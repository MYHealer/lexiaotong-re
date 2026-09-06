package client.android.yixiaotong.v3.ui.about;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.bean.login.InvestorInfosBean;
import client.android.yixiaotong.v3.bean.login.SchoolInfosBean;
import client.android.yixiaotong.v3.bean.order.UnPayOrderBean;
import client.android.yixiaotong.v3.bean.order.UnPayOrdersBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.ui.order.ConsumeRecordActivity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtil;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.stub.StubApp;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class CancelAccountActivity extends BaseActivity {
    private static final String TAG = "CancelAccountActivity";
    private Button mBtnCancel;
    private Button mBtnConfirt;
    private String mInvestorId;
    private boolean mIsEnable = true;
    private String mMobile;
    private String mSchoolId;
    private int mStatus;
    private String mStudentId;
    private TitleBar mTitleBar;

    static {
        StubApp.interface11(8908);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) CancelAccountActivity.class));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mBtnConfirt = (Button) findViewById(R.id.btn_confirm);
        this.mBtnCancel = (Button) findViewById(R.id.btn_cancel);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("注销账号");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        long jCurrentTimeMillis;
        this.mMobile = UserInfoUtil.getInstance().getLoginAccountV3().studentMobile;
        this.mStudentId = UserInfoUtil.getInstance().getLoginAccountV3().studentId;
        this.mInvestorId = InvestorInfoUtilControl.getInstance().getInvestorId();
        this.mSchoolId = UserInfoUtilControl.getInstance().getSchoolId();
        String accoutCancelTime = LocalDataUtil.getAccoutCancelTime(getActivity(), this.mMobile);
        if (StringUtils.isEmpty(accoutCancelTime)) {
            this.mBtnCancel.setVisibility(8);
            getUnPayOrder();
            return;
        }
        String currentTime = LocalDataUtil.getCurrentTime(getActivity());
        if (StringUtils.isNotEmpty(currentTime)) {
            jCurrentTimeMillis = Long.parseLong(currentTime) / 1000;
        } else {
            jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        }
        long j = Long.parseLong(accoutCancelTime) / 1000;
        LogUtil.e(TAG, jCurrentTimeMillis + "  " + j + "  " + System.currentTimeMillis());
        if (jCurrentTimeMillis - j >= 259200) {
            this.mBtnConfirt.setText("确认注销");
        } else {
            this.mBtnConfirt.setVisibility(8);
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = true;
        BaseMaterialDialog.dissmisMaterialDialog();
    }

    private void initClickListeners() {
        findViewById(R.id.btn_confirm).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.about.CancelAccountActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m223x818b1d5b(view);
            }
        });
        findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.about.CancelAccountActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m224x3c00bddc(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-about-CancelAccountActivity, reason: not valid java name */
    /* synthetic */ void m223x818b1d5b(View view) {
        if (this.mBtnConfirt.getText().toString().equals(getResources().getString(R.string.cancel_account))) {
            this.mStatus = 2;
            showTwoButDialog("已提交账号注销申请，账号将被停用，如确实需要注销，三天后请再次确认");
        } else {
            this.mStatus = 3;
            getUnPayOrder();
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-about-CancelAccountActivity, reason: not valid java name */
    /* synthetic */ void m224x3c00bddc(View view) {
        this.mStatus = 1;
        showTwoButDialog("账号将恢复使用，是否确认取消注销操作");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showTwoButDialog(String str) {
        TwoButtonDialog.getInstance().showDialog(getActivity(), new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.about.CancelAccountActivity.1
            @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
            public void onCancle() {
            }

            @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
            public void onConfirm() {
                if (CancelAccountActivity.this.mStatus == 3) {
                    CancelAccountActivity.this.appUpdateUserStatus();
                } else {
                    CancelAccountActivity.this.appUpdateUserStatus();
                }
            }
        }, "提示", str, R.color.ff242933, "取消", "确认");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showCancelTipDialog(final UnPayOrderBean unPayOrderBean) {
        if (StringUtils.isNotEmpty(this.mInvestorId) && StringUtils.isNotEmpty(this.mSchoolId) && unPayOrderBean.investorId.equals(this.mInvestorId) && unPayOrderBean.schoolId.equals(this.mSchoolId)) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.about.CancelAccountActivity.2
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    ConsumeRecordActivity.launch(CancelAccountActivity.this.getActivity(), unPayOrderBean.typeId, true);
                    CancelAccountActivity.this.finish();
                }
            }, "有未完成订单，请先取消注销，完成支付再重新申请", "确定");
        } else if (StringUtils.isNotEmpty(this.mSchoolId) && unPayOrderBean.schoolId.equals(this.mSchoolId)) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.about.CancelAccountActivity.3
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                }
            }, "此服务商“" + getInvestorInfo(unPayOrderBean.investorId) + "”有未完成订单，请先取消注销，完成支付再重新申请", "确定");
        } else {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.about.CancelAccountActivity.4
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                }
            }, "此学校“" + getSchoolInfo(unPayOrderBean.schoolId) + "”有未完成订单，请先取消注销，完成支付再重新申请", "确定");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showTwoDialog(final UnPayOrderBean unPayOrderBean) {
        if (StringUtils.isNotEmpty(this.mInvestorId) && StringUtils.isNotEmpty(this.mSchoolId) && unPayOrderBean.investorId.equals(this.mInvestorId) && unPayOrderBean.schoolId.equals(this.mSchoolId)) {
            TwoButtonDialog.getInstance().showDialog(getActivity(), new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.about.CancelAccountActivity.5
                @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
                public void onConfirm() {
                    ConsumeRecordActivity.launch(CancelAccountActivity.this.getActivity(), unPayOrderBean.typeId, true);
                    CancelAccountActivity.this.finish();
                }

                @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
                public void onCancle() {
                    CancelAccountActivity.this.finish();
                }
            }, "提示", "有未支付订单，请前往账单页支付", R.color.ff242933, "取消", "查看账单");
        } else if (StringUtils.isNotEmpty(this.mSchoolId) && unPayOrderBean.schoolId.equals(this.mSchoolId)) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.about.CancelAccountActivity.6
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    CancelAccountActivity.this.finish();
                }
            }, "此服务商“" + getInvestorInfo(unPayOrderBean.investorId) + "”有未支付订单，请前往账单页支付", "确定");
        } else {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.about.CancelAccountActivity.7
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    CancelAccountActivity.this.finish();
                }
            }, "此学校“" + getSchoolInfo(unPayOrderBean.schoolId) + "”有未支付订单，请前往账单页支付", "确定");
        }
    }

    private void getUnPayOrder() {
        V3BusinessControllers.getInstance().getUnPayOrderIndex(getLoginAccount(), this.mStudentId, new Listener<UnPayOrdersBean>() { // from class: client.android.yixiaotong.v3.ui.about.CancelAccountActivity.8
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(CancelAccountActivity.this.getActivity(), "加载中..", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, UnPayOrdersBean unPayOrdersBean, Object... objArr) {
                if (CancelAccountActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (unPayOrdersBean == null || unPayOrdersBean.metaList == null || unPayOrdersBean.metaList.size() <= 0) {
                        if (CancelAccountActivity.this.mStatus == 3) {
                            CancelAccountActivity.this.showTwoButDialog("账号将永久注销，注销后不可再登录，所有历史数据将不可见，是否确认操作");
                        }
                    } else {
                        UnPayOrderBean unPayOrderBean = unPayOrdersBean.metaList.get(0);
                        LogUtil.e(CancelAccountActivity.TAG, unPayOrderBean.investorId + "  " + CancelAccountActivity.this.mInvestorId + "  " + unPayOrderBean.typeId + "  " + unPayOrderBean.schoolId + "  " + CancelAccountActivity.this.mSchoolId);
                        if (CancelAccountActivity.this.mStatus == 3) {
                            CancelAccountActivity.this.showCancelTipDialog(unPayOrderBean);
                        } else {
                            CancelAccountActivity.this.showTwoDialog(unPayOrderBean);
                        }
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (CancelAccountActivity.this.mIsEnable) {
                    CancelAccountActivity.this.onError(true, clientException);
                }
            }
        });
    }

    private String getSchoolInfo(String str) {
        List<SchoolInfosBean> list = UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList;
        if (list == null || list.size() <= 0) {
            return null;
        }
        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i).id + "").equals(str)) {
                return list.get(i).schoolName;
            }
        }
        return null;
    }

    private String getInvestorInfo(String str) {
        List<InvestorInfosBean> investorInfosV3 = InvestorInfoUtil.getInstance().getInvestorInfosV3();
        if (investorInfosV3 == null || investorInfosV3.size() <= 0) {
            return null;
        }
        for (int i = 0; i < investorInfosV3.size(); i++) {
            if (investorInfosV3.get(i).investorInfo.investorId.equals(str)) {
                return investorInfosV3.get(i).investorInfo.providerJson.providerName;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appUpdateUserStatus() {
        V3BusinessControllers.getInstance().appUpdateUserStatus(getLoginAccount(), this.mStatus, this.mMobile, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v3.ui.about.CancelAccountActivity.9
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(CancelAccountActivity.this.getActivity(), "正在处理中", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (CancelAccountActivity.this.mIsEnable) {
                    if (CancelAccountActivity.this.mStatus == 1 || CancelAccountActivity.this.mStatus == 3) {
                        LocalDataUtil.saveAccoutCancelTime(CancelAccountActivity.this.getActivity(), CancelAccountActivity.this.mMobile, "");
                        LocalDataUtil.saveCurrentTime(CancelAccountActivity.this.getActivity(), "");
                    }
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(CancelAccountActivity.this.getActivity(), "申请成功");
                    CancelAccountActivity.this.exitLogin();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (CancelAccountActivity.this.mIsEnable) {
                    CancelAccountActivity.this.onError(false, clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(final boolean z, ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.about.CancelAccountActivity.10
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    if (z) {
                        CancelAccountActivity.this.finish();
                    }
                }
            }, clientException.getDetail());
            return;
        }
        V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
        if (z) {
            finish();
        }
    }
}
