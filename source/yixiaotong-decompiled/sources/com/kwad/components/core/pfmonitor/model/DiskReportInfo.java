package com.kwad.components.core.pfmonitor.model;

import com.kwad.sdk.utils.ac;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class DiskReportInfo extends com.kwad.sdk.commercial.c.a implements Serializable {
    public static final int STATUS_ERROR = 1;
    public static final int STATUS_NORMAL = 2;
    private static final long serialVersionUID = 7321357294899828707L;
    public String pathList;
    public int status;

    public static DiskReportInfo createErrorInfo(List<f> list) {
        DiskReportInfo diskReportInfo = new DiskReportInfo();
        diskReportInfo.status = 1;
        diskReportInfo.pathList = ac.Y(list).toString();
        return diskReportInfo;
    }

    public static DiskReportInfo createCommonPathListInfo(List<f> list) {
        DiskReportInfo diskReportInfo = new DiskReportInfo();
        diskReportInfo.status = 2;
        diskReportInfo.pathList = ac.Y(list).toString();
        return diskReportInfo;
    }
}
