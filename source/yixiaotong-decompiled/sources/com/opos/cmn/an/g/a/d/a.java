package com.opos.cmn.an.g.a.d;

import android.content.Context;
import com.opos.cmn.an.g.a.a.b;
import com.opos.cmn.an.g.c;
import com.opos.cmn.an.g.f;
import com.opos.cmn.an.g.g;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<Long, b> f5922a = new ConcurrentHashMap();

    @Override // com.opos.cmn.an.g.c
    public g a(Context context, long j, f fVar) throws Exception {
        if (context == null || fVar == null) {
            return null;
        }
        b bVar = new b(context, fVar);
        this.f5922a.put(Long.valueOf(j), bVar);
        return bVar.a();
    }

    @Override // com.opos.cmn.an.g.c
    public void a(long j) throws Exception {
        Map<Long, b> map = this.f5922a;
        if (map == null || !map.containsKey(Long.valueOf(j))) {
            return;
        }
        b bVar = this.f5922a.get(Long.valueOf(j));
        if (bVar != null) {
            bVar.b();
        }
        this.f5922a.remove(Long.valueOf(j));
    }
}
