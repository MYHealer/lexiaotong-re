package a.b.c.d.e.f.gng;

import android.util.SparseArray;
import com.bytedance.msdk.adapter.gdt.GdtManager;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class GngFunction extends AdnAdapterBaseFunction {
    @Override // com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction
    public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        if (i != 9000) {
            return null;
        }
        return (T) new GdtManager();
    }

    @Override // com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction
    public SparseArray<Object> get() {
        return null;
    }
}
