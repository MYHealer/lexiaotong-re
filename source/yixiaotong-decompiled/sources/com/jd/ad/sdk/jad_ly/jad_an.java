package com.jd.ad.sdk.jad_ly;

import android.content.Context;
import android.text.TextUtils;
import com.jd.ad.sdk.bl.video.db.SplashRenderVideoHelper;
import com.jd.ad.sdk.bl.video.listener.VideoLoadListener;
import com.jd.ad.sdk.jad_zm.jad_ly;
import com.jd.ad.sdk.jad_zm.jad_mz;
import com.jd.ad.sdk.jad_zm.jad_ob;
import com.jd.ad.sdk.logger.Logger;
import java.io.BufferedInputStream;

/* JADX INFO: compiled from: JADVideoLoader.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_an implements Runnable {
    public final /* synthetic */ String jad_an;
    public final /* synthetic */ VideoLoadListener jad_bo;
    public final /* synthetic */ Context jad_cp;
    public final /* synthetic */ String jad_dq;
    public final /* synthetic */ jad_bo jad_er;

    public jad_an(jad_bo jad_boVar, String str, VideoLoadListener videoLoadListener, Context context, String str2) {
        this.jad_er = jad_boVar;
        this.jad_an = str;
        this.jad_bo = videoLoadListener;
        this.jad_cp = context;
        this.jad_dq = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.jd.ad.sdk.jad_pc.jad_cp jad_cpVarJad_cp = com.jd.ad.sdk.jad_re.jad_an.jad_cp();
        com.jd.ad.sdk.jad_zm.jad_fs jad_fsVar = new com.jd.ad.sdk.jad_zm.jad_fs();
        jad_fsVar.jad_bo("User-Agent", com.jd.ad.sdk.jad_qd.jad_hu.jad_dq());
        jad_fsVar.jad_bo("Content-Type", "application/stream");
        jad_ly.jad_bo jad_boVar = new jad_ly.jad_bo();
        jad_boVar.jad_an = 1;
        jad_boVar.jad_er = this.jad_an;
        jad_boVar.jad_bo = jad_fsVar;
        jad_boVar.jad_cp = jad_cpVarJad_cp == null ? 5000 : (int) jad_cpVarJad_cp.jad_dq;
        jad_boVar.jad_dq = jad_cpVarJad_cp != null ? (int) jad_cpVarJad_cp.jad_dq : 5000;
        jad_boVar.jad_jt = new C0563jad_an();
        jad_boVar.jad_an(com.jd.ad.sdk.jad_ep.jad_bo.jad_dq);
    }

    /* JADX INFO: renamed from: com.jd.ad.sdk.jad_ly.jad_an$jad_an, reason: collision with other inner class name */
    /* JADX INFO: compiled from: JADVideoLoader.java */
    public class C0563jad_an implements jad_ly.jad_an {
        public C0563jad_an() {
        }

        @Override // com.jd.ad.sdk.jad_zm.jad_ly.jad_an
        public void jad_an(jad_mz jad_mzVar) throws Throwable {
            BufferedInputStream bufferedInputStream;
            try {
                int i = jad_mzVar.jad_an;
                if (i != 200) {
                    jad_an jad_anVar = jad_an.this;
                    jad_anVar.jad_er.jad_an(jad_anVar.jad_bo, i, "error code: " + jad_mzVar.jad_an);
                    jad_ob jad_obVar = jad_mzVar.jad_cp;
                    Logger.d("【load】loadAd error code:" + jad_mzVar.jad_an + ",msg=" + (jad_obVar != null ? jad_obVar.jad_bo() : ""));
                    return;
                }
                jad_ob jad_obVar2 = jad_mzVar.jad_cp;
                if (jad_obVar2 != null && (bufferedInputStream = jad_obVar2.jad_bo) != null) {
                    jad_an jad_anVar2 = jad_an.this;
                    String strJad_an = jad_bo.jad_an(jad_anVar2.jad_er, jad_anVar2.jad_cp, bufferedInputStream, jad_anVar2.jad_an);
                    if (TextUtils.isEmpty(strJad_an)) {
                        return;
                    }
                    jad_an jad_anVar3 = jad_an.this;
                    jad_bo jad_boVar = jad_anVar3.jad_er;
                    if (jad_boVar.jad_an == null) {
                        jad_boVar.jad_an = new SplashRenderVideoHelper(jad_anVar3.jad_cp, jad_anVar3.jad_dq);
                    }
                    jad_an jad_anVar4 = jad_an.this;
                    jad_anVar4.jad_er.jad_an.updateVideoData(jad_anVar4.jad_dq, jad_anVar4.jad_an, strJad_an);
                    VideoLoadListener videoLoadListener = jad_an.this.jad_bo;
                    if (videoLoadListener != null) {
                        videoLoadListener.onLoadSuccess();
                        return;
                    }
                    return;
                }
                Logger.d("loadAd response body is null");
                jad_an jad_anVar5 = jad_an.this;
                jad_bo jad_boVar2 = jad_anVar5.jad_er;
                VideoLoadListener videoLoadListener2 = jad_anVar5.jad_bo;
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar6 = com.jd.ad.sdk.jad_wj.jad_an.GW_RESPONSE_VIDEO_BODY_NULL_ERROR;
                jad_boVar2.jad_an(videoLoadListener2, jad_anVar6.jad_an, jad_anVar6.jad_an(new String[0]));
            } catch (Exception e) {
                Logger.d("Exception load video ad  exception:" + e);
            }
        }

        @Override // com.jd.ad.sdk.jad_zm.jad_ly.jad_an
        public void jad_an(int i, String str) {
            Logger.d("load video Ad response body is onRequestFailed:code: " + i + " ,error:" + str);
        }
    }
}
