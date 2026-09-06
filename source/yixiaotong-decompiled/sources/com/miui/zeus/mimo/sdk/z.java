package com.miui.zeus.mimo.sdk;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class z implements Parcelable {
    public static final Parcelable.Creator<z> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5753a;
    public String b;
    public String c;

    public class a implements Parcelable.Creator<z> {
        @Override // android.os.Parcelable.Creator
        public z createFromParcel(Parcel parcel) {
            return new z(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public z[] newArray(int i) {
            return new z[i];
        }
    }

    public z(Parcel parcel) {
        this.f5753a = parcel.readInt();
        this.b = parcel.readString();
        this.c = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f5753a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }
}
