package client.android.yixiaotong.v4.ui.app.electricitymeter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.v3.ui.adv.AdvControlUtil;
import client.android.yixiaotong.v3.ui.adv.Common;
import client.android.yixiaotong.v3.ui.adv.NativeUtil;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.http.bean.V4ElecMeterInfoBean;
import client.android.yixiaotong.v4.ui.app.air.V4AirControlActivity;
import client.android.yixiaotong.v4.ui.app.electricitymeter.refund.V4SetSupervisorActivity;
import client.android.yixiaotong.v4.ui.app.electricitymeter.refund.V4SupervisorInfoActivity;
import client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil;
import client.android.yixiaotong.v4.util.homeinfo.V4HomeInfoUtil;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4ElecMeterControlActivity extends BaseActivity {
    private static final int CLICK_ADDRESS;
    private static final int CLICK_ANALYSIS;
    private static final int CLICK_BALANCE;
    private static final int CLICK_CHANGE_ROOM;
    private static final int CLICK_HOME;
    private static final int CLICK_NEXT;
    private static final int CLICK_RECHARGE;
    private static final int CLICK_RECHARGE_RECORD;
    private static final String TAG = "V4ElecMeterControlActivity";
    RelativeLayout flContainer;
    private AdvControlUtil.AdvListener mAdvListener;
    private V4ElecMeterInfoBean mBindElecMeterInfoBean;
    private boolean mIsEnable;
    private boolean mIsNeedLoadWallet = false;
    private boolean mIsShowAdv = false;
    private NativeUtil mNativeUtil;
    private int mProductId;
    PullRefreshLayout mPullRefreshLayout;
    RelativeLayout mReHouseMaster;
    RelativeLayout mRelAirControl;
    TitleBar mTitleBar;
    TextView mTvAddress;
    TextView mTvAnalysis;
    TextView mTvBalance;
    TextView mTvBalanceText;
    TextView mTvHouseName;
    TextView mTvRechargeText;
    TextView mTvRefunding;
    TextView mTvTime;
    TextView mTvTipText;

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titlebar);
        this.mPullRefreshLayout = (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        this.mTvAddress = (TextView) findViewById(R.id.tv_address);
        this.mTvTime = (TextView) findViewById(R.id.tv_time);
        this.mTvBalance = (TextView) findViewById(R.id.tv_balance);
        this.mTvRefunding = (TextView) findViewById(R.id.tv_refunding);
        this.mTvBalanceText = (TextView) findViewById(R.id.tv_balabcetext);
        this.mTvRechargeText = (TextView) findViewById(R.id.tv_rechargetext);
        this.mTvAnalysis = (TextView) findViewById(R.id.tv_analysis);
        this.mTvTipText = (TextView) findViewById(R.id.tv_tiptext);
        this.mRelAirControl = (RelativeLayout) findViewById(R.id.rel_aircontrol);
        this.flContainer = (RelativeLayout) findViewById(R.id.flContainer);
    }

    public static void launch(Activity activity, V4ElecMeterInfoBean v4ElecMeterInfoBean, int i) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4ElecMeterControlActivity.class).putExtra("bean", v4ElecMeterInfoBean).putExtra("productid", i));
        }
    }

    private void initTitleBar() {
        this.mTitleBar.setLeftView(R.mipmap.back);
        int i = this.mProductId;
        if (i == 12) {
            this.mTitleBar.setTitleView(getString(R.string.elecmeter));
        } else if (i == 6) {
            this.mTitleBar.setTitleView(getString(R.string.prepaidmeter));
        } else if (i == 13) {
            this.mTitleBar.setTitleView(getString(R.string.air));
        }
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        this.mRelAirControl.setVisibility(8);
        this.mReHouseMaster = (RelativeLayout) findViewById(R.id.rel_housemaster);
        this.mTvHouseName = (TextView) findViewById(R.id.tv_name);
        int i = this.mProductId;
        if (i == 12) {
            this.mTvBalanceText.setText(R.string.electmeterremainingkwh);
            this.mTvRechargeText.setText(R.string.elecmeterrecharge);
            this.mTvAnalysis.setText(R.string.elecmeteranalysis);
            this.mTvTipText.setText(R.string.electmetertip1);
        } else if (i == 13) {
            this.mTvBalanceText.setText(getString(R.string.airremainingkwh));
            this.mTvRechargeText.setText(getString(R.string.airconditioningrecharge));
            this.mTvAnalysis.setText(R.string.elecmeteranalysis);
            this.mRelAirControl.setVisibility(0);
            this.mTvTipText.setText(R.string.airtip);
        } else if (i == 6) {
            this.mTvBalanceText.setText(getString(R.string.waterremainingl));
            this.mTvRechargeText.setText(getString(R.string.rechargewatermeter2));
            this.mTvAnalysis.setText(R.string.materanalysis);
            this.mTvTipText.setText(R.string.remotewatertip);
        }
        this.mPullRefreshLayout.setRefreshing(false);
        this.mPullRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterControlActivity.1
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                V4ElecMeterControlActivity.this.mPullRefreshLayout.setRefreshing(true);
                V4ElecMeterControlActivity.this.getElecMeterInfo();
            }
        });
        initBalanceView();
        findViewById(R.id.iv_home).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterControlActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m480xd9b07115(view);
            }
        });
        findViewById(R.id.tv_address).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterControlActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m481xba29c716(view);
            }
        });
        findViewById(R.id.iv_next).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterControlActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m482x9aa31d17(view);
            }
        });
        findViewById(R.id.rel_balance).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterControlActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m483x7b1c7318(view);
            }
        });
        findViewById(R.id.rel_recharge).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterControlActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m484x5b95c919(view);
            }
        });
        findViewById(R.id.rel_rechargerecord).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterControlActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m485x3c0f1f1a(view);
            }
        });
        findViewById(R.id.rel_analysis).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterControlActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m486x1c88751b(view);
            }
        });
        findViewById(R.id.rel_changeroom).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterControlActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m487xfd01cb1c(view);
            }
        });
        this.mRelAirControl.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterControlActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m488xdd7b211d(view);
            }
        });
        this.mReHouseMaster.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterControlActivity$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m489xbdf4771e(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initView$8$client-android-yixiaotong-v4-ui-app-electricitymeter-V4ElecMeterControlActivity, reason: not valid java name */
    /* synthetic */ void m488xdd7b211d(View view) {
        V4AirControlActivity.launch(getActivity(), this.mBindElecMeterInfoBean);
    }

    /* JADX INFO: renamed from: lambda$initView$9$client-android-yixiaotong-v4-ui-app-electricitymeter-V4ElecMeterControlActivity, reason: not valid java name */
    /* synthetic */ void m489xbdf4771e(View view) {
        if (ClickUtil.isFastDoubleClick() || this.mBindElecMeterInfoBean.hasLeader == null) {
            return;
        }
        this.mIsNeedLoadWallet = true;
        if (this.mBindElecMeterInfoBean.hasLeader.booleanValue()) {
            V4SupervisorInfoActivity.launch(getActivity(), this.mBindElecMeterInfoBean, this.mProductId);
        } else {
            V4SetSupervisorActivity.launch(getActivity(), this.mBindElecMeterInfoBean.roomId, this.mProductId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initBalanceView() {
        this.mTvBalance.setText(this.mBindElecMeterInfoBean.roomTotalKwh);
        this.mTvAddress.setText(this.mBindElecMeterInfoBean.address);
        if (StringUtils.isNotEmpty(this.mBindElecMeterInfoBean.updateTime)) {
            this.mTvTime.setText(this.mBindElecMeterInfoBean.updateTime);
        }
        if (this.mBindElecMeterInfoBean.hasLeader != null && this.mBindElecMeterInfoBean.hasLeader.booleanValue() && this.mBindElecMeterInfoBean.leaderInfo != null) {
            this.mTvHouseName.setText(this.mBindElecMeterInfoBean.leaderInfo.name);
        } else {
            this.mTvHouseName.setText("");
        }
        if (this.mBindElecMeterInfoBean.deviceStatus != null && this.mBindElecMeterInfoBean.deviceStatus.intValue() == 1) {
            this.mTvRefunding.setVisibility(0);
        } else {
            this.mTvRefunding.setVisibility(8);
        }
    }

    static {
        StubApp.interface11(10752);
        CLICK_HOME = R.id.iv_home;
        CLICK_ADDRESS = R.id.tv_address;
        CLICK_NEXT = R.id.iv_next;
        CLICK_BALANCE = R.id.rel_balance;
        CLICK_RECHARGE = R.id.rel_recharge;
        CLICK_RECHARGE_RECORD = R.id.rel_rechargerecord;
        CLICK_ANALYSIS = R.id.rel_analysis;
        CLICK_CHANGE_ROOM = R.id.rel_changeroom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onViewClicked, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void m487xfd01cb1c(View view) {
        int id = view.getId();
        if (id == CLICK_HOME || id == CLICK_ADDRESS || id == CLICK_NEXT) {
            if (ClickUtil.isFastDoubleClick()) {
                return;
            }
            V4RoomDetailActivity.launch(getActivity(), this.mBindElecMeterInfoBean, this.mProductId);
            return;
        }
        if (id == CLICK_BALANCE) {
            if (ClickUtil.isFastDoubleClick()) {
                return;
            }
            V4DeviceBalanceDetailActivity.launch(getActivity(), this.mBindElecMeterInfoBean, this.mProductId);
            return;
        }
        if (id == CLICK_RECHARGE) {
            if (ClickUtil.isFastDoubleClick()) {
                return;
            }
            this.mIsNeedLoadWallet = true;
            V4ElecMeterRechargeActivity.launch(getActivity(), this.mBindElecMeterInfoBean, this.mProductId);
            return;
        }
        if (id == CLICK_RECHARGE_RECORD) {
            if (ClickUtil.isFastDoubleClick() || this.mBindElecMeterInfoBean == null) {
                return;
            }
            V4ElecMeterRechargeRecordActivity.launch(getActivity(), this.mBindElecMeterInfoBean.mac, this.mProductId);
            return;
        }
        if (id == CLICK_ANALYSIS) {
            if (this.mBindElecMeterInfoBean != null) {
                V4ElecMeterAnalysisActivity.launch(getActivity(), this.mBindElecMeterInfoBean.mac, this.mProductId);
            }
        } else {
            if (id != CLICK_CHANGE_ROOM || ClickUtil.isFastDoubleClick()) {
                return;
            }
            V4SelecetDeviceActivity.launch(getActivity(), this.mProductId);
            finish();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        V4ErrorControlUtil.getInstance().onResume();
        if (this.mIsNeedLoadWallet) {
            getElecMeterInfo();
        }
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
        V4ErrorControlUtil.getInstance().onPause();
        this.mPullRefreshLayout.setRefreshing(false);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void getElecMeterInfo() {
        this.mIsNeedLoadWallet = false;
        V4BusinessControllers.getInstance().getElecMeterInfo(getLoginAccount(), this.mProductId, new Listener<V4ElecMeterInfoBean>() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterControlActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4ElecMeterInfoBean v4ElecMeterInfoBean, Object... objArr) {
                super.onComplete(controller, v4ElecMeterInfoBean, objArr);
                if (V4ElecMeterControlActivity.this.mIsEnable) {
                    V4ElecMeterControlActivity.this.mPullRefreshLayout.setRefreshing(false);
                    V4ElecMeterControlActivity.this.mBindElecMeterInfoBean = v4ElecMeterInfoBean;
                    V4ElecMeterControlActivity.this.initBalanceView();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (V4ElecMeterControlActivity.this.mIsEnable) {
                    V4ElecMeterControlActivity.this.mPullRefreshLayout.setRefreshing(false);
                    V4ErrorControlUtil.getInstance().showDialog(clientException, V4ElecMeterControlActivity.this.getActivity(), false);
                }
            }
        });
    }

    private void initAdv() {
        this.mNativeUtil = new NativeUtil();
    }

    private void getAdv() {
        if (this.mIsShowAdv) {
            return;
        }
        this.mAdvListener = new AdvControlUtil.AdvListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterControlActivity.3
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
                V4ElecMeterControlActivity.this.mIsShowAdv = true;
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
