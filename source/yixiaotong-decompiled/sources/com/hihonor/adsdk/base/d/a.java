package com.hihonor.adsdk.base.d;

import android.content.Context;
import android.text.TextUtils;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.bean.BaseAdInfo;
import com.hihonor.adsdk.base.bean.EventAdImpl;
import com.hihonor.adsdk.base.dp.AdDatabase;
import com.hihonor.adsdk.base.g.j.d.d;
import com.hihonor.adsdk.base.g.j.d.e;
import com.hihonor.adsdk.base.g.j.d.s0;
import com.hihonor.adsdk.base.g.j.d.x;
import com.hihonor.adsdk.base.g.k.c.t;
import com.hihonor.adsdk.common.f.a0;
import com.hihonor.adsdk.common.f.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a {
    private static final String hnadsb = "AdCache";
    private static volatile a hnadsc = null;
    public static boolean hnadsd = true;
    private final com.hihonor.adsdk.common.safe.a<String, List<BaseAdInfo>> hnadsa = new com.hihonor.adsdk.common.safe.a<>();

    /* JADX INFO: renamed from: com.hihonor.adsdk.base.d.a$a, reason: collision with other inner class name */
    class RunnableC0427a implements Runnable {
        final /* synthetic */ int hnadsd;

        RunnableC0427a(int i) {
            this.hnadsd = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<BaseAdInfo> listHnadsc = a.this.hnadsc();
            if (f.hnadsa((Collection<?>) listHnadsc)) {
                com.hihonor.adsdk.common.b.b.hnadsc(a.hnadsb, "deleteExpiredAdData baseAdInfoList is empty", new Object[0]);
                return;
            }
            for (BaseAdInfo baseAdInfo : listHnadsc) {
                if (Objects.isNull(baseAdInfo)) {
                    com.hihonor.adsdk.common.b.b.hnadsc(a.hnadsb, "deleteExpiredAdData baseAdInfo is null", new Object[0]);
                } else {
                    a.this.hnadsa(baseAdInfo, false);
                    String adUnitId = baseAdInfo.getAdUnitId();
                    String adRequestId = baseAdInfo.getAdRequestId();
                    a.this.hnadsa(2, adUnitId, com.hihonor.adsdk.base.g.j.g.b.hnadsa(baseAdInfo), adRequestId, this.hnadsd);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsc(int i) {
        List<BaseAdInfo> listHnadsc = hnadsc();
        if (f.hnadsa((Collection<?>) listHnadsc)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "deleteExpiredAdDataList baseAdInfoList is empty", new Object[0]);
            return;
        }
        ArrayList arrayList = new ArrayList(f.hnadsb((Collection<?>) listHnadsc));
        for (BaseAdInfo baseAdInfo : listHnadsc) {
            if (Objects.isNull(baseAdInfo)) {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "deleteExpiredAdDataList baseAdInfo is null", new Object[0]);
            } else {
                hnadsa(baseAdInfo, false);
                f.hnadsa(arrayList, new EventAdImpl(baseAdInfo));
            }
        }
        hnadsa(2, arrayList, i);
    }

    public static a hnadsb() {
        if (hnadsc == null) {
            synchronized (a.class) {
                if (hnadsc == null) {
                    hnadsc = new a();
                }
            }
        }
        return hnadsc;
    }

    private Context hnadsa() {
        return HnAds.get().getContext();
    }

    public void hnadsa(final List<BaseAdInfo> list, final String str) {
        a0.hnadsg(new Runnable() { // from class: com.hihonor.adsdk.base.d.a$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.hnadsb(list, str);
            }
        });
    }

    private long hnadsa(List<BaseAdInfo> list) {
        if (list == null || list.isEmpty()) {
            return 0L;
        }
        return list.get(0).getExpirationTime();
    }

    public int hnadsa(String str, long j) {
        try {
            if (hnadsa() != null) {
                int size = 0;
                for (List<BaseAdInfo> list : this.hnadsa.values()) {
                    if (!list.isEmpty() && TextUtils.equals(str, list.get(0).getAdUnitId())) {
                        size += list.size();
                    }
                }
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "queryUnExpiredAdDataByAdUnitId from adcopy: " + size, new Object[0]);
                return AdDatabase.hnadsa(hnadsa()).hnadsb().hnadsa(str, j) + size;
            }
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsb, "queryUnExpiredAdDataByAdUnitId, Exception: " + e.getMessage(), new Object[0]);
            hnadsb(str, "queryUnExpiredAdDataByAdUnitId: " + e.getMessage());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsb(List list, String str) {
        String strHnadsb = hnadsb((List<BaseAdInfo>) list);
        if (hnadsd && strHnadsb != null) {
            List<BaseAdInfo> list2 = this.hnadsa.get(strHnadsb);
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "check db copy: " + (list2 == null ? "" : Integer.valueOf(list2.size())), new Object[0]);
            if (list2 == null) {
                return;
            }
        }
        try {
            if (hnadsa() != null) {
                List<Long> listHnadsa = AdDatabase.hnadsa(hnadsa()).hnadsb().hnadsa((List<BaseAdInfo>) list);
                this.hnadsa.remove(strHnadsb);
                for (int i = 0; i < listHnadsa.size(); i++) {
                    hnadsa((BaseAdInfo) list.get(i), listHnadsa.get(i).longValue(), (String) null, str);
                }
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "insertAdData insertResultList: " + listHnadsa, new Object[0]);
            }
        } catch (Exception e) {
            String str2 = "db saveAdData, but has Exception.insertAd one Data:" + e.getMessage();
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsb, "insertAdData, insertAdData one: " + str2, new Object[0]);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                hnadsa((BaseAdInfo) it.next(), 0L, str2, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<BaseAdInfo> hnadsc() {
        try {
            if (hnadsa() != null) {
                return AdDatabase.hnadsa(hnadsa()).hnadsb().hnadsa(System.currentTimeMillis());
            }
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsb, "queryAdExpiredData, Exception: " + e.getMessage(), new Object[0]);
            hnadsb("", "queryAdExpiredData: " + e.getMessage());
        }
        return new ArrayList();
    }

    public void hnadsa(int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "deleteExpiredAdData", new Object[0]);
        a0.hnadsg(new RunnableC0427a(i));
    }

    private void hnadsa(int i, String str, int i2, String str2, com.hihonor.adsdk.base.g.j.d.h1.a aVar, int i3) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "reportCacheDel type = %d", Integer.valueOf(i2));
        new d(String.valueOf(i), String.valueOf(i2), str, str2, i3, aVar).hnadse();
    }

    public void hnadsc(List<BaseAdInfo> list) {
        if (!hnadsd || list == null || list.isEmpty()) {
            return;
        }
        String strHnadsb = hnadsb(list);
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "recordDbCache: " + strHnadsb, new Object[0]);
        if (strHnadsb != null) {
            this.hnadsa.put(strHnadsb, list);
        }
    }

    private void hnadsa(int i, BaseAd baseAd, int i2, String str) {
        String str2;
        int i3;
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "reportCacheDel outMsg = %s", str);
        String adUnitId = baseAd.getAdUnitId();
        String requestId = baseAd.getRequestId();
        if (i == 1) {
            str2 = "delete onImpression ad data. ad reqId is :" + requestId + ", adUnitId is " + adUnitId + str;
            i3 = ErrorCode.DELETE_ON_IMPRESSION_CACHE_AD_DATA;
        } else {
            str2 = "delete expired ad data. ad reqId is :" + requestId + ", adUnitId is " + adUnitId + str;
            i3 = ErrorCode.DELETE_EXPIRED_CACHE_AD_DATA;
        }
        hnadsa(i3, str2, i, adUnitId, com.hihonor.adsdk.base.g.j.g.b.hnadsa(baseAd), i2);
    }

    private String hnadsb(List<BaseAdInfo> list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0).getAdRequestId();
    }

    private void hnadsb(String str, String str2) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "reportCacheGetException", new Object[0]);
        new x(str, com.hihonor.adsdk.base.g.j.g.b.hnadsb(), ErrorCode.DB_CACHE_GET_EXCEPTION, str2).hnadse();
    }

    public List<BaseAdInfo> hnadsb(String str) {
        try {
            if (hnadsa() != null) {
                List<BaseAdInfo> listHnadsb = AdDatabase.hnadsa(hnadsa()).hnadsb().hnadsb(str, System.currentTimeMillis());
                if (!f.hnadsa((Collection<?>) listHnadsb) || str == null) {
                    return listHnadsb;
                }
                List<BaseAdInfo> list = null;
                for (List<BaseAdInfo> list2 : this.hnadsa.values()) {
                    BaseAdInfo baseAdInfo = list2.get(0);
                    if (str.equals(baseAdInfo.getAdUnitId()) && !baseAdInfo.isExpired(System.currentTimeMillis()) && (list == null || hnadsa(list) > hnadsa(list2))) {
                        list = list2;
                    }
                }
                if (list == null || list.isEmpty()) {
                    return listHnadsb;
                }
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "queryAdDataByAdUnitId from adcopy: " + list, new Object[0]);
                return list;
            }
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsb, "queryAdDataByAdUnitId, Exception: " + e.getMessage(), new Object[0]);
            hnadsb(str, "queryAdDataByAdUnitId: " + e.getMessage());
        }
        return null;
    }

    private void hnadsa(BaseAdInfo baseAdInfo, long j, String str, String str2) {
        if (baseAdInfo != null) {
            com.hihonor.adsdk.base.g.j.d.h1.a aVarHnadsa = com.hihonor.adsdk.base.g.j.g.b.hnadsa(baseAdInfo);
            if (!TextUtils.isEmpty(str)) {
                new e(str2, String.valueOf(ErrorCode.DB_CACHE_INFO_EXCEPTION), "", str, baseAdInfo.getAdUnitId(), aVarHnadsa).hnadse();
            } else if (j > 0) {
                new e(str2, String.valueOf(0), String.valueOf(baseAdInfo.getExpirationTime()), "SUCCESS", baseAdInfo.getAdUnitId(), aVarHnadsa).hnadse();
            } else {
                new e(str2, String.valueOf(ErrorCode.DB_CACHE_INSERT_EXCEPTION), String.valueOf(baseAdInfo.getExpirationTime()), "db insert result < 0.insertResult is " + j, baseAdInfo.getAdUnitId(), aVarHnadsa).hnadse();
            }
        }
    }

    public int hnadsa(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "getAdCacheCount currentTime = " + jCurrentTimeMillis, new Object[0]);
        int iHnadsa = hnadsa(str, jCurrentTimeMillis);
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "getAdCacheCount adCacheCount = " + iHnadsa, new Object[0]);
        return iHnadsa;
    }

    public void hnadsa(final BaseAd baseAd, final int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "deleteOnImpressionAdData", new Object[0]);
        a0.hnadsg(new Runnable() { // from class: com.hihonor.adsdk.base.d.a$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.hnadsb(baseAd, i);
            }
        });
    }

    public void hnadsb(final int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "deleteExpiredAdDataList ", new Object[0]);
        a0.hnadsg(new Runnable() { // from class: com.hihonor.adsdk.base.d.a$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.hnadsc(i);
            }
        });
    }

    private void hnadsa(int i, List<BaseAd> list, int i2) {
        if (f.hnadsa((Collection<?>) list)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "deleteAdDataList baseAdList is empty.", new Object[0]);
            return;
        }
        if (Objects.isNull(hnadsa())) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "deleteAdDataList getContext() back context is empty.", new Object[0]);
            return;
        }
        ArrayList arrayList = new ArrayList(f.hnadsb((Collection<?>) list));
        for (BaseAd baseAd : list) {
            com.hihonor.adsdk.common.b.b.hnadsa(hnadsb, (Object) ("deleteAdDataList will be delete unit = " + baseAd.getAdUnitId() + ", request = " + baseAd.getRequestId()));
            arrayList.add(baseAd.getRequestId());
        }
        try {
            int iHnadsc = AdDatabase.hnadsa(hnadsa()).hnadsb().hnadsc(arrayList);
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "deleteAdDataList deleteAdDataList results =  " + iHnadsc, new Object[0]);
            hnadsa(iHnadsc, arrayList, list, i, i2);
        } catch (Exception e) {
            for (BaseAd baseAd2 : list) {
                String str = "db delAdData, but has Exception.del Data:" + e.getMessage();
                com.hihonor.adsdk.common.b.b.hnadsb(hnadsb, "deleteAdDataList: " + str, new Object[0]);
                hnadsa(i, baseAd2, i2, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsb(BaseAd baseAd, int i) {
        if (baseAd == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "deleteOnImpressionAdData baseAd is null", new Object[0]);
            return;
        }
        com.hihonor.adsdk.base.g.j.d.h1.a aVarHnadsa = com.hihonor.adsdk.base.g.j.g.b.hnadsa(baseAd);
        String adUnitId = baseAd.getAdUnitId();
        String requestId = baseAd.getRequestId();
        hnadsa(adUnitId, requestId, baseAd.getAdId());
        hnadsa(1, adUnitId, aVarHnadsa, requestId, i);
        if (requestId != null) {
            this.hnadsa.remove(requestId);
        }
    }

    private void hnadsa(int i, List<String> list, List<BaseAd> list2, int i2, int i3) {
        if (i <= 0) {
            return;
        }
        if (i == f.hnadsb((Collection<?>) list)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "deleteAdDataList delete all =  " + i, new Object[0]);
            for (BaseAd baseAd : list2) {
                hnadsa(i2, baseAd, i3, baseAd.getRequestId() + " delete success");
            }
            return;
        }
        List<BaseAdInfo> listHnadsb = AdDatabase.hnadsa(hnadsa()).hnadsb().hnadsb(list);
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "deleteAdDataList delete part =  " + i, new Object[0]);
        if (f.hnadsa((Collection<?>) listHnadsb)) {
            return;
        }
        for (String str : list) {
            BaseAdInfo baseAdInfo = null;
            for (BaseAdInfo baseAdInfo2 : listHnadsb) {
                if (!TextUtils.equals(str, baseAdInfo2.getAdRequestId())) {
                    baseAdInfo = baseAdInfo2;
                }
            }
            if (baseAdInfo != null) {
                hnadsa(i2, new EventAdImpl(baseAdInfo), i3, baseAdInfo.getAdRequestId() + " delete success");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hnadsa(int i, String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar, String str2, int i2) {
        String str3;
        int i3;
        if (i == 1) {
            str3 = "delete onImpression ad data. ad reqId is :" + str2 + ", adUnitId is " + str;
            i3 = ErrorCode.DELETE_ON_IMPRESSION_CACHE_AD_DATA;
        } else {
            str3 = "delete expired ad data. ad reqId is :" + str2 + ", adUnitId is " + str;
            i3 = ErrorCode.DELETE_EXPIRED_CACHE_AD_DATA;
        }
        String str4 = str3;
        try {
            if (hnadsa() != null) {
                int iHnadsb = AdDatabase.hnadsa(hnadsa()).hnadsb().hnadsb(str, str2);
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, ">>>>>>> deleteAdData type = %d, deleteResult = %d ", Integer.valueOf(i), Integer.valueOf(iHnadsb));
                if (iHnadsb > 0) {
                    hnadsa(i3, str4, i, str, aVar, i2);
                }
            }
        } catch (Exception e) {
            String str5 = str4 + "db delAdData, but has Exception.del Data:" + e.getMessage();
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsb, "deleteAdData: " + str5, new Object[0]);
            hnadsa(ErrorCode.DB_CACHE_DEL_EXCEPTION, str5, i, str, aVar, i2);
        }
    }

    public List<BaseAdInfo> hnadsa(String str, String str2) {
        List<BaseAdInfo> list;
        try {
            if (hnadsa() != null) {
                List<BaseAdInfo> listHnadsa = AdDatabase.hnadsa(hnadsa()).hnadsb().hnadsa(str, str2);
                return (!f.hnadsa((Collection<?>) listHnadsa) || (list = this.hnadsa.get(str2)) == null || list.isEmpty()) ? listHnadsa : list;
            }
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsb, "queryAdDataByAdUnitMarkerAndRequestMarker, Exception: " + e.getMessage(), new Object[0]);
            hnadsb(str, "queryAdDataByAdUnitMarkerAndRequestMarker: " + e.getMessage());
        }
        return new ArrayList();
    }

    private void hnadsa(String str, String str2, String str3) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "handleReportBeforeDeleteADData", new Object[0]);
        List<BaseAdInfo> listHnadsa = hnadsa(str, str2);
        if (f.hnadsa((Collection<?>) listHnadsa)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "handleReportBeforeDeleteADData cacheList is empty", new Object[0]);
            return;
        }
        for (BaseAdInfo baseAdInfo : listHnadsa) {
            if (Objects.isNull(baseAdInfo)) {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "handleReportBeforeDeleteADData baseAdInfo is null", new Object[0]);
            } else if (!TextUtils.equals(baseAdInfo.getAdId(), str3)) {
                hnadsa(baseAdInfo, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hnadsa(BaseAdInfo baseAdInfo, boolean z) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "reportShowFail isOnImpressionDelete = %s", Boolean.valueOf(z));
        if (baseAdInfo == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "reportShowFail baseAdInfo is null", new Object[0]);
            return;
        }
        String str = "Excess ad exposure failed. AdMarker:" + baseAdInfo.getAdId() + ",Sequence:" + baseAdInfo.getSequence();
        int i = z ? ErrorCode.DELETE_ON_IMPRESSION_CACHE_AD_DATA : ErrorCode.DELETE_EXPIRED_CACHE_AD_DATA;
        new t(i, str).hnadsc(baseAdInfo.getAdId(), baseAdInfo.getAdUnitId(), baseAdInfo.getAdRequestId(), baseAdInfo.getTrackUrl().getCommons());
        new s0(i, str, baseAdInfo.getAdUnitId(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(baseAdInfo)).hnadse();
    }
}
