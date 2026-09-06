package com.ubix.ssp.ad.core.monitor.data.c;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.ubix.ssp.ad.core.monitor.data.UbixDataContentProvider;
import com.ubix.ssp.ad.e.w.h;
import com.ubix.ssp.ad.e.w.n;
import com.ubixnow.ooooo.oOOOoo00;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f8591a = "EventDataOperation";
    UbixDataContentProvider b;
    private final File c;
    private Context d;

    a(Context context) {
        UbixDataContentProvider ubixDataContentProvider = new UbixDataContentProvider();
        this.b = ubixDataContentProvider;
        this.d = context;
        ubixDataContentProvider.onCreate(context);
        this.c = context.getDatabasePath("ubix_sdk");
    }

    private long a(Context context) {
        try {
            return n.a(context).i();
        } catch (Exception e) {
            h.a(e);
            return 33554432L;
        }
    }

    private boolean a() {
        return this.c.exists() && this.c.length() >= a(this.d);
    }

    int a(Uri uri) {
        if (a()) {
            h.b(this.f8591a, "There is not enough space left on the device to store events, so will delete 100 oldest events");
            String[] strArrA = a(uri, 100);
            if (strArrA == null) {
                return -2;
            }
            a(uri, strArrA[0]);
            if (b(uri) <= 0) {
                return -2;
            }
        }
        return 0;
    }

    abstract int a(Uri uri, JSONObject jSONObject);

    int a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.b.query(uri, strArr, str, strArr2, str2);
                if (cursorQuery != null) {
                    int count = cursorQuery.getCount();
                    cursorQuery.close();
                    return count;
                }
                if (cursorQuery == null) {
                    return 0;
                }
            } catch (Exception e) {
                h.a(e);
                if (cursorQuery == null) {
                    return 0;
                }
            }
            cursorQuery.close();
            return 0;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    String a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            int iLastIndexOf = str.lastIndexOf("\t");
            if (iLastIndexOf > -1) {
                String strReplaceFirst = str.substring(iLastIndexOf).replaceFirst("\t", "");
                str = str.substring(0, iLastIndexOf);
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(strReplaceFirst) || !strReplaceFirst.equals(String.valueOf(str.hashCode()))) {
                    return "";
                }
            }
        } catch (Exception e) {
            h.a(e);
        }
        return str;
    }

    void a(Uri uri, String str) {
        try {
            if (oOOOoo00.OooOoO.equals(str)) {
                this.b.delete(uri, null, null);
            } else {
                this.b.delete(uri, "_id <= ?", new String[]{str});
            }
        } catch (Exception e) {
            h.a(e);
        }
    }

    abstract String[] a(Uri uri, int i);

    int b(Uri uri) {
        return a(uri, null, null, null, null);
    }
}
