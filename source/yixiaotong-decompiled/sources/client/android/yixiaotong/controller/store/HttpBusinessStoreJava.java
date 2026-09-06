package client.android.yixiaotong.controller.store;

import android.util.Log;
import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.account.Account;
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
import client.android.yixiaotong.controller.bean.doorlock.DLKeyBean;
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
import client.android.yixiaotong.exception.DBException;
import client.android.yixiaotong.exception.HttpException;
import client.android.yixiaotong.ui.RechargeRecordActivity;
import client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity;
import client.android.yixiaotong.util.AESHelper;
import client.android.yixiaotong.util.MD5;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.android.LocalPreferencesHelper;
import client.android.yixiaotong.util.http.HttpProtocolFactoryJava;
import client.android.yixiaotong.util.http.bean.BaseBean;
import client.android.yixiaotong.util.http.protocol.BusinessHttpProtocolJava;
import client.android.yixiaotong.v3.util.LogUtil;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.cdo.oaps.ad.OapsKey;
import com.google.gson.Gson;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.umeng.analytics.pro.am;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class HttpBusinessStoreJava {
    private static final String TAG = "HttpBusinessStoreJava";
    private BusinessHttpProtocolJava mProtocolTest;

    public HttpBusinessStoreJava(Account account) {
    }

    public void getServer() {
        String string = new LocalPreferencesHelper(BaseApplication.app, "localserveraddress").getString("localjavaserver");
        if (StringUtils.isNotEmpty(string)) {
            this.mProtocolTest = (BusinessHttpProtocolJava) HttpProtocolFactoryJava.getInstance().getProtocol(string, BusinessHttpProtocolJava.class);
        } else {
            this.mProtocolTest = (BusinessHttpProtocolJava) HttpProtocolFactoryJava.getInstance().getProtocol(HttpComfigUtil.SERVER_PREJAVA_HOST, BusinessHttpProtocolJava.class);
        }
    }

    public SoundWaveBean SoundWave(String str, long j, String str2, String str3, int i, String str4, String str5, String str6, String str7, int i2, int i3, int i4, int i5) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentId", j + "").combind("machineId", str2 + "").combind(AmmeterWalletDetailActivity.EXTRA_ORDERID, str3 + "").combind("managerflag", i + "").combind("machineInfo", str4 + "").combind("machinetime", str5 + "").combind("machineData", str6 + "").combind("randomData", str7 + "").combind(RechargeRecordActivity.EXTRA_TYPEID, i2 + "").combind("cardtype", i3 + "").combind("alleywaytype", i4 + "").combind("version", i5 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<SoundWaveBean> soundWave = this.mProtocolTest.getSoundWave(code, sign, str);
            if (soundWave.ok()) {
                return soundWave.Data;
            }
            throw HttpException.filter(soundWave.Code, soundWave.getErrMsg(), soundWave.Data, soundWave.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SoundWaveBean SoundWave1(String str, long j, String str2, String str3, int i, String str4, String str5, long j2, int i2, int i3, int i4, String str6, int i5) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentId", j + "").combind("schoolid", str2 + "").combind(AmmeterWalletDetailActivity.EXTRA_ORDERID, str3 + "").combind("managerflag", i + "").combind("machineid", str4 + "").combind("machinedata", str5 + "").combind("applicationId", j2 + "").combind(RechargeRecordActivity.EXTRA_TYPEID, i2 + "").combind("cardtype", i3 + "").combind("alleywaytype", i4 + "").combind("rand", str6).combind("version", i5 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<SoundWaveBean> soundWaveREC = this.mProtocolTest.getSoundWaveREC(code, sign, str);
            if (soundWaveREC.ok()) {
                return soundWaveREC.Data;
            }
            throw HttpException.filter(soundWaveREC.Code, soundWaveREC.getErrMsg(), soundWaveREC.Data, soundWaveREC.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public WashHistoryOrderBean SoundWaveCardUpdateInfo(String str, String str2, int i, String str3, String str4, int i2, String str5, boolean z) throws HttpException {
        BaseBean<WashHistoryOrderBean> washUpdateInfoREC;
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("schoolid", str2 + "").combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("alleywaytype", "1").combind("cardtype", "1").combind("machineid", str3 + "").combind("machinedata", str4 + "").combind("version", i2 + "").combind("rand", str5 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.e(TAG, code + "  " + sign);
            LogUtil.log(combindBean.toString());
            if (z) {
                washUpdateInfoREC = this.mProtocolTest.getSoundWaveCardUpdateInfoREC(code, sign, str);
            } else {
                washUpdateInfoREC = this.mProtocolTest.getWashUpdateInfoREC(code, sign, str);
            }
            if (washUpdateInfoREC.ok()) {
                return washUpdateInfoREC.Data;
            }
            throw HttpException.filter(washUpdateInfoREC.Code, washUpdateInfoREC.getErrMsg(), washUpdateInfoREC.Data, washUpdateInfoREC.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SoundWaveOrderBean SoundWaveOrder(String str, long j, String str2, String str3, int i, String str4, String str5, long j2, String str6, int i2, int i3, String str7) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentId", j + "").combind("schoolid", str2 + "").combind("mobile", str3 + "").combind("appway", i + "").combind(AmmeterWalletDetailActivity.EXTRA_ORDERID, str4 + "").combind("apptime", str5 + "").combind("applicationId", j2 + "").combind(RechargeRecordActivity.EXTRA_TYPEID, i3 + "").combind("machineid", str7).combind("deviceType", str6 + "").combind("totalPrice", i2 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<SoundWaveOrderBean> soundWaveOrder = this.mProtocolTest.getSoundWaveOrder(code, sign, str);
            if (soundWaveOrder.ok()) {
                return soundWaveOrder.Data;
            }
            throw HttpException.filter(soundWaveOrder.Code, soundWaveOrder.getErrMsg(), soundWaveOrder.Data, soundWaveOrder.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SoundWaveCardRecordListBean getCardRecordList(String str, long j, int i, int i2, String str2, String str3) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            if (i <= 0) {
                combindBean.combind("studentId", j + "").combind("typeId", i + "").combind("pageIndex", i2 + "").combind("status", str2).combind("machineid", str3);
            } else {
                combindBean.combind("studentId", j + "").combind("typeId", i + "").combind("pageIndex", i2 + "").combind("status", str2).combind("machineid", str3);
            }
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<SoundWaveCardRecordListBean> baseBeanGetCardRecordList = this.mProtocolTest.GetCardRecordList(code, sign, str);
            if (baseBeanGetCardRecordList.ok()) {
                return baseBeanGetCardRecordList.Data;
            }
            throw HttpException.filter(baseBeanGetCardRecordList.Code, baseBeanGetCardRecordList.getErrMsg(), baseBeanGetCardRecordList.Data, baseBeanGetCardRecordList.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SoundWaveDrinkWaterRecordListBean getCardDrinkWaterHasUnFinishOrderRecordList(String str, String str2, String str3, long j, int i, int i2) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentId", j + "").combind("status", str2 + "").combind("machineid", str3 + "").combind("typeId", i + "").combind("pageIndex", i2 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<SoundWaveDrinkWaterRecordListBean> baseBeanGetDrinkWaterRecordList = this.mProtocolTest.GetDrinkWaterRecordList(code, sign, str);
            if (baseBeanGetDrinkWaterRecordList.ok()) {
                return baseBeanGetDrinkWaterRecordList.Data;
            }
            throw HttpException.filter(baseBeanGetDrinkWaterRecordList.Code, baseBeanGetDrinkWaterRecordList.getErrMsg(), baseBeanGetDrinkWaterRecordList.Data, baseBeanGetDrinkWaterRecordList.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SoundWaveDrinkWaterRecordListBean getDrinkWaterRecordList2(String str, long j, int i, int i2, int i3, String str2, String str3, String str4) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentId", j + "").combind("typeId", i + "").combind("pageIndex", i2 + "").combind("orderrule", i3 + "");
            if (StringUtils.isNotEmpty(str3) && StringUtils.isNotEmpty(str4)) {
                combindBean.combind("status", str3).combind("machineid", str4);
            }
            if (i3 == 4) {
                combindBean.combind("beforeMonth", str2);
            }
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<SoundWaveDrinkWaterRecordListBean> baseBeanGetDrinkWaterRecordList2 = this.mProtocolTest.GetDrinkWaterRecordList2(code, sign, str);
            if (baseBeanGetDrinkWaterRecordList2.ok()) {
                return baseBeanGetDrinkWaterRecordList2.Data;
            }
            throw HttpException.filter(baseBeanGetDrinkWaterRecordList2.Code, baseBeanGetDrinkWaterRecordList2.getErrMsg(), baseBeanGetDrinkWaterRecordList2.Data, baseBeanGetDrinkWaterRecordList2.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public HairDryerOrderBean SoundWaveHairDryerOrder(String str, long j, long j2, String str2, int i, String str3, int i2, String str4, long j3, int i3, int i4, String str5, String str6) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentid", j + "").combind("schoolid", j2 + "").combind("mobile", str2 + "").combind("appway", i + "").combind(AmmeterWalletDetailActivity.EXTRA_ORDERID, str3 + "").combind(RechargeRecordActivity.EXTRA_TYPEID, i2 + "").combind("apptime", str4 + "").combind("applicationid", j3 + "").combind("deviceType", i3 + "").combind("whpay", i4 + "").combind("machineid", str5).combind("rand", str6);
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<HairDryerOrderBean> soundWaveHairDryerOrder = this.mProtocolTest.getSoundWaveHairDryerOrder(code, sign, str);
            if (soundWaveHairDryerOrder.ok()) {
                return soundWaveHairDryerOrder.Data;
            }
            throw HttpException.filter(soundWaveHairDryerOrder.Code, soundWaveHairDryerOrder.getErrMsg(), soundWaveHairDryerOrder.Data, soundWaveHairDryerOrder.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public HairDryerBean SoundWaveHairDryer(String str, long j, long j2, String str2, int i, String str3, String str4, int i2, int i3, int i4, long j3, int i5, String str5) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentid", j + "").combind("schoolid", j2 + "").combind(AmmeterWalletDetailActivity.EXTRA_ORDERID, str2 + "").combind("managerflag", i + "").combind("machineid", str3 + "").combind("machinedata", str4 + "").combind(RechargeRecordActivity.EXTRA_TYPEID, i2 + "").combind("alleywaytype", i3 + "").combind("version", i4 + "").combind("applicationid", j3 + "").combind("whpay", i5 + "").combind("rand", str5 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<HairDryerBean> soundWaveHairDryer = this.mProtocolTest.getSoundWaveHairDryer(code, sign, str);
            if (soundWaveHairDryer.ok()) {
                return soundWaveHairDryer.Data;
            }
            throw HttpException.filter(soundWaveHairDryer.Code, soundWaveHairDryer.getErrMsg(), soundWaveHairDryer.Data, soundWaveHairDryer.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SoundWaveOrderBean SoundWaveWaterOrder(String str, long j, long j2, String str2, int i, String str3, int i2, String str4, long j3, int i3, int i4, String str5) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentId", j + "").combind("schoolid", j2 + "").combind("mobile", str2 + "").combind("appway", i + "").combind(AmmeterWalletDetailActivity.EXTRA_ORDERID, str3 + "").combind(RechargeRecordActivity.EXTRA_TYPEID, i2 + "").combind("apptime", str4 + "").combind("applicationId", j3 + "").combind("deviceType", i3 + "").combind("whpay", i4 + "").combind("machineid", str5);
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<SoundWaveOrderBean> soundWaveWaterOrder = this.mProtocolTest.getSoundWaveWaterOrder(code, sign, str);
            if (soundWaveWaterOrder.ok()) {
                return soundWaveWaterOrder.Data;
            }
            throw HttpException.filter(soundWaveWaterOrder.Code, soundWaveWaterOrder.getErrMsg(), soundWaveWaterOrder.Data, soundWaveWaterOrder.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SoundWaveBean SoundWaveWater(String str, long j, long j2, String str2, int i, String str3, String str4, int i2, int i3, int i4, long j3, int i5, String str5) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentId", j + "").combind("schoolid", j2 + "").combind("orderId", str2 + "").combind("managerflag", i + "").combind("machineid", str3 + "").combind("machinedata", str4 + "").combind(RechargeRecordActivity.EXTRA_TYPEID, i2 + "").combind("alleywaytype", i3 + "").combind("version", i4 + "").combind("applicationId", j3 + "").combind("whpay", i5 + "").combind("rand", str5 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<SoundWaveBean> soundWaveWater = this.mProtocolTest.getSoundWaveWater(code, sign, str);
            if (soundWaveWater.ok()) {
                return soundWaveWater.Data;
            }
            throw HttpException.filter(soundWaveWater.Code, soundWaveWater.getErrMsg(), soundWaveWater.Data, soundWaveWater.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SoundWaveOrderRecordBean SoundWaveWaterOrderRecord(String str, long j, int i, int i2, long j2, String str2, String str3, int i3, String str4) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("schoolid", j + "").combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("alleywaytype", i2 + "").combind("studentid", j2 + "").combind("machineid", str2 + "").combind("machinedata", str3 + "").combind("version", i3 + "").combind("rand", str4 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.e(TAG, combindBean.returnStr);
            LogUtil.log(combindBean.toString());
            BaseBean<SoundWaveOrderRecordBean> soundWaveWaterOrderRecord = this.mProtocolTest.getSoundWaveWaterOrderRecord(code, sign, str);
            if (soundWaveWaterOrderRecord.ok()) {
                return soundWaveWaterOrderRecord.Data;
            }
            throw HttpException.filter(soundWaveWaterOrderRecord.Code, soundWaveWaterOrderRecord.getErrMsg(), soundWaveWaterOrderRecord.Data, soundWaveWaterOrderRecord.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SoundWaveDrinkWaterCleanData SoundWaveWaterCleanData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("investorid", str2 + "").combind(RechargeRecordActivity.EXTRA_TYPEID, str3 + "").combind("alleywaytype", str4 + "").combind("studentid", str5 + "").combind("machineid", str6 + "").combind("machinedata", str7 + "").combind("machineflag", str8 + "").combind("alleywaytype", str4 + "").combind("version", str9 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<SoundWaveDrinkWaterCleanData> soundWaveDrinkWaterCleanData = this.mProtocolTest.getSoundWaveDrinkWaterCleanData(code, sign, str);
            if (soundWaveDrinkWaterCleanData.ok()) {
                return soundWaveDrinkWaterCleanData.Data;
            }
            throw HttpException.filter(soundWaveDrinkWaterCleanData.Code, soundWaveDrinkWaterCleanData.getErrMsg(), soundWaveDrinkWaterCleanData.Data, soundWaveDrinkWaterCleanData.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SoundWaveDrinkWaterCleanData SoundWaveWaterSettingData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("investorid", str2 + "").combind(RechargeRecordActivity.EXTRA_TYPEID, str3 + "").combind("alleywaytype", str4 + "").combind("studentid", str5 + "").combind("machineid", str6 + "").combind("machinedata", str7 + "").combind("machineflag", str8 + "").combind("alleywaytype", str4 + "").combind("regtime", str9 + "").combind("registrant", str10 + "").combind("schoolid", str11 + "").combind("version", str12 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<SoundWaveDrinkWaterCleanData> soundWaveWaterSettingData = this.mProtocolTest.getSoundWaveWaterSettingData(code, sign, str);
            if (soundWaveWaterSettingData.ok()) {
                return soundWaveWaterSettingData.Data;
            }
            throw HttpException.filter(soundWaveWaterSettingData.Code, soundWaveWaterSettingData.getErrMsg(), soundWaveWaterSettingData.Data, soundWaveWaterSettingData.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public AeemterAuthorizeBean ammeterAuthorize(String str, long j, String str2, int i, String str3, int i2, int i3, String str4, int i4, String str5, String str6, String str7) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentid", j + "").combind("schoolid", str2 + "").combind("managerflag", i + "").combind("machineid", str3 + "").combind(RechargeRecordActivity.EXTRA_TYPEID, i2 + "").combind("alleywaytype", i3 + "").combind("rand", str4 + "").combind("version", i4 + "").combind(AmmeterWalletDetailActivity.EXTRA_ORDERID, str5 + "").combind("i4_2", str6 + "").combind("i8_1", str7 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            LogUtil.e(TAG, combindBean.toString());
            BaseBean<AeemterAuthorizeBean> baseBeanAmmeterAuthorize = this.mProtocolTest.ammeterAuthorize(code, sign, str);
            if (baseBeanAmmeterAuthorize.ok()) {
                return baseBeanAmmeterAuthorize.Data;
            }
            throw HttpException.filter(baseBeanAmmeterAuthorize.Code, baseBeanAmmeterAuthorize.getErrMsg(), baseBeanAmmeterAuthorize.Data, baseBeanAmmeterAuthorize.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public AmmeterSubsidyBean ammeterSubsidy(String str, String str2, long j, String str3, String str4, String str5, int i, String str6, int i2) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind(AmmeterWalletDetailActivity.EXTRA_ORDERID, str2 + "").combind("studentid", j + "").combind("createusename", str3 + "").combind("rand", str4 + "").combind("apptime", str5 + "").combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("schoolid", str6 + "").combind("payflag", i2 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<AmmeterSubsidyBean> baseBeanAmmeterSubsidy = this.mProtocolTest.ammeterSubsidy(code, sign, str);
            if (baseBeanAmmeterSubsidy.ok()) {
                return baseBeanAmmeterSubsidy.Data;
            }
            throw HttpException.filter(baseBeanAmmeterSubsidy.Code, baseBeanAmmeterSubsidy.getErrMsg(), baseBeanAmmeterSubsidy.Data, baseBeanAmmeterSubsidy.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public AmmeterRecordListBean getAmmeterRecordList(String str, long j, int i, int i2) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentid", j + "").combind("typeId", i + "").combind("pageIndex", i2 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<AmmeterRecordListBean> ammeterRecharge = this.mProtocolTest.getAmmeterRecharge(code, sign, str);
            if (ammeterRecharge.ok()) {
                return ammeterRecharge.Data;
            }
            throw HttpException.filter(ammeterRecharge.Code, ammeterRecharge.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public AmmeterRecordListBean getAmmeterButieRecordList(String str, String str2, int i, int i2) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            if (i <= 0) {
                combindBean.combind("roomid", str2 + "").combind("typeId", i + "").combind("pageIndex", i2 + "");
            } else {
                combindBean.combind("roomid", str2 + "").combind("typeId", i + "").combind("pageIndex", i2 + "");
            }
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<AmmeterRecordListBean> baseBeanGetAmmeterRecordList = this.mProtocolTest.GetAmmeterRecordList(code, sign, str);
            if (baseBeanGetAmmeterRecordList.ok()) {
                return baseBeanGetAmmeterRecordList.Data;
            }
            throw HttpException.filter(baseBeanGetAmmeterRecordList.Code, baseBeanGetAmmeterRecordList.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public AmmeterEndBean ammeterEnd(String str, String str2, String str3, String str4, String str5) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind(AmmeterWalletDetailActivity.EXTRA_ORDERID, str2 + "").combind("machineid", str3 + "").combind("i4_2", str4 + "").combind("i8_1", str5 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<AmmeterEndBean> baseBeanAmmeterEnd = this.mProtocolTest.ammeterEnd(code, sign, str);
            if (baseBeanAmmeterEnd.ok()) {
                return baseBeanAmmeterEnd.Data;
            }
            throw HttpException.filter(baseBeanAmmeterEnd.Code, baseBeanAmmeterEnd.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public AmmeterEndBean ammeterDetails(String str, String str2, String str3, String str4, String str5) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("machineid", str2 + "").combind("rand", str3 + "").combind("i4_2", str4 + "").combind("i8_1", str5 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<AmmeterEndBean> baseBeanAmmeterDetails = this.mProtocolTest.ammeterDetails(code, sign, str);
            if (baseBeanAmmeterDetails.ok()) {
                return baseBeanAmmeterDetails.Data;
            }
            throw HttpException.filter(baseBeanAmmeterDetails.Code, baseBeanAmmeterDetails.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public AmmeterPricesBean ammeterGetPrice(String str, String str2, String str3) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("shoolid", str2 + "").combind("rand", str3);
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<AmmeterPricesBean> ammeterPrice = this.mProtocolTest.getAmmeterPrice(code, sign, str);
            if (ammeterPrice.ok()) {
                return ammeterPrice.Data;
            }
            throw HttpException.filter(ammeterPrice.Code, ammeterPrice.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public AmmeterInitBean ammeterInit(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i, String str12) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("deivceid", str2 + "").combind(RechargeRecordActivity.EXTRA_TYPEID, str3 + "").combind("investorid", str4 + "").combind("schoolid", str5 + "").combind("registrant", str6 + "").combind("regtime", str7 + "").combind("rid", str8 + "").combind("cnflag", "1").combind("devicemac", str9 + "").combind("devicename", str10.replace(PPSLabelView.Code, "")).combind("rand", str11).combind(OapsKey.KEY_PRICE, i + "").combind("code", str12);
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<AmmeterInitBean> initAmmeter = this.mProtocolTest.getInitAmmeter(code, sign, str);
            if (initAmmeter.ok()) {
                return initAmmeter.Data;
            }
            throw HttpException.filter(initAmmeter.Code, initAmmeter.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public AmmeterStateBean ammeterState(String str, String str2, String str3) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("deviceid", str2 + "").combind("rand", str3);
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<AmmeterStateBean> ammeterState = this.mProtocolTest.getAmmeterState(code, sign, str);
            if (ammeterState.ok()) {
                return ammeterState.Data;
            }
            throw HttpException.filter(ammeterState.Code, ammeterState.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public AmmeterStateBean ammeterInfo(String str, String str2, String str3, String str4) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("rid", str2 + "").combind("rand", str3).combind("machineid", str4);
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<AmmeterStateBean> ammeterInfo = this.mProtocolTest.getAmmeterInfo(code, sign, str);
            if (ammeterInfo.ok()) {
                return ammeterInfo.Data;
            }
            throw HttpException.filter(ammeterInfo.Code, ammeterInfo.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public AmmeterStateBean ammeterCollectionData(String str, String str2, String str3, String str4, String str5, String str6, String str7) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("registrant", str2).combind("rid", str3 + "").combind("rand", str4).combind("machineid", str5).combind("i4_2", str6).combind("i8_1", str7);
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<AmmeterStateBean> ammeterCollectionData = this.mProtocolTest.getAmmeterCollectionData(code, sign, str);
            if (ammeterCollectionData.ok()) {
                return ammeterCollectionData.Data;
            }
            throw HttpException.filter(ammeterCollectionData.Code, ammeterCollectionData.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public AmmeterStateBean ammeterInitSuccess(String str, String str2, String str3, String str4, long j, int i) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("machineid", str2 + "").combind("rid", str3).combind("rand", str4).combind("schoolid", j + "").combind(RechargeRecordActivity.EXTRA_TYPEID, i + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<AmmeterStateBean> ammeterInitSuccess = this.mProtocolTest.getAmmeterInitSuccess(code, sign, str);
            if (ammeterInitSuccess.ok()) {
                return ammeterInitSuccess.Data;
            }
            throw HttpException.filter(ammeterInitSuccess.Code, ammeterInitSuccess.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public AmmeterStateBean ammeterInitSuccess1(String str, String str2, String str3, String str4, long j, int i) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("machineid", str2 + "").combind("rid", str3).combind("rand", str4).combind("schoolid", j + "").combind(RechargeRecordActivity.EXTRA_TYPEID, i + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<AmmeterStateBean> ammeterInitSuccess1 = this.mProtocolTest.getAmmeterInitSuccess1(code, sign, str);
            if (ammeterInitSuccess1.ok()) {
                return ammeterInitSuccess1.Data;
            }
            throw HttpException.filter(ammeterInitSuccess1.Code, ammeterInitSuccess1.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public AmmeterDestroyBean ammeterSales(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("devicemac", str2 + "").combind("i4_2", str3 + "").combind("deivceid", str4 + "").combind("i8_1", str5 + "").combind("deivcetime", str6 + "").combind("logoutman", str7 + "").combind("logouttime", str8 + "").combind("rand", str9).combind("machineid", str10);
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<AmmeterDestroyBean> baseBeanAmmeterSales = this.mProtocolTest.ammeterSales(code, sign, str);
            if (baseBeanAmmeterSales.ok()) {
                return baseBeanAmmeterSales.Data;
            }
            throw HttpException.filter(baseBeanAmmeterSales.Code, baseBeanAmmeterSales.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public AmmeterDestroyBean ammeterSalesSuccess(String str, String str2, String str3, String str4, String str5) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("machineid", str2 + "").combind("rand", str3).combind("devicemac", str4 + "").combind(AmmeterWalletDetailActivity.EXTRA_DEVICENO, str5);
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<AmmeterDestroyBean> baseBeanAmmeterSalesSuccess = this.mProtocolTest.ammeterSalesSuccess(code, sign, str);
            if (baseBeanAmmeterSalesSuccess.ok()) {
                return baseBeanAmmeterSalesSuccess.Data;
            }
            throw HttpException.filter(baseBeanAmmeterSalesSuccess.Code, baseBeanAmmeterSalesSuccess.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public List<AmmeterAreaInfo> ammeterGetAreaInfo(String str, String str2) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("id", str2 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<List<AmmeterAreaInfo>> ammeterGetAreaInfo = this.mProtocolTest.getAmmeterGetAreaInfo(code, sign, str);
            if (ammeterGetAreaInfo.ok()) {
                return ammeterGetAreaInfo.Data;
            }
            throw HttpException.filter(ammeterGetAreaInfo.Code, ammeterGetAreaInfo.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public List<AmmeterAreaInfo> ammeterGetAreaForRoom(String str, String str2) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("id", str2 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<List<AmmeterAreaInfo>> ammeterGetAreaForRoom = this.mProtocolTest.getAmmeterGetAreaForRoom(code, sign, str);
            if (ammeterGetAreaForRoom.ok()) {
                return ammeterGetAreaForRoom.Data;
            }
            throw HttpException.filter(ammeterGetAreaForRoom.Code, ammeterGetAreaForRoom.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public AmmeterSettingBean ammeterReadInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("i4_2", str2 + "").combind("i8_1", str3 + "").combind("machineid", str4 + "").combind("schoolid", str5 + "").combind("s1", str6 + "").combind("rand", str7);
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<AmmeterSettingBean> baseBeanAmmeterReadInfo = this.mProtocolTest.ammeterReadInfo(code, sign, str);
            if (baseBeanAmmeterReadInfo.ok()) {
                return baseBeanAmmeterReadInfo.Data;
            }
            throw HttpException.filter(baseBeanAmmeterReadInfo.Code, baseBeanAmmeterReadInfo.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public AmmeterWriteSettingBean ammeterWriteInfo(String str, String str2, String str3, String str4) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("machineid", str2 + "").combind("schoolid", str3 + "").combind("rand", str4);
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<AmmeterWriteSettingBean> baseBeanAmmeterWriteInfo = this.mProtocolTest.ammeterWriteInfo(code, sign, str);
            if (baseBeanAmmeterWriteInfo.ok()) {
                return baseBeanAmmeterWriteInfo.Data;
            }
            throw HttpException.filter(baseBeanAmmeterWriteInfo.Code, baseBeanAmmeterWriteInfo.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public AmmeterWriteSettingBean ammeterWriteInfoSuccess(String str, String str2, String str3) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("machineid", str2 + "").combind("rand", str3);
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<AmmeterWriteSettingBean> baseBeanAmmeterWriteInfoSuccess = this.mProtocolTest.ammeterWriteInfoSuccess(code, sign, str);
            if (baseBeanAmmeterWriteInfoSuccess.ok()) {
                return baseBeanAmmeterWriteInfoSuccess.Data;
            }
            throw HttpException.filter(baseBeanAmmeterWriteInfoSuccess.Code, baseBeanAmmeterWriteInfoSuccess.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public AmmeterBindRoomBean ammeterIsBindRoom(String str, String str2, String str3, String str4) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind(RechargeRecordActivity.EXTRA_TYPEID, str2 + "").combind("studentid", str3 + "").combind("schoolid", str4 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<AmmeterBindRoomBean> baseBeanAmmeterIsBindRoom = this.mProtocolTest.ammeterIsBindRoom(code, sign, str);
            if (baseBeanAmmeterIsBindRoom.ok()) {
                return baseBeanAmmeterIsBindRoom.Data;
            }
            throw HttpException.filter(baseBeanAmmeterIsBindRoom.Code, baseBeanAmmeterIsBindRoom.getErrMsg(), baseBeanAmmeterIsBindRoom.Data, baseBeanAmmeterIsBindRoom.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public WashParametersBean GetAllWashParameters(String str, long j, String str2, int i, String str3) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("schoolid", j + "").combind("devicemac", str2 + "").combind("alleywaytype", "0").combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("rand", str3 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<WashParametersBean> baseBeanGetAllWashParametersV1 = this.mProtocolTest.GetAllWashParametersV1(code, sign, str);
            if (baseBeanGetAllWashParametersV1.ok()) {
                WashParametersBean washParametersBean = baseBeanGetAllWashParametersV1.Data;
                washParametersBean.serial = baseBeanGetAllWashParametersV1.Serial;
                return washParametersBean;
            }
            throw HttpException.filter(baseBeanGetAllWashParametersV1.Code, baseBeanGetAllWashParametersV1.getErrMsg(), baseBeanGetAllWashParametersV1.Data, baseBeanGetAllWashParametersV1.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public WashParametersBean GetAllWashParameters2(String str, long j, String str2, int i, String str3) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("schoolid", j + "").combind("devicemac", str2 + "").combind("alleywaytype", "0").combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("rand", str3 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<WashParametersBean> baseBeanGetAllWashParameters = this.mProtocolTest.GetAllWashParameters(code, sign, str);
            if (baseBeanGetAllWashParameters.ok()) {
                WashParametersBean washParametersBean = baseBeanGetAllWashParameters.Data;
                washParametersBean.serial = baseBeanGetAllWashParameters.Serial;
                return washParametersBean;
            }
            throw HttpException.filter(baseBeanGetAllWashParameters.Code, baseBeanGetAllWashParameters.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public WashParametersBean WashInit(String str, String str2, long j, String str3, String str4, String str5, String str6, int i, String str7, String str8, String str9) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("investorid", str2 + "").combind("schoolid", j + "").combind("devicetype", str3 + "").combind("devicemac", str4 + "").combind("devicename", str5.replace(PPSLabelView.Code, "")).combind("alleywaytype", "0").combind("registrant", str6).combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("installlocation", str7).combind("rand", str8 + "").combind("machineid", str9);
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<WashParametersBean> baseBeanWashInit = this.mProtocolTest.WashInit(code, sign, str);
            if (baseBeanWashInit.ok()) {
                return baseBeanWashInit.Data;
            }
            throw HttpException.filter(baseBeanWashInit.Code, baseBeanWashInit.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public WashParametersBean WashInitFinish(String str, String str2, String str3) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("machineid", str2 + "").combind("rand", str3 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<WashParametersBean> baseBeanWashInitFinish = this.mProtocolTest.WashInitFinish(code, sign, str);
            if (baseBeanWashInitFinish.ok()) {
                return baseBeanWashInitFinish.Data;
            }
            throw HttpException.filter(baseBeanWashInitFinish.Code, baseBeanWashInitFinish.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public WashGetMachineid WashGetMachineid(String str, String str2, long j, String str3, int i, String str4) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("investorid", str2 + "").combind("schoolid", j + "").combind("devicemac", str3 + "").combind("alleywaytype", "0").combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("rand", str4 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<WashGetMachineid> baseBeanWashGetMachineid = this.mProtocolTest.WashGetMachineid(code, sign, str);
            if (baseBeanWashGetMachineid.ok()) {
                return baseBeanWashGetMachineid.Data;
            }
            throw HttpException.filter(baseBeanWashGetMachineid.Code, baseBeanWashGetMachineid.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public WashParametersBean WashUpdateInit(String str, String str2, long j, String str3, int i, String str4, String str5, String str6) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("investorid", str2 + "").combind("schoolid", j + "").combind("machineid", str3 + "").combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("rand", str4).combind("installlocation", str5).combind("devicename", str6 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<WashParametersBean> baseBeanWashUpdateInit = this.mProtocolTest.WashUpdateInit(code, sign, str);
            if (baseBeanWashUpdateInit.ok()) {
                return baseBeanWashUpdateInit.Data;
            }
            throw HttpException.filter(baseBeanWashUpdateInit.Code, baseBeanWashUpdateInit.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public WashOrderBean WashOrder(String str, String str2, int i, long j, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentid", str2 + "").combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("schoolid", j + "").combind("pay", str3 + "").combind("machineid", str4 + "").combind("mobile", str5 + "").combind("appway", str6 + "").combind(AmmeterWalletDetailActivity.EXTRA_ORDERID, str7 + "").combind("apptime", str8 + "").combind("applicationid", str9 + "").combind("devicetype", "1").combind("machinename", str10).combind("rand", str11 + "").combind("prninttype", str12 + "").combind("devicemac", str13);
            String code = getCode(combindBean);
            String sign = getSign(code);
            Log.e(TAG, combindBean.toString());
            LogUtil.log(combindBean.toString());
            BaseBean<WashOrderBean> baseBeanWashOrderV1 = this.mProtocolTest.WashOrderV1(code, sign, str);
            if (baseBeanWashOrderV1.ok()) {
                return baseBeanWashOrderV1.Data;
            }
            throw HttpException.filter(baseBeanWashOrderV1.Code, baseBeanWashOrderV1.getErrMsg(), baseBeanWashOrderV1.Data, baseBeanWashOrderV1.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public WashOrderBean WashOrderV3(String str, String str2, int i, long j, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentid", str2 + "").combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("schoolid", j + "").combind("pay", str3 + "").combind("machineid", str4 + "").combind("mobile", str5 + "").combind("appway", str6 + "").combind(AmmeterWalletDetailActivity.EXTRA_ORDERID, str7 + "").combind("apptime", str8 + "").combind("applicationid", str9 + "").combind("devicetype", "1").combind("machinename", str10).combind("rand", str11 + "").combind("prninttype", str12 + "").combind("devicemac", str13);
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<WashOrderBean> baseBeanWashOrder = this.mProtocolTest.WashOrder(code, sign, str);
            if (baseBeanWashOrder.ok()) {
                return baseBeanWashOrder.Data;
            }
            throw HttpException.filter(baseBeanWashOrder.Code, baseBeanWashOrder.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public WashAuthorizeBean WashAuthorize(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentid", str2 + "").combind("schoolid", str3 + "").combind(AmmeterWalletDetailActivity.EXTRA_ORDERID, str4 + "").combind("managerflag", str5 + "").combind("machineid", str6 + "").combind("machinedata", str7 + "").combind(RechargeRecordActivity.EXTRA_TYPEID, str8 + "").combind("pay", str9 + "").combind("alleywaytype", str10 + "").combind("rand", str11).combind("version", str12 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<WashAuthorizeBean> baseBeanWashAuthorize = this.mProtocolTest.WashAuthorize(code, sign, str);
            if (baseBeanWashAuthorize.ok()) {
                return baseBeanWashAuthorize.Data;
            }
            throw HttpException.filter(baseBeanWashAuthorize.Code, baseBeanWashAuthorize.getErrMsg(), baseBeanWashAuthorize.Data, baseBeanWashAuthorize.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public WashHistoryOrderBean SoundWaveWashUpdateInfo(String str, String str2, int i, String str3, String str4, String str5, int i2, String str6, boolean z) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("schoolid", str2 + "").combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("alleywaytype", "1").combind("studentid", str3).combind("cardtype", "1").combind("machineid", str4 + "").combind("machinedata", str5 + "").combind("version", i2 + "").combind("rand", str6 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            Log.e(TAG, combindBean.toString());
            LogUtil.log(combindBean.toString());
            BaseBean<WashHistoryOrderBean> washUpdateInfoREC = this.mProtocolTest.getWashUpdateInfoREC(code, sign, str);
            if (washUpdateInfoREC.ok()) {
                return washUpdateInfoREC.Data;
            }
            throw HttpException.filter(washUpdateInfoREC.Code, washUpdateInfoREC.getErrMsg(), washUpdateInfoREC.Data, washUpdateInfoREC.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SoundWaveCardRecordListBean getWashRecordList(String str, long j, int i, int i2, String str2, String str3, String str4) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            try {
                if (i <= 0) {
                    combindBean.combind("studentid", j + "").combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("pageindex", i2 + "").combind("status", str2).combind("machineid", str3).combind("pminfotype", str4 + "");
                } else {
                    combindBean.combind("studentid", j + "").combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("pageindex", i2 + "").combind("status", str2).combind("machineid", str3).combind("pminfotype", str4 + "");
                }
                String code = getCode(combindBean);
                String sign = getSign(code);
                LogUtil.log(combindBean.toString());
                BaseBean<SoundWaveCardRecordListBean> baseBeanGetWashRecordList = this.mProtocolTest.GetWashRecordList(code, sign, str);
                if (baseBeanGetWashRecordList.ok()) {
                    SoundWaveCardRecordListBean soundWaveCardRecordListBean = baseBeanGetWashRecordList.Data;
                    soundWaveCardRecordListBean.serial = baseBeanGetWashRecordList.Serial;
                    return soundWaveCardRecordListBean;
                }
                throw HttpException.filter(baseBeanGetWashRecordList.Code, baseBeanGetWashRecordList.getErrMsg());
            } catch (Exception e) {
                e = e;
                if (e instanceof HttpException) {
                    throw ((HttpException) e);
                }
                if (e instanceof DBException) {
                    throw ((DBException) e);
                }
                throw HttpException.getDefautException();
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public WashOrderBean WashUpdateOrder(String str, String str2, String str3, String str4) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentid", str2 + "").combind("systemtime", str3 + "").combind("rand", str4 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<WashOrderBean> baseBeanWashUpdateOrder = this.mProtocolTest.WashUpdateOrder(code, sign, str);
            if (baseBeanWashUpdateOrder.ok()) {
                return baseBeanWashUpdateOrder.Data;
            }
            throw HttpException.filter(baseBeanWashUpdateOrder.Code, baseBeanWashUpdateOrder.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public EGIsBindBean getEntranceGuardIsBind(String str, long j, long j2, long j3, String str2) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("schoolid", j + "").combind("studentid", j2 + "").combind(RechargeRecordActivity.EXTRA_TYPEID, j3 + "").combind("rand", str2);
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<EGIsBindBean> entranceGuardIsBind = this.mProtocolTest.getEntranceGuardIsBind(code, sign, str);
            if (entranceGuardIsBind.ok()) {
                return entranceGuardIsBind.Data;
            }
            throw HttpException.filter(entranceGuardIsBind.Code, entranceGuardIsBind.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public List<AmmeterAreaInfo> entranceGuardGetAreaInfo(String str, String str2) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("id", str2 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            Log.e(TAG, combindBean.toString());
            LogUtil.log(combindBean.toString());
            BaseBean<List<AmmeterAreaInfo>> entranceGuardGetAreaInfo = this.mProtocolTest.getEntranceGuardGetAreaInfo(code, sign, str);
            if (entranceGuardGetAreaInfo.ok()) {
                return entranceGuardGetAreaInfo.Data;
            }
            throw HttpException.filter(entranceGuardGetAreaInfo.Code, entranceGuardGetAreaInfo.getErrMsg(), entranceGuardGetAreaInfo.Data, entranceGuardGetAreaInfo.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public EGRoomDetailBean entranceGuardGetAreaInfoAll(String str, String str2) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("roomid", str2 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<EGRoomDetailBean> entranceGuardGetAreaInfoAll = this.mProtocolTest.getEntranceGuardGetAreaInfoAll(code, sign, str);
            if (entranceGuardGetAreaInfoAll.ok()) {
                return entranceGuardGetAreaInfoAll.Data;
            }
            throw HttpException.filter(entranceGuardGetAreaInfoAll.Code, entranceGuardGetAreaInfoAll.getErrMsg(), entranceGuardGetAreaInfoAll.Data, entranceGuardGetAreaInfoAll.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public EGBindRoomInfo entranceGuardUnBindingRoom(String str, long j, long j2, String str2, int i, String str3) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("schoolid", j + "").combind("studentid", j2 + "").combind("roomid", str2).combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("rand", str3);
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<EGBindRoomInfo> entranceGuardUnBindingRoom = this.mProtocolTest.getEntranceGuardUnBindingRoom(code, sign, str);
            if (entranceGuardUnBindingRoom.ok()) {
                return entranceGuardUnBindingRoom.Data;
            }
            throw HttpException.filter(entranceGuardUnBindingRoom.Code, entranceGuardUnBindingRoom.getErrMsg(), entranceGuardUnBindingRoom.Data, entranceGuardUnBindingRoom.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public WashHistoryOrderBean getUpdateMacForSalesCard(String str, String str2, long j, int i, String str3, String str4, int i2, String str5) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("schoolid", str2 + "").combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("alleywaytype", "0").combind("studentid", j + "").combind("machineid", str3 + "").combind("machinedata", str4 + "").combind("version", i2 + "").combind("rand", str5 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<WashHistoryOrderBean> updateMacForSalesCard = this.mProtocolTest.getUpdateMacForSalesCard(code, sign, str);
            if (updateMacForSalesCard.ok()) {
                return updateMacForSalesCard.Data;
            }
            throw HttpException.filter(updateMacForSalesCard.Code, updateMacForSalesCard.getErrMsg(), updateMacForSalesCard.Data, updateMacForSalesCard.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SellCardPriceBean getCardSalesPrice(String str, String str2, int i, String str3) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("schoolid", str2 + "").combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("rand", str3 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<SellCardPriceBean> cardSalesPrice = this.mProtocolTest.getCardSalesPrice(code, sign, str);
            if (cardSalesPrice.ok()) {
                return cardSalesPrice.Data;
            }
            throw HttpException.filter(cardSalesPrice.Code, cardSalesPrice.getErrMsg(), cardSalesPrice.Data, cardSalesPrice.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SellCardAuthorizeBean cardSalesAuth(String str, long j, String str2, int i, String str3, int i2, int i3, String str4, int i4, String str5, String str6, int i5) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentid", j + "").combind("schoolid", str2 + "").combind("managerflag", i + "").combind("machineid", str3 + "").combind(RechargeRecordActivity.EXTRA_TYPEID, i2 + "").combind("machinedata", str6).combind("alleywaytype", i3 + "").combind("rand", str4 + "").combind("version", i4 + "").combind("pay", i5 + "").combind(AmmeterWalletDetailActivity.EXTRA_ORDERID, str5 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.e(TAG, combindBean.toString());
            LogUtil.log(combindBean.toString());
            BaseBean<SellCardAuthorizeBean> baseBeanCardSalesAuth = this.mProtocolTest.cardSalesAuth(code, sign, str);
            if (baseBeanCardSalesAuth.ok()) {
                return baseBeanCardSalesAuth.Data;
            }
            throw HttpException.filter(baseBeanCardSalesAuth.Code, baseBeanCardSalesAuth.getErrMsg(), baseBeanCardSalesAuth.Data, baseBeanCardSalesAuth.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SoundWaveCardRecordListBean getCardSalesList(String str, long j, int i, int i2, String str2, String str3) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentid", j + "").combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("pageindex", i2 + "").combind("status", str2).combind("machineid", str3);
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<SoundWaveCardRecordListBean> cardSalesList = this.mProtocolTest.getCardSalesList(code, sign, str);
            if (cardSalesList.ok()) {
                return cardSalesList.Data;
            }
            throw HttpException.filter(cardSalesList.Code, cardSalesList.getErrMsg(), cardSalesList.Data, cardSalesList.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public HamamIsBindBean getHamamIsBind(String str, long j, long j2, String str2) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("schoolid", j + "").combind("studentid", j2 + "").combind("bathhouseid", str2);
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<HamamIsBindBean> hamamIsBind = this.mProtocolTest.getHamamIsBind(code, sign, str, "2");
            if (hamamIsBind.ok()) {
                return hamamIsBind.Data;
            }
            throw HttpException.filter(hamamIsBind.Code, hamamIsBind.getErrMsg(), hamamIsBind.Data, hamamIsBind.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean hamamUnBindingRoom(String str, long j, long j2, String str2) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("schoolid", j + "").combind("studentid", j2 + "").combind("bathhouseid", str2);
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<SuccessBean> hamamUnBindingRoom = this.mProtocolTest.getHamamUnBindingRoom(code, sign, str, "2");
            if (hamamUnBindingRoom.ok()) {
                return hamamUnBindingRoom.Data;
            }
            throw HttpException.filter(hamamUnBindingRoom.Code, hamamUnBindingRoom.getErrMsg(), hamamUnBindingRoom.Data, hamamUnBindingRoom.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public HamamBindBean hamamBindingRoom(String str, long j, long j2, String str2) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("schoolid", j + "").combind("studentid", j2 + "").combind("bathhouseid", str2);
            Log.e(TAG, combindBean.toString());
            LogUtil.log(combindBean.toString());
            String code = getCode(combindBean);
            BaseBean<HamamBindBean> hamamBindingRoom = this.mProtocolTest.getHamamBindingRoom(code, getSign(code), str, "2");
            if (hamamBindingRoom.ok()) {
                return hamamBindingRoom.Data;
            }
            if (hamamBindingRoom.Code == 4127) {
                throw HttpException.filter(hamamBindingRoom.Code, hamamBindingRoom.Data.bathhouseareaId);
            }
            throw HttpException.filter(hamamBindingRoom.Code, hamamBindingRoom.getErrMsg(), hamamBindingRoom.Data, hamamBindingRoom.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public HamamBindPreBean bindBathHouseFront(String str, String str2, String str3, long j) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("userpass", str2).combind("rand", str3).combind("schoolid", j + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<HamamBindPreBean> baseBeanBindBathHouseFront = this.mProtocolTest.bindBathHouseFront(code, sign, str, "2");
            if (baseBeanBindBathHouseFront.ok()) {
                return baseBeanBindBathHouseFront.Data;
            }
            throw HttpException.filter(baseBeanBindBathHouseFront.Code, baseBeanBindBathHouseFront.getErrMsg(), baseBeanBindBathHouseFront.Data, baseBeanBindBathHouseFront.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public HamamRecordListBean getHamamConsumeDetailList(String str, long j, long j2, int i) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("schoolid", j + "").combind("studentid", j2 + "").combind("currentpage", i + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<HamamRecordListBean> baseBeanGetHamamConsumeDetailList = this.mProtocolTest.GetHamamConsumeDetailList(code, sign, str, "2");
            if (baseBeanGetHamamConsumeDetailList.ok()) {
                return baseBeanGetHamamConsumeDetailList.Data;
            }
            throw HttpException.filter(baseBeanGetHamamConsumeDetailList.Code, baseBeanGetHamamConsumeDetailList.getErrMsg(), baseBeanGetHamamConsumeDetailList.Data, baseBeanGetHamamConsumeDetailList.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public List<HamamDetailListBean> getHamamDetail(String str, String str2, int i, String str3) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (StringUtils.isNotEmpty(str2)) {
                if (str3.equals("0")) {
                    combindBean.combind("aid", str2).combind(ArticleInfo.USER_SEX, i + "").combind(CrashHianalyticsData.TIME, jCurrentTimeMillis + "");
                } else {
                    combindBean.combind("aid", str2).combind(ArticleInfo.USER_SEX, i + "").combind("id", str3).combind(CrashHianalyticsData.TIME, jCurrentTimeMillis + "");
                }
            } else {
                combindBean.combind("id", str3).combind(CrashHianalyticsData.TIME, jCurrentTimeMillis + "");
            }
            String code = getCode(combindBean);
            String sign = getSign(code);
            Log.e(TAG, combindBean.toString());
            LogUtil.log(combindBean.toString());
            BaseBean<List<HamamDetailListBean>> hamamDetail = this.mProtocolTest.getHamamDetail(code, sign, str, "2");
            if (hamamDetail.ok()) {
                return hamamDetail.Data;
            }
            throw HttpException.filter(hamamDetail.Code, hamamDetail.getErrMsg(), hamamDetail.Data, hamamDetail.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public HamamYuYueBean getHamamIsYuYue(String str, String str2, String str3, String str4) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentid", str2).combind("bathhouseid", str3).combind("rand", str4);
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<HamamYuYueBean> hamamIsYuYue = this.mProtocolTest.getHamamIsYuYue(code, sign, str, "2");
            if (hamamIsYuYue.ok()) {
                return hamamIsYuYue.Data;
            }
            throw HttpException.filter(hamamIsYuYue.Code, hamamIsYuYue.getErrMsg(), hamamIsYuYue.Data, hamamIsYuYue.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public HamamYuYueBean getHamamYuYue(String str, String str2, String str3, String str4, String str5, String str6, String str7) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentid", str2).combind("bathhouseid", str3).combind("schoolid", str4).combind("machineid", str5).combind("reserveindex", str6).combind("rand", str7);
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<HamamYuYueBean> hamamYuYue = this.mProtocolTest.getHamamYuYue(code, sign, str, "2");
            if (hamamYuYue.ok()) {
                return hamamYuYue.Data;
            }
            throw HttpException.filter(hamamYuYue.Code, hamamYuYue.getErrMsg(), hamamYuYue.Data, hamamYuYue.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public BathAuthBean postBathAuth(String str, String str2, String str3, int i, String str4, String str5, int i2, String str6) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentid", str2).combind("schoolid", str3).combind("managerflag", i + "").combind("machineid", str4).combind("machinedata", str5).combind(RechargeRecordActivity.EXTRA_TYPEID, i2 + "").combind("alleywaytype", "0").combind("rand", str6).combind("version", "1");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.e(TAG, combindBean.toString());
            LogUtil.log(combindBean.toString());
            BaseBean<BathAuthBean> bathAuth = this.mProtocolTest.getBathAuth(code, sign, str);
            if (bathAuth.ok()) {
                return bathAuth.Data;
            }
            throw HttpException.filter(bathAuth.Code, bathAuth.getErrMsg(), bathAuth.Data, bathAuth.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public BathUploadOrderBean postBathUploadOrder(String str, String str2, String str3, int i, String str4, String str5, int i2, String str6) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentid", str2).combind("schoolid", str3).combind("managerflag", i + "").combind("machineid", str4).combind("machinedata", str5).combind(RechargeRecordActivity.EXTRA_TYPEID, i2 + "").combind("alleywaytype", "0").combind("rand", str6).combind("version", "1");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<BathUploadOrderBean> bathUploadOrder = this.mProtocolTest.getBathUploadOrder(code, sign, str);
            if (bathUploadOrder.ok()) {
                return bathUploadOrder.Data;
            }
            throw HttpException.filter(bathUploadOrder.Code, bathUploadOrder.getErrMsg(), bathUploadOrder.Data, bathUploadOrder.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public BathUploadOrderNewBean postBatheAuthAnalysis(String str, long j, int i, long j2, int i2, String str2, int i3, int i4, String str3, String str4, String str5, int i5, String str6, String str7) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentid", j + "").combind("clienttype", "3").combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("schoolid", j2 + "").combind("managerflag", i2 + "").combind("machineid", str2 + "").combind("machinetypeid", i3 + "").combind("machinever", i4 + "").combind("machinedata", str3 + "").combind("machinerandom", str4 + "").combind("possystemtime", str5 + "").combind("alleywaytype", i5 + "").combind("rand", str6 + "").combind("version", str7 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<BathUploadOrderNewBean> baseBeanPostBatheAuthAnalysis = this.mProtocolTest.postBatheAuthAnalysis(code, sign, str, "140000000000000001", "2");
            if (!baseBeanPostBatheAuthAnalysis.ok() && baseBeanPostBatheAuthAnalysis.Code != 4115) {
                throw HttpException.filter(baseBeanPostBatheAuthAnalysis.Code, baseBeanPostBatheAuthAnalysis.getErrMsg(), baseBeanPostBatheAuthAnalysis.Data, baseBeanPostBatheAuthAnalysis.Serial);
            }
            return baseBeanPostBatheAuthAnalysis.Data;
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public BathAuthNewBean postBatheAuth(String str, String str2, int i, long j, int i2, String str3, int i3, int i4, String str4, String str5, String str6, int i5, String str7, String str8) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentid", str2).combind("clienttype", "3").combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("schoolid", j + "").combind("managerflag", i2 + "").combind("machineid", str3 + "").combind("machinetypeid", i3 + "").combind("machinever", i4 + "").combind("machinerandom", str4 + "").combind("nextopenposmoney", str5 + "").combind("nextopenposserial", str6 + "").combind("alleywaytype", i5 + "").combind("rand", str7 + "").combind("version", str8 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<BathAuthNewBean> baseBeanPostBatheAuth = this.mProtocolTest.postBatheAuth(code, sign, str, "140000000000000001", "2");
            if (baseBeanPostBatheAuth.ok()) {
                return baseBeanPostBatheAuth.Data;
            }
            throw HttpException.filter(baseBeanPostBatheAuth.Code, baseBeanPostBatheAuth.getErrMsg(), baseBeanPostBatheAuth.Data, baseBeanPostBatheAuth.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public BathUploadOrderNewBean postCommIotAuthAnalysis(String str, long j, int i, long j2, int i2, String str2, int i3, int i4, String str3, String str4, String str5, int i5, String str6, String str7) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentid", j + "").combind("clienttype", "3").combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("schoolid", j2 + "").combind("managerflag", i2 + "").combind("machineid", str2 + "").combind("machinetypeid", i3 + "").combind("machinever", i4 + "").combind("machinedata", str3 + "").combind("machinerandom", str4 + "").combind("possystemtime", str5 + "").combind("alleywaytype", i5 + "").combind("rand", str6 + "").combind("version", str7 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<BathUploadOrderNewBean> baseBeanPostCommIotAuthAnalysis = this.mProtocolTest.postCommIotAuthAnalysis(code, sign, str, "140000000000000001", "2");
            if (!baseBeanPostCommIotAuthAnalysis.ok() && baseBeanPostCommIotAuthAnalysis.Code != 4115) {
                throw HttpException.filter(baseBeanPostCommIotAuthAnalysis.Code, baseBeanPostCommIotAuthAnalysis.getErrMsg(), baseBeanPostCommIotAuthAnalysis.Data, baseBeanPostCommIotAuthAnalysis.Serial);
            }
            return baseBeanPostCommIotAuthAnalysis.Data;
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public BathAuthNewBean postCommIotAuth(String str, String str2, int i, long j, int i2, String str3, int i3, int i4, String str4, String str5, String str6, int i5, String str7, String str8) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentid", str2).combind("clienttype", "3").combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("schoolid", j + "").combind("managerflag", i2 + "").combind("machineid", str3 + "").combind("machinetypeid", i3 + "").combind("machinever", i4 + "").combind("machinerandom", str4 + "").combind("nextopenposmoney", str5 + "").combind("nextopenposserial", str6 + "").combind("alleywaytype", i5 + "").combind("rand", str7 + "").combind("openmoney", "1").combind("version", str8 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<BathAuthNewBean> baseBeanPostCommIotAuth = this.mProtocolTest.postCommIotAuth(code, sign, str, "140000000000000001", "2");
            if (baseBeanPostCommIotAuth.ok()) {
                return baseBeanPostCommIotAuth.Data;
            }
            throw HttpException.filter(baseBeanPostCommIotAuth.Code, baseBeanPostCommIotAuth.getErrMsg(), baseBeanPostCommIotAuth.Data, baseBeanPostCommIotAuth.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SetNBDrinkWaterBean postDeviceConfiguration(String str, int i, long j, String str2, int i2, int i3, String str3, String str4, String str5, String str6) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("alleywaytype", "2").combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("schoolid", j + "").combind("machineid", str2 + "").combind("machine_typeid", i2 + "").combind("machine_ver", i3 + "").combind("machineid_random", str3 + "").combind("setmachinedata", str4 + "").combind("rand", str5 + "").combind("version", str6 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<SetNBDrinkWaterBean> baseBeanPostDeviceConfiguration = this.mProtocolTest.postDeviceConfiguration(code, sign, str, "140000000000000001", "2");
            if (baseBeanPostDeviceConfiguration.ok()) {
                return baseBeanPostDeviceConfiguration.Data;
            }
            throw HttpException.filter(baseBeanPostDeviceConfiguration.Code, baseBeanPostDeviceConfiguration.getErrMsg(), baseBeanPostDeviceConfiguration.Data, baseBeanPostDeviceConfiguration.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public UnRegisterBathHouseBean postLogoutBathHouse(String str, long j, String str2, String str3) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("schoolid", j + "").combind("machineid", str2 + "").combind("rand", str3 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<UnRegisterBathHouseBean> baseBeanPostLogoutBathHouse = this.mProtocolTest.postLogoutBathHouse(code, sign, str, "140000000000000001", "2");
            if (baseBeanPostLogoutBathHouse.ok()) {
                return baseBeanPostLogoutBathHouse.Data;
            }
            throw HttpException.filter(baseBeanPostLogoutBathHouse.Code, baseBeanPostLogoutBathHouse.getErrMsg(), baseBeanPostLogoutBathHouse.Data, baseBeanPostLogoutBathHouse.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public UnRegisterBathHouseBean getChangeBathHouse(String str, String str2, String str3) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("machineid", str2 + "").combind("rand", str3 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<UnRegisterBathHouseBean> changeBathHouse = this.mProtocolTest.getChangeBathHouse(code, sign, str, "140000000000000001", "2");
            if (changeBathHouse.ok()) {
                return changeBathHouse.Data;
            }
            throw HttpException.filter(changeBathHouse.Code, changeBathHouse.getErrMsg(), changeBathHouse.Data, changeBathHouse.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public BathHousePasswordBean getBathHousePassword(String str, long j, long j2, int i, String str2) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentid", j + "").combind("schoolid", j2 + "").combind("clienttype", "1").combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("rand", str2 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<BathHousePasswordBean> bathHousePassword = this.mProtocolTest.getBathHousePassword(code, sign, str, "140000000000000001", "2");
            if (bathHousePassword.ok()) {
                return bathHousePassword.Data;
            }
            throw HttpException.filter(bathHousePassword.Code, bathHousePassword.getErrMsg(), bathHousePassword.Data, bathHousePassword.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public BathHousePasswordBean postSetAuthorizedPassword(String str, long j, long j2, String str2, int i, String str3, String str4) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentid", j + "").combind("schoolid", j2 + "").combind("password", str2).combind("clienttype", "1").combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("mobile", str3).combind("rand", str4 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<BathHousePasswordBean> baseBeanPostSetAuthorizedPassword = this.mProtocolTest.postSetAuthorizedPassword(code, sign, str, "140000000000000001", "2");
            if (baseBeanPostSetAuthorizedPassword.ok()) {
                return baseBeanPostSetAuthorizedPassword.Data;
            }
            throw HttpException.filter(baseBeanPostSetAuthorizedPassword.Code, baseBeanPostSetAuthorizedPassword.getErrMsg(), baseBeanPostSetAuthorizedPassword.Data, baseBeanPostSetAuthorizedPassword.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public BathHousePasswordBean postChangeAuthorizedPassword(String str, long j, long j2, String str2, String str3, int i, String str4, String str5) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentid", j + "").combind("schoolid", j2 + "").combind("newpassword", str2).combind("originalpassword", str3).combind("clienttype", "1").combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("mobile", str4).combind("rand", str5 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<BathHousePasswordBean> baseBeanPostChangeAuthorizedPassword = this.mProtocolTest.postChangeAuthorizedPassword(code, sign, str, "140000000000000001", "2");
            if (baseBeanPostChangeAuthorizedPassword.ok()) {
                return baseBeanPostChangeAuthorizedPassword.Data;
            }
            throw HttpException.filter(baseBeanPostChangeAuthorizedPassword.Code, baseBeanPostChangeAuthorizedPassword.getErrMsg(), baseBeanPostChangeAuthorizedPassword.Data, baseBeanPostChangeAuthorizedPassword.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SelectUserAuthenticationBean getSelectUserAuthenticationStatus(String str, long j, long j2, int i, String str2) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("userid", j + "").combind("schoolid", j2 + "").combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("random", str2 + "");
            String doorLockCode = getDoorLockCode(combindBean);
            String doorLockSign = getDoorLockSign(doorLockCode);
            Log.e(TAG, combindBean.returnStr);
            LogUtil.log(combindBean.toString());
            BaseBean<SelectUserAuthenticationBean> selectUserAuthenticationStatus = this.mProtocolTest.getSelectUserAuthenticationStatus(doorLockCode, doorLockSign, str, "140000000000000001", "2");
            if (selectUserAuthenticationStatus.ok()) {
                return selectUserAuthenticationStatus.Data;
            }
            throw HttpException.filter(selectUserAuthenticationStatus.Code, selectUserAuthenticationStatus.getErrMsg(), selectUserAuthenticationStatus.Data, selectUserAuthenticationStatus.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SubmitUserInformationBean postSubmitUserInformation(String str, long j, long j2, int i, String str2, String str3, String str4, String str5, int i2, int i3) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("userid", j + "").combind("schoolid", j2 + "").combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("random", str2 + "").combind("studentname", str3).combind("identityid", str4).combind("mobile", str5).combind(ArticleInfo.USER_SEX, i2 + "").combind("number", i3 + "");
            Log.e(TAG, combindBean.returnStr);
            LogUtil.log(combindBean.toString());
            String doorLockCode = getDoorLockCode(combindBean);
            BaseBean<SubmitUserInformationBean> baseBeanPostSubmitUserInformation = this.mProtocolTest.postSubmitUserInformation(doorLockCode, getDoorLockSign(doorLockCode), str, "140000000000000001", "2");
            if (baseBeanPostSubmitUserInformation.ok()) {
                return baseBeanPostSubmitUserInformation.Data;
            }
            throw HttpException.filter(baseBeanPostSubmitUserInformation.Code, baseBeanPostSubmitUserInformation.getErrMsg(), baseBeanPostSubmitUserInformation.Data, baseBeanPostSubmitUserInformation.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public DoorLockInfoBean getDoorLockUserInfo(String str, long j, long j2, int i, String str2) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("userid", j + "").combind("schoolid", j2 + "").combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("random", str2 + "");
            String doorLockCode = getDoorLockCode(combindBean);
            String doorLockSign = getDoorLockSign(doorLockCode);
            LogUtil.log(combindBean.toString());
            BaseBean<DoorLockInfoBean> doorLockUserInfo = this.mProtocolTest.getDoorLockUserInfo(doorLockCode, doorLockSign, str, "140000000000000001", "2");
            if (doorLockUserInfo.ok()) {
                LocalBusinessStore.saveSystemTime(BaseApplication.app, System.currentTimeMillis() - Long.parseLong(doorLockUserInfo.Serial));
                return doorLockUserInfo.Data;
            }
            throw HttpException.filter(doorLockUserInfo.Code, doorLockUserInfo.getErrMsg(), doorLockUserInfo.Data, doorLockUserInfo.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public DLHACBean getDLHAC(String str, int i, long j, String str2, String str3, String str4, String str5, String str6, String str7) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("schoolid", j + "").combind("userid", str2).combind("random", str3).combind("machineid", str4 + "").combind("student_hex", str5).combind("machine_data_R1", str6).combind("machine_data_R2", str7).combind("version", "1");
            String doorLockCode = getDoorLockCode(combindBean);
            String doorLockSign = getDoorLockSign(doorLockCode);
            Log.e(TAG, combindBean.toString());
            LogUtil.log(combindBean.toString());
            BaseBean<DLHACBean> hac = this.mProtocolTest.getHAC(doorLockCode, doorLockSign, str, "140000000000000001", "2");
            if (hac.ok()) {
                return hac.Data;
            }
            throw HttpException.filter(hac.Code, hac.getErrMsg(), hac.Data, hac.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public DoorLockAllUsersInfoBean getDoorLockAllUserID(String str, int i, long j, String str2, String str3, String str4, String str5) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("schoolid", j + "").combind("userid", str2).combind("random", str3).combind("machineid", str4 + "").combind("roomId", str5);
            String doorLockCode = getDoorLockCode(combindBean);
            String doorLockSign = getDoorLockSign(doorLockCode);
            Log.e(TAG, combindBean.toString());
            LogUtil.log(combindBean.toString());
            BaseBean<DoorLockAllUsersInfoBean> doorLockAllUserID = this.mProtocolTest.getDoorLockAllUserID(doorLockCode, doorLockSign, str, "140000000000000001", "2");
            if (doorLockAllUserID.ok()) {
                return doorLockAllUserID.Data;
            }
            throw HttpException.filter(doorLockAllUserID.Code, doorLockAllUserID.getErrMsg(), doorLockAllUserID.Data, doorLockAllUserID.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean getDoorLockSyncUserID(String str, int i, long j, String str2, String str3, String str4, String str5, String str6) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("schoolid", j + "").combind("userid", str2).combind("random", str3).combind("machineid", str4 + "").combind("lcsId", str5).combind("roomId", str6);
            String doorLockCode = getDoorLockCode(combindBean);
            String doorLockSign = getDoorLockSign(doorLockCode);
            Log.e(TAG, combindBean.toString());
            LogUtil.log(combindBean.toString());
            BaseBean<SuccessBean> doorLockSyncUserID = this.mProtocolTest.getDoorLockSyncUserID(doorLockCode, doorLockSign, str, "140000000000000001", "2");
            if (doorLockSyncUserID.ok()) {
                return doorLockSyncUserID.Data;
            }
            throw HttpException.filter(doorLockSyncUserID.Code, doorLockSyncUserID.getErrMsg(), doorLockSyncUserID.Data, doorLockSyncUserID.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public DoorLockNotSyncKeys getDoorLockNotSyncKeyInfo(String str, int i, long j, String str2, String str3, String str4, String str5) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("schoolid", j + "").combind("userid", str2).combind("random", str3).combind("machineid", str4 + "").combind("roomId", str5);
            String doorLockCode = getDoorLockCode(combindBean);
            String doorLockSign = getDoorLockSign(doorLockCode);
            Log.e(TAG, combindBean.toString());
            LogUtil.log(combindBean.toString());
            BaseBean<DoorLockNotSyncKeys> doorLockNotSyncKeyInfo = this.mProtocolTest.getDoorLockNotSyncKeyInfo(doorLockCode, doorLockSign, str, "140000000000000001", "2");
            if (doorLockNotSyncKeyInfo.ok()) {
                return doorLockNotSyncKeyInfo.Data;
            }
            throw HttpException.filter(doorLockNotSyncKeyInfo.Code, doorLockNotSyncKeyInfo.getErrMsg(), doorLockNotSyncKeyInfo.Data, doorLockNotSyncKeyInfo.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public DoorLockKeyInfos getDoorLockKeyInfo(String str, int i, long j, String str2, String str3, String str4) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("schoolid", j + "").combind("userid", str2).combind("random", str3).combind("selectUserid", str4);
            String doorLockCode = getDoorLockCode(combindBean);
            String doorLockSign = getDoorLockSign(doorLockCode);
            Log.e(TAG, combindBean.toString());
            LogUtil.log(combindBean.toString());
            BaseBean<DoorLockKeyInfos> doorLockKeyInfo = this.mProtocolTest.getDoorLockKeyInfo(doorLockCode, doorLockSign, str, "140000000000000001", "2");
            if (doorLockKeyInfo.ok()) {
                return doorLockKeyInfo.Data;
            }
            throw HttpException.filter(doorLockKeyInfo.Code, doorLockKeyInfo.getErrMsg(), doorLockKeyInfo.Data, doorLockKeyInfo.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean getDoorLockSyncKey(String str, int i, long j, String str2, String str3, String str4, String str5, int i2) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("schoolid", j + "").combind("userid", str2).combind("random", str3).combind("doorStudentMachineKeyId", str4).combind("keyid", str5).combind("type", i2 + "");
            String doorLockCode = getDoorLockCode(combindBean);
            String doorLockSign = getDoorLockSign(doorLockCode);
            Log.e(TAG, combindBean.toString());
            LogUtil.log(combindBean.toString());
            BaseBean<SuccessBean> doorLockSyncKey = this.mProtocolTest.getDoorLockSyncKey(doorLockCode, doorLockSign, str, "140000000000000001", "2");
            if (doorLockSyncKey.ok()) {
                return doorLockSyncKey.Data;
            }
            throw HttpException.filter(doorLockSyncKey.Code, doorLockSyncKey.getErrMsg(), doorLockSyncKey.Data, doorLockSyncKey.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean getDoorLockAddUserID(String str, int i, long j, String str2, String str3, String str4, String str5, String str6) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("schoolid", j + "").combind("userid", str2).combind("random", str3).combind("roomid", str4).combind("machineid", str5).combind("hardwareUserid", str6);
            String doorLockCode = getDoorLockCode(combindBean);
            String doorLockSign = getDoorLockSign(doorLockCode);
            Log.e(TAG, combindBean.toString());
            LogUtil.log(combindBean.toString());
            BaseBean<SuccessBean> doorLockAddUserID = this.mProtocolTest.getDoorLockAddUserID(doorLockCode, doorLockSign, str, "140000000000000001", "2");
            if (doorLockAddUserID.ok()) {
                return doorLockAddUserID.Data;
            }
            throw HttpException.filter(doorLockAddUserID.Code, doorLockAddUserID.getErrMsg(), doorLockAddUserID.Data, doorLockAddUserID.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public DoorLockAddKeyBean getDoorLockAddKey(String str, int i, long j, String str2, String str3, String str4, String str5, String str6, int i2, String str7, String str8) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("schoolid", j + "").combind("userid", str2).combind("random", str3).combind("roomid", str4).combind("machineid", str5).combind("hardwareUserid", str6).combind("keyflag", i2 + "").combind("keyname", str7).combind("key_passwrod", str8);
            String doorLockCode = getDoorLockCode(combindBean);
            String doorLockSign = getDoorLockSign(doorLockCode);
            Log.e(TAG, combindBean.toString());
            LogUtil.log(combindBean.toString());
            BaseBean<DoorLockAddKeyBean> doorLockAddKey = this.mProtocolTest.getDoorLockAddKey(doorLockCode, doorLockSign, str, "140000000000000001", "2");
            if (doorLockAddKey.ok()) {
                return doorLockAddKey.Data;
            }
            throw HttpException.filter(doorLockAddKey.Code, doorLockAddKey.getErrMsg(), doorLockAddKey.Data, doorLockAddKey.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public DoorLockAddKeyBean getDoorLockUpdateKey(String str, int i, long j, String str2, String str3, String str4, String str5) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("schoolid", j + "").combind("userid", str2).combind("random", str3).combind("doorStudentMachineKeyId", str4).combind("keyflag", "2").combind("key_passwrod", str5);
            String doorLockCode = getDoorLockCode(combindBean);
            String doorLockSign = getDoorLockSign(doorLockCode);
            Log.e(TAG, combindBean.toString());
            LogUtil.log(combindBean.toString());
            BaseBean<DoorLockAddKeyBean> doorLockUpdateKey = this.mProtocolTest.getDoorLockUpdateKey(doorLockCode, doorLockSign, str, "140000000000000001", "2");
            if (doorLockUpdateKey.ok()) {
                return doorLockUpdateKey.Data;
            }
            throw HttpException.filter(doorLockUpdateKey.Code, doorLockUpdateKey.getErrMsg(), doorLockUpdateKey.Data, doorLockUpdateKey.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean getDoorLockDeleteKey(String str, int i, long j, String str2, String str3, String str4) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("schoolid", j + "").combind("userid", str2).combind("random", str3).combind("doorStudentMachineKeyId", str4);
            String doorLockCode = getDoorLockCode(combindBean);
            String doorLockSign = getDoorLockSign(doorLockCode);
            Log.e(TAG, combindBean.toString());
            LogUtil.log(combindBean.toString());
            BaseBean<SuccessBean> doorLockDeleteKey = this.mProtocolTest.getDoorLockDeleteKey(doorLockCode, doorLockSign, str, "140000000000000001", "2");
            if (doorLockDeleteKey.ok()) {
                return doorLockDeleteKey.Data;
            }
            throw HttpException.filter(doorLockDeleteKey.Code, doorLockDeleteKey.getErrMsg(), doorLockDeleteKey.Data, doorLockDeleteKey.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean getDoorLockUpdateKeyName(String str, int i, long j, String str2, String str3, String str4, String str5, String str6, int i2, String str7) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("schoolid", j + "").combind("userid", str2).combind("random", str3).combind("roomid", str5).combind("machineid", str6).combind("keyflag", i2 + "").combind("keyname", str7).combind("doorStudentMachineKeyId", str4);
            String doorLockCode = getDoorLockCode(combindBean);
            String doorLockSign = getDoorLockSign(doorLockCode);
            Log.e(TAG, combindBean.toString());
            LogUtil.log(combindBean.toString());
            BaseBean<SuccessBean> doorLockUpdateKeyName = this.mProtocolTest.getDoorLockUpdateKeyName(doorLockCode, doorLockSign, str, "140000000000000001", "2");
            if (doorLockUpdateKeyName.ok()) {
                return doorLockUpdateKeyName.Data;
            }
            throw HttpException.filter(doorLockUpdateKeyName.Code, doorLockUpdateKeyName.getErrMsg(), doorLockUpdateKeyName.Data, doorLockUpdateKeyName.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean getDoorLockChangeRoom(String str, int i, long j, String str2, String str3, String str4, String str5) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("schoolid", j + "").combind("userid", str2).combind("random", str3).combind("oldRoomid", str4).combind("newRoomid", str5);
            String doorLockCode = getDoorLockCode(combindBean);
            String doorLockSign = getDoorLockSign(doorLockCode);
            Log.e(TAG, combindBean.toString());
            LogUtil.log(combindBean.toString());
            BaseBean<SuccessBean> doorLockChangeRoom = this.mProtocolTest.getDoorLockChangeRoom(doorLockCode, doorLockSign, str, "140000000000000001", "2");
            if (doorLockChangeRoom.ok()) {
                return doorLockChangeRoom.Data;
            }
            throw HttpException.filter(doorLockChangeRoom.Code, doorLockChangeRoom.getErrMsg(), doorLockChangeRoom.Data, doorLockChangeRoom.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public DoorLockChangeRoomRecordsBean getDoorLockChangeRoomRecords(String str, int i, long j, String str2, String str3) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("schoolid", j + "").combind("userid", str2).combind("random", str3);
            String doorLockCode = getDoorLockCode(combindBean);
            String doorLockSign = getDoorLockSign(doorLockCode);
            Log.e(TAG, combindBean.toString());
            LogUtil.log(combindBean.toString());
            BaseBean<DoorLockChangeRoomRecordsBean> doorLockChangeRoomRecords = this.mProtocolTest.getDoorLockChangeRoomRecords(doorLockCode, doorLockSign, str, "140000000000000001", "2");
            if (doorLockChangeRoomRecords.ok()) {
                return doorLockChangeRoomRecords.Data;
            }
            throw HttpException.filter(doorLockChangeRoomRecords.Code, doorLockChangeRoomRecords.getErrMsg(), doorLockChangeRoomRecords.Data, doorLockChangeRoomRecords.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public DLKeyBean getDoorLockEntryptData(String str, int i, long j, String str2, String str3, String str4, String str5, String str6, String str7) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("schoolid", j + "").combind("userid", str2).combind("random", str3).combind("sn", str4).combind("machine_data_R1", str5).combind("machine_data_R2", str6).combind("machine_data", str7).combind("version", "1");
            String doorLockCode = getDoorLockCode(combindBean);
            String doorLockSign = getDoorLockSign(doorLockCode);
            Log.e(TAG, combindBean.toString());
            LogUtil.log(combindBean.toString());
            BaseBean<String> doorLockEntryptData = this.mProtocolTest.getDoorLockEntryptData(doorLockCode, doorLockSign, str, "140000000000000001", "2");
            if (doorLockEntryptData.ok()) {
                return (DLKeyBean) new Gson().fromJson(doorLockEntryptData.Data, DLKeyBean.class);
            }
            throw HttpException.filter(doorLockEntryptData.Code, doorLockEntryptData.getErrMsg(), doorLockEntryptData.Data, doorLockEntryptData.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean getDoorLockUploadRecords(String str, int i, long j, String str2, String str3, String str4) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("schoolid", j + "").combind("userid", str2).combind("random", str3).combind("data", str4);
            String doorLockCode = getDoorLockCode(combindBean);
            String doorLockSign = getDoorLockSign(doorLockCode);
            Log.e(TAG, combindBean.toString());
            LogUtil.log(combindBean.toString());
            BaseBean<SuccessBean> doorLockUploadRecords = this.mProtocolTest.getDoorLockUploadRecords(doorLockCode, doorLockSign, str, "140000000000000001", "2");
            if (doorLockUploadRecords.ok()) {
                return doorLockUploadRecords.Data;
            }
            throw HttpException.filter(doorLockUploadRecords.Code, doorLockUploadRecords.getErrMsg(), doorLockUploadRecords.Data, doorLockUploadRecords.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public DoorLockRecordsBean getDoorLockRecords(String str, int i, long j, String str2, String str3, int i2, int i3) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("schoolid", j + "").combind("userid", str2).combind("random", str3).combind("pageNum", i2 + "").combind("pageSize", i3 + "");
            String doorLockCode = getDoorLockCode(combindBean);
            String doorLockSign = getDoorLockSign(doorLockCode);
            Log.e(TAG, combindBean.toString());
            LogUtil.log(combindBean.toString());
            BaseBean<DoorLockRecordsBean> doorLockRecords = this.mProtocolTest.getDoorLockRecords(doorLockCode, doorLockSign, str, "140000000000000001", "2");
            if (doorLockRecords.ok()) {
                return doorLockRecords.Data;
            }
            throw HttpException.filter(doorLockRecords.Code, doorLockRecords.getErrMsg(), doorLockRecords.Data, doorLockRecords.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean getDoorLockStatus(String str, int i, long j, String str2, String str3, String str4, String str5, String str6, String str7, int i2) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind(RechargeRecordActivity.EXTRA_TYPEID, i + "").combind("schoolid", j + "").combind("userid", str2).combind("random", str3).combind("sn", str4).combind("roomid", str5).combind("hardwareVersion", str6).combind(am.Z, str7).combind("dataSize", i2 + "");
            String doorLockCode = getDoorLockCode(combindBean);
            String doorLockSign = getDoorLockSign(doorLockCode);
            Log.e(TAG, combindBean.toString());
            LogUtil.log(combindBean.toString());
            BaseBean<SuccessBean> doorLockStatus = this.mProtocolTest.getDoorLockStatus(doorLockCode, doorLockSign, str, "140000000000000001", "2");
            if (doorLockStatus.ok()) {
                return doorLockStatus.Data;
            }
            throw HttpException.filter(doorLockStatus.Code, doorLockStatus.getErrMsg(), doorLockStatus.Data, doorLockStatus.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SoundWaveDrinkWaterCleanData xiZaoCleanData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("investorid", str2 + "").combind(RechargeRecordActivity.EXTRA_TYPEID, str3 + "").combind("alleywaytype", str4 + "").combind("studentid", str5 + "").combind("machineid", str6 + "").combind("machinedata", str7 + "").combind("machineflag", str8 + "").combind("alleywaytype", str4 + "").combind("version", str9 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<SoundWaveDrinkWaterCleanData> xiZaoCleanData = this.mProtocolTest.getXiZaoCleanData(code, sign, str);
            if (xiZaoCleanData.ok()) {
                return xiZaoCleanData.Data;
            }
            throw HttpException.filter(xiZaoCleanData.Code, xiZaoCleanData.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    private String getCode(CombindBean combindBean) throws HttpException {
        try {
            return AESHelper.encrypt(combindBean.toString(), StringUtils.asciiToString("121,107,116,95,50,48,49,55,95,64,37,48,50,48,95,87,90,81,73,84,83,84,89,85,73,74,104,100,48,56,48,50"));
        } catch (Exception unused) {
            throw new HttpException(-1001, "获取服务器数据失败");
        }
    }

    private String getSign(String str) {
        return MD5.md5(StringUtils.asciiToString("121,107,116,42,37,95,99,79") + str);
    }

    private String getDoorLockCode(CombindBean combindBean) throws HttpException {
        try {
            return AESHelper.encrypt(combindBean.toString(), StringUtils.asciiToString("121,107,116,95,50,48,49,55,95,64,37,48,50,48,95,87,90,81,73,84,83,84,89,85,73,74,104,100,48,56,48,50"));
        } catch (Exception unused) {
            throw new HttpException(-1001, "获取服务器数据失败");
        }
    }

    private String getDoorLockSign(String str) {
        return MD5.md5(StringUtils.asciiToString("121,107,116,42,37,95,99,79") + str);
    }

    class CombindBean {
        private String returnStr = "";

        CombindBean() {
        }

        public CombindBean combind(String str, String str2) {
            if (str2 != null && !str2.equals("null")) {
                this.returnStr += (str + "=" + str2 + "#?");
            }
            return this;
        }

        public String toString() {
            String str = new String(this.returnStr);
            return str.length() >= 2 ? str.substring(0, str.length() - 2) : str;
        }
    }

    public static String decryptData(String str) {
        try {
            return AESHelper.decrypt(str, StringUtils.asciiToString("121,107,116,95,50,48,49,55,95,64,37,48,50,48,95,87,90,81,73,84,83,84,89,85,73,74,104,100,48,56,48,50"));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
