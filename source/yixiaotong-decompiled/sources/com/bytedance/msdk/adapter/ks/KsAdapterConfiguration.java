package com.bytedance.msdk.adapter.ks;

import android.content.Context;
import android.util.SparseArray;
import com.bytedance.msdk.adapter.ks.base.MediationInitBaseFunction;
import com.bytedance.msdk.adapter.ks.base.config.MediationInitConfig;
import com.bytedance.msdk.adapter.ks.base.utils.MediationValueUtil;
import com.h7brb.h7brb.h7brb.h7brb.h7brb.j;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class KsAdapterConfiguration extends MediationInitBaseFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f3077a = false;
    private volatile j b;

    @Override // com.bytedance.msdk.adapter.ks.base.MediationInitBaseFunction
    public <T> T callFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        if (i == 8101) {
            return BuildConfig.ADAPTER_VERSION;
        }
        if (i == 8104) {
            try {
                return (T) getProxyInitConfigInstance().b();
            } catch (Throwable unused) {
                return "0.0";
            }
        }
        if (i == 8105) {
            return (T) this.mInitConfig.getGromoreVersion();
        }
        if (i == 8124) {
            this.mInitConfig.setMediationCustomControllerValueSet(MediationValueUtil.objectValue(sparseArray.get(8517), Object.class, null));
            if (this.f3077a) {
                getProxyInitConfigInstance().a();
            }
        }
        return null;
    }

    public j getProxyInitConfigInstance() {
        if (this.b == null) {
            synchronized (j.class) {
                if (this.b == null) {
                    this.b = new j();
                }
            }
        }
        return this.b;
    }

    @Override // com.bytedance.msdk.adapter.ks.base.MediationInitBaseFunction
    public void realInitAdn(Context context, MediationInitConfig mediationInitConfig) {
        synchronized (KsAdapterConfiguration.class) {
            if (this.f3077a) {
                notifySuccess();
            } else {
                getProxyInitConfigInstance().a(context, this, mediationInitConfig);
            }
        }
    }

    public void setInitSuccess(boolean z) {
        this.f3077a = z;
    }
}
