package client.android.yixiaotong.v3.http;

import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.bean.gonggaolan.Detail;
import client.android.yixiaotong.controller.bean.gonggaolan.GetAllAnnounceListBean;
import client.android.yixiaotong.controller.bean.gonggaolan.GetAnnouncementBean;
import client.android.yixiaotong.ui.login.FillInfoActivity;
import client.android.yixiaotong.util.http.bean.BaseBean;
import client.android.yixiaotong.util.retrofit.http.Body;
import client.android.yixiaotong.util.retrofit.http.Field;
import client.android.yixiaotong.util.retrofit.http.FormUrlEncoded;
import client.android.yixiaotong.util.retrofit.http.GET;
import client.android.yixiaotong.util.retrofit.http.Header;
import client.android.yixiaotong.util.retrofit.http.Headers;
import client.android.yixiaotong.util.retrofit.http.Multipart;
import client.android.yixiaotong.util.retrofit.http.POST;
import client.android.yixiaotong.util.retrofit.http.PartMap;
import client.android.yixiaotong.util.retrofit.http.Query;
import client.android.yixiaotong.v3.bean.AlarmSwitchBean;
import client.android.yixiaotong.v3.bean.PlatformInfoBean;
import client.android.yixiaotong.v3.bean.adv.AdvBean;
import client.android.yixiaotong.v3.bean.adv.AdvRulesBean;
import client.android.yixiaotong.v3.bean.appointment.AppointmentBean;
import client.android.yixiaotong.v3.bean.appointment.AppointmentListBean;
import client.android.yixiaotong.v3.bean.appointment.AppointmentResultBean;
import client.android.yixiaotong.v3.bean.appointment.UsingBean;
import client.android.yixiaotong.v3.bean.area.AreaListBean;
import client.android.yixiaotong.v3.bean.card.Activate;
import client.android.yixiaotong.v3.bean.card.BindCard;
import client.android.yixiaotong.v3.bean.card.BuyClubCardBean;
import client.android.yixiaotong.v3.bean.card.ClubCardBean;
import client.android.yixiaotong.v3.bean.card.CreateOrder;
import client.android.yixiaotong.v3.bean.card.CreateOrderBean;
import client.android.yixiaotong.v3.bean.card.RefundCreateOrder;
import client.android.yixiaotong.v3.bean.card.SchoolCardInfoBean;
import client.android.yixiaotong.v3.bean.consumer.ConsumerCreateOrder;
import client.android.yixiaotong.v3.bean.consumer.ConsumerCreateOrderBean;
import client.android.yixiaotong.v3.bean.consumer.ConsumerPriceInfoBean;
import client.android.yixiaotong.v3.bean.consumer.ConsumerQueryOrder;
import client.android.yixiaotong.v3.bean.consumer.ConsumerQueryOrderBean;
import client.android.yixiaotong.v3.bean.deviceinfo.BluetoothSetBean;
import client.android.yixiaotong.v3.bean.deviceinfo.DevicePswRuleBean;
import client.android.yixiaotong.v3.bean.deviceinfo.GetModeBean;
import client.android.yixiaotong.v3.bean.deviceinfo.MachineByLocation;
import client.android.yixiaotong.v3.bean.deviceinfo.MachineByLocationBean;
import client.android.yixiaotong.v3.bean.deviceinfo.MachineByMacBean;
import client.android.yixiaotong.v3.bean.deviceinfo.MachineRunInfo;
import client.android.yixiaotong.v3.bean.deviceinfo.NBOr4GStatuBean;
import client.android.yixiaotong.v3.bean.deviceinfo.OpenPro;
import client.android.yixiaotong.v3.bean.deviceinfo.PostPrepareBath;
import client.android.yixiaotong.v3.bean.deviceinfo.PostPrepareBathBean;
import client.android.yixiaotong.v3.bean.deviceinfo.SetRateUpload;
import client.android.yixiaotong.v3.bean.deviceinfo.SetResult;
import client.android.yixiaotong.v3.bean.deviceinfo.UpLoadData;
import client.android.yixiaotong.v3.bean.deviceinfo.UpdateMachineMac;
import client.android.yixiaotong.v3.bean.drawmoney.DMGetOrder;
import client.android.yixiaotong.v3.bean.drawmoney.DMGetOrderBean;
import client.android.yixiaotong.v3.bean.drawmoney.DMGetQrcode;
import client.android.yixiaotong.v3.bean.drawmoney.DMGetQrcodeBean;
import client.android.yixiaotong.v3.bean.drawmoney.DMHandleData;
import client.android.yixiaotong.v3.bean.drawmoney.DMHandleDataBean;
import client.android.yixiaotong.v3.bean.drawmoney.DMOrderRecordBean;
import client.android.yixiaotong.v3.bean.elecmeter.BindElecMeterInfo;
import client.android.yixiaotong.v3.bean.elecmeter.BindElecMeterInfoBean;
import client.android.yixiaotong.v3.bean.elecmeter.BindElecMeterRoomInfoBean;
import client.android.yixiaotong.v3.bean.elecmeter.ElecMeterBlanceInfoBean;
import client.android.yixiaotong.v3.bean.elecmeter.ElecMeterCreateOrder;
import client.android.yixiaotong.v3.bean.elecmeter.ElecRechargeRecord;
import client.android.yixiaotong.v3.bean.elecmeter.ElecRechargeRecordBean;
import client.android.yixiaotong.v3.bean.elecmeter.MetersTrend;
import client.android.yixiaotong.v3.bean.elecmeter.MetersTrendBean;
import client.android.yixiaotong.v3.bean.elecmeter.SelectElecMeterAreaInfo;
import client.android.yixiaotong.v3.bean.elecmeter.SelectElecMeterBuildingInfo;
import client.android.yixiaotong.v3.bean.elecmeter.SelectElecMeterFloorInfo;
import client.android.yixiaotong.v3.bean.elecmeter.SelectElecMeterRoomInfo;
import client.android.yixiaotong.v3.bean.elecmeter.UserBindRoomElecMeter;
import client.android.yixiaotong.v3.bean.login.CancelAccount;
import client.android.yixiaotong.v3.bean.login.HostUrlBean;
import client.android.yixiaotong.v3.bean.login.InvestorInfosBean;
import client.android.yixiaotong.v3.bean.login.InvestoridAndSchoolId;
import client.android.yixiaotong.v3.bean.login.LoginSeccessBean;
import client.android.yixiaotong.v3.bean.login.SchoolIdBean;
import client.android.yixiaotong.v3.bean.login.SchoolInfoBean;
import client.android.yixiaotong.v3.bean.login.SchoolInfosBean;
import client.android.yixiaotong.v3.bean.login.SchoolQrcodeBean;
import client.android.yixiaotong.v3.bean.login.UserAesData;
import client.android.yixiaotong.v3.bean.login.UserInfoBean;
import client.android.yixiaotong.v3.bean.login.UserLoginBean;
import client.android.yixiaotong.v3.bean.order.BuyClubCardDetailBean;
import client.android.yixiaotong.v3.bean.order.BuyClubCradRecordBean;
import client.android.yixiaotong.v3.bean.order.Coupon;
import client.android.yixiaotong.v3.bean.order.CouponBean;
import client.android.yixiaotong.v3.bean.order.DMOrder;
import client.android.yixiaotong.v3.bean.order.DepositRechargeRecordBean;
import client.android.yixiaotong.v3.bean.order.NoPayOrderListBean;
import client.android.yixiaotong.v3.bean.order.NoPayOrderResultBean;
import client.android.yixiaotong.v3.bean.order.OrderMoreDetailBean;
import client.android.yixiaotong.v3.bean.order.OrderRecord;
import client.android.yixiaotong.v3.bean.order.OrderRecordBean;
import client.android.yixiaotong.v3.bean.order.PayOrder;
import client.android.yixiaotong.v3.bean.order.RefundOrderRecord;
import client.android.yixiaotong.v3.bean.order.UnPayOrdersBean;
import client.android.yixiaotong.v3.bean.pay.PayResult;
import client.android.yixiaotong.v3.bean.pay.SelectAll;
import client.android.yixiaotong.v3.bean.pay.SelectAllBean;
import client.android.yixiaotong.v3.bean.pay.SignBean;
import client.android.yixiaotong.v3.bean.prepayment.ChangeSupervisor;
import client.android.yixiaotong.v3.bean.prepayment.PrepaymentCreateOrder;
import client.android.yixiaotong.v3.bean.prepayment.PrepaymentDeviceInfo;
import client.android.yixiaotong.v3.bean.prepayment.PrepaymentDeviceInfoBean;
import client.android.yixiaotong.v3.bean.prepayment.PrepaymentRedPackageAmountBean;
import client.android.yixiaotong.v3.bean.prepayment.PrepaymentWalletBean;
import client.android.yixiaotong.v3.bean.prepayment.Refund;
import client.android.yixiaotong.v3.bean.prepayment.RefundBean;
import client.android.yixiaotong.v3.bean.prepayment.SetWaterZero;
import client.android.yixiaotong.v3.bean.prepayment.SetWaterZeroBean;
import client.android.yixiaotong.v3.bean.prepayment.SupervisorBean;
import client.android.yixiaotong.v3.bean.prepayment.UnFinishOrder;
import client.android.yixiaotong.v3.bean.prepayment.UnFinishOrderBean;
import client.android.yixiaotong.v3.bean.prepayment.UserInfoByMobileBean;
import client.android.yixiaotong.v3.bean.register.ChangePhone;
import client.android.yixiaotong.v3.bean.register.MobileMessageBean;
import client.android.yixiaotong.v3.bean.register.MobileRegisterUser;
import client.android.yixiaotong.v3.bean.register.PswBean;
import client.android.yixiaotong.v3.bean.register.SetMachinePWD;
import client.android.yixiaotong.v3.bean.sellcard.DeductionRuleBean;
import client.android.yixiaotong.v3.bean.sellcard.SellCardAuth;
import client.android.yixiaotong.v3.bean.user.AppVersionBean;
import client.android.yixiaotong.v3.bean.user.HistoryLoginInfoBean;
import client.android.yixiaotong.v3.bean.user.RedisCach;
import client.android.yixiaotong.v3.bean.user.RepairUserInfo;
import client.android.yixiaotong.v3.bean.user.UserActiveInfo;
import client.android.yixiaotong.v3.bean.wallet.AppIdAndSecretBean;
import client.android.yixiaotong.v3.bean.wallet.BindSchoolGive;
import client.android.yixiaotong.v3.bean.wallet.CashRedPackageBean;
import client.android.yixiaotong.v3.bean.wallet.DepositionBean;
import client.android.yixiaotong.v3.bean.wallet.PostGetWalletInfo;
import client.android.yixiaotong.v3.bean.wallet.PostGetWalletInfoV2;
import client.android.yixiaotong.v3.bean.wallet.WalletInfoBean;
import client.android.yixiaotong.v3.bean.wallet.WalletRefundDetailBean;
import client.android.yixiaotong.v3.bean.wallet.YiKaTongPayRequest;
import client.android.yixiaotong.v3.bean.wallet.YiKaTongPayResultBean;
import client.android.yixiaotong.v3.bean.ykt.OpenYKTBean;
import client.android.yixiaotong.v3.bean.ykt.YKTBind;
import client.android.yixiaotong.v3.bean.ykt.YKTBindStateBean;
import client.android.yixiaotong.v4.http.bean.V4BaseBean;
import com.alipay.sdk.tid.b;
import com.cdo.oaps.ad.OapsKey;
import com.hihonor.adsdk.base.g.j.e.a;
import com.unionpay.tsmservice.mi.data.Constant;
import java.util.List;
import java.util.Map;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public interface V3BusinessHttpProtocol {
    @GET("/whitelist/status")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    V4BaseBean<Boolean> alarmSwitch(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3);

    @GET("/whitelist/status")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    V4BaseBean<String> alarmSwitch2(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Query("passwordSeed") String str4);

    @POST("/user/userManagement/appUpdateUserStatus")
    @Headers({"Content-Type: application/json"})
    BaseBean<SuccessBean> appUpdateUserStatus(@Body CancelAccount cancelAccount, @Header("X-Sign") String str);

    @GET("/cashMachine/card/bind")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<SuccessBean> bindCardForOpen(@Query(FillInfoActivity.EXTRA_SCHOOLID) String str, @Query("investorId") String str2, @Query("cardId") String str3, @Header("X-Sign") String str4);

    @POST("/user/binding/bindExtendCardInfo")
    @Headers({"Content-Type: application/json"})
    BaseBean<YKTBindStateBean> bindExtendCardInfo(@Body YKTBind yKTBind, @Header("X-Sign") String str);

    @POST("/unifiedOrderV1/app/payOrderV1/refundOrderCancel")
    @Headers({"Content-Type: application/json"})
    BaseBean<RefundBean> cancelRefundOrderPrepayment(@Body Refund refund, @Header("X-Sign") String str);

    @GET("/bath/async/reserve/cancel")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<AppointmentBean> cancelReserve(@Query("orderId") String str, @Query("machineId") String str2, @Query("channelWay") int i, @Query("typeId") int i2, @Query("reserveStatus") int i3, @Header("X-Sign") String str3);

    @POST("/unifiedOrderV1/app/supervisor/register")
    @Headers({"Content-Type: application/json"})
    BaseBean<SuccessBean> changeSupervisor(@Body ChangeSupervisor changeSupervisor, @Header("X-Sign") String str);

    @GET("/operation/deductionRule/app/machine/check")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<Integer> checkPrepaymentDeductionRule(@Query("investorId") String str, @Query(FillInfoActivity.EXTRA_SCHOOLID) String str2, @Query("typeId") int i, @Query("machineId") String str3, @Header("X-Sign") String str4);

    @POST("/unifiedOrderV1/app/electricity/append")
    @Headers({"Content-Type: application/json"})
    BaseBean<CreateOrderBean> elecMeterRechargeCreateOrder(@Body ElecMeterCreateOrder elecMeterCreateOrder, @Header("X-Sign") String str);

    @POST("/unifiedOrderV1/app/electricity/appendList")
    @Headers({"Content-Type: application/json"})
    BaseBean<List<ElecRechargeRecordBean>> elecMeterRechargeRecord(@Body ElecRechargeRecord elecRechargeRecord, @Header("X-Sign") String str);

    @POST("/operation/advertising/app/findAdvertisingFacilitatorRules")
    @Headers({"Content-Type: application/json"})
    BaseBean<AdvRulesBean> findAdvertisingFacilitatorRules(@Body SuccessBean successBean, @Header("X-Sign") String str);

    @POST("/unifiedOrderV1/app/payOrderV1/findRefundOrder")
    @Headers({"Content-Type: application/json"})
    BaseBean<RefundBean> findRefundOrderForPrepayment(@Body Refund refund, @Header("X-Sign") String str);

    @GET("/operation/advertising/getAdvertising")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<AdvBean> getAdvertising(@Query(FillInfoActivity.EXTRA_SCHOOLID) String str, @Query("investorId") String str2, @Header("X-Sign") String str3);

    @GET("/announcement/app/getAllAnnouncement")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<GetAllAnnounceListBean> getAllAnnouncementV3(@Query(FillInfoActivity.EXTRA_SCHOOLID) String str, @Query("investorId") String str2, @Header("X-Sign") String str3);

    @GET("/baseDict/school/analysisQRCode")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<SchoolIdBean> getAnalysisQRCode(@Query("QRCode") String str, @Header("X-Sign") String str2);

    @GET("/announcement/app/getAnnouncementDetail")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<Detail> getAnnouncementDetailNewV3(@Query("id") String str, @Header("X-Sign") String str2);

    @GET("/announcement/app/getAnnouncement")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<List<GetAnnouncementBean>> getAnnouncementV3(@Query(FillInfoActivity.EXTRA_SCHOOLID) String str, @Query("investorId") String str2, @Header("X-Sign") String str3);

    @POST("/payment/lxtInvestorPayment/getAppInfo")
    @Headers({"Content-Type: application/json"})
    BaseBean<AppIdAndSecretBean> getAppInfo(@Body InvestoridAndSchoolId investoridAndSchoolId, @Header("X-Sign") String str);

    @GET("/baseDict/app/ver/cur/newest")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<AppVersionBean> getAppVerInfo(@Query("premisesId") String str, @Query("investorId") String str2, @Header("X-Sign") String str3);

    @GET("/baseDict/app/ver/cur/newest")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<AppVersionBean> getAppVerInfo2(@Query("productVer") String str, @Query("clientType") String str2, @Query("productCode") String str3, @Header("X-Sign") String str4);

    @GET("/unifiedOrderV1/app/payOrderV1/getAppendOrderStatus")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<PrepaymentWalletBean> getAppendOrderStatus(@Query("id") String str, @Query(FillInfoActivity.EXTRA_SCHOOLID) String str2, @Query("investorId") String str3, @Header("X-Sign") String str4);

    @POST("/device-expansion/app/getBuildingList")
    @Headers({"Content-Type: application/json"})
    BaseBean<List<BindElecMeterRoomInfoBean>> getBuildingListElecMeter(@Body SelectElecMeterBuildingInfo selectElecMeterBuildingInfo, @Header("X-Sign") String str);

    @GET("/operation/app/machine/calculatePrepaidMoney")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<ConsumerPriceInfoBean> getCalculatePrepaidMoney(@Query(FillInfoActivity.EXTRA_SCHOOLID) String str, @Query("investorId") String str2, @Query("typeId") int i, @Query("studentId") String str3, @Query("machineId") String str4, @Query("deviceVer") String str5, @Query("ruleType") int i2, @Header("X-Sign") String str6);

    @GET("/user/app/checkUser")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<String> getCheckUser(@Query("account") String str, @Header("X-Sign") String str2);

    @GET("/promotion/student/getClubCardList")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<List<ClubCardBean>> getClubCardList(@Query("typeId") int i, @Query("flag") int i2, @Header("X-Sign") String str);

    @GET("/promotion/commodity/getClubCardListByInvestorid")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<List<BuyClubCardBean>> getClubCardListByInvestorid(@Query(FillInfoActivity.EXTRA_SCHOOLID) String str, @Query("investorId") String str2, @Header("X-Sign") String str3);

    @POST("/bill/clubcard/getOrderList")
    @Headers({"Content-Type: application/json"})
    BaseBean<BuyClubCradRecordBean> getClubCardOrderList(@Body OrderRecord orderRecord, @Header("X-Sign") String str);

    @GET("/user/authentication/getCode")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<String> getCode(@Query("account") String str, @Header("X-Sign") String str2);

    @POST("/promotion/student/getCouponListV1")
    @Headers({"Content-Type: application/json"})
    BaseBean<List<CouponBean>> getCouponList(@Body Coupon coupon, @Header("X-Sign") String str);

    @POST("/cashMachine/getChargeQRCode")
    @Headers({"Content-Type: application/json"})
    BaseBean<DMGetQrcodeBean> getDMChargeQRCode(@Body DMGetQrcode dMGetQrcode, @Header("X-Sign") String str);

    @GET("/user/modify/delayedPassword")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<SuccessBean> getDelayedPassword(@Header("X-Sign") String str);

    @POST("/unifiedOrder/student/getDepositInfoByInvestorid")
    @Headers({"Content-Type: application/json"})
    BaseBean<DepositionBean> getDepositInfoByInvestorid(@Body InvestoridAndSchoolId investoridAndSchoolId, @Header("X-Sign") String str);

    @POST("/bill/deposit/getOrderList")
    @Headers({"Content-Type: application/json"})
    BaseBean<DepositRechargeRecordBean> getDepositOrderList(@Body OrderRecord orderRecord, @Header("X-Sign") String str);

    @POST("/bill/deposit/getSurrenderList")
    @Headers({"Content-Type: application/json"})
    BaseBean<BuyClubCradRecordBean> getDepositRefundOrderList(@Body OrderRecord orderRecord, @Header("X-Sign") String str);

    @POST("/device-expansion/app/getDeviceBalance")
    @Headers({"Content-Type: application/json"})
    BaseBean<ElecMeterBlanceInfoBean> getDeviceBalanceElecMeter(@Body BindElecMeterInfo bindElecMeterInfo, @Header("X-Sign") String str);

    @POST("/mgapp/app/machine/get/custom")
    @Headers({"Content-Type: application/json"})
    BaseBean<PrepaymentDeviceInfoBean> getDeviceInfo(@Body PrepaymentDeviceInfo prepaymentDeviceInfo, @Header("X-Sign") String str);

    @GET("/operation/app/machine-password/v1/rule")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<DevicePswRuleBean> getDevicePswRule(@Query(FillInfoActivity.EXTRA_SCHOOLID) String str, @Header("X-Sign") String str2);

    @GET("/baseDict/site/getDormitoryOrPublicRoom")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<List<AreaListBean>> getDormitoryOrPublicRoom(@Query("areaId") String str, @Header("X-Sign") String str2);

    @GET("/user/binding/getExtendCardInfo")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<YKTBindStateBean> getExtendCardInfo(@Query("investorId") String str, @Query(FillInfoActivity.EXTRA_SCHOOLID) String str2, @Query("studentId") String str3, @Header("X-Sign") String str4);

    @GET("/card/findCard")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<SchoolCardInfoBean> getFindCard(@Query(FillInfoActivity.EXTRA_SCHOOLID) String str, @Header("X-Sign") String str2);

    @GET("/usepass/findMachiniePWD")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<PswBean> getFindMachiniePWD(@Query(FillInfoActivity.EXTRA_SCHOOLID) String str, @Header("X-Sign") String str2);

    @POST("/device-expansion/app/getFloorList")
    @Headers({"Content-Type: application/json"})
    BaseBean<List<BindElecMeterRoomInfoBean>> getFloorListElecMeter(@Body SelectElecMeterFloorInfo selectElecMeterFloorInfo, @Header("X-Sign") String str);

    @GET("/isv-config/app/getHostUrlBySchoolIdAndInvestorIdAndCode")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<List<HostUrlBean>> getHostUrlBySchoolIdAndInvestorIdAndCode(@Query(FillInfoActivity.EXTRA_SCHOOLID) String str, @Query("investorId") String str2, @Query("code") String str3, @Header("X-Sign") String str4);

    @GET("/mgapp/machine/getInfoByQRCode")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<MachineByMacBean> getInfoByQRCode(@Query("qrcode") String str, @Header("X-Sign") String str2);

    @GET("/operation/getInvestorInfoByShoolidV2")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<List<InvestorInfosBean>> getInvestorInfo(@Query(FillInfoActivity.EXTRA_SCHOOLID) String str, @Header("X-Sign") String str2);

    @GET("/mgapp/app/machine/count")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<Integer> getIsHasSellCardDevice(@Query("investorId") String str, @Query("premisesId") String str2, @Query("typeId") int i, @Query("deviceVer") String str3, @Query("status") int i2, @Header("X-Sign") String str4);

    @GET("/isv-config/app/getConfigBySchoolIdAndInvestorIdAndCategoryCode")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<OpenYKTBean> getIsOpenYKT(@Query("investorId") String str, @Query(FillInfoActivity.EXTRA_SCHOOLID) String str2, @Query("categoryCode") String str3, @Query("type") int i, @Header("X-Sign") String str4);

    @GET("/bath/machine/status/getList")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<AppointmentListBean> getList(@Query(FillInfoActivity.EXTRA_SCHOOLID) String str, @Query("investorId") String str2, @Query("siteId") String str3, @Query("siteFlag") String str4, @Query("typeId") int i, @Header("X-Sign") String str5);

    @GET("/baseDict/school/getListByAreaInfo")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<List<SchoolInfosBean>> getListByAreaInfo(@Query("province") String str, @Query(a.p) String str2, @Header("X-Sign") String str3);

    @GET("/baseDict/site/getLowerAreas")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<List<AreaListBean>> getLowerAreas(@Query("areaId") String str, @Header("X-Sign") String str2);

    @GET("/mgapp/machine/getMachineByMac")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<MachineByMacBean> getMachineByMac(@Query(Constant.KEY_MAC) String str, @Query("typeId") int i, @Header("X-Sign") String str2);

    @GET("/mgapp/machine/getCache")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<MachineByMacBean> getMachineByMachineId(@Query("machineId") String str, @Query("typeId") int i, @Header("X-Sign") String str2);

    @GET("/mgapp/machine/getCache")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<MachineByMacBean> getMachineByMachineId2(@Query("machineId") String str, @Header("X-Sign") String str2);

    @POST("/device-expansion/app/metersTrend")
    @Headers({"Content-Type: application/json"})
    BaseBean<List<MetersTrendBean>> getMetersTrend(@Body MetersTrend metersTrend, @Header("X-Sign") String str);

    @GET("/user/app/studentMobile/getMobileInfo")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<List<HistoryLoginInfoBean>> getMobileInfo(@Query("studentId") String str, @Query("pageSize") int i, @Query("pageIndex") int i2, @Header("X-Sign") String str2);

    @GET("/user/authentication/moblieMessage")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<MobileMessageBean> getMoblieMessage(@Query("studentMobile") String str, @Query("funFlag") int i, @Query("platform") int i2, @Header("X-Sign") String str2);

    @GET("/user/authentication/moblieMessageV2")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<MobileMessageBean> getMoblieMessageV2(@Query("studentMobile") String str, @Query("funFlag") int i, @Query("platform") int i2, @Query("verificationCode") String str2, @Header("X-Sign") String str3);

    @GET("/promotion/student/getMoneyCouponAmount")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<String> getMoneyCouponAmount(@Query(FillInfoActivity.EXTRA_SCHOOLID) String str, @Query("investorId") String str2, @Header("X-Sign") String str3);

    @GET("/promotion/student/getMoneyCouponAmountV2")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<CashRedPackageBean> getMoneyCouponAmountV2(@Query(FillInfoActivity.EXTRA_SCHOOLID) String str, @Query("investorId") String str2, @Query("isRefund") int i, @Header("X-Sign") String str3);

    @GET("/bath/valve/getStatus")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<NBOr4GStatuBean> getNBOr4GStatus(@Query("typeId") int i, @Query("machineId") String str, @Query("modeValue") int i2, @Query("communicationVal") String str2, @Header("X-Sign") String str3);

    @POST("/MPorder/student/getNoPayOrders/v2")
    @Headers({"Content-Type: application/json"})
    BaseBean<NoPayOrderListBean> getNoPayOrders(@Body OrderRecord orderRecord, @Header("X-Sign") String str);

    @POST("/bill/useMachineOrder/getOrderIdInfo")
    @Headers({"Content-Type: application/json"})
    BaseBean<OrderMoreDetailBean> getOrderIdInfo(@Body OrderRecord orderRecord, @Header("X-Sign") String str);

    @POST("/bill/useMachineOrder/getOrderIntegration")
    @Headers({"Content-Type: application/json"})
    BaseBean<DMOrderRecordBean> getOrderIntegration(@Body DMOrder dMOrder, @Header("X-Sign") String str);

    @POST("/bill/useMachineOrder/getOrderList")
    @Headers({"Content-Type: application/json"})
    BaseBean<OrderRecordBean> getOrderList(@Body OrderRecord orderRecord, @Header("X-Sign") String str);

    @POST("/payment/app/payFactory/getPayResult")
    @Headers({"Content-Type: application/json"})
    BaseBean<SignBean> getPayResult(@Body PayResult payResult, @Header("X-Sign") String str);

    @POST("/payment/payFactory/getPayResult")
    @Headers({"Content-Type: application/json"})
    BaseBean<YiKaTongPayResultBean> getPayResultForYiKaTong(@Body YiKaTongPayRequest yiKaTongPayRequest, @Header("X-Sign") String str);

    @GET("/baseDict/school/exist")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<PlatformInfoBean> getPlatformInfo(@Query(FillInfoActivity.EXTRA_SCHOOLID) String str, @Header("X-Sign") String str2);

    @POST("/bill/wallet/wm/getOrderList")
    @Headers({"Content-Type: application/json"})
    BaseBean<BuyClubCradRecordBean> getPrepaymentRechargeOrderList(@Body OrderRecord orderRecord, @Header("X-Sign") String str);

    @GET("/promotion/student/getRedPackageAmount")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<PrepaymentRedPackageAmountBean> getPrepaymentRedPackageAmount(@Query("machineId") String str, @Query(FillInfoActivity.EXTRA_SCHOOLID) String str2, @Query("investorId") String str3, @Header("X-Sign") String str4);

    @POST("/bill/wallet/wm/getRefundList")
    @Headers({"Content-Type: application/json"})
    BaseBean<BuyClubCradRecordBean> getPrepaymentRefundOrderList(@Body OrderRecord orderRecord, @Header("X-Sign") String str);

    @GET("/unifiedOrderV1/app/supervisor/find")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<SupervisorBean> getPrepaymentSupervisor(@Query("walletKey") String str, @Query(FillInfoActivity.EXTRA_SCHOOLID) String str2, @Query("investorId") String str3, @Header("X-Sign") String str4);

    @GET("/paymentV1/app/wallet/find")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<PrepaymentWalletBean> getPrepaymentWallet(@Query("walletKey") String str, @Query(FillInfoActivity.EXTRA_SCHOOLID) String str2, @Query("investorId") String str3, @Header("X-Sign") String str4);

    @GET("/baseDict/school/getQRCodeBySchoolId")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<SchoolQrcodeBean> getQRCodeBySchoolId(@Query("id") String str, @Header("X-Sign") String str2);

    @GET("/operation/useCach/getRedisCach")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<String> getRedisCach(@Query("key") String str, @Header("X-Sign") String str2);

    @POST("/bill/wallet/getRefundIdInfo")
    @Headers({"Content-Type: application/json"})
    BaseBean<WalletRefundDetailBean> getRefundIdInfo(@Body OrderRecord orderRecord, @Header("X-Sign") String str);

    @POST("/device-expansion/app/getRegionalList")
    @Headers({"Content-Type: application/json"})
    BaseBean<List<BindElecMeterRoomInfoBean>> getRegionalListElecMeter(@Body SelectElecMeterAreaInfo selectElecMeterAreaInfo, @Header("X-Sign") String str);

    @GET("/bath/async/getResult")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<AppointmentResultBean> getResult(@Query("machineId") String str, @Query("typeId") int i, @Query("asyncType") int i2, @Query("communicationWord") String str2, @Header("X-Sign") String str3);

    @POST("/device-expansion/app/getRoomInformation")
    @Headers({"Content-Type: application/json"})
    BaseBean<BindElecMeterRoomInfoBean> getRoomInformationElecMeter(@Body BindElecMeterInfo bindElecMeterInfo, @Header("X-Sign") String str);

    @POST("/device-expansion/app/getRoomList")
    @Headers({"Content-Type: application/json"})
    BaseBean<List<BindElecMeterRoomInfoBean>> getRoomListElecMeter(@Body SelectElecMeterRoomInfo selectElecMeterRoomInfo, @Header("X-Sign") String str);

    @GET("/user/binding/getSchoolInfo")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<SchoolInfoBean> getSchoolInfo(@Header("X-Sign") String str);

    @GET("/baseDict/school/getListBySchoolIds")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<List<SchoolInfosBean>> getSchoolInfos(@Query("schoolList") String str, @Header("X-Sign") String str2);

    @GET("/user/school/selectStudentNumberBySchoolId")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<String> getSelectStudentNumberBySchoolId(@Query(FillInfoActivity.EXTRA_SCHOOLID) String str, @Header("X-Sign") String str2);

    @POST("/cashMachine/app/sellCard/authorize")
    @Headers({"Content-Type: application/json"})
    BaseBean<AppointmentBean> getSellCardAuthData(@Body SellCardAuth sellCardAuth, @Header("X-Sign") String str);

    @POST("/bath/app/num/down")
    @Headers({"Content-Type: application/json"})
    BaseBean<SetWaterZeroBean> getSetWaterZeroData(@Body SetWaterZero setWaterZero, @Header("X-Sign") String str);

    @POST("/bill/deposit/getSurrenderIdInfo")
    @Headers({"Content-Type: application/json"})
    BaseBean<WalletRefundDetailBean> getSurrenderIdInfo(@Body OrderRecord orderRecord, @Header("X-Sign") String str);

    @POST("/unifiedOrderV1/app/payOrderV1/getUnfinishedAppendOrder")
    @Headers({"Content-Type: application/json"})
    BaseBean<List<UnFinishOrderBean>> getUnFinishOrder(@Body UnFinishOrder unFinishOrder, @Header("X-Sign") String str);

    @GET("/MPorder/student/getUnPayOrderIndex")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<UnPayOrdersBean> getUnPayOrderIndex(@Query("studentId") String str, @Header("X-Sign") String str2);

    @POST("/mgapp/machine/updateMachineMac")
    @Headers({"Content-Type: application/json"})
    BaseBean<MachineByMacBean> getUpdateMachineMac(@Body UpdateMachineMac updateMachineMac, @Header("X-Sign") String str);

    @GET("/bath/machine/status/update")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<SuccessBean> getUpdateStatus(@Query("machineId") String str, @Query("typeId") int i, @Query("statusInfo") String str2, @Header("X-Sign") String str3);

    @GET("/drink/machine/status/update")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<SuccessBean> getUpdateStatusDrink(@Query("machineId") String str, @Query("typeId") int i, @Query("statusInfo") String str2, @Header("X-Sign") String str3);

    @GET("/hairdryer/machine/status/update")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<SuccessBean> getUpdateStatusHair(@Query("machineId") String str, @Query("typeId") int i, @Query("statusInfo") String str2, @Header("X-Sign") String str3);

    @GET("/washing/machine/status/update")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<SuccessBean> getUpdateStatusWash(@Query("machineId") String str, @Query("typeId") int i, @Query("statusInfo") String str2, @Header("X-Sign") String str3);

    @GET("/mgapp/machine/getUseInfoByMachineId")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<InvestoridAndSchoolId> getUseInfoByMachineId(@Query("machineId") String str, @Query("typeId") int i, @Header("X-Sign") String str2);

    @GET("/user/app/getUserByStudentMobile")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<UserInfoByMobileBean> getUserByStudentMobile(@Query("studentMobile") String str, @Header("X-Sign") String str2);

    @GET("/user/basic/getUserInfo")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<UserInfoBean> getUserInfo(@Header("X-Sign") String str);

    @POST("/device-expansion/app/getUserInfo")
    @Headers({"Content-Type: application/json"})
    BaseBean<BindElecMeterInfoBean> getUserInfoElecMeter(@Body BindElecMeterInfo bindElecMeterInfo, @Header("X-Sign") String str);

    @GET("/user/login/userLogout")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<String> getUserLogout(@Header("X-Sign") String str);

    @GET("/bath/machine/status/getUsingList")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<List<UsingBean>> getUsingList(@Query(FillInfoActivity.EXTRA_SCHOOLID) String str, @Query("investorId") String str2, @Query("typeId") int i, @Header("X-Sign") String str3);

    @POST("/bill/wallet/getOrderList")
    @Headers({"Content-Type: application/json"})
    BaseBean<BuyClubCradRecordBean> getWalletOrderList(@Body OrderRecord orderRecord, @Header("X-Sign") String str);

    @POST("/bill/wallet/getRefundList")
    @Headers({"Content-Type: application/json"})
    BaseBean<BuyClubCradRecordBean> getWalletRefundOrderList(@Body RefundOrderRecord refundOrderRecord, @Header("X-Sign") String str);

    @GET("/unifiedOrderV1/app/supervisor/unbind")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<SuccessBean> pastSupervisor(@Query("walletKey") String str, @Query(FillInfoActivity.EXTRA_SCHOOLID) String str2, @Query("investorId") String str3, @Header("X-Sign") String str4);

    @POST("/payment/app/lxtPaymentExtend/selectAll")
    @Headers({"Content-Type: application/json"})
    BaseBean<List<SelectAllBean>> paySelectAll(@Body SelectAll selectAll, @Header("X-Sign") String str);

    @POST("/unifiedOrder/activate")
    @Headers({"Content-Type: application/json"})
    BaseBean<SuccessBean> postActivate(@Body Activate activate, @Header("X-Sign") String str);

    @POST("/card/bindCardByMachine")
    @Headers({"Content-Type: application/json"})
    BaseBean<SchoolCardInfoBean> postBindCardByMachine(@Body BindCard bindCard, @Header("X-Sign") String str);

    @POST("/card/bindCard")
    @Headers({"Content-Type: application/json"})
    BaseBean<SchoolCardInfoBean> postBindCardByMachine2(@Body BindCard bindCard, @Header("X-Sign") String str);

    @POST("/operation/rechargeGiftProgram/cloud/binDingGive")
    @Headers({"Content-Type: application/json"})
    BaseBean<SuccessBean> postBindSchoolGive(@Body BindSchoolGive bindSchoolGive, @Header("X-Sign") String str);

    @FormUrlEncoded
    @POST("/user/binding/schoolInfo")
    BaseBean<SuccessBean> postBindSchoolInfo(@Field(FillInfoActivity.EXTRA_SCHOOLID) String str, @Field("studentNumber") String str2, @Header("X-Sign") String str3);

    @POST("/bath/setMachinePar")
    @Headers({"Content-Type: application/json"})
    BaseBean<BluetoothSetBean> postBluetoothSetData(@Body SetRateUpload setRateUpload, @Header("X-Sign") String str);

    @POST("/drink/setMachinePar")
    @Headers({"Content-Type: application/json"})
    BaseBean<BluetoothSetBean> postBluetoothSetDataDrink(@Body SetRateUpload setRateUpload, @Header("X-Sign") String str);

    @POST("/hairdryer/setMachinePar")
    @Headers({"Content-Type: application/json"})
    BaseBean<BluetoothSetBean> postBluetoothSetDataHairdryer(@Body SetRateUpload setRateUpload, @Header("X-Sign") String str);

    @POST("/bath/setMachineParOk")
    @Headers({"Content-Type: application/json"})
    BaseBean<SuccessBean> postBluetoothSetDataResult(@Body SetResult setResult, @Header("X-Sign") String str);

    @POST("/drink/setMachineParOk")
    @Headers({"Content-Type: application/json"})
    BaseBean<SuccessBean> postBluetoothSetDataResultDrink(@Body SetResult setResult, @Header("X-Sign") String str);

    @POST("/hairdryer/setMachineParOk")
    @Headers({"Content-Type: application/json"})
    BaseBean<SuccessBean> postBluetoothSetDataResultHairdryer(@Body SetResult setResult, @Header("X-Sign") String str);

    @POST("/washing/setMachineParOk")
    @Headers({"Content-Type: application/json"})
    BaseBean<SuccessBean> postBluetoothSetDataResultWashing(@Body SetResult setResult, @Header("X-Sign") String str);

    @POST("/washing/setMachinePar")
    @Headers({"Content-Type: application/json"})
    BaseBean<BluetoothSetBean> postBluetoothSetDataWashing(@Body SetRateUpload setRateUpload, @Header("X-Sign") String str);

    @POST("/MPorder/student/merge_order/cancel")
    @Headers({"Content-Type: application/json"})
    BaseBean<Object> postCancelPayOrders(@Body InvestoridAndSchoolId investoridAndSchoolId, @Header("X-Sign") String str);

    @POST("/card/closeApply")
    @Headers({"Content-Type: application/json"})
    BaseBean<SchoolCardInfoBean> postCloseApplyCard(@Body BindCard bindCard, @Header("X-Sign") String str);

    @POST("/bath/valve/close")
    @Headers({"Content-Type: application/json"})
    BaseBean<Object> postCloseAuth(@Body PostPrepareBath postPrepareBath, @Header("X-Sign") String str);

    @POST("/MPorder/app/posMachine/create")
    @Headers({"Content-Type: application/json"})
    BaseBean<ConsumerCreateOrderBean> postConsumerCreateOrder(@Body ConsumerCreateOrder consumerCreateOrder, @Header("X-Sign") String str);

    @POST("/MPorder/app/posMachine/queryOrder")
    @Headers({"Content-Type: application/json"})
    BaseBean<ConsumerQueryOrderBean> postConsumerQueryOrder(@Body ConsumerQueryOrder consumerQueryOrder, @Header("X-Sign") String str);

    @POST("/MPorder/sell-card/createBluetoothOrder")
    @Headers({"Content-Type: application/json"})
    BaseBean<DMGetOrderBean> postCreateBluetoothOrder(@Body DMGetOrder dMGetOrder, @Header("X-Sign") String str);

    @POST("/unifiedOrder/createOrders")
    @Headers({"Content-Type: application/json"})
    BaseBean<CreateOrderBean> postCreateOrders(@Body CreateOrder createOrder, @Header("X-Sign") String str);

    @POST("/MPorder/recharger/order/create")
    @Headers({"Content-Type: application/json"})
    BaseBean<DMGetOrderBean> postDMGetOrder(@Body DMGetOrder dMGetOrder, @Header("X-Sign") String str);

    @POST("/cashMachine/handleData")
    @Headers({"Content-Type: application/json"})
    BaseBean<DMHandleDataBean> postDMHandleData(@Body DMHandleData dMHandleData, @Header("X-Sign") String str);

    @POST("/cashMachine/removeData")
    @Headers({"Content-Type: application/json"})
    BaseBean<DMGetQrcodeBean> postDMRemoveData(@Body DMHandleData dMHandleData, @Header("X-Sign") String str);

    @POST("/mgapp/machine/getMachineByLocation")
    @Headers({"Content-Type: application/json"})
    BaseBean<List<MachineByLocationBean>> postGetMachineByLocation(@Body MachineByLocation machineByLocation, @Header("X-Sign") String str);

    @GET("/washing/getMode")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<GetModeBean> postGetMode(@Query("typeId") int i, @Query("machineId") String str, @Query(FillInfoActivity.EXTRA_SCHOOLID) String str2, @Header("X-Sign") String str3);

    @POST("/payment/student/getWalletInfoByInvestorid")
    @Headers({"Content-Type: application/json"})
    BaseBean<WalletInfoBean> postGetWalletInfoByInvestorid(@Body PostGetWalletInfo postGetWalletInfo, @Header("X-Sign") String str);

    @POST("/paymentV1/getUserWallet")
    @Headers({"Content-Type: application/json"})
    BaseBean<WalletInfoBean> postGetWalletInfoByInvestoridV2(@Body PostGetWalletInfoV2 postGetWalletInfoV2, @Header("X-Sign") String str);

    @POST("/bath/handleData")
    @Headers({"Content-Type: application/json"})
    BaseBean<Object> postHandleData(@Body UpLoadData upLoadData, @Header("X-Sign") String str);

    @POST("/drink/handleData")
    @Headers({"Content-Type: application/json"})
    BaseBean<Object> postHandleDataDrink(@Body UpLoadData upLoadData, @Header("X-Sign") String str);

    @POST("/hairdryer/handleData")
    @Headers({"Content-Type: application/json"})
    BaseBean<Object> postHandleDataHairdryer(@Body UpLoadData upLoadData, @Header("X-Sign") String str);

    @POST("/washing/handleData")
    @Headers({"Content-Type: application/json"})
    BaseBean<Object> postHandleDataWash(@Body UpLoadData upLoadData, @Header("X-Sign") String str);

    @POST("/user/modify/loginPasswordByAuthenticationMessage")
    @Headers({"Content-Type: application/json"})
    BaseBean<SuccessBean> postLoginPasswordByAuthenticationMessage(@Body MobileRegisterUser mobileRegisterUser, @Header("X-Sign") String str);

    @POST("/user/modify/loginPasswordByAuthenticationMessageWithEncrypt")
    @Headers({"Content-Type: application/json"})
    BaseBean<SuccessBean> postLoginPasswordByAuthenticationMessageAes(@Body UserAesData userAesData, @Header("X-Sign") String str);

    @POST("/bath/setMachineRunInfo")
    @Headers({"Content-Type: application/json"})
    BaseBean<BluetoothSetBean> postMachineRunInfo(@Body MachineRunInfo machineRunInfo, @Header("X-Sign") String str);

    @POST("/drink/setMachineRunInfo")
    @Headers({"Content-Type: application/json"})
    BaseBean<BluetoothSetBean> postMachineRunInfoDrink(@Body MachineRunInfo machineRunInfo, @Header("X-Sign") String str);

    @POST("/hairdryer/setMachineRunInfo")
    @Headers({"Content-Type: application/json"})
    BaseBean<BluetoothSetBean> postMachineRunInfoHairdryer(@Body MachineRunInfo machineRunInfo, @Header("X-Sign") String str);

    @POST("/washing/setMachineRunInfo")
    @Headers({"Content-Type: application/json"})
    BaseBean<BluetoothSetBean> postMachineRunInfoWashing(@Body MachineRunInfo machineRunInfo, @Header("X-Sign") String str);

    @POST("/user/register/moblieRegisterUser")
    @Headers({"Content-Type: application/json"})
    BaseBean<SuccessBean> postMoblieRegisterUser(@Body MobileRegisterUser mobileRegisterUser, @Header("X-Sign") String str);

    @POST("/user/register/moblieRegisterUserWithEncrypt")
    @Headers({"Content-Type: application/json"})
    BaseBean<SuccessBean> postMoblieRegisterUserAes(@Body UserAesData userAesData, @Header("X-Sign") String str);

    @POST("/device/open")
    @Headers({"Content-Type: application/json"})
    V4BaseBean<String> postOpen(@Header(b.f) String str, @Header("tokenInfo") String str2, @Header("sign") String str3, @Body OpenPro openPro);

    @POST("/card/openApply")
    @Headers({"Content-Type: application/json"})
    BaseBean<SchoolCardInfoBean> postOpenApplyCard(@Body BindCard bindCard, @Header("X-Sign") String str);

    @POST("/bath/valve/open")
    @Headers({"Content-Type: application/json"})
    BaseBean<Object> postOpenAuth(@Body PostPrepareBath postPrepareBath, @Header("X-Sign") String str);

    @POST("/drink/valve/open")
    @Headers({"Content-Type: application/json"})
    BaseBean<Object> postOpenAuthDrink(@Body PostPrepareBath postPrepareBath, @Header("X-Sign") String str);

    @POST("/hairdryer/valve/open")
    @Headers({"Content-Type: application/json"})
    BaseBean<Object> postOpenAuthHairdryer(@Body PostPrepareBath postPrepareBath, @Header("X-Sign") String str);

    @POST("/washing/valve/open")
    @Headers({"Content-Type: application/json"})
    BaseBean<Object> postOpenAuthWash(@Body PostPrepareBath postPrepareBath, @Header("X-Sign") String str);

    @POST("/v4/device/open")
    @Headers({"Content-Type: application/json"})
    V4BaseBean<String> postOpenV4(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Body OpenPro openPro);

    @POST("/MPorder/student/pos/payOrder")
    @Headers({"Content-Type: application/json"})
    BaseBean<NoPayOrderResultBean> postPayOrders(@Body PayOrder payOrder, @Header("X-Sign") String str);

    @POST("/bath/valve/prepare")
    @Headers({"Content-Type: application/json"})
    BaseBean<PostPrepareBathBean> postPrepareBath(@Body PostPrepareBath postPrepareBath, @Header("X-Sign") String str);

    @POST("/unifiedOrderV1/app/order")
    @Headers({"Content-Type: application/json"})
    BaseBean<CreateOrderBean> postPrepaymentCreateOrders(@Body PrepaymentCreateOrder prepaymentCreateOrder, @Header("X-Sign") String str);

    @POST("/operation/useCach/setRedisCach")
    @Headers({"Content-Type: application/json"})
    BaseBean<SuccessBean> postRedisCach(@Body RedisCach redisCach, @Header("X-Sign") String str);

    @POST("/unifiedOrder/refund")
    @Headers({"Content-Type: application/json"})
    BaseBean<CreateOrderBean> postRefundCard(@Body RefundCreateOrder refundCreateOrder, @Header("X-Sign") String str);

    @POST("/unifiedOrderV1/app/redPackage/redPackageRefundApply")
    @Headers({"Content-Type: application/json"})
    BaseBean<CreateOrderBean> postRefundCashRedPackageOrders(@Body RefundCreateOrder refundCreateOrder, @Header("X-Sign") String str);

    @POST("/unifiedOrderV1/app/redPackage/redPackageRefundApplyCancel")
    @Headers({"Content-Type: application/json"})
    BaseBean<CreateOrderBean> postRefundCashRedPackageOrdersCancel(@Body RefundCreateOrder refundCreateOrder, @Header("X-Sign") String str);

    @POST("/unifiedOrder/refundOrders")
    @Headers({"Content-Type: application/json"})
    BaseBean<CreateOrderBean> postRefundOrders(@Body RefundCreateOrder refundCreateOrder, @Header("X-Sign") String str);

    @POST("/api/oss/ali/upload")
    @Multipart
    BaseBean<String> postRefundPic(@PartMap Map<String, RequestBody> map, @Header("X-Sign") String str);

    @POST("/user/modify/userLoginPassword")
    @Headers({"Content-Type: application/json"})
    BaseBean<SuccessBean> postResetLoginPassword(@Body MobileRegisterUser mobileRegisterUser, @Header("X-Sign") String str);

    @POST("/user/modify/userLoginPasswordWithEncrypt")
    @Headers({"Content-Type: application/json"})
    BaseBean<SuccessBean> postResetLoginPasswordAes(@Body UserAesData userAesData, @Header("X-Sign") String str);

    @POST("/unifiedOrder/refund/revoke")
    @Headers({"Content-Type: application/json"})
    BaseBean<CreateOrderBean> postRevokeRefundOrders(@Body RefundCreateOrder refundCreateOrder, @Header("X-Sign") String str);

    @FormUrlEncoded
    @POST("/usepass/setMachiniePWD")
    BaseBean<PswBean> postSetMachinePWD(@Field(FillInfoActivity.EXTRA_SCHOOLID) String str, @Field("setPassword") String str2, @Header("X-Sign") String str3);

    @POST("/user/modify/studentMobileByAuthenticationMessage")
    @Headers({"Content-Type: application/json"})
    BaseBean<SuccessBean> postStudentMobileByAuthenticationMessage(@Body ChangePhone changePhone, @Header("X-Sign") String str);

    @POST("/card/unbindCard")
    @Headers({"Content-Type: application/json"})
    BaseBean<SchoolCardInfoBean> postUnbindCard(@Body BindCard bindCard, @Header("X-Sign") String str);

    @POST("/usepass/updateMachiniePWD")
    @Headers({"Content-Type: application/json"})
    BaseBean<PswBean> postUpdateMachinePWD(@Body SetMachinePWD setMachinePWD, @Header("X-Sign") String str);

    @POST("/user/school/updateStudentNumberBySchoolId")
    @Headers({"Content-Type: application/json"})
    BaseBean<SuccessBean> postUpdateStudentNumberBySchoolId(@Body RepairUserInfo repairUserInfo, @Header("X-Sign") String str);

    @POST("/operationProducer/app/userActiveInfo")
    @Headers({"Content-Type: application/json"})
    BaseBean<SuccessBean> postUserActiveInfo(@Body UserActiveInfo userActiveInfo, @Header("X-Sign") String str);

    @POST("/user/binding/userInfo")
    @Headers({"Content-Type: application/json"})
    BaseBean<SuccessBean> postUserInfo(@Body RepairUserInfo repairUserInfo, @Header("X-Sign") String str);

    @POST("/user/login/userLoginV2")
    @Headers({"Content-Type: application/json"})
    BaseBean<LoginSeccessBean> postUserLogin(@Body UserLoginBean userLoginBean, @Header("X-Sign") String str);

    @POST("/user/login/userLoginV2WithEncrypt")
    @Headers({"Content-Type: application/json"})
    BaseBean<LoginSeccessBean> postUserLoginAes(@Body UserAesData userAesData, @Header("X-Sign") String str);

    @POST("/unifiedOrderV1/app/payOrderV1/refundOrder")
    @Headers({"Content-Type: application/json"})
    BaseBean<RefundBean> refundOrderPrepayment(@Body Refund refund, @Header("X-Sign") String str);

    @GET("/bath/async/reserve")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<AppointmentBean> reserve(@Query("machineId") String str, @Query("channelWay") int i, @Query("typeId") int i2, @Header("X-Sign") String str2);

    @GET("/operation/deductionRule/app/v1/rule/custom")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<DeductionRuleBean> selectDeductionRule(@Query("investorId") String str, @Query(FillInfoActivity.EXTRA_SCHOOLID) String str2, @Query("typeId") int i, @Query("deviceVer") String str3, @Query("ruleType") int i2, @Header("X-Sign") String str4);

    @POST("/whitelist/status")
    @Headers({"Content-Type: application/json"})
    V4BaseBean<SuccessBean> setAlarmSwitch(@Header(b.f) String str, @Header(OapsKey.KEY_TOKEN) String str2, @Header("sign") String str3, @Body AlarmSwitchBean alarmSwitchBean);

    @GET("/bath/num/unlock")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<SuccessBean> unlock(@Query("typeId") int i, @Query("machineId") String str, @Query("deviceVer") String str2, @Header("X-Sign") String str3);

    @POST("/device-expansion/app/userBindRoom")
    @Headers({"Content-Type: application/json"})
    BaseBean<SuccessBean> userBindRoomElecMeter(@Body UserBindRoomElecMeter userBindRoomElecMeter, @Header("X-Sign") String str);

    @GET("/unifiedOrderV1/app/payOrderV1/waterAppendCallback")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    BaseBean<BuyClubCardDetailBean> waterAppendCallback(@Query("id") String str, @Query("status") int i, @Query(FillInfoActivity.EXTRA_SCHOOLID) String str2, @Query("investorId") String str3, @Query("type") int i2, @Header("X-Sign") String str4);
}
