package com.ubixnow.network.kuaishou;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsCustomController;
import com.kwad.sdk.api.KsInitCallback;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.SdkConfig;
import com.ubixnow.core.api.UMNAdManager;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.j1;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00O0O0O;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.o0O0ooO;
import com.ubixnow.ooooo.o0OO000o;
import com.ubixnow.ooooo.oO0OO00;
import com.ubixnow.ooooo.oO0OO0O;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.oOo00o00;
import com.ubixnow.ooooo.oo00o;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class KsInitManager extends o00O0O0O {
    private static Map<o00O0OO0, o00O000> OooO0o = new HashMap();
    private static KsInitManager OooO0o0;
    private int OooO;
    private String OooO0oO = "-----KsInitManager";
    private SdkConfig.Builder OooO0oo;

    private void OooO00o(o00O000 o00o000) {
        JSONObject jSONObjectOptJSONObject;
        try {
            if (!TextUtils.isEmpty(o00o000.OooO00o.OooOOO0) && (jSONObjectOptJSONObject = new JSONObject(o00o000.OooO00o.OooOOO0).optJSONObject("advCo")) != null) {
                String strOptString = jSONObjectOptJSONObject.optString("ks_conf_support_sdk_vers");
                if (!TextUtils.isEmpty(strOptString)) {
                    String[] strArrSplit = strOptString.split(",");
                    if (strArrSplit.length > 0 && !TextUtils.isEmpty(getVersion()) && Arrays.asList(strArrSplit).contains(getVersion())) {
                        this.OooO = 1;
                        ooooO000.OooO0O0(this.OooO0oO, "ksConfigStatus: " + this.OooO);
                        return;
                    }
                }
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
        this.OooO = 2;
        ooooO000.OooO0O0(this.OooO0oO, "ksConfigStatus: " + this.OooO);
    }

    public static synchronized KsInitManager getInstance() {
        if (OooO0o0 == null) {
            OooO0o0 = new KsInitManager();
        }
        return OooO0o0;
    }

    public static long getKSLongValue(String str) {
        try {
            if (!TextUtils.isEmpty(str) && str.length() > 1 && (str.endsWith("L") || str.endsWith(t.d))) {
                str = str.substring(0, str.length() - 1);
            }
            return Long.parseLong(str);
        } catch (Exception unused) {
            return -1L;
        }
    }

    public void getBiddingToken(Context context, final o00O000 o00o000, final oo00o oo00oVar, final o00O00o0 o00o00o0) {
        initSDK(context, o00o000, new o00O0OO0() { // from class: com.ubixnow.network.kuaishou.KsInitManager.3
            @Override // com.ubixnow.ooooo.o00O0OO0
            public void onError(Throwable th) {
                o00O00o0 o00o00o1 = o00o00o0;
                if (o00o00o1 != null) {
                    o00o00o1.getTokenFail(new ErrorInfo("500041", KsInitManager.getInstance().getName() + oOO00O0.ubix_initError_msg + th.getMessage()));
                }
            }

            @Override // com.ubixnow.ooooo.o00O0OO0
            public void onSuccess() {
                String bidRequestToken = KsAdSDK.getLoadManager().getBidRequestToken(new KsScene.Builder(KsInitManager.getKSLongValue(KsInitManager.this.OooO0Oo.OooO00o.OooO0o0)).adNum(1).build());
                if (o00o00o0 != null) {
                    if (TextUtils.isEmpty(bidRequestToken)) {
                        o00o00o0.getTokenFail(new ErrorInfo(o0OO000o.o00O0ooo, o0OO000o.o00O));
                    } else {
                        o00o000.OooOOO = bidRequestToken;
                        o00o00o0.getTokenSucc(oo00oVar);
                    }
                }
            }
        });
    }

    public String getName() {
        return "KUAISHOU";
    }

    @Override // com.ubixnow.ooooo.o00O0O0O
    public String getVersion() {
        try {
            return KsAdSDK.getSDKVersion();
        } catch (Exception e) {
            ooooO000.OooO00o(e);
            return "";
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0096 A[Catch: all -> 0x009a, TRY_LEAVE, TryCatch #1 {all -> 0x009a, blocks: (B:5:0x0008, B:7:0x000c, B:8:0x000f, B:10:0x0014, B:16:0x0023, B:18:0x0029, B:23:0x0044, B:25:0x0084, B:29:0x0096, B:19:0x002e, B:21:0x0034, B:22:0x0039, B:15:0x0020, B:26:0x0088, B:28:0x008e, B:12:0x001a), top: B:39:0x0008, outer: #0, inners: #2 }] */
    public synchronized void initNewSDK(o00O000 o00o000, o00O0OO0 o00o0oo0) {
        String str;
        boolean zIsNeedInit;
        OooO0o.put(o00o0oo0, o00o000);
        try {
            if (this.OooO == 0) {
                OooO00o(o00o000);
            }
            if (this.OooO == 1) {
                String str2 = o00o000.OooOO0.OooO;
                String appId = "";
                try {
                    appId = KsAdSDK.getAppId();
                } catch (Throwable th) {
                    ooooO000.OooO00o(th);
                }
                if (!TextUtils.isEmpty(str2)) {
                    zIsNeedInit = true ^ this.OooO0O0;
                    str = str2;
                } else if (TextUtils.isEmpty(appId)) {
                    str = o00o000.OooO00o.OooO0Oo;
                    zIsNeedInit = isNeedInit(o00o000);
                } else {
                    zIsNeedInit = true ^ this.OooO0O0;
                    str = appId;
                }
                ooooO000.OooO0O0(this.OooO0oO, "ubix app id: " + o00o000.OooO00o.OooO0Oo + " strategy app id:" + str2 + " last app id:" + appId + "final app id:" + str + " need init:" + zIsNeedInit);
                if (zIsNeedInit) {
                    realInit(o00o000, str);
                } else {
                    onSucces();
                }
            } else if (isNeedInit(o00o000)) {
                realInit(o00o000, o00o000.OooO00o.OooO0Oo);
            } else {
                onSucces();
            }
        } catch (Throwable th2) {
            ooooO000.OooO00o(th2);
            trackingAdsInitFail(o00o000, "-1", th2.getMessage());
            onError(new Exception(th2));
        }
    }

    @Override // com.ubixnow.ooooo.o00O0O0O
    public synchronized void initSDK(Context context, o00O000 o00o000) {
        super.initSDK(context, o00o000);
        initSDK(context, o00o000, null);
    }

    @Override // com.ubixnow.ooooo.o00O0O0O
    public synchronized void initSDK(Context context, o00O000 o00o000, o00O0OO0 o00o0oo0) {
        super.initSDK(context, o00o000, o00o0oo0);
        try {
            initNewSDK(o00o000, o00o0oo0);
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    public synchronized void initSdkConfig(String str) {
        this.OooO0oo = new SdkConfig.Builder().customController(new KsCustomController() { // from class: com.ubixnow.network.kuaishou.KsInitManager.1
            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canReadInstalledPackages() {
                return j1.OooO0oo;
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canReadLocation() {
                return j1.OooO00o;
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canUseMacAddress() {
                return j1.OooO0o0;
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canUseNetworkState() {
                return j1.OooO0oO;
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canUseOaid() {
                return j1.OooO0Oo;
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canUsePhoneState() {
                return j1.OooO0O0;
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public boolean canUseStoragePermission() {
                return j1.OooO0o;
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public String getAndroidId() {
                return !TextUtils.isEmpty(j1.OooOOO) ? j1.OooOOO : super.getAndroidId();
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public String getImei() {
                return !TextUtils.isEmpty(j1.OooOO0o) ? j1.OooOO0o : super.getImei();
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public String[] getImeis() {
                return super.getImeis();
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public List<String> getInstalledPackages() {
                HashSet hashSet = new HashSet();
                List<String> list = j1.OooOOOo;
                if (list != null && !list.isEmpty()) {
                    hashSet.addAll(j1.OooOOOo);
                }
                if (!o0O0ooO.OooO0Oo.isEmpty()) {
                    hashSet.addAll(o0O0ooO.OooO0Oo);
                }
                return new ArrayList(hashSet);
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public Location getLocation() {
                Location location = j1.OooOO0O;
                return location != null ? location : super.getLocation();
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public String getMacAddress() {
                return !TextUtils.isEmpty(j1.OooOOO0) ? j1.OooOOO0 : super.getMacAddress();
            }

            @Override // com.kwad.sdk.api.KsCustomController
            public String getOaid() {
                if (!TextUtils.isEmpty(j1.OooOOOO)) {
                    return j1.OooOOOO;
                }
                String strOooO0o0 = oOo00o00.OooO0o0("oaid");
                return !TextUtils.isEmpty(strOooO0o0) ? strOooO0o0 : super.getOaid();
            }
        }).appId(str).canReadNearbyWifiList(j1.OooO0oO).debug(UMNAdManager.getInstance().getConfig().isDebug).showNotification(true);
    }

    public synchronized void onError(Throwable th) {
        try {
            Iterator<Map.Entry<o00O0OO0, o00O000>> it = OooO0o.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<o00O0OO0, o00O000> next = it.next();
                ooooO000.OooO0O0(this.OooO0oO, "ks init fail");
                next.getKey().onError(th);
                it.remove();
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    public synchronized void onSucces() {
        try {
            Iterator<Map.Entry<o00O0OO0, o00O000>> it = OooO0o.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<o00O0OO0, o00O000> next = it.next();
                ooooO000.OooO0O0(this.OooO0oO, "ks init succ");
                trackRedirectStart(next.getValue());
                try {
                    if (ooooO000.OooO00o) {
                        ooooO000.OooO0O0(this.OooO0oO, KsAdSDK.getLoadManager().getClass().getClassLoader().hashCode() + PPSLabelView.Code + getClass().getClassLoader().hashCode());
                    }
                    if (KsAdSDK.getLoadManager().getClass().getClassLoader().hashCode() == getClass().getClassLoader().hashCode()) {
                        oO0OO0O.OooO00o(next.getValue(), getVersion());
                    } else {
                        oO0OO0O.OooO00o(next.getValue(), getVersion());
                        oO0OO00.OooO00o(next.getValue(), getVersion(), KsAdSDK.getLoadManager().getClass().getClassLoader());
                    }
                } catch (Throwable unused) {
                }
                next.getKey().onSuccess();
                it.remove();
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    public void realInit(final o00O000 o00o000, String str) {
        trackSdkInitStart(o00o000);
        initSdkConfig(str);
        KsAdSDK.init(BaseUtils.getContext(), this.OooO0oo.setStartCallback(new KsInitCallback() { // from class: com.ubixnow.network.kuaishou.KsInitManager.2
            @Override // com.kwad.sdk.api.KsInitCallback
            public void onFail(int i, String str2) {
                ooooO000.OooO0O0(KsInitManager.this.OooO0oO, "ks callback onFail:" + str2);
                KsInitManager.this.trackingAdsInitFail(o00o000, i + "", str2 + "");
                KsInitManager.this.onError(new Exception(str2));
            }

            @Override // com.kwad.sdk.api.KsInitCallback
            public void onSuccess() {
                ooooO000.OooO0O0(KsInitManager.this.OooO0oO, "ks callback succ");
                KsInitManager.this.OooO0O0 = true;
                KsInitManager.this.trackingAdsInitSucc(o00o000);
                KsInitManager.this.onSucces();
            }
        }).build());
        KsAdSDK.start();
        KsAdSDK.setPersonalRecommend(j1.OooO);
        KsAdSDK.setProgrammaticRecommend(j1.OooOO0);
    }
}
