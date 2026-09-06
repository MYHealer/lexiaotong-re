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
import client.android.yixiaotong.controller.bean.hamam.HamamDetailListBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.LoadMoreFooter;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class HamamZaoTangAddressActivity extends BaseActivity {
    public static final String EXTRAS_DEVICE_ADDRESS = "deviceAddress";
    public static final String EXTRA_WALLET = "extra_wallet";
    public static final int requestCode = 1;
    private AddressAdapter2 mAddressAdapter2;
    private int mCode;
    private String mId;
    ListView mListView2;
    private LoadMoreFooter mLoadMoreFootView;
    MultiStateView mMultiStateView;
    PullRefreshLayout mSwipeRefreshLayout;
    TitleBar mTitleBar;
    TextView mTvErrorTip;
    private List<HamamDetailListBean> mAreaInfos = new ArrayList();
    private boolean mIsInit = false;
    private boolean mIsEnable = true;

    static {
        StubApp.interface11(AVMDLDataLoader.KeyIsEnableIOManager);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, int i, String str) {
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) HamamZaoTangAddressActivity.class);
            intent.putExtra("code", i);
            intent.putExtra("id", str);
            activity.startActivityForResult(intent, 1);
        }
    }

    public static void launch(Activity activity, int i, String str, boolean z) {
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) HamamZaoTangAddressActivity.class);
            intent.putExtra("code", i);
            intent.putExtra("id", str);
            intent.putExtra("isinit", z);
            activity.startActivityForResult(intent, 1);
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mListView2 = (ListView) findViewById(R.id.list2);
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
        this.mAddressAdapter2 = new AddressAdapter2();
        this.mListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: client.android.yixiaotong.ui.hamam.HamamZaoTangAddressActivity.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                HamamDetailListBean hamamDetailListBean = (HamamDetailListBean) adapterView.getAdapter().getItem(i);
                Intent intent = new Intent();
                intent.putExtra("name", hamamDetailListBean.bhname);
                intent.putExtra("id", hamamDetailListBean.id);
                HamamZaoTangAddressActivity hamamZaoTangAddressActivity = HamamZaoTangAddressActivity.this;
                hamamZaoTangAddressActivity.setResult(hamamZaoTangAddressActivity.mCode, intent);
                HamamZaoTangAddressActivity.this.finish();
            }
        });
        this.mListView2.setAdapter((ListAdapter) this.mAddressAdapter2);
    }

    private void initFooterView() {
        LoadMoreFooter loadMoreFooter = new LoadMoreFooter(getContext());
        this.mLoadMoreFootView = loadMoreFooter;
        this.mListView2.addFooterView(loadMoreFooter);
        this.mListView2.setFooterDividersEnabled(false);
        this.mLoadMoreFootView.setVisibility(8);
    }

    private void initListener() {
        this.mTvErrorTip = (TextView) this.mMultiStateView.getView(1).findViewById(R.id.tv_errortip);
        this.mMultiStateView.getView(1).findViewById(R.id.btn_reload).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.hamam.HamamZaoTangAddressActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HamamZaoTangAddressActivity.this.mMultiStateView.setViewState(3);
                HamamZaoTangAddressActivity.this.initData();
            }
        });
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.ui.hamam.HamamZaoTangAddressActivity.3
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                HamamZaoTangAddressActivity.this.initData();
            }
        });
        this.mLoadMoreFootView.setUseProgressBar(true);
        this.mLoadMoreFootView.setOnClickLoadMoreListener(new LoadMoreFooter.OnClickLoadMoreListener() { // from class: client.android.yixiaotong.ui.hamam.HamamZaoTangAddressActivity.4
            @Override // client.android.yixiaotong.ui.widget.LoadMoreFooter.OnClickLoadMoreListener
            public void onClick() {
                HamamZaoTangAddressActivity.this.initData();
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
        String str2 = str;
        if (this.mCode == 2 && StringUtils.isNotEmpty(str2)) {
            int i2 = getLoginAccount().getAccountManagetStore().getUserInfo().GenderId;
            if (this.mIsInit) {
                i2 = 0;
            }
            BusinessControllers.getInstance().getHamamDetail(getLoginAccount(), str2, i2, "0", new Listener<List<HamamDetailListBean>>() { // from class: client.android.yixiaotong.ui.hamam.HamamZaoTangAddressActivity.5
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    HamamZaoTangAddressActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, List<HamamDetailListBean> list, Object... objArr) {
                    if (HamamZaoTangAddressActivity.this.mIsEnable) {
                        HamamZaoTangAddressActivity.this.mMultiStateView.setViewState(0);
                        HamamZaoTangAddressActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                        if (list != null && list.size() > 0) {
                            HamamZaoTangAddressActivity.this.mAreaInfos = list;
                            HamamZaoTangAddressActivity.this.mAddressAdapter2.notifyDataSetChanged();
                        } else {
                            HamamZaoTangAddressActivity.this.mMultiStateView.setViewState(2);
                        }
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (HamamZaoTangAddressActivity.this.mIsEnable) {
                        HamamZaoTangAddressActivity.this.mMultiStateView.setViewState(1);
                        HamamZaoTangAddressActivity.this.mTvErrorTip.setText(clientException.getDetail());
                        SystemErrorTip.getInstance().showTipDialog(HamamZaoTangAddressActivity.this.getActivity(), clientException.getDetail());
                    }
                }
            });
        }
    }

    private class AddressAdapter2 extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        private AddressAdapter2() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return HamamZaoTangAddressActivity.this.mAreaInfos.size();
        }

        @Override // android.widget.Adapter
        public HamamDetailListBean getItem(int i) {
            return (HamamDetailListBean) HamamZaoTangAddressActivity.this.mAreaInfos.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(HamamZaoTangAddressActivity.this.getContext()).inflate(R.layout.ammeter_address_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.textView.setText(getItem(i).bhname);
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
