package com.jd.ad.sdk.jad_s_an;

import android.util.Log;
import android.view.View;
import com.jd.ad.sdk.bl.video.listener.OnVideoRenderListener;
import com.jd.ad.sdk.dl.error.JADError;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.mdt.service.JADEventService;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import com.jd.ad.sdk.splash.JADSplashVideoListener;

/* JADX INFO: compiled from: JADSplashRender.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_s_cp implements OnVideoRenderListener {
    public final /* synthetic */ com.jd.ad.sdk.splash.jad_s_an jad_s_an;

    public jad_s_cp(com.jd.ad.sdk.splash.jad_s_an jad_s_anVar) {
        this.jad_s_an = jad_s_anVar;
    }

    @Override // com.jd.ad.sdk.bl.video.listener.OnVideoRenderListener
    public void onVideoRenderFailed(int i, String str) {
        try {
            com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = this.jad_s_an;
            JADError jADError = JADError.RENDER_VIDEO_FAIL_ERROR;
            JADMediator.getInstance().getEventService().reportRenderFailedEvent(this.jad_s_an.jad_s_er, jADError.getCode(), jad_s_anVar.jad_s_an(jADError.getMessage(new String[0])), this.jad_s_an.jad_s_fs);
            com.jd.ad.sdk.splash.jad_s_an.jad_s_an(this.jad_s_an, jADError.getCode(), jADError.getMessage(new String[0]));
        } catch (Exception e) {
            Logger.d(Log.getStackTraceString(e));
        }
    }

    @Override // com.jd.ad.sdk.bl.video.listener.OnVideoRenderListener
    public void onVideoRenderSuccess(View view) {
        try {
            JADError jADError = JADError.RENDER_CREATE_AD_VIEW_FAIL_ERROR;
            int code = jADError.getCode();
            String message = jADError.getMessage(new String[0]);
            if (view != null) {
                com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = this.jad_s_an;
                if (jad_s_anVar.jad_s_bo != null) {
                    jad_s_anVar.jad_s_iv = view;
                    jad_s_anVar.jad_s_an(view, 1);
                    return;
                }
            }
            JADEventService eventService = JADMediator.getInstance().getEventService();
            com.jd.ad.sdk.splash.jad_s_an jad_s_anVar2 = this.jad_s_an;
            eventService.reportRenderFailedEvent(jad_s_anVar2.jad_s_er, code, message, jad_s_anVar2.jad_s_fs);
            com.jd.ad.sdk.splash.jad_s_an.jad_s_an(this.jad_s_an, code, message);
        } catch (Exception e) {
            com.jd.ad.sdk.splash.jad_s_an jad_s_anVar3 = this.jad_s_an;
            JADError jADError2 = JADError.RENDER_CREATE_AD_VIEW_FAIL_ERROR;
            com.jd.ad.sdk.splash.jad_s_an.jad_s_an(jad_s_anVar3, jADError2.getCode(), jADError2.getMessage(e.toString()));
        }
    }

    @Override // com.jd.ad.sdk.bl.video.listener.OnVideoRenderListener
    public void updateMaterialMetaPreload(boolean z) {
        this.jad_s_an.jad_s_na = z;
    }

    @Override // com.jd.ad.sdk.bl.video.listener.OnVideoRenderListener
    public void videoPlayerError(int i, int i2, int i3, int i4, String str) {
        JADSplashVideoListener jADSplashVideoListener = this.jad_s_an.jad_s_mz;
        if (jADSplashVideoListener != null) {
            jADSplashVideoListener.onPlayerError(i, str);
        }
        com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = this.jad_s_an;
        if (jad_s_anVar.jad_s_pc == null) {
            jad_s_anVar.jad_s_pc = new jad_s_jw(jad_s_anVar.jad_s_bo);
        }
        jad_s_anVar.jad_s_pc.reportVideoError(com.jd.ad.sdk.splash.jad_s_an.jad_s_an(this.jad_s_an, i4), i2, i3);
    }

    @Override // com.jd.ad.sdk.bl.video.listener.OnVideoRenderListener
    public void videoPlayerStatusChanged(int i, int i2) {
        JADSplashVideoListener jADSplashVideoListener = this.jad_s_an.jad_s_mz;
        if (jADSplashVideoListener != null) {
            jADSplashVideoListener.onPlayerStatusChanged(i);
        }
        if (i != 0) {
            com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = this.jad_s_an;
            if (jad_s_anVar.jad_s_pc == null) {
                jad_s_anVar.jad_s_pc = new jad_s_jw(jad_s_anVar.jad_s_bo);
            }
            jad_s_jw jad_s_jwVar = jad_s_anVar.jad_s_pc;
            float fJad_s_an = com.jd.ad.sdk.splash.jad_s_an.jad_s_an(this.jad_s_an, i2);
            jad_s_jwVar.getClass();
            switch (i) {
                case 1:
                    jad_s_jwVar.reportVideoWillStart();
                    break;
                case 2:
                    jad_s_jwVar.reportVideoPreloadCompleted();
                    break;
                case 3:
                    jad_s_jwVar.jad_s_an(3, fJad_s_an);
                    break;
                case 4:
                    jad_s_jwVar.jad_s_an(5, fJad_s_an);
                    break;
                case 5:
                    jad_s_jwVar.jad_s_an(4, fJad_s_an);
                    break;
                case 6:
                    jad_s_jwVar.jad_s_an(6, fJad_s_an);
                    break;
            }
        }
    }
}
