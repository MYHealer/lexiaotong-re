package com.miui.zeus.mimo.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class s8 implements Parcelable {
    public static final Parcelable.Creator<s8> CREATOR = new a();
    public boolean k;
    public boolean r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f5598a = null;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public int f = 0;
    public boolean g = false;
    public int h = 255;
    public int i = -1;
    public int j = -1;
    public int l = 0;
    public int m = 0;
    public int n = 0;
    public int o = 0;
    public int p = 0;
    public int q = android.R.color.black;

    public class a implements Parcelable.Creator<s8> {
        @Override // android.os.Parcelable.Creator
        public s8 createFromParcel(Parcel parcel) {
            s8 s8Var = new s8();
            s8Var.h = parcel.readInt();
            s8Var.i = parcel.readInt();
            s8Var.j = parcel.readInt();
            s8Var.q = parcel.readInt();
            s8Var.l = parcel.readInt();
            s8Var.n = parcel.readInt();
            s8Var.m = parcel.readInt();
            s8Var.o = parcel.readInt();
            s8Var.b = parcel.readInt();
            s8Var.c = parcel.readInt();
            s8Var.d = parcel.readInt();
            s8Var.e = parcel.readInt();
            s8Var.f = parcel.readInt();
            s8Var.p = parcel.readInt();
            s8Var.r = parcel.readByte() == 1;
            s8Var.k = parcel.readByte() == 1;
            s8Var.g = parcel.readByte() == 1;
            return s8Var;
        }

        @Override // android.os.Parcelable.Creator
        public s8[] newArray(int i) {
            return new s8[i];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
        parcel.writeInt(this.j);
        parcel.writeInt(this.q);
        parcel.writeInt(this.l);
        parcel.writeInt(this.n);
        parcel.writeInt(this.m);
        parcel.writeInt(this.o);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        parcel.writeInt(this.p);
        parcel.writeByte(this.r ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.k ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.g ? (byte) 1 : (byte) 0);
    }
}
