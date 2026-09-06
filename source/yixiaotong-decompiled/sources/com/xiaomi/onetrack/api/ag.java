package com.xiaomi.onetrack.api;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class ag implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f9406a;
    public final /* synthetic */ Map b;
    public final /* synthetic */ List c;
    public final /* synthetic */ m d;

    public ag(m mVar, String str, Map map, List list) {
        this.d = mVar;
        this.f9406a = str;
        this.b = map;
        this.c = list;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        try {
            if (TextUtils.isEmpty(this.d.f.getAdEventAppId())) {
                com.xiaomi.onetrack.util.p.a(ijiami_1011.s.s.s.d(new byte[]{44, 88, 7, 50, 70, 86, 2, 15, 47, 15, 65}, "c6bf47"), ijiami_1011.s.s.s.d(new byte[]{81, 92, 114, Ascii.DC4, 80, 94, Ascii.NAK, 37, Ascii.SYN, Ascii.DC2, 120, 1, 16, 81, 68, 66, 91, 69, 13, 8, 74, 50, 93, 0, 81, 75, 82, 66, 86, 95, 15, 2, 15, 5, 68, Ascii.ETB, 85, Ascii.DC4, 82, Ascii.DC4, 80, 94, Ascii.NAK, 68, 8, 3, 92, 0, 10}, "087b50") + this.f9406a);
            } else {
                if (this.d.d(this.f9406a)) {
                    return;
                }
                this.d.b.a(this.f9406a, h.a(this.f9406a, com.xiaomi.onetrack.util.r.a((Map<String, Object>) this.b, true), this.d.f, this.d.h, this.d.f(this.f9406a), this.d.i, com.xiaomi.onetrack.util.r.a(this.c), this.d.j));
            }
        } catch (Exception e) {
            com.xiaomi.onetrack.util.p.b(ijiami_1011.s.s.s.d(new byte[]{126, 15, 7, 53, 19, 83, 2, 15, 47, 15, 65}, "1abaa2"), ijiami_1011.s.s.s.d(new byte[]{69, 74, 86, 83, 89, 19, 12, 5, Ascii.SYN, 66, 84, Ascii.ETB, 67, 87, 69, 10, Ascii.DC2}, "187023") + e.toString());
        }
    }
}
