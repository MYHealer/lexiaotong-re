package com.ubix.ssp.ad.e.w.q;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f8915a;

    private a(Context context) {
        this.f8915a = new b(context);
    }

    public static a a(Context context) {
        return new a(context);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x006b A[Catch: all -> 0x007c, Exception -> 0x007f, TryCatch #7 {Exception -> 0x007f, all -> 0x007c, blocks: (B:10:0x0046, B:12:0x004c, B:14:0x0070, B:13:0x006b), top: B:52:0x0046 }] */
    /* JADX WARN: Code duplicated, block: B:16:0x0075 A[Catch: all -> 0x0092, TRY_ENTER, TryCatch #1 {all -> 0x0092, blocks: (B:16:0x0075, B:17:0x0078, B:36:0x0097, B:37:0x009a, B:41:0x009f, B:43:0x00a4, B:44:0x00aa, B:31:0x008e), top: B:47:0x0008 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    public void a(String str, String str2) {
        SQLiteDatabase writableDatabase;
        synchronized (this) {
            ?? r3 = 0;
            StringBuilder sb = null;
            r3 = 0;
            r3 = 0;
            r3 = 0;
            try {
                try {
                    try {
                        writableDatabase = this.f8915a.getWritableDatabase();
                        try {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("init_data", str2);
                            contentValues.put("ad_appid", str);
                            contentValues.put("createTime", Long.valueOf(System.currentTimeMillis()));
                            writableDatabase.beginTransaction();
                            Cursor cursorRawQuery = writableDatabase.rawQuery("SELECT * FROM t_ubixinit_admeta_cache WHERE ad_appid = '" + str + "'", null);
                            if (cursorRawQuery != null) {
                                try {
                                    if (cursorRawQuery.getCount() > 0) {
                                        StringBuilder sb2 = new StringBuilder("UPDATE t_ubixinit_admeta_cache SET init_data = '");
                                        writableDatabase.execSQL(sb2.append(str2).append("' WHERE ad_appid = '").append(str).append("'").toString());
                                        sb = sb2;
                                    } else {
                                        writableDatabase.insert("t_ubixinit_admeta_cache", null, contentValues);
                                    }
                                    writableDatabase.setTransactionSuccessful();
                                    r3 = sb;
                                    if (cursorRawQuery != null) {
                                        cursorRawQuery.close();
                                        r3 = sb;
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    r3 = cursorRawQuery;
                                    e.printStackTrace();
                                    if (r3 != 0) {
                                        r3.close();
                                    }
                                    if (writableDatabase != null) {
                                        r3 = r3;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    r3 = cursorRawQuery;
                                    if (r3 != 0) {
                                        r3.close();
                                    }
                                    if (writableDatabase != null) {
                                        writableDatabase.endTransaction();
                                        writableDatabase.close();
                                    }
                                    throw th;
                                }
                                writableDatabase.endTransaction();
                                writableDatabase.close();
                            } else {
                                writableDatabase.insert("t_ubixinit_admeta_cache", null, contentValues);
                                writableDatabase.setTransactionSuccessful();
                                r3 = sb;
                                if (cursorRawQuery != null) {
                                    cursorRawQuery.close();
                                    r3 = sb;
                                }
                                writableDatabase.endTransaction();
                                writableDatabase.close();
                            }
                        } catch (Exception e2) {
                            e = e2;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                } catch (Exception e3) {
                    e = e3;
                    writableDatabase = null;
                } catch (Throwable th3) {
                    th = th3;
                    writableDatabase = null;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    public boolean a() {
        boolean z;
        synchronized (this) {
            z = this.f8915a.getWritableDatabase().delete("t_ubixad_admeta_cache", String.format("%s<=? or %s=?", "expirationTimestamp", "status"), new String[]{String.valueOf(System.currentTimeMillis() / 1000), String.valueOf(2)}) != 0;
        }
        return z;
    }

    public boolean a(ContentValues contentValues, String str, String[] strArr) {
        boolean z;
        synchronized (this) {
            SQLiteDatabase writableDatabase = this.f8915a.getWritableDatabase();
            int iUpdate = writableDatabase.update("t_ubixad_admeta_cache", contentValues, str, strArr);
            writableDatabase.close();
            this.f8915a.close();
            z = iUpdate > 0;
        }
        return z;
    }

    public boolean a(String str) {
        boolean z;
        synchronized (this) {
            try {
                try {
                    SQLiteDatabase writableDatabase = this.f8915a.getWritableDatabase();
                    int iDelete = writableDatabase.delete("t_ubixad_admeta_cache", String.format("%s=?", "ad_id"), new String[]{String.valueOf(str)});
                    writableDatabase.close();
                    this.f8915a.close();
                    z = iDelete != 0;
                } catch (Exception unused) {
                    return false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v9 */
    public String b(String str) throws Throwable {
        SQLiteDatabase writableDatabase;
        Cursor cursorRawQuery;
        ?? r1 = 0;
        string = null;
        string = null;
        string = null;
        String string = null;
        r1 = 0;
        try {
            try {
                writableDatabase = this.f8915a.getWritableDatabase();
                try {
                    cursorRawQuery = writableDatabase.rawQuery("SELECT init_data FROM t_ubixinit_admeta_cache WHERE ad_appid = '" + str + "'", null);
                    if (cursorRawQuery != null) {
                        try {
                            if (cursorRawQuery.getCount() > 0) {
                                cursorRawQuery.moveToFirst();
                                string = cursorRawQuery.getString(0);
                            }
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            if (cursorRawQuery != null) {
                                cursorRawQuery.close();
                            }
                            if (writableDatabase != null) {
                            }
                            return string;
                        }
                    }
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                } catch (Exception e2) {
                    e = e2;
                    cursorRawQuery = null;
                } catch (Throwable th) {
                    th = th;
                    if (r1 != 0) {
                        r1.close();
                    }
                    if (writableDatabase != null) {
                        writableDatabase.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                r1 = str;
            }
        } catch (Exception e3) {
            e = e3;
            cursorRawQuery = null;
            writableDatabase = null;
        } catch (Throwable th3) {
            th = th3;
            writableDatabase = null;
        }
        writableDatabase.close();
        return string;
    }
}
