package com.hihonor.adsdk.base.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class Style implements Parcelable {
    public static final Parcelable.Creator<Style> CREATOR = new a();
    private int borderRadius;
    private int layout;

    class a implements Parcelable.Creator<Style> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
        public Style createFromParcel(Parcel parcel) {
            return new Style(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
        public Style[] newArray(int i) {
            return new Style[i];
        }
    }

    protected Style(Parcel parcel) {
        this.layout = parcel.readInt();
        this.borderRadius = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getBorderRadius() {
        return this.borderRadius;
    }

    public int getLayout() {
        return this.layout;
    }

    public void setBorderRadius(int i) {
        this.borderRadius = i;
    }

    public void setLayout(int i) {
        this.layout = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.layout);
        parcel.writeInt(this.borderRadius);
    }
}
