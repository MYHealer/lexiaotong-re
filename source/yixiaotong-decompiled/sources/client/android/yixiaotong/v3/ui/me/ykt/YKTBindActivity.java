package client.android.yixiaotong.v3.ui.me.ykt;

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
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.bean.ykt.YKTBindStateBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class YKTBindActivity extends BaseActivity {
    private EditText mEtAccount;
    private EditText mEtPsw;
    private boolean mIsEnable = true;
    private TitleBar mTitleBar;

    static {
        StubApp.interface11(9961);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) YKTBindActivity.class));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titlebar);
        this.mEtAccount = (EditText) findViewById(R.id.et_account);
        this.mEtPsw = (EditText) findViewById(R.id.et_psw);
    }

    private void initTitleBar() {
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setTitleView("绑定一卡通");
    }

    private void initClickListeners() {
        findViewById(R.id.btn_bind).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.me.ykt.YKTBindActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m378x32cc4e55(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-me-ykt-YKTBindActivity, reason: not valid java name */
    /* synthetic */ void m378x32cc4e55(View view) {
        if (ClickUtil.isFastDoubleClick() || !check()) {
            return;
        }
        YKTBind();
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
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
    }

    private boolean check() {
        if (StringUtils.isEmpty(this.mEtAccount.getText().toString())) {
            ToastUtils.show(getActivity(), "请输入一卡通账号");
            return false;
        }
        if (!StringUtils.isEmpty(this.mEtPsw.getText().toString())) {
            return true;
        }
        ToastUtils.show(getActivity(), "请输入密码");
        return false;
    }

    private void YKTBind() {
        V3BusinessControllers.getInstance().bindExtendCardInfo(getLoginAccount(), InvestorInfoUtilControl.getInstance().getInvestorId(), UserInfoUtilControl.getInstance().getSchoolId(), UserInfoUtilControl.getInstance().getStudentId(), this.mEtAccount.getText().toString(), this.mEtPsw.getText().toString(), new Listener<YKTBindStateBean>() { // from class: client.android.yixiaotong.v3.ui.me.ykt.YKTBindActivity.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(YKTBindActivity.this.getActivity(), "正在绑定中..", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, YKTBindStateBean yKTBindStateBean, Object... objArr) {
                if (YKTBindActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(YKTBindActivity.this.getActivity(), "绑定一卡通成功");
                    YKTBindActivity.this.finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (YKTBindActivity.this.mIsEnable) {
                    YKTBindActivity.this.onError(clientException, false);
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
            SystemErrorTip.getInstance().showTipDialog(getActivity(), "", str2, "", false, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.me.ykt.YKTBindActivity.2
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    YKTBindActivity.this.finish();
                }
            });
        } else if (z && z3) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.me.ykt.YKTBindActivity.3
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    YKTBindActivity.this.finish();
                }
            }, str2);
        } else {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), str2);
        }
    }
}
