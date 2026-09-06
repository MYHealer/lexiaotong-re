package com.adprof.sdk;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.loopj.android.http.AsyncHttpClient;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class w1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static w1 f1490a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SQLiteDatabase f787a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ii f788a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile boolean f791a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ReadWriteLock f790a = new ReentrantReadWriteLock();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f789a = null;

    public w1() {
        new HashSet();
    }

    public String a() {
        HashMap map;
        String string = null;
        try {
            this.f790a.readLock().lock();
            if (!this.f791a && ((map = this.f789a) == null || map.isEmpty())) {
                JSONArray jSONArray = new JSONArray();
                y6 y6VarA = y6.a();
                if (y6VarA.f849a == 0) {
                    y6VarA.f849a = 5;
                }
                HashMap mapA = a(y6VarA.f849a);
                this.f789a = mapA;
                if (mapA.isEmpty()) {
                    this.f790a.readLock().unlock();
                    return null;
                }
                for (String str : this.f789a.values()) {
                    if (str != null && !TextUtils.isEmpty(str)) {
                        String strTrim = str.trim();
                        if (strTrim.startsWith("{") && strTrim.endsWith(com.alipay.sdk.util.i.d)) {
                            try {
                                jSONArray.put(new JSONObject(str));
                            } catch (Throwable th) {
                                pk.a(th);
                                oh.b(th);
                            }
                        } else {
                            pk.d("非 JSONObject 格式字符串：" + strTrim);
                        }
                    }
                }
                if (jSONArray.length() == 0) {
                    this.f790a.readLock().unlock();
                    return null;
                }
                string = jSONArray.toString();
                try {
                    if (pk.f594a) {
                        pk.d("AdPointManager body: " + string);
                    }
                    if (this.f789a != null) {
                        pk.a("AdPointManager send log count = " + this.f789a.size());
                    }
                    a(jSONArray, true);
                } catch (Throwable th2) {
                    pk.b("AdPoint send server error: ", th2);
                    oh.b(th2);
                }
                return string;
            }
            this.f790a.readLock().unlock();
            return null;
        } catch (Throwable th3) {
            try {
                oh.b(th3);
                pk.b("sendPoint fail ", th3);
            } finally {
                this.f790a.readLock().unlock();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0059 A[Catch: all -> 0x0069, PHI: r6
  0x0059: PHI (r6v2 java.lang.String) = (r6v0 java.lang.String), (r6v3 java.lang.String) binds: [B:14:0x004b, B:16:0x0057] A[DONT_GENERATE, DONT_INLINE], TryCatch #1 {all -> 0x0069, blocks: (B:5:0x0007, B:7:0x0011, B:9:0x0017, B:11:0x002c, B:13:0x0046, B:15:0x004d, B:17:0x0059, B:18:0x005c), top: B:39:0x0007, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0071 A[Catch: all -> 0x007d, PHI: r1
  0x0071: PHI (r1v2 android.database.Cursor) = (r1v1 android.database.Cursor), (r1v3 android.database.Cursor) binds: [B:26:0x006f, B:22:0x0066] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #2 {, blocks: (B:3:0x0001, B:27:0x0071, B:32:0x0079, B:33:0x007c, B:25:0x006a, B:5:0x0007, B:7:0x0011, B:9:0x0017, B:11:0x002c, B:13:0x0046, B:15:0x004d, B:17:0x0059, B:18:0x005c), top: B:41:0x0001, inners: #0, #1 }] */
    public final synchronized HashMap a(int i) {
        HashMap map;
        map = new HashMap();
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = this.f787a.rawQuery("select * from point where item not null order by point_id", null);
            if (cursorRawQuery != null && cursorRawQuery.moveToFirst()) {
                int columnIndex = cursorRawQuery.getColumnIndex("item");
                int columnIndex2 = cursorRawQuery.getColumnIndex("point_id");
                int columnIndex3 = cursorRawQuery.getColumnIndex("encryption");
                for (int i2 = 0; i2 < i; i2++) {
                    String string = cursorRawQuery.getString(columnIndex);
                    Integer numValueOf = Integer.valueOf(cursorRawQuery.getInt(columnIndex2));
                    Integer numValueOf2 = Integer.valueOf(cursorRawQuery.getInt(columnIndex3));
                    if (!TextUtils.isEmpty(string)) {
                        if (numValueOf2.intValue() == 1) {
                            string = a.a(string, "adprof_private_a");
                            if (!TextUtils.isEmpty(string)) {
                                map.put(numValueOf, string);
                            }
                        } else {
                            map.put(numValueOf, string);
                        }
                    }
                    if (!cursorRawQuery.moveToNext()) {
                        break;
                    }
                }
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        } catch (Throwable th) {
            try {
                pk.b("\n\n getLogs fail", th);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            } catch (Throwable th2) {
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                throw th2;
            }
        }
        return map;
    }

    public final void a(long j) {
        try {
            StringBuilder sb = new StringBuilder("delete from point where point_id in (  select point_id from point order by point_id ");
            sb.append(" limit " + j);
            sb.append(" )");
            this.f787a.execSQL(sb.toString());
        } catch (Throwable th) {
            pk.b("clearLogDB fail", th);
        }
    }

    public final void a(JSONArray jSONArray, boolean z) {
        String strEncodeToString;
        this.f791a = true;
        v1 v1Var = new v1(this, z);
        try {
            if (jSONArray.length() == 0) {
                v1Var.invoke(Boolean.TRUE);
                return;
            }
            if (pk.f594a) {
                pk.a("EventReport", "【event upload server】= count=" + jSONArray.length() + ' ' + jSONArray);
            }
            String str = "https://sl.buluken.com/tracking/sl?appid=" + AdprofSdk.getInstance().getAppId();
            String string = jSONArray.toString();
            String appSecret = AdprofSdk.getInstance().getAppSecret();
            Charset charset = g1.f1181a;
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(appSecret)) {
                strEncodeToString = null;
            } else {
                try {
                    try {
                        strEncodeToString = Base64.encodeToString(g1.m630a(string, appSecret), 0);
                    } catch (Exception e) {
                        pk.b(e.getMessage());
                        strEncodeToString = "";
                    }
                } catch (Exception e2) {
                    pk.b(e2.getMessage());
                    strEncodeToString = null;
                }
            }
            long jCurrentTimeMillis = System.currentTimeMillis() / ((long) 1000);
            yk ykVar = new yk(str);
            ykVar.c = strEncodeToString;
            ykVar.f882b.put("Content-Type", "application/json");
            ykVar.f882b.put("X-ADS-TIME", String.valueOf(jCurrentTimeMillis));
            String lowerCase = g1.a(jCurrentTimeMillis + AdprofSdk.getInstance().getAppSecret()).toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
            ykVar.f882b.put("X-ADS-KEY", lowerCase);
            ykVar.f883b = true;
            ykVar.f882b.put("Content-Encoding", AsyncHttpClient.ENCODING_GZIP);
            j1 j1Var = new j1(v1Var);
            ykVar.b = "POST";
            ykVar.a(j1Var);
        } catch (Throwable th) {
            pk.b(Log.getStackTraceString(th));
            v1Var.invoke(Boolean.FALSE);
        }
    }
}
