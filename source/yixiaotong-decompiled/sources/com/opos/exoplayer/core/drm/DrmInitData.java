package com.opos.exoplayer.core.drm;

import android.os.Parcel;
import android.os.Parcelable;
import com.opos.exoplayer.core.i.y;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class DrmInitData implements Parcelable, Comparator<SchemeData> {
    public static final Parcelable.Creator<DrmInitData> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6381a;
    public final int b;
    private final SchemeData[] c;
    private int d;

    public static final class SchemeData implements Parcelable {
        public static final Parcelable.Creator<SchemeData> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f6382a;
        public final byte[] b;
        public final boolean c;
        private int d;
        private final UUID e;

        static class a implements Parcelable.Creator<SchemeData> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SchemeData createFromParcel(Parcel parcel) {
                return new SchemeData(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SchemeData[] newArray(int i) {
                return new SchemeData[i];
            }
        }

        SchemeData(Parcel parcel) {
            this.e = new UUID(parcel.readLong(), parcel.readLong());
            this.f6382a = parcel.readString();
            this.b = parcel.createByteArray();
            this.c = parcel.readByte() != 0;
        }

        public SchemeData(UUID uuid, String str, byte[] bArr) {
            this(uuid, str, bArr, false);
        }

        public SchemeData(UUID uuid, String str, byte[] bArr, boolean z) {
            this.e = (UUID) com.opos.exoplayer.core.i.a.a(uuid);
            this.f6382a = (String) com.opos.exoplayer.core.i.a.a(str);
            this.b = bArr;
            this.c = z;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof SchemeData)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            SchemeData schemeData = (SchemeData) obj;
            return this.f6382a.equals(schemeData.f6382a) && y.a(this.e, schemeData.e) && Arrays.equals(this.b, schemeData.b);
        }

        public int hashCode() {
            if (this.d == 0) {
                this.d = (((this.e.hashCode() * 31) + this.f6382a.hashCode()) * 31) + Arrays.hashCode(this.b);
            }
            return this.d;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.e.getMostSignificantBits());
            parcel.writeLong(this.e.getLeastSignificantBits());
            parcel.writeString(this.f6382a);
            parcel.writeByteArray(this.b);
            parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
        }
    }

    static class a implements Parcelable.Creator<DrmInitData> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DrmInitData createFromParcel(Parcel parcel) {
            return new DrmInitData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DrmInitData[] newArray(int i) {
            return new DrmInitData[i];
        }
    }

    DrmInitData(Parcel parcel) {
        this.f6381a = parcel.readString();
        SchemeData[] schemeDataArr = (SchemeData[]) parcel.createTypedArray(SchemeData.CREATOR);
        this.c = schemeDataArr;
        this.b = schemeDataArr.length;
    }

    private DrmInitData(String str, boolean z, SchemeData... schemeDataArr) {
        this.f6381a = str;
        schemeDataArr = z ? (SchemeData[]) schemeDataArr.clone() : schemeDataArr;
        Arrays.sort(schemeDataArr, this);
        this.c = schemeDataArr;
        this.b = schemeDataArr.length;
    }

    public DrmInitData(String str, SchemeData... schemeDataArr) {
        this(str, true, schemeDataArr);
    }

    public DrmInitData(List<SchemeData> list) {
        this(null, false, (SchemeData[]) list.toArray(new SchemeData[list.size()]));
    }

    public DrmInitData(SchemeData... schemeDataArr) {
        this(null, schemeDataArr);
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(SchemeData schemeData, SchemeData schemeData2) {
        if (com.opos.exoplayer.core.b.b.equals(schemeData.e)) {
            return com.opos.exoplayer.core.b.b.equals(schemeData2.e) ? 0 : 1;
        }
        return schemeData.e.compareTo(schemeData2.e);
    }

    public SchemeData a(int i) {
        return this.c[i];
    }

    public DrmInitData a(String str) {
        return y.a(this.f6381a, str) ? this : new DrmInitData(str, false, this.c);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DrmInitData.class != obj.getClass()) {
            return false;
        }
        DrmInitData drmInitData = (DrmInitData) obj;
        return y.a(this.f6381a, drmInitData.f6381a) && Arrays.equals(this.c, drmInitData.c);
    }

    public int hashCode() {
        if (this.d == 0) {
            String str = this.f6381a;
            this.d = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.c);
        }
        return this.d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6381a);
        parcel.writeTypedArray(this.c, 0);
    }
}
