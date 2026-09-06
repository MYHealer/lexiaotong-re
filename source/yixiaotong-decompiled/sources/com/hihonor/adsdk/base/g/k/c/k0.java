package com.hihonor.adsdk.base.g.k.c;

import android.net.Uri;
import android.text.TextUtils;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.dp.AdDatabase;
import com.hihonor.adsdk.base.dp.entity.AdTrack;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class k0 {
    public static final int hnadsb = 2;
    private static final String hnadsc = "BaseTrack";
    protected final LinkedHashMap<String, String> hnadsa = new LinkedHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsb(String str, String str2, String str3, List list) {
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsc, (Object) "call on report.");
        hnadsa(str, str2, str3, list);
    }

    public int hnadsa() {
        return 2;
    }

    public void hnadsa(int i, int i2) {
        String strHnadsa;
        try {
            strHnadsa = com.hihonor.adsdk.common.f.z.hnadsa(new JSONObject().put(com.hihonor.adsdk.base.g.j.e.a.InterfaceC0437a.hnadsd, i).put("installType", i2).toString());
        } catch (JSONException e) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsc, "setExt, Set ext exception, Exception: " + e.getMessage(), new Object[0]);
            strHnadsa = "";
        }
        this.hnadsa.put(com.hihonor.adsdk.base.g.j.e.c.hnadsp, strHnadsa);
    }

    public abstract int hnadsb();

    protected int hnadsc() {
        return 0;
    }

    public void hnadsc(final String str, final String str2, final String str3, final List<String> list) {
        if (list == null || list.isEmpty()) {
            com.hihonor.adsdk.common.b.b.hnadsa(hnadsc, (Object) "execute track report, but trackUrls is null");
        } else {
            com.hihonor.adsdk.common.f.a0.hnadse(new Runnable() { // from class: com.hihonor.adsdk.base.g.k.c.k0$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.hnadsb(str, str2, str3, list);
                }
            });
        }
    }

    protected void hnadsd() {
        String strHnadsb = com.hihonor.adsdk.base.init.j.b.hnadsa().hnadsb();
        this.hnadsa.put(com.hihonor.adsdk.base.g.j.e.c.hnadsk, strHnadsb);
        this.hnadsa.put(com.hihonor.adsdk.base.g.j.e.c.hnadsl, com.hihonor.adsdk.base.j.b.hnadsc(strHnadsb.getBytes(StandardCharsets.UTF_8)));
        this.hnadsa.put(com.hihonor.adsdk.base.g.j.e.c.hnadsq, String.valueOf(System.currentTimeMillis()));
        this.hnadsa.put(com.hihonor.adsdk.base.g.j.e.c.hnadsr, String.valueOf(hnadsa()));
        this.hnadsa.put(com.hihonor.adsdk.base.g.j.e.c.hnadss, com.hihonor.adsdk.base.g.j.a.hnadsa().hnadsh);
    }

    protected String hnadsa(String str) {
        for (String str2 : this.hnadsa.keySet()) {
            String str3 = this.hnadsa.get(str2);
            if (TextUtils.isEmpty(str3)) {
                str3 = "";
            }
            str = str.replace(str2, Uri.encode(str3));
        }
        return str;
    }

    public void hnadsa(String str, String str2) {
        hnadsc("", str, str2, Collections.singletonList(com.hihonor.adsdk.base.net.p.a.hnadsa() + com.hihonor.adsdk.base.c.h2.hnadsd));
    }

    public void hnadsa(BaseAd baseAd, List<String> list) {
        String adId;
        String requestId;
        String adUnitId;
        if (Objects.nonNull(baseAd)) {
            adId = baseAd.getAdId();
            adUnitId = baseAd.getAdUnitId();
            requestId = baseAd.getRequestId();
        } else {
            adId = "";
            requestId = "";
            adUnitId = requestId;
        }
        hnadsc(adId, adUnitId, requestId, list);
    }

    private void hnadsa(String str, String str2, String str3, List<String> list) {
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsc, (Object) "execute track report internal");
        long jCurrentTimeMillis = System.currentTimeMillis();
        hnadsd();
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String strHnadsa = hnadsa(it.next());
            AdTrack adTrack = new AdTrack();
            adTrack.setTrackUrl(strHnadsa);
            adTrack.setTrackingType(hnadsb());
            adTrack.setTime(jCurrentTimeMillis);
            adTrack.setReportState(0);
            adTrack.setReportTime(jCurrentTimeMillis);
            adTrack.setReportCnt(0);
            adTrack.setBody(this.hnadsa.containsKey(com.hihonor.adsdk.base.g.j.e.c.hnadst) ? this.hnadsa.get(com.hihonor.adsdk.base.g.j.e.c.hnadst) : "");
            adTrack.setMethod(this.hnadsa.containsKey(com.hihonor.adsdk.base.g.j.e.c.hnadsu) ? this.hnadsa.get(com.hihonor.adsdk.base.g.j.e.c.hnadsu) : "GET");
            adTrack.setAdUnitId(str2);
            adTrack.setRequestId(str3);
            adTrack.setAdId(str);
            adTrack.setUrlType(hnadsc());
            adTrack.setRecordId(UUID.randomUUID().toString());
            com.hihonor.adsdk.common.b.b.hnadsa(hnadsc, (Object) ("============>TRACK-START trackUrl: " + strHnadsa + ", reqMarker：" + str3 + ", body: " + adTrack.getBody()));
            arrayList.add(adTrack);
        }
        hnadsa(str2, str3, arrayList);
    }

    private void hnadsa(String str, String str2, List<AdTrack> list) {
        com.hihonor.adsdk.base.g.k.a aVarHnadsa;
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsc, ">>>>>>>>>>>>> onReportInternal enter", new Object[0]);
        try {
            try {
                AdDatabase adDatabaseHnadsa = AdDatabase.hnadsa(HnAds.get().getContext());
                if (adDatabaseHnadsa != null) {
                    List<Long> listHnadsa = adDatabaseHnadsa.hnadsa().hnadsa(list);
                    com.hihonor.adsdk.common.b.b.hnadsc(hnadsc, ">>>>>>>>>>>>> Start Insert Tracking , size=" + com.hihonor.adsdk.common.f.f.hnadsb((Collection<?>) listHnadsa), new Object[0]);
                    if (com.hihonor.adsdk.common.f.f.hnadsa((Collection<?>) listHnadsa)) {
                        com.hihonor.adsdk.common.b.b.hnadsc(hnadsc, ">>>>>>>>>>>>> Start Report Tracking", new Object[0]);
                        return;
                    }
                    for (int i = 0; i < listHnadsa.size(); i++) {
                        list.get(i).setId(listHnadsa.get(i).longValue());
                    }
                    com.hihonor.adsdk.common.b.b.hnadsc(hnadsc, ">>>>>>>>>>>>> Start Report Tracking", new Object[0]);
                    com.hihonor.adsdk.base.g.k.a.hnadsa().hnadsa(list, true);
                }
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsc, ">>>>>>>>>>>>> Start Report Tracking", new Object[0]);
            } catch (Exception e) {
                com.hihonor.adsdk.common.b.b.hnadse(hnadsc, "execute Task, execute track report error, Exception: " + e.getMessage(), new Object[0]);
                new com.hihonor.adsdk.base.g.j.d.x(str, com.hihonor.adsdk.base.g.j.g.b.hnadsa("", str2, -1, 0), ErrorCode.AD_TRACK_DB_ERR, ErrorCode.STR_AD_TRACK_DB_ERR + com.hihonor.adsdk.base.j.g.hnadsa(list) + ",Exception msg : " + e.getMessage()).hnadsa("code", String.valueOf(ErrorCode.AD_CODE_INSERT_BATCH_TRACK_ERROR)).hnadse();
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsc, ">>>>>>>>>>>>> Start Report Tracking", new Object[0]);
            }
        } finally {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsc, ">>>>>>>>>>>>> Start Report Tracking", new Object[0]);
            com.hihonor.adsdk.base.g.k.a.hnadsa().hnadsa(list, true);
        }
    }
}
