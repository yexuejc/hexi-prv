package com.yexue.android.hexiprv.bean;

/**
 * @author yexue
 * @version 1.0
 * @name com.yexue.android.hexiprv.bean
 * @explain
 * @time 2017/7/13 13:55
 */
public class ResultPptIcoItem {
    private String imgUrl;
    private int orderBy;
    private String name;
    private String M;
    private double version;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(int orderBy) {
        this.orderBy = orderBy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getM() {
        return M;
    }

    public void setM(String m) {
        M = m;
    }

    public double getVersion() {
        return version;
    }

    public void setVersion(double version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "ResultPptIcoItem{" +
                "imgUrl='" + imgUrl + '\'' +
                ", orderBy=" + orderBy +
                ", name='" + name + '\'' +
                ", M='" + M + '\'' +
                ", version=" + version +
                '}';
    }
}
