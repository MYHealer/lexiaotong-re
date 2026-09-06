package com.miui.zeus.mimo.sdk;

import com.google.common.base.Ascii;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class a5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b5 f5281a;
    public final Set<String> b = new CopyOnWriteArraySet();

    public void a(b5 b5Var) {
        this.f5281a = b5Var;
    }

    public void a(String str, e5 e5Var, long j, i5 i5Var) {
        if (!this.b.isEmpty()) {
            this.b.remove(str);
        }
        b5 b5Var = this.f5281a;
        if (b5Var != null) {
            g5.a aVar = (g5.a) b5Var;
            if (!g5.this.b.isEmpty()) {
                g5.this.b.remove(str);
            }
            g5.this.b(str, false);
            g5.a(g5.this, str, e5Var, j, i5Var);
        }
    }

    public void a(String str, e5 e5Var, long j) {
        if (!this.b.isEmpty()) {
            this.b.remove(str);
        }
        b5 b5Var = this.f5281a;
        if (b5Var != null) {
            g5.a aVar = (g5.a) b5Var;
            aVar.getClass();
            if (e5Var.b) {
                g5 g5Var = g5.this;
                g5Var.getClass();
                x8.i.execute(new h5(g5Var, str));
            }
            if (!g5.this.b.isEmpty()) {
                g5.this.b.remove(str);
            }
            s4<Boolean> s4VarA = g5.this.a(str, true);
            if (s4VarA.f5594a == null || s4VarA.b != null || s4VarA.c != null) {
                g5.a(g5.this, str, e5Var, j, new i5(s4VarA.c, (String) null, new Throwable(s4VarA.b)));
                return;
            }
            g5 g5Var2 = g5.this;
            g5Var2.getClass();
            m.a(ijiami_1011.s.s.s.d(new byte[]{125, 14, 78, 94, 13, 12, 0, 0, 3, 16}, "9a90ac"), ijiami_1011.s.s.s.d(new byte[]{114, 13, 17, 87, 94, 11, 0, 0, 70, 16, 84, Ascii.SYN, 89, Ascii.ETB, Ascii.DC4, 90, 87, 68, Ascii.DC2, 17, 5, 1, 84, Ascii.SYN, 69, 4, 19, 85, Ascii.RS, 68, Ascii.DC4, Ascii.SYN, 10, 66, 12, 69}, "6bf92d") + str + ijiami_1011.s.s.s.d(new byte[]{77, Ascii.EM, Ascii.ETB, 17, 112, 82, 65, 89, 70}, "a9ba96") + e5Var.f5415a + ijiami_1011.s.s.s.d(new byte[]{79, Ascii.CAN, 19, 68, 6, 101, 8, 9, 3, 66, 12, 69}, "c8f7c1") + (System.currentTimeMillis() - j) + ijiami_1011.s.s.s.d(new byte[]{65, 89, Ascii.ETB}, "a4d324"));
            b.a(e5Var.f5415a, e5Var.c, ijiami_1011.s.s.s.d(new byte[]{119, 44, 49, 44, 124, 119, 32, 32}, "3cfb08"), ijiami_1011.s.s.s.d(new byte[]{0, 13, 67, 87, 92, 9, 0, 0, 57, 17, 68, 6, 7, 7, 71, 74}, "db490f"), j, ijiami_1011.s.s.s.d(new byte[]{0}, "06484f"), ijiami_1011.s.s.s.d(new byte[]{-35, -36, -23, -115, -37, -37, -121, -20, -10, -121, -69, -6}, "9dbeff"));
            for (g5.b bVar : g5Var2.f5439a) {
                if (bVar != null) {
                    bVar.b(str);
                }
            }
        }
    }
}
