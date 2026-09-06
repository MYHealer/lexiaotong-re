package client.android.yixiaotong.v4.util;

import android.content.Context;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.android.LocalPreferencesHelper;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.http.bean.V4ServerListBean;
import client.android.yixiaotong.v4.util.userinfo.V4UserInfoBean;
import client.android.yixiaotong.v4.util.userinfo.V4UserInfoUtil;
import com.unionpay.tsmservice.mi.data.Constant;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4LocalDataUtil {
    private static final String TAG = "V4LocalDataUtil";
    private static final String dbname = "v4localdata";

    public static void saveOfflineLog(Context context, String str, String str2) {
        LocalPreferencesHelper localPreferencesHelper = new LocalPreferencesHelper(context, dbname);
        LogUtil.e(TAG, "saveOfflineLog;" + str + "  " + str2);
        if (StringUtils.isNotEmpty(str2)) {
            saveOfflineMac(context, str);
            localPreferencesHelper.saveOrUpdate("offlinelog" + V4UserInfoUtil.getInstance().getLoginAccountV4().hexUserId + str, getOfflineLog(context, str) + str2);
        } else {
            delectOfflineMac(context, str);
            localPreferencesHelper.saveOrUpdate("offlinelog" + V4UserInfoUtil.getInstance().getLoginAccountV4().hexUserId + str, "");
        }
    }

    public static String getOfflineLog(Context context, String str) {
        return new LocalPreferencesHelper(context, dbname).getString("offlinelog" + V4UserInfoUtil.getInstance().getLoginAccountV4().hexUserId + str);
    }

    private static void saveOfflineMac(Context context, String str) {
        LocalPreferencesHelper localPreferencesHelper = new LocalPreferencesHelper(context, dbname);
        String string = localPreferencesHelper.getString("offlinemac" + V4UserInfoUtil.getInstance().getLoginAccountV4().hexUserId);
        if (StringUtils.isNotEmpty(string) && string.contains(str)) {
            return;
        }
        if (StringUtils.isNotEmpty(string)) {
            localPreferencesHelper.saveOrUpdate("offlinemac" + V4UserInfoUtil.getInstance().getLoginAccountV4().hexUserId, string + "," + str);
        } else {
            localPreferencesHelper.saveOrUpdate("offlinemac" + V4UserInfoUtil.getInstance().getLoginAccountV4().hexUserId, str);
        }
    }

    public static void delectOfflineMac(Context context, String str) {
        LocalPreferencesHelper localPreferencesHelper = new LocalPreferencesHelper(context, dbname);
        String string = localPreferencesHelper.getString("offlinemac" + V4UserInfoUtil.getInstance().getLoginAccountV4().hexUserId);
        String str2 = str + ",";
        String str3 = "," + str;
        if (StringUtils.isNotEmpty(string)) {
            if (string.contains(str2)) {
                string = string.replace(str2, "");
            } else if (string.contains(str3)) {
                string = string.replace(str3, "");
            } else if (string.contains(str)) {
                string = string.replace(str, "");
            }
            localPreferencesHelper.saveOrUpdate("offlinemac" + V4UserInfoUtil.getInstance().getLoginAccountV4().hexUserId, string);
        }
    }

    public static String getOfflineMac(Context context) {
        String string = new LocalPreferencesHelper(context, dbname).getString("offlinemac" + V4UserInfoUtil.getInstance().getLoginAccountV4().hexUserId);
        LogUtil.e(TAG, "getOfflineMac:" + string);
        if (!StringUtils.isNotEmpty(string)) {
            return "";
        }
        String[] strArrSplit = string.split(",");
        return strArrSplit.length >= 1 ? strArrSplit[0] : "";
    }

    public static void saveBathMacInfo(Context context, String str) {
        new LocalPreferencesHelper(context, dbname).saveOrUpdate(Constant.KEY_MAC + V4UserInfoUtil.getInstance().getLoginAccountV4().hexUserId, str);
    }

    public static String getBathMacInfo(Context context) {
        return new LocalPreferencesHelper(context, dbname).getString(Constant.KEY_MAC + V4UserInfoUtil.getInstance().getLoginAccountV4().hexUserId);
    }

    public static void saveGuideTip(Context context, int i) {
        new LocalPreferencesHelper(context, dbname).saveOrUpdate("appguide_" + i, false);
    }

    public static boolean getGuideTip(Context context, int i) {
        return new LocalPreferencesHelper(context, dbname).getBooleanDefaultTrue("appguide_" + i);
    }

    public static void saveOpenSuccessInfo(Context context, String str, String str2) {
        new LocalPreferencesHelper(context, dbname).saveOrUpdate("opensuccessinfo_" + str, str2);
    }

    public static String getOpenSuccessInfo(Context context, String str) {
        return new LocalPreferencesHelper(context, dbname).getString("opensuccessinfo_" + str);
    }

    public static void saveIsEnableOffline(Context context, boolean z) {
        new LocalPreferencesHelper(context, dbname).saveOrUpdate("offlineopen", z);
    }

    public static boolean getIsEnableOffline(Context context) {
        return new LocalPreferencesHelper(context, dbname).getBooleanDefaultFalse("offlineopen");
    }

    public static void saveAppUpdateUrl(Context context, String str) {
        new LocalPreferencesHelper(context, dbname).saveOrUpdate("appupdateurl", str);
    }

    public static String getAppUpdateUrl(Context context) {
        return new LocalPreferencesHelper(context, dbname).getString("appupdateurl");
    }

    public static void saveIsNeedLoadVersion(Context context, int i) {
        new LocalPreferencesHelper(context, dbname).saveOrUpdate("isneedloadversion", i);
    }

    public static int getIsNeedLoadVersion(Context context) {
        return new LocalPreferencesHelper(context, dbname).getInt("isneedloadversion", 0);
    }

    public static void saveAppVer(Context context, String str) {
        new LocalPreferencesHelper(context, dbname).saveOrUpdate("appverv3", str);
    }

    public static String getAppVer(Context context) {
        return new LocalPreferencesHelper(context, dbname).getString("appverv3");
    }

    public static void saveAppVerTip(Context context, String str) {
        new LocalPreferencesHelper(context, "localdata").saveOrUpdate("appverv3tip", str);
    }

    public static String getAppVerTip(Context context) {
        return new LocalPreferencesHelper(context, "localdata").getString("appverv3tip");
    }

    public static void saveArea1(Context context, String str) {
        new LocalPreferencesHelper(context, dbname).saveOrUpdate("area1" + UserInfoUtilControl.getInstance().getSchoolId(), str);
    }

    public static String getArea1(Context context) {
        return new LocalPreferencesHelper(context, dbname).getString("area1" + UserInfoUtilControl.getInstance().getSchoolId());
    }

    public static void saveArea2(Context context, String str) {
        new LocalPreferencesHelper(context, dbname).saveOrUpdate("area2" + UserInfoUtilControl.getInstance().getSchoolId(), str);
    }

    public static String getArea2(Context context) {
        return new LocalPreferencesHelper(context, dbname).getString("area2" + UserInfoUtilControl.getInstance().getSchoolId());
    }

    public static void saveArea3(Context context, String str) {
        new LocalPreferencesHelper(context, dbname).saveOrUpdate("area3" + UserInfoUtilControl.getInstance().getSchoolId(), str);
    }

    public static String getArea3(Context context) {
        return new LocalPreferencesHelper(context, dbname).getString("area3" + UserInfoUtilControl.getInstance().getSchoolId());
    }

    public static void saveArea4(Context context, String str) {
        new LocalPreferencesHelper(context, dbname).saveOrUpdate("area4" + UserInfoUtilControl.getInstance().getSchoolId(), str);
    }

    public static String getArea4(Context context) {
        return new LocalPreferencesHelper(context, dbname).getString("area4" + UserInfoUtilControl.getInstance().getSchoolId());
    }

    public static void saveAccoutCancelTime(Context context, String str, String str2) {
        new LocalPreferencesHelper(context, dbname).saveOrUpdate("accountcancel_" + str, str2);
    }

    public static String getAccoutCancelTime(Context context, String str) {
        return new LocalPreferencesHelper(context, dbname).getString("accountcancel_" + str);
    }

    public static void saveCurrentTime(Context context, String str) {
        new LocalPreferencesHelper(context, dbname).saveOrUpdate("currenttime", str);
    }

    public static String getCurrentTime(Context context) {
        return new LocalPreferencesHelper(context, dbname).getString("currenttime");
    }

    public static void saveOpenDeviceForUser(Context context, String str) {
        new LocalPreferencesHelper(context, dbname).saveOrUpdate("opendeviceforuser_" + str, true);
    }

    public static boolean getOpenDeviceForUser(Context context, String str) {
        return new LocalPreferencesHelper(context, dbname).getBooleanDefaultFalse("opendeviceforuser_" + str);
    }

    public static void saveIsNeedTipSignZKT(Context context, boolean z) {
        new LocalPreferencesHelper(context, dbname).saveOrUpdate("isneedsignzkt", z);
    }

    public static boolean getIsNeedTipSignZKT(Context context) {
        return new LocalPreferencesHelper(context, dbname).getBooleanDefaultTrue("isneedsignzkt");
    }

    public static void saveIsNeedTipSignZKT(Context context) {
        List<V4ServerListBean> list;
        LocalPreferencesHelper localPreferencesHelper = new LocalPreferencesHelper(context, dbname);
        V4UserInfoBean loginAccountV4 = V4UserInfoUtil.getInstance().getLoginAccountV4();
        if (loginAccountV4 == null || (list = loginAccountV4.serverInfoList) == null || list.size() <= 0) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            V4ServerListBean v4ServerListBean = list.get(i);
            if (v4ServerListBean != null) {
                localPreferencesHelper.saveOrUpdate("isneedsignzkt" + loginAccountV4.customerId + v4ServerListBean.serviceId, true);
            }
        }
    }

    public static void saveIsNeedTipSignZKT(Context context, boolean z, String str, String str2) {
        new LocalPreferencesHelper(context, dbname).saveOrUpdate("isneedsignzkt" + str + str2, z);
    }

    public static boolean getIsNeedTipSignZKT(Context context, String str, String str2) {
        return new LocalPreferencesHelper(context, dbname).getBooleanDefaultTrue("isneedsignzkt" + str + str2);
    }

    public static void saveIsNeedLoadZKT(Context context, boolean z) {
        new LocalPreferencesHelper(context, dbname).saveOrUpdate("signzkt", z);
    }

    public static boolean getIsNeedLoadZKTTip(Context context) {
        return new LocalPreferencesHelper(context, dbname).getBooleanDefaultFalse("signzkt");
    }

    public static void saveIsChangeCustomerOrService(Context context, boolean z) {
        new LocalPreferencesHelper(context, dbname).saveOrUpdate("changecustomerorservice", z);
    }

    public static boolean getIsChangeCustomerOrService(Context context) {
        return new LocalPreferencesHelper(context, dbname).getBooleanDefaultFalse("changecustomerorservice");
    }
}
