package com.adprof.sdk.base.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.adprof.sdk.gi;
import com.adprof.sdk.p2;
import com.adprof.sdk.pk;
import com.adprof.sdk.pp;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.openalliance.ad.constant.x;
import com.stub.StubApp;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class AdxActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f96a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public p2 f97a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f100a;
    public boolean b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final pp f98a = new pp();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1072a = 1000;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f99a = "";

    static {
        StubApp.interface11(11396);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:31:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:39:0x00f0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:? A[RETURN, SYNTHETIC] */
    public static final boolean a(AdxActivity adxActivity, String str) {
        ResolveInfo resolveInfoResolveActivity;
        adxActivity.getClass();
        boolean zA = gi.a(str);
        pk.d("beforeLogic link = " + str + "  hap = " + zA);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        intent.addFlags(32768);
        intent.addFlags(268435456);
        String str2 = adxActivity.f99a;
        if (zA && TextUtils.isEmpty(str2)) {
            str2 = adxActivity.f99a;
            try {
                String lowerCase = Build.MANUFACTURER.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "huawei", false, 2, (Object) null)) {
                    str2 = "com.huawei.fastapp";
                } else if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) MediationConstant.ADN_XIAOMI, false, 2, (Object) null)) {
                    str2 = "com.miui.hybrid";
                } else if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "oppo", false, 2, (Object) null)) {
                    str2 = "com.nearme.instant.platform";
                } else if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "vivo", false, 2, (Object) null)) {
                    str2 = "com.vivo.hybrid";
                } else if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "honor", false, 2, (Object) null)) {
                    str2 = x.bj;
                }
            } catch (Throwable unused) {
            }
        }
        if (str2 != null) {
            intent.setPackage(str2);
            try {
                adxActivity.startActivityForResult(intent, adxActivity.f1072a);
            } catch (Throwable th) {
                pk.b("adprofsdk", "Failed to open deeplink with package " + str2 + ": " + th.getMessage());
                intent.setPackage(null);
                if (Build.VERSION.SDK_INT >= 33) {
                    resolveInfoResolveActivity = adxActivity.getPackageManager().resolveActivity(intent, PackageManager.ResolveInfoFlags.of(0L));
                } else {
                    resolveInfoResolveActivity = adxActivity.getPackageManager().resolveActivity(intent, 0);
                }
                pk.d("openDeeplink info=" + resolveInfoResolveActivity);
                if (resolveInfoResolveActivity != null) {
                    return false;
                }
                try {
                    adxActivity.startActivityForResult(intent, adxActivity.f1072a);
                } catch (Throwable unused2) {
                    return false;
                }
            }
        } else {
            if (Build.VERSION.SDK_INT >= 33) {
                resolveInfoResolveActivity = adxActivity.getPackageManager().resolveActivity(intent, PackageManager.ResolveInfoFlags.of(0L));
            } else {
                resolveInfoResolveActivity = adxActivity.getPackageManager().resolveActivity(intent, 0);
            }
            pk.d("openDeeplink info=" + resolveInfoResolveActivity);
            if (resolveInfoResolveActivity != null) {
                return false;
            }
            adxActivity.startActivityForResult(intent, adxActivity.f1072a);
        }
        return true;
    }

    public final void a(int i) {
        pk.d("XXX failCallback code = " + i);
        p2 p2Var = this.f97a;
        if (p2Var != null) {
            p2Var.a(Boolean.FALSE, i);
        }
        this.f97a = null;
        finish();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f96a;
        pk.d(" XXX onActivityResult requestCode=" + i + ", resultCode=" + i2 + ", isBackground=" + this.f100a + ", time=" + jElapsedRealtime + "  intent=" + intent);
        if (i == this.f1072a) {
            this.b = true;
            boolean z = jElapsedRealtime <= 50;
            pk.d("  XXX onActivityResult  success =  " + z);
            p2 p2Var = this.f97a;
            if (p2Var != null) {
                p2Var.a(Boolean.valueOf(z), 1005);
            }
            this.f97a = null;
        }
        if (isFinishing()) {
            return;
        }
        pk.d("  XXX onActivityResult  finish");
        finish();
    }

    @Override // android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f97a = null;
    }

    @Override // android.app.Activity
    public void onPause() {
        pk.d("XXX  onPause start");
        super.onPause();
        this.f96a = SystemClock.elapsedRealtime();
        this.f100a = true;
        pk.d("XXX onPause end");
    }

    @Override // android.app.Activity
    public void onResume() {
        pk.d("XXX onResume start");
        super.onResume();
        pk.d("XXX onResume end");
    }

    @Override // android.app.Activity
    public void onStop() {
        pk.d("XXX onStop start");
        super.onStop();
        pk.d("XXX onStop end");
        p2 p2Var = this.f97a;
        if (p2Var != null) {
            p2Var.a(Boolean.valueOf(!this.b), 1003);
        }
        this.f97a = null;
    }
}
