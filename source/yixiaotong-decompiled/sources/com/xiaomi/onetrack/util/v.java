package com.xiaomi.onetrack.util;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.xiaomi.onetrack.Configuration;
import com.xiaomi.onetrack.OneTrack;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9556a = ijiami_1011.s.s.s.d(new byte[]{83, 17, 71, SignedBytes.MAX_POWER_OF_TWO, 95, 94, 62, 11, Ascii.SYN, 7, 95}, "0d4403");
    private static final String b = ijiami_1011.s.s.s.d(new byte[]{5, 67, 17, 68, 88, 85, 62, 7, 10, 13, 66, 0}, "f6b078");
    private static final String c = ijiami_1011.s.s.s.d(new byte[]{1, 72, 19, Ascii.DC4, 89, 92, 15, 7, 3, Base64.padSymbol, 94, Ascii.NAK, 1, 94}, "d0cf09");
    private static final String d = ijiami_1011.s.s.s.d(new byte[]{80, SignedBytes.MAX_POWER_OF_TWO, 66, 74, 15, 87, 15, 7, 3, Base64.padSymbol, 82, 9, 90, 75, 87}, "5828f2");
    private static final String e = ijiami_1011.s.s.s.d(new byte[]{103, 68, 94, SignedBytes.MAX_POWER_OF_TWO, 83, 85, Ascii.CAN, 41, 7, 12, 80, 2, 82, 68}, "767626");
    private static final long k = 900000;
    private OneTrack.IEventHook f;
    private Configuration g;
    private boolean h;
    private boolean i;
    private long j = 0;

    public v(Configuration configuration) {
        this.g = configuration;
        this.h = aa.k(r.a(configuration));
    }

    private boolean b() {
        if (Math.abs(System.currentTimeMillis() - this.j) > k) {
            this.j = System.currentTimeMillis();
            this.i = q.a(com.xiaomi.onetrack.f.a.b());
        }
        return this.i;
    }

    private boolean b(String str) {
        return ijiami_1011.s.s.s.d(new byte[]{11, 95, 1, Ascii.DC2, 75, 2, 2, 15, 57, 6, 80, 16}, "d1df9c").equals(str) || ijiami_1011.s.s.s.d(new byte[]{10, 86, 87, 16, 67, 85, 2, 15, 57, Ascii.DC2, 80}, "e82d14").equals(str);
    }

    private boolean c(String str) {
        OneTrack.IEventHook iEventHook = this.f;
        return iEventHook != null && iEventHook.isRecommendEvent(str);
    }

    private boolean d(String str) {
        OneTrack.IEventHook iEventHook = this.f;
        return iEventHook != null && iEventHook.isCustomDauEvent(str);
    }

    public String a() {
        if (this.g.isUseCustomPrivacyPolicy()) {
            return this.h ? f9556a : b;
        }
        return b() ? c : d;
    }

    public void a(OneTrack.IEventHook iEventHook) {
        this.f = iEventHook;
    }

    public void a(boolean z) {
        this.h = z;
    }

    public boolean a(String str) {
        boolean zB;
        if (this.g.isUseCustomPrivacyPolicy()) {
            p.a(e, ijiami_1011.s.s.s.d(new byte[]{76, SignedBytes.MAX_POWER_OF_TWO, 3, Ascii.CAN, 83, 77, Ascii.DC2, 16, 9, 15, 17, Ascii.NAK, 75, 90, 16, 89, 83, 65, 65, Ascii.DC4, 9, 14, 88, 6, SignedBytes.MAX_POWER_OF_TWO, Ascii.US, 70, 76, 88, 93, 65, Ascii.DC4, 9, 14, 88, 6, SignedBytes.MAX_POWER_OF_TWO, 19, 15, 75, 16}, "93f808") + (this.h ? ijiami_1011.s.s.s.d(new byte[]{95, 69, 7, 12}, "05bb28") : ijiami_1011.s.s.s.d(new byte[]{81, 14, 88, 69, 81}, "2b7644")));
            zB = this.h;
        } else {
            zB = b();
            p.a(e, ijiami_1011.s.s.s.d(new byte[]{77, 74, 1, 67, Ascii.SYN, 75, Ascii.DC2, 16, 3, 15, 17, 0, SignedBytes.MAX_POWER_OF_TWO, 73, 1, 17, 12, 87, 15, 7, 3, 66, 65, 9, 89, 87, 72, 67, 17, 90, 4, 68, Ascii.SYN, 13, 93, 12, 91, SignedBytes.MAX_POWER_OF_TWO, 68, 10, Ascii.SYN, Ascii.DC2}, "89dce2") + (zB ? ijiami_1011.s.s.s.d(new byte[]{13, 73, 3, 94}, "b9f000") : ijiami_1011.s.s.s.d(new byte[]{1, 9, 94, 67, 81}, "be104c")));
        }
        if (zB) {
            return zB;
        }
        boolean zB2 = b(str);
        boolean zC = c(str);
        boolean zD = d(str);
        p.a(e, ijiami_1011.s.s.s.d(new byte[]{53, 81, 92, 66, Ascii.CAN, 92, Ascii.ETB, 1, 8, Ascii.SYN, 17}, "a95189") + str + (zB2 ? ijiami_1011.s.s.s.d(new byte[]{Ascii.CAN, 8, 17, Ascii.ETB}, "8ab73e") : ijiami_1011.s.s.s.d(new byte[]{Ascii.DC2, 92, Ascii.DC2, Ascii.DC2, 13, 91, Ascii.NAK, 68}, "25a2c4")) + ijiami_1011.s.s.s.d(new byte[]{90, 7, 69, 95, 2, Ascii.ETB, 4, Ascii.DC2, 3, 12, 69, 69, 89, 8, 82, Ascii.SYN}, "8f66a7") + (zC ? ijiami_1011.s.s.s.d(new byte[]{93, Ascii.SYN}, "4e4659") : ijiami_1011.s.s.s.d(new byte[]{92, 66, Ascii.SYN, 8, 89, 65}, "516f65")) + ijiami_1011.s.s.s.d(new byte[]{65, 67, 93, 85, 90, 91, 12, 1, 8, 6, 17, 0, Ascii.ETB, 84, 86, 66, Ascii.NAK, 87, 15, 0, 70}, "a18656") + (zD ? ijiami_1011.s.s.s.d(new byte[]{90, 74}, "399f53") : ijiami_1011.s.s.s.d(new byte[]{13, 67, Ascii.NAK, 89, 92, 77}, "d05739")) + ijiami_1011.s.s.s.d(new byte[]{Ascii.DC2, 81, 66, 66, 70, 11, 12, 68, 2, 3, 68, 69, 87, 68, 82, 95, 70}, "22712d"));
        return zB2 || zC || zD;
    }
}
