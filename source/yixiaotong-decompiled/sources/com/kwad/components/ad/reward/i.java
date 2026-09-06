package com.kwad.components.ad.reward;

import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class i {
    private Map<String, List<AdTemplate>> tX;

    static class a {
        private static final i tY = new i(0);
    }

    /* synthetic */ i(byte b) {
        this();
    }

    private i() {
        this.tX = new ConcurrentHashMap();
    }

    public static i hE() {
        return a.tY;
    }

    public final void I(String str) {
        this.tX.remove(str);
    }
}
