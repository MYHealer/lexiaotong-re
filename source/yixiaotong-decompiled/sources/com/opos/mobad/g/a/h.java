package com.opos.mobad.g.a;

import com.heytap.msp.mobad.api.ad.IBidding;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class h {
    private static int a(int i, float f) {
        com.opos.cmn.an.f.a.b("PriceCalculateTool", "getChannelPrice:" + i + "*" + f);
        return (int) (i * f);
    }

    public static int a(int i, com.opos.mobad.ad.b bVar, com.opos.mobad.c.a.d.a aVar) {
        if (bVar == null) {
            com.opos.cmn.an.f.a.b("PriceCalculateTool", "ad is null");
            return IBidding.ECPM_PRICE_STATUS_NULL_AD;
        }
        if (i == com.opos.mobad.c.a.d.a.f6704a || i == 1001) {
            com.opos.cmn.an.f.a.b("PriceCalculateTool", "channel union return price:" + bVar.f());
            return bVar.f();
        }
        if (aVar != null) {
            return a(bVar.f(), aVar);
        }
        com.opos.cmn.an.f.a.b("PriceCalculateTool", "entity is null");
        return IBidding.ECPM_PRICE_STATUS_NULL_CHANNEL_ENTITY;
    }

    public static int a(int i, com.opos.mobad.ad.d.h hVar, com.opos.mobad.c.a.d.a aVar) {
        if (hVar == null) {
            com.opos.cmn.an.f.a.b("PriceCalculateTool", "ad is null");
            return IBidding.ECPM_PRICE_STATUS_NULL_AD;
        }
        if (i == com.opos.mobad.c.a.d.a.f6704a || i == 1001) {
            com.opos.cmn.an.f.a.b("PriceCalculateTool", "channel union return price:" + hVar.f());
            return hVar.f();
        }
        if (aVar != null) {
            return a(hVar.f(), aVar);
        }
        com.opos.cmn.an.f.a.b("PriceCalculateTool", "entity is null");
        return IBidding.ECPM_PRICE_STATUS_NULL_CHANNEL_ENTITY;
    }

    private static int a(int i, com.opos.mobad.c.a.d.a aVar) {
        if (aVar.m == com.opos.mobad.c.a.d.a.f6704a || aVar.m == 1001) {
            return i;
        }
        if (i > 0) {
            return a(i, aVar.a());
        }
        if (aVar.s > 0) {
            return a(aVar.s, aVar.a());
        }
        com.opos.cmn.an.f.a.b("PriceCalculateTool", "entity.ecpm:" + aVar.s);
        return IBidding.ECPM_PRICE_STATUS_LESS_ZERO;
    }

    public static int a(com.opos.mobad.ad.b bVar, com.opos.mobad.c.a.d.a aVar) {
        if (bVar == null) {
            com.opos.cmn.an.f.a.b("PriceCalculateTool", "ad is null");
            return IBidding.ECPM_PRICE_STATUS_NULL_AD;
        }
        if (aVar != null) {
            return a(bVar.f(), aVar);
        }
        com.opos.cmn.an.f.a.b("PriceCalculateTool", "entity is null");
        return IBidding.ECPM_PRICE_STATUS_NULL_CHANNEL_ENTITY;
    }

    public static int a(com.opos.mobad.ad.d.p pVar, com.opos.mobad.c.a.d.a aVar) {
        if (pVar == null || aVar == null) {
            return 0;
        }
        return a(pVar.f(), aVar);
    }
}
