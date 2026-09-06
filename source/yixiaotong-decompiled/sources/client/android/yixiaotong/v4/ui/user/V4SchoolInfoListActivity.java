package client.android.yixiaotong.v4.ui.user;

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
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.LoadMoreFooter;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.v3.bean.login.SchoolInfosBean;
import client.android.yixiaotong.v3.ui.server.SchoolQrcodeActivity;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4SchoolInfoListActivity extends BaseActivity {
    private static final String TAG = "V4SchoolInfoListActivity";
    private ListView mListView;
    private LoadMoreFooter mLoadMoreFootView;
    private MultiStateView mMultiStateView;
    private SchoolListAdapter mSchoolListAdapter;
    private PullRefreshLayout mSwipeRefreshLayout;
    private TitleBar mTitleBar;
    private TextView mTvErrorTip;
    private boolean mIsEnable = true;
    private List<SchoolInfosBean> mSchoolInfosBeans = new ArrayList();

    static {
        StubApp.interface11(11063);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getSchoolListInfo() {
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4SchoolInfoListActivity.class));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mListView = (ListView) findViewById(R.id.list);
        this.mSwipeRefreshLayout = (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        this.mMultiStateView = (MultiStateView) findViewById(R.id.multiStateView);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.schoolqrcode));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        SchoolListAdapter schoolListAdapter = new SchoolListAdapter();
        this.mSchoolListAdapter = schoolListAdapter;
        this.mListView.setAdapter((ListAdapter) schoolListAdapter);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: client.android.yixiaotong.v4.ui.user.V4SchoolInfoListActivity.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (ClickUtil.isFastDoubleClick()) {
                    return;
                }
                SchoolInfosBean item = V4SchoolInfoListActivity.this.mSchoolListAdapter.getItem(i);
                SchoolQrcodeActivity.launch(V4SchoolInfoListActivity.this.getActivity(), item.id + "", item.schoolName);
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

    private void initListener() {
        this.mTvErrorTip = (TextView) this.mMultiStateView.getView(1).findViewById(R.id.tv_errortip);
        this.mMultiStateView.getView(1).findViewById(R.id.btn_reload).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.user.V4SchoolInfoListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                V4SchoolInfoListActivity.this.mMultiStateView.setViewState(3);
                V4SchoolInfoListActivity.this.getSchoolListInfo();
            }
        });
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.v4.ui.user.V4SchoolInfoListActivity.3
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                V4SchoolInfoListActivity.this.getSchoolListInfo();
            }
        });
        this.mLoadMoreFootView.setUseProgressBar(true);
        this.mLoadMoreFootView.setOnClickLoadMoreListener(new LoadMoreFooter.OnClickLoadMoreListener() { // from class: client.android.yixiaotong.v4.ui.user.V4SchoolInfoListActivity.4
            @Override // client.android.yixiaotong.ui.widget.LoadMoreFooter.OnClickLoadMoreListener
            public void onClick() {
                V4SchoolInfoListActivity.this.getSchoolListInfo();
            }
        });
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

    private class SchoolListAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        private SchoolListAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return V4SchoolInfoListActivity.this.mSchoolInfosBeans.size();
        }

        @Override // android.widget.Adapter
        public SchoolInfosBean getItem(int i) {
            return (SchoolInfosBean) V4SchoolInfoListActivity.this.mSchoolInfosBeans.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(V4SchoolInfoListActivity.this.getContext()).inflate(R.layout.layout_schoollist_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            SchoolInfosBean item = getItem(i);
            viewHolder.tv_schoolname.setText(item.schoolName);
            viewHolder.tv_schooladdress.setText(item.schoolAddress);
            return view;
        }

        class ViewHolder {
            public ImageView iv_qrcode;
            public RelativeLayout rel_qrcode;
            public TextView tv_schooladdress;
            public TextView tv_schoolname;

            public ViewHolder(View view) {
                this.rel_qrcode = (RelativeLayout) view.findViewById(R.id.rel_qrcode);
                this.tv_schoolname = (TextView) view.findViewById(R.id.tv_schoolname);
                this.tv_schooladdress = (TextView) view.findViewById(R.id.tv_schooladdress);
                this.iv_qrcode = (ImageView) view.findViewById(R.id.iv_qrcode);
            }
        }
    }
}
