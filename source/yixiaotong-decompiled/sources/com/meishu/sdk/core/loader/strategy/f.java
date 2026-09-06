package com.meishu.sdk.core.loader.strategy;

import com.meishu.sdk.core.loader.cache.CacheManager;
import com.meishu.sdk.core.safe.l;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: compiled from: PriceFirstStrategy.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class f extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f4822a;

    public f(e eVar) {
        this.f4822a = eVar;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        try {
            if (this.f4822a.b.getCache() > 0) {
                String cacheKey = this.f4822a.b.getCacheKey();
                if (this.f4822a.q.size() > 0) {
                    HashSet hashSet = new HashSet(this.f4822a.q);
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(hashSet);
                    this.f4822a.a(arrayList);
                    for (int i = 0; i < this.f4822a.q.size(); i++) {
                        if (i != 0 || this.f4822a.r) {
                            com.meishu.sdk.core.loader.loadbean.a aVar = this.f4822a.q.get(i);
                            if (aVar.g) {
                                com.meishu.sdk.core.loader.concurrent.e eVar = (com.meishu.sdk.core.loader.concurrent.e) this.f4822a.k;
                                eVar.i.post(new com.meishu.sdk.core.loader.concurrent.c(eVar));
                            } else {
                                e.b(this.f4822a, aVar);
                            }
                        }
                    }
                }
                CacheManager cacheManager = CacheManager.INSTANCE;
                e eVar2 = this.f4822a;
                cacheManager.handleCurrentList(cacheKey, eVar2.c, eVar2.b.getCache());
                e.a(this.f4822a);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
