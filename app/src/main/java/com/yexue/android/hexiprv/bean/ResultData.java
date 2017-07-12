package com.yexue.android.hexiprv.bean;

import java.util.Objects;

/**
 * @author yexue
 * @version 1.0
 * @name com.yexue.android.hexiprv.bean
 * @explain 网络请求封装
 * @time 2017/7/11 14:23
 */
public class ResultData<T> {
    private T datas;
    private String message;
    private boolean flag;

    public T getDatas() {
        return datas;
    }

    public void setDatas(T datas) {
        this.datas = datas;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "ResultData{" +
                "datas='" + datas + '\'' +
                ", message='" + message + '\'' +
                ", flag=" + flag +
                '}';
    }
}
