package client.android.yixiaotong.v3.util;

import android.app.Activity;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class Error50XUtil {
    private static final String ACTIVITYSTRING = "LoginActivity,V3MainActivity,DryControlActivity,WashControlActivity,HairdryerControlActivity,DrinkWaterControlActivity,BathControlActivity,DrawMoneyControlActivity";
    private static final String TAG = "Error50XUtil";

    public static boolean isInterrupt(Activity activity) {
        LogUtil.e(TAG, "isInterrupt");
        if (activity != null) {
            int code = LocalDataUtil.getCode(activity);
            LogUtil.e(TAG, "isInterrupt:" + code);
            if (code >= 500 && code < 600) {
                return true;
            }
        }
        return false;
    }

    public static boolean isFinishActivity(Activity activity) {
        String[] strArrSplit;
        if (activity == null || (strArrSplit = activity.getLocalClassName().split("\\.")) == null || strArrSplit.length <= 0 || !ACTIVITYSTRING.contains(strArrSplit[strArrSplit.length - 1])) {
            return true;
        }
        LogUtil.e(TAG, "isFinishActivity:" + strArrSplit[strArrSplit.length - 1]);
        return false;
    }
}
