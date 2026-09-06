package client.android.yixiaotong.v4.util.homeinfo;

import android.app.Activity;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4TypeIDSetUtil {
    public static final int TYPEID_AIR = 13;
    public static final int TYPEID_AMMER = 12;
    public static final int TYPEID_BATH = 1;
    public static final int TYPEID_CONSUMER = 15;
    public static final int TYPEID_DRINKWATER = 2;
    public static final int TYPEID_DRY = 11;
    public static final int TYPEID_HAIR = 3;
    public static final int TYPEID_REMOTEWATER = 6;
    public static final int TYPEID_REMOTEWATER2 = 17;
    public static final int TYPEID_SMARTGATEWAY = 14;
    public static final int TYPEID_WASH = 4;
    public static final int TYPEID_WASHSHOE = 10;
    public static final int TYPE_DRAWMONEY = 7;

    public static String getAppName(Activity activity, int i) {
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
            case 14:
            case 16:
            default:
                return "";
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
            case 15:
                return activity.getResources().getString(R.string.consumermachine);
            case 17:
                return activity.getResources().getString(R.string.remotewater);
        }
    }
}
