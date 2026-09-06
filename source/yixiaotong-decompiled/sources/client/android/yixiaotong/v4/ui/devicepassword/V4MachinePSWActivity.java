package client.android.yixiaotong.v4.ui.devicepassword;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.store.ClientDataManager;
import client.android.yixiaotong.ui.orderhamam.SetPswSuccessActivity;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.v3.ui.adv.AdvControlUtil;
import client.android.yixiaotong.v3.ui.adv.Common;
import client.android.yixiaotong.v3.ui.adv.NativeUtil;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.util.homeinfo.V4HomeInfoUtil;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4MachinePSWActivity extends BaseActivity {
    private static final int PSWFIXEDLENGTH = 6;
    private static final String TAG = "V4MachinePSWActivity";
    RelativeLayout flContainer;
    private AdvControlUtil.AdvListener mAdvListener;
    private boolean mIsEnable;
    private boolean mIsOpenPsw = false;
    private boolean mIsShowAdv = false;
    ImageView mIvOpenClose;
    private NativeUtil mNativeUtil;
    private String mPsw;
    TitleBar mTitleBar;
    TextView mTvAdvName;
    TextView mTvLeftPsw;
    TextView mTvPswCombinationWay;
    TextView mTvRightPsw;

    static {
        StubApp.interface11(10905);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, String str) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4MachinePSWActivity.class).putExtra(SetPswSuccessActivity.EXTRA_PSW, str));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mIvOpenClose = (ImageView) findViewById(R.id.iv_openclose);
        this.mTvPswCombinationWay = (TextView) findViewById(R.id.tv_psw_combination_way);
        this.mTvLeftPsw = (TextView) findViewById(R.id.tv_leftpsw);
        this.mTvRightPsw = (TextView) findViewById(R.id.tv_rightpsw);
        this.flContainer = (RelativeLayout) findViewById(R.id.flContainer);
        this.mTvAdvName = (TextView) findViewById(R.id.tv_advname);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.equipmentpass));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
        findViewById(R.id.iv_openclose).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.devicepassword.V4MachinePSWActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m520xe3aed4b2(view);
            }
        });
        findViewById(R.id.tv_reset).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.devicepassword.V4MachinePSWActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m521xd5006433(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initTitleBar$0$client-android-yixiaotong-v4-ui-devicepassword-V4MachinePSWActivity, reason: not valid java name */
    /* synthetic */ void m520xe3aed4b2(View view) {
        if (this.mIsOpenPsw) {
            this.mIsOpenPsw = false;
        } else {
            this.mIsOpenPsw = true;
        }
        initView();
    }

    /* JADX INFO: renamed from: lambda$initTitleBar$1$client-android-yixiaotong-v4-ui-devicepassword-V4MachinePSWActivity, reason: not valid java name */
    /* synthetic */ void m521xd5006433(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        V4ResetDevicePswActivity.launch(getActivity(), 1, this.mPsw);
        finish();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        getAdv();
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onResume();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onPause();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onDestroy();
        }
        super.onDestroy();
    }

    private void initView() {
        this.mTvPswCombinationWay.setText(String.format(getString(R.string.psw_combination_way_tip), 4));
        String string = ClientDataManager.getInstance().getString(ClientDataManager.LOGIN_ACCOUNT);
        this.mTvLeftPsw.setText(string.substring(string.length() - 4));
        if (this.mIsOpenPsw) {
            this.mIvOpenClose.setImageResource(R.mipmap.xianshi);
            this.mTvRightPsw.setText(this.mPsw);
        } else {
            this.mIvOpenClose.setImageResource(R.mipmap.yincang);
            this.mTvRightPsw.setText("******");
        }
    }

    private void initAdv() {
        this.mNativeUtil = new NativeUtil();
    }

    private void getAdv() {
        if (this.mIsShowAdv) {
            return;
        }
        this.mAdvListener = new AdvControlUtil.AdvListener() { // from class: client.android.yixiaotong.v4.ui.devicepassword.V4MachinePSWActivity.1
            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void isOpen(int i, int i2, int i3, int i4, int i5) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdClosed(Common.AdvType advType) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onRenderSuccess(View view, int i) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdShow(String str, Common.AdvType advType) {
                V4MachinePSWActivity.this.mIsShowAdv = true;
            }
        };
        boolean zIsOpenAdv = V4HomeInfoUtil.getInstance().isOpenAdv();
        LogUtil.e(TAG, "广告是否开启：" + zIsOpenAdv);
        if (zIsOpenAdv) {
            this.mNativeUtil.initNative(getActivity(), this.mAdvListener, 1);
            this.mNativeUtil.onNative(this.flContainer);
        }
    }
}
