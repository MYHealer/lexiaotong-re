package client.android.yixiaotong.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.HelloBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.login.LoginActivity;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import client.android.yixiaotong.v3.ui.V3MainActivity;
import client.android.yixiaotong.v3.ui.adv.AdvControlUtil;
import client.android.yixiaotong.v3.ui.adv.Common;
import client.android.yixiaotong.v3.ui.adv.ShouYeInsertUtil;
import client.android.yixiaotong.v3.ui.adv.SplashUtil;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.ui.V4MainActivity;
import client.android.yixiaotong.v4.util.homeinfo.V4HomeInfoUtil;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class WelcomeActivity extends BaseActivity {
    private static final String TAG = "WelcomeActivity";
    FrameLayout fl;
    private AdvControlUtil.AdvListener mAdvListener;
    RelativeLayout mRelAdvLogo;
    private SplashUtil mSplashUtil;
    private boolean mIsEnable = true;
    private boolean mIsStartLaunch = false;
    private boolean mIsHotLaunch = false;
    private String schoolid = "";
    private boolean mIsOpenSplash = false;

    static {
        StubApp.interface11(6118);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadNative() {
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        activity.startActivity(new Intent(activity, (Class<?>) WelcomeActivity.class));
        activity.finish();
    }

    private void initViewNew() {
        this.fl = (FrameLayout) findViewById(R.id.fl);
        this.mRelAdvLogo = (RelativeLayout) findViewById(R.id.rel_advlogo);
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.WelcomeActivity$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LocalDataUtil.getIsSaveLanuaging(WelcomeActivity.this.getActivity())) {
                WelcomeActivity.this.load();
            } else {
                WelcomeActivity.this.getAdv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void load() {
        LogUtil.e(TAG, "load:" + this.mIsStartLaunch);
        if (this.mIsStartLaunch) {
            return;
        }
        this.mIsStartLaunch = true;
        BusinessControllers.getInstance().welcome(getLoginAccount(), new Listener<HelloBean>() { // from class: client.android.yixiaotong.ui.WelcomeActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, HelloBean helloBean, Object... objArr) {
                LogUtil.e(WelcomeActivity.TAG, "load:" + helloBean.needIntroduct + "  " + helloBean.needLogin);
                if (helloBean.needIntroduct) {
                    GuideActivity.launch(WelcomeActivity.this.getActivity(), helloBean.needLogin);
                    return;
                }
                if (helloBean.needLogin) {
                    LoginActivity.launch(WelcomeActivity.this.getActivity());
                    return;
                }
                if (LocalDataUtil.getPlatformInfo(WelcomeActivity.this.getContext()) == 1) {
                    V3MainActivity.launch(WelcomeActivity.this.getActivity());
                } else if (LocalDataUtil.getPlatformInfo(WelcomeActivity.this.getContext()) == 4) {
                    V4MainActivity.launch(WelcomeActivity.this.getActivity());
                } else {
                    MainActivity.launch(WelcomeActivity.this.getActivity());
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                LoginActivity.launch(WelcomeActivity.this.getActivity());
            }
        });
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        LogUtil.e(TAG, "onResume:");
        this.mIsStartLaunch = false;
        this.mIsEnable = true;
        SplashUtil splashUtil = this.mSplashUtil;
        if (splashUtil != null) {
            splashUtil.onResume();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        LogUtil.e(TAG, "onPause:");
        SplashUtil splashUtil = this.mSplashUtil;
        if (splashUtil != null) {
            splashUtil.onPause();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        LogUtil.e(TAG, "onStop:");
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        SplashUtil splashUtil = this.mSplashUtil;
        if (splashUtil != null) {
            splashUtil.onDestroy();
        }
        super.onDestroy();
        this.mIsEnable = false;
        LogUtil.e(TAG, "onDestroy");
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 || i == 3) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getAdv() {
        boolean z;
        if (LocalDataUtil.getPlatformInfo(getContext()) == 4) {
            getAdvV4();
            return;
        }
        if (LocalDataUtil.getPlatformInfo(getContext()) == 1) {
            this.schoolid = UserInfoUtilControl.getInstance().getSchoolId();
            z = true;
        } else {
            if (getLoginAccount().getAccountManagetStore().getUserInfo() != null) {
                this.schoolid = getLoginAccount().getAccountManagetStore().getUserInfo().AreaId + "";
            } else {
                this.schoolid = LocalBusinessStore.getSchoolId(getActivity());
            }
            z = false;
        }
        LogUtil.e(TAG, "schoolid:" + this.schoolid);
        initAdvData();
        int advlaunchCount = LocalDataUtil.getAdvlaunchCount(getActivity(), 1);
        long splashPlayTime = LocalDataUtil.getSplashPlayTime(getActivity());
        long jCurrentTimeMillis = System.currentTimeMillis() - splashPlayTime;
        LogUtil.e(TAG, "已看开屏广告次数：" + advlaunchCount + "  " + splashPlayTime + "  " + jCurrentTimeMillis);
        if (StringUtils.isNotEmpty(this.schoolid)) {
            AdvControlUtil.getInstance().init(getActivity(), this.mAdvListener, 0, z, this.schoolid);
            if (AdvControlUtil.getInstance().isNeedLoadAdv(getActivity()) || (jCurrentTimeMillis > 30000 && advlaunchCount < 5)) {
                AdvControlUtil.getInstance().initAdvInfo();
                return;
            } else {
                load();
                return;
            }
        }
        load();
    }

    private void getAdvV4() {
        SplashUtil splashUtil = new SplashUtil();
        this.mSplashUtil = splashUtil;
        splashUtil.onResume();
        this.mAdvListener = new AdvControlUtil.AdvListener() { // from class: client.android.yixiaotong.ui.WelcomeActivity.3
            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void isOpen(int i, int i2, int i3, int i4, int i5) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdClosed(Common.AdvType advType) {
                LogUtil.e(WelcomeActivity.TAG, "onAdClosed：" + WelcomeActivity.this.mIsEnable);
                if (WelcomeActivity.this.mIsEnable) {
                    WelcomeActivity.this.load();
                }
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onRenderSuccess(View view, int i) {
                LogUtil.e(WelcomeActivity.TAG, "onRenderSuccess");
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdShow(String str, Common.AdvType advType) {
                LogUtil.e(WelcomeActivity.TAG, "onAdShow：" + str);
                LocalDataUtil.saveAdvlaunchCount(WelcomeActivity.this.getActivity(), 1);
                LocalDataUtil.saveSplashPlayTime(WelcomeActivity.this.getActivity(), System.currentTimeMillis());
                MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.ui.WelcomeActivity.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (WelcomeActivity.this.mIsEnable) {
                            WelcomeActivity.this.mRelAdvLogo.setVisibility(0);
                        }
                    }
                });
            }
        };
        int advlaunchCount = LocalDataUtil.getAdvlaunchCount(getActivity(), 1);
        long splashPlayTime = LocalDataUtil.getSplashPlayTime(getActivity());
        long jCurrentTimeMillis = System.currentTimeMillis() - splashPlayTime;
        LogUtil.e(TAG, "已看开屏广告次数：" + advlaunchCount + "  " + splashPlayTime + "  " + jCurrentTimeMillis);
        if (LocalDataUtil.getPlatformInfo(getContext()) == 4 && V4HomeInfoUtil.getInstance().isOpenAdv()) {
            if (AdvControlUtil.getInstance().isNeedLoadAdv(getActivity()) || (jCurrentTimeMillis > 30000 && advlaunchCount < 5)) {
                this.mIsOpenSplash = true;
                this.mSplashUtil.initSplash(getActivity(), this.mAdvListener, 5, this.mIsHotLaunch);
                this.mSplashUtil.onSplash(this.fl);
                if (this.mIsHotLaunch) {
                    return;
                }
                loadInsert();
                loadNative();
                return;
            }
            load();
            return;
        }
        load();
    }

    private void initAdvData() {
        SplashUtil splashUtil = new SplashUtil();
        this.mSplashUtil = splashUtil;
        splashUtil.onResume();
        this.mAdvListener = new AdvControlUtil.AdvListener() { // from class: client.android.yixiaotong.ui.WelcomeActivity.4
            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void isOpen(int i, int i2, int i3, int i4, int i5) {
                LogUtil.e(WelcomeActivity.TAG, "isOpen ShouYe:" + i + PPSLabelView.Code + i2 + PPSLabelView.Code + i4 + PPSLabelView.Code + i5 + PPSLabelView.Code + WelcomeActivity.this.mIsHotLaunch);
                if (i4 == 1) {
                    WelcomeActivity.this.mIsOpenSplash = true;
                    WelcomeActivity.this.mSplashUtil.initSplash(WelcomeActivity.this.getActivity(), WelcomeActivity.this.mAdvListener, 5, WelcomeActivity.this.mIsHotLaunch);
                    WelcomeActivity.this.mSplashUtil.onSplash(WelcomeActivity.this.fl);
                }
                if (i == 1 && !WelcomeActivity.this.mIsHotLaunch) {
                    WelcomeActivity.this.loadInsert();
                }
                if (i5 == 1 && !WelcomeActivity.this.mIsHotLaunch) {
                    WelcomeActivity.this.loadNative();
                }
                if (i4 == -1) {
                    WelcomeActivity.this.load();
                }
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdClosed(Common.AdvType advType) {
                LogUtil.e(WelcomeActivity.TAG, "onAdClosed：" + WelcomeActivity.this.mIsEnable);
                if (WelcomeActivity.this.mIsEnable) {
                    WelcomeActivity.this.load();
                }
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onRenderSuccess(View view, int i) {
                LogUtil.e(WelcomeActivity.TAG, "onRenderSuccess");
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdShow(String str, Common.AdvType advType) {
                LogUtil.e(WelcomeActivity.TAG, "onAdShow：" + str);
                LocalDataUtil.saveAdvlaunchCount(WelcomeActivity.this.getActivity(), 1);
                LocalDataUtil.saveSplashPlayTime(WelcomeActivity.this.getActivity(), System.currentTimeMillis());
                MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.ui.WelcomeActivity.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (WelcomeActivity.this.mIsEnable) {
                            WelcomeActivity.this.mRelAdvLogo.setVisibility(0);
                        }
                    }
                });
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadInsert() {
        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.WelcomeActivity.5
            @Override // java.lang.Runnable
            public void run() {
                if (WelcomeActivity.this.mIsOpenSplash) {
                    ShouYeInsertUtil.getInstance().onCreate(WelcomeActivity.this.getActivity(), true);
                    ShouYeInsertUtil.getInstance().initInsert(WelcomeActivity.this.getActivity(), WelcomeActivity.this.mAdvListener, true, "", true);
                    ShouYeInsertUtil.getInstance().onInsert();
                }
            }
        }, 100L);
    }
}
