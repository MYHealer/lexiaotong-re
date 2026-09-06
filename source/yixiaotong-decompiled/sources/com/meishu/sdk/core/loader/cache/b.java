package com.meishu.sdk.core.loader.cache;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.domain.SdkMonitor;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.z;

/* JADX INFO: compiled from: CacheUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b {
    public void a(Context context, a aVar, String str, long j, SdkMonitor sdkMonitor) {
        try {
            if (aVar.e) {
                String[] responUrl = aVar.h.getResponUrl();
                if (responUrl != null && responUrl.length > 0) {
                    for (String str2 : responUrl) {
                        if (!TextUtils.isEmpty(str2)) {
                            z.a(context, h0.a(h0.a(h0.a(str2, str, aVar.h.getReq_id()), System.currentTimeMillis() - j)), new i());
                        }
                    }
                }
                a(aVar.h.getMonitorUrl(), str, aVar.h);
                a(aVar.h.getClickUrl(), str, aVar.h);
                a(aVar.h.getDn_active(), str, aVar.h);
                a(aVar.h.getDn_inst_start(), str, aVar.h);
                a(aVar.h.getDn_inst_succ(), str, aVar.h);
                a(aVar.h.getDn_start(), str, aVar.h);
                a(aVar.h.getDn_succ(), str, aVar.h);
                a(aVar.h.getErrorUrl(), str, aVar.h);
                a(aVar.h.getVideo_complete(), str, aVar.h);
                a(aVar.h.getVideo_mute(), str, aVar.h);
                a(aVar.h.getVideo_one_half(), str, aVar.h);
                a(aVar.h.getVideo_one_quarter(), str, aVar.h);
                a(aVar.h.getVideo_pause(), str, aVar.h);
                a(aVar.h.getVideo_replay(), str, aVar.h);
                a(aVar.h.getVideo_resume(), str, aVar.h);
                a(aVar.h.getVideo_start(), str, aVar.h);
                a(aVar.h.getVideo_three_quarter(), str, aVar.h);
                a(aVar.h.getVideo_unmute(), str, aVar.h);
                a(aVar.h.getDp_fail(), str, aVar.h);
                a(aVar.h.getDp_start(), str, aVar.h);
                a(aVar.h.getDp_succ(), str, aVar.h);
                a(aVar.h.getWx_fail(), str, aVar.h);
                a(aVar.h.getWx_start(), str, aVar.h);
                a(aVar.h.getWx_succ(), str, aVar.h);
                return;
            }
            if (sdkMonitor == null || TextUtils.isEmpty(sdkMonitor.getReq())) {
                z.a(context, h0.a(h0.a(aVar.b.getCache_req(), str, aVar.h.getReq_id())), new i());
            } else {
                z.a(context, h0.a(h0.a(a(aVar.b, sdkMonitor.getReq()), str, aVar.h.getReq_id())), new i());
            }
            if (sdkMonitor == null || TextUtils.isEmpty(sdkMonitor.getRsp())) {
                z.a(context, h0.a(h0.a(aVar.b.getCache_rsp(), str, aVar.h.getReq_id())), new i());
                z.a(context, h0.a(h0.a(h0.a(aVar.b.getFinalRsp(), str, aVar.h.getReq_id()), System.currentTimeMillis() - j)), new i());
            } else {
                String strA = a(aVar.b, sdkMonitor.getRsp().replace(com.hihonor.adsdk.base.g.j.e.c.hnadsv, "ssp" + Base64.encodeToString(String.valueOf(aVar.b.getOriginEcpm() * 10).getBytes(), 2)).replace("__S__", aVar.b.get_s()));
                String strA2 = h0.a(strA.replace("__PST__", aVar.b.get_pst()), str, aVar.h.getReq_id());
                String strA3 = h0.a(strA, str, aVar.h.getReq_id());
                z.a(context, h0.a(strA2), new i());
                z.a(context, h0.a(h0.a(strA3, System.currentTimeMillis() - j)), new i());
            }
            if (sdkMonitor == null || TextUtils.isEmpty(sdkMonitor.getImp())) {
                aVar.b.setImp(h0.a(aVar.b.getCache_imp(), str, aVar.h.getReq_id()));
            } else {
                aVar.b.setImp(h0.a(a(aVar.b, sdkMonitor.getImp()).replace(com.hihonor.adsdk.base.g.j.e.c.hnadsv, "ssp" + Base64.encodeToString(String.valueOf(aVar.b.getOriginEcpm() * 10).getBytes(), 2)).replace("__PRE__", "ssp" + Base64.encodeToString(String.valueOf(aVar.b.getEcpm() * 10).getBytes(), 2)), str, aVar.h.getReq_id()));
            }
            if (sdkMonitor == null || TextUtils.isEmpty(sdkMonitor.getClk())) {
                aVar.b.setClk(h0.a(aVar.b.getCache_clk(), str, aVar.h.getReq_id()));
            } else {
                aVar.b.setClk(h0.a(a(aVar.b, h0.a(sdkMonitor.getClk().replace("__S__", aVar.b.get_s()).replace("__PST__", aVar.b.get_pst()).replace(com.hihonor.adsdk.base.g.j.e.c.hnadsv, "ssp" + Base64.encodeToString(String.valueOf(aVar.b.getOriginEcpm() * 10).getBytes(), 2)).replace("__PRE__", "ssp" + Base64.encodeToString(String.valueOf(aVar.b.getEcpm() * 10).getBytes(), 2)), str, aVar.h.getReq_id())), str, aVar.h.getReq_id()));
            }
            if (sdkMonitor != null && !TextUtils.isEmpty(sdkMonitor.getErr())) {
                String strReplace = sdkMonitor.getErr().replace(com.hihonor.adsdk.base.g.j.e.c.hnadsv, aVar.b.getOriginEcpm() + "").replace("__S__", aVar.b.get_s());
                if (TextUtils.isEmpty(aVar.b.get_err_pst())) {
                    strReplace = strReplace.replace("__PST__", aVar.b.get_err_pst());
                }
                aVar.b.setErr(h0.a(a(aVar.b, strReplace), str, aVar.h.getReq_id()));
                return;
            }
            aVar.b.setErr(h0.a(aVar.b.getCache_err(), str, aVar.h.getReq_id()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void a(String[] strArr, String str, MeishuAdInfo meishuAdInfo) {
        String req_id = meishuAdInfo.getReq_id();
        if (strArr != null) {
            for (int i = 0; i < strArr.length; i++) {
                String str2 = strArr[i];
                if (!TextUtils.isEmpty(str2)) {
                    strArr[i] = h0.a(str2, str, req_id);
                }
            }
            meishuAdInfo.setClickUrl(strArr);
        }
    }

    public final String a(SdkAdInfo sdkAdInfo, String str) {
        String[] strArr = {"__ACCEPT_ID__", "__STRATEGY_DEALID__", "__ACCEPT_APPID__", "__ACCEPT_PID__", "__SDK__", "__GROUP_ID__", "__P__", "__TIMEOUT__"};
        String[] strArr2 = new String[8];
        strArr2[0] = sdkAdInfo.getAccept_id() == null ? "" : sdkAdInfo.getAccept_id();
        strArr2[1] = sdkAdInfo.getStrategy_dealid() == null ? "" : sdkAdInfo.getStrategy_dealid();
        strArr2[2] = sdkAdInfo.getApp_id() == null ? "" : sdkAdInfo.getApp_id();
        strArr2[3] = sdkAdInfo.getPid() == null ? "" : sdkAdInfo.getPid();
        strArr2[4] = sdkAdInfo.getSdk() == null ? "" : sdkAdInfo.getSdk();
        strArr2[5] = sdkAdInfo.getGroup_id() != null ? sdkAdInfo.getGroup_id() : "";
        strArr2[6] = String.valueOf(sdkAdInfo.getPrice());
        strArr2[7] = String.valueOf(0);
        return TextUtils.replace(str, strArr, strArr2).toString();
    }
}
