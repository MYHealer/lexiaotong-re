package com.jd.ad.sdk.jad_te;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.ParcelFileDescriptor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_re implements com.jd.ad.sdk.jad_ju.jad_ly<ParcelFileDescriptor, Bitmap> {
    public final jad_jw jad_an;

    public jad_re(jad_jw jad_jwVar) {
        this.jad_an = jad_jwVar;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public com.jd.ad.sdk.jad_mx.jad_xk<Bitmap> jad_an(ParcelFileDescriptor parcelFileDescriptor, int i, int i2, com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        jad_jw jad_jwVar2 = this.jad_an;
        return jad_jwVar2.jad_an(new jad_ob.jad_cp(parcelFileDescriptor, jad_jwVar2.jad_dq, jad_jwVar2.jad_cp), i, i2, jad_jwVar, jad_jw.jad_kx);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public boolean jad_an(ParcelFileDescriptor parcelFileDescriptor, com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        ParcelFileDescriptor parcelFileDescriptor2 = parcelFileDescriptor;
        String str = Build.MANUFACTURER;
        if ((!"HUAWEI".equalsIgnoreCase(str) && !"HONOR".equalsIgnoreCase(str)) || parcelFileDescriptor2.getStatSize() <= 536870912) {
            this.jad_an.getClass();
            if (com.jd.ad.sdk.jad_kv.jad_mz.jad_cp()) {
                return true;
            }
        }
        return false;
    }
}
