package com.adprof.sdk.base.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.adprof.sdk.AdprofSdk;
import com.adprof.sdk.api.AdAppInfo;
import com.adprof.sdk.base.activity.AdActivity;
import com.adprof.sdk.d;
import com.adprof.sdk.g3;
import com.adprof.sdk.j5;
import com.stub.StubApp;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class AdDownloadDetailDialog extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1080a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f112a;

    static {
        StubApp.interface11(11413);
    }

    public static final void a(AdDownloadDetailDialog adDownloadDetailDialog) {
        View decorView;
        View rootView;
        Window window = adDownloadDetailDialog.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null || (rootView = decorView.getRootView()) == null) {
            return;
        }
        rootView.setFocusable(true);
        rootView.setFocusableInTouchMode(true);
        rootView.requestFocus();
    }

    public static final void a(AdDownloadDetailDialog adDownloadDetailDialog, View view) {
        AdAppInfo adAppInfo;
        d dVar = adDownloadDetailDialog.f112a;
        adDownloadDetailDialog.a((dVar == null || (adAppInfo = dVar.f182a) == null) ? null : adAppInfo.getAppDescriptionUrl());
    }

    public static final boolean a(AdDownloadDetailDialog adDownloadDetailDialog, View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            return true;
        }
        if (action != 1) {
            return false;
        }
        adDownloadDetailDialog.finish();
        return true;
    }

    public static final void b(AdDownloadDetailDialog adDownloadDetailDialog, View view) {
        AdAppInfo adAppInfo;
        d dVar = adDownloadDetailDialog.f112a;
        adDownloadDetailDialog.a((dVar == null || (adAppInfo = dVar.f182a) == null) ? null : adAppInfo.getPermissionsUrl());
    }

    public static final void c(AdDownloadDetailDialog adDownloadDetailDialog, View view) {
        AdAppInfo adAppInfo;
        d dVar = adDownloadDetailDialog.f112a;
        adDownloadDetailDialog.a((dVar == null || (adAppInfo = dVar.f182a) == null) ? null : adAppInfo.getPrivacyUrl());
    }

    public static final void d(AdDownloadDetailDialog adDownloadDetailDialog, View view) {
        adDownloadDetailDialog.getClass();
        try {
            g3 g3Var = g3.f300a;
            Function0 function0 = (Function0) g3.f1183a.get(adDownloadDetailDialog.f1080a);
            if (function0 != null) {
                function0.invoke();
            }
        } catch (Throwable unused) {
            g3 g3Var2 = g3.f300a;
        }
        g3.f1183a.remove(adDownloadDetailDialog.f1080a);
        adDownloadDetailDialog.finish();
    }

    public static final void e(AdDownloadDetailDialog adDownloadDetailDialog, View view) {
        adDownloadDetailDialog.finish();
    }

    public final void a(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        j5.a(AdprofSdk.getInstance().getContext(), AdActivity.class, this.f112a, str);
    }

    @Override // android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public void onDestroy() {
        int i = this.f1080a;
        if (i != 0) {
            g3 g3Var = g3.f300a;
            g3.f1183a.remove(i);
        }
        super.onDestroy();
    }
}
