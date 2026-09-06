package client.android.yixiaotong.ui.deviceinit;

import android.app.Activity;
import android.client.bluetoothsdk.bluetooth.BluetoothDevice;
import android.content.Intent;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.ui.widget.TitleBar;
import com.afollestad.materialdialogs.MaterialDialog;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DeviceInitSaoMaActivity extends BaseActivity {
    public static final String EXTRA_ISINIT = "extra_isinit";
    public static final String EXTRA_WALLET = "extra_wallet";
    private static final String TAG;
    private BluetoothDevice mBluetoothDevice;
    private boolean mIsInit;
    private MaterialDialog mMaterialDialog;
    private TitleBar mTitleBar;
    private WalletModel mWalletModel;
    private boolean mIsEnable = true;
    private int mConnectCount = 0;
    private SendDataState mSendDataState = SendDataState.none;
    private boolean mIsCollectSelfData = true;
    private boolean mIsAutoConnect = true;

    private enum SendDataState {
        none,
        f0,
        f02,
        f06,
        f08
    }

    public static void launch(Activity activity, WalletModel walletModel, boolean z) {
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) DeviceInitSaoMaActivity.class);
            intent.putExtra("extra_wallet", walletModel);
            intent.putExtra("extra_isinit", z);
            activity.startActivity(intent);
        }
    }

    static {
        StubApp.interface11(6728);
        TAG = "HamamCaptureActivity";
    }
}
