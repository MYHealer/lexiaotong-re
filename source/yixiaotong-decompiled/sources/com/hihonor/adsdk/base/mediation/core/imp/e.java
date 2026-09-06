package com.hihonor.adsdk.base.mediation.core.imp;

import com.cdo.oaps.ad.OapsKey;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.hihonor.adsdk.base.AdSlot;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.api.BaseExpressAd;
import com.hihonor.adsdk.base.callback.filter.AdFilteringLog;
import com.hihonor.adsdk.base.g.j.d.s0;
import com.hihonor.adsdk.base.g.j.d.w0;
import com.hihonor.adsdk.base.g.k.c.t;
import com.hihonor.adsdk.base.mediation.adn.AdnConfig;
import com.hihonor.adsdk.common.f.f;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class e {
    private static final String hnadsa = "SortAndBidManager";
    public static final String hnadsb = "0";
    public static final String hnadsc = "1";
    private static final int hnadsd = 0;
    private static final int hnadse = 0;
    private static final int hnadsf = 1;
    private static final int hnadsg = 1;
    private static final int hnadsh = 2;

    public static <K extends BaseExpressAd, T extends b<K>> List<K> hnadsa(List<T> list, int i, AdSlot adSlot, int i2) {
        String strHnadst;
        String strHnadsi;
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "sortAndBid", new Object[0]);
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "adType:" + i2, new Object[0]);
        if (f.hnadsa((Collection<?>) list)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "baseInstances 为 空", new Object[0]);
            return null;
        }
        T t = list.get(0);
        if (t != null) {
            strHnadst = t.hnadst();
            strHnadsi = t.hnadsi();
        } else {
            strHnadst = "";
            strHnadsi = "";
        }
        com.hihonor.adsdk.base.g.j.d.c.a aVarHnadsm = new com.hihonor.adsdk.base.g.j.d.c.a().hnadsa(adSlot.getAdCount()).hnadst(adSlot.getSlotId()).hnadsb(i2).hnadsh(i).hnadsc(strHnadsi).hnadsm(strHnadst);
        return i == 0 ? hnadsb(list, adSlot, aVarHnadsm, i2) : hnadsa(list, adSlot, aVarHnadsm, i2);
    }

    private static <K extends BaseExpressAd, T extends b<K>> List<K> hnadsb(List<T> list, AdSlot adSlot, com.hihonor.adsdk.base.g.j.d.c.a aVar, int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "singleShow", new Object[0]);
        hnadsa(list);
        T t = list.get(0);
        int i2 = 1;
        List<T> listSubList = list.subList(1, list.size());
        List listHnadsf = t.hnadsf();
        Collections.sort(listHnadsf, new Comparator() { // from class: com.hihonor.adsdk.base.mediation.core.imp.e$$ExternalSyntheticLambda1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return e.hnadsa((BaseExpressAd) obj, (BaseExpressAd) obj2);
            }
        });
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(listHnadsf);
        ArrayList arrayList2 = new ArrayList();
        if (!f.hnadsa((Collection<?>) listSubList)) {
            Iterator<T> it = listSubList.iterator();
            while (it.hasNext()) {
                arrayList2.addAll(it.next().hnadsf());
            }
        }
        arrayList.addAll(arrayList2);
        aVar.hnadsx("0");
        hnadsa(arrayList, aVar);
        int size = listHnadsf.size();
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("size:" + size));
        int adCount = adSlot.getAdCount();
        if (adCount <= 0) {
            adCount = size;
        }
        if (4 != i && 3 != i && 5 != i) {
            i2 = adCount;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "adCount:" + i2, new Object[0]);
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        if (i2 < size) {
            arrayList3.addAll(listHnadsf.subList(0, i2));
            arrayList4.addAll(listHnadsf.subList(i2, size));
        } else {
            arrayList3.addAll(listHnadsf);
        }
        arrayList4.addAll(arrayList2);
        hnadsa(arrayList3, arrayList4, aVar);
        return arrayList3;
    }

    private static <K extends BaseExpressAd, T extends b<K>> List<K> hnadsa(List<T> list, AdSlot adSlot, com.hihonor.adsdk.base.g.j.d.c.a aVar, int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "mixShow", new Object[0]);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            List listHnadsf = it.next().hnadsf();
            if (!f.hnadsa((Collection<?>) listHnadsf)) {
                arrayList.addAll(listHnadsf);
            }
        }
        hnadsb(arrayList);
        aVar.hnadsx("0");
        hnadsa(arrayList, aVar);
        int size = arrayList.size();
        int adCount = adSlot.getAdCount();
        if (adCount <= 0) {
            adCount = size;
        }
        if (4 == i || 3 == i || 5 == i) {
            adCount = 1;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (adCount < size) {
            arrayList2.addAll(arrayList.subList(0, adCount));
            arrayList3.addAll(arrayList.subList(adCount, size));
        } else {
            arrayList2.addAll(arrayList);
        }
        hnadsa(arrayList2, arrayList3, aVar);
        return arrayList2;
    }

    private static <K extends BaseExpressAd> List<K> hnadsb(List<K> list) {
        Collections.sort(list, new Comparator() { // from class: com.hihonor.adsdk.base.mediation.core.imp.e$$ExternalSyntheticLambda2
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return e.hnadsb((BaseExpressAd) obj, (BaseExpressAd) obj2);
            }
        });
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int hnadsb(BaseExpressAd baseExpressAd, BaseExpressAd baseExpressAd2) {
        if (baseExpressAd.getLevel() == baseExpressAd2.getLevel()) {
            if (baseExpressAd.getEcpm() == baseExpressAd2.getEcpm()) {
                if ("0".equals(baseExpressAd.getAdnType()) && "0".equals(baseExpressAd2.getAdnType())) {
                    return 0;
                }
                if (!"0".equals(baseExpressAd.getAdnType()) && "0".equals(baseExpressAd2.getAdnType())) {
                    return 1;
                }
                if ("0".equals(baseExpressAd.getAdnType()) && !"0".equals(baseExpressAd2.getAdnType())) {
                    return -1;
                }
                if (!"0".equals(baseExpressAd.getAdnType()) && !"0".equals(baseExpressAd2.getAdnType())) {
                    return (int) (baseExpressAd.getUseTime() - baseExpressAd2.getUseTime());
                }
            } else {
                return hnadsa(baseExpressAd2.getEcpm(), baseExpressAd.getEcpm());
            }
        }
        if (baseExpressAd.getLevel() > 0 && baseExpressAd2.getLevel() > 0) {
            return baseExpressAd.getLevel() - baseExpressAd2.getLevel();
        }
        if (baseExpressAd.getLevel() <= 0 || baseExpressAd2.getLevel() <= 0) {
            return baseExpressAd2.getLevel() - baseExpressAd.getLevel();
        }
        return 0;
    }

    private static <K extends BaseExpressAd> void hnadsa(List<K> list, com.hihonor.adsdk.base.g.j.d.c.a aVar) {
        if (f.hnadsa((Collection<?>) list)) {
            return;
        }
        JsonArray jsonArray = new JsonArray();
        Iterator<K> it = list.iterator();
        while (it.hasNext()) {
            jsonArray.add(hnadsa(it.next()));
        }
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("jsonArray:" + jsonArray.toString()));
        aVar.hnadsu(jsonArray.toString());
        com.hihonor.adsdk.base.g.j.d.c cVarHnadsa = aVar.hnadsa();
        new w0(cVarHnadsa, cVarHnadsa.hnadsl(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(cVarHnadsa)).hnadse();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int hnadsa(BaseExpressAd baseExpressAd, BaseExpressAd baseExpressAd2) {
        return hnadsa(baseExpressAd2.getEcpm(), baseExpressAd.getEcpm());
    }

    private static <K extends BaseExpressAd, T extends b<K>> List<T> hnadsa(List<T> list) {
        Collections.sort(list, new Comparator() { // from class: com.hihonor.adsdk.base.mediation.core.imp.e$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return e.hnadsa((b) obj, (b) obj2);
            }
        });
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int hnadsa(b bVar, b bVar2) {
        if (bVar.hnadso() == bVar2.hnadso()) {
            if (bVar.hnadsq() != bVar2.hnadsq()) {
                return hnadsa(bVar2.hnadsq(), bVar.hnadsq());
            }
            if ("0".equals(bVar.hnadsn()) && "0".equals(bVar2.hnadsn())) {
                return 0;
            }
            if ("0".equals(bVar.hnadsn()) && "0".equals(bVar2.hnadsn())) {
                return 1;
            }
            if ("0".equals(bVar.hnadsn()) && "0".equals(bVar2.hnadsn())) {
                return -1;
            }
            if (!"0".equals(bVar.hnadsn()) && !"0".equals(bVar2.hnadsn())) {
                return (int) (bVar.hnadsw() - bVar2.hnadsw());
            }
        }
        if (bVar.hnadso() > 0 && bVar2.hnadso() > 0) {
            return bVar.hnadso() - bVar2.hnadso();
        }
        if (bVar.hnadso() <= 0 || bVar2.hnadso() <= 0) {
            return bVar2.hnadso() - bVar.hnadso();
        }
        return 0;
    }

    private static <K extends BaseExpressAd> void hnadsa(List<K> list, List<K> list2, com.hihonor.adsdk.base.g.j.d.c.a aVar) {
        String str;
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "callBack", new Object[0]);
        aVar.hnadsx("1");
        if (f.hnadsa((Collection<?>) list)) {
            com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) "winList is null");
            return;
        }
        int i = 1;
        K k = list.get(list.size() - 1);
        JsonArray jsonArray = new JsonArray();
        for (K k2 : list) {
            k2.sendWinNotification(k2.getEcpm());
            jsonArray.add(hnadsa(k2));
        }
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("jsonArray:" + jsonArray.toString()));
        aVar.hnadsi("1").hnadsu(jsonArray.toString());
        com.hihonor.adsdk.base.g.j.d.c cVarHnadsa = aVar.hnadsa();
        com.hihonor.adsdk.base.g.j.d.h1.a aVarHnadsa = com.hihonor.adsdk.base.g.j.g.b.hnadsa(cVarHnadsa);
        new w0(cVarHnadsa, cVarHnadsa.hnadsl(), aVarHnadsa).hnadse();
        JsonArray jsonArray2 = new JsonArray();
        if (f.hnadsa((Collection<?>) list2)) {
            aVar.hnadsi("2").hnadsu("");
            com.hihonor.adsdk.base.g.j.d.c cVarHnadsa2 = aVar.hnadsa();
            new w0(cVarHnadsa2, cVarHnadsa2.hnadsl(), aVarHnadsa).hnadse();
            return;
        }
        for (K k3 : list2) {
            if (k3 != null) {
                if (k3.getLevel() == k.getLevel()) {
                    k3.sendLossNotification(k3.getEcpm(), 2, k3.getAdnId() + "");
                    str = "price is weak";
                } else {
                    k3.sendLossNotification(k3.getEcpm(), i, k3.getAdnId() + "");
                    str = "level is weak";
                }
                AdFilteringLog.info(AdFilteringLog.FILTER_TYPE_POLYMERIZE, "bid", "brand_type:" + hnadsa(k3.getAdnType()), "price:" + k3.getEcpm(), "level:" + k3.getLevel(), "AdMarker:" + k3.getAdId(), "AdRequestMarker:" + k3.getRequestId(), "ad_type:" + k3.getAdType(), "PackName:" + k3.getAppPackage(), "code:0", "msg:".concat(str));
                jsonArray2.add(hnadsa(k3));
                k3.release();
                hnadsa(k3, aVar.hnadsa());
                k = k;
                i = 1;
            }
        }
        aVar.hnadsi("0").hnadsu(jsonArray2.toString());
        com.hihonor.adsdk.base.g.j.d.c cVarHnadsa3 = aVar.hnadsa();
        new w0(cVarHnadsa3, cVarHnadsa3.hnadsl(), aVarHnadsa).hnadse();
    }

    private static <K extends BaseExpressAd> void hnadsa(K k, com.hihonor.adsdk.base.g.j.d.c cVar) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "reportShowFailed", new Object[0]);
        if (k.getTrackUrl() != null) {
            new t(ErrorCode.AD_BID_FAILED, ErrorCode.STR_BID_FAILED).hnadsc(k.getAdId(), cVar.i(), k.getRequestId(), k.getTrackUrl().getCommons());
        }
        cVar.hnadsi(String.valueOf(ErrorCode.AD_BID_FAILED));
        cVar.hnadsj(ErrorCode.STR_BID_FAILED);
        cVar.hnadsf(hnadsa(k.getAdnType()));
        cVar.hnadsd(k.getAdnType());
        cVar.hnadsv(k.getAdnId());
        cVar.hnadsn(k.getAppPackage());
        cVar.hnadse(k.getAppVersion());
        cVar.hnadsa(k.getAdId());
        cVar.hnadsq(k.getRequestId());
        new s0(cVar, cVar.hnadsl(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(cVar)).hnadse();
    }

    private static <K extends BaseExpressAd> JsonObject hnadsa(K k) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(com.hihonor.adsdk.base.g.j.e.a.K, hnadsa(k.getAdnType()));
        jsonObject.addProperty("level", Integer.valueOf(k.getLevel()));
        jsonObject.addProperty(OapsKey.KEY_PRICE, Long.valueOf(k.getEcpm()));
        jsonObject.addProperty("response_time", Long.valueOf(k.getUseTime()));
        jsonObject.addProperty("ad_id", k.getAdId());
        jsonObject.addProperty(com.hihonor.adsdk.base.g.j.e.a.hnadsj, k.getRequestId());
        return jsonObject;
    }

    private static int hnadsa(long j, long j2) {
        long jLongValue = new BigDecimal(j).subtract(new BigDecimal(j2)).longValue();
        if (jLongValue > 0) {
            return 1;
        }
        return jLongValue < 0 ? -1 : 0;
    }

    private static String hnadsa(String str) {
        if (str.equals("1")) {
            return AdnConfig.a.hnadsb;
        }
        if (str.equals("2")) {
            return AdnConfig.a.hnadsc;
        }
        return str.equals("0") ? AdnConfig.a.hnadsa : "";
    }
}
