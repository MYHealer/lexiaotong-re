package com.byazt.sh;

import android.util.SparseArray;
import com.byazt.hj.u;
import com.byazt.hj.z;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1606, 46})
public class n implements Function<SparseArray<Object>, Object> {
    public final TTAdNative.NativeExpressAdListener c;

    public n(TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        this.c = nativeExpressAdListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.c == null) {
            return null;
        }
        ValueSet valueSetTt = com.byazt.rl.ve.c(sparseArray).tt();
        switch (valueSetTt.intValue(-99999987)) {
            case 153101:
                this.c.onError(valueSetTt.intValue(0), valueSetTt.stringValue(1));
                return null;
            case 153102:
                List arrayList = (List) valueSetTt.objectValue(0, List.class);
                if (arrayList == null) {
                    arrayList = new ArrayList(0);
                }
                ArrayList arrayList2 = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new u(z.c(it.next())));
                }
                this.c.onNativeExpressAdLoad(arrayList2);
                return null;
            default:
                return null;
        }
    }
}
