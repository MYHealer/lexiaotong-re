package com.yfanads.android.adx.core;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;
import com.yfanads.android.adx.core.impl.h;
import com.yfanads.android.adx.core.model.ApiBean;
import com.yfanads.android.utils.YFLog;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class TransparentActivity extends Activity {
    public static final String EXTRA_APP_NAME = "app_name";
    public static final String EXTRA_LAUNCH_URI = "launch_uri";
    public static final String EXTRA_NPD = "npd";
    public static final String EXTRA_NPDW = "npdw";
    public static final String EXTRA_PACKAGE_NAME = "package_name";
    public static final String EXTRA_REF_NAME = "ref_pkg";
    public static final String EXTRA_TYPE = "j_type";
    private static final long IMMEDIATE_RETURN_THRESHOLD = 500;
    private static final long LAUNCH_PROCESSING_TIME = 300;
    private static final long MIN_LAUNCH_TIME = 100;
    private static final long QUICK_RETURN_THRESHOLD = 8000;
    private static final int REQUEST_CODE_LAUNCH_APP = 9901;
    private static final long RESUME_INTERVAL_THRESHOLD = 200;
    public static final String TAG = "Router";
    private static a launchResultCallback;
    private ApiBean apiBean;
    private String appName;
    private boolean isV2Suc;
    private long launchTime;
    private String launchUri;
    private String npd;
    private String npdw;
    private String packageName;
    private String refPkg;
    private com.yfanads.android.adx.service.a type;
    private long lastResumeTime = 0;
    private long onActivityResultTime = 0;
    private boolean onActivityResultCalled = false;
    private int activityResultCode = -1;
    private final AtomicBoolean onActivityResultEventHandled = new AtomicBoolean(false);
    private final Handler handler = new Handler();
    private boolean isFinished = false;
    private boolean hasLaunched = false;

    public interface a {
    }

    static {
        StubApp.interface11(55982);
    }

    private void compensation(long j) {
        if (j > QUICK_RETURN_THRESHOLD) {
            this.handler.removeCallbacksAndMessages(null);
            finishWithResult("user_likely_accepted_and_returned", j);
            a aVar = launchResultCallback;
            if (aVar != null) {
                ((com.yfanads.android.adx.router.a) aVar).a(this.appName, j);
            }
        }
    }

    private void handleAppNotInstalled() {
    }

    private void handleLaunchException(Exception exc) {
        com.yfanads.android.adx.utils.a.a("Router 启动应用异常: " + this.packageName + exc.getMessage());
    }

    private boolean isInWhite() {
        try {
            if (TextUtils.isEmpty(this.npdw)) {
                return false;
            }
            if (TextUtils.isEmpty(this.launchUri)) {
                YFLog.error("Router dp is empty");
                return true;
            }
            for (String str : this.npdw.split(",")) {
                if (str != null) {
                    String strTrim = str.trim();
                    if (!strTrim.isEmpty() && this.launchUri.startsWith(strTrim)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isV1() {
        return TextUtils.isEmpty(this.npd);
    }

    private void launchThirdPartyApp() {
        try {
            if (isV1() || isInWhite()) {
                YFLog.high("Router V1");
                startRouterV1();
            } else {
                YFLog.high("Router V2");
                startRouterV2();
            }
        } catch (Exception e) {
            this.hasLaunched = true;
            handleLaunchException(e);
            long jCurrentTimeMillis = System.currentTimeMillis() - this.launchTime;
            finishWithResult("launch_exception", jCurrentTimeMillis);
            a aVar = launchResultCallback;
            if (aVar != null) {
                ((com.yfanads.android.adx.router.a) aVar).a(this.appName, "启动异常: " + e.getMessage(), jCurrentTimeMillis);
            }
        }
    }

    public static void setLaunchResultCallback(a aVar) {
        launchResultCallback = aVar;
    }

    private void setupTimeDetection() {
        this.handler.postDelayed(new Runnable() { // from class: com.yfanads.android.adx.core.TransparentActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1186xc111dd0c();
            }
        }, 800L);
        this.handler.postDelayed(new Runnable() { // from class: com.yfanads.android.adx.core.TransparentActivity$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1187xb2bb832b();
            }
        }, 8300L);
    }

    private void setupTransparentStatusBar() {
        Window window = getWindow();
        window.addFlags(67108864);
        window.addFlags(16);
        window.addFlags(8);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = 1;
        attributes.height = 1;
        attributes.gravity = 51;
        attributes.x = 0;
        attributes.y = 0;
        window.setAttributes(attributes);
        window.setBackgroundDrawableResource(R.color.transparent);
    }

    private void startRouterV1() {
        String str = this.launchUri;
        Intent launchIntentForPackage = (str == null || str.isEmpty()) ? getPackageManager().getLaunchIntentForPackage(this.packageName) : new Intent("android.intent.action.VIEW", Uri.parse(this.launchUri));
        if (launchIntentForPackage != null) {
            launchIntentForPackage.addFlags(268435456);
            startActivityForResult(launchIntentForPackage, REQUEST_CODE_LAUNCH_APP);
            this.hasLaunched = true;
        } else {
            handleAppNotInstalled();
            finishWithResult("app_not_installed", 0L);
            a aVar = launchResultCallback;
            if (aVar != null) {
                ((com.yfanads.android.adx.router.a) aVar).a(this.appName, "应用未安装", 0L);
            }
        }
    }

    private void startRouterV2() {
        this.isV2Suc = new h().navigation(this, this.apiBean);
        this.hasLaunched = true;
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.yfanads.android.adx.utils.a.a("Router onActivityResult " + i + PPSLabelView.Code + i2);
        if (i == REQUEST_CODE_LAUNCH_APP && i2 == 0 && this.onActivityResultEventHandled.compareAndSet(false, true)) {
            this.onActivityResultCalled = true;
            this.onActivityResultTime = System.currentTimeMillis();
            this.activityResultCode = i2;
        }
    }

    @Override // android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.handler.removeCallbacksAndMessages(null);
        launchResultCallback = null;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        long jCurrentTimeMillis = System.currentTimeMillis() - this.launchTime;
        com.yfanads.android.adx.utils.a.a("RouteronPause:" + jCurrentTimeMillis + ", isV2: " + this.isV2Suc);
        if (jCurrentTimeMillis < 100 || this.isFinished || this.isV2Suc || jCurrentTimeMillis > 500 || jCurrentTimeMillis <= LAUNCH_PROCESSING_TIME) {
            return;
        }
        this.handler.removeCallbacksAndMessages(null);
        finishWithResult("user_likely_refused_on_pause", jCurrentTimeMillis);
        a aVar = launchResultCallback;
        if (aVar != null) {
            ((com.yfanads.android.adx.router.a) aVar).a(this.appName, "用户在切换时拒绝", jCurrentTimeMillis);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        com.yfanads.android.adx.utils.a.a("RouteronResume");
        if (!this.hasLaunched || this.isFinished) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - this.launchTime;
        if (isQuickToApp(jCurrentTimeMillis, j)) {
            return;
        }
        this.lastResumeTime = jCurrentTimeMillis;
        if (hasUserCanceled(j)) {
            return;
        }
        compensation(j);
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        long jCurrentTimeMillis = System.currentTimeMillis() - this.launchTime;
        com.yfanads.android.adx.utils.a.a("RouteronStop:" + jCurrentTimeMillis + ", isFinished: " + this.isFinished);
        if (this.isFinished || launchResultCallback == null) {
            return;
        }
        finishWithResult("user_stop_accepted", jCurrentTimeMillis);
        ((com.yfanads.android.adx.router.a) launchResultCallback).a(this.appName, jCurrentTimeMillis);
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        finishWithResult("activity_touch", 0L);
        com.yfanads.android.adx.utils.a.a("RouteronTouchEvent");
        return false;
    }

    private void AdxLogAnalysisResult(String str, long j) {
        String str2;
        str.getClass();
        str.hashCode();
        switch (str) {
            case "user_likely_accepted":
            case "user_stop_accepted":
                str2 = "用户很可能接受并打开了 " + this.appName + " (" + j + "ms)";
                break;
            case "user_likely_refused_immediate":
                str2 = "用户很可能立即拒绝打开 " + this.appName + " (" + j + "ms)";
                break;
            case "user_likely_refused_on_pause":
                str2 = "用户在切换时很可能拒绝打开 " + this.appName + " (" + j + "ms)";
                break;
            case "user_likely_refused":
                str2 = "用户很可能拒绝打开 " + this.appName + " (" + j + "ms)";
                break;
            case "user_likely_accepted_has":
                str2 = "用户很可能同意打开了 " + this.appName + " (" + j + "ms)";
                break;
            case "user_maybe_accepted":
                str2 = "用户可能接受了打开 " + this.appName + " (" + j + "ms)";
                break;
            case "user_likely_accepted_and_returned":
                str2 = "用户接受并返回了 " + this.appName + " (" + j + "ms)";
                break;
            case "user_likely_returned_quickly":
                str2 = "用户可能快速返回了 " + this.appName + " (" + j + "ms)";
                break;
            case "app_not_installed":
                str2 = "应用未安装: " + this.appName;
                break;
            case "launch_exception":
                str2 = "启动应用时发生异常: " + this.appName;
                break;
            default:
                str2 = "";
                break;
        }
        com.yfanads.android.adx.utils.a.a(TAG + str2 + " resultType " + str);
    }

    private boolean hasUserCanceled(long j) {
        if (!this.onActivityResultCalled) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.onActivityResultTime;
        if (this.activityResultCode != 0 || jCurrentTimeMillis > 100) {
            return false;
        }
        this.handler.removeCallbacksAndMessages(null);
        if (j <= 500) {
            finishWithResult("user_likely_refused_immediate", j);
            a aVar = launchResultCallback;
            if (aVar != null) {
                ((com.yfanads.android.adx.router.a) aVar).a(this.appName, "用户立即拒绝", j);
            }
            return true;
        }
        finishWithResult("user_likely_refused", j);
        a aVar2 = launchResultCallback;
        if (aVar2 != null) {
            ((com.yfanads.android.adx.router.a) aVar2).a(this.appName, "用户拒绝", j);
        }
        return true;
    }

    /* JADX INFO: renamed from: lambda$setupTimeDetection$0$com-yfanads-android-adx-core-TransparentActivity, reason: not valid java name */
    /* synthetic */ void m1186xc111dd0c() {
        if (this.isFinished) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.launchTime;
        if (jCurrentTimeMillis < 100 || jCurrentTimeMillis > 500) {
            return;
        }
        finishWithResult("user_likely_refused_immediate", jCurrentTimeMillis);
        a aVar = launchResultCallback;
        if (aVar != null) {
            ((com.yfanads.android.adx.router.a) aVar).a(this.appName, "用户立即拒绝", jCurrentTimeMillis);
        }
    }

    /* JADX INFO: renamed from: lambda$setupTimeDetection$1$com-yfanads-android-adx-core-TransparentActivity, reason: not valid java name */
    /* synthetic */ void m1187xb2bb832b() {
        if (this.isFinished) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.launchTime;
        if (jCurrentTimeMillis >= QUICK_RETURN_THRESHOLD) {
            finishWithResult("user_likely_accepted", jCurrentTimeMillis);
            a aVar = launchResultCallback;
            if (aVar != null) {
                ((com.yfanads.android.adx.router.a) aVar).a(this.appName, jCurrentTimeMillis);
            }
        }
    }

    private void finishWithResult(String str, long j) {
        if (this.isFinished) {
            return;
        }
        this.isFinished = true;
        this.handler.removeCallbacksAndMessages(null);
        AdxLogAnalysisResult(str, j);
        finish();
        overridePendingTransition(0, 0);
    }

    private boolean isQuickToApp(long j, long j2) {
        long j3 = this.lastResumeTime;
        if (j3 <= 0 || j - j3 > RESUME_INTERVAL_THRESHOLD) {
            return false;
        }
        this.handler.removeCallbacksAndMessages(null);
        finishWithResult("user_likely_accepted_has", j2);
        a aVar = launchResultCallback;
        if (aVar == null) {
            return true;
        }
        ((com.yfanads.android.adx.router.a) aVar).a(this.appName, j2);
        return true;
    }
}
