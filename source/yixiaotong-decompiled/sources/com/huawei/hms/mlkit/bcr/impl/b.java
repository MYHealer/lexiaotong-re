package com.huawei.hms.mlkit.bcr.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.RemoteException;
import com.huawei.hms.ml.common.card.bcr.BcrDetectorOptionsParcel;
import com.huawei.hms.ml.common.utils.SmartLog;

/* JADX INFO: compiled from: BcrDetector.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BcrEngineDelegate f4147a = null;

    public void a(Context context) throws RemoteException {
        BcrEngineDelegate bcrEngineDelegate = new BcrEngineDelegate();
        this.f4147a = bcrEngineDelegate;
        if (!bcrEngineDelegate.a(context)) {
            throw new RemoteException("Load so failed.");
        }
    }

    public a a(Bitmap bitmap, BcrDetectorOptionsParcel bcrDetectorOptionsParcel) {
        if (bitmap != null && bcrDetectorOptionsParcel != null) {
            String str = bcrDetectorOptionsParcel.language;
            int iA = str != null ? c.a(str) : 1;
            SmartLog.i("BcrDetector", "resultType: " + bcrDetectorOptionsParcel.resultType);
            return this.f4147a.a(bitmap, iA, bcrDetectorOptionsParcel.recType, bcrDetectorOptionsParcel.recMode, bcrDetectorOptionsParcel.resultType);
        }
        return new a();
    }

    public boolean a() throws RemoteException {
        if (this.f4147a.a() == 0) {
            return true;
        }
        throw new RemoteException("Unload bcr Model failed.");
    }
}
