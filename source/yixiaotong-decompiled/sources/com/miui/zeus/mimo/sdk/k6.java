package com.miui.zeus.mimo.sdk;

import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class k6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i6 f5509a;
    public o6 b;
    public String c;
    public Map<String, Long> d;
    public Map<String, Object> e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public l6 k;

    public static k6 a(int i, String str) {
        k6 k6Var = new k6();
        k6Var.j = String.valueOf(i);
        k6Var.i = str;
        return k6Var;
    }

    public static k6 a(ClickAreaType clickAreaType, j6 j6Var) {
        return a(null, clickAreaType, j6Var, null);
    }

    public static k6 a(String str, ClickAreaType clickAreaType, j6 j6Var, l6 l6Var) {
        k6 k6Var = new k6();
        k6Var.f5509a = new i6(str, ijiami_1011.s.s.s.d(new byte[]{5, 89, 80, 0, 95}, "f59c43"), clickAreaType, j6Var);
        k6Var.k = l6Var;
        return k6Var;
    }

    public static k6 a(String str, j6 j6Var, ClickAreaType clickAreaType) {
        k6 k6Var = new k6();
        k6Var.f5509a = new i6(str, null, clickAreaType, j6Var);
        return k6Var;
    }

    public static k6 a(String str, o6 o6Var) {
        k6 k6Var = new k6();
        k6Var.f = str;
        k6Var.b = o6Var;
        return k6Var;
    }
}
