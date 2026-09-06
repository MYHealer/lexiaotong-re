package com.opos.exoplayer.core.e;

import android.net.Uri;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class n extends com.opos.exoplayer.core.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f6404a;

    public n(String str, Uri uri) {
        super(str);
        this.f6404a = uri;
    }

    @Override // com.opos.exoplayer.core.o, com.opos.exoplayer.core.i.c
    public String a() {
        return "UnrecognizedInputFormatException";
    }
}
