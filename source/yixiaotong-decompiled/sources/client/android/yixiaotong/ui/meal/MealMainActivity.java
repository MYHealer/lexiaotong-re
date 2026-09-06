package client.android.yixiaotong.ui.meal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.ViewFlipper;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.baseutil.BrightnessUtils;
import client.android.yixiaotong.controller.model.WalletModel;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class MealMainActivity extends BaseActivity {
    public static final String EXTRA_WALLET = "extra_wallet";
    private boolean isAutoBrightness = false;
    private int mBrightness;
    FrameLayout mMainLayoutTab1;
    FrameLayout mMainLayoutTab2;
    ViewFlipper mMainSwitcher;
    RadioButton mRBtnAccount;
    RadioButton mRBtnMe;
    private WalletModel mWalletModel;
    private MealMainFragment mWashMainFragment;
    private MealMeFragment mWashMeFragment;

    static {
        StubApp.interface11(7476);
    }

    public WalletModel getmWalletModel() {
        return this.mWalletModel;
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
        findViewById(R.id.rbtn_account).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.meal.MealMainActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MealMainActivity.this.chooseRadioBtn(view);
                MealMainActivity.this.showAccountFragment();
            }
        });
        findViewById(R.id.rbtn_me).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.meal.MealMainActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MealMainActivity.this.chooseRadioBtn(view);
                MealMainActivity.this.showMeFragment();
                BrightnessUtils.setBrightness(MealMainActivity.this.getActivity(), MealMainActivity.this.mBrightness);
                if (MealMainActivity.this.isAutoBrightness) {
                    BrightnessUtils.startAutoBrightness(MealMainActivity.this.getActivity());
                } else {
                    BrightnessUtils.stopAutoBrightness(MealMainActivity.this.getActivity());
                }
            }
        });
    }

    public static void launch(Activity activity, WalletModel walletModel) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) MealMainActivity.class).putExtra("extra_wallet", walletModel));
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chooseRadioBtn(View view) {
        this.mRBtnAccount.setChecked(false);
        this.mRBtnMe.setChecked(false);
        ((RadioButton) view).setChecked(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAccountFragment() {
        if (this.mMainSwitcher.getDisplayedChild() != 0 || this.mWashMainFragment == null) {
            if (this.mWashMainFragment == null) {
                ((FrameLayout) findViewById(R.id.main_layout_tab1)).removeAllViews();
                this.mWashMainFragment = MealMainFragment.newInstance();
                getFragmentManager().beginTransaction().replace(R.id.main_layout_tab1, this.mWashMainFragment).commit();
            }
            this.mMainSwitcher.setDisplayedChild(0);
            this.isAutoBrightness = BrightnessUtils.isAutoBrightness(getActivity().getContentResolver());
            this.mBrightness = BrightnessUtils.getScreenBrightness(getActivity());
            BrightnessUtils.stopAutoBrightness(getActivity());
            BrightnessUtils.setBrightness(getActivity(), 0.8f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showMeFragment() {
        if (this.mMainSwitcher.getDisplayedChild() != 1 || this.mWashMeFragment == null) {
            if (this.mWashMeFragment == null) {
                ((FrameLayout) findViewById(R.id.main_layout_tab2)).removeAllViews();
                this.mWashMeFragment = MealMeFragment.newInstance();
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
        BrightnessUtils.setBrightness(getActivity(), this.mBrightness);
        if (this.isAutoBrightness) {
            BrightnessUtils.startAutoBrightness(getActivity());
        } else {
            BrightnessUtils.stopAutoBrightness(getActivity());
        }
        this.mWashMainFragment = null;
        this.mMainLayoutTab1.removeAllViews();
        this.mMainLayoutTab2.removeAllViews();
    }
}
