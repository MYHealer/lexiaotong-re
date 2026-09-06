package com.facebook.common.memory;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public enum MemoryTrimType {
    OnCloseToDalvikHeapLimit(0.5d),
    OnSystemLowMemoryWhileAppInForeground(0.5d),
    OnSystemLowMemoryWhileAppInBackground(1.0d),
    OnAppBackgrounded(1.0d);

    private double mSuggestedTrimRatio;

    public double getSuggestedTrimRatio() {
        return this.mSuggestedTrimRatio;
    }

    MemoryTrimType(double d) {
        this.mSuggestedTrimRatio = d;
    }
}
