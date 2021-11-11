# Redis

## 核心数据结构

![image-20211109143929770](assets/image-20211109143929770.png)



### String字符串

#### 常见命令

**常见操作**

1. 存入字符串键值对

```
SET key value
```



2. 批量存储字符串键值对

```
MSET key value [key value...]
```



3. 当某一个键值对不存在时设置

```
SETNX key value
```



4. 获取 key 对应的值

```
GET key
```



5. 批量获取字符串键值

```
MGET key [key...]
```



6. 删除key，可批量删除

```
DEL key [key...]
```



7. 设置一个键的失效时间

```
EXPIRE key seconds
```



**原子加减**

1. 将key对应的数字值加1

```
INCR key
```



2. 将key对应的数字值减1

```
DECR key
```



3. 将key所存储的值加上对应的值

```
INCBY key num
```



4. 将key所存储的值减去对应的值

```
DECRBY key num
```



#### 应用场景

**单值缓存**

使用 set key 和 get key 适用于简单的缓存场景



**对象缓存**

可以将我们常见的对象转为json字符串作为value存储；

将一个对象的 k:v 分开存储。

- SET user:123 value(json格式话数据)
- MSET user123:name  xiaohuang user123:age 22  //批量设置
- MGET user123:name user123:age  //批量获取



**分布式锁**

SETNX  user:123 true









### Hash

####  对象缓存

避免大key问题，





### List



#### 应用场景

微博大v消息推送，可以采取push和pull两种方式

push：推送适用于关注量较小的用户，可以直接将消息推送给粉丝

pull：拉取时需要去队列中去拿消息，拿完消息后可能还要排序





### Set

#### 应用场景

差集的解释