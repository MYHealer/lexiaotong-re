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
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v3.bean.login.SchoolInfoBean;
import client.android.yixiaotong.v3.bean.login.SchoolInfosBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtil;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class SelectedSchoolListActivity extends BaseActivity {
    private static final String TAG = "SelectedSchoolListActivity";
    private List<SchoolInfosBean> mAllSchoolInfos;
    private RelativeLayout mRelCurrentSchool;
    private SchoolsAdapter mSchoolAdapter;
    private SchoolInfosBean mSchoolInfosBean;
    private TitleBar mTitleBar;
    private TextView mTvHistorySchool;
    private TextView mTvNoSchool;
    private TextView mTvSchoolAddress;
    private TextView mTvSchoolName;
    private ListView mlvSchool;
    private int mSchoolInfoIndex = 0;
    private List<SchoolInfosBean> mSchoolInfos = new ArrayList();
    private boolean mIsEnable = true;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v3.ui.server.SelectedSchoolListActivity.4
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            if (i != 1) {
                return;
            }
            ChangeSchoolActivity.launch(SelectedSchoolListActivity.this.getActivity());
        }
    };

    static {
        StubApp.interface11(10237);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) SelectedSchoolListActivity.class));
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

    private void initData() {
        this.mAllSchoolInfos = UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList;
        SchoolsAdapter schoolsAdapter = new SchoolsAdapter();
        this.mSchoolAdapter = schoolsAdapter;
        this.mlvSchool.setAdapter((ListAdapter) schoolsAdapter);
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        this.mSchoolInfoIndex = UserInfoUtil.getInstance().getSchoolInfosIndex();
        this.mSchoolInfos.clear();
        LogUtil.e(TAG, this.mSchoolInfoIndex + "  " + (this.mAllSchoolInfos != null) + "  " + this.mAllSchoolInfos.size());
        List<SchoolInfosBean> list = this.mAllSchoolInfos;
        if (list == null || list.size() <= 0 || this.mAllSchoolInfos.size() <= this.mSchoolInfoIndex) {
            return;
        }
        for (int i = 0; i < this.mAllSchoolInfos.size(); i++) {
            if (this.mAllSchoolInfos.get(i).id != this.mAllSchoolInfos.get(this.mSchoolInfoIndex).id) {
                this.mSchoolInfos.add(this.mAllSchoolInfos.get(i));
            }
        }
        this.mSchoolInfosBean = this.mAllSchoolInfos.get(this.mSchoolInfoIndex);
        this.mSchoolAdapter.notifyDataSetChanged();
        SchoolInfosBean schoolInfosBean = this.mSchoolInfosBean;
        if (schoolInfosBean != null) {
            String str = schoolInfosBean.schoolName;
            String str2 = this.mSchoolInfosBean.schoolAddress;
            this.mTvSchoolName.setText(str);
            this.mTvSchoolAddress.setText(str2);
        }
    }

    private void initView() {
        this.mlvSchool.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: client.android.yixiaotong.v3.ui.server.SelectedSchoolListActivity.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                SchoolInfosBean item = SelectedSchoolListActivity.this.mSchoolAdapter.getItem(i);
                for (int i2 = 0; i2 < SelectedSchoolListActivity.this.mAllSchoolInfos.size(); i2++) {
                    if (((SchoolInfosBean) SelectedSchoolListActivity.this.mAllSchoolInfos.get(i2)).id == item.id) {
                        UserInfoUtil.getInstance().saveSchoolInfosIndex(i2);
                        InvestorInfoUtil.getInstance().saveInvestorInfosIndex(0);
                        LocalDataUtil.saveIsNeedLoadInvestorInfo(SelectedSchoolListActivity.this.getContext(), true);
                    }
                }
                SelectedSchoolListActivity.this.loadData();
                LocalDataUtil.saveIsNeedLoadVersion(SelectedSchoolListActivity.this.getActivity(), 1);
            }
        });
    }

    private void initClickListeners() {
        findViewById(R.id.tv_scanchange).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.server.SelectedSchoolListActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m421x305230bf(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-server-SelectedSchoolListActivity, reason: not valid java name */
    /* synthetic */ void m421x305230bf(View view) {
        PermissionUtil.requestPerssion(getActivity(), 1, this.permissionGrant);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        if (LocalDataUtil.isNeedLoadUserInfos(getContext())) {
            getSchoolIdInfo();
        } else {
            initData();
            initView();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
    }

    private void getSchoolIdInfo() {
        V3BusinessControllers.getInstance().getSchoolInfo(getLoginAccount(), new Listener<SchoolInfoBean>() { // from class: client.android.yixiaotong.v3.ui.server.SelectedSchoolListActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(SelectedSchoolListActivity.this.getActivity(), "获取账户信息..", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SchoolInfoBean schoolInfoBean, Object... objArr) {
                if (SelectedSchoolListActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    SelectedSchoolListActivity.this.getSchoolInfos();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (SelectedSchoolListActivity.this.mIsEnable) {
                    SelectedSchoolListActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getSchoolInfos() {
        List<String> list = UserInfoUtil.getInstance().getLoginAccountV3().schoolList;
        if (list != null && list.size() > 0) {
            this.mRelCurrentSchool.setVisibility(0);
            this.mTvNoSchool.setVisibility(8);
            this.mTvHistorySchool.setVisibility(0);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i) + ",");
            }
            V3BusinessControllers.getInstance().getSchoolInfos(getLoginAccount(), sb.substring(0, sb.length() - 1), false, new Listener<List<SchoolInfosBean>>() { // from class: client.android.yixiaotong.v3.ui.server.SelectedSchoolListActivity.3
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    BaseMaterialDialog.showMaterialDialog(SelectedSchoolListActivity.this.getActivity(), "获取账户信息...", false);
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, List<SchoolInfosBean> list2, Object... objArr) {
                    if (SelectedSchoolListActivity.this.mIsEnable) {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        UserInfoUtil.getInstance().saveSchoolInfosV3(list2);
                        String bindSchoolId = UserInfoUtil.getInstance().getBindSchoolId();
                        for (int i2 = 0; i2 < list2.size(); i2++) {
                            if ((list2.get(i2).id + "").equals(bindSchoolId)) {
                                UserInfoUtil.getInstance().saveSchoolInfosIndex(i2);
                                InvestorInfoUtil.getInstance().saveInvestorInfosIndex(0);
                                LocalDataUtil.saveIsNeedLoadInvestorInfo(SelectedSchoolListActivity.this.getContext(), true);
                            }
                        }
                        LocalDataUtil.saveIsNeedLoadUserInfo(SelectedSchoolListActivity.this.getContext(), false);
                        UserInfoUtil.getInstance().saveBindSchoolId("");
                        SelectedSchoolListActivity.this.mAllSchoolInfos = UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList;
                        SelectedSchoolListActivity.this.loadData();
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (SelectedSchoolListActivity.this.mIsEnable) {
                        SelectedSchoolListActivity.this.onError(clientException);
                    }
                }
            });
            return;
        }
        this.mRelCurrentSchool.setVisibility(8);
        this.mTvNoSchool.setVisibility(0);
        this.mTvHistorySchool.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), clientException.getDetail());
        } else {
            V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
        }
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
            return SelectedSchoolListActivity.this.mSchoolInfos.size();
        }

        @Override // android.widget.Adapter
        public SchoolInfosBean getItem(int i) {
            return (SchoolInfosBean) SelectedSchoolListActivity.this.mSchoolInfos.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(SelectedSchoolListActivity.this.getContext()).inflate(R.layout.layout_school_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            SchoolInfosBean item = getItem(i);
            if (item != null) {
                viewHolder.name.setText(item.schoolName);
                viewHolder.des.setText(item.schoolAddress);
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
