package com.opos.mobad.g.a.a;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<Integer, com.opos.mobad.c.a.d.a> f6944a = new HashMap<>();

    public u(List<com.opos.mobad.c.a.d.a> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (com.opos.mobad.c.a.d.a aVar : list) {
            this.f6944a.put(Integer.valueOf(aVar.m), aVar);
        }
    }

    private <T extends com.opos.mobad.ad.i> int a(int i, T t) {
        if (i == com.opos.mobad.c.a.d.a.f6704a) {
            return t.e();
        }
        int iE = t.e();
        if (iE > 0) {
            return iE;
        }
        com.opos.cmn.an.f.a.b("NativeBiddingDispatchController", "bidding channel:" + i + "real fail, use default");
        com.opos.mobad.c.a.d.a aVar = this.f6944a.get(Integer.valueOf(i));
        return aVar != null ? aVar.s : iE;
    }

    private <T extends com.opos.mobad.ad.i> void a(List<T> list) {
        for (T t : list) {
            if (t != null) {
                t.b(0);
            }
        }
    }

    private <T extends com.opos.mobad.ad.i> void a(List<T> list, int i) {
        for (T t : list) {
            if (t != null) {
                t.a(i, null, 0);
            }
        }
    }

    public <T extends com.opos.mobad.ad.i> com.opos.mobad.c.a.d.a a(HashMap<Integer, List<T>> map) {
        List<T> value;
        T t;
        if (map != null && map.size() > 0) {
            int iIntValue = -1;
            int i = 0;
            for (Map.Entry<Integer, List<T>> entry : map.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null && value.size() > 0 && (t = value.get(0)) != null) {
                    int iA = a(entry.getKey().intValue(), t);
                    if (iA <= 0 && entry.getKey().intValue() != com.opos.mobad.c.a.d.a.f6704a) {
                        com.opos.cmn.an.f.a.b("NativeBiddingDispatchController", "biding with fail result" + entry.getKey());
                        return null;
                    }
                    if (i > iA) {
                        com.opos.cmn.an.f.a.b("NativeBiddingDispatchController", "biding fail by compare:" + entry.getKey());
                    } else if (i != iA) {
                        iIntValue = entry.getKey().intValue();
                        i = iA;
                    } else if (entry.getKey().intValue() == com.opos.mobad.c.a.d.a.f6704a) {
                        iIntValue = entry.getKey().intValue();
                    }
                }
            }
            com.opos.cmn.an.f.a.b("NativeBiddingDispatchController", "biding result:" + iIntValue);
            if (iIntValue != -1) {
                a(iIntValue, map);
                return this.f6944a.get(Integer.valueOf(iIntValue));
            }
        }
        return null;
    }

    public <T extends com.opos.mobad.ad.i> void a(int i, HashMap<Integer, List<T>> map) {
        List<T> value;
        for (Map.Entry<Integer, List<T>> entry : map.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null && value.size() > 0) {
                if (i == entry.getKey().intValue()) {
                    com.opos.cmn.an.f.a.b("NativeBiddingDispatchController", "notify win " + i);
                    a(value);
                } else {
                    com.opos.cmn.an.f.a.b("NativeBiddingDispatchController", "notify loss " + entry.getKey() + ":1");
                    a(value, 1);
                }
            }
        }
    }
}
