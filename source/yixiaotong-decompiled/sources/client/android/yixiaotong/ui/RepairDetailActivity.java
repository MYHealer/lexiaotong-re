package client.android.yixiaotong.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.RepairProcessBean;
import client.android.yixiaotong.controller.bean.RepairProcessListBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.adapter.RepairDetailAdapter;
import client.android.yixiaotong.ui.widget.LoadMoreFooter;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.afollestad.materialdialogs.MaterialDialog;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class RepairDetailActivity extends BaseActivity {
    public static final String EXTRA_REPROTID = "extra_reportid";
    private RepairDetailAdapter mApdater;
    EditText mEtRevert;
    private LayoutInflater mInflater;
    private LoadMoreFooter mLoadMoreFootView;
    ListView mLvRepair;
    private MaterialDialog mMaterialDialog;
    MultiStateView mMultiStateView;
    PullRefreshLayout mSwipeRefreshLayout;
    TitleBar mTitleBar;
    TextView mTvErrorTip;
    private long reportId;
    private int mStart = 0;
    private List<RepairProcessBean> repairDetailBeanList = new ArrayList();

    static {
        StubApp.interface11(6063);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, long j) {
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) RepairDetailActivity.class);
            intent.putExtra(EXTRA_REPROTID, j);
            activity.startActivity(intent);
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titlebar);
        this.mLvRepair = (ListView) findViewById(R.id.lv_repair);
        this.mSwipeRefreshLayout = (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        this.mMultiStateView = (MultiStateView) findViewById(R.id.multiStateView);
        this.mEtRevert = (EditText) findViewById(R.id.et_revert);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initClickListeners() {
        findViewById(R.id.tv_send).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.RepairDetailActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m89x7e973348(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-ui-RepairDetailActivity, reason: not valid java name */
    /* synthetic */ void m89x7e973348(View view) {
        String string = this.mEtRevert.getText().toString();
        if (StringUtils.isEmpty(string)) {
            ToastUtils.show(getActivity(), "请填写回复内容");
        } else {
            BusinessControllers.getInstance().uploadRevertInfo(getLoginAccount(), this.reportId, string, new Listener<Boolean>() { // from class: client.android.yixiaotong.ui.RepairDetailActivity.1
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    if (RepairDetailActivity.this.mMaterialDialog != null) {
                        RepairDetailActivity.this.mMaterialDialog.dismiss();
                        RepairDetailActivity.this.mMaterialDialog = null;
                    }
                    RepairDetailActivity.this.mMaterialDialog = new MaterialDialog.Builder(RepairDetailActivity.this.getActivity()).content("提交中...").progress(true, 0).show();
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, Boolean bool, Object... objArr) {
                    if (RepairDetailActivity.this.mMaterialDialog != null) {
                        RepairDetailActivity.this.mMaterialDialog.dismiss();
                        RepairDetailActivity.this.mMaterialDialog = null;
                    }
                    if (!bool.booleanValue()) {
                        ToastUtils.show(RepairDetailActivity.this.getContext(), "提交失败，请重试");
                        return;
                    }
                    RepairDetailActivity.this.mEtRevert.setText("");
                    RepairDetailActivity.this.initData();
                    ToastUtils.show(RepairDetailActivity.this.getContext(), "提交成功");
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (RepairDetailActivity.this.mMaterialDialog != null) {
                        RepairDetailActivity.this.mMaterialDialog.dismiss();
                        RepairDetailActivity.this.mMaterialDialog = null;
                    }
                    ToastUtils.show(RepairDetailActivity.this.getContext(), "提交失败，请重试");
                }
            });
        }
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("详情");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
        this.mTitleBar.setLeftViewOnClickBack(this);
    }

    private void initView() {
        initFooterView();
        RepairDetailAdapter repairDetailAdapter = new RepairDetailAdapter(this.mInflater, this.repairDetailBeanList);
        this.mApdater = repairDetailAdapter;
        this.mLvRepair.setAdapter((ListAdapter) repairDetailAdapter);
    }

    private void initFooterView() {
        LoadMoreFooter loadMoreFooter = new LoadMoreFooter(getContext());
        this.mLoadMoreFootView = loadMoreFooter;
        this.mLvRepair.addFooterView(loadMoreFooter);
        this.mLoadMoreFootView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        getRepairDetailList();
    }

    private void initListener() {
        this.mTvErrorTip = (TextView) this.mMultiStateView.getView(1).findViewById(R.id.tv_errortip);
        this.mMultiStateView.getView(1).findViewById(R.id.btn_reload).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.RepairDetailActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RepairDetailActivity.this.mMultiStateView.setViewState(3);
                RepairDetailActivity.this.initData();
            }
        });
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.ui.RepairDetailActivity.3
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                RepairDetailActivity.this.mStart = 0;
                RepairDetailActivity.this.initData();
            }
        });
        this.mLoadMoreFootView.setUseProgressBar(true);
        this.mLoadMoreFootView.setOnClickLoadMoreListener(new LoadMoreFooter.OnClickLoadMoreListener() { // from class: client.android.yixiaotong.ui.RepairDetailActivity.4
            @Override // client.android.yixiaotong.ui.widget.LoadMoreFooter.OnClickLoadMoreListener
            public void onClick() {
                RepairDetailActivity.this.initData();
            }
        });
    }

    private void getRepairDetailList() {
        BusinessControllers.getInstance().getRepairProcessList(getLoginAccount(), this.reportId, new Listener<RepairProcessListBean>() { // from class: client.android.yixiaotong.ui.RepairDetailActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                super.onStart(controller);
                if (RepairDetailActivity.this.mStart == 0) {
                    RepairDetailActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, RepairProcessListBean repairProcessListBean, Object... objArr) {
                super.onComplete(controller, repairProcessListBean, objArr);
                RepairDetailActivity.this.mMultiStateView.setViewState(0);
                RepairDetailActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                if (repairProcessListBean != null) {
                    RepairDetailActivity.this.repairDetailBeanList.clear();
                    RepairDetailActivity.this.repairDetailBeanList.addAll(repairProcessListBean.Records);
                    RepairDetailActivity.this.mApdater.notifyDataSetChanged();
                    RepairDetailActivity.this.mLoadMoreFootView.setVisibility(8);
                    RepairDetailActivity.this.mLoadMoreFootView.reset();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (RepairDetailActivity.this.mStart == 0) {
                    RepairDetailActivity.this.mMultiStateView.setViewState(1);
                    RepairDetailActivity.this.mTvErrorTip.setText(clientException.getDetail());
                }
                RepairDetailActivity.this.mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }
}
