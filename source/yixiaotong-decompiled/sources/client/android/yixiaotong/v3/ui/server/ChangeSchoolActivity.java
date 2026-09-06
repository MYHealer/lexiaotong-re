package client.android.yixiaotong.v3.ui.server;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.SetFontColorUtil;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v3.bean.deviceinfo.MachineByMacBean;
import client.android.yixiaotong.v3.bean.login.SchoolIdBean;
import client.android.yixiaotong.v3.bean.login.SchoolInfosBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.adv.AdvControlUtil;
import client.android.yixiaotong.v3.ui.adv.Common;
import client.android.yixiaotong.v3.ui.adv.NativeUtil;
import client.android.yixiaotong.v3.ui.dialog.BindSchoolDialog;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.ui.scan.QrcodeUtil;
import client.android.yixiaotong.v3.ui.scan.ScanQrcodeActivity;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.stub.StubApp;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ChangeSchoolActivity extends BaseActivity {
    private static final String TAG = "ChangeSchoolActivity";
    private RelativeLayout flContainer;
    private AdvControlUtil.AdvListener mAdvListener;
    private NativeUtil mNativeUtil;
    private TitleBar mTitleBar;
    private TextView mTvAdvName;
    private TextView mTvScanDeviceQrcode;
    private TextView mTvScanSchoolQrcode;
    private boolean mIsEnable = true;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v3.ui.server.ChangeSchoolActivity.7
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            if (i != 0) {
                return;
            }
            ScanQrcodeActivity.launch(ChangeSchoolActivity.this.getActivity(), 1);
        }
    };
    private boolean mIsShowAdv = false;

    static {
        StubApp.interface11(10211);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) ChangeSchoolActivity.class));
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
        getAdv();
        AdvControlUtil.getInstance().onResume();
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onResume();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        BaseMaterialDialog.dissmisMaterialDialog();
        AdvControlUtil.getInstance().onPause();
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onPause();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        AdvControlUtil.getInstance().onDestroy(getActivity());
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onDestroy();
        }
        super.onDestroy();
    }

    private void initClickListeners() {
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.server.ChangeSchoolActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m420xfd4dd816(view);
            }
        };
        findViewById(R.id.rel_scan_device_qrcode).setOnClickListener(onClickListener);
        findViewById(R.id.rel_scanqrcode).setOnClickListener(onClickListener);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-server-ChangeSchoolActivity, reason: not valid java name */
    /* synthetic */ void m420xfd4dd816(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        PermissionUtil.requestPerssion(getActivity(), 0, this.permissionGrant);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null && i == 1 && i2 == 1) {
            getDeviceInfo(intent.getStringExtra("qrcode"), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getDeviceInfo(String str, String str2) {
        String subQrcode = QrcodeUtil.getSubQrcode(str);
        if (StringUtils.isNotEmpty(str2) || (StringUtils.isNotEmpty(subQrcode) && subQrcode.length() >= 40 && QrcodeUtil.isNumberLetterIllegal(subQrcode.toUpperCase()))) {
            if (StringUtils.isEmpty(str2)) {
                str2 = subQrcode.substring(2, 10);
                if (subQrcode.length() >= 52 && QrcodeUtil.isNBor4GDevice(subQrcode)) {
                    str2 = subQrcode.substring(34, 50);
                }
            }
            V3BusinessControllers.getInstance().getMachineByMachineId2(getLoginAccount(), str2, false, new Listener<MachineByMacBean>() { // from class: client.android.yixiaotong.v3.ui.server.ChangeSchoolActivity.1
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, MachineByMacBean machineByMacBean, Object... objArr) {
                    if (ChangeSchoolActivity.this.mIsEnable) {
                        if (machineByMacBean != null && machineByMacBean.base != null && StringUtils.isNotEmpty(machineByMacBean.base.schoolId) && machineByMacBean.base.use == 1) {
                            ChangeSchoolActivity.this.getSchoolInfos(machineByMacBean.base.schoolId);
                        } else {
                            BaseMaterialDialog.dissmisMaterialDialog();
                            SystemErrorTip.getInstance().showTipDialog(ChangeSchoolActivity.this.getActivity(), "当前设备未注册，尝试“扫描学校二维码”");
                        }
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (ChangeSchoolActivity.this.mIsEnable) {
                        ChangeSchoolActivity.this.onError(clientException);
                    }
                }
            });
            return;
        }
        if (StringUtils.isNotEmpty(str)) {
            getInfoByQRCode(str);
        }
    }

    private void getInfoByQRCode(final String str) {
        V3BusinessControllers.getInstance().getInfoByQRCode(getLoginAccount(), str, false, new Listener<MachineByMacBean>() { // from class: client.android.yixiaotong.v3.ui.server.ChangeSchoolActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(ChangeSchoolActivity.this.getActivity(), "正在获取二维码数据.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, MachineByMacBean machineByMacBean, Object... objArr) {
                if (ChangeSchoolActivity.this.mIsEnable) {
                    if (machineByMacBean == null || !StringUtils.isNotEmpty(machineByMacBean.deviceMac) || !StringUtils.isNotEmpty(machineByMacBean.machineId) || !StringUtils.isNotEmpty(machineByMacBean.deviceVer)) {
                        ChangeSchoolActivity.this.qrcode(str);
                    } else {
                        ChangeSchoolActivity.this.getDeviceInfo(str, machineByMacBean.machineId);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (ChangeSchoolActivity.this.mIsEnable) {
                    ChangeSchoolActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qrcode(String str) {
        V3BusinessControllers.getInstance().getAnalysisQRCode(getLoginAccount(), str, new Listener<SchoolIdBean>() { // from class: client.android.yixiaotong.v3.ui.server.ChangeSchoolActivity.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(ChangeSchoolActivity.this.getActivity(), "正在解析二维码.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SchoolIdBean schoolIdBean, Object... objArr) {
                super.onComplete(controller, schoolIdBean, objArr);
                if (ChangeSchoolActivity.this.mIsEnable) {
                    ChangeSchoolActivity.this.getSchoolInfos(schoolIdBean.schoolId);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (ChangeSchoolActivity.this.mIsEnable) {
                    ChangeSchoolActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getSchoolInfos(final String str) {
        V3BusinessControllers.getInstance().getSchoolInfos(getLoginAccount(), str, false, new Listener<List<SchoolInfosBean>>() { // from class: client.android.yixiaotong.v3.ui.server.ChangeSchoolActivity.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<SchoolInfosBean> list, Object... objArr) {
                if (ChangeSchoolActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (list == null || list.size() <= 0 || list.get(0) == null) {
                        return;
                    }
                    BindSchoolDialog.getInstance().showDialog(ChangeSchoolActivity.this.getActivity(), new BindSchoolDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.server.ChangeSchoolActivity.4.1
                        @Override // client.android.yixiaotong.v3.ui.dialog.BindSchoolDialog.Listener
                        public void onConfirm(String str2) {
                            LogUtil.e(ChangeSchoolActivity.TAG, "bindSchool:" + ChangeSchoolActivity.this.mIsEnable);
                            ChangeSchoolActivity.this.bindSchool(str, str2);
                        }
                    }, list.get(0).schoolName, list.get(0).schoolAddress);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (ChangeSchoolActivity.this.mIsEnable) {
                    ChangeSchoolActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindSchool(final String str, String str2) {
        V3BusinessControllers.getInstance().postBindSchoolInfo(getLoginAccount(), str, str2, false, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v3.ui.server.ChangeSchoolActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(ChangeSchoolActivity.this.getActivity(), "绑定学校.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (ChangeSchoolActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(ChangeSchoolActivity.this.getContext(), "绑定学校成功！");
                    LocalDataUtil.saveIsNeedLoadUserInfo(ChangeSchoolActivity.this.getContext(), true);
                    UserInfoUtil.getInstance().saveBindSchoolId(str);
                    ChangeSchoolActivity.this.finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (ChangeSchoolActivity.this.mIsEnable) {
                    ChangeSchoolActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.server.ChangeSchoolActivity.6
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    ChangeSchoolActivity.this.finish();
                }
            }, clientException.getDetail());
        } else {
            V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
            finish();
        }
    }

    private void getAdv() {
        if (this.mIsShowAdv) {
            return;
        }
        this.mNativeUtil = new NativeUtil();
        this.mAdvListener = new AdvControlUtil.AdvListener() { // from class: client.android.yixiaotong.v3.ui.server.ChangeSchoolActivity.8
            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdClosed(Common.AdvType advType) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onRenderSuccess(View view, int i) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void isOpen(int i, int i2, int i3, int i4, int i5) {
                if (i5 == 1) {
                    ChangeSchoolActivity.this.mNativeUtil.initNative(ChangeSchoolActivity.this.getActivity(), ChangeSchoolActivity.this.mAdvListener, 1);
                    ChangeSchoolActivity.this.mNativeUtil.onNative(ChangeSchoolActivity.this.flContainer);
                }
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdShow(String str, Common.AdvType advType) {
                ChangeSchoolActivity.this.mIsShowAdv = true;
            }
        };
        AdvControlUtil.getInstance().init(getActivity(), this.mAdvListener, 1, true, "");
        AdvControlUtil.getInstance().initAdvInfo();
    }
}
