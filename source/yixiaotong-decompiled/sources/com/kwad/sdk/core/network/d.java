package com.kwad.sdk.core.network;

import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.request.model.StatusInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.be;
import com.masget.base.AppConfig;
import com.ubixnow.ooooo.o0OO000o;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class d extends b {
    public static final String TRACK_ID_KEY = "kuaishou-tracing-token";
    public static boolean hadCreateInstance;

    protected boolean enablePrivateInfoObtain() {
        return true;
    }

    protected boolean needAppList() {
        return false;
    }

    protected boolean needAppendKuaHeader() {
        return true;
    }

    protected boolean needDeviceInfoBody() {
        return true;
    }

    public d() {
        this(0, null);
    }

    public d(int i, SceneImpl sceneImpl) {
        hadCreateInstance = true;
        if (needAppendKuaHeader()) {
            appendKUAHeader();
        }
        if (needDeviceInfoBody()) {
            putBody("deviceInfo", com.kwad.sdk.utils.c.d.k(needAppList(), i));
        }
        if (sceneImpl != null) {
            putBody("statusInfo", StatusInfo.e(sceneImpl));
        }
    }

    private void appendKUAHeader() {
        com.kwad.sdk.service.a.f fVar;
        com.kwad.sdk.core.i.c cVarK = com.kwad.sdk.core.i.a.k(true, false);
        if (cVarK == null || (fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)) == null) {
            return;
        }
        addHeader("KUA", cVarK.cd(fVar.getContext()));
    }

    @Override // com.kwad.sdk.core.network.b
    protected void buildBaseBody() {
        try {
            putBody("protocolVersion", AppConfig.OPEN_API_VERSION);
            putBody("SDKVersion", BuildConfig.VERSION_NAME);
            putBody("SDKVersionCode", BuildConfig.VERSION_CODE);
            putBody("sdkApiVersion", ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion());
            putBody("sdkApiVersionCode", ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersionCode());
            putBody("sdkType", 1);
            putBody("appInfo", com.kwad.sdk.core.request.model.a.Np());
            putBody("tkVersion", "6.2.3");
            putBody("adSdkVersion", BuildConfig.VERSION_NAME);
            putBody("networkInfo", com.kwad.sdk.core.request.model.d.Nt());
            putBody("liveSupportMode", ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).tu() ? 1 : 0);
            putBody("waynePlayerSupportMode", ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).tt() ? 1 : 0);
            putBody("closureSupportMode", ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).tr() ? 1 : 0);
            putBody("userInfo", com.kwad.sdk.core.request.model.g.Nw());
            putBody("requestSessionData", q.Mj().eL(getUrl()));
            putBody(com.alipay.sdk.tid.b.f, System.currentTimeMillis());
            if (enablePrivateInfoObtain()) {
                buildBaseBodyWithPrivateInfo();
            }
        } catch (Throwable th) {
            reportSdkCaughtException(th);
        }
        putBody("mediumDisableSensor", be.useSensorManagerDisable());
        putBody("kwaiMerchantSdkVersion", com.opos.cmn.an.custom.policy.BuildConfig.SDK_VER_NAME);
    }

    protected void buildBaseBodyWithPrivateInfo() {
        try {
            putBody("geoInfo", com.kwad.sdk.core.request.model.c.Ns());
            putBody("kGeoInfo", ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Fz());
            putBody(o0OO000o.o00O0O0O, com.kwad.sdk.core.request.model.e.Nv());
        } catch (Throwable th) {
            reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.core.network.b
    protected void buildBaseHeader() {
        if (com.kwad.framework.b.a.pe.booleanValue()) {
            com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
            addHeader("trace-context", "{\"laneId\":\"STAGING.online.u\"}");
            com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        }
    }
}
