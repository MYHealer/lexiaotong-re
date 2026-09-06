package client.android.yixiaotong.v4.util;

import android.app.Activity;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.v3.util.LocalDataUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4LanguageUtils {
    public static String getAppName(Activity activity, int i, String str) {
        String lanuage = LocalDataUtil.getLanuage(activity);
        if (!StringUtils.isNotEmpty(lanuage) || !lanuage.equals(BaseActivity.LANGUAGEEN)) {
            return str;
        }
        switch (i) {
            case 1:
                return activity.getResources().getString(R.string.bath);
            case 2:
                return activity.getResources().getString(R.string.drink);
            case 3:
                return activity.getResources().getString(R.string.hairdryer);
            case 4:
                return activity.getResources().getString(R.string.laundry);
            case 5:
            case 8:
            case 9:
            default:
                return str;
            case 6:
                return activity.getResources().getString(R.string.prepaidmeter);
            case 7:
                return activity.getResources().getString(R.string.drawmoney);
            case 10:
                return activity.getResources().getString(R.string.washshoes);
            case 11:
                return activity.getResources().getString(R.string.clothesdryer);
            case 12:
                return activity.getResources().getString(R.string.elecmeter);
            case 13:
                return activity.getResources().getString(R.string.air);
        }
    }
}
