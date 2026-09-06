package client.android.yixiaotong.v4.ui.wallet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.ui.dialog.RefundDialog;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4RefundActivity extends BaseActivity {
    private static final String TAG = "V4RefundActivity";
    private ImageView mImgAli;
    private ImageView mImgWechat;
    private RelativeLayout mRelAli;
    private RelativeLayout mRelWeChat;
    private String mTotalMoney;
    private TitleBar mVTitleBar;
    private boolean mIsEnable = true;
    private List<Integer> mPayFlagTypeList = new ArrayList();
    private int mIndexPayFlag = -1;

    static {
        StubApp.interface11(11113);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, String str) {
        Intent intent = new Intent(activity, (Class<?>) V4RefundActivity.class);
        intent.putExtra("totalmoney", str);
        activity.startActivity(intent);
    }

    private void initViewNew() {
        this.mVTitleBar = (TitleBar) findViewById(R.id.v_titleBar);
        this.mImgWechat = (ImageView) findViewById(R.id.img_select_weixin);
        this.mImgAli = (ImageView) findViewById(R.id.img_select_ali);
        this.mRelAli = (RelativeLayout) findViewById(R.id.rel_alipay);
        this.mRelWeChat = (RelativeLayout) findViewById(R.id.rel_wechat);
    }

    private void initTitleBar() {
        this.mVTitleBar.setTitleView(getString(R.string.applyrefund));
        this.mVTitleBar.setLeftView(R.mipmap.back);
        this.mVTitleBar.setLeftViewOnClickBack(getActivity());
        this.mVTitleBar.setRightView(getString(R.string.refundrule));
        this.mVTitleBar.setRightViewTextColor(getResources().getColor(R.color.ff222222));
        this.mVTitleBar.setRightViewOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.wallet.V4RefundActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RefundDialog.getInstance().showTipTimeOutDialog(V4RefundActivity.this.getActivity());
            }
        });
    }

    private void initView() {
        this.mPayFlagTypeList.add(1);
        for (int i = 0; i < this.mPayFlagTypeList.size(); i++) {
            if (this.mPayFlagTypeList.get(i).intValue() == 1 || this.mPayFlagTypeList.get(i).intValue() == -1) {
                this.mRelWeChat.setVisibility(0);
                this.mIndexPayFlag = 1;
            }
            if (this.mPayFlagTypeList.get(i).intValue() == 2 || this.mPayFlagTypeList.get(i).intValue() == -2) {
                this.mRelAli.setVisibility(0);
                if (this.mIndexPayFlag != 1) {
                    this.mIndexPayFlag = 2;
                }
            }
        }
        int i2 = this.mIndexPayFlag;
        if (i2 == 1) {
            this.mImgWechat.setImageResource(R.mipmap.xz1);
            this.mImgAli.setImageResource(R.mipmap.wxz);
        } else if (i2 == 2) {
            this.mImgWechat.setImageResource(R.mipmap.wxz);
            this.mImgAli.setImageResource(R.mipmap.xz1);
        }
    }

    private void toLaunch() {
        LogUtil.e(TAG, "toLaunch:" + this.mIndexPayFlag + PPSLabelView.Code + new BigDecimal(this.mTotalMoney).doubleValue());
        int i = this.mIndexPayFlag;
        if (i != -1) {
            toLaunchActivity(i);
        } else {
            ToastUtils.show(getContext(), "请选择到账账户");
        }
    }

    private void toLaunchActivity(int i) {
        V4SubmitRefundActivity.launch(getActivity(), i, this.mTotalMoney);
        finish();
    }

    private void initClickListeners() {
        findViewById(R.id.rel_alipay).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.wallet.V4RefundActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m561x16df8151(view);
            }
        });
        findViewById(R.id.rel_wechat).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.wallet.V4RefundActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m562x3c738a52(view);
            }
        });
        findViewById(R.id.btn_refund).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.wallet.V4RefundActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m563x62079353(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v4-ui-wallet-V4RefundActivity, reason: not valid java name */
    /* synthetic */ void m561x16df8151(View view) {
        this.mIndexPayFlag = 2;
        this.mImgWechat.setImageResource(R.mipmap.wxz);
        this.mImgAli.setImageResource(R.mipmap.xz1);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v4-ui-wallet-V4RefundActivity, reason: not valid java name */
    /* synthetic */ void m562x3c738a52(View view) {
        this.mIndexPayFlag = 1;
        this.mImgAli.setImageResource(R.mipmap.wxz);
        this.mImgWechat.setImageResource(R.mipmap.xz1);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v4-ui-wallet-V4RefundActivity, reason: not valid java name */
    /* synthetic */ void m563x62079353(View view) {
        if (ClickUtil.isFastDoubleClick() || !checkMoney()) {
            return;
        }
        toLaunch();
    }

    private boolean checkMoney() {
        BigDecimal bigDecimal = new BigDecimal(this.mTotalMoney);
        if (bigDecimal.doubleValue() == 0.0d) {
            ToastUtils.show(getContext(), getString(R.string.refundbalance1));
            return false;
        }
        if (bigDecimal.doubleValue() >= 0.0d) {
            return true;
        }
        ToastUtils.show(getContext(), getString(R.string.refundbalance2));
        return false;
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
