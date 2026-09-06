package com.jd.ad.sdk.dl.cache.multiprocess;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.huawei.hms.actions.SearchIntents;
import com.jd.ad.sdk.fdt.utils.ANEProxy;
import com.jd.ad.sdk.jad_hu.jad_bo;
import com.jd.ad.sdk.jad_kx.jad_an;
import com.jd.ad.sdk.jad_xk.jad_cp;
import com.jd.ad.sdk.jad_xk.jad_dq;
import com.jd.ad.sdk.jad_xk.jad_fs;
import com.ubixnow.ooooo.oOOOoo00;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class JADMultiProvider extends ContentProvider {
    public static jad_bo jad_an;
    public static jad_cp jad_bo;
    public static jad_an jad_cp;
    public static com.jd.ad.sdk.jad_mz.jad_an jad_dq;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        String[] strArrSplit;
        if (uri != null) {
            String strJad_an = com.jd.ad.sdk.jad_tg.jad_an.jad_an(uri);
            if (!TextUtils.isEmpty(strJad_an)) {
                strJad_an.getClass();
                strJad_an.hashCode();
                switch (strJad_an) {
                    case "db_preload_ad":
                        try {
                            if (!TextUtils.isEmpty(str) && strArr != null) {
                                jad_bo();
                                jad_cp.jad_an(str, strArr);
                            }
                            break;
                        } catch (Exception e) {
                            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_PRELOAD_AD_DELETE_ERROR;
                            jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
                            break;
                        }
                        break;
                    case "db_event":
                        try {
                            if (!TextUtils.isEmpty(str) && strArr != null) {
                                jad_an();
                                jad_bo.jad_an(str, strArr);
                            }
                            break;
                        } catch (Exception e2) {
                            com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_CONTENT_PROVIDER_DELETE_EVENT_ERROR;
                            jad_fs.jad_an("", jad_anVar2.jad_an, jad_anVar2.jad_an(e2.getMessage()));
                            break;
                        }
                        break;
                    case "sp_jadyunsdk":
                        try {
                            if (!TextUtils.isEmpty(uri.getPath()) && (strArrSplit = uri.getPath().split("/")) != null && strArrSplit.length > 4) {
                                com.jd.ad.sdk.jad_uh.jad_bo.jad_an.jad_an.jad_an(strArrSplit[3]);
                            }
                            break;
                        } catch (Exception e3) {
                            com.jd.ad.sdk.jad_wj.jad_an jad_anVar3 = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_CONTENT_PROVIDER_DELETE_SP_ERROR;
                            jad_fs.jad_an("", jad_anVar3.jad_an, jad_anVar3.jad_an(e3.getMessage()));
                            break;
                        }
                        break;
                }
            }
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        String[] strArrSplit;
        try {
            if (!TextUtils.isEmpty(uri.getPath()) && (strArrSplit = uri.getPath().split("/")) != null) {
                String str = strArrSplit.length >= 2 ? strArrSplit[1] : "";
                String str2 = strArrSplit.length >= 3 ? strArrSplit[2] : "";
                if (!TextUtils.isEmpty(str) && str.equals("sp_jadyunsdk")) {
                    if (str2.equals("get")) {
                        if (strArrSplit.length >= 5) {
                            return (String) com.jd.ad.sdk.jad_uh.jad_bo.jad_an.jad_an.jad_an(strArrSplit[4], String.class);
                        }
                    } else if (str2.equals("contain") && strArrSplit.length >= 4) {
                        return String.valueOf(com.jd.ad.sdk.jad_uh.jad_bo.jad_an.jad_an.jad_an(strArrSplit[3], false));
                    }
                }
            }
        } catch (Exception e) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_CONTENT_PROVIDER_GET_TYPE_ERROR;
            jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
        }
        return "";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        String strJad_an = com.jd.ad.sdk.jad_tg.jad_an.jad_an(uri);
        if (TextUtils.isEmpty(strJad_an) || !strJad_an.equals("sp_jadyunsdk") || contentValues == null) {
            return null;
        }
        try {
            com.jd.ad.sdk.jad_uh.jad_bo.jad_an.jad_an.jad_an((String) contentValues.get("key"), contentValues.get(oOOOoo00.OooOo0o));
            return null;
        } catch (Exception e) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_CONTENT_PROVIDER_INSERT_SP_ERROR;
            jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        String[] strArrSplit = uri.getPath().split("/");
        if (strArrSplit != null) {
            String str3 = strArrSplit.length >= 2 ? strArrSplit[1] : "";
            String str4 = strArrSplit.length >= 3 ? strArrSplit[2] : "";
            if (!TextUtils.isEmpty(str3)) {
                str3.getClass();
                str3.hashCode();
                switch (str3) {
                    case "db_video_render":
                        if (!TextUtils.isEmpty(str4) && str4.equals(SearchIntents.EXTRA_QUERY)) {
                            try {
                                if (jad_dq == null) {
                                    com.jd.ad.sdk.jad_mz.jad_an jad_anVarJad_an = com.jd.ad.sdk.jad_mz.jad_an.jad_an(com.jd.ad.sdk.jad_fq.jad_cp.jad_an(), "jaddb.db", 2);
                                    jad_dq = jad_anVarJad_an;
                                    jad_anVarJad_an.jad_cp();
                                }
                                String str5 = strArrSplit.length >= 4 ? strArrSplit[3] : "";
                                jad_cp();
                                List<com.jd.ad.sdk.jad_ly.jad_cp> listJad_bo = jad_dq.jad_bo(str5);
                                MatrixCursor matrixCursor = new MatrixCursor(new String[]{"_id", "videoUrl", "videoLocalPath", "timeStampInterval"});
                                ArrayList<com.jd.ad.sdk.jad_ly.jad_cp> arrayList = (ArrayList) listJad_bo;
                                if (arrayList.size() > 0) {
                                    for (com.jd.ad.sdk.jad_ly.jad_cp jad_cpVar : arrayList) {
                                        if (jad_cpVar != null) {
                                            matrixCursor.addRow(new Object[]{Integer.valueOf(jad_cpVar.jad_an), jad_cpVar.jad_cp, jad_cpVar.jad_dq, jad_cpVar.jad_er});
                                        }
                                        break;
                                    }
                                }
                                return matrixCursor;
                            } catch (Exception e) {
                                com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_CONTENT_PROVIDER_QUERY_TEMPLATE_ERROR;
                                jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
                            }
                            break;
                        }
                        break;
                    case "db_dynamic_render":
                        if (!TextUtils.isEmpty(str4) && str4.equals(SearchIntents.EXTRA_QUERY)) {
                            try {
                                String str6 = strArrSplit.length >= 4 ? strArrSplit[3] : "";
                                jad_cp();
                                List<com.jd.ad.sdk.jad_hu.jad_cp> listJad_an = jad_an.jad_an(str6);
                                MatrixCursor matrixCursor2 = new MatrixCursor(new String[]{"_id", "templateID", "templateUpdateTimeStamp", "templateJSON", "timeStampInterval"});
                                ArrayList<com.jd.ad.sdk.jad_hu.jad_cp> arrayList2 = (ArrayList) listJad_an;
                                if (arrayList2.size() > 0) {
                                    for (com.jd.ad.sdk.jad_hu.jad_cp jad_cpVar2 : arrayList2) {
                                        if (jad_cpVar2 != null) {
                                            matrixCursor2.addRow(new Object[]{Integer.valueOf(jad_cpVar2.jad_an), Integer.valueOf(jad_cpVar2.jad_cp), jad_cpVar2.jad_dq, jad_cpVar2.jad_er, jad_cpVar2.jad_fs});
                                        }
                                        break;
                                    }
                                }
                                return matrixCursor2;
                            } catch (Exception e2) {
                                com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_CONTENT_PROVIDER_QUERY_TEMPLATE_ERROR;
                                jad_fs.jad_an("", jad_anVar2.jad_an, jad_anVar2.jad_an(e2.getMessage()));
                                return null;
                            }
                        }
                        break;
                    case "db_preload_ad":
                        if (!TextUtils.isEmpty(str4) && str4.equals(SearchIntents.EXTRA_QUERY)) {
                            try {
                                jad_bo();
                                String str7 = strArrSplit.length >= 4 ? strArrSplit[3] : "";
                                return !TextUtils.isEmpty(str7) ? jad_cp.jad_bo(str7) : jad_cp.jad_er();
                            } catch (Exception e3) {
                                com.jd.ad.sdk.jad_wj.jad_an jad_anVar3 = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_PRELOAD_AD_QUERY_ERROR;
                                jad_fs.jad_an("", jad_anVar3.jad_an, jad_anVar3.jad_an(e3.getMessage()));
                                return null;
                            }
                        }
                        break;
                    case "db_event":
                        if (!TextUtils.isEmpty(str4) && SearchIntents.EXTRA_QUERY.equals(str4)) {
                            try {
                                String str8 = strArrSplit.length >= 4 ? strArrSplit[3] : "";
                                jad_an();
                                return jad_bo.jad_an(str8);
                            } catch (Exception e4) {
                                com.jd.ad.sdk.jad_wj.jad_an jad_anVar4 = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_CONTENT_PROVIDER_QUERY_EVENT_ERROR;
                                jad_fs.jad_an("", jad_anVar4.jad_an, jad_anVar4.jad_an(e4.getMessage()));
                                return null;
                            }
                        }
                        break;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        String strJad_an = com.jd.ad.sdk.jad_tg.jad_an.jad_an(uri);
        if (!TextUtils.isEmpty(strJad_an)) {
            strJad_an.getClass();
            strJad_an.hashCode();
            switch (strJad_an) {
                case "db_dynamic_render":
                    if (contentValues != null) {
                        try {
                            com.jd.ad.sdk.jad_hu.jad_cp jad_cpVar = new com.jd.ad.sdk.jad_hu.jad_cp(contentValues.getAsInteger("_id").intValue(), contentValues.getAsString("appIdPid"), contentValues.getAsInteger("templateID").intValue(), contentValues.getAsString("templateUpdateTimeStamp"), contentValues.getAsString("templateJSON"), contentValues.getAsString("timeStampInterval"));
                            jad_cp();
                            jad_bo jad_boVar = jad_an;
                            if (jad_boVar != null) {
                                jad_boVar.jad_an(jad_cpVar);
                            }
                        } catch (Exception e) {
                            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_CONTENT_PROVIDER_UPDATE_TEMPLATE_ERROR;
                            jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
                        }
                        break;
                    }
                    break;
                case "db_preload_ad":
                    if (contentValues != null) {
                        try {
                            jad_bo();
                            if (jad_cp != null) {
                                jad_cp.jad_an(new com.jd.ad.sdk.jad_kx.jad_cp(contentValues.containsKey("_id") ? contentValues.getAsInteger("_id").intValue() : 0, contentValues.getAsString("appIdSlotId"), contentValues.getAsString("rId"), ANEProxy.jb(contentValues.getAsString("preloadAdJson")), contentValues.getAsString("preloadAdCacheTimeStamp")));
                            }
                        } catch (Exception e2) {
                            com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_PRELOAD_AD_UPDATE_ERROR;
                            jad_fs.jad_an("", jad_anVar2.jad_an, jad_anVar2.jad_an(e2.getMessage()));
                        }
                        break;
                    }
                    break;
                case "db_event":
                    if (contentValues != null) {
                        try {
                            String asString = contentValues.getAsString(NotificationCompat.CATEGORY_EVENT);
                            String asString2 = contentValues.getAsString(ContentProviderManager.PLUGIN_PROCESS_NAME);
                            int iIntValue = contentValues.getAsInteger("key").intValue();
                            if (!TextUtils.isEmpty(asString2) && !TextUtils.isEmpty(asString)) {
                                new JSONObject(asString);
                                jad_dq jad_dqVar = new jad_dq(iIntValue, asString);
                                jad_an();
                                jad_bo.jad_an(jad_dqVar, asString2);
                            }
                        } catch (Exception e3) {
                            com.jd.ad.sdk.jad_wj.jad_an jad_anVar3 = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_CONTENT_PROVIDER_UPDATE_EVENT_ERROR;
                            jad_fs.jad_an("", jad_anVar3.jad_an, jad_anVar3.jad_an(e3.getMessage()));
                        }
                        break;
                    }
                    break;
                case "sp_jadyunsdk":
                    insert(uri, contentValues);
                    break;
            }
        }
        return 0;
    }

    public final void jad_an() {
        jad_cp jad_cpVar;
        if (jad_bo == null) {
            Application applicationJad_an = com.jd.ad.sdk.jad_fq.jad_cp.jad_an();
            synchronized (jad_cp.class) {
                if (jad_cp.jad_bo == null) {
                    jad_cp.jad_bo = new jad_cp(applicationJad_an, "jaddb.db", 2);
                }
                jad_cpVar = jad_cp.jad_bo;
            }
            jad_bo = jad_cpVar;
            jad_cpVar.jad_cp();
        }
    }

    public final void jad_bo() {
        if (jad_cp == null) {
            jad_an jad_anVarJad_dq = jad_an.jad_dq();
            jad_cp = jad_anVarJad_dq;
            jad_anVarJad_dq.jad_cp();
        }
    }

    public final void jad_cp() {
        if (jad_an == null) {
            jad_bo jad_boVarJad_an = jad_bo.jad_an(com.jd.ad.sdk.jad_fq.jad_cp.jad_an(), "jaddb.db", 2);
            jad_an = jad_boVarJad_an;
            jad_boVarJad_an.jad_cp();
        }
    }
}
