package com.jd.ad.sdk.jad_zi;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.huawei.openalliance.ad.constant.x;
import com.jd.ad.sdk.bl.initsdk.JADYunSdk;
import com.jd.ad.sdk.bl.video.VideoRenderView;
import com.jd.ad.sdk.bl.video.listener.OnVideoRenderListener;
import com.jd.ad.sdk.bl.video.listener.VideoInteractionListener;
import com.jd.ad.sdk.bl.video.listener.VideoLoadListener;
import com.jd.ad.sdk.dl.addata.JADMaterialData;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.fdt.utils.ScreenUtils;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.mdt.service.JADVideoRenderService;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: JADVideoRenderServiceImplementor.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_kx implements JADVideoRenderService {
    @Override // com.jd.ad.sdk.mdt.service.JADVideoRenderService
    public VideoRenderView createVideoRendView(Context context, String str, JADSlot jADSlot, long j, OnVideoRenderListener onVideoRenderListener, VideoLoadListener videoLoadListener) throws JSONException {
        try {
            int iDip2px = (int) ScreenUtils.dip2px(context, jADSlot.getWidth());
            int iDip2px2 = (int) ScreenUtils.dip2px(context, jADSlot.getHeight());
            List<JADMaterialData> jADMaterialDataList = JADMediator.getInstance().getAdService().getJADMaterialDataList(str);
            if (jADMaterialDataList != null && jADMaterialDataList.size() > 0) {
                String str2 = JADYunSdk.getAppId() + jADSlot.getSlotID();
                JADMaterialData jADMaterialData = JADMediator.getInstance().getAdService().getJADMaterialDataList(str).get(0);
                if (jADMaterialData == null) {
                    return null;
                }
                String videoUrl = jADMaterialData.getVideoUrl();
                int muted = jADMaterialData.getMuted();
                List<String> imageUrls = jADMaterialData.getImageUrls();
                String str3 = (imageUrls == null || imageUrls.size() <= 0) ? "" : imageUrls.get(0);
                if (TextUtils.isEmpty(str3) && TextUtils.isEmpty(videoUrl)) {
                    return null;
                }
                VideoRenderView.jad_jw jad_jwVar = new VideoRenderView.jad_jw();
                jad_jwVar.jad_an = iDip2px;
                jad_jwVar.jad_bo = iDip2px2;
                jad_jwVar.jad_ly = str;
                jad_jwVar.jad_fs = str3;
                jad_jwVar.jad_jw = videoUrl;
                jad_jwVar.jad_jt = jADSlot.getSkipTime();
                jad_jwVar.jad_cp = onVideoRenderListener;
                jad_jwVar.jad_dq = jADSlot.getEventInteractionType();
                jad_jwVar.jad_er = jADSlot.getModelClickAreaType();
                jad_jwVar.jad_hu = jADSlot.isHideSkip();
                jad_jwVar.jad_kx = str2;
                jad_jwVar.jad_ob = muted;
                jad_jwVar.jad_pc = jADMaterialData.getVideoDuration();
                jad_jwVar.jad_na = j;
                jad_jwVar.jad_iv = jADSlot.isHidePreloadLabel();
                jad_jwVar.jad_mz = videoLoadListener;
                VideoRenderView videoRenderView = new VideoRenderView(context, jad_jwVar);
                Exception videoRenderException = videoRenderView.getVideoRenderException();
                if (videoRenderException == null) {
                    return videoRenderView;
                }
                throw videoRenderException;
            }
            return null;
        } catch (Throwable th) {
            int sen = jADSlot != null ? jADSlot.getSen() : 0;
            Exception exc = new Exception("video render view init error", th);
            JSONObject jSONObject = new JSONObject();
            String message = exc.getMessage();
            int i = com.jd.ad.sdk.jad_wj.jad_an.RENDER_VIDEO_VIEW_INIT_OTHER_ERROR.jad_an;
            try {
                try {
                    for (Throwable cause = exc.getCause(); cause != null; cause = cause.getCause()) {
                        String message2 = cause.getMessage();
                        if (TextUtils.isEmpty(message2) || !message2.startsWith(BaseWrapper.ENTER_ID_OAPS_PHONEMANAGER)) {
                            message = message + "|" + message2;
                        } else {
                            String[] strArrSplit = message2.split(x.A);
                            i = Integer.parseInt(strArrSplit[0]);
                            message = message + "|" + strArrSplit[1];
                        }
                    }
                    jSONObject.put("code", i);
                    jSONObject.put("msg", message);
                } catch (Exception unused) {
                    Logger.d("错误信息拼接异常");
                    jSONObject.put("code", i);
                    jSONObject.put("msg", message);
                }
                int iOptInt = jSONObject.optInt("code");
                com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", 5, iOptInt, jSONObject.optString("msg"), sen);
                Logger.w(iOptInt + ": video render view error：" + Log.getStackTraceString(exc), new Object[0]);
                return null;
            } catch (Throwable th2) {
                jSONObject.put("code", i);
                jSONObject.put("msg", message);
                throw th2;
            }
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADVideoRenderService
    public void registerAdViewClick(Context context, VideoRenderView videoRenderView, VideoInteractionListener videoInteractionListener) {
        videoRenderView.setVideoInteractionListener(videoInteractionListener);
    }
}
