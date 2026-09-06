package com.huawei.hms.mlkit.bcr;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.huawei.hms.ml.common.card.bcr.BcrDetectorFrameParcel;
import com.huawei.hms.ml.common.card.bcr.BcrDetectorOptionsParcel;
import com.huawei.hms.ml.common.card.bcr.BcrDetectorParcel;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class BcrDecoderHelper {
    public static BcrDecoderImpl getInstance() {
        return BcrDecoderImpl.a();
    }

    public int destroy() throws RemoteException {
        return getInstance().destroy();
    }

    public BcrDetectorParcel detect(Bundle bundle, BcrDetectorFrameParcel bcrDetectorFrameParcel, BcrDetectorOptionsParcel bcrDetectorOptionsParcel) throws RemoteException {
        return getInstance().detect(bundle, bcrDetectorFrameParcel, bcrDetectorOptionsParcel);
    }

    public int initial(Context context, BcrDetectorOptionsParcel bcrDetectorOptionsParcel) throws RemoteException {
        return getInstance().initial(context, bcrDetectorOptionsParcel);
    }
}
