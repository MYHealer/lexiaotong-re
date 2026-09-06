package com.miui.zeus.mimo.sdk;

import android.os.Build;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class v9 extends Build {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f5649a;
    public static final boolean b;
    public static final boolean c;

    static {
        boolean z = !TextUtils.isEmpty(Build.VERSION.INCREMENTAL) && Build.VERSION.INCREMENTAL.matches(ijiami_1011.s.s.s.d(new byte[]{107, 85, Ascii.ESC, 75, 108, 81, 74, 74, 58, 6, 26, 77, 26, 88, 94, 17, 85, 71, 15, 5, 10, 75, 14}, "710e05"));
        f5649a = z;
        b = ijiami_1011.s.s.s.d(new byte[]{16, 65, 92, 67}, "e29107").equals(Build.TYPE) && !z;
        c = b.b(ijiami_1011.s.s.s.d(new byte[]{16, 11, 77, Ascii.SYN, Ascii.SYN, 95, 5, 17, 5, Ascii.SYN, Ascii.US, 8, 13, 0, 60, 2, 1, 70, 8, 7, 3}, "bdcfd0"), "").endsWith(ijiami_1011.s.s.s.d(new byte[]{102, 4, 93, 65, 11, 83}, "9e11c2")) || b.b(ijiami_1011.s.s.s.d(new byte[]{Ascii.ETB, 91, Ascii.ETB, 19, 69, 95, 5, 17, 5, Ascii.SYN, Ascii.US, 8, 10, 80, 102, 7, 82, 70, 8, 7, 3}, "e49c70"), "").endsWith(ijiami_1011.s.s.s.d(new byte[]{57, 82, 89, 65, 81, 5, 62, 3, 10, 13, 83, 4, 10}, "f3519d"));
        ijiami_1011.s.s.s.d(new byte[]{8}, "93122e").equals(b.b(ijiami_1011.s.s.s.d(new byte[]{Ascii.ETB, 11, 76, 85, 81, 68, 8, 74, 5, Ascii.SYN, 80}, "edb881"), ""));
        b.b(ijiami_1011.s.s.s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 95, Ascii.GS, SignedBytes.MAX_POWER_OF_TWO, Ascii.DC4, 11, 5, 17, 5, Ascii.SYN, Ascii.US, 8, 93, 84, 108, 84, 3, Ascii.DC2, 8, 7, 3}, "2030fd"), "").contains(ijiami_1011.s.s.s.d(new byte[]{107, 81, 94, 89, 90, 7, 13}, "46268f"));
        b.b(ijiami_1011.s.s.s.d(new byte[]{75, 88, 26, 83, Ascii.DC4, 89, 13, 0, 72, 1, 89, 4, 75, 86, 87, 69, 4, 66, 8, Ascii.ETB, Ascii.DC2, 11, 82, Ascii.SYN}, "9741a0"), "").contains(ijiami_1011.s.s.s.d(new byte[]{66, 86, 7, 94, 80, Ascii.SYN}, "67e25b"));
    }
}
