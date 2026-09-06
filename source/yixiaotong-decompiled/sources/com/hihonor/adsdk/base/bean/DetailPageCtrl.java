package com.hihonor.adsdk.base.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class DetailPageCtrl implements Parcelable {
    public static final Parcelable.Creator<DetailPageCtrl> CREATOR = new a();
    private int detailType;
    private int downloadType;
    private String partner;
    private String sign;
    private String ts;

    class a implements Parcelable.Creator<DetailPageCtrl> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
        public DetailPageCtrl createFromParcel(Parcel parcel) {
            return new DetailPageCtrl(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
        public DetailPageCtrl[] newArray(int i) {
            return new DetailPageCtrl[i];
        }
    }

    protected DetailPageCtrl(Parcel parcel) {
        this.detailType = parcel.readInt();
        this.downloadType = parcel.readInt();
        this.partner = parcel.readString();
        this.ts = parcel.readString();
        this.sign = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDetailType() {
        return this.detailType;
    }

    public int getDownloadType() {
        return this.downloadType;
    }

    public String getPartner() {
        return this.partner;
    }

    public String getSign() {
        return this.sign;
    }

    public String getTs() {
        return this.ts;
    }

    public void setDetailType(int i) {
        this.detailType = i;
    }

    public void setDownloadType(int i) {
        this.downloadType = i;
    }

    public void setPartner(String str) {
        this.partner = str;
    }

    public void setSign(String str) {
        this.sign = str;
    }

    public void setTs(String str) {
        this.ts = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.detailType);
        parcel.writeInt(this.downloadType);
        parcel.writeString(this.partner);
        parcel.writeString(this.ts);
        parcel.writeString(this.sign);
    }
}
