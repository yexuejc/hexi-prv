package com.yexue.android.hexiprv.model.impl;

import com.yexue.android.hexiprv.model.BaseModel;
import com.yexue.android.hexiprv.model.PptIco;
import com.yexue.android.hexiprv.propreties.HttpsValues;

import retrofit2.Retrofit;

/**
 * @author yexue
 * @version 1.0
 * @name com.yexue.android.hexiprv.model.impl
 * @explain
 * @time 2017/7/11 14:36
 */
public class PptIcoImpl extends BaseModel {
    private static PptIco pptIco;

    public static PptIco getPptIco() {
        if (pptIco == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(HttpsValues.SERVER_URL_PREFIX_SHOP)//基本URL
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            pptIco = retrofit.create(PptIco.class);
        }
        return pptIco;
    }
}
