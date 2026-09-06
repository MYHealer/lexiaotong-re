package client.android.yixiaotong.v3.ui.device;

import android.app.Activity;
import android.util.Log;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.error.ErrorTipActivity;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ManageDeviceControlUtil {
    private Activity mActivity;
    private boolean mIsEnable;
    private String mTitleContent;

    public void onPause() {
        this.mIsEnable = false;
    }

    public void onResume() {
        this.mIsEnable = true;
    }

    public void init(Activity activity, String str) {
        this.mActivity = activity;
        this.mTitleContent = str;
        setBluetoothListener();
    }

    private void setBluetoothListener() {
        BluetoothControlUtil.getInstance().init(this.mActivity);
        BluetoothControlUtil.getInstance().setListener(new BluetoothControlUtil.Listener() { // from class: client.android.yixiaotong.v3.ui.device.ManageDeviceControlUtil.1
            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onConnected() {
                super.onConnected();
                if (ManageDeviceControlUtil.this.mIsEnable) {
                    BaseMaterialDialog.setConnectMaterialDialog("连接成功，正在获取设备信息");
                    MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v3.ui.device.ManageDeviceControlUtil.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                        }
                    }, 500L);
                }
            }

            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onReceivedData(String str) {
                super.onReceivedData(str);
                if (ManageDeviceControlUtil.this.mIsEnable) {
                    Log.e("test", "收到数据：" + str);
                }
            }

            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onFail(int i, String str) {
                super.onFail(i, str);
                if (ManageDeviceControlUtil.this.mIsEnable) {
                    Log.e("onFail:", i + "  " + str + "  ");
                    BaseMaterialDialog.dissmisMaterialDialog();
                    BluetoothControlUtil.getInstance().disconnect();
                    Activity activity = ManageDeviceControlUtil.this.mActivity;
                    String str2 = ManageDeviceControlUtil.this.mTitleContent;
                    if (!StringUtils.isNotEmpty(str)) {
                        str = "连接设备失败";
                    }
                    ErrorTipActivity.launch(activity, str2, "蓝牙连接失败", str, i, 1);
                    ManageDeviceControlUtil.this.finishActivity();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        if (this.mActivity.getLocalClassName().contains("DeviceSaoMaActivity") || this.mActivity.getLocalClassName().contains("HMSScanActivity")) {
            this.mActivity.finish();
        }
    }

    private void showDialog(final String str) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.v3.ui.device.ManageDeviceControlUtil.2
            @Override // java.lang.Runnable
            public void run() {
                if (ManageDeviceControlUtil.this.mActivity.getLocalClassName().contains("DeviceSaoMaActivity") || ManageDeviceControlUtil.this.mActivity.getLocalClassName().contains("HMSScanActivity")) {
                    SystemErrorTip.getInstance().showTipDialog(ManageDeviceControlUtil.this.mActivity, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.device.ManageDeviceControlUtil.2.1
                        @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                        public void onConfirm() {
                            ManageDeviceControlUtil.this.mActivity.finish();
                        }
                    }, str);
                } else {
                    SystemErrorTip.getInstance().showTipDialog(ManageDeviceControlUtil.this.mActivity, str);
                }
            }
        });
    }
}
