package com.yexue.android.hexiprv.bean;

import java.util.List;
import java.util.Map;

/**
 * @author yexue
 * @version 1.0
 * @name com.yexue.android.hexiprv.bean
 * @explain 自定义简单 PptIco
 * @time 2017/7/12 11:18
 */
public class ResultPptIcoMap {
    public List<Map<String, ResultPptIcoItem>> pptIcoMap;

    @Override
    public String toString() {
        return "ResultPptIcoMap{" +
                "pptIcoMap=" + pptIcoMap +
                '}';
    }
}
