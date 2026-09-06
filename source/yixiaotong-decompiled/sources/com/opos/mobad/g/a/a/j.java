package com.opos.mobad.g.a.a;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<Integer, com.opos.mobad.c.a.d.a> f6939a = new HashMap<>();

    public j(List<com.opos.mobad.c.a.d.a> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (com.opos.mobad.c.a.d.a aVar : list) {
            this.f6939a.put(Integer.valueOf(aVar.m), aVar);
        }
    }

    private <T extends com.opos.mobad.ad.b> int a(int i, T t) {
        if (i == com.opos.mobad.c.a.d.a.f6704a) {
            return t.e();
        }
        int iE = t.e();
        if (iE > 0) {
            return iE;
        }
        com.opos.cmn.an.f.a.b("BiddingDispatchController", "bidding channel:" + i + "real fail, use default");
        com.opos.mobad.c.a.d.a aVar = this.f6939a.get(Integer.valueOf(i));
        return aVar != null ? aVar.s : iE;
    }

    private <T extends com.opos.mobad.ad.b> void a(int i, Map<Integer, T> map) {
        T value;
        int i2;
        for (Map.Entry<Integer, T> entry : map.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                if (i == entry.getKey().intValue()) {
                    com.opos.cmn.an.f.a.b("BiddingDispatchController", "notify win " + entry.getKey());
                    value.b(0);
                } else {
                    int iC = value.c();
                    if (iC != 0) {
                        i2 = 2;
                        if (iC != 1) {
                            if (iC == 2) {
                                i2 = 1;
                            } else if (iC != 6) {
                                i2 = 4;
                            }
                        }
                    } else {
                        i2 = 3;
                    }
                    com.opos.cmn.an.f.a.b("BiddingDispatchController", "notify loss " + entry.getKey() + com.huawei.openalliance.ad.constant.x.bQ + i2);
                    value.a(i2, null, 0);
                }
            }
        }
    }

    public <T extends com.opos.mobad.ad.b> com.opos.mobad.c.a.d.a a(Map<Integer, T> map) {
        T value;
        int i = 0;
        int iIntValue = -1;
        for (Map.Entry<Integer, T> entry : map.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null && value.d()) {
                int iA = a(entry.getKey().intValue(), value);
                if (iA <= 0 && entry.getKey().intValue() != com.opos.mobad.c.a.d.a.f6704a) {
                    com.opos.cmn.an.f.a.b("BiddingDispatchController", "biding with fail result" + entry.getKey());
                    return null;
                }
                if (i > iA) {
                    com.opos.cmn.an.f.a.b("BiddingDispatchController", "biding fail by compare:" + entry.getKey());
                } else if (i != iA) {
                    iIntValue = entry.getKey().intValue();
                    i = iA;
                } else if (entry.getKey().intValue() == com.opos.mobad.c.a.d.a.f6704a) {
                    iIntValue = entry.getKey().intValue();
                }
            }
        }
        com.opos.cmn.an.f.a.b("BiddingDispatchController", "biding result:" + iIntValue);
        if (iIntValue == -1) {
            return null;
        }
        a(iIntValue, map);
        return this.f6939a.get(Integer.valueOf(iIntValue));
    }
}
