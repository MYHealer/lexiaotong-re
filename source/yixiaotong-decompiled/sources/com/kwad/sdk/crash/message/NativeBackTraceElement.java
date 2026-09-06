package com.kwad.sdk.crash.message;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class NativeBackTraceElement extends BackTraceElement {
    private static final long serialVersionUID = 8646793782725084250L;
    public String mBuildId;
    public String mPc;

    public final String getBuildId() {
        return this.mBuildId;
    }

    public final String getPc() {
        return this.mPc;
    }

    public final void setBuildId(String str) {
        this.mBuildId = str;
    }

    public final void setPc(String str) {
        this.mPc = str;
    }

    public NativeBackTraceElement(String str, int i) {
        super(str, i);
        this.mBuildId = "";
        this.mPc = "";
    }
}
