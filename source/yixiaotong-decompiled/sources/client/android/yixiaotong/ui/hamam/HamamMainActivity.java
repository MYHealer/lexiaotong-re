package client.android.yixiaotong.ui.hamam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.ViewFlipper;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.model.WalletModel;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class HamamMainActivity extends BaseActivity {
    public static final String EXTRA_WALLET = "extra_wallet";
    FrameLayout mMainLayoutTab1;
    FrameLayout mMainLayoutTab2;
    ViewFlipper mMainSwitcher;
    RadioButton mRBtnAccount;
    RadioButton mRBtnMe;
    private WalletModel mWalletModel;
    private HamamMainFragment mWashMainFragment;
    private HamamMeFragment mWashMeFragment;

    static {
        StubApp.interface11(7309);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    private void initViewNew() {
        this.mMainLayoutTab1 = (FrameLayout) findViewById(R.id.main_layout_tab1);
        this.mMainLayoutTab2 = (FrameLayout) findViewById(R.id.main_layout_tab2);
        this.mMainSwitcher = (ViewFlipper) findViewById(R.id.main_switcher);
        this.mRBtnAccount = (RadioButton) findViewById(R.id.rbtn_account);
        this.mRBtnMe = (RadioButton) findViewById(R.id.rbtn_me);
    }

    private void initClickListeners() {
        findViewById(R.id.rbtn_account).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.hamam.HamamMainActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m135xb2944d40(view);
            }
        });
        findViewById(R.id.rbtn_me).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.hamam.HamamMainActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m136xccafcbdf(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-ui-hamam-HamamMainActivity, reason: not valid java name */
    /* synthetic */ void m135xb2944d40(View view) {
        chooseRadioBtn(view);
        showAccountFragment();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-ui-hamam-HamamMainActivity, reason: not valid java name */
    /* synthetic */ void m136xccafcbdf(View view) {
        chooseRadioBtn(view);
        showMeFragment();
    }

    public static void launch(Activity activity, WalletModel walletModel) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) HamamMainActivity.class).putExtra("extra_wallet", walletModel));
        }
    }

    public WalletModel getmWalletModel() {
        if (this.mWalletModel == null) {
            finish();
        }
        return this.mWalletModel;
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    private void chooseRadioBtn(View view) {
        this.mRBtnAccount.setChecked(false);
        this.mRBtnMe.setChecked(false);
        ((RadioButton) view).setChecked(true);
    }

    private void showAccountFragment() {
        if (this.mMainSwitcher.getDisplayedChild() != 0 || this.mWashMainFragment == null) {
            if (this.mWashMainFragment == null) {
                ((FrameLayout) findViewById(R.id.main_layout_tab1)).removeAllViews();
                this.mWashMainFragment = HamamMainFragment.newInstance();
                getFragmentManager().beginTransaction().replace(R.id.main_layout_tab1, this.mWashMainFragment).commit();
            }
            this.mMainSwitcher.setDisplayedChild(0);
        }
    }

    private void showMeFragment() {
        if (this.mMainSwitcher.getDisplayedChild() != 1 || this.mWashMeFragment == null) {
            if (this.mWashMeFragment == null) {
                ((FrameLayout) findViewById(R.id.main_layout_tab2)).removeAllViews();
                this.mWashMeFragment = HamamMeFragment.newInstance();
                getFragmentManager().beginTransaction().replace(R.id.main_layout_tab2, this.mWashMeFragment).commit();
            }
            this.mMainSwitcher.setDisplayedChild(1);
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.mWashMainFragment = null;
        this.mMainLayoutTab1.removeAllViews();
        this.mMainLayoutTab2.removeAllViews();
    }
}
