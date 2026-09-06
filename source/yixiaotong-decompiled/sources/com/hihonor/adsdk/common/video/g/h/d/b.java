package com.hihonor.adsdk.common.video.g.h.d;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.DefaultDataSource;
import androidx.media3.datasource.DefaultHttpDataSource;
import androidx.media3.datasource.RawResourceDataSource;
import androidx.media3.datasource.cache.Cache;
import androidx.media3.datasource.cache.CacheDataSource;
import androidx.media3.datasource.cache.CacheWriter;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ProgressiveMediaSource;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import com.hihonor.adsdk.common.f.a0;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b implements d {
    private static final String hnadse = "AndroidXDataSource";
    private static final String hnadsf = "User-Agent";
    private static final String hnadsg = "android.resource";
    private static int hnadsh = 8000;
    private static int hnadsi = 8000;
    private final Context hnadsa;
    private final Map<String, String> hnadsb;
    private CacheWriter hnadsc;
    private final com.hihonor.adsdk.common.video.g.h.c hnadsd;

    private b(Context context, Map<String, String> map, com.hihonor.adsdk.common.video.g.h.c cVar) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, hnadse, new Object[0]);
        this.hnadsa = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.hnadsb = map;
        this.hnadsd = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DataSource hnadsa(RawResourceDataSource rawResourceDataSource) {
        return rawResourceDataSource;
    }

    public static void hnadsa(int i, int i2) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "setHttpConfig", new Object[0]);
        hnadsi = i;
        hnadsh = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsb(Cache cache, final String str, Map map) {
        String str2;
        try {
            if (cache == null) {
                com.hihonor.adsdk.common.b.b.hnadsb(hnadse, "doPreCacheVideo,cache is null,return", new Object[0]);
                return;
            }
            Map<String, String> map2 = this.hnadsb;
            if (map2 == null || !map2.containsKey("User-Agent")) {
                str2 = null;
            } else {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "doPreCacheVideo,userAgent", new Object[0]);
                str2 = this.hnadsb.get("User-Agent");
            }
            DataSpec dataSpec = new DataSpec(Uri.parse(str), 0L, -1L);
            CacheDataSource.Factory factory = new CacheDataSource.Factory();
            factory.setCache(cache).setFlags(2).setUpstreamDataSourceFactory(hnadsa(this.hnadsa, (Map<String, String>) map, str2));
            this.hnadsc = new CacheWriter(factory.createDataSource(), dataSpec, (byte[]) null, new CacheWriter.ProgressListener() { // from class: com.hihonor.adsdk.common.video.g.h.d.b$$ExternalSyntheticLambda0
                public final void onProgress(long j, long j2, long j3) {
                    this.f$0.hnadsa(str, j, j2, j3);
                }
            });
            com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "doPreCacheVideo,cache", new Object[0]);
            this.hnadsc.cache();
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadse, "doPreCacheVideo,exception: " + e.getMessage(), new Object[0]);
        }
    }

    public static d hnadsa(Context context, Map<String, String> map) {
        return new b(context, map, null);
    }

    public static d hnadsa(Context context, Map<String, String> map, com.hihonor.adsdk.common.video.g.h.c cVar) {
        return new b(context, map, cVar);
    }

    @Override // com.hihonor.adsdk.common.video.g.h.d.d
    public MediaSource hnadsa(Cache cache, String str, Map<String, String> map, boolean z, String str2) {
        String str3;
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "getDataSource", new Object[0]);
        try {
            Uri uri = Uri.parse(str);
            MediaItem mediaItemFromUri = MediaItem.fromUri(uri);
            Map<String, String> map2 = this.hnadsb;
            if (map2 == null || !map2.containsKey("User-Agent")) {
                str3 = null;
            } else {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "getDataSource,userAgent", new Object[0]);
                str3 = this.hnadsb.get("User-Agent");
            }
            if (hnadsg.equals(uri.getScheme())) {
                DataSpec dataSpec = new DataSpec(uri);
                final RawResourceDataSource rawResourceDataSource = new RawResourceDataSource(this.hnadsa);
                try {
                    rawResourceDataSource.open(dataSpec);
                } catch (RawResourceDataSource.RawResourceDataSourceException e) {
                    com.hihonor.adsdk.common.b.b.hnadsb(hnadse, "getDataSource,RawResourceDataSourceException: " + e.getMessage(), new Object[0]);
                }
                return new ProgressiveMediaSource.Factory(new DataSource.Factory() { // from class: com.hihonor.adsdk.common.video.g.h.d.b$$ExternalSyntheticLambda2
                    public final DataSource createDataSource() {
                        return b.hnadsa(rawResourceDataSource);
                    }
                }).createMediaSource(mediaItemFromUri);
            }
            return new ProgressiveMediaSource.Factory(hnadsa(cache, z, map, str3)).createMediaSource(mediaItemFromUri);
        } catch (Exception e2) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadse, "getDataSource,exception: " + e2.getMessage(), new Object[0]);
            return null;
        }
    }

    @Override // com.hihonor.adsdk.common.video.g.h.d.d
    public void hnadsa(final Cache cache, final String str, final Map<String, String> map) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "doPreCacheVideo", new Object[0]);
        a0.hnadsb(new Runnable() { // from class: com.hihonor.adsdk.common.video.g.h.d.b$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.hnadsb(cache, str, map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsa(String str, long j, long j2, long j3) {
        if (j == j2) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "onCacheFinish", new Object[0]);
            com.hihonor.adsdk.common.video.g.h.c cVar = this.hnadsd;
            if (cVar != null) {
                cVar.hnadsa(str);
            }
        }
    }

    @Override // com.hihonor.adsdk.common.video.g.h.d.d
    public void hnadsa() {
        if (this.hnadsc != null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "cancelPreCacheVideo", new Object[0]);
            try {
                this.hnadsc.cancel();
            } catch (Exception e) {
                com.hihonor.adsdk.common.b.b.hnadsb(hnadse, "cancelPreCacheVideo,exception: " + e.getMessage(), new Object[0]);
            }
        }
    }

    private DataSource.Factory hnadsa(Cache cache, boolean z, Map<String, String> map, String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "getCacheDataSourceFactory", new Object[0]);
        DataSource.Factory factoryHnadsa = hnadsa(this.hnadsa, map, str);
        if (!z || cache == null) {
            return factoryHnadsa;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "getCacheDataSourceFactory,setCache", new Object[0]);
        return new CacheDataSource.Factory().setCache(cache).setFlags(2).setUpstreamDataSourceFactory(factoryHnadsa);
    }

    private DataSource.Factory hnadsa(Context context, Map<String, String> map, String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "getDefaultHttpDataSourceFactory", new Object[0]);
        if (TextUtils.isEmpty(str)) {
            str = Util.getUserAgent(context, hnadse);
        }
        DefaultHttpDataSource.Factory transferListener = new DefaultHttpDataSource.Factory().setUserAgent(str).setConnectTimeoutMs(hnadsi).setReadTimeoutMs(hnadsh).setTransferListener(new DefaultBandwidthMeter.Builder(this.hnadsa).build());
        Map<String, String> map2 = this.hnadsb;
        if (map2 != null && map2.size() > 0) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "getDefaultHttpDataSourceFactory,property", new Object[0]);
            if (map == null) {
                map = new HashMap<>();
            }
            map.putAll(this.hnadsb);
            transferListener.setDefaultRequestProperties(map);
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "getDefaultHttpDataSourceFactory,new DefaultDataSource.Factory", new Object[0]);
        return new DefaultDataSource.Factory(context, transferListener).setTransferListener(new DefaultBandwidthMeter.Builder(context).build());
    }
}
