package com.unionpay.tsmservice.mi.request;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class InitRequestParams extends RequestParams {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.unionpay.tsmservice.mi.request.InitRequestParams.1
        @Override // android.os.Parcelable.Creator
        public final InitRequestParams createFromParcel(Parcel parcel) {
            return new InitRequestParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final InitRequestParams[] newArray(int i) {
            return new InitRequestParams[i];
        }
    };
    private String mSignature;

    public InitRequestParams() {
        this.mSignature = "";
    }

    public InitRequestParams(Parcel parcel) {
        super(parcel);
        this.mSignature = "";
        this.mSignature = parcel.readString();
    }

    public String getSignature() {
        return this.mSignature;
    }

    public void setSignature(String str) {
        this.mSignature = str;
    }

    @Override // com.unionpay.tsmservice.mi.request.RequestParams, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mSignature);
    }
}
