package com.huawei.hms.ml.common.card.bcr;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.base.common.ParcelReader;
import com.huawei.hms.base.common.ParcelWriter;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class BcrDetectorOptionsParcel implements Parcelable {
    public static final Parcelable.Creator<BcrDetectorOptionsParcel> CREATOR = new Parcelable.Creator<BcrDetectorOptionsParcel>() { // from class: com.huawei.hms.ml.common.card.bcr.BcrDetectorOptionsParcel.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BcrDetectorOptionsParcel createFromParcel(Parcel parcel) {
            return new BcrDetectorOptionsParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BcrDetectorOptionsParcel[] newArray(int i) {
            return new BcrDetectorOptionsParcel[i];
        }
    };
    public final Bundle bundle;
    public final String language;
    public int recMode;
    public int recType;
    public int resultType;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BcrDetectorOptionsParcel(String str, Bundle bundle, int i, int i2, int i3) {
        this.language = str;
        this.bundle = bundle;
        this.recType = i;
        this.recMode = i2;
        this.resultType = i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelWriter parcelWriter = new ParcelWriter(parcel);
        int iBeginObjectHeader = parcelWriter.beginObjectHeader();
        parcelWriter.writeString(2, this.language, false);
        parcelWriter.writeBundle(3, this.bundle, true);
        parcelWriter.writeInt(4, this.recType);
        parcelWriter.writeInt(5, this.recMode);
        parcelWriter.writeInt(6, this.resultType);
        parcelWriter.finishObjectHeader(iBeginObjectHeader);
    }

    protected BcrDetectorOptionsParcel(Parcel parcel) {
        ParcelReader parcelReader = new ParcelReader(parcel);
        this.language = parcelReader.createString(2, null);
        this.bundle = parcelReader.readBundle(3, null);
        this.recType = parcelReader.readInt(4, 0);
        this.recMode = parcelReader.readInt(5, 1);
        this.resultType = parcelReader.readInt(6, 1);
        parcelReader.finish();
    }
}
