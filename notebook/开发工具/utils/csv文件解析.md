### csv文件解析

##### 一、先给出工具类

```java
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author: hj
 * @date: 2021-01-21 13:45
 * @description: Csv解析工具类
 **/
@Slf4j
public class CsvUtil {

    /**
     * 采用  ColumnPositionMapping  策略解析
     *
     * @param file
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> getCsvData(MultipartFile file, Class<T> clazz) {
        InputStreamReader in = null;
        try {
            in = new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8);
        } catch (Exception e) {
            log.error("读取csv文件失败！");
        }
        //采用 以基于 position 策略
        ColumnPositionMappingStrategy<T> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(clazz);
        CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(in)
                .withSeparator(',')//指定分隔符
                .withQuoteChar('\'')//指定引用字符
                .withSkipLines(1)//跳过第一行
                .withMappingStrategy(strategy)//指定策略
            	.build();
        return csvToBean.parse();
    }
}

```



##### 二、针对该工具类的使用

**ColumnPositionMappingStrategy 策略**

1. **csv文件**

```
日期,低评级债券信用利差,沪深300
2020/12/23,0.666666,66
2020/12/22,0.111111,11
2020/12/21,1.222222,22
2020/12/18,1.333333,33
```

2. **基于@CsvBindByPosition注解方式**

```Java
     //此处自定义了字符串转date的ConverterToDate，所以使用@CsvCustomBindByPosition注解
    @CsvCustomBindByPosition(position = 0, converter = ConverterToDate.class)
    private Date dateTime;

    @CsvBindByPosition(position = 1)
    private BigDecimal emotionalFactorValue;

    @CsvBindByPosition(position = 2)
    private BigDecimal stockIndexValue;
```

3. 自定义的 converter

```java
import com.opencsv.bean.AbstractBeanField;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: hj
 * @date: 2021-01-21 13:31
 * @description: 字符串转日期
 **/
@Slf4j
public class ConverterToDate extends AbstractBeanField {
    @Override
    protected Date convert(String value) {
        Date date = new Date();
        if (StringUtils.isBlank(value)) {
            return date;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        try {
            date = format.parse(value);
        } catch (ParseException e) {
            log.error("字符串转日期类型出错");
            e.printStackTrace();
        }
        return date;
    }
}

```



[^更多使用方法参考:]: https://www.jianshu.com/p/cb59458d5a34

