package com.myproject.admin.service;


public interface RedisService {

    void set(String key, String value);

    String get(String key);

    void setExpire(String key, Long expireTime);

    /**
     * 删除数据
     */
    void remove(String key);

    /**
     * 自增操作
     * @param delta 自增步长
     */
    Long increment(String key, long delta);

}
