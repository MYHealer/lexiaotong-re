package com.meishu.sdk.core.loader.strategy;

import java.util.Comparator;

/* JADX INFO: compiled from: PriceFirstStrategy.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class d implements Comparator<com.meishu.sdk.core.loader.loadbean.a> {
    public d(e eVar) {
    }

    @Override // java.util.Comparator
    public int compare(com.meishu.sdk.core.loader.loadbean.a aVar, com.meishu.sdk.core.loader.loadbean.a aVar2) {
        return aVar2.a() - aVar.a();
    }
}
