package client.android.yixiaotong.v3.ui.announcement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.bean.gonggaolan.GetAllAnnounceBean;
import client.android.yixiaotong.controller.bean.gonggaolan.GetAllAnnounceListBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.adapter.GongGaoLanInfoAdapter;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AnnouncementInfoActivity extends BaseActivity {
    private static final String TAG = "AnnouncementInfoActivity";
    private GongGaoLanInfoAdapter adapter;
    private List<GetAllAnnounceBean> mDatas = new ArrayList();
    private boolean mIsEnable = true;
    private MultiStateView mMultiStateView;
    private PullRefreshLayout mSwipeRefreshLayout;
    private TitleBar mTitlebar;
    TextView mTvErrorTip;
    private RecyclerView rvGongGaoLan;

    static {
        StubApp.interface11(8995);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    private void initViewNew() {
        this.mTitlebar = (TitleBar) findViewById(R.id.titlebar);
        this.rvGongGaoLan = (RecyclerView) findViewById(R.id.rv_ggl);
        this.mMultiStateView = (MultiStateView) findViewById(R.id.multiStateView);
        this.mSwipeRefreshLayout = (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);
    }

    public static void launch(Activity activity) {
        activity.startActivity(new Intent(activity, (Class<?>) AnnouncementInfoActivity.class));
    }

    private void initTitleBar() {
        this.mTitlebar.setTitleView(getString(R.string.announcementlist));
        this.mTitlebar.setLeftView(R.mipmap.back);
        this.mTitlebar.setLeftViewOnClickBack(getActivity());
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

    /* JADX INFO: Access modifiers changed from: private */
    public void getAllListData() {
        if (StringUtils.isNotEmpty(LocalDataUtil.getLastTokenInfo(getActivity()))) {
            V3BusinessControllers.getInstance().getAllAnnouncementV3(getLoginAccount(), UserInfoUtil.getInstance().getLoginAccountV3().schoolList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()), InvestorInfoUtilControl.getInstance().getInvestorId(), new Listener<GetAllAnnounceListBean>() { // from class: client.android.yixiaotong.v3.ui.announcement.AnnouncementInfoActivity.1
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    AnnouncementInfoActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, GetAllAnnounceListBean getAllAnnounceListBean, Object... objArr) {
                    if (AnnouncementInfoActivity.this.mIsEnable) {
                        AnnouncementInfoActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                        if (getAllAnnounceListBean == null || getAllAnnounceListBean.list == null || getAllAnnounceListBean.list.size() <= 0) {
                            AnnouncementInfoActivity.this.mMultiStateView.setViewState(2);
                            return;
                        }
                        AnnouncementInfoActivity.this.mMultiStateView.setViewState(0);
                        List<GetAllAnnounceBean> list = getAllAnnounceListBean.list;
                        AnnouncementInfoActivity.this.mDatas.clear();
                        AnnouncementInfoActivity.this.mDatas.addAll(list);
                        LogUtil.e(AnnouncementInfoActivity.TAG, "getAllListData:" + list.size());
                        AnnouncementInfoActivity.this.initRecyclerView();
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    ToastUtils.show(AnnouncementInfoActivity.this.getContext(), clientException.getDetail());
                    AnnouncementInfoActivity.this.mMultiStateView.setViewState(1);
                    AnnouncementInfoActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    AnnouncementInfoActivity.this.mTvErrorTip.setText(clientException.getDetail());
                }
            });
            return;
        }
        this.mMultiStateView.setViewState(2);
        this.mSwipeRefreshLayout.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initRecyclerView() {
        GongGaoLanInfoAdapter gongGaoLanInfoAdapter = new GongGaoLanInfoAdapter(getActivity(), this.mDatas);
        this.adapter = gongGaoLanInfoAdapter;
        gongGaoLanInfoAdapter.setAppV3();
        this.rvGongGaoLan.setAdapter(this.adapter);
        this.rvGongGaoLan.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
    }

    private void initListener() {
        this.mTvErrorTip = (TextView) this.mMultiStateView.getView(1).findViewById(R.id.tv_errortip);
        this.mMultiStateView.getView(1).findViewById(R.id.btn_reload).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.announcement.AnnouncementInfoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AnnouncementInfoActivity.this.mMultiStateView.setViewState(3);
                AnnouncementInfoActivity.this.getAllListData();
            }
        });
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.v3.ui.announcement.AnnouncementInfoActivity.3
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                AnnouncementInfoActivity.this.getAllListData();
            }
        });
    }
}
