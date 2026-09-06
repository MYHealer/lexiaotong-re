package client.android.yixiaotong.v3.ui.area;

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
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.widget.LoadMoreFooter;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.v3.bean.area.AreaListBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AddressActivity extends BaseActivity {
    public static final int REQUESTCODE = 1;
    private AddressAdapter mAddressAdapter;
    private int mCode;
    private String mId;
    private ListView mListView;
    private LoadMoreFooter mLoadMoreFootView;
    private MultiStateView mMultiStateView;
    private PullRefreshLayout mSwipeRefreshLayout;
    private TitleBar mTitleBar;
    private String mTitleName;
    private TextView mTvErrorTip;
    private boolean mIsEnable = true;
    private List<AreaListBean> mAreaListBeans = new ArrayList();

    static {
        StubApp.interface11(9609);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, String str, String str2, int i) {
        if (activity != null) {
            activity.startActivityForResult(new Intent(activity, (Class<?>) AddressActivity.class).putExtra("id", str).putExtra("title", str2).putExtra("code", i), 1);
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mListView = (ListView) findViewById(R.id.list);
        this.mSwipeRefreshLayout = (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        this.mMultiStateView = (MultiStateView) findViewById(R.id.multiStateView);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(this.mTitleName);
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
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

    private void initView() {
        this.mAddressAdapter = new AddressAdapter();
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: client.android.yixiaotong.v3.ui.area.AddressActivity.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AreaListBean areaListBean = (AreaListBean) adapterView.getAdapter().getItem(i);
                Intent intent = new Intent();
                intent.putExtra("name", areaListBean.name);
                intent.putExtra("id", areaListBean.id);
                intent.putExtra("siteflag", areaListBean.siteFlag);
                AddressActivity addressActivity = AddressActivity.this;
                addressActivity.setResult(addressActivity.mCode, intent);
                AddressActivity.this.finish();
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
        this.mMultiStateView.getView(1).findViewById(R.id.btn_reload).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.area.AddressActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddressActivity.this.mMultiStateView.setViewState(3);
                AddressActivity.this.initRid();
            }
        });
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.v3.ui.area.AddressActivity.3
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                AddressActivity.this.initRid();
            }
        });
        this.mLoadMoreFootView.setUseProgressBar(true);
        this.mLoadMoreFootView.setOnClickLoadMoreListener(new LoadMoreFooter.OnClickLoadMoreListener() { // from class: client.android.yixiaotong.v3.ui.area.AddressActivity.4
            @Override // client.android.yixiaotong.ui.widget.LoadMoreFooter.OnClickLoadMoreListener
            public void onClick() {
                AddressActivity.this.initRid();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initRid() {
        if (this.mCode == 4) {
            getRoomInfo();
        } else {
            getPublicArea();
        }
    }

    private void getPublicArea() {
        V3BusinessControllers.getInstance().getLowerAreas(getLoginAccount(), this.mId, new Listener<List<AreaListBean>>() { // from class: client.android.yixiaotong.v3.ui.area.AddressActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                AddressActivity.this.mSwipeRefreshLayout.setRefreshing(true);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<AreaListBean> list, Object... objArr) {
                if (AddressActivity.this.mIsEnable) {
                    AddressActivity.this.mMultiStateView.setViewState(0);
                    AddressActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    if (list == null || list.size() <= 0) {
                        AddressActivity.this.mMultiStateView.setViewState(2);
                        return;
                    }
                    AddressActivity.this.mAreaListBeans.clear();
                    AddressActivity.this.mAreaListBeans = list;
                    AddressActivity.this.mAddressAdapter.notifyDataSetChanged();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (AddressActivity.this.mIsEnable) {
                    AddressActivity.this.mMultiStateView.setViewState(1);
                    AddressActivity.this.mTvErrorTip.setText(clientException.getDetail());
                    if (clientException.isNeedTip(clientException.getCode())) {
                        AddressActivity.this.mTvErrorTip.setText(clientException.getDetail());
                    } else {
                        AddressActivity.this.onError(clientException);
                    }
                }
            }
        });
    }

    private void getRoomInfo() {
        V3BusinessControllers.getInstance().getDormitoryOrPublicRoom(getLoginAccount(), this.mId, new Listener<List<AreaListBean>>() { // from class: client.android.yixiaotong.v3.ui.area.AddressActivity.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                AddressActivity.this.mSwipeRefreshLayout.setRefreshing(true);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<AreaListBean> list, Object... objArr) {
                if (AddressActivity.this.mIsEnable) {
                    AddressActivity.this.mMultiStateView.setViewState(0);
                    AddressActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    if (list != null) {
                        AddressActivity.this.mAreaListBeans = list;
                        AddressActivity.this.mAddressAdapter.notifyDataSetChanged();
                    } else {
                        AddressActivity.this.mMultiStateView.setViewState(2);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (AddressActivity.this.mIsEnable) {
                    AddressActivity.this.mMultiStateView.setViewState(1);
                    AddressActivity.this.mTvErrorTip.setText(clientException.getDetail());
                    if (clientException.isNeedTip(clientException.getCode())) {
                        AddressActivity.this.mTvErrorTip.setText(clientException.getDetail());
                    } else {
                        AddressActivity.this.onError(clientException);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
        finish();
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
            return AddressActivity.this.mAreaListBeans.size();
        }

        @Override // android.widget.Adapter
        public AreaListBean getItem(int i) {
            return (AreaListBean) AddressActivity.this.mAreaListBeans.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(AddressActivity.this.getContext()).inflate(R.layout.address_item, (ViewGroup) null);
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
