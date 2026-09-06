package com.qq.e.ads;

import com.qq.e.comm.pi.IBiddingLoss;
import com.qq.e.comm.util.AdError;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class NativeAbstractAD<T extends IBiddingLoss> extends AbstractAD<T> implements IBiddingLoss {

    public interface BasicADListener {
        void onNoAD(AdError adError);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.ads.AbstractAD
    public void a(T t) {
    }

    @Override // com.qq.e.comm.pi.IBiddingLoss
    public void sendLossNotification(Map<String, Object> map) {
        this.f8457a.sendLossNotification(map);
    }
}
