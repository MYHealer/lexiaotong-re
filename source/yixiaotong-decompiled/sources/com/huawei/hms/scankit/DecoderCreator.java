package com.huawei.hms.scankit;

import android.os.RemoteException;
import com.huawei.hms.hmsscankit.api.IRemoteDecoderCreator;
import com.huawei.hms.hmsscankit.api.IRemoteFrameDecoderDelegate;
import com.huawei.hms.scankit.p.q3;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class DecoderCreator extends IRemoteDecoderCreator.Stub {
    @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderCreator
    public IRemoteFrameDecoderDelegate newRemoteFrameDecoderDelegate() throws RemoteException {
        return q3.a();
    }
}
