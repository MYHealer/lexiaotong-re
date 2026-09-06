package com.kwad.components.offline.api.adInnerEc;

import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.components.offline.api.core.adInnerEc.IAdInnerEcExternalModule;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface IAdInnerEcOfflineCompo extends IOfflineCompo<IAdInnerEcOfflineCompoInitConfig> {
    public static final String IMPL = "com.kwad.sdk.AdInnerEcOfflineCompoImpl";
    public static final String PACKAGE_NAME = "com.kwad.components.adInnerEc";

    public enum AdInnerEcState {
        READY,
        SO_FAIL
    }

    IAdInnerEcExternalModule getAdInnerEcExternalModule();

    AdInnerEcState getState();
}
