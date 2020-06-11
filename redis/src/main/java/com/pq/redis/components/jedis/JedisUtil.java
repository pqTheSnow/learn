package com.pq.redis.components.jedis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pq.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * TODO 可以想办法给这个加上泛型吗
 * TODO 实现jedis的
 */
@Component
public class JedisUtil {

    @Autowired
    private JedisPool jedisPool;

    /**
     * string类型
     *
     * @param key
     * @param value
     * @return
     */
    public String set(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        String back = jedis.set(key, value);
        jedis.close();
        return back;
    }

    /**
     * @return java.util.Set<java.lang.String>
     * @Description <模糊获取key>
     * @Author Zhaiyt
     * @Date 20:02 2019/1/14
     * @Param
     **/
    public Set<String> keys(String pattern) {
        Jedis jedis = jedisPool.getResource();
        Set<String> keys = jedis.keys(pattern);
        jedis.close();
        return keys;
    }


    /**
     * 删除key对应的value
     *
     * @param key
     * @return
     */
    public Long del(String key) {
        Jedis jedis = jedisPool.getResource();
        Long back = jedis.del(key);
        jedis.close();
        return back;
    }

    /**
     * 获取string类型
     *
     * @param key
     * @return
     */
    public String get(String key) {
        Jedis jedis = jedisPool.getResource();
        String back = jedis.get(key);
        jedis.close();
        return back;
    }

    /**
     * 将值 value 关联到 key ,并将 key 的生存时间设为 seconds (以秒为单位)。
     *
     * @param key
     * @param seconds
     * @param value
     * @return
     */
    public String setex(String key, int seconds, String value) {
        Jedis jedis = jedisPool.getResource();
        String back = jedis.setex(key, seconds, value);
        jedis.close();
        return back;
    }

    /**
     * 返回哈希表 key 中,所有的域和值。
     * 在返回值里,紧跟每个域名(field name)之后是域的值(value),所以返回值的长度是哈希表大小的两倍。
     *
     * @param key
     * @return
     */
    public Map hgetAll(String key) {
        Jedis jedis = jedisPool.getResource();
        Map back = jedis.hgetAll(key);
        jedis.close();
        return back;
    }

    /**
     * 将哈希表 key 中的域 field 的值设为 value 。
     * 如果 key 不存在,一个新的哈希表被创建并进行 HSET 操作。
     * 如果域 field 已经存在于哈希表中,旧值将被覆盖。
     *
     * @param key
     * @param field
     * @param value
     * @return
     */
    public Long hset(String key, String field, String value) {
        Jedis jedis = jedisPool.getResource();
        Long back = jedis.hset(key, field, value);
        jedis.close();
        return back;
    }

    /**
     * 返回哈希表 key 中给定域 field 的值。
     *
     * @param key
     * @param field
     * @return
     */
    public String hget(String key, String field) {
        Jedis jedis = jedisPool.getResource();
        String back = jedis.hget(key, field);
        jedis.close();
        return back;
    }

    /**
     * 删除哈希表 key 中的一个或多个指定域,不存在的域将被忽略。
     *
     * @param key
     * @param field
     * @return
     */
    public long hdel(String key, String field) {
        Jedis jedis = jedisPool.getResource();
        long back = jedis.hdel(key, field);
        jedis.close();
        return back;
    }

    /**
     * 将一个或多个值 value 插入到列表 key 的表头
     *
     * @param key
     * @param value
     * @return
     */
    public Long lpush(String key, String... value) {
        Jedis jedis = jedisPool.getResource();
        Long back = jedis.lpush(key, value);
        jedis.close();
        return back;
    }

    /**
     * 将一个或多个值 value 插入到列表 key 的表尾
     *
     * @param key
     * @param value
     * @return
     */
    public long rpush(String key, String... value) {
        Jedis jedis = jedisPool.getResource();
        long back = jedis.rpush(key, value);
        jedis.close();
        return back;
    }

    /**
     * 通过下标替换元素的内容
     *
     * @param key
     * @param index
     * @param value
     * @return
     */
    public String lset(String key, long index, String value) {
        Jedis jedis = jedisPool.getResource();
        String back = jedis.lset(key, index, value);
        jedis.close();
        return back;
    }

    /**
     * 移除有序集合lsit中的参数
     * 0所有
     *
     * @param key
     * @param count
     * @param value
     * @return
     */
    public long lrem(String key, long count, String value) {
        Jedis jedis = jedisPool.getResource();
        long back = jedis.lrem(key, count, value);
        jedis.close();
        return back;
    }

    /**
     * 返回列表 key 的长度。
     * 如果 key 不存在,则 key 被解释为一个空列表,返回 0 .
     * 如果 key 不是列表类型,返回一个错误。
     *
     * @param key
     * @return
     */
    public Long llen(String key) {
        Jedis jedis = jedisPool.getResource();
        Long back = jedis.llen(key);
        jedis.close();
        return back;
    }

    /**
     * 返回列表 key 中指定区间内的元素
     * -1 表示列表的最后一个元素
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public List lrange(String key, int start, int end) {
        Jedis jedis = jedisPool.getResource();
        List back = jedis.lrange(key, start, end);
        jedis.close();
        return back;
    }

    /**
     * 将 key 中储存的数字值增一
     *
     * @param key
     * @return
     */
    public long incr(String key) {
        Jedis jedis = jedisPool.getResource();
        long back = jedis.incr(key);
        jedis.close();
        return back;
    }

    /**
     * 将 key 中储存的数字值减一。
     *
     * @param key
     * @return
     */
    public long decr(String key) {
        Jedis jedis = jedisPool.getResource();
        long back = jedis.decr(key);
        jedis.close();
        return back;
    }

    /**
     * 为给定 key 设置生存时间,当 key 过期时(生存时间为 0 ),它会被自动删除。
     *
     * @param key
     * @param seconds
     * @return
     */
    public long expire(String key, int seconds) {
        Jedis jedis = jedisPool.getResource();
        long back = jedis.expire(key, seconds);
        jedis.close();
        return back;
    }

    /**
     * 将一个或多个 member 元素加入到集合 key 当中,已经存在于集合的 member 元素将被忽略。
     *
     * @param key
     * @param value
     * @return
     */
    public long sadd(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        long back = jedis.sadd(key, value);
        jedis.close();
        return back;
    }

    /**
     * 检查给定 key 是否存在。
     *
     * @param key
     * @return
     */
    public boolean exists(String key) {
        Jedis jedis = jedisPool.getResource();
        boolean back = jedis.exists(key);
        jedis.close();
        return back;
    }

    /**
     * 将一个或多个 member 元素及其 score 值加入到有序集 key 当中。
     *
     * @param key
     * @param score
     * @param member
     * @return
     */
    public double zadd(String key, double score, String member) {
        Jedis jedis = jedisPool.getResource();
        double back = jedis.zadd(key, score, member);
        jedis.close();
        return back;
    }

    /**
     * 返回有序集 key 中,所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员。有序集成员按 score 值递增(从小到大)次序排列。
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    public Set getZrangeByScore(String key, String min, String max) {
        Jedis jedis = jedisPool.getResource();
        Set back = jedis.zrangeByScore(key, min, max);
        jedis.close();
        return back;
    }

    /**
     * 移除有序系列中的指定范围
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public long delZremrangeByScore(String key, String start, String end) {
        Jedis jedis = jedisPool.getResource();
        long back = jedis.zremrangeByScore(key, start, end);
        jedis.close();
        return back;
    }

    /**
     * 有序集合
     * 根据分数降序排列
     *
     * @param key
     * @param max
     * @param min
     * @return
     */
    public Set getZrevrangeByScore(String key, String max, String min) {
        Jedis jedis = jedisPool.getResource();
        Set back = jedis.zrevrangeByScore(key, max, min);
        jedis.close();
        return back;
    }

    /**
     * 有序集合
     * score增加或减少值
     *
     * @param key
     * @param score
     * @param member
     * @return
     */
    public Double setZincrby(String key, double score, String member) {
        Jedis jedis = jedisPool.getResource();
        double back = jedis.zincrby(key, score, member);
        jedis.close();
        return back;
    }

    /**
     * 有序集合
     * 降序排列
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Set getZrevrange(String key, long start, long end) {
        Jedis jedis = jedisPool.getResource();
        Set back = jedis.zrevrange(key, start, end);
        jedis.close();
        return back;
    }

    /**
     * @Description <对象转string>
     * @Author Zhaiyt
     * @Date 19:34 2019/1/14
     * @Param
     * @return java.lang.String
     **/
    public static String objectToString(Object obj){
        ObjectMapper objectMapper = new ObjectMapper();
        String resultStr = null;
        try {
            resultStr = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            LogUtil.error("向Redis中写入数据时失败");
        }
        return resultStr;
    }

    /**
     * @Description <对象转string>
     * @Author Zhaiyt
     * @Date 19:34 2019/1/14
     * @Param
     * @return java.lang.String
     **/
    public static Object stringToObj(Class typeClass,Class clazz,String data){
        ObjectMapper objectMapper = new ObjectMapper();
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(typeClass, clazz);
        Object obj = null;
        try {
            obj = objectMapper.readValue(data, javaType);
        } catch (IOException e) {
            LogUtil.error("redis中读取数据失败");
        }
        return obj;
    }

}
