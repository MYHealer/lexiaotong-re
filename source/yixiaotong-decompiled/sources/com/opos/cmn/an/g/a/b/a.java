package com.opos.cmn.an.g.a.b;

import android.content.Context;
import com.opos.cmn.an.g.b;
import com.opos.cmn.an.g.f;
import com.opos.cmn.an.g.g;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<Long, com.opos.cmn.an.g.a.a.b> f5921a = new ConcurrentHashMap();

    @Override // com.opos.cmn.an.g.b
    public g a(Context context, long j, f fVar) throws Exception {
        if (context == null || fVar == null) {
            return null;
        }
        com.opos.cmn.an.g.a.a.b bVar = new com.opos.cmn.an.g.a.a.b(context, fVar);
        this.f5921a.put(Long.valueOf(j), bVar);
        return bVar.a();
    }

    @Override // com.opos.cmn.an.g.b
    public void a(long j) throws Exception {
        Map<Long, com.opos.cmn.an.g.a.a.b> map = this.f5921a;
        if (map == null || !map.containsKey(Long.valueOf(j))) {
            return;
        }
        com.opos.cmn.an.g.a.a.b bVar = this.f5921a.get(Long.valueOf(j));
        if (bVar != null) {
            bVar.b();
        }
        this.f5921a.remove(Long.valueOf(j));
    }
}
