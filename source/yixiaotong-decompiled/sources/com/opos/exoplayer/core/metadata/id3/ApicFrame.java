package com.opos.exoplayer.core.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.opos.exoplayer.core.i.y;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class ApicFrame extends Id3Frame {
    public static final Parcelable.Creator<ApicFrame> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6526a;
    public final String b;
    public final int c;
    public final byte[] d;

    static class a implements Parcelable.Creator<ApicFrame> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ApicFrame createFromParcel(Parcel parcel) {
            return new ApicFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ApicFrame[] newArray(int i) {
            return new ApicFrame[i];
        }
    }

    ApicFrame(Parcel parcel) {
        super(com.google.android.exoplayer2.metadata.id3.ApicFrame.ID);
        this.f6526a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readInt();
        this.d = parcel.createByteArray();
    }

    public ApicFrame(String str, String str2, int i, byte[] bArr) {
        super(com.google.android.exoplayer2.metadata.id3.ApicFrame.ID);
        this.f6526a = str;
        this.b = str2;
        this.c = i;
        this.d = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ApicFrame.class != obj.getClass()) {
            return false;
        }
        ApicFrame apicFrame = (ApicFrame) obj;
        return this.c == apicFrame.c && y.a(this.f6526a, apicFrame.f6526a) && y.a(this.b, apicFrame.b) && Arrays.equals(this.d, apicFrame.d);
    }

    public int hashCode() {
        int i = (this.c + 527) * 31;
        String str = this.f6526a;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.b;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Arrays.hashCode(this.d);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6526a);
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        parcel.writeByteArray(this.d);
    }
}
