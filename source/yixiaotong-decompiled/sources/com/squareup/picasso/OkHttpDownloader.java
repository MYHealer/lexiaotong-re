package com.squareup.picasso;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class OkHttpDownloader implements Downloader {

    /* JADX INFO: renamed from: client, reason: collision with root package name */
    private final OkHttpClient f8524client;

    protected final OkHttpClient getClient() {
        return this.f8524client;
    }

    private static OkHttpClient defaultOkHttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(C.DEFAULT_SEEK_FORWARD_INCREMENT_MS, TimeUnit.MILLISECONDS);
        okHttpClient.setReadTimeout(SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US, TimeUnit.MILLISECONDS);
        okHttpClient.setWriteTimeout(SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US, TimeUnit.MILLISECONDS);
        return okHttpClient;
    }

    public OkHttpDownloader(Context context) {
        this(Utils.createDefaultCacheDir(context));
    }

    public OkHttpDownloader(File file) {
        this(file, Utils.calculateDiskCacheSize(file));
    }

    public OkHttpDownloader(Context context, long j) {
        this(Utils.createDefaultCacheDir(context), j);
    }

    public OkHttpDownloader(File file, long j) {
        this(defaultOkHttpClient());
        try {
            this.f8524client.setCache(new com.squareup.okhttp.Cache(file, j));
        } catch (IOException unused) {
        }
    }

    public OkHttpDownloader(OkHttpClient okHttpClient) {
        this.f8524client = okHttpClient;
    }

    @Override // com.squareup.picasso.Downloader
    public Downloader.Response load(Uri uri, int i) throws IOException {
        CacheControl cacheControlBuild;
        if (i == 0) {
            cacheControlBuild = null;
        } else if (NetworkPolicy.isOfflineOnly(i)) {
            cacheControlBuild = CacheControl.FORCE_CACHE;
        } else {
            CacheControl.Builder builder = new CacheControl.Builder();
            if (!NetworkPolicy.shouldReadFromDiskCache(i)) {
                builder.noCache();
            }
            if (!NetworkPolicy.shouldWriteToDiskCache(i)) {
                builder.noStore();
            }
            cacheControlBuild = builder.build();
        }
        com.squareup.okhttp.Request.Builder builderUrl = new com.squareup.okhttp.Request.Builder().url(uri.toString());
        if (cacheControlBuild != null) {
            builderUrl.cacheControl(cacheControlBuild);
        }
        Response responseExecute = this.f8524client.newCall(builderUrl.build()).execute();
        int iCode = responseExecute.code();
        if (iCode >= 300) {
            responseExecute.body().close();
            throw new Downloader.ResponseException(iCode + PPSLabelView.Code + responseExecute.message(), i, iCode);
        }
        boolean z = responseExecute.cacheResponse() != null;
        ResponseBody responseBodyBody = responseExecute.body();
        return new Downloader.Response(responseBodyBody.byteStream(), z, responseBodyBody.contentLength());
    }

    @Override // com.squareup.picasso.Downloader
    public void shutdown() {
        com.squareup.okhttp.Cache cache = this.f8524client.getCache();
        if (cache != null) {
            try {
                cache.close();
            } catch (IOException unused) {
            }
        }
    }
}
