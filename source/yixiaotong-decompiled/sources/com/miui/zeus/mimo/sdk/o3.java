package com.miui.zeus.mimo.sdk;

import android.view.View;
import android.view.ViewGroup;
import com.google.common.base.Ascii;
import com.miui.zeus.mimo.sdk.ad.template.TemplateUIController;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.common.ViewMeasureHelper;
import com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep;
import com.miui.zeus.mimo.sdk.track.info.AdEvent;
import com.miui.zeus.mimo.sdk.utils.error.MimoAdError;
import com.miui.zeus.mimo.sdk.view.AdImpressMonitor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class o3 implements TemplateUIController.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TemplateUIController f5546a;

    public class a implements AdImpressMonitor.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f5547a;
        public final /* synthetic */ h3 b;

        public a(View view, h3 h3Var) {
            this.f5547a = view;
            this.b = h3Var;
        }

        @Override // com.miui.zeus.mimo.sdk.view.AdImpressMonitor.a
        public void onAdShow() {
            int width = this.f5547a.getWidth();
            int height = this.f5547a.getHeight();
            int requestMinWidth = this.b.getRequestMinWidth();
            int requestMinHeight = this.b.getRequestMinHeight();
            if (width < 0 || height < 0 || requestMinWidth < 0 || requestMinHeight < 0) {
                return;
            }
            if (width < requestMinWidth || height < requestMinHeight) {
                o3.this.f5546a.a(MimoAdError.ERROR_3001, m4.a(DiagnosisStep.KEY_EXCEPTION_WHEN_CREATE_AD_VIEW, new Throwable(ijiami_1011.s.s.s.d(new byte[]{87, 86, 17, 75, 15, 74, 4, 68, 15, 17, 17, 11, 89, 70, 17, 85, 7, 68, 2, 12}, "6218f0"))));
                return;
            }
            this.b.getRootAdView().setVisibility(0);
            TemplateUIController templateUIController = o3.this.f5546a;
            View view = this.f5547a;
            ViewMeasureHelper viewMeasureHelper = new ViewMeasureHelper(templateUIController.f5367a, null, null, null, true, true, false);
            m.b(ijiami_1011.s.s.s.d(new byte[]{50, 1, 94, 19, 84, 0, Ascii.NAK, 1, 51, 43, 114, 10, 8, 16, 65, 12, 84, 13, 4, Ascii.SYN}, "fd3c8a"), ijiami_1011.s.s.s.d(new byte[]{8, 90, 17, 89, 84, 65, 55, 13, 3, Ascii.NAK, 114, Ascii.ETB, 3, 84, 17, 85, 86}, "f5e028"));
            view.setTag(Boolean.TRUE);
            MimoAdInfo mimoAdInfo = templateUIController.b;
            mimoAdInfo.V = true;
            b.a(AdEvent.VIEW, mimoAdInfo, (n6) null, k6.a(templateUIController.c, viewMeasureHelper.f5396a));
            i3 i3Var = templateUIController.h;
            if (i3Var != null) {
                i3Var.onAdShow();
            }
            b.c(templateUIController.d);
        }
    }

    public o3(TemplateUIController templateUIController) {
        this.f5546a = templateUIController;
    }

    public void a(Throwable th) {
        this.f5546a.a(MimoAdError.ERROR_3001, m4.a(DiagnosisStep.KEY_EXCEPTION_WHEN_CREATE_AD_VIEW, th));
    }

    public void a(h3 h3Var) {
        TemplateUIController templateUIController = this.f5546a;
        ViewGroup viewGroup = templateUIController.f5367a;
        if (viewGroup == null || templateUIController.f == null) {
            templateUIController.a(MimoAdError.ERROR_3001, m4.a(DiagnosisStep.KEY_EXCEPTION_WHEN_CREATE_AD_VIEW, new Exception(ijiami_1011.s.s.s.d(new byte[]{94, 117, 86, 91, Ascii.SYN, 0, Ascii.EM, 16, 70, 95, 12, 69, 93, 67, 85, 89, Ascii.RS, Ascii.EM, 3, 5, Ascii.NAK, 7, 112, 1, 122, 88, 95, 90, 66, 88, 92, 68, 8, Ascii.ETB, 93, 9}, "3695be"))));
            return;
        }
        templateUIController.f = h3Var;
        viewGroup.removeAllViews();
        View rootAdView = h3Var.getRootAdView();
        this.f5546a.f5367a.addView(rootAdView);
        TemplateUIController templateUIController2 = this.f5546a;
        AdImpressMonitor adImpressMonitor = templateUIController2.j;
        if (adImpressMonitor != null) {
            templateUIController2.i.removeCallbacks(adImpressMonitor);
        }
        TemplateUIController templateUIController3 = this.f5546a;
        if (TemplateUIController.a(templateUIController3, templateUIController3.b)) {
            TemplateUIController templateUIController4 = this.f5546a;
            templateUIController4.j = new AdImpressMonitor(templateUIController4.i);
        }
        AdImpressMonitor adImpressMonitor2 = this.f5546a.j;
        if (adImpressMonitor2 != null) {
            View rootAdView2 = h3Var.getRootAdView();
            adImpressMonitor2.e = new a(rootAdView, h3Var);
            adImpressMonitor2.f = rootAdView2;
            TemplateUIController templateUIController5 = this.f5546a;
            templateUIController5.i.post(templateUIController5.j);
        }
    }
}
