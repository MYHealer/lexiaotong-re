package client.android.yixiaotong.v3.util;

import android.content.Context;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.TimeUtils;
import client.android.yixiaotong.util.android.LocalPreferencesHelper;
import client.android.yixiaotong.v3.bean.login.InvestorInfosBean;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtil;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.unionpay.tsmservice.mi.data.Constant;
import java.util.Calendar;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class LocalDataUtil {
    public static final String TAG = "LocalDataUtil";

    public static boolean getIsCheckVer(long j) {
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        if (j > jCurrentTimeMillis) {
            jCurrentTimeMillis = j;
        }
        LogUtil.e(TAG, j + PPSLabelView.Code + jCurrentTimeMillis);
        return jCurrentTimeMillis < 172800;
    }

    public static void saveUrl(Context context, String str) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("url", str);
    }

    public static String getUrl(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getString("url");
    }

    public static void saveUrlRequestTime(Context context, String str, String str2, long j) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("urlrequesttime_" + str + str2, j);
    }

    public static long getRequestTime(Context context, String str, String str2) {
        return new LocalPreferencesHelper(context, "localdata").getLong("urlrequesttime_" + str + str2, 0L);
    }

    public static void saveLonginAccount(Context context, String str) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("accountv3", str);
    }

    public static String getLonginAccount(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getString("accountv3");
    }

    public static void saveFirstLogin(Context context, boolean z) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("firstlogin", z);
    }

    public static boolean getFirstLogin(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getBooleanDefaultTrue("firstlogin");
    }

    public static void saveAppVer(Context context, String str) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("appverv3", str);
    }

    public static String getAppVer(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getString("appverv3");
    }

    public static void saveAppVerOld(Context context, String str) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("appverold", str);
    }

    public static String getAppVerOld(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getString("appverold");
    }

    public static void saveAppVerTip(Context context, String str) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("appverv3tip", str);
    }

    public static String getAppVerTip(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getString("appverv3tip");
    }

    public static void saveTraceID(Context context, String str) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("traceid", str);
    }

    public static String getTraceID(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getString("traceid");
    }

    public static void saveCode(Context context, int i) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("code", i);
    }

    public static int getCode(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getInt("code", 0);
    }

    public static void saveErrorUrl(Context context, String str) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("errorurl", str);
    }

    public static String getErrorUrl(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getString("errorurl");
    }

    public static void saveErrorHeader(Context context, String str) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("errorheader", str);
    }

    public static String getErrorHeader(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getString("errorheader");
    }

    public static void saveErrorHeaderResponse(Context context, String str) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("errorheaderresponse", str);
    }

    public static String getErrorHeaderResponse(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getString("errorheaderresponse");
    }

    public static void saveErrorBody(Context context, String str) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("errorbody", str);
    }

    public static String getErrorBody(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getString("errorbody");
    }

    public static void saveErrorBodyResponse(Context context, String str) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("errorbodyresponse", str);
    }

    public static String getErrorBodyResponse(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getString("errorbodyresponse");
    }

    public static void saveError50XTip(Context context, boolean z) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("isshowerroe50x", z);
    }

    public static boolean getError50XTip(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getBooleanDefaultFalse("isshowerroe50x");
    }

    public static void saveLastTokenInfo(Context context, String str) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("tokeninfo", str);
    }

    public static String getLastTokenInfo(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getString("tokeninfo");
    }

    public static void saveRoute(Context context, String str) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("route", str);
    }

    public static String getRoute(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getString("route");
    }

    public static void savePlatformInfo(Context context, int i) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("platforminfo", i);
    }

    public static int getPlatformInfo(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getInt("platforminfo", -1);
    }

    public static void savePlatformSchoolName(Context context, String str) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("schoolname", str);
    }

    public static String getPlatformSchoolName(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getString("schoolname");
    }

    public static void saveClientTypeInfo(Context context, String str) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("clienttypeinfo", str);
    }

    public static String getClientTypeInfo(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getString("clienttypeinfo");
    }

    public static void saveIsNeedGetWalletInfo(Context context, boolean z) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("isneedgetwallinfo", z);
    }

    public static boolean getIsNeedGetWalletInfo(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getBooleanDefaultTrue("isneedgetwallinfo");
    }

    public static void saveIsNeedGetCashRedPackageInfo(Context context, boolean z) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("isneedgetcashredpackageinfo", z);
    }

    public static boolean getIsNeedGetCashRedPackageInfo(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getBooleanDefaultTrue("isneedgetcashredpackageinfo");
    }

    public static void saveIsNeedGetPrepaymentWalletInfo(Context context, boolean z) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("isneedgetprepaymentwallinfo", z);
    }

    public static boolean getIsNeedGetPrepaymentWalletInfo(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getBooleanDefaultFalse("isneedgetprepaymentwallinfo");
    }

    public static void savePrepaymentAddress(Context context, String str) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("prepaymentaddress", str);
    }

    public static String getPrepaymentAddress(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getString("prepaymentaddress");
    }

    public static void saveIsNeedGetPrepaymentSupervisorInfo(Context context, boolean z) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("isneedgetprepaymentsupervisorinfo", z);
    }

    public static boolean getIsNeedGetPrepaymentSupervisorInfo(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getBooleanDefaultFalse("isneedgetprepaymentsupervisorinfo");
    }

    public static void saveBathMacInfo(Context context, String str) {
        LogUtil.e(TAG, UserInfoUtilControl.getInstance().getSchoolId() + PPSLabelView.Code + str);
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate(Constant.KEY_MAC + UserInfoUtilControl.getInstance().getSchoolId(), str);
    }

    public static String getBathMacInfo(Context context) {
        String string = new LocalPreferencesHelper(context, "localdata").getString(Constant.KEY_MAC + UserInfoUtilControl.getInstance().getSchoolId());
        LogUtil.e(TAG, UserInfoUtilControl.getInstance().getSchoolId() + PPSLabelView.Code + string);
        return string;
    }

    public static void saveArea1(Context context, String str) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("area1" + UserInfoUtilControl.getInstance().getSchoolId(), str);
    }

    public static String getArea1(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getString("area1" + UserInfoUtilControl.getInstance().getSchoolId());
    }

    public static void saveArea2(Context context, String str) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("area2" + UserInfoUtilControl.getInstance().getSchoolId(), str);
    }

    public static String getArea2(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getString("area2" + UserInfoUtilControl.getInstance().getSchoolId());
    }

    public static void saveArea3(Context context, String str) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("area3" + UserInfoUtilControl.getInstance().getSchoolId(), str);
    }

    public static String getArea3(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getString("area3" + UserInfoUtilControl.getInstance().getSchoolId());
    }

    public static void saveArea4(Context context, String str) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("area4" + UserInfoUtilControl.getInstance().getSchoolId(), str);
    }

    public static String getArea4(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getString("area4" + UserInfoUtilControl.getInstance().getSchoolId());
    }

    public static void saveBathMacs(Context context, String str, int i) {
        LocalPreferencesHelper localPreferencesHelper = new LocalPreferencesHelper(context, "localdata");
        String bathMacs = getBathMacs(context, i);
        if (StringUtils.isNotEmpty(bathMacs)) {
            localPreferencesHelper.saveOrUpdate("macs" + i, bathMacs + "," + str);
        } else {
            localPreferencesHelper.saveOrUpdate("macs" + i, Calendar.getInstance().get(5) + "," + str);
        }
    }

    public static String getBathMacs(Context context, int i) {
        return new LocalPreferencesHelper(context, "localdata").getString("macs" + i);
    }

    public static boolean isAllowConnect(Context context, String str, int i, int i2) {
        String bathMacs = getBathMacs(context, i);
        if (!StringUtils.isNotEmpty(bathMacs) || bathMacs.contains(str)) {
            return true;
        }
        int i3 = Calendar.getInstance().get(5);
        String[] strArrSplit = bathMacs.split(",");
        if (i3 == Integer.parseInt(strArrSplit[0])) {
            return strArrSplit.length < i2;
        }
        saveBathMacs(context, "", i);
        return true;
    }

    public static void saveIsNeedLoadUserInfo(Context context, boolean z) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("isneedloaduserinfo", z);
    }

    public static boolean isNeedLoadUserInfos(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getBooleanDefaultFalse("isneedloaduserinfo");
    }

    public static void saveIsNeedLoadInvestorInfo(Context context, boolean z) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("isneedloadinvestorinfo", z);
    }

    public static boolean isNeedLoadInvestorInfos(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getBooleanDefaultFalse("isneedloadinvestorinfo");
    }

    public static void saveUnFinshOrderId(Context context, String str) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("unorderid", str);
    }

    public static String getUnFinshOrderTd(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getString("unorderid");
    }

    public static void saveAdvTime(Context context, String str, String str2, String str3) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("adv_" + str + "_" + str2 + "_time", str3);
    }

    public static String getAdvTime(Context context, String str, String str2) {
        return new LocalPreferencesHelper(context, "localdata").getString("adv_" + str + "_" + str2 + "_time");
    }

    public static void saveAdvInfo(Context context, String str, String str2, int i, String str3) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("adv_" + str + "_" + str2 + "_" + i, str3);
    }

    public static String getAdvInfo(Context context, String str, String str2, int i) {
        return new LocalPreferencesHelper(context, "localdata").getString("adv_" + str + "_" + str2 + "_" + i);
    }

    public static void saveAdvBannerJumpInfo(Context context, String str, String str2, String str3) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("adv_jump_" + str + "_" + str2, str3);
    }

    public static String getAdvBannerJumpInfo(Context context, String str, String str2) {
        return new LocalPreferencesHelper(context, "localdata").getString("adv_jump_" + str + "_" + str2);
    }

    public static void saveAdvlaunchCount(Context context, int i) {
        LocalPreferencesHelper localPreferencesHelper = new LocalPreferencesHelper(context, "localdata");
        String time = TimeUtils.formatTime(System.currentTimeMillis());
        String string = localPreferencesHelper.getString("launchtime" + i);
        int advlaunchCount = 1;
        if (StringUtils.isNotEmpty(string) && string.equals(time)) {
            advlaunchCount = 1 + getAdvlaunchCount(context, i);
        }
        localPreferencesHelper.saveOrUpdate("launchtime" + i, time);
        localPreferencesHelper.saveOrUpdate("launch" + i, advlaunchCount);
    }

    public static int getAdvlaunchCount(Context context, int i) {
        LocalPreferencesHelper localPreferencesHelper = new LocalPreferencesHelper(context, "localdata");
        String string = localPreferencesHelper.getString("launchtime" + i);
        String time = TimeUtils.formatTime(System.currentTimeMillis());
        LogUtil.e("getAdvlaunchCount", string + "  " + time);
        if (StringUtils.isNotEmpty(string) && string.equals(time)) {
            return localPreferencesHelper.getInt("launch" + i, 0);
        }
        return 0;
    }

    public static void saveAppointmentArea(Context context, String str) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("appointmentarea" + UserInfoUtilControl.getInstance().getSchoolId(), str);
    }

    public static String getAppointmentArea(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getString("appointmentarea" + UserInfoUtilControl.getInstance().getSchoolId());
    }

    public static void saveGuideTip(Context context, int i) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("appguide_" + i, false);
    }

    public static boolean getGuideTip(Context context, int i) {
        return new LocalPreferencesHelper(context, "localdata").getBooleanDefaultTrue("appguide_" + i);
    }

    public static void saveAccoutPsw(Context context, String str, String str2) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("accountpsw", str + "," + str2);
    }

    public static String getAccountPsw(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getString("accountpsw");
    }

    public static void saveAccoutCancelTime(Context context, String str, String str2) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("accountcancel_" + str, str2);
    }

    public static String getAccoutCancelTime(Context context, String str) {
        return new LocalPreferencesHelper(context, "localdata").getString("accountcancel_" + str);
    }

    public static void saveCurrentTime(Context context, String str) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("currenttime", str);
    }

    public static String getCurrentTime(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getString("currenttime");
    }

    public static void saveCardId(Context context, String str) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("cardid", str);
    }

    public static String getCardId(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getString("cardid");
    }

    public static void saveIsNeedChangePsw(Context context, boolean z) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("isneedchangepsw", z);
    }

    public static boolean getIsNeedChangePsw(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getBooleanDefaultFalse("isneedchangepsw");
    }

    public static void saveAppVersion(Context context, String str) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("appversion", str);
    }

    public static String getAppVersion(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getString("appversion");
    }

    public static void saveIsNeedLoadVersion(Context context, int i) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("isneedloadversion", i);
    }

    public static int getIsNeedLoadVersion(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getInt("isneedloadversion", 0);
    }

    public static void saveIsNeedLoadZKT(Context context, boolean z) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("signzkt", z);
    }

    public static boolean getIsNeedLoadZKTTip(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getBooleanDefaultTrue("signzkt");
    }

    public static void saveIsNeedLoadAdv(Context context, boolean z) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("isneedloadadv", z);
    }

    public static boolean getIsNeedLoadAdv(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getBooleanDefaultFalse("isneedloadadv");
    }

    public static void saveAndroidId(Context context, String str) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("androidid", str);
    }

    public static String getAndroidId(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getString("androidid");
    }

    public static void saveUuid(Context context, String str) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate(com.huawei.hms.ads.jsb.constant.Constant.MAP_KEY_UUID, str);
    }

    public static String getUuid(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getString(com.huawei.hms.ads.jsb.constant.Constant.MAP_KEY_UUID);
    }

    public static void saveAdvRuleInfo(Context context, String str) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("advruleinfo", str);
    }

    public static String getAdvRuleInfo(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getString("advruleinfo");
    }

    public static int getAdvSplashCount(Context context) {
        String string = new LocalPreferencesHelper(context, "localdata").getString("advsplashcount");
        if (StringUtils.isNotEmpty(string) && string.contains(TimeUtils.formatDate(System.currentTimeMillis()))) {
            String[] strArrSplit = string.split(",");
            if (strArrSplit.length > 1) {
                return Integer.parseInt(strArrSplit[1]);
            }
        }
        return 0;
    }

    public static void saveSplashPlayTime(Context context, long j) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("splashplaytime", j);
    }

    public static long getSplashPlayTime(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getLong("splashplaytime", 0L);
    }

    public static void saveAppUpdateUrl(Context context, String str) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("appupdateurl", str);
    }

    public static String getAppUpdateUrl(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getString("appupdateurl");
    }

    public static void saveTypeIdArea(Context context, int i, String str) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("typeidarea" + UserInfoUtilControl.getInstance().getSchoolId() + i, str);
    }

    public static String getTypeIdArea(Context context, int i) {
        return new LocalPreferencesHelper(context, "localdata").getString("typeidarea" + UserInfoUtilControl.getInstance().getSchoolId() + i);
    }

    public static void saveTypeIdMachineId(Context context, int i, String str) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("typeidmachineid" + UserInfoUtilControl.getInstance().getSchoolId() + i, str);
    }

    public static String getTypeIdMachineId(Context context, int i) {
        return new LocalPreferencesHelper(context, "localdata").getString("typeidmachineid" + UserInfoUtilControl.getInstance().getSchoolId() + i);
    }

    public static void saveIsNeedTipSignZKT(Context context, boolean z) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("isneedsignzkt", z);
    }

    public static boolean getIsNeedTipSignZKT(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getBooleanDefaultTrue("isneedsignzkt");
    }

    public static void saveIsNeedTipSignZKT(Context context) {
        LocalPreferencesHelper localPreferencesHelper = new LocalPreferencesHelper(context, "localdata");
        List<String> list = UserInfoUtil.getInstance().getLoginAccountV3().schoolList;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (String str : list) {
            List<InvestorInfosBean> investorInfosV3 = InvestorInfoUtil.getInstance().getInvestorInfosV3();
            if (investorInfosV3 != null && investorInfosV3.size() > 0) {
                for (int i = 0; i < investorInfosV3.size(); i++) {
                    InvestorInfosBean investorInfosBean = investorInfosV3.get(i);
                    if (investorInfosBean != null) {
                        localPreferencesHelper.saveOrUpdate("isneedsignzkt" + str + investorInfosBean.investorInfo.investorId, true);
                    }
                }
            }
        }
    }

    public static void saveIsNeedTipSignZKT(Context context, boolean z, String str, String str2) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("isneedsignzkt" + str + str2, z);
    }

    public static boolean getIsNeedTipSignZKT(Context context, String str, String str2) {
        return new LocalPreferencesHelper(context, "localdata").getBooleanDefaultTrue("isneedsignzkt" + str + str2);
    }

    public static void saveIsEnableOffline(Context context, boolean z) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("offlineopen", z);
    }

    public static boolean getIsEnableOffline(Context context) {
        boolean booleanDefaultFalse = new LocalPreferencesHelper(context, "localdata").getBooleanDefaultFalse("offlineopen");
        long enableOfflineTime = getEnableOfflineTime(context);
        LogUtil.e(TAG, "getIsEnableOffline:" + enableOfflineTime + "  " + booleanDefaultFalse);
        long jCurrentTimeMillis = (System.currentTimeMillis() / 1000) - enableOfflineTime;
        LogUtil.e(TAG, "time:" + jCurrentTimeMillis);
        if (jCurrentTimeMillis > 0) {
            return false;
        }
        return booleanDefaultFalse;
    }

    public static void saveEnableOfflineTime(Context context, Integer num) {
        if (num != null) {
            long jCurrentTimeMillis = (System.currentTimeMillis() / 1000) + ((long) (num.intValue() * 86400));
            LogUtil.e(TAG, "saveEnableOfflineTime:" + jCurrentTimeMillis);
            new LocalPreferencesHelper(context, "localdata").saveOrUpdate("offlinetime", jCurrentTimeMillis);
        }
    }

    public static long getEnableOfflineTime(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getLong("offlinetime", 0L);
    }

    public static void saveIsFirstOffline(Context context, boolean z) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("firstoffline", z);
    }

    public static boolean getIsFirstOffline(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getBooleanDefaultFalse("firstoffline");
    }

    public static void saveLanuage(Context context, String str) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("language", str);
    }

    public static String getLanuage(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getString("language");
    }

    public static void saveLanuaging(Context context, boolean z) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("languaging", z);
    }

    public static boolean getIsSaveLanuaging(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getBooleanDefaultFalse("languaging");
    }

    public static boolean getIsAgreed(Context context, int i) {
        return new LocalPreferencesHelper(context, "localdata").getInt(new StringBuilder("permiss_").append(i).toString(), 0) == 1;
    }

    public static void savePermissIndex(Context context, int i) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("permiss_" + i, 1);
    }

    public static Long getLoginDeviceInfo(Context context) {
        return Long.valueOf(new LocalPreferencesHelper(context, "localdata").getLong("logindeviceinfo", 0L));
    }

    public static void saveLoginDeviceInfo(Context context) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("logindeviceinfo", System.currentTimeMillis());
    }

    public static void saveTestMode(Context context, int i) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("testmode", i);
    }

    public static int getTestMode(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getInt("testmode", 0);
    }

    public static void savePaySuccess(Context context, int i) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("paysuccess", i);
    }

    public static int getPaySuccessResult(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getInt("paysuccess", 0);
    }

    public static void saveOpenSuccessInfo(Context context, String str, String str2) {
        LocalPreferencesHelper localPreferencesHelper = new LocalPreferencesHelper(context, "localdata");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (StringUtils.isNotEmpty(str2)) {
            saveOpenTime(context, jCurrentTimeMillis);
        } else {
            saveOpenTime(context, 0L);
        }
        localPreferencesHelper.saveOrUpdate("opensuccessinfo_" + str, str2);
    }

    public static String getOpenSuccessInfo(Context context, String str) {
        return new LocalPreferencesHelper(context, "localdata").getString("opensuccessinfo_" + str);
    }

    public static void saveLoadWalletDate(Context context) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("loadwalletdate_" + UserInfoUtilControl.getInstance().getStudentId() + UserInfoUtilControl.getInstance().getSchoolId(), TimeUtils.formatTime(System.currentTimeMillis()));
    }

    public static String getLoadWalletDate(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getString("loadwalletdate_" + UserInfoUtilControl.getInstance().getStudentId() + UserInfoUtilControl.getInstance().getSchoolId());
    }

    public static void saveDesktopToMainPage(Context context, boolean z) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("desktoptopage_", z);
    }

    public static boolean getDesktopToMainPage(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getBooleanDefaultTrue("desktoptopage_");
    }

    public static void saveSchoolId(Context context, String str) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("schoolid_", str);
    }

    public static String getSchoolId(Context context) {
        String string = new LocalPreferencesHelper(context, "localdata").getString("schoolid_");
        return StringUtils.isNotEmpty(string) ? string : "-1";
    }

    public static void saveOpenDeviceForUser(Context context, String str) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("opendeviceforuser_" + str, true);
    }

    public static boolean getOpenDeviceForUser(Context context, String str) {
        return new LocalPreferencesHelper(context, "localdata").getBooleanDefaultFalse("opendeviceforuser_" + str);
    }

    public static void saveUseDeviceTimeoutAlert(Context context, int i) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("useDeviceTimeoutAlert_" + UserInfoUtilControl.getInstance().getSchoolId(), i);
    }

    public static int getUseDeviceTimeoutAlert(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getInt("useDeviceTimeoutAlert_" + UserInfoUtilControl.getInstance().getSchoolId(), 0);
    }

    public static void saveOpenTime(Context context, long j) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("opentime_" + UserInfoUtilControl.getInstance().getSchoolId(), j);
    }

    public static long getOpenTime(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getLong("opentime_" + UserInfoUtilControl.getInstance().getSchoolId(), 0L);
    }

    public static void saveBLEUseRecord(Context context, int i, String str, String str2, String str3) {
        LocalPreferencesHelper localPreferencesHelper = new LocalPreferencesHelper(context, "localdata");
        String bLEUseRecord = getBLEUseRecord(context);
        if (StringUtils.isNotEmpty(bLEUseRecord)) {
            localPreferencesHelper.saveOrUpdate("bleuserecord_", bLEUseRecord + ";" + i + "," + str + "," + str2 + "," + str3);
        } else {
            localPreferencesHelper.saveOrUpdate("bleuserecord_", i + "," + str + "," + str2 + "," + str3);
        }
    }

    public static String getBLEUseRecord(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getString("bleuserecord_");
    }

    public static void clearBLEUseRecord(Context context, String str) {
        LocalPreferencesHelper localPreferencesHelper = new LocalPreferencesHelper(context, "localdata");
        String string = localPreferencesHelper.getString("bleuserecord_");
        if (string.contains(str)) {
            String[] strArrSplit = string.split(";");
            StringBuilder sb = new StringBuilder();
            for (String str2 : strArrSplit) {
                if (!str2.contains(str)) {
                    sb.append(str2).append(";");
                }
            }
            if (StringUtils.isNotEmpty(sb.toString())) {
                sb.deleteCharAt(sb.length() - 1);
            }
            localPreferencesHelper.saveOrUpdate("bleuserecord_", sb.toString());
        }
    }

    public static void saveAlarmSwitch(Context context, boolean z) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("alarmswitch", z);
    }

    public static boolean getAlarmSwitch(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getBooleanDefaultFalse("alarmswitch");
    }

    public static void saveAlarmPsw(Context context, String str) {
        LocalPreferencesHelper localPreferencesHelper = new LocalPreferencesHelper(context, "localdata");
        LogUtil.e("AlarmPswTrace", "LocalDataUtil.saveAlarmPsw openPassword=" + str + " caller=" + getAlarmPswCallSource());
        localPreferencesHelper.saveOrUpdate("alarmswitchpsw", str);
    }

    public static String getAlarmPsw(Context context) {
        String string = new LocalPreferencesHelper(context, "localdata").getString("alarmswitchpsw");
        LogUtil.e("AlarmPswTrace", "LocalDataUtil.getAlarmPsw openPassword=" + string + " caller=" + getAlarmPswCallSource());
        return string;
    }

    private static String getAlarmPswCallSource() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (int i = 3; i < stackTrace.length; i++) {
            String className = stackTrace[i].getClassName();
            if (!LocalDataUtil.class.getName().equals(className)) {
                return className + "." + stackTrace[i].getMethodName() + x.bQ + stackTrace[i].getLineNumber();
            }
        }
        return "";
    }

    public static void saveBindGiveID(Context context, String str) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("bindgiveid", str);
    }

    public static String getBindGiveID(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getString("bindgiveid");
    }
}
