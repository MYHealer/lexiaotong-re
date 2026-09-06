package com.yfanads.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.yfanads.android.libs.utils.DeviceUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class FeedCom implements Parcelable {
    public static final Parcelable.Creator<FeedCom> CREATOR = new Parcelable.Creator<FeedCom>() { // from class: com.yfanads.android.model.FeedCom.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FeedCom createFromParcel(Parcel parcel) {
            return new FeedCom(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FeedCom[] newArray(int i) {
            return new FeedCom[i];
        }
    };
    public String adID;
    public String appID;
    public String devID;
    public String reqID;

    public FeedCom(String str, String str2, String str3) {
        this.appID = str;
        this.adID = str2;
        this.devID = TextUtils.isEmpty(DeviceUtils.getCacheOAID()) ? DeviceUtils.getClientId() : DeviceUtils.getCacheOAID();
        this.reqID = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appID);
        parcel.writeString(this.adID);
        parcel.writeString(this.devID);
        parcel.writeString(this.reqID);
    }

    public FeedCom(Parcel parcel) {
        this.appID = parcel.readString();
        this.adID = parcel.readString();
        this.devID = parcel.readString();
        this.reqID = parcel.readString();
    }
}
