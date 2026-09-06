package com.miui.zeus.mimo.sdk;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;

/* JADX INFO: renamed from: com.miui.zeus.mimo.sdk.r, reason: case insensitive filesystem */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class C1210r {
    public static final String c = ijiami_1011.s.s.s.d(new byte[]{70}, "41904d");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f5577a;
    public p b;

    public C1210r(Context context) {
        this.f5577a = context;
    }

    public void a(String str, n nVar) {
        m.a(c, ijiami_1011.s.s.s.d(new byte[]{65, 83, 82, 94, 74, Ascii.SYN, 4, Ascii.SYN, 43, 3, 67, 14, 86, 66, 103, 82, 90, 7, 8, Ascii.DC2, 3, 16}, "36579b"));
        if (this.b != null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ijiami_1011.s.s.s.d(new byte[]{0, 87, 84, Ascii.CAN, 72, 11, 0, 11, 11, 11, Ascii.US, 8, 2, 74, 82, 83, 68, 76, 37, 43, 49, 44, 125, 42, 34, 124, 102, 127, 126, 49, 53, 37, 42, 46, 110, 55, 38, 107, 108, 122, 100}, "c8960b"));
        p pVar = new p(str);
        this.b = pVar;
        pVar.f5557a = nVar;
        if (Build.VERSION.SDK_INT >= 33) {
            this.f5577a.registerReceiver(pVar, intentFilter, 2);
        } else {
            this.f5577a.registerReceiver(pVar, intentFilter);
        }
    }

    public void a() {
        try {
            if (this.b != null) {
                m.a(c, ijiami_1011.s.s.s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 10, 97, 82, 2, 13, Ascii.DC2, 16, 3, 16, 124, 4, 71, 15, 86, 67, 55, 1, 2, 1, 15, Ascii.DC4, 84, Ascii.ETB}, "5d37ed"));
                p pVar = this.b;
                pVar.f5557a = null;
                this.f5577a.unregisterReceiver(pVar);
                this.b = null;
            }
        } catch (Exception e) {
            m.b(c, ijiami_1011.s.s.s.d(new byte[]{16, 12, 106, 3, 6, 11, Ascii.DC2, 16, 3, 16, 124, 4, Ascii.ETB, 9, 93, Ascii.DC2, 51, 7, 2, 1, 15, Ascii.DC4, 84, Ascii.ETB}, "eb8fab"), e);
        }
    }
}
