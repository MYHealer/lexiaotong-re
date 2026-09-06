package com.kwad.components.core.proxy.launchdialog;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface g {

    public static class b implements g {
        private Lifecycle.Event ajg;

        public b(Lifecycle.Event event) {
            this.ajg = event;
        }

        public final boolean b(Lifecycle.Event event) {
            return this.ajg.equals(event);
        }

        public final String toString() {
            return "PageEventItem{mEvent=" + this.ajg + '}';
        }
    }

    public static class a implements g {
        private long ajn;

        public a(long j) {
            this.ajn = j;
        }

        public final boolean Q(long j) {
            return this.ajn > 0 && System.currentTimeMillis() - j >= this.ajn;
        }

        public final String toString() {
            return "DurationMoreThanItem{mDuration=" + this.ajn + '}';
        }
    }
}
