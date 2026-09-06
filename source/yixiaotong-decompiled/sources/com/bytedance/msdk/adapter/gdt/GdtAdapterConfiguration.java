package com.bytedance.msdk.adapter.gdt;

import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.msdk.adapter.gdt.base.MediationInitBaseFunction;
import com.bytedance.msdk.adapter.gdt.base.config.MediationInitConfig;
import com.bytedance.msdk.adapter.gdt.base.utils.MediationValueUtil;
import com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.i;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class GdtAdapterConfiguration extends MediationInitBaseFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f3056a = false;
    private MediationInitConfig b;
    private volatile i c;

    @Override // com.bytedance.msdk.adapter.gdt.base.MediationInitBaseFunction
    public <T> T callFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        if (i == 8101) {
            return BuildConfig.ADAPTER_VERSION;
        }
        if (i == 8103) {
            return (T) getProxyInitConfigInstance().a((Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null));
        }
        if (i == 8104) {
            try {
                return (T) getProxyInitConfigInstance().b();
            } catch (Throwable unused) {
                return "0.0";
            }
        }
        if (i == 8105) {
            return (T) this.b.getGromoreVersion();
        }
        if (i == 8124) {
            this.b.setMediationCustomControllerValueSet(MediationValueUtil.objectValue(sparseArray.get(8517), Object.class, null));
            try {
                getProxyInitConfigInstance().a(this.b);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else if (i == 8126) {
            return (T) Integer.valueOf(getProxyInitConfigInstance().a());
        }
        return (T) MediationValueUtil.checkClassType(cls);
    }

    public i getProxyInitConfigInstance() {
        if (this.c == null) {
            synchronized (i.class) {
                if (this.c == null) {
                    this.c = new i();
                }
            }
        }
        return this.c;
    }

    @Override // com.bytedance.msdk.adapter.gdt.base.MediationInitBaseFunction
    public void realInitAdn(Context context, MediationInitConfig mediationInitConfig) {
        this.b = mediationInitConfig;
        synchronized (GdtAdapterConfiguration.class) {
            if (this.f3056a) {
                notifySuccess();
            } else {
                getProxyInitConfigInstance().a(context, this, mediationInitConfig);
            }
        }
    }

    public void setInitSuccess(boolean z) {
        this.f3056a = z;
    }
}
