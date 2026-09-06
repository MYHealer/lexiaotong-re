package com.opos.mobad.provider.ad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b extends SQLiteOpenHelper {
    public b(Context context) {
        super(context, "opos_mobad_ad", (SQLiteDatabase.CursorFactory) null, 2);
    }

    private void b(String str) {
        try {
            com.opos.cmn.an.f.a.b("", "delete:" + str + ",result:" + getWritableDatabase().delete("mobad_ad", "posId=" + str, new String[0]));
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("", "", e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:76:0x00e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public synchronized AdEntity a(String str) {
        Cursor cursorQuery;
        Cursor cursor = null;
        try {
            cursorQuery = getWritableDatabase().query("mobad_ad", new String[]{"data", "posData", "validTime", "posType"}, "posId=?", new String[]{str}, null, null, null);
            try {
                try {
                    com.opos.cmn.an.f.a.b("", "select cache:" + cursorQuery);
                    if (cursorQuery == null) {
                        if (cursorQuery != null) {
                            try {
                                cursorQuery.close();
                            } catch (Exception e) {
                                com.opos.cmn.an.f.a.a("", "", (Throwable) e);
                            }
                        }
                        b(str);
                        return null;
                    }
                    if (cursorQuery.getColumnCount() <= 0 || !cursorQuery.moveToFirst()) {
                        if (cursorQuery != null) {
                            try {
                                cursorQuery.close();
                            } catch (Exception e2) {
                                com.opos.cmn.an.f.a.a("", "", (Throwable) e2);
                            }
                        }
                        b(str);
                        return null;
                    }
                    int columnIndex = cursorQuery.getColumnIndex("posType");
                    AdEntity adEntity = new AdEntity(cursorQuery.getBlob(cursorQuery.getColumnIndex("posData")), cursorQuery.getBlob(cursorQuery.getColumnIndex("data")), cursorQuery.getLong(cursorQuery.getColumnIndex("validTime")), cursorQuery.isNull(columnIndex) ? -1 : cursorQuery.getInt(columnIndex));
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                        } catch (Exception e3) {
                            com.opos.cmn.an.f.a.a("", "", (Throwable) e3);
                        }
                    }
                    b(str);
                    return adEntity;
                } catch (Exception e4) {
                    e = e4;
                    com.opos.cmn.an.f.a.a("", "", (Throwable) e);
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                        } catch (Exception e5) {
                            com.opos.cmn.an.f.a.a("", "", (Throwable) e5);
                        }
                    }
                    b(str);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor = cursorQuery;
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e6) {
                        com.opos.cmn.an.f.a.a("", "", (Throwable) e6);
                    }
                }
                b(str);
                throw th;
            }
        } catch (Exception e7) {
            e = e7;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor != null) {
                cursor.close();
            }
            b(str);
            throw th;
        }
        throw th;
    }

    public synchronized void a(String str, AdEntity adEntity) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("posId", str);
        contentValues.put("data", adEntity.b);
        contentValues.put("validTime", Long.valueOf(adEntity.c));
        contentValues.put("posData", adEntity.f7262a);
        contentValues.put("posType", Integer.valueOf(adEntity.d));
        getWritableDatabase().replace("mobad_ad", null, contentValues);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE mobad_ad(posId TEXT PRIMARY KEY,data BLOB,posData BLOB,validTime INTEGER,posType INTEGER)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i2 > i && sQLiteDatabase != null && i < 2) {
            sQLiteDatabase.execSQL("ALTER TABLE mobad_ad ADD COLUMN posType INTEGER");
        }
    }
}
