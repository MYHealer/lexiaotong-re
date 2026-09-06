package client.android.yixiaotong.ui.doorlock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.bean.doorlock.AuthUserInfoBean;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AuthenticationSuccessActivity extends BaseActivity {
    public static final String EXTRA_AUTHINFO = "extra_authinfo";
    public static final String EXTRA_FROMME = "extra_fromme";
    public static final String EXTRA_WALLET = "extra_wallet";
    public static final int FROMME = 1;
    private AuthUserInfoBean mAuthUserInfoBean;
    private Button mBtnFinish;
    private int mFromMe;
    private boolean mIsEnable = true;
    private TitleBar mTitleBar;
    private TextView mTvAddress;
    private TextView mTvIdentityId;
    private TextView mTvName;
    private TextView mTvSex;
    private WalletModel mWalletModel;

    static {
        StubApp.interface11(6921);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, WalletModel walletModel, AuthUserInfoBean authUserInfoBean) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) AuthenticationSuccessActivity.class).putExtra("extra_wallet", walletModel).putExtra("extra_authinfo", authUserInfoBean));
        }
    }

    public static void launch(Activity activity, WalletModel walletModel, AuthUserInfoBean authUserInfoBean, int i) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) AuthenticationSuccessActivity.class).putExtra("extra_wallet", walletModel).putExtra("extra_authinfo", authUserInfoBean).putExtra(EXTRA_FROMME, i));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titlebar);
        this.mTvName = (TextView) findViewById(R.id.tv_name);
        this.mTvSex = (TextView) findViewById(R.id.tv_sex);
        this.mTvIdentityId = (TextView) findViewById(R.id.tv_identityId);
        this.mTvAddress = (TextView) findViewById(R.id.tv_address);
        this.mBtnFinish = (Button) findViewById(R.id.btn_finish);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("验证成功");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        this.mTvName.setText(this.mAuthUserInfoBean.studentname);
        if (StringUtils.isNotEmpty(this.mAuthUserInfoBean.sex)) {
            if (Integer.parseInt(this.mAuthUserInfoBean.sex) == 1) {
                this.mTvSex.setText("男");
            } else if (Integer.parseInt(this.mAuthUserInfoBean.sex) == 2) {
                this.mTvSex.setText("女");
            }
        }
        if (StringUtils.isNotEmpty(this.mAuthUserInfoBean.identityid) && this.mAuthUserInfoBean.identityid.length() > 2) {
            this.mTvIdentityId.setText(this.mAuthUserInfoBean.identityid.substring(0, 1) + "**************" + this.mAuthUserInfoBean.identityid.substring(this.mAuthUserInfoBean.identityid.length() - 1));
        }
        this.mTvAddress.setText(this.mAuthUserInfoBean.room);
        if (this.mFromMe == 1) {
            this.mBtnFinish.setVisibility(4);
        }
    }

    private void initClickListeners() {
        findViewById(R.id.btn_finish).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.doorlock.AuthenticationSuccessActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m99x735b5c81(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-ui-doorlock-AuthenticationSuccessActivity, reason: not valid java name */
    /* synthetic */ void m99x735b5c81(View view) {
        DoorLockMainActivity.launch(getActivity(), this.mWalletModel);
        finish();
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

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }
}
