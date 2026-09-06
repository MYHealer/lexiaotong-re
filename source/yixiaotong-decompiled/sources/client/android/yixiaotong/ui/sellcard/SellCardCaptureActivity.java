package client.android.yixiaotong.ui.sellcard;

import android.app.Activity;
import android.content.Intent;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.controller.model.WalletModel;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class SellCardCaptureActivity extends BaseActivity {
    public static final String EXTRA_MONEY = "extra_money";
    public static final String EXTRA_ORDERID = "extra_orderid";
    public static final String EXTRA_WALLET = "extra_wallet";
    private static final String TAG = "SellCardCaptureActivity";
    private String mLanYaSendData;
    private String mMac;
    private String mMoney;
    private WalletModel mWalletModel;
    private String mOrderID = "";
    private int mConnectCount = 0;
    private boolean mIsEnable = true;

    static {
        StubApp.interface11(7602);
    }

    public static void launch(Activity activity, WalletModel walletModel, String str, String str2) {
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) SellCardCaptureActivity.class);
            intent.putExtra("extra_wallet", walletModel);
            intent.putExtra("extra_orderid", str);
            intent.putExtra("extra_money", str2);
            activity.startActivity(intent);
        }
    }
}
