package com.kwad.sdk.collector.model.jni;

import com.kwad.sdk.collector.AppStatusNative;
import com.kwad.sdk.collector.model.a;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class AnalyseTaskNative extends NativeObject implements a {
    public AnalyseTaskNative(AppRunningInfoNative appRunningInfoNative, Set<String> set, long j) {
        String[] strArr = new String[set.size()];
        set.toArray(strArr);
        this.mPtr = AppStatusNative.nativeCreateAnalyseTask(appRunningInfoNative.mPtr, strArr, j);
    }

    @Override // com.kwad.sdk.collector.model.jni.NativeObject
    public void destroy() {
        if (this.mPtr != 0) {
            AppStatusNative.nativeDeleteAnalyseTask(this.mPtr);
            this.mPtr = 0L;
        }
    }
}
