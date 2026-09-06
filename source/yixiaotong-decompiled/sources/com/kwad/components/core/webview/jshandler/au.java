package com.kwad.components.core.webview.jshandler;

import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class au implements com.kwad.sdk.core.webview.c.a {
    private KsAppDownloadListener aph;
    private com.kwad.sdk.core.webview.c.c apx;
    private final com.kwad.sdk.core.webview.b fi;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.d mApkDownloadHelper;

    public static final class a extends com.kwad.sdk.core.response.a.a {
        public double arg;
        public double arh;
        public long soFarBytes;
        public int status;
        public long totalBytes;
    }

    public static final class b extends com.kwad.sdk.core.response.a.a {
        public String appName;
        public long aro;
        public String icon;
        public String md5;
        public String pkgName;
        public String tU;
        public String url;
        public String version;
        public int versionCode;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerApkStatusListener";
    }

    public au(com.kwad.sdk.core.webview.b bVar) {
        this.fi = bVar;
        try {
            this.mAdTemplate = new AdTemplate();
            AdTemplate adTemplate = bVar.getAdTemplate();
            if (adTemplate != null) {
                if (adTemplate.mOriginJString != null) {
                    this.mAdTemplate.parseJson(new JSONObject(adTemplate.mOriginJString));
                } else {
                    this.mAdTemplate.parseJson(adTemplate.toJson());
                }
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate == null) {
            cVar.onError(-1, "native photo is null");
            return;
        }
        if (com.kwad.sdk.core.response.helper.a.aL(com.kwad.sdk.core.response.helper.e.eO(adTemplate))) {
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new com.kwad.components.core.e.d.d(this.mAdTemplate);
            }
            this.mApkDownloadHelper.aS(2);
        } else {
            AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate);
            b bVar = new b();
            try {
                bVar.parseJson(new JSONObject(str));
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
            a(adInfoEO, bVar);
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new com.kwad.components.core.e.d.d(this.mAdTemplate);
            }
            this.mApkDownloadHelper.aS(1);
        }
        this.apx = cVar;
        KsAppDownloadListener ksAppDownloadListener = this.aph;
        if (ksAppDownloadListener == null) {
            KsAppDownloadListener ksAppDownloadListenerYr = yr();
            this.aph = ksAppDownloadListenerYr;
            this.mApkDownloadHelper.b(ksAppDownloadListenerYr);
            return;
        }
        this.mApkDownloadHelper.d(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        KsAppDownloadListener ksAppDownloadListener;
        this.apx = null;
        com.kwad.components.core.e.d.d dVar = this.mApkDownloadHelper;
        if (dVar == null || (ksAppDownloadListener = this.aph) == null) {
            return;
        }
        dVar.c(ksAppDownloadListener);
        this.aph = null;
    }

    private static void a(AdInfo adInfo, b bVar) {
        adInfo.adBaseInfo.adOperationType = 1;
        adInfo.adBaseInfo.appPackageName = bVar.pkgName;
        adInfo.adBaseInfo.appName = bVar.appName;
        adInfo.adBaseInfo.appVersion = bVar.version;
        adInfo.adBaseInfo.packageSize = bVar.aro;
        adInfo.adBaseInfo.appIconUrl = bVar.icon;
        adInfo.adBaseInfo.appDescription = bVar.tU;
        adInfo.adConversionInfo.appDownloadUrl = bVar.url;
        adInfo.downloadId = com.kwad.sdk.utils.an.md5(adInfo.adConversionInfo.appDownloadUrl);
    }

    private KsAppDownloadListener yr() {
        return new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.webview.jshandler.au.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                au.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                au.this.a(2, (i * 1.0f) / 100.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                au.this.a(5, 1.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                au.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                au.this.a(6, 1.0f);
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i) {
                au.this.a(3, (i * 1.0f) / 100.0f);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f) {
        if (this.apx != null) {
            a aVar = new a();
            aVar.arg = f;
            aVar.status = i;
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate != null) {
                aVar.totalBytes = com.kwad.sdk.core.response.helper.e.eO(adTemplate).totalBytes;
                aVar.soFarBytes = com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate).soFarBytes;
                if (aVar.totalBytes > 0) {
                    aVar.arh = (aVar.soFarBytes * 1.0d) / aVar.totalBytes;
                } else {
                    aVar.arh = 0.0d;
                }
            }
            this.apx.b(aVar);
        }
    }
}
