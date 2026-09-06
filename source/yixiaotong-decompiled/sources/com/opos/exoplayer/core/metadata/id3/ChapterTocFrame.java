package com.opos.exoplayer.core.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.opos.exoplayer.core.i.y;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class ChapterTocFrame extends Id3Frame {
    public static final Parcelable.Creator<ChapterTocFrame> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6529a;
    public final boolean b;
    public final boolean c;
    public final String[] d;
    private final Id3Frame[] e;

    static class a implements Parcelable.Creator<ChapterTocFrame> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ChapterTocFrame createFromParcel(Parcel parcel) {
            return new ChapterTocFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ChapterTocFrame[] newArray(int i) {
            return new ChapterTocFrame[i];
        }
    }

    ChapterTocFrame(Parcel parcel) {
        super(com.google.android.exoplayer2.metadata.id3.ChapterTocFrame.ID);
        this.f6529a = parcel.readString();
        this.b = parcel.readByte() != 0;
        this.c = parcel.readByte() != 0;
        this.d = parcel.createStringArray();
        int i = parcel.readInt();
        this.e = new Id3Frame[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.e[i2] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }

    public ChapterTocFrame(String str, boolean z, boolean z2, String[] strArr, Id3Frame[] id3FrameArr) {
        super(com.google.android.exoplayer2.metadata.id3.ChapterTocFrame.ID);
        this.f6529a = str;
        this.b = z;
        this.c = z2;
        this.d = strArr;
        this.e = id3FrameArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ChapterTocFrame.class != obj.getClass()) {
            return false;
        }
        ChapterTocFrame chapterTocFrame = (ChapterTocFrame) obj;
        return this.b == chapterTocFrame.b && this.c == chapterTocFrame.c && y.a(this.f6529a, chapterTocFrame.f6529a) && Arrays.equals(this.d, chapterTocFrame.d) && Arrays.equals(this.e, chapterTocFrame.e);
    }

    public int hashCode() {
        int i = ((((this.b ? 1 : 0) + 527) * 31) + (this.c ? 1 : 0)) * 31;
        String str = this.f6529a;
        return i + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6529a);
        parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
        parcel.writeStringArray(this.d);
        parcel.writeInt(this.e.length);
        for (Id3Frame id3Frame : this.e) {
            parcel.writeParcelable(id3Frame, 0);
        }
    }
}
