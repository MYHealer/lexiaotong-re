package com.xiaomi.onetrack.e;

import com.google.common.base.Ascii;
import com.xiaomi.onetrack.b.h;
import com.xiaomi.onetrack.util.p;
import ijiami_1011.s.s.s;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class a extends com.xiaomi.onetrack.f.b {
    private static final String d = s.d(new byte[]{33, 65, 68, 77, 88, 89, 36, Ascii.DC2, 3, 12, 69}, "b47974");

    public a(String str, String str2, String str3, String str4) {
        try {
            a(str);
            c(str3);
            b(str2);
            b(System.currentTimeMillis());
            b(new JSONObject(str4));
            a(h.a().a(str, str3, s.d(new byte[]{89, 83, 68, 92, 15}, "5629ca"), 1));
        } catch (Exception e) {
            p.b(s.d(new byte[]{112, Ascii.DC4, 69, 70, 87, 94, 36, Ascii.DC2, 3, 12, 69}, "3a6283"), s.d(new byte[]{123, 16, Ascii.DC2, 17, 14, 92, 36, Ascii.DC2, 3, 12, 69, 69, 93, Ascii.ETB, 19, 10, 19, 11}, "8eaea1") + e.toString());
        }
    }
}
