package com.miui.zeus.mimo.sdk;

import android.view.View;
import com.google.common.base.Ascii;
import java.math.BigDecimal;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class c6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j6 f5387a;

    public c6(View view, View view2, View view3, View view4, View[] viewArr, n6 n6Var, boolean z, boolean z2) {
        m6 m6VarA;
        if (view2 != null) {
            int width = view2.getWidth();
            int height = view2.getHeight();
            if (width <= 0 || height <= 0) {
                return;
            }
            j6 j6Var = new j6();
            this.f5387a = j6Var;
            j6Var.a(ijiami_1011.s.s.s.d(new byte[]{86, 91, 10, 81, 89, 48, 8, 1, 17, 43, 95, 3, 90}, "57c22f"), a(view));
            this.f5387a.a(ijiami_1011.s.s.s.d(new byte[]{1, 15, 13, 74, 3, 53, 8, 1, 17, 43, 95, 3, 13}, "bcb9fc"), a(view3));
            this.f5387a.a(ijiami_1011.s.s.s.d(new byte[]{7, 91, 10, Ascii.DC2, 88, 89, 15, 1, Ascii.DC4, 52, 88, 0, 19, 125, 10, 0, 86}, "d4df90"), a(view2));
            this.f5387a.a(ijiami_1011.s.s.s.d(new byte[]{95, 4, 91, 4, 89, 50, 8, 1, 17, 43, 95, 3, 92}, "3e9a5d"), a(view4));
            if (viewArr != null && viewArr.length > 0) {
                ArrayList arrayList = new ArrayList();
                for (View view5 : viewArr) {
                    if (view5 != null && (m6VarA = a(view5)) != null) {
                        arrayList.add(m6VarA);
                        if (view5 instanceof z7) {
                            z7 z7Var = (z7) view5;
                            if (!z7Var.a()) {
                                this.f5387a.g = z7Var.getBtnText();
                            }
                        }
                    }
                }
                this.f5387a.f5500a = arrayList;
            }
            if (n6Var != null) {
                j6 j6Var2 = this.f5387a;
                j6Var2.c = n6Var.g + n6Var.f5538a;
                j6Var2.d = n6Var.h + n6Var.b;
                j6Var2.getClass();
            }
            float fA = (z || z2) ? b.a(view2, true) : 0.0f;
            if (z) {
                this.f5387a.e = b.b(fA, 2);
            }
            if (z2) {
                if (new BigDecimal(fA).compareTo(new BigDecimal(1.0d)) < 0) {
                    this.f5387a.f = String.valueOf(true);
                } else {
                    this.f5387a.f = String.valueOf(false);
                }
            }
        }
    }

    public final m6 a(View view) {
        if (view == null) {
            return null;
        }
        m6 m6Var = new m6();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        m6Var.c = iArr[0];
        m6Var.d = iArr[1];
        m6Var.f5530a = view.getWidth();
        m6Var.b = view.getHeight();
        m6Var.e = b.b(b.a(view, true), 2);
        m6Var.f = String.valueOf(b.b(view));
        return m6Var;
    }
}
