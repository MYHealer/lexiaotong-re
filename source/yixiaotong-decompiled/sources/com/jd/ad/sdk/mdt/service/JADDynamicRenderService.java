package com.jd.ad.sdk.mdt.service;

import android.content.Context;
import com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView;
import com.jd.ad.sdk.bl.dynamicrender.listener.IDynamicInteractionListener;
import com.jd.ad.sdk.dl.model.JADSlot;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public interface JADDynamicRenderService {
    DynamicRenderView createDynamicView(Context context, String str, JADSlot jADSlot, DynamicRenderView.IDynamicRenderCallback iDynamicRenderCallback);

    void registerAdViewClick(Context context, DynamicRenderView dynamicRenderView, IDynamicInteractionListener iDynamicInteractionListener);
}
