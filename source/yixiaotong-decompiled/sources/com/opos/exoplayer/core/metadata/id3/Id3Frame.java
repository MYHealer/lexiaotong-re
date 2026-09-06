package com.opos.exoplayer.core.metadata.id3;

import com.opos.exoplayer.core.metadata.Metadata;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class Id3Frame implements Metadata.Entry {
    public final String f;

    public Id3Frame(String str) {
        this.f = (String) com.opos.exoplayer.core.i.a.a(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
