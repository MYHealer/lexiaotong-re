package com.meishu.sdk.core.ad.recycler;

import com.meishu.sdk.core.loader.IAdLoadListener;
import java.util.List;

/* JADX INFO: compiled from: RecyclerAdListener.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface a extends IAdLoadListener<List<RecyclerAdData>> {
    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    default void onAdExposure() {
    }

    @Override // com.meishu.sdk.core.loader.IAdLoadListener
    default void onAdRenderFail(String str, int i) {
    }
}
