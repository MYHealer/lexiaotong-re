package com.jd.ad.sdk.jad_jt;

import android.text.TextUtils;
import com.jd.ad.sdk.bl.adload.JADAdLoadListener;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.fdt.utils.ANEProxy;
import com.jd.ad.sdk.fdt.utils.ConversionUtils;
import com.jd.ad.sdk.fdt.utils.HandlerUtils;
import com.jd.ad.sdk.jad_zm.jad_ly;
import com.jd.ad.sdk.jad_zm.jad_mz;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import java.io.IOException;
import org.json.JSONException;

/* JADX INFO: compiled from: JADLoader.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_an implements Runnable {
    public final /* synthetic */ JADSlot jad_an;
    public final /* synthetic */ JADAdLoadListener jad_bo;
    public final /* synthetic */ String jad_cp;
    public final /* synthetic */ String jad_dq;
    public final /* synthetic */ jad_jt jad_er;

    public jad_an(jad_jt jad_jtVar, JADSlot jADSlot, JADAdLoadListener jADAdLoadListener, String str, String str2) {
        this.jad_er = jad_jtVar;
        this.jad_an = jADSlot;
        this.jad_bo = jADAdLoadListener;
        this.jad_cp = str;
        this.jad_dq = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        jad_jt.jad_an(this.jad_er, this.jad_an);
        com.jd.ad.sdk.jad_pc.jad_cp jad_cpVarJad_cp = com.jd.ad.sdk.jad_re.jad_an.jad_cp();
        String strJad_an = jad_hu.jad_an(jad_cpVarJad_cp, this.jad_an.getSlotID());
        Logger.d("loadAd URl: " + strJad_an);
        if (TextUtils.isEmpty(strJad_an)) {
            jad_jt jad_jtVar = this.jad_er;
            JADAdLoadListener jADAdLoadListener = this.jad_bo;
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_URL_IS_NULL_ERROR;
            jad_jtVar.jad_an(jADAdLoadListener, jad_anVar.jad_an, jad_anVar.jad_an(new String[0]));
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an(this.jad_cp, 7, jad_anVar.jad_an, this.jad_er.jad_an(this.jad_an.getSlotID(), this.jad_an.getAdType(), jad_anVar.jad_an(new String[0])), 0);
            return;
        }
        com.jd.ad.sdk.jad_zm.jad_er jad_erVar = new com.jd.ad.sdk.jad_zm.jad_er(jad_hu.jad_bo(this.jad_an));
        com.jd.ad.sdk.jad_zm.jad_fs jad_fsVar = new com.jd.ad.sdk.jad_zm.jad_fs();
        jad_fsVar.jad_bo("User-Agent", com.jd.ad.sdk.jad_qd.jad_hu.jad_dq());
        jad_fsVar.jad_bo("Content-Type", "application/stream");
        this.jad_er.getClass();
        com.jd.ad.sdk.jad_pc.jad_an jad_anVarJad_an = com.jd.ad.sdk.jad_re.jad_an.jad_an();
        if (jad_anVarJad_an == null || !"1".equals(jad_anVarJad_an.jad_bo)) {
            jad_fsVar.jad_an("sdkxid", "default");
        }
        jad_ly.jad_bo jad_boVarJad_an = com.jd.ad.sdk.jad_zm.jad_bo.jad_an();
        jad_boVarJad_an.jad_er = strJad_an;
        jad_boVarJad_an.jad_fs = jad_erVar;
        jad_boVarJad_an.jad_bo = jad_fsVar;
        jad_boVarJad_an.jad_cp = jad_cpVarJad_cp == null ? 5000 : (int) jad_cpVarJad_cp.jad_dq;
        jad_boVarJad_an.jad_dq = jad_cpVarJad_cp != null ? (int) jad_cpVarJad_cp.jad_dq : 5000;
        jad_boVarJad_an.jad_jt = new C0558jad_an();
        jad_jt jad_jtVar2 = this.jad_er;
        JADSlot jADSlot = this.jad_an;
        jad_jtVar2.getClass();
        if (jADSlot != null) {
            long jCurrentTimeMillis = System.currentTimeMillis() - jADSlot.getLoadTime();
            String requestId = jADSlot.getRequestId();
            String slotID = jADSlot.getSlotID();
            int adType = jADSlot.getAdType();
            int sen = jADSlot.getSen();
            int rem = jADSlot.getRem();
            int width = (int) jADSlot.getWidth();
            int height = (int) jADSlot.getHeight();
            if (rem == 2) {
                width = (int) jADSlot.getAdImageWidth();
                height = (int) jADSlot.getAdImageHeight();
            }
            int i = width;
            int i2 = height;
            int templateId = jADSlot.getTemplateId();
            int ds = JADMediator.getInstance().getInitService().getDs(jADSlot.getSlotID());
            int r = JADMediator.getInstance().getInitService().getR(jADSlot.getSlotID());
            double dFloatToDouble = (jADSlot.isFromNativeAd() || adType != 1) ? 0.0d : ConversionUtils.floatToDouble(jADSlot.getTolerateTime());
            if (jADSlot.getAdDataRequestSourceType() == 1 || jADSlot.getAdDataRequestSourceType() == 2) {
                com.jd.ad.sdk.jad_xk.jad_fs.jad_an(requestId, slotID, 1, adType, sen, i2, i, templateId, rem, jCurrentTimeMillis, ds, r, 1, dFloatToDouble);
            } else {
                com.jd.ad.sdk.jad_xk.jad_fs.jad_an(requestId, slotID, 1, adType, sen, i2, i, templateId, rem, jCurrentTimeMillis, ds, r, 0, dFloatToDouble);
            }
        }
        jad_boVarJad_an.jad_an(com.jd.ad.sdk.jad_ep.jad_bo.jad_an);
    }

    /* JADX INFO: renamed from: com.jd.ad.sdk.jad_jt.jad_an$jad_an, reason: collision with other inner class name */
    /* JADX INFO: compiled from: JADLoader.java */
    public class C0558jad_an implements jad_ly.jad_an {

        /* JADX INFO: renamed from: com.jd.ad.sdk.jad_jt.jad_an$jad_an$jad_an, reason: collision with other inner class name */
        /* JADX INFO: compiled from: JADLoader.java */
        public class RunnableC0559jad_an implements Runnable {
            public RunnableC0559jad_an() {
            }

            @Override // java.lang.Runnable
            public void run() {
                jad_an jad_anVar = jad_an.this;
                jad_jt.jad_an(jad_anVar.jad_er, jad_anVar.jad_bo, jad_anVar.jad_an.getAdDataRequestSourceType());
            }
        }

        public C0558jad_an() {
        }

        @Override // com.jd.ad.sdk.jad_zm.jad_ly.jad_an
        public void jad_an(jad_mz jad_mzVar) {
            com.jd.ad.sdk.jad_yl.jad_dq jad_dqVar;
            try {
                if (jad_mzVar.jad_cp() != 200) {
                    jad_an jad_anVar = jad_an.this;
                    jad_anVar.jad_er.jad_an(jad_anVar.jad_bo, jad_mzVar.jad_cp(), "error code: " + jad_mzVar.jad_cp());
                    String strJad_bo = jad_mzVar.jad_bo() != null ? jad_mzVar.jad_bo().jad_bo() : "";
                    Logger.d("【load】loadAd error code:" + jad_mzVar.jad_cp() + ",msg=" + strJad_bo);
                    String str = jad_an.this.jad_cp;
                    int iJad_cp = jad_mzVar.jad_cp();
                    jad_an jad_anVar2 = jad_an.this;
                    com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, 3, iJad_cp, jad_anVar2.jad_er.jad_an(jad_anVar2.jad_an.getSlotID(), jad_an.this.jad_an.getAdType(), strJad_bo), jad_an.this.jad_an.getSen());
                    return;
                }
                if (jad_mzVar.jad_bo() == null) {
                    Logger.d("loadAd response body is null");
                    jad_an jad_anVar3 = jad_an.this;
                    jad_jt jad_jtVar = jad_anVar3.jad_er;
                    JADAdLoadListener jADAdLoadListener = jad_anVar3.jad_bo;
                    com.jd.ad.sdk.jad_wj.jad_an jad_anVar4 = com.jd.ad.sdk.jad_wj.jad_an.GW_RESPONSE_BODY_NULL_ERROR;
                    jad_jtVar.jad_an(jADAdLoadListener, jad_anVar4.jad_an(), jad_anVar4.jad_an(new String[0]));
                    String str2 = jad_an.this.jad_cp;
                    int iJad_an = jad_anVar4.jad_an();
                    jad_an jad_anVar5 = jad_an.this;
                    com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str2, 3, iJad_an, jad_anVar5.jad_er.jad_an(jad_anVar5.jad_an.getSlotID(), jad_an.this.jad_an.getAdType(), jad_anVar4.jad_an(new String[0])), jad_an.this.jad_an.getSen());
                    return;
                }
                String strJad_bo2 = jad_mzVar.jad_bo().jad_bo();
                if (TextUtils.isEmpty(strJad_bo2)) {
                    jad_an jad_anVar6 = jad_an.this;
                    jad_jt jad_jtVar2 = jad_anVar6.jad_er;
                    JADAdLoadListener jADAdLoadListener2 = jad_anVar6.jad_bo;
                    com.jd.ad.sdk.jad_wj.jad_an jad_anVar7 = com.jd.ad.sdk.jad_wj.jad_an.GW_RESPONSE_BODY_DATA_NULL_ERROR;
                    jad_jtVar2.jad_an(jADAdLoadListener2, jad_anVar7.jad_an(), jad_anVar7.jad_an(new String[0]));
                    String str3 = jad_an.this.jad_cp;
                    int iJad_an2 = jad_anVar7.jad_an();
                    jad_an jad_anVar8 = jad_an.this;
                    com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str3, 3, iJad_an2, jad_anVar8.jad_er.jad_an(jad_anVar8.jad_an.getSlotID(), jad_an.this.jad_an.getAdType(), jad_anVar7.jad_an(new String[0])), jad_an.this.jad_an.getSen());
                    return;
                }
                String strJe = ANEProxy.je(strJad_bo2);
                Logger.d("GW Data: " + strJe);
                if (TextUtils.isEmpty(strJe)) {
                    jad_an jad_anVar9 = jad_an.this;
                    jad_jt jad_jtVar3 = jad_anVar9.jad_er;
                    JADAdLoadListener jADAdLoadListener3 = jad_anVar9.jad_bo;
                    com.jd.ad.sdk.jad_wj.jad_an jad_anVar10 = com.jd.ad.sdk.jad_wj.jad_an.GW_RESPONSE_DES_ERROR_ERROR;
                    jad_jtVar3.jad_an(jADAdLoadListener3, jad_anVar10.jad_an(), jad_anVar10.jad_an(new String[0]));
                    String str4 = jad_an.this.jad_cp;
                    int iJad_an3 = jad_anVar10.jad_an();
                    jad_an jad_anVar11 = jad_an.this;
                    com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str4, 3, iJad_an3, jad_anVar11.jad_er.jad_an(jad_anVar11.jad_an.getSlotID(), jad_an.this.jad_an.getAdType(), jad_anVar10.jad_an(new String[0])), jad_an.this.jad_an.getSen());
                    return;
                }
                com.jd.ad.sdk.jad_yl.jad_jt jad_jtVarJad_an = com.jd.ad.sdk.jad_yl.jad_jt.jad_an(strJe);
                if (jad_jtVarJad_an.jad_an() != 0) {
                    jad_an jad_anVar12 = jad_an.this;
                    jad_anVar12.jad_er.jad_an(jad_anVar12.jad_bo, jad_jtVarJad_an.jad_an(), jad_jtVarJad_an.jad_bo());
                    String str5 = jad_an.this.jad_cp;
                    int iJad_an4 = jad_jtVarJad_an.jad_an();
                    jad_an jad_anVar13 = jad_an.this;
                    com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str5, 3, iJad_an4, jad_anVar13.jad_er.jad_an(jad_anVar13.jad_an.getSlotID(), jad_an.this.jad_an.getAdType(), jad_jtVarJad_an.jad_bo()), jad_an.this.jad_an.getSen());
                    return;
                }
                Logger.d("【preload】缓存请求 - 成功");
                if (jad_an.this.jad_an.getAdDataRequestSourceType() == 1) {
                    Logger.d("【preload】缓存 - 预加载广告数据");
                    jad_an jad_anVar14 = jad_an.this;
                    jad_jt.jad_an(jad_anVar14.jad_er, jad_anVar14.jad_an, strJe);
                } else {
                    if (jad_an.this.jad_an.getDynamicRenderTemplateHelper() != null) {
                        jad_an.this.jad_an.getDynamicRenderTemplateHelper().jad_an(strJe);
                    }
                    if (jad_jtVarJad_an.jad_cp() != null && jad_jtVarJad_an.jad_cp().jad_an() != null && jad_jtVarJad_an.jad_cp().jad_an().size() > 0 && (jad_dqVar = jad_jtVarJad_an.jad_cp().jad_an().get(0)) != null && jad_dqVar.jad_an() != null) {
                        jad_an.this.jad_an.setTemplateId(jad_dqVar.jad_an().jad_dq());
                        jad_an.this.jad_an.setMediaSpecSetType(jad_dqVar.jad_an().jad_cp());
                        jad_an.this.jad_an.setEventInteractionType(jad_dqVar.jad_an().jad_bo());
                        jad_an.this.jad_an.setModelClickAreaType(jad_dqVar.jad_an().jad_an());
                    }
                    jad_an jad_anVar15 = jad_an.this;
                    jad_jt.jad_an(jad_anVar15.jad_er, jad_anVar15.jad_dq, strJe);
                    if (jad_an.this.jad_an.getMediaSpecSetType() == 10009) {
                        com.jd.ad.sdk.jad_ly.jad_dq.jad_an().jad_an(jad_an.this.jad_dq);
                    }
                }
                jad_an jad_anVar16 = jad_an.this;
                jad_jt.jad_bo(jad_anVar16.jad_er, jad_anVar16.jad_an);
                HandlerUtils.runOnUiThread(new RunnableC0559jad_an());
            } catch (IOException e) {
                jad_an jad_anVar17 = jad_an.this;
                jad_jt jad_jtVar4 = jad_anVar17.jad_er;
                JADAdLoadListener jADAdLoadListener4 = jad_anVar17.jad_bo;
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar18 = com.jd.ad.sdk.jad_wj.jad_an.GW_RESPONSE_DATA_IO_ERROR;
                jad_jtVar4.jad_an(jADAdLoadListener4, jad_anVar18.jad_an(), jad_anVar18.jad_an(new String[0]));
                String str6 = jad_an.this.jad_cp;
                int iJad_an5 = jad_anVar18.jad_an();
                jad_an jad_anVar19 = jad_an.this;
                com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str6, 3, iJad_an5, jad_anVar19.jad_er.jad_an(jad_anVar19.jad_an.getSlotID(), jad_an.this.jad_an.getAdType(), jad_anVar18.jad_an(e.getMessage())), jad_an.this.jad_an.getSen());
            } catch (JSONException e2) {
                jad_an jad_anVar20 = jad_an.this;
                jad_jt jad_jtVar5 = jad_anVar20.jad_er;
                JADAdLoadListener jADAdLoadListener5 = jad_anVar20.jad_bo;
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar21 = com.jd.ad.sdk.jad_wj.jad_an.GW_RESPONSE_JSON_PARSER_ERROR;
                jad_jtVar5.jad_an(jADAdLoadListener5, jad_anVar21.jad_an(), jad_anVar21.jad_an(new String[0]));
                String str7 = jad_an.this.jad_cp;
                int iJad_an6 = jad_anVar21.jad_an();
                jad_an jad_anVar22 = jad_an.this;
                com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str7, 3, iJad_an6, jad_anVar22.jad_er.jad_an(jad_anVar22.jad_an.getSlotID(), jad_an.this.jad_an.getAdType(), jad_anVar21.jad_an(e2.getMessage())), jad_an.this.jad_an.getSen());
            } catch (Exception e3) {
                jad_an jad_anVar23 = jad_an.this;
                jad_jt jad_jtVar6 = jad_anVar23.jad_er;
                JADAdLoadListener jADAdLoadListener6 = jad_anVar23.jad_bo;
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar24 = com.jd.ad.sdk.jad_wj.jad_an.GW_RESPONSE_OTHER_ERROR;
                jad_jtVar6.jad_an(jADAdLoadListener6, jad_anVar24.jad_an(), jad_anVar24.jad_an(new String[0]));
                String str8 = jad_an.this.jad_cp;
                int iJad_an7 = jad_anVar24.jad_an();
                jad_an jad_anVar25 = jad_an.this;
                com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str8, 3, iJad_an7, jad_anVar25.jad_er.jad_an(jad_anVar25.jad_an.getSlotID(), jad_an.this.jad_an.getAdType(), com.jd.ad.sdk.jad_wj.jad_an.GW_RESPONSE_DATA_IO_ERROR.jad_an(e3.getMessage())), jad_an.this.jad_an.getSen());
            }
        }

        @Override // com.jd.ad.sdk.jad_zm.jad_ly.jad_an
        public void jad_an(int i, String str) {
            jad_an jad_anVar = jad_an.this;
            jad_anVar.jad_er.jad_an(jad_anVar.jad_bo, i, str);
            jad_an jad_anVar2 = jad_an.this;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an(jad_anVar2.jad_cp, 3, i, jad_anVar2.jad_er.jad_an(jad_anVar2.jad_an.getSlotID(), jad_an.this.jad_an.getAdType(), str), jad_an.this.jad_an.getSen());
        }
    }
}
