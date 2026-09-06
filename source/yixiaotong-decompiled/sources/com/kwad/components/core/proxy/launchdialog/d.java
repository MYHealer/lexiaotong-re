package com.kwad.components.core.proxy.launchdialog;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class d {
    private final Lifecycle.Event ajg;
    private final long ajh = System.currentTimeMillis();

    public final Lifecycle.Event vH() {
        return this.ajg;
    }

    public final long vI() {
        return this.ajh;
    }

    public d(Lifecycle.Event event) {
        this.ajg = event;
    }

    public final String toString() {
        return "LifecycleStamp{mEvent=" + this.ajg + ", mEventTimestamp=" + this.ajh + '}';
    }
}
