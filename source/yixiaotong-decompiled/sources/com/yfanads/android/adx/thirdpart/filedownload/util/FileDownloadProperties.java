package com.yfanads.android.adx.thirdpart.filedownload.util;

import com.google.android.exoplayer2.ExoPlayer;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class FileDownloadProperties {
    private static final String FALSE_STRING = "false";
    private static final String KEY_BROADCAST_COMPLETED = "broadcast.completed";
    private static final String KEY_DOWNLOAD_MAX_NETWORK_THREAD_COUNT = "download.max-network-thread-count";
    private static final String KEY_DOWNLOAD_MIN_PROGRESS_STEP = "download.min-progress-step";
    private static final String KEY_DOWNLOAD_MIN_PROGRESS_TIME = "download.min-progress-time";
    private static final String KEY_FILE_NON_PRE_ALLOCATION = "file.non-pre-allocation";
    private static final String KEY_HTTP_LENIENT = "http.lenient";
    private static final String KEY_PROCESS_NON_SEPARATE = "process.non-separate";
    private static final String KEY_TRIAL_CONNECTION_HEAD_METHOD = "download.trial-connection-head-method";
    private static final String TRUE_STRING = "true";
    public final boolean broadcastCompleted;
    public final int downloadMaxNetworkThreadCount;
    public final int downloadMinProgressStep;
    public final long downloadMinProgressTime;
    public final boolean fileNonPreAllocation;
    public final boolean httpLenient;
    public final boolean processNonSeparate;
    public final boolean trialConnectionHeadMethod;

    /* JADX INFO: renamed from: com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadProperties$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class HolderClass {
        private static final FileDownloadProperties INSTANCE = new FileDownloadProperties(null);
    }

    public /* synthetic */ FileDownloadProperties(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static FileDownloadProperties getImpl() {
        return HolderClass.INSTANCE;
    }

    public static int getValidNetworkThreadCount(int i) {
        if (i > 12) {
            FileDownloadLog.w(FileDownloadProperties.class, "require the count of network thread  is %d, what is more than the max valid count(%d), so adjust to %d auto", Integer.valueOf(i), 12, 12);
            return 12;
        }
        if (i >= 1) {
            return i;
        }
        FileDownloadLog.w(FileDownloadProperties.class, "require the count of network thread  is %d, what is less than the min valid count(%d), so adjust to %d auto", Integer.valueOf(i), 1, 1);
        return 1;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:105:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:107:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:113:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:115:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:117:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:123:0x0201  */
    /* JADX WARN: Code duplicated, block: B:126:0x0208  */
    /* JADX WARN: Code duplicated, block: B:138:0x00d3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:162:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x00ba A[Catch: all -> 0x025e, TryCatch #13 {all -> 0x025e, blocks: (B:7:0x0030, B:8:0x0037, B:9:0x003b, B:10:0x0041, B:11:0x0047, B:12:0x004d, B:13:0x0051, B:14:0x0055, B:50:0x00b6, B:52:0x00ba, B:54:0x00be, B:56:0x00cc), top: B:156:0x0030 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x00be A[Catch: all -> 0x025e, TryCatch #13 {all -> 0x025e, blocks: (B:7:0x0030, B:8:0x0037, B:9:0x003b, B:10:0x0041, B:11:0x0047, B:12:0x004d, B:13:0x0051, B:14:0x0055, B:50:0x00b6, B:52:0x00ba, B:54:0x00be, B:56:0x00cc), top: B:156:0x0030 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:56:0x00cc A[Catch: all -> 0x025e, TRY_LEAVE, TryCatch #13 {all -> 0x025e, blocks: (B:7:0x0030, B:8:0x0037, B:9:0x003b, B:10:0x0041, B:11:0x0047, B:12:0x004d, B:13:0x0051, B:14:0x0055, B:50:0x00b6, B:52:0x00ba, B:54:0x00be, B:56:0x00cc), top: B:156:0x0030 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:68:0x0104  */
    /* JADX WARN: Code duplicated, block: B:74:0x0120  */
    /* JADX WARN: Code duplicated, block: B:76:0x0125  */
    /* JADX WARN: Code duplicated, block: B:78:0x012b  */
    /* JADX WARN: Code duplicated, block: B:84:0x0148  */
    /* JADX WARN: Code duplicated, block: B:86:0x014d  */
    /* JADX WARN: Code duplicated, block: B:87:0x015c  */
    /* JADX WARN: Code duplicated, block: B:89:0x0162  */
    /* JADX WARN: Code duplicated, block: B:90:0x0174  */
    /* JADX WARN: Code duplicated, block: B:92:0x017b  */
    /* JADX WARN: Code duplicated, block: B:93:0x018a  */
    /* JADX WARN: Code duplicated, block: B:95:0x018f  */
    /* JADX WARN: Code duplicated, block: B:97:0x0195  */
    private FileDownloadProperties() throws Throwable {
        Throwable th;
        InputStream inputStream;
        String property;
        InputStream inputStreamOpen;
        String property2;
        String property3;
        String property4;
        String property5;
        String property6;
        String property7;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String property8;
        int i;
        String str8;
        if (FileDownloadHelper.getAppContext() == null) {
            throw new IllegalStateException("Please invoke the 'FileDownloader#setup' before using FileDownloader. If you want to register some components on FileDownloader please invoke the 'FileDownloader#setupOnApplicationOnCreate' on the 'Application#onCreate' first.");
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Properties properties = new Properties();
        try {
            inputStreamOpen = FileDownloadHelper.getAppContext().getAssets().open("filedownloader.properties");
            if (inputStreamOpen != null) {
                try {
                    try {
                        properties.load(inputStreamOpen);
                        property2 = properties.getProperty(KEY_HTTP_LENIENT);
                        try {
                            property3 = properties.getProperty(KEY_PROCESS_NON_SEPARATE);
                            try {
                                property4 = properties.getProperty(KEY_DOWNLOAD_MIN_PROGRESS_STEP);
                                try {
                                    property = properties.getProperty(KEY_DOWNLOAD_MIN_PROGRESS_TIME);
                                    try {
                                        property7 = properties.getProperty(KEY_DOWNLOAD_MAX_NETWORK_THREAD_COUNT);
                                        try {
                                            property5 = properties.getProperty(KEY_FILE_NON_PRE_ALLOCATION);
                                            try {
                                                property6 = properties.getProperty(KEY_BROADCAST_COMPLETED);
                                                try {
                                                    str8 = property3;
                                                    property8 = properties.getProperty(KEY_TRIAL_CONNECTION_HEAD_METHOD);
                                                    str2 = property7;
                                                    str3 = property;
                                                    str = property2;
                                                } catch (IOException e) {
                                                    e = e;
                                                    property7 = property7;
                                                    if (e instanceof FileNotFoundException) {
                                                        e.printStackTrace();
                                                    } else if (FileDownloadLog.NEED_LOG) {
                                                        FileDownloadLog.d(FileDownloadProperties.class, "not found filedownloader.properties", new Object[0]);
                                                    }
                                                    if (inputStreamOpen != null) {
                                                        try {
                                                            inputStreamOpen.close();
                                                        } catch (IOException e2) {
                                                            e = e2;
                                                            str = property2;
                                                            str2 = property7;
                                                            str3 = property;
                                                            str4 = null;
                                                            e.printStackTrace();
                                                            str5 = property3;
                                                            property8 = str4;
                                                            str6 = property5;
                                                            str7 = property6;
                                                        }
                                                    }
                                                    str = property2;
                                                    str5 = property3;
                                                    str6 = property5;
                                                    str7 = property6;
                                                    str2 = property7;
                                                    str3 = property;
                                                    property8 = null;
                                                }
                                            } catch (IOException e3) {
                                                e = e3;
                                                property6 = null;
                                                if (e instanceof FileNotFoundException) {
                                                    e.printStackTrace();
                                                } else if (FileDownloadLog.NEED_LOG) {
                                                    FileDownloadLog.d(FileDownloadProperties.class, "not found filedownloader.properties", new Object[0]);
                                                }
                                                if (inputStreamOpen != null) {
                                                    inputStreamOpen.close();
                                                }
                                                str = property2;
                                                str5 = property3;
                                                str6 = property5;
                                                str7 = property6;
                                                str2 = property7;
                                                str3 = property;
                                                property8 = null;
                                                if (str == null) {
                                                    if (str.equals("true")) {
                                                    }
                                                    this.httpLenient = str.equals("true");
                                                } else {
                                                    this.httpLenient = false;
                                                }
                                                if (str5 == null) {
                                                    if (str5.equals("true")) {
                                                    }
                                                    this.processNonSeparate = str5.equals("true");
                                                    i = 0;
                                                } else {
                                                    i = 0;
                                                    this.processNonSeparate = false;
                                                }
                                                if (property4 != null) {
                                                    this.downloadMinProgressStep = Math.max(i, Integer.valueOf(property4).intValue());
                                                } else {
                                                    this.downloadMinProgressStep = 65536;
                                                }
                                                if (str3 != null) {
                                                    this.downloadMinProgressTime = Math.max(0L, Long.valueOf(str3).longValue());
                                                } else {
                                                    this.downloadMinProgressTime = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
                                                }
                                                if (str2 != null) {
                                                    this.downloadMaxNetworkThreadCount = getValidNetworkThreadCount(Integer.valueOf(str2).intValue());
                                                } else {
                                                    this.downloadMaxNetworkThreadCount = 3;
                                                }
                                                if (str6 == null) {
                                                    if (str6.equals("true")) {
                                                    }
                                                    this.fileNonPreAllocation = str6.equals("true");
                                                } else {
                                                    this.fileNonPreAllocation = false;
                                                }
                                                if (str7 == null) {
                                                    if (str7.equals("true")) {
                                                    }
                                                    this.broadcastCompleted = str7.equals("true");
                                                } else {
                                                    this.broadcastCompleted = false;
                                                }
                                                if (property8 == 0) {
                                                    if (property8.equals("true")) {
                                                    }
                                                    this.trialConnectionHeadMethod = property8.equals("true");
                                                } else {
                                                    this.trialConnectionHeadMethod = false;
                                                }
                                                if (FileDownloadLog.NEED_LOG) {
                                                    FileDownloadLog.i(FileDownloadProperties.class, "init properties %d\n load properties: %s=%B; %s=%B; %s=%d; %s=%d; %s=%d; %s=%B; %s=%B; %s=%B", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), KEY_HTTP_LENIENT, Boolean.valueOf(this.httpLenient), KEY_PROCESS_NON_SEPARATE, Boolean.valueOf(this.processNonSeparate), KEY_DOWNLOAD_MIN_PROGRESS_STEP, Integer.valueOf(this.downloadMinProgressStep), KEY_DOWNLOAD_MIN_PROGRESS_TIME, Long.valueOf(this.downloadMinProgressTime), KEY_DOWNLOAD_MAX_NETWORK_THREAD_COUNT, Integer.valueOf(this.downloadMaxNetworkThreadCount), KEY_FILE_NON_PRE_ALLOCATION, Boolean.valueOf(this.fileNonPreAllocation), KEY_BROADCAST_COMPLETED, Boolean.valueOf(this.broadcastCompleted), KEY_TRIAL_CONNECTION_HEAD_METHOD, Boolean.valueOf(this.trialConnectionHeadMethod));
                                                }
                                            }
                                        } catch (IOException e4) {
                                            e = e4;
                                            property5 = null;
                                        }
                                    } catch (IOException e5) {
                                        e = e5;
                                        property5 = null;
                                        property6 = null;
                                        property7 = null;
                                        if (e instanceof FileNotFoundException) {
                                            e.printStackTrace();
                                        } else if (FileDownloadLog.NEED_LOG) {
                                            FileDownloadLog.d(FileDownloadProperties.class, "not found filedownloader.properties", new Object[0]);
                                        }
                                        if (inputStreamOpen != null) {
                                            inputStreamOpen.close();
                                        }
                                        str = property2;
                                        str5 = property3;
                                        str6 = property5;
                                        str7 = property6;
                                        str2 = property7;
                                        str3 = property;
                                        property8 = null;
                                        if (str == null) {
                                            if (str.equals("true")) {
                                            }
                                            this.httpLenient = str.equals("true");
                                        } else {
                                            this.httpLenient = false;
                                        }
                                        if (str5 == null) {
                                            if (str5.equals("true")) {
                                            }
                                            this.processNonSeparate = str5.equals("true");
                                            i = 0;
                                        } else {
                                            i = 0;
                                            this.processNonSeparate = false;
                                        }
                                        if (property4 != null) {
                                            this.downloadMinProgressStep = Math.max(i, Integer.valueOf(property4).intValue());
                                        } else {
                                            this.downloadMinProgressStep = 65536;
                                        }
                                        if (str3 != null) {
                                            this.downloadMinProgressTime = Math.max(0L, Long.valueOf(str3).longValue());
                                        } else {
                                            this.downloadMinProgressTime = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
                                        }
                                        if (str2 != null) {
                                            this.downloadMaxNetworkThreadCount = getValidNetworkThreadCount(Integer.valueOf(str2).intValue());
                                        } else {
                                            this.downloadMaxNetworkThreadCount = 3;
                                        }
                                        if (str6 == null) {
                                            if (str6.equals("true")) {
                                            }
                                            this.fileNonPreAllocation = str6.equals("true");
                                        } else {
                                            this.fileNonPreAllocation = false;
                                        }
                                        if (str7 == null) {
                                            if (str7.equals("true")) {
                                            }
                                            this.broadcastCompleted = str7.equals("true");
                                        } else {
                                            this.broadcastCompleted = false;
                                        }
                                        if (property8 == 0) {
                                            if (property8.equals("true")) {
                                            }
                                            this.trialConnectionHeadMethod = property8.equals("true");
                                        } else {
                                            this.trialConnectionHeadMethod = false;
                                        }
                                        if (FileDownloadLog.NEED_LOG) {
                                            FileDownloadLog.i(FileDownloadProperties.class, "init properties %d\n load properties: %s=%B; %s=%B; %s=%d; %s=%d; %s=%d; %s=%B; %s=%B; %s=%B", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), KEY_HTTP_LENIENT, Boolean.valueOf(this.httpLenient), KEY_PROCESS_NON_SEPARATE, Boolean.valueOf(this.processNonSeparate), KEY_DOWNLOAD_MIN_PROGRESS_STEP, Integer.valueOf(this.downloadMinProgressStep), KEY_DOWNLOAD_MIN_PROGRESS_TIME, Long.valueOf(this.downloadMinProgressTime), KEY_DOWNLOAD_MAX_NETWORK_THREAD_COUNT, Integer.valueOf(this.downloadMaxNetworkThreadCount), KEY_FILE_NON_PRE_ALLOCATION, Boolean.valueOf(this.fileNonPreAllocation), KEY_BROADCAST_COMPLETED, Boolean.valueOf(this.broadcastCompleted), KEY_TRIAL_CONNECTION_HEAD_METHOD, Boolean.valueOf(this.trialConnectionHeadMethod));
                                        }
                                    }
                                } catch (IOException e6) {
                                    e = e6;
                                    property = null;
                                }
                            } catch (IOException e7) {
                                e = e7;
                                property = null;
                                property4 = null;
                                property5 = null;
                                property6 = null;
                                property7 = null;
                                if (e instanceof FileNotFoundException) {
                                    e.printStackTrace();
                                } else if (FileDownloadLog.NEED_LOG) {
                                    FileDownloadLog.d(FileDownloadProperties.class, "not found filedownloader.properties", new Object[0]);
                                }
                                if (inputStreamOpen != null) {
                                    inputStreamOpen.close();
                                }
                                str = property2;
                                str5 = property3;
                                str6 = property5;
                                str7 = property6;
                                str2 = property7;
                                str3 = property;
                                property8 = null;
                                if (str == null) {
                                    if (str.equals("true")) {
                                    }
                                    this.httpLenient = str.equals("true");
                                } else {
                                    this.httpLenient = false;
                                }
                                if (str5 == null) {
                                    if (str5.equals("true")) {
                                    }
                                    this.processNonSeparate = str5.equals("true");
                                    i = 0;
                                } else {
                                    i = 0;
                                    this.processNonSeparate = false;
                                }
                                if (property4 != null) {
                                    this.downloadMinProgressStep = Math.max(i, Integer.valueOf(property4).intValue());
                                } else {
                                    this.downloadMinProgressStep = 65536;
                                }
                                if (str3 != null) {
                                    this.downloadMinProgressTime = Math.max(0L, Long.valueOf(str3).longValue());
                                } else {
                                    this.downloadMinProgressTime = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
                                }
                                if (str2 != null) {
                                    this.downloadMaxNetworkThreadCount = getValidNetworkThreadCount(Integer.valueOf(str2).intValue());
                                } else {
                                    this.downloadMaxNetworkThreadCount = 3;
                                }
                                if (str6 == null) {
                                    if (str6.equals("true")) {
                                    }
                                    this.fileNonPreAllocation = str6.equals("true");
                                } else {
                                    this.fileNonPreAllocation = false;
                                }
                                if (str7 == null) {
                                    if (str7.equals("true")) {
                                    }
                                    this.broadcastCompleted = str7.equals("true");
                                } else {
                                    this.broadcastCompleted = false;
                                }
                                if (property8 == 0) {
                                    if (property8.equals("true")) {
                                    }
                                    this.trialConnectionHeadMethod = property8.equals("true");
                                } else {
                                    this.trialConnectionHeadMethod = false;
                                }
                                if (FileDownloadLog.NEED_LOG) {
                                    FileDownloadLog.i(FileDownloadProperties.class, "init properties %d\n load properties: %s=%B; %s=%B; %s=%d; %s=%d; %s=%d; %s=%B; %s=%B; %s=%B", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), KEY_HTTP_LENIENT, Boolean.valueOf(this.httpLenient), KEY_PROCESS_NON_SEPARATE, Boolean.valueOf(this.processNonSeparate), KEY_DOWNLOAD_MIN_PROGRESS_STEP, Integer.valueOf(this.downloadMinProgressStep), KEY_DOWNLOAD_MIN_PROGRESS_TIME, Long.valueOf(this.downloadMinProgressTime), KEY_DOWNLOAD_MAX_NETWORK_THREAD_COUNT, Integer.valueOf(this.downloadMaxNetworkThreadCount), KEY_FILE_NON_PRE_ALLOCATION, Boolean.valueOf(this.fileNonPreAllocation), KEY_BROADCAST_COMPLETED, Boolean.valueOf(this.broadcastCompleted), KEY_TRIAL_CONNECTION_HEAD_METHOD, Boolean.valueOf(this.trialConnectionHeadMethod));
                                }
                            }
                        } catch (IOException e8) {
                            e = e8;
                            property = null;
                            property3 = null;
                            property4 = null;
                            property5 = null;
                            property6 = null;
                            property7 = null;
                            if (e instanceof FileNotFoundException) {
                                e.printStackTrace();
                            } else if (FileDownloadLog.NEED_LOG) {
                                FileDownloadLog.d(FileDownloadProperties.class, "not found filedownloader.properties", new Object[0]);
                            }
                            if (inputStreamOpen != null) {
                                inputStreamOpen.close();
                            }
                            str = property2;
                            str5 = property3;
                            str6 = property5;
                            str7 = property6;
                            str2 = property7;
                            str3 = property;
                            property8 = null;
                            if (str == null) {
                                if (str.equals("true")) {
                                }
                                this.httpLenient = str.equals("true");
                            } else {
                                this.httpLenient = false;
                            }
                            if (str5 == null) {
                                if (str5.equals("true")) {
                                }
                                this.processNonSeparate = str5.equals("true");
                                i = 0;
                            } else {
                                i = 0;
                                this.processNonSeparate = false;
                            }
                            if (property4 != null) {
                                this.downloadMinProgressStep = Math.max(i, Integer.valueOf(property4).intValue());
                            } else {
                                this.downloadMinProgressStep = 65536;
                            }
                            if (str3 != null) {
                                this.downloadMinProgressTime = Math.max(0L, Long.valueOf(str3).longValue());
                            } else {
                                this.downloadMinProgressTime = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
                            }
                            if (str2 != null) {
                                this.downloadMaxNetworkThreadCount = getValidNetworkThreadCount(Integer.valueOf(str2).intValue());
                            } else {
                                this.downloadMaxNetworkThreadCount = 3;
                            }
                            if (str6 == null) {
                                if (str6.equals("true")) {
                                }
                                this.fileNonPreAllocation = str6.equals("true");
                            } else {
                                this.fileNonPreAllocation = false;
                            }
                            if (str7 == null) {
                                if (str7.equals("true")) {
                                }
                                this.broadcastCompleted = str7.equals("true");
                            } else {
                                this.broadcastCompleted = false;
                            }
                            if (property8 == 0) {
                                if (property8.equals("true")) {
                                }
                                this.trialConnectionHeadMethod = property8.equals("true");
                            } else {
                                this.trialConnectionHeadMethod = false;
                            }
                            if (FileDownloadLog.NEED_LOG) {
                                FileDownloadLog.i(FileDownloadProperties.class, "init properties %d\n load properties: %s=%B; %s=%B; %s=%d; %s=%d; %s=%d; %s=%B; %s=%B; %s=%B", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), KEY_HTTP_LENIENT, Boolean.valueOf(this.httpLenient), KEY_PROCESS_NON_SEPARATE, Boolean.valueOf(this.processNonSeparate), KEY_DOWNLOAD_MIN_PROGRESS_STEP, Integer.valueOf(this.downloadMinProgressStep), KEY_DOWNLOAD_MIN_PROGRESS_TIME, Long.valueOf(this.downloadMinProgressTime), KEY_DOWNLOAD_MAX_NETWORK_THREAD_COUNT, Integer.valueOf(this.downloadMaxNetworkThreadCount), KEY_FILE_NON_PRE_ALLOCATION, Boolean.valueOf(this.fileNonPreAllocation), KEY_BROADCAST_COMPLETED, Boolean.valueOf(this.broadcastCompleted), KEY_TRIAL_CONNECTION_HEAD_METHOD, Boolean.valueOf(this.trialConnectionHeadMethod));
                            }
                        }
                    } catch (IOException e9) {
                        e = e9;
                        property = null;
                        property2 = null;
                        property3 = null;
                        property4 = null;
                        property5 = null;
                        property6 = null;
                        property7 = null;
                        if (e instanceof FileNotFoundException) {
                            e.printStackTrace();
                        } else if (FileDownloadLog.NEED_LOG) {
                            FileDownloadLog.d(FileDownloadProperties.class, "not found filedownloader.properties", new Object[0]);
                        }
                        if (inputStreamOpen != null) {
                            inputStreamOpen.close();
                        }
                        str = property2;
                        str5 = property3;
                        str6 = property5;
                        str7 = property6;
                        str2 = property7;
                        str3 = property;
                        property8 = null;
                        if (str == null) {
                            if (str.equals("true")) {
                            }
                            this.httpLenient = str.equals("true");
                        } else {
                            this.httpLenient = false;
                        }
                        if (str5 == null) {
                            if (str5.equals("true")) {
                            }
                            this.processNonSeparate = str5.equals("true");
                            i = 0;
                        } else {
                            i = 0;
                            this.processNonSeparate = false;
                        }
                        if (property4 != null) {
                            this.downloadMinProgressStep = Math.max(i, Integer.valueOf(property4).intValue());
                        } else {
                            this.downloadMinProgressStep = 65536;
                        }
                        if (str3 != null) {
                            this.downloadMinProgressTime = Math.max(0L, Long.valueOf(str3).longValue());
                        } else {
                            this.downloadMinProgressTime = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
                        }
                        if (str2 != null) {
                            this.downloadMaxNetworkThreadCount = getValidNetworkThreadCount(Integer.valueOf(str2).intValue());
                        } else {
                            this.downloadMaxNetworkThreadCount = 3;
                        }
                        if (str6 == null) {
                            if (str6.equals("true")) {
                            }
                            this.fileNonPreAllocation = str6.equals("true");
                        } else {
                            this.fileNonPreAllocation = false;
                        }
                        if (str7 == null) {
                            if (str7.equals("true")) {
                            }
                            this.broadcastCompleted = str7.equals("true");
                        } else {
                            this.broadcastCompleted = false;
                        }
                        if (property8 == 0) {
                            if (property8.equals("true")) {
                            }
                            this.trialConnectionHeadMethod = property8.equals("true");
                        } else {
                            this.trialConnectionHeadMethod = false;
                        }
                        if (FileDownloadLog.NEED_LOG) {
                            FileDownloadLog.i(FileDownloadProperties.class, "init properties %d\n load properties: %s=%B; %s=%B; %s=%d; %s=%d; %s=%d; %s=%B; %s=%B; %s=%B", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), KEY_HTTP_LENIENT, Boolean.valueOf(this.httpLenient), KEY_PROCESS_NON_SEPARATE, Boolean.valueOf(this.processNonSeparate), KEY_DOWNLOAD_MIN_PROGRESS_STEP, Integer.valueOf(this.downloadMinProgressStep), KEY_DOWNLOAD_MIN_PROGRESS_TIME, Long.valueOf(this.downloadMinProgressTime), KEY_DOWNLOAD_MAX_NETWORK_THREAD_COUNT, Integer.valueOf(this.downloadMaxNetworkThreadCount), KEY_FILE_NON_PRE_ALLOCATION, Boolean.valueOf(this.fileNonPreAllocation), KEY_BROADCAST_COMPLETED, Boolean.valueOf(this.broadcastCompleted), KEY_TRIAL_CONNECTION_HEAD_METHOD, Boolean.valueOf(this.trialConnectionHeadMethod));
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = inputStreamOpen;
                    if (inputStream == null) {
                        throw th;
                    }
                    try {
                        inputStream.close();
                        throw th;
                    } catch (IOException e10) {
                        e10.printStackTrace();
                        throw th;
                    }
                }
            } else {
                str3 = null;
                str = null;
                str2 = null;
                property8 = null;
                property4 = null;
                str8 = null;
                property5 = null;
                property6 = null;
            }
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (IOException e11) {
                    e = e11;
                    String str9 = str8;
                    str4 = property8;
                    property3 = str9;
                    e.printStackTrace();
                    str5 = property3;
                    property8 = str4;
                }
            }
            str5 = str8;
            str6 = property5;
            str7 = property6;
        } catch (IOException e12) {
            e = e12;
            property = null;
            inputStreamOpen = null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
        if (str == null) {
            this.httpLenient = false;
        } else {
            if (str.equals("true") && !str.equals("false")) {
                throw new IllegalStateException(FileDownloadUtils.formatString("the value of '%s' must be '%s' or '%s'", KEY_HTTP_LENIENT, "true", "false"));
            }
            this.httpLenient = str.equals("true");
        }
        if (str5 == null) {
            i = 0;
            this.processNonSeparate = false;
        } else {
            if (str5.equals("true") && !str5.equals("false")) {
                throw new IllegalStateException(FileDownloadUtils.formatString("the value of '%s' must be '%s' or '%s'", KEY_PROCESS_NON_SEPARATE, "true", "false"));
            }
            this.processNonSeparate = str5.equals("true");
            i = 0;
        }
        if (property4 != null) {
            this.downloadMinProgressStep = Math.max(i, Integer.valueOf(property4).intValue());
        } else {
            this.downloadMinProgressStep = 65536;
        }
        if (str3 != null) {
            this.downloadMinProgressTime = Math.max(0L, Long.valueOf(str3).longValue());
        } else {
            this.downloadMinProgressTime = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
        }
        if (str2 != null) {
            this.downloadMaxNetworkThreadCount = getValidNetworkThreadCount(Integer.valueOf(str2).intValue());
        } else {
            this.downloadMaxNetworkThreadCount = 3;
        }
        if (str6 == null) {
            this.fileNonPreAllocation = false;
        } else {
            if (str6.equals("true") && !str6.equals("false")) {
                throw new IllegalStateException(FileDownloadUtils.formatString("the value of '%s' must be '%s' or '%s'", KEY_FILE_NON_PRE_ALLOCATION, "true", "false"));
            }
            this.fileNonPreAllocation = str6.equals("true");
        }
        if (str7 == null) {
            this.broadcastCompleted = false;
        } else {
            if (str7.equals("true") && !str7.equals("false")) {
                throw new IllegalStateException(FileDownloadUtils.formatString("the value of '%s' must be '%s' or '%s'", KEY_BROADCAST_COMPLETED, "true", "false"));
            }
            this.broadcastCompleted = str7.equals("true");
        }
        if (property8 == 0) {
            this.trialConnectionHeadMethod = false;
        } else {
            if (property8.equals("true") && !property8.equals("false")) {
                throw new IllegalStateException(FileDownloadUtils.formatString("the value of '%s' must be '%s' or '%s'", KEY_TRIAL_CONNECTION_HEAD_METHOD, "true", "false"));
            }
            this.trialConnectionHeadMethod = property8.equals("true");
        }
        if (FileDownloadLog.NEED_LOG) {
            FileDownloadLog.i(FileDownloadProperties.class, "init properties %d\n load properties: %s=%B; %s=%B; %s=%d; %s=%d; %s=%d; %s=%B; %s=%B; %s=%B", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), KEY_HTTP_LENIENT, Boolean.valueOf(this.httpLenient), KEY_PROCESS_NON_SEPARATE, Boolean.valueOf(this.processNonSeparate), KEY_DOWNLOAD_MIN_PROGRESS_STEP, Integer.valueOf(this.downloadMinProgressStep), KEY_DOWNLOAD_MIN_PROGRESS_TIME, Long.valueOf(this.downloadMinProgressTime), KEY_DOWNLOAD_MAX_NETWORK_THREAD_COUNT, Integer.valueOf(this.downloadMaxNetworkThreadCount), KEY_FILE_NON_PRE_ALLOCATION, Boolean.valueOf(this.fileNonPreAllocation), KEY_BROADCAST_COMPLETED, Boolean.valueOf(this.broadcastCompleted), KEY_TRIAL_CONNECTION_HEAD_METHOD, Boolean.valueOf(this.trialConnectionHeadMethod));
        }
    }
}
