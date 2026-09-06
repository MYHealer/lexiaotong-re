package client.android.yixiaotong.ui.baoxiu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.report.ReportBean;
import client.android.yixiaotong.controller.bean.report.ReportListBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.adapter.MalfunctionRepairAdapter;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.LoadMoreFooter;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.ListUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class MRepairActivity extends BaseActivity {
    private MalfunctionRepairAdapter mApdater;
    private Button mBtnAll;
    private Button mBtnFinish;
    private Button mBtnFinishing;
    private Button mBtnFinishing2;
    private Button mBtnUnfinish;
    private LayoutInflater mInflater;
    private LoadMoreFooter mLoadMoreFootView;
    private ListView mLvRepair;
    private MultiStateView mMultiStateView;
    private PullRefreshLayout mSwipeRefreshLayout;
    private TitleBar mTitlebar;
    private TextView mTvContent2;
    private TextView mTvErrorTip;
    private TextView mTvLoad;
    private Button mVBtnReload;
    private WalletModel mWalletModel;
    private List<WalletModel> mWalletModels;
    private int mStart = 0;
    private String mMonth = "0";
    private List<ReportBean> repairDetailBeanList = new ArrayList();
    private boolean mHasMoreData = false;
    private int mTotalCount = 0;
    private int mTypeId = 0;
    private boolean mIsEnable = true;
    private int mRepairState = 0;
    private boolean mIsRefrensh = false;

    static {
        StubApp.interface11(6381);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    static /* synthetic */ int access$1012(MRepairActivity mRepairActivity, int i) {
        int i2 = mRepairActivity.mStart + i;
        mRepairActivity.mStart = i2;
        return i2;
    }

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) MRepairActivity.class));
        }
    }

    private void initViewNew() {
        this.mTitlebar = (TitleBar) findViewById(R.id.titlebar);
        this.mLvRepair = (ListView) findViewById(R.id.lv_repair);
        this.mSwipeRefreshLayout = (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        this.mMultiStateView = (MultiStateView) findViewById(R.id.multiStateView);
        this.mBtnAll = (Button) findViewById(R.id.btn_all);
        this.mBtnUnfinish = (Button) findViewById(R.id.btn_unfinish);
        this.mBtnFinish = (Button) findViewById(R.id.btn_finish);
        this.mBtnFinishing = (Button) findViewById(R.id.btn_finishing);
        this.mBtnFinishing2 = (Button) findViewById(R.id.btn_finishing2);
        this.mTvErrorTip = (TextView) findViewById(R.id.tv_errortip);
        this.mVBtnReload = (Button) findViewById(R.id.btn_reload);
        this.mTvLoad = (TextView) findViewById(R.id.tv_load);
        this.mTvContent2 = (TextView) findViewById(R.id.tv_content2);
    }

    private void initTitlebar() {
        this.mTitlebar.setTitleView("报修中心");
        this.mTitlebar.setLeftView(R.mipmap.back);
        this.mTitlebar.setLeftViewOnClickBack(getActivity());
    }

    private void getWallet() {
        BusinessControllers.getInstance().getWalletModels(getLoginAccount(), new Listener<List<WalletModel>>() { // from class: client.android.yixiaotong.ui.baoxiu.MRepairActivity.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<WalletModel> list, Object... objArr) {
                if (list != null) {
                    MRepairActivity.this.mWalletModels = list;
                    MRepairActivity.this.initView();
                    MRepairActivity.this.initData();
                }
                if (MRepairActivity.this.mTypeId == 0 || MRepairActivity.this.mWalletModels == null || MRepairActivity.this.mWalletModels.size() <= 0) {
                    return;
                }
                for (WalletModel walletModel : MRepairActivity.this.mWalletModels) {
                    if (MRepairActivity.this.mTypeId == walletModel.typeId) {
                        MRepairActivity.this.mWalletModel = walletModel;
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                ToastUtils.show(MRepairActivity.this.getContext(), "获取钱包失败");
                MRepairActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initView() {
        MalfunctionRepairAdapter malfunctionRepairAdapter = new MalfunctionRepairAdapter(getActivity(), this.mInflater, this.repairDetailBeanList, this.mWalletModels);
        this.mApdater = malfunctionRepairAdapter;
        this.mLvRepair.setAdapter((ListAdapter) malfunctionRepairAdapter);
        this.mLvRepair.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: client.android.yixiaotong.ui.baoxiu.MRepairActivity.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (!MRepairActivity.this.mHasMoreData || i + i2 < i3 || i3 <= MRepairActivity.this.mTotalCount) {
                    return;
                }
                MRepairActivity.this.mTotalCount = i3;
                MRepairActivity.this.initData();
                MRepairActivity.this.mLoadMoreFootView.loadMoreData();
            }
        });
        this.mVBtnReload.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.baoxiu.MRepairActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MRepairActivity.this.mMultiStateView.setViewState(3);
                MRepairActivity.this.initData();
            }
        });
        this.mTvLoad.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.baoxiu.MRepairActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MRepairActivity.this.mMultiStateView.setViewState(3);
                MRepairActivity.this.initData();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        this.mIsRefrensh = false;
        getRepairList();
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
        this.mIsEnable = false;
    }

    private void initListener() {
        LoadMoreFooter loadMoreFooter = new LoadMoreFooter(getContext());
        this.mLoadMoreFootView = loadMoreFooter;
        this.mLvRepair.addFooterView(loadMoreFooter);
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.ui.baoxiu.MRepairActivity.5
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                MRepairActivity.this.mStart = 0;
                MRepairActivity.this.mMonth = "0";
                MRepairActivity.this.mTotalCount = 0;
                MRepairActivity.this.repairDetailBeanList.clear();
                MRepairActivity.this.mApdater.notifyDataSetChanged();
                MRepairActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                MRepairActivity.this.mIsRefrensh = true;
                MRepairActivity.this.getRepairList();
            }
        });
        this.mLoadMoreFootView.setUseProgressBar(true);
        this.mLoadMoreFootView.setOnClickLoadMoreListener(new LoadMoreFooter.OnClickLoadMoreListener() { // from class: client.android.yixiaotong.ui.baoxiu.MRepairActivity.6
            @Override // client.android.yixiaotong.ui.widget.LoadMoreFooter.OnClickLoadMoreListener
            public void onClick() {
                MRepairActivity.this.initData();
            }
        });
        this.mTvContent2.setVisibility(4);
    }

    private void initClickListeners() {
        findViewById(R.id.btn_all).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.baoxiu.MRepairActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MRepairActivity.this.mRepairState == 0) {
                    return;
                }
                MRepairActivity.this.initData(0);
                MRepairActivity.this.initBtnView();
                MRepairActivity.this.initData();
            }
        });
        findViewById(R.id.btn_unfinish).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.baoxiu.MRepairActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MRepairActivity.this.mRepairState == 2) {
                    return;
                }
                MRepairActivity.this.initData(2);
                MRepairActivity.this.initBtnView();
                MRepairActivity.this.initData();
            }
        });
        findViewById(R.id.btn_finish).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.baoxiu.MRepairActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MRepairActivity.this.mRepairState == 5) {
                    return;
                }
                MRepairActivity.this.initData(5);
                MRepairActivity.this.initBtnView();
                MRepairActivity.this.initData();
            }
        });
        findViewById(R.id.btn_finishing).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.baoxiu.MRepairActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MRepairActivity.this.mRepairState == 7) {
                    return;
                }
                MRepairActivity.this.initData(7);
                MRepairActivity.this.initBtnView();
                MRepairActivity.this.initData();
            }
        });
        findViewById(R.id.btn_finishing2).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.baoxiu.MRepairActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MRepairActivity.this.mRepairState == 3) {
                    return;
                }
                MRepairActivity.this.initData(3);
                MRepairActivity.this.initBtnView();
                MRepairActivity.this.initData();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData(int i) {
        this.mRepairState = i;
        this.mStart = 0;
        this.mMonth = "0";
        this.mTotalCount = 0;
        this.repairDetailBeanList.clear();
        this.mApdater.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getRepairList() {
        BusinessControllers.getInstance().getReportList(getLoginAccount(), getLoginAccount().getAccountManagetStore().getUserInfo().Token, getLoginAccount().getAccountManagetStore().getUserInfo().AreaId + "", getLoginAccount().getUid() + "", 0, 200, this.mMonth, this.mTypeId, this.mRepairState, new Listener<ReportListBean>() { // from class: client.android.yixiaotong.ui.baoxiu.MRepairActivity.12
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                MRepairActivity.this.mHasMoreData = false;
                if (MRepairActivity.this.mStart == 0) {
                    MRepairActivity.this.mLoadMoreFootView.setNoMoreData("");
                } else {
                    MRepairActivity.this.mLoadMoreFootView.loadMoreData();
                }
                if (MRepairActivity.this.mIsRefrensh) {
                    MRepairActivity.this.mMultiStateView.getView(3);
                } else {
                    MRepairActivity.this.mMultiStateView.setViewState(3);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, ReportListBean reportListBean, Object... objArr) {
                super.onComplete(controller, reportListBean, objArr);
                if (MRepairActivity.this.mIsEnable) {
                    MRepairActivity.this.mTvLoad.setVisibility(4);
                    if (MRepairActivity.this.mMultiStateView == null || MRepairActivity.this.mSwipeRefreshLayout == null) {
                        return;
                    }
                    MRepairActivity.this.mMultiStateView.setViewState(0);
                    MRepairActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    if (reportListBean != null) {
                        if (MRepairActivity.this.mStart == 0) {
                            MRepairActivity.this.repairDetailBeanList.clear();
                            ListUtils.addList(MRepairActivity.this.repairDetailBeanList, reportListBean.list);
                            if (MRepairActivity.this.repairDetailBeanList.size() == 0) {
                                MRepairActivity.this.mTvLoad.setVisibility(0);
                                MRepairActivity.this.mMultiStateView.setViewState(2);
                            }
                        } else {
                            ListUtils.addList(MRepairActivity.this.repairDetailBeanList, reportListBean.list);
                        }
                        MRepairActivity.this.mApdater.notifyDataSetChanged();
                        if ("-1".equals(reportListBean.nextMonth)) {
                            MRepairActivity.this.mLoadMoreFootView.setNoMoreData();
                            return;
                        }
                        MRepairActivity.this.mHasMoreData = true;
                        MRepairActivity.this.mMonth = reportListBean.nextMonth;
                        MRepairActivity.access$1012(MRepairActivity.this, 1);
                        MRepairActivity.this.mLoadMoreFootView.setVisibility(0);
                        MRepairActivity.this.mLoadMoreFootView.reset();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (MRepairActivity.this.mIsEnable) {
                    if (MRepairActivity.this.mStart != 0 || MRepairActivity.this.mMultiStateView == null) {
                        MRepairActivity.this.mLoadMoreFootView.resetForFail();
                    } else {
                        MRepairActivity.this.mMultiStateView.setViewState(1);
                        MRepairActivity.this.mTvErrorTip.setText(clientException.getDetail());
                    }
                    if (MRepairActivity.this.mSwipeRefreshLayout != null) {
                        MRepairActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    }
                    SystemErrorTip.getInstance().showTipDialog(MRepairActivity.this.getActivity(), clientException.getDetail());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initBtnView() {
        int i = this.mRepairState;
        if (i == 0) {
            this.mBtnAll.setTextColor(-1);
            this.mBtnAll.setBackgroundColor(-11890462);
            this.mBtnUnfinish.setTextColor(-11890462);
            this.mBtnUnfinish.setBackgroundResource(R.drawable.shape_blue_button1);
            this.mBtnFinish.setTextColor(-11890462);
            this.mBtnFinish.setBackgroundResource(R.drawable.shape_blue_button1);
            this.mBtnFinishing.setTextColor(-11890462);
            this.mBtnFinishing.setBackgroundResource(R.drawable.shape_blue_button1);
            this.mBtnFinishing2.setTextColor(-11890462);
            this.mBtnFinishing2.setBackgroundResource(R.drawable.shape_blue_button1);
            return;
        }
        if (i == 5) {
            this.mBtnAll.setTextColor(-11890462);
            this.mBtnAll.setBackgroundResource(R.drawable.shape_blue_button1);
            this.mBtnUnfinish.setTextColor(-11890462);
            this.mBtnUnfinish.setBackgroundResource(R.drawable.shape_blue_button1);
            this.mBtnFinish.setTextColor(-1);
            this.mBtnFinish.setBackgroundColor(-11890462);
            this.mBtnFinishing.setTextColor(-11890462);
            this.mBtnFinishing.setBackgroundResource(R.drawable.shape_blue_button1);
            this.mBtnFinishing2.setTextColor(-11890462);
            this.mBtnFinishing2.setBackgroundResource(R.drawable.shape_blue_button1);
            return;
        }
        if (i == 7) {
            this.mBtnAll.setTextColor(-11890462);
            this.mBtnAll.setBackgroundResource(R.drawable.shape_blue_button1);
            this.mBtnUnfinish.setTextColor(-11890462);
            this.mBtnUnfinish.setBackgroundResource(R.drawable.shape_blue_button1);
            this.mBtnFinish.setTextColor(-11890462);
            this.mBtnFinish.setBackgroundResource(R.drawable.shape_blue_button1);
            this.mBtnFinishing.setTextColor(-1);
            this.mBtnFinishing.setBackgroundColor(-11890462);
            this.mBtnFinishing2.setTextColor(-11890462);
            this.mBtnFinishing2.setBackgroundResource(R.drawable.shape_blue_button1);
            return;
        }
        if (i == 2) {
            this.mBtnAll.setTextColor(-11890462);
            this.mBtnAll.setBackgroundResource(R.drawable.shape_blue_button1);
            this.mBtnUnfinish.setTextColor(-1);
            this.mBtnUnfinish.setBackgroundColor(-11890462);
            this.mBtnFinish.setTextColor(-11890462);
            this.mBtnFinish.setBackgroundResource(R.drawable.shape_blue_button1);
            this.mBtnFinishing.setTextColor(-11890462);
            this.mBtnFinishing.setBackgroundResource(R.drawable.shape_blue_button1);
            this.mBtnFinishing2.setTextColor(-11890462);
            this.mBtnFinishing2.setBackgroundResource(R.drawable.shape_blue_button1);
            return;
        }
        if (i != 3) {
            return;
        }
        this.mBtnAll.setTextColor(-11890462);
        this.mBtnAll.setBackgroundResource(R.drawable.shape_blue_button1);
        this.mBtnUnfinish.setTextColor(-11890462);
        this.mBtnUnfinish.setBackgroundResource(R.drawable.shape_blue_button1);
        this.mBtnFinish.setTextColor(-11890462);
        this.mBtnFinish.setBackgroundResource(R.drawable.shape_blue_button1);
        this.mBtnFinishing.setTextColor(-11890462);
        this.mBtnFinishing.setBackgroundResource(R.drawable.shape_blue_button1);
        this.mBtnFinishing2.setTextColor(-1);
        this.mBtnFinishing2.setBackgroundColor(-11890462);
    }
}
