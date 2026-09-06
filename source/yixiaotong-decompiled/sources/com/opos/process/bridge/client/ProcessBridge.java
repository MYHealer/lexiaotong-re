package com.opos.process.bridge.client;

import com.opos.process.bridge.dispatch.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class ProcessBridge {
    private static final ProcessBridge ourInstance = new ProcessBridge();

    private ProcessBridge() {
    }

    public static ProcessBridge getInstance() {
        return ourInstance;
    }

    public void init() {
        a.a().b();
    }
}
