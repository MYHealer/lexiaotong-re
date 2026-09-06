package client.android.yixiaotong.util.http.protocol;

import client.android.yixiaotong.controller.bean.AeemterAuthorizeBean;
import client.android.yixiaotong.controller.bean.AmmeterAreaInfo;
import client.android.yixiaotong.controller.bean.AmmeterBindRoomBean;
import client.android.yixiaotong.controller.bean.AmmeterDestroyBean;
import client.android.yixiaotong.controller.bean.AmmeterEndBean;
import client.android.yixiaotong.controller.bean.AmmeterInitBean;
import client.android.yixiaotong.controller.bean.AmmeterPricesBean;
import client.android.yixiaotong.controller.bean.AmmeterRecordListBean;
import client.android.yixiaotong.controller.bean.AmmeterSettingBean;
import client.android.yixiaotong.controller.bean.AmmeterStateBean;
import client.android.yixiaotong.controller.bean.AmmeterSubsidyBean;
import client.android.yixiaotong.controller.bean.AmmeterWriteSettingBean;
import client.android.yixiaotong.controller.bean.HairDryerBean;
import client.android.yixiaotong.controller.bean.HairDryerOrderBean;
import client.android.yixiaotong.controller.bean.SoundWaveBean;
import client.android.yixiaotong.controller.bean.SoundWaveCardRecordListBean;
import client.android.yixiaotong.controller.bean.SoundWaveDrinkWaterCleanData;
import client.android.yixiaotong.controller.bean.SoundWaveDrinkWaterRecordListBean;
import client.android.yixiaotong.controller.bean.SoundWaveOrderBean;
import client.android.yixiaotong.controller.bean.SoundWaveOrderRecordBean;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.bean.bath.BathAuthBean;
import client.android.yixiaotong.controller.bean.bath.BathAuthNewBean;
import client.android.yixiaotong.controller.bean.bath.BathUploadOrderBean;
import client.android.yixiaotong.controller.bean.bath.BathUploadOrderNewBean;
import client.android.yixiaotong.controller.bean.doorlock.DLHACBean;
import client.android.yixiaotong.controller.bean.doorlock.DoorLockAddKeyBean;
import client.android.yixiaotong.controller.bean.doorlock.DoorLockAllUsersInfoBean;
import client.android.yixiaotong.controller.bean.doorlock.DoorLockChangeRoomRecordsBean;
import client.android.yixiaotong.controller.bean.doorlock.DoorLockInfoBean;
import client.android.yixiaotong.controller.bean.doorlock.DoorLockKeyInfos;
import client.android.yixiaotong.controller.bean.doorlock.DoorLockNotSyncKeys;
import client.android.yixiaotong.controller.bean.doorlock.DoorLockRecordsBean;
import client.android.yixiaotong.controller.bean.doorlock.SelectUserAuthenticationBean;
import client.android.yixiaotong.controller.bean.doorlock.SubmitUserInformationBean;
import client.android.yixiaotong.controller.bean.entranceguard.EGBindRoomInfo;
import client.android.yixiaotong.controller.bean.entranceguard.EGIsBindBean;
import client.android.yixiaotong.controller.bean.entranceguard.EGRoomDetailBean;
import client.android.yixiaotong.controller.bean.hamam.BathHousePasswordBean;
import client.android.yixiaotong.controller.bean.hamam.HamamBindBean;
import client.android.yixiaotong.controller.bean.hamam.HamamBindPreBean;
import client.android.yixiaotong.controller.bean.hamam.HamamDetailListBean;
import client.android.yixiaotong.controller.bean.hamam.HamamIsBindBean;
import client.android.yixiaotong.controller.bean.hamam.HamamRecordListBean;
import client.android.yixiaotong.controller.bean.hamam.HamamYuYueBean;
import client.android.yixiaotong.controller.bean.hamam.UnRegisterBathHouseBean;
import client.android.yixiaotong.controller.bean.init.SetNBDrinkWaterBean;
import client.android.yixiaotong.controller.bean.sellcard.SellCardAuthorizeBean;
import client.android.yixiaotong.controller.bean.sellcard.SellCardPriceBean;
import client.android.yixiaotong.controller.bean.wash.WashAuthorizeBean;
import client.android.yixiaotong.controller.bean.wash.WashGetMachineid;
import client.android.yixiaotong.controller.bean.wash.WashHistoryOrderBean;
import client.android.yixiaotong.controller.bean.wash.WashOrderBean;
import client.android.yixiaotong.controller.bean.wash.WashParametersBean;
import client.android.yixiaotong.util.http.bean.BaseBean;
import client.android.yixiaotong.util.retrofit.http.Field;
import client.android.yixiaotong.util.retrofit.http.FormUrlEncoded;
import client.android.yixiaotong.util.retrofit.http.GET;
import client.android.yixiaotong.util.retrofit.http.POST;
import client.android.yixiaotong.util.retrofit.http.Query;
import com.cdo.oaps.ad.OapsKey;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public interface BusinessHttpProtocolJava {
    @GET("/zk_ykt_api/washer/washerRead")
    BaseBean<WashParametersBean> GetAllWashParameters(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_ykt_api/washer/washerReadTool")
    BaseBean<WashParametersBean> GetAllWashParametersV1(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_ykt_api/app/lxtNoPayMonth/getLxtNoPayMonthInfo")
    BaseBean<AmmeterRecordListBean> GetAmmeterRecordList(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_ykt_api/app/xcMonth/getXCMonthInfo")
    BaseBean<SoundWaveCardRecordListBean> GetCardRecordList(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_ykt_api/app/getConsumeBill")
    BaseBean<SoundWaveDrinkWaterRecordListBean> GetDrinkWaterRecordList(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_ykt_api/app/getBillList")
    BaseBean<SoundWaveDrinkWaterRecordListBean> GetDrinkWaterRecordList2(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_bathhouse_api/bathHouse/getGGPList")
    BaseBean<HamamRecordListBean> GetHamamConsumeDetailList(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3, @Query("requestType") String str4);

    @GET("/zk_ykt_api/app/getWashBillList")
    BaseBean<SoundWaveCardRecordListBean> GetWashRecordList(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_ykt_api/washer/washerAuthority")
    BaseBean<WashAuthorizeBean> WashAuthorize(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_ykt_api/washer/washerInfoRead")
    BaseBean<WashGetMachineid> WashGetMachineid(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/zk_ykt_api/washer/washerInitV2")
    BaseBean<WashParametersBean> WashInit(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/zk_ykt_api/washer/washerInitEnd")
    BaseBean<WashParametersBean> WashInitFinish(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_ykt_api/washer/washerOrderV3")
    BaseBean<WashOrderBean> WashOrder(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_ykt_api/washer/washerSetOrder")
    BaseBean<WashOrderBean> WashOrderV1(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_ykt_api/washer/washerInfoUpdate")
    BaseBean<WashParametersBean> WashUpdateInit(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_ykt_api/washer/uploadOrderInfo")
    BaseBean<WashOrderBean> WashUpdateOrder(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_ykt_api/ammeter/ammeterAuthorize")
    BaseBean<AeemterAuthorizeBean> ammeterAuthorize(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_ykt_api/ammeter/ammeterDetails")
    BaseBean<AmmeterEndBean> ammeterDetails(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_ykt_api/ammeter/ammeterEnd")
    BaseBean<AmmeterEndBean> ammeterEnd(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_ykt_api/ammeter/ammeterIsBindRoom")
    BaseBean<AmmeterBindRoomBean> ammeterIsBindRoom(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_ykt_api/ammeter/ammeterRead")
    BaseBean<AmmeterSettingBean> ammeterReadInfo(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_ykt_api/ammeter/ammeterSales")
    BaseBean<AmmeterDestroyBean> ammeterSales(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_ykt_api/ammeter/ammterSalesEnd")
    BaseBean<AmmeterDestroyBean> ammeterSalesSuccess(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_ykt_api/ammeter/ammeterSubsidy")
    BaseBean<AmmeterSubsidyBean> ammeterSubsidy(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_ykt_api/ammeter/ammeterWrite")
    BaseBean<AmmeterWriteSettingBean> ammeterWriteInfo(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_ykt_api/ammeter/ammeterWriteEnd")
    BaseBean<AmmeterWriteSettingBean> ammeterWriteInfoSuccess(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/zk_bathhouse_api/bathHouse/bindBathHouseFront")
    BaseBean<HamamBindPreBean> bindBathHouseFront(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3, @Field("requestType") String str4);

    @FormUrlEncoded
    @POST("/zk_ykt_api/cardSales/cardSalesAuth")
    BaseBean<SellCardAuthorizeBean> cardSalesAuth(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_ykt_api/ammeter/ammeterInfoCollect")
    BaseBean<AmmeterStateBean> getAmmeterCollectionData(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_areainfo_api/areaInfo/getAreaForRoom")
    BaseBean<List<AmmeterAreaInfo>> getAmmeterGetAreaForRoom(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_areainfo_api/areaInfo/getAreaInfo")
    BaseBean<List<AmmeterAreaInfo>> getAmmeterGetAreaInfo(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_ykt_api/ammeter/ammeterInfoObtain")
    BaseBean<AmmeterStateBean> getAmmeterInfo(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_ykt_api/ammeter/ammeterInitEnd")
    BaseBean<AmmeterStateBean> getAmmeterInitSuccess(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_ykt_api/ammeter/ammeterChangeEnd")
    BaseBean<AmmeterStateBean> getAmmeterInitSuccess1(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_ykt_api/ammeter/ammeterGetPrice")
    BaseBean<AmmeterPricesBean> getAmmeterPrice(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_ykt_api/app/ammeterRecharge/getAmmeterRecharge")
    BaseBean<AmmeterRecordListBean> getAmmeterRecharge(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_ykt_api/ammeter/ammeterStatusInfo")
    BaseBean<AmmeterStateBean> getAmmeterState(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/zk_ykt_api/bathe/batheAuth")
    BaseBean<BathAuthBean> getBathAuth(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_bathhouse_api/basic/getPassword")
    BaseBean<BathHousePasswordBean> getBathHousePassword(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3, @Query(OapsKey.KEY_SUB_ID) String str4, @Query("requestType") String str5);

    @FormUrlEncoded
    @POST("/zk_ykt_api/bathe/batheSettlement")
    BaseBean<BathUploadOrderBean> getBathUploadOrder(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_ykt_api/app/getCardSalesList")
    BaseBean<SoundWaveCardRecordListBean> getCardSalesList(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_ykt_api/cardSales/getCardSalesPrice")
    BaseBean<SellCardPriceBean> getCardSalesPrice(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_bathhouse_api/bathHouse/changeBathHouse")
    BaseBean<UnRegisterBathHouseBean> getChangeBathHouse(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3, @Query(OapsKey.KEY_SUB_ID) String str4, @Query("requestType") String str5);

    @GET("/zk_entrance_api/KeyManagement/AddUserKey")
    BaseBean<DoorLockAddKeyBean> getDoorLockAddKey(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3, @Query(OapsKey.KEY_SUB_ID) String str4, @Query("requestType") String str5);

    @GET("/zk_entrance_api/KeyManagement/AddHardwareUser")
    BaseBean<SuccessBean> getDoorLockAddUserID(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3, @Query(OapsKey.KEY_SUB_ID) String str4, @Query("requestType") String str5);

    @GET("/zk_entrance_api/KeyManagement/SelectHardwareUsers")
    BaseBean<DoorLockAllUsersInfoBean> getDoorLockAllUserID(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3, @Query(OapsKey.KEY_SUB_ID) String str4, @Query("requestType") String str5);

    @GET("/zk_entrance_api/RoomManagement/ChangeRoom")
    BaseBean<SuccessBean> getDoorLockChangeRoom(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3, @Query(OapsKey.KEY_SUB_ID) String str4, @Query("requestType") String str5);

    @GET("/zk_entrance_api/RoomManagement/SelectChangeRoom")
    BaseBean<DoorLockChangeRoomRecordsBean> getDoorLockChangeRoomRecords(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3, @Query(OapsKey.KEY_SUB_ID) String str4, @Query("requestType") String str5);

    @GET("/zk_entrance_api/KeyManagement/DeleteUserKey")
    BaseBean<SuccessBean> getDoorLockDeleteKey(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3, @Query(OapsKey.KEY_SUB_ID) String str4, @Query("requestType") String str5);

    @GET("/zk_entrance_api/EncryptionManagement/DoorEncryptDataServiceV1")
    BaseBean<String> getDoorLockEntryptData(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3, @Query(OapsKey.KEY_SUB_ID) String str4, @Query("requestType") String str5);

    @GET("/zk_entrance_api/KeyManagement/SelectUserKeys")
    BaseBean<DoorLockKeyInfos> getDoorLockKeyInfo(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3, @Query(OapsKey.KEY_SUB_ID) String str4, @Query("requestType") String str5);

    @GET("/zk_entrance_api/KeyManagement/SelectNotSynchronizeUsers")
    BaseBean<DoorLockNotSyncKeys> getDoorLockNotSyncKeyInfo(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3, @Query(OapsKey.KEY_SUB_ID) String str4, @Query("requestType") String str5);

    @GET("/zk_entrance_api/DataManagement/SelectUnlockRecords")
    BaseBean<DoorLockRecordsBean> getDoorLockRecords(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3, @Query(OapsKey.KEY_SUB_ID) String str4, @Query("requestType") String str5);

    @GET("/zk_equipment_api/Entrance/UploadHardwareRunningStatus")
    BaseBean<SuccessBean> getDoorLockStatus(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3, @Query(OapsKey.KEY_SUB_ID) String str4, @Query("requestType") String str5);

    @GET("/zk_entrance_api/KeyManagement/SynchronousUserKey")
    BaseBean<SuccessBean> getDoorLockSyncKey(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3, @Query(OapsKey.KEY_SUB_ID) String str4, @Query("requestType") String str5);

    @GET("/zk_entrance_api/KeyManagement/SynchronousUser")
    BaseBean<SuccessBean> getDoorLockSyncUserID(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3, @Query(OapsKey.KEY_SUB_ID) String str4, @Query("requestType") String str5);

    @GET("/zk_entrance_api/KeyManagement/UpdateUserPassword")
    BaseBean<DoorLockAddKeyBean> getDoorLockUpdateKey(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3, @Query(OapsKey.KEY_SUB_ID) String str4, @Query("requestType") String str5);

    @GET("/zk_entrance_api/KeyManagement/UpdateUserKeyName")
    BaseBean<SuccessBean> getDoorLockUpdateKeyName(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3, @Query(OapsKey.KEY_SUB_ID) String str4, @Query("requestType") String str5);

    @GET("/zk_entrance_api/DataManagement/UploadUnlockRecords")
    BaseBean<SuccessBean> getDoorLockUploadRecords(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3, @Query(OapsKey.KEY_SUB_ID) String str4, @Query("requestType") String str5);

    @GET("/zk_entrance_api/UserAuthentication/SelectUserAuthentication")
    BaseBean<DoorLockInfoBean> getDoorLockUserInfo(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3, @Query(OapsKey.KEY_SUB_ID) String str4, @Query("requestType") String str5);

    @GET("/zk_areainfo_api/areaInfo/getAreaInfo")
    BaseBean<List<AmmeterAreaInfo>> getEntranceGuardGetAreaInfo(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_areainfo_api/areaInfo/getAreaInfoAll")
    BaseBean<EGRoomDetailBean> getEntranceGuardGetAreaInfoAll(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/zk_areainfo_api/studentRoom/isBind")
    BaseBean<EGIsBindBean> getEntranceGuardIsBind(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/zk_areainfo_api/studentRoom/unbind")
    BaseBean<EGBindRoomInfo> getEntranceGuardUnBindingRoom(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_entrance_api/EncryptionManagement/GetHacAndEacByUserId")
    BaseBean<DLHACBean> getHAC(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3, @Query(OapsKey.KEY_SUB_ID) String str4, @Query("requestType") String str5);

    @FormUrlEncoded
    @POST("/zk_areainfo_api/studentBathHouse/bind")
    BaseBean<HamamBindBean> getHamamBindingRoom(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3, @Field("requestType") String str4);

    @GET("/zk_bathhouse_api/bathHouse/getBathHouseList")
    BaseBean<List<HamamDetailListBean>> getHamamDetail(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3, @Query("requestType") String str4);

    @GET("/zk_areainfo_api/studentBathHouse/isbind")
    BaseBean<HamamIsBindBean> getHamamIsBind(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3, @Query("requestType") String str4);

    @GET("/zk_bathhouse_api/bathHouse/isReserve")
    BaseBean<HamamYuYueBean> getHamamIsYuYue(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3, @Query("requestType") String str4);

    @FormUrlEncoded
    @POST("/zk_areainfo_api/studentBathHouse/unbind")
    BaseBean<SuccessBean> getHamamUnBindingRoom(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3, @Field("requestType") String str4);

    @FormUrlEncoded
    @POST("/zk_bathhouse_api/bathHouse/reserve")
    BaseBean<HamamYuYueBean> getHamamYuYue(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3, @Field("requestType") String str4);

    @GET("/zk_ykt_api/ammeter/ammeterInit")
    BaseBean<AmmeterInitBean> getInitAmmeter(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_entrance_api/UserAuthentication/SelectUserAuthenticationStatus")
    BaseBean<SelectUserAuthenticationBean> getSelectUserAuthenticationStatus(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3, @Query(OapsKey.KEY_SUB_ID) String str4, @Query("requestType") String str5);

    @GET("/zk_ykt_api/app/student/GetSoundwaveProtocol")
    BaseBean<SoundWaveBean> getSoundWave(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_ykt_api/app/UpdateMacInfoForREC")
    BaseBean<WashHistoryOrderBean> getSoundWaveCardUpdateInfoREC(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_ykt_api/machine/machineInit")
    BaseBean<SoundWaveDrinkWaterCleanData> getSoundWaveDrinkWaterCleanData(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/zk_ykt_api/hairy/hairyAuth")
    BaseBean<HairDryerBean> getSoundWaveHairDryer(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/zk_ykt_api/hairy/hairyOrder")
    BaseBean<HairDryerOrderBean> getSoundWaveHairDryerOrder(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_ykt_api/app/order/Javatransfer")
    BaseBean<SoundWaveOrderBean> getSoundWaveOrder(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_ykt_api/app/student/SoundwaveREC")
    BaseBean<SoundWaveBean> getSoundWaveREC(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_ykt_api/app/student/SoundwaveCON")
    BaseBean<SoundWaveBean> getSoundWaveWater(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_ykt_api/app/student/ProductedWater")
    BaseBean<SoundWaveOrderBean> getSoundWaveWaterOrder(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/zk_ykt_api/app/UpdateMacInfoForCON")
    BaseBean<SoundWaveOrderRecordBean> getSoundWaveWaterOrderRecord(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_ykt_api/machine/importDrinkingInfo")
    BaseBean<SoundWaveDrinkWaterCleanData> getSoundWaveWaterSettingData(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/zk_ykt_api/cardSales/UpdateMacForSalesCard")
    BaseBean<WashHistoryOrderBean> getUpdateMacForSalesCard(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_ykt_api/washer/updateWasherAuth")
    BaseBean<WashHistoryOrderBean> getWashUpdateInfoREC(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @GET("/zk_ykt_api/machine/machineInitApplets")
    BaseBean<SoundWaveDrinkWaterCleanData> getXiZaoCleanData(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3);

    @FormUrlEncoded
    @POST("/zk_bathhouse_api/bathe/batheAuth")
    BaseBean<BathAuthNewBean> postBatheAuth(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3, @Field(OapsKey.KEY_SUB_ID) String str4, @Field("requestType") String str5);

    @FormUrlEncoded
    @POST("/zk_bathhouse_api/bathe/batheAuthAnalysis")
    BaseBean<BathUploadOrderNewBean> postBatheAuthAnalysis(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3, @Field(OapsKey.KEY_SUB_ID) String str4, @Field("requestType") String str5);

    @FormUrlEncoded
    @POST("/zk_bathhouse_api/basic/NewChangeAuthorizedPassword")
    BaseBean<BathHousePasswordBean> postChangeAuthorizedPassword(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3, @Field(OapsKey.KEY_SUB_ID) String str4, @Field("requestType") String str5);

    @FormUrlEncoded
    @POST("/zk_bathhouse_api/common/commIotAuth")
    BaseBean<BathAuthNewBean> postCommIotAuth(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3, @Field(OapsKey.KEY_SUB_ID) String str4, @Field("requestType") String str5);

    @FormUrlEncoded
    @POST("/zk_bathhouse_api/common/commIotAuthAnalysis")
    BaseBean<BathUploadOrderNewBean> postCommIotAuthAnalysis(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3, @Field(OapsKey.KEY_SUB_ID) String str4, @Field("requestType") String str5);

    @FormUrlEncoded
    @POST("/zk_bathhouse_api/machine/deviceConfiguration")
    BaseBean<SetNBDrinkWaterBean> postDeviceConfiguration(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3, @Field(OapsKey.KEY_SUB_ID) String str4, @Field("requestType") String str5);

    @GET("/zk_bathhouse_api/bathHouse/logoutBathHouse")
    BaseBean<UnRegisterBathHouseBean> postLogoutBathHouse(@Query("code") String str, @Query("sign") String str2, @Query(OapsKey.KEY_TOKEN) String str3, @Query(OapsKey.KEY_SUB_ID) String str4, @Query("requestType") String str5);

    @FormUrlEncoded
    @POST("/zk_bathhouse_api/basic/NewSetAuthorizedPassword")
    BaseBean<BathHousePasswordBean> postSetAuthorizedPassword(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3, @Field(OapsKey.KEY_SUB_ID) String str4, @Field("requestType") String str5);

    @FormUrlEncoded
    @POST("/zk_entrance_api/UserAuthentication/SubmitUserInformation")
    BaseBean<SubmitUserInformationBean> postSubmitUserInformation(@Field("code") String str, @Field("sign") String str2, @Field(OapsKey.KEY_TOKEN) String str3, @Field(OapsKey.KEY_SUB_ID) String str4, @Field("requestType") String str5);
}
