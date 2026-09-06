package com.meishu.sdk.meishu_ad.nativ;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.meishu.sdk.meishu_ad.n0;
import java.util.List;

/* JADX INFO: compiled from: NativeAdData.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface b extends com.meishu.sdk.platform.ms.c {
    @Override // com.meishu.sdk.platform.ms.c
    f a();

    void a(Context context, ViewGroup viewGroup, List<View> list, com.meishu.sdk.platform.ms.recycler.d dVar);

    void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, e eVar);

    int getAdPatternType();

    String getDesc();

    String getIconUrl();

    String[] getImgUrls();

    @Override // com.meishu.sdk.platform.ms.c
    int getInteractionType();

    n0 getMediaView();

    String getTitle();
}
