package client.android.yixiaotong.v3.ui.appcontrol.electricitymeter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.v3.bean.elecmeter.ElecRechargeRecordBean;
import client.android.yixiaotong.v3.bean.pay.RechargeRecordInfoBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.adapter.RechargeRecordAdapter;
import client.android.yixiaotong.v3.ui.error.ErrorControlUtil;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ElecMeterRechargeRecordActivity extends BaseActivity {
    private static final String TAG = "ElecMeterRechargeRecordActivity";
    private String mDeviceNo;
    private ListView mLvRecord;
    private PullRefreshLayout mPullRefreshLayout;
    private RechargeRecordAdapter mRechargeRecordAdapter;
    private TitleBar mTitleBar;
    private TextView mTvNoData;
    private boolean mIsEnable = true;
    private List<RechargeRecordInfoBean> mRechargeRecordInfoBeans = new ArrayList();
    private int mSelectIndex = 0;
    private List<ElecRechargeRecordBean> mElecRechargeRecordBeans = new ArrayList();

    static {
        StubApp.interface11(9347);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, String str) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) ElecMeterRechargeRecordActivity.class).putExtra(AmmeterWalletDetailActivity.EXTRA_DEVICENO, str));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titlebar);
        this.mPullRefreshLayout = (PullRefreshLayout) findViewById(R.id.pullrefreshlayout);
        this.mLvRecord = (ListView) findViewById(R.id.lv_record);
        this.mTvNoData = (TextView) findViewById(R.id.tv_nodata);
    }

    private void initTitleBar() {
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setTitleView(getString(R.string.rechargerecord));
    }

    private void initView() {
        this.mPullRefreshLayout.setRefreshing(false);
        this.mPullRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.ElecMeterRechargeRecordActivity.1
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                ElecMeterRechargeRecordActivity.this.getRecord();
            }
        });
        RechargeRecordAdapter rechargeRecordAdapter = new RechargeRecordAdapter(getActivity(), new RechargeRecordAdapter.OnItemClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.ElecMeterRechargeRecordActivity.2
            @Override // client.android.yixiaotong.v3.ui.adapter.RechargeRecordAdapter.OnItemClickListener
            public void onItemClick(int i) {
                if (i < ElecMeterRechargeRecordActivity.this.mRechargeRecordInfoBeans.size()) {
                    ElecMeterRechargeRecordActivity.this.mSelectIndex = i;
                    ElecMeterRecordDetailActivity.launch(ElecMeterRechargeRecordActivity.this.getActivity(), (ElecRechargeRecordBean) ElecMeterRechargeRecordActivity.this.mElecRechargeRecordBeans.get(ElecMeterRechargeRecordActivity.this.mSelectIndex));
                }
            }
        });
        this.mRechargeRecordAdapter = rechargeRecordAdapter;
        this.mLvRecord.setAdapter((ListAdapter) rechargeRecordAdapter);
        this.mLvRecord.setOnItemClickListener(this.mRechargeRecordAdapter);
        this.mRechargeRecordAdapter.setData(this.mRechargeRecordInfoBeans);
        this.mRechargeRecordAdapter.notifyDataSetChanged();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        ErrorControlUtil.getInstance().onResume();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        ErrorControlUtil.getInstance().onPause();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getRecord() {
        V3BusinessControllers.getInstance().elecMeterRechargeRecord(getLoginAccount(), UserInfoUtilControl.getInstance().getSchoolId(), UserInfoUtilControl.getInstance().getStudentId(), this.mDeviceNo, 1, new Listener<List<ElecRechargeRecordBean>>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.ElecMeterRechargeRecordActivity.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                ElecMeterRechargeRecordActivity.this.mTvNoData.setVisibility(8);
                ElecMeterRechargeRecordActivity.this.mPullRefreshLayout.setRefreshing(true);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<ElecRechargeRecordBean> list, Object... objArr) {
                super.onComplete(controller, list, objArr);
                if (ElecMeterRechargeRecordActivity.this.mIsEnable) {
                    ElecMeterRechargeRecordActivity.this.mPullRefreshLayout.setRefreshing(false);
                    LogUtil.e(ElecMeterRechargeRecordActivity.TAG, "getMetersTrend:" + list.size());
                    ElecMeterRechargeRecordActivity.this.mElecRechargeRecordBeans.clear();
                    ElecMeterRechargeRecordActivity.this.mElecRechargeRecordBeans = list;
                    if (ElecMeterRechargeRecordActivity.this.mElecRechargeRecordBeans.size() == 0) {
                        ElecMeterRechargeRecordActivity.this.mTvNoData.setVisibility(0);
                    }
                    ElecMeterRechargeRecordActivity.this.initData(list);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (ElecMeterRechargeRecordActivity.this.mIsEnable) {
                    ElecMeterRechargeRecordActivity.this.mPullRefreshLayout.setRefreshing(false);
                    ErrorControlUtil.getInstance().onError(ElecMeterRechargeRecordActivity.this.getLoginAccount(), clientException, ElecMeterRechargeRecordActivity.this.getActivity(), true, ElecMeterRechargeRecordActivity.this.mTitleBar.getTitleViewContent());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData(List<ElecRechargeRecordBean> list) {
        this.mRechargeRecordInfoBeans.clear();
        for (ElecRechargeRecordBean elecRechargeRecordBean : list) {
            RechargeRecordInfoBean rechargeRecordInfoBean = new RechargeRecordInfoBean();
            rechargeRecordInfoBean.time = elecRechargeRecordBean.paySuccessDatetime;
            rechargeRecordInfoBean.money = DecimalUtil.divide(elecRechargeRecordBean.price + "", "100");
            rechargeRecordInfoBean.title = getResources().getString(R.string.elecmeterrecharge);
            rechargeRecordInfoBean.state = elecRechargeRecordBean.appendStatus;
            LogUtil.e(TAG, "initData:" + elecRechargeRecordBean.paySuccessDatetime + PPSLabelView.Code + DecimalUtil.divide(elecRechargeRecordBean.price + "", "100") + PPSLabelView.Code);
            this.mRechargeRecordInfoBeans.add(rechargeRecordInfoBean);
        }
        this.mRechargeRecordAdapter.setData(this.mRechargeRecordInfoBeans);
        this.mRechargeRecordAdapter.notifyDataSetChanged();
    }
}
