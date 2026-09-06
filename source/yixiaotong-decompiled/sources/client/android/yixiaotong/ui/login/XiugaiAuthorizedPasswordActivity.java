package client.android.yixiaotong.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.hamam.BathHousePasswordBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.error.ErrorUtil;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.sdk.utils.RandomUtil;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.AESHelper;
import client.android.yixiaotong.util.StringUtils;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class XiugaiAuthorizedPasswordActivity extends BaseActivity {
    public static final String EXTRA_CAPTCACODE = "extra_captcacode";
    public static final String EXTRA_LAUNCH_MODE = "extra_launch_mode";
    public static final String EXTRA_MOBILE = "extra_mobile";
    public static final int LAUNCH_MODIFY_SHOUQUAN_MODE = 3;
    private boolean mIsEnable = true;
    private int mLaunchMode;
    Button mVBtnFinish;
    EditText mVEtOldPassword;
    EditText mVEtPassword;
    EditText mVEtPasswordAgain;
    TitleBar mVTitleBar;

    static {
        StubApp.interface11(7473);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    private void initViewNew() {
        this.mVTitleBar = (TitleBar) findViewById(R.id.v_titleBar);
        this.mVEtOldPassword = (EditText) findViewById(R.id.v_et_old_password);
        this.mVEtPassword = (EditText) findViewById(R.id.v_et_password);
        this.mVEtPasswordAgain = (EditText) findViewById(R.id.v_et_password_again);
        this.mVBtnFinish = (Button) findViewById(R.id.v_btn_finish);
    }

    private void initClickListeners() {
        findViewById(R.id.v_btn_finish).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.login.XiugaiAuthorizedPasswordActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m165x86c1fc8f(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-ui-login-XiugaiAuthorizedPasswordActivity, reason: not valid java name */
    /* synthetic */ void m165x86c1fc8f(View view) {
        if (check()) {
            modifyShouQuanPasswordNew();
        }
    }

    public static void launch(Activity activity, String str, String str2, int i) {
        Intent intent = new Intent(activity, (Class<?>) XiugaiAuthorizedPasswordActivity.class);
        intent.putExtra("extra_launch_mode", i);
        intent.putExtra("extra_captcacode", str2);
        intent.putExtra("extra_mobile", str);
        activity.startActivity(intent);
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

    private void initData() {
        this.mLaunchMode = getIntent().getIntExtra("extra_launch_mode", 0);
    }

    private void initTitleBar() {
        this.mVTitleBar.setTitleView("修改密钥");
        this.mVTitleBar.setLeftView(R.mipmap.back);
        this.mVTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private boolean check() {
        if (this.mLaunchMode == 3 && StringUtils.isTrimEmpty(this.mVEtOldPassword.getText().toString())) {
            toast("请输入原授权密钥（后面6位）");
            return false;
        }
        if (StringUtils.isTrimEmpty(this.mVEtPassword.getText().toString())) {
            toast("请输入新授权密钥（6位纯数字）");
            return false;
        }
        if (this.mVEtPassword.getText().toString().length() != 6) {
            toast("授权密钥必须是6位");
            return false;
        }
        if (StringUtils.isTrimEmpty(this.mVEtPasswordAgain.getText().toString())) {
            toast("请输入确认授权密钥");
            return false;
        }
        if (this.mVEtPasswordAgain.getText().toString().equals(this.mVEtPassword.getText().toString())) {
            return true;
        }
        toast("新授权密钥与确认授权密钥不一致");
        return false;
    }

    private void modifyShouQuanPasswordNew() {
        BusinessControllers.getInstance().postChangeAuthorizedPassword(getLoginAccount(), this.mVEtPassword.getText().toString(), this.mVEtOldPassword.getText().toString(), 11, RandomUtil.getRandNumMaxString(6), new Listener<BathHousePasswordBean>() { // from class: client.android.yixiaotong.ui.login.XiugaiAuthorizedPasswordActivity.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, BathHousePasswordBean bathHousePasswordBean, Object... objArr) {
                String strDecrypt;
                if (!XiugaiAuthorizedPasswordActivity.this.mIsEnable || bathHousePasswordBean == null) {
                    return;
                }
                XiugaiAuthorizedPasswordActivity.this.toast("修改授权密码成功");
                try {
                    strDecrypt = AESHelper.decrypt(bathHousePasswordBean.typePassword, StringUtils.asciiToString("121,107,116,95,50,48,49,55,95,64,37,48,50,48,95,87,90,81,73,84,83,84,89,85,73,74,104,100,48,56,48,50"));
                } catch (Exception e) {
                    e.printStackTrace();
                    strDecrypt = "";
                }
                if (StringUtils.isNotEmpty(strDecrypt) && strDecrypt.length() == 10) {
                    LocalBusinessStore.saveAuthorizedPassword(XiugaiAuthorizedPasswordActivity.this.getContext(), XiugaiAuthorizedPasswordActivity.this.getLoginAccount().getUid(), strDecrypt);
                }
                XiugaiAuthorizedPasswordActivity.this.finish();
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (XiugaiAuthorizedPasswordActivity.this.mIsEnable) {
                    ErrorUtil.onFailResult(XiugaiAuthorizedPasswordActivity.this.getActivity(), XiugaiAuthorizedPasswordActivity.this.mVTitleBar.getTitleViewContent(), clientException, true);
                }
            }
        });
    }
}
