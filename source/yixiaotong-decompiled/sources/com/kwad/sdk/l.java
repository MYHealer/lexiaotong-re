package com.kwad.sdk;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.y;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class l implements com.kwad.framework.filedownloader.a.b {
    private final OkHttpClient aGi;
    private final Request.Builder aGj;
    private Request aGk;
    private Response aGl;

    /* synthetic */ l(String str, OkHttpClient okHttpClient, byte b) {
        this(str, okHttpClient);
    }

    private l(Request.Builder builder, OkHttpClient okHttpClient) {
        this.aGj = builder;
        this.aGi = okHttpClient;
    }

    private l(String str, OkHttpClient okHttpClient) {
        this(new Request.Builder().url(str), okHttpClient);
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final void addHeader(String str, String str2) {
        this.aGj.addHeader(str, str2);
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final InputStream getInputStream() {
        Response response = this.aGl;
        if (response == null) {
            throw new IllegalStateException("Please invoke #execute first!");
        }
        return ((com.kwad.sdk.service.a.j) ServiceProvider.get(com.kwad.sdk.service.a.j.class)).wrapInputStream(response.body().byteStream());
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final Map<String, List<String>> BO() {
        if (this.aGk == null) {
            this.aGk = this.aGj.build();
        }
        return this.aGk.headers().toMultimap();
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final Map<String, List<String>> BP() {
        Response response = this.aGl;
        if (response == null) {
            return null;
        }
        return response.headers().toMultimap();
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final String bW(String str) {
        String str2;
        if (!"Content-Disposition".equals(str)) {
            Response response = this.aGl;
            if (response == null) {
                return null;
            }
            return response.header(str);
        }
        try {
            if (TextUtils.isEmpty(com.kwad.framework.filedownloader.f.f.cn(this.aGl.header(str)))) {
                List<String> listPathSegments = this.aGl.request().url().pathSegments();
                str2 = listPathSegments.get(listPathSegments.size() - 1);
                return "attachment; filename=\"" + cS(str2) + "\"";
            }
            return this.aGl.header(str);
        } catch (Exception unused) {
            str2 = "";
        }
    }

    private String cS(String str) {
        String strBW = bW("Content-Type");
        String extension = y.getExtension(str);
        if (TextUtils.isEmpty(strBW) || !TextUtils.isEmpty(extension)) {
            return TextUtils.isEmpty(str) ? System.currentTimeMillis() + ".apk" : str;
        }
        String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(strBW);
        return System.currentTimeMillis() + (TextUtils.isEmpty(extensionFromMimeType) ? ".apk" : "." + extensionFromMimeType);
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final void execute() {
        if (this.aGk == null) {
            this.aGk = this.aGj.build();
        }
        this.aGl = this.aGi.newCall(this.aGk).execute();
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final int getResponseCode() {
        Response response = this.aGl;
        if (response == null) {
            throw new IllegalStateException("Please invoke #execute first!");
        }
        return response.code();
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final void BQ() {
        this.aGk = null;
        Response response = this.aGl;
        if (response != null && response.body() != null) {
            com.kwad.sdk.crash.utils.b.closeQuietly(this.aGl.body());
        }
        this.aGl = null;
    }

    public static class a implements com.kwad.framework.filedownloader.f.c.b {
        private volatile OkHttpClient aGi;
        private OkHttpClient.Builder aGm;

        public a() {
        }

        public a(boolean z) {
            if (z) {
                this.aGm = l.Go();
            } else {
                this.aGm = l.Gn();
            }
        }

        @Override // com.kwad.framework.filedownloader.f.c.b
        public final com.kwad.framework.filedownloader.a.b bX(String str) {
            if (this.aGi == null) {
                synchronized (a.class) {
                    if (this.aGi == null) {
                        OkHttpClient.Builder builder = this.aGm;
                        this.aGi = builder != null ? builder.build() : new OkHttpClient();
                        this.aGm = null;
                    }
                }
            }
            return new l(str, this.aGi, (byte) 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static OkHttpClient.Builder Gn() {
        return new OkHttpClient.Builder().connectTimeout(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS).addInterceptor(new com.kwad.sdk.j.a()).readTimeout(0L, TimeUnit.MILLISECONDS).connectionPool(new ConnectionPool(6, 60000L, TimeUnit.MILLISECONDS)).retryOnConnectionFailure(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static OkHttpClient.Builder Go() {
        return new OkHttpClient.Builder().connectTimeout(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS).addInterceptor(new com.kwad.sdk.j.a()).protocols(Util.immutableList(new Protocol[]{Protocol.HTTP_1_1})).readTimeout(0L, TimeUnit.MILLISECONDS).connectionPool(new ConnectionPool(6, 60000L, TimeUnit.MILLISECONDS)).retryOnConnectionFailure(true);
    }
}
