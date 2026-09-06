package com.hihonor.adsdk.common.video.g.h.e;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.database.StandaloneDatabaseProvider;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheKeyFactory;
import com.google.android.exoplayer2.upstream.cache.CacheSpan;
import com.google.android.exoplayer2.upstream.cache.ContentMetadata;
import com.google.android.exoplayer2.upstream.cache.LeastRecentlyUsedCacheEvictor;
import com.google.android.exoplayer2.upstream.cache.SimpleCache;
import com.stub.StubApp;
import java.io.File;
import java.util.Iterator;
import java.util.NavigableSet;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class a extends com.hihonor.adsdk.common.video.g.h.a {
    private static final String hnadsf = "GoogleCacheRepository";
    private Cache hnadsd;
    private DatabaseProvider hnadse;

    public a(Context context, long j, File file) {
        try {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, hnadsf, new Object[0]);
            String str = (file != null ? file.getCanonicalPath() : StubApp.getOrigApplicationContext(context.getApplicationContext()).getCacheDir().getCanonicalPath()) + File.separator + com.hihonor.adsdk.common.video.g.h.a.hnadsc;
            com.hihonor.adsdk.common.b.b.hnadsa(hnadsf, (Object) ("GoogleCacheRepository,path：" + str));
            this.hnadsa = new File(str);
            this.hnadse = new StandaloneDatabaseProvider(context);
            this.hnadsb = j;
            hnadse();
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsf, "new GoogleCacheRepository,exception:" + e.getMessage(), new Object[0]);
        }
    }

    private void hnadse() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "initCache", new Object[0]);
        try {
            this.hnadsd = new SimpleCache(this.hnadsa, new LeastRecentlyUsedCacheEvictor(this.hnadsb), this.hnadse);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsf, "initCache,exception: " + e.getMessage(), new Object[0]);
        }
    }

    @Override // com.hihonor.adsdk.common.video.g.h.a
    public String hnadsa(String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "getCacheKey", new Object[0]);
        return CacheKeyFactory.DEFAULT.buildCacheKey(new DataSpec(Uri.parse(str)));
    }

    @Override // com.hihonor.adsdk.common.video.g.h.a
    public boolean hnadsb() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "hasSimpleCache", new Object[0]);
        return this.hnadsd != null;
    }

    @Override // com.hihonor.adsdk.common.video.g.h.a
    public void hnadsc(String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "removeCache", new Object[0]);
        try {
            Cache cache = this.hnadsd;
            if (cache != null) {
                cache.removeResource(hnadsa(str));
            }
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "removeCache,error msg is " + e.getMessage(), new Object[0]);
        }
    }

    public Cache hnadsd() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "getCache", new Object[0]);
        return this.hnadsd;
    }

    @Override // com.hihonor.adsdk.common.video.g.h.a
    public boolean hnadsb(String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "isFullyCached", new Object[0]);
        try {
            if (!TextUtils.isEmpty(str) && this.hnadsd != null) {
                String strHnadsa = hnadsa(str);
                if (!TextUtils.isEmpty(strHnadsa)) {
                    NavigableSet<CacheSpan> cachedSpans = this.hnadsd.getCachedSpans(strHnadsa);
                    if (cachedSpans.size() > 0) {
                        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "isFullyCached,size>0", new Object[0]);
                        long j = this.hnadsd.getContentMetadata(strHnadsa).get(ContentMetadata.KEY_CONTENT_LENGTH, -1L);
                        Iterator<CacheSpan> it = cachedSpans.iterator();
                        long cachedLength = 0;
                        while (it.hasNext()) {
                            CacheSpan next = it.next();
                            File file = next.file;
                            if (file == null || !file.exists()) {
                                cachedLength = cachedLength;
                                it = it;
                            } else {
                                cachedLength += this.hnadsd.getCachedLength(strHnadsa, next.position, next.length);
                                it = it;
                            }
                        }
                        long j2 = cachedLength;
                        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "isPreviewCache,contentLength:" + j + ",currentLength:" + j2, new Object[0]);
                        if (j2 > 0 && j2 >= j) {
                            return true;
                        }
                    }
                }
                return false;
            }
            com.hihonor.adsdk.common.b.b.hnadse(hnadsf, "isPreviewCache,url is invalid or cache is null,return false", new Object[0]);
            return false;
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsf, "isFullyCached,exception:" + e.getMessage(), new Object[0]);
            return false;
        }
    }

    @Override // com.hihonor.adsdk.common.video.g.h.a
    public void hnadsa() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "clearCache", new Object[0]);
        hnadsc();
        try {
            SimpleCache.delete(this.hnadsa, this.hnadse);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "clearCache,error msg is " + e.getMessage(), new Object[0]);
        }
        hnadse();
    }

    @Override // com.hihonor.adsdk.common.video.g.h.a
    public void hnadsc() {
        Cache cache;
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "releaseCache", new Object[0]);
        try {
            File file = this.hnadsa;
            if (file == null || !SimpleCache.isCacheFolderLocked(file) || (cache = this.hnadsd) == null) {
                return;
            }
            cache.release();
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "releaseCache,error msg is " + e.getMessage(), new Object[0]);
        }
    }
}
