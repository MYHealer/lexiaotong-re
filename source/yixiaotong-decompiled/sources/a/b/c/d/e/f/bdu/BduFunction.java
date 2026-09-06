package a.b.c.d.e.f.bdu;

import android.util.SparseArray;
import com.bytedance.msdk.adapter.baidu.BaiduManager;
import com.bytedance.msdk.adapter.baidu.base.proto.AdnAdapterBaseFunction;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class BduFunction extends AdnAdapterBaseFunction {
    @Override // com.bytedance.msdk.adapter.baidu.base.proto.AdnAdapterBaseFunction
    public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        if (i != 9000) {
            return null;
        }
        return (T) new BaiduManager();
    }

    @Override // com.bytedance.msdk.adapter.baidu.base.proto.AdnAdapterBaseFunction
    public SparseArray<Object> get() {
        return null;
    }
}
