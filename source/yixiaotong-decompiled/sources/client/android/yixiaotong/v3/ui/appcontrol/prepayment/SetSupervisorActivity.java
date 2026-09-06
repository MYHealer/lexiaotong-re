package client.android.yixiaotong.v3.ui.appcontrol.prepayment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.dialog.TwoButtonDialog;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.bean.prepayment.UserInfoByMobileBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.account.UpdateInfoActivity;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfo;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class SetSupervisorActivity extends BaseActivity {
    private static final String TAG;
    private EditText mEtPhone;
    private boolean mIsEnable = true;
    private String mMachineId;
    private String mStudentId;
    private String mStudentName;
    private TitleBar mTitleBar;

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    static {
        StubApp.interface11(9482);
        TAG = "SelecetDeviceActivity";
    }

    public static void launch(Activity activity, String str) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) SetSupervisorActivity.class).putExtra("machineid", str));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mEtPhone = (EditText) findViewById(R.id.et_phone);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.changedormitoryleader));
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

    private void initClickListeners() {
        findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.SetSupervisorActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m307x401ba4f9(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-appcontrol-prepayment-SetSupervisorActivity, reason: not valid java name */
    /* synthetic */ void m307x401ba4f9(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        validateAndSavePhoneNumber();
    }

    private void validateAndSavePhoneNumber() {
        if (StringUtils.isEmpty(this.mEtPhone.getText().toString())) {
            ToastUtils.show(getActivity(), "请输入手机号");
        } else {
            getUserByStudentMobile();
        }
    }

    private void getUserByStudentMobile() {
        V3BusinessControllers.getInstance().getUserByStudentMobile(getLoginAccount(), this.mEtPhone.getText().toString(), new Listener<UserInfoByMobileBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.SetSupervisorActivity.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(SetSupervisorActivity.this.getActivity(), "正在处理中..", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, UserInfoByMobileBean userInfoByMobileBean, Object... objArr) {
                if (SetSupervisorActivity.this.mIsEnable) {
                    if (userInfoByMobileBean == null || !StringUtils.isNotEmpty(userInfoByMobileBean.studentId)) {
                        SetSupervisorActivity.this.showDialog("个人信息异常");
                        return;
                    }
                    if (StringUtils.isNotEmpty(userInfoByMobileBean.studentName)) {
                        SetSupervisorActivity.this.mStudentId = userInfoByMobileBean.studentId;
                        SetSupervisorActivity.this.mStudentName = userInfoByMobileBean.studentName;
                        SetSupervisorActivity.this.changeSupervisor();
                        return;
                    }
                    final UserInfo loginAccountV3 = UserInfoUtil.getInstance().getLoginAccountV3();
                    if (loginAccountV3 == null || !loginAccountV3.studentId.equals(userInfoByMobileBean.studentId)) {
                        SetSupervisorActivity.this.showDialog("手机号对应账号的姓名为空，姓名为空不允许成为舍长");
                    } else {
                        TwoButtonDialog.getInstance().showDialog(SetSupervisorActivity.this.getActivity(), new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.SetSupervisorActivity.1.1
                            @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
                            public void onCancle() {
                            }

                            @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
                            public void onConfirm() {
                                UpdateInfoActivity.launch(SetSupervisorActivity.this.getActivity(), loginAccountV3.studentName, loginAccountV3.studentGender, "", 2, true);
                            }
                        }, "提示", "未设置姓名，无法成为舍长，是否去设置？", "暂不", "去设置");
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (SetSupervisorActivity.this.mIsEnable) {
                    SetSupervisorActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeSupervisor() {
        V3BusinessControllers.getInstance().changeSupervisor(getLoginAccount(), this.mStudentId, this.mMachineId, this.mStudentName, this.mEtPhone.getText().toString(), UserInfoUtilControl.getInstance().getSchoolId(), InvestorInfoUtilControl.getInstance().getInvestorInfoBean().investorId, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.SetSupervisorActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(SetSupervisorActivity.this.getActivity(), "正在处理中..", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (SetSupervisorActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(SetSupervisorActivity.this.getActivity(), "更换舍长成功");
                    LocalDataUtil.saveIsNeedGetPrepaymentSupervisorInfo(SetSupervisorActivity.this.getActivity(), true);
                    SetSupervisorActivity.this.finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (SetSupervisorActivity.this.mIsEnable) {
                    SetSupervisorActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.SetSupervisorActivity.3
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                }
            }, clientException.getDetail() + "\n(" + LocalDataUtil.getTraceID(getActivity()) + ")");
        } else {
            V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(String str) {
        BaseMaterialDialog.dissmisMaterialDialog();
        SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.SetSupervisorActivity.4
            @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
            public void onConfirm() {
            }
        }, str + "\n(" + LocalDataUtil.getTraceID(getActivity()) + ")");
    }
}
