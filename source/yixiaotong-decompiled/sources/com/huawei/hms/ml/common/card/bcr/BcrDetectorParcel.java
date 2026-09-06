package com.huawei.hms.ml.common.card.bcr;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.base.common.AbstractSafeParcelable;
import com.huawei.hms.base.common.ParcelReader;
import com.huawei.hms.base.common.ParcelWriter;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class BcrDetectorParcel extends AbstractSafeParcelable {
    public static final Parcelable.Creator<BcrDetectorParcel> CREATOR = new Parcelable.Creator<BcrDetectorParcel>() { // from class: com.huawei.hms.ml.common.card.bcr.BcrDetectorParcel.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BcrDetectorParcel createFromParcel(Parcel parcel) {
            return new BcrDetectorParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BcrDetectorParcel[] newArray(int i) {
            return new BcrDetectorParcel[i];
        }
    };
    public static final int RET_CODE_FAILED = 1;
    public static final int RET_CODE_SUCCESS = 0;
    public BcrDetectorBorderParcel border;
    public String cardExpire;
    public String cardIssuer;
    public String cardNumber;
    public String cardOrganization;
    public String cardOwner;
    public String cardType;
    public Bitmap correct;
    public Bitmap original;
    public int retCode;
    public int tipsCode;

    public BcrDetectorParcel() {
        this.retCode = 1;
    }

    public BcrDetectorParcel(Parcel parcel) {
        ParcelReader parcelReader = new ParcelReader(parcel);
        this.border = (BcrDetectorBorderParcel) parcelReader.readParcelable(2, BcrDetectorBorderParcel.CREATOR, null);
        this.retCode = parcelReader.readInt(3, 1);
        this.cardNumber = parcelReader.createString(4, null);
        this.cardIssuer = parcelReader.createString(5, null);
        this.cardExpire = parcelReader.createString(6, null);
        this.cardOwner = parcelReader.createString(7, null);
        this.original = (Bitmap) parcelReader.readParcelable(8, Bitmap.CREATOR, null);
        this.tipsCode = parcelReader.readInt(9, Integer.MIN_VALUE);
        this.correct = (Bitmap) parcelReader.readParcelable(10, Bitmap.CREATOR, null);
        this.cardOrganization = parcelReader.createString(11, null);
        this.cardType = parcelReader.createString(12, null);
        parcelReader.finish();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelWriter parcelWriter = new ParcelWriter(parcel);
        int iBeginObjectHeader = parcelWriter.beginObjectHeader();
        parcelWriter.writeParcelable(2, this.border, i, false);
        parcelWriter.writeInt(3, this.retCode);
        parcelWriter.writeString(4, this.cardNumber, false);
        parcelWriter.writeString(5, this.cardIssuer, false);
        parcelWriter.writeString(6, this.cardExpire, false);
        parcelWriter.writeString(7, this.cardOwner, false);
        parcelWriter.writeParcelable(8, this.original, i, false);
        parcelWriter.writeInt(9, this.tipsCode);
        parcelWriter.writeParcelable(10, this.correct, i, false);
        parcelWriter.writeString(11, this.cardOrganization, false);
        parcelWriter.writeString(12, this.cardType, false);
        parcelWriter.finishObjectHeader(iBeginObjectHeader);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder sb = new StringBuilder("border=");
        Object obj = this.border;
        if (obj == null) {
            obj = "NULL";
        }
        stringBuffer.append(sb.append(obj).toString());
        stringBuffer.append(", ");
        stringBuffer.append("retCode=" + this.retCode);
        stringBuffer.append(", ");
        StringBuilder sb2 = new StringBuilder("cardNumber=");
        String str = this.cardNumber;
        if (str == null) {
            str = "NULL";
        }
        stringBuffer.append(sb2.append(str).toString());
        stringBuffer.append(", ");
        StringBuilder sb3 = new StringBuilder("cardIssuer=");
        String str2 = this.cardIssuer;
        if (str2 == null) {
            str2 = "NULL";
        }
        stringBuffer.append(sb3.append(str2).toString());
        stringBuffer.append(", ");
        StringBuilder sb4 = new StringBuilder("cardExpire=");
        String str3 = this.cardExpire;
        if (str3 == null) {
            str3 = "NULL";
        }
        stringBuffer.append(sb4.append(str3).toString());
        stringBuffer.append(", ");
        StringBuilder sb5 = new StringBuilder("cardOwner=");
        String str4 = this.cardOwner;
        if (str4 == null) {
            str4 = "NULL";
        }
        stringBuffer.append(sb5.append(str4).toString());
        stringBuffer.append(", ");
        stringBuffer.append("cardOwner=" + (this.cardOrganization == null ? "NULL" : this.cardOwner));
        stringBuffer.append(", ");
        StringBuilder sb6 = new StringBuilder("cardOwner=");
        String str5 = this.cardType;
        if (str5 == null) {
            str5 = "NULL";
        }
        stringBuffer.append(sb6.append(str5).toString());
        stringBuffer.append(", ");
        StringBuilder sb7 = new StringBuilder("original=");
        Bitmap bitmap = this.original;
        stringBuffer.append(sb7.append(bitmap == null ? "NULL" : Integer.valueOf(bitmap.getByteCount())).toString());
        stringBuffer.append(", ");
        stringBuffer.append("tipsCode=" + this.tipsCode);
        stringBuffer.append(", ");
        StringBuilder sb8 = new StringBuilder("correct=");
        Bitmap bitmap2 = this.correct;
        stringBuffer.append(sb8.append(bitmap2 != null ? Integer.valueOf(bitmap2.getByteCount()) : "NULL").toString());
        return stringBuffer.toString();
    }
}
