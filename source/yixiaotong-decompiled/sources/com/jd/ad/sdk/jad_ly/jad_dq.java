package com.jd.ad.sdk.jad_ly;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.jd.ad.sdk.dl.addata.JADMaterialData;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: VideoRenderHelper.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_dq {
    public static jad_dq jad_bo;
    public WeakHashMap<String, Bitmap> jad_an = null;

    public static jad_dq jad_an() {
        if (jad_bo == null) {
            jad_bo = new jad_dq();
        }
        return jad_bo;
    }

    public void jad_an(String str) {
        JADMaterialData jADMaterialData = JADMediator.getInstance().getAdService().getJADMaterialDataList(str).get(0);
        if (jADMaterialData == null || TextUtils.isEmpty(jADMaterialData.getVideoUrl())) {
            return;
        }
        WeakHashMap<String, Bitmap> weakHashMap = this.jad_an;
        if (weakHashMap != null) {
            weakHashMap.clear();
            this.jad_an = null;
        }
        this.jad_an = new WeakHashMap<>();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(jADMaterialData.getVideoUrl());
        if (mediaMetadataRetriever.extractMetadata(9) == null) {
            return;
        }
        this.jad_an.put(str, mediaMetadataRetriever.getFrameAtTime(0L));
    }
}
