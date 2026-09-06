package com.yfanads.android.utils.log.printer;

import android.text.TextUtils;
import com.facebook.common.util.UriUtil;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import com.huawei.openalliance.ad.constant.x;
import com.yfanads.android.db.imp.g;
import com.yfanads.android.libs.net.NetCallBack;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.libs.net.UrlHttpUtil;
import com.yfanads.android.libs.utils.Util;
import com.yfanads.android.model.YFAdsPhone;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.log.DateFileNameGenerator;
import com.yfanads.android.utils.log.DefaultsLogFactory;
import com.yfanads.android.utils.log.FileNameGenerator;
import com.yfanads.android.utils.log.LogContentGenerator;
import com.yfanads.android.utils.log.LogFileBean;
import com.yfanads.android.utils.log.LogLevelInterceptInterface;
import com.yfanads.android.utils.log.LogUploadResultListener;
import com.yfanads.android.utils.log.writer.SimpleWriter;
import com.yfanads.android.utils.log.writer.Writer;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class FilePrinter implements Printer {
    private static final boolean USE_WORKER = true;
    private final FileNameGenerator fileNameGenerator;
    private final String folderPath;
    private volatile boolean isUpload;
    private final LogContentGenerator logContentGenerator;
    private final LogLevelInterceptInterface logLevelInterceptInterface;
    private final long logMaxSize;
    private final int logUploadIntervalTime;
    private final Worker worker;
    private final Writer writer;
    private volatile boolean sUploadLog2FileSwitch = false;
    private volatile long lastUploadTime = 0;
    private final int NET_ERROR_CODE = 209;
    private String oaid = YFAdsPhone.getInstance().getDeviceId();

    public static class Builder {
        FileNameGenerator fileNameGenerator;
        String folderPath;
        LogContentGenerator logContentGenerator;
        LogLevelInterceptInterface logLevelInterceptInterface;
        long logMaxSize = CacheDataSink.DEFAULT_FRAGMENT_SIZE;
        int logUploadIntervalTime = 60000;
        Writer writer;

        public Builder(String str) {
            this.folderPath = str;
        }

        public FilePrinter build() {
            fillEmptyFields();
            return new FilePrinter(this);
        }

        public Builder fileNameGenerator(DateFileNameGenerator dateFileNameGenerator) {
            this.fileNameGenerator = dateFileNameGenerator;
            return this;
        }

        public Builder logContentGenerator(LogContentGenerator logContentGenerator) {
            this.logContentGenerator = logContentGenerator;
            return this;
        }

        public Builder logLevelIntercept(LogLevelInterceptInterface logLevelInterceptInterface) {
            this.logLevelInterceptInterface = logLevelInterceptInterface;
            return this;
        }

        public Builder logMaxSize(long j) {
            this.logMaxSize = j;
            return this;
        }

        public Builder logUploadIntervalTime(int i) {
            this.logUploadIntervalTime = i;
            return this;
        }

        public Builder writer(Writer writer) {
            this.writer = writer;
            return this;
        }

        private void fillEmptyFields() {
            if (this.fileNameGenerator == null) {
                this.fileNameGenerator = DefaultsLogFactory.createFileNameGenerator();
            }
            if (this.logContentGenerator == null) {
                this.logContentGenerator = DefaultsLogFactory.createLogContentGenerator();
            }
            if (this.logMaxSize == 0) {
                this.logMaxSize = DefaultsLogFactory.createLogMaxSize();
            }
            if (this.logUploadIntervalTime == 0) {
                this.logUploadIntervalTime = DefaultsLogFactory.createLogUploadIntervalTime();
            }
            if (this.logLevelInterceptInterface == null) {
                this.logLevelInterceptInterface = DefaultsLogFactory.createLogLevel();
            }
            if (this.writer == null) {
                this.writer = new SimpleWriter();
            }
        }
    }

    public class Worker implements Runnable {
        private BlockingQueue<LogFileBean> logs;
        private volatile boolean started;

        private Worker() {
            this.logs = new LinkedBlockingQueue();
        }

        public void enqueue(LogFileBean logFileBean) {
            try {
                this.logs.put(logFileBean);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public boolean isStarted() {
            boolean z;
            synchronized (this) {
                z = this.started;
            }
            return z;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            while (true) {
                try {
                    LogFileBean logFileBeanTake = this.logs.take();
                    if (logFileBeanTake == null) {
                        return;
                    } else {
                        FilePrinter.this.doPrintln(logFileBeanTake);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    synchronized (this) {
                        this.started = false;
                        return;
                    }
                }
            }
        }

        public void start() {
            synchronized (this) {
                if (this.started) {
                    return;
                }
                new Thread(this).start();
                this.started = true;
            }
        }
    }

    public FilePrinter(Builder builder) {
        this.folderPath = builder.folderPath;
        this.fileNameGenerator = builder.fileNameGenerator;
        this.logMaxSize = builder.logMaxSize;
        this.logUploadIntervalTime = builder.logUploadIntervalTime;
        this.logContentGenerator = builder.logContentGenerator;
        this.logLevelInterceptInterface = builder.logLevelInterceptInterface;
        this.writer = builder.writer;
        checkCurrentLogFile();
        this.worker = new Worker();
        checkLogFolder();
    }

    private void checkCurrentLogFile() {
        File file = new File(this.folderPath);
        File[] fileArrListFiles = file.listFiles();
        String name = (!file.isDirectory() || fileArrListFiles == null || fileArrListFiles.length <= 0) ? null : fileArrListFiles[fileArrListFiles.length - 1].getName();
        if (name != null && !TextUtils.isEmpty(name)) {
            this.fileNameGenerator.setGenerateFileName(name);
        }
        if (TextUtils.isEmpty(this.oaid)) {
            this.oaid = YFAdsPhone.getInstance().getDeviceId();
        }
        this.fileNameGenerator.setOaid(this.oaid);
    }

    private void checkLogFolder() {
        File file = new File(this.folderPath);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cleanLogAndOpenNew() {
        this.writer.close();
        this.fileNameGenerator.setGenerateFileName("");
        cleanLogFilesIfNecessary();
        return !this.writer.open(new File(this.folderPath, this.fileNameGenerator.generateFileName(new Date())));
    }

    private void cleanLogFilesIfNecessary() {
        File[] fileArrListFiles = new File(this.folderPath).listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            if (file != null && !file.getName().endsWith(".zip")) {
                file.delete();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doPrintln(LogFileBean logFileBean) throws Throwable {
        String openedFileName = this.writer.getOpenedFileName();
        boolean z = !this.writer.isOpened();
        if (TextUtils.isEmpty(this.oaid)) {
            this.oaid = YFAdsPhone.getInstance().getDeviceId();
        }
        this.fileNameGenerator.setOaid(this.oaid);
        String strGenerateFileName = this.fileNameGenerator.generateFileName(new Date());
        if (strGenerateFileName == null || strGenerateFileName.trim().isEmpty()) {
            return;
        }
        if (!strGenerateFileName.equals(openedFileName) || z) {
            this.writer.close();
            if (!this.writer.open(new File(this.folderPath, strGenerateFileName))) {
                return;
            }
        }
        if (this.lastUploadTime == 0) {
            this.lastUploadTime = System.currentTimeMillis();
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.lastUploadTime;
        if (isOverUploadMaxSize() || (this.writer.getOpenedFile() != null && jCurrentTimeMillis > this.logUploadIntervalTime)) {
            executeUploadLog(logFileBean);
        } else {
            this.writer.appendLog(this.logContentGenerator.generateLogContent(logFileBean));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doUploadSuccess(File file) {
        if (file.exists()) {
            file.delete();
        }
    }

    private void executeUploadLog(final LogFileBean logFileBean) throws Throwable {
        if (needUploadLog()) {
            handleUploadLog(new LogUploadResultListener() { // from class: com.yfanads.android.utils.log.printer.FilePrinter.1
                @Override // com.yfanads.android.utils.log.LogUploadResultListener
                public void onUploadFailure(File file) {
                    FilePrinter.this.isUpload = false;
                    FilePrinter.this.doUploadSuccess(file);
                    if (FilePrinter.this.cleanLogAndOpenNew()) {
                        return;
                    }
                    FilePrinter.this.writer.appendLog(FilePrinter.this.logContentGenerator.generateLogContent(logFileBean));
                }

                @Override // com.yfanads.android.utils.log.LogUploadResultListener
                public void onUploadSuccess(File file) {
                    FilePrinter.this.isUpload = false;
                    FilePrinter.this.doUploadSuccess(file);
                    if (FilePrinter.this.cleanLogAndOpenNew()) {
                        return;
                    }
                    FilePrinter.this.writer.appendLog(FilePrinter.this.logContentGenerator.generateLogContent(logFileBean));
                }
            });
        } else {
            if (isOverUploadMaxSize() && cleanLogAndOpenNew()) {
                return;
            }
            this.writer.appendLog(this.logContentGenerator.generateLogContent(logFileBean));
        }
    }

    private void handleUploadLog(final LogUploadResultListener logUploadResultListener) throws Throwable {
        this.lastUploadTime = System.currentTimeMillis();
        String str = new File(this.folderPath).getAbsolutePath() + "/" + Util.getFileNameWithoutExtension(this.writer.getOpenedFile()) + ".zip";
        Util.zipFolder(this.writer.getOpenedFile().getAbsolutePath(), str);
        final File file = new File(str);
        doUploadFile(file, new NetCallBack.NetCallBackString() { // from class: com.yfanads.android.utils.log.printer.FilePrinter.2
            @Override // com.yfanads.android.libs.net.NetCallBack
            /* JADX INFO: renamed from: onFailure */
            public void m1259lambda$onError$0$comyfanadsandroidlibsnetNetCallBack(int i, String str2) {
                if (i != 209) {
                    logUploadResultListener.onUploadFailure(file);
                    return;
                }
                logUploadResultListener.onUploadSuccess(file);
                InitUtils.closeULF();
                g.a("sdkConf", InitUtils.getConfModel());
            }

            @Override // com.yfanads.android.libs.net.NetCallBack
            /* JADX INFO: renamed from: onResponse, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public void m1262lambda$onSuccess$3$comyfanadsandroidlibsnetNetCallBack(String str2) {
                logUploadResultListener.onUploadSuccess(file);
            }
        });
    }

    private boolean isOverUploadMaxSize() {
        return this.writer.getOpenedFile() != null && this.writer.getOpenedFile().length() >= this.logMaxSize;
    }

    private boolean needUploadLog() {
        return !this.isUpload && (this.sUploadLog2FileSwitch || InitUtils.isULFOpen());
    }

    @Override // com.yfanads.android.utils.log.printer.Printer
    public void println(LogFileBean logFileBean) {
        if (!this.worker.isStarted()) {
            this.worker.start();
        }
        this.worker.enqueue(logFileBean);
    }

    public void switchUploadLogFile(boolean z) {
        this.sUploadLog2FileSwitch = z;
    }

    private void doUploadFile(File file, NetCallBack<?> netCallBack) {
        this.isUpload = true;
        String str = Util.getFileNameWithoutExtension(file) + "~" + new SimpleDateFormat("MM-dd HH_mm_ss", Locale.getDefault()).format(new Date()) + ".zip";
        UrlHttpUtil.uploadFile(UrlConst.getUploadLog() + "?sign=" + Util.md5(str + x.bQ + UrlConst.getSignKey()) + "&device_type=0", file, str, UriUtil.LOCAL_FILE_SCHEME, "application/zip", netCallBack);
    }
}
