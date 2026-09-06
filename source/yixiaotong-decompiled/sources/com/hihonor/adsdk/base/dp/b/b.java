package com.hihonor.adsdk.base.dp.b;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.hihonor.adsdk.base.dp.entity.AdTrack;
import com.hihonor.updater.installsdk.api.TraceUrlData;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.openalliance.ad.constant.ba;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class b implements com.hihonor.adsdk.base.dp.b.a {
    private final RoomDatabase hnadsa;
    private final EntityInsertionAdapter<AdTrack> hnadsb;
    private final EntityDeletionOrUpdateAdapter<AdTrack> hnadsc;
    private final EntityDeletionOrUpdateAdapter<AdTrack> hnadsd;
    private final SharedSQLiteStatement hnadse;
    private final SharedSQLiteStatement hnadsf;
    private final SharedSQLiteStatement hnadsg;
    private final SharedSQLiteStatement hnadsh;
    private final SharedSQLiteStatement hnadsi;

    class a extends EntityInsertionAdapter<AdTrack> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `AdTrack` (`_id`,`time`,`trackUrl`,`trackingType`,`reportCnt`,`reportState`,`reportTime`,`method`,`body`,`headers`,`adUnitId`,`adId`,`requestId`,`recordId`,`recordIds`,`urlType`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, AdTrack adTrack) {
            supportSQLiteStatement.bindLong(1, adTrack.id);
            supportSQLiteStatement.bindLong(2, adTrack.getTime());
            if (adTrack.getTrackUrl() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, adTrack.getTrackUrl());
            }
            supportSQLiteStatement.bindLong(4, adTrack.getTrackingType());
            supportSQLiteStatement.bindLong(5, adTrack.getReportCnt());
            supportSQLiteStatement.bindLong(6, adTrack.getReportState());
            supportSQLiteStatement.bindLong(7, adTrack.getReportTime());
            if (adTrack.getMethod() == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindString(8, adTrack.getMethod());
            }
            if (adTrack.getBody() == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindString(9, adTrack.getBody());
            }
            if (adTrack.getHeaders() == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindString(10, adTrack.getHeaders());
            }
            if (adTrack.getAdUnitId() == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindString(11, adTrack.getAdUnitId());
            }
            if (adTrack.getAdId() == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, adTrack.getAdId());
            }
            if (adTrack.getRequestId() == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindString(13, adTrack.getRequestId());
            }
            if (adTrack.getRecordId() == null) {
                supportSQLiteStatement.bindNull(14);
            } else {
                supportSQLiteStatement.bindString(14, adTrack.getRecordId());
            }
            if (adTrack.getRecordIds() == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindString(15, adTrack.getRecordIds());
            }
            supportSQLiteStatement.bindLong(16, adTrack.getUrlType());
        }
    }

    /* JADX INFO: renamed from: com.hihonor.adsdk.base.dp.b.b$b, reason: collision with other inner class name */
    class C0431b extends EntityDeletionOrUpdateAdapter<AdTrack> {
        C0431b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM `AdTrack` WHERE `_id` = ?";
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, AdTrack adTrack) {
            supportSQLiteStatement.bindLong(1, adTrack.id);
        }
    }

    class c extends EntityDeletionOrUpdateAdapter<AdTrack> {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE OR ABORT `AdTrack` SET `_id` = ?,`time` = ?,`trackUrl` = ?,`trackingType` = ?,`reportCnt` = ?,`reportState` = ?,`reportTime` = ?,`method` = ?,`body` = ?,`headers` = ?,`adUnitId` = ?,`adId` = ?,`requestId` = ?,`recordId` = ?,`recordIds` = ?,`urlType` = ? WHERE `_id` = ?";
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, AdTrack adTrack) {
            supportSQLiteStatement.bindLong(1, adTrack.id);
            supportSQLiteStatement.bindLong(2, adTrack.getTime());
            if (adTrack.getTrackUrl() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, adTrack.getTrackUrl());
            }
            supportSQLiteStatement.bindLong(4, adTrack.getTrackingType());
            supportSQLiteStatement.bindLong(5, adTrack.getReportCnt());
            supportSQLiteStatement.bindLong(6, adTrack.getReportState());
            supportSQLiteStatement.bindLong(7, adTrack.getReportTime());
            if (adTrack.getMethod() == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindString(8, adTrack.getMethod());
            }
            if (adTrack.getBody() == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindString(9, adTrack.getBody());
            }
            if (adTrack.getHeaders() == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindString(10, adTrack.getHeaders());
            }
            if (adTrack.getAdUnitId() == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindString(11, adTrack.getAdUnitId());
            }
            if (adTrack.getAdId() == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, adTrack.getAdId());
            }
            if (adTrack.getRequestId() == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindString(13, adTrack.getRequestId());
            }
            if (adTrack.getRecordId() == null) {
                supportSQLiteStatement.bindNull(14);
            } else {
                supportSQLiteStatement.bindString(14, adTrack.getRecordId());
            }
            if (adTrack.getRecordIds() == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindString(15, adTrack.getRecordIds());
            }
            supportSQLiteStatement.bindLong(16, adTrack.getUrlType());
            supportSQLiteStatement.bindLong(17, adTrack.id);
        }
    }

    class d extends SharedSQLiteStatement {
        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "update AdTrack set reportState=? WHERE reportState = ?";
        }
    }

    class e extends SharedSQLiteStatement {
        e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "update AdTrack set reportState=? WHERE reportState=? AND reportTime<?";
        }
    }

    class f extends SharedSQLiteStatement {
        f(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "update AdTrack set reportState=? WHERE _id in(?)";
        }
    }

    class g extends SharedSQLiteStatement {
        g(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM AdTrack WHERE _id = ?";
        }
    }

    class h extends SharedSQLiteStatement {
        h(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "delete from AdTrack";
        }
    }

    public b(RoomDatabase roomDatabase) {
        this.hnadsa = roomDatabase;
        this.hnadsb = new a(roomDatabase);
        this.hnadsc = new C0431b(roomDatabase);
        this.hnadsd = new c(roomDatabase);
        this.hnadse = new d(roomDatabase);
        this.hnadsf = new e(roomDatabase);
        this.hnadsg = new f(roomDatabase);
        this.hnadsh = new g(roomDatabase);
        this.hnadsi = new h(roomDatabase);
    }

    public static List<Class<?>> hnadsd() {
        return Collections.emptyList();
    }

    @Override // com.hihonor.adsdk.base.dp.b.a
    public List<Long> hnadsa(List<AdTrack> list) {
        this.hnadsa.assertNotSuspendingTransaction();
        this.hnadsa.beginTransaction();
        try {
            List<Long> listInsertAndReturnIdsList = this.hnadsb.insertAndReturnIdsList(list);
            this.hnadsa.setTransactionSuccessful();
            return listInsertAndReturnIdsList;
        } finally {
            this.hnadsa.endTransaction();
        }
    }

    @Override // com.hihonor.adsdk.base.dp.b.a
    public long hnadsb(AdTrack adTrack) {
        this.hnadsa.assertNotSuspendingTransaction();
        this.hnadsa.beginTransaction();
        try {
            long jInsertAndReturnId = this.hnadsb.insertAndReturnId(adTrack);
            this.hnadsa.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.hnadsa.endTransaction();
        }
    }

    @Override // com.hihonor.adsdk.base.dp.b.a
    public int hnadsc(AdTrack adTrack) {
        this.hnadsa.assertNotSuspendingTransaction();
        this.hnadsa.beginTransaction();
        try {
            int iHandle = this.hnadsd.handle(adTrack);
            this.hnadsa.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.hnadsa.endTransaction();
        }
    }

    @Override // com.hihonor.adsdk.base.dp.b.a
    public int hnadsa(AdTrack adTrack) {
        this.hnadsa.assertNotSuspendingTransaction();
        this.hnadsa.beginTransaction();
        try {
            int iHandle = this.hnadsc.handle(adTrack);
            this.hnadsa.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.hnadsa.endTransaction();
        }
    }

    @Override // com.hihonor.adsdk.base.dp.b.a
    public int hnadsb(List<AdTrack> list) {
        this.hnadsa.assertNotSuspendingTransaction();
        this.hnadsa.beginTransaction();
        try {
            int iHandleMultiple = this.hnadsc.handleMultiple(list);
            this.hnadsa.setTransactionSuccessful();
            return iHandleMultiple;
        } finally {
            this.hnadsa.endTransaction();
        }
    }

    @Override // com.hihonor.adsdk.base.dp.b.a
    public int hnadsc(List<AdTrack> list) {
        this.hnadsa.assertNotSuspendingTransaction();
        this.hnadsa.beginTransaction();
        try {
            int iHandleMultiple = this.hnadsd.handleMultiple(list);
            this.hnadsa.setTransactionSuccessful();
            return iHandleMultiple;
        } finally {
            this.hnadsa.endTransaction();
        }
    }

    @Override // com.hihonor.adsdk.base.dp.b.a
    public int hnadsa(int i, int i2) {
        this.hnadsa.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.hnadse.acquire();
        supportSQLiteStatementAcquire.bindLong(1, i2);
        supportSQLiteStatementAcquire.bindLong(2, i);
        this.hnadsa.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.hnadsa.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.hnadsa.endTransaction();
            this.hnadse.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.hihonor.adsdk.base.dp.b.a
    public List<AdTrack> hnadsb() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM AdTrack", 0);
        this.hnadsa.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.hnadsa, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, CrashHianalyticsData.TIME);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, TraceUrlData.JsonKeyOld.KEY_TRACK_URL);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackingType");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reportCnt");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reportState");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reportTime");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "method");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, TtmlNode.TAG_BODY);
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "headers");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "adUnitId");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "adId");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, ba.S);
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "recordId");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "recordIds");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "urlType");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    AdTrack adTrack = new AdTrack();
                    ArrayList arrayList2 = arrayList;
                    int i2 = columnIndexOrThrow13;
                    adTrack.id = cursorQuery.getLong(columnIndexOrThrow);
                    adTrack.setTime(cursorQuery.getLong(columnIndexOrThrow2));
                    adTrack.setTrackUrl(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    adTrack.setTrackingType(cursorQuery.getInt(columnIndexOrThrow4));
                    adTrack.setReportCnt(cursorQuery.getInt(columnIndexOrThrow5));
                    adTrack.setReportState(cursorQuery.getInt(columnIndexOrThrow6));
                    adTrack.setReportTime(cursorQuery.getLong(columnIndexOrThrow7));
                    adTrack.setMethod(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    adTrack.setBody(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                    adTrack.setHeaders(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    adTrack.setAdUnitId(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                    adTrack.setAdId(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    adTrack.setRequestId(cursorQuery.isNull(i2) ? null : cursorQuery.getString(i2));
                    int i3 = i;
                    adTrack.setRecordId(cursorQuery.isNull(i3) ? null : cursorQuery.getString(i3));
                    int i4 = columnIndexOrThrow15;
                    adTrack.setRecordIds(cursorQuery.isNull(i4) ? null : cursorQuery.getString(i4));
                    int i5 = columnIndexOrThrow16;
                    adTrack.setUrlType(cursorQuery.getInt(i5));
                    arrayList = arrayList2;
                    arrayList.add(adTrack);
                    columnIndexOrThrow16 = i5;
                    columnIndexOrThrow = columnIndexOrThrow;
                    i = i3;
                    columnIndexOrThrow13 = i2;
                    columnIndexOrThrow15 = i4;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.hihonor.adsdk.base.dp.b.a
    public int hnadsc() {
        this.hnadsa.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.hnadsi.acquire();
        this.hnadsa.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.hnadsa.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.hnadsa.endTransaction();
            this.hnadsi.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.hihonor.adsdk.base.dp.b.a
    public List<AdTrack> hnadsc(int i, int i2) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM AdTrack WHERE reportState=? ORDER BY _id DESC LIMIT ?", 2);
        roomSQLiteQueryAcquire.bindLong(1, i);
        roomSQLiteQueryAcquire.bindLong(2, i2);
        this.hnadsa.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.hnadsa, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, CrashHianalyticsData.TIME);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, TraceUrlData.JsonKeyOld.KEY_TRACK_URL);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackingType");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reportCnt");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reportState");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reportTime");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "method");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, TtmlNode.TAG_BODY);
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "headers");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "adUnitId");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "adId");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, ba.S);
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "recordId");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "recordIds");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "urlType");
                int i3 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    AdTrack adTrack = new AdTrack();
                    ArrayList arrayList2 = arrayList;
                    int i4 = columnIndexOrThrow13;
                    adTrack.id = cursorQuery.getLong(columnIndexOrThrow);
                    adTrack.setTime(cursorQuery.getLong(columnIndexOrThrow2));
                    adTrack.setTrackUrl(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    adTrack.setTrackingType(cursorQuery.getInt(columnIndexOrThrow4));
                    adTrack.setReportCnt(cursorQuery.getInt(columnIndexOrThrow5));
                    adTrack.setReportState(cursorQuery.getInt(columnIndexOrThrow6));
                    adTrack.setReportTime(cursorQuery.getLong(columnIndexOrThrow7));
                    adTrack.setMethod(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    adTrack.setBody(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                    adTrack.setHeaders(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    adTrack.setAdUnitId(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                    adTrack.setAdId(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    adTrack.setRequestId(cursorQuery.isNull(i4) ? null : cursorQuery.getString(i4));
                    int i5 = i3;
                    adTrack.setRecordId(cursorQuery.isNull(i5) ? null : cursorQuery.getString(i5));
                    columnIndexOrThrow15 = columnIndexOrThrow15;
                    adTrack.setRecordIds(cursorQuery.isNull(columnIndexOrThrow15) ? null : cursorQuery.getString(columnIndexOrThrow15));
                    int i6 = columnIndexOrThrow16;
                    adTrack.setUrlType(cursorQuery.getInt(i6));
                    arrayList = arrayList2;
                    arrayList.add(adTrack);
                    i3 = i5;
                    columnIndexOrThrow13 = i4;
                    columnIndexOrThrow16 = i6;
                    columnIndexOrThrow = columnIndexOrThrow;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.hihonor.adsdk.base.dp.b.a
    public int hnadsa(int i, long j, int i2) {
        this.hnadsa.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.hnadsf.acquire();
        supportSQLiteStatementAcquire.bindLong(1, i2);
        supportSQLiteStatementAcquire.bindLong(2, i);
        supportSQLiteStatementAcquire.bindLong(3, j);
        this.hnadsa.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.hnadsa.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.hnadsa.endTransaction();
            this.hnadsf.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.hihonor.adsdk.base.dp.b.a
    public int hnadsa(String str, int i) {
        this.hnadsa.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.hnadsg.acquire();
        supportSQLiteStatementAcquire.bindLong(1, i);
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, str);
        }
        this.hnadsa.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.hnadsa.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.hnadsa.endTransaction();
            this.hnadsg.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.hihonor.adsdk.base.dp.b.a
    public int hnadsa(long j) {
        this.hnadsa.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.hnadsh.acquire();
        supportSQLiteStatementAcquire.bindLong(1, j);
        this.hnadsa.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.hnadsa.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.hnadsa.endTransaction();
            this.hnadsh.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.hihonor.adsdk.base.dp.b.a
    public int hnadsa() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT EXISTS (SELECT 1 FROM AdTrack)", 0);
        this.hnadsa.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.hnadsa, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.hihonor.adsdk.base.dp.b.a
    public AdTrack hnadsa(String str) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        AdTrack adTrack;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM AdTrack WHERE recordId=?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.hnadsa.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.hnadsa, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, CrashHianalyticsData.TIME);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, TraceUrlData.JsonKeyOld.KEY_TRACK_URL);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackingType");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reportCnt");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reportState");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reportTime");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "method");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, TtmlNode.TAG_BODY);
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "headers");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "adUnitId");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "adId");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, ba.S);
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "recordId");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "recordIds");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "urlType");
                if (cursorQuery.moveToFirst()) {
                    AdTrack adTrack2 = new AdTrack();
                    adTrack2.id = cursorQuery.getLong(columnIndexOrThrow);
                    adTrack2.setTime(cursorQuery.getLong(columnIndexOrThrow2));
                    adTrack2.setTrackUrl(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    adTrack2.setTrackingType(cursorQuery.getInt(columnIndexOrThrow4));
                    adTrack2.setReportCnt(cursorQuery.getInt(columnIndexOrThrow5));
                    adTrack2.setReportState(cursorQuery.getInt(columnIndexOrThrow6));
                    adTrack2.setReportTime(cursorQuery.getLong(columnIndexOrThrow7));
                    adTrack2.setMethod(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    adTrack2.setBody(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                    adTrack2.setHeaders(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    adTrack2.setAdUnitId(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                    adTrack2.setAdId(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    adTrack2.setRequestId(cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13));
                    adTrack2.setRecordId(cursorQuery.isNull(columnIndexOrThrow14) ? null : cursorQuery.getString(columnIndexOrThrow14));
                    adTrack2.setRecordIds(cursorQuery.isNull(columnIndexOrThrow15) ? null : cursorQuery.getString(columnIndexOrThrow15));
                    adTrack2.setUrlType(cursorQuery.getInt(columnIndexOrThrow16));
                    adTrack = adTrack2;
                } else {
                    adTrack = null;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return adTrack;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.hihonor.adsdk.base.dp.b.a
    public List<AdTrack> hnadsb(int i, int i2) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM AdTrack WHERE reportCnt>=? AND reportState= ?", 2);
        roomSQLiteQueryAcquire.bindLong(1, i);
        roomSQLiteQueryAcquire.bindLong(2, i2);
        this.hnadsa.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.hnadsa, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, CrashHianalyticsData.TIME);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, TraceUrlData.JsonKeyOld.KEY_TRACK_URL);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackingType");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reportCnt");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reportState");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "reportTime");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "method");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, TtmlNode.TAG_BODY);
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "headers");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "adUnitId");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "adId");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, ba.S);
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "recordId");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "recordIds");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "urlType");
                int i3 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    AdTrack adTrack = new AdTrack();
                    ArrayList arrayList2 = arrayList;
                    int i4 = columnIndexOrThrow13;
                    adTrack.id = cursorQuery.getLong(columnIndexOrThrow);
                    adTrack.setTime(cursorQuery.getLong(columnIndexOrThrow2));
                    adTrack.setTrackUrl(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    adTrack.setTrackingType(cursorQuery.getInt(columnIndexOrThrow4));
                    adTrack.setReportCnt(cursorQuery.getInt(columnIndexOrThrow5));
                    adTrack.setReportState(cursorQuery.getInt(columnIndexOrThrow6));
                    adTrack.setReportTime(cursorQuery.getLong(columnIndexOrThrow7));
                    adTrack.setMethod(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    adTrack.setBody(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                    adTrack.setHeaders(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    adTrack.setAdUnitId(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                    adTrack.setAdId(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    adTrack.setRequestId(cursorQuery.isNull(i4) ? null : cursorQuery.getString(i4));
                    int i5 = i3;
                    adTrack.setRecordId(cursorQuery.isNull(i5) ? null : cursorQuery.getString(i5));
                    columnIndexOrThrow15 = columnIndexOrThrow15;
                    adTrack.setRecordIds(cursorQuery.isNull(columnIndexOrThrow15) ? null : cursorQuery.getString(columnIndexOrThrow15));
                    int i6 = columnIndexOrThrow16;
                    adTrack.setUrlType(cursorQuery.getInt(i6));
                    arrayList = arrayList2;
                    arrayList.add(adTrack);
                    i3 = i5;
                    columnIndexOrThrow13 = i4;
                    columnIndexOrThrow16 = i6;
                    columnIndexOrThrow = columnIndexOrThrow;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }
}
