package com.rd.rep.databasetest.model;

import android.support.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 实体类
 * @author  dlong
 * created at 2019/3/13 10:29 AM
 */
public class Person {

    /** 数据库自增ID */
    public int id;
    /** 用户名 */
    public String name;
    /** 发送时间 */
    public long time;
    /** 发送消息 */
    public String msg;

    public Person(){
    }

    public Person(String n,long t,String m){
        name = n;
        time = t;
        msg = m;
    }

    /**
     * 拼接字符串
     * @return
     */
    @NonNull
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        builder.append(id).append("--");
        builder.append(name).append("--");
        // 将时间戳转换成特定格式的字符串
        Date date = new Date(time);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        builder.append(format.format(date)).append("--");
        builder.append(msg).append("]");
        return builder.toString();
    }
}
