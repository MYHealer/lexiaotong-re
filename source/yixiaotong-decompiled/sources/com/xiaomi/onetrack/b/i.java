package com.xiaomi.onetrack.b;

import com.google.common.base.Ascii;
import com.xiaomi.onetrack.util.p;
import ijiami_1011.s.s.s;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArrayList f9456a;
    public final /* synthetic */ h b;

    public i(h hVar, ArrayList arrayList) {
        this.b = hVar;
        this.f9456a = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        if (p.f9551a) {
            p.a(s.d(new byte[]{118, 13, 88, 83, 90, 80, 37, 6, 43, 3, 95, 4, 82, 7, 68}, "5b6537"), s.d(new byte[]{71, Ascii.SYN, 82, 3, 67, 85, 91, 68}, "2f6b70") + this.f9456a);
        }
        this.b.b((ArrayList<l>) this.f9456a);
    }
}
