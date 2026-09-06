package com.kwad.components.core.request.model;

import android.text.TextUtils;
import com.kwad.components.core.request.j;
import com.kwad.sdk.commercial.convert.e;
import com.kwad.sdk.core.response.model.AdResultData;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a {
    public final ImpInfo abn;
    public final com.kwad.components.core.request.c ajK;
    public j ajL;
    public List<String> ajM;
    public boolean ajN;
    public boolean ajO;
    public c ajP;
    private String ajQ;

    public final void bi(String str) {
        this.ajQ = str;
    }

    public final j wb() {
        return this.ajL;
    }

    /* synthetic */ a(C0690a c0690a, byte b) {
        this(c0690a);
    }

    public static void a(a aVar, AdResultData adResultData, boolean z) {
        e.a(aVar.abn.adScene, aVar.wc(), adResultData.getAdSource());
        if (adResultData.isAdResultDataEmpty()) {
            aVar.ajK.a(com.kwad.sdk.core.network.e.aTe.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.aTe.msg : adResultData.testErrorMsg, z);
        } else {
            aVar.ajK.a(adResultData, z);
        }
    }

    public static void a(a aVar, int i, String str, boolean z) {
        aVar.ajK.a(i, str, z);
        e.a(aVar.getAdStyle(), i, str, aVar.wc());
    }

    private a(C0690a c0690a) {
        this.abn = c0690a.abn;
        this.ajK = c0690a.ajK;
        this.ajN = c0690a.ajN;
        this.ajO = c0690a.ajO;
        this.ajL = c0690a.ajR;
    }

    public final long getPosId() {
        if (this.abn.adScene != null) {
            return this.abn.adScene.getPosId();
        }
        return -1L;
    }

    public final int getAdNum() {
        if (this.abn.adScene != null) {
            return this.abn.adScene.getAdNum();
        }
        return 1;
    }

    public final int getAdStyle() {
        if (this.abn.adScene != null) {
            return this.abn.adScene.adStyle;
        }
        return 0;
    }

    public final String wc() {
        return !TextUtils.isEmpty(this.ajQ) ? this.ajQ : "network_only";
    }

    /* JADX INFO: renamed from: com.kwad.components.core.request.model.a$a, reason: collision with other inner class name */
    public static class C0690a {
        public ImpInfo abn;
        public com.kwad.components.core.request.c ajK;
        public boolean ajN;
        public boolean ajO;
        public j ajR;

        public final C0690a a(com.kwad.components.core.request.c cVar) {
            this.ajK = cVar;
            return this;
        }

        public final C0690a a(j jVar) {
            this.ajR = jVar;
            return this;
        }

        public final C0690a aY(boolean z) {
            this.ajN = true;
            return this;
        }

        public final C0690a aZ(boolean z) {
            this.ajO = z;
            return this;
        }

        public final C0690a e(ImpInfo impInfo) {
            this.abn = impInfo;
            return this;
        }

        public final a wd() {
            if (com.kwad.components.ad.f.a.pe.booleanValue() && (this.abn == null || this.ajK == null)) {
                throw new IllegalStateException("AdRequestParams build Illegal");
            }
            return new a(this, (byte) 0);
        }
    }
}
