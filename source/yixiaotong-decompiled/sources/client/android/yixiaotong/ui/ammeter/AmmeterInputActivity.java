package client.android.yixiaotong.ui.ammeter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.controller.model.WalletModel;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AmmeterInputActivity extends BaseActivity {
    public static final String EXTRAS_STATE = "devicestate";
    public static final String EXTRA_WALLET = "extra_wallet";

    static {
        StubApp.interface11(6195);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, WalletModel walletModel, int i) {
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) AmmeterInputActivity.class);
            intent.putExtra("extra_wallet", walletModel);
            intent.putExtra("devicestate", i);
            activity.startActivity(intent);
        }
    }
}
