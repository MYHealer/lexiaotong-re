package com.unionpay.tsmservice.mi.request;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class EncryptDataRequestParams extends RequestParams {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.unionpay.tsmservice.mi.request.EncryptDataRequestParams.1
        @Override // android.os.Parcelable.Creator
        public final EncryptDataRequestParams createFromParcel(Parcel parcel) {
            return new EncryptDataRequestParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final EncryptDataRequestParams[] newArray(int i) {
            return new EncryptDataRequestParams[i];
        }
    };
    private List mData;

    public EncryptDataRequestParams() {
    }

    public EncryptDataRequestParams(Parcel parcel) {
        super(parcel);
        ArrayList arrayList = new ArrayList();
        this.mData = arrayList;
        parcel.readList(arrayList, ClassLoader.getSystemClassLoader());
    }

    public List getData() {
        return this.mData;
    }

    public void setData(List list) {
        this.mData = list;
    }

    @Override // com.unionpay.tsmservice.mi.request.RequestParams, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeList(this.mData);
    }
}
