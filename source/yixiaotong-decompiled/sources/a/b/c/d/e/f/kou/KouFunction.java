package a.b.c.d.e.f.kou;

import android.util.SparseArray;
import com.bytedance.msdk.adapter.ks.KsManager;
import com.bytedance.msdk.adapter.ks.base.proto.AdnAdapterBaseFunction;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class KouFunction extends AdnAdapterBaseFunction {
    @Override // com.bytedance.msdk.adapter.ks.base.proto.AdnAdapterBaseFunction
    public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        if (i != 9000) {
            return null;
        }
        return (T) new KsManager();
    }

    @Override // com.bytedance.msdk.adapter.ks.base.proto.AdnAdapterBaseFunction
    public SparseArray<Object> get() {
        return null;
    }
}
