package com.kwad.components.core.pfmonitor;

import com.kwad.components.core.pfmonitor.model.DiskReportInfo;
import com.kwad.components.core.pfmonitor.model.f;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class c {
    public static void r(List<f> list) {
        try {
            DiskReportInfo diskReportInfoCreateCommonPathListInfo = DiskReportInfo.createCommonPathListInfo(list);
            com.kwad.sdk.core.d.c.d("DiskPerformanceReporter", "reportPathList info: " + diskReportInfoCreateCommonPathListInfo.pathList);
            com.kwad.sdk.commercial.c.e((com.kwad.sdk.commercial.c.a) diskReportInfoCreateCommonPathListInfo, false);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    public static void s(List<f> list) {
        try {
            DiskReportInfo diskReportInfoCreateErrorInfo = DiskReportInfo.createErrorInfo(list);
            com.kwad.sdk.core.d.c.d("DiskPerformanceReporter", "reportPathError info: " + diskReportInfoCreateErrorInfo.pathList);
            com.kwad.sdk.commercial.c.e((com.kwad.sdk.commercial.c.a) diskReportInfoCreateErrorInfo, true);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }
}
