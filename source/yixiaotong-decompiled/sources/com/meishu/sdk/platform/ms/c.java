package com.meishu.sdk.platform.ms;

import android.content.Context;
import com.meishu.sdk.core.ad.AdSlot;
import com.meishu.sdk.core.ad.AdType;
import com.meishu.sdk.core.ad.IAd;
import com.meishu.sdk.core.loader.InteractionListener;

/* JADX INFO: compiled from: IMsAd.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface c<T extends InteractionListener> extends IAd<T> {
    AdSlot a();

    AdType getAdType();

    Context getContext();

    int getInteractionType();
}
