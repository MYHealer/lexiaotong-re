package client.android.yixiaotong.util.http.protocol;

import client.android.yixiaotong.controller.bean.AliPayBean;
import client.android.yixiaotong.controller.bean.AmmeterAliPayBean;
import client.android.yixiaotong.controller.bean.AmmeterBindingRoom;
import client.android.yixiaotong.controller.bean.AmmeterOrderStateBean;
import client.android.yixiaotong.controller.bean.AmmeterRoomDetail;
import client.android.yixiaotong.controller.bean.AmmeterWeiXinPayBean;
import client.android.yixiaotong.controller.bean.AreasBean;
import client.android.yixiaotong.controller.bean.DeviceInfoBean;
import client.android.yixiaotong.controller.bean.EncrypedBean;
import client.android.yixiaotong.controller.bean.GetDeviceQrCodeBean;
import client.android.yixiaotong.controller.bean.GetMealQrcodeBean;
import client.android.yixiaotong.controller.bean.ManagerBean;
import client.android.yixiaotong.controller.bean.MessageRecordListBean;
import client.android.yixiaotong.controller.bean.NullBean;
import client.android.yixiaotong.controller.bean.OpenDataBean;
import client.android.yixiaotong.controller.bean.RecordListBean;
import client.android.yixiaotong.controller.bean.RefundBean;
import client.android.yixiaotong.controller.bean.RepairProcessListBean;
import client.android.yixiaotong.controller.bean.SoundWaveBean;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.bean.UnionPayBean;
import client.android.yixiaotong.controller.bean.UserInfoBean;
import client.android.yixiaotong.controller.bean.WeiXinPayBean;
import client.android.yixiaotong.controller.bean.adv.AdvControlListBean;
import client.android.yixiaotong.controller.bean.bath.BathDevicesInfoListBean;
import client.android.yixiaotong.controller.bean.getserveraddress.LoginBefore;
import client.android.yixiaotong.controller.bean.getserveraddress.RegisterBefore;
import client.android.yixiaotong.controller.bean.gonggaolan.Detail;
import client.android.yixiaotong.controller.bean.gonggaolan.GetAllAnnounceListBean;
import client.android.yixiaotong.controller.bean.gonggaolan.GetAnnouncementBean;
import client.android.yixiaotong.controller.bean.hamam.HamamGetRoomInfoBean;
import client.android.yixiaotong.controller.bean.hamam.HamamInitDeviceBean;
import client.android.yixiaotong.controller.bean.hamam.HamamVerifyAuthPasswordSecurity;
import client.android.yixiaotong.controller.bean.init.NBMachineInfo;
import client.android.yixiaotong.controller.bean.pay.ABCPayBean;
import client.android.yixiaotong.controller.bean.recharge.RechargeDetailListBean;
import client.android.yixiaotong.controller.bean.recharge.RechargeInfoBean;
import client.android.yixiaotong.controller.bean.refund.RefundListBean;
import client.android.yixiaotong.controller.bean.report.RepairUploadReportPicsBean;
import client.android.yixiaotong.controller.bean.report.ReportDetailBean;
import client.android.yixiaotong.controller.bean.report.ReportListBean;
import client.android.yixiaotong.controller.bean.sellcard.SellCardAliBean;
import client.android.yixiaotong.controller.bean.sellcard.SellCardUnionBean;
import client.android.yixiaotong.controller.bean.sellcard.SellCardWeiXinPayBean;
import client.android.yixiaotong.controller.bean.set.SetBean;
import client.android.yixiaotong.controller.store.FileUploadBean;
import client.android.yixiaotong.util.http.bean.BaseBean;
import client.android.yixiaotong.util.http.bean.BaseBeanLow;
import client.android.yixiaotong.util.retrofit.http.Field;
import client.android.yixiaotong.util.retrofit.http.FormUrlEncoded;
import client.android.yixiaotong.util.retrofit.http.GET;
import client.android.yixiaotong.util.retrofit.http.POST;
import client.android.yixiaotong.util.retrofit.http.Query;
import com.cdo.oaps.ad.OapsKey;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public interface BusinessHttpProtocol {
    public static final String NAME_TAG = "YIKATONG";

    @FormUrlEncoded
    @POST("/app/Order/ABCPayment")
    BaseBean<ABCPayBean> ABCPay(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/App/Order/AliCardMachinePay")
    BaseBean<SellCardAliBean> AliCardMachinePay(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/app/order/AliPay")
    BaseBean<AliPayBean> AliPay(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @GET("/App/Student/EncryptedLoginToV3")
    BaseBean<SuccessBean> EncryptedLoginToV3(@Query("code") String str, @Query("sign") String str2);

    @GET("/App/Basic/GerOrdersInfo")
    BaseBean<SuccessBean> GerOrdersInfo(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/App/EWallet/GetEncryptedOneStudentApplication")
    BaseBean<EncrypedBean> GetEncryptedOneStudentApplication(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/App/Equipment/GetEquipmentInformation")
    BaseBean<HamamGetRoomInfoBean> GetEquipmentInfo(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/app/Basic/GetEquipmentRateInfo")
    BaseBean<SetBean> GetEquipmentRateInfo(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/App/Equipment/GetEquipmentSerialNumbers")
    BaseBean<BathDevicesInfoListBean> GetEquipmentSerialNumbers(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/app/report/NewGetConsumeDetailList")
    BaseBean<RecordListBean> GetNewConsumeDetailList(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/App/Report/GetTopupList")
    BaseBean<MessageRecordListBean> GetRechargeMessageList(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/app/Basic/GetRechargePromptInformation")
    BaseBean<RechargeInfoBean> GetRechargePromptInformation(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/app/Basic/JudgeEquipmentRateInfo")
    BaseBean<SetBean> JudgeEquipmentRateInfo(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/app/Basic/SetEquipmentRateInfo")
    BaseBean<SuccessBean> SetEquipmentRateInfo(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/App/Order/UnionCardMachinePay")
    BaseBean<SellCardUnionBean> UnionCardMachinePay(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/app/order/UnionPay")
    BaseBean<UnionPayBean> UnionPay(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @GET("/App/student/VerifyAuthPasswordSecurity")
    BaseBean<HamamVerifyAuthPasswordSecurity> VerifyAuthPasswordSecurity(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/app/order/WeiXinPay")
    BaseBean<WeiXinPayBean> WeiXinPay(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/App/Order/WxCardMachinePay")
    BaseBean<SellCardWeiXinPayBean> WxCardMachinePay(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/App/Order/AliOrdersPay")
    BaseBean<AmmeterAliPayBean> ammeterAliOrder(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/app/Basic/BindingRoom")
    BaseBean<AmmeterBindingRoom> ammeterBindingRoom(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @GET("/app/Basic/GetRoomDetail")
    BaseBean<AmmeterRoomDetail> ammeterGetRoomDetail(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/app/Basic/NewGetRoomDetail")
    BaseBean<AmmeterRoomDetail> ammeterGetRoomDetailNew(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/app/Basic/NewIsBinding")
    BaseBean<AmmeterBindingRoom> ammeterIsBindRoom(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/app/Basic/NewBindingRoom")
    BaseBean<AmmeterBindingRoom> ammeterNewBindingRoom(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @GET("/App/Basic/GerOrdersInfo")
    BaseBean<AmmeterOrderStateBean> ammeterSelectOrder(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/App/Basic/UnBindingRoom")
    BaseBean<AmmeterBindingRoom> ammeterUnBindingRoom(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/App/Basic/NewUnBindingRoom")
    BaseBean<AmmeterBindingRoom> ammeterUnBindingRoomNew(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/App/Student/ResetAuthorizedPassword")
    BaseBean<SuccessBean> chongZhiShouQuanPassword(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @GET("/app/Basic/AdvertisingControl")
    BaseBean<AdvControlListBean> getAdvertisingControl(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/app/Basic/GetAllAnnouncement")
    BaseBean<GetAllAnnounceListBean> getAllAnnouncement(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/ZK_BSRS/announcement/getAllAnnouncement")
    BaseBeanLow<GetAllAnnounceListBean> getAllAnnouncementV3(@Query("sign") String str, @Query("wxcode") String str2, @Query(OapsKey.KEY_SUB_ID) String str3);

    @FormUrlEncoded
    @POST("/App/Order/UnionOrdersPay")
    BaseBean<UnionPayBean> getAmmeterUnionAliOrder(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/App/Order/WxOrdersPay")
    BaseBean<AmmeterWeiXinPayBean> getAmmeterWeiXinOrder(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @GET("/app/Basic/GetAnnouncement")
    BaseBean<List<GetAnnouncementBean>> getAnnouncement(@Query("code") String str, @Query("sign") String str2);

    @GET("/app/Basic/NewGetAnnouncementDetail")
    BaseBean<Detail> getAnnouncementDetailNew(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/ZK_BSRS/announcement/getNewAnnouncementDetail")
    BaseBeanLow<Detail> getAnnouncementDetailNewV3(@Query("sign") String str, @Query("wxcode") String str2, @Query(OapsKey.KEY_SUB_ID) String str3);

    @GET("/ZK_BSRS/announcement/getAnnouncement")
    BaseBeanLow<List<GetAnnouncementBean>> getAnnouncementV3(@Query("sign") String str, @Query("wxcode") String str2, @Query(OapsKey.KEY_SUB_ID) String str3);

    @FormUrlEncoded
    @POST("/app/EWallet/CancellationOfRefund")
    BaseBean<SuccessBean> getCancellationOfRefund(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @GET("/app/Equipment/GetDeviceInfo")
    BaseBean<DeviceInfoBean> getDeviceInfo(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/App/EWallet/GetEncryptedStudentApplications")
    BaseBean<EncrypedBean> getEncryptedAllApplication(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/App/Student/GetEncryptedStudentInfo")
    BaseBean<EncrypedBean> getEncryptedStudentInfo(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/App/Student/GetLoginInfo")
    BaseBean<ManagerBean> getIsManager(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/app/basic/GetMealQrCode")
    BaseBean<GetMealQrcodeBean> getMealQrCode(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/App/Equipment/GetNBMachineInfo")
    BaseBean<NBMachineInfo> getNBMachineInfo(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/app/Equipment/NewGetDeviceInfo")
    BaseBean<DeviceInfoBean> getNewDeviceInfo(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/app/Basic/GetRechargeGiftInfo")
    BaseBean<RechargeDetailListBean> getRechargeGiftInfo(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/App/EWallet/GetStudentApplicationDetail")
    BaseBean<List<RefundBean>> getRefundProgress(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/app/Equipment/GetRepairProcess")
    BaseBean<RepairProcessListBean> getRepairProcessList(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/App/FaultReport/GetReportDetail")
    BaseBean<ReportDetailBean> getReportDetail(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/ZK_BSRS/repair/getReportDetail")
    BaseBeanLow<ReportDetailBean> getReportDetailV3(@Query("sign") String str, @Query("wxcode") String str2, @Query(OapsKey.KEY_SUB_ID) String str3);

    @GET("/App/FaultReport/GetReportList")
    BaseBean<ReportListBean> getReportList(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/ZK_BSRS/repair/getReportList")
    BaseBeanLow<ReportListBean> getReportListV3(@Query("sign") String str, @Query("wxcode") String str2, @Query(OapsKey.KEY_SUB_ID) String str3);

    @GET("/app/basic/GetSchoolList")
    BaseBean<List<AreasBean>> getSchoolList(@Query("code") String str, @Query("sign") String str2);

    @GET("/App/Equipment/SmpGetDeviceInfo")
    BaseBean<DeviceInfoBean> getSmpDeviceInfo(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_ykt_api/app/student/GetSoundwaveProtocol")
    BaseBean<SoundWaveBean> getSoundWave(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/app/EWallet/GetRefundList")
    BaseBean<RefundListBean> getUserRefundList(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/app/Equipment/InitDeviceWithMac")
    BaseBean<GetDeviceQrCodeBean> initDevice(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/app/Equipment/NewInitDeviceWithMac")
    BaseBean<GetDeviceQrCodeBean> initDeviceNew(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/App/Equipment/InitializationDevice")
    BaseBean<HamamInitDeviceBean> initHamam(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @GET("/app/student/login")
    BaseBean<UserInfoBean> login(@Query("code") String str, @Query("sign") String str2);

    @GET("/App/Student/PreGetByMobile")
    BaseBean<LoginBefore> loginBeforeGetServerAddress(@Query("code") String str, @Query("sign") String str2);

    @GET("/App/Student/EncryptedLogin")
    BaseBean<EncrypedBean> loginEncryped(@Query("code") String str, @Query("sign") String str2);

    @GET("/App/Student/NewLogin")
    BaseBean<UserInfoBean> loginnew(@Query("code") String str, @Query("sign") String str2);

    @FormUrlEncoded
    @POST("/app/student/ChangeLoginPassword")
    BaseBean<SuccessBean> modifyLoginPassword(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/app/student/ChangePaymentPassword")
    BaseBean<SuccessBean> modifyPayPassword(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/App/FaultReport/NewAddReports")
    BaseBean<SuccessBean> newAddReports(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @GET("/ZK_BSRS/repair/newAddReports")
    BaseBeanLow<SuccessBean> newAddReportsV3(@Query("sign") String str, @Query("wxcode") String str2, @Query(OapsKey.KEY_SUB_ID) String str3);

    @FormUrlEncoded
    @POST("/App/Student/NewRegister")
    BaseBean<UserInfoBean> newRegister(@Field("code") String str, @Field("sign") String str2, @Field("fileData") String str3);

    @FormUrlEncoded
    @POST("/App/Equipment/CancelNBMachine")
    BaseBean<SuccessBean> postCancelNBMachine(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/App/FaultReport/ConfirmFaultInfo")
    BaseBean<SuccessBean> postConfirmFaultInfo(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/App/Equipment/InitNBMachine")
    BaseBean<SuccessBean> postInitNBMachine(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/App/FaultReport/SubmitReportInfo")
    BaseBean<SuccessBean> postSubmitReportInfo(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/app/ewallet/refund")
    BaseBean<SuccessBean> refund(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/app/EWallet/Refund")
    BaseBean<SuccessBean> refund2(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/app/student/Register")
    BaseBean<UserInfoBean> register(@Field("code") String str, @Field("sign") String str2, @Field("fileData") String str3);

    @GET("/App/Student/PreGetBySchoolId")
    BaseBean<RegisterBefore> registerBeforeGetServerAddress(@Query("code") String str, @Query("sign") String str2);

    @FormUrlEncoded
    @POST("/app/student/ResetLoginPassword")
    BaseBean<SuccessBean> resetLoginPassword(@Field("code") String str, @Field("sign") String str2);

    @FormUrlEncoded
    @POST("/app/basic/SendSMSCaptcha")
    BaseBean<SuccessBean> sendSMSCaptcha(@Field("code") String str, @Field("sign") String str2);

    @FormUrlEncoded
    @POST("/App/student/SetAuthorizedPassword")
    BaseBean<HamamVerifyAuthPasswordSecurity> setShouQuanPassword(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/App/Equipment/StrappedDevice")
    BaseBean<SuccessBean> uninitHamam(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/App/Equipment/HandleConsumptionTimes")
    BaseBean<SuccessBean> updateConsumptionTimes(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/app/student/UpdateStudentInfo")
    BaseBean<NullBean> updateStudentInfo(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/app/ewallet/UploadBillConsume")
    BaseBean<SuccessBean> uploadBillConsume(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/App/EWallet/NewUploadBillConsume")
    BaseBean<OpenDataBean> uploadBillConsume2(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/app/Equipment/UploadEqStatus")
    BaseBean<SuccessBean> uploadEqStatus(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/app/student/UploadUserHeadPic")
    BaseBean<FileUploadBean> uploadImage(@Field("code") String str, @Field("sign") String str2, @Field("fileData") String str3);

    @FormUrlEncoded
    @POST("/App/FaultReport/UploadReportPics")
    BaseBean<RepairUploadReportPicsBean> uploadReportPics(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3, @Field("fileData") String str4);

    @FormUrlEncoded
    @POST("/app/Equipment/UploadFalutReprotProcess")
    BaseBean<SuccessBean> uploadReportProcess(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/app/basic/VerifySMSCaptcha")
    BaseBean<SuccessBean> verifySMSCaptcha(@Field("code") String str, @Field("sign") String str2);
}
