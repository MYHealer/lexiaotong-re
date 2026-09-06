package com.jd.ad.sdk.mdt.service;

import android.content.Context;
import com.jd.ad.sdk.bl.video.VideoRenderView;
import com.jd.ad.sdk.bl.video.listener.OnVideoRenderListener;
import com.jd.ad.sdk.bl.video.listener.VideoInteractionListener;
import com.jd.ad.sdk.bl.video.listener.VideoLoadListener;
import com.jd.ad.sdk.dl.model.JADSlot;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public interface JADVideoRenderService {
    VideoRenderView createVideoRendView(Context context, String str, JADSlot jADSlot, long j, OnVideoRenderListener onVideoRenderListener, VideoLoadListener videoLoadListener);

    void registerAdViewClick(Context context, VideoRenderView videoRenderView, VideoInteractionListener videoInteractionListener);
}
