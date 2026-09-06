package com.jd.ad.sdk.bl.video.db;

import android.app.Application;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.jd.ad.sdk.fdt.thread.WorkExecutor;
import com.jd.ad.sdk.fdt.utils.ANEProxy;
import com.jd.ad.sdk.jad_ly.jad_cp;
import com.jd.ad.sdk.jad_qd.jad_jw;
import com.jd.ad.sdk.jad_xk.jad_fs;
import com.jd.ad.sdk.logger.Logger;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class SplashRenderVideoHelper {
    private static com.jd.ad.sdk.jad_mz.jad_an sDataBaseVideoStorage;
    private final String mAppIdPid;
    private List<jad_cp> mRenderVideoList;

    public class jad_an implements Runnable {
        public final /* synthetic */ Context jad_an;

        public jad_an(Context context) {
            this.jad_an = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!SplashRenderVideoHelper.isFbdr() && jad_jw.jad_dq(this.jad_an) && SplashRenderVideoHelper.sDataBaseVideoStorage == null) {
                com.jd.ad.sdk.jad_mz.jad_an unused = SplashRenderVideoHelper.sDataBaseVideoStorage = com.jd.ad.sdk.jad_mz.jad_an.jad_an(this.jad_an, "jaddb.db", 2);
                SplashRenderVideoHelper.sDataBaseVideoStorage.jad_cp();
            }
        }
    }

    public class jad_bo implements Runnable {
        public final /* synthetic */ jad_cp jad_an;

        public jad_bo(SplashRenderVideoHelper splashRenderVideoHelper, jad_cp jad_cpVar) {
            this.jad_an = jad_cpVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (jad_jw.jad_dq(com.jd.ad.sdk.jad_fq.jad_cp.jad_an())) {
                com.jd.ad.sdk.jad_mz.jad_an jad_anVar = SplashRenderVideoHelper.sDataBaseVideoStorage;
                jad_cp jad_cpVar = this.jad_an;
                synchronized (jad_anVar) {
                    if (jad_cpVar != null) {
                        try {
                            jad_anVar.getWritableDatabase();
                            if (jad_anVar.jad_bo()) {
                                ContentValues contentValuesJad_an = jad_anVar.jad_an(jad_cpVar);
                                if (jad_cpVar.jad_an > 0) {
                                    jad_anVar.jad_an.update("splashVideo", contentValuesJad_an, "_id=?", new String[]{String.valueOf(jad_cpVar)});
                                } else {
                                    jad_anVar.jad_an.insert("splashVideo", null, contentValuesJad_an);
                                }
                                jad_anVar.jad_an(jad_cpVar.jad_bo);
                            }
                        } catch (Throwable th) {
                            Logger.w("Exception while saving video: ", th.getMessage());
                        }
                    }
                }
                return;
            }
            jad_cp jad_cpVar2 = this.jad_an;
            List<String> list = com.jd.ad.sdk.jad_tg.jad_an.jad_an;
            if (jad_cpVar2 == null) {
                return;
            }
            try {
                ContentResolver contentResolverJad_an = com.jd.ad.sdk.jad_tg.jad_an.jad_an();
                if (contentResolverJad_an == null) {
                    return;
                }
                Uri uri = Uri.parse(com.jd.ad.sdk.jad_tg.jad_an.jad_bo() + "db_video_render/update");
                ContentValues contentValues = new ContentValues();
                contentValues.put("_id", Integer.valueOf(jad_cpVar2.jad_an));
                contentValues.put("appIdPid", jad_cpVar2.jad_bo);
                String strJa = ANEProxy.ja(jad_cpVar2.jad_cp);
                String strJa2 = ANEProxy.ja(jad_cpVar2.jad_dq);
                contentValues.put("videoUrl", strJa);
                contentValues.put("videoLocalPath", strJa2);
                contentResolverJad_an.update(uri, contentValues, null, null);
            } catch (Exception e) {
                Logger.w("Exception while multi process update template: ", e.getMessage());
            }
        }
    }

    public SplashRenderVideoHelper(Context context, String str) {
        this.mAppIdPid = str;
        if (!jad_jw.jad_dq(context)) {
            this.mRenderVideoList = com.jd.ad.sdk.jad_tg.jad_an.jad_bo(str);
            return;
        }
        if (sDataBaseVideoStorage == null) {
            com.jd.ad.sdk.jad_mz.jad_an jad_anVarJad_an = com.jd.ad.sdk.jad_mz.jad_an.jad_an(context, "jaddb.db", 2);
            sDataBaseVideoStorage = jad_anVarJad_an;
            jad_anVarJad_an.jad_cp();
        }
        this.mRenderVideoList = sDataBaseVideoStorage.jad_bo(str);
    }

    public static void init(Context context) {
        WorkExecutor.execute(new jad_an(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isFbdr() {
        com.jd.ad.sdk.jad_pc.jad_an jad_anVarJad_an = com.jd.ad.sdk.jad_re.jad_an.jad_an();
        return jad_anVarJad_an != null && "1".equals(jad_anVarJad_an.jad_tg);
    }

    public jad_cp getStorageVideoByUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.RENDER_SPLASH_VIDEO_GW_RESPONSE_URL_NULL_ERROR;
            jad_fs.jad_an("", 10, jad_anVar.jad_an, jad_anVar.jad_an(new String[0]), 0);
            return null;
        }
        Application applicationJad_an = com.jd.ad.sdk.jad_fq.jad_cp.jad_an();
        if (applicationJad_an != null) {
            if (jad_jw.jad_dq(applicationJad_an)) {
                if (sDataBaseVideoStorage == null) {
                    com.jd.ad.sdk.jad_mz.jad_an jad_anVarJad_an = com.jd.ad.sdk.jad_mz.jad_an.jad_an(applicationJad_an, "jaddb.db", 2);
                    sDataBaseVideoStorage = jad_anVarJad_an;
                    jad_anVarJad_an.jad_cp();
                }
                this.mRenderVideoList = sDataBaseVideoStorage.jad_bo(this.mAppIdPid);
            } else {
                this.mRenderVideoList = com.jd.ad.sdk.jad_tg.jad_an.jad_bo(this.mAppIdPid);
            }
        }
        List<jad_cp> list = this.mRenderVideoList;
        if (list != null && list.size() != 0) {
            for (jad_cp jad_cpVar : this.mRenderVideoList) {
                if (jad_cpVar != null && jad_cpVar.jad_cp.equals(str)) {
                    return jad_cpVar;
                }
            }
        }
        return null;
    }

    public void updateVideoData(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str)) {
            return;
        }
        WorkExecutor.execute(new jad_bo(this, new jad_cp(0, str, str2, str3, System.currentTimeMillis() + "")));
    }
}
