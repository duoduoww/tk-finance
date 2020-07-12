package com.tk.admin.util;


import javax.security.auth.login.Configuration;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RedisPoolConfigure {

    //Redis服务器IP
    private String ADDR ;

    //Redis的端口号
    private int PORT ;

    //可用连接实例的最大数目
    private  int MAX_ACTIVE ;

    //pool中的idle jedis实例数
    private  int MAX_IDLE ;

    //等待可用连接的最大时间，单位毫秒
    private  int MAX_WAIT ;
    //超时时间，单位毫秒
    private  int TIME_OUT ;
    //设置的逐出策略类名, 默认DefaultEvictionPolicy(当连接超过最大空闲时间,或连接数超过最大空闲连接数)
    private String EVICTION_POLICY_CLASS_NAME ;

    //连接耗尽时是否阻塞, false报异常,ture阻塞直到超时
    private boolean BLOCK_WHEN_EXHAUSTED;

    //是否启用pool的jmx管理功能, 默认true
    private boolean JMX_ENABLED;

    //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
    private boolean TEST_ON_BORROW ;

    //服务器密码
    private String REDIS_PASS;
    //redis选择数据库DB
    private int REDIS_DB;


    private String LUASHA;

    private Map<String, String> configure = null;

    /**
     * 根据配置文件,将RedisPool连接配置初始化
     */
    public RedisPoolConfigure(){
        configure = new ConcurrentHashMap<>();// new ConfigureReader().readProperties("redis.properties");
        this.ADDR = configure.get("REDIS.ADDR");
        this.LUASHA = configure.get("REDIS.LUA_HASH");
        this.EVICTION_POLICY_CLASS_NAME = configure.get("REDIS.EVICTION_POLICY_CLASS_NAME");
        this.BLOCK_WHEN_EXHAUSTED = Boolean.parseBoolean(configure.get("REDIS.BLOCK_WHEN_EXHAUSTED"));
        this.JMX_ENABLED = Boolean.parseBoolean(configure.get("REDIS.JMX_ENABLED"));
        this.TEST_ON_BORROW = Boolean.parseBoolean(configure.get("REDIS.TEST_ON_BORROW"));
        this.REDIS_PASS=configure.get("REDIS.PASS");

        if(typeCheck()){
            this.PORT = new Integer(configure.get("REDIS.PORT"));
            this.MAX_ACTIVE = new Integer(configure.get("REDIS.MAX_ACTIVE"));
            this.MAX_IDLE = new Integer(configure.get("REDIS.MAX_IDLE"));
            this.MAX_WAIT = new Integer(configure.get("REDIS.MAX_WAIT"));
            this.REDIS_DB=new Integer(configure.get("REDIS.DB"));
        }else{
            System.out.println("error");
        }
    }

    /**
     * 辅助工具,检查map中数据的类型
     * @return
     */
    private boolean typeCheck() {
        if (isNumeric(configure.get("REDIS.PORT"))
                && isNumeric(configure.get("REDIS.MAX_ACTIVE"))
                && isNumeric(configure.get("REDIS.MAX_IDLE"))
                && isNumeric(configure.get("REDIS.MAX_WAIT"))
                && isNumeric(configure.get("REDIS.DB"))) {
            return true;
        }
        return false;
    }

    public String getADDR() {
        return ADDR;
    }

    public int getPORT() {
        return PORT;
    }


    public int getMAX_ACTIVE() {
        return MAX_ACTIVE;
    }

    public int getMAX_IDLE() {
        return MAX_IDLE;
    }

    public int getMAX_WAIT() {
        return MAX_WAIT;
    }

    public int getTIME_OUT() {
        return TIME_OUT;
    }

    public boolean isTEST_ON_BORROW() {
        return TEST_ON_BORROW;
    }

    public String getEVICTION_POLICY_CLASS_NAME() {
        return EVICTION_POLICY_CLASS_NAME;
    }

    public boolean isBLOCK_WHEN_EXHAUSTED() {
        return BLOCK_WHEN_EXHAUSTED;
    }

    public boolean isJMX_ENABLED() {
        return JMX_ENABLED;
    }
    /**
     * 判断传入的数据是否为纯数字构成
     * @param str
     * @return
     */
    public boolean isNumeric(String str) {
        if(str==null || "".equals(str)){
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public String getLUASHA() {
        return LUASHA;
    }

    public void setLUASHA(String lUASHA) {
        LUASHA = lUASHA;
    }

    public String getREDIS_PASS() {
        return REDIS_PASS;
    }

    public void setREDIS_PASS(String rEDIS_PASS) {
        REDIS_PASS = rEDIS_PASS;
    }

    public int getREDIS_DB() {
        return REDIS_DB;
    }

    public void setREDIS_DB(int rEDIS_DB) {
        REDIS_DB = rEDIS_DB;
    }
}