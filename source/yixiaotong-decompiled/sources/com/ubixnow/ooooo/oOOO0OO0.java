package com.ubixnow.ooooo;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class oOOO0OO0 {
    public String OooO00o = "---EventDataOperation";
    public ContentResolver OooO0O0;
    private final File OooO0OO;
    private Context OooO0Oo;

    public oOOO0OO0(Context context) {
        this.OooO0Oo = context;
        this.OooO0O0 = context.getContentResolver();
        this.OooO0OO = context.getDatabasePath(oOOOoo00.OooO0o);
    }

    private long OooO00o(Context context) {
        try {
            return ooooO0O0.OooO00o(context).OooO0OO();
        } catch (Exception e) {
            oOO0O0O.OooO00o(e);
            return 33554432L;
        }
    }

    private boolean OooO00o() {
        return this.OooO0OO.exists() && this.OooO0OO.length() >= OooO00o(this.OooO0Oo);
    }

    public int OooO00o(Uri uri) {
        if (OooO00o()) {
            oOO0O0O.OooO0O0(this.OooO00o, "There is not enough space left on the device to store events, so will delete 100 oldest events");
            String[] strArrOooO00o = OooO00o(uri, 100);
            if (strArrOooO00o == null) {
                return -2;
            }
            OooO00o(uri, strArrOooO00o[0]);
            if (OooO0O0(uri) <= 0) {
                return -2;
            }
        }
        return 0;
    }

    public abstract int OooO00o(Uri uri, ContentValues contentValues);

    public abstract int OooO00o(Uri uri, JSONObject jSONObject);

    /* JADX WARN: Code duplicated, block: B:15:0x0028 A[PHI: r0
  0x0028: PHI (r0v3 android.database.Cursor) = (r0v1 android.database.Cursor), (r0v4 android.database.Cursor) binds: [B:14:0x0026, B:8:0x001d] A[DONT_GENERATE, DONT_INLINE]] */
    public int OooO00o(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.OooO0O0.query(uri, new String[]{"_id"}, str, strArr2, str2);
                if (cursorQuery != null) {
                    int count = cursorQuery.getCount();
                    cursorQuery.close();
                    return count;
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return 0;
            } catch (Exception e) {
                oOO0O0O.OooO00o(e);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public String OooO00o(String str) {
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
            oOO0O0O.OooO00o(e);
        }
        return str;
    }

    public void OooO00o(Uri uri, String str) {
        try {
            if (oOOOoo00.OooOoO.equals(str)) {
                this.OooO0O0.delete(uri, null, null);
            } else {
                this.OooO0O0.delete(uri, "_id <= ?", new String[]{str});
            }
        } catch (Exception e) {
            oOO0O0O.OooO00o(e);
        }
    }

    public abstract String[] OooO00o(Uri uri, int i);

    public int OooO0O0(Uri uri) {
        return OooO00o(uri, null, null, null, null);
    }
}
