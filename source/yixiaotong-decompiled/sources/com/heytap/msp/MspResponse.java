package com.heytap.msp;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class MspResponse implements Parcelable {
    public static final Parcelable.Creator<MspResponse> CREATOR = new Parcelable.Creator<MspResponse>() { // from class: com.heytap.msp.MspResponse.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MspResponse createFromParcel(Parcel parcel) {
            return new MspResponse(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MspResponse[] newArray(int i) {
            return new MspResponse[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3395a;
    private String b;
    private Bundle c;

    public MspResponse() {
    }

    protected MspResponse(Parcel parcel) {
        this.f3395a = parcel.readInt();
        this.b = parcel.readString();
        this.c = parcel.readBundle();
    }

    public int a() {
        return this.f3395a;
    }

    public String b() {
        return this.b;
    }

    public Bundle c() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "MspResponse{code='" + this.f3395a + "', message='" + this.b + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f3395a);
        parcel.writeString(this.b);
        parcel.writeBundle(this.c);
    }
}
