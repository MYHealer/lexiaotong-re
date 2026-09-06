package com.jd.ad.sdk.jad_zi;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.jd.ad.sdk.bl.video.listener.VideoLoadListener;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.mdt.service.JADAdVideoLoadService;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: JADAdVideoServiceImplementor.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_bo implements JADAdVideoLoadService {
    public final ConcurrentHashMap<String, com.jd.ad.sdk.jad_ly.jad_bo> jad_an = new ConcurrentHashMap<>();

    @Override // com.jd.ad.sdk.mdt.service.JADAdVideoLoadService
    public void loadAdVideo(Context context, String str, String str2, String str3, VideoLoadListener videoLoadListener) {
        com.jd.ad.sdk.jad_ly.jad_bo jad_boVar = this.jad_an.get(str);
        if (jad_boVar == null) {
            if (videoLoadListener != null) {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_LOAD_REGISTER_AD_SERVICE_ERROR;
                videoLoadListener.onLoadFailure(jad_anVar.jad_an, jad_anVar.jad_an(new String[0]));
                return;
            }
            return;
        }
        synchronized (jad_boVar) {
            try {
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    if (Build.VERSION.SDK_INT < 29 && ContextCompat.checkSelfPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                        com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_LOAD_VIDEO_AD_SERVICE_PERMISSION_ERROR;
                        jad_boVar.jad_an(videoLoadListener, jad_anVar2.jad_an, jad_anVar2.jad_an(new String[0]));
                    }
                    com.jd.ad.sdk.jad_ep.jad_cp.jad_an.execute(new com.jd.ad.sdk.jad_ly.jad_an(jad_boVar, str2, videoLoadListener, context, str3));
                    return;
                }
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar3 = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_LOAD_VIDEO_URL_IS_NULL_ERROR;
                jad_boVar.jad_an(videoLoadListener, jad_anVar3.jad_an, jad_anVar3.jad_an(new String[0]));
            } catch (Exception e) {
                Logger.d("load video Ad response body is exception:" + e);
            }
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADAdVideoLoadService
    public void registerAd(String str) {
        if (this.jad_an.get(str) == null) {
            this.jad_an.put(str, new com.jd.ad.sdk.jad_ly.jad_bo());
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADAdVideoLoadService
    public void unregisterAd(String str) {
        if (this.jad_an.get(str) == null) {
            return;
        }
        this.jad_an.remove(str);
    }
}
