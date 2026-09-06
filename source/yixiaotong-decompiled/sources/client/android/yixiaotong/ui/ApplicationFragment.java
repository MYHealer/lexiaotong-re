package client.android.yixiaotong.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.viewpager.widget.ViewPager;
import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.BaseFragment;
import client.android.yixiaotong.R;
import client.android.yixiaotong.account.AccountManager;
import client.android.yixiaotong.account.AppAccountManager;
import client.android.yixiaotong.baseutil.ActivitiesHelper;
import client.android.yixiaotong.baseutil.QrcodeUtils;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.AmmeterBindRoomBean;
import client.android.yixiaotong.controller.bean.UserInfoBean;
import client.android.yixiaotong.controller.bean.adv.AdvControlListBean;
import client.android.yixiaotong.controller.bean.doorlock.SelectUserAuthenticationBean;
import client.android.yixiaotong.controller.bean.gonggaolan.GetAnnouncementBean;
import client.android.yixiaotong.controller.bean.hamam.BathHousePasswordBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.error.ErrorUtil;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.event.BalanceSyncEvent;
import client.android.yixiaotong.event.WalletSyncEvent;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.sdk.utils.RandomUtil;
import client.android.yixiaotong.ui.adapter.GridViewAdapter;
import client.android.yixiaotong.ui.adapter.ViewPagerAdapter;
import client.android.yixiaotong.ui.ammeter.AmmeterDataCollectionActivity;
import client.android.yixiaotong.ui.ammeter.HuaWeiScanActivity;
import client.android.yixiaotong.ui.ammeter.SearchAmmeterActivity;
import client.android.yixiaotong.ui.ammeter.SelectAmmeterAddressActivity;
import client.android.yixiaotong.ui.ammeter.SelectOperateActivity;
import client.android.yixiaotong.ui.baoxiu.MalfunctionRepairActivity;
import client.android.yixiaotong.ui.bluetoothtwo.BathMainActivity;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SetPswDialogTip;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.dialog.TwoButtonDialog;
import client.android.yixiaotong.ui.doorlock.AuthenticationActivity;
import client.android.yixiaotong.ui.doorlock.DoorLockMainActivity;
import client.android.yixiaotong.ui.drinkwater.DrinkWaterMainActivity;
import client.android.yixiaotong.ui.dry.DryMainActivity;
import client.android.yixiaotong.ui.hairdryer.HairDryerMainActivity;
import client.android.yixiaotong.ui.hamam.HamamMainActivity;
import client.android.yixiaotong.ui.login.LoginActivity;
import client.android.yixiaotong.ui.meal.MealMainActivity;
import client.android.yixiaotong.ui.pullrefresh.MyGridView;
import client.android.yixiaotong.ui.pullrefresh.MyViewPager;
import client.android.yixiaotong.ui.sellcard.SellCardMainActivity;
import client.android.yixiaotong.ui.wash.WashMainActivity;
import client.android.yixiaotong.ui.widget.DrinkWaterDialog;
import client.android.yixiaotong.ui.widget.MyPagerGalleryView;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.AESHelper;
import client.android.yixiaotong.util.ClickUtils;
import client.android.yixiaotong.util.EventBusUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.android.NetworkUtils;
import client.android.yixiaotong.util.bleutils.BLEUtil;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v3.ui.adv.AdvControl;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.stub.StubApp;
import de.greenrobot.event.EventBus;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class ApplicationFragment extends BaseFragment {
    private static final int PAGESIZE = 8;
    ImageView mImgFAQ;
    ImageView mImgMoreNotice;
    ImageView mImgNotice;
    ImageView mImgQrcode;
    ImageView mImgSex;
    SimpleDraweeView mIvMeIcon;
    LinearLayout mLinMeInfo;
    LinearLayout mLlDot;
    MyViewPager mMainViewPager;
    MyPagerGalleryView mNoticePagerGalleryView;
    LinearLayout mOvalLayout;
    private SetPswDialogTip mSetPswDialogTip;
    private State mState;
    PullRefreshLayout mSwipeRefreshLayout;
    TitleBar mTitlebar;
    TextView mTvMeId;
    TextView mTvMeName;
    private UserInfoBean mUserInfoBean;
    private WalletModel mWalletModel;
    private String mSchoolName = "";
    private int mCurIndex = 0;
    private final List<WalletModel> mWalletModels = new ArrayList();
    private boolean mIsEnable = true;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.ui.ApplicationFragment.24
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            if (i == 0) {
                PermissionUtil.requestPerssion(ApplicationFragment.this.getActivity(), 1, ApplicationFragment.this.permissionGrant);
                return;
            }
            if (i == 1) {
                PermissionUtil.requestPerssion(ApplicationFragment.this.getActivity(), 2, ApplicationFragment.this.permissionGrant);
                return;
            }
            if (i != 2) {
                if (i == 3 && ApplicationFragment.this.mState == State.meal) {
                    MealMainActivity.launch(ApplicationFragment.this.getActivity(), ApplicationFragment.this.mWalletModel);
                    return;
                }
                return;
            }
            if (ApplicationFragment.this.mState == State.meal) {
                PermissionUtil.requestPerssion(ApplicationFragment.this.getActivity(), 3, ApplicationFragment.this.permissionGrant);
                return;
            }
            if (ApplicationFragment.this.mState == State.ammeter) {
                ApplicationFragment applicationFragment = ApplicationFragment.this;
                applicationFragment.ammeter(applicationFragment.mWalletModel);
                return;
            }
            if (ApplicationFragment.this.mState == State.bath) {
                BathMainActivity.launch(ApplicationFragment.this.getActivity(), ApplicationFragment.this.mWalletModel);
                return;
            }
            if (ApplicationFragment.this.mState == State.hair) {
                HairDryerMainActivity.launch(ApplicationFragment.this.getActivity(), ApplicationFragment.this.mWalletModel);
                return;
            }
            if (ApplicationFragment.this.mState == State.drink) {
                DrinkWaterMainActivity.launch(ApplicationFragment.this.getActivity(), ApplicationFragment.this.mWalletModel);
                return;
            }
            if (ApplicationFragment.this.mState == State.wash) {
                WashMainActivity.launch(ApplicationFragment.this.getActivity(), ApplicationFragment.this.mWalletModel);
                return;
            }
            if (ApplicationFragment.this.mState == State.entrance) {
                ApplicationFragment.this.selectUserAuth();
                return;
            }
            if (ApplicationFragment.this.mState == State.sellcard) {
                SellCardMainActivity.launch(ApplicationFragment.this.getActivity(), ApplicationFragment.this.mWalletModel);
            } else if (ApplicationFragment.this.mState == State.hamam) {
                ApplicationFragment.this.hamam();
            } else if (ApplicationFragment.this.mState == State.dry) {
                DryMainActivity.launch(ApplicationFragment.this.getActivity(), ApplicationFragment.this.mWalletModel);
            }
        }
    };

    private enum State {
        bath,
        meal,
        ammeter,
        hair,
        drink,
        wash,
        entrance,
        sellcard,
        hamam,
        dry
    }

    private void initViewNew(View view) {
        this.mTitlebar = (TitleBar) view.findViewById(R.id.titlebar);
        this.mSwipeRefreshLayout = (PullRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        this.mIvMeIcon = (SimpleDraweeView) view.findViewById(R.id.iv_me_icon);
        this.mImgSex = (ImageView) view.findViewById(R.id.img_sex);
        this.mTvMeName = (TextView) view.findViewById(R.id.tv_me_name);
        this.mTvMeId = (TextView) view.findViewById(R.id.tv_me_id);
        this.mLinMeInfo = (LinearLayout) view.findViewById(R.id.ll_me_info);
        this.mImgQrcode = (ImageView) view.findViewById(R.id.img_qrcode);
        this.mImgNotice = (ImageView) view.findViewById(R.id.iv_loading);
        this.mNoticePagerGalleryView = (MyPagerGalleryView) view.findViewById(R.id.adgallery);
        this.mOvalLayout = (LinearLayout) view.findViewById(R.id.ovalLayout1);
        this.mMainViewPager = (MyViewPager) view.findViewById(R.id.viewpager);
        this.mLlDot = (LinearLayout) view.findViewById(R.id.ll_dot);
        this.mImgMoreNotice = (ImageView) view.findViewById(R.id.img_more_notice);
        this.mImgFAQ = (ImageView) view.findViewById(R.id.img_faq);
    }

    public static ApplicationFragment newInstance() {
        return new ApplicationFragment();
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_application, (ViewGroup) null);
        initViewNew(viewInflate);
        return viewInflate;
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        initTitleBar();
        initListener();
        initMeInfo();
        getNoticeViewPagerData();
        AdvControl.getInstance().init(getLoginAccount(), getActivity());
        AdvControl.getInstance().getAdvRules();
        getAdvControl();
        initMoreNotice();
        initDialog();
    }

    private void initTitleBar() {
        if (getLoginAccount().getAccountManagetStore().getUserInfo() != null) {
            String str = getLoginAccount().getAccountManagetStore().getUserInfo().SchoolName;
            this.mSchoolName = str;
            this.mTitlebar.setTitleView(str);
            LocalDataUtil.savePlatformInfo(getActivity(), 0);
            LocalDataUtil.savePlatformSchoolName(getActivity(), this.mSchoolName);
            LocalDataUtil.saveSchoolId(getActivity(), getLoginAccount().getAccountManagetStore().getUserInfo().AreaId + "");
        } else {
            AccountManager.getInstance().clearLoginAccount();
            LoginActivity.launch(getActivity());
            getActivity().finish();
        }
        this.mTitlebar.setRightView(R.mipmap.l_shouye_msg);
        this.mTitlebar.setRightViewOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.ApplicationFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GongGaoLanInfoActivity.launch(ApplicationFragment.this.getActivity());
            }
        });
    }

    class SchoolInfo {
        public long schoolId;
        public String schoolName;

        SchoolInfo() {
        }
    }

    @Override // client.android.yixiaotong.BaseFragment, android.app.Fragment
    public void onResume() {
        super.onResume();
        this.mIsEnable = true;
        AdvControl.getInstance().onResume();
        getWalletList();
        getDataStudentInfo();
    }

    @Override // client.android.yixiaotong.BaseFragment, android.app.Fragment
    public void onPause() {
        super.onPause();
        this.mIsEnable = false;
        AdvControl.getInstance().onPause();
    }

    public void onEventMainThread(BalanceSyncEvent balanceSyncEvent) {
        getLocalWalletModels();
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
        EventBusUtil.getInstance().getCommonEventBus().unregister(this);
    }

    private void getDataStudentInfo() {
        this.mTvMeName.getPaint().setFakeBoldText(true);
        UserInfoBean userInfo = getLoginAccount().getAccountManagetStore().getUserInfo();
        this.mUserInfoBean = userInfo;
        if (userInfo == null || !this.mIsEnable) {
            return;
        }
        if (StringUtils.isNotEmpty(userInfo.Icon)) {
            this.mIvMeIcon.setImageURI(UriUtil.parseUriOrNull(this.mUserInfoBean.Icon));
        }
        if (this.mUserInfoBean.GenderId == 1) {
            this.mImgSex.setImageDrawable(getResources().getDrawable(R.mipmap.l_shouye_boy));
        } else {
            this.mImgSex.setImageDrawable(getResources().getDrawable(R.mipmap.l_shouye_girl));
        }
        if (StringUtils.isNotEmpty(this.mUserInfoBean.StudentName)) {
            this.mTvMeName.setText(this.mUserInfoBean.StudentName);
        }
        if (this.mTvMeId != null) {
            String str = this.mUserInfoBean.ID + "";
            if (!StringUtils.isNotEmpty(str) || str.length() <= 4) {
                return;
            }
            this.mTvMeId.setText("ID：**************" + str.substring(str.length() - 4, str.length()));
        }
    }

    private void initMeInfo() {
        this.mImgQrcode.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.ApplicationFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String strSimpleEncrypt;
                View viewInflate = View.inflate(ApplicationFragment.this.getContext(), R.layout.dialog_schoolqrcode, null);
                LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.lin);
                TextView textView = (TextView) viewInflate.findViewById(R.id.tv_schoolname);
                ImageView imageView = (ImageView) viewInflate.findViewById(R.id.img_schoolqrcode);
                final DrinkWaterDialog drinkWaterDialog = new DrinkWaterDialog(ApplicationFragment.this.getContext(), viewInflate, R.style.DrinkWateTextViewDialog);
                drinkWaterDialog.show();
                linearLayout.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.ApplicationFragment.2.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        drinkWaterDialog.dismiss();
                    }
                });
                long j = ApplicationFragment.this.getLoginAccount().getAccountManagetStore().getUserInfo().AreaId;
                SchoolInfo schoolInfo = ApplicationFragment.this.new SchoolInfo();
                schoolInfo.schoolName = ApplicationFragment.this.mSchoolName;
                schoolInfo.schoolId = j;
                try {
                    strSimpleEncrypt = AESHelper.simpleEncrypt(new Gson().toJson(schoolInfo), StringUtils.asciiToString("121,107,116,95,50,48,49,55,95,64,37,48,50,48,95,87,90,81,73,84,83,84,89,85,73,74,104,100,48,56,48,50"));
                } catch (Exception e) {
                    e.printStackTrace();
                    strSimpleEncrypt = "";
                }
                if (StringUtils.isNotEmpty(ApplicationFragment.this.mSchoolName)) {
                    textView.setText(ApplicationFragment.this.mSchoolName);
                }
                imageView.setImageBitmap(QrcodeUtils.createQrcode(strSimpleEncrypt));
            }
        });
        this.mLinMeInfo.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.ApplicationFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserInfoActivity.launch(ApplicationFragment.this.getActivity(), ApplicationFragment.this.mUserInfoBean);
            }
        });
    }

    private void initMoreNotice() {
        this.mImgMoreNotice.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.ApplicationFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GongGaoLanInfoActivity.launch(ApplicationFragment.this.getActivity());
            }
        });
        this.mImgFAQ.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.ApplicationFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MalfunctionRepairActivity.launch(ApplicationFragment.this.getActivity(), 0);
            }
        });
    }

    private void initViewPager() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getActivity());
        int iCeil = (int) Math.ceil((((double) this.mWalletModels.size()) * 1.0d) / 8.0d);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < iCeil; i++) {
            MyGridView myGridView = (MyGridView) layoutInflaterFrom.inflate(R.layout.l_shouye_gridview, (ViewGroup) this.mMainViewPager, false);
            myGridView.setAdapter((ListAdapter) new GridViewAdapter(getActivity(), this.mWalletModels, i, 8));
            arrayList.add(myGridView);
            myGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: client.android.yixiaotong.ui.ApplicationFragment.6
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                    ApplicationFragment.this.gridViewOnClick((WalletModel) adapterView.getAdapter().getItem(i2));
                }
            });
        }
        this.mMainViewPager.setAdapter(new ViewPagerAdapter(arrayList));
        if (iCeil > 1) {
            this.mLlDot.removeAllViews();
            for (int i2 = 0; i2 < iCeil; i2++) {
                this.mLlDot.addView(layoutInflaterFrom.inflate(R.layout.dot, (ViewGroup) null));
            }
            this.mLlDot.getChildAt(0).findViewById(R.id.v_dot).setBackgroundResource(R.drawable.dot_selected);
            this.mMainViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: client.android.yixiaotong.ui.ApplicationFragment.7
                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i3) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i3, float f, int i4) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i3) {
                    ApplicationFragment.this.mLlDot.getChildAt(ApplicationFragment.this.mCurIndex).findViewById(R.id.v_dot).setBackgroundResource(R.drawable.dot_normal);
                    ApplicationFragment.this.mLlDot.getChildAt(i3).findViewById(R.id.v_dot).setBackgroundResource(R.drawable.dot_selected);
                    ApplicationFragment.this.mCurIndex = i3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getWalletList() {
        if (NetworkUtils.isNetworkAvailable(getContext())) {
            BusinessControllers.getInstance().syncWallets(getLoginAccount(), new Listener<List<WalletModel>>() { // from class: client.android.yixiaotong.ui.ApplicationFragment.8
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, List<WalletModel> list, Object... objArr) {
                    if (ApplicationFragment.this.mIsEnable) {
                        if (list != null) {
                            ApplicationFragment.this.setWalletData(list);
                            EventBus.getDefault().post(new WalletSyncEvent());
                            if (ApplicationFragment.this.mSwipeRefreshLayout != null) {
                                ApplicationFragment.this.mSwipeRefreshLayout.setRefreshing(false);
                                return;
                            }
                            return;
                        }
                        ToastUtils.show(ApplicationFragment.this.getContext(), "数据异常，请重新登录");
                        AccountManager.getInstance().clearLoginAccount();
                        LoginActivity.launch(BaseApplication.app);
                        ActivitiesHelper.getInstance().closeExcept(LoginActivity.class);
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (ApplicationFragment.this.mIsEnable) {
                        if (ApplicationFragment.this.mSwipeRefreshLayout != null) {
                            ApplicationFragment.this.mSwipeRefreshLayout.setRefreshing(false);
                        }
                        if (clientException.getCode() != 1001) {
                            ApplicationFragment.this.getLocalWalletModels();
                            return;
                        }
                        ToastUtils.show(ApplicationFragment.this.getContext(), "当前用户已下线，请重新登录");
                        AccountManager.getInstance().clearLoginAccount();
                        LoginActivity.launch(BaseApplication.app);
                        ActivitiesHelper.getInstance().closeExcept(LoginActivity.class);
                    }
                }
            });
        } else {
            getLocalWalletModels();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getLocalWalletModels() {
        BusinessControllers.getInstance().getWalletModels(getLoginAccount(), new Listener<List<WalletModel>>() { // from class: client.android.yixiaotong.ui.ApplicationFragment.9
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<WalletModel> list, Object... objArr) {
                if (list != null && ApplicationFragment.this.mIsEnable) {
                    ApplicationFragment.this.setWalletData(list);
                }
            }
        });
    }

    private void initListener() {
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.ui.ApplicationFragment.10
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                ApplicationFragment.this.getWalletList();
                ApplicationFragment.this.getNoticeViewPagerData();
                AdvControl.getInstance().getAdvRules();
                ApplicationFragment.this.getAdvControl();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWalletData(List<WalletModel> list) {
        if (list == null) {
            return;
        }
        this.mWalletModels.clear();
        for (WalletModel walletModel : list) {
            if (walletModel.typeId != 15) {
                this.mWalletModels.add(walletModel);
            }
        }
        initViewPager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getNoticeViewPagerData() {
        if (!NetworkUtils.isNetworkAvailable(getContext()) || getLoginAccount().getAccountManagetStore().getUserInfo() == null) {
            return;
        }
        BusinessControllers.getInstance().getAnnouncement(getLoginAccount(), getLoginAccount().getAccountManagetStore().getUserInfo().AreaId + "", new Listener<List<GetAnnouncementBean>>() { // from class: client.android.yixiaotong.ui.ApplicationFragment.11
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, final List<GetAnnouncementBean> list, Object... objArr) {
                if (ApplicationFragment.this.mIsEnable) {
                    if (list != null && list.size() > 0) {
                        ApplicationFragment.this.mImgNotice.setVisibility(8);
                        String[] strArr = new String[list.size()];
                        for (int i = 0; i < list.size(); i++) {
                            strArr[i] = list.get(i).UrlImage;
                        }
                        if (ApplicationFragment.this.mNoticePagerGalleryView != null) {
                            ApplicationFragment.this.mNoticePagerGalleryView.start(ApplicationFragment.this.getContext(), strArr, null, 4000, ApplicationFragment.this.mOvalLayout, R.drawable.dot_selected, R.drawable.dot_normal, null, null);
                            ApplicationFragment.this.mNoticePagerGalleryView.setMyOnItemClickListener(new MyPagerGalleryView.MyOnItemClickListener() { // from class: client.android.yixiaotong.ui.ApplicationFragment.11.1
                                @Override // client.android.yixiaotong.ui.widget.MyPagerGalleryView.MyOnItemClickListener
                                public void onItemClick(int i2) {
                                    GongGaoLanDetailActivity.launch(ApplicationFragment.this.getActivity(), ((GetAnnouncementBean) list.get(i2)).ID);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    ApplicationFragment.this.mImgNotice.setVisibility(0);
                }
            }
        });
    }

    private void initDialog() {
        this.mSetPswDialogTip = new SetPswDialogTip(getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ammeter(final WalletModel walletModel) {
        if (ClickUtils.isFastDoubleClick()) {
            return;
        }
        if (walletModel.refund == 1) {
            RefundProgressActivity.launch(getActivity(), walletModel);
            return;
        }
        if (BLEUtil.isBluetoothLeSupported(getActivity())) {
            if (AppAccountManager.getInstance().getAppManagerAccount(walletModel.typeId) == walletModel.typeId) {
                View viewInflate = View.inflate(getActivity(), R.layout.ammeter_select_operate, null);
                TextView textView = (TextView) viewInflate.findViewById(R.id.tv_init);
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_set);
                TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_destroy);
                TextView textView4 = (TextView) viewInflate.findViewById(R.id.tv_change);
                TextView textView5 = (TextView) viewInflate.findViewById(R.id.tv_rechargerecord);
                TextView textView6 = (TextView) viewInflate.findViewById(R.id.tv_chongzhi);
                TextView textView7 = (TextView) viewInflate.findViewById(R.id.tv_cancel);
                final DrinkWaterDialog drinkWaterDialog = new DrinkWaterDialog(getContext(), viewInflate, R.style.DrinkWateTextViewDialog);
                drinkWaterDialog.show();
                textView.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.ApplicationFragment.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        drinkWaterDialog.dismiss();
                        HuaWeiScanActivity.launch(ApplicationFragment.this.getActivity(), walletModel, 1);
                    }
                });
                textView2.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.ApplicationFragment.13
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        drinkWaterDialog.dismiss();
                        SearchAmmeterActivity.launch(ApplicationFragment.this.getActivity(), walletModel, "", 2, 1);
                    }
                });
                textView3.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.ApplicationFragment.14
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        drinkWaterDialog.dismiss();
                        SearchAmmeterActivity.launch(ApplicationFragment.this.getActivity(), walletModel, "", 3, 1);
                    }
                });
                textView4.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.ApplicationFragment.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        drinkWaterDialog.dismiss();
                        AmmeterDataCollectionActivity.launch(ApplicationFragment.this.getActivity(), walletModel);
                    }
                });
                textView5.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.ApplicationFragment.16
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        drinkWaterDialog.dismiss();
                        SearchAmmeterActivity.launch(ApplicationFragment.this.getActivity(), walletModel, "", 7, 1);
                    }
                });
                textView6.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.ApplicationFragment.17
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        drinkWaterDialog.dismiss();
                        ApplicationFragment.this.isBindAmmeter(walletModel);
                    }
                });
                textView7.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.ApplicationFragment.18
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        drinkWaterDialog.dismiss();
                    }
                });
                return;
            }
            isBindAmmeter(walletModel);
            return;
        }
        Toast.makeText(getActivity(), "你的手机不支持蓝牙4.0", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void isBindAmmeter(final WalletModel walletModel) {
        BusinessControllers.getInstance().ammeterIsBindRoom(getLoginAccount(), walletModel.typeId + "", getLoginAccount().getAccountManagetStore().getUserInfo().AreaId + "", new Listener<AmmeterBindRoomBean>() { // from class: client.android.yixiaotong.ui.ApplicationFragment.19
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(ApplicationFragment.this.getActivity(), "加载中..", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, AmmeterBindRoomBean ammeterBindRoomBean, Object... objArr) {
                if (ammeterBindRoomBean == null || !ApplicationFragment.this.mIsEnable) {
                    return;
                }
                BaseMaterialDialog.dissmisMaterialDialog();
                if (ammeterBindRoomBean != null && ApplicationFragment.this.mIsEnable && StringUtils.isNotEmpty(ammeterBindRoomBean.machineid) && StringUtils.isNotEmpty(ammeterBindRoomBean.devicemac)) {
                    SelectOperateActivity.launch(ApplicationFragment.this.getActivity(), walletModel, ammeterBindRoomBean.devicemac, ammeterBindRoomBean.machineid);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (ApplicationFragment.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (clientException.getCode() == 4048) {
                        SelectAmmeterAddressActivity.launch(ApplicationFragment.this.getActivity(), 1, walletModel);
                    } else if (clientException.getCode() == 4049) {
                        ToastUtils.show(ApplicationFragment.this.getActivity(), "您的宿舍没安装电表！");
                        SelectOperateActivity.launch(ApplicationFragment.this.getActivity(), walletModel, "", "");
                    } else {
                        ErrorUtil.onFailResult(ApplicationFragment.this.getActivity(), ApplicationFragment.this.mTitlebar.getTitleViewContent(), clientException, false);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hamam() {
        BusinessControllers.getInstance().getBathHousePassword(getLoginAccount(), this.mWalletModel.typeId, RandomUtil.getRandNumMaxString(6), new Listener<BathHousePasswordBean>() { // from class: client.android.yixiaotong.ui.ApplicationFragment.20
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, BathHousePasswordBean bathHousePasswordBean, Object... objArr) {
                String strDecrypt;
                if (ApplicationFragment.this.mIsEnable) {
                    if (bathHousePasswordBean == null || !StringUtils.isNotEmpty(bathHousePasswordBean.typePassword)) {
                        ApplicationFragment.this.mSetPswDialogTip.showSetPswDialog();
                        ApplicationFragment.this.mSetPswDialogTip.waitOnclick();
                        ApplicationFragment.this.mSetPswDialogTip.confirmOnclick();
                        return;
                    }
                    try {
                        strDecrypt = AESHelper.decrypt(bathHousePasswordBean.typePassword, StringUtils.asciiToString("121,107,116,95,50,48,49,55,95,64,37,48,50,48,95,87,90,81,73,84,83,84,89,85,73,74,104,100,48,56,48,50"));
                    } catch (Exception e) {
                        e.printStackTrace();
                        strDecrypt = "";
                    }
                    if (StringUtils.isNotEmpty(strDecrypt) && strDecrypt.length() == 10) {
                        LocalBusinessStore.saveAuthorizedPassword(ApplicationFragment.this.getContext(), ApplicationFragment.this.getLoginAccount().getUid(), strDecrypt);
                        Log.e("test", "max:" + ApplicationFragment.this.mWalletModel.max);
                        if (ApplicationFragment.this.mWalletModel.getBalance() >= ApplicationFragment.this.mWalletModel.max) {
                            HamamMainActivity.launch(ApplicationFragment.this.getActivity(), ApplicationFragment.this.mWalletModel);
                            return;
                        } else {
                            TwoButtonDialog.getInstance().showDialog(ApplicationFragment.this.getActivity(), new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.ui.ApplicationFragment.20.1
                                @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
                                public void onCancle() {
                                }

                                @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
                                public void onConfirm() {
                                    WalletDetailActivity.launch(ApplicationFragment.this.getActivity(), ApplicationFragment.this.mWalletModel);
                                }
                            }, "温馨提示", "钱包余额不足，请充值后使用", "暂不需要", "马上充值");
                            return;
                        }
                    }
                    SystemErrorTip.getInstance().showTipDialog(ApplicationFragment.this.getActivity(), "获取授权密钥失败");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (ApplicationFragment.this.mIsEnable) {
                    ErrorUtil.onFailResult(ApplicationFragment.this.getActivity(), ApplicationFragment.this.mTitlebar.getTitleViewContent(), clientException, false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectUserAuth() {
        final String randNumMaxString = RandomUtil.getRandNumMaxString(6);
        BusinessControllers.getInstance().getSelectUserAuthenticationStatus(getLoginAccount(), this.mWalletModel.typeId, randNumMaxString, new Listener<SelectUserAuthenticationBean>() { // from class: client.android.yixiaotong.ui.ApplicationFragment.21
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SelectUserAuthenticationBean selectUserAuthenticationBean, Object... objArr) {
                if (ApplicationFragment.this.mIsEnable && StringUtils.isNotEmpty(selectUserAuthenticationBean.random) && randNumMaxString.equals(selectUserAuthenticationBean.random)) {
                    if (selectUserAuthenticationBean.type == 0) {
                        int doorLockAuthCount = LocalBusinessStore.getDoorLockAuthCount(ApplicationFragment.this.getContext());
                        int doorLockMaxAuthCount = LocalBusinessStore.getDoorLockMaxAuthCount(ApplicationFragment.this.getContext());
                        if (doorLockAuthCount == 0 || doorLockAuthCount < doorLockMaxAuthCount) {
                            AuthenticationActivity.launch(ApplicationFragment.this.getActivity(), ApplicationFragment.this.mWalletModel);
                            return;
                        } else {
                            TwoButtonDialog.getInstance().showDialog(ApplicationFragment.this.getActivity(), new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.ui.ApplicationFragment.21.1
                                @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
                                public void onCancle() {
                                }

                                @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
                                public void onConfirm() {
                                    AuthenticationActivity.launch(ApplicationFragment.this.getActivity(), ApplicationFragment.this.mWalletModel);
                                }
                            }, "验证失败", StringUtils.isNotEmpty(selectUserAuthenticationBean.message) ? selectUserAuthenticationBean.message : "请联系管理员处理或重新认证", "取消", "重新认证");
                            return;
                        }
                    }
                    if (selectUserAuthenticationBean.type == 1) {
                        SystemErrorTip.getInstance().showTipDialog(ApplicationFragment.this.getActivity(), "验证失败", StringUtils.isNotEmpty(selectUserAuthenticationBean.message) ? selectUserAuthenticationBean.message : "部分信息不匹配,待审核中请耐心等待", "确认");
                    } else if (selectUserAuthenticationBean.type == 2) {
                        DoorLockMainActivity.launch(ApplicationFragment.this.getActivity(), ApplicationFragment.this.mWalletModel);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (ApplicationFragment.this.mIsEnable) {
                    ErrorUtil.onFailResult(ApplicationFragment.this.getActivity(), ApplicationFragment.this.mTitlebar.getTitleViewContent(), clientException, false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridViewOnClick(WalletModel walletModel) {
        if (!NetworkUtils.isNetworkAvailable(getContext())) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), "请打开网络");
            return;
        }
        this.mWalletModel = walletModel;
        if (walletModel != null) {
            if (walletModel.refund == 1) {
                RefundProgressActivity.launch(getActivity(), walletModel);
                return;
            }
            if (walletModel.typeId == 5) {
                if (walletModel.getBalance() == 0) {
                    TwoButtonDialog.getInstance().showDialog(getActivity(), new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.ui.ApplicationFragment.22
                        @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
                        public void onCancle() {
                        }

                        @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
                        public void onConfirm() {
                            WalletDetailActivity.launch(ApplicationFragment.this.getActivity(), ApplicationFragment.this.mWalletModel);
                        }
                    }, "温馨提示", "钱包余额不足，请充值后使用", "暂不需要", "马上充值");
                    return;
                } else {
                    this.mState = State.meal;
                    PermissionUtil.requestPerssion(getActivity(), 2, this.permissionGrant);
                    return;
                }
            }
            if (walletModel.typeId == 7) {
                this.mState = State.ammeter;
                PermissionUtil.requestPerssion(getActivity(), 0, this.permissionGrant);
                return;
            }
            if (walletModel.typeId == 1) {
                if (walletModel.getBalance() == 0) {
                    TwoButtonDialog.getInstance().showDialog(getActivity(), new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.ui.ApplicationFragment.23
                        @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
                        public void onCancle() {
                        }

                        @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
                        public void onConfirm() {
                            WalletDetailActivity.launch(ApplicationFragment.this.getActivity(), ApplicationFragment.this.mWalletModel);
                        }
                    }, "温馨提示", "钱包余额不足，请充值后使用", "暂不需要", "马上充值");
                    return;
                } else if (this.mWalletModel.max > this.mWalletModel.getBalance()) {
                    SystemErrorTip.getInstance().showTipDialog(getActivity(), "当前余额少于最低消费额，无法使用此功能");
                    return;
                } else {
                    this.mState = State.bath;
                    PermissionUtil.requestPerssion(getActivity(), 0, this.permissionGrant);
                    return;
                }
            }
            if (walletModel.typeId == 8) {
                this.mState = State.hair;
                PermissionUtil.requestPerssion(getActivity(), 0, this.permissionGrant);
                return;
            }
            if (walletModel.typeId == 6) {
                this.mState = State.drink;
                PermissionUtil.requestPerssion(getActivity(), 0, this.permissionGrant);
                return;
            }
            if (walletModel.typeId == 3) {
                this.mState = State.wash;
                PermissionUtil.requestPerssion(getActivity(), 0, this.permissionGrant);
                return;
            }
            if (walletModel.typeId == 10) {
                this.mState = State.entrance;
                PermissionUtil.requestPerssion(getActivity(), 0, this.permissionGrant);
                return;
            }
            if (walletModel.typeId == 9) {
                this.mState = State.sellcard;
                PermissionUtil.requestPerssion(getActivity(), 0, this.permissionGrant);
                return;
            }
            if (walletModel.typeId == 11) {
                hamam();
                return;
            }
            if (walletModel.typeId == 17) {
                ToastUtils.show(getContext(), "暂未开通，敬请期待");
            } else if (walletModel.typeId == 16) {
                this.mState = State.dry;
                PermissionUtil.requestPerssion(getActivity(), 0, this.permissionGrant);
            } else {
                ToastUtils.show(getContext(), "暂未开通，敬请期待");
            }
        }
    }

    @Override // android.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        StubApp.interface22(i, strArr, iArr);
        PermissionUtil.requestPermissionsResult(getActivity(), i, strArr, iArr, this.permissionGrant);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getAdvControl() {
        BusinessControllers.getInstance().getAdvertisingControl(getLoginAccount(), new Listener<AdvControlListBean>() { // from class: client.android.yixiaotong.ui.ApplicationFragment.25
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, AdvControlListBean advControlListBean, Object... objArr) {
                if (ApplicationFragment.this.mIsEnable) {
                    LocalBusinessStore.saveIsOpenAdv(BaseApplication.app, true);
                }
            }
        });
    }
}
