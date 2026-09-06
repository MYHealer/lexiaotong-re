package client.android.yixiaotong.v4.ui.app.electricitymeter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.http.bean.V4DeviceInfoBean;
import client.android.yixiaotong.v4.ui.area.V4SelectAddressActivity;
import client.android.yixiaotong.v4.ui.area.V4SelectAddressControl;
import client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil;
import client.android.yixiaotong.v4.ui.scan.V4ScanQrcodeActivity;
import client.android.yixiaotong.v4.util.userinfo.V4UserInfoUtil;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4SelecetDeviceActivity extends BaseActivity {
    private static final String TAG = "V4SelecetDeviceActivity";
    private int mProductId;
    TitleBar mTitleBar;
    TextView mTvScanDevice;
    TextView mTvScanDeviceTip;
    TextView mTvSelectDeviceText;
    private boolean mIsEnable = true;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4SelecetDeviceActivity.3
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            if (i != 0) {
                return;
            }
            V4ScanQrcodeActivity.launch(V4SelecetDeviceActivity.this.getActivity(), 1);
        }
    };

    static {
        StubApp.interface11(10782);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public static void launch(Activity activity, int i) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4SelecetDeviceActivity.class).putExtra("productid", i));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTvScanDevice = (TextView) findViewById(R.id.tv_scandevice1);
        this.mTvScanDeviceTip = (TextView) findViewById(R.id.tv_scandeviceqrcode);
        this.mTvSelectDeviceText = (TextView) findViewById(R.id.tv_scanschoolqr);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.selectby));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
        findViewById(R.id.rel_scan_device_qrcode).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4SelecetDeviceActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ClickUtil.isFastDoubleClick()) {
                    return;
                }
                PermissionUtil.requestPerssion(V4SelecetDeviceActivity.this.getActivity(), 0, V4SelecetDeviceActivity.this.permissionGrant);
            }
        });
        findViewById(R.id.rel_selectaddress).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4SelecetDeviceActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ClickUtil.isFastDoubleClick()) {
                    return;
                }
                V4SelectAddressActivity.launch(V4SelecetDeviceActivity.this.getActivity(), V4SelecetDeviceActivity.this.mProductId);
                V4SelecetDeviceActivity.this.finish();
            }
        });
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        V4ErrorControlUtil.getInstance().onResume();
        V4SelectAddressControl.getInstance().onResume();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        BaseMaterialDialog.dissmisMaterialDialog();
        V4ErrorControlUtil.getInstance().onPause();
        V4SelectAddressControl.getInstance().onPause();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null) {
            String str = TAG;
            LogUtil.e(str, "onActivityResult:" + i2);
            if (i2 == 1) {
                String stringExtra = intent.getStringExtra("qrcode");
                LogUtil.e(str, "onActivityResult:" + stringExtra);
                if (StringUtils.isNotEmpty(stringExtra)) {
                    getInfoByQRCode(stringExtra);
                }
            }
        }
    }

    private void getInfoByQRCode(String str) {
        int i = this.mProductId;
        if (i == 13 || i == 12) {
            if (StringUtils.isNotEmpty(str) && str.length() > 12) {
                str = str.substring(str.length() - 12);
            }
            V4BusinessControllers.getInstance().getDeviceInfoBySn(getLoginAccount(), str, new Listener<V4DeviceInfoBean>() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4SelecetDeviceActivity.4
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    BaseMaterialDialog.showMaterialDialog(V4SelecetDeviceActivity.this.getActivity(), "正在获取设备信息.", false);
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, V4DeviceInfoBean v4DeviceInfoBean, Object... objArr) {
                    if (V4SelecetDeviceActivity.this.mIsEnable) {
                        if (v4DeviceInfoBean == null || !StringUtils.isNotEmpty(v4DeviceInfoBean.roomId) || v4DeviceInfoBean.roomId.equals("0") || !StringUtils.isNotEmpty(v4DeviceInfoBean.customerId) || v4DeviceInfoBean.customerId.equals("0")) {
                            V4SelecetDeviceActivity.this.showDialogNeedExit("设备未授权，请联系管理员");
                            return;
                        }
                        if (v4DeviceInfoBean.customerId.equals(V4UserInfoUtil.getInstance().getLoginAccountV4().customerId)) {
                            V4SelectAddressControl.getInstance().bindRoom(V4SelecetDeviceActivity.this.getLoginAccount(), V4SelecetDeviceActivity.this.getActivity(), v4DeviceInfoBean.roomId, V4SelecetDeviceActivity.this.mProductId, true);
                        } else {
                            V4SelecetDeviceActivity.this.showDialogNeedExit("设备不在当前学校下,设备在[" + v4DeviceInfoBean.customerName + "]");
                        }
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (V4SelecetDeviceActivity.this.mIsEnable) {
                        V4ErrorControlUtil.getInstance().showDialog(clientException, V4SelecetDeviceActivity.this.getActivity(), true);
                    }
                }
            });
            return;
        }
        getDeviceInfoByQrcode(str);
    }

    private void getDeviceInfoByQrcode(String str) {
        V4BusinessControllers.getInstance().getDeviceInfoByQrcode(getLoginAccount(), str, new Listener<V4DeviceInfoBean>() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4SelecetDeviceActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                BaseMaterialDialog.showMaterialDialog(V4SelecetDeviceActivity.this.getActivity(), "获取设备信息中", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4DeviceInfoBean v4DeviceInfoBean, Object... objArr) {
                super.onComplete(controller, v4DeviceInfoBean, objArr);
                if (V4SelecetDeviceActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (v4DeviceInfoBean == null || !StringUtils.isNotEmpty(v4DeviceInfoBean.roomId) || v4DeviceInfoBean.roomId.equals("0")) {
                        V4SelecetDeviceActivity.this.showDialogNeedExit("设备未授权，请联系管理员");
                    } else {
                        V4SelectAddressControl.getInstance().bindRoom(V4SelecetDeviceActivity.this.getLoginAccount(), V4SelecetDeviceActivity.this.getActivity(), v4DeviceInfoBean.roomId, V4SelecetDeviceActivity.this.mProductId, true);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (V4SelecetDeviceActivity.this.mIsEnable) {
                    V4ErrorControlUtil.getInstance().showDialog(clientException, V4SelecetDeviceActivity.this.getActivity(), true);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogNeedExit(String str) {
        BaseMaterialDialog.dissmisMaterialDialog();
        SystemErrorTip.getInstance().showTipDialog(getActivity(), "提示", str, "确定", false, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4SelecetDeviceActivity.6
            @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
            public void onConfirm() {
                V4SelecetDeviceActivity.this.finish();
            }
        });
    }
}
