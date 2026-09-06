package client.android.yixiaotong.v3.ui.appcontrol.prepayment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
import client.android.yixiaotong.v3.bean.deviceinfo.MachineByMacBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.ui.scan.ScanQrcodeActivity;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class SelecetDeviceActivity extends BaseActivity {
    private static final String TAG = "SelecetDeviceActivity";
    private TitleBar mTitleBar;
    private TypeInfoBean mTypeInfoBean;
    private boolean mIsEnable = true;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.SelecetDeviceActivity.1
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            if (i != 0) {
                return;
            }
            ScanQrcodeActivity.launch(SelecetDeviceActivity.this.getActivity(), 13);
        }
    };

    static {
        StubApp.interface11(9467);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public static void launch(Activity activity, TypeInfoBean typeInfoBean) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) SelecetDeviceActivity.class).putExtra("bean", typeInfoBean));
        }
    }

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) SelecetDeviceActivity.class));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("预付费水表");
        if (StringUtils.isNotEmpty(this.mTypeInfoBean.base.appName)) {
            this.mTitleBar.setTitleView(this.mTypeInfoBean.base.appName);
        }
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        BaseMaterialDialog.dissmisMaterialDialog();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initClickListeners() {
        findViewById(R.id.rel_scan_device_qrcode).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.SelecetDeviceActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m300xb74d62ec(view);
            }
        });
        findViewById(R.id.rel_selectaddress).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.SelecetDeviceActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m301xb81be16d(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-appcontrol-prepayment-SelecetDeviceActivity, reason: not valid java name */
    /* synthetic */ void m300xb74d62ec(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        PermissionUtil.requestPerssion(getActivity(), 0, this.permissionGrant);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-appcontrol-prepayment-SelecetDeviceActivity, reason: not valid java name */
    /* synthetic */ void m301xb81be16d(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        SelectAddressActivity.launch(getActivity(), this.mTypeInfoBean);
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null) {
            String str = TAG;
            LogUtil.e(str, "onActivityResult:" + i2);
            if (i2 == 13) {
                String stringExtra = intent.getStringExtra("qrcode");
                LogUtil.e(str, "onActivityResult:" + stringExtra);
                if (StringUtils.isNotEmpty(stringExtra)) {
                    getInfoByQRCode(stringExtra);
                }
            }
        }
    }

    private void getInfoByQRCode(String str) {
        V3BusinessControllers.getInstance().getInfoByQRCode(getLoginAccount(), str, false, new Listener<MachineByMacBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.SelecetDeviceActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(SelecetDeviceActivity.this.getActivity(), "正在获取二维码数据.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, MachineByMacBean machineByMacBean, Object... objArr) {
                if (SelecetDeviceActivity.this.mIsEnable) {
                    if (machineByMacBean == null || !StringUtils.isNotEmpty(machineByMacBean.deviceMac) || !StringUtils.isNotEmpty(machineByMacBean.machineId) || !StringUtils.isNotEmpty(machineByMacBean.deviceVer)) {
                        SelecetDeviceActivity.this.showDialogNeedExit("设备未授权，请联系管理员\n(" + LocalDataUtil.getTraceID(SelecetDeviceActivity.this.getActivity()) + ")");
                        return;
                    }
                    BaseMaterialDialog.dissmisMaterialDialog();
                    LocalDataUtil.saveTypeIdMachineId(SelecetDeviceActivity.this.getActivity(), 18, machineByMacBean.machineId + ";" + machineByMacBean.deviceMac + ";" + machineByMacBean.deviceVer);
                    PrepaymentWalletActivity.launch(SelecetDeviceActivity.this.getActivity(), SelecetDeviceActivity.this.mTypeInfoBean);
                    SelecetDeviceActivity.this.finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (SelecetDeviceActivity.this.mIsEnable) {
                    SelecetDeviceActivity.this.onError(clientException);
                }
            }
        });
    }

    private void getDeviceInfo(String str) {
        V3BusinessControllers.getInstance().getMachineByMachineId2(getLoginAccount(), str, false, new Listener<MachineByMacBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.SelecetDeviceActivity.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.setConnectMaterialDialog("正在获取设备信息..");
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, MachineByMacBean machineByMacBean, Object... objArr) {
                if (SelecetDeviceActivity.this.mIsEnable) {
                    if (machineByMacBean == null || machineByMacBean.base == null || !StringUtils.isNotEmpty(machineByMacBean.base.schoolId) || machineByMacBean.base.use != 1) {
                        SelecetDeviceActivity.this.showDialogNeedExit("当前设备未初始化");
                    } else {
                        BaseMaterialDialog.dissmisMaterialDialog();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (SelecetDeviceActivity.this.mIsEnable) {
                    SelecetDeviceActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogNeedExit(String str) {
        BaseMaterialDialog.dissmisMaterialDialog();
        SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.SelecetDeviceActivity.4
            @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
            public void onConfirm() {
            }
        }, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.SelecetDeviceActivity.5
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                }
            }, clientException.getDetail() + "\n(" + LocalDataUtil.getTraceID(getActivity()) + ")");
        } else {
            V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
        }
    }
}
