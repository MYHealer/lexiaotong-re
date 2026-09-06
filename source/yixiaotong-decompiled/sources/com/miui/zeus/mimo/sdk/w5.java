package com.miui.zeus.mimo.sdk;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.jni.NativeUtils;
import com.miui.zeus.mimo.sdk.utils.MimoSdkInitHolder;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class w5 implements s5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5724a = ijiami_1011.s.s.s.d(new byte[]{17, 81}, "fd7e6b");
    public static boolean b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Application f5725a;

        public a(w5 w5Var, Application application) {
            this.f5725a = application;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (w5.b) {
                return;
            }
            boolean unused = w5.b = true;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(NativeUtils.a(ijiami_1011.s.s.s.d(new byte[]{115, 9, 7, 80, 92, 79, 45, 9, 48, Ascii.ETB, 104, 50, 120, 75, 62, 51, 13, 8, 59, 39, 83, Ascii.SYN, 107, 50, 96, 72, Base64.padSymbol, 58, 98, 69, 3, 86, 82, Ascii.ETB, 107, 34, 94, 80, 62, 80, 5, 67, 56, 86, 95, Ascii.SYN, 125, 11, 90, 72, Base64.padSymbol, 53, 9, 65, 0, 55, 83, 10}, "28db05")));
            intentFilter.addAction(NativeUtils.a(ijiami_1011.s.s.s.d(new byte[]{121, 4, 87, 7, 91, 78, 45, 9, 52, Ascii.DC2, 82, 87, 126, 92, 86, 114, 98, 9, 59, 39, 83, Ascii.SYN, 107, 50, 106, 69, 109, 109, 101, 68, 3, 86, 82, Ascii.ETB, 107, 34, 84, 93, 110, 7, 2, 66, 56, 86, 95, Ascii.SYN, 125, 11, 80, 69, 109, 98, 14, SignedBytes.MAX_POWER_OF_TWO, 0, 55, 83, 10}, "854574")));
            intentFilter.addAction(NativeUtils.a(ijiami_1011.s.s.s.d(new byte[]{119, 2, 92, 39, 7, 116, 51, 49, 44, 52, 99, 84, 15, 99, 108, 3, 15, 12, 59, 39, 83, Ascii.SYN, 80, 50, 7, 69, 116, 9, 94, 68, 5, 35, 48, Ascii.ETB, 104, 87, 15, 71, 116, 10, 90, 65, 56, 51, 95, Ascii.SYN, 80, 54, 3, 91}, "638d21")));
            intentFilter.addAction(NativeUtils.a(ijiami_1011.s.s.s.d(new byte[]{114, 7, 0, 118, 4, 117, 51, 49, 44, 52, 99, 84, 10, 102, 54, 94, 104, 13, 59, 39, 83, Ascii.SYN, 80, 50, 2, SignedBytes.MAX_POWER_OF_TWO, 40, 88, 93, 69, 5, 35, 48, Ascii.ETB, 104, 87, 10, 66, 40, 91, 89, SignedBytes.MAX_POWER_OF_TWO, 56, 51, 95, Ascii.SYN, 80, 54, 6, 94}, "36d510")));
            if (Build.VERSION.SDK_INT >= 33) {
                this.f5725a.registerReceiver(new b(), intentFilter, 2);
            } else {
                this.f5725a.registerReceiver(new b(), intentFilter);
            }
        }
    }

    public static final class b extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (context == null || intent == null) {
                return;
            }
            String action = intent.getAction();
            if (TextUtils.equals(action, NativeUtils.a(ijiami_1011.s.s.s.d(new byte[]{112, 83, 85, 0, 91, 72, 45, 9, 52, Ascii.DC2, 82, 87, 119, 11, 84, 117, 98, 15, 59, 39, 83, Ascii.SYN, 107, 50, 99, Ascii.DC2, 111, 106, 101, 66, 3, 86, 82, Ascii.ETB, 107, 34, 93, 10, 108, 0, 2, 68, 56, 86, 95, Ascii.SYN, 125, 11, 89, Ascii.DC2, 111, 101, 14, 70, 0, 55, 83, 10}, "1b6272"))) || TextUtils.equals(action, NativeUtils.a(ijiami_1011.s.s.s.d(new byte[]{117, 7, 93, 113, 81, 35, 51, 49, 44, 52, 99, 84, 13, 102, 107, 89, Base64.padSymbol, 91, 59, 39, 83, Ascii.SYN, 80, 50, 5, SignedBytes.MAX_POWER_OF_TWO, 117, 95, 8, 19, 5, 35, 48, Ascii.ETB, 104, 87, 13, 66, 117, 92, 12, Ascii.SYN, 56, 51, 95, Ascii.SYN, 80, 54, 1, 94}, "4692df")))) {
                com.miui.zeus.mimo.sdk.b.a(false);
                MimoSdkInitHolder.setDebugOnSetting(false);
                Log.i(w5.f5724a, ijiami_1011.s.s.s.d(new byte[]{124, 91, 84, 11, 65, 83, 10, 68, Ascii.NAK, 7, 69, 69, 85, 87, 91, 17, 85, Ascii.ETB, 14, 2, 0, 66, 66, 16, 82, 81, 92, Ascii.ETB, 65, Ascii.ETB}, "129d27"));
            } else if (TextUtils.equals(action, NativeUtils.a(ijiami_1011.s.s.s.d(new byte[]{35, 3, 87, 84, 89, 67, 45, 9, 48, Ascii.ETB, 104, 50, 40, 65, 110, 55, 8, 4, 59, 39, 83, Ascii.SYN, 107, 50, 48, 66, 109, 62, 103, 73, 3, 86, 82, Ascii.ETB, 107, 34, 14, 90, 110, 84, 0, 79, 56, 86, 95, Ascii.SYN, 125, 11, 10, 66, 109, 49, 12, 77, 0, 55, 83, 10}, "b24f59"))) || TextUtils.equals(action, NativeUtils.a(ijiami_1011.s.s.s.d(new byte[]{36, 2, 1, 114, 7, 124, 51, 49, 44, 52, 99, 84, 92, 99, 49, 86, 15, 4, 59, 39, 83, Ascii.SYN, 80, 50, 84, 69, 41, 92, 94, 76, 5, 35, 48, Ascii.ETB, 104, 87, 92, 71, 41, 95, 90, 73, 56, 51, 95, Ascii.SYN, 80, 54, 80, 91}, "e3e129")))) {
                com.miui.zeus.mimo.sdk.b.a(true);
                MimoSdkInitHolder.setDebugOnSetting(true);
                Log.i(w5.f5724a, ijiami_1011.s.s.s.d(new byte[]{44, 80, 88, 93, 70, 83, 10, 68, Ascii.NAK, 7, 69, 69, 5, 92, 87, 71, 82, Ascii.ETB, 14, 10, 70, 17, 68, 6, 2, 92, 70, 65}, "a95257"));
            }
        }
    }

    @Override // com.miui.zeus.mimo.sdk.s5
    public void a(Application application) {
        if (com.miui.zeus.mimo.sdk.b.b == null) {
            com.miui.zeus.mimo.sdk.b.b = new d9(ijiami_1011.s.s.s.d(new byte[]{110, 89, 94, 60, 81, 65}, "147c52"));
        }
        MimoSdkInitHolder.setDebugOnSetting(TextUtils.equals(com.miui.zeus.mimo.sdk.b.b.f5408a.getString(ijiami_1011.s.s.s.d(new byte[]{110, 92, 11, 105, 2, 16, 62, Ascii.ETB, 17}, "11f6fc"), ijiami_1011.s.s.s.d(new byte[]{111, 11, 15, 105, 88, 94, 7}, "0fb678")), ijiami_1011.s.s.s.d(new byte[]{Base64.padSymbol, 94, 8, Base64.padSymbol, 88, 72, 4, 10}, "b3eb78")));
        x8.i.execute(new a(this, application));
    }
}
