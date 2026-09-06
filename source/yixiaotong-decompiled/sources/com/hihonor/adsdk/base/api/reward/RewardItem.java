package com.hihonor.adsdk.base.api.reward;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class RewardItem implements Parcelable {
    public static final Parcelable.Creator<RewardItem> CREATOR = new a();
    private double amount;
    private String type;

    class a implements Parcelable.Creator<RewardItem> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
        public RewardItem createFromParcel(Parcel parcel) {
            return new RewardItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
        public RewardItem[] newArray(int i) {
            return new RewardItem[i];
        }
    }

    public RewardItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public double getAmount() {
        return this.amount;
    }

    public String getType() {
        return this.type;
    }

    public void setAmount(double d) {
        this.amount = d;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.amount);
        parcel.writeString(this.type);
    }

    public RewardItem(double d, String str) {
        this.type = str;
        this.amount = d;
    }

    public RewardItem(Parcel parcel) {
        this.amount = parcel.readDouble();
        this.type = parcel.readString();
    }
}
