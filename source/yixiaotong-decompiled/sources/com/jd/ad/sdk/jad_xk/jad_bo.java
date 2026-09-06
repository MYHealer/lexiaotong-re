package com.jd.ad.sdk.jad_xk;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.jd.ad.sdk.jad_zm.jad_ly;
import com.jd.ad.sdk.jad_zm.jad_mz;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.multi.BuildConfig;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.UndeclaredThrowableException;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: CrashEventReporter.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_bo implements Thread.UncaughtExceptionHandler {
    public SharedPreferences jad_an;
    public Thread.UncaughtExceptionHandler jad_bo;

    /* JADX INFO: compiled from: CrashEventReporter.java */
    public class jad_an implements jad_ly.jad_an {
        public jad_an() {
        }

        @Override // com.jd.ad.sdk.jad_zm.jad_ly.jad_an
        public void jad_an(jad_mz jad_mzVar) {
            jad_bo.this.jad_an.edit().clear().commit();
            Logger.d("crash report success " + jad_mzVar.toString());
        }

        @Override // com.jd.ad.sdk.jad_zm.jad_ly.jad_an
        public void jad_an(int i, String str) {
            Logger.d("crash report fail " + i + ",  " + str);
        }
    }

    /* JADX INFO: renamed from: com.jd.ad.sdk.jad_xk.jad_bo$jad_bo, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CrashEventReporter.java */
    public static class C0588jad_bo {
        public static final jad_bo jad_an = new jad_bo();
    }

    public final synchronized void jad_an() {
        com.jd.ad.sdk.jad_pc.jad_cp jad_cpVarJad_cp = com.jd.ad.sdk.jad_re.jad_an.jad_cp();
        SharedPreferences sharedPreferences = this.jad_an;
        if (sharedPreferences != null && jad_cpVarJad_cp != null && jad_cpVarJad_cp.jad_bo != null) {
            if (com.jd.ad.sdk.jad_vi.jad_an.jad_bo) {
                return;
            }
            Map<String, ?> all = sharedPreferences.getAll();
            Logger.d(com.jd.ad.sdk.jad_bo.jad_bo.jad_an("crash uploadCrash size: ").append(all.size()).toString());
            if (all.size() == 0) {
                return;
            }
            Logger.d(com.jd.ad.sdk.jad_bo.jad_bo.jad_an("crash uploadCrash size: ").append(all.size()).toString());
            try {
                String str = jad_cpVarJad_cp.jad_bo.jad_an;
                ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
                Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next().getValue();
                    if (!TextUtils.isEmpty(str2)) {
                        String strReplaceAll = str2.replaceAll("\u0001", PPSLabelView.Code);
                        concurrentLinkedQueue.add(jad_iv.jad_an(strReplaceAll, jad_an(strReplaceAll) ? 2 : 1));
                    }
                }
                byte[] bArrJad_an = jad_jt.jad_an(concurrentLinkedQueue);
                if (bArrJad_an == null) {
                    return;
                }
                com.jd.ad.sdk.jad_zm.jad_fs jad_fsVarJad_an = jad_jt.jad_an();
                jad_ly.jad_bo jad_boVarJad_an = com.jd.ad.sdk.jad_zm.jad_bo.jad_an();
                jad_boVarJad_an.jad_fs = new com.jd.ad.sdk.jad_zm.jad_er(bArrJad_an);
                jad_boVarJad_an.jad_bo = jad_fsVarJad_an;
                jad_boVarJad_an.jad_er = str;
                jad_boVarJad_an.jad_jt = new jad_an();
                jad_boVarJad_an.jad_cp = KSImageLoader.InnerImageLoadingListener.MAX_DURATION;
                jad_boVarJad_an.jad_dq = 60000;
                jad_boVarJad_an.jad_an(com.jd.ad.sdk.jad_ep.jad_bo.jad_bo);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final synchronized void jad_bo(Throwable th) {
        SharedPreferences sharedPreferences = this.jad_an;
        if (sharedPreferences == null) {
            return;
        }
        if (sharedPreferences.getAll() != null && this.jad_an.getAll().size() >= 10) {
            return;
        }
        try {
            String strJad_an = jad_an(th);
            if (TextUtils.isEmpty(strJad_an)) {
                return;
            }
            String strConcat = BuildConfig.VERSION_NAME.concat(x.bQ).concat(String.valueOf(com.jd.ad.sdk.jad_wj.jad_an.CRASH_ERROR.jad_an)).concat(x.bQ).concat(strJad_an);
            SharedPreferences.Editor editorEdit = this.jad_an.edit();
            editorEdit.putString(Long.toString(System.currentTimeMillis()), strConcat.trim());
            com.jd.ad.sdk.jad_pc.jad_an jad_anVarJad_an = com.jd.ad.sdk.jad_re.jad_an.jad_an();
            if (jad_anVarJad_an == null) {
                editorEdit.commit();
                Logger.d("crash config is null, catch all errorInfo: " + strConcat);
                jad_an();
                return;
            }
            if (!"1".equals(jad_anVarJad_an.jad_an)) {
                editorEdit.commit();
                Logger.d("crash config's crt is 0, catch all errorInfo: " + strConcat);
                jad_an();
            } else if (jad_an(strConcat)) {
                editorEdit.commit();
                Logger.d("crash config's crt is 1, catch sdk errorInfo: " + strConcat);
                jad_an();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        try {
            if (th != null) {
                try {
                    if (!(th instanceof UndeclaredThrowableException)) {
                        jad_bo(th);
                        uncaughtExceptionHandler = this.jad_bo;
                        if (uncaughtExceptionHandler != null && uncaughtExceptionHandler != this && !(uncaughtExceptionHandler instanceof jad_bo)) {
                        }
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    uncaughtExceptionHandler = this.jad_bo;
                    if (uncaughtExceptionHandler != null && uncaughtExceptionHandler != this && !(uncaughtExceptionHandler instanceof jad_bo)) {
                    }
                }
                uncaughtExceptionHandler.uncaughtException(thread, th);
                return;
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.jad_bo;
            if (uncaughtExceptionHandler2 == null || uncaughtExceptionHandler2 == this || (uncaughtExceptionHandler2 instanceof jad_bo)) {
                return;
            }
            uncaughtExceptionHandler2.uncaughtException(thread, th);
        } catch (Throwable th2) {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler3 = this.jad_bo;
            if (uncaughtExceptionHandler3 != null && uncaughtExceptionHandler3 != this && !(uncaughtExceptionHandler3 instanceof jad_bo)) {
                uncaughtExceptionHandler3.uncaughtException(thread, th);
            }
            throw th2;
        }
    }

    public static String jad_an(Throwable th) {
        for (Throwable th2 = new Throwable(BuildConfig.VERSION_NAME, th); th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof UnknownHostException) {
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        String string = stringWriter.toString();
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        return string.length() > 512000 ? string.substring(string.length() - IoUtils.DEFAULT_IMAGE_TOTAL_SIZE) : string;
    }

    public final boolean jad_an(String str) {
        return str.contains("com.jd.ad.sdk") || str.contains("jad") || str.contains("JAD");
    }
}
