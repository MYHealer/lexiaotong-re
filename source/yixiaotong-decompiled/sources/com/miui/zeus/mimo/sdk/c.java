package com.miui.zeus.mimo.sdk;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.util.Log;
import com.google.common.base.Ascii;
import com.miui.systemAdSolution.landingPageV2.listener.IDeeplinkListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c extends a<IDeeplinkListener> {
    public String e;
    public String f;

    public c(Parcel parcel) {
        super(parcel);
        try {
            String string = parcel.readString();
            String string2 = parcel.readString();
            this.e = string;
            this.f = string2;
        } catch (Exception e) {
            Log.e(ijiami_1011.s.s.s.d(new byte[]{37, 6, 4, 70, 95, 80, 15, 15, 39, 1, 69, 12, 14, 13}, "aca639"), ijiami_1011.s.s.s.d(new byte[]{115, 87, 4, 68, 8, 95, 15, 15, 39, 1, 69, 12, 88, 92, 65, 68, 5, 68, Ascii.DC2, 1, 70, Ascii.DC2, 80, Ascii.ETB, 84, 87, 13, Ascii.DC4, 1, Ascii.SYN, 91, 68}, "72a4d6"), e);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.a
    public int a() {
        return 1;
    }

    @Override // com.miui.zeus.mimo.sdk.a
    public IInterface a(IBinder iBinder) {
        return IDeeplinkListener.Stub.asInterface(iBinder);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.miui.zeus.mimo.sdk.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
    }
}
