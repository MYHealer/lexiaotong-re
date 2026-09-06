package com.opos.exoplayer.core.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.opos.exoplayer.core.i.y;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class GeobFrame extends Id3Frame {
    public static final Parcelable.Creator<GeobFrame> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6531a;
    public final String b;
    public final String c;
    public final byte[] d;

    static class a implements Parcelable.Creator<GeobFrame> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public GeobFrame createFromParcel(Parcel parcel) {
            return new GeobFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public GeobFrame[] newArray(int i) {
            return new GeobFrame[i];
        }
    }

    GeobFrame(Parcel parcel) {
        super(com.google.android.exoplayer2.metadata.id3.GeobFrame.ID);
        this.f6531a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.createByteArray();
    }

    public GeobFrame(String str, String str2, String str3, byte[] bArr) {
        super(com.google.android.exoplayer2.metadata.id3.GeobFrame.ID);
        this.f6531a = str;
        this.b = str2;
        this.c = str3;
        this.d = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || GeobFrame.class != obj.getClass()) {
            return false;
        }
        GeobFrame geobFrame = (GeobFrame) obj;
        return y.a(this.f6531a, geobFrame.f6531a) && y.a(this.b, geobFrame.b) && y.a(this.c, geobFrame.c) && Arrays.equals(this.d, geobFrame.d);
    }

    public int hashCode() {
        String str = this.f6531a;
        int iHashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        String str2 = this.b;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        return ((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + Arrays.hashCode(this.d);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6531a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeByteArray(this.d);
    }
}
