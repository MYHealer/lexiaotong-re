package com.jd.ad.sdk.jad_zi;

import android.os.Looper;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.mdt.service.JADExposureService;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: JADExposureServiceImplementor.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_jt implements JADExposureService {
    @Override // com.jd.ad.sdk.mdt.service.JADExposureService
    public ConcurrentHashMap<String, WeakReference<View>> getNativeExposureFeedShakeViewMap() {
        return com.jd.ad.sdk.jad_iv.jad_an.C0556jad_an.jad_an.jad_bo;
    }

    @Override // com.jd.ad.sdk.mdt.service.JADExposureService
    public void registerExposureView(String str) {
        com.jd.ad.sdk.jad_iv.jad_an jad_anVar = com.jd.ad.sdk.jad_iv.jad_an.C0556jad_an.jad_an;
        if (jad_anVar.jad_an.get(str) == null) {
            jad_anVar.jad_an.put(str, new com.jd.ad.sdk.jad_iv.jad_dq());
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADExposureService
    public void registerNativeExposureFeedShakeView(String str, View view) {
        com.jd.ad.sdk.jad_iv.jad_an jad_anVar = com.jd.ad.sdk.jad_iv.jad_an.C0556jad_an.jad_an;
        jad_anVar.getClass();
        if (view != null && jad_anVar.jad_bo.get(str) == null) {
            jad_anVar.jad_bo.put(str, new WeakReference<>(view));
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADExposureService
    public void setViewExposureCallback(String str, int i, View view, JADExposureListener jADExposureListener) {
        com.jd.ad.sdk.jad_iv.jad_dq jad_dqVar = com.jd.ad.sdk.jad_iv.jad_an.C0556jad_an.jad_an.jad_an.get(str);
        if (jad_dqVar == null) {
            return;
        }
        jad_dqVar.jad_fs = new WeakReference<>(str);
        jad_dqVar.jad_cp = jADExposureListener;
        jad_dqVar.jad_dq = i;
        jad_dqVar.jad_an = new WeakReference<>(view);
        View viewJad_bo = jad_dqVar.jad_bo();
        if (viewJad_bo != null) {
            jad_dqVar.jad_bo = new com.jd.ad.sdk.jad_iv.jad_er(Looper.getMainLooper(), jad_dqVar);
            if (!ViewCompat.isAttachedToWindow(viewJad_bo)) {
                viewJad_bo.addOnAttachStateChangeListener(new com.jd.ad.sdk.jad_iv.jad_cp(jad_dqVar, viewJad_bo));
            } else {
                jad_dqVar.jad_bo.sendEmptyMessage(1);
                viewJad_bo.addOnAttachStateChangeListener(new com.jd.ad.sdk.jad_iv.jad_bo(jad_dqVar, viewJad_bo));
            }
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADExposureService
    public void setViewForceExposure(String str) {
        com.jd.ad.sdk.jad_yl.jad_bo jad_boVar;
        com.jd.ad.sdk.jad_iv.jad_dq jad_dqVar = com.jd.ad.sdk.jad_iv.jad_an.C0556jad_an.jad_an.jad_an.get(str);
        if (jad_dqVar == null || (jad_boVar = jad_dqVar.jad_er) == null || jad_boVar.jad_cp) {
            return;
        }
        jad_dqVar.jad_an(true, CommonConstants.ExposureType.EXPOSURE_FORCE.getIndex());
    }

    @Override // com.jd.ad.sdk.mdt.service.JADExposureService
    public void unregisterExposureView(String str) {
        com.jd.ad.sdk.jad_iv.jad_an jad_anVar = com.jd.ad.sdk.jad_iv.jad_an.C0556jad_an.jad_an;
        if (jad_anVar.jad_an.get(str) != null) {
            com.jd.ad.sdk.jad_iv.jad_dq jad_dqVar = jad_anVar.jad_an.get(str);
            jad_dqVar.jad_cp = null;
            com.jd.ad.sdk.jad_iv.jad_er jad_erVar = jad_dqVar.jad_bo;
            if (jad_erVar != null) {
                jad_erVar.removeCallbacksAndMessages(null);
                jad_dqVar.jad_bo = null;
            }
            jad_anVar.jad_an.remove(str);
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADExposureService
    public void unregisterNativeExposureFeedShakeView(String str) {
        com.jd.ad.sdk.jad_iv.jad_an jad_anVar = com.jd.ad.sdk.jad_iv.jad_an.C0556jad_an.jad_an;
        if (jad_anVar.jad_bo.get(str) != null) {
            jad_anVar.jad_bo.remove(str);
        }
    }
}
