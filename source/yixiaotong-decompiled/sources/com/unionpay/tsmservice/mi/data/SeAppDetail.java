package com.unionpay.tsmservice.mi.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.openalliance.ad.constant.x;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class SeAppDetail implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.unionpay.tsmservice.mi.data.SeAppDetail.1
        @Override // android.os.Parcelable.Creator
        public final SeAppDetail createFromParcel(Parcel parcel) {
            return new SeAppDetail(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final SeAppDetail[] newArray(int i) {
            return new SeAppDetail[i];
        }
    };
    private Bundle mDetail;

    public SeAppDetail() {
    }

    public SeAppDetail(Parcel parcel) {
        this.mDetail = parcel.readBundle();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle getDetail() {
        return this.mDetail;
    }

    public void setDetail(Bundle bundle) {
        this.mDetail = bundle;
    }

    public String toString() {
        if (this.mDetail == null) {
            return "AppDetail [mDetail=null]";
        }
        String str = "AppDetail [mDetail=Bundle(";
        for (String str2 : this.mDetail.keySet()) {
            str = str + str2 + x.bQ + this.mDetail.get(str2) + ";";
        }
        return str + ")]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.mDetail);
    }
}
