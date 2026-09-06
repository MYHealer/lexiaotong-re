package com.hihonor.adsdk.common.video.g.h.e;

import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.cache.Cache;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface d {
    default MediaSource hnadsa(Cache cache, String str) {
        return hnadsa(cache, str, true, null);
    }

    MediaSource hnadsa(Cache cache, String str, Map<String, String> map, boolean z, String str2);

    void hnadsa();

    void hnadsa(Cache cache, String str, Map<String, String> map);

    default MediaSource hnadsa(Cache cache, String str, boolean z, String str2) {
        return hnadsa(cache, str, new HashMap(), z, str2);
    }
}
