package com.xiaomi.onetrack.a.c;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.xiaomi.onetrack.util.p;
import com.xiaomi.onetrack.util.q;
import ijiami_1011.s.s.s;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9397a = s.d(new byte[]{119, 84, 117, 12, 12, 91, Ascii.NAK, 11, Ascii.DC4, 55, 65, 9, 89, 81, 92, 6, 16}, "608cb2");

    public static void a() {
        ArrayList<com.xiaomi.onetrack.a.b.a> arrayList;
        Integer numValueOf;
        ArrayList<Integer> arrayList2;
        try {
            if (b()) {
                p.a(f9397a, s.d(new byte[]{-46, -66, -125, -44, -42, -66, -119, -53, -35, -121, -66, -13, -47, -90, -128, -41, -21, -106, -124, -34, -11, -121, -120, -45, -45, -117, -70, -43, -38, -104, -121, -15, -42, -124, -68, -53}, "7301f8"));
                int i = 0;
                while (i <= 20) {
                    com.xiaomi.onetrack.a.a.a().d();
                    a aVarB = com.xiaomi.onetrack.a.a.a().b();
                    if (aVarB != null && (arrayList = aVarB.b) != null && arrayList.size() > 0) {
                        ArrayList<Integer> arrayList3 = new ArrayList<>();
                        ArrayList<Integer> arrayList4 = new ArrayList<>();
                        for (com.xiaomi.onetrack.a.b.a aVar : aVarB.b) {
                            boolean zB = com.xiaomi.onetrack.g.b.b(aVar.c());
                            int iB = aVar.b();
                            if (zB) {
                                numValueOf = Integer.valueOf(iB);
                                arrayList2 = arrayList3;
                            } else {
                                numValueOf = Integer.valueOf(iB);
                                arrayList2 = arrayList4;
                            }
                            arrayList2.add(numValueOf);
                        }
                        if (arrayList3.size() > 0) {
                            com.xiaomi.onetrack.a.a.a().a(arrayList3);
                        }
                        if (arrayList4.size() > 0) {
                            com.xiaomi.onetrack.a.a.a().b(arrayList4);
                        }
                        i++;
                        if (aVarB.c) {
                            p.a(f9397a, s.d(new byte[]{126, 11, 67, 89, 89, 65, 4, 68, 7, 6, 17, 8, 95, 10, 10, SignedBytes.MAX_POWER_OF_TWO, 89, 65, 65, Ascii.SYN, 3, 1, 94, Ascii.ETB, 84, Ascii.ETB}, "0dc463"));
                            return;
                        }
                    }
                    p.a(f9397a, s.d(new byte[]{-42, -33, -107, -47, -41, -118, -121, -7, -57, -122, -118, -45, -41, -2, -80, 88, 5, 116, 14, 10, 15, Ascii.SYN, 94, Ascii.ETB, -40, -54, -124, -36, -36, -84, -123, -36, -36, -123, -104, -33, -33, -40, -72, -36, -20, -118, -124, -44, -32, -118, -114, -15, -43, -1, -86}, "0d49a9"));
                    return;
                }
            }
        } catch (Throwable th) {
            p.a(f9397a, s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 71, 9, 86, 84, 93, 37, 5, Ascii.DC2, 3, 17, 49, 93, 69, 10, 78, 84, 91, 13, 1, 92}, "57e959") + th.getMessage());
        }
    }

    private static boolean b() {
        String strD;
        String str = f9397a;
        if (q.a(str)) {
            strD = s.d(new byte[]{Ascii.SYN, 10, 3, 19, 87, 7, Ascii.ETB, 13, 5, 7, 17, 12, 17, 66, 8, 92, 71, 66, 17, Ascii.SYN, 9, Ascii.DC4, 88, Ascii.SYN, 11, 13, 8, 86, 87, 78, 65, Ascii.ETB, Ascii.DC2, 13, 65, 69, Ascii.DC2, 13, 10, 95, Ascii.DC2}, "bbf33b");
        } else if (!com.xiaomi.onetrack.g.c.a()) {
            strD = s.d(new byte[]{89, 87, Ascii.ETB, 78, 86, 70, 10, 68, 15, 17, 17, 16, 89, 81, 12, 87, 87, 81, 2, 16, 3, 6, Ascii.GS, 69, 68, 70, 12, 73, Ascii.EM, 68, 14, 8, 10, 67}, "72c994");
        } else {
            if (com.xiaomi.onetrack.a.a.a().e() != 0) {
                return true;
            }
            strD = s.d(new byte[]{95, 91, 69, 83, 82, 71, 0, 68, Ascii.DC4, 7, 92, 4, 88, 90, 69, 94, 93, 19, 5, 6, 74, 66, 66, 17, 94, 68, 69, 71, 92, 95, 13, 69}, "14e733");
        }
        p.a(str, strD);
        return false;
    }
}
