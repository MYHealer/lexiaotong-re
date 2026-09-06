package com.xiaomi.onetrack.util.oaid;

import android.content.Context;
import android.os.SystemClock;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.google.android.exoplayer2.C;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.xiaomi.onetrack.util.n;
import com.xiaomi.onetrack.util.oaid.helpers.b;
import com.xiaomi.onetrack.util.oaid.helpers.g;
import com.xiaomi.onetrack.util.p;
import com.xiaomi.onetrack.util.q;
import com.xiaomi.onetrack.util.w;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9521a = s.d(new byte[]{84}, "52bb1d");
    private static volatile a b;
    private static long d;
    private volatile String c = "";
    private final int e = 3;
    private volatile int f = 0;
    private boolean g = false;

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }

    private boolean d() {
        if (this.f > 3) {
            return true;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jAbs = Math.abs(jElapsedRealtime - d);
        if (this.f == 1) {
            if (jAbs < C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS) {
                return true;
            }
        } else if (this.f == 2) {
            if (jAbs < ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                return true;
            }
        } else if (this.f == 3 && jAbs < 60000) {
            return true;
        }
        p.a(f9521a, s.d(new byte[]{94, 82, 69, Ascii.SYN, 17, 90, 12, 1, -119, -34, -85}, "9716e3") + this.f);
        d = jElapsedRealtime;
        return false;
    }

    public String a(Context context) {
        String strA;
        synchronized (this.c) {
            if (w.a()) {
                if (p.f9551a) {
                    throw new IllegalStateException(s.d(new byte[]{32, 88, 13, Ascii.NAK, 17, Ascii.ETB, Ascii.DC4, Ascii.ETB, 3, 66, 88, 17, 68, 88, 13, Ascii.DC2, 17, 95, 4, 68, 11, 3, 88, 11, 68, 67, 11, SignedBytes.MAX_POWER_OF_TWO, 0, 86, 5}, "d7c2e7"));
                }
                p.b(f9521a, s.d(new byte[]{1, 4, 68, 124, 5, 93, 5, 76, 79, 66, 69, 13, Ascii.DC4, 14, 71, 19, 1, 76, 2, 1, Ascii.SYN, Ascii.SYN, 88, 10, 8, 65, 10, 19, 32, 91, 15, 67, Ascii.DC2, 66, 68, Ascii.SYN, 3, 65, 89, 71, 68, 91, 15, 68, Ascii.DC2, 10, 84, 69, 11, 0, 89, 93, 68, SignedBytes.MAX_POWER_OF_TWO, 9, Ascii.SYN, 3, 3, 85}, "fa03d4"));
                return "";
            }
            if (this.c != null && !this.c.equals("")) {
                return this.c;
            }
            if (d()) {
                p.a(f9521a, s.d(new byte[]{15, 65, 126, 88, 16, 121, 13, 8, 9, Ascii.NAK, 84, 1, 33, 87, 68, 120, 5, 81, 5}, "f207d8"));
                return this.c;
            }
            if (q.a()) {
                this.c = n.b(context);
                this.f++;
                return this.c;
            }
            if (!this.g && (strA = new g().a(context)) != null && !strA.equals("")) {
                this.c = strA;
                this.f++;
                return strA;
            }
            String strA2 = new b().a(context);
            if (strA2 == null || strA2.equals("")) {
                this.f++;
                return this.c;
            }
            this.c = strA2;
            this.f++;
            return strA2;
        }
    }

    public void a(boolean z) {
        this.g = z;
        p.a(f9521a, s.d(new byte[]{75, 1, Ascii.DC2, 112, 88, 87, Ascii.DC2, 1, 41, 3, 88, 1, 124, 1, Ascii.SYN, 86, 90, 92, 44, Ascii.ETB, 7, 49, 117, 46, -41, -40, -4}, "8df348") + this.g);
    }

    public void b() {
        this.f = 0;
    }

    public boolean c() {
        return (this.c == null || this.c.equals("")) ? false : true;
    }
}
