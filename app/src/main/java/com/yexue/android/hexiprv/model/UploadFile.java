package com.yexue.android.hexiprv.model;

import com.yexue.android.hexiprv.bean.ResultData;
import com.yexue.android.hexiprv.propreties.HttpsValues;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;

/**
 * @author yexue
 * @version 1.0
 * @name com.yexue.android.hexiprv.model
 * @explain 上传文件
 * @time 2017/7/12 10:23
 */
public interface UploadFile {

    /**
     * 上传图片
     * @param params
     * @return
     */
    @Multipart
    @POST(HttpsValues.URL_UP_IMAGE)
    public ResultData uploadImg(@PartMap Map<String, ResponseBody> params);
}
