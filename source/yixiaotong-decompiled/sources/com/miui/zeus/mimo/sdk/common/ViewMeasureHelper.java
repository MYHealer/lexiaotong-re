package com.miui.zeus.mimo.sdk.common;

import android.view.View;
import android.view.ViewTreeObserver;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.miui.zeus.mimo.sdk.m6;
import com.miui.zeus.mimo.sdk.o6;
import ijiami_1011.NCall;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class ViewMeasureHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o6 f5396a;
    public Runnable b;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f5397a;
        public final /* synthetic */ View b;
        public final /* synthetic */ View[] c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ boolean e;

        public a(View view, View view2, View[] viewArr, boolean z, boolean z2) {
            this.f5397a = view;
            this.b = view2;
            this.c = viewArr;
            this.d = z;
            this.e = z2;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            NCall.IV(new Object[]{Integer.valueOf(TTAdConstant.DEEPLINK_FALL_BACK_CODE), this});
        }
    }

    public ViewMeasureHelper(View view, View view2, View view3, View[] viewArr, boolean z, boolean z2, boolean z3) {
        if (view == null) {
            return;
        }
        if (z3) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(new a(view, view3, viewArr, z, z2));
        } else {
            a(view, view2, view3, viewArr, z, z2);
        }
    }

    public final m6 a(View view) {
        return (m6) NCall.IL(new Object[]{423, this, view});
    }

    public void a(Runnable runnable) {
        NCall.IV(new Object[]{424, this, runnable});
    }

    public final boolean a(View view, View view2, View view3, View[] viewArr, boolean z, boolean z2) {
        return NCall.IZ(new Object[]{425, this, view, view2, view3, viewArr, Boolean.valueOf(z), Boolean.valueOf(z2)});
    }
}
