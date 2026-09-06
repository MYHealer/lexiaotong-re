package com.kwad.components.offline.a;

import android.content.Context;
import com.kwad.components.core.offline.b.a.n;
import com.kwad.components.offline.api.adInnerEc.IAdInnerEcOfflineCompo;
import com.kwad.components.offline.api.adInnerEc.IAdInnerEcOfflineCompoInitConfig;
import com.kwad.components.offline.api.core.api.IOfflineCompoWrapper;
import com.kwad.components.offline.api.core.soloader.ISoLoader;
import com.kwad.components.offline.api.core.soloader.SoLoadListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class c implements IAdInnerEcOfflineCompoInitConfig {
    @Override // com.kwad.components.offline.api.adInnerEc.IAdInnerEcOfflineCompoInitConfig
    public final ISoLoader soLoader() {
        return new ISoLoader() { // from class: com.kwad.components.offline.a.c.1
            @Override // com.kwad.components.offline.api.core.soloader.ISoLoader
            public final void loadSo(Context context, SoLoadListener soLoadListener) {
                com.kwad.components.offline.a.a.a.a(context, soLoadListener);
            }
        };
    }

    @Override // com.kwad.components.offline.api.IOfflineCompoInitConfig
    public final IOfflineCompoWrapper wrapper() {
        return new n(IAdInnerEcOfflineCompo.PACKAGE_NAME);
    }
}
