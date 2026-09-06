package com.huawei.hms.ads;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.huawei.openalliance.ad.beans.inner.AnalysisEventReport;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jr extends jv {
    public static final String Code = "1";
    private View F;
    private boolean S;

    public jr(Context context, AdContentData adContentData, View view) {
        super(context, adContentData);
        this.S = false;
        this.F = view;
        if (view == null || view.getAlpha() >= 1.0f) {
            return;
        }
        this.S = true;
    }

    private void Code(Rect rect, String str) {
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        analysisEventReport.V(com.huawei.openalliance.ad.beans.inner.a.D);
        analysisEventReport.Z(this.F.getClass().getSimpleName() + "_" + str);
        analysisEventReport.B(String.valueOf(this.F.getAlpha()));
        analysisEventReport.C(String.valueOf(rect.width()));
        analysisEventReport.S(String.valueOf(rect.height()));
        this.B.Code(this.I, analysisEventReport, this.Z);
    }

    @Override // com.huawei.hms.ads.jv
    public boolean Code() {
        if (this.F == null) {
            return false;
        }
        if (!this.S) {
            if (this.C != null) {
                return this.C.Code();
            }
            return false;
        }
        Rect rect = new Rect();
        this.F.getGlobalVisibleRect(rect);
        Code(rect, "1");
        return true;
    }
}
