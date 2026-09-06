package com.byazt.zl;

import android.net.Uri;
import android.text.TextUtils;
import com.byazt.c.gr;
import com.byazt.c.yp;
import com.byazt.ev.DownloadStatus;
import com.byazt.hs.i;
import com.byazt.hs.n;
import com.byazt.m.BaseException;
import com.byazt.m.sp;
import com.byazt.nr.m;
import com.byazt.t.DownloadInfo;
import com.byazt.t.DownloadTask;
import com.byazt.zz.nu;
import com.hihonor.adsdk.base.g.j.e.a;
import com.huawei.hms.adapter.internal.CommonCode;
import com.ubixnow.ooooo.o0OO000o;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1945, 20})
public class c {
    public static void c(DownloadTask downloadTask, BaseException baseException, int i) {
        if (downloadTask == null) {
            return;
        }
        try {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo == null) {
                return;
            }
            gr monitorDepend = downloadTask.getMonitorDepend();
            boolean zIsMonitorStatus = DownloadStatus.isMonitorStatus(i);
            if (!zIsMonitorStatus && !(zIsMonitorStatus = c(downloadInfo.getExtraMonitorStatus(), i)) && monitorDepend != null && (monitorDepend instanceof com.byazt.c.ve)) {
                zIsMonitorStatus = c(((com.byazt.c.ve) monitorDepend).c(), i);
            }
            if (zIsMonitorStatus) {
                try {
                    yp depend = downloadTask.getDepend();
                    if (depend != null) {
                        depend.c(downloadInfo, baseException, i);
                    }
                } catch (Throwable th) {
                    m.c(th);
                }
                c(monitorDepend, downloadInfo, baseException, i);
                c(com.byazt.zz.ve.sp(), downloadInfo, baseException, i);
            }
        } catch (Throwable th2) {
            m.c(th2);
        }
    }

    private static boolean c(int[] iArr, int i) {
        if (iArr != null && iArr.length > 0) {
            for (int i2 : iArr) {
                if (i == i2) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void c(gr grVar, DownloadInfo downloadInfo, BaseException baseException, int i) {
        if (grVar == null) {
            return;
        }
        try {
            String strTt = grVar.tt();
            if (TextUtils.isEmpty(strTt)) {
                strTt = "default";
            }
            JSONObject jSONObjectC = c(strTt, downloadInfo, baseException, i);
            if (jSONObjectC == null) {
                jSONObjectC = new JSONObject();
            }
            grVar.c(jSONObjectC);
        } catch (Throwable unused) {
        }
    }

    public static void c(tt ttVar, DownloadInfo downloadInfo, BaseException baseException, int i) {
        if (ttVar == null || !downloadInfo.isNeedSDKMonitor() || TextUtils.isEmpty(downloadInfo.getMonitorScene())) {
            return;
        }
        try {
            JSONObject jSONObjectC = c(downloadInfo.getMonitorScene(), downloadInfo, baseException, i);
            if (jSONObjectC == null) {
                jSONObjectC = new JSONObject();
            }
            if (i == -1) {
                jSONObjectC.put("status", baseException.getErrorCode());
            } else {
                c(i, jSONObjectC, downloadInfo);
            }
        } catch (Throwable th) {
            m.c(th);
        }
    }

    private static void c(int i, JSONObject jSONObject, DownloadInfo downloadInfo) throws JSONException {
        String str;
        if (i == -5) {
            str = "download_uncomplete";
        } else if (i == -4) {
            str = "download_cancel";
        } else if (i == -3) {
            double downloadSpeed = downloadInfo.getDownloadSpeed();
            if (downloadSpeed >= 0.0d) {
                jSONObject.put("download_speed", downloadSpeed);
            }
            str = "download_success";
        } else if (i == -2) {
            str = "download_pause";
        } else if (i == 0) {
            str = "download_create";
        } else if (i != 2) {
            str = i != 6 ? "" : "download_first_start";
        } else {
            str = "download_start";
        }
        jSONObject.put("status", str);
    }

    public static String c(String str) {
        try {
            return TextUtils.isDigitsOnly(str) ? String.valueOf(Long.valueOf(str).longValue() % 100) : "";
        } catch (Exception e) {
            m.c(e);
            return "";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r2v1, types: [org.json.JSONObject] */
    private static JSONObject c(String str, DownloadInfo downloadInfo, BaseException baseException, int i) {
        String strTt;
        String strC;
        String strC2;
        int iVe;
        String lastPathSegment;
        String host;
        String path;
        ?? r1 = 0;
        try {
            ?? jSONObject = new JSONObject();
            try {
                nu nuVarSl = com.byazt.zz.ve.sl();
                if (nuVarSl != null) {
                    strTt = nuVarSl.tt();
                    strC = c(strTt);
                    strC2 = nuVarSl.c();
                    iVe = nuVarSl.ve();
                } else {
                    strTt = "";
                    strC = strTt;
                    strC2 = strC;
                    iVe = 0;
                }
                String strC3 = (baseException == null || !(baseException instanceof sp)) ? "" : ((sp) baseException).c();
                jSONObject.put("event_page", str);
                jSONObject.put("app_id", strC2);
                jSONObject.put("device_id", strTt);
                jSONObject.put("device_id_postfix", strC);
                jSONObject.put(CommonCode.MapKey.UPDATE_VERSION, iVe);
                jSONObject.put("download_status", i);
                if (downloadInfo != null) {
                    jSONObject.put("setting_tag", com.byazt.k.c.c(downloadInfo.getId()).ve("setting_tag"));
                    jSONObject.put("download_id", downloadInfo.getId());
                    jSONObject.put("name", downloadInfo.getName());
                    jSONObject.put("url", downloadInfo.getUrl());
                    jSONObject.put("save_path", downloadInfo.getSavePath());
                    jSONObject.put("download_time", downloadInfo.getDownloadTime());
                    jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
                    jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
                    jSONObject.put("network_quality", downloadInfo.getNetworkQuality());
                    jSONObject.put("only_wifi", downloadInfo.isOnlyWifi() ? 1 : 0);
                    jSONObject.put("need_https_degrade", downloadInfo.isNeedHttpsToHttpRetry() ? 1 : 0);
                    jSONObject.put("https_degrade_retry_used", downloadInfo.isHttpsToHttpRetryUsed() ? 1 : 0);
                    jSONObject.put("md5", downloadInfo.getMd5() == null ? "" : downloadInfo.getMd5());
                    jSONObject.put("chunk_count", downloadInfo.getChunkCount());
                    jSONObject.put("is_force", downloadInfo.isForce() ? 1 : 0);
                    jSONObject.put("retry_count", downloadInfo.getRetryCount());
                    jSONObject.put("cur_retry_time", downloadInfo.getCurRetryTime());
                    jSONObject.put("need_retry_delay", downloadInfo.isNeedRetryDelay() ? 1 : 0);
                    jSONObject.put("need_reuse_first_connection", downloadInfo.isNeedReuseFirstConnection() ? 1 : 0);
                    jSONObject.put("default_http_service_backup", downloadInfo.isNeedDefaultHttpServiceBackUp() ? 1 : 0);
                    jSONObject.put("retry_delay_status", downloadInfo.getRetryDelayStatus().ordinal());
                    jSONObject.put("backup_url_used", downloadInfo.isBackUpUrlUsed() ? 1 : 0);
                    jSONObject.put("download_byte_error_retry_status", downloadInfo.getByteInvalidRetryStatus().ordinal());
                    jSONObject.put("forbidden_handler_status", downloadInfo.getAsyncHandleStatus().ordinal());
                    jSONObject.put("need_independent_process", downloadInfo.isNeedIndependentProcess() ? 1 : 0);
                    jSONObject.put("head_connection_error_msg", downloadInfo.getHeadConnectionException() != null ? downloadInfo.getHeadConnectionException() : "");
                    jSONObject.put("extra", downloadInfo.getExtra() != null ? downloadInfo.getExtra() : "");
                    jSONObject.put("add_listener_to_same_task", downloadInfo.isAddListenerToSameTask() ? 1 : 0);
                    jSONObject.put("backup_url_count", downloadInfo.getBackUpUrls() != null ? downloadInfo.getBackUpUrls().size() : 0);
                    jSONObject.put("cur_backup_url_index", downloadInfo.getBackUpUrls() != null ? downloadInfo.getCurBackUpUrlIndex() : -1);
                    jSONObject.put("forbidden_urls", downloadInfo.getForbiddenBackupUrls() != null ? downloadInfo.getForbiddenBackupUrls().toString() : "");
                    jSONObject.put("task_id", TextUtils.isEmpty(downloadInfo.getTaskId()) ? "" : downloadInfo.getTaskId());
                    try {
                        String url = downloadInfo.getUrl();
                        if (TextUtils.isEmpty(url)) {
                            lastPathSegment = "";
                            host = lastPathSegment;
                            path = host;
                        } else {
                            Uri uri = Uri.parse(url);
                            host = uri.getHost();
                            path = uri.getPath();
                            lastPathSegment = uri.getLastPathSegment();
                            if (!TextUtils.isEmpty(path) && !TextUtils.isEmpty(lastPathSegment)) {
                                try {
                                    path = path.substring(0, path.length() - lastPathSegment.length());
                                } catch (Throwable th) {
                                    m.c(th);
                                }
                            }
                        }
                        jSONObject.put("url_host", host);
                        jSONObject.put("url_path", path);
                        jSONObject.put("url_last_path_segment", lastPathSegment);
                    } catch (Throwable th2) {
                        m.c(th2);
                    }
                }
                jSONObject.put("error_code", baseException != null ? baseException.getErrorCode() : 0);
                jSONObject.put(a.hnadst, baseException != null ? baseException.getErrorMessage() : "");
                jSONObject.put("request_log", strC3);
                return jSONObject;
            } catch (JSONException e) {
                e = e;
                r1 = jSONObject;
                m.c(e);
                return r1;
            }
        } catch (JSONException e2) {
            e = e2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x003c A[PHI: r8
  0x003c: PHI (r8v8 int) = (r8v0 int), (r8v2 int) binds: [B:12:0x0023, B:19:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    public static void c(com.byazt.hs.sp spVar, String str, String str2, long j, String str3, int i, IOException iOException, DownloadInfo downloadInfo) {
        com.byazt.k.c cVarC;
        int iC;
        String strN;
        int httpStatusCode;
        if (downloadInfo == null || (iC = (cVarC = com.byazt.k.c.c(downloadInfo.getId())).c("monitor_download_connect", 0)) <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        String errorMessage = null;
        int iTt = -1;
        try {
            if (spVar != null) {
                try {
                    iTt = spVar.tt();
                } catch (Throwable th) {
                    m.c(th);
                }
                if (spVar instanceof com.byazt.hs.c) {
                    strN = ((com.byazt.hs.c) spVar).n();
                } else {
                    strN = null;
                }
            } else {
                strN = null;
            }
            String strC = "";
            if (iTt < 200 || iTt >= 400) {
                if (downloadInfo.getCurRetryTime() != 0 && ((httpStatusCode = downloadInfo.getHttpStatusCode()) < 200 || httpStatusCode >= 400)) {
                    return;
                }
                if (iOException != null) {
                    if (com.byazt.w.a.ve(com.byazt.zz.ve.ic())) {
                        try {
                            com.byazt.w.a.c((Throwable) iOException, "");
                        } catch (BaseException e) {
                            iTt = e.getErrorCode();
                            errorMessage = e.getErrorMessage();
                            if (e instanceof sp) {
                                strC = ((sp) e).c();
                            }
                        }
                    } else {
                        iTt = 1049;
                    }
                }
            }
            Uri uri = Uri.parse(str);
            String host = uri.getHost();
            String path = uri.getPath();
            String lastPathSegment = uri.getLastPathSegment();
            if (!TextUtils.isEmpty(path) && !TextUtils.isEmpty(lastPathSegment)) {
                try {
                    path = path.substring(0, path.length() - lastPathSegment.length());
                } catch (Throwable unused) {
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("setting_tag", cVarC.ve("setting_tag"));
                jSONObject.put("url_host", host);
                jSONObject.putOpt("host_ip", str2);
                jSONObject.putOpt("host_real_ip", strN);
                jSONObject.put("url_path", path);
                jSONObject.put("url_last_path_segment", lastPathSegment);
                jSONObject.put("net_lib", i);
                jSONObject.put("connect_type", str3);
                jSONObject.put(o0OO000o.o000o0oo, iTt);
                jSONObject.put("request_log", strC);
                if (errorMessage != null) {
                    jSONObject.put(a.hnadst, com.byazt.w.a.c(errorMessage, cVarC.c("exception_msg_length", 500)));
                }
                jSONObject.put("connect_time", j);
                jSONObject.put(com.hihonor.adsdk.base.download.marketdownload.a.hnadse, downloadInfo.getPackageName());
                jSONObject.put("name", downloadInfo.getTitle());
            } catch (JSONException e2) {
                m.c(e2);
            }
            if (iC == 1 || iC == 3) {
                com.byazt.zz.ve.sp();
            }
            if (iC == 2 || iC == 3) {
                com.byazt.zz.ve.bm().c(downloadInfo.getId(), "download_connect", jSONObject);
            }
        } catch (Throwable th2) {
            m.c(th2);
        }
    }

    public static void c(com.byazt.k.c cVar, DownloadInfo downloadInfo, String str, i iVar, boolean z, boolean z2, BaseException baseException, long j, long j2, boolean z3, long j3, long j4, long j5, JSONObject jSONObject) {
        c("download_io", cVar.tt("monitor_download_io"), cVar, downloadInfo, str, null, null, iVar, z, z2, baseException, j, j2, z3, j3, j4, j5, null);
    }

    public static void c(com.byazt.k.c cVar, DownloadInfo downloadInfo, String str, String str2, String str3, boolean z, i iVar, BaseException baseException, long j, long j2) {
        c("segment_io", cVar.tt("monitor_segment_io"), cVar, downloadInfo, str, str2, str3, iVar, z, false, baseException, j, j2, false, -1L, -1L, -1L, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r23v3 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    private static void c(String str, int i, com.byazt.k.c cVar, DownloadInfo downloadInfo, String str2, String str3, String str4, i iVar, boolean z, boolean z2, BaseException baseException, long j, long j2, boolean z3, long j3, long j4, long j5, JSONObject jSONObject) {
        int i2;
        int i3;
        if (i <= 0 || j2 <= 0) {
            return;
        }
        try {
            Uri uri = Uri.parse(str2);
            String host = uri.getHost();
            String path = uri.getPath();
            String lastPathSegment = uri.getLastPathSegment();
            int errorCode = 0;
            if (!TextUtils.isEmpty(path) && !TextUtils.isEmpty(lastPathSegment)) {
                try {
                    path = path.substring(0, path.length() - lastPathSegment.length());
                } catch (Throwable unused) {
                }
            }
            String errorMessage = null;
            if (z) {
                errorCode = 1;
            } else if (z2) {
                errorCode = 2;
            } else if (baseException != null) {
                errorCode = !com.byazt.w.a.ve(com.byazt.zz.ve.ic()) ? 1049 : baseException.getErrorCode();
                errorMessage = baseException.getErrorMessage();
            }
            JSONObject jSONObject2 = new JSONObject();
            String strA = "";
            if (iVar != null) {
                i3 = !(iVar instanceof n) ? 1 : 0;
                String strC = iVar.c("X-Cache");
                ?? Contains = !TextUtils.isEmpty(strC) ? strC.toLowerCase().contains("hit") : -1;
                cVar.c("monitor_sla", 1);
                strA = iVar instanceof com.byazt.hs.c ? ((com.byazt.hs.c) iVar).a() : "";
                i2 = Contains == true ? 1 : 0;
            } else {
                i2 = -1;
                i3 = -1;
            }
            double d = j / 1048576.0d;
            double d2 = j2;
            double nanos = d2 / TimeUnit.SECONDS.toNanos(1L);
            jSONObject2.put("setting_tag", cVar.ve("setting_tag"));
            jSONObject2.put("url_host", host);
            jSONObject2.putOpt("host_ip", str3);
            jSONObject2.putOpt("host_real_ip", str4);
            jSONObject2.put("url_path", path);
            jSONObject2.put("url_last_path_segment", lastPathSegment);
            jSONObject2.put("net_lib", i3);
            jSONObject2.put("hit_cdn_cache", i2);
            jSONObject2.put(o0OO000o.o000o0oo, errorCode);
            jSONObject2.put("request_log", strA);
            if (errorMessage != 0) {
                jSONObject2.put(a.hnadst, com.byazt.w.a.c(errorMessage, cVar.c("exception_msg_length", 500)));
            }
            jSONObject2.put("download_sec", nanos);
            jSONObject2.put("download_mb", d);
            if (nanos > 0.0d) {
                jSONObject2.put("download_speed", d / nanos);
            }
            if (z3) {
                jSONObject2.put("rw_read_time", j3 / d2);
                jSONObject2.put("rw_write_time", j4 / d2);
                jSONObject2.put("rw_sync_time", j5 / d2);
            }
            jSONObject2.put(com.hihonor.adsdk.base.download.marketdownload.a.hnadse, downloadInfo.getPackageName());
            jSONObject2.put("name", downloadInfo.getTitle());
            if (i == 1 || i == 3) {
                com.byazt.zz.ve.sp();
            }
            if (i == 2 || i == 3) {
                com.byazt.zz.ve.bm().c(downloadInfo.getId(), str, jSONObject2);
            }
        } catch (Throwable th) {
            m.c(th);
        }
    }

    public static void c(DownloadInfo downloadInfo, List<com.byazt.h.i> list) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("segments", com.byazt.h.i.c(list));
            jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
            jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
            ve veVarBm = com.byazt.zz.ve.bm();
            if (veVarBm != null) {
                veVarBm.c(downloadInfo.getId(), "segments_error", jSONObject);
            }
        } catch (Throwable th) {
            m.c(th);
        }
    }
}
