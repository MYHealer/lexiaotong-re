package com.kwad.sdk.mobileid;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class d {
    private String biV;
    private String errorReason;
    private boolean success;

    public final String Sm() {
        return this.errorReason;
    }

    public final String Sn() {
        return this.biV;
    }

    public final void hb(String str) {
        this.biV = str;
    }

    public final boolean isSuccess() {
        return this.success;
    }

    public d(boolean z, String str) {
        this.success = z;
        this.errorReason = str;
    }

    public final String toString() {
        return "UaidErrorReason{success=" + this.success + ", errorReason='" + this.errorReason + "', extraErrorMsg='" + this.biV + "'}";
    }
}
