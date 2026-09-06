package client.android.yixiaotong.v3.ui.wallet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.dialog.TwoButtonDialog;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.bean.login.InvestorInfoBean;
import client.android.yixiaotong.v3.bean.wallet.PayModelParameter;
import client.android.yixiaotong.v3.bean.wallet.YiKaTongPayResultBean;
import client.android.yixiaotong.v3.bean.wallet.YiKaTongPayResultCardBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.util.ClickUtil;
import com.stub.StubApp;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AuthLoginActivity extends BaseActivity {
    private EditText mEtPsw;
    private EditText mEtStudentNo;
    private InvestorInfoBean mInvestorInfoBean;
    private boolean mIsEnable = true;
    private int mMoney = -1;
    private TitleBar mTitleBar;

    static {
        StubApp.interface11(10242);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivityForResult(new Intent(activity, (Class<?>) AuthLoginActivity.class), 1);
        }
    }

    public static void launch(Activity activity, int i) {
        if (activity != null) {
            activity.startActivityForResult(new Intent(activity, (Class<?>) AuthLoginActivity.class).putExtra(AmmeterWalletDetailActivity.EXTRA_MONEY, i), 1);
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mEtStudentNo = (EditText) findViewById(R.id.et_studentno);
        this.mEtPsw = (EditText) findViewById(R.id.et_psw);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("授权登录");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initClickListeners() {
        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.wallet.AuthLoginActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m422xf737a143(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-wallet-AuthLoginActivity, reason: not valid java name */
    /* synthetic */ void m422xf737a143(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        getPayResultForYiKaTong();
    }

    private boolean isCheckInfo() {
        if (StringUtils.isEmpty(this.mEtStudentNo.getText().toString())) {
            ToastUtils.show(getContext(), "请输入学工号");
            return false;
        }
        if (!StringUtils.isEmpty(this.mEtPsw.getText().toString())) {
            return true;
        }
        ToastUtils.show(getContext(), "请输入密码");
        return false;
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

    private void getPayResultForYiKaTong() {
        if (isCheckInfo()) {
            String str = UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "";
            InvestorInfoBean investorInfoBean = InvestorInfoUtilControl.getInstance().getInvestorInfoBean();
            this.mInvestorInfoBean = investorInfoBean;
            if (investorInfoBean != null) {
                PayModelParameter payModelParameter = new PayModelParameter();
                payModelParameter.idType = "sno";
                payModelParameter.id = this.mEtStudentNo.getText().toString();
                payModelParameter.pwd = this.mEtPsw.getText().toString();
                V3BusinessControllers.getInstance().getPayResultForYiKaTong(getLoginAccount(), str, this.mInvestorInfoBean.investorId, 7, "wideBodyQueryCard", payModelParameter, new Listener<YiKaTongPayResultBean>() { // from class: client.android.yixiaotong.v3.ui.wallet.AuthLoginActivity.1
                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onStart(Controller controller) {
                        super.onStart(controller);
                        BaseMaterialDialog.showMaterialDialog(AuthLoginActivity.this.getActivity(), "正在授权登录中.", false);
                    }

                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onComplete(Controller controller, YiKaTongPayResultBean yiKaTongPayResultBean, Object... objArr) {
                        if (AuthLoginActivity.this.mIsEnable) {
                            BaseMaterialDialog.dissmisMaterialDialog();
                            if (yiKaTongPayResultBean != null) {
                                if (yiKaTongPayResultBean == null || yiKaTongPayResultBean.card == null || yiKaTongPayResultBean.card.size() <= 0) {
                                    ToastUtils.show(AuthLoginActivity.this.getContext(), "授权登录失败，请重试");
                                    return;
                                }
                                int i = 0;
                                for (int i2 = 0; i2 < yiKaTongPayResultBean.card.size(); i2++) {
                                    i = i + Integer.parseInt(yiKaTongPayResultBean.card.get(i2).unsettle_amount) + Integer.parseInt(yiKaTongPayResultBean.card.get(i2).db_balance);
                                }
                                if (AuthLoginActivity.this.mMoney == -1 || i >= AuthLoginActivity.this.mMoney) {
                                    AuthLoginActivity.this.showDialogTip(i, yiKaTongPayResultBean.card);
                                } else {
                                    SystemErrorTip.getInstance().showTipDialog(AuthLoginActivity.this.getActivity(), "一卡通余额为" + DecimalUtil.divide(i + "", "100") + "元，余额不足");
                                }
                            }
                        }
                    }

                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onFail(Controller controller, ClientException clientException) {
                        if (AuthLoginActivity.this.mIsEnable) {
                            AuthLoginActivity.this.onError(clientException);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogTip(int i, final List<YiKaTongPayResultCardBean> list) {
        TwoButtonDialog.getInstance().showDialog(getActivity(), new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.wallet.AuthLoginActivity.2
            @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
            public void onCancle() {
            }

            @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
            public void onConfirm() {
                Intent intent = new Intent();
                intent.putExtra("card", (Serializable) list);
                AuthLoginActivity.this.setResult(1, intent);
                AuthLoginActivity.this.finish();
            }
        }, "提示", "授权成功，一卡通余额为" + DecimalUtil.divide(i + "", "100") + "元", "取消", "完成支付");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), clientException.getDetail());
        } else {
            V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
        }
    }
}
