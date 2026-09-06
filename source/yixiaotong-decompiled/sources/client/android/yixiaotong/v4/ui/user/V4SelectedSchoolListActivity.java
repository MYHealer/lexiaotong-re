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
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.http.bean.V4SchoolInfoBean;
import client.android.yixiaotong.v4.http.bean.V4UserInfoDetailBean;
import client.android.yixiaotong.v4.ui.control.V4MainControl;
import client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil;
import client.android.yixiaotong.v4.util.userinfo.V4UserInfoUtil;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4SelectedSchoolListActivity extends BaseActivity {
    private static final String TAG = "V4SelectedSchoolListActivity";
    private String mCustomerId;
    private RelativeLayout mRelCurrentSchool;
    private SchoolsAdapter mSchoolAdapter;
    private V4SchoolInfoBean mSchoolInfosBean;
    private TitleBar mTitleBar;
    private TextView mTvHistorySchool;
    private TextView mTvNoSchool;
    private TextView mTvSchoolAddress;
    private TextView mTvSchoolName;
    private ListView mlvSchool;
    private int mSchoolInfoIndex = 0;
    private List<V4SchoolInfoBean> mAllSchoolInfos = new ArrayList();
    private List<V4SchoolInfoBean> mSchoolInfos = new ArrayList();
    private boolean mIsEnable = true;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v4.ui.user.V4SelectedSchoolListActivity.5
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            if (i != 1) {
                return;
            }
            V4ChangeSchoolActivity.launch(V4SelectedSchoolListActivity.this.getActivity());
        }
    };

    static {
        StubApp.interface11(11089);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4SelectedSchoolListActivity.class));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mRelCurrentSchool = (RelativeLayout) findViewById(R.id.rel_currentschool);
        this.mTvNoSchool = (TextView) findViewById(R.id.tv_noschool);
        this.mTvHistorySchool = (TextView) findViewById(R.id.tv_historyschool);
        this.mTvSchoolName = (TextView) findViewById(R.id.tv_schoolname);
        this.mTvSchoolAddress = (TextView) findViewById(R.id.tv_schooladdress);
        this.mlvSchool = (ListView) findViewById(R.id.listschool);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getResources().getString(R.string.currentschool));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        SchoolsAdapter schoolsAdapter = new SchoolsAdapter();
        this.mSchoolAdapter = schoolsAdapter;
        this.mlvSchool.setAdapter((ListAdapter) schoolsAdapter);
        this.mlvSchool.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: client.android.yixiaotong.v4.ui.user.V4SelectedSchoolListActivity.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                V4SelectedSchoolListActivity.this.postSwitchCustomer(V4SelectedSchoolListActivity.this.mSchoolAdapter.getItem(i).customerId);
            }
        });
    }

    private void initClickListeners() {
        findViewById(R.id.tv_scanchange).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.user.V4SelectedSchoolListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PermissionUtil.requestPerssion(V4SelectedSchoolListActivity.this.getActivity(), 1, V4SelectedSchoolListActivity.this.permissionGrant);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        this.mSchoolInfos.clear();
        this.mCustomerId = V4UserInfoUtil.getInstance().getLoginAccountV4().customerId;
        List<V4SchoolInfoBean> list = this.mAllSchoolInfos;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i = 0; i < this.mAllSchoolInfos.size(); i++) {
            if (this.mAllSchoolInfos.get(i).customerId.equals(this.mCustomerId)) {
                this.mSchoolInfoIndex = i;
            } else {
                this.mSchoolInfos.add(this.mAllSchoolInfos.get(i));
            }
        }
        this.mSchoolInfosBean = this.mAllSchoolInfos.get(this.mSchoolInfoIndex);
        this.mSchoolAdapter.notifyDataSetChanged();
        V4SchoolInfoBean v4SchoolInfoBean = this.mSchoolInfosBean;
        if (v4SchoolInfoBean != null) {
            String str = v4SchoolInfoBean.customerName;
            String str2 = this.mSchoolInfosBean.address;
            this.mTvSchoolName.setText(str);
            this.mTvSchoolAddress.setText(str2);
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        V4ErrorControlUtil.getInstance().onResume();
        V4MainControl.getInstance().onResume();
        getSchoolInfos();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        V4ErrorControlUtil.getInstance().onPause();
    }

    private void getSchoolInfos() {
        V4BusinessControllers.getInstance().getSchoolInfos(getLoginAccount(), new Listener<List<V4SchoolInfoBean>>() { // from class: client.android.yixiaotong.v4.ui.user.V4SelectedSchoolListActivity.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(V4SelectedSchoolListActivity.this.getActivity(), "获取学校信息...", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<V4SchoolInfoBean> list, Object... objArr) {
                if (V4SelectedSchoolListActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    V4SelectedSchoolListActivity.this.mAllSchoolInfos.clear();
                    V4SelectedSchoolListActivity.this.mAllSchoolInfos.addAll(list);
                    V4SelectedSchoolListActivity.this.loadData();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4SelectedSchoolListActivity.this.mIsEnable) {
                    V4SelectedSchoolListActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postSwitchCustomer(String str) {
        V4BusinessControllers.getInstance().postSwitchCustomer(getLoginAccount(), str, new Listener<V4UserInfoDetailBean>() { // from class: client.android.yixiaotong.v4.ui.user.V4SelectedSchoolListActivity.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(V4SelectedSchoolListActivity.this.getActivity(), "切换学校.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4UserInfoDetailBean v4UserInfoDetailBean, Object... objArr) {
                if (V4SelectedSchoolListActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    V4SelectedSchoolListActivity.this.mCustomerId = v4UserInfoDetailBean.customerId;
                    ToastUtils.show(V4SelectedSchoolListActivity.this.getContext(), "切换学校成功！");
                    V4SelectedSchoolListActivity.this.loadData();
                    V4MainControl.getInstance().getUserInfo(V4SelectedSchoolListActivity.this.getActivity(), V4SelectedSchoolListActivity.this.getLoginAccount());
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4SelectedSchoolListActivity.this.mIsEnable) {
                    V4SelectedSchoolListActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        V4ErrorControlUtil.getInstance().showDialog(clientException, getActivity(), false);
    }

    private class SchoolsAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        private SchoolsAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return V4SelectedSchoolListActivity.this.mSchoolInfos.size();
        }

        @Override // android.widget.Adapter
        public V4SchoolInfoBean getItem(int i) {
            return (V4SchoolInfoBean) V4SelectedSchoolListActivity.this.mSchoolInfos.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(V4SelectedSchoolListActivity.this.getContext()).inflate(R.layout.layout_school_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            V4SchoolInfoBean item = getItem(i);
            if (item != null) {
                viewHolder.name.setText(item.customerName);
                viewHolder.des.setText(item.address);
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
