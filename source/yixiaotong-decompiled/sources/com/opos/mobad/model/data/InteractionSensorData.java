package com.opos.mobad.model.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class InteractionSensorData extends a implements Parcelable {
    public static final Parcelable.Creator<InteractionSensorData> CREATOR = new Parcelable.Creator<InteractionSensorData>() { // from class: com.opos.mobad.model.data.InteractionSensorData.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public InteractionSensorData createFromParcel(Parcel parcel) {
            if (parcel != null) {
                return new InteractionSensorData(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readByte() != 0, parcel.readInt(), parcel.readInt());
            }
            return null;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public InteractionSensorData[] newArray(int i) {
            return new InteractionSensorData[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7194a;
    private int b;
    private int c;
    private int d;
    private boolean e;
    private int f;
    private int g;

    public InteractionSensorData(int i, int i2, int i3, int i4, boolean z, int i5, int i6) {
        this.f7194a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = z;
        this.f = i5;
        this.g = i6;
    }

    public int a() {
        return this.f7194a;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean e() {
        return this.e;
    }

    public int f() {
        return this.f;
    }

    public int g() {
        return this.g;
    }

    public String toString() {
        return "InteractionSensorData{shakeSensorTime=" + this.f7194a + ", shakeSensorDiff=" + this.b + ", tiltAngle=" + this.c + ", tiltTime=" + this.d + ", isBidirectionalTilt=" + this.e + ", forwardAngle=" + this.f + ", forwardTime=" + this.g + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f7194a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeByte(this.e ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
    }
}
