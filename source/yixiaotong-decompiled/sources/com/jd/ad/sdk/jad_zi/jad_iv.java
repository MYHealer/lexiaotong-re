package com.jd.ad.sdk.jad_zi;

import com.jd.ad.sdk.bl.initsdk.JADYunSdk;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.mdt.service.JADInitService;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: JADInitServiceImplementor.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_iv implements JADInitService {
    @Override // com.jd.ad.sdk.mdt.service.JADInitService
    public void createDefaultAdInstance(JADSlot jADSlot) {
        Map<String, com.jd.ad.sdk.jad_yl.jad_an> map = com.jd.ad.sdk.jad_ob.jad_jt.jad_an;
        if (jADSlot == null) {
            return;
        }
        com.jd.ad.sdk.jad_yl.jad_an jad_anVar = new com.jd.ad.sdk.jad_yl.jad_an();
        jad_anVar.jad_an = "Audience";
        jADSlot.getAdType();
        JADYunSdk.getAppId();
        jad_anVar.jad_bo = jADSlot.getSlotID();
        jADSlot.getSlotID();
        jad_anVar.jad_cp = 7;
        ((HashMap) com.jd.ad.sdk.jad_ob.jad_jt.jad_cp).put(jad_anVar.jad_bo, jad_anVar);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADInitService
    public String getAdUrl(String str) {
        return com.jd.ad.sdk.jad_jt.jad_hu.jad_an(com.jd.ad.sdk.jad_re.jad_an.jad_cp(), str);
    }

    @Override // com.jd.ad.sdk.mdt.service.JADInitService
    public int getDs(String str) {
        com.jd.ad.sdk.jad_yl.jad_an jad_anVarJad_an = com.jd.ad.sdk.jad_ob.jad_jt.jad_an(str);
        if (jad_anVarJad_an == null) {
            return 0;
        }
        return jad_anVarJad_an.jad_dq;
    }

    @Override // com.jd.ad.sdk.mdt.service.JADInitService
    public float getFeedShakeAngleValue() {
        com.jd.ad.sdk.jad_pc.jad_an jad_anVarJad_an = com.jd.ad.sdk.jad_re.jad_an.jad_an();
        if (jad_anVarJad_an == null) {
            return 0.0f;
        }
        return jad_anVarJad_an.jad_hu;
    }

    @Override // com.jd.ad.sdk.mdt.service.JADInitService
    public float getFeedShakeSensitivityValue() {
        com.jd.ad.sdk.jad_pc.jad_an jad_anVarJad_an = com.jd.ad.sdk.jad_re.jad_an.jad_an();
        if (jad_anVarJad_an == null) {
            return 0.0f;
        }
        return jad_anVarJad_an.jad_jt;
    }

    @Override // com.jd.ad.sdk.mdt.service.JADInitService
    public float getFeedShakeTimeValue() {
        com.jd.ad.sdk.jad_pc.jad_an jad_anVarJad_an = com.jd.ad.sdk.jad_re.jad_an.jad_an();
        if (jad_anVarJad_an == null) {
            return 0.0f;
        }
        return jad_anVarJad_an.jad_iv;
    }

    @Override // com.jd.ad.sdk.mdt.service.JADInitService
    public int getJumpToH5DelayTime() {
        com.jd.ad.sdk.jad_pc.jad_an jad_anVarJad_an = com.jd.ad.sdk.jad_re.jad_an.jad_an();
        if (jad_anVarJad_an == null) {
            return 100;
        }
        return jad_anVarJad_an.jad_vi;
    }

    @Override // com.jd.ad.sdk.mdt.service.JADInitService
    public int getNeedCheckMediaClickH5() {
        com.jd.ad.sdk.jad_pc.jad_an jad_anVarJad_an = com.jd.ad.sdk.jad_re.jad_an.jad_an();
        if (jad_anVarJad_an == null) {
            return 0;
        }
        return jad_anVarJad_an.jad_uh;
    }

    @Override // com.jd.ad.sdk.mdt.service.JADInitService
    public int getOpenReflectOaid() {
        com.jd.ad.sdk.jad_pc.jad_an jad_anVarJad_an = com.jd.ad.sdk.jad_re.jad_an.jad_an();
        if (jad_anVarJad_an == null) {
            return 0;
        }
        return jad_anVarJad_an.jad_ob;
    }

    @Override // com.jd.ad.sdk.mdt.service.JADInitService
    public int getR(String str) {
        com.jd.ad.sdk.jad_yl.jad_an jad_anVarJad_an = com.jd.ad.sdk.jad_ob.jad_jt.jad_an(str);
        if (jad_anVarJad_an == null) {
            return 0;
        }
        return jad_anVarJad_an.jad_er;
    }

    @Override // com.jd.ad.sdk.mdt.service.JADInitService
    public int getSen(String str) {
        com.jd.ad.sdk.jad_yl.jad_an jad_anVarJad_an;
        Map<String, com.jd.ad.sdk.jad_yl.jad_an> map = com.jd.ad.sdk.jad_ob.jad_jt.jad_an;
        return (com.jd.ad.sdk.jad_re.jad_an.jad_cp() == null || (jad_anVarJad_an = com.jd.ad.sdk.jad_ob.jad_jt.jad_an(str)) == null || jad_anVarJad_an.jad_cp != 4) ? 1 : 2;
    }

    @Override // com.jd.ad.sdk.mdt.service.JADInitService
    public float getShakeAngleValue() {
        com.jd.ad.sdk.jad_pc.jad_an jad_anVarJad_an = com.jd.ad.sdk.jad_re.jad_an.jad_an();
        if (jad_anVarJad_an == null) {
            return 0.0f;
        }
        return jad_anVarJad_an.jad_er;
    }

    @Override // com.jd.ad.sdk.mdt.service.JADInitService
    public float getShakeSensitivityValue() {
        com.jd.ad.sdk.jad_pc.jad_an jad_anVarJad_an = com.jd.ad.sdk.jad_re.jad_an.jad_an();
        if (jad_anVarJad_an == null) {
            return 0.0f;
        }
        return jad_anVarJad_an.jad_cp;
    }

    @Override // com.jd.ad.sdk.mdt.service.JADInitService
    public float getShakeTimeValue() {
        com.jd.ad.sdk.jad_pc.jad_an jad_anVarJad_an = com.jd.ad.sdk.jad_re.jad_an.jad_an();
        if (jad_anVarJad_an == null) {
            return 0.0f;
        }
        return jad_anVarJad_an.jad_fs;
    }

    @Override // com.jd.ad.sdk.mdt.service.JADInitService
    public float getSwipeAngle() {
        com.jd.ad.sdk.jad_pc.jad_an jad_anVarJad_an = com.jd.ad.sdk.jad_re.jad_an.jad_an();
        if (jad_anVarJad_an == null) {
            return 45.0f;
        }
        return jad_anVarJad_an.jad_jw;
    }

    @Override // com.jd.ad.sdk.mdt.service.JADInitService
    public float getSwipeLength() {
        com.jd.ad.sdk.jad_pc.jad_an jad_anVarJad_an = com.jd.ad.sdk.jad_re.jad_an.jad_an();
        if (jad_anVarJad_an == null) {
            return 1.0f;
        }
        return jad_anVarJad_an.jad_dq;
    }

    @Override // com.jd.ad.sdk.mdt.service.JADInitService
    public boolean isForbidModelToH5() {
        return com.jd.ad.sdk.jad_ob.jad_dq.jad_an.jad_an.jad_an(13, (String) null);
    }
}
