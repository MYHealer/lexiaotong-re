package com.miui.zeus.mimo.sdk;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.miui.zeus.jni.NativeUtils;
import okio.Utf8;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class x5 implements s5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f5739a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Application f5740a;

        public a(x5 x5Var, Application application) {
            this.f5740a = application;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (x5.f5739a) {
                return;
            }
            boolean unused = x5.f5739a = true;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(NativeUtils.a(ijiami_1011.s.s.s.d(new byte[]{39, 6, 42, 93, 96, Ascii.DC4, 56, 51, 2, Ascii.ETB, 83, 86, 40, 71, 5, 71, 15, 89, 59, 39, 83, Ascii.SYN, 80, 50, 87, 65, Utf8.REPLACEMENT_BYTE, 2, 11, 16, 45, 10, 14, Ascii.DC2, 104, 50, 95, 67, 7, 99, 7, 12}, "f7f02d")));
            if (Build.VERSION.SDK_INT >= 33) {
                this.f5740a.registerReceiver(new b(), intentFilter, 2);
            } else {
                this.f5740a.registerReceiver(new b(), intentFilter);
            }
        }
    }

    public static class b extends BroadcastReceiver {

        public class a implements Runnable {
            public a(b bVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    l4.a.f5519a.b();
                } catch (Exception unused) {
                }
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (context == null || intent == null || !TextUtils.equals(intent.getAction(), NativeUtils.a(ijiami_1011.s.s.s.d(new byte[]{116, 6, 122, 94, 106, 70, 56, 51, 2, Ascii.ETB, 83, 86, 123, 71, 85, 68, 5, 11, 59, 39, 83, Ascii.SYN, 80, 50, 4, 65, 111, 1, 1, 66, 45, 10, 14, Ascii.DC2, 104, 50, 12, 67, 87, 96, 13, 94}, "576386")))) {
                return;
            }
            x8.i.execute(new a(this));
        }
    }

    @Override // com.miui.zeus.mimo.sdk.s5
    public void a(Application application) {
        x8.i.execute(new a(this, application));
    }
}
