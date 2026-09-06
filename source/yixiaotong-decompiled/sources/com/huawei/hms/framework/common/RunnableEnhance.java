package com.huawei.hms.framework.common;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class RunnableEnhance implements Runnable {
    static final String TRANCELOGO = " -->";
    private String parentName = Thread.currentThread().getName();
    private Runnable proxy;

    public String getParentName() {
        return this.parentName;
    }

    RunnableEnhance(Runnable runnable) {
        this.proxy = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.proxy.run();
    }
}
