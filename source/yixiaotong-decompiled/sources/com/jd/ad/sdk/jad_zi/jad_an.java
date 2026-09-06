package com.jd.ad.sdk.jad_zi;

import android.text.TextUtils;
import android.util.Log;
import com.jd.ad.sdk.bl.adload.JADAdLoadListener;
import com.jd.ad.sdk.bl.initsdk.JADYunSdk;
import com.jd.ad.sdk.dl.addata.JADMaterialData;
import com.jd.ad.sdk.dl.model.IJADExtra;
import com.jd.ad.sdk.dl.model.JADExtra;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.fdt.thread.WorkExecutor;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.mdt.service.JADAdService;
import com.jd.ad.sdk.mdt.service.JADEventService;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;

/* JADX INFO: compiled from: JADAdServiceImplementor.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_an implements JADAdService {
    public final ConcurrentHashMap<String, com.jd.ad.sdk.jad_jt.jad_jt> jad_an = new ConcurrentHashMap<>();
    public final ConcurrentHashMap<String, ArrayList<com.jd.ad.sdk.jad_jt.jad_jt>> jad_bo = new ConcurrentHashMap<>();

    @Override // com.jd.ad.sdk.mdt.service.JADAdService
    public boolean enablePreloadAd(String str, JADSlot jADSlot) {
        if (this.jad_an.get(str) == null) {
            return false;
        }
        ArrayList<com.jd.ad.sdk.jad_jt.jad_jt> arrayList = this.jad_bo.get(jADSlot.getSlotID());
        return arrayList == null || arrayList.size() < com.jd.ad.sdk.jad_kx.jad_er.jad_an.jad_an.jad_an();
    }

    @Override // com.jd.ad.sdk.mdt.service.JADAdService
    public IJADExtra getJADExtra(String str) {
        IJADExtra iJADExtra = com.jd.ad.sdk.jad_na.jad_cp.jad_an.jad_an.jad_bo.get(str);
        return iJADExtra == null ? new JADExtra() : iJADExtra;
    }

    @Override // com.jd.ad.sdk.mdt.service.JADAdService
    public List<JADMaterialData> getJADMaterialDataList(String str) {
        com.jd.ad.sdk.jad_yl.jad_jt jad_jtVarJad_an;
        List<com.jd.ad.sdk.jad_yl.jad_fs> list;
        com.jd.ad.sdk.jad_yl.jad_hu jad_huVar;
        List<com.jd.ad.sdk.jad_yl.jad_dq> list2;
        com.jd.ad.sdk.jad_yl.jad_dq jad_dqVar;
        ArrayList arrayList = new ArrayList();
        String str2 = com.jd.ad.sdk.jad_na.jad_cp.jad_an.jad_an.jad_an.get(str);
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        com.jd.ad.sdk.jad_yl.jad_cp jad_cpVar = null;
        if (TextUtils.isEmpty(str2)) {
            jad_jtVarJad_an = null;
        } else {
            try {
                jad_jtVarJad_an = com.jd.ad.sdk.jad_yl.jad_jt.jad_an(str2);
            } catch (JSONException e) {
                e.printStackTrace();
                jad_jtVarJad_an = null;
            }
        }
        if (jad_jtVarJad_an != null && (jad_huVar = jad_jtVarJad_an.jad_cp) != null && (list2 = jad_huVar.jad_an) != null && !list2.isEmpty() && (jad_dqVar = list2.get(0)) != null) {
            jad_cpVar = jad_dqVar.jad_bo;
        }
        if (jad_cpVar != null && (list = jad_cpVar.jad_an) != null && !list.isEmpty()) {
            for (com.jd.ad.sdk.jad_yl.jad_fs jad_fsVar : list) {
                if (jad_fsVar != null) {
                    com.jd.ad.sdk.jad_na.jad_an jad_anVar = new com.jd.ad.sdk.jad_na.jad_an();
                    jad_anVar.jad_an = jad_fsVar.jad_an;
                    jad_anVar.jad_bo = jad_fsVar.jad_bo;
                    jad_anVar.jad_dq = jad_fsVar.jad_iv;
                    jad_anVar.jad_fs = jad_fsVar.jad_mz;
                    jad_anVar.jad_jt = jad_fsVar.jad_ly;
                    jad_anVar.jad_hu = jad_cpVar.jad_cp;
                    jad_anVar.jad_iv = jad_cpVar.jad_er;
                    jad_anVar.jad_kx = jad_fsVar.jad_hu;
                    jad_anVar.jad_jw = jad_fsVar.jad_jt;
                    jad_anVar.jad_er = jad_fsVar.jad_na;
                    jad_anVar.jad_ob = jad_fsVar.jad_re;
                    jad_anVar.jad_pc = jad_fsVar.jad_sf;
                    jad_anVar.jad_ly = jad_fsVar.jad_ob;
                    jad_anVar.jad_mz = jad_fsVar.jad_pc;
                    jad_anVar.jad_na = jad_fsVar.jad_qd;
                    ArrayList arrayList2 = new ArrayList();
                    if (TextUtils.isEmpty(jad_fsVar.jad_er) || jad_cpVar.jad_cp == 10005) {
                        List<com.jd.ad.sdk.jad_yl.jad_er> list3 = jad_fsVar.jad_fs;
                        if (list3 != null && !list3.isEmpty()) {
                            for (com.jd.ad.sdk.jad_yl.jad_er jad_erVar : list3) {
                                if (jad_erVar != null && !TextUtils.isEmpty(jad_erVar.jad_an)) {
                                    arrayList2.add(jad_erVar.jad_an);
                                }
                            }
                        }
                    } else {
                        arrayList2.add(jad_fsVar.jad_er);
                    }
                    jad_anVar.jad_cp = arrayList2;
                    arrayList.add(jad_anVar);
                }
            }
        }
        return arrayList;
    }

    @Override // com.jd.ad.sdk.mdt.service.JADAdService
    public void loadAd(String str, JADSlot jADSlot, JADAdLoadListener jADAdLoadListener) {
        com.jd.ad.sdk.jad_jt.jad_jt jad_jtVar = this.jad_an.get(str);
        if (jad_jtVar == null) {
            JADEventService eventService = JADMediator.getInstance().getEventService();
            String requestId = jADSlot.getRequestId();
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_REGISTER_AD_SERVICE_ERROR;
            eventService.reportRequestErrorEvent(requestId, jad_anVar.jad_an, jad_anVar.jad_an(new String[0]));
            jADAdLoadListener.onLoadFailure(jad_anVar.jad_an, jad_anVar.jad_an(new String[0]));
            return;
        }
        String requestId2 = jADSlot.getRequestId();
        try {
            if (jADSlot.getAdDataRequestSourceType() == 0) {
                if (jad_jtVar.jad_an == 2) {
                    return;
                }
            } else if (!JADMediator.getInstance().getAdService().enablePreloadAd(str, jADSlot)) {
                return;
            } else {
                JADMediator.getInstance().getAdService().registerAdPreloader(str, jADSlot);
            }
            if (jad_jtVar.jad_an(jADSlot, jADAdLoadListener)) {
                WorkExecutor.execute(new com.jd.ad.sdk.jad_jt.jad_an(jad_jtVar, jADSlot, jADAdLoadListener, requestId2, str));
            }
        } catch (Exception e) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_OTHER_ERROR;
            jad_jtVar.jad_an(jADAdLoadListener, jad_anVar2.jad_an, jad_anVar2.jad_an(new String[0]));
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an(requestId2, 3, jad_anVar2.jad_an, jad_jtVar.jad_an(jADSlot.getSlotID(), jADSlot.getAdType(), jad_anVar2.jad_an(e.getMessage())), jADSlot.getSen());
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADAdService
    public void loadAdFromCache(String str, JADSlot jADSlot, JADAdLoadListener jADAdLoadListener) {
        com.jd.ad.sdk.jad_jt.jad_jt jad_jtVar = this.jad_an.get(str);
        if (jad_jtVar == null || jADSlot == null) {
            return;
        }
        try {
            if (jad_jtVar.jad_an == 1) {
                return;
            }
            jADSlot.setAdDataRequestSourceType(2);
            WorkExecutor.execute(new com.jd.ad.sdk.jad_jt.jad_bo(jad_jtVar, jADSlot, str, jADAdLoadListener));
        } catch (Exception e) {
            Logger.d(com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while preload ad load from cache failed:").append(Log.getStackTraceString(e)).toString());
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADAdService
    public synchronized void printRequestData(JADSlot jADSlot) {
        String string;
        if (JADYunSdk.isEnableLog()) {
            String adUrl = JADMediator.getInstance().getInitService().getAdUrl(jADSlot.getSlotID());
            byte[] bArrJad_bo = com.jd.ad.sdk.jad_jt.jad_hu.jad_bo(jADSlot);
            if (bArrJad_bo != null) {
                String str = new String(bArrJad_bo);
                if (!TextUtils.isEmpty(str)) {
                    HashMap map = new HashMap(3);
                    map.put("Content-Type", "application/json");
                    map.put("User-Agent", com.jd.ad.sdk.jad_qd.jad_hu.jad_dq());
                    map.put("sdkxid", "default");
                    if (TextUtils.isEmpty(adUrl) || TextUtils.isEmpty(str)) {
                        Logger.w("url or requestData is empty", new Object[0]);
                        string = "";
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("curl -v ");
                        for (Map.Entry entry : map.entrySet()) {
                            sb.append("-H '" + ((String) entry.getKey()) + ": " + ((String) entry.getValue()) + "' ");
                        }
                        sb.append("-d '" + str + "' ");
                        sb.append("'" + adUrl + "'");
                        string = sb.toString();
                    }
                    Logger.w(string, new Object[0]);
                }
            }
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADAdService
    public void registerAd(String str) {
        if (this.jad_an.get(str) == null) {
            this.jad_an.put(str, new com.jd.ad.sdk.jad_jt.jad_jt());
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADAdService
    public void registerAdPreloader(String str, JADSlot jADSlot) {
        com.jd.ad.sdk.jad_jt.jad_jt jad_jtVar = this.jad_an.get(str);
        if (jad_jtVar != null) {
            ArrayList<com.jd.ad.sdk.jad_jt.jad_jt> arrayList = this.jad_bo.get(jADSlot.getSlotID());
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(jad_jtVar);
            this.jad_bo.put(jADSlot.getSlotID(), arrayList);
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADAdService
    public void removeData(String str) {
        com.jd.ad.sdk.jad_na.jad_cp jad_cpVar = com.jd.ad.sdk.jad_na.jad_cp.jad_an.jad_an;
        jad_cpVar.jad_an.remove(str);
        jad_cpVar.jad_bo.remove(str);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADAdService
    public void unregisterAd(String str) {
        if (this.jad_an.get(str) == null) {
            return;
        }
        this.jad_an.remove(str);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADAdService
    public void unregisterAdPreloader(String str, JADSlot jADSlot) {
        ArrayList<com.jd.ad.sdk.jad_jt.jad_jt> arrayList;
        com.jd.ad.sdk.jad_jt.jad_jt jad_jtVar = this.jad_an.get(str);
        if (jad_jtVar == null || (arrayList = this.jad_bo.get(jADSlot.getSlotID())) == null || arrayList.size() <= 0) {
            return;
        }
        arrayList.remove(jad_jtVar);
        this.jad_bo.put(jADSlot.getSlotID(), arrayList);
    }
}
