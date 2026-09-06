package com.unionpay.tsmservice.mi.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class GetTransactionDetailsRequestParams extends RequestParams {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.unionpay.tsmservice.mi.request.GetTransactionDetailsRequestParams.1
        @Override // android.os.Parcelable.Creator
        public final GetTransactionDetailsRequestParams createFromParcel(Parcel parcel) {
            return new GetTransactionDetailsRequestParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final GetTransactionDetailsRequestParams[] newArray(int i) {
            return new GetTransactionDetailsRequestParams[i];
        }
    };
    private Bundle mParams;

    public GetTransactionDetailsRequestParams() {
    }

    public GetTransactionDetailsRequestParams(Parcel parcel) {
        super(parcel);
        this.mParams = parcel.readBundle();
    }

    @Override // com.unionpay.tsmservice.mi.request.RequestParams, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle getParams() {
        return this.mParams;
    }

    public void setParams(Bundle bundle) {
        this.mParams = bundle;
    }

    @Override // com.unionpay.tsmservice.mi.request.RequestParams, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeBundle(this.mParams);
    }
}
