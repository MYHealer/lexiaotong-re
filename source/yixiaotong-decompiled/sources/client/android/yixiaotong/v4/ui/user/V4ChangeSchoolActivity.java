package client.android.yixiaotong.v4.ui.user;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.widget.SetFontColorUtil;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v3.ui.adv.AdvControlUtil;
import client.android.yixiaotong.v3.ui.adv.Common;
import client.android.yixiaotong.v3.ui.adv.NativeUtil;
import client.android.yixiaotong.v3.ui.scan.ScanQrcodeActivity;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.http.bean.V4BindCustomer;
import client.android.yixiaotong.v4.http.bean.V4DeviceInfoBean;
import client.android.yixiaotong.v4.http.bean.V4UserInfoDetailBean;
import client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil;
import client.android.yixiaotong.v4.util.homeinfo.V4HomeInfoUtil;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4ChangeSchoolActivity extends BaseActivity {
    private static final String TAG = "V4ChangeSchoolActivity";
    private RelativeLayout flContainer;
    private AdvControlUtil.AdvListener mAdvListener;
    private NativeUtil mNativeUtil;
    private TitleBar mTitleBar;
    private TextView mTvAdvName;
    private TextView mTvScanDeviceQrcode;
    private TextView mTvScanSchoolQrcode;
    private boolean mIsEnable = true;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v4.ui.user.V4ChangeSchoolActivity.4
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            if (i != 0) {
                return;
            }
            ScanQrcodeActivity.launch(V4ChangeSchoolActivity.this.getActivity(), 1);
        }
    };
    private boolean mIsShowAdv = false;

    static {
        StubApp.interface11(11043);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4ChangeSchoolActivity.class));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTvScanDeviceQrcode = (TextView) findViewById(R.id.tv_scandeviceqrcode);
        this.mTvScanSchoolQrcode = (TextView) findViewById(R.id.tv_scanschoolqrcode);
        this.flContainer = (RelativeLayout) findViewById(R.id.flContainer);
        this.mTvAdvName = (TextView) findViewById(R.id.tv_advname);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.selectschool));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        TextView textView = this.mTvScanDeviceQrcode;
        textView.setText(SetFontColorUtil.getFontForContent(textView.getText().toString(), "扫码获取", "#ff6f32fd"));
        TextView textView2 = this.mTvScanSchoolQrcode;
        textView2.setText(SetFontColorUtil.getFontForContent(textView2.getText().toString(), "扫码获取", "#ff6f32fd"));
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        V4ErrorControlUtil.getInstance().onResume();
        getAdv();
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onResume();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        V4ErrorControlUtil.getInstance().onPause();
        BaseMaterialDialog.dissmisMaterialDialog();
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onPause();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onDestroy();
        }
        super.onDestroy();
    }

    private void initClickListeners() {
        findViewById(R.id.rel_scan_device_qrcode).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.user.V4ChangeSchoolActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m545xd23d678b(view);
            }
        });
        findViewById(R.id.rel_scanqrcode).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.user.V4ChangeSchoolActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m546x8cb3080c(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v4-ui-user-V4ChangeSchoolActivity, reason: not valid java name */
    /* synthetic */ void m545xd23d678b(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        PermissionUtil.requestPerssion(getActivity(), 0, this.permissionGrant);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v4-ui-user-V4ChangeSchoolActivity, reason: not valid java name */
    /* synthetic */ void m546x8cb3080c(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        PermissionUtil.requestPerssion(getActivity(), 0, this.permissionGrant);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null && i == 1 && i2 == 1) {
            checkQrcode(intent.getStringExtra("qrcode"));
        }
    }

    private void checkQrcode(String str) {
        if (StringUtils.isNotEmpty(str)) {
            String strIsV4CustomerQrcode = V4RegisterQrcodeControl.isV4CustomerQrcode(str);
            String strIsV4DeviceQrcode = V4RegisterQrcodeControl.isV4DeviceQrcode(str);
            if (StringUtils.isNotEmpty(strIsV4CustomerQrcode)) {
                bindSchool(strIsV4CustomerQrcode);
            } else if (StringUtils.isNotEmpty(strIsV4DeviceQrcode)) {
                getMachineInfo(strIsV4DeviceQrcode);
            } else {
                ToastUtils.show(getActivity(), "二维码不合法!");
                finish();
            }
        }
    }

    private void getMachineInfo(String str) {
        V4BusinessControllers.getInstance().getDeviceInfoByMachineId(getLoginAccount(), str, new Listener<V4DeviceInfoBean>() { // from class: client.android.yixiaotong.v4.ui.user.V4ChangeSchoolActivity.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                BaseMaterialDialog.showMaterialDialog(V4ChangeSchoolActivity.this.getActivity(), "获取信息中", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4DeviceInfoBean v4DeviceInfoBean, Object... objArr) {
                super.onComplete(controller, v4DeviceInfoBean, objArr);
                if (V4ChangeSchoolActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    V4ChangeSchoolActivity.this.bindSchool(v4DeviceInfoBean.customerId);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (V4ChangeSchoolActivity.this.mIsEnable) {
                    V4ErrorControlUtil.getInstance().showDialog(clientException, V4ChangeSchoolActivity.this.getActivity(), false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindSchool(String str) {
        V4BusinessControllers.getInstance().postBindCustomer(getLoginAccount(), str, new Listener<V4BindCustomer>() { // from class: client.android.yixiaotong.v4.ui.user.V4ChangeSchoolActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(V4ChangeSchoolActivity.this.getActivity(), "绑定学校.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4BindCustomer v4BindCustomer, Object... objArr) {
                if (V4ChangeSchoolActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(V4ChangeSchoolActivity.this.getContext(), "绑定学校成功！");
                    V4ChangeSchoolActivity.this.getUserInfo();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4ChangeSchoolActivity.this.mIsEnable) {
                    V4ChangeSchoolActivity.this.onError(clientException);
                }
            }
        });
    }

    public void getUserInfo() {
        V4BusinessControllers.getInstance().getUserInfo(getLoginAccount(), new Listener<V4UserInfoDetailBean>() { // from class: client.android.yixiaotong.v4.ui.user.V4ChangeSchoolActivity.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                BaseMaterialDialog.showMaterialDialog(V4ChangeSchoolActivity.this.getActivity(), "获取用户信息", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4UserInfoDetailBean v4UserInfoDetailBean, Object... objArr) {
                super.onComplete(controller, v4UserInfoDetailBean, objArr);
                if (V4ChangeSchoolActivity.this.mIsEnable) {
                    V4ChangeSchoolActivity.this.finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (V4ChangeSchoolActivity.this.mIsEnable) {
                    V4ChangeSchoolActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        V4ErrorControlUtil.getInstance().showDialog(clientException, getActivity(), false);
    }

    private void initAdv() {
        this.mNativeUtil = new NativeUtil();
    }

    private void getAdv() {
        if (this.mIsShowAdv) {
            return;
        }
        this.mAdvListener = new AdvControlUtil.AdvListener() { // from class: client.android.yixiaotong.v4.ui.user.V4ChangeSchoolActivity.5
            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void isOpen(int i, int i2, int i3, int i4, int i5) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdClosed(Common.AdvType advType) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onRenderSuccess(View view, int i) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdShow(String str, Common.AdvType advType) {
                V4ChangeSchoolActivity.this.mIsShowAdv = true;
            }
        };
        boolean zIsOpenAdv = V4HomeInfoUtil.getInstance().isOpenAdv();
        LogUtil.e(TAG, "广告是否开启：" + zIsOpenAdv);
        if (zIsOpenAdv) {
            this.mNativeUtil.initNative(getActivity(), this.mAdvListener, 1);
            this.mNativeUtil.onNative(this.flContainer);
        }
    }
}
