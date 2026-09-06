package com.kwad.sdk.crash.report;

import com.kwad.sdk.core.report.n;
import com.kwad.sdk.crash.model.message.ExceptionMessage;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a {
    public static void b(ExceptionMessage exceptionMessage) {
        n nVar = new n(10211L);
        nVar.errorMsg = exceptionMessage.getReportMsg();
        com.kwad.sdk.core.report.g.a(nVar);
    }
}
