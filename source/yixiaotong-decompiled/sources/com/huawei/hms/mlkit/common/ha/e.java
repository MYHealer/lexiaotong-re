package com.huawei.hms.mlkit.common.ha;

import java.util.TimerTask;

/* JADX INFO: compiled from: HianalyticsOnReportTask.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class e extends TimerTask {
    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        try {
            c.f4152a.a();
        } catch (Exception unused) {
            b.a("HaLogOnReport", "Failed to report hianalytics data");
        }
    }
}
