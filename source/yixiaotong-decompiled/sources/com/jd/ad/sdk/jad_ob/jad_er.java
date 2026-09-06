package com.jd.ad.sdk.jad_ob;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.jd.ad.sdk.bl.initsdk.JADYunSdk;
import com.jd.ad.sdk.fdt.thread.WorkExecutor;
import com.jd.ad.sdk.fdt.utils.ActLifecycle;
import com.jd.ad.sdk.fdt.utils.HandlerUtils;
import com.jd.ad.sdk.fdt.utils.UUIDUtils;
import com.jd.ad.sdk.jad_zm.jad_ly;
import com.jd.ad.sdk.jad_zm.jad_mz;
import com.jd.ad.sdk.jad_zm.jad_ob;
import com.jd.ad.sdk.logger.Logger;
import com.kwad.components.offline.api.explore.model.ExploreConstants;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: InitImp.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_er {
    public static final Handler jad_an = new Handler(Looper.getMainLooper());
    public static jad_hu jad_bo;

    /* JADX INFO: compiled from: InitImp.java */
    public class jad_an implements Runnable {
        public final /* synthetic */ String jad_an;

        public jad_an(String str) {
            this.jad_an = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String strUuid = UUIDUtils.uuid();
            try {
                com.jd.ad.sdk.jad_ob.jad_cp.jad_an(new jad_cp(this.jad_an, strUuid), strUuid);
                com.jd.ad.sdk.jad_xk.jad_fs.jad_an(strUuid);
            } catch (Exception e) {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.AN_REQUEST_ERROR;
                com.jd.ad.sdk.jad_xk.jad_fs.jad_an(strUuid, 2, jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()), 0);
            }
        }
    }

    /* JADX INFO: compiled from: InitImp.java */
    public static class jad_bo implements ActLifecycle.jad_an {
        @Override // com.jd.ad.sdk.fdt.utils.ActLifecycle.jad_an
        public void jad_an() {
            try {
                Logger.d("InitImp onChangeToForeground hotRequestConfig");
                com.jd.ad.sdk.jad_vi.jad_an.jad_bo = false;
                if (com.jd.ad.sdk.jad_ob.jad_bo.jad_bo) {
                    return;
                }
                jad_er.jad_an(JADYunSdk.getAppId());
            } catch (Exception e) {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.AN_REQUEST_OTHER_ERROR;
                com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
            }
        }

        @Override // com.jd.ad.sdk.fdt.utils.ActLifecycle.jad_an
        public void jad_bo() {
            com.jd.ad.sdk.jad_vi.jad_an.jad_bo = true;
            com.jd.ad.sdk.jad_ob.jad_bo.jad_bo = false;
        }
    }

    public static void jad_an(String str, com.jd.ad.sdk.jad_pc.jad_cp jad_cpVar) {
        String str2;
        try {
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            String string = jad_cpVar.jad_an().toString();
            jad_anVar.getClass();
            if (!TextUtils.isEmpty("Config")) {
                jad_anVar.jad_an("Config" + JADYunSdk.getAppId(), string);
            }
            Long lValueOf = Long.valueOf(System.currentTimeMillis());
            if (!TextUtils.isEmpty("cat")) {
                jad_anVar.jad_an("cat" + JADYunSdk.getAppId(), lValueOf);
            }
            jad_jt.jad_an();
            List<com.jd.ad.sdk.jad_pc.jad_er> list = jad_cpVar.jad_jt;
            for (int i = 0; i < list.size(); i++) {
                com.jd.ad.sdk.jad_pc.jad_er jad_erVar = list.get(i);
                int i2 = jad_erVar.jad_bo;
                if (i2 == 1) {
                    str2 = ExploreConstants.SCENE_SPLASH;
                } else if (i2 == 2) {
                    str2 = ExploreConstants.SCENE_FEED;
                } else {
                    str2 = i2 == 4 ? ExploreConstants.SCENE_INTERSTITIAL : "Banner";
                }
                if (jad_erVar.jad_er != 4) {
                    Logger.i(str2 + " 广告位 " + jad_erVar.jad_an + " 为线上状态", new Object[0]);
                } else {
                    Logger.w(str2 + " 广告位 " + jad_erVar.jad_an + " 为测试状态", new Object[0]);
                }
            }
            jad_an(jad_cpVar);
        } catch (Exception e) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.AN_RESPONSE_DATA_PROCESS_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, jad_anVar2.jad_an, jad_anVar2.jad_an(e.getMessage()));
        }
    }

    public static void jad_an(String str) {
        AtomicInteger atomicInteger = com.jd.ad.sdk.jad_ob.jad_bo.jad_an;
        if (Math.abs(System.currentTimeMillis() - com.jd.ad.sdk.jad_ob.jad_bo.jad_cp) > 30000) {
            com.jd.ad.sdk.jad_ob.jad_bo.jad_cp = System.currentTimeMillis();
            WorkExecutor.execute(new jad_an(str));
        }
    }

    public static void jad_an(com.jd.ad.sdk.jad_pc.jad_cp jad_cpVar) {
        try {
            ArrayList arrayList = new ArrayList();
            com.jd.ad.sdk.jad_pc.jad_an jad_anVar = jad_cpVar.jad_iv;
            if (jad_anVar != null) {
                String str = jad_anVar.jad_qd;
                if (!TextUtils.isEmpty(str)) {
                    arrayList.addAll(Arrays.asList(str.split(",")));
                }
                com.jd.ad.sdk.jad_qd.jad_fs jad_fsVar = com.jd.ad.sdk.jad_qd.jad_fs.jad_an.jad_an;
                jad_fsVar.jad_iv.clear();
                if (arrayList.size() > 0) {
                    jad_fsVar.jad_iv.addAll(arrayList);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void jad_an(String str, int i, String str2, String str3) {
        AtomicInteger atomicInteger = com.jd.ad.sdk.jad_ob.jad_bo.jad_an;
        if (atomicInteger.get() < 10) {
            atomicInteger.incrementAndGet();
        }
        Logger.d("retry time: " + atomicInteger);
        if (atomicInteger.get() < 3 && com.jd.ad.sdk.jad_ob.jad_bo.jad_bo) {
            jad_an.postDelayed(new jad_fs(str2), 30000L);
        }
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, 2, i, str3, 0);
    }

    /* JADX INFO: compiled from: InitImp.java */
    public static class jad_cp implements jad_ly.jad_an {
        public final String jad_an;
        public String jad_bo;
        public final long jad_cp = System.currentTimeMillis();

        public jad_cp(String str, String str2) {
            this.jad_an = str;
            this.jad_bo = str2;
        }

        @Override // com.jd.ad.sdk.jad_zm.jad_ly.jad_an
        public void jad_an(jad_mz jad_mzVar) {
            long time;
            long jCurrentTimeMillis = System.currentTimeMillis() - this.jad_cp;
            try {
                String strJad_an = jad_mzVar.jad_bo.jad_an("Date");
                if (TextUtils.isEmpty(strJad_an)) {
                    time = 0;
                } else {
                    try {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM y HH:mm:ss 'GMT'", Locale.US);
                        simpleDateFormat.setTimeZone(com.jd.ad.sdk.jad_zm.jad_fs.jad_bo);
                        time = simpleDateFormat.parse(strJad_an).getTime();
                    } catch (ParseException e) {
                        e.printStackTrace();
                        time = 0;
                    }
                }
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                long jAbs = Math.abs(jCurrentTimeMillis2 - time);
                String str = new SimpleDateFormat("yyyy年MM月dd日 HH:mm").format(new Date(time));
                String str2 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm").format(new Date(jCurrentTimeMillis2));
                if (jAbs < 600000) {
                    Logger.i("本机时间：" + str2 + ", 服务器时间：" + str + ", 相差：" + jAbs + "ms, 联调时间不影响广告填充", new Object[0]);
                } else {
                    Logger.w("本机时间：" + str2 + ", 服务器时间：" + str + ", 相差：" + jAbs + "ms, 联调时间影响广告填充,请校准本机时间", new Object[0]);
                }
            } catch (Exception e2) {
                Logger.w(com.jd.ad.sdk.jad_bo.jad_bo.jad_an("an exception:").append(e2.getMessage()).toString(), new Object[0]);
            }
            try {
                try {
                    try {
                        if (jad_mzVar.jad_an != 200) {
                            jad_ob jad_obVar = jad_mzVar.jad_cp;
                            String strJad_bo = jad_obVar != null ? jad_obVar.jad_bo() : "";
                            jad_an(false, jad_mzVar.jad_an, strJad_bo);
                            jad_er.jad_an(this.jad_bo, jad_mzVar.jad_an, this.jad_an, strJad_bo);
                            try {
                                jad_mzVar.close();
                                return;
                            } catch (IOException e3) {
                                e3.printStackTrace();
                                com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.UTILS_IO_STREAM_CLOSE_ERROR;
                                com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e3.getMessage()));
                                return;
                            }
                        }
                        jad_ob jad_obVar2 = jad_mzVar.jad_cp;
                        if (jad_obVar2 == null) {
                            com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.AN_RESULT_BODY_NULL_ERROR;
                            jad_an(false, jad_anVar2.jad_an, "");
                            jad_er.jad_an(this.jad_bo, jad_anVar2.jad_an, this.jad_an, jad_anVar2.jad_an(new String[0]));
                            try {
                                jad_mzVar.close();
                                return;
                            } catch (IOException e4) {
                                e4.printStackTrace();
                                com.jd.ad.sdk.jad_wj.jad_an jad_anVar3 = com.jd.ad.sdk.jad_wj.jad_an.UTILS_IO_STREAM_CLOSE_ERROR;
                                com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar3.jad_an, jad_anVar3.jad_an(e4.getMessage()));
                                return;
                            }
                        }
                        String strJad_bo2 = jad_obVar2.jad_bo();
                        if (TextUtils.isEmpty(strJad_bo2)) {
                            com.jd.ad.sdk.jad_wj.jad_an jad_anVar4 = com.jd.ad.sdk.jad_wj.jad_an.AN_RESPONSE_BODY_CONTENT_NULL_ERROR;
                            jad_an(false, jad_anVar4.jad_an, "");
                            jad_er.jad_an(this.jad_bo, jad_anVar4.jad_an, this.jad_an, jad_anVar4.jad_an(new String[0]));
                            try {
                                jad_mzVar.close();
                                return;
                            } catch (IOException e5) {
                                e5.printStackTrace();
                                com.jd.ad.sdk.jad_wj.jad_an jad_anVar5 = com.jd.ad.sdk.jad_wj.jad_an.UTILS_IO_STREAM_CLOSE_ERROR;
                                com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar5.jad_an, jad_anVar5.jad_an(e5.getMessage()));
                                return;
                            }
                        }
                        String strJad_an2 = com.jd.ad.sdk.jad_fq.jad_an.jad_an(strJad_bo2);
                        if (TextUtils.isEmpty(strJad_an2)) {
                            com.jd.ad.sdk.jad_wj.jad_an jad_anVar6 = com.jd.ad.sdk.jad_wj.jad_an.AN_RESPONSE_DATA_DES_ERROR;
                            jad_an(false, jad_anVar6.jad_an, "");
                            jad_er.jad_an(this.jad_bo, jad_anVar6.jad_an, this.jad_an, jad_anVar6.jad_an(new String[0]));
                            try {
                                jad_mzVar.close();
                                return;
                            } catch (IOException e6) {
                                e6.printStackTrace();
                                com.jd.ad.sdk.jad_wj.jad_an jad_anVar7 = com.jd.ad.sdk.jad_wj.jad_an.UTILS_IO_STREAM_CLOSE_ERROR;
                                com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar7.jad_an, jad_anVar7.jad_an(e6.getMessage()));
                                return;
                            }
                        }
                        Logger.d("AN API Response：" + strJad_an2);
                        JSONObject jSONObject = new JSONObject(strJad_an2);
                        int iOptInt = jSONObject.optInt("code");
                        String strOptString = jSONObject.optString("msg");
                        String strOptString2 = jSONObject.optString("rid", this.jad_bo);
                        this.jad_bo = strOptString2;
                        if (iOptInt == 0) {
                            com.jd.ad.sdk.jad_xk.jad_fs.jad_an(strOptString2, jCurrentTimeMillis);
                            com.jd.ad.sdk.jad_pc.jad_cp jad_cpVarJad_an = com.jd.ad.sdk.jad_pc.jad_cp.jad_an(jSONObject.getJSONObject("data"));
                            if (jad_cpVarJad_an != null) {
                                jad_er.jad_an(this.jad_bo, jad_cpVarJad_an);
                            }
                            jad_an(true, -1, "");
                        } else if (iOptInt == 2) {
                            jad_an(true, -1, "");
                        } else {
                            jad_an(false, iOptInt, strOptString);
                            jad_er.jad_an(this.jad_bo, iOptInt, this.jad_an, strOptString);
                        }
                        try {
                            jad_mzVar.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                            com.jd.ad.sdk.jad_wj.jad_an jad_anVar8 = com.jd.ad.sdk.jad_wj.jad_an.UTILS_IO_STREAM_CLOSE_ERROR;
                            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar8.jad_an, jad_anVar8.jad_an(e7.getMessage()));
                        }
                    } catch (Throwable th) {
                        if (jad_mzVar != null) {
                            try {
                                jad_mzVar.close();
                            } catch (IOException e8) {
                                e8.printStackTrace();
                                com.jd.ad.sdk.jad_wj.jad_an jad_anVar9 = com.jd.ad.sdk.jad_wj.jad_an.UTILS_IO_STREAM_CLOSE_ERROR;
                                com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar9.jad_an, jad_anVar9.jad_an(e8.getMessage()));
                            }
                        }
                        throw th;
                    }
                } catch (JSONException e9) {
                    com.jd.ad.sdk.jad_wj.jad_an jad_anVar10 = com.jd.ad.sdk.jad_wj.jad_an.AN_RESPONSE_JSON_PARSER_ERROR;
                    jad_an(false, jad_anVar10.jad_an, "");
                    jad_er.jad_an(this.jad_bo, jad_anVar10.jad_an, this.jad_an, jad_anVar10.jad_an(e9.getMessage()));
                    if (jad_mzVar != null) {
                        try {
                            jad_mzVar.close();
                        } catch (IOException e10) {
                            e10.printStackTrace();
                            com.jd.ad.sdk.jad_wj.jad_an jad_anVar11 = com.jd.ad.sdk.jad_wj.jad_an.UTILS_IO_STREAM_CLOSE_ERROR;
                            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar11.jad_an, jad_anVar11.jad_an(e10.getMessage()));
                        }
                    }
                }
            } catch (IOException e11) {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar12 = com.jd.ad.sdk.jad_wj.jad_an.AN_RESPONSE_DATA_IO_ERROR;
                jad_an(false, jad_anVar12.jad_an, "");
                jad_er.jad_an(this.jad_bo, jad_anVar12.jad_an, this.jad_an, jad_anVar12.jad_an(e11.getMessage()));
                if (jad_mzVar != null) {
                    try {
                        jad_mzVar.close();
                    } catch (IOException e12) {
                        e12.printStackTrace();
                        com.jd.ad.sdk.jad_wj.jad_an jad_anVar13 = com.jd.ad.sdk.jad_wj.jad_an.UTILS_IO_STREAM_CLOSE_ERROR;
                        com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar13.jad_an, jad_anVar13.jad_an(e12.getMessage()));
                    }
                }
            } catch (Exception e13) {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar14 = com.jd.ad.sdk.jad_wj.jad_an.AN_RESPONSE_DATA_PROCESS_OTHER_ERROR;
                jad_an(false, jad_anVar14.jad_an, "");
                jad_er.jad_an(this.jad_bo, jad_anVar14.jad_an, this.jad_an, jad_anVar14.jad_an(e13.getMessage()));
                if (jad_mzVar != null) {
                    try {
                        jad_mzVar.close();
                    } catch (IOException e14) {
                        e14.printStackTrace();
                        com.jd.ad.sdk.jad_wj.jad_an jad_anVar15 = com.jd.ad.sdk.jad_wj.jad_an.UTILS_IO_STREAM_CLOSE_ERROR;
                        com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar15.jad_an, jad_anVar15.jad_an(e14.getMessage()));
                    }
                }
            }
        }

        public final void jad_an(boolean z, int i, String str) {
            JADYunSdk.jad_er jad_erVar = JADYunSdk.mInnerInitCallBack;
            if (jad_erVar != null) {
                boolean unused = JADYunSdk.isInitSuccess = z;
                if (com.jd.ad.sdk.jad_ob.jad_bo.jad_an.get() == 0 && com.jd.ad.sdk.jad_ob.jad_bo.jad_bo) {
                    if (z) {
                        JADYunSdk.jad_cp jad_cpVar = (JADYunSdk.jad_cp) JADYunSdk.mInnerInitCallBack;
                        jad_cpVar.getClass();
                        HandlerUtils.runOnUiThread(new com.jd.ad.sdk.bl.initsdk.jad_an(jad_cpVar));
                    } else {
                        if (TextUtils.isEmpty(str)) {
                            str = "sdk init error";
                        }
                        JADYunSdk.jad_cp jad_cpVar2 = (JADYunSdk.jad_cp) JADYunSdk.mInnerInitCallBack;
                        jad_cpVar2.getClass();
                        HandlerUtils.runOnUiThread(new com.jd.ad.sdk.bl.initsdk.jad_bo(jad_cpVar2, i, str));
                    }
                }
            }
        }

        @Override // com.jd.ad.sdk.jad_zm.jad_ly.jad_an
        public void jad_an(int i, String str) {
            jad_er.jad_an(this.jad_bo, i, this.jad_an, str);
            jad_an(false, i, str);
        }
    }
}
