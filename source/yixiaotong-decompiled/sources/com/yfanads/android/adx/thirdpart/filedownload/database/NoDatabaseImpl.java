package com.yfanads.android.adx.thirdpart.filedownload.database;

import android.util.SparseArray;
import com.yfanads.android.adx.thirdpart.filedownload.model.ConnectionModel;
import com.yfanads.android.adx.thirdpart.filedownload.model.FileDownloadModel;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadHelper;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class NoDatabaseImpl implements FileDownloadDatabase {
    final SparseArray<FileDownloadModel> downloaderModelMap = new SparseArray<>();
    final SparseArray<List<ConnectionModel>> connectionModelListMap = new SparseArray<>();

    public class Maintainer implements FileDownloadDatabase.Maintainer {
        public Maintainer() {
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase.Maintainer
        public void changeFileDownloadModelId(int i, FileDownloadModel fileDownloadModel) {
        }

        @Override // java.lang.Iterable
        public Iterator<FileDownloadModel> iterator() {
            return NoDatabaseImpl.this.new MaintainerIterator();
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase.Maintainer
        public void onFinishMaintain() {
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase.Maintainer
        public void onRefreshedValidData(FileDownloadModel fileDownloadModel) {
        }

        @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase.Maintainer
        public void onRemovedInvalidData(FileDownloadModel fileDownloadModel) {
        }
    }

    public class MaintainerIterator implements Iterator<FileDownloadModel> {
        public MaintainerIterator() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public FileDownloadModel next() {
            return null;
        }

        @Override // java.util.Iterator
        public void remove() {
        }
    }

    public static class Maker implements FileDownloadHelper.DatabaseCustomMaker {
        @Override // com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadHelper.DatabaseCustomMaker
        public FileDownloadDatabase customMake() {
            return new NoDatabaseImpl();
        }
    }

    public static Maker createMaker() {
        return new Maker();
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase
    public void clear() {
        synchronized (this.downloaderModelMap) {
            this.downloaderModelMap.clear();
        }
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase
    public FileDownloadModel find(int i) {
        FileDownloadModel fileDownloadModel;
        synchronized (this.downloaderModelMap) {
            fileDownloadModel = this.downloaderModelMap.get(i);
        }
        return fileDownloadModel;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase
    public List<ConnectionModel> findConnectionModel(int i) {
        List<ConnectionModel> list;
        ArrayList arrayList = new ArrayList();
        synchronized (this.connectionModelListMap) {
            list = this.connectionModelListMap.get(i);
        }
        if (list != null) {
            arrayList.addAll(list);
        }
        return arrayList;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase
    public void insert(FileDownloadModel fileDownloadModel) {
        synchronized (this.downloaderModelMap) {
            this.downloaderModelMap.put(fileDownloadModel.getId(), fileDownloadModel);
        }
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase
    public void insertConnectionModel(ConnectionModel connectionModel) {
        int id = connectionModel.getId();
        synchronized (this.connectionModelListMap) {
            List<ConnectionModel> arrayList = this.connectionModelListMap.get(id);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.connectionModelListMap.put(id, arrayList);
            }
            arrayList.add(connectionModel);
        }
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase
    public FileDownloadDatabase.Maintainer maintainer() {
        return new Maintainer();
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase
    public void onTaskStart(int i) {
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase
    public boolean remove(int i) {
        synchronized (this.downloaderModelMap) {
            this.downloaderModelMap.remove(i);
        }
        return true;
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase
    public void removeConnections(int i) {
        synchronized (this.connectionModelListMap) {
            this.connectionModelListMap.remove(i);
        }
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase
    public void update(FileDownloadModel fileDownloadModel) {
        if (fileDownloadModel == null) {
            FileDownloadLog.w(this, "update but model == null!", new Object[0]);
            return;
        }
        if (find(fileDownloadModel.getId()) == null) {
            insert(fileDownloadModel);
            return;
        }
        synchronized (this.downloaderModelMap) {
            this.downloaderModelMap.remove(fileDownloadModel.getId());
            this.downloaderModelMap.put(fileDownloadModel.getId(), fileDownloadModel);
        }
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase
    public void updateCompleted(int i, long j) {
        remove(i);
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase
    public void updateConnected(int i, long j, String str, String str2) {
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase
    public void updateConnectionCount(int i, int i2) {
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase
    public void updateConnectionModel(int i, int i2, long j) {
        synchronized (this.connectionModelListMap) {
            List<ConnectionModel> list = this.connectionModelListMap.get(i);
            if (list == null) {
                return;
            }
            for (ConnectionModel connectionModel : list) {
                if (connectionModel.getIndex() == i2) {
                    connectionModel.setCurrentOffset(j);
                    return;
                }
            }
        }
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase
    public void updateError(int i, Throwable th, long j) {
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase
    public void updateOldEtagOverdue(int i, String str, long j, long j2, int i2) {
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase
    public void updatePause(int i, long j) {
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase
    public void updatePending(int i) {
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase
    public void updateProgress(int i, long j) {
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase
    public void updateRetry(int i, Throwable th) {
    }
}
