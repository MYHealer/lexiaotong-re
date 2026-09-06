package client.android.yixiaotong.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.about.CancelAccountActivity;
import client.android.yixiaotong.ui.about.ContactUsActivity;
import client.android.yixiaotong.ui.h5display.FoodHelpActivity;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.v3.ui.about.LicenseV3Activity;
import client.android.yixiaotong.v3.ui.jump.JunpWebActivity;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class AboutActivity extends BaseActivity {
    RelativeLayout mEmailView;
    RelativeLayout mLicenseView;
    RelativeLayout mLicenseView1;
    RelativeLayout mPhoneView;
    RelativeLayout mRelCancelAccount;
    RelativeLayout mRelContactUs;
    RelativeLayout mRelUploadApp;
    TitleBar mTitleBar;
    TextView mTvBeianNo;
    TextView mTvVersion;
    RelativeLayout mWebSiteView;
    RelativeLayout mWebSiteView1;

    static {
        StubApp.interface11(5862);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) AboutActivity.class));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mLicenseView = (RelativeLayout) findViewById(R.id.agreement);
        this.mLicenseView1 = (RelativeLayout) findViewById(R.id.agreement1);
        this.mPhoneView = (RelativeLayout) findViewById(R.id.phone);
        this.mEmailView = (RelativeLayout) findViewById(R.id.email);
        this.mWebSiteView = (RelativeLayout) findViewById(R.id.website);
        this.mWebSiteView1 = (RelativeLayout) findViewById(R.id.website1);
        this.mTvVersion = (TextView) findViewById(R.id.tv_version);
        this.mRelUploadApp = (RelativeLayout) findViewById(R.id.rel_app);
        this.mRelContactUs = (RelativeLayout) findViewById(R.id.rel_contactus);
        this.mRelCancelAccount = (RelativeLayout) findViewById(R.id.rel_cancelaccount);
        this.mTvBeianNo = (TextView) findViewById(R.id.tv_beian);
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.AboutActivity$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LicenseV3Activity.launch(AboutActivity.this.getActivity());
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.AboutActivity$2, reason: invalid class name */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PrivacyPolicyActivity.launch(AboutActivity.this.getActivity());
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.AboutActivity$3, reason: invalid class name */
    class AnonymousClass3 implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }

        AnonymousClass3() {
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.AboutActivity$4, reason: invalid class name */
    class AnonymousClass4 implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }

        AnonymousClass4() {
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.AboutActivity$5, reason: invalid class name */
    class AnonymousClass5 implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }

        AnonymousClass5() {
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.AboutActivity$6, reason: invalid class name */
    class AnonymousClass6 implements View.OnClickListener {
        AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FoodHelpActivity.launch(AboutActivity.this.getActivity(), "http://lexiaotong.cn:8090/page/zk.html");
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.AboutActivity$7, reason: invalid class name */
    class AnonymousClass7 implements View.OnClickListener {
        AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LeXiaoTongQrcodeActivity.launch(AboutActivity.this.getActivity());
            AboutActivity.this.finish();
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.AboutActivity$8, reason: invalid class name */
    class AnonymousClass8 implements View.OnClickListener {
        AnonymousClass8() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ContactUsActivity.launch(AboutActivity.this.getActivity());
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.AboutActivity$9, reason: invalid class name */
    class AnonymousClass9 implements View.OnClickListener {
        AnonymousClass9() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CancelAccountActivity.launch(AboutActivity.this.getActivity());
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.AboutActivity$10, reason: invalid class name */
    class AnonymousClass10 implements View.OnClickListener {
        AnonymousClass10() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            JunpWebActivity.launch(AboutActivity.this.getActivity(), "https://beian.miit.gov.cn");
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("关于中卡");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        Log.e("test", "schoolid:" + getLoginAccount().getAccountManagetStore().getUserInfo().AreaId);
        long j = getLoginAccount().getAccountManagetStore().getUserInfo().AreaId;
        if (j == 1 || j == 25004) {
            this.mRelContactUs.setVisibility(0);
            this.mRelCancelAccount.setVisibility(0);
        }
    }
}
