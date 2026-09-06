package com.unionpay.tsmservice.mi.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class MessageDetail implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.unionpay.tsmservice.mi.data.MessageDetail.1
        @Override // android.os.Parcelable.Creator
        public final MessageDetail createFromParcel(Parcel parcel) {
            return new MessageDetail(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final MessageDetail[] newArray(int i) {
            return new MessageDetail[i];
        }
    };
    private Bundle mDetail;

    public MessageDetail() {
    }

    public MessageDetail(Parcel parcel) {
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

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.mDetail);
    }
}
