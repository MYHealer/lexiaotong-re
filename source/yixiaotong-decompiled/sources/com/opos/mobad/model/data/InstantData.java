package com.opos.mobad.model.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class InstantData extends a implements Parcelable {
    public static final Parcelable.Creator<InstantData> CREATOR = new Parcelable.Creator<InstantData>() { // from class: com.opos.mobad.model.data.InstantData.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public InstantData createFromParcel(Parcel parcel) {
            if (parcel != null) {
                return new InstantData(parcel.readString(), parcel.readString());
            }
            return null;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public InstantData[] newArray(int i) {
            return new InstantData[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f7193a;
    public String b;

    public InstantData(String str, String str2) {
        this.f7193a = str;
        this.b = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7193a);
        parcel.writeString(this.b);
    }
}
