package client.android.yixiaotong.v3.ui.me.ykt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
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
import client.android.yixiaotong.v3.bean.ykt.YKTBindStateBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class YKTDetailActivity extends BaseActivity {
    private boolean mIsEnable = true;
    private LinearLayout mLinBinded;
    private LinearLayout mLinUnBind;
    private TitleBar mTitleBar;
    private TextView mTvYKTAccount;

    static {
        StubApp.interface11(9966);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) YKTDetailActivity.class));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titlebar);
        this.mLinUnBind = (LinearLayout) findViewById(R.id.lin_unbind);
        this.mLinBinded = (LinearLayout) findViewById(R.id.lin_binded);
        this.mTvYKTAccount = (TextView) findViewById(R.id.tv_yktaccount);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.yikatong));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initView(int i, String str) {
        if (i == 1) {
            this.mLinUnBind.setVisibility(8);
            this.mLinBinded.setVisibility(0);
            this.mTvYKTAccount.setText(getAccount(str));
        } else {
            this.mLinUnBind.setVisibility(0);
            this.mLinBinded.setVisibility(8);
            this.mTvYKTAccount.setText("");
        }
    }

    private String getAccount(String str) {
        if (!StringUtils.isNotEmpty(str) || str.length() < 2) {
            return StringUtils.isNotEmpty(str) ? "*" : str;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length() / 2; i++) {
            sb.append("*");
        }
        sb.append(str.substring(str.length() / 2));
        return sb.toString();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        getYKTState();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
    }

    private void initClickListeners() {
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.me.ykt.YKTDetailActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m379x99549829(view);
            }
        };
        findViewById(R.id.rel_tobind).setOnClickListener(onClickListener);
        findViewById(R.id.img_edit).setOnClickListener(onClickListener);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-me-ykt-YKTDetailActivity, reason: not valid java name */
    /* synthetic */ void m379x99549829(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        YKTBindActivity.launch(getActivity());
    }

    private void getYKTState() {
        V3BusinessControllers.getInstance().getExtendCardInfo(getLoginAccount(), InvestorInfoUtilControl.getInstance().getInvestorId(), UserInfoUtilControl.getInstance().getSchoolId(), UserInfoUtilControl.getInstance().getStudentId(), new Listener<YKTBindStateBean>() { // from class: client.android.yixiaotong.v3.ui.me.ykt.YKTDetailActivity.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(YKTDetailActivity.this.getActivity(), "正在获取状态..", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, YKTBindStateBean yKTBindStateBean, Object... objArr) {
                if (YKTDetailActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    YKTDetailActivity.this.initView(yKTBindStateBean.statusFlag, yKTBindStateBean.cardNumber);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (YKTDetailActivity.this.mIsEnable) {
                    YKTDetailActivity.this.onError(clientException, true);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException, boolean z) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (clientException.isNeedTip(clientException.getCode())) {
            showDialog(z, false, false, clientException.getDetail() + "\n(" + LocalDataUtil.getTraceID(getActivity()) + ")");
            return;
        }
        V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
        if (z) {
            finish();
        }
    }

    public void showDialog(boolean z, boolean z2, boolean z3, String str) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (z2) {
            str = str + "\n(" + LocalDataUtil.getTraceID(getActivity()) + ")";
        }
        String str2 = str;
        if (z && !z3) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), "", str2, "", false, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.me.ykt.YKTDetailActivity.2
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    YKTDetailActivity.this.finish();
                }
            });
        } else if (z && z3) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.me.ykt.YKTDetailActivity.3
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    YKTDetailActivity.this.finish();
                }
            }, str2);
        } else {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), str2);
        }
    }
}
