package com.adprof.sdk;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.widget.Toast;
import com.bytedance.pangle.provider.ContentProviderManager;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class o8 extends BroadcastReceiver {
    /* JADX WARN: Code duplicated, block: B:22:0x0091  */
    /* JADX WARN: Code duplicated, block: B:41:0x016c  */
    /* JADX WARN: Code duplicated, block: B:59:? A[RETURN, SYNTHETIC] */
    public final void a(Context context, long j, d dVar) {
        Cursor cursorQuery;
        HashMap map;
        String str;
        n5 n5VarM590a;
        String str2;
        int iIntValue;
        int iIntValue2;
        Uri uri;
        Map map2 = n8.f1321a;
        try {
            DownloadManager downloadManagerA = n8.a();
            if (downloadManagerA != null) {
                DownloadManager.Query query = new DownloadManager.Query();
                query.setFilterById(j);
                Uri uriForDownloadedFile = downloadManagerA.getUriForDownloadedFile(j);
                cursorQuery = downloadManagerA.query(query);
                try {
                    if (cursorQuery.moveToFirst()) {
                        int i = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("status"));
                        int i2 = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("reason"));
                        String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("local_uri"));
                        map = new HashMap();
                        map.put("fileName", string);
                        map.put("status", Integer.valueOf(i));
                        map.put(ContentProviderManager.PROVIDER_URI, uriForDownloadedFile);
                        map.put("reason", Integer.valueOf(i2));
                        cursorQuery.close();
                    } else {
                        cursorQuery.close();
                        cursorQuery.close();
                        map = null;
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        pk.b("getDownloadInfoWithDownloadID error", th);
                        if (cursorQuery != null) {
                        }
                        map = null;
                        qn.a(dVar, "download_end");
                        oh.a("download_end", "", dVar);
                        str = "download is exception";
                        if (map != null) {
                            str2 = (String) map.get("fileName");
                            iIntValue = ((Integer) map.get("status")).intValue();
                            iIntValue2 = ((Integer) map.get("reason")).intValue();
                            uri = (Uri) map.get(ContentProviderManager.PROVIDER_URI);
                            if (str2 == null) {
                            }
                            try {
                                str = String.format("status %d, reason %d", Integer.valueOf(iIntValue), Integer.valueOf(iIntValue2));
                                pk.c("----handleDownloadComplete  fail:" + j9.m658a(j9.a(context, uri)));
                            } catch (Throwable th2) {
                                pk.b("DownloadCompleteReceiver handle complete error2: ", th2);
                            }
                        }
                        Toast.makeText(context, "下载失败", 0).show();
                        final HashMap map3 = new HashMap();
                        map3.put("result", "0");
                        map3.put("reason", str);
                        map3.put("downloadId", Long.valueOf(j));
                        s5.a(dVar.k(), map3, "action.ad.download.fail", 0);
                        oh.a("download_failed", "", dVar, null, new nh() { // from class: com.adprof.sdk.o8$$ExternalSyntheticLambda0
                            @Override // com.adprof.sdk.nh
                            public final void a(Object obj) {
                                o8.a(map3, obj);
                            }
                        });
                        pk.d("download fail 2 ....");
                        n5VarM590a = dVar.m590a();
                        if (n5VarM590a != null) {
                            n5VarM590a.b(dVar);
                        }
                    } catch (Throwable th3) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        throw th3;
                    }
                }
            } else {
                map = null;
            }
        } catch (Throwable th4) {
            th = th4;
            cursorQuery = null;
        }
        qn.a(dVar, "download_end");
        oh.a("download_end", "", dVar);
        str = "download is exception";
        if (map != null) {
            str2 = (String) map.get("fileName");
            iIntValue = ((Integer) map.get("status")).intValue();
            iIntValue2 = ((Integer) map.get("reason")).intValue();
            uri = (Uri) map.get(ContentProviderManager.PROVIDER_URI);
            if (str2 == null && iIntValue == 8) {
                try {
                    String strA = j9.a(context, uri);
                    he.a(context, strA);
                    HashMap map4 = new HashMap();
                    map4.put("result", "1");
                    map4.put("downloadId", Long.valueOf(j));
                    s5.a(dVar.k(), map4, "action.ad.download.end", 0);
                    n8.a(context, strA, dVar);
                    return;
                } catch (Throwable th5) {
                    pk.b("DownloadCompleteReceiver handle complete error1: ", th5);
                    return;
                }
            }
            str = String.format("status %d, reason %d", Integer.valueOf(iIntValue), Integer.valueOf(iIntValue2));
            pk.c("----handleDownloadComplete  fail:" + j9.m658a(j9.a(context, uri)));
        }
        try {
            Toast.makeText(context, "下载失败", 0).show();
        } catch (Throwable th6) {
            pk.b("toast error: " + th6.getMessage());
        }
        final HashMap map5 = new HashMap();
        map5.put("result", "0");
        map5.put("reason", str);
        map5.put("downloadId", Long.valueOf(j));
        s5.a(dVar.k(), map5, "action.ad.download.fail", 0);
        oh.a("download_failed", "", dVar, null, new nh() { // from class: com.adprof.sdk.o8$$ExternalSyntheticLambda0
            @Override // com.adprof.sdk.nh
            public final void a(Object obj) {
                o8.a(map5, obj);
            }
        });
        pk.d("download fail 2 ....");
        n5VarM590a = dVar.m590a();
        if (n5VarM590a != null) {
            n5VarM590a.b(dVar);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            a(context, intent);
        } catch (Exception e) {
            pk.b("DownloadCompleteReceiver  ", e);
        }
    }

    public static void a(HashMap map, Object obj) {
        if (obj instanceof fh) {
            try {
                ((mh) ((fh) obj)).f469c = new JSONObject(map).toString();
            } catch (Throwable th) {
                pk.b("1 pointEventRecord put extra error: ", th);
            }
        }
    }

    public final void a(Context context, Intent intent) {
        d dVar;
        long longExtra = intent.getLongExtra("extra_download_id", -1L);
        Iterator it = ((CopyOnWriteArraySet) n8.f516a).iterator();
        while (true) {
            dVar = null;
            if (!it.hasNext()) {
                break;
            }
            m8 m8Var = (m8) it.next();
            if (m8Var.f1302a == longExtra || m8Var.f464a.equalsIgnoreCase(null)) {
                ((CopyOnWriteArraySet) n8.f516a).remove(m8Var);
                break;
            }
        }
        File file = new File(k1.m667a(), longExtra + ".log");
        Object objA = j9.a(file.getAbsolutePath());
        pk.b("adprofsdk", "\n  ===== DownloadCompleteReceiver onReceive download finished 。  downId = " + longExtra + "  === \n ");
        if (file.exists()) {
            pk.b("adprofsdk", "\n  ===== apk log file = " + file.getAbsolutePath() + "  === \n ");
        }
        if (objA instanceof d) {
            dVar = (d) objA;
            d dVarA = h2.a(dVar.k());
            if (dVarA != null) {
                dVar = dVarA;
            }
        }
        j9.m658a(file.getAbsolutePath());
        String action = intent.getAction();
        action.getClass();
        if (action.equals("android.intent.action.DOWNLOAD_COMPLETE") && dVar != null) {
            a(context, longExtra, dVar);
        }
    }
}
