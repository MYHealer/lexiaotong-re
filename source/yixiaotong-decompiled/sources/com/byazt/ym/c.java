package com.byazt.ym;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.byazt.nr.m;
import com.byazt.vb.n;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.stub.StubApp;
import com.ubixnow.ooooo.oOOOoo00;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 799, 20})
public class c {
    public static volatile c ve;
    public tt c;
    public Context tt;

    /* JADX INFO: renamed from: com.byazt.ym.c$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 799, 26})
    static /* synthetic */ class AnonymousClass1 {
    }

    private Context getContext() {
        return this.tt;
    }

    public tt c() {
        return this.c;
    }

    public static c c(Context context) {
        if (ve == null) {
            synchronized (c.class) {
                if (ve == null) {
                    ve = new c(context);
                }
            }
        }
        return ve;
    }

    private c(Context context) {
        try {
            this.tt = StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (this.c == null) {
                this.c = new tt();
            }
        } catch (Throwable unused) {
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 799, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    public class tt {
        public tt() {
        }

        private SQLiteDatabase c(n nVar) {
            try {
                SQLiteDatabase sQLiteDatabaseC = nVar.tt().c(nVar.getContext());
                if (sQLiteDatabaseC == null || !sQLiteDatabaseC.isOpen()) {
                    return null;
                }
                sQLiteDatabaseC.setLockingEnabled(false);
                return sQLiteDatabaseC;
            } catch (Throwable th) {
                m.c(th);
                if (tt(nVar)) {
                    throw th;
                }
                return null;
            }
        }

        public void c(n nVar, String str) throws SQLException {
            try {
                SQLiteDatabase sQLiteDatabaseC = c(nVar);
                if (sQLiteDatabaseC != null) {
                    sQLiteDatabaseC.execSQL(str);
                }
            } catch (Throwable th) {
                if (tt(nVar)) {
                    throw th;
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Cursor query(n nVar, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            Object[] objArr = 0;
            try {
                SQLiteDatabase sQLiteDatabaseC = c(nVar);
                return sQLiteDatabaseC != null ? sQLiteDatabaseC.query(str, strArr, str2, strArr2, str3, str4, str5) : null;
            } catch (Throwable th) {
                m.c(th);
                C0335c c0335c = new C0335c(c.this, objArr == true ? 1 : 0);
                if (tt(nVar)) {
                    throw th;
                }
                return c0335c;
            }
        }

        public int update(n nVar, String str, ContentValues contentValues, String str2, String[] strArr) throws Exception {
            try {
                SQLiteDatabase sQLiteDatabaseC = c(nVar);
                if (sQLiteDatabaseC != null) {
                    return sQLiteDatabaseC.update(str, contentValues, str2, strArr);
                }
                return 0;
            } catch (Exception e) {
                m.c(e);
                if (tt(nVar)) {
                    throw e;
                }
                return 0;
            }
        }

        public long insert(n nVar, String str, String str2, ContentValues contentValues) throws Exception {
            try {
                SQLiteDatabase sQLiteDatabaseC = c(nVar);
                if (sQLiteDatabaseC != null) {
                    return sQLiteDatabaseC.insert(str, str2, contentValues);
                }
                return -1L;
            } catch (Exception e) {
                m.c(e);
                if (tt(nVar)) {
                    throw e;
                }
                return -1L;
            }
        }

        public synchronized void insert(n nVar, String str, String str2, List<com.byazt.vb.tt> list) {
            JSONObject jSONObjectSp;
            SQLiteDatabase sQLiteDatabaseC = null;
            try {
                try {
                    sQLiteDatabaseC = c(nVar);
                    if (sQLiteDatabaseC != null) {
                        sQLiteDatabaseC.beginTransaction();
                        ContentValues contentValues = new ContentValues();
                        for (int i = 0; i < list.size(); i++) {
                            com.byazt.vb.tt ttVar = list.get(i);
                            if (ttVar != null && (jSONObjectSp = ttVar.sp()) != null) {
                                contentValues.put("id", ttVar.ve());
                                String strTt = nVar.uj().tt(jSONObjectSp.toString());
                                if (!TextUtils.isEmpty(strTt)) {
                                    contentValues.put(oOOOoo00.OooOo0o, strTt);
                                    contentValues.put("gen_time", Long.valueOf(System.currentTimeMillis()));
                                    contentValues.put("retry", (Integer) 0);
                                    contentValues.put("encrypt", (Integer) 1);
                                    sQLiteDatabaseC.insert(str, str2, contentValues);
                                }
                                contentValues.clear();
                            }
                        }
                        sQLiteDatabaseC.setTransactionSuccessful();
                        com.byazt.ml.ve.c("DBHelper", str + " insert list size=" + list.size(), nVar);
                    }
                    if (sQLiteDatabaseC != null) {
                        sQLiteDatabaseC.endTransaction();
                    }
                } catch (Exception e) {
                    com.byazt.ml.ve.c("DBHelper", str + " insert list error=" + list.size(), nVar);
                    m.c(e);
                    if (tt(nVar)) {
                        throw e;
                    }
                    if (sQLiteDatabaseC != null) {
                        sQLiteDatabaseC.endTransaction();
                    }
                }
            } catch (Throwable th) {
                if (sQLiteDatabaseC != null) {
                    sQLiteDatabaseC.endTransaction();
                }
                throw th;
            }
        }

        public int delete(n nVar, String str, String str2, String[] strArr) throws Exception {
            try {
                SQLiteDatabase sQLiteDatabaseC = c(nVar);
                if (sQLiteDatabaseC != null) {
                    return sQLiteDatabaseC.delete(str, str2, strArr);
                }
                return 0;
            } catch (Exception e) {
                m.c(e);
                if (tt(nVar)) {
                    throw e;
                }
                return 0;
            }
        }

        private boolean tt(n nVar) {
            SQLiteDatabase sQLiteDatabaseC = c(nVar);
            return sQLiteDatabaseC != null && sQLiteDatabaseC.inTransaction();
        }
    }

    /* JADX INFO: renamed from: com.byazt.ym.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 799, 44})
    private class C0335c extends AbstractCursor {
        @Override // android.database.AbstractCursor, android.database.Cursor
        public String[] getColumnNames() {
            return new String[0];
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getCount() {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public double getDouble(int i) {
            return 0.0d;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public float getFloat(int i) {
            return 0.0f;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getInt(int i) {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public long getLong(int i) {
            return 0L;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public short getShort(int i) {
            return (short) 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String getString(int i) {
            return null;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public boolean isNull(int i) {
            return true;
        }

        private C0335c() {
        }

        public /* synthetic */ C0335c(c cVar, AnonymousClass1 anonymousClass1) {
            this();
        }
    }
}
