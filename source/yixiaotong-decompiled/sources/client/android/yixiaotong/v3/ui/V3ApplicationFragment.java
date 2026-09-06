package client.android.yixiaotong.v3.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import client.android.yixiaotong.BaseFragment;
import client.android.yixiaotong.R;
import client.android.yixiaotong.account.AccountManager;
import client.android.yixiaotong.controller.bean.gonggaolan.GetAnnouncementBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.store.ClientDataManager;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.adapter.ViewPagerAdapter;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.login.LoginActivity;
import client.android.yixiaotong.ui.pullrefresh.MyGridView;
import client.android.yixiaotong.ui.pullrefresh.MyViewPager;
import client.android.yixiaotong.ui.widget.MyPagerGalleryView;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.android.NetworkUtils;
import client.android.yixiaotong.v3.bean.AlarmSwitchBean2;
import client.android.yixiaotong.v3.bean.UIVisableBean;
import client.android.yixiaotong.v3.bean.login.InvestorInfosBean;
import client.android.yixiaotong.v3.bean.login.JumpAppBean;
import client.android.yixiaotong.v3.bean.login.SchoolInfoBean;
import client.android.yixiaotong.v3.bean.login.SchoolInfosBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBaseInfoBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBean;
import client.android.yixiaotong.v3.bean.login.UseSoftwareProductBean;
import client.android.yixiaotong.v3.bean.login.UserInfoBean;
import client.android.yixiaotong.v3.bean.wallet.WalletInfoBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.adapter.GridViewAdapterV3;
import client.android.yixiaotong.v3.ui.adv.AdvControl;
import client.android.yixiaotong.v3.ui.adv.AdvControlUtil;
import client.android.yixiaotong.v3.ui.adv.Common;
import client.android.yixiaotong.v3.ui.adv.NativeUtil;
import client.android.yixiaotong.v3.ui.adv.ShouYeInsertUtil;
import client.android.yixiaotong.v3.ui.announcement.AnnouncementDetailActivity;
import client.android.yixiaotong.v3.ui.announcement.AnnouncementInfoActivity;
import client.android.yixiaotong.v3.ui.appcontrol.bath.BathControlActivity;
import client.android.yixiaotong.v3.ui.appcontrol.consumer.ConsumerControlActivity;
import client.android.yixiaotong.v3.ui.appcontrol.drawmoney.DrawMoneyControlActivity;
import client.android.yixiaotong.v3.ui.appcontrol.drinkwater.DrinkWaterControlActivity;
import client.android.yixiaotong.v3.ui.appcontrol.dry.DryControlActivity;
import client.android.yixiaotong.v3.ui.appcontrol.hairdryer.HairdryerControlActivity;
import client.android.yixiaotong.v3.ui.appcontrol.prepayment.PrepaymentWalletActivity;
import client.android.yixiaotong.v3.ui.appcontrol.prepayment.SelecetDeviceActivity;
import client.android.yixiaotong.v3.ui.appcontrol.sellcard.SellCardControlActivity;
import client.android.yixiaotong.v3.ui.appcontrol.wash.WashControlActivity;
import client.android.yixiaotong.v3.ui.card.SchoolCardActivity;
import client.android.yixiaotong.v3.ui.control.AppUpdateControlUtil;
import client.android.yixiaotong.v3.ui.control.ApplicationControlUtil;
import client.android.yixiaotong.v3.ui.control.BindSchoolGiveControl;
import client.android.yixiaotong.v3.ui.control.CashControl;
import client.android.yixiaotong.v3.ui.dialog.DrawMoneyTipDialog;
import client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog;
import client.android.yixiaotong.v3.ui.error.ErrorControlUtil;
import client.android.yixiaotong.v3.ui.register.ChangeLoginPswActivity;
import client.android.yixiaotong.v3.ui.server.ChangeSchoolActivity;
import client.android.yixiaotong.v3.ui.server.SelectedSchoolListActivity;
import client.android.yixiaotong.v3.ui.wallet.WalletDetailActivity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtil;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfo;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.Error50XUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.huawei.openalliance.ad.views.PPSLabelView;
import de.greenrobot.event.EventBus;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V3ApplicationFragment extends BaseFragment {
    private static final int PAGESIZE = 8;
    public static final String TAG = "V3Application";
    private RelativeLayout flContainer;
    private Activity mActivity;
    private AdvControlUtil.AdvListener mAdvListener;
    private String mCashInvestorId;
    private String mCashSchoolId;
    private ImageView mImgBingCard;
    private ImageView mImgNotice;
    private LinearLayout mLlDot;
    private MyViewPager mMainAppViewPager;
    private MainListener mMainListener;
    private NativeUtil mNativeUtil;
    private MyPagerGalleryView mNoticePagerGalleryView;
    private LinearLayout mOvalLayout;
    private RelativeLayout mRelWarningError;
    private ScrollView mScrollView;
    private PullRefreshLayout mSwipeRefreshLayout;
    private TextView mTvSchoolName;
    private boolean mIsEnable = true;
    private int mCurIndex = 0;
    private List<TypeInfoBean> mAppDatas = new ArrayList();
    private boolean mIsLoading = false;
    private boolean mIsVisable = true;
    private boolean mIsShowAdvNative = false;
    private boolean mIsShowAdvInsert = false;

    public void setMainListener(MainListener mainListener) {
        this.mMainListener = mainListener;
    }

    private void initViewNew(View view) {
        this.mRelWarningError = (RelativeLayout) view.findViewById(R.id.rel_warningerror);
        this.mSwipeRefreshLayout = (PullRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        this.mTvSchoolName = (TextView) view.findViewById(R.id.tv_schoolname);
        this.mImgNotice = (ImageView) view.findViewById(R.id.iv_loading);
        this.mNoticePagerGalleryView = (MyPagerGalleryView) view.findViewById(R.id.adgallery);
        this.mOvalLayout = (LinearLayout) view.findViewById(R.id.ovalLayout1);
        this.mMainAppViewPager = (MyViewPager) view.findViewById(R.id.viewpager);
        this.mLlDot = (LinearLayout) view.findViewById(R.id.ll_dot);
        this.mImgBingCard = (ImageView) view.findViewById(R.id.img_quickbindcard);
        this.flContainer = (RelativeLayout) view.findViewById(R.id.rl_native);
        this.mScrollView = (ScrollView) view.findViewById(R.id.scrollview);
    }

    public static V3ApplicationFragment newInstance() {
        return new V3ApplicationFragment();
    }

    @Override // android.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (Activity) context;
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_v3_application, (ViewGroup) null);
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        LogUtil.e(TAG, "onViewCreated:" + (this.mActivity == null));
        initViewNew(view);
        initClickListeners(view);
        handlerOnCreate();
    }

    private void handlerOnCreate() {
        EventBus.getDefault().register(this);
        AdvControl.getInstance().init(getLoginAccount(), this.mActivity);
        CashControl.getInstance().init(getLoginAccount(), getActivity());
        initListener();
        LogUtil.e(TAG, "handlerOnCreate:" + LocalDataUtil.getFirstLogin(getContext()));
        if (LocalDataUtil.getFirstLogin(getContext())) {
            CashControl.getInstance().getRedisCash();
            getUserInfo();
        } else {
            String schoolName = UserInfoUtilControl.getInstance().getSchoolName();
            if (StringUtils.isNotEmpty(schoolName)) {
                this.mTvSchoolName.setText(schoolName);
                saveSchoolName(schoolName);
            }
            loadData();
            getInvestorInfo();
        }
        this.mIsLoading = true;
        this.mIsVisable = true;
        ApplicationControlUtil.getInstance().setListener(new ApplicationControlUtil.OnListener() { // from class: client.android.yixiaotong.v3.ui.V3ApplicationFragment.1
            @Override // client.android.yixiaotong.v3.ui.control.ApplicationControlUtil.OnListener
            public void onError() {
                if (V3ApplicationFragment.this.mIsEnable) {
                    V3ApplicationFragment.this.showError50XTip();
                }
            }
        });
        initAdv();
    }

    private void handlerOnResume() {
        LogUtil.e(TAG, "onResume" + this.mIsLoading + "  " + this.mIsVisable);
        ErrorControlUtil.getInstance().onResume();
        showError50XTip();
        AdvControl.getInstance().onResume();
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onResume();
        }
        loadAdv();
        CashControl.getInstance().onResume();
        ApplicationControlUtil.getInstance().onResume();
        if (!this.mIsLoading && LocalDataUtil.isNeedLoadUserInfos(getContext())) {
            getSchoolIdInfo();
        }
        loadData();
        ApplicationControlUtil.getInstance().isNeedChangePsw(getLoginAccount(), getActivity());
        if (LocalDataUtil.getIsNeedLoadZKTTip(getActivity())) {
            CashControl.getInstance().isNeedSignZKT();
        }
        LocalDataUtil.saveIsNeedLoadZKT(getActivity(), false);
        CashControl.getInstance().getHostUrl();
        ApplicationControlUtil.getInstance().getWalletBalance();
    }

    private void initListener() {
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.v3.ui.V3ApplicationFragment.2
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                if (LocalDataUtil.getAlarmSwitch(V3ApplicationFragment.this.getActivity())) {
                    V3ApplicationFragment.this.mSwipeRefreshLayout.setRefreshing(false);
                    final String str = UserInfoUtil.getInstance().getLoginAccountV3().studentHex + ClientDataManager.getInstance().getString(ClientDataManager.LOGIN_ACCOUNT);
                    LogUtil.e("AlarmPswTrace", "V3ApplicationFragment alarmSwitch2 request seed=" + str);
                    V3BusinessControllers.getInstance().alarmSwitch2(V3ApplicationFragment.this.getLoginAccount(), str, new Listener<AlarmSwitchBean2>() { // from class: client.android.yixiaotong.v3.ui.V3ApplicationFragment.2.1
                        @Override // client.android.yixiaotong.controller.core.Listener
                        public void onComplete(Controller controller, AlarmSwitchBean2 alarmSwitchBean2, Object... objArr) {
                            super.onComplete(controller, alarmSwitchBean2, objArr);
                            LogUtil.e("AlarmPswTrace", "V3ApplicationFragment alarmSwitch2 complete seed=" + str + " goWhite=" + alarmSwitchBean2.goWhite + " openPassword=" + alarmSwitchBean2.openPassword);
                            LocalDataUtil.saveAlarmSwitch(V3ApplicationFragment.this.getActivity(), alarmSwitchBean2.goWhite);
                            LocalDataUtil.saveAlarmPsw(V3ApplicationFragment.this.getActivity(), alarmSwitchBean2.openPassword);
                            LogUtil.log("alarmSwitch:" + alarmSwitchBean2);
                            LogUtil.e("alarmSwitch", "alarmSwitch:" + alarmSwitchBean2);
                        }

                        @Override // client.android.yixiaotong.controller.core.Listener
                        public void onFail(Controller controller, ClientException clientException) {
                            super.onFail(controller, clientException);
                            LogUtil.e("AlarmPswTrace", "V3ApplicationFragment alarmSwitch2 fail seed=" + str + " error=" + clientException.getDetail());
                            LocalDataUtil.saveAlarmSwitch(V3ApplicationFragment.this.getActivity(), false);
                            LogUtil.log("alarmSwitch:" + clientException.getDetail());
                            LogUtil.e("alarmSwitch", "alarmSwitch:" + clientException.getDetail());
                        }
                    });
                    return;
                }
                V3ApplicationFragment.this.getUserInfo();
            }
        });
        CashControl.getInstance().setListener(new CashControl.CashListener() { // from class: client.android.yixiaotong.v3.ui.V3ApplicationFragment.3
            @Override // client.android.yixiaotong.v3.ui.control.CashControl.CashListener
            public void onSchoolAndInvestor(String str) {
                if (StringUtils.isNotEmpty(str) && str.contains(",")) {
                    String[] strArrSplit = str.split(",");
                    if (strArrSplit.length >= 2) {
                        V3ApplicationFragment.this.mCashSchoolId = strArrSplit[0];
                        V3ApplicationFragment.this.mCashInvestorId = strArrSplit[1];
                    }
                }
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
        handlerOnResume();
    }

    @Override // client.android.yixiaotong.BaseFragment, android.app.Fragment
    public void onPause() {
        super.onPause();
        this.mIsEnable = false;
        LogUtil.e(TAG, "onPause");
        ErrorControlUtil.getInstance().onPause();
        BaseMaterialDialog.dissmisMaterialDialog();
        AdvControl.getInstance().onPause();
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onPause();
        }
        ShouYeInsertUtil.getInstance().onPause();
        CashControl.getInstance().onPause();
        ApplicationControlUtil.getInstance().onPause();
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
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onDestroy();
        }
        ShouYeInsertUtil.getInstance().onDestroy(this.mActivity);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    public void onEventMainThread(UIVisableBean uIVisableBean) {
        LogUtil.e(TAG, "onEventMainThread:UIVisableBean:" + uIVisableBean.index);
        if (uIVisableBean.index != 1) {
            this.mIsVisable = false;
        } else {
            this.mIsVisable = true;
            CashControl.getInstance().isNeedSignZKT();
        }
    }

    private void initClickListeners(View view) {
        view.findViewById(R.id.rel_selectschool).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.V3ApplicationFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m180x850859dc(view2);
            }
        });
        view.findViewById(R.id.iv_announcement).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.V3ApplicationFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m181xae5caf1d(view2);
            }
        });
        view.findViewById(R.id.img_scan).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.V3ApplicationFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m182xd7b1045e(view2);
            }
        });
        view.findViewById(R.id.img_quickbindcard).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.V3ApplicationFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m183x105599f(view2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-V3ApplicationFragment, reason: not valid java name */
    /* synthetic */ void m180x850859dc(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        if (LocalDataUtil.getAlarmSwitch(getActivity())) {
            ToastUtils.show(getActivity(), getString(R.string.alarmswitch));
            return;
        }
        UserInfo loginAccountV3 = UserInfoUtil.getInstance().getLoginAccountV3();
        if (loginAccountV3 != null && loginAccountV3.schoolInfoList != null) {
            SelectedSchoolListActivity.launch(getActivity());
        } else {
            ChangeSchoolActivity.launch(getActivity());
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-V3ApplicationFragment, reason: not valid java name */
    /* synthetic */ void m181xae5caf1d(View view) {
        if (LocalDataUtil.getAlarmSwitch(getActivity())) {
            ToastUtils.show(getActivity(), getString(R.string.alarmswitch));
        } else if (isCheckSchool()) {
            AnnouncementInfoActivity.launch(getActivity());
        } else {
            showDialog(false, "使用相关功能需要先绑定学校", "退出登录", "去绑定");
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v3-ui-V3ApplicationFragment, reason: not valid java name */
    /* synthetic */ void m182xd7b1045e(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        if (!NetworkUtils.isNetworkAvailable(getActivity())) {
            ToastUtils.show(getActivity(), "请打开网络后重试");
            return;
        }
        if (LocalDataUtil.getAlarmSwitch(getActivity())) {
            ToastUtils.show(getActivity(), getString(R.string.alarmswitch));
            return;
        }
        if (!isCheckSchool()) {
            MainListener mainListener = this.mMainListener;
            if (mainListener != null) {
                mainListener.onApplication(0);
                return;
            }
            return;
        }
        UseSoftwareProductBean useSoftwareProductBeanIsUseAndroid = InvestorInfoUtilControl.getInstance().isUseAndroid();
        if (!useSoftwareProductBeanIsUseAndroid.isUse) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), useSoftwareProductBeanIsUseAndroid.msg);
            return;
        }
        MainListener mainListener2 = this.mMainListener;
        if (mainListener2 != null) {
            mainListener2.onApplication(0);
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$3$client-android-yixiaotong-v3-ui-V3ApplicationFragment, reason: not valid java name */
    /* synthetic */ void m183x105599f(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        if (LocalDataUtil.getAlarmSwitch(getActivity())) {
            ToastUtils.show(getActivity(), getString(R.string.alarmswitch));
        } else {
            SchoolCardActivity.launch(getActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveSchoolName(String str) {
        LocalDataUtil.savePlatformInfo(getActivity(), 1);
        LocalDataUtil.savePlatformSchoolName(getActivity(), str);
        LocalDataUtil.saveSchoolId(getActivity(), UserInfoUtilControl.getInstance().getSchoolId());
    }

    private void initViewPager(int i) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getActivity());
        int iCeil = (int) Math.ceil((((double) i) * 1.0d) / 8.0d);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < iCeil; i2++) {
            MyGridView myGridView = (MyGridView) layoutInflaterFrom.inflate(R.layout.l_shouye_gridviewv3, (ViewGroup) this.mMainAppViewPager, false);
            myGridView.setAdapter((ListAdapter) new GridViewAdapterV3(getActivity(), this.mAppDatas, i2, 8));
            arrayList.add(myGridView);
            myGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: client.android.yixiaotong.v3.ui.V3ApplicationFragment.4
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                    V3ApplicationFragment.this.gridViewOnClick((TypeInfoBean) adapterView.getAdapter().getItem(i3));
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
            this.mMainAppViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: client.android.yixiaotong.v3.ui.V3ApplicationFragment.5
                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i4) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i4, float f, int i5) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i4) {
                    V3ApplicationFragment.this.mLlDot.getChildAt(V3ApplicationFragment.this.mCurIndex).findViewById(R.id.v_dot).setBackgroundResource(R.drawable.dot_normal);
                    V3ApplicationFragment.this.mLlDot.getChildAt(i4).findViewById(R.id.v_dot).setBackgroundResource(R.drawable.dot_selected);
                    V3ApplicationFragment.this.mCurIndex = i4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridViewOnClick(TypeInfoBean typeInfoBean) {
        if (LocalDataUtil.getAlarmSwitch(getActivity()) && typeInfoBean.base.typeId != 1 && typeInfoBean.base.typeId != 6 && typeInfoBean.base.typeId != 8 && typeInfoBean.base.typeId != 3 && typeInfoBean.base.typeId != 16) {
            ToastUtils.show(getActivity(), getString(R.string.alarmswitch));
            return;
        }
        UseSoftwareProductBean useSoftwareProductBeanIsUseAndroid = InvestorInfoUtilControl.getInstance().isUseAndroid();
        if (!useSoftwareProductBeanIsUseAndroid.isUse) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), useSoftwareProductBeanIsUseAndroid.msg);
            return;
        }
        if (typeInfoBean.base.typeId == 1) {
            if (!NetworkUtils.isNetworkAvailable(getActivity())) {
                ToastUtils.show(getActivity(), "请打开网络后重试");
                return;
            } else {
                BathControlActivity.launch(getActivity(), typeInfoBean);
                return;
            }
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
            return;
        }
        if (typeInfoBean.base.typeId == 7) {
            if (typeInfoBean.base.machineServiceProvider != null) {
                LogUtil.e(TAG, "电表gridViewOnClick:machineModel:" + typeInfoBean.base.machineServiceProvider);
                if (typeInfoBean.base.machineServiceProvider.intValue() == 1) {
                    ApplicationControlUtil.getInstance().getElecMeterBindInfo();
                    return;
                } else {
                    SystemErrorTip.getInstance().showTipDialog(getActivity(), "暂不支持设备服务商" + typeInfoBean.base.machineServiceProvider + ",升级APP到最新版本后再试");
                    return;
                }
            }
            SystemErrorTip.getInstance().showTipDialog(getActivity(), "未配置设备服务商,请联系管理员");
            return;
        }
        if (typeInfoBean.base.typeId == 16) {
            DryControlActivity.launch(getActivity(), typeInfoBean);
            return;
        }
        if (typeInfoBean.base.typeId == 20) {
            if (typeInfoBean.extendJson != null && typeInfoBean.extendJson.type == 1) {
                drawmoney();
                return;
            } else {
                DrawMoneyControlActivity.launch(getActivity(), typeInfoBean);
                return;
            }
        }
        if (typeInfoBean.base.typeId == 9) {
            if (typeInfoBean.base.machineModel != null) {
                LogUtil.e(TAG, "gridViewOnClick:machineModel:" + typeInfoBean.base.machineModel);
                if (typeInfoBean.base.machineModel.intValue() == 1) {
                    SellCardControlActivity.launch(getActivity(), typeInfoBean);
                    return;
                } else {
                    if (typeInfoBean.base.machineModel.intValue() == 0) {
                        getWalletInfo();
                        return;
                    }
                    return;
                }
            }
            SystemErrorTip.getInstance().showTipDialog(getActivity(), "未配置售卡机类型,请联系管理员");
            return;
        }
        if (typeInfoBean.base.typeId == 18) {
            UseSoftwareProductBean useSoftwareProductBeanIsUseAndroid2 = InvestorInfoUtilControl.getInstance().isUseAndroid(18);
            if (!useSoftwareProductBeanIsUseAndroid2.isUse) {
                SystemErrorTip.getInstance().showTipDialog(getActivity(), useSoftwareProductBeanIsUseAndroid2.msg);
                return;
            }
            if (typeInfoBean.base.statusFlag == 1) {
                if (StringUtils.isNotEmpty(LocalDataUtil.getTypeIdMachineId(getActivity(), 18))) {
                    PrepaymentWalletActivity.launch(getActivity(), typeInfoBean);
                    return;
                } else {
                    SelecetDeviceActivity.launch(getActivity(), typeInfoBean);
                    return;
                }
            }
            SystemErrorTip.getInstance().showTipDialog(getActivity(), "应用已停用");
            return;
        }
        if (typeInfoBean.base.typeId == 26 || typeInfoBean.base.typeId == 2) {
            ConsumerControlActivity.launch(getActivity(), typeInfoBean);
        } else if (typeInfoBean.base.typeId >= 100) {
            ApplicationControlUtil.getInstance().jumpApp(getActivity(), typeInfoBean.base.appName);
        } else {
            ToastUtils.show(getContext(), "暂未开通");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        LogUtil.e(TAG, "loadData:" + this.mIsLoading + PPSLabelView.Code + LocalDataUtil.isNeedLoadInvestorInfos(getContext()));
        if (this.mIsLoading) {
            return;
        }
        if (!LocalDataUtil.getAlarmSwitch(getContext()) && LocalDataUtil.isNeedLoadInvestorInfos(getContext())) {
            this.mAppDatas.clear();
            String schoolName = UserInfoUtilControl.getInstance().getSchoolName();
            if (StringUtils.isNotEmpty(schoolName)) {
                this.mTvSchoolName.setText(schoolName);
                saveSchoolName(schoolName);
            }
            getInvestorInfo();
            return;
        }
        if (InvestorInfoUtilControl.getInstance().getInvestorInfoBean() != null) {
            CashControl.getInstance().setRedisCash();
            this.mAppDatas.clear();
            List<TypeInfoBean> typeInfoBeans = InvestorInfoUtilControl.getInstance().getTypeInfoBeans();
            for (int i = 0; i < typeInfoBeans.size(); i++) {
                if (typeInfoBeans.get(i).base.typeId == 1 || typeInfoBeans.get(i).base.typeId == 3 || typeInfoBeans.get(i).base.typeId == 6 || typeInfoBeans.get(i).base.typeId == 8 || typeInfoBeans.get(i).base.typeId == 16 || typeInfoBeans.get(i).base.typeId == 20 || typeInfoBeans.get(i).base.typeId == 9 || typeInfoBeans.get(i).base.typeId == 18 || typeInfoBeans.get(i).base.typeId == 7 || typeInfoBeans.get(i).base.typeId == 2) {
                    this.mAppDatas.add(typeInfoBeans.get(i));
                }
            }
            List<JumpAppBean> jumpApp = InvestorInfoUtilControl.getInstance().getJumpApp();
            if (jumpApp != null && jumpApp.size() > 0) {
                for (int i2 = 0; i2 < jumpApp.size(); i2++) {
                    TypeInfoBean typeInfoBean = new TypeInfoBean();
                    TypeInfoBaseInfoBean typeInfoBaseInfoBean = new TypeInfoBaseInfoBean();
                    typeInfoBaseInfoBean.typeId = i2 + 100;
                    typeInfoBaseInfoBean.appName = jumpApp.get(i2).name;
                    typeInfoBean.base = typeInfoBaseInfoBean;
                    this.mAppDatas.add(typeInfoBean);
                }
            }
            initViewPager(this.mAppDatas.size());
            if (InvestorInfoUtilControl.getInstance().isVisableBindCard()) {
                this.mImgBingCard.setVisibility(0);
                return;
            } else {
                this.mImgBingCard.setVisibility(8);
                return;
            }
        }
        initViewPager(this.mAppDatas.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getNoticeViewPagerData() {
        if (LocalDataUtil.getAlarmSwitch(getActivity())) {
            BaseMaterialDialog.dissmisMaterialDialog();
            return;
        }
        String schoolId = UserInfoUtilControl.getInstance().getSchoolId();
        String investorId = InvestorInfoUtilControl.getInstance().getInvestorId();
        LogUtil.e(TAG, schoolId + "  " + investorId);
        if (StringUtils.isNotEmpty(schoolId) && StringUtils.isNotEmpty(investorId)) {
            V3BusinessControllers.getInstance().getAnnouncementV3(getLoginAccount(), schoolId, investorId, new Listener<List<GetAnnouncementBean>>() { // from class: client.android.yixiaotong.v3.ui.V3ApplicationFragment.6
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, final List<GetAnnouncementBean> list, Object... objArr) {
                    if (V3ApplicationFragment.this.mIsEnable) {
                        V3ApplicationFragment.this.showError50XTip();
                        if (list == null || list.size() <= 0) {
                            V3ApplicationFragment.this.mImgNotice.setVisibility(0);
                            if (V3ApplicationFragment.this.mNoticePagerGalleryView != null) {
                                V3ApplicationFragment.this.mNoticePagerGalleryView.start(V3ApplicationFragment.this.getContext(), new String[0], null, 4000, V3ApplicationFragment.this.mOvalLayout, R.drawable.dot_selected, R.drawable.dot_normal, null, null);
                                return;
                            }
                            return;
                        }
                        V3ApplicationFragment.this.mImgNotice.setVisibility(8);
                        String[] strArr = new String[list.size()];
                        for (int i = 0; i < list.size(); i++) {
                            strArr[i] = list.get(i).UrlImage;
                        }
                        if (V3ApplicationFragment.this.mNoticePagerGalleryView != null) {
                            V3ApplicationFragment.this.mNoticePagerGalleryView.start(V3ApplicationFragment.this.getContext(), strArr, null, 4000, V3ApplicationFragment.this.mOvalLayout, R.drawable.dot_selected, R.drawable.dot_normal, null, null);
                            V3ApplicationFragment.this.mNoticePagerGalleryView.setMyOnItemClickListener(new MyPagerGalleryView.MyOnItemClickListener() { // from class: client.android.yixiaotong.v3.ui.V3ApplicationFragment.6.1
                                @Override // client.android.yixiaotong.ui.widget.MyPagerGalleryView.MyOnItemClickListener
                                public void onItemClick(int i2) {
                                    if (LocalDataUtil.getAlarmSwitch(V3ApplicationFragment.this.getActivity())) {
                                        ToastUtils.show(V3ApplicationFragment.this.getActivity(), V3ApplicationFragment.this.getString(R.string.alarmswitch));
                                    } else {
                                        AnnouncementDetailActivity.launch(V3ApplicationFragment.this.getActivity(), ((GetAnnouncementBean) list.get(i2)).ID);
                                    }
                                }
                            });
                        }
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (V3ApplicationFragment.this.mIsEnable) {
                        V3ApplicationFragment.this.mImgNotice.setVisibility(0);
                    }
                }
            });
            return;
        }
        UserInfoUtil.getInstance().saveSchoolInfosIndex(0);
        InvestorInfoUtil.getInstance().saveInvestorInfosIndex(0);
        ToastUtils.show(getContext(), "数据异常，请重新登录");
        AccountManager.getInstance().clearLoginAccount();
        LoginActivity.launch(getActivity());
        getActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getUserInfo() {
        if (LocalDataUtil.getAlarmSwitch(getActivity())) {
            BaseMaterialDialog.dissmisMaterialDialog();
        } else {
            V3BusinessControllers.getInstance().getUserInfo(getLoginAccount(), new Listener<UserInfoBean>() { // from class: client.android.yixiaotong.v3.ui.V3ApplicationFragment.7
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    BaseMaterialDialog.showMaterialDialog(V3ApplicationFragment.this.getActivity(), "获取账户信息.", false);
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, UserInfoBean userInfoBean, Object... objArr) {
                    if (V3ApplicationFragment.this.mIsEnable) {
                        if (V3ApplicationFragment.this.getActivity() instanceof V3MainActivity) {
                            ((V3MainActivity) V3ApplicationFragment.this.getActivity()).onUserInfoLoadedForAlarmSwitch();
                        }
                        V3ApplicationFragment.this.showError50XTip();
                        V3ApplicationFragment.this.getSchoolIdInfo();
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (V3ApplicationFragment.this.mIsEnable) {
                        V3ApplicationFragment.this.onErrorHide(clientException);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getSchoolIdInfo() {
        if (LocalDataUtil.getAlarmSwitch(getActivity())) {
            BaseMaterialDialog.dissmisMaterialDialog();
        } else {
            V3BusinessControllers.getInstance().getSchoolInfo(getLoginAccount(), new Listener<SchoolInfoBean>() { // from class: client.android.yixiaotong.v3.ui.V3ApplicationFragment.8
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    BaseMaterialDialog.showMaterialDialog(V3ApplicationFragment.this.getActivity(), "获取账户信息..", false);
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, SchoolInfoBean schoolInfoBean, Object... objArr) {
                    if (V3ApplicationFragment.this.mIsEnable) {
                        V3ApplicationFragment.this.showError50XTip();
                        if (schoolInfoBean.schoolList == null || schoolInfoBean.schoolList.size() <= 0) {
                            V3ApplicationFragment.this.mIsLoading = false;
                            InvestorInfoUtil.getInstance().saveInvestorInfosV3(null);
                            if (V3ApplicationFragment.this.mSwipeRefreshLayout != null) {
                                V3ApplicationFragment.this.mSwipeRefreshLayout.setRefreshing(false);
                            }
                            BaseMaterialDialog.dissmisMaterialDialog();
                            return;
                        }
                        V3ApplicationFragment.this.getSchoolInfos();
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (V3ApplicationFragment.this.mIsEnable) {
                        V3ApplicationFragment.this.onErrorHide(clientException);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getSchoolInfos() {
        if (LocalDataUtil.getAlarmSwitch(getActivity())) {
            BaseMaterialDialog.dissmisMaterialDialog();
            return;
        }
        String schoolIds = UserInfoUtilControl.getInstance().getSchoolIds();
        if (StringUtils.isNotEmpty(schoolIds)) {
            V3BusinessControllers.getInstance().getSchoolInfos(getLoginAccount(), schoolIds, false, new Listener<List<SchoolInfosBean>>() { // from class: client.android.yixiaotong.v3.ui.V3ApplicationFragment.9
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    BaseMaterialDialog.showMaterialDialog(V3ApplicationFragment.this.getActivity(), "获取账户信息...", false);
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, List<SchoolInfosBean> list, Object... objArr) {
                    if (V3ApplicationFragment.this.mIsEnable) {
                        V3ApplicationFragment.this.showError50XTip();
                        LocalDataUtil.saveIsNeedLoadUserInfo(V3ApplicationFragment.this.getContext(), false);
                        UserInfoUtil.getInstance().saveSchoolInfosV3(list);
                        LogUtil.e(V3ApplicationFragment.TAG, "getSchoolInfos:mCashSchoolId：" + V3ApplicationFragment.this.mCashSchoolId);
                        if (StringUtils.isNotEmpty(V3ApplicationFragment.this.mCashSchoolId)) {
                            for (int i = 0; i < list.size(); i++) {
                                if ((list.get(i).id + "").equals(V3ApplicationFragment.this.mCashSchoolId)) {
                                    UserInfoUtil.getInstance().saveSchoolInfosIndex(i);
                                    InvestorInfoUtil.getInstance().saveInvestorInfosIndex(0);
                                }
                            }
                        }
                        String schoolId = UserInfoUtilControl.getInstance().getSchoolId();
                        LogUtil.e(V3ApplicationFragment.TAG, "getSchoolInfos:SchoolId：" + schoolId);
                        if (StringUtils.isEmpty(schoolId)) {
                            UserInfoUtil.getInstance().saveSchoolInfosIndex(0);
                            InvestorInfoUtil.getInstance().saveInvestorInfosIndex(0);
                        }
                        String schoolName = UserInfoUtilControl.getInstance().getSchoolName();
                        V3ApplicationFragment.this.mTvSchoolName.setText(schoolName);
                        V3ApplicationFragment.this.saveSchoolName(schoolName);
                        V3ApplicationFragment.this.getInvestorInfo();
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (V3ApplicationFragment.this.mIsEnable) {
                        V3ApplicationFragment.this.onErrorHide(clientException);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getInvestorInfo() {
        if (LocalDataUtil.getAlarmSwitch(getActivity())) {
            BaseMaterialDialog.dissmisMaterialDialog();
        } else {
            V3BusinessControllers.getInstance().getInvestorInfo(getLoginAccount(), new Listener<List<InvestorInfosBean>>() { // from class: client.android.yixiaotong.v3.ui.V3ApplicationFragment.10
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    BaseMaterialDialog.showMaterialDialog(V3ApplicationFragment.this.getActivity(), "加载数据....", false);
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, List<InvestorInfosBean> list, Object... objArr) {
                    if (V3ApplicationFragment.this.mIsEnable) {
                        V3ApplicationFragment.this.showError50XTip();
                        InvestorInfoUtilControl.getInstance().setInvestorId();
                        V3ApplicationFragment.this.mIsLoading = false;
                        if (V3ApplicationFragment.this.mSwipeRefreshLayout != null) {
                            V3ApplicationFragment.this.mSwipeRefreshLayout.setRefreshing(false);
                        }
                        BaseMaterialDialog.dissmisMaterialDialog();
                        EventBus.getDefault().post(new InvestorInfosBean());
                        if (list != null && list.size() > 0) {
                            if (StringUtils.isNotEmpty(V3ApplicationFragment.this.mCashInvestorId)) {
                                for (int i = 0; i < list.size(); i++) {
                                    if (list.get(i).investorInfo.investorId.equals(V3ApplicationFragment.this.mCashInvestorId)) {
                                        LogUtil.e(V3ApplicationFragment.TAG, "getInvestorInfo:saveInvestorInfosIndex:" + i);
                                        InvestorInfoUtil.getInstance().saveInvestorInfosIndex(i);
                                    }
                                }
                            }
                            LocalDataUtil.saveIsNeedLoadInvestorInfo(V3ApplicationFragment.this.getContext(), false);
                            LocalDataUtil.saveIsFirstOffline(V3ApplicationFragment.this.getActivity(), false);
                            V3ApplicationFragment.this.loadData();
                            V3ApplicationFragment.this.mCashInvestorId = "";
                            V3ApplicationFragment.this.mCashSchoolId = "";
                            if (V3ApplicationFragment.this.mIsVisable) {
                                CashControl.getInstance().isNeedSignZKT();
                            }
                            ApplicationControlUtil.getInstance().setMinimumWarningAmount(V3ApplicationFragment.this.getActivity(), V3ApplicationFragment.this.getLoginAccount());
                            ApplicationControlUtil.getInstance().getWalletBalance();
                        }
                        V3ApplicationFragment.this.getNoticeViewPagerData();
                        AdvControl.getInstance().getAdvRules();
                        AdvControl.getInstance().getAdvertising();
                        if (LocalDataUtil.getIsNeedLoadVersion(V3ApplicationFragment.this.getActivity()) == 1) {
                            LocalDataUtil.saveIsNeedLoadVersion(V3ApplicationFragment.this.getActivity(), 0);
                            AppUpdateControlUtil.getInstance().getVerSion();
                        }
                        BindSchoolGiveControl.getInstance().bindSchoolGive();
                        if (LocalDataUtil.getFirstLogin(V3ApplicationFragment.this.getActivity())) {
                            CashControl.getInstance().getHostUrl();
                        }
                        LocalDataUtil.saveFirstLogin(V3ApplicationFragment.this.getContext(), false);
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (V3ApplicationFragment.this.mIsEnable) {
                        V3ApplicationFragment.this.onErrorHide(clientException);
                    }
                }
            });
        }
    }

    private void getWalletInfo() {
        if (LocalDataUtil.getAlarmSwitch(getActivity())) {
            BaseMaterialDialog.dissmisMaterialDialog();
        } else {
            V3BusinessControllers.getInstance().postGetWalletInfoByInvestorid(getLoginAccount(), InvestorInfoUtilControl.getInstance().getInvestorInfoBean().investorId, new Listener<WalletInfoBean>() { // from class: client.android.yixiaotong.v3.ui.V3ApplicationFragment.11
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    BaseMaterialDialog.showMaterialDialog(V3ApplicationFragment.this.getActivity(), "正在获取钱包信息..", false);
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, WalletInfoBean walletInfoBean, Object... objArr) {
                    if (V3ApplicationFragment.this.mIsEnable) {
                        V3ApplicationFragment.this.showError50XTip();
                        BaseMaterialDialog.dissmisMaterialDialog();
                        WalletDetailActivity.launch(V3ApplicationFragment.this.getActivity(), walletInfoBean);
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (V3ApplicationFragment.this.mIsEnable) {
                        V3ApplicationFragment.this.onErrorHide(clientException);
                    }
                }
            });
        }
    }

    private boolean isCheckSchool() {
        return UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList != null;
    }

    private void showDialog(boolean z, String str, final String str2, String str3) {
        if (z) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.V3ApplicationFragment.12
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    if (str2.equals("退出登录")) {
                        AccountManager.getInstance().clearLoginAccount();
                        LoginActivity.launch(V3ApplicationFragment.this.getActivity());
                        V3ApplicationFragment.this.getActivity().finish();
                    }
                }
            }, str, str2);
        } else {
            TwoButtonDialog.getInstance().showDialog(getActivity(), new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.V3ApplicationFragment.13
                @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
                public void onConfirm() {
                    if (ClickUtil.isFastDoubleClick()) {
                        return;
                    }
                    ChangeSchoolActivity.launch(V3ApplicationFragment.this.getActivity());
                }

                @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
                public void onCancle() {
                    AccountManager.getInstance().clearLoginAccount();
                    LoginActivity.launch(V3ApplicationFragment.this.getActivity());
                    V3ApplicationFragment.this.getActivity().finish();
                }
            }, "提示", str, str2, str3);
        }
    }

    private void drawmoney() {
        String accountPsw = LocalDataUtil.getAccountPsw(getContext());
        if (StringUtils.isNotEmpty(accountPsw)) {
            String[] strArrSplit = accountPsw.split(",");
            String str = strArrSplit[0];
            String str2 = strArrSplit[1];
            if (!StringUtils.isNumberIllegal(str) || str.length() != 11) {
                DrawMoneyTipDialog.getInstance().showDialog(getActivity(), new DrawMoneyTipDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.V3ApplicationFragment.14
                    @Override // client.android.yixiaotong.v3.ui.dialog.DrawMoneyTipDialog.Listener
                    public void onCancle() {
                    }

                    @Override // client.android.yixiaotong.v3.ui.dialog.DrawMoneyTipDialog.Listener
                    public void onConfirm() {
                        CashControl.getInstance().exitapp();
                    }
                }, "安卓领款机上只支持11位数字账号登录，请重新注册后登录！", "", "退出登录");
                return;
            } else if (!StringUtils.isNumberIllegal(str2) || str2.length() != 6) {
                DrawMoneyTipDialog.getInstance().showDialog(getActivity(), new DrawMoneyTipDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.V3ApplicationFragment.15
                    @Override // client.android.yixiaotong.v3.ui.dialog.DrawMoneyTipDialog.Listener
                    public void onCancle() {
                    }

                    @Override // client.android.yixiaotong.v3.ui.dialog.DrawMoneyTipDialog.Listener
                    public void onConfirm() {
                        ChangeLoginPswActivity.launch(V3ApplicationFragment.this.getActivity());
                    }
                }, "安卓领款机上只支持6位数字密码登录，请前往修改后使用！", "", "去修改");
                return;
            } else {
                getWalletInfo();
                return;
            }
        }
        ToastUtils.show(getContext(), "请重新登录");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showError50XTip() {
        if (Error50XUtil.isInterrupt(getActivity()) && !LocalDataUtil.getIsEnableOffline(getActivity())) {
            this.mRelWarningError.setVisibility(0);
        } else {
            this.mRelWarningError.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onErrorHide(ClientException clientException) {
        LogUtil.e(TAG, "onErrorHide");
        showError50XTip();
        PullRefreshLayout pullRefreshLayout = this.mSwipeRefreshLayout;
        if (pullRefreshLayout != null) {
            pullRefreshLayout.setRefreshing(false);
        }
        this.mIsLoading = true;
        ErrorControlUtil.getInstance().onHideError(getLoginAccount(), clientException, getActivity(), false, 1, "首页");
    }

    private void initAdv() {
        this.mNativeUtil = new NativeUtil();
    }

    private void loadAdv() {
        LogUtil.e(TAG, "ShouYeInsertUtil initAdv:广告入口" + this.mIsLoading + "  " + this.mIsShowAdvNative + PPSLabelView.Code + this.mIsShowAdvInsert + PPSLabelView.Code + (this.mActivity == null));
        ShouYeInsertUtil.getInstance().onCreate(this.mActivity, false);
        this.mAdvListener = new AdvControlUtil.AdvListener() { // from class: client.android.yixiaotong.v3.ui.V3ApplicationFragment.16
            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdClosed(Common.AdvType advType) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onRenderSuccess(View view, int i) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void isOpen(int i, int i2, int i3, int i4, int i5) {
                LogUtil.e(V3ApplicationFragment.TAG, "ShouYeInsertUtil 开始加载广告：" + V3ApplicationFragment.this.mIsLoading + "  " + V3ApplicationFragment.this.mIsShowAdvNative + PPSLabelView.Code + V3ApplicationFragment.this.mIsShowAdvInsert + PPSLabelView.Code + i5 + PPSLabelView.Code + i);
                if (i5 == 1 && !V3ApplicationFragment.this.mIsShowAdvNative) {
                    V3ApplicationFragment.this.mNativeUtil.initNative(V3ApplicationFragment.this.mActivity, V3ApplicationFragment.this.mAdvListener, 0);
                    V3ApplicationFragment.this.mNativeUtil.onNative(V3ApplicationFragment.this.flContainer);
                }
                if (i != 1 || V3ApplicationFragment.this.mIsShowAdvInsert) {
                    return;
                }
                ShouYeInsertUtil.getInstance().initInsert(V3ApplicationFragment.this.mActivity, V3ApplicationFragment.this.mAdvListener, true, "", true);
                ShouYeInsertUtil.getInstance().onInsert();
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdShow(String str, Common.AdvType advType) {
                LogUtil.e(V3ApplicationFragment.TAG, "展示广告：" + advType);
                if (advType == Common.AdvType.advnative) {
                    V3ApplicationFragment.this.mIsShowAdvNative = true;
                }
                if (advType == Common.AdvType.advinsert) {
                    V3ApplicationFragment.this.mIsShowAdvInsert = true;
                }
            }
        };
        AdvControlUtil.getInstance().init(this.mActivity, this.mAdvListener, 0, true, "");
        AdvControlUtil.getInstance().initAdvInfo();
    }
}
