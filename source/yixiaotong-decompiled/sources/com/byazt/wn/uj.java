package com.byazt.wn;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 58, 15})
public class uj extends tt {
    public uj(String str, com.byazt.db.tt ttVar) {
        super(str, ttVar);
    }

    public void callLoadSucceed(List<Function<SparseArray<Object>, Object>> list) {
        if (list != null) {
            if (!hasNotifySuccess()) {
                ArrayList arrayList = new ArrayList(list.size());
                Iterator<Function<SparseArray<Object>, Object>> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new com.byazt.uj.n(this, it.next()));
                }
                notifyLoadSuccess(arrayList);
                return;
            }
            com.byazt.eu.tt.uj("TTMediationSDK", "自定义Adapter 加载成功或者失败回调只能调用一次");
            return;
        }
        callLoadFail(new com.byazt.zm.c(49010, "list is null"));
    }

    public void callLoadFail(com.byazt.zm.c cVar) {
        if (!hasNotifyFail()) {
            notifyLoadFail(new com.byazt.pp.c(49010, com.byazt.pp.c.c(49010), cVar == null ? -1 : cVar.c(), cVar == null ? "" : cVar.tt()));
        } else {
            com.byazt.eu.tt.uj("TTMediationSDK", "自定义Adapter 加载成功或者失败回调只能调用一次");
        }
    }

    public boolean isExpressRender() {
        return this.tt != null && this.tt.tt() == 1;
    }

    public boolean isNativeAd() {
        return this.tt != null && this.tt.tt() == 2;
    }

    @Override // com.byazt.wn.tt
    public <T> T callManager(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 8222) {
            boolean zIsExpressRender = isExpressRender();
            com.byazt.eu.tt.tt("TTMediationSDK", "Adn custom feed loader : isExpressRender: " + zIsExpressRender);
            return (T) Boolean.valueOf(zIsExpressRender);
        }
        if (i == 8223) {
            boolean zIsNativeAd = isNativeAd();
            com.byazt.eu.tt.tt("TTMediationSDK", "Adn custom feed loader : isNativeAd: " + zIsNativeAd);
            return (T) Boolean.valueOf(zIsNativeAd);
        }
        if (i == 8123) {
            int iIntValue = pluginValueSet.intValue(8014);
            String strStringValue = pluginValueSet.stringValue(8015);
            com.byazt.eu.tt.tt("TTMediationSDK", "Adn custom feed loader : callLoaderFail  code:" + iIntValue + " msg:" + strStringValue);
            callLoaderFail(iIntValue, strStringValue);
            return null;
        }
        if (i != 8107) {
            return null;
        }
        List<Function<SparseArray<Object>, Object>> list = (List) pluginValueSet.objectValue(8303, List.class);
        com.byazt.eu.tt.tt("TTMediationSDK", "Adn custom feed loader : callLoadSucceed  list size:" + (list != null ? list.size() : 0));
        callLoadSucceed(list);
        return null;
    }
}
