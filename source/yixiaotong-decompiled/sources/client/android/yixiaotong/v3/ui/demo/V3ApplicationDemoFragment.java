package client.android.yixiaotong.v3.ui.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import client.android.yixiaotong.BaseFragment;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.adapter.ViewPagerAdapter;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.pullrefresh.MyGridView;
import client.android.yixiaotong.ui.pullrefresh.MyViewPager;
import client.android.yixiaotong.ui.widget.MyPagerGalleryView;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.bean.UIVisableBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBaseInfoBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBean;
import client.android.yixiaotong.v3.ui.MainListener;
import client.android.yixiaotong.v3.ui.adapter.GridViewAdapterV3;
import client.android.yixiaotong.v3.ui.announcement.AnnouncementInfoActivity;
import client.android.yixiaotong.v3.ui.appcontrol.drinkwater.DrinkWaterControlActivity;
import client.android.yixiaotong.v3.ui.appcontrol.dry.DryControlActivity;
import client.android.yixiaotong.v3.ui.appcontrol.hairdryer.HairdryerControlActivity;
import client.android.yixiaotong.v3.ui.appcontrol.wash.WashControlActivity;
import client.android.yixiaotong.v3.ui.card.SchoolCardActivity;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import de.greenrobot.event.EventBus;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V3ApplicationDemoFragment extends BaseFragment {
    private static final int PAGESIZE = 8;
    public static final String TAG = "V3ApplicationDemo";
    private ImageView mImgBingCard;
    private ImageView mImgNotice;
    private LinearLayout mLlDot;
    private MyViewPager mMainAppViewPager;
    private MainListener mMainListener;
    private MyPagerGalleryView mNoticePagerGalleryView;
    private LinearLayout mOvalLayout;
    private PullRefreshLayout mSwipeRefreshLayout;
    private TextView mTvSchoolName;
    private int mCurIndex = 0;
    private List<TypeInfoBean> mAppDatas = new ArrayList();
    private boolean mIsEnable = true;
    private boolean mIsLoading = false;
    private boolean mIsVisable = true;

    public void setMainListener(MainListener mainListener) {
        this.mMainListener = mainListener;
    }

    private void initViewNew(View view) {
        this.mSwipeRefreshLayout = (PullRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        this.mTvSchoolName = (TextView) view.findViewById(R.id.tv_schoolname);
        this.mImgNotice = (ImageView) view.findViewById(R.id.iv_loading);
        this.mNoticePagerGalleryView = (MyPagerGalleryView) view.findViewById(R.id.adgallery);
        this.mOvalLayout = (LinearLayout) view.findViewById(R.id.ovalLayout1);
        this.mMainAppViewPager = (MyViewPager) view.findViewById(R.id.viewpager);
        this.mLlDot = (LinearLayout) view.findViewById(R.id.ll_dot);
        this.mImgBingCard = (ImageView) view.findViewById(R.id.img_quickbindcard);
    }

    public static V3ApplicationDemoFragment newInstance() {
        return new V3ApplicationDemoFragment();
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_v3_application_demo, (ViewGroup) null);
        initViewNew(viewInflate);
        initClickListeners(viewInflate);
        EventBus.getDefault().register(this);
        initListener();
        this.mIsLoading = true;
        this.mIsVisable = true;
        this.mAppDatas.clear();
        TypeInfoBean typeInfoBean = new TypeInfoBean();
        TypeInfoBaseInfoBean typeInfoBaseInfoBean = new TypeInfoBaseInfoBean();
        typeInfoBaseInfoBean.typeId = 1;
        typeInfoBaseInfoBean.appName = "洗澡";
        typeInfoBean.base = typeInfoBaseInfoBean;
        this.mAppDatas.add(typeInfoBean);
        initViewPager(this.mAppDatas.size());
        return viewInflate;
    }

    private void initListener() {
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3ApplicationDemoFragment.1
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
            }
        });
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // client.android.yixiaotong.BaseFragment, android.app.Fragment
    public void onResume() {
        super.onResume();
        this.mIsEnable = true;
        LogUtil.e(TAG, "onResume" + this.mIsLoading + "  " + this.mIsVisable);
    }

    @Override // client.android.yixiaotong.BaseFragment, android.app.Fragment
    public void onPause() {
        super.onPause();
        this.mIsEnable = false;
        LogUtil.e(TAG, "onPause");
        BaseMaterialDialog.dissmisMaterialDialog();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    @Override // android.app.Fragment
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
        view.findViewById(R.id.rel_selectschool).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3ApplicationDemoFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ClickUtil.isFastDoubleClick();
            }
        });
        view.findViewById(R.id.iv_announcement).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3ApplicationDemoFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m337x3b267802(view2);
            }
        });
        view.findViewById(R.id.img_scan).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3ApplicationDemoFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m338xb9877be1(view2);
            }
        });
        view.findViewById(R.id.img_quickbindcard).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3ApplicationDemoFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m339x37e87fc0(view2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-demo-V3ApplicationDemoFragment, reason: not valid java name */
    /* synthetic */ void m337x3b267802(View view) {
        AnnouncementInfoActivity.launch(getActivity());
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v3-ui-demo-V3ApplicationDemoFragment, reason: not valid java name */
    /* synthetic */ void m338xb9877be1(View view) {
        MainListener mainListener;
        if (ClickUtil.isFastDoubleClick() || (mainListener = this.mMainListener) == null) {
            return;
        }
        mainListener.onApplication(0);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$3$client-android-yixiaotong-v3-ui-demo-V3ApplicationDemoFragment, reason: not valid java name */
    /* synthetic */ void m339x37e87fc0(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        SchoolCardActivity.launch(getActivity());
    }

    private void initViewPager(int i) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getActivity());
        int iCeil = (int) Math.ceil((((double) i) * 1.0d) / 8.0d);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < iCeil; i2++) {
            MyGridView myGridView = (MyGridView) layoutInflaterFrom.inflate(R.layout.l_shouye_gridviewv3, (ViewGroup) this.mMainAppViewPager, false);
            myGridView.setAdapter((ListAdapter) new GridViewAdapterV3(getActivity(), this.mAppDatas, i2, 8));
            arrayList.add(myGridView);
            myGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3ApplicationDemoFragment.2
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                    V3ApplicationDemoFragment.this.gridViewOnClick((TypeInfoBean) adapterView.getAdapter().getItem(i3));
                }
            });
        }
        this.mMainAppViewPager.setAdapter(new ViewPagerAdapter(arrayList));
        LogUtil.e(TAG, "initViewPager:" + iCeil);
        if (iCeil == 1) {
            this.mLlDot.removeAllViews();
            return;
        }
        if (iCeil > 1) {
            this.mLlDot.removeAllViews();
            for (int i3 = 0; i3 < iCeil; i3++) {
                this.mLlDot.addView(layoutInflaterFrom.inflate(R.layout.dot, (ViewGroup) null));
            }
            this.mLlDot.getChildAt(0).findViewById(R.id.v_dot).setBackgroundResource(R.drawable.dot_selected);
            this.mMainAppViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3ApplicationDemoFragment.3
                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i4) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i4, float f, int i5) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i4) {
                    V3ApplicationDemoFragment.this.mLlDot.getChildAt(V3ApplicationDemoFragment.this.mCurIndex).findViewById(R.id.v_dot).setBackgroundResource(R.drawable.dot_normal);
                    V3ApplicationDemoFragment.this.mLlDot.getChildAt(i4).findViewById(R.id.v_dot).setBackgroundResource(R.drawable.dot_selected);
                    V3ApplicationDemoFragment.this.mCurIndex = i4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridViewOnClick(TypeInfoBean typeInfoBean) {
        if (typeInfoBean.base.typeId == 1) {
            BathControlDemoActivity.launch(getActivity(), typeInfoBean);
            return;
        }
        if (typeInfoBean.base.typeId == 6) {
            DrinkWaterControlActivity.launch(getActivity(), typeInfoBean);
            return;
        }
        if (typeInfoBean.base.typeId == 8) {
            HairdryerControlActivity.launch(getActivity(), typeInfoBean);
            return;
        }
        if (typeInfoBean.base.typeId == 3) {
            WashControlActivity.launch(getActivity(), typeInfoBean);
        } else if (typeInfoBean.base.typeId == 16) {
            DryControlActivity.launch(getActivity(), typeInfoBean);
        } else {
            ToastUtils.show(getContext(), "暂未开通");
        }
    }
}
