package client.android.yixiaotong.v3.util;

import android.app.Activity;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.util.StringUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class LanguageUtils {
    public static String getAppName(Activity activity, int i, String str) {
        String lanuage = LocalDataUtil.getLanuage(activity);
        if (!StringUtils.isNotEmpty(lanuage) || !lanuage.equals(BaseActivity.LANGUAGEEN)) {
            return str;
        }
        if (i == 1) {
            return activity.getResources().getString(R.string.bath);
        }
        if (i == 2) {
            return activity.getResources().getString(R.string.vendingmachine);
        }
        if (i == 3) {
            return activity.getResources().getString(R.string.laundry);
        }
        if (i == 6) {
            return activity.getResources().getString(R.string.drink);
        }
        if (i == 16) {
            return activity.getResources().getString(R.string.clothesdryer);
        }
        if (i == 18) {
            return activity.getResources().getString(R.string.prepaidmeter);
        }
        if (i == 20) {
            return activity.getResources().getString(R.string.drawmoney);
        }
        if (i == 23) {
            return activity.getResources().getString(R.string.washshoes);
        }
        if (i != 8) {
            return i != 9 ? str : activity.getResources().getString(R.string.sellcard);
        }
        return activity.getResources().getString(R.string.hairdryer);
    }
}
