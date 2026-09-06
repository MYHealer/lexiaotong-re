package client.android.yixiaotong.v3.ui.appcontrol.electricitymeter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.v3.bean.elecmeter.BindElecMeterInfoBean;
import client.android.yixiaotong.v3.bean.elecmeter.ElecMeterBlanceInfoBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.error.ErrorControlUtil;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ElecMeterControlActivity extends BaseActivity {
    private static final String TAG = "ElecMeterControlActivity";
    private BindElecMeterInfoBean mBindElecMeterInfoBean;
    private String mInvestorId;
    private boolean mIsEnable;
    private boolean mIsError = false;
    private PullRefreshLayout mPullRefreshLayout;
    private String mSchoolId;
    private String mStudentId;
    private TitleBar mTitleBar;
    private TextView mTvAddress;
    private TextView mTvBalance;
    private TextView mTvTime;

    static {
        StubApp.interface11(9334);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, BindElecMeterInfoBean bindElecMeterInfoBean) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) ElecMeterControlActivity.class).putExtra("bean", bindElecMeterInfoBean));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titlebar);
        this.mPullRefreshLayout = (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        this.mTvAddress = (TextView) findViewById(R.id.tv_address);
        this.mTvTime = (TextView) findViewById(R.id.tv_time);
        this.mTvBalance = (TextView) findViewById(R.id.tv_balance);
    }

    private void initTitleBar() {
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setTitleView(getString(R.string.elecmeter));
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        this.mPullRefreshLayout.setRefreshing(false);
        this.mPullRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.ElecMeterControlActivity.1
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                ElecMeterControlActivity.this.mPullRefreshLayout.setRefreshing(true);
                ElecMeterControlActivity.this.getBalanceInfo();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initBalanceView(ElecMeterBlanceInfoBean elecMeterBlanceInfoBean) {
        this.mTvBalance.setText(DecimalUtil.divide(elecMeterBlanceInfoBean.machineBalance + "", "100"));
        this.mTvAddress.setText(elecMeterBlanceInfoBean.roomAddress);
        if (StringUtils.isNotEmpty(elecMeterBlanceInfoBean.balanceUpdateTime)) {
            this.mTvTime.setText(elecMeterBlanceInfoBean.balanceUpdateTime);
        }
    }

    private void initClickListeners() {
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.ElecMeterControlActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m271x649ab8f3(view);
            }
        };
        findViewById(R.id.iv_home).setOnClickListener(onClickListener);
        findViewById(R.id.tv_address).setOnClickListener(onClickListener);
        findViewById(R.id.iv_next).setOnClickListener(onClickListener);
        findViewById(R.id.rel_recharge).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.ElecMeterControlActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m272xaa3bfb92(view);
            }
        });
        findViewById(R.id.rel_rechargerecord).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.ElecMeterControlActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m273xefdd3e31(view);
            }
        });
        findViewById(R.id.rel_analysis).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.ElecMeterControlActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m274x357e80d0(view);
            }
        });
        findViewById(R.id.rel_changeroom).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.ElecMeterControlActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m275x7b1fc36f(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-appcontrol-electricitymeter-ElecMeterControlActivity, reason: not valid java name */
    /* synthetic */ void m271x649ab8f3(View view) {
        RoomDetailActivity.launch(getActivity(), this.mBindElecMeterInfoBean);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-appcontrol-electricitymeter-ElecMeterControlActivity, reason: not valid java name */
    /* synthetic */ void m272xaa3bfb92(View view) {
        ElecMeterRechargeActivity.launch(getActivity(), this.mBindElecMeterInfoBean);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v3-ui-appcontrol-electricitymeter-ElecMeterControlActivity, reason: not valid java name */
    /* synthetic */ void m273xefdd3e31(View view) {
        if (this.mBindElecMeterInfoBean != null) {
            ElecMeterRechargeRecordActivity.launch(getActivity(), this.mBindElecMeterInfoBean.factoryNo);
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$3$client-android-yixiaotong-v3-ui-appcontrol-electricitymeter-ElecMeterControlActivity, reason: not valid java name */
    /* synthetic */ void m274x357e80d0(View view) {
        if (this.mBindElecMeterInfoBean != null) {
            ElecMeterAnalysisActivity.launch(getActivity(), this.mBindElecMeterInfoBean.factoryNo);
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$4$client-android-yixiaotong-v3-ui-appcontrol-electricitymeter-ElecMeterControlActivity, reason: not valid java name */
    /* synthetic */ void m275x7b1fc36f(View view) {
        BindRoomActivity.launch(getActivity(), 1);
        finish();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        ErrorControlUtil.getInstance().onResume();
        if (this.mIsError) {
            return;
        }
        getBalanceInfo();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        ErrorControlUtil.getInstance().onPause();
        this.mPullRefreshLayout.setRefreshing(false);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getBalanceInfo() {
        this.mSchoolId = UserInfoUtilControl.getInstance().getSchoolId();
        this.mInvestorId = InvestorInfoUtilControl.getInstance().getInvestorId();
        this.mStudentId = UserInfoUtilControl.getInstance().getStudentId();
        V3BusinessControllers.getInstance().getDeviceBalanceElecMeter(getLoginAccount(), this.mSchoolId, this.mInvestorId, this.mStudentId, 1, new Listener<ElecMeterBlanceInfoBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.ElecMeterControlActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, ElecMeterBlanceInfoBean elecMeterBlanceInfoBean, Object... objArr) {
                super.onComplete(controller, elecMeterBlanceInfoBean, objArr);
                if (ElecMeterControlActivity.this.mIsEnable) {
                    ElecMeterControlActivity.this.mPullRefreshLayout.setRefreshing(false);
                    ElecMeterControlActivity.this.initBalanceView(elecMeterBlanceInfoBean);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (ElecMeterControlActivity.this.mIsEnable) {
                    ElecMeterControlActivity.this.mPullRefreshLayout.setRefreshing(false);
                    ElecMeterControlActivity.this.mIsError = true;
                    ErrorControlUtil.getInstance().onError(ElecMeterControlActivity.this.getLoginAccount(), clientException, ElecMeterControlActivity.this.getActivity(), false, ElecMeterControlActivity.this.mTitleBar.getTitleViewContent());
                }
            }
        });
    }
}
