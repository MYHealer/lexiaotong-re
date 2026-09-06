package client.android.yixiaotong.ui.hamam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.AmmeterAreaInfo;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.LoadMoreFooter;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class HamamAddressActivity extends BaseActivity {
    public static final String EXTRAS_DEVICE_ADDRESS = "deviceAddress";
    public static final String EXTRA_WALLET = "extra_wallet";
    public static final int requestCode = 1;
    private AddressAdapter mAddressAdapter;
    private int mCode;
    private String mId;
    private ListView mListView;
    private LoadMoreFooter mLoadMoreFootView;
    private MultiStateView mMultiStateView;
    private PullRefreshLayout mSwipeRefreshLayout;
    private TitleBar mTitleBar;
    TextView mTvErrorTip;
    private List<AmmeterAreaInfo> mAmmeterAreaInfos = new ArrayList();
    private boolean mIsEnable = true;

    static {
        StubApp.interface11(7270);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, int i, String str) {
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) HamamAddressActivity.class);
            intent.putExtra("code", i);
            intent.putExtra("id", str);
            activity.startActivityForResult(intent, 1);
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mListView = (ListView) findViewById(R.id.list);
        this.mSwipeRefreshLayout = (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        this.mMultiStateView = (MultiStateView) findViewById(R.id.multiStateView);
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

    private void initTitleBar() {
        this.mTitleBar.setTitleView("浴室地址");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        this.mAddressAdapter = new AddressAdapter();
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: client.android.yixiaotong.ui.hamam.HamamAddressActivity.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AmmeterAreaInfo ammeterAreaInfo = (AmmeterAreaInfo) adapterView.getAdapter().getItem(i);
                Intent intent = new Intent();
                intent.putExtra("name", ammeterAreaInfo.name);
                intent.putExtra("id", ammeterAreaInfo.id);
                HamamAddressActivity hamamAddressActivity = HamamAddressActivity.this;
                hamamAddressActivity.setResult(hamamAddressActivity.mCode, intent);
                HamamAddressActivity.this.finish();
            }
        });
        this.mListView.setAdapter((ListAdapter) this.mAddressAdapter);
    }

    private void initFooterView() {
        LoadMoreFooter loadMoreFooter = new LoadMoreFooter(getContext());
        this.mLoadMoreFootView = loadMoreFooter;
        this.mListView.addFooterView(loadMoreFooter);
        this.mListView.setFooterDividersEnabled(false);
        this.mLoadMoreFootView.setVisibility(8);
    }

    private void initListener() {
        this.mTvErrorTip = (TextView) this.mMultiStateView.getView(1).findViewById(R.id.tv_errortip);
        this.mMultiStateView.getView(1).findViewById(R.id.btn_reload).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.hamam.HamamAddressActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HamamAddressActivity.this.mMultiStateView.setViewState(3);
                HamamAddressActivity.this.initData();
            }
        });
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.ui.hamam.HamamAddressActivity.3
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                HamamAddressActivity.this.initData();
            }
        });
        this.mLoadMoreFootView.setUseProgressBar(true);
        this.mLoadMoreFootView.setOnClickLoadMoreListener(new LoadMoreFooter.OnClickLoadMoreListener() { // from class: client.android.yixiaotong.ui.hamam.HamamAddressActivity.4
            @Override // client.android.yixiaotong.ui.widget.LoadMoreFooter.OnClickLoadMoreListener
            public void onClick() {
                HamamAddressActivity.this.initData();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        initRid();
    }

    private void initRid() {
        String str;
        int i = this.mCode;
        if (i == 1) {
            str = getLoginAccount().getAccountManagetStore().getUserInfo().AreaId + "";
        } else {
            str = i == 2 ? this.mId : null;
        }
        if (this.mCode != 2) {
            if (StringUtils.isNotEmpty(str)) {
                BusinessControllers.getInstance().entranceGuardGetAreaInfo(getLoginAccount(), str, new Listener<List<AmmeterAreaInfo>>() { // from class: client.android.yixiaotong.ui.hamam.HamamAddressActivity.5
                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onStart(Controller controller) {
                        HamamAddressActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                    }

                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onComplete(Controller controller, List<AmmeterAreaInfo> list, Object... objArr) {
                        if (HamamAddressActivity.this.mIsEnable) {
                            HamamAddressActivity.this.mMultiStateView.setViewState(0);
                            HamamAddressActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                            if (list == null || list.size() <= 0) {
                                HamamAddressActivity.this.mMultiStateView.setViewState(2);
                            } else {
                                HamamAddressActivity.this.mAmmeterAreaInfos = list;
                                HamamAddressActivity.this.mAddressAdapter.notifyDataSetChanged();
                            }
                        }
                    }

                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onFail(Controller controller, ClientException clientException) {
                        if (HamamAddressActivity.this.mIsEnable) {
                            HamamAddressActivity.this.mMultiStateView.setViewState(1);
                            HamamAddressActivity.this.mTvErrorTip.setText(clientException.getDetail());
                            SystemErrorTip.getInstance().showTipDialog(HamamAddressActivity.this.getActivity(), clientException.getDetail());
                        }
                    }
                });
                return;
            }
            return;
        }
        StringUtils.isNotEmpty(str);
    }

    private class AddressAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        private AddressAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return HamamAddressActivity.this.mAmmeterAreaInfos.size();
        }

        @Override // android.widget.Adapter
        public AmmeterAreaInfo getItem(int i) {
            return (AmmeterAreaInfo) HamamAddressActivity.this.mAmmeterAreaInfos.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(HamamAddressActivity.this.getContext()).inflate(R.layout.ammeter_address_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.textView.setText(getItem(i).name);
            return view;
        }

        class ViewHolder {
            public TextView textView;

            public ViewHolder(View view) {
                this.textView = (TextView) view.findViewById(R.id.name);
            }
        }
    }
}
