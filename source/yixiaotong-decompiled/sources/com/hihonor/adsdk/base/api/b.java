package com.hihonor.adsdk.base.api;

import android.text.TextUtils;
import com.cdo.oaps.ad.OapsKey;
import com.google.gson.JsonObject;
import com.hihonor.adsdk.base.AdSlot;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.bean.BaseAdInfo;
import com.hihonor.adsdk.base.bean.BaseAdInfoResp;
import com.hihonor.adsdk.base.bean.EventAdImpl;
import com.hihonor.adsdk.base.callback.BaseListener;
import com.hihonor.adsdk.base.g.j.d.s0;
import com.hihonor.adsdk.base.g.j.d.w0;
import com.hihonor.adsdk.base.g.k.c.t;
import com.hihonor.adsdk.base.g.k.c.w;
import com.hihonor.adsdk.base.init.InitCallback;
import com.hihonor.adsdk.base.init.h;
import com.hihonor.adsdk.base.init.i;
import com.hihonor.adsdk.base.mediation.adn.AdnConfig;
import com.hihonor.adsdk.base.net.request.TrackAdRequest;
import com.hihonor.adsdk.base.net.resp.AdUnitInfo;
import com.hihonor.adsdk.common.f.a0;
import com.hihonor.adsdk.common.f.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class b<LISTENER extends BaseListener> implements IAdLoad<LISTENER> {
    private static final String hnadse = "BaseAdLoadImpl";
    private static final String hnadsf = "START_REQ_MEDIA";
    private static final String hnadsg = "shakeSwitch";
    private static final String hnadsh = "START_REQ_FAIL_SDK";
    protected AdSlot hnadsa;
    protected volatile LISTENER hnadsb;
    protected String hnadsc;
    private final ArrayList<e> hnadsd = new a();

    class a extends ArrayList<e> {
        a() {
            add(new com.hihonor.adsdk.base.api.f.a());
            add(new com.hihonor.adsdk.base.api.f.b());
        }
    }

    /* JADX INFO: renamed from: com.hihonor.adsdk.base.api.b$b, reason: collision with other inner class name */
    class C0424b implements com.hihonor.adsdk.base.callback.e<BaseAdInfoResp> {
        C0424b() {
        }

        @Override // com.hihonor.adsdk.base.callback.e
        public void hnadsa(BaseAdInfoResp baseAdInfoResp) {
            b.this.hnadsa(String.valueOf(0), "success", baseAdInfoResp);
        }

        @Override // com.hihonor.adsdk.base.callback.e
        public void hnadsa(String str, Throwable th) {
            b.this.hnadsa(str, "client reqId : " + b.this.hnadsc + "," + th.getMessage(), (BaseAdInfoResp) null);
        }
    }

    class c implements Runnable {
        final /* synthetic */ String hnadsd;
        final /* synthetic */ String hnadse;
        final /* synthetic */ com.hihonor.adsdk.base.g.j.d.h1.a hnadsf;
        final /* synthetic */ String hnadsg;

        c(String str, String str2, com.hihonor.adsdk.base.g.j.d.h1.a aVar, String str3) {
            this.hnadsd = str;
            this.hnadse = str2;
            this.hnadsf = aVar;
            this.hnadsg = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.hihonor.adsdk.base.bean.b bVarHnadsb = b.this.hnadsb(this.hnadsd);
            LISTENER listener = b.this.hnadsb;
            if (listener != null) {
                if (TextUtils.isEmpty(this.hnadse) || !this.hnadse.contains(com.hihonor.adsdk.base.g.j.e.a.Z)) {
                    new com.hihonor.adsdk.base.g.j.d.j1.e(bVarHnadsb, this.hnadsd, this.hnadsf, this.hnadsg, this.hnadse, (String) null).hnadse();
                } else {
                    String[] strArrSplit = this.hnadse.split(com.hihonor.adsdk.base.g.j.e.a.Z);
                    new com.hihonor.adsdk.base.g.j.d.j1.e(bVarHnadsb, this.hnadsd, this.hnadsf, this.hnadsg, strArrSplit[0], strArrSplit.length > 1 ? strArrSplit[1] : "").hnadse();
                }
                listener.onFailed(String.valueOf(this.hnadsg), this.hnadse);
                b.this.hnadsb = null;
            }
        }
    }

    class d implements Runnable {
        final /* synthetic */ String hnadsd;
        final /* synthetic */ String hnadse;

        d(String str, String str2) {
            this.hnadsd = str;
            this.hnadse = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            LISTENER listener = b.this.hnadsb;
            if (listener != null) {
                listener.onFailed(String.valueOf(this.hnadsd), this.hnadse);
                b.this.hnadsb = null;
            }
        }
    }

    public interface e {
        void hnadsa(List<BaseAdInfo> list);
    }

    private int hnadsd() {
        AdSlot adSlot = this.hnadsa;
        if (adSlot != null) {
            return adSlot.getRenderType();
        }
        return 0;
    }

    private com.hihonor.adsdk.base.g.j.d.c.a hnadse() {
        AdUnitInfo adUnitInfoHnadsa = i.hnadsa(this.hnadsa.getSlotId());
        return new com.hihonor.adsdk.base.g.j.d.c.a().hnadsa(1).hnadst(this.hnadsa.getSlotId()).hnadsb(hnadsb()).hnadsh(adUnitInfoHnadsa != null ? adUnitInfoHnadsa.sameShow : 0);
    }

    private String hnadsf() {
        AdSlot adSlot = this.hnadsa;
        return adSlot != null ? adSlot.getSlotId() : "";
    }

    private void hnadsi() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "call init internalConfigInitSDK method start", new Object[0]);
        h.hnadsa("internalConfigInitSDK");
    }

    private void hnadsm() {
        com.hihonor.adsdk.base.init.b.hnadsc().hnadsi();
        if (h.hnadsb()) {
            return;
        }
        hnadsi();
    }

    private void hnadsp() {
        AdSlot adSlot = this.hnadsa;
        String slotId = adSlot != null ? adSlot.getSlotId() : "";
        int iHnadsb = hnadsb();
        int iHnadsc = hnadsc();
        AdSlot adSlot2 = this.hnadsa;
        int dataType = adSlot2 != null ? adSlot2.getDataType() : 0;
        String strHnadsa = com.hihonor.adsdk.base.g.c.hnadsa(this.hnadsa);
        hnadsa(hnadsb(slotId), hnadsf, com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.hnadsc, "", iHnadsb, dataType), slotId, null, null);
        hnadsa(hnadsf, slotId, iHnadsb, this.hnadsc, iHnadsc, null, null, strHnadsa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hnadsr() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "Start requesting ads.", new Object[0]);
        if (hnadsj()) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "statLoad#isIntercept is true", new Object[0]);
            return;
        }
        hnadsl();
        if (hnadsa()) {
            hnadsq();
        } else {
            com.hihonor.adsdk.base.net.o.b.hnadsa().hnadsb(this.hnadsc);
        }
    }

    protected abstract void hnadsa(int i, String str, BaseAdInfoResp baseAdInfoResp);

    protected boolean hnadsa() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "Check request condition.", new Object[0]);
        AdSlot adSlot = this.hnadsa;
        if (adSlot == null) {
            hnadsb(String.valueOf(ErrorCode.AD_SLOT_NONE), "Please set AdSlot correctly.");
            com.hihonor.adsdk.common.b.b.hnadse(hnadse, "Please set AdSlot correctly.", new Object[0]);
            return false;
        }
        if (TextUtils.isEmpty(adSlot.getSlotId())) {
            hnadsb(String.valueOf(ErrorCode.AD_SLOT_ID_EMPTY), "SlotId is empty.Please set the correct slotId.");
            com.hihonor.adsdk.common.b.b.hnadse(hnadse, "SlotId is empty.Please set the correct slotId.", new Object[0]);
            return false;
        }
        if (h.hnadsa() == null || 1 == h.hnadsa().enable) {
            if (!TextUtils.isEmpty(HnAds.get().getCfg().getAppKey())) {
                return true;
            }
            hnadsb(String.valueOf(ErrorCode.AD_APP_KEY_EMPTY), "AppKey is empty.Your must input valid!");
            return false;
        }
        String str = "media is disable :" + h.hnadsa().enable;
        hnadsb(String.valueOf(ErrorCode.AD_MEDIA_DISABLE), str);
        com.hihonor.adsdk.common.b.b.hnadse(hnadse, str, new Object[0]);
        return false;
    }

    protected abstract int hnadsb();

    protected void hnadsb(String str, String str2) {
        hnadsa(str, str2, false);
    }

    protected int hnadsc() {
        AdSlot adSlot = this.hnadsa;
        if (adSlot != null) {
            return adSlot.getLoadType();
        }
        return -1;
    }

    protected boolean hnadsh() {
        return true;
    }

    protected boolean hnadsj() {
        return false;
    }

    protected abstract boolean hnadsk();

    protected void hnadsl() {
        this.hnadsc = UUID.randomUUID().toString();
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "call mediaStart mClientReqId = " + this.hnadsc + ", AdType = " + hnadsb() + ", slotId = " + hnadsf() + ", renderType = " + hnadsd(), new Object[0]);
        hnadsm();
        hnadsp();
        com.hihonor.adsdk.base.net.o.b.hnadsa().hnadsa(this.hnadsc, 0);
    }

    protected void hnadsn() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "recordRenderEnd enter.", new Object[0]);
        com.hihonor.adsdk.base.net.o.b.hnadsa().hnadsa(this.hnadsc, 17);
    }

    protected void hnadso() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "recordRenderStart enter.", new Object[0]);
        com.hihonor.adsdk.base.net.o.b.hnadsa().hnadsa(this.hnadsc, 16);
    }

    protected void hnadsq() {
        com.hihonor.adsdk.base.h.a.hnadsa().hnadsb(this.hnadsa, this.hnadsc, hnadsb(), new C0424b());
    }

    @Override // com.hihonor.adsdk.base.api.IAdLoad
    public void loadAd() {
        if (!HnAds.get().isInitialized()) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "loadAd isInitialized is false", new Object[0]);
            hnadsa(String.valueOf(30002), "the SDK is not initialized");
        } else if (com.hihonor.adsdk.base.init.b.hnadsc().hnadsg()) {
            hnadsr();
        } else {
            com.hihonor.adsdk.base.init.b.hnadsc().hnadsa(new InitCallback() { // from class: com.hihonor.adsdk.base.api.b$$ExternalSyntheticLambda1
                @Override // com.hihonor.adsdk.base.init.InitCallback
                public final void onResult() {
                    this.f$0.hnadsr();
                }
            });
        }
    }

    @Override // com.hihonor.adsdk.base.api.IAdLoad
    public void setAdLoadListener(LISTENER listener) {
        this.hnadsb = listener;
    }

    @Override // com.hihonor.adsdk.base.api.IAdLoad
    public void setAdSlot(AdSlot adSlot) {
        this.hnadsa = adSlot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int hnadsb(BaseAdInfo baseAdInfo, BaseAdInfo baseAdInfo2) {
        return (int) (baseAdInfo2.getPrice() - baseAdInfo.getPrice());
    }

    private void hnadsc(BaseAdInfoResp baseAdInfoResp) {
        if (baseAdInfoResp == null || baseAdInfoResp.getList() == null || baseAdInfoResp.getList().isEmpty()) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadse, "notifyBaseAdInfoResp ad list is empty", new Object[0]);
            return;
        }
        List<BaseAdInfo> list = baseAdInfoResp.getList();
        if (hnadsh()) {
            Collections.sort(list, new Comparator() { // from class: com.hihonor.adsdk.base.api.b$$ExternalSyntheticLambda2
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return b.hnadsb((BaseAdInfo) obj, (BaseAdInfo) obj2);
                }
            });
            BaseAdInfo baseAdInfo = list.get(0);
            ArrayList arrayList = new ArrayList();
            arrayList.add(baseAdInfo);
            list = arrayList;
        }
        Iterator<e> it = this.hnadsd.iterator();
        while (it.hasNext()) {
            it.next().hnadsa(list);
        }
    }

    protected BaseAdInfo hnadsb(BaseAdInfoResp baseAdInfoResp) {
        List<BaseAdInfo> list = baseAdInfoResp.getList();
        Collections.sort(list, new Comparator() { // from class: com.hihonor.adsdk.base.api.b$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return b.hnadsa((BaseAdInfo) obj, (BaseAdInfo) obj2);
            }
        });
        boolean zIsCachedData = baseAdInfoResp.isCachedData();
        if (hnadsk() && (hnadsc() == 1 || zIsCachedData)) {
            return list.get(0);
        }
        com.hihonor.adsdk.base.g.j.d.c.a aVarHnadse = hnadse();
        aVarHnadse.hnadsx("1");
        if (list.size() > 1) {
            for (int i = 1; i < list.size(); i++) {
                BaseAdInfo baseAdInfo = list.get(i);
                if (Objects.isNull(baseAdInfo)) {
                    com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "getOnlyOneAdInfo, but AD is null.", new Object[0]);
                } else {
                    aVarHnadse.hnadsi("0").hnadsr(com.hihonor.adsdk.base.j.c.hnadsb(baseAdInfoResp)).hnadsu(hnadsa(baseAdInfo.getPrice()).toString());
                    new w0(aVarHnadse.hnadsa(), baseAdInfo.getAdUnitId(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(baseAdInfo)).hnadse();
                    EventAdImpl eventAdImpl = new EventAdImpl(baseAdInfo);
                    String str = "Excess ad exposure failed. Sequence:" + eventAdImpl.getSequence();
                    new t(ErrorCode.AD_EXCESS_COUNT_UN_EXPOSURE, str).hnadsa(eventAdImpl, eventAdImpl.getTrackUrl().getCommons());
                    new s0(ErrorCode.AD_EXCESS_COUNT_UN_EXPOSURE, str, eventAdImpl.getAdUnitId(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(eventAdImpl)).hnadse();
                }
            }
        }
        return list.get(0);
    }

    private String hnadsg() {
        AdSlot adSlot = this.hnadsa;
        if (adSlot == null) {
            return "1";
        }
        String adContext = adSlot.getAdContext();
        if (!TextUtils.isEmpty(adContext) && adContext.contains(hnadsg)) {
            try {
                return String.valueOf(new JSONObject(adContext).get(hnadsg));
            } catch (Exception e2) {
                com.hihonor.adsdk.common.b.b.hnadsb(hnadse, "handleMediaAdContext errorMsg = " + e2.getMessage(), new Object[0]);
            }
        }
        return "1";
    }

    protected void hnadsc(String str) {
        AdSlot adSlot = this.hnadsa;
        boolean z = adSlot != null && adSlot.isPreCacheVideo();
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "preCacheVideo,isPreCacheVideo:" + z, new Object[0]);
        if (z) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "preCacheVideo", new Object[0]);
            com.hihonor.adsdk.common.video.g.b.hnadsa().hnadsb().hnadsb(HnAds.get().getContext(), str);
        }
    }

    protected void hnadsa(String str, String str2, boolean z) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "Load ad on fail code: %s, msg:%s", str, str2);
        if (!TextUtils.equals(String.valueOf(ErrorCode.AD_LOADING_TIME_OUT), str)) {
            com.hihonor.adsdk.base.net.o.b.hnadsa().hnadsb(this.hnadsc);
        }
        AdSlot adSlot = this.hnadsa;
        String slotId = adSlot != null ? adSlot.getSlotId() : "";
        int iHnadsb = hnadsb();
        int iHnadsc = hnadsc();
        AdSlot adSlot2 = this.hnadsa;
        int dataType = adSlot2 != null ? adSlot2.getDataType() : 0;
        AdSlot adSlot3 = this.hnadsa;
        if (adSlot3 != null) {
            adSlot3.getRenderType();
        }
        String strHnadsa = com.hihonor.adsdk.base.g.c.hnadsa(this.hnadsa);
        if (!z) {
            hnadsa(hnadsb(slotId), hnadsh, com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.hnadsc, "", iHnadsb, dataType), slotId, str, str2);
            hnadsa(hnadsh, slotId, iHnadsb, this.hnadsc, iHnadsc, str, str2, strHnadsa);
        }
        hnadsa(com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.hnadsc, "", iHnadsb, dataType), slotId, str, str2);
    }

    protected com.hihonor.adsdk.base.bean.b hnadsb(String str) {
        com.hihonor.adsdk.base.bean.b.a aVarHnadsd = new com.hihonor.adsdk.base.bean.b.a().hnadsa(hnadsb()).hnadsc(str).hnadsd(hnadsc());
        AdSlot adSlot = this.hnadsa;
        com.hihonor.adsdk.base.bean.b.a aVarHnadsa = aVarHnadsd.hnadsb(adSlot != null ? adSlot.getDataType() : 0).hnadsa(com.hihonor.adsdk.base.g.c.hnadsa(this.hnadsa));
        AdSlot adSlot2 = this.hnadsa;
        com.hihonor.adsdk.base.bean.b.a aVarHnadsc = aVarHnadsa.hnadsc(adSlot2 != null ? com.hihonor.adsdk.base.b.hnadsa(adSlot2) : 0);
        AdSlot adSlot3 = this.hnadsa;
        return aVarHnadsc.hnadse(adSlot3 != null ? adSlot3.getRenderType() : 0).hnadsd(hnadsg()).hnadsa();
    }

    private void hnadsa(com.hihonor.adsdk.base.g.j.d.h1.a aVar, String str, String str2, String str3) {
        a0.hnadsc(new c(str, str3, aVar, str2));
    }

    protected void hnadsa(String str, String str2, BaseAdInfoResp baseAdInfoResp) {
        String strHnadsb;
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "BaseAdLoadImpl#onLoadResult#onResult#ad loaded! code=%s, msg=%s.", str, str2);
        if (str.equals(String.valueOf(1012))) {
            hnadsa(str, str2, false);
            return;
        }
        if (hnadsa(str)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadse, " this req isTimeOut", new Object[0]);
            return;
        }
        if (!str.equals(String.valueOf(0))) {
            hnadsa(str, str2, true);
            return;
        }
        if (baseAdInfoResp != null && baseAdInfoResp.getList() != null && !baseAdInfoResp.getList().isEmpty()) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "clientReqId:%s, reqId:%s, adUnitId:%s, adList:%s", this.hnadsc, com.hihonor.adsdk.base.j.c.hnadsb(baseAdInfoResp), com.hihonor.adsdk.base.j.c.hnadsa(baseAdInfoResp), hnadsa(baseAdInfoResp.getList()));
            hnadsa(baseAdInfoResp);
            com.hihonor.adsdk.base.net.o.b.hnadsa().hnadsa(this.hnadsc, 15);
            boolean z = hnadsk() && hnadsc() == 1;
            if (z) {
                com.hihonor.adsdk.base.d.a.hnadsb().hnadsc(baseAdInfoResp.getList());
                if (!com.hihonor.adsdk.base.d.a.hnadsd) {
                    com.hihonor.adsdk.base.h.a.hnadsa().hnadsa(baseAdInfoResp, this.hnadsc);
                }
            }
            hnadso();
            hnadsc(baseAdInfoResp);
            hnadsa(q.hnadsf(str), str2, baseAdInfoResp);
            if (com.hihonor.adsdk.base.d.a.hnadsd && z) {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "PreCache save ad to db", new Object[0]);
                com.hihonor.adsdk.base.h.a.hnadsa().hnadsa(baseAdInfoResp, this.hnadsc);
            }
            com.hihonor.adsdk.base.net.o.b.hnadsa().hnadsb(this.hnadsc);
            if (hnadsk()) {
                com.hihonor.adsdk.base.d.a.hnadsb().hnadsb(hnadsc());
            }
            a0.hnadsf();
            return;
        }
        StringBuilder sb = new StringBuilder("Ad loaded,but response or ad data is empty, and reqId is : ");
        if (baseAdInfoResp != null) {
            strHnadsb = com.hihonor.adsdk.base.j.c.hnadsb(baseAdInfoResp);
        } else {
            strHnadsb = "null, client reqId is " + this.hnadsc;
        }
        hnadsa(String.valueOf(ErrorCode.RESPONSE_DATA_EMPTY), sb.append(strHnadsb).toString(), true);
    }

    private String hnadsa(List<BaseAdInfo> list) {
        StringBuilder sb = new StringBuilder("[");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append(list.get(i).getAdId());
            if (i < size - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private void hnadsa(BaseAdInfoResp baseAdInfoResp) {
        int adCount = this.hnadsa.getAdCount();
        if (adCount <= 0) {
            adCount = baseAdInfoResp.getList().size();
        }
        List<BaseAdInfo> list = baseAdInfoResp.getList();
        int size = list.size();
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "checkAdCount, adCount=%s, responseCount=%s", Integer.valueOf(adCount), Integer.valueOf(size));
        if (size <= adCount) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "ad count equals response ad count.", new Object[0]);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            if (i < adCount) {
                arrayList.add(list.get(i));
            } else {
                EventAdImpl eventAdImpl = new EventAdImpl(baseAdInfoResp.getList().get(i));
                if (eventAdImpl.getTrackUrl() != null) {
                    new t(ErrorCode.AD_LOADING_EXCESS_EXPOSURE, ErrorCode.EXCESS_EXPOSURE_MESSAGE).hnadsa(eventAdImpl, eventAdImpl.getTrackUrl().getCommons());
                }
                new s0(ErrorCode.AD_LOADING_EXCESS_EXPOSURE, "", eventAdImpl.getAdUnitId(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(eventAdImpl)).hnadse();
            }
        }
        baseAdInfoResp.setList(arrayList);
    }

    private boolean hnadsa(String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "call checkTimeOut", new Object[0]);
        if (!String.valueOf(ErrorCode.AD_LOADING_TIME_OUT).equals(str)) {
            return false;
        }
        String str2 = String.format("The ad loading process exceeded the timeout period set by the developer.The expected time is less than %s ms.", Long.valueOf(this.hnadsa.getTimeOutMillis()));
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, str2, new Object[0]);
        hnadsa(str, str2, true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int hnadsa(BaseAdInfo baseAdInfo, BaseAdInfo baseAdInfo2) {
        return (int) (baseAdInfo2.getPrice() - baseAdInfo.getPrice());
    }

    private JsonObject hnadsa(long j) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(com.hihonor.adsdk.base.g.j.e.a.K, "0");
        jsonObject.addProperty(OapsKey.KEY_PRICE, Long.valueOf(j));
        return jsonObject;
    }

    private void hnadsa(String str, String str2) {
        a0.hnadsc(new d(str, str2));
    }

    protected void hnadsa(BaseAdInfoResp baseAdInfoResp, int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "reportLoadAdChainCostTime enter.", new Object[0]);
        com.hihonor.adsdk.base.net.o.b.hnadsa().hnadsa(com.hihonor.adsdk.base.j.c.hnadsa(baseAdInfoResp), this.hnadsc, com.hihonor.adsdk.base.j.c.hnadsb(baseAdInfoResp), hnadsb(), i, hnadsc());
    }

    private void hnadsa(com.hihonor.adsdk.base.bean.b bVar, String str, com.hihonor.adsdk.base.g.j.d.h1.a aVar, String str2, String str3, String str4) {
        if (hnadsf.equals(str)) {
            new com.hihonor.adsdk.base.g.j.d.j1.d(bVar, str2, aVar).hnadse();
        }
        if (hnadsh.equals(str)) {
            new com.hihonor.adsdk.base.g.j.d.j1.c(bVar, str3, str4, str2, aVar).hnadse();
        }
    }

    private void hnadsa(String str, String str2, int i, String str3, int i2, String str4, String str5, String str6) {
        TrackAdRequest trackAdRequest = new TrackAdRequest();
        trackAdRequest.setAdUnitId(str2);
        trackAdRequest.setAdType(i);
        trackAdRequest.setMediaRequestId(str3);
        trackAdRequest.setLoadType(i2);
        trackAdRequest.setSdkVersionName("10024300");
        trackAdRequest.setThirdPlatformId(AdnConfig.b.hnadsa);
        trackAdRequest.setOaid(com.hihonor.adsdk.base.init.j.b.hnadsa().hnadsb());
        trackAdRequest.setKeyTerms(str6);
        trackAdRequest.setPackageName(HnAds.get().getContext() != null ? HnAds.get().getContext().getPackageName() : "");
        AdSlot adSlot = this.hnadsa;
        if (adSlot != null) {
            trackAdRequest.setLoadAction(String.valueOf(com.hihonor.adsdk.base.b.hnadsa(adSlot)));
            trackAdRequest.setDataType(String.valueOf(this.hnadsa.getDataType()));
        }
        trackAdRequest.setCode(str4);
        trackAdRequest.setMsg(str5);
        if (hnadsf.equals(str)) {
            new com.hihonor.adsdk.base.g.k.c.a0(trackAdRequest).hnadsa(str2, str3);
        }
        if (hnadsh.equals(str)) {
            new w(trackAdRequest).hnadsa(str2, str3);
        }
    }
}
