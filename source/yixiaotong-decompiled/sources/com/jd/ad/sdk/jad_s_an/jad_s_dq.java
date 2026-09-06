package com.jd.ad.sdk.jad_s_an;

import android.util.Log;
import com.jd.ad.sdk.bl.video.listener.VideoLoadListener;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.mdt.service.JADEventService;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;

/* JADX INFO: compiled from: JADSplashRender.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_s_dq implements VideoLoadListener {
    public final /* synthetic */ com.jd.ad.sdk.splash.jad_s_an jad_s_an;

    public jad_s_dq(com.jd.ad.sdk.splash.jad_s_an jad_s_anVar) {
        this.jad_s_an = jad_s_anVar;
    }

    @Override // com.jd.ad.sdk.bl.video.listener.VideoLoadListener
    public void onLoadFailure(int i, String str) {
        try {
            JADEventService eventService = JADMediator.getInstance().getEventService();
            com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = this.jad_s_an;
            eventService.reportRenderFailedEvent(jad_s_anVar.jad_s_er, i, jad_s_anVar.jad_s_an(str), this.jad_s_an.jad_s_fs);
        } catch (Exception e) {
            Logger.d(Log.getStackTraceString(e));
        }
    }

    @Override // com.jd.ad.sdk.bl.video.listener.VideoLoadListener
    public void onLoadSuccess() {
    }
}
