package com.kwad.sdk.crash.model.message;

import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class AnrReason extends com.kwad.sdk.core.response.a.a implements Serializable {
    private static final long serialVersionUID = 2458805633316742361L;
    public String mLongMsg;
    public String mShortMsg;
    public String mTag;

    @Override // com.kwad.sdk.core.response.a.a
    public String toString() {
        return "mTag: " + this.mTag + "\nmShortMsg: " + this.mShortMsg + "\nmLongMsg: " + this.mLongMsg + '\n';
    }
}
