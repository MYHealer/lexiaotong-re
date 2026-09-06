package com.yfanads.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.yfanads.android.libs.thirdpart.gson.annotations.SerializedName;
import com.yfanads.android.utils.YFAdsConst;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class Permission implements Parcelable {
    public static final Parcelable.Creator<Permission> CREATOR = new Parcelable.Creator<Permission>() { // from class: com.yfanads.android.model.Permission.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Permission createFromParcel(Parcel parcel) {
            return new Permission(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Permission[] newArray(int i) {
            return new Permission[i];
        }
    };

    @SerializedName(YFAdsConst.CAR)
    public int car;

    @SerializedName(YFAdsConst.CUA)
    public int cua;

    @SerializedName(YFAdsConst.CUAID)
    public int cuaid;

    @SerializedName(YFAdsConst.CUL)
    public int cul;

    @SerializedName(YFAdsConst.CUO)
    public int cuo;

    @SerializedName(YFAdsConst.CUP)
    public int cup;

    @SerializedName(YFAdsConst.CUW)
    public int cuw;

    @SerializedName(YFAdsConst.CWE)
    public int cwe;

    @SerializedName(YFAdsConst.LP)
    public int lp;

    public Permission() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.cwe);
        parcel.writeInt(this.cua);
        parcel.writeInt(this.cuaid);
        parcel.writeInt(this.cul);
        parcel.writeInt(this.cuo);
        parcel.writeInt(this.cup);
        parcel.writeInt(this.cuw);
        parcel.writeInt(this.car);
        parcel.writeInt(this.lp);
    }

    public Permission(Parcel parcel) {
        this.cwe = parcel.readInt();
        this.cua = parcel.readInt();
        this.cuaid = parcel.readInt();
        this.cul = parcel.readInt();
        this.cuo = parcel.readInt();
        this.cup = parcel.readInt();
        this.cuw = parcel.readInt();
        this.car = parcel.readInt();
        this.lp = parcel.readInt();
    }
}
