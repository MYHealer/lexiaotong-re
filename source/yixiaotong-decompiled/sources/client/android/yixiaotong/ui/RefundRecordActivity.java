package client.android.yixiaotong.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.account.AccountManager;
import client.android.yixiaotong.baseutil.ActivitiesHelper;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.refund.RefundListBean;
import client.android.yixiaotong.controller.bean.refund.RefundRecordBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.sdk.utils.RandomUtil;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.login.LoginActivity;
import client.android.yixiaotong.ui.refund.RefundDetailActivity;
import client.android.yixiaotong.ui.widget.LoadMoreFooter;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.TimeUtils;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.huawei.openalliance.ad.constant.x;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class RefundRecordActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    public static final String EXTRA_WALLTE = "extra_wallet";
    private LayoutInflater mInflater;
    private boolean mIsEnable;
    private LoadMoreFooter mLoadMoreFootView;
    private MessageAdapter mMessageAdapter;
    private final List<RefundRecordBean> mMessageBeans = new ArrayList();
    PullRefreshLayout mPullRefreshLayout;
    TitleBar mTitlebar;
    TextView mTvErrorTip;
    Button mVBtnReload;
    MultiStateView mVLoadingview;
    private WalletModel mWalletModel;
    ListView vLvMessage;

    static {
        StubApp.interface11(6056);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, WalletModel walletModel) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) RefundRecordActivity.class).putExtra("extra_wallet", walletModel));
        }
    }

    private void initViewNew() {
        this.mTitlebar = (TitleBar) findViewById(R.id.titlebar);
        this.vLvMessage = (ListView) findViewById(R.id.v_lv_message);
        this.mVLoadingview = (MultiStateView) findViewById(R.id.v_loadingview);
        this.mVBtnReload = (Button) findViewById(R.id.btn_reload);
        this.mTvErrorTip = (TextView) findViewById(R.id.tv_errortip);
        this.mPullRefreshLayout = (PullRefreshLayout) findViewById(R.id.pullRefreshLayout);
    }

    private void initTitlebar() {
        this.mTitlebar.setTitleView("退款记录");
        this.mTitlebar.setLeftView(R.mipmap.back);
        this.mTitlebar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        this.mInflater = LayoutInflater.from(getActivity());
        LoadMoreFooter loadMoreFooter = new LoadMoreFooter(getContext());
        this.mLoadMoreFootView = loadMoreFooter;
        this.vLvMessage.addFooterView(loadMoreFooter);
        MessageAdapter messageAdapter = new MessageAdapter();
        this.mMessageAdapter = messageAdapter;
        this.vLvMessage.setAdapter((ListAdapter) messageAdapter);
        this.mVBtnReload.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.RefundRecordActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RefundRecordActivity.this.mVLoadingview.setViewState(3);
                RefundRecordActivity.this.initData();
            }
        });
        this.vLvMessage.setOnItemClickListener(this);
    }

    private void initListener() {
        this.mPullRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.ui.RefundRecordActivity.2
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                RefundRecordActivity.this.initData();
            }
        });
        this.mLoadMoreFootView.setUseProgressBar(true);
        this.mLoadMoreFootView.setOnClickLoadMoreListener(new LoadMoreFooter.OnClickLoadMoreListener() { // from class: client.android.yixiaotong.ui.RefundRecordActivity.3
            @Override // client.android.yixiaotong.ui.widget.LoadMoreFooter.OnClickLoadMoreListener
            public void onClick() {
                RefundRecordActivity.this.initData();
            }
        });
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        RefundDetailActivity.launch(getActivity(), this.mMessageAdapter.getItem(i));
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

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        BusinessControllers.getInstance().getUserRefundList(getLoginAccount(), RandomUtil.getRandNumMaxString(6), this.mWalletModel.typeId, new Listener<RefundListBean>() { // from class: client.android.yixiaotong.ui.RefundRecordActivity.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                if (RefundRecordActivity.this.mMessageBeans.size() == 0) {
                    RefundRecordActivity.this.mLoadMoreFootView.setNoMoreData("");
                } else {
                    RefundRecordActivity.this.mLoadMoreFootView.loadMoreData();
                }
                RefundRecordActivity.this.mVLoadingview.getView(3);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, RefundListBean refundListBean, Object... objArr) {
                super.onComplete(controller, refundListBean, objArr);
                if (!RefundRecordActivity.this.mIsEnable || RefundRecordActivity.this.mVLoadingview == null || RefundRecordActivity.this.mPullRefreshLayout == null) {
                    return;
                }
                RefundRecordActivity.this.mVLoadingview.setViewState(0);
                RefundRecordActivity.this.mPullRefreshLayout.setRefreshing(false);
                if (refundListBean != null) {
                    RefundRecordActivity.this.mMessageBeans.clear();
                    RefundRecordActivity.this.mMessageBeans.addAll(refundListBean.refundList);
                    if (RefundRecordActivity.this.mMessageBeans.size() == 0) {
                        RefundRecordActivity.this.mVLoadingview.setViewState(2);
                    }
                    RefundRecordActivity.this.mMessageAdapter.notifyDataSetChanged();
                    RefundRecordActivity.this.mLoadMoreFootView.setNoMoreData();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (RefundRecordActivity.this.mIsEnable) {
                    if (clientException.getCode() == 1001) {
                        AccountManager.getInstance().clearLoginAccount();
                        LoginActivity.launch(RefundRecordActivity.this.getActivity());
                        ActivitiesHelper.getInstance().closeExcept(LoginActivity.class);
                    } else {
                        RefundRecordActivity.this.mVLoadingview.setViewState(1);
                        RefundRecordActivity.this.mTvErrorTip.setText(clientException.getDetail());
                        if (RefundRecordActivity.this.mPullRefreshLayout != null) {
                            RefundRecordActivity.this.mPullRefreshLayout.setRefreshing(false);
                        }
                        SystemErrorTip.getInstance().showTipDialog(RefundRecordActivity.this.getActivity(), clientException.getDetail());
                    }
                }
            }
        });
    }

    class MessageAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        MessageAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return RefundRecordActivity.this.mMessageBeans.size();
        }

        @Override // android.widget.Adapter
        public RefundRecordBean getItem(int i) {
            return (RefundRecordBean) RefundRecordActivity.this.mMessageBeans.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = RefundRecordActivity.this.mInflater.inflate(R.layout.refund_record_item_layout, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            RefundRecordBean refundRecordBean = (RefundRecordBean) RefundRecordActivity.this.mMessageBeans.get(i);
            viewHolder.money.setText(x.A + refundRecordBean.Refund);
            if (StringUtils.isNotEmpty(refundRecordBean.ApplicationTimeStr)) {
                viewHolder.tv_time.setText(TimeUtils.formatDateTime(Long.parseLong(refundRecordBean.ApplicationTimeStr)));
                viewHolder.name.setText(RefundRecordActivity.this.mWalletModel.name + "退款");
            }
            return view;
        }
    }

    static class ViewHolder {
        public TextView money;
        public TextView name;
        public TextView tv_time;

        public ViewHolder(View view) {
            this.tv_time = (TextView) view.findViewById(R.id.tv_time);
            this.money = (TextView) view.findViewById(R.id.money);
            this.name = (TextView) view.findViewById(R.id.name);
        }
    }
}
