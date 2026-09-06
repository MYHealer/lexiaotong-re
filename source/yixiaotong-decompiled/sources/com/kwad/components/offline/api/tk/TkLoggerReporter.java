package com.kwad.components.offline.api.tk;

import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.sdk.commercial.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class TkLoggerReporter {

    /* JADX INFO: renamed from: com.kwad.components.offline.api.tk.TkLoggerReporter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* synthetic */ TkLoggerReporter(AnonymousClass1 anonymousClass1) {
        this();
    }

    static final class Holder {
        private static final TkLoggerReporter sInstance = new TkLoggerReporter(null);

        private Holder() {
        }
    }

    private TkLoggerReporter() {
    }

    public static TkLoggerReporter get() {
        return Holder.sInstance;
    }

    private void reportEvent(String str, String str2, JSONObject jSONObject, d dVar) {
        OfflineHostProvider.getApi().loggerReporter().reportEvent(dVar);
    }

    public final void reportTKDownload(String str, JSONObject jSONObject) {
        OfflineHostProvider.getApi().loggerReporter().reportEvent(d.In().m983do(str).g(0.1d).Q("ad_tk_download_performance", "download_state").i(jSONObject));
    }

    public final void reportTKSODownload(String str, JSONObject jSONObject) {
        OfflineHostProvider.getApi().loggerReporter().reportEvent(d.In().m983do(str).g(0.1d).Q("ad_tk_so_download_event", "download_state").i(jSONObject));
    }

    public final void reportTKSOLoad(String str, JSONObject jSONObject) {
        OfflineHostProvider.getApi().loggerReporter().reportEvent(d.In().m983do(str).g(0.1d).Q("ad_tk_so_load_performence", "download_state").i(jSONObject));
    }

    public final void reportTKPerform(String str, JSONObject jSONObject) {
        OfflineHostProvider.getApi().loggerReporter().reportEvent(d.In().m983do(str).g(0.1d).i(0.001d).Q("ad_tk_render_performance", "render_state").i(jSONObject));
    }
}
