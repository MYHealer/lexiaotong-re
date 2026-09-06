package com.hihonor.adsdk.common.video.g.h.d;

import android.content.Context;
import android.text.TextUtils;
import androidx.media3.datasource.cache.Cache;
import androidx.media3.exoplayer.source.MediaSource;
import com.hihonor.adsdk.common.video.g.e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c extends com.hihonor.adsdk.common.video.g.h.b implements e {
    private static final String hnadsd = "AndroidXPlayerCacheManager";
    private final Map<String, d> hnadsc;

    static /* synthetic */ class a {
    }

    private static class b {
        private static final c hnadsa = new c(null);

        private b() {
        }
    }

    /* synthetic */ c(a aVar) {
        this();
    }

    public static c hnadsa() {
        return b.hnadsa;
    }

    @Override // com.hihonor.adsdk.common.video.g.h.b, com.hihonor.adsdk.common.video.g.e
    public void hnadsb(Context context, String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsd, "preCache", new Object[0]);
        if (TextUtils.isEmpty(str)) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsd, "preCache,url is null,return", new Object[0]);
            return;
        }
        if (!this.hnadsc.containsKey(str)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsd, "preCache,not containsKey", new Object[0]);
            this.hnadsc.put(str, com.hihonor.adsdk.common.video.g.h.d.b.hnadsa(context, new HashMap(), this));
        }
        d dVar = this.hnadsc.get(str);
        if (dVar != null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsd, "preCache,doPreCacheVideo", new Object[0]);
            dVar.hnadsa(hnadsd(context), str, null);
        }
    }

    @Override // com.hihonor.adsdk.common.video.g.h.b
    protected com.hihonor.adsdk.common.video.g.h.a hnadsc(Context context) {
        return new com.hihonor.adsdk.common.video.g.h.d.a(context, com.hihonor.adsdk.common.video.g.a.hnadsb, null);
    }

    public Cache hnadsd(Context context) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsd, "getSimpleCache", new Object[0]);
        com.hihonor.adsdk.common.video.g.h.a aVarHnadsb = hnadsb(context);
        com.hihonor.adsdk.common.video.g.h.d.a aVar = aVarHnadsb instanceof com.hihonor.adsdk.common.video.g.h.d.a ? (com.hihonor.adsdk.common.video.g.h.d.a) aVarHnadsb : null;
        if (aVar == null) {
            return null;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsd, "getSimpleCache,getCache", new Object[0]);
        return aVar.hnadsd();
    }

    private c() {
        this.hnadsc = new ConcurrentHashMap();
    }

    @Override // com.hihonor.adsdk.common.video.g.h.c
    public void hnadsa(String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsd, "onCacheFinish", new Object[0]);
        this.hnadsc.remove(str);
    }

    public MediaSource hnadsa(Context context, String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsd, "getMediaSource,url is null,return", new Object[0]);
            return null;
        }
        Cache cacheHnadsd = hnadsd(context);
        d dVarHnadsa = this.hnadsc.get(str);
        if (dVarHnadsa != null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsd, "getMediaSource,cancelPreCacheVideo", new Object[0]);
            dVarHnadsa.hnadsa();
        } else {
            dVarHnadsa = com.hihonor.adsdk.common.video.g.h.d.b.hnadsa(context, new HashMap());
        }
        MediaSource mediaSourceHnadsa = dVarHnadsa.hnadsa(cacheHnadsd, str, new HashMap(), z, null);
        this.hnadsc.remove(str);
        return mediaSourceHnadsa;
    }
}
