package com.ubixnow.ooooo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.text.TextUtils;
import com.ubixnow.core.api.UMNConfigUserInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class oOOOOo0O extends oOOO0OO0 {
    public oOOOOo0O(Context context) {
        super(context);
        this.OooO00o = "EventDataOperation";
    }

    @Override // com.ubixnow.ooooo.oOOO0OO0
    public int OooO00o(Uri uri, ContentValues contentValues) {
        try {
            if (OooO00o(uri) != 0) {
                return -2;
            }
            this.OooO0O0.insert(uri, contentValues);
            return 0;
        } catch (Exception e) {
            oOO0O0O.OooO00o(e);
            return 0;
        }
    }

    @Override // com.ubixnow.ooooo.oOOO0OO0
    public int OooO00o(Uri uri, JSONObject jSONObject) {
        try {
            if (OooO00o(uri) != 0) {
                return -2;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("data", jSONObject.toString() + "\t" + jSONObject.toString().hashCode());
            contentValues.put(oOOOoo00.OooOo0, Long.valueOf(System.currentTimeMillis()));
            this.OooO0O0.insert(uri, contentValues);
            return 0;
        } catch (Throwable th) {
            oOO0O0O.OooO00o(this.OooO00o, th.getMessage());
            return 0;
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x014c A[Catch: Exception -> 0x01ea, TRY_LEAVE, TryCatch #0 {Exception -> 0x01ea, blocks: (B:3:0x0010, B:6:0x002a, B:9:0x00de, B:12:0x00e5, B:14:0x00eb, B:22:0x0149, B:23:0x014c, B:28:0x01e6, B:15:0x0122, B:17:0x012a, B:19:0x0136, B:25:0x0150), top: B:33:0x0010, inners: #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x0150 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public oOOoOOO0 OooO00o(List<oO00Oo00> list) {
        h1 h1VarOooO00o = h1.OooO0O0().OooO00o(false);
        oOOoOOO0 ooooooo0 = new oOOoOOO0();
        try {
            ooooooo0.OooO0OO = h1VarOooO00o.OooOo0 + "";
            String str = i1.OooOo0O;
            if (str == null) {
                str = "";
            }
            ooooooo0.OooO0Oo = str;
            ooooooo0.OooO0oO = 0;
            ooooooo0.OooO0o = (oO00Oo00[]) list.toArray(ooooooo0.OooO0o);
            ooooooo0.OooO0o0 = System.currentTimeMillis();
            ooooooo0.OooO0oo = h1VarOooO00o.OooO0oo + "";
            ooooooo0.OooO = h1VarOooO00o.OooOO0 + "";
            ooooooo0.OooOO0 = o00O0000.OooO0O0;
            ooooooo0.OooOO0O = h1VarOooO00o.OooOo0O + "";
            ooooooo0.OooOOO = h1VarOooO00o.OooOo0o + "";
            ooooooo0.OooOO0o = h1VarOooO00o.OooOO0o + "";
            ooooooo0.OooOOO0 = h1VarOooO00o.OooO0Oo + "";
            ooooooo0.OooOOOO = h1VarOooO00o.OooO0OO + "";
            ooooooo0.OooOOo0 = h1VarOooO00o.OooO0O0;
            String str2 = h1VarOooO00o.OooOoO;
            if (str2 == null) {
                str2 = "";
            }
            ooooooo0.OooOoO0 = str2;
            String str3 = h1VarOooO00o.OooOoO0;
            if (str3 == null) {
                str3 = "";
            }
            ooooooo0.OooOoO = str3;
            UMNConfigUserInfo uMNConfigUserInfo = o0O0ooO.OooO0o0;
            if (uMNConfigUserInfo != null) {
                ooooooo0.OooOOoo = uMNConfigUserInfo.getUserId();
                ooooooo0.OooOo00 = o0O0ooO.OooO0o0.getChannel();
                ooooooo0.OooOo0 = o0O0ooO.OooO0o0.getSubChannel();
                ooooooo0.OooOo0O = o0O0ooO.OooO0o0.getSubScriber() + "";
                ooooooo0.OooOo0o = o0O0ooO.OooO0o0.getPubSegmentId();
                try {
                    if (o0O0ooO.OooO0o0.getCustomUserInfo() != null && o0O0ooO.OooO0o0.getCustomUserInfo().size() > 0) {
                        ooooooo0.OooOo = new JSONObject(o0O0ooO.OooO0o0.getCustomUserInfo()).toString();
                        if (ooooO000.OooO00o) {
                            ooooO000.OooO0OO(ooooO000.OooO0OO("b10"), oO0000O.OooO00o(ooooO000.OooO0OO("b9"), new String[]{ooooooo0.OooO0OO, ooooooo0.OooO0Oo, String.valueOf(ooooooo0.OooO0oO), String.valueOf(ooooooo0.OooO0o0), ooooooo0.OooO0oo, ooooooo0.OooO, ooooooo0.OooOO0, ooooooo0.OooOO0O, ooooooo0.OooOO0o, ooooooo0.OooOOO0, ooooooo0.OooOOO, ooooooo0.OooOOOO, ooooooo0.OooOOo0, ooooooo0.OooOOoo, ooooooo0.OooOo00, ooooooo0.OooOo0, "", "", ooooooo0.OooOo0O, ooooooo0.OooOo0o, oO0O0O0o.OooO0OO(ooooooo0.OooOo)}));
                        }
                    } else if (ooooO000.OooO00o) {
                        try {
                            ooooO000.OooO0OO(ooooO000.OooO0OO("b10"), oO0000O.OooO00o(ooooO000.OooO0OO("b9"), new String[]{ooooooo0.OooO0OO, ooooooo0.OooO0Oo, String.valueOf(ooooooo0.OooO0oO), String.valueOf(ooooooo0.OooO0o0), ooooooo0.OooO0oo, ooooooo0.OooO, ooooooo0.OooOO0, ooooooo0.OooOO0O, ooooooo0.OooOO0o, ooooooo0.OooOOO0, ooooooo0.OooOOO, ooooooo0.OooOOOO, ooooooo0.OooOOo0, ooooooo0.OooOOoo, ooooooo0.OooOo00, ooooooo0.OooOo0, "", "", ooooooo0.OooOo0O, ooooooo0.OooOo0o, oO0O0O0o.OooO0OO(ooooooo0.OooOo)}));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e2) {
                    ooooO000.OooO00o(e2);
                }
            } else if (ooooO000.OooO00o) {
                ooooO000.OooO0OO(ooooO000.OooO0OO("b10"), oO0000O.OooO00o(ooooO000.OooO0OO("b9"), new String[]{ooooooo0.OooO0OO, ooooooo0.OooO0Oo, String.valueOf(ooooooo0.OooO0oO), String.valueOf(ooooooo0.OooO0o0), ooooooo0.OooO0oo, ooooooo0.OooO, ooooooo0.OooOO0, ooooooo0.OooOO0O, ooooooo0.OooOO0o, ooooooo0.OooOOO0, ooooooo0.OooOOO, ooooooo0.OooOOOO, ooooooo0.OooOOo0, ooooooo0.OooOOoo, ooooooo0.OooOo00, ooooooo0.OooOo0, "", "", ooooooo0.OooOo0O, ooooooo0.OooOo0o, oO0O0O0o.OooO0OO(ooooooo0.OooOo)}));
            }
        } catch (Exception e3) {
            ooooO000.OooO00o(e3);
        }
        return ooooooo0;
    }

    @Override // com.ubixnow.ooooo.oOOO0OO0
    public void OooO00o(Uri uri, String str) {
        super.OooO00o(uri, str);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x007c A[PHI: r0 r9 r10
  0x007c: PHI (r0v3 java.lang.String) = (r0v2 java.lang.String), (r0v11 java.lang.String) binds: [B:30:0x007a, B:22:0x006a] A[DONT_GENERATE, DONT_INLINE]
  0x007c: PHI (r9v4 android.database.Cursor) = (r9v3 android.database.Cursor), (r9v7 android.database.Cursor) binds: [B:30:0x007a, B:22:0x006a] A[DONT_GENERATE, DONT_INLINE]
  0x007c: PHI (r10v7 java.lang.String) = (r10v6 java.lang.String), (r10v15 java.lang.String) binds: [B:30:0x007a, B:22:0x006a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:39:0x008d  */
    @Override // com.ubixnow.ooooo.oOOO0OO0
    public String[] OooO00o(Uri uri, int i) throws Throwable {
        Cursor cursorQuery;
        String strOooO0O0;
        String string;
        Cursor cursor = null;
        try {
            cursorQuery = this.OooO0O0.query(uri, null, null, null, "created_at ASC LIMIT " + i);
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
                                oO00Oo00 oo00oo00OooO0O0 = OooO0O0(OooO00o(cursorQuery.getString(cursorQuery.getColumnIndex("data"))));
                                if (oo00oo00OooO0O0 != null) {
                                    arrayList.add(oo00oo00OooO0O0);
                                }
                            } catch (Exception e) {
                                oOO0O0O.OooO00o(e);
                            }
                        }
                        strOooO0O0 = oO0Oo0o0.OooO0O0().OooO0O0(oOo0000O.OooO00o(OooO00o(arrayList)));
                    } catch (SQLiteException e2) {
                        e = e2;
                        oOO0O0O.OooO0O0(this.OooO00o, "Could not pull records for SensorsData out of database events. Waiting to send.", e);
                        strOooO0O0 = null;
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
                strOooO0O0 = null;
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
            return new String[]{string, strOooO0O0, "1"};
        }
        return null;
    }

    public oO00Oo00 OooO0O0(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("SDKEvent");
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString("md_event");
                if (!TextUtils.isEmpty(strOptString)) {
                    return oO00Oo00.OooO00o(oO0Oo0o0.OooO00o().OooO00o(strOptString));
                }
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("AppCrashed");
            if (jSONObjectOptJSONObject2 == null) {
                return null;
            }
            String strOptString2 = jSONObjectOptJSONObject2.optString("app_crashed_reason");
            if (TextUtils.isEmpty(strOptString2)) {
                return null;
            }
            if (ooooO000.OooO00o) {
                ooooO000.OooO0O0("----app_crashed_reason----:", strOptString2);
            }
            oO00Oo00 oo00oo00 = new oO00Oo00();
            oo00oo00.OooO0o0 = o0OO000o.o000OoOO;
            oo00oo00.OooOOo = o0OO000o.o000OoOo;
            oo00oo00.OooO0OO = jSONObjectOptJSONObject2.optLong("app_crashed_time");
            if (!TextUtils.isEmpty(jSONObjectOptJSONObject2.optString(o0OO000o.o000ooo0))) {
                oo00oo00.OooOOOo = jSONObjectOptJSONObject2.optString(o0OO000o.o000ooo0);
            }
            if (!TextUtils.isEmpty(jSONObjectOptJSONObject2.optString(o0OO000o.oooo00o))) {
                oo00oo00.OooOO0 = jSONObjectOptJSONObject2.optString(o0OO000o.oooo00o);
            }
            oo00oo00.OooOOoo = strOptString2;
            oo00oo00.OooO0Oo = UUID.randomUUID().toString().replace(com.huawei.openalliance.ad.constant.x.A, "");
            if (!TextUtils.isEmpty(jSONObjectOptJSONObject2.optString("app_crashed_type"))) {
                oo00oo00.OoooOOo = jSONObjectOptJSONObject2.optString("app_crashed_type");
            }
            HashMap map = new HashMap();
            map.put("oaid", h1.OooO0O0().OooO0O0);
            map.put("vendor", h1.OooO0O0().OooOO0O);
            map.put("conn_type", h1.OooO0O0().OooOOo0 + "");
            map.put("model", h1.OooO0O0().OooO0Oo);
            oo00oo00.OooOo0O = map;
            return oo00oo00;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
