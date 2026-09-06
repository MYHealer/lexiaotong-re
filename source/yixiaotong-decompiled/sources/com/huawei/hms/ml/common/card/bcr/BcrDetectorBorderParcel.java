package com.huawei.hms.ml.common.card.bcr;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.base.common.AbstractSafeParcelable;
import com.huawei.hms.base.common.ParcelReader;
import com.huawei.hms.base.common.ParcelWriter;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class BcrDetectorBorderParcel extends AbstractSafeParcelable {
    public static final Parcelable.Creator<BcrDetectorBorderParcel> CREATOR = new Parcelable.Creator<BcrDetectorBorderParcel>() { // from class: com.huawei.hms.ml.common.card.bcr.BcrDetectorBorderParcel.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BcrDetectorBorderParcel createFromParcel(Parcel parcel) {
            return new BcrDetectorBorderParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BcrDetectorBorderParcel[] newArray(int i) {
            return new BcrDetectorBorderParcel[i];
        }
    };
    public BcrDetectorBorderPointParcel cardExpire;
    public BcrDetectorBorderPointParcel cardIssuer;
    public BcrDetectorBorderPointParcel cardNumber;
    public BcrDetectorBorderPointParcel cardOwner;

    public BcrDetectorBorderParcel() {
    }

    public BcrDetectorBorderParcel(Parcel parcel) {
        ParcelReader parcelReader = new ParcelReader(parcel);
        this.cardNumber = (BcrDetectorBorderPointParcel) parcelReader.readParcelable(2, BcrDetectorBorderPointParcel.CREATOR, null);
        this.cardIssuer = (BcrDetectorBorderPointParcel) parcelReader.readParcelable(3, BcrDetectorBorderPointParcel.CREATOR, null);
        this.cardExpire = (BcrDetectorBorderPointParcel) parcelReader.readParcelable(4, BcrDetectorBorderPointParcel.CREATOR, null);
        this.cardOwner = (BcrDetectorBorderPointParcel) parcelReader.readParcelable(5, BcrDetectorBorderPointParcel.CREATOR, null);
        parcelReader.finish();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelWriter parcelWriter = new ParcelWriter(parcel);
        int iBeginObjectHeader = parcelWriter.beginObjectHeader();
        parcelWriter.writeParcelable(2, this.cardNumber, i, false);
        parcelWriter.writeParcelable(3, this.cardIssuer, i, false);
        parcelWriter.writeParcelable(4, this.cardExpire, i, false);
        parcelWriter.writeParcelable(5, this.cardOwner, i, false);
        parcelWriter.finishObjectHeader(iBeginObjectHeader);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder sb = new StringBuilder("number=");
        Object obj = this.cardNumber;
        if (obj == null) {
            obj = "NULL";
        }
        stringBuffer.append(sb.append(obj).toString());
        stringBuffer.append(", ");
        StringBuilder sb2 = new StringBuilder("issuer=");
        Object obj2 = this.cardIssuer;
        if (obj2 == null) {
            obj2 = "NULL";
        }
        stringBuffer.append(sb2.append(obj2).toString());
        stringBuffer.append(", ");
        StringBuilder sb3 = new StringBuilder("expire=");
        Object obj3 = this.cardExpire;
        if (obj3 == null) {
            obj3 = "NULL";
        }
        stringBuffer.append(sb3.append(obj3).toString());
        stringBuffer.append(", ");
        StringBuilder sb4 = new StringBuilder("owner=");
        BcrDetectorBorderPointParcel bcrDetectorBorderPointParcel = this.cardOwner;
        stringBuffer.append(sb4.append(bcrDetectorBorderPointParcel != null ? bcrDetectorBorderPointParcel : "NULL").toString());
        return stringBuffer.toString();
    }
}
