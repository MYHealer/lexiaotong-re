package client.android.yixiaotong.v4.http;

import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.util.retrofit.http.Body;
import client.android.yixiaotong.util.retrofit.http.Field;
import client.android.yixiaotong.util.retrofit.http.FormUrlEncoded;
import client.android.yixiaotong.util.retrofit.http.GET;
import client.android.yixiaotong.util.retrofit.http.Header;
import client.android.yixiaotong.util.retrofit.http.Headers;
import client.android.yixiaotong.util.retrofit.http.POST;
import client.android.yixiaotong.util.retrofit.http.Query;
import client.android.yixiaotong.v3.bean.deviceinfo.OpenPro;
import client.android.yixiaotong.v4.http.bean.DeviceLock;
import client.android.yixiaotong.v4.http.bean.V44GOpen;
import client.android.yixiaotong.v4.http.bean.V44GOpenStatus;
import client.android.yixiaotong.v4.http.bean.V4AddRepair;
import client.android.yixiaotong.v4.http.bean.V4AppMonitorReport;
import client.android.yixiaotong.v4.http.bean.V4AreaBean;
import client.android.yixiaotong.v4.http.bean.V4BLECollect;
import client.android.yixiaotong.v4.http.bean.V4BLEOpen;
import client.android.yixiaotong.v4.http.bean.V4BLEOpenBean;
import client.android.yixiaotong.v4.http.bean.V4BTRecharge;
import client.android.yixiaotong.v4.http.bean.V4BaseBean;
import client.android.yixiaotong.v4.http.bean.V4BathConsumeDetailBean;
import client.android.yixiaotong.v4.http.bean.V4BathRecordBean;
import client.android.yixiaotong.v4.http.bean.V4BathRecordListBean;
import client.android.yixiaotong.v4.http.bean.V4BindCard;
import client.android.yixiaotong.v4.http.bean.V4BindCustomer;
import client.android.yixiaotong.v4.http.bean.V4BindRoom;
import client.android.yixiaotong.v4.http.bean.V4BugErrorLog;
import client.android.yixiaotong.v4.http.bean.V4CancelRefund;
import client.android.yixiaotong.v4.http.bean.V4CardInfoBean;
import client.android.yixiaotong.v4.http.bean.V4DeviceInfoBean;
import client.android.yixiaotong.v4.http.bean.V4DeviceListBean;
import client.android.yixiaotong.v4.http.bean.V4DeviceMeterRefundRecordBean;
import client.android.yixiaotong.v4.http.bean.V4DeviceSubmitRefund;
import client.android.yixiaotong.v4.http.bean.V4ElecMeterInfoBean;
import client.android.yixiaotong.v4.http.bean.V4ElecRechargeRecordBean;
import client.android.yixiaotong.v4.http.bean.V4F0Data;
import client.android.yixiaotong.v4.http.bean.V4HomeInfoBean;
import client.android.yixiaotong.v4.http.bean.V4ImageCodeBean;
import client.android.yixiaotong.v4.http.bean.V4Login;
import client.android.yixiaotong.v4.http.bean.V4LoginBean;
import client.android.yixiaotong.v4.http.bean.V4MeterConsumeDailySummaryBean;
import client.android.yixiaotong.v4.http.bean.V4MetersTrendBean;
import client.android.yixiaotong.v4.http.bean.V4Mobile;
import client.android.yixiaotong.v4.http.bean.V4ModeBean;
import client.android.yixiaotong.v4.http.bean.V4PlatformInfoBean;
import client.android.yixiaotong.v4.http.bean.V4ProjectConfigBean;
import client.android.yixiaotong.v4.http.bean.V4Recharge;
import client.android.yixiaotong.v4.http.bean.V4RechargeBean;
import client.android.yixiaotong.v4.http.bean.V4RechargeListBean;
import client.android.yixiaotong.v4.http.bean.V4RechargeRecordListBean;
import client.android.yixiaotong.v4.http.bean.V4RefundDetailBean;
import client.android.yixiaotong.v4.http.bean.V4RefundRecordBean;
import client.android.yixiaotong.v4.http.bean.V4RefundableAmountBean;
import client.android.yixiaotong.v4.http.bean.V4Register;
import client.android.yixiaotong.v4.http.bean.V4RepairRecordBean;
import client.android.yixiaotong.v4.http.bean.V4ResetPassword;
import client.android.yixiaotong.v4.http.bean.V4RoomLeaderBean;
import client.android.yixiaotong.v4.http.bean.V4SchoolInfoBean;
import client.android.yixiaotong.v4.http.bean.V4SelectAllBean;
import client.android.yixiaotong.v4.http.bean.V4ServerListBean;
import client.android.yixiaotong.v4.http.bean.V4SetDevicePassword;
import client.android.yixiaotong.v4.http.bean.V4SignBean;
import client.android.yixiaotong.v4.http.bean.V4SubmitRefund;
import client.android.yixiaotong.v4.http.bean.V4SubmitRefundBean;
import client.android.yixiaotong.v4.http.bean.V4ToPay;
import client.android.yixiaotong.v4.http.bean.V4UpdateRoomLeader;
import client.android.yixiaotong.v4.http.bean.V4UserInfoDetailBean;
import client.android.yixiaotong.v4.http.bean.V4UserLogoff;
import client.android.yixiaotong.v4.http.bean.V4UserUpdateLoginPassword;
import client.android.yixiaotong.v4.http.bean.V4VersionInfoBean;
import client.android.yixiaotong.v4.http.bean.V4WalletInfoBean;
import com.alipay.sdk.tid.b;
import com.cdo.oaps.ad.OapsKey;
import com.unionpay.tsmservice.mi.data.Constant;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public interface V4BusinessHttpProtocol {
    @POST("/cus/electricity/recharge/btRecharge")
    @Headers({"Content-Type: application/json"})
    V4BaseBean<String> btRecharge(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Body V4BTRecharge v4BTRecharge);

    @POST("/cus/deviceMeterRefund/btReturnToZeroKwh")
    @Headers({"Content-Type: application/json"})
    V4BaseBean<String> btReturnToZeroKwh(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Body V4BTRecharge v4BTRecharge);

    @POST("/cus/deviceMeterRefund/cancelRefund")
    @Headers({"Content-Type: application/json"})
    V4BaseBean<SuccessBean> cancelRefund(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Body V4CancelRefund v4CancelRefund);

    @GET("/cus/deviceConsume/v2/getNetAuthUesResult")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    V4BaseBean<V44GOpenStatus> get4GOpenStatus(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Query(Constant.KEY_MAC) String str4, @Query("sysRandom") String str5);

    @GET("/cus/app/newest")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    V4BaseBean<V4VersionInfoBean> getAppVersionInfo(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Query("clientType") int i, @Query("clientPlatformType") int i2, @Query("curVer") String str4);

    @GET("/cus/house/list")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    V4BaseBean<List<V4AreaBean>> getAreaList(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Query("id") String str4);

    @GET("/cus/userIdcard/getUserIdcardByUserId")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    V4BaseBean<V4CardInfoBean> getCardInfo(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3);

    @GET("/cus/deviceConsume/consumeDetail")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    V4BaseBean<V4BathConsumeDetailBean> getConsumeDetail(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Query("consumeOrderId") String str4);

    @GET("/cus/deviceConsume/pageQuery")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    V4BaseBean<V4BathRecordListBean> getConsumeRecord(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Query("timeFrameType") String str4, @Query("pageSize") int i, @Query("pageIndex") int i2, @Query("productId") int i3, @Query("pay") int i4);

    @GET("/cus/customerPerson/getCustomerPersonInfo")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    V4BaseBean<V4UserInfoDetailBean> getCustomerPersonInfo(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3);

    @GET("/cus/device/getByBtMac")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    V4BaseBean<V4DeviceInfoBean> getDeviceInfoByMac(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Query("btMac") String str4);

    @GET("/cus/device/getByMac")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    V4BaseBean<V4DeviceInfoBean> getDeviceInfoByMachineId(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Query(Constant.KEY_MAC) String str4);

    @GET("/cus/device/getByQrcode")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    V4BaseBean<V4DeviceInfoBean> getDeviceInfoByQrcode(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Query("qrcode") String str4);

    @GET("/cus/device/getByEleSn")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    V4BaseBean<V4DeviceInfoBean> getDeviceInfoBySn(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Query("eleSn") String str4);

    @GET("/cus/device/deviceMacList")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    V4BaseBean<List<V4DeviceListBean>> getDeviceList(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Query("roomId") String str4);

    @GET("/cus/deviceMeterRefund/pageQuery")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    V4BaseBean<V4DeviceMeterRefundRecordBean> getDeviceMeterRefundRecord(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Query("pageIndex") int i, @Query("pageSize") int i2, @Query("status") Integer num);

    @GET("/cus/devicePersonPassword/getPassword")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    V4BaseBean<String> getDevicePassword(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3);

    @GET("/cus/customerPerson/getRoomInfo")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    V4BaseBean<V4ElecMeterInfoBean> getElecMeterInfo(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Query("projectId") String str4, @Query("productId") int i);

    @GET("/cus/electricity/recharge/pageQuery")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    V4BaseBean<V4ElecRechargeRecordBean> getElecMeterRechargeRecord(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Query("pageSize") int i, @Query("pageIndex") int i2, @Query(Constant.KEY_MAC) String str4, @Query("cpersonId") String str5);

    @GET("/cus/customerPerson/getHomeInfo")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    V4BaseBean<V4HomeInfoBean> getHomeInfo(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3);

    @GET("/common/user/getLoginCodeImage")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    V4BaseBean<V4ImageCodeBean> getLoginCodeImage(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3);

    @GET("/cus/roomWallet/meterConsume/dailySummary")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    V4BaseBean<V4MeterConsumeDailySummaryBean> getMeterConsumeDailySummary(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Query("timeRange") int i, @Query("productId") int i2);

    @GET("/cus/electricity/report/getMeterConsumptionAnalysis")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    V4BaseBean<V4MetersTrendBean> getMetersTrend(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Query("productId") int i, @Query(Constant.KEY_MAC) String str4, @Query("statisticType") String str5, @Query("timeRange") String str6);

    @GET("/cus/deviceWashMode/getListByMac")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    V4BaseBean<V4ModeBean> getMode(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Query(Constant.KEY_MAC) String str4);

    @GET("/cus/deviceConsumeOwefee/getList")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    V4BaseBean<List<V4BathRecordBean>> getNoPayRecord(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Query("serviceId") String str4, @Query("pay") int i);

    @GET("/cus/project/getConfig")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    V4BaseBean<V4ProjectConfigBean> getProjectConfig(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Query("projectId") String str4);

    @GET("/cus/rechargeAmountDef/queryList")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    V4BaseBean<List<V4RechargeListBean>> getRechargeList(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Query("type") int i, @Query("serviceId") String str4);

    @GET("/cus/recharge/pageQuery")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    V4BaseBean<V4RechargeRecordListBean> getRechargeRecord(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3);

    @GET("/cus/userRefund/pageQuery")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    V4BaseBean<V4RefundRecordBean> getRefundList(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Query("type") int i, @Query("productId") int i2);

    @GET("/cus/deviceMeterRefund/getRefundableAmount")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    V4BaseBean<V4RefundableAmountBean> getRefundableAmount(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Query("customerId") String str4, @Query("serviceId") String str5, @Query("productId") int i, @Query("roomId") String str6);

    @GET("/cus/deviceRepair/pageQuery")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    V4BaseBean<V4RepairRecordBean> getRepairList(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Query("status") int i, @Query("pageSize") int i2, @Query("pageIndex") int i3, @Query("serviceId") String str4, @Query("customerId") String str5);

    @GET("/cus/deviceMeterRefund/getRoomLeader")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    V4BaseBean<V4RoomLeaderBean> getRoomLeader(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Query("customerId") String str4, @Query("serviceId") String str5, @Query("productId") int i, @Query("roomId") String str6);

    @GET("/cus/customerPerson/getListCustomerByUserId")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    V4BaseBean<List<V4SchoolInfoBean>> getSchoolInfos(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3);

    @GET("/school/getByKeyword")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    V4BaseBean<List<V4PlatformInfoBean>> getSchoolPlatform(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Query("keyword") String str4);

    @GET("/cus/customerPerson/getQrCode")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    V4BaseBean<String> getSchoolQrCode(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3);

    @GET("/cus/project/getListCurrent")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    V4BaseBean<List<V4ServerListBean>> getServerList(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3);

    @GET("/cus/aliPay/getSignAContractResult")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    V4BaseBean<V4SignBean> getSignAContractResult(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Query("modelType") String str4, @Query("parameter") String str5, @Query("serviceId") String str6);

    @GET("/cus/projectBalance/getBalanceDetail")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    V4BaseBean<V4WalletInfoBean> getUserBalance(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Query("balanceId") String str4);

    @GET("/cus/customerPerson/getUserInfo")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    V4BaseBean<V4UserInfoDetailBean> getUserInfo(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3);

    @GET("/cus/userRefund/getWaitUserRefundV2")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    V4BaseBean<V4RefundDetailBean> getWaitRefundList(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Query("type") int i, @Query("productId") int i2);

    @FormUrlEncoded
    @POST("/cus/electricity/recharge/netRecharge")
    V4BaseBean<V4RechargeBean> netRecharge(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Field(Constant.KEY_MAC) String str4);

    @POST("/cus/deviceConsume/v2/netAuthUse")
    @Headers({"Content-Type: application/json"})
    V4BaseBean<V4BLEOpenBean> post4GOpen(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Body V44GOpen v44GOpen);

    @POST("/cus/deviceRepair/add")
    @Headers({"Content-Type: application/json"})
    V4BaseBean<SuccessBean> postAddRepair(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Body V4AddRepair v4AddRepair);

    @POST("/cus/userRefund/againSubmitRefund")
    @Headers({"Content-Type: application/json"})
    V4BaseBean<String> postAgainSubmitRefund(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Body V4SubmitRefund v4SubmitRefund);

    @POST("/cus/app/appMonitorReport")
    @Headers({"Content-Type: application/json"})
    V4BaseBean<SuccessBean> postAppMonitorReport(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Body V4AppMonitorReport v4AppMonitorReport);

    @POST("/cus/deviceConsume/v2/btCollect")
    @Headers({"Content-Type: application/json"})
    V4BaseBean<V4BLEOpenBean> postBLEClollect(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Body V4BLECollect v4BLECollect);

    @POST("/cus/deviceConsume/v2/btAuthUse")
    @Headers({"Content-Type: application/json"})
    V4BaseBean<V4BLEOpenBean> postBLEOpen(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Body V4BLEOpen v4BLEOpen);

    @POST("/cus/userIdcard/bind")
    @Headers({"Content-Type: application/json"})
    V4BaseBean<V4CardInfoBean> postBindCard(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Body V4BindCard v4BindCard);

    @POST("/cus/customerPerson/addUserCustomer")
    @Headers({"Content-Type: application/json"})
    V4BaseBean<V4BindCustomer> postBindCustomer(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Body V4BindCustomer v4BindCustomer);

    @POST("/cus/customerPerson/updateRoom")
    @Headers({"Content-Type: application/json"})
    V4BaseBean<V4ElecMeterInfoBean> postBindRoom(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Body V4BindRoom v4BindRoom);

    @POST("/v1/mini-program-error-logs")
    @Headers({"Content-Type: application/json"})
    V4BaseBean<SuccessBean> postBugErrorLog(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Body V4BugErrorLog v4BugErrorLog);

    @POST("/cus/userRefund/cancelRefund")
    @Headers({"Content-Type: application/json"})
    V4BaseBean<String> postCancelRefund(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Body V4SubmitRefund v4SubmitRefund);

    @POST("/cus/electricity/recharge/recharge")
    @Headers({"Content-Type: application/json"})
    V4BaseBean<V4RechargeBean> postCreateElecMeterOrderId(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Body V4Recharge v4Recharge);

    @FormUrlEncoded
    @POST("/cus/deviceRepair/userDelete")
    V4BaseBean<SuccessBean> postDeleteRepair(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Field("repairId") String str4);

    @POST("/common/user/customerPersonLogin")
    @Headers({"Content-Type: application/json"})
    V4BaseBean<V4LoginBean> postLogin(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Body V4Login v4Login);

    @POST("/device/open")
    @Headers({"Content-Type: application/json"})
    V4BaseBean<String> postOpen(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Body OpenPro openPro);

    @POST("/common/user/resetPassword")
    @Headers({"Content-Type: application/json"})
    V4BaseBean<SuccessBean> postResetPassword(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Body V4ResetPassword v4ResetPassword);

    @FormUrlEncoded
    @POST("/sms/sendSmscode")
    V4BaseBean<SuccessBean> postSendSmsCode(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Field("mobile") String str4, @Field("captcha") String str5, @Field("captchaKey") String str6);

    @POST("/cus/devicePersonPassword/updatePassword")
    @Headers({"Content-Type: application/json"})
    V4BaseBean<SuccessBean> postSetDevicePassword(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Body V4SetDevicePassword v4SetDevicePassword);

    @POST("/cus/userRefund/submitRefundV2")
    @Headers({"Content-Type: application/json"})
    V4BaseBean<V4SubmitRefundBean> postSubmitRefund(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Body V4SubmitRefund v4SubmitRefund);

    @POST("/cus/customerPerson/switchUserCustomer")
    @Headers({"Content-Type: application/json"})
    V4BaseBean<V4UserInfoDetailBean> postSwitchCustomer(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Body V4BindCustomer v4BindCustomer);

    @FormUrlEncoded
    @POST("/cus/project/switchProject")
    V4BaseBean<V4UserInfoDetailBean> postSwitchProject(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Field("projectId") String str4);

    @POST("/cus/userIdcard/unbind")
    @Headers({"Content-Type: application/json"})
    V4BaseBean<SuccessBean> postUnBindCard(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Body V4BindCard v4BindCard);

    @FormUrlEncoded
    @POST("/cus/customerPerson/updateCurrentDeductBank")
    V4BaseBean<SuccessBean> postUpdateCurrentDeductBank(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Field("currentDeductBank") int i);

    @POST("/cus/customerPerson/updateMobile")
    @Headers({"Content-Type: application/json"})
    V4BaseBean<SuccessBean> postUpdateMobile(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Body V4Mobile v4Mobile);

    @POST("/cus/customerPerson/updatePassword")
    @Headers({"Content-Type: application/json"})
    V4BaseBean<SuccessBean> postUpdatePassword(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Body V4UserUpdateLoginPassword v4UserUpdateLoginPassword);

    @FormUrlEncoded
    @POST("/cus/customerPerson/updateCustomerInfo")
    V4BaseBean<V4UserInfoDetailBean> postUpdateUserInfo(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Field("cpersonName") String str4);

    @POST("/cus/recharge/userRecharge")
    @Headers({"Content-Type: application/json"})
    V4BaseBean<V4RechargeBean> postUserRecharge(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Body V4Recharge v4Recharge);

    @POST("/common/user/customerPersonReg")
    @Headers({"Content-Type: application/json"})
    V4BaseBean<SuccessBean> postUserRegister(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Body V4Register v4Register);

    @POST("/cus/customerPerson/logoffAllCustomer")
    @Headers({"Content-Type: application/json"})
    V4BaseBean<SuccessBean> postUserlogoff(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Body V4UserLogoff v4UserLogoff);

    @GET("/cus/aliPay/selectAll")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    V4BaseBean<List<V4SelectAllBean>> selectAll(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Query("customerId") String str4, @Query("serviceId") String str5, @Query("cpersonId") String str6, @Query("payFlagType") int i, @Query("type") int i2);

    @GET("/cus/deviceConsumeOwefee/haveUnpaidOrder")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    V4BaseBean<Boolean> selectIsHasNoPay(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Query("serviceId") String str4);

    @POST("/cus/deviceMeterRefund/submitRefund")
    @Headers({"Content-Type: application/json"})
    V4BaseBean<SuccessBean> submitRefundForDevice(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Body V4DeviceSubmitRefund v4DeviceSubmitRefund);

    @POST("/cus/deviceConsumeOwefee/payOrder")
    @Headers({"Content-Type: application/json"})
    V4BaseBean<String> toPay(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Body V4ToPay v4ToPay);

    @POST("/cus/deviceMeterRefund/toggleDeviceLock")
    @Headers({"Content-Type: application/json"})
    V4BaseBean<String> toggleDeviceLock(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Body DeviceLock deviceLock);

    @POST("/cus/electricity/receiveF0")
    @Headers({"Content-Type: application/json"})
    V4BaseBean<SuccessBean> updateF0(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Body V4F0Data v4F0Data);

    @POST("/cus/deviceMeterRefund/updateRoomLeader")
    @Headers({"Content-Type: application/json"})
    V4BaseBean<SuccessBean> updateRoomLeader(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Body V4UpdateRoomLeader v4UpdateRoomLeader);
}
