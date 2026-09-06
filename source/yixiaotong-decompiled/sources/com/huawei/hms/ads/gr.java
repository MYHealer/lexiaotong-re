package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.beans.metadata.Om;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class gr {
    private static final String Code = "AdSessionAgentFactory";

    public static hm Code(Context context, AdContentData adContentData, gl glVar, boolean z) {
        hj hjVar;
        ho hoVar;
        hp hpVar;
        hp hpVar2;
        if (adContentData == null || context == null) {
            return new gu();
        }
        if (z && (glVar == null || glVar.getOpenMeasureView() == null)) {
            fh.V(Code, "MeasureView is null");
            return new gu();
        }
        if (!gq.Code()) {
            return new gu();
        }
        fh.Code(Code, "AdSessionAgent is avalible");
        gq gqVar = new gq();
        List<Om> listAj = adContentData.aj();
        if (listAj == null) {
            fh.V(Code, "Oms is null");
            return gqVar;
        }
        if (adContentData.t() != null || (adContentData.u() != null && "video/mp4".equals(adContentData.u().Code()))) {
            fh.V(Code, "Video adsession");
            hjVar = hj.VIDEO;
            hoVar = ho.VIEWABLE;
            hpVar = hp.NATIVE;
            hpVar2 = hp.NATIVE;
        } else {
            hjVar = hj.NATIVE_DISPLAY;
            hoVar = ho.VIEWABLE;
            hpVar = hp.NATIVE;
            hpVar2 = hp.NONE;
        }
        hg hgVarCode = hg.Code(hjVar, hoVar, hpVar, hpVar2, false);
        if (hgVarCode == null) {
            return gqVar;
        }
        if (gqVar instanceof gq) {
            fh.V(Code, "init adSessionAgent");
            gqVar.Code(context, listAj, hgVarCode);
        }
        if (z) {
            gqVar.Code(glVar.getOpenMeasureView());
        }
        return gqVar;
    }
}
