package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.common.inter.LoaderSpHandlerInter;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ei implements LoaderSpHandlerInter {
    private static ei Code;
    private static final byte[] I = new byte[0];
    private static ej V;

    private ei(Context context) {
        V = ej.Code(context);
    }

    public static ei Code(Context context) {
        return V(context);
    }

    private static ei V(Context context) {
        ei eiVar;
        synchronized (I) {
            if (Code == null) {
                Code = new ei(context);
            }
            eiVar = Code;
        }
        return eiVar;
    }

    @Override // com.huawei.hms.ads.common.inter.LoaderSpHandlerInter
    public long getKitloaderLastCheckTime() {
        return V.aq();
    }

    @Override // com.huawei.hms.ads.common.inter.LoaderSpHandlerInter
    public int getLoaderEngin2KitUpdate(String str) {
        return V.L(str);
    }

    @Override // com.huawei.hms.ads.common.inter.LoaderSpHandlerInter
    public int getLoaderEngineInterval(String str) {
        return V.a(str);
    }

    @Override // com.huawei.hms.ads.common.inter.LoaderSpHandlerInter
    public boolean getLoaderEngineUpdate(String str) {
        return V.D(str);
    }

    @Override // com.huawei.hms.ads.common.inter.LoaderSpHandlerInter
    public void setKitloaderLastCheckTime(long j) {
        V.Z(j);
    }
}
