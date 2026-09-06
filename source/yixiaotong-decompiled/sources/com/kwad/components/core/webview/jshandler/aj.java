package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class aj implements com.kwad.sdk.core.webview.c.a {
    private final com.kwad.sdk.core.webview.b apJ;
    private final Handler aqd = new Handler(Looper.getMainLooper());
    private final AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.d mApkDownloadHelper;

    public static final class a extends com.kwad.sdk.core.response.a.a {
        public String appId;
        public String appName;
        public int aqE;
        public String aqF;
        public String aqG;

        @Deprecated
        public boolean aqH;
        public boolean aqI;
        public boolean aqJ;
        public String icon;
        public String md5;
        public String pkgName;
        public String tU;
        public int type;
        public String url;
        public String version;
        public int versionCode;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "handleAdUrl";
    }

    public aj(com.kwad.sdk.core.webview.b bVar) {
        this.apJ = bVar;
        AdTemplate adTemplate = new AdTemplate();
        this.mAdTemplate = adTemplate;
        try {
            AdTemplate adTemplate2 = bVar.getAdTemplate();
            if (adTemplate2 != null) {
                if (adTemplate2.mOriginJString != null) {
                    adTemplate.parseJson(new JSONObject(adTemplate2.mOriginJString));
                } else {
                    adTemplate.parseJson(adTemplate2.toJson());
                }
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        if (com.kwad.sdk.core.response.helper.a.aL(com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate))) {
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new com.kwad.components.core.e.d.d(this.mAdTemplate);
            }
            this.mApkDownloadHelper.aS(2);
        } else {
            AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate);
            a aVar = new a();
            try {
                aVar.parseJson(new JSONObject(str));
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
            a(adInfoEO, aVar);
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new com.kwad.components.core.e.d.d(this.mAdTemplate);
            }
            this.mApkDownloadHelper.aS(1);
        }
        this.aqd.post(new com.kwad.sdk.utils.bi() { // from class: com.kwad.components.core.webview.jshandler.aj.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C0661a(aj.this.apJ.adW.getContext()).aJ(aj.this.mAdTemplate).b(aj.this.mApkDownloadHelper).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.core.webview.jshandler.aj.1.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                    }
                }));
            }
        });
        cVar.b(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.aqd.removeCallbacksAndMessages(null);
    }

    private static void a(AdInfo adInfo, a aVar) {
        AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
        adConversionInfo.deeplinkUrl = aVar.aqF;
        adConversionInfo.marketUrl = aVar.aqG;
        adInfo.adBaseInfo.adOperationType = aVar.type;
        adInfo.adBaseInfo.appPackageName = aVar.pkgName;
        adInfo.adBaseInfo.appName = aVar.appName;
        adInfo.adBaseInfo.appVersion = aVar.version;
        adInfo.adBaseInfo.packageSize = aVar.aqE;
        adInfo.adBaseInfo.appIconUrl = aVar.icon;
        adInfo.adBaseInfo.appDescription = aVar.tU;
        if (com.kwad.sdk.core.response.helper.a.aL(adInfo)) {
            adInfo.adConversionInfo.appDownloadUrl = aVar.url;
            adInfo.downloadId = com.kwad.sdk.utils.an.md5(adInfo.adConversionInfo.appDownloadUrl);
        } else {
            adInfo.adConversionInfo.h5Url = aVar.url;
        }
    }
}
