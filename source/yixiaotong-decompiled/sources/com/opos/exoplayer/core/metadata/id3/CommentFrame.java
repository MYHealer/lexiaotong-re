package com.opos.exoplayer.core.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.opos.exoplayer.core.i.y;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class CommentFrame extends Id3Frame {
    public static final Parcelable.Creator<CommentFrame> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6530a;
    public final String b;
    public final String c;

    static class a implements Parcelable.Creator<CommentFrame> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CommentFrame createFromParcel(Parcel parcel) {
            return new CommentFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CommentFrame[] newArray(int i) {
            return new CommentFrame[i];
        }
    }

    CommentFrame(Parcel parcel) {
        super(com.google.android.exoplayer2.metadata.id3.CommentFrame.ID);
        this.f6530a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
    }

    public CommentFrame(String str, String str2, String str3) {
        super(com.google.android.exoplayer2.metadata.id3.CommentFrame.ID);
        this.f6530a = str;
        this.b = str2;
        this.c = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CommentFrame.class != obj.getClass()) {
            return false;
        }
        CommentFrame commentFrame = (CommentFrame) obj;
        return y.a(this.b, commentFrame.b) && y.a(this.f6530a, commentFrame.f6530a) && y.a(this.c, commentFrame.c);
    }

    public int hashCode() {
        String str = this.f6530a;
        int iHashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        String str2 = this.b;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f);
        parcel.writeString(this.f6530a);
        parcel.writeString(this.c);
    }
}
