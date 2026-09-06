package com.ubix.ssp.ad.core.monitor.data.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.text.TextUtils;
import com.ubix.ssp.ad.e.a0.n;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.ad.e.w.h;
import com.ubix.ssp.ad.e.y.c.f;
import com.ubixnow.ooooo.oOOOoo00;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d extends a {
    d(Context context) {
        super(context);
        this.f8591a = "EventDataOperation";
    }

    @Override // com.ubix.ssp.ad.core.monitor.data.c.a
    int a(Uri uri, JSONObject jSONObject) {
        try {
            if (a(uri) != 0) {
                return -2;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("data", jSONObject.toString() + "\t" + jSONObject.toString().hashCode());
            contentValues.put(oOOOoo00.OooOo0, Long.valueOf(System.currentTimeMillis()));
            this.b.insert(uri, contentValues);
            return 0;
        } catch (Throwable th) {
            h.a(this.f8591a, th.getMessage());
            return 0;
        }
    }

    public com.ubix.ssp.ad.e.y.b.b a(List<com.ubix.ssp.ad.e.y.b.a> list) {
        com.ubix.ssp.ad.e.y.b.b bVar = new com.ubix.ssp.ad.e.y.b.b();
        try {
            bVar.b = com.ubix.ssp.ad.e.w.s.a.f().e();
            bVar.p = com.ubix.ssp.ad.e.w.s.a.f().h();
            bVar.q = com.ubix.ssp.ad.e.w.s.a.f().a();
            bVar.c = com.ubix.ssp.ad.e.w.s.a.f().b();
            bVar.e = 0;
            bVar.d = System.currentTimeMillis();
            bVar.f = com.ubix.ssp.ad.e.w.s.a.f().i();
            bVar.g = com.ubix.ssp.ad.e.w.s.a.f().j();
            bVar.h = com.ubix.ssp.ad.e.w.s.a.f().l();
            bVar.i = com.ubix.ssp.ad.e.w.s.a.f().c();
            bVar.l = com.ubix.ssp.ad.e.w.s.a.f().k();
            bVar.j = com.ubix.ssp.ad.e.w.s.a.f().d();
            bVar.k = com.ubix.ssp.ad.e.w.s.a.f().g();
            bVar.m = (com.ubix.ssp.ad.e.y.b.a[]) list.toArray(bVar.m);
        } catch (Exception e) {
            e.printStackTrace();
        }
        u.b(bVar.toString());
        return bVar;
    }

    @Override // com.ubix.ssp.ad.core.monitor.data.c.a
    void a(Uri uri, String str) {
        super.a(uri, str);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x007c A[PHI: r0 r9 r10
  0x007c: PHI (r0v3 java.lang.String) = (r0v2 java.lang.String), (r0v11 java.lang.String) binds: [B:30:0x007a, B:22:0x006a] A[DONT_GENERATE, DONT_INLINE]
  0x007c: PHI (r9v4 android.database.Cursor) = (r9v3 android.database.Cursor), (r9v7 android.database.Cursor) binds: [B:30:0x007a, B:22:0x006a] A[DONT_GENERATE, DONT_INLINE]
  0x007c: PHI (r10v7 java.lang.String) = (r10v6 java.lang.String), (r10v15 java.lang.String) binds: [B:30:0x007a, B:22:0x006a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:39:0x008d  */
    @Override // com.ubix.ssp.ad.core.monitor.data.c.a
    String[] a(Uri uri, int i) throws Throwable {
        Cursor cursorQuery;
        String strB;
        String string;
        Cursor cursor = null;
        try {
            cursorQuery = this.b.query(uri, null, null, null, "created_at ASC LIMIT " + i);
            if (cursorQuery != null) {
                try {
                    try {
                        ArrayList arrayList = new ArrayList();
                        string = null;
                        while (cursorQuery.moveToNext()) {
                            if (cursorQuery.isLast()) {
                                string = cursorQuery.getString(cursorQuery.getColumnIndex("_id"));
                            }
                            try {
                                com.ubix.ssp.ad.e.y.b.a aVarB = b(a(cursorQuery.getString(cursorQuery.getColumnIndex("data"))));
                                if (aVarB != null) {
                                    arrayList.add(aVarB);
                                }
                            } catch (Exception e) {
                                h.a(e);
                            }
                        }
                        strB = n.b().b(f.a(a(arrayList)));
                    } catch (SQLiteException e2) {
                        e = e2;
                        h.a(this.f8591a, "Could not pull records for SensorsData out of database events. Waiting to send.", e);
                        strB = null;
                        string = null;
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } else {
                strB = null;
                string = null;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        if (string != null) {
            return new String[]{string, strB, "1"};
        }
        return null;
    }

    public com.ubix.ssp.ad.e.y.b.a b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("SDKEvent");
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString("md_event");
                if (!TextUtils.isEmpty(strOptString)) {
                    return com.ubix.ssp.ad.e.y.b.a.a(n.a().a(strOptString));
                }
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("AppCrashed");
            if (jSONObjectOptJSONObject2 == null || TextUtils.isEmpty(jSONObjectOptJSONObject2.optString("app_crashed_reason"))) {
                return null;
            }
            return new com.ubix.ssp.ad.e.y.b.a();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
