package client.android.yixiaotong.ui.cleandata;

import android.app.Activity;
import android.content.Intent;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.controller.model.WalletModel;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class CleanDataCapatureActivity extends BaseActivity {
    public static final String EXTRA_FLAG = "extra_flag";
    public static final String EXTRA_MONEY = "extra_money";
    public static final String EXTRA_ORDERID = "extra_orderid";
    public static final String EXTRA_TYPEID = "extra_typeid";
    public static final String EXTRA_WALLET = "extra_orderid";
    private String mFlag = "";
    private WalletModel mWalletModel;

    public static void launch(Activity activity, WalletModel walletModel, String str) {
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) CleanDataCapatureActivity.class);
            intent.putExtra("extra_orderid", walletModel);
            intent.putExtra("extra_flag", str);
            activity.startActivity(intent);
        }
    }
}
