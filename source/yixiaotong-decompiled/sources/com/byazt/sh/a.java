package com.byazt.sh;

import android.util.SparseArray;
import com.byazt.hj.yp;
import com.byazt.hj.z;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1606, 34})
public class a implements Function<SparseArray<Object>, Object> {
    public final TTAdNative.RewardVideoAdListener c;

    public a(TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        this.c = rewardVideoAdListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        ValueSet valueSetTt;
        if (this.c != null && (valueSetTt = com.byazt.rl.ve.c(sparseArray).tt()) != null) {
            switch (valueSetTt.intValue(-99999987)) {
                case 124101:
                    this.c.onError(valueSetTt.intValue(0), valueSetTt.stringValue(1));
                    break;
                case 124102:
                    this.c.onRewardVideoAdLoad(new yp(z.c(valueSetTt.objectValue(0, Object.class))));
                    break;
                case 124103:
                    this.c.onRewardVideoCached(new yp(z.c(valueSetTt.objectValue(0, Object.class))));
                    break;
                case 124104:
                    this.c.onRewardVideoCached();
                    break;
            }
        }
        return null;
    }
}
