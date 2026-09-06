package com.meishu.sdk.core.utils;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.SoftReference;

/* JADX INFO: compiled from: ViewClickChecker.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class s1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f4945a = new int[2];
    public int b;
    public int c;

    /* JADX INFO: compiled from: ViewClickChecker.java */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SoftReference f4946a;

        public a(SoftReference softReference) {
            this.f4946a = softReference;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            try {
                s1.this.b = ((View) this.f4946a.get()).getWidth();
                s1.this.c = ((View) this.f4946a.get()).getHeight();
                ((View) this.f4946a.get()).getLocationOnScreen(s1.this.f4945a);
                ((View) this.f4946a.get()).getViewTreeObserver().removeOnGlobalLayoutListener(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public s1(View view) {
        if (view == null) {
            return;
        }
        try {
            view.getViewTreeObserver().addOnGlobalLayoutListener(new a(new SoftReference(view)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean a(float f, float f2) {
        try {
            int[] iArr = this.f4945a;
            int i = iArr[0];
            if (f <= i || f >= i + this.b) {
                return false;
            }
            int i2 = iArr[1];
            return f2 > ((float) i2) && f2 < ((float) (i2 + this.c));
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean a(View view, float f, float f2) {
        try {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            return f >= ((float) i) && f <= ((float) (view.getWidth() + i)) && f2 >= ((float) i2) && f2 <= ((float) (view.getHeight() + i2));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
