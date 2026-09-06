package client.android.yixiaotong.v3.ui.register;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.v3.userinfo.UserInfo;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ChangePhoneActivity extends BaseActivity {
    private boolean mIsEnable = true;
    private TitleBar mTitleBar;
    private TextView mTvPhone;
    private UserInfo mUserInfo;

    static {
        StubApp.interface11(10103);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) ChangePhoneActivity.class));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTvPhone = (TextView) findViewById(R.id.tv_phone);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.changephone));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        this.mTvPhone.setText(this.mTvPhone.getText().toString() + this.mUserInfo.studentMobile);
    }

    private void initClickListeners() {
        findViewById(R.id.btn_reset).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.register.ChangePhoneActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m396xb8e7346a(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-register-ChangePhoneActivity, reason: not valid java name */
    /* synthetic */ void m396xb8e7346a(View view) {
        ChangePhoneGetVerifyActivity.launch(getActivity());
        finish();
    }
}
