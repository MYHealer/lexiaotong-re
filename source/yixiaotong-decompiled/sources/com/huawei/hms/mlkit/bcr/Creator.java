package com.huawei.hms.mlkit.bcr;

import android.os.RemoteException;
import com.huawei.hms.ml.common.card.bcr.IRemoteBcrCreator;
import com.huawei.hms.ml.common.card.bcr.IRemoteBcrDecoderDelegate;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class Creator extends IRemoteBcrCreator.Stub {
    @Override // com.huawei.hms.ml.common.card.bcr.IRemoteBcrCreator
    public IRemoteBcrDecoderDelegate newRemoteBcrDecoderDelegate() throws RemoteException {
        return BcrDecoderImpl.a();
    }
}
