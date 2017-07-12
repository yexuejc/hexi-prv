package com.yexue.android.hexiprv.model.impl;

import com.yexue.android.hexiprv.model.BaseModel;
import com.yexue.android.hexiprv.model.UploadFile;
import com.yexue.android.hexiprv.propreties.HttpsValues;

import retrofit2.Retrofit;

/**
 * @author yexue
 * @version 1.0
 * @name com.yexue.android.hexiprv.model.impl
 * @explain
 * @time 2017/7/12 10:27
 */
public class UploadFileImpl extends BaseModel {
    private UploadFile uploadFile;

    public UploadFile getUploadFile() {
        if (uploadFile == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(HttpsValues.SERVER_URL_PREFIX)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            uploadFile = retrofit.create(UploadFile.class);
        }
        return uploadFile;
    }
}
