package com.yfanads.android.db.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.yfanads.android.YFAdsManager;
import com.yfanads.android.core.f;
import com.yfanads.android.libs.thirdpart.gson.Gson;
import com.yfanads.android.model.EventData;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: YFAdsDao.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f9644a = new c(YFAdsManager.getInstance().getContext());

    /* JADX INFO: compiled from: YFAdsDao.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f9645a = new b();
    }

    public final int a() {
        SQLiteDatabase readableDatabase = this.f9644a.getReadableDatabase();
        try {
            Cursor cursorRawQuery = readableDatabase.rawQuery("select count (*) from fc_event", null);
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        int i = cursorRawQuery.getInt(0);
                        cursorRawQuery.close();
                        readableDatabase.close();
                        return i;
                    }
                } catch (Throwable th) {
                    try {
                        cursorRawQuery.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            readableDatabase.close();
            return -1;
        } catch (Throwable th3) {
            if (readableDatabase != null) {
                try {
                    readableDatabase.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
            }
            throw th3;
        }
    }

    public final ArrayList a(int i) {
        ArrayList arrayList = new ArrayList();
        String str = "select * from fc_event Limit " + i + " Offset 0";
        try {
            SQLiteDatabase readableDatabase = this.f9644a.getReadableDatabase();
            try {
                Cursor cursorRawQuery = readableDatabase.rawQuery(str, null);
                while (cursorRawQuery.moveToNext()) {
                    try {
                        EventData eventData = new EventData();
                        eventData.id = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("id"));
                        eventData.eId = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("eID"));
                        eventData.eType = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("eType"));
                        String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("param2"));
                        if (!TextUtils.isEmpty(string)) {
                            eventData.t = YFUtil.toLong(string, 0L);
                        } else {
                            eventData.t = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("t"));
                        }
                        eventData.tCost = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("tCost"));
                        eventData.aType = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("aType"));
                        eventData.adId = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("adID"));
                        eventData.sId = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("sID"));
                        eventData.gId = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("gID"));
                        eventData.rId = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("rID"));
                        eventData.abId = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("abID"));
                        eventData.lId = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("lID"));
                        eventData.adnId = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("adnID"));
                        eventData.adnAdId = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("adnAdID"));
                        eventData.adnAppId = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("adnAppID"));
                        eventData.isBid = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("isBid"));
                        eventData.ecpm = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("ecpm"));
                        eventData.cd = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("param1"));
                        eventData.sdkVer = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("param4"));
                        eventData.msg = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("param5"));
                        String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("param3"));
                        if (!TextUtils.isEmpty(string2)) {
                            try {
                                eventData.od = (Map) new Gson().fromJson(string2, new com.yfanads.android.db.dao.a().getType());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        arrayList.add(eventData);
                    } catch (Throwable th) {
                        if (cursorRawQuery != null) {
                            try {
                                cursorRawQuery.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                }
                cursorRawQuery.close();
                readableDatabase.close();
                return arrayList;
            } catch (Throwable th3) {
                if (readableDatabase != null) {
                    try {
                        readableDatabase.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                }
                throw th3;
            }
        } catch (Exception e2) {
            f.a(e2, new StringBuilder("FCDao getAllData "));
            return arrayList;
        }
    }

    public final synchronized boolean a(EventData eventData) {
        try {
            SQLiteDatabase writableDatabase = this.f9644a.getWritableDatabase();
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("eID", eventData.eId);
                contentValues.put("eType", Integer.valueOf(eventData.eType));
                contentValues.put("param2", eventData.t + "");
                contentValues.put("tCost", Integer.valueOf(eventData.tCost));
                contentValues.put("aType", Integer.valueOf(eventData.aType));
                contentValues.put("adID", eventData.adId);
                contentValues.put("lID", eventData.lId);
                contentValues.put("sID", eventData.sId);
                contentValues.put("abID", eventData.abId);
                contentValues.put("gID", eventData.gId);
                contentValues.put("rID", eventData.rId);
                contentValues.put("adnID", Integer.valueOf(eventData.adnId));
                contentValues.put("adnAdID", eventData.adnAdId);
                contentValues.put("adnAppID", eventData.adnAppId);
                contentValues.put("isBid", Integer.valueOf(eventData.isBid));
                contentValues.put("ecpm", Long.valueOf(eventData.ecpm));
                contentValues.put("param1", eventData.cd);
                contentValues.put("param4", eventData.sdkVer);
                contentValues.put("param3", eventData.extData);
                contentValues.put("param5", eventData.msg);
                writableDatabase.insert("fc_event", null, contentValues);
                writableDatabase.close();
            } catch (Throwable th) {
                if (writableDatabase != null) {
                    try {
                        writableDatabase.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Exception e) {
            f.a(e, new StringBuilder("FCDao insertData "));
            return false;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00b9 A[Catch: all -> 0x00c2, TRY_ENTER, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0008, B:8:0x000f, B:9:0x0017, B:11:0x001d, B:12:0x002e, B:20:0x007b, B:24:0x0085, B:36:0x00b1, B:34:0x00ac, B:41:0x00b9, B:43:0x00be, B:44:0x00c1), top: B:48:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00be A[Catch: all -> 0x00c2, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0008, B:8:0x000f, B:9:0x0017, B:11:0x001d, B:12:0x002e, B:20:0x007b, B:24:0x0085, B:36:0x00b1, B:34:0x00ac, B:41:0x00b9, B:43:0x00be, B:44:0x00c1), top: B:48:0x0001 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v3 */
    public final synchronized int a(List<EventData> list) {
        SQLiteDatabase writableDatabase;
        if (YFListUtils.isEmpty(list)) {
            YFLog.debug("FCDao delete data from database, but data empty.");
            return -1;
        }
        String[] strArr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            strArr[i] = String.valueOf(list.get(i).id);
        }
        String strJoin = TextUtils.join(", ", strArr);
        SQLiteDatabase sQLiteDatabase = "FCDao eventIds  deleteIds ";
        YFLog.debug("FCDao eventIds  deleteIds " + strJoin);
        Cursor cursorRawQuery = null;
        try {
            try {
                writableDatabase = this.f9644a.getWritableDatabase();
                try {
                    writableDatabase.execSQL("delete from fc_event where id in (" + strJoin + ")");
                    cursorRawQuery = writableDatabase.rawQuery("select count (*) from fc_event", null);
                    if (cursorRawQuery != null && cursorRawQuery.moveToFirst()) {
                        int i2 = cursorRawQuery.getInt(0);
                        cursorRawQuery.close();
                        writableDatabase.close();
                        return i2;
                    }
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                } catch (Exception e) {
                    e = e;
                    YFLog.error("FCDaodeleteAndQueryData " + e.getMessage());
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    if (writableDatabase != null) {
                    }
                    return -1;
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    cursorRawQuery.close();
                }
                if (sQLiteDatabase != 0) {
                    sQLiteDatabase.close();
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            writableDatabase = null;
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = 0;
            if (0 != 0) {
                cursorRawQuery.close();
            }
            if (sQLiteDatabase != 0) {
                sQLiteDatabase.close();
            }
            throw th;
        }
        writableDatabase.close();
        return -1;
    }
}
