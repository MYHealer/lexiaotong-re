package com.kwad.components.offline.d;

import android.content.Context;
import com.kwad.components.offline.api.obiwan.IObiwanLogcat;
import com.kwad.components.offline.api.obiwan.IObiwanOfflineCompo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a implements com.kwad.components.core.offline.a.e.a {
    private final IObiwanOfflineCompo axM;

    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return a.class;
    }

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    public a(IObiwanOfflineCompo iObiwanOfflineCompo) {
        this.axM = iObiwanOfflineCompo;
    }

    @Override // com.kwad.sdk.components.b
    public final int priority() {
        return this.axM.priority();
    }

    public final void updateConfigs() {
        this.axM.updateConfigs();
    }

    public final IObiwanLogcat getLog() {
        return this.axM.getLog();
    }
}
