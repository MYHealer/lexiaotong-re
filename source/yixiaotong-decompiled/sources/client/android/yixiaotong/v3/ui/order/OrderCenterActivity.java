package client.android.yixiaotong.v3.ui.order;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import com.stub.StubApp;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class OrderCenterActivity extends BaseActivity {
    private RelativeLayout mRelDepositRechargeRefund;
    private RelativeLayout mRelNone;
    private RelativeLayout mRelRechargeRefund;
    private TitleBar mTitleBar;
    private View mView1;
    private View mView2;

    static {
        StubApp.interface11(10053);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) OrderCenterActivity.class));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mRelRechargeRefund = (RelativeLayout) findViewById(R.id.rel_rechargerefundorder);
        this.mRelDepositRechargeRefund = (RelativeLayout) findViewById(R.id.rel_depositrechargerefundorder);
        this.mRelNone = (RelativeLayout) findViewById(R.id.rel_none);
        this.mView1 = findViewById(R.id.view1);
        this.mView2 = findViewById(R.id.view2);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.myorder));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002e  */
    private void initView() {
        char c;
        List<Integer> planFlagList = InvestorInfoUtilControl.getInstance().getPlanFlagList();
        if (planFlagList == null || planFlagList.size() <= 0) {
            c = 0;
        } else {
            c = 0;
            for (int i = 0; i < planFlagList.size(); i++) {
                if (planFlagList.get(i).intValue() == 1) {
                    if (c == 0) {
                        c = 1;
                    } else if (c == 2) {
                        c = 3;
                    }
                } else if (planFlagList.get(i).intValue() == 2) {
                    if (c == 0) {
                        c = 2;
                    } else if (c == 1) {
                        c = 3;
                    }
                }
            }
        }
        if (c == 1) {
            this.mRelRechargeRefund.setVisibility(0);
            this.mView1.setVisibility(0);
            this.mRelNone.setVisibility(4);
        } else if (c == 2) {
            this.mRelDepositRechargeRefund.setVisibility(0);
            this.mView2.setVisibility(0);
            this.mRelNone.setVisibility(4);
        } else if (c == 3) {
            this.mRelRechargeRefund.setVisibility(0);
            this.mView1.setVisibility(0);
            this.mRelDepositRechargeRefund.setVisibility(0);
        }
    }

    private void initClickListeners() {
        findViewById(R.id.rel_deviceorder).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.order.OrderCenterActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m387xb8787fcc(view);
            }
        });
        findViewById(R.id.rel_clubcardorder).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.order.OrderCenterActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m388xc92e4c8d(view);
            }
        });
        findViewById(R.id.rel_rechargerefundorder).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.order.OrderCenterActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m389xd9e4194e(view);
            }
        });
        findViewById(R.id.rel_depositrechargerefundorder).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.order.OrderCenterActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m390xea99e60f(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-order-OrderCenterActivity, reason: not valid java name */
    /* synthetic */ void m387xb8787fcc(View view) {
        ConsumeRecordActivity.launch(getActivity(), 0);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-order-OrderCenterActivity, reason: not valid java name */
    /* synthetic */ void m388xc92e4c8d(View view) {
        BuyClubCardRecordActivity.launch(getActivity());
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v3-ui-order-OrderCenterActivity, reason: not valid java name */
    /* synthetic */ void m389xd9e4194e(View view) {
        RechargeRefundRecordActivity.launch(getActivity());
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$3$client-android-yixiaotong-v3-ui-order-OrderCenterActivity, reason: not valid java name */
    /* synthetic */ void m390xea99e60f(View view) {
        DepositRechargeRefundRecordActivity.launch(getActivity());
    }
}
