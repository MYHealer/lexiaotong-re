package com.miui.zeus.mimo.sdk;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.util.Log;
import com.google.common.base.Ascii;
import com.miui.systemAdSolution.landingPageV2.listener.IH5Listener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class e extends a<IH5Listener> {
    public String e;

    public e(Parcel parcel) {
        super(parcel);
        try {
            this.e = parcel.readString();
        } catch (Exception e) {
            Log.e(ijiami_1011.s.s.s.d(new byte[]{43, 80, 32, 81, 71, 91, 14, 10}, "cea232"), ijiami_1011.s.s.s.d(new byte[]{126, 80, 116, 86, 69, 89, 14, 10, 70, Ascii.DC2, 80, Ascii.ETB, 69, 0, Ascii.NAK, 69, 80, 66, 2, 1, 10, 66, 84, 69, 12, 69}, "6e5510"), e);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.a
    public int a() {
        return 2;
    }

    @Override // com.miui.zeus.mimo.sdk.a
    public IInterface a(IBinder iBinder) {
        return IH5Listener.Stub.asInterface(iBinder);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.miui.zeus.mimo.sdk.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.e);
    }
}
