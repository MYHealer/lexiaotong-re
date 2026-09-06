package com.jd.ad.sdk.bl.video;

import android.view.View;
import com.jd.ad.sdk.bl.video.listener.VideoInteractionListener;

/* JADX INFO: compiled from: VideoSkipView.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_dq implements View.OnClickListener {
    public final /* synthetic */ VideoSkipView jad_an;

    public jad_dq(VideoSkipView videoSkipView) {
        this.jad_an = videoSkipView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VideoSkipView.jad_bo jad_boVar = this.jad_an.jad_bo;
        if (jad_boVar != null) {
            jad_cp jad_cpVar = (jad_cp) jad_boVar;
            VideoInteractionListener videoInteractionListener = jad_cpVar.jad_an.jad_qd;
            if (videoInteractionListener != null) {
                videoInteractionListener.onAdSkip(view);
            }
            VideoSkipView videoSkipView = jad_cpVar.jad_an.jad_ju;
            if (videoSkipView != null) {
                videoSkipView.removeCallbacks(null);
            }
        }
    }
}
