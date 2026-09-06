package com.jd.ad.sdk.jad_ep;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: VideoExecutor.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_cp {
    public static final ScheduledThreadPoolExecutor jad_an;

    static {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        jad_an = scheduledThreadPoolExecutor;
        scheduledThreadPoolExecutor.setKeepAliveTime(30L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.setRejectedExecutionHandler(new jad_an("video"));
    }
}
