package com.jd.ad.sdk.jad_zm;

import com.jd.ad.sdk.logger.Logger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_cp extends jad_dq implements Runnable {
    public jad_an jad_cp;

    public interface jad_an {
    }

    public jad_cp(jad_ly jad_lyVar) {
        super(jad_lyVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        com.jd.ad.sdk.jad_zm.jad_an jad_anVar;
        try {
            com.jd.ad.sdk.jad_zm.jad_an jad_anVar2 = this.jad_bo;
            if (jad_anVar2 == null) {
                jad_an jad_anVar3 = this.jad_cp;
                if (jad_anVar3 != null) {
                    com.jd.ad.sdk.jad_cn.jad_an jad_anVar4 = com.jd.ad.sdk.jad_cn.jad_an.NET_CONNECTION_IS_NULL_ERROR;
                    ((jad_jw) jad_anVar3).jad_an(jad_anVar4.jad_an, jad_anVar4.jad_an(new String[0]));
                }
                com.jd.ad.sdk.jad_zm.jad_an jad_anVar5 = this.jad_bo;
                if (jad_anVar5 != null) {
                    try {
                        jad_anVar5.jad_an();
                        return;
                    } catch (Exception e) {
                        Logger.w("Exception while async req: ", e.getMessage());
                        return;
                    }
                }
                return;
            }
            jad_mz jad_mzVarJad_bo = jad_anVar2.jad_bo(this.jad_an);
            if (jad_mzVarJad_bo == null) {
                jad_an jad_anVar6 = this.jad_cp;
                if (jad_anVar6 != null) {
                    com.jd.ad.sdk.jad_cn.jad_an jad_anVar7 = com.jd.ad.sdk.jad_cn.jad_an.NET_HTTP_RESPONSE_IS_NULL_ERROR;
                    ((jad_jw) jad_anVar6).jad_an(jad_anVar7.jad_an, jad_anVar7.jad_an(new String[0]));
                }
            } else {
                jad_an jad_anVar8 = this.jad_cp;
                if (jad_anVar8 != null) {
                    jad_ly.jad_an jad_anVar9 = ((jad_jw) jad_anVar8).jad_an.jad_hu;
                    if (jad_anVar9 != null) {
                        jad_anVar9.jad_an(jad_mzVarJad_bo);
                    } else {
                        jad_mzVarJad_bo.close();
                    }
                }
            }
            com.jd.ad.sdk.jad_zm.jad_an jad_anVar10 = this.jad_bo;
            if (jad_anVar10 != null) {
                try {
                    jad_anVar10.jad_an();
                } catch (Exception e2) {
                    Logger.w("Exception while async req: ", e2.getMessage());
                }
            }
        } catch (Throwable th) {
            try {
                jad_an jad_anVar11 = this.jad_cp;
                if (jad_anVar11 == null) {
                    if (jad_anVar != null) {
                        try {
                            return;
                        } catch (Exception e3) {
                            return;
                        }
                    }
                    return;
                }
                com.jd.ad.sdk.jad_cn.jad_an jad_anVar12 = com.jd.ad.sdk.jad_cn.jad_an.NET_HTTP_OTHER_ERROR;
                ((jad_jw) jad_anVar11).jad_an(jad_anVar12.jad_an, jad_anVar12.jad_an(th.getMessage()));
            } finally {
                jad_anVar = this.jad_bo;
                if (jad_anVar != null) {
                    try {
                        jad_anVar.jad_an();
                    } catch (Exception e4) {
                        Logger.w("Exception while async req: ", e4.getMessage());
                    }
                }
            }
        }
    }
}
