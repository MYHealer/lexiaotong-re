package com.opos.mobad.model.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class MaterialFileData extends a implements Parcelable {
    public static final Parcelable.Creator<MaterialFileData> CREATOR = new Parcelable.Creator<MaterialFileData>() { // from class: com.opos.mobad.model.data.MaterialFileData.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MaterialFileData createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            MaterialFileData materialFileData = new MaterialFileData();
            materialFileData.a(parcel.readString());
            materialFileData.b(parcel.readString());
            return materialFileData;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MaterialFileData[] newArray(int i) {
            return new MaterialFileData[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f7198a;
    private String b;

    public String a() {
        return this.f7198a;
    }

    public void a(String str) {
        this.f7198a = str;
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "MaterialFileData{url='" + this.f7198a + "', md5='" + this.b + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7198a);
        parcel.writeString(this.b);
    }
}
