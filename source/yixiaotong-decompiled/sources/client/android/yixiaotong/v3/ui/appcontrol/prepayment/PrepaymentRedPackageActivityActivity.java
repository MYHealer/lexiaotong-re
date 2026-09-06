package client.android.yixiaotong.v3.ui.appcontrol.prepayment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.LoadMoreFooter;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.v3.bean.login.InvestorInfoBean;
import client.android.yixiaotong.v3.bean.order.CouponBean;
import client.android.yixiaotong.v3.bean.prepayment.PrepaymentDeviceInfoBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.alipay.sdk.packet.e;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class PrepaymentRedPackageActivityActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private RecordsAdapter mApdater;
    private InvestorInfoBean mInvestorInfoBean;
    private LoadMoreFooter mLoadMoreFootView;
    private ListView mLvRecord;
    private MultiStateView mMultiStateView;
    private PrepaymentDeviceInfoBean mPrepaymentDeviceInfoBean;
    private PullRefreshLayout mSwipeRefreshLayout;
    private TitleBar mTitleBar;
    private TextView mTvOutOfDate;
    private TextView mTvUseText;
    private TextView mTvUsedText;
    private View mVLineUse;
    private View mVLineUsed;
    private View mVOutOfDate;
    private final List<CouponBean> mRecordListBeans = new ArrayList();
    public int mState = 0;
    private boolean mIsEnable = true;

    static {
        StubApp.interface11(9421);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, PrepaymentDeviceInfoBean prepaymentDeviceInfoBean) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) PrepaymentRedPackageActivityActivity.class).putExtra(e.n, prepaymentDeviceInfoBean));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTvUseText = (TextView) findViewById(R.id.tv_usetext);
        this.mVLineUse = findViewById(R.id.v_lineuse);
        this.mTvUsedText = (TextView) findViewById(R.id.tv_usedtext);
        this.mVLineUsed = findViewById(R.id.v_lineused);
        this.mTvOutOfDate = (TextView) findViewById(R.id.tv_outofdate);
        this.mVOutOfDate = findViewById(R.id.v_outofdate);
        this.mLvRecord = (ListView) findViewById(R.id.lv_record);
        this.mSwipeRefreshLayout = (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        this.mMultiStateView = (MultiStateView) findViewById(R.id.multiStateView);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.redpacket));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        RecordsAdapter recordsAdapter = new RecordsAdapter();
        this.mApdater = recordsAdapter;
        this.mLvRecord.setAdapter((ListAdapter) recordsAdapter);
        this.mLvRecord.setOnItemClickListener(this);
        this.mLvRecord.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.PrepaymentRedPackageActivityActivity.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (i == 0) {
                    PrepaymentRedPackageActivityActivity.this.mSwipeRefreshLayout.setEnabled(true);
                } else {
                    PrepaymentRedPackageActivityActivity.this.mSwipeRefreshLayout.setEnabled(false);
                }
            }
        });
    }

    private void initFooterView() {
        LoadMoreFooter loadMoreFooter = new LoadMoreFooter(getContext());
        this.mLoadMoreFootView = loadMoreFooter;
        this.mLvRecord.addFooterView(loadMoreFooter);
    }

    private void initListener() {
        this.mMultiStateView.getView(1).findViewById(R.id.btn_reload).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.PrepaymentRedPackageActivityActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PrepaymentRedPackageActivityActivity.this.mMultiStateView.setViewState(3);
                PrepaymentRedPackageActivityActivity.this.getRecords();
            }
        });
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.PrepaymentRedPackageActivityActivity.3
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                PrepaymentRedPackageActivityActivity.this.mRecordListBeans.clear();
                PrepaymentRedPackageActivityActivity.this.mApdater.notifyDataSetChanged();
                PrepaymentRedPackageActivityActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                PrepaymentRedPackageActivityActivity.this.mLoadMoreFootView.setNoMoreData("");
                PrepaymentRedPackageActivityActivity.this.getRecords();
            }
        });
        this.mLoadMoreFootView.setUseProgressBar(true);
        this.mLoadMoreFootView.setOnClickLoadMoreListener(new LoadMoreFooter.OnClickLoadMoreListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.PrepaymentRedPackageActivityActivity.4
            @Override // client.android.yixiaotong.ui.widget.LoadMoreFooter.OnClickLoadMoreListener
            public void onClick() {
                PrepaymentRedPackageActivityActivity.this.getRecords();
            }
        });
    }

    private void initData() {
        getRecords();
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

    private void initClickListeners() {
        findViewById(R.id.rel_use).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.PrepaymentRedPackageActivityActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m288x9a299d6(view);
            }
        });
        findViewById(R.id.rel_used).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.PrepaymentRedPackageActivityActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m289x8c92935(view);
            }
        });
        findViewById(R.id.rel_outofdate).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.PrepaymentRedPackageActivityActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m290x7efb894(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-appcontrol-prepayment-PrepaymentRedPackageActivityActivity, reason: not valid java name */
    /* synthetic */ void m288x9a299d6(View view) {
        initViewTop(0);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-appcontrol-prepayment-PrepaymentRedPackageActivityActivity, reason: not valid java name */
    /* synthetic */ void m289x8c92935(View view) {
        initViewTop(1);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v3-ui-appcontrol-prepayment-PrepaymentRedPackageActivityActivity, reason: not valid java name */
    /* synthetic */ void m290x7efb894(View view) {
        initViewTop(2);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Log.e("test", "onItemClick:" + i);
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        PrepaymentRedPackageDetailActivityActivity.launch(getActivity(), this.mApdater.getItem(i), this.mState);
    }

    private void initViewTop(int i) {
        if (i == 0) {
            this.mTvUseText.setTextColor(getResources().getColor(R.color.ff242933));
            this.mTvUseText.setTextSize(16.0f);
            this.mVLineUse.setVisibility(0);
            this.mTvUsedText.setTextColor(getResources().getColor(R.color.ffa1a6b3));
            this.mTvUsedText.setTextSize(15.0f);
            this.mVLineUsed.setVisibility(8);
            this.mTvOutOfDate.setTextColor(getResources().getColor(R.color.ffa1a6b3));
            this.mTvOutOfDate.setTextSize(15.0f);
            this.mVOutOfDate.setVisibility(8);
        } else if (i == 1) {
            this.mTvUseText.setTextColor(getResources().getColor(R.color.ffa1a6b3));
            this.mTvUseText.setTextSize(15.0f);
            this.mVLineUse.setVisibility(8);
            this.mTvUsedText.setTextColor(getResources().getColor(R.color.ff242933));
            this.mTvUsedText.setTextSize(16.0f);
            this.mVLineUsed.setVisibility(0);
            this.mTvOutOfDate.setTextColor(getResources().getColor(R.color.ffa1a6b3));
            this.mTvOutOfDate.setTextSize(15.0f);
            this.mVOutOfDate.setVisibility(8);
        } else if (i == 2) {
            this.mTvUseText.setTextColor(getResources().getColor(R.color.ffa1a6b3));
            this.mTvUseText.setTextSize(15.0f);
            this.mVLineUse.setVisibility(8);
            this.mTvUsedText.setTextColor(getResources().getColor(R.color.ffa1a6b3));
            this.mTvUsedText.setTextSize(15.0f);
            this.mVLineUsed.setVisibility(8);
            this.mTvOutOfDate.setTextColor(getResources().getColor(R.color.ff242933));
            this.mTvOutOfDate.setTextSize(16.0f);
            this.mVOutOfDate.setVisibility(0);
        }
        if (this.mState != i) {
            this.mState = i;
            getRecords();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getRecords() {
        V3BusinessControllers.getInstance().getCouponList(getLoginAccount(), UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "", InvestorInfoUtilControl.getInstance().getInvestorInfoBean().investorId, this.mState, 5, 21, 0, this.mPrepaymentDeviceInfoBean.machineId, UserInfoUtilControl.getInstance().getStudentId(), new Listener<List<CouponBean>>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.PrepaymentRedPackageActivityActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                PrepaymentRedPackageActivityActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                PrepaymentRedPackageActivityActivity.this.mLoadMoreFootView.setNoMoreData("");
                PrepaymentRedPackageActivityActivity.this.mMultiStateView.getView(3);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<CouponBean> list, Object... objArr) {
                if (PrepaymentRedPackageActivityActivity.this.mIsEnable) {
                    PrepaymentRedPackageActivityActivity.this.mMultiStateView.setViewState(0);
                    PrepaymentRedPackageActivityActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    if (list != null) {
                        PrepaymentRedPackageActivityActivity.this.mRecordListBeans.clear();
                        PrepaymentRedPackageActivityActivity.this.mRecordListBeans.addAll(list);
                        PrepaymentRedPackageActivityActivity.this.mApdater.notifyDataSetChanged();
                        if (list.size() == 0) {
                            PrepaymentRedPackageActivityActivity.this.mMultiStateView.setViewState(2);
                            return;
                        }
                        return;
                    }
                    PrepaymentRedPackageActivityActivity.this.mMultiStateView.setViewState(2);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (PrepaymentRedPackageActivityActivity.this.mIsEnable) {
                    PrepaymentRedPackageActivityActivity.this.mMultiStateView.setViewState(1);
                    PrepaymentRedPackageActivityActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    PrepaymentRedPackageActivityActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), clientException.getDetail());
        } else {
            V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
        }
    }

    private class RecordsAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        private RecordsAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return PrepaymentRedPackageActivityActivity.this.mRecordListBeans.size();
        }

        @Override // android.widget.Adapter
        public CouponBean getItem(int i) {
            return (CouponBean) PrepaymentRedPackageActivityActivity.this.mRecordListBeans.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(PrepaymentRedPackageActivityActivity.this.getContext()).inflate(R.layout.layout_item_prepayment_repackage, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            if (PrepaymentRedPackageActivityActivity.this.mState != 2) {
                if (PrepaymentRedPackageActivityActivity.this.mState == 1) {
                    viewHolder.rel_yhq.setBackgroundResource(R.mipmap.hbyy);
                } else {
                    viewHolder.rel_yhq.setBackgroundResource(R.mipmap.hb);
                }
            } else {
                viewHolder.rel_yhq.setBackgroundResource(R.mipmap.hbgq);
            }
            CouponBean item = getItem(i);
            viewHolder.tv_money.setText(DecimalUtil.divide(item.balance + "", "100"));
            viewHolder.tv_time.setText(item.startDate + " 至 " + item.endDate);
            if (PrepaymentRedPackageActivityActivity.this.mInvestorInfoBean != null && PrepaymentRedPackageActivityActivity.this.mInvestorInfoBean.providerJson != null) {
                viewHolder.tv_servername.setText(PrepaymentRedPackageActivityActivity.this.mInvestorInfoBean.providerJson.providerName);
            }
            return view;
        }

        class ViewHolder {
            private LinearLayout rel_yhq;
            public TextView tv_money;
            public TextView tv_servername;
            public TextView tv_time;

            public ViewHolder(View view) {
                this.tv_money = (TextView) view.findViewById(R.id.tv_money);
                this.tv_time = (TextView) view.findViewById(R.id.tv_time);
                this.tv_servername = (TextView) view.findViewById(R.id.tv_servername);
                this.rel_yhq = (LinearLayout) view.findViewById(R.id.rel_yhq);
            }
        }
    }
}
