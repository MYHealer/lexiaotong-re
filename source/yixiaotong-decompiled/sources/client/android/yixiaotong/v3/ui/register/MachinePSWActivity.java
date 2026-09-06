package client.android.yixiaotong.v3.ui.register;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.error.ErrorUtil;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.orderhamam.SetPswSuccessActivity;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.v3.bean.deviceinfo.DevicePswRuleBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.adv.AdvControlUtil;
import client.android.yixiaotong.v3.ui.adv.Common;
import client.android.yixiaotong.v3.ui.adv.NativeUtil;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class MachinePSWActivity extends BaseActivity {
    private static final int PSWFIXEDLENGTH = 6;
    private RelativeLayout flContainer;
    private AdvControlUtil.AdvListener mAdvListener;
    private boolean mIsEnable;
    private boolean mIsOpenPsw = false;
    private boolean mIsShowAdv = false;
    private ImageView mIvOpenClose;
    private NativeUtil mNativeUtil;
    private String mPsw;
    private TitleBar mTitleBar;
    private TextView mTvAdvName;
    private TextView mTvLeftPsw;
    private TextView mTvPswCombinationWay;
    private TextView mTvRightPsw;

    static {
        StubApp.interface11(10133);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, String str) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) MachinePSWActivity.class).putExtra(SetPswSuccessActivity.EXTRA_PSW, str));
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
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        getAdv();
        AdvControlUtil.getInstance().onResume();
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onResume();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        AdvControlUtil.getInstance().onPause();
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onPause();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        AdvControlUtil.getInstance().onDestroy(getActivity());
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onDestroy();
        }
        super.onDestroy();
    }

    private void initClickListeners() {
        findViewById(R.id.iv_openclose).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.register.MachinePSWActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m403x307f7ff(view);
            }
        });
        findViewById(R.id.tv_reset).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.register.MachinePSWActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m404xbd7d9880(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-register-MachinePSWActivity, reason: not valid java name */
    /* synthetic */ void m403x307f7ff(View view) {
        togglePasswordVisibility();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-register-MachinePSWActivity, reason: not valid java name */
    /* synthetic */ void m404xbd7d9880(View view) {
        launchResetActivity();
    }

    private void togglePasswordVisibility() {
        this.mIsOpenPsw = !this.mIsOpenPsw;
        initView();
    }

    private void launchResetActivity() {
        ResetDevicePswActivity.launch(getActivity(), 1, this.mPsw);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initView() {
        this.mTvPswCombinationWay.setText(String.format(getString(R.string.psw_combination_way_tip), Integer.valueOf(this.mPsw.length() - 6)));
        if (this.mPsw.length() - 6 == 0) {
            this.mTvPswCombinationWay.setText(getString(R.string.psw_combination_way_tip2));
        }
        TextView textView = this.mTvLeftPsw;
        String str = this.mPsw;
        textView.setText(str.substring(0, str.length() - 6));
        if (this.mIsOpenPsw) {
            this.mIvOpenClose.setImageResource(R.mipmap.xianshi);
            TextView textView2 = this.mTvRightPsw;
            String str2 = this.mPsw;
            textView2.setText(str2.substring(str2.length() - 6));
            return;
        }
        this.mIvOpenClose.setImageResource(R.mipmap.yincang);
        this.mTvRightPsw.setText("******");
    }

    private void getPswRule() {
        V3BusinessControllers.getInstance().getDevicePswRule(getLoginAccount(), UserInfoUtilControl.getInstance().getSchoolId(), new Listener<DevicePswRuleBean>() { // from class: client.android.yixiaotong.v3.ui.register.MachinePSWActivity.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                BaseMaterialDialog.showMaterialDialog(MachinePSWActivity.this.getActivity(), "正在加载中", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, DevicePswRuleBean devicePswRuleBean, Object... objArr) {
                super.onComplete(controller, devicePswRuleBean, objArr);
                if (MachinePSWActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (devicePswRuleBean.prefixNum + 6 == MachinePSWActivity.this.mPsw.length()) {
                        MachinePSWActivity.this.initView();
                    } else {
                        ResetDevicePswActivity.launch(MachinePSWActivity.this.getActivity(), 0, devicePswRuleBean.prefixNum + 6);
                        MachinePSWActivity.this.finish();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (MachinePSWActivity.this.mIsEnable) {
                    ErrorUtil.onFailResult(MachinePSWActivity.this.getActivity(), MachinePSWActivity.this.mTitleBar.getTitleViewContent(), clientException, true);
                }
            }
        });
    }

    private void getAdv() {
        if (this.mIsShowAdv) {
            return;
        }
        this.mNativeUtil = new NativeUtil();
        this.mAdvListener = new AdvControlUtil.AdvListener() { // from class: client.android.yixiaotong.v3.ui.register.MachinePSWActivity.2
            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdClosed(Common.AdvType advType) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onRenderSuccess(View view, int i) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void isOpen(int i, int i2, int i3, int i4, int i5) {
                if (i5 == 1) {
                    MachinePSWActivity.this.mNativeUtil.initNative(MachinePSWActivity.this.getActivity(), MachinePSWActivity.this.mAdvListener, 1);
                    MachinePSWActivity.this.mNativeUtil.onNative(MachinePSWActivity.this.flContainer);
                }
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdShow(String str, Common.AdvType advType) {
                MachinePSWActivity.this.mIsShowAdv = true;
            }
        };
        AdvControlUtil.getInstance().init(getActivity(), this.mAdvListener, 1, true, "");
        AdvControlUtil.getInstance().initAdvInfo();
    }
}
