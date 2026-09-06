package com.kwad.components.offline.api.core.api;

import com.kwad.components.offline.api.tk.model.report.TKExceptionUploadParams;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface ICrash {
    void addCustomKeyValue(ICrashCustomKeyValue iCrashCustomKeyValue);

    void addOnCrashListener(ICrashOccurListener iCrashOccurListener);

    void gatherException(TKExceptionUploadParams tKExceptionUploadParams);

    void gatherException(Throwable th);
}
