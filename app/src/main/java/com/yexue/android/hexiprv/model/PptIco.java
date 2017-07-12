package com.yexue.android.hexiprv.model;

import com.yexue.android.hexiprv.bean.ResultData;
import com.yexue.android.hexiprv.propreties.HttpsValues;

import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * @author yexue
 * @version 1.0
 * @name com.yexue.android.hexiprv.model
 * @explain 图片路径 https://shop.globalhexi.cn/shop/pptIco/
 * @time 2017/7/11 14:00
 */
public interface PptIco {
    /**
     * 获取首页所有图片
     *
     * @return
     */
    @GET(HttpsValues.GET_IMAGE_URLD)
    Observable<ResultData> listALL();

    /**
     * 获取指定key图片
     *
     * @param pptKey 指定key
     * @return
     */
    @GET(HttpsValues.GET_PING_GO_PPT)
    Observable<ResultData> list(@Query("pptKey") String pptKey);

}
