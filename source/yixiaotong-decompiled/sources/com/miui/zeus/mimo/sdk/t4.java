package com.miui.zeus.mimo.sdk;

import android.content.Context;
import com.google.common.base.Ascii;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class t4 extends g5 {
    public static volatile t4 f;

    public t4(d5 d5Var, a5 a5Var) {
        super(d5Var, a5Var);
    }

    public static t4 a() {
        if (f == null) {
            a(y8.f5752a);
        }
        return f;
    }

    public static void a(Context context) {
        f5 f5Var;
        if (f == null) {
            synchronized (t4.class) {
                if (f == null) {
                    String strA = b.a(context, ijiami_1011.s.s.s.d(new byte[]{84, 88, 88, 93, 60, 69, 4, Ascii.ETB}, "9152c7"));
                    String str = f5.c;
                    try {
                        f5Var = new f5();
                        f5Var.b = u4.a(new File(strA), 1, 1, 524288000L);
                    } catch (Exception unused) {
                        f5Var = null;
                    }
                    f = new t4(f5Var, new c5());
                }
            }
        }
    }
}
