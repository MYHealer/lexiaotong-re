package com.yfanads.android.adx.thirdpart.filedownload.services;

import com.yfanads.android.adx.thirdpart.filedownload.connection.DefaultConnectionCountAdapter;
import com.yfanads.android.adx.thirdpart.filedownload.connection.FileDownloadUrlConnection;
import com.yfanads.android.adx.thirdpart.filedownload.database.FileDownloadDatabase;
import com.yfanads.android.adx.thirdpart.filedownload.database.RemitDatabase;
import com.yfanads.android.adx.thirdpart.filedownload.stream.FileDownloadRandomAccessFile;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadHelper;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadLog;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadProperties;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class DownloadMgrInitialParams {
    private final InitCustomMaker mMaker;

    public static class InitCustomMaker {
        FileDownloadHelper.ConnectionCountAdapter mConnectionCountAdapter;
        FileDownloadHelper.ConnectionCreator mConnectionCreator;
        FileDownloadHelper.DatabaseCustomMaker mDatabaseCustomMaker;
        ForegroundServiceConfig mForegroundServiceConfig;
        FileDownloadHelper.IdGenerator mIdGenerator;
        Integer mMaxNetworkThreadCount;
        FileDownloadHelper.OutputStreamCreator mOutputStreamCreator;

        public void commit() {
        }

        public InitCustomMaker connectionCountAdapter(FileDownloadHelper.ConnectionCountAdapter connectionCountAdapter) {
            this.mConnectionCountAdapter = connectionCountAdapter;
            return this;
        }

        public InitCustomMaker connectionCreator(FileDownloadHelper.ConnectionCreator connectionCreator) {
            this.mConnectionCreator = connectionCreator;
            return this;
        }

        public InitCustomMaker database(FileDownloadHelper.DatabaseCustomMaker databaseCustomMaker) {
            this.mDatabaseCustomMaker = databaseCustomMaker;
            return this;
        }

        public InitCustomMaker foregroundServiceConfig(ForegroundServiceConfig foregroundServiceConfig) {
            this.mForegroundServiceConfig = foregroundServiceConfig;
            return this;
        }

        public InitCustomMaker idGenerator(FileDownloadHelper.IdGenerator idGenerator) {
            this.mIdGenerator = idGenerator;
            return this;
        }

        public InitCustomMaker maxNetworkThreadCount(int i) {
            if (i > 0) {
                this.mMaxNetworkThreadCount = Integer.valueOf(i);
            }
            return this;
        }

        public String toString() {
            return FileDownloadUtils.formatString("component: database[%s], maxNetworkCount[%s], outputStream[%s], connection[%s], connectionCountAdapter[%s]", this.mDatabaseCustomMaker, this.mMaxNetworkThreadCount, this.mOutputStreamCreator, this.mConnectionCreator, this.mConnectionCountAdapter);
        }

        public InitCustomMaker outputStreamCreator(FileDownloadHelper.OutputStreamCreator outputStreamCreator) {
            this.mOutputStreamCreator = outputStreamCreator;
            if (outputStreamCreator == null || outputStreamCreator.supportSeek() || FileDownloadProperties.getImpl().fileNonPreAllocation) {
                return this;
            }
            throw new IllegalArgumentException("Since the provided FileDownloadOutputStream does not support the seek function, if FileDownloader pre-allocates file size at the beginning of the download, it will can not be resumed from the breakpoint. If you need to ensure that the resumption is available, please add and set the value of 'file.non-pre-allocation' field to 'true' in the 'filedownloader.properties' file which is in your application assets folder manually for resolving this problem.");
        }
    }

    public DownloadMgrInitialParams() {
        this.mMaker = null;
    }

    private FileDownloadHelper.ConnectionCountAdapter createDefaultConnectionCountAdapter() {
        return new DefaultConnectionCountAdapter();
    }

    private FileDownloadHelper.ConnectionCreator createDefaultConnectionCreator() {
        return new FileDownloadUrlConnection.Creator();
    }

    private FileDownloadDatabase createDefaultDatabase() {
        return new RemitDatabase();
    }

    private ForegroundServiceConfig createDefaultForegroundServiceConfig() {
        return new ForegroundServiceConfig.Builder().needRecreateChannelId(true).build();
    }

    private FileDownloadHelper.IdGenerator createDefaultIdGenerator() {
        return new DefaultIdGenerator();
    }

    private FileDownloadHelper.OutputStreamCreator createDefaultOutputStreamCreator() {
        return new FileDownloadRandomAccessFile.Creator();
    }

    private int getDefaultMaxNetworkThreadCount() {
        return FileDownloadProperties.getImpl().downloadMaxNetworkThreadCount;
    }

    public FileDownloadDatabase createDatabase() {
        FileDownloadHelper.DatabaseCustomMaker databaseCustomMaker;
        InitCustomMaker initCustomMaker = this.mMaker;
        if (initCustomMaker == null || (databaseCustomMaker = initCustomMaker.mDatabaseCustomMaker) == null) {
            return createDefaultDatabase();
        }
        FileDownloadDatabase fileDownloadDatabaseCustomMake = databaseCustomMaker.customMake();
        if (fileDownloadDatabaseCustomMake == null) {
            return createDefaultDatabase();
        }
        if (FileDownloadLog.NEED_LOG) {
            FileDownloadLog.d(this, "initial FileDownloader manager with the customize database: %s", fileDownloadDatabaseCustomMake);
        }
        return fileDownloadDatabaseCustomMake;
    }

    public FileDownloadHelper.ConnectionCountAdapter createConnectionCountAdapter() {
        InitCustomMaker initCustomMaker = this.mMaker;
        if (initCustomMaker == null) {
            return createDefaultConnectionCountAdapter();
        }
        FileDownloadHelper.ConnectionCountAdapter connectionCountAdapter = initCustomMaker.mConnectionCountAdapter;
        if (connectionCountAdapter == null) {
            return createDefaultConnectionCountAdapter();
        }
        if (FileDownloadLog.NEED_LOG) {
            FileDownloadLog.d(this, "initial FileDownloader manager with the customize connection count adapter: %s", connectionCountAdapter);
        }
        return connectionCountAdapter;
    }

    public FileDownloadHelper.ConnectionCreator createConnectionCreator() {
        InitCustomMaker initCustomMaker = this.mMaker;
        if (initCustomMaker == null) {
            return createDefaultConnectionCreator();
        }
        FileDownloadHelper.ConnectionCreator connectionCreator = initCustomMaker.mConnectionCreator;
        if (connectionCreator == null) {
            return createDefaultConnectionCreator();
        }
        if (FileDownloadLog.NEED_LOG) {
            FileDownloadLog.d(this, "initial FileDownloader manager with the customize connection creator: %s", connectionCreator);
        }
        return connectionCreator;
    }

    public ForegroundServiceConfig createForegroundServiceConfig() {
        InitCustomMaker initCustomMaker = this.mMaker;
        if (initCustomMaker == null) {
            return createDefaultForegroundServiceConfig();
        }
        ForegroundServiceConfig foregroundServiceConfig = initCustomMaker.mForegroundServiceConfig;
        if (foregroundServiceConfig == null) {
            return createDefaultForegroundServiceConfig();
        }
        if (FileDownloadLog.NEED_LOG) {
            FileDownloadLog.d(this, "initial FileDownloader manager with the customize foreground service config: %s", foregroundServiceConfig);
        }
        return foregroundServiceConfig;
    }

    public FileDownloadHelper.IdGenerator createIdGenerator() {
        InitCustomMaker initCustomMaker = this.mMaker;
        if (initCustomMaker == null) {
            return createDefaultIdGenerator();
        }
        FileDownloadHelper.IdGenerator idGenerator = initCustomMaker.mIdGenerator;
        if (idGenerator == null) {
            return createDefaultIdGenerator();
        }
        if (FileDownloadLog.NEED_LOG) {
            FileDownloadLog.d(this, "initial FileDownloader manager with the customize id generator: %s", idGenerator);
        }
        return idGenerator;
    }

    public FileDownloadHelper.OutputStreamCreator createOutputStreamCreator() {
        InitCustomMaker initCustomMaker = this.mMaker;
        if (initCustomMaker == null) {
            return createDefaultOutputStreamCreator();
        }
        FileDownloadHelper.OutputStreamCreator outputStreamCreator = initCustomMaker.mOutputStreamCreator;
        if (outputStreamCreator == null) {
            return createDefaultOutputStreamCreator();
        }
        if (FileDownloadLog.NEED_LOG) {
            FileDownloadLog.d(this, "initial FileDownloader manager with the customize output stream: %s", outputStreamCreator);
        }
        return outputStreamCreator;
    }

    public int getMaxNetworkThreadCount() {
        InitCustomMaker initCustomMaker = this.mMaker;
        if (initCustomMaker == null) {
            return getDefaultMaxNetworkThreadCount();
        }
        Integer num = initCustomMaker.mMaxNetworkThreadCount;
        if (num == null) {
            return getDefaultMaxNetworkThreadCount();
        }
        if (FileDownloadLog.NEED_LOG) {
            FileDownloadLog.d(this, "initial FileDownloader manager with the customize maxNetworkThreadCount: %d", num);
        }
        return FileDownloadProperties.getValidNetworkThreadCount(num.intValue());
    }

    public DownloadMgrInitialParams(InitCustomMaker initCustomMaker) {
        this.mMaker = initCustomMaker;
    }
}
