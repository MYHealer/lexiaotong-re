package client.android.yixiaotong.v4.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseXFragment;
import client.android.yixiaotong.R;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.MyPagerGalleryView;
import client.android.yixiaotong.ui.widget.WrapGridView;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.android.NetworkUtils;
import client.android.yixiaotong.v3.bean.UIVisableBean;
import client.android.yixiaotong.v3.bean.login.UseSoftwareProductBean;
import client.android.yixiaotong.v3.ui.MainListener;
import client.android.yixiaotong.v3.ui.adv.AdvControlUtil;
import client.android.yixiaotong.v3.ui.adv.Common;
import client.android.yixiaotong.v3.ui.adv.NativeUtil;
import client.android.yixiaotong.v3.ui.adv.ShouYeInsertUtil;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.http.bean.V4HomeInfoBean;
import client.android.yixiaotong.v4.ui.adapter.ShouYeGridAdapter;
import client.android.yixiaotong.v4.ui.app.bath.V4BathControlActivity;
import client.android.yixiaotong.v4.ui.app.drink.V4DrinkWaterControlActivity;
import client.android.yixiaotong.v4.ui.control.V4MainControl;
import client.android.yixiaotong.v4.ui.notice.V4AnnouncementDetailActivity;
import client.android.yixiaotong.v4.ui.user.V4SelectedSchoolListActivity;
import client.android.yixiaotong.v4.util.V4LocalDataUtil;
import client.android.yixiaotong.v4.util.homeinfo.V4HomeInfoUtil;
import client.android.yixiaotong.v4.util.projectconfig.V4ProjectConfigInfoUtil;
import client.android.yixiaotong.v4.util.userinfo.V4UserInfoBean;
import client.android.yixiaotong.v4.util.userinfo.V4UserInfoUtil;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.huawei.openalliance.ad.views.PPSLabelView;
import de.greenrobot.event.EventBus;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4MainFragment extends BaseXFragment {
    public static final String TAG = "V4MainFragment";
    private RelativeLayout flContainer;
    private Activity mActivity;
    private AdvControlUtil.AdvListener mAdvListener;
    private WrapGridView mGvApp;
    private ImageView mImgNotice;
    private MainListener mMainListener;
    private NativeUtil mNativeUtil;
    private MyPagerGalleryView mNoticePagerGalleryView;
    private LinearLayout mOvalLayout;
    private ShouYeGridAdapter mShouYeGridAdapter;
    private PullRefreshLayout mSwipeRefreshLayout;
    private TextView mTvSchoolName;
    private boolean mIsEnable = true;
    private List<V4HomeInfoBean> mAppDatas = new ArrayList();
    private boolean mIsVisable = true;
    private boolean mIsShowAdvNative = false;
    private boolean mIsShowAdvInsert = false;

    public void setMainListener(MainListener mainListener) {
        this.mMainListener = mainListener;
    }

    private void initViewNew(View view) {
        this.mSwipeRefreshLayout = (PullRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        this.mTvSchoolName = (TextView) view.findViewById(R.id.tv_schoolname);
        this.mImgNotice = (ImageView) view.findViewById(R.id.iv_loading);
        this.mNoticePagerGalleryView = (MyPagerGalleryView) view.findViewById(R.id.adgallery);
        this.mOvalLayout = (LinearLayout) view.findViewById(R.id.ovalLayout1);
        this.mGvApp = (WrapGridView) view.findViewById(R.id.gv_app);
        this.flContainer = (RelativeLayout) view.findViewById(R.id.rl_native);
    }

    public static V4MainFragment newInstance() {
        return new V4MainFragment();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (Activity) context;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_v4_main, (ViewGroup) null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        LogUtil.e(TAG, "onViewCreated:" + (this.mActivity == null));
        initViewNew(view);
        initClickListeners(view);
        initView();
        EventBus.getDefault().register(this);
        initListener();
        LogUtil.e(TAG, "handlerOnCreate:");
        loadData();
        V4MainControl.getInstance().setListener(new V4MainControl.OnListener() { // from class: client.android.yixiaotong.v4.ui.V4MainFragment.1
            @Override // client.android.yixiaotong.v4.ui.control.V4MainControl.OnListener
            public void onHome() {
                if (V4MainFragment.this.mSwipeRefreshLayout != null) {
                    V4MainFragment.this.mSwipeRefreshLayout.setRefreshing(false);
                }
                V4MainFragment.this.initViewValue();
                V4MainFragment.this.loadData();
            }

            @Override // client.android.yixiaotong.v4.ui.control.V4MainControl.OnListener
            public void onProjectConfig() {
                if (V4MainFragment.this.mIsVisable) {
                    V4MainFragment.this.mAppDatas.clear();
                    V4MainFragment.this.mAppDatas = V4HomeInfoUtil.getInstance().getAppList(V4MainFragment.this.getActivity());
                    V4MainFragment.this.mShouYeGridAdapter.setData(V4MainFragment.this.mAppDatas);
                    V4MainFragment.this.mShouYeGridAdapter.notifyDataSetChanged();
                    V4MainControl.getInstance().isNeedSignZKT(V4MainFragment.this.getActivity(), V4MainFragment.this.getLoginAccount());
                }
            }

            @Override // client.android.yixiaotong.v4.ui.control.V4MainControl.OnListener
            public void onError(ClientException clientException) {
                if (V4MainFragment.this.mSwipeRefreshLayout != null) {
                    V4MainFragment.this.mSwipeRefreshLayout.setRefreshing(false);
                }
            }
        });
        V4MainControl.getInstance().getUserInfo(getActivity(), getLoginAccount());
        this.mIsVisable = true;
        initAdv();
    }

    private void initListener() {
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.v4.ui.V4MainFragment.2
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                V4MainControl.getInstance().getUserInfo(V4MainFragment.this.getActivity(), V4MainFragment.this.getLoginAccount());
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // client.android.yixiaotong.BaseXFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mIsEnable = true;
        initViewValue();
        LogUtil.e(TAG, "onResume  " + this.mIsVisable);
        V4MainControl.getInstance().onResume();
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onResume();
        }
        if (V4LocalDataUtil.getIsNeedLoadZKTTip(getActivity())) {
            V4MainControl.getInstance().isNeedSignZKT(getActivity(), getLoginAccount());
        }
        loadData();
        loadAdv();
    }

    @Override // client.android.yixiaotong.BaseXFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mIsEnable = false;
        LogUtil.e(TAG, "onPause");
        BaseMaterialDialog.dissmisMaterialDialog();
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onPause();
        }
        ShouYeInsertUtil.getInstance().onPause();
        V4MainControl.getInstance().onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onDestroy();
        }
        ShouYeInsertUtil.getInstance().onDestroy(this.mActivity);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    public void onEventMainThread(UIVisableBean uIVisableBean) {
        LogUtil.e(TAG, "onEventMainThread:UIVisableBean:" + uIVisableBean.index);
        if (uIVisableBean.index == 1) {
            this.mIsVisable = true;
        } else {
            this.mIsVisable = false;
        }
    }

    private void initClickListeners(View view) {
        view.findViewById(R.id.rel_selectschool).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.V4MainFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m444xffacf4cf(view2);
            }
        });
        view.findViewById(R.id.img_scan).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.V4MainFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m445x397796ae(view2);
            }
        });
        view.findViewById(R.id.img_quickbindcard).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.V4MainFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ClickUtil.isFastDoubleClick();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v4-ui-V4MainFragment, reason: not valid java name */
    /* synthetic */ void m444xffacf4cf(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        V4SelectedSchoolListActivity.launch(getActivity());
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v4-ui-V4MainFragment, reason: not valid java name */
    /* synthetic */ void m445x397796ae(View view) {
        if (ClickUtil.isFastDoubleClick() || NetworkUtils.isNetworkAvailable(getActivity())) {
            return;
        }
        ToastUtils.show(getActivity(), "请打开网络后重试");
    }

    private void initView() {
        ShouYeGridAdapter shouYeGridAdapter = new ShouYeGridAdapter(getActivity(), this.mAppDatas);
        this.mShouYeGridAdapter = shouYeGridAdapter;
        shouYeGridAdapter.setOnItemClick(new ShouYeGridAdapter.OnClickItemListener() { // from class: client.android.yixiaotong.v4.ui.V4MainFragment.3
            @Override // client.android.yixiaotong.v4.ui.adapter.ShouYeGridAdapter.OnClickItemListener
            public void onClick(int i) {
                V4MainFragment v4MainFragment = V4MainFragment.this;
                v4MainFragment.gridViewOnClick((V4HomeInfoBean) v4MainFragment.mAppDatas.get(i));
            }
        });
        this.mGvApp.setAdapter((ListAdapter) this.mShouYeGridAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewValue() {
        V4UserInfoBean loginAccountV4 = V4UserInfoUtil.getInstance().getLoginAccountV4();
        if (loginAccountV4 != null) {
            this.mTvSchoolName.setText(loginAccountV4.customerName);
            saveSchoolName(loginAccountV4.customerName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridViewOnClick(V4HomeInfoBean v4HomeInfoBean) {
        if (!NetworkUtils.isNetworkAvailable(getActivity())) {
            ToastUtils.show(getActivity(), "请打开网络后重试");
            return;
        }
        if (isEnableAndroid() && V4ProjectConfigInfoUtil.getInstance().isEnableUse(getActivity())) {
            if (v4HomeInfoBean.productId == 1) {
                V4BathControlActivity.launch(getActivity(), v4HomeInfoBean);
                return;
            }
            if (v4HomeInfoBean.productId == 2 || v4HomeInfoBean.productId == 3 || v4HomeInfoBean.productId == 4 || v4HomeInfoBean.productId == 11) {
                V4DrinkWaterControlActivity.launch(getActivity(), v4HomeInfoBean);
            } else if (v4HomeInfoBean.productId == 12 || v4HomeInfoBean.productId == 6 || v4HomeInfoBean.productId == 17) {
                V4MainControl.getInstance().selectElecMeterInfo(getActivity(), getLoginAccount(), v4HomeInfoBean.productId);
            } else {
                ToastUtils.show(getContext(), "暂未开通");
            }
        }
    }

    private boolean isEnableAndroid() {
        UseSoftwareProductBean useSoftwareProductBeanIsUseAndroid = V4ProjectConfigInfoUtil.getInstance().isUseAndroid();
        if (useSoftwareProductBeanIsUseAndroid.isUse) {
            return true;
        }
        SystemErrorTip.getInstance().showTipDialog(getActivity(), useSoftwareProductBeanIsUseAndroid.msg);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        this.mAppDatas.clear();
        List<V4HomeInfoBean> appList = V4HomeInfoUtil.getInstance().getAppList(getActivity());
        this.mAppDatas = appList;
        this.mShouYeGridAdapter.setData(appList);
        this.mShouYeGridAdapter.notifyDataSetChanged();
        final V4HomeInfoBean homeInfoV4 = V4HomeInfoUtil.getInstance().getHomeInfoV4();
        if (homeInfoV4 != null && homeInfoV4.noticeList != null && homeInfoV4.noticeList.size() > 0) {
            this.mImgNotice.setVisibility(8);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < homeInfoV4.noticeList.size(); i++) {
                arrayList.add(homeInfoV4.noticeList.get(i).picUrl);
            }
            String[] strArr = (String[]) arrayList.toArray(new String[0]);
            MyPagerGalleryView myPagerGalleryView = this.mNoticePagerGalleryView;
            if (myPagerGalleryView != null) {
                myPagerGalleryView.start(getContext(), strArr, null, 4000, this.mOvalLayout, R.drawable.dot_selected, R.drawable.dot_normal, null, null);
                this.mNoticePagerGalleryView.setMyOnItemClickListener(new MyPagerGalleryView.MyOnItemClickListener() { // from class: client.android.yixiaotong.v4.ui.V4MainFragment.4
                    @Override // client.android.yixiaotong.ui.widget.MyPagerGalleryView.MyOnItemClickListener
                    public void onItemClick(int i2) {
                        V4AnnouncementDetailActivity.launch(V4MainFragment.this.getActivity(), homeInfoV4.noticeList.get(i2));
                    }
                });
                return;
            }
            return;
        }
        this.mImgNotice.setVisibility(0);
        MyPagerGalleryView myPagerGalleryView2 = this.mNoticePagerGalleryView;
        if (myPagerGalleryView2 != null) {
            myPagerGalleryView2.start(getContext(), new String[0], null, 4000, this.mOvalLayout, R.drawable.dot_selected, R.drawable.dot_normal, null, null);
        }
    }

    private void saveSchoolName(String str) {
        LocalDataUtil.savePlatformInfo(getActivity(), 4);
        LocalDataUtil.savePlatformSchoolName(getActivity(), str);
        LocalDataUtil.saveSchoolId(getActivity(), V4UserInfoUtil.getInstance().getLoginAccountV4().customerId);
    }

    private void initAdv() {
        this.mNativeUtil = new NativeUtil();
    }

    private void loadAdv() {
        LogUtil.e(TAG, "ShouYeInsertUtil initAdv:广告入口  " + this.mIsShowAdvNative + PPSLabelView.Code + this.mIsShowAdvInsert);
        ShouYeInsertUtil.getInstance().onCreate(getActivity(), false);
        this.mAdvListener = new AdvControlUtil.AdvListener() { // from class: client.android.yixiaotong.v4.ui.V4MainFragment.5
            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void isOpen(int i, int i2, int i3, int i4, int i5) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdClosed(Common.AdvType advType) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onRenderSuccess(View view, int i) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdShow(String str, Common.AdvType advType) {
                LogUtil.e(V4MainFragment.TAG, "展示广告：" + advType);
                if (advType == Common.AdvType.advnative) {
                    V4MainFragment.this.mIsShowAdvNative = true;
                }
                if (advType == Common.AdvType.advinsert) {
                    V4MainFragment.this.mIsShowAdvInsert = true;
                }
            }
        };
        boolean zIsOpenAdv = V4HomeInfoUtil.getInstance().isOpenAdv();
        LogUtil.e(TAG, "广告是否开启：" + zIsOpenAdv);
        if (zIsOpenAdv) {
            if (!this.mIsShowAdvNative) {
                this.mNativeUtil.initNative(this.mActivity, this.mAdvListener, 0);
                this.mNativeUtil.onNative(this.flContainer);
            }
            if (this.mIsShowAdvInsert) {
                return;
            }
            ShouYeInsertUtil.getInstance().initInsert(this.mActivity, this.mAdvListener, true, "", true);
            ShouYeInsertUtil.getInstance().onInsert();
        }
    }
}
