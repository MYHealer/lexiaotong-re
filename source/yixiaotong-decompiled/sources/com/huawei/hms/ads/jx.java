package com.huawei.hms.ads;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.huawei.openalliance.ad.beans.inner.AnalysisEventReport;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jx extends jv {
    public static final String Code = "4";
    private static final String[] F = {"com.huawei.openalliance.ad.views.ScanningRelativeLayout", "com.huawei.openalliance.ad.views.ParticleRelativeLayout"};
    private static final String S = "ShadeDetector";
    private View D;
    private double L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f3870a;
    private int b;
    private int c;
    private int d;
    private int e;
    private double f;
    private String g;

    public jx(Context context, AdContentData adContentData, View view) {
        super(context, adContentData);
        this.L = 0.0d;
        this.f3870a = 0.0d;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0.0d;
        this.D = view;
    }

    private int Code(Rect rect, int i) {
        if (rect.right <= this.c) {
            return (this.c - this.b) - (Math.max(rect.left - this.b, 0) + Math.min(this.c - rect.right, i));
        }
        if (rect.left >= this.b) {
            int iMin = Math.min(rect.left - this.b, i);
            int i2 = rect.right;
            int i3 = this.c;
            return (this.c - this.b) - (iMin + (i2 - i3 <= 0 ? i3 - rect.right : 0));
        }
        if (rect.left >= this.b) {
            return 0;
        }
        int i4 = rect.right;
        int i5 = this.c;
        if (i4 > i5) {
            return i5 - this.b;
        }
        return 0;
    }

    private void Code(Rect rect) {
        int iCode = this.c - this.b;
        int iMin = this.e - this.d;
        if (rect.bottom <= this.e) {
            iMin -= (this.d - rect.top <= 0 ? rect.top - this.d : 0) + Math.min(this.e - rect.bottom, iMin);
        } else if (rect.top < this.d) {
            if (rect.top < this.d && rect.bottom > this.e) {
            }
            this.f = ((double) (iCode * iMin)) / this.L;
        } else {
            int iMin2 = Math.min(rect.top - this.d, iMin);
            int i = rect.bottom;
            int i2 = this.e;
            iMin -= iMin2 + (i - i2 <= 0 ? i2 - rect.bottom : 0);
        }
        iCode = Code(rect, iCode);
        this.f = ((double) (iCode * iMin)) / this.L;
    }

    private void Code(Rect rect, String str) {
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        analysisEventReport.V(com.huawei.openalliance.ad.beans.inner.a.D);
        analysisEventReport.Z(this.D.getClass().getSimpleName() + "_" + str);
        analysisEventReport.B(String.valueOf(this.D.getAlpha()));
        analysisEventReport.C(String.valueOf(rect.width()));
        analysisEventReport.S(String.valueOf(rect.height()));
        analysisEventReport.F(this.g);
        this.B.Code(this.I, analysisEventReport, this.Z);
    }

    private boolean I(View view) {
        if (view == null) {
            return false;
        }
        for (String str : F) {
            if (str.equals(view.getClass().getName())) {
                fh.Code(S, "shaded by animator view.");
                this.f = 0.0d;
                return true;
            }
        }
        return false;
    }

    private double V(View view) {
        if (view == null) {
            return this.f;
        }
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup)) {
            return this.f;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        int iIndexOfChild = viewGroup.indexOfChild(view);
        while (true) {
            iIndexOfChild++;
            if (iIndexOfChild >= viewGroup.getChildCount()) {
                double d = this.f;
                return d < 0.5d ? V(viewGroup) : d;
            }
            View childAt = viewGroup.getChildAt(iIndexOfChild);
            if (childAt.getVisibility() == 0) {
                Rect rect = new Rect();
                childAt.getGlobalVisibleRect(rect);
                Code(rect);
                if (this.f >= 0.5d && !I(childAt)) {
                    this.g = childAt.getClass().getName();
                    return this.f;
                }
            }
        }
    }

    @Override // com.huawei.hms.ads.jv
    public boolean Code() {
        View view = this.D;
        if (view == null || !Code(view)) {
            return false;
        }
        this.L = this.D.getWidth() * this.D.getHeight();
        Rect rect = new Rect();
        this.D.getGlobalVisibleRect(rect);
        this.b = rect.left;
        this.c = rect.right;
        this.d = rect.top;
        this.e = rect.bottom;
        if (V(this.D) >= 0.5d) {
            Code(rect, "4");
            return true;
        }
        if (this.C != null) {
            return this.C.Code();
        }
        return false;
    }
}
