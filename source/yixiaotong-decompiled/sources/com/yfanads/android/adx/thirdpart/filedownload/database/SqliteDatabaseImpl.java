package com.yfanads.android.adx.thirdpart.filedownload.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.SparseArray;
import com.yfanads.android.adx.thirdpart.filedownload.model.ConnectionModel;
import com.yfanads.android.adx.thirdpart.filedownload.model.FileDownloadModel;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadHelper;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadLog;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class SqliteDatabaseImpl implements FileDownloadDatabase {
    public static final String CONNECTION_TABLE_NAME = "filedownloaderConnection";
    public static final String TABLE_NAME = "filedownloader";
    private final SQLiteDatabase db = new SqliteDatabaseOpenHelper(FileDownloadHelper.getAppContext()).getWritableDatabase();

    public class Maintainer implements FileDownloadDatabase.Maintainer {
        private final SparseArray<List<ConnectionModel>> connectionModelListMap;
        private MaintainerIterator currentIterator;
        private final SparseArray<FileDownloadModel> downloaderModelMap;
        private final SparseArray<FileDownloadModel> needChangeIdList;

        public Maintainer(SqliteDatabaseImpl sqliteDatabaseImpl) {
            this(null, null);
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase.Maintainer
        public void changeFileDownloadModelId(int i, FileDownloadModel fileDownloadModel) {
            this.needChangeIdList.put(i, fileDownloadModel);
        }

        @Override // java.lang.Iterable
        public Iterator<FileDownloadModel> iterator() {
            MaintainerIterator maintainerIterator = SqliteDatabaseImpl.this.new MaintainerIterator();
            this.currentIterator = maintainerIterator;
            return maintainerIterator;
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase.Maintainer
        public void onFinishMaintain() {
            MaintainerIterator maintainerIterator = this.currentIterator;
            if (maintainerIterator != null) {
                maintainerIterator.onFinishMaintain();
            }
            int size = this.needChangeIdList.size();
            if (size < 0) {
                return;
            }
            SqliteDatabaseImpl.this.db.beginTransaction();
            for (int i = 0; i < size; i++) {
                try {
                    int iKeyAt = this.needChangeIdList.keyAt(i);
                    FileDownloadModel fileDownloadModel = this.needChangeIdList.get(iKeyAt);
                    SqliteDatabaseImpl.this.db.delete(SqliteDatabaseImpl.TABLE_NAME, "_id = ?", new String[]{String.valueOf(iKeyAt)});
                    SqliteDatabaseImpl.this.db.insert(SqliteDatabaseImpl.TABLE_NAME, null, fileDownloadModel.toContentValues());
                    if (fileDownloadModel.getConnectionCount() > 1) {
                        List<ConnectionModel> listFindConnectionModel = SqliteDatabaseImpl.this.findConnectionModel(iKeyAt);
                        if (listFindConnectionModel.size() > 0) {
                            SqliteDatabaseImpl.this.db.delete(SqliteDatabaseImpl.CONNECTION_TABLE_NAME, "id = ?", new String[]{String.valueOf(iKeyAt)});
                            for (ConnectionModel connectionModel : listFindConnectionModel) {
                                connectionModel.setId(fileDownloadModel.getId());
                                SqliteDatabaseImpl.this.db.insert(SqliteDatabaseImpl.CONNECTION_TABLE_NAME, null, connectionModel.toContentValues());
                            }
                        }
                    }
                } catch (Throwable th) {
                    SqliteDatabaseImpl.this.db.endTransaction();
                    throw th;
                }
            }
            SparseArray<FileDownloadModel> sparseArray = this.downloaderModelMap;
            if (sparseArray != null && this.connectionModelListMap != null) {
                int size2 = sparseArray.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    int id = this.downloaderModelMap.valueAt(i2).getId();
                    List<ConnectionModel> listFindConnectionModel2 = SqliteDatabaseImpl.this.findConnectionModel(id);
                    if (listFindConnectionModel2 != null && listFindConnectionModel2.size() > 0) {
                        this.connectionModelListMap.put(id, listFindConnectionModel2);
                    }
                }
            }
            SqliteDatabaseImpl.this.db.setTransactionSuccessful();
            SqliteDatabaseImpl.this.db.endTransaction();
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase.Maintainer
        public void onRefreshedValidData(FileDownloadModel fileDownloadModel) {
            SparseArray<FileDownloadModel> sparseArray = this.downloaderModelMap;
            if (sparseArray != null) {
                sparseArray.put(fileDownloadModel.getId(), fileDownloadModel);
            }
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase.Maintainer
        public void onRemovedInvalidData(FileDownloadModel fileDownloadModel) {
        }

        public Maintainer(SparseArray<FileDownloadModel> sparseArray, SparseArray<List<ConnectionModel>> sparseArray2) {
            this.needChangeIdList = new SparseArray<>();
            this.downloaderModelMap = sparseArray;
            this.connectionModelListMap = sparseArray2;
        }
    }

    public class MaintainerIterator implements Iterator<FileDownloadModel> {
        private final Cursor c;
        private int currentId;
        private final List<Integer> needRemoveId = new ArrayList();

        public MaintainerIterator() {
            this.c = SqliteDatabaseImpl.this.db.rawQuery("SELECT * FROM filedownloader", null);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.c.moveToNext();
        }

        public void onFinishMaintain() {
            this.c.close();
            if (this.needRemoveId.isEmpty()) {
                return;
            }
            String strJoin = TextUtils.join(", ", this.needRemoveId);
            if (FileDownloadLog.NEED_LOG) {
                FileDownloadLog.d(this, "delete %s", strJoin);
            }
            SqliteDatabaseImpl.this.db.execSQL(FileDownloadUtils.formatString("DELETE FROM %s WHERE %s IN (%s);", SqliteDatabaseImpl.TABLE_NAME, "_id", strJoin));
            SqliteDatabaseImpl.this.db.execSQL(FileDownloadUtils.formatString("DELETE FROM %s WHERE %s IN (%s);", SqliteDatabaseImpl.CONNECTION_TABLE_NAME, "id", strJoin));
        }

        @Override // java.util.Iterator
        public void remove() {
            this.needRemoveId.add(Integer.valueOf(this.currentId));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public FileDownloadModel next() {
            FileDownloadModel fileDownloadModelCreateFromCursor = SqliteDatabaseImpl.createFromCursor(this.c);
            this.currentId = fileDownloadModelCreateFromCursor.getId();
            return fileDownloadModelCreateFromCursor;
        }
    }

    public static class Maker implements FileDownloadHelper.DatabaseCustomMaker {
        @Override // com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadHelper.DatabaseCustomMaker
        public FileDownloadDatabase customMake() {
            return new SqliteDatabaseImpl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static FileDownloadModel createFromCursor(Cursor cursor) {
        FileDownloadModel fileDownloadModel = new FileDownloadModel();
        fileDownloadModel.setId(cursor.getInt(cursor.getColumnIndex("_id")));
        fileDownloadModel.setUrl(cursor.getString(cursor.getColumnIndex("url")));
        fileDownloadModel.setPath(cursor.getString(cursor.getColumnIndex("path")), cursor.getShort(cursor.getColumnIndex(FileDownloadModel.PATH_AS_DIRECTORY)) == 1);
        fileDownloadModel.setStatus((byte) cursor.getShort(cursor.getColumnIndex("status")));
        fileDownloadModel.setSoFar(cursor.getLong(cursor.getColumnIndex(FileDownloadModel.SOFAR)));
        fileDownloadModel.setTotal(cursor.getLong(cursor.getColumnIndex(FileDownloadModel.TOTAL)));
        fileDownloadModel.setErrMsg(cursor.getString(cursor.getColumnIndex(FileDownloadModel.ERR_MSG)));
        fileDownloadModel.setETag(cursor.getString(cursor.getColumnIndex(FileDownloadModel.ETAG)));
        fileDownloadModel.setFilename(cursor.getString(cursor.getColumnIndex(FileDownloadModel.FILENAME)));
        fileDownloadModel.setConnectionCount(cursor.getInt(cursor.getColumnIndex(FileDownloadModel.CONNECTION_COUNT)));
        return fileDownloadModel;
    }

    public static Maker createMaker() {
        return new Maker();
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase
    public void clear() {
        this.db.delete(TABLE_NAME, null, null);
        this.db.delete(CONNECTION_TABLE_NAME, null, null);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase
    public FileDownloadModel find(int i) throws Throwable {
        Throwable th;
        Cursor cursorRawQuery;
        try {
            cursorRawQuery = this.db.rawQuery(FileDownloadUtils.formatString("SELECT * FROM %s WHERE %s = ?", TABLE_NAME, "_id"), new String[]{Integer.toString(i)});
            try {
                if (!cursorRawQuery.moveToNext()) {
                    cursorRawQuery.close();
                    return null;
                }
                FileDownloadModel fileDownloadModelCreateFromCursor = createFromCursor(cursorRawQuery);
                cursorRawQuery.close();
                return fileDownloadModelCreateFromCursor;
            } catch (Throwable th2) {
                th = th2;
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            cursorRawQuery = null;
        }
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase
    public List<ConnectionModel> findConnectionModel(int i) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = this.db.rawQuery(FileDownloadUtils.formatString("SELECT * FROM %s WHERE %s = ?", CONNECTION_TABLE_NAME, "id"), new String[]{Integer.toString(i)});
            while (cursorRawQuery.moveToNext()) {
                ConnectionModel connectionModel = new ConnectionModel();
                connectionModel.setId(i);
                connectionModel.setIndex(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(ConnectionModel.INDEX)));
                connectionModel.setStartOffset(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex(ConnectionModel.START_OFFSET)));
                connectionModel.setCurrentOffset(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex(ConnectionModel.CURRENT_OFFSET)));
                connectionModel.setEndOffset(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex(ConnectionModel.END_OFFSET)));
                arrayList.add(connectionModel);
            }
            cursorRawQuery.close();
            return arrayList;
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase
    public void insert(FileDownloadModel fileDownloadModel) {
        this.db.insert(TABLE_NAME, null, fileDownloadModel.toContentValues());
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase
    public void insertConnectionModel(ConnectionModel connectionModel) {
        this.db.insert(CONNECTION_TABLE_NAME, null, connectionModel.toContentValues());
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase
    public FileDownloadDatabase.Maintainer maintainer() {
        return new Maintainer(this);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase
    public void onTaskStart(int i) {
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase
    public void removeConnections(int i) {
        this.db.execSQL("DELETE FROM filedownloaderConnection WHERE id = " + i);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase
    public void update(FileDownloadModel fileDownloadModel) {
        if (fileDownloadModel == null) {
            FileDownloadLog.w(this, "update but model == null!", new Object[0]);
        } else if (find(fileDownloadModel.getId()) == null) {
            insert(fileDownloadModel);
        } else {
            this.db.update(TABLE_NAME, fileDownloadModel.toContentValues(), "_id = ? ", new String[]{String.valueOf(fileDownloadModel.getId())});
        }
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase
    public void updateCompleted(int i, long j) {
        remove(i);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase
    public void updateConnected(int i, long j, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) 2);
        contentValues.put(FileDownloadModel.TOTAL, Long.valueOf(j));
        contentValues.put(FileDownloadModel.ETAG, str);
        contentValues.put(FileDownloadModel.FILENAME, str2);
        update(i, contentValues);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase
    public void updateConnectionCount(int i, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(FileDownloadModel.CONNECTION_COUNT, Integer.valueOf(i2));
        this.db.update(TABLE_NAME, contentValues, "_id = ? ", new String[]{Integer.toString(i)});
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase
    public void updateConnectionModel(int i, int i2, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConnectionModel.CURRENT_OFFSET, Long.valueOf(j));
        this.db.update(CONNECTION_TABLE_NAME, contentValues, "id = ? AND connectionIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2)});
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase
    public void updateError(int i, Throwable th, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(FileDownloadModel.ERR_MSG, th.toString());
        contentValues.put("status", (Byte) (byte) -1);
        contentValues.put(FileDownloadModel.SOFAR, Long.valueOf(j));
        update(i, contentValues);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase
    public void updateOldEtagOverdue(int i, String str, long j, long j2, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(FileDownloadModel.SOFAR, Long.valueOf(j));
        contentValues.put(FileDownloadModel.TOTAL, Long.valueOf(j2));
        contentValues.put(FileDownloadModel.ETAG, str);
        contentValues.put(FileDownloadModel.CONNECTION_COUNT, Integer.valueOf(i2));
        update(i, contentValues);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase
    public void updatePause(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) -2);
        contentValues.put(FileDownloadModel.SOFAR, Long.valueOf(j));
        update(i, contentValues);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase
    public void updatePending(int i) {
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase
    public void updateProgress(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) 3);
        contentValues.put(FileDownloadModel.SOFAR, Long.valueOf(j));
        update(i, contentValues);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase
    public void updateRetry(int i, Throwable th) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(FileDownloadModel.ERR_MSG, th.toString());
        contentValues.put("status", (Byte) (byte) 5);
        update(i, contentValues);
    }

    public FileDownloadDatabase.Maintainer maintainer(SparseArray<FileDownloadModel> sparseArray, SparseArray<List<ConnectionModel>> sparseArray2) {
        return new Maintainer(sparseArray, sparseArray2);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase
    public boolean remove(int i) {
        return this.db.delete(TABLE_NAME, "_id = ?", new String[]{String.valueOf(i)}) != 0;
    }

    private void update(int i, ContentValues contentValues) {
        this.db.update(TABLE_NAME, contentValues, "_id = ? ", new String[]{String.valueOf(i)});
    }
}
