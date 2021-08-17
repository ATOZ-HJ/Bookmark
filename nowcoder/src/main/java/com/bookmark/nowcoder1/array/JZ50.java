package com.bookmark.nowcoder1.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: hj
 * @date: 2021-08-17 20:07
 * @description: 数组中重复的数字
 * <p>
 * 描述：在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任一一个重复的数字。 例如，如果输入长度为7的数组[2,3,1,0,2,5,3]，
 * 那么对应的输出是2或者3。存在不合法的输入的话输出-1
 * <p>
 * 示例1：
 * 输入：
 * [2,3,1,0,2,5,3]
 * 返回值：
 * 2
 * 说明：
 * 2或3都是对的
 * <p>
 * https://www.nowcoder.com/practice/6fe361ede7e54db1b84adc81d09d8524
 **/
public class JZ50 {
    /**
     * 使用map缓存每个数值的计算次数
     * <p>
     * 运行时间：84ms
     * 超过8.59% 用Java提交的代码
     * 占用内存：15572KB
     * 超过0.77%用Java提交的代码
     *
     * @param numbers int整型一维数组
     * @return int整型
     */
    public int duplicate1(int[] numbers) {
        if (numbers.length == 0) {
            return -1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int number : numbers) {
            Integer value = map.get(number);
            if (value == null) {
                map.put(number, 1);
            } else {
                map.put(number, ++value);
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            Integer number = entry.getKey();
            Integer count = entry.getValue();
            if (count > 1) {
                return number;
            }
        }
        return -1;
    }
}
