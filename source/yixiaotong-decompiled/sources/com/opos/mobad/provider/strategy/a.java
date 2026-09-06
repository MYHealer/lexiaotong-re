package com.opos.mobad.provider.strategy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ReadWriteLock f7281a;

    public a(Context context) {
        super(context, "opos_mobad_app", (SQLiteDatabase.CursorFactory) null, 1);
        this.f7281a = new ReentrantReadWriteLock();
    }

    private void a(String str, long j) {
        try {
            com.opos.cmn.an.f.a.b("MobConfig", "remove " + getWritableDatabase().delete("pos", "appId=? and stgVer!=?", new String[]{str, String.valueOf(j)}));
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("MobConfig", "remove pos fail", e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:52:0x007e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public AppInfo a() throws Throwable {
        Throwable th;
        Cursor cursorQuery;
        Lock lock = this.f7281a.readLock();
        Cursor cursor = null;
        try {
            try {
                lock.lock();
                cursorQuery = getWritableDatabase().query("app", null, null, null, null, null, "lmTime desc", "1");
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            AppInfo appInfo = new AppInfo(cursorQuery.getLong(cursorQuery.getColumnIndex("expTime")), cursorQuery.getBlob(cursorQuery.getColumnIndex("data")));
                            if (cursorQuery != null) {
                                try {
                                    cursorQuery.close();
                                } catch (Exception e) {
                                    com.opos.cmn.an.f.a.b("MobConfig", "close err", e);
                                }
                            }
                            lock.unlock();
                            return appInfo;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        com.opos.cmn.an.f.a.b("MobConfig", "get app fail", e);
                        if (cursorQuery != null) {
                            try {
                                cursorQuery.close();
                            } catch (Exception e3) {
                                com.opos.cmn.an.f.a.b("MobConfig", "close err", e3);
                            }
                        }
                        lock.unlock();
                        return null;
                    }
                }
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Exception e4) {
                        com.opos.cmn.an.f.a.b("MobConfig", "close err", e4);
                    }
                }
                lock.unlock();
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                    try {
                        cursor.close();
                    } catch (Exception e5) {
                        com.opos.cmn.an.f.a.b("MobConfig", "close err", e5);
                    }
                }
                lock.unlock();
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
            if (0 != 0) {
                cursor.close();
            }
            lock.unlock();
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:52:0x007f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v4, types: [android.database.Cursor] */
    public AppInfo a(String str) throws Throwable {
        Throwable th;
        Cursor cursorQuery;
        Lock lock = this.f7281a.readLock();
        try {
            try {
                lock.lock();
                cursorQuery = getWritableDatabase().query("app", null, "appId=?", new String[]{str}, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            AppInfo appInfo = new AppInfo(cursorQuery.getLong(cursorQuery.getColumnIndex("expTime")), cursorQuery.getBlob(cursorQuery.getColumnIndex("data")));
                            if (cursorQuery != null) {
                                try {
                                    cursorQuery.close();
                                } catch (Exception e) {
                                    com.opos.cmn.an.f.a.b("MobConfig", "close err", e);
                                }
                            }
                            lock.unlock();
                            return appInfo;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        com.opos.cmn.an.f.a.b("MobConfig", "get app fail", e);
                        if (cursorQuery != null) {
                            try {
                                cursorQuery.close();
                            } catch (Exception e3) {
                                com.opos.cmn.an.f.a.b("MobConfig", "close err", e3);
                            }
                        }
                        lock.unlock();
                        return null;
                    }
                }
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Exception e4) {
                        com.opos.cmn.an.f.a.b("MobConfig", "close err", e4);
                    }
                }
                lock.unlock();
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (str != 0) {
                    try {
                        str.close();
                    } catch (Exception e5) {
                        com.opos.cmn.an.f.a.b("MobConfig", "close err", e5);
                    }
                }
                lock.unlock();
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
            str = 0;
            if (str != 0) {
                str.close();
            }
            lock.unlock();
            throw th;
        }
    }

    public void a(String str, Bundle bundle, long j) {
        Lock lockWriteLock = this.f7281a.writeLock();
        try {
            try {
                lockWriteLock.lock();
                getWritableDatabase().beginTransaction();
                for (String str2 : bundle.keySet()) {
                    byte[] byteArray = bundle.getByteArray(str2);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("appId", str);
                    contentValues.put("posId", str2);
                    contentValues.put("data", byteArray);
                    contentValues.put("stgVer", Long.valueOf(j));
                    getWritableDatabase().replace("pos", null, contentValues);
                }
                getWritableDatabase().setTransactionSuccessful();
                try {
                    try {
                        getWritableDatabase().endTransaction();
                        a(str, j);
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.b("MobConfig", "end err", e);
                    }
                } finally {
                    lockWriteLock.unlock();
                }
            } catch (Throwable th) {
                try {
                    try {
                        getWritableDatabase().endTransaction();
                        a(str, j);
                    } finally {
                        lockWriteLock.unlock();
                    }
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.b("MobConfig", "end err", e2);
                }
                throw th;
            }
        } catch (Exception e3) {
            com.opos.cmn.an.f.a.b("MobConfig", "add pos fail", e3);
            try {
                try {
                    getWritableDatabase().endTransaction();
                    a(str, j);
                } catch (Exception e4) {
                    com.opos.cmn.an.f.a.b("MobConfig", "end err", e4);
                }
            } finally {
                lockWriteLock.unlock();
            }
        }
    }

    public void a(String str, byte[] bArr, long j) {
        Lock lockWriteLock = this.f7281a.writeLock();
        try {
            try {
                lockWriteLock.lock();
                ContentValues contentValues = new ContentValues();
                contentValues.put("appId", str);
                contentValues.put("data", bArr);
                contentValues.put("expTime", Long.valueOf(j));
                contentValues.put("lmTime", Long.valueOf(System.currentTimeMillis()));
                getWritableDatabase().replace("app", null, contentValues);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("MobConfig", "add fail", e);
            }
        } finally {
            lockWriteLock.unlock();
        }
    }

    /* JADX WARN: Code duplicated, block: B:50:0x0097 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v4, types: [android.database.Cursor] */
    public Bundle b(String str) throws Throwable {
        Throwable th;
        Cursor cursorQuery;
        Lock lock = this.f7281a.readLock();
        try {
            try {
                lock.lock();
                cursorQuery = getWritableDatabase().query("pos", null, "appId=?", new String[]{str}, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            int columnIndex = cursorQuery.getColumnIndex("posId");
                            int columnIndex2 = cursorQuery.getColumnIndex("stgVer");
                            int columnIndex3 = cursorQuery.getColumnIndex("data");
                            Bundle bundle = new Bundle();
                            do {
                                bundle.putParcelable(cursorQuery.getString(columnIndex), new PosInfo(cursorQuery.getBlob(columnIndex3), cursorQuery.getLong(columnIndex2)));
                            } while (cursorQuery.moveToNext());
                            if (cursorQuery != null) {
                                try {
                                    cursorQuery.close();
                                } catch (Exception e) {
                                    com.opos.cmn.an.f.a.b("MobConfig", "close err", e);
                                }
                            }
                            lock.unlock();
                            return bundle;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        com.opos.cmn.an.f.a.b("MobConfig", "get pos fail", e);
                        if (cursorQuery != null) {
                            try {
                                cursorQuery.close();
                            } catch (Exception e3) {
                                com.opos.cmn.an.f.a.b("MobConfig", "close err", e3);
                            }
                        }
                        lock.unlock();
                        return null;
                    }
                }
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Exception e4) {
                        com.opos.cmn.an.f.a.b("MobConfig", "close err", e4);
                    }
                }
                lock.unlock();
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (str != 0) {
                    try {
                        str.close();
                    } catch (Exception e5) {
                        com.opos.cmn.an.f.a.b("MobConfig", "close err", e5);
                    }
                }
                lock.unlock();
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
            str = 0;
            if (str != 0) {
                str.close();
            }
            lock.unlock();
            throw th;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table app(appId varchar primary key,data blob,expTime interger,lmTime interger);");
        sQLiteDatabase.execSQL("create table pos(posId varchar primary key,appId varchar,data blob,stgVer interger)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
