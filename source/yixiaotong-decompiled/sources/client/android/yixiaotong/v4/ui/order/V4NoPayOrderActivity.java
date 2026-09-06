package client.android.yixiaotong.v4.ui.order;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.widget.LoadMoreFooter;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.http.bean.V4BathRecordBean;
import client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil;
import client.android.yixiaotong.v4.util.homeinfo.V4TypeIDSetUtil;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4NoPayOrderActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private static final String TAG = "V4NoPayOrderActivity";
    private RecordsAdapter mApdater;
    private LoadMoreFooter mLoadMoreFootView;
    private ListView mLvRecord;
    private MultiStateView mMultiStateView;
    private PullRefreshLayout mSwipeRefreshLayout;
    private TitleBar mTitleBar;
    private TextView mTvErrorTip;
    private TextView mTvTotalMoney;
    private List<V4BathRecordBean> mAllRecordListBeans = new ArrayList();
    private List<Integer> mPayFlagTypeList = new ArrayList();
    private int mSelectWay = 0;
    private int mSelectIndex = 0;
    private boolean mIsEnable = true;

    static {
        StubApp.interface11(10969);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4NoPayOrderActivity.class));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mSwipeRefreshLayout = (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        this.mMultiStateView = (MultiStateView) findViewById(R.id.multiStateView);
        this.mLvRecord = (ListView) findViewById(R.id.lv_record);
        this.mTvTotalMoney = (TextView) findViewById(R.id.tv_totalmoney);
        initFooterView();
    }

    private void initFooterView() {
        LoadMoreFooter loadMoreFooter = new LoadMoreFooter(getContext());
        this.mLoadMoreFootView = loadMoreFooter;
        this.mLvRecord.addFooterView(loadMoreFooter);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.unpaidorder));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    public void initView() {
        this.mApdater = new RecordsAdapter();
        this.mLvRecord.setOnItemClickListener(this);
        this.mLvRecord.setAdapter((ListAdapter) this.mApdater);
        this.mApdater.notifyDataSetChanged();
        this.mPayFlagTypeList.add(1);
        this.mTvErrorTip = (TextView) this.mMultiStateView.getView(1).findViewById(R.id.tv_errortip);
        this.mMultiStateView.getView(1).findViewById(R.id.btn_reload).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.order.V4NoPayOrderActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                V4NoPayOrderActivity.this.mMultiStateView.setViewState(3);
                V4NoPayOrderActivity.this.getRecord();
            }
        });
        this.mSwipeRefreshLayout.setRefreshing(false);
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.v4.ui.order.V4NoPayOrderActivity.2
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                V4NoPayOrderActivity.this.getRecord();
            }
        });
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        getRecord();
        V4ErrorControlUtil.getInstance().onResume();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        V4ErrorControlUtil.getInstance().onPause();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.mIsEnable = false;
        LogUtil.e(TAG, "onDestroy");
    }

    private void initClickListeners() {
        findViewById(R.id.btn_pay).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.order.V4NoPayOrderActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m531xa1881cdb(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v4-ui-order-V4NoPayOrderActivity, reason: not valid java name */
    /* synthetic */ void m531xa1881cdb(View view) {
        if (ClickUtil.isFastDoubleClick() || this.mAllRecordListBeans.isEmpty() || this.mSelectIndex >= this.mAllRecordListBeans.size()) {
            return;
        }
        if (this.mAllRecordListBeans.get(this.mSelectIndex).isClicked()) {
            handlePayment(3);
        } else {
            ToastUtils.show(getActivity(), "请选择订单");
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i < 0 || i >= this.mAllRecordListBeans.size()) {
            return;
        }
        V4BathRecordBean v4BathRecordBean = this.mAllRecordListBeans.get(i);
        if (v4BathRecordBean.isPayed()) {
            return;
        }
        for (int i2 = 0; i2 < this.mAllRecordListBeans.size(); i2++) {
            LogUtil.e(TAG, "onItemClick:" + i2 + PPSLabelView.Code + i);
            this.mAllRecordListBeans.get(i2).setClicked(false);
        }
        this.mAllRecordListBeans.get(i).setClicked(true);
        LogUtil.e(TAG, "onItemClick2222:" + this.mAllRecordListBeans.get(i).isClicked());
        if (this.mAllRecordListBeans.get(i).isClicked()) {
            this.mTvTotalMoney.setText(getResources().getString(R.string.renminbi) + v4BathRecordBean.consume);
        } else {
            this.mTvTotalMoney.setText(getResources().getString(R.string.renminbi));
        }
        this.mSelectIndex = i;
        this.mApdater.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getRecord() {
        V4BusinessControllers.getInstance().getNoPayRecord(getLoginAccount(), 0, new Listener<List<V4BathRecordBean>>() { // from class: client.android.yixiaotong.v4.ui.order.V4NoPayOrderActivity.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                V4NoPayOrderActivity.this.mLoadMoreFootView.setNoMoreData("");
                V4NoPayOrderActivity.this.mMultiStateView.getView(3);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<V4BathRecordBean> list, Object... objArr) {
                if (V4NoPayOrderActivity.this.mIsEnable) {
                    V4NoPayOrderActivity.this.mMultiStateView.setViewState(0);
                    V4NoPayOrderActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    if (list != null) {
                        V4NoPayOrderActivity.this.mLoadMoreFootView.setNoMoreData();
                        V4NoPayOrderActivity.this.mAllRecordListBeans.clear();
                        for (int i = 0; i < list.size(); i++) {
                            V4NoPayOrderActivity.this.mAllRecordListBeans.add(list.get(i));
                        }
                        if (V4NoPayOrderActivity.this.mAllRecordListBeans.size() == 0) {
                            V4NoPayOrderActivity.this.mMultiStateView.setViewState(2);
                        }
                        V4NoPayOrderActivity.this.mApdater.notifyDataSetChanged();
                        return;
                    }
                    V4NoPayOrderActivity.this.mMultiStateView.setViewState(2);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4NoPayOrderActivity.this.mIsEnable) {
                    V4NoPayOrderActivity.this.mMultiStateView.setViewState(1);
                    V4NoPayOrderActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    V4NoPayOrderActivity.this.onError(clientException);
                }
            }
        });
    }

    private void handlePayment(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mAllRecordListBeans.get(this.mSelectIndex).consumeOrderId);
        V4BusinessControllers.getInstance().toPay(getLoginAccount(), arrayList, i, new Listener<String>() { // from class: client.android.yixiaotong.v4.ui.order.V4NoPayOrderActivity.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, String str, Object... objArr) {
                super.onComplete(controller, str, objArr);
                if (V4NoPayOrderActivity.this.mIsEnable) {
                    ToastUtils.show(V4NoPayOrderActivity.this.getActivity(), "支付成功");
                    V4BathRecordBean v4BathRecordBean = (V4BathRecordBean) V4NoPayOrderActivity.this.mAllRecordListBeans.get(V4NoPayOrderActivity.this.mSelectIndex);
                    v4BathRecordBean.setPayed(true);
                    v4BathRecordBean.setClicked(false);
                    V4NoPayOrderActivity.this.mApdater.notifyDataSetChanged();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (V4NoPayOrderActivity.this.mIsEnable) {
                    V4ErrorControlUtil.getInstance().showDialog(clientException, V4NoPayOrderActivity.this.getActivity(), false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        V4ErrorControlUtil.getInstance().showDialog(clientException, getActivity(), false);
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
            return V4NoPayOrderActivity.this.mAllRecordListBeans.size();
        }

        @Override // android.widget.Adapter
        public V4BathRecordBean getItem(int i) {
            return (V4BathRecordBean) V4NoPayOrderActivity.this.mAllRecordListBeans.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(V4NoPayOrderActivity.this.getContext()).inflate(R.layout.layout_nopayorderrecord_item_v3, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            V4BathRecordBean v4BathRecordBean = (V4BathRecordBean) V4NoPayOrderActivity.this.mAllRecordListBeans.get(i);
            LogUtil.e(V4NoPayOrderActivity.TAG, "getView:" + v4BathRecordBean.isClicked() + PPSLabelView.Code + v4BathRecordBean.isPayed());
            viewHolder.tv_orderid.setText(V4NoPayOrderActivity.this.getString(R.string.orderno) + v4BathRecordBean.consumeOrderId);
            viewHolder.tv_money.setText("¥" + v4BathRecordBean.consume);
            if (v4BathRecordBean.isPayed()) {
                viewHolder.tv_state.setTextColor(V4NoPayOrderActivity.this.getResources().getColor(R.color.ffa1a6b3));
                viewHolder.tv_state.setText(V4NoPayOrderActivity.this.getString(R.string.payed));
            } else {
                viewHolder.tv_state.setTextColor(V4NoPayOrderActivity.this.getResources().getColor(R.color.fff3382a));
                viewHolder.tv_state.setText(V4NoPayOrderActivity.this.getString(R.string.nopay));
            }
            viewHolder.tv_type.setText(V4TypeIDSetUtil.getAppName(V4NoPayOrderActivity.this.getActivity(), v4BathRecordBean.productId));
            if (v4BathRecordBean.isClicked()) {
                viewHolder.iv_check.setImageResource(R.drawable.radio_check);
            } else {
                viewHolder.iv_check.setImageResource(R.drawable.radio_uncheck);
            }
            return view;
        }

        class ViewHolder {
            public ImageView iv_check;
            public TextView tv_money;
            public TextView tv_orderid;
            public TextView tv_state;
            public TextView tv_type;

            public ViewHolder(View view) {
                this.tv_orderid = (TextView) view.findViewById(R.id.tv_orderid);
                this.tv_type = (TextView) view.findViewById(R.id.tv_type);
                this.tv_money = (TextView) view.findViewById(R.id.tv_money);
                this.tv_state = (TextView) view.findViewById(R.id.tv_state);
                this.iv_check = (ImageView) view.findViewById(R.id.iv_check);
            }
        }
    }
}
