package client.android.yixiaotong.ui.drinkwater;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.orderhamam.SetPswSuccessActivity;
import client.android.yixiaotong.ui.widget.TitleBar;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class MachinePSWOldActivity extends BaseActivity {
    private EditText et1;
    private EditText et10;
    private EditText et2;
    private EditText et3;
    private EditText et4;
    private EditText et5;
    private EditText et6;
    private EditText et7;
    private EditText et8;
    private EditText et9;
    private RelativeLayout flContainer;
    private boolean mIsOpenPsw = false;
    private ImageView mIvOpenClose;
    private String mPsw;
    private TitleBar mTitleBar;

    static {
        StubApp.interface11(7126);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, String str) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) MachinePSWOldActivity.class).putExtra(SetPswSuccessActivity.EXTRA_PSW, str));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.et1 = (EditText) findViewById(R.id.et1);
        this.et2 = (EditText) findViewById(R.id.et2);
        this.et3 = (EditText) findViewById(R.id.et3);
        this.et4 = (EditText) findViewById(R.id.et4);
        this.et5 = (EditText) findViewById(R.id.et5);
        this.et6 = (EditText) findViewById(R.id.et6);
        this.et7 = (EditText) findViewById(R.id.et7);
        this.et8 = (EditText) findViewById(R.id.et8);
        this.et9 = (EditText) findViewById(R.id.et9);
        this.et10 = (EditText) findViewById(R.id.et10);
        this.mIvOpenClose = (ImageView) findViewById(R.id.iv_openclose);
        this.flContainer = (RelativeLayout) findViewById(R.id.flContainer);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.equipmentpass));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initClickListeners() {
        findViewById(R.id.iv_openclose).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.drinkwater.MachinePSWOldActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m125x945dd256(view);
            }
        });
        findViewById(R.id.lin_reset).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.drinkwater.MachinePSWOldActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m126x87ed5697(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-ui-drinkwater-MachinePSWOldActivity, reason: not valid java name */
    /* synthetic */ void m125x945dd256(View view) {
        if (this.mIsOpenPsw) {
            this.mIsOpenPsw = false;
        } else {
            this.mIsOpenPsw = true;
        }
        initView();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-ui-drinkwater-MachinePSWOldActivity, reason: not valid java name */
    /* synthetic */ void m126x87ed5697(View view) {
        ResetDevicePswOldActivity.launch(getActivity(), 1, this.mPsw);
        finish();
    }

    private void initView() {
        if (this.mIsOpenPsw) {
            this.mIvOpenClose.setImageResource(R.mipmap.xianshi);
            this.et1.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            this.et2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            this.et3.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            this.et4.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            this.et5.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            this.et6.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            this.et7.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            this.et8.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            this.et9.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            this.et10.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            this.et1.setText(this.mPsw.substring(0, 1));
            this.et2.setText(this.mPsw.substring(1, 2));
            this.et3.setText(this.mPsw.substring(2, 3));
            this.et4.setText(this.mPsw.substring(3, 4));
            this.et5.setText(this.mPsw.substring(4, 5));
            this.et6.setText(this.mPsw.substring(5, 6));
            this.et7.setText(this.mPsw.substring(6, 7));
            this.et8.setText(this.mPsw.substring(7, 8));
            this.et9.setText(this.mPsw.substring(8, 9));
            this.et10.setText(this.mPsw.substring(9, 10));
            return;
        }
        this.mIvOpenClose.setImageResource(R.mipmap.yincang);
        this.et1.setText(this.mPsw.substring(0, 1));
        this.et2.setText(this.mPsw.substring(1, 2));
        this.et3.setText(this.mPsw.substring(2, 3));
        this.et4.setText(this.mPsw.substring(3, 4));
        this.et5.setText(this.mPsw.substring(4, 5));
        this.et6.setText(this.mPsw.substring(5, 6));
        this.et7.setText(this.mPsw.substring(6, 7));
        this.et8.setText(this.mPsw.substring(7, 8));
        this.et9.setText(this.mPsw.substring(8, 9));
        this.et10.setText(this.mPsw.substring(9, 10));
        this.et1.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.et2.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.et3.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.et4.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.et5.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.et6.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.et7.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.et8.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.et9.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.et10.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }
}
