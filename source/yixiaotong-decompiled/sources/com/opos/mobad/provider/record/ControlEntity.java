package com.opos.mobad.provider.record;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class ControlEntity implements Parcelable {
    public static final Parcelable.Creator<ControlEntity> CREATOR = new Parcelable.Creator<ControlEntity>() { // from class: com.opos.mobad.provider.record.ControlEntity.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ControlEntity createFromParcel(Parcel parcel) {
            boolean z = parcel.readInt() == 1;
            boolean z2 = parcel.readInt() == 1;
            boolean z3 = parcel.readInt() == 1;
            long j = parcel.readLong();
            return new ControlEntity(z, z2, z3, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, j, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ControlEntity[] newArray(int i) {
            return new ControlEntity[0];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f7272a;
    public final boolean b;
    public final boolean c;
    public final long d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final boolean m;

    public ControlEntity(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, long j, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12) {
        this.f7272a = z;
        this.b = z2;
        this.c = z3;
        this.d = j;
        this.e = z4;
        this.f = z5;
        this.i = z7;
        this.g = z6;
        this.h = z8;
        this.j = z9;
        this.k = z10;
        this.l = z11;
        this.m = z12;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f7272a ? 1 : 0);
        parcel.writeInt(this.b ? 1 : 0);
        parcel.writeInt(this.c ? 1 : 0);
        parcel.writeLong(this.d);
        parcel.writeInt(this.e ? 1 : 0);
        parcel.writeInt(this.f ? 1 : 0);
        parcel.writeInt(this.i ? 1 : 0);
        parcel.writeInt(this.g ? 1 : 0);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeInt(this.j ? 1 : 0);
        parcel.writeInt(this.k ? 1 : 0);
        parcel.writeInt(this.l ? 1 : 0);
        parcel.writeInt(this.m ? 1 : 0);
    }
}
