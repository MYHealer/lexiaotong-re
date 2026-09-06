package com.hihonor.adsdk.base.api;

import com.hihonor.adsdk.base.bean.BaseAdInfoResp;
import com.hihonor.adsdk.base.net.resp.GameReserveResult;
import com.hihonor.adsdk.base.net.resp.InitResp;
import java.util.Map;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.SkipCallbackExecutor;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Url;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface a {
    @POST(com.hihonor.adsdk.base.c.h2.hnadsa)
    com.hihonor.adsdk.base.net.a<InitResp> hnadsa(@HeaderMap Map<String, String> map, @Body RequestBody requestBody);

    @GET
    @SkipCallbackExecutor
    Call<ResponseBody> hnadsa(@Url String str);

    @POST(com.hihonor.adsdk.base.c.h2.hnadsd)
    com.hihonor.adsdk.base.net.a<String> hnadsb(@HeaderMap Map<String, String> map, @Body RequestBody requestBody);

    @GET
    Call<GameReserveResult> hnadsb(@Url String str);

    @POST(com.hihonor.adsdk.base.c.h2.hnadsc)
    com.hihonor.adsdk.base.net.a<BaseAdInfoResp> hnadsc(@HeaderMap Map<String, String> map, @Body RequestBody requestBody);
}
