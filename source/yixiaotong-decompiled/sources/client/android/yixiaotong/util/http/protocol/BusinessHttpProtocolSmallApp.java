package client.android.yixiaotong.util.http.protocol;

import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.bean.bindcard.BindCardBean;
import client.android.yixiaotong.controller.bean.bindcard.IsBindCardBean;
import client.android.yixiaotong.controller.bean.bindcard.IsHasBindCardFunctionBean;
import client.android.yixiaotong.controller.bean.bindcard.PasswordStateBean;
import client.android.yixiaotong.util.http.bean.BaseBean;
import client.android.yixiaotong.util.retrofit.http.Field;
import client.android.yixiaotong.util.retrofit.http.FormUrlEncoded;
import client.android.yixiaotong.util.retrofit.http.GET;
import client.android.yixiaotong.util.retrofit.http.POST;
import client.android.yixiaotong.util.retrofit.http.Query;
import com.cdo.oaps.ad.OapsKey;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public interface BusinessHttpProtocolSmallApp {
    @GET("/zk_cardmanager_api/passwordManagement/AddPassword")
    BaseBean<SuccessBean> addPassword(@Query("wxcode") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3, @Query(OapsKey.KEY_SUB_ID) String str4, @Query("requestType") int i);

    @FormUrlEncoded
    @POST("/zk_cardmanager_api/cardmanager/bindCard")
    BaseBean<BindCardBean> bindCard(@Field("wxcode") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3, @Field(OapsKey.KEY_SUB_ID) String str4, @Field("requestType") int i);

    @FormUrlEncoded
    @POST("/zk_cardmanager_api/cardmanager/bindCardV2")
    BaseBean<BindCardBean> bindCard2(@Field("wxcode") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3, @Field(OapsKey.KEY_SUB_ID) String str4, @Field("requestType") int i);

    @FormUrlEncoded
    @POST("/zk_cardmanager_api/cardmanager/closeCard")
    BaseBean<SuccessBean> closeCard(@Field("wxcode") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3, @Field(OapsKey.KEY_SUB_ID) String str4, @Field("requestType") int i);

    @GET("/zk_cardmanager_api/cardmanager/isBindCard")
    BaseBean<IsBindCardBean> getIsBindCard(@Query("wxcode") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3, @Query(OapsKey.KEY_SUB_ID) String str4, @Query("requestType") int i);

    @GET("/zk_cardmanager_api/cardmanager/isCard")
    BaseBean<IsHasBindCardFunctionBean> isHasCardFunction(@Query("wxcode") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3, @Query(OapsKey.KEY_SUB_ID) String str4, @Query("requestType") int i);

    @FormUrlEncoded
    @POST("/zk_cardmanager_api/cardmanager/openCard")
    BaseBean<SuccessBean> openCard(@Field("wxcode") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3, @Field(OapsKey.KEY_SUB_ID) String str4, @Field("requestType") int i);

    @FormUrlEncoded
    @POST("/zk_cardmanager_api/cardmanager/unbindCard")
    BaseBean<SuccessBean> unBindCard(@Field("wxcode") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3, @Field(OapsKey.KEY_SUB_ID) String str4, @Field("requestType") int i);

    @GET("/zk_cardmanager_api/passwordManagement/UpdatePassword")
    BaseBean<SuccessBean> updatePassword(@Query("wxcode") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3, @Query(OapsKey.KEY_SUB_ID) String str4, @Query("requestType") int i);

    @GET("/zk_cardmanager_api/passwordManagement/WhetherPassword")
    BaseBean<PasswordStateBean> whetherPassword(@Query("wxcode") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3, @Query(OapsKey.KEY_SUB_ID) String str4, @Query("requestType") int i);
}
