package client.android.yixiaotong;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.account.AccountManager;
import client.android.yixiaotong.baseutil.ActivitiesHelper;
import client.android.yixiaotong.exception.HttpException;
import client.android.yixiaotong.ui.WelcomeActivity;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.login.LoginActivity;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.byazt.bv.BaseConstants;
import crossoverone.statuslib.StatusUtil;
import java.util.Locale;
import lxt.com.a.S;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class BaseActivity extends FragmentActivity implements BaseInterface {
    public static final String LANGUAGEEN = "en";
    private static final int SYSTEM_UI_FLAG_OP_STATUS_BAR_TINT = 16;
    private static final String TAG = "BaseActivity";
    private ProgressDialog dialog;
    private boolean isCallPostCreate;
    private boolean isVisible;
    private Handler mHandler;
    private int dialogOpenTimes = 0;
    private Object dialogLock = new Object();

    /* JADX INFO: Access modifiers changed from: protected */
    public Activity getActivity() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public void onPostCreate() {
    }

    static /* synthetic */ int access$106(BaseActivity baseActivity) {
        int i = baseActivity.dialogOpenTimes - 1;
        baseActivity.dialogOpenTimes = i;
        return i;
    }

    static /* synthetic */ int access$108(BaseActivity baseActivity) {
        int i = baseActivity.dialogOpenTimes;
        baseActivity.dialogOpenTimes = i + 1;
        return i;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT != 26 && getRequestedOrientation() != 1) {
            setRequestedOrientation(1);
        }
        ActivitiesHelper.getInstance().addActivity(this);
        StatusUtil.setSystemStatus(getActivity(), false, true);
        StatusUtil.setUseStatusBarColor(getActivity(), 855638016);
        setOPPOStatusTextColor(true, getActivity());
        setStatusBarColor(getResources().getColor(R.color.white));
        LogUtil.e(TAG, "onCreate");
        initLang();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.isVisible = true;
        if (!this.isCallPostCreate) {
            this.isCallPostCreate = true;
            onPostCreate();
        }
        if (!S.b(getContext())) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), "提示", "签名异常，请到各大市场下载正版乐校通APP", "我知道了", false, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.BaseActivity.1
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    BaseActivity.this.getActivity().finish();
                }
            });
        }
        LogUtil.e(TAG, "onResume");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.isVisible = false;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        ActivitiesHelper.getInstance().removeActivity(this);
        LogUtil.e(TAG, "onDestroy");
    }

    protected void closeAllActivity() {
        ActivitiesHelper.getInstance().closeAll();
    }

    public void runOnUiThread(Runnable runnable, long j) {
        if (runnable != null) {
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            try {
                this.mHandler.postDelayed(runnable, Math.max(0L, j));
            } catch (Exception unused) {
            }
        }
    }

    public Account getLoginAccount() {
        return AccountManager.getInstance().getLoginAccount();
    }

    @Override // client.android.yixiaotong.BaseInterface
    public void onWaitStart(final String str) {
        runOnUiThread(new Runnable() { // from class: client.android.yixiaotong.BaseActivity.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (BaseActivity.this.dialogLock) {
                    if (BaseActivity.access$108(BaseActivity.this) == 0) {
                        try {
                            BaseActivity baseActivity = BaseActivity.this;
                            baseActivity.dialog = ProgressDialog.show(baseActivity.getActivity(), null, str);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    @Override // client.android.yixiaotong.BaseInterface
    public void onWaitEnd() {
        runOnUiThread(new Runnable() { // from class: client.android.yixiaotong.BaseActivity.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (BaseActivity.this.dialogLock) {
                    if (BaseActivity.access$106(BaseActivity.this) <= 0) {
                        if (BaseActivity.this.dialog != null && BaseActivity.this.dialog.isShowing()) {
                            try {
                                BaseActivity.this.dialog.dismiss();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            BaseActivity.this.dialog = null;
                        }
                        BaseActivity.this.dialogOpenTimes = 0;
                    }
                }
            }
        });
    }

    @Override // client.android.yixiaotong.BaseInterface
    public void toast(String str) {
        Toast.makeText(BaseApplication.app, str, 0).show();
    }

    @Override // client.android.yixiaotong.BaseInterface
    public void handlerException(Exception exc) {
        if (exc instanceof HttpException) {
            toast(((HttpException) exc).getDetail());
        }
    }

    private void setOPPOStatusTextColor(boolean z, Activity activity) {
        if (Build.MANUFACTURER.equals(BaseConstants.ROM_OPPO_UPPER_CONSTANT)) {
            Window window = activity.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
            window.getDecorView().setSystemUiVisibility(z ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
        }
    }

    public void exitLogin() {
        AccountManager.getInstance().clearLoginAccount();
        LoginActivity.launch(getActivity());
        closeAllActivity();
    }

    private void initLang() {
        Locale locale;
        Resources resources = getResources();
        Configuration configuration = resources.getConfiguration();
        Locale.getDefault();
        String lanuage = LocalDataUtil.getLanuage(this);
        if (StringUtils.isNotEmpty(lanuage) && LANGUAGEEN.equals(lanuage)) {
            locale = Locale.ENGLISH;
        } else {
            locale = Locale.CHINA;
        }
        LogUtil.e(TAG, "当前语言：" + lanuage + "  " + locale.getLanguage());
        configuration.locale = locale;
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }

    protected void switchLang(String str) {
        LogUtil.e(TAG, "切换语言：" + str);
        LocalDataUtil.saveLanuaging(this, true);
        closeAllActivity();
        startActivity(WelcomeActivity.class);
    }

    private void startActivity(Class<? extends BaseActivity> cls) {
        startActivity(new Intent(this, cls));
    }

    protected void setStatusBarColor(int i) {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.setStatusBarColor(i);
    }
}
