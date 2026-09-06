package com.byazt.op;

import android.util.SparseArray;
import com.byazt.rl.ve;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.google.android.exoplayer2.audio.AacUtil;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1062, 20})
public abstract class c implements Function<SparseArray<Object>, Object>, IntSupplier {
    public abstract <T> T applyFunction(int i, ValueSet valueSet, Class<T> cls);

    public abstract SparseArray<Object> get();

    @Override // java.util.function.IntSupplier
    public int getAsInt() {
        return AacUtil.AAC_HE_V2_MAX_RATE_BYTES_PER_SECOND;
    }

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        ValueSet valueSetTt = ve.c(sparseArray).tt();
        int iIntValue = valueSetTt.intValue(-99999987, 0);
        Class cls = (Class) valueSetTt.objectValue(-99999985, Class.class);
        if (iIntValue == -99999986) {
            return get();
        }
        return applyFunction(iIntValue, valueSetTt, cls);
    }

    public static <T> T objectValue(Object obj, Class<T> cls, T t) {
        if (obj instanceof ValueSet.ValueGetter) {
            obj = (T) ((ValueSet.ValueGetter) obj).get();
        } else if ((obj instanceof Supplier) && !(obj instanceof Function) && !(obj instanceof ValueSet)) {
            obj = (T) ((Supplier) obj).get();
        }
        return cls.isInstance(obj) ? (T) obj : t;
    }
}
