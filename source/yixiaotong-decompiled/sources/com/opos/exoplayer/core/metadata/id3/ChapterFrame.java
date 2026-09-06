package com.opos.exoplayer.core.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.opos.exoplayer.core.i.y;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class ChapterFrame extends Id3Frame {
    public static final Parcelable.Creator<ChapterFrame> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6528a;
    public final int b;
    public final int c;
    public final long d;
    public final long e;
    private final Id3Frame[] g;

    static class a implements Parcelable.Creator<ChapterFrame> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ChapterFrame createFromParcel(Parcel parcel) {
            return new ChapterFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ChapterFrame[] newArray(int i) {
            return new ChapterFrame[i];
        }
    }

    ChapterFrame(Parcel parcel) {
        super(com.google.android.exoplayer2.metadata.id3.ChapterFrame.ID);
        this.f6528a = parcel.readString();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readLong();
        this.e = parcel.readLong();
        int i = parcel.readInt();
        this.g = new Id3Frame[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.g[i2] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }

    public ChapterFrame(String str, int i, int i2, long j, long j2, Id3Frame[] id3FrameArr) {
        super(com.google.android.exoplayer2.metadata.id3.ChapterFrame.ID);
        this.f6528a = str;
        this.b = i;
        this.c = i2;
        this.d = j;
        this.e = j2;
        this.g = id3FrameArr;
    }

    @Override // com.opos.exoplayer.core.metadata.id3.Id3Frame, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ChapterFrame.class != obj.getClass()) {
            return false;
        }
        ChapterFrame chapterFrame = (ChapterFrame) obj;
        return this.b == chapterFrame.b && this.c == chapterFrame.c && this.d == chapterFrame.d && this.e == chapterFrame.e && y.a(this.f6528a, chapterFrame.f6528a) && Arrays.equals(this.g, chapterFrame.g);
    }

    public int hashCode() {
        int i = (((((((this.b + 527) * 31) + this.c) * 31) + ((int) this.d)) * 31) + ((int) this.e)) * 31;
        String str = this.f6528a;
        return i + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6528a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeLong(this.d);
        parcel.writeLong(this.e);
        parcel.writeInt(this.g.length);
        for (Id3Frame id3Frame : this.g) {
            parcel.writeParcelable(id3Frame, 0);
        }
    }
}
