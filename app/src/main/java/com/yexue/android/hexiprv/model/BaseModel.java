package com.yexue.android.hexiprv.model;

import android.util.Log;

import com.yexue.android.hexiprv.sys.HttpLoggingInterceptor;
import com.yexue.android.hexiprv.utils.HttpsUtils;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author yexue
 * @version 1.0
 * @name com.yexue.android.hexiprv.model
 * @explain 网络请求/model supper
 * @time 2017/7/11 14:31
 */
public class BaseModel {
    protected static OkHttpClient okHttpClient;
    protected static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    protected static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();

    static {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.e("RxJava", message);
            }
        });
        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(null, null, null);
        okHttpClient = new OkHttpClient.Builder()
                //TODO log请求参数-->正式发布请注释.addInterceptor(interceptor)
                .addInterceptor(interceptor)
                .hostnameVerifier(new HostnameVerifier() {
                    @Override
                    public boolean verify(String hostname, SSLSession session) {
                        return true;
                    }
                })
                .sslSocketFactory(sslParams.sSLSocketFactory)
                .build();
    }
}
