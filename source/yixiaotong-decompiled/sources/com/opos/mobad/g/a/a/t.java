package com.opos.mobad.g.a.a;

import com.byazt.p.ve;
import com.opos.mobad.ad.b;
import com.opos.mobad.ad.i;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class t<T extends com.opos.mobad.ad.b, P extends com.opos.mobad.ad.i> extends i<T> implements q<T, P> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final HashMap<Integer, List<P>> f6943a;
    final u d;

    public t(String str, int i, com.opos.mobad.g.a.c.a aVar, List<com.opos.mobad.c.a.d.a> list, com.opos.mobad.c.a.d.a aVar2, long j, int i2, com.opos.mobad.g.a.b.a<T> aVar3, com.opos.mobad.ad.b.a aVar4) {
        super(str, i, aVar, list, aVar2, j, i2, aVar3, aVar4);
        this.f6943a = new HashMap<>();
        this.d = new u(list);
    }

    private HashMap<Integer, List<P>> a(Map<Integer, List<P>> map, List<String> list) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        HashMap map2 = new HashMap(map);
        ve.c cVar = (HashMap<Integer, List<P>>) new HashMap();
        for (Map.Entry entry : map2.entrySet()) {
            Integer num = (Integer) entry.getKey();
            if (b(num.intValue(), list)) {
                cVar.put(num, entry.getValue());
            }
        }
        return cVar;
    }

    @Override // com.opos.mobad.g.a.a.i
    protected com.opos.mobad.c.a.d.a b(List<String> list) {
        HashMap<Integer, List<P>> mapA = a(this.f6943a, list);
        if (mapA == null || mapA.size() <= 0) {
            return null;
        }
        return this.d.a(mapA);
    }

    @Override // com.opos.mobad.g.a.a.i
    protected boolean f(int i) {
        return this.f6943a.containsKey(Integer.valueOf(i));
    }

    @Override // com.opos.mobad.g.a.a.q
    public List<P> g() {
        return this.f6943a.remove(Integer.valueOf(i()));
    }
}
