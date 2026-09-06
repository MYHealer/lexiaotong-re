package client.android.yixiaotong.ui.sellcard;

import android.app.Activity;
import android.client.bluetoothsdk.BluetoothSDK;
import android.client.bluetoothsdk.bluetooth.BluetoothDevice;
import android.client.bluetoothsdk.listener.BluetoothConnectListener;
import android.client.bluetoothsdk.util.ClientException;
import android.client.bluetoothsdk.util.TimeOut;
import android.client.bluetoothsdk.util.executor.MainThreadExecutor;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.zksoundwave.SWCommandUtil;
import client.android.yixiaotong.zksoundwave.soundwavedatamanage.SoundWaveDataListener;
import com.afollestad.materialdialogs.MaterialDialog;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class SellCardAuthActivity extends BaseActivity {
    public static final String EXTRA_MAC = "extra_mac";
    public static final String EXTRA_MACHINEDATA = "extra_machinedata";
    public static final String EXTRA_MACHINETIME = "extra_machinetime";
    public static final String EXTRA_WALLET = "extra_wallet";
    Button btnToast;
    ImageView ivPlayWave;
    private int mConnectCount = 0;
    private boolean mConnectState = false;
    private String mLanYaSendData;
    private String mMac;
    private MaterialDialog mMaterialDialog;
    private String mSystemData;
    private String mSystemTime;
    TitleBar mVTitleBar;
    private WalletModel mWalletModel;
    private TimeCount time;
    TextView tvShowPlay;

    static {
        StubApp.interface11(7601);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    static /* synthetic */ int access$608(SellCardAuthActivity sellCardAuthActivity) {
        int i = sellCardAuthActivity.mConnectCount;
        sellCardAuthActivity.mConnectCount = i + 1;
        return i;
    }

    public static void launch(Activity activity, WalletModel walletModel, String str, String str2, String str3) {
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) SellCardAuthActivity.class);
            intent.putExtra("extra_wallet", walletModel);
            intent.putExtra("extra_mac", str);
            intent.putExtra(EXTRA_MACHINETIME, str2);
            intent.putExtra("extra_machinedata", str3);
            activity.startActivity(intent);
        }
    }

    private void initViewNew() {
        this.mVTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.ivPlayWave = (ImageView) findViewById(R.id.play_soundwave);
        this.tvShowPlay = (TextView) findViewById(R.id.tv_show_play);
        this.btnToast = (Button) findViewById(R.id.btntoast);
    }

    private void initTitleBar() {
        this.mVTitleBar.setTitleView("售卡");
        this.mVTitleBar.setLeftView(R.mipmap.back);
        this.mVTitleBar.setLeftViewOnClickBackConnect(getActivity());
    }

    private void initView() {
        this.ivPlayWave.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.sellcard.SellCardAuthActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SellCardAuthActivity.this.mConnectState) {
                    return;
                }
                SellCardAuthActivity.this.showDialog();
                BluetoothSDK.getInstance().ConnectManagerDevice(new BluetoothDevice("", SellCardAuthActivity.this.mMac));
            }
        });
    }

    private void init() {
        SWCommandUtil.getInstance().initDataManage();
        SWCommandUtil.getInstance().setDataListener(new SoundWaveDataListener() { // from class: client.android.yixiaotong.ui.sellcard.SellCardAuthActivity.2
            @Override // client.android.yixiaotong.zksoundwave.soundwavedatamanage.SoundWaveDataListener
            public void onQrcodeData(String str, String str2, int i) {
            }

            @Override // client.android.yixiaotong.zksoundwave.soundwavedatamanage.SoundWaveDataListener
            public void onGetQrcodeData(String str) {
                SellCardAuthActivity.this.mLanYaSendData = str;
            }
        });
    }

    private void initLanYa() {
        BluetoothSDK.getInstance().init(getContext());
        BluetoothSDK.getInstance().setListener(new BluetoothConnectListener() { // from class: client.android.yixiaotong.ui.sellcard.SellCardAuthActivity.3
            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onStart(BluetoothDevice bluetoothDevice) {
                SellCardAuthActivity.this.showDialog();
            }

            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onBluetoothException(ClientException clientException) {
                SellCardAuthActivity.this.dismissDialog();
                ToastUtils.show(SellCardAuthActivity.this.getContext(), clientException.getDetail());
            }

            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onFail(BluetoothDevice bluetoothDevice, TimeOut timeOut, String str) {
                SellCardAuthActivity.this.mConnectState = false;
                SellCardAuthActivity.access$608(SellCardAuthActivity.this);
                if (SellCardAuthActivity.this.mConnectCount > 1) {
                    SellCardAuthActivity.this.dismissDialog();
                    SellCardAuthActivity.this.tvShowPlay.setText("连接设备失败，点击按钮重试领取卡片");
                    ToastUtils.show(SellCardAuthActivity.this.getContext(), str + "，连接设备失败，点击按钮重试领取卡片");
                    return;
                }
                BluetoothSDK.getInstance().ConnectManagerDevice(new BluetoothDevice("", SellCardAuthActivity.this.mMac));
            }

            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onSuccessConnect(BluetoothDevice bluetoothDevice) {
                SellCardAuthActivity.this.mConnectState = true;
                MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.sellcard.SellCardAuthActivity.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SellCardAuthActivity.this.dismissDialog();
                        if (StringUtils.isNotEmpty(SellCardAuthActivity.this.mLanYaSendData)) {
                            BluetoothSDK.getInstance().SendDataManagerDevice(SellCardAuthActivity.this.mLanYaSendData);
                        }
                        SellCardAuthActivity.this.btnToast.setVisibility(0);
                        SellCardAuthActivity.this.time.start();
                    }
                }, 200L);
            }

            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onSuccessSendData(BluetoothDevice bluetoothDevice, String str) {
                Log.e("test", "onSuccessSendData:" + str);
                SellCardAuthActivity.this.dismissDialog();
                ToastUtils.show(SellCardAuthActivity.this.getContext(), "机器正在出卡中...");
            }
        });
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        BluetoothSDK.getInstance().closeBLE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        dismissDialog();
        MaterialDialog materialDialogShow = new MaterialDialog.Builder(this).content("连接设备中...").progress(true, 0).dismissListener(new DialogInterface.OnDismissListener() { // from class: client.android.yixiaotong.ui.sellcard.SellCardAuthActivity.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
            }
        }).show();
        this.mMaterialDialog = materialDialogShow;
        materialDialogShow.setCanceledOnTouchOutside(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissDialog() {
        MaterialDialog materialDialog = this.mMaterialDialog;
        if (materialDialog == null || !materialDialog.isShowing()) {
            return;
        }
        this.mMaterialDialog.dismiss();
        this.mMaterialDialog = null;
    }

    class TimeCount extends CountDownTimer {
        public TimeCount(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            SellCardAuthActivity.this.finish();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            SellCardAuthActivity.this.btnToast.setTextColor(-1);
            SellCardAuthActivity.this.btnToast.setClickable(false);
            SellCardAuthActivity.this.btnToast.setText(Html.fromHtml("出卡成功后手动返回或者等待<font color='#FF0000'>" + (j / 1000) + "</font>秒自动返回"));
            SellCardAuthActivity.this.btnToast.setTextSize(15.0f);
            SellCardAuthActivity.this.btnToast.setPadding(5, 5, 5, 5);
            SellCardAuthActivity.this.btnToast.setBackgroundResource(R.drawable.drink_water_toast_shape);
        }
    }
}
