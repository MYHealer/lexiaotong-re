package client.android.yixiaotong.v4.ui.scan;

import android.app.Activity;
import android.content.Intent;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.ui.scan.QrcodeUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.http.bean.V4DeviceInfoBean;
import client.android.yixiaotong.v4.ui.app.bath.V4BathDetailActivity;
import client.android.yixiaotong.v4.ui.app.wash.V4WashModeActivity;
import client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4ScanResultControlUtil {
    private static final String TAG = "V4ScanResultControlUtil";
    private Account mAccount;
    private Activity mActivity;
    private boolean mIsEnable = true;

    public V4ScanResultControlUtil(Activity activity, Account account) {
        this.mActivity = activity;
        this.mAccount = account;
    }

    public void onResume() {
        V4ErrorControlUtil.getInstance().onResume();
        this.mIsEnable = true;
    }

    public void onPause() {
        V4ErrorControlUtil.getInstance().onPause();
        this.mIsEnable = false;
    }

    public void onResult(int i, String str) {
        LogUtil.e(TAG, "onResult11:" + i + "  " + str);
        if (i == 1) {
            Intent intent = new Intent();
            intent.putExtra("qrcode", str);
            this.mActivity.setResult(1, intent);
            this.mActivity.finish();
            return;
        }
        if (i == 10) {
            toLaunch(str, 1);
            return;
        }
        if (i == 5) {
            toLaunch(str, 2);
            return;
        }
        if (i == 6) {
            toLaunch(str, 3);
            return;
        }
        if (i == 7) {
            toLaunch(str, 4);
            return;
        }
        if (i == 9) {
            toLaunch(str, 11);
            return;
        }
        if (i == 17) {
            toLaunch(str, 13);
        } else if (i == 18) {
            toLaunch(str, 12);
        } else {
            this.mActivity.finish();
        }
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001f  */
    private void toLaunch(String str, int i) {
        String str2;
        if (str.contains("?")) {
            String[] strArrSplit = str.split("\\?");
            if (strArrSplit.length <= 1 || strArrSplit[1].length() < 52) {
                str2 = str;
            } else {
                str2 = strArrSplit[1];
            }
        } else {
            str2 = str;
        }
        String mac = getMac(str2);
        String btMac = getBtMac(str2);
        if (StringUtils.isNotEmpty(mac) && StringUtils.isNotEmpty(btMac)) {
            V4BathDetailActivity.launch(this.mActivity, btMac, mac, i, "", false);
            this.mActivity.finish();
        } else {
            getDeviceInfoByQrcode(str, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toLaunch2(String str, String str2, int i) {
        if (i == 1 || i == 3 || i == 2 || i == 13 || i == 12) {
            V4BathDetailActivity.launch(this.mActivity, str2, str, i, "", false);
        } else if (i == 4 || i == 11) {
            V4WashModeActivity.launch(this.mActivity, str, str2, i);
        }
        this.mActivity.finish();
    }

    private String getMac(String str) {
        return QrcodeUtil.isNBor4GDeviceV4(str) ? str.substring(34, 50) : "";
    }

    private String getBtMac(String str) {
        return (QrcodeUtil.isNBor4GDeviceV4(str) && QrcodeUtil.isNumberLetterIllegal(str.substring(0, 12).toUpperCase())) ? QrcodeUtil.getMac(str.substring(0, 12)) : "";
    }

    private void getDeviceInfoByQrcode(String str, final int i) {
        V4BusinessControllers.getInstance().getDeviceInfoByQrcode(this.mAccount, str, new Listener<V4DeviceInfoBean>() { // from class: client.android.yixiaotong.v4.ui.scan.V4ScanResultControlUtil.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                BaseMaterialDialog.showMaterialDialog(V4ScanResultControlUtil.this.mActivity, "获取设备信息中", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4DeviceInfoBean v4DeviceInfoBean, Object... objArr) {
                super.onComplete(controller, v4DeviceInfoBean, objArr);
                if (V4ScanResultControlUtil.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    String mac = v4DeviceInfoBean.bluetoothMac;
                    if (StringUtils.isNotEmpty(mac)) {
                        if (mac.length() == 12) {
                            mac = QrcodeUtil.getMac(v4DeviceInfoBean.bluetoothMac);
                        }
                        V4ScanResultControlUtil.this.toLaunch2(v4DeviceInfoBean.mac, mac, i);
                    } else {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        ToastUtils.show(V4ScanResultControlUtil.this.mActivity, "蓝牙mac异常！");
                        V4ScanResultControlUtil.this.mActivity.finish();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (V4ScanResultControlUtil.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(V4ScanResultControlUtil.this.mActivity, "不合法的设备码！");
                    V4ScanResultControlUtil.this.mActivity.finish();
                }
            }
        });
    }
}
