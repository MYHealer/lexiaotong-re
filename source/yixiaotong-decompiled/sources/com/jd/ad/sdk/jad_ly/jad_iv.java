package com.jd.ad.sdk.jad_ly;

import android.content.Context;
import com.jd.ad.sdk.bl.dynamicrender.ShakeListener;
import com.jd.ad.sdk.bl.video.VideoRenderView;
import com.jd.ad.sdk.dl.common.CommonConstants;

/* JADX INFO: compiled from: VideoRenderView.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_iv extends ShakeListener {
    public final /* synthetic */ VideoRenderView jad_na;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jad_iv(VideoRenderView videoRenderView, Context context, float f, float f2, float f3) {
        super(context, f, f2, f3);
        this.jad_na = videoRenderView;
    }

    @Override // com.jd.ad.sdk.bl.dynamicrender.ShakeListener
    public void onShake() {
        VideoRenderView videoRenderView = this.jad_na;
        if (VideoRenderView.jad_an(videoRenderView, videoRenderView.jad_tg)) {
            VideoRenderView videoRenderView2 = this.jad_na;
            if (videoRenderView2.jad_qd != null) {
                float f = videoRenderView2.jad_jw;
                float f2 = videoRenderView2.jad_ly;
                float f3 = videoRenderView2.jad_mz;
                CommonConstants.AdTriggerSourceType adTriggerSourceType = CommonConstants.AdTriggerSourceType.SHAKE;
                int iOrdinal = adTriggerSourceType.ordinal();
                if (f3 > 0.0f) {
                    if (f > 0.0f && f2 > 0.0f) {
                        iOrdinal = CommonConstants.AdTriggerSourceType.SHAKE_ALL.ordinal();
                    } else if (f > 0.0f) {
                        iOrdinal = CommonConstants.AdTriggerSourceType.SHAKE_ACCELERATION_TIME.ordinal();
                    } else if (f2 > 0.0f) {
                        iOrdinal = CommonConstants.AdTriggerSourceType.SHAKE_ANGLE_TIME.ordinal();
                    }
                } else if (f > 0.0f && f2 > 0.0f) {
                    iOrdinal = CommonConstants.AdTriggerSourceType.SHAKE_ACCELERATION_ANGLE.ordinal();
                } else if (f > 0.0f) {
                    iOrdinal = adTriggerSourceType.ordinal();
                } else if (f2 > 0.0f) {
                    iOrdinal = CommonConstants.AdTriggerSourceType.SHAKE_ANGLE.ordinal();
                }
                VideoRenderView videoRenderView3 = this.jad_na;
                videoRenderView3.jad_qd.onAdClicked(videoRenderView3.jad_pc, iOrdinal);
            }
        }
    }
}
