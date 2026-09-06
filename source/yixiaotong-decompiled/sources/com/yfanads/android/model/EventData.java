package com.yfanads.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.yfanads.android.libs.thirdpart.gson.annotations.SerializedName;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class EventData implements Parcelable {
    public static final Parcelable.Creator<EventData> CREATOR = new Parcelable.Creator<EventData>() { // from class: com.yfanads.android.model.EventData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EventData createFromParcel(Parcel parcel) {
            return new EventData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EventData[] newArray(int i) {
            return new EventData[i];
        }
    };

    @SerializedName("aType")
    public int aType;

    @SerializedName("abID")
    public String abId;

    @SerializedName("adID")
    public String adId;

    @SerializedName("adnAdID")
    public String adnAdId;

    @SerializedName("adnAppID")
    public String adnAppId;

    @SerializedName("adnID")
    public int adnId;

    @SerializedName("cd")
    public String cd;

    @SerializedName("eID")
    public String eId;

    @SerializedName("eType")
    public int eType;

    @SerializedName("ecpm")
    public long ecpm;
    public String extData;

    @SerializedName("gID")
    public String gId;
    public int id;

    @SerializedName("isBid")
    public int isBid;

    @SerializedName("lID")
    public String lId;

    @SerializedName("msg")
    public String msg;

    @SerializedName("od")
    public Map<Integer, Permission> od;

    @SerializedName("rID")
    public String rId;

    @SerializedName("sID")
    public String sId;

    @SerializedName("sdkVer")
    public String sdkVer;

    @SerializedName("t")
    public long t;

    @SerializedName("tCost")
    public int tCost;

    public EventData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "{eType=" + this.eType + (!TextUtils.isEmpty(this.cd) ? ", cd=" + this.cd : "") + (TextUtils.isEmpty(this.adId) ? "" : ", adId=" + this.adId) + ", adnID=" + this.adnId + ", ecpm=" + this.ecpm + ", eID=" + this.eId + ", rId=" + this.rId + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.eId);
        parcel.writeInt(this.eType);
        parcel.writeLong(this.t);
        parcel.writeInt(this.tCost);
        parcel.writeInt(this.aType);
        parcel.writeString(this.adId);
        parcel.writeString(this.lId);
        parcel.writeString(this.sId);
        parcel.writeString(this.abId);
        parcel.writeString(this.gId);
        parcel.writeInt(this.adnId);
        parcel.writeString(this.adnAdId);
        parcel.writeString(this.adnAppId);
        parcel.writeInt(this.isBid);
        parcel.writeLong(this.ecpm);
        parcel.writeString(this.cd);
        parcel.writeString(this.sdkVer);
        parcel.writeString(this.msg);
    }

    public EventData(Parcel parcel) {
        this.id = parcel.readInt();
        this.eId = parcel.readString();
        this.eType = parcel.readInt();
        this.t = parcel.readLong();
        this.tCost = parcel.readInt();
        this.aType = parcel.readInt();
        this.adId = parcel.readString();
        this.lId = parcel.readString();
        this.sId = parcel.readString();
        this.abId = parcel.readString();
        this.gId = parcel.readString();
        this.adnId = parcel.readInt();
        this.adnAdId = parcel.readString();
        this.adnAppId = parcel.readString();
        this.isBid = parcel.readInt();
        this.ecpm = parcel.readLong();
        this.cd = parcel.readString();
        this.sdkVer = parcel.readString();
        this.msg = parcel.readString();
    }
}
