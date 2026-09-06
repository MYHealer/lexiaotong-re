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
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.adapter.MalfunctionRepairAdapter;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.LoadMoreFooter;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.ListUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class MalfunctionRepairActivity extends BaseActivity {
    public static final String EXTRA_TYPEID = "extra_typeid";
    private MalfunctionRepairAdapter mApdater;
    private Button mBtnBaoXiu;
    private LayoutInflater mInflater;
    private boolean mIsEnable;
    private LoadMoreFooter mLoadMoreFootView;
    private ListView mLvRepair;
    private MultiStateView mMultiStateView;
    private PullRefreshLayout mSwipeRefreshLayout;
    private TitleBar mTitleBar;
    private TextView mTvErrorTip;
    private Button mVBtnReload;
    private WalletModel mWalletModel;
    private List<WalletModel> mWalletModels;
    private int mTypeId = 0;
    private int mStart = 0;
    private String mMonth = "0";
    private List<ReportBean> repairDetailBeanList = new ArrayList();
    private boolean mHasMoreData = false;
    private int mTotalCount = 0;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.ui.baoxiu.MalfunctionRepairActivity.8
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            if (i == 0) {
                PermissionUtil.requestPerssion(MalfunctionRepairActivity.this.getActivity(), 2, MalfunctionRepairActivity.this.permissionGrant);
            } else if (i == 2) {
                PermissionUtil.requestPerssion(MalfunctionRepairActivity.this.getActivity(), 3, MalfunctionRepairActivity.this.permissionGrant);
            } else {
                if (i != 3) {
                    return;
                }
                DeviceReportActivity.launch(MalfunctionRepairActivity.this.getActivity(), MalfunctionRepairActivity.this.mTypeId);
            }
        }
    };

    static {
        StubApp.interface11(6411);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    static /* synthetic */ int access$1212(MalfunctionRepairActivity malfunctionRepairActivity, int i) {
        int i2 = malfunctionRepairActivity.mStart + i;
        malfunctionRepairActivity.mStart = i2;
        return i2;
    }

    public static void launch(Activity activity, int i) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) MalfunctionRepairActivity.class).putExtra("extra_typeid", i));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titlebar);
        this.mLvRepair = (ListView) findViewById(R.id.lv_repair);
        this.mSwipeRefreshLayout = (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        this.mMultiStateView = (MultiStateView) findViewById(R.id.multiStateView);
        this.mBtnBaoXiu = (Button) findViewById(R.id.btn_baoxiu);
        this.mTvErrorTip = (TextView) findViewById(R.id.tv_errortip);
        this.mVBtnReload = (Button) findViewById(R.id.btn_reload);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("报修中心");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void getWallet() {
        BusinessControllers.getInstance().getWalletModels(getLoginAccount(), new Listener<List<WalletModel>>() { // from class: client.android.yixiaotong.ui.baoxiu.MalfunctionRepairActivity.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<WalletModel> list, Object... objArr) {
                if (list != null) {
                    MalfunctionRepairActivity.this.mWalletModels = list;
                    MalfunctionRepairActivity.this.initView();
                    MalfunctionRepairActivity.this.initData();
                }
                if (MalfunctionRepairActivity.this.mTypeId == 0 || MalfunctionRepairActivity.this.mWalletModels == null || MalfunctionRepairActivity.this.mWalletModels.size() <= 0) {
                    return;
                }
                for (WalletModel walletModel : MalfunctionRepairActivity.this.mWalletModels) {
                    if (MalfunctionRepairActivity.this.mTypeId == walletModel.typeId) {
                        MalfunctionRepairActivity.this.mWalletModel = walletModel;
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                ToastUtils.show(MalfunctionRepairActivity.this.getContext(), "获取钱包失败");
                MalfunctionRepairActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initView() {
        this.mBtnBaoXiu.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.baoxiu.MalfunctionRepairActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PermissionUtil.requestPerssion(MalfunctionRepairActivity.this.getActivity(), 0, MalfunctionRepairActivity.this.permissionGrant);
            }
        });
        MalfunctionRepairAdapter malfunctionRepairAdapter = new MalfunctionRepairAdapter(getActivity(), this.mInflater, this.repairDetailBeanList, this.mWalletModels);
        this.mApdater = malfunctionRepairAdapter;
        this.mLvRepair.setAdapter((ListAdapter) malfunctionRepairAdapter);
        this.mLvRepair.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: client.android.yixiaotong.ui.baoxiu.MalfunctionRepairActivity.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (!MalfunctionRepairActivity.this.mHasMoreData || i + i2 < i3 || i3 <= MalfunctionRepairActivity.this.mTotalCount) {
                    return;
                }
                MalfunctionRepairActivity.this.mTotalCount = i3;
                MalfunctionRepairActivity.this.initData();
                MalfunctionRepairActivity.this.mLoadMoreFootView.loadMoreData();
            }
        });
        this.mVBtnReload.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.baoxiu.MalfunctionRepairActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MalfunctionRepairActivity.this.mMultiStateView.setViewState(3);
                MalfunctionRepairActivity.this.initData();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        getRepairList();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        if (LocalBusinessStore.getIsUploadRepair(getContext())) {
            this.mStart = 0;
            this.mMonth = "0";
            this.mTotalCount = 0;
            initData();
        }
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
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.ui.baoxiu.MalfunctionRepairActivity.5
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                MalfunctionRepairActivity.this.mStart = 0;
                MalfunctionRepairActivity.this.mMonth = "0";
                MalfunctionRepairActivity.this.mTotalCount = 0;
                MalfunctionRepairActivity.this.initData();
            }
        });
        this.mLoadMoreFootView.setUseProgressBar(true);
        this.mLoadMoreFootView.setOnClickLoadMoreListener(new LoadMoreFooter.OnClickLoadMoreListener() { // from class: client.android.yixiaotong.ui.baoxiu.MalfunctionRepairActivity.6
            @Override // client.android.yixiaotong.ui.widget.LoadMoreFooter.OnClickLoadMoreListener
            public void onClick() {
                MalfunctionRepairActivity.this.initData();
            }
        });
    }

    private void getRepairList() {
        BusinessControllers.getInstance().getReportList(getLoginAccount(), getLoginAccount().getAccountManagetStore().getUserInfo().Token, getLoginAccount().getAccountManagetStore().getUserInfo().AreaId + "", getLoginAccount().getUid() + "", 0, 200, this.mMonth, this.mTypeId, 0, new Listener<ReportListBean>() { // from class: client.android.yixiaotong.ui.baoxiu.MalfunctionRepairActivity.7
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                MalfunctionRepairActivity.this.mHasMoreData = false;
                if (MalfunctionRepairActivity.this.mStart == 0) {
                    MalfunctionRepairActivity.this.mLoadMoreFootView.setNoMoreData("");
                } else {
                    MalfunctionRepairActivity.this.mLoadMoreFootView.loadMoreData();
                }
                MalfunctionRepairActivity.this.mMultiStateView.getView(3);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, ReportListBean reportListBean, Object... objArr) {
                if (!MalfunctionRepairActivity.this.mIsEnable || MalfunctionRepairActivity.this.mMultiStateView == null || MalfunctionRepairActivity.this.mSwipeRefreshLayout == null) {
                    return;
                }
                MalfunctionRepairActivity.this.mMultiStateView.setViewState(0);
                MalfunctionRepairActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                if (reportListBean != null) {
                    if (MalfunctionRepairActivity.this.mStart == 0) {
                        MalfunctionRepairActivity.this.repairDetailBeanList.clear();
                        ListUtils.addList(MalfunctionRepairActivity.this.repairDetailBeanList, reportListBean.list);
                        if (MalfunctionRepairActivity.this.repairDetailBeanList.size() == 0) {
                            MalfunctionRepairActivity.this.mMultiStateView.setViewState(2);
                        }
                    } else {
                        ListUtils.addList(MalfunctionRepairActivity.this.repairDetailBeanList, reportListBean.list);
                    }
                    MalfunctionRepairActivity.this.mApdater.notifyDataSetChanged();
                    if ("-1".equals(reportListBean.nextMonth)) {
                        MalfunctionRepairActivity.this.mLoadMoreFootView.setNoMoreData();
                        return;
                    }
                    MalfunctionRepairActivity.this.mHasMoreData = true;
                    MalfunctionRepairActivity.this.mMonth = reportListBean.nextMonth;
                    MalfunctionRepairActivity.access$1212(MalfunctionRepairActivity.this, 1);
                    MalfunctionRepairActivity.this.mLoadMoreFootView.setVisibility(0);
                    MalfunctionRepairActivity.this.mLoadMoreFootView.reset();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (MalfunctionRepairActivity.this.mIsEnable) {
                    if (MalfunctionRepairActivity.this.mStart != 0 || MalfunctionRepairActivity.this.mMultiStateView == null) {
                        MalfunctionRepairActivity.this.mLoadMoreFootView.resetForFail();
                    } else {
                        MalfunctionRepairActivity.this.mMultiStateView.setViewState(1);
                        MalfunctionRepairActivity.this.mTvErrorTip.setText(clientException.getDetail());
                    }
                    if (MalfunctionRepairActivity.this.mSwipeRefreshLayout != null) {
                        MalfunctionRepairActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    }
                    SystemErrorTip.getInstance().showTipDialog(MalfunctionRepairActivity.this.getActivity(), clientException.getDetail());
                }
            }
        });
    }
}
