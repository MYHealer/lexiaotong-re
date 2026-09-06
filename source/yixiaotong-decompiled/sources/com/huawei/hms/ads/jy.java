package com.huawei.hms.ads;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.openalliance.ad.beans.inner.AnalysisEventReport;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jy extends jv {
    public static final String Code = "3";
    public static final String S = "2";
    private int D;
    private View F;
    private int L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3871a;
    private int b;

    public jy(Context context, AdContentData adContentData, View view) {
        super(context, adContentData);
        this.F = view;
    }

    private boolean B() {
        return Code((ViewGroup) this.F) || V(this.F);
    }

    private void Code(Rect rect, String str) {
        int width = rect.width() < 0 ? this.F.getWidth() : rect.width();
        int height = rect.height() < 0 ? this.F.getHeight() : rect.height();
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        analysisEventReport.V(com.huawei.openalliance.ad.beans.inner.a.D);
        analysisEventReport.Z(this.F.getClass().getSimpleName() + "_" + str);
        analysisEventReport.B(String.valueOf(this.F.getAlpha()));
        analysisEventReport.C(String.valueOf(width));
        analysisEventReport.S(String.valueOf(height));
        this.B.Code(this.I, analysisEventReport, this.Z);
    }

    private boolean Code(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        float scaleX = viewGroup.getScaleX() * viewGroup.getScaleY();
        if (scaleX < 0.5d || scaleX > 2.0f) {
            return true;
        }
        if (viewGroup.getParent() instanceof ViewGroup) {
            return Code((ViewGroup) viewGroup.getParent());
        }
        return false;
    }

    private boolean I() {
        this.D = this.F.getPaddingLeft();
        this.L = this.F.getPaddingTop();
        this.f3871a = this.F.getPaddingRight();
        int paddingBottom = this.F.getPaddingBottom();
        this.b = paddingBottom;
        return this.D < 0 || this.L < 0 || this.f3871a < 0 || paddingBottom < 0;
    }

    private boolean V() {
        int iV = com.huawei.openalliance.ad.utils.z.V(this.F.getContext(), 9.0f);
        return this.F.getWidth() < iV || this.F.getHeight() < iV;
    }

    private boolean V(View view) {
        if (view == null || com.huawei.openalliance.ad.utils.z.V(this.Z)) {
            return false;
        }
        float scaleX = view.getScaleX() * view.getScaleY();
        if (scaleX < 0.5d || scaleX > 2.0f) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            if (V(viewGroup.getChildAt(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean Z() {
        ViewGroup.LayoutParams layoutParams = this.F.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return false;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        this.D = marginLayoutParams.leftMargin;
        this.L = marginLayoutParams.topMargin;
        this.f3871a = marginLayoutParams.rightMargin;
        int i = marginLayoutParams.bottomMargin;
        this.b = i;
        return this.D < 0 || this.L < 0 || this.f3871a < 0 || i < 0;
    }

    @Override // com.huawei.hms.ads.jv
    public boolean Code() {
        String str;
        View view = this.F;
        if (view == null || !Code(view)) {
            return false;
        }
        Rect rect = new Rect();
        this.F.getGlobalVisibleRect(rect);
        if (I() || Z() || B()) {
            str = "2";
        } else {
            if (!V()) {
                if (this.C != null) {
                    return this.C.Code();
                }
                return false;
            }
            str = "3";
        }
        Code(rect, str);
        return true;
    }
}
