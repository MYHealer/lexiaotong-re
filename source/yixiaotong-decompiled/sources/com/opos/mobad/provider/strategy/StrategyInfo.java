package com.opos.mobad.provider.strategy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class StrategyInfo implements Parcelable {
    public static final Parcelable.Creator<StrategyInfo> CREATOR = new Parcelable.Creator<StrategyInfo>() { // from class: com.opos.mobad.provider.strategy.StrategyInfo.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public StrategyInfo createFromParcel(Parcel parcel) {
            return new StrategyInfo(parcel.readLong(), parcel.readBundle());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public StrategyInfo[] newArray(int i) {
            return new StrategyInfo[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f7279a;
    public final Bundle b;

    public StrategyInfo(long j, Bundle bundle) {
        this.f7279a = j;
        this.b = bundle;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f7279a);
        parcel.writeBundle(this.b);
    }
}
