package client.android.yixiaotong.v3.ui.server;

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
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.v3.bean.login.InvestorInfoBean;
import client.android.yixiaotong.v3.bean.login.InvestorInfosBean;
import client.android.yixiaotong.v3.ui.adv.AdvControl;
import client.android.yixiaotong.v3.ui.control.BindSchoolGiveControl;
import client.android.yixiaotong.v3.ui.control.CashControl;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtil;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ChangeServerActivity extends BaseActivity {
    private static final String TAG = "ChangeServerActivity";
    private int mIndex;
    private InvestorInfoBean mInvestorInfoBean;
    private ServersAdapter mServersAdapter;
    private TitleBar mTitleBar;
    private TextView mTvServerDes;
    private TextView mTvServerName;
    private ListView mlvServer;
    private List<InvestorInfosBean> mAllInvestorInfosBeanList = new ArrayList();
    private List<InvestorInfosBean> mInvestorInfosBeanList = new ArrayList();
    private boolean mIsEnable = true;

    static {
        StubApp.interface11(10217);
    }

    static /* synthetic */ void lambda$initClickListeners$0(View view) {
    }

    static /* synthetic */ void lambda$initClickListeners$1(View view) {
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) ChangeServerActivity.class));
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

    private void initClickListeners() {
        findViewById(R.id.tv_scanchange).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.server.ChangeServerActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChangeServerActivity.lambda$initClickListeners$0(view);
            }
        });
        findViewById(R.id.iv_scanchange).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.server.ChangeServerActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChangeServerActivity.lambda$initClickListeners$1(view);
            }
        });
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mIsEnable = true;
        AdvControl.getInstance().onResume();
        BindSchoolGiveControl.getInstance().onResume();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mIsEnable = false;
        AdvControl.getInstance().onPause();
        BindSchoolGiveControl.getInstance().onPause();
    }

    private void initData() {
        List<InvestorInfosBean> investorInfosV3 = InvestorInfoUtil.getInstance().getInvestorInfosV3();
        this.mAllInvestorInfosBeanList = investorInfosV3;
        if (investorInfosV3 != null && investorInfosV3.size() > 0) {
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
        this.mIndex = InvestorInfoUtil.getInstance().getInvestorInfosIndex();
        this.mInvestorInfosBeanList.clear();
        for (int i = 0; i < this.mAllInvestorInfosBeanList.size(); i++) {
            if (!this.mAllInvestorInfosBeanList.get(i).investorInfo.investorId.equals(this.mAllInvestorInfosBeanList.get(this.mIndex).investorInfo.investorId)) {
                this.mInvestorInfosBeanList.add(this.mAllInvestorInfosBeanList.get(i));
            }
        }
        this.mInvestorInfoBean = this.mAllInvestorInfosBeanList.get(this.mIndex).investorInfo;
        this.mServersAdapter.notifyDataSetChanged();
        this.mTvServerName.setText(this.mInvestorInfoBean.providerJson.providerName);
        this.mTvServerDes.setText(this.mInvestorInfoBean.providerJson.description);
    }

    private void initView() {
        this.mlvServer.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: client.android.yixiaotong.v3.ui.server.ChangeServerActivity.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                LogUtil.e(ChangeServerActivity.TAG, "onItemClick:");
                InvestorInfosBean item = ChangeServerActivity.this.mServersAdapter.getItem(i);
                for (int i2 = 0; i2 < ChangeServerActivity.this.mAllInvestorInfosBeanList.size(); i2++) {
                    if (((InvestorInfosBean) ChangeServerActivity.this.mAllInvestorInfosBeanList.get(i2)).investorInfo.investorId.equals(item.investorInfo.investorId)) {
                        LogUtil.e(ChangeServerActivity.TAG, "saveInvestorInfosIndex:" + i2);
                        InvestorInfoUtil.getInstance().saveInvestorInfosIndex(i2);
                        InvestorInfoUtilControl.getInstance().setInvestorId();
                        CashControl.getInstance().setRedisCash();
                    }
                }
                ChangeServerActivity.this.loadData();
                AdvControl.getInstance().getAdvertising();
                LocalDataUtil.saveIsNeedLoadVersion(ChangeServerActivity.this.getActivity(), 0);
                BindSchoolGiveControl.getInstance().bindSchoolGive();
            }
        });
    }

    private class ServersAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        private ServersAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ChangeServerActivity.this.mInvestorInfosBeanList.size();
        }

        @Override // android.widget.Adapter
        public InvestorInfosBean getItem(int i) {
            return (InvestorInfosBean) ChangeServerActivity.this.mInvestorInfosBeanList.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(ChangeServerActivity.this.getContext()).inflate(R.layout.layout_server_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            InvestorInfosBean item = getItem(i);
            if (item != null) {
                viewHolder.name.setText(item.investorInfo.providerJson.providerName);
                viewHolder.des.setText(item.investorInfo.providerJson.description);
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
