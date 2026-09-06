package client.android.yixiaotong.v4.ui.user;

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
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4ChangeLoginPswActivity extends BaseActivity {
    private EditText mEtNewPsw1;
    private EditText mEtNewPsw2;
    private EditText mEtOldPsw;
    private boolean mIsEnable = true;
    private TitleBar mTitleBar;

    static {
        StubApp.interface11(11026);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4ChangeLoginPswActivity.class));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mEtOldPsw = (EditText) findViewById(R.id.et_oldpsw);
        this.mEtNewPsw1 = (EditText) findViewById(R.id.et_newpsw1);
        this.mEtNewPsw2 = (EditText) findViewById(R.id.et_newpsw2);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.changeloginpsw));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initClickListeners() {
        findViewById(R.id.btn_reset).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.user.V4ChangeLoginPswActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (V4ChangeLoginPswActivity.this.isCheckInfo()) {
                    V4ChangeLoginPswActivity.this.resetPsw();
                }
            }
        });
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        V4ErrorControlUtil.getInstance().onResume();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        BaseMaterialDialog.dissmisMaterialDialog();
        V4ErrorControlUtil.getInstance().onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCheckInfo() {
        if (StringUtils.isEmpty(this.mEtOldPsw.getText().toString())) {
            ToastUtils.show(getContext(), "请输入旧密码");
            return false;
        }
        if (StringUtils.isEmpty(this.mEtNewPsw1.getText().toString())) {
            ToastUtils.show(getContext(), "请输入新密码");
            return false;
        }
        if (this.mEtNewPsw1.getText().toString().length() < 6) {
            ToastUtils.show(getContext(), "密码长度是6-18位");
            return false;
        }
        if (StringUtils.isEmpty(this.mEtNewPsw2.getText().toString())) {
            ToastUtils.show(getContext(), "请输入确认密码");
            return false;
        }
        if (this.mEtNewPsw2.getText().toString().length() < 6) {
            ToastUtils.show(getContext(), "密码长度是6-18位");
            return false;
        }
        if (this.mEtNewPsw1.getText().toString().equals(this.mEtNewPsw2.getText().toString())) {
            return true;
        }
        ToastUtils.show(getContext(), "密码与确认密码不一致");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetPsw() {
        V4BusinessControllers.getInstance().postUpdatePassword(getLoginAccount(), this.mEtNewPsw1.getText().toString(), this.mEtOldPsw.getText().toString(), new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v4.ui.user.V4ChangeLoginPswActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(V4ChangeLoginPswActivity.this.getActivity(), "正在修改密码中.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (V4ChangeLoginPswActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(V4ChangeLoginPswActivity.this.getContext(), "修改密码成功，请重新登录");
                    V4ChangeLoginPswActivity.this.finish();
                    V4ChangeLoginPswActivity.this.exitLogin();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4ChangeLoginPswActivity.this.mIsEnable) {
                    V4ChangeLoginPswActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        V4ErrorControlUtil.getInstance().showDialog(clientException, getActivity(), false);
    }
}
