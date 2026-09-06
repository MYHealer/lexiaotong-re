package client.android.yixiaotong.v4.ui.area;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
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
import client.android.yixiaotong.util.ClickUtils;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.http.bean.V4AreaBean;
import client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil;
import client.android.yixiaotong.v4.util.V4Util;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4AddressActivity extends BaseActivity {
    public static final int REQUESTCODE = 1;
    private AddressAdapter mAddressAdapter;
    private int mCode;
    EditText mEtSearchName;
    private String mId;
    ListView mListView;
    private LoadMoreFooter mLoadMoreFootView;
    MultiStateView mMultiStateView;
    PullRefreshLayout mSwipeRefreshLayout;
    TitleBar mTitleBar;
    private String mTitleName;
    private TextView mTvErrorTip;
    private boolean mIsEnable = true;
    private List<V4AreaBean> mAreaListBeans = new ArrayList();
    private List<V4AreaBean> mAreaListSearchBeans = new ArrayList();

    static {
        StubApp.interface11(10834);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, String str, String str2, int i) {
        if (activity != null) {
            activity.startActivityForResult(new Intent(activity, (Class<?>) V4AddressActivity.class).putExtra("id", str).putExtra("title", str2).putExtra("code", i), 1);
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mListView = (ListView) findViewById(R.id.list);
        this.mEtSearchName = (EditText) findViewById(R.id.et_name);
        this.mSwipeRefreshLayout = (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        this.mMultiStateView = (MultiStateView) findViewById(R.id.multiStateView);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(this.mTitleName);
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
        findViewById(R.id.btn_search).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.area.V4AddressActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ClickUtils.isFastDoubleClick()) {
                    return;
                }
                if (StringUtils.isEmpty(V4AddressActivity.this.mEtSearchName.getText().toString())) {
                    ToastUtils.show(V4AddressActivity.this.getActivity(), "请输入关键字");
                }
                if (V4AddressActivity.this.mAreaListBeans.size() == 0) {
                    ToastUtils.show(V4AddressActivity.this.getActivity(), "搜索失败");
                }
                V4AddressActivity.this.getSearchResult();
            }
        });
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        V4ErrorControlUtil.getInstance().onResume();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        V4ErrorControlUtil.getInstance().onPause();
    }

    private void initView() {
        this.mAddressAdapter = new AddressAdapter();
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: client.android.yixiaotong.v4.ui.area.V4AddressActivity.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                V4AreaBean v4AreaBean = (V4AreaBean) adapterView.getAdapter().getItem(i);
                Intent intent = new Intent();
                intent.putExtra("name", v4AreaBean.name);
                intent.putExtra("id", v4AreaBean.id);
                V4AddressActivity v4AddressActivity = V4AddressActivity.this;
                v4AddressActivity.setResult(v4AddressActivity.mCode, intent);
                V4AddressActivity.this.finish();
            }
        });
        this.mListView.setAdapter((ListAdapter) this.mAddressAdapter);
        this.mEtSearchName.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.v4.ui.area.V4AddressActivity.3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                V4AddressActivity.this.getSearchResult();
            }
        });
    }

    private void initFooterView() {
        LoadMoreFooter loadMoreFooter = new LoadMoreFooter(getContext());
        this.mLoadMoreFootView = loadMoreFooter;
        this.mListView.addFooterView(loadMoreFooter);
        this.mListView.setFooterDividersEnabled(false);
        this.mLoadMoreFootView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getSearchResult() {
        this.mAreaListSearchBeans = V4Util.getSearchAddressResult(this.mAreaListBeans, this.mEtSearchName.getText().toString());
        this.mAddressAdapter.notifyDataSetChanged();
    }

    private void initListener() {
        this.mTvErrorTip = (TextView) this.mMultiStateView.getView(1).findViewById(R.id.tv_errortip);
        this.mMultiStateView.getView(1).findViewById(R.id.btn_reload).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.area.V4AddressActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                V4AddressActivity.this.mMultiStateView.setViewState(3);
                V4AddressActivity.this.getArea();
            }
        });
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.v4.ui.area.V4AddressActivity.5
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                V4AddressActivity.this.getArea();
            }
        });
        this.mLoadMoreFootView.setUseProgressBar(true);
        this.mLoadMoreFootView.setOnClickLoadMoreListener(new LoadMoreFooter.OnClickLoadMoreListener() { // from class: client.android.yixiaotong.v4.ui.area.V4AddressActivity.6
            @Override // client.android.yixiaotong.ui.widget.LoadMoreFooter.OnClickLoadMoreListener
            public void onClick() {
                V4AddressActivity.this.getArea();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getArea() {
        V4BusinessControllers.getInstance().getAreaList(getLoginAccount(), this.mId, new Listener<List<V4AreaBean>>() { // from class: client.android.yixiaotong.v4.ui.area.V4AddressActivity.7
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                V4AddressActivity.this.mSwipeRefreshLayout.setRefreshing(true);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<V4AreaBean> list, Object... objArr) {
                if (V4AddressActivity.this.mIsEnable) {
                    V4AddressActivity.this.mMultiStateView.setViewState(0);
                    V4AddressActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    if (list != null && list.size() > 0) {
                        V4AddressActivity.this.mAreaListBeans.clear();
                        V4AddressActivity.this.mAreaListBeans = list;
                        V4AddressActivity.this.getSearchResult();
                        return;
                    }
                    V4AddressActivity.this.mMultiStateView.setViewState(2);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4AddressActivity.this.mIsEnable) {
                    V4AddressActivity.this.mMultiStateView.setViewState(1);
                    V4AddressActivity.this.mTvErrorTip.setText(clientException.getDetail());
                    if (clientException.isNeedTip(clientException.getCode())) {
                        V4AddressActivity.this.mTvErrorTip.setText(clientException.getDetail());
                    } else {
                        V4AddressActivity.this.onError(clientException);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        V4ErrorControlUtil.getInstance().showDialog(clientException, getActivity(), false);
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
            return V4AddressActivity.this.mAreaListSearchBeans.size();
        }

        @Override // android.widget.Adapter
        public V4AreaBean getItem(int i) {
            return (V4AreaBean) V4AddressActivity.this.mAreaListSearchBeans.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(V4AddressActivity.this.getContext()).inflate(R.layout.address_item, (ViewGroup) null);
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
