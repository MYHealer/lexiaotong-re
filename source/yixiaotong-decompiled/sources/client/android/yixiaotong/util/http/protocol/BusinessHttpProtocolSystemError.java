package client.android.yixiaotong.util.http.protocol;

import client.android.yixiaotong.controller.bean.SystemErrorBean;
import client.android.yixiaotong.ui.RechargeRecordActivity;
import client.android.yixiaotong.util.http.bean.BaseBean;
import client.android.yixiaotong.util.retrofit.http.GET;
import client.android.yixiaotong.util.retrofit.http.Query;
import com.cdo.oaps.ad.OapsKey;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public interface BusinessHttpProtocolSystemError {
    @GET("/systemMsg")
    BaseBean<SystemErrorBean> getSystemError(@Query("schoolid") String str, @Query(RechargeRecordActivity.EXTRA_TYPEID) String str2);

    @GET("/app/Basic/systemMsg")
    BaseBean<SystemErrorBean> getSystemError(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);
}
