package com.miui.zeus.mimo.sdk;

import android.text.TextUtils;
import com.miui.zeus.mimo.sdk.server.http.Error;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class l5<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f5520a;
    public final a7 b;
    public final i5 c;

    public l5(a7 a7Var, i5 i5Var) {
        this.f5520a = null;
        this.b = a7Var;
        this.c = i5Var;
    }

    public l5(T t) {
        this.f5520a = t;
        this.b = null;
        this.c = null;
    }

    public l5(T t, a7 a7Var, i5 i5Var) {
        this.f5520a = t;
        this.b = a7Var;
        this.c = i5Var;
    }

    public static <T> l5<T> a(Error error, i5 i5Var) {
        return new l5<>(new a7(error), i5Var);
    }

    public static String b(i5 i5Var) {
        if (i5Var == null) {
            return null;
        }
        return i5Var.e == 2 ? i5Var.b() : i5Var.d();
    }

    public boolean b() {
        return this.f5520a != null && this.b == null && this.c == null;
    }

    public static String a(i5 i5Var) {
        if (i5Var != null && i5Var.e == 2) {
            return String.valueOf(i5Var.a());
        }
        return null;
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        if (this.b != null) {
            sb.append(ijiami_1011.s.s.s.d(new byte[]{1, 71, 17, 90, 19, 122, 14, 0, 3, 66, 12}, "d5c5a9"));
            sb.append(this.b.f5282a);
        }
        i5 i5Var = this.c;
        if (i5Var == null) {
            return sb.toString();
        }
        String strD = i5Var.d();
        if (!TextUtils.isEmpty(strD)) {
            sb.append(ijiami_1011.s.s.s.d(new byte[]{26, 67}, "6c0c00"));
        }
        sb.append(strD);
        return sb.toString();
    }
}
