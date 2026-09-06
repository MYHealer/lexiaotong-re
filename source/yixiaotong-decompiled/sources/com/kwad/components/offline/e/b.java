package com.kwad.components.offline.e;

import android.content.Context;
import com.kwad.components.offline.api.tk.IOfflineCompoTachikomaContext;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TKDownloadListener;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.components.offline.e.a.i;
import com.kwad.sdk.components.t;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b implements com.kwad.components.core.offline.a.f.c {
    private final ITkOfflineCompo axT;

    @Override // com.kwad.sdk.components.b
    public final Class<b> getComponentsType() {
        return b.class;
    }

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    public b(ITkOfflineCompo iTkOfflineCompo) {
        this.axT = iTkOfflineCompo;
    }

    @Override // com.kwad.sdk.components.b
    public final int priority() {
        return this.axT.priority();
    }

    @Override // com.kwad.components.core.offline.a.f.c
    public final ITkOfflineCompo.TKState getState() {
        return this.axT.getState();
    }

    @Override // com.kwad.components.core.offline.a.f.c
    public final t a(Context context, String str, int i, int i2, boolean z) {
        IOfflineCompoTachikomaContext context2 = this.axT.getContext(context, str, i, i2, z);
        if (context2 == null) {
            return null;
        }
        return new i(context2);
    }

    @Override // com.kwad.components.core.offline.a.f.c
    public final String getJsBaseDir(Context context, String str) {
        return this.axT.getJsBaseDir(context, str);
    }

    public final void onConfigRefresh(Context context, JSONObject jSONObject) {
        this.axT.onConfigRefresh(context, jSONObject);
    }

    @Override // com.kwad.components.core.offline.a.f.c
    public final StyleTemplate checkStyleTemplateById(Context context, String str, String str2, String str3, int i) {
        return this.axT.checkStyleTemplateById(context, str, str2, str3, i);
    }

    @Override // com.kwad.components.core.offline.a.f.c
    public final void loadTkFileByTemplateId(Context context, String str, String str2, String str3, int i, TKDownloadListener tKDownloadListener) {
        this.axT.loadTkFileByTemplateId(context, str, str2, str3, i, tKDownloadListener);
    }

    @Override // com.kwad.components.core.offline.a.f.c
    public final void onDestroy() {
        this.axT.onDestroy();
    }
}
