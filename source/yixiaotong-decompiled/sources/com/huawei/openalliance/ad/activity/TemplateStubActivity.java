package com.huawei.openalliance.ad.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import com.google.android.exoplayer2.C;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.dynamic.ObjectWrapper;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.jn;
import com.huawei.hms.ads.uiengine.IPPSUiEngineCallback;
import com.huawei.hms.ads.uiengine.IRemoteViewDelegate;
import com.huawei.openalliance.ad.constant.br;
import com.huawei.openalliance.ad.constant.dh;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.bg;
import com.stub.StubApp;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class TemplateStubActivity extends d {
    private static final String Code = "TemplateStubActivity";
    private static AdContentData I;
    private boolean B = false;
    private boolean C = false;
    private boolean S = true;
    private IRemoteViewDelegate V;
    private View Z;

    /* JADX INFO: renamed from: com.huawei.openalliance.ad.activity.TemplateStubActivity$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TemplateStubActivity.this.I();
            TemplateStubActivity.this.Code("start", (Bundle) null);
            bg.Code(TemplateStubActivity.this.Z, TemplateStubActivity.this);
            if (TemplateStubActivity.this.S) {
                TemplateStubActivity.this.Z.startAnimation(AnimationUtils.loadAnimation(StubApp.getOrigApplicationContext(TemplateStubActivity.this.getApplicationContext()), R.anim.hiad_anim_fade_in));
            }
        }
    }

    private static class a extends IPPSUiEngineCallback.b {
        private WeakReference<TemplateStubActivity> Code;

        public a(TemplateStubActivity templateStubActivity) {
            this.Code = new WeakReference<>(templateStubActivity);
        }

        @Override // com.huawei.hms.ads.uiengine.IPPSUiEngineCallback
        public void onCallResult(String str, Bundle bundle) {
            fh.V(TemplateStubActivity.Code, "onCallResult method: %s", str);
            TemplateStubActivity templateStubActivity = this.Code.get();
            if (templateStubActivity == null) {
                return;
            }
            str.hashCode();
            switch (str) {
                case "easterEggClick":
                    if (!jn.Code(StubApp.getOrigApplicationContext(templateStubActivity.getApplicationContext())).V(templateStubActivity, TemplateStubActivity.I, bundle, templateStubActivity.getClass().getSimpleName())) {
                        return;
                    }
                    break;
                case "complete":
                    jn.Code(templateStubActivity).Code(TemplateStubActivity.I, bundle);
                    break;
                case "notify_finish":
                    break;
                case "fail":
                    templateStubActivity.V();
                    jn.Code(StubApp.getOrigApplicationContext(templateStubActivity.getApplicationContext())).I(TemplateStubActivity.I, bundle);
                    return;
                case "show":
                    jn.Code(StubApp.getOrigApplicationContext(templateStubActivity.getApplicationContext())).Code(TemplateStubActivity.I, templateStubActivity.getClass().getSimpleName());
                    return;
                case "click":
                    templateStubActivity.C = true;
                    jn.Code(StubApp.getOrigApplicationContext(templateStubActivity.getApplicationContext())).Code(templateStubActivity, TemplateStubActivity.I, bundle, templateStubActivity.getClass().getSimpleName());
                    return;
                case "close":
                    templateStubActivity.V();
                    jn.Code(StubApp.getOrigApplicationContext(templateStubActivity.getApplicationContext())).V(TemplateStubActivity.I, bundle);
                    return;
                case "dismiss":
                    templateStubActivity.V();
                    jn.Code(StubApp.getOrigApplicationContext(templateStubActivity.getApplicationContext())).V(TemplateStubActivity.I);
                    return;
                default:
                    return;
            }
            templateStubActivity.V();
        }
    }

    static {
        StubApp.interface11(35592);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle Code(String str, Bundle bundle) {
        try {
            IRemoteViewDelegate iRemoteViewDelegate = this.V;
            if (iRemoteViewDelegate != null) {
                return iRemoteViewDelegate.sendCommand(str, bundle);
            }
            return null;
        } catch (Throwable th) {
            fh.I(Code, "%s failed: %s ", str, th.getClass().getSimpleName());
            return null;
        }
    }

    private void Code(Intent intent) {
        try {
            if (!intent.getBooleanExtra(br.f.y, false)) {
                fh.I(Code, "not need reset");
                return;
            }
            Window window = getWindow();
            if (window == null) {
                fh.I(Code, "window is null");
                return;
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.flags = intent.getIntExtra(br.f.z, window.getAttributes().flags);
            if (!dh.Code(getPackageName())) {
                attributes.flags |= 67108864;
            }
            if (Build.VERSION.SDK_INT >= 28) {
                attributes.layoutInDisplayCutoutMode = intent.getIntExtra(br.f.A, window.getAttributes().layoutInDisplayCutoutMode);
            }
            window.setAttributes(attributes);
            window.setNavigationBarColor(intent.getIntExtra(br.f.E, window.getNavigationBarColor()));
            View decorView = window.getDecorView();
            if (decorView == null) {
                fh.I(Code, "decorView is null");
            } else {
                decorView.setSystemUiVisibility(intent.getIntExtra(br.f.G, decorView.getSystemUiVisibility()));
            }
        } catch (Throwable th) {
            fh.I(Code, "inherit err: %s", th.getClass().getSimpleName());
        }
    }

    private static void Code(AdContentData adContentData) {
        I = adContentData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        try {
            IRemoteViewDelegate iRemoteViewDelegate = this.V;
            if (iRemoteViewDelegate != null) {
                View view = (View) ObjectWrapper.unwrap(iRemoteViewDelegate.getView());
                this.Z = view;
                setContentView(view);
            }
        } catch (Throwable th) {
            fh.I(Code, "plugRemoteView " + th.getClass().getSimpleName());
        }
    }

    private void I(Intent intent) {
        int intExtra = intent.getIntExtra(br.f.an, 1024);
        getWindow().setFlags(intExtra, intExtra);
        getWindow().addFlags(C.BUFFER_FLAG_FIRST_SAMPLE);
        try {
            if (Build.VERSION.SDK_INT < 28 || 1 != getResources().getConfiguration().orientation) {
                return;
            }
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            getWindow().setAttributes(attributes);
        } catch (Throwable th) {
            Log.w(Code, "set CutoutMode error:" + th.getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        finish();
        if (this.S) {
            overridePendingTransition(0, R.anim.hiad_anim_fade_out);
        }
    }

    private void V(Intent intent) {
        try {
            setRequestedOrientation(intent.getIntExtra("orientation", -1));
        } catch (Throwable th) {
            fh.Z(Code, "setScreenOrientation err: %s", th.getClass().getSimpleName());
        }
    }

    private void Z() {
        try {
            IRemoteViewDelegate iRemoteViewDelegate = this.V;
            if (iRemoteViewDelegate != null) {
                iRemoteViewDelegate.onDestroy();
            }
        } catch (Throwable th) {
            fh.I(Code, "onDestroy failed: " + th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (this.S) {
            overridePendingTransition(0, R.anim.hiad_anim_fade_out);
        }
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        fh.V(Code, "onDestroy");
        Z();
        if (this.S) {
            jn.Code(StubApp.getOrigApplicationContext(getApplicationContext())).V(I);
        }
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    protected void onPause() {
        super.onPause();
        fh.V(Code, "onPause");
        this.B = true;
        try {
            IRemoteViewDelegate iRemoteViewDelegate = this.V;
            if (iRemoteViewDelegate != null) {
                iRemoteViewDelegate.onPause();
            }
        } catch (Throwable th) {
            fh.I(Code, "onPause " + th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    protected void onRestart() {
        super.onRestart();
        fh.V(Code, "onRestart, hasPause= %s", Boolean.valueOf(this.B));
        if (this.B && this.S) {
            finish();
        }
        try {
            IRemoteViewDelegate iRemoteViewDelegate = this.V;
            if (iRemoteViewDelegate != null) {
                iRemoteViewDelegate.onRestart();
            }
        } catch (Throwable th) {
            fh.I(Code, "onRestart " + th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    protected void onResume() {
        super.onResume();
        fh.V(Code, "onResume, hasPause= %s", Boolean.valueOf(this.B));
        if (this.B && this.S) {
            finish();
        }
        try {
            IRemoteViewDelegate iRemoteViewDelegate = this.V;
            if (iRemoteViewDelegate != null) {
                iRemoteViewDelegate.onResume();
            }
        } catch (Throwable th) {
            fh.I(Code, "onResume " + th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    protected void onStart() {
        super.onStart();
        try {
            IRemoteViewDelegate iRemoteViewDelegate = this.V;
            if (iRemoteViewDelegate != null) {
                iRemoteViewDelegate.onStart();
            }
        } catch (Throwable th) {
            fh.I(Code, "onStart " + th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    protected void onStop() {
        super.onStop();
        fh.V(Code, "onStop");
        try {
            IRemoteViewDelegate iRemoteViewDelegate = this.V;
            if (iRemoteViewDelegate != null) {
                iRemoteViewDelegate.onStop();
            }
        } catch (Throwable th) {
            fh.I(Code, "onStop " + th.getClass().getSimpleName());
        }
        finish();
    }
}
