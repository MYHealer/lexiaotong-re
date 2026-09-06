package client.android.yixiaotong.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.gonggaolan.GetAllAnnounceBean;
import client.android.yixiaotong.controller.bean.gonggaolan.GetAllAnnounceListBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.adapter.GongGaoLanInfoAdapter;
import client.android.yixiaotong.ui.h5display.FoodHelpActivity;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class GongGaoLanInfoActivity extends BaseActivity {
    public static final String FOODURL = "http://lexiaotong.cn:8090/page/food.html";
    public static final String PROBLEMURL = "http://lexiaotong.cn:8090/page/problem.html";
    public static final String USERURL = "http://lexiaotong.cn:8090/page/user.html";
    public static final String ZKURL = "http://lexiaotong.cn:8090/page/zk.html";
    private GongGaoLanInfoAdapter adapter;
    private List<GetAllAnnounceBean> mDatas = new ArrayList();
    MultiStateView mMultiStateView;
    PullRefreshLayout mSwipeRefreshLayout;
    TitleBar mTitlebar;
    TextView mTvBluetooth;
    TextView mTvErrorTip;
    TextView mTvFoot;
    TextView mTvQW;
    RecyclerView rvGongGaoLan;

    static {
        StubApp.interface11(5944);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    private void initViewNew() {
        this.mTitlebar = (TitleBar) findViewById(R.id.titlebar);
        this.mTvBluetooth = (TextView) findViewById(R.id.tv_bluetooth);
        this.mTvFoot = (TextView) findViewById(R.id.tv_foot);
        this.mTvQW = (TextView) findViewById(R.id.tv_qw);
        this.rvGongGaoLan = (RecyclerView) findViewById(R.id.rv_ggl);
        this.mMultiStateView = (MultiStateView) findViewById(R.id.multiStateView);
        this.mSwipeRefreshLayout = (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);
    }

    public static void launch(Activity activity) {
        activity.startActivity(new Intent(activity, (Class<?>) GongGaoLanInfoActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getAllListData() {
        BusinessControllers.getInstance().getAllAnnouncement(getLoginAccount(), new Listener<GetAllAnnounceListBean>() { // from class: client.android.yixiaotong.ui.GongGaoLanInfoActivity.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                GongGaoLanInfoActivity.this.mSwipeRefreshLayout.setRefreshing(true);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, GetAllAnnounceListBean getAllAnnounceListBean, Object... objArr) {
                GongGaoLanInfoActivity.this.mMultiStateView.setViewState(0);
                GongGaoLanInfoActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                List<GetAllAnnounceBean> list = getAllAnnounceListBean.list;
                GongGaoLanInfoActivity.this.mDatas.clear();
                GongGaoLanInfoActivity.this.mDatas.addAll(list);
                GongGaoLanInfoActivity.this.initRecyclerView();
                if (getAllAnnounceListBean == null) {
                    GongGaoLanInfoActivity.this.mMultiStateView.setViewState(2);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                ToastUtils.show(GongGaoLanInfoActivity.this.getContext(), clientException.getDetail());
                GongGaoLanInfoActivity.this.mMultiStateView.setViewState(1);
                GongGaoLanInfoActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                GongGaoLanInfoActivity.this.mTvErrorTip.setText(clientException.getDetail());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initRecyclerView() {
        GongGaoLanInfoAdapter gongGaoLanInfoAdapter = new GongGaoLanInfoAdapter(getActivity(), this.mDatas);
        this.adapter = gongGaoLanInfoAdapter;
        this.rvGongGaoLan.setAdapter(gongGaoLanInfoAdapter);
        this.rvGongGaoLan.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
    }

    private void initListener() {
        this.mTvErrorTip = (TextView) this.mMultiStateView.getView(1).findViewById(R.id.tv_errortip);
        this.mMultiStateView.getView(1).findViewById(R.id.btn_reload).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.GongGaoLanInfoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GongGaoLanInfoActivity.this.mMultiStateView.setViewState(3);
                GongGaoLanInfoActivity.this.getAllListData();
            }
        });
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.ui.GongGaoLanInfoActivity.3
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                GongGaoLanInfoActivity.this.getAllListData();
            }
        });
    }

    private void initTitleBar() {
        this.mTitlebar.setTitleView("公告列表");
        this.mTitlebar.setLeftView(R.mipmap.back);
        this.mTitlebar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        this.mTvBluetooth.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.GongGaoLanInfoActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FoodHelpActivity.launch(GongGaoLanInfoActivity.this.getActivity(), GongGaoLanInfoActivity.USERURL);
            }
        });
        this.mTvFoot.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.GongGaoLanInfoActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FoodHelpActivity.launch(GongGaoLanInfoActivity.this.getActivity(), GongGaoLanInfoActivity.FOODURL);
            }
        });
        this.mTvQW.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.GongGaoLanInfoActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FoodHelpActivity.launch(GongGaoLanInfoActivity.this.getActivity(), "http://lexiaotong.cn:8090/page/problem.html");
            }
        });
    }
}
