package client.android.yixiaotong.v3.ui.appcontrol.prepayment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.db.LocalSqliteHelper;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.v3.bean.login.TypeInfoBean;
import client.android.yixiaotong.v3.bean.prepayment.PrepaymentDeviceInfoBean;
import client.android.yixiaotong.v3.bean.prepayment.PrepaymentWalletBean;
import client.android.yixiaotong.v3.util.ClickUtil;
import com.alipay.sdk.packet.e;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BalanceDetailActivity extends BaseActivity {
    private static final String TAG = "BalanceDetailActivity";
    private ImageView mImgEye;
    private boolean mIsEyeOpen = true;
    private PrepaymentDeviceInfoBean mPrepaymentDeviceInfoBean;
    private PrepaymentWalletBean mPrepaymentWalletBean;
    private TextView mTvBalance;
    private TextView mTvCashBalance;
    private TextView mTvRedPackageBalance;
    private TypeInfoBean mTypeInfoBean;

    static {
        StubApp.interface11(9397);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, TypeInfoBean typeInfoBean, PrepaymentWalletBean prepaymentWalletBean, PrepaymentDeviceInfoBean prepaymentDeviceInfoBean) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) BalanceDetailActivity.class).putExtra("bean", typeInfoBean).putExtra(LocalSqliteHelper.TABLE_NAME_WALLET, prepaymentWalletBean).putExtra(e.n, prepaymentDeviceInfoBean));
        }
    }

    private void initViewNew() {
        this.mImgEye = (ImageView) findViewById(R.id.img_eye);
        this.mTvBalance = (TextView) findViewById(R.id.tv_balance);
        this.mTvCashBalance = (TextView) findViewById(R.id.tv_cashbalance);
        this.mTvRedPackageBalance = (TextView) findViewById(R.id.tv_redpackage);
    }

    private void initClickListeners() {
        findViewById(R.id.img_back).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.BalanceDetailActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m282xb1b296dc(view);
            }
        });
        findViewById(R.id.img_eye).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.BalanceDetailActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m283xb281155d(view);
            }
        });
        findViewById(R.id.tv_toredpackagedetail).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.BalanceDetailActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m284xb34f93de(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-appcontrol-prepayment-BalanceDetailActivity, reason: not valid java name */
    /* synthetic */ void m282xb1b296dc(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        finish();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-appcontrol-prepayment-BalanceDetailActivity, reason: not valid java name */
    /* synthetic */ void m283xb281155d(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        initView();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v3-ui-appcontrol-prepayment-BalanceDetailActivity, reason: not valid java name */
    /* synthetic */ void m284xb34f93de(View view) {
        PrepaymentRedPackageActivityActivity.launch(getActivity(), this.mPrepaymentDeviceInfoBean);
    }

    private void initView() {
        this.mTvBalance.setText(DecimalUtil.twoDecimal(DecimalUtil.divide(this.mPrepaymentWalletBean.money + "", "100")));
        this.mTvCashBalance.setText(DecimalUtil.twoDecimal(DecimalUtil.divide(this.mPrepaymentWalletBean.cashRedPackage + "", "100")));
        this.mTvRedPackageBalance.setText(DecimalUtil.twoDecimal(DecimalUtil.divide(this.mPrepaymentWalletBean.redPackage + "", "100")));
        if (this.mIsEyeOpen) {
            this.mIsEyeOpen = false;
            this.mImgEye.setImageResource(R.mipmap.eye_close_black);
            StringBuilder sb = new StringBuilder();
            if (StringUtils.isNotEmpty(this.mTvBalance.getText().toString())) {
                for (int i = 0; i < this.mTvBalance.getText().toString().length(); i++) {
                    sb.append("*");
                }
            }
            this.mTvBalance.setText(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            if (StringUtils.isNotEmpty(this.mTvCashBalance.getText().toString())) {
                for (int i2 = 0; i2 < this.mTvCashBalance.getText().toString().length(); i2++) {
                    sb2.append("*");
                }
            }
            this.mTvCashBalance.setText(sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            if (StringUtils.isNotEmpty(this.mTvRedPackageBalance.getText().toString())) {
                for (int i3 = 0; i3 < this.mTvRedPackageBalance.getText().toString().length(); i3++) {
                    sb3.append("*");
                }
            }
            this.mTvRedPackageBalance.setText(sb3.toString());
            return;
        }
        this.mIsEyeOpen = true;
        this.mImgEye.setImageResource(R.mipmap.eye_open_black);
    }
}
