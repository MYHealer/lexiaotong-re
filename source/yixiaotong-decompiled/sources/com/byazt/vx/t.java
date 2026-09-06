package com.byazt.vx;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 962, 66})
public class t {
    public static com.byazt.pp.ve c(com.byazt.ll.tt ttVar, com.byazt.yl.ve veVar, boolean z) {
        if (veVar == null || ttVar == null) {
            return null;
        }
        com.byazt.pp.ve veVar2 = new com.byazt.pp.ve();
        veVar2.c(veVar.getAdNetworkPlatformId());
        veVar2.x(veVar.getAdNetWorkName());
        veVar2.i(veVar.getCustomAdNetWorkName());
        veVar2.da(veVar.getAdNetworkSlotId());
        veVar2.u(veVar.getLevelTag());
        if (z) {
            if (!c() && (veVar.isServerBiddingAd() || veVar.isClientBiddingAd() || veVar.isMultiBiddingAd())) {
                veVar2.sl("-3");
            } else {
                veVar2.sl(veVar.getNetWorkPlatFormCpm());
            }
        } else if (!tt() && veVar.isServerBiddingAd()) {
            veVar2.sl("-3");
        } else {
            veVar2.sl(veVar.getMultiCpm());
        }
        veVar2.z(veVar.getReqId());
        veVar2.tt(veVar.getAdNetworkSlotType());
        veVar2.yp(veVar.getErrorMsg());
        veVar2.c(tt(ttVar));
        veVar2.tt(c(veVar));
        veVar2.sp(ttVar != null ? ttVar.rl() : null);
        veVar2.a(c(ttVar));
        veVar2.ve(new StringBuilder().append(ttVar.lo()).toString());
        com.byazt.yf.a aVarRl = com.byazt.bp.c.t().rl();
        veVar2.uj(aVarRl != null ? aVarRl.ve() : null);
        veVar2.n(aVarRl != null ? aVarRl.uj() : null);
        Map<String, Object> mapCu = ttVar != null ? ttVar.cu() : null;
        if (mapCu != null && !mapCu.isEmpty()) {
            HashMap map = new HashMap();
            for (Map.Entry<String, Object> entry : mapCu.entrySet()) {
                Object value = entry.getValue();
                map.put(entry.getKey(), value == null ? null : value.toString());
            }
            veVar2.c(map);
        }
        veVar2.t(veVar.getDiscount());
        return veVar2;
    }

    private static String c(com.byazt.ll.tt ttVar) {
        com.byazt.nbs.tt ttVarC;
        if (ttVar == null || com.byazt.ck.tt.c().x() != 1 || (ttVarC = com.byazt.ck.uj.c().c(ttVar.gt(), ttVar.my(), 102)) == null || ttVarC.ve() == 1) {
            return null;
        }
        String strL = ttVar.l();
        if (TextUtils.isEmpty(strL)) {
            return null;
        }
        try {
            return new JSONObject(strL).optString("experiment_detail_id");
        } catch (JSONException e) {
            com.byazt.nr.m.c(e);
            return null;
        }
    }

    private static String tt(com.byazt.ll.tt ttVar) {
        if (ttVar == null) {
            return null;
        }
        switch (ttVar.my()) {
            case 1:
                return "banner";
            case 2:
                return MediationConstant.RIT_TYPE_INTERSTITIAL;
            case 3:
                return MediationConstant.RIT_TYPE_SPLASH;
            case 4:
            case 6:
            default:
                return null;
            case 5:
                return "feed";
            case 7:
                return MediationConstant.RIT_TYPE_REWARD_VIDEO;
            case 8:
                return MediationConstant.RIT_TYPE_FULL_VIDEO;
            case 9:
                return MediationConstant.RIT_TYPE_DRAW;
            case 10:
                return MediationConstant.RIT_TYPE_INTERSTITIAL_FULL;
        }
    }

    private static String c(com.byazt.yl.ve veVar) {
        if (veVar == null) {
            return null;
        }
        switch (veVar.getSubAdType()) {
            case 1:
            case 8:
                return MediationConstant.RIT_TYPE_INTERSTITIAL;
            case 2:
            case 7:
                return MediationConstant.RIT_TYPE_FULL_VIDEO;
            case 3:
                return "banner";
            case 4:
                return "feed";
            case 5:
                return MediationConstant.RIT_TYPE_DRAW;
            case 6:
                return MediationConstant.RIT_TYPE_REWARD_VIDEO;
            default:
                int adType = veVar.getAdType();
                if (adType == 1) {
                    return "banner";
                }
                if (adType == 5) {
                    return "feed";
                }
                if (adType != 7) {
                    return null;
                }
                return MediationConstant.RIT_TYPE_REWARD_VIDEO;
        }
    }

    private static boolean c() {
        return com.byazt.bp.tt.tt().zb();
    }

    private static boolean tt() {
        return com.byazt.bp.tt.tt().cu();
    }

    public static boolean c(List<com.byazt.yl.ve> list, List<com.byazt.yl.ve> list2, List<com.byazt.yl.ve> list3, com.byazt.ll.tt ttVar, boolean z, String str, int i, List<com.byazt.nbs.da> list4) {
        int iTt = com.byazt.hz.tt.tt(str);
        com.byazt.ng.a.c(list, list2, list3, ttVar, iTt);
        if (z || iTt != 0) {
            return false;
        }
        if (list.size() > 0) {
            for (com.byazt.yl.ve veVar : list) {
                if (veVar != null) {
                    com.byazt.eu.tt.c("TTMediationSDK", com.byazt.eu.uj.tt(str, veVar.getAdNetworkSlotId()) + "isReady-》广告类型：" + com.byazt.yl.c.c(veVar.getAdNetworkPlatformId()) + ",是否已准备好？isReady()：" + veVar.isReady(str));
                    if (veVar.isReady(str) && !veVar.isHasShown()) {
                        return true;
                    }
                }
            }
        }
        if (list3 != null && list3.size() > 0) {
            for (com.byazt.yl.ve veVar2 : list3) {
                if (veVar2 != null) {
                    com.byazt.eu.tt.c("TTMediationSDK", com.byazt.eu.uj.tt(str, veVar2.getAdNetworkSlotId()) + "isReady-》广告类型：" + com.byazt.yl.c.c(veVar2.getAdNetworkPlatformId()) + ",是否已准备好？isReady()：" + veVar2.isReady(str));
                    if (veVar2.isReady(str) && !veVar2.isHasShown()) {
                        return true;
                    }
                }
            }
        }
        if (list2 != null && list2.size() > 0) {
            for (com.byazt.yl.ve veVar3 : list2) {
                if (veVar3 != null) {
                    com.byazt.eu.tt.c("TTMediationSDK", com.byazt.eu.uj.tt(str, veVar3.getAdNetworkSlotId()) + "isReady--->biding-->广告类型：" + com.byazt.yl.c.c(veVar3.getAdNetworkPlatformId()) + ",是否已准备好？isReady()：" + veVar3.isReady(str));
                    if (veVar3.isReady(str) && !veVar3.isHasShown()) {
                        return true;
                    }
                }
            }
        }
        if (list4 != null && list4.size() > 0) {
            for (com.byazt.nbs.da daVar : list4) {
                String strRh = daVar.rh();
                if (daVar.gt() && com.byazt.hk.c.c().uj(str, strRh, i) && com.byazt.hk.c.c().c(strRh, ttVar, false) == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean c(Map<String, Object> map) {
        if (map == null) {
            return false;
        }
        Object obj = map.get("show_adn_load_error_detail");
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public static com.byazt.pp.c c(com.byazt.ll.tt ttVar, com.byazt.pp.c cVar, List<com.byazt.pp.tt> list) {
        if (cVar == null || ttVar == null || list == null || list.size() == 0 || !c(ttVar.cu())) {
            return cVar;
        }
        JSONArray jSONArray = new JSONArray();
        for (com.byazt.pp.tt ttVar2 : list) {
            if (ttVar2 != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(MediationConstant.EXTRA_ADN_NAME, TextUtils.isEmpty(ttVar2.ve()) ? ttVar2.uj() : ttVar2.ve());
                    jSONObject.put("mediation_rit", ttVar2.tt());
                    jSONObject.put("ad_type", ttVar2.c());
                    jSONObject.put("error_code", ttVar2.n());
                    jSONObject.put(com.hihonor.adsdk.base.g.j.e.a.hnadst, ttVar2.a());
                    jSONArray.put(jSONObject);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        cVar.tt = jSONArray.toString();
        return cVar;
    }
}
