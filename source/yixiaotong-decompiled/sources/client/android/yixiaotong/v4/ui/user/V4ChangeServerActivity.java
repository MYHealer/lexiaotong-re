package client.android.yixiaotong.v4.ui.user;

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
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.http.bean.V4ServerListBean;
import client.android.yixiaotong.v4.http.bean.V4UserInfoDetailBean;
import client.android.yixiaotong.v4.ui.control.V4MainControl;
import client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil;
import client.android.yixiaotong.v4.util.userinfo.V4UserInfoUtil;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4ChangeServerActivity extends BaseActivity {
    private static final String TAG = "V4ChangeServerActivity";
    private String mCurrentServerId;
    private int mIndex;
    private V4ServerListBean mInvestorInfoBean;
    private ServersAdapter mServersAdapter;
    private TitleBar mTitleBar;
    private TextView mTvServerDes;
    private TextView mTvServerName;
    private ListView mlvServer;
    private List<V4ServerListBean> mAllInvestorInfosBeanList = new ArrayList();
    private List<V4ServerListBean> mInvestorInfosBeanList = new ArrayList();
    private boolean mIsEnable = true;

    static {
        StubApp.interface11(11048);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4ChangeServerActivity.class));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTvServerName = (TextView) findViewById(R.id.tv_servername);
        this.mTvServerDes = (TextView) findViewById(R.id.tv_serverdes);
        this.mlvServer = (ListView) findViewById(R.id.listserver);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.listofproviders));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mIsEnable = true;
        V4ErrorControlUtil.getInstance().onResume();
        V4MainControl.getInstance().onResume();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mIsEnable = false;
        V4ErrorControlUtil.getInstance().onPause();
    }

    private void initData() {
        this.mCurrentServerId = V4UserInfoUtil.getInstance().getLoginAccountV4().projectId;
        List<V4ServerListBean> list = V4UserInfoUtil.getInstance().getLoginAccountV4().serverInfoList;
        this.mAllInvestorInfosBeanList = list;
        if (list != null && list.size() > 0) {
            ServersAdapter serversAdapter = new ServersAdapter();
            this.mServersAdapter = serversAdapter;
            this.mlvServer.setAdapter((ListAdapter) serversAdapter);
            loadData();
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        LogUtil.e(TAG, "loadData:" + this.mCurrentServerId);
        this.mInvestorInfosBeanList.clear();
        for (int i = 0; i < this.mAllInvestorInfosBeanList.size(); i++) {
            LogUtil.e(TAG, "loadData:" + this.mAllInvestorInfosBeanList.get(i).projectId);
            if (this.mAllInvestorInfosBeanList.get(i).projectId.equals(this.mCurrentServerId)) {
                this.mIndex = i;
            } else {
                this.mInvestorInfosBeanList.add(this.mAllInvestorInfosBeanList.get(i));
            }
        }
        this.mInvestorInfoBean = this.mAllInvestorInfosBeanList.get(this.mIndex);
        this.mServersAdapter.notifyDataSetChanged();
        this.mTvServerName.setText(this.mInvestorInfoBean.serviceName);
        this.mTvServerDes.setText("");
    }

    private void initView() {
        this.mlvServer.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: client.android.yixiaotong.v4.ui.user.V4ChangeServerActivity.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                LogUtil.e(V4ChangeServerActivity.TAG, "onItemClick:");
                V4ChangeServerActivity.this.postSwitchProject(V4ChangeServerActivity.this.mServersAdapter.getItem(i).projectId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postSwitchProject(String str) {
        V4BusinessControllers.getInstance().postSwitchProject(getLoginAccount(), str, new Listener<V4UserInfoDetailBean>() { // from class: client.android.yixiaotong.v4.ui.user.V4ChangeServerActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(V4ChangeServerActivity.this.getActivity(), "切换服务商.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4UserInfoDetailBean v4UserInfoDetailBean, Object... objArr) {
                if (V4ChangeServerActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(V4ChangeServerActivity.this.getContext(), "切换服务商成功！");
                    V4ChangeServerActivity.this.mCurrentServerId = V4UserInfoUtil.getInstance().getLoginAccountV4().projectId;
                    V4ChangeServerActivity.this.loadData();
                    V4MainControl.getInstance().getUserInfo(V4ChangeServerActivity.this.getActivity(), V4ChangeServerActivity.this.getLoginAccount());
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4ChangeServerActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    V4ErrorControlUtil.getInstance().showDialog(clientException, V4ChangeServerActivity.this.getActivity(), false);
                }
            }
        });
    }

    private class ServersAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        private ServersAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return V4ChangeServerActivity.this.mInvestorInfosBeanList.size();
        }

        @Override // android.widget.Adapter
        public V4ServerListBean getItem(int i) {
            return (V4ServerListBean) V4ChangeServerActivity.this.mInvestorInfosBeanList.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(V4ChangeServerActivity.this.getContext()).inflate(R.layout.layout_server_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            V4ServerListBean item = getItem(i);
            if (item != null) {
                viewHolder.name.setText(item.serviceName);
                viewHolder.des.setText("");
            }
            return view;
        }

        class ViewHolder {
            public TextView des;
            public TextView name;

            public ViewHolder(View view) {
                this.name = (TextView) view.findViewById(R.id.tv_servername);
                this.des = (TextView) view.findViewById(R.id.tv_serverdes);
            }
        }
    }
}
