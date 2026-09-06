package com.kwad.sdk.crash.handler;

import android.content.Context;
import com.huawei.openalliance.ad.constant.x;
import com.kwad.sdk.crash.f;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.report.e;
import com.kwad.sdk.crash.utils.g;
import com.kwad.sdk.service.ServiceProvider;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class c extends b {

    static class a {
        private static final c bev = new c(0);
    }

    @Override // com.kwad.sdk.crash.handler.b
    protected final int getCrashType() {
        return 1;
    }

    /* synthetic */ c(byte b) {
        this();
    }

    private c() {
    }

    public static c Qs() {
        return a.bev;
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final void init(File file, f fVar, e eVar) {
        super.init(file, fVar, eVar);
        if (com.kwad.sdk.crash.e.Qd().isDebug()) {
            initBackupDir(new File("sdcard/kwad_ex/java_crash/dump"));
        }
    }

    public final void a(Throwable th, ExceptionMessage exceptionMessage, Context context) throws Throwable {
        a(th, exceptionMessage, context, ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Fu());
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0224 A[Catch: all -> 0x026e, TRY_LEAVE, TryCatch #10 {all -> 0x026e, blocks: (B:93:0x01f6, B:95:0x0200, B:97:0x0213, B:99:0x021a, B:101:0x0224, B:102:0x0232, B:104:0x023a, B:105:0x023d, B:114:0x0264, B:107:0x0243, B:109:0x0248, B:111:0x0250, B:113:0x025d), top: B:178:0x01f6 }] */
    /* JADX WARN: Code duplicated, block: B:104:0x023a A[Catch: all -> 0x026e, DONT_GENERATE, TRY_ENTER, TryCatch #10 {all -> 0x026e, blocks: (B:93:0x01f6, B:95:0x0200, B:97:0x0213, B:99:0x021a, B:101:0x0224, B:102:0x0232, B:104:0x023a, B:105:0x023d, B:114:0x0264, B:107:0x0243, B:109:0x0248, B:111:0x0250, B:113:0x025d), top: B:178:0x01f6 }] */
    /* JADX WARN: Code duplicated, block: B:106:0x0241 A[DONT_GENERATE, DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:107:0x0243 A[Catch: all -> 0x026e, DONT_GENERATE, TryCatch #10 {all -> 0x026e, blocks: (B:93:0x01f6, B:95:0x0200, B:97:0x0213, B:99:0x021a, B:101:0x0224, B:102:0x0232, B:104:0x023a, B:105:0x023d, B:114:0x0264, B:107:0x0243, B:109:0x0248, B:111:0x0250, B:113:0x025d), top: B:178:0x01f6 }] */
    /* JADX WARN: Code duplicated, block: B:109:0x0248 A[Catch: all -> 0x026e, DONT_GENERATE, TryCatch #10 {all -> 0x026e, blocks: (B:93:0x01f6, B:95:0x0200, B:97:0x0213, B:99:0x021a, B:101:0x0224, B:102:0x0232, B:104:0x023a, B:105:0x023d, B:114:0x0264, B:107:0x0243, B:109:0x0248, B:111:0x0250, B:113:0x025d), top: B:178:0x01f6 }] */
    /* JADX WARN: Code duplicated, block: B:110:0x024f A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:11:0x0062  */
    /* JADX WARN: Code duplicated, block: B:160:0x0094 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:164:0x025d A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:180:0x00ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:184:0x018f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:190:0x00bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x00bd A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:32:0x00e8 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:39:0x011f A[Catch: all -> 0x01a9, TRY_LEAVE, TryCatch #5 {all -> 0x01a9, blocks: (B:37:0x0111, B:39:0x011f), top: B:168:0x0111 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x0132 A[Catch: all -> 0x01a0, TryCatch #0 {all -> 0x01a0, blocks: (B:40:0x0128, B:42:0x0132, B:44:0x0145, B:46:0x014c, B:48:0x0156, B:49:0x0164, B:51:0x016c, B:52:0x016f, B:61:0x0196, B:54:0x0175, B:56:0x017a, B:58:0x0182, B:60:0x018f), top: B:158:0x0128 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x0145 A[Catch: all -> 0x01a0, TryCatch #0 {all -> 0x01a0, blocks: (B:40:0x0128, B:42:0x0132, B:44:0x0145, B:46:0x014c, B:48:0x0156, B:49:0x0164, B:51:0x016c, B:52:0x016f, B:61:0x0196, B:54:0x0175, B:56:0x017a, B:58:0x0182, B:60:0x018f), top: B:158:0x0128 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x014c A[Catch: all -> 0x01a0, TryCatch #0 {all -> 0x01a0, blocks: (B:40:0x0128, B:42:0x0132, B:44:0x0145, B:46:0x014c, B:48:0x0156, B:49:0x0164, B:51:0x016c, B:52:0x016f, B:61:0x0196, B:54:0x0175, B:56:0x017a, B:58:0x0182, B:60:0x018f), top: B:158:0x0128 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x0156 A[Catch: all -> 0x01a0, TRY_LEAVE, TryCatch #0 {all -> 0x01a0, blocks: (B:40:0x0128, B:42:0x0132, B:44:0x0145, B:46:0x014c, B:48:0x0156, B:49:0x0164, B:51:0x016c, B:52:0x016f, B:61:0x0196, B:54:0x0175, B:56:0x017a, B:58:0x0182, B:60:0x018f), top: B:158:0x0128 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x016c A[Catch: all -> 0x01a0, TRY_ENTER, TryCatch #0 {all -> 0x01a0, blocks: (B:40:0x0128, B:42:0x0132, B:44:0x0145, B:46:0x014c, B:48:0x0156, B:49:0x0164, B:51:0x016c, B:52:0x016f, B:61:0x0196, B:54:0x0175, B:56:0x017a, B:58:0x0182, B:60:0x018f), top: B:158:0x0128 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x0173 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:54:0x0175 A[Catch: all -> 0x01a0, TryCatch #0 {all -> 0x01a0, blocks: (B:40:0x0128, B:42:0x0132, B:44:0x0145, B:46:0x014c, B:48:0x0156, B:49:0x0164, B:51:0x016c, B:52:0x016f, B:61:0x0196, B:54:0x0175, B:56:0x017a, B:58:0x0182, B:60:0x018f), top: B:158:0x0128 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x017a A[Catch: all -> 0x01a0, TryCatch #0 {all -> 0x01a0, blocks: (B:40:0x0128, B:42:0x0132, B:44:0x0145, B:46:0x014c, B:48:0x0156, B:49:0x0164, B:51:0x016c, B:52:0x016f, B:61:0x0196, B:54:0x0175, B:56:0x017a, B:58:0x0182, B:60:0x018f), top: B:158:0x0128 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0181  */
    /* JADX WARN: Code duplicated, block: B:95:0x0200 A[Catch: all -> 0x026e, DONT_GENERATE, TryCatch #10 {all -> 0x026e, blocks: (B:93:0x01f6, B:95:0x0200, B:97:0x0213, B:99:0x021a, B:101:0x0224, B:102:0x0232, B:104:0x023a, B:105:0x023d, B:114:0x0264, B:107:0x0243, B:109:0x0248, B:111:0x0250, B:113:0x025d), top: B:178:0x01f6 }] */
    /* JADX WARN: Code duplicated, block: B:97:0x0213 A[Catch: all -> 0x026e, DONT_GENERATE, TryCatch #10 {all -> 0x026e, blocks: (B:93:0x01f6, B:95:0x0200, B:97:0x0213, B:99:0x021a, B:101:0x0224, B:102:0x0232, B:104:0x023a, B:105:0x023d, B:114:0x0264, B:107:0x0243, B:109:0x0248, B:111:0x0250, B:113:0x025d), top: B:178:0x01f6 }] */
    /* JADX WARN: Code duplicated, block: B:99:0x021a A[Catch: all -> 0x026e, DONT_GENERATE, TryCatch #10 {all -> 0x026e, blocks: (B:93:0x01f6, B:95:0x0200, B:97:0x0213, B:99:0x021a, B:101:0x0224, B:102:0x0232, B:104:0x023a, B:105:0x023d, B:114:0x0264, B:107:0x0243, B:109:0x0248, B:111:0x0250, B:113:0x025d), top: B:178:0x01f6 }] */
    private void a(Throwable th, ExceptionMessage exceptionMessage, Context context, boolean z) throws Throwable {
        boolean z2;
        String string;
        CountDownLatch countDownLatch;
        int andIncrement = this.mIndex.getAndIncrement();
        File file = this.mDumpDir;
        File file2 = this.mLogcatFile;
        File file3 = this.mJavaTraceFile;
        File file4 = this.mMemoryInfoFile;
        e uploader = getUploader();
        try {
            exceptionMessage.mCrashDetail = th.toString();
            if (this.mLogDir.exists()) {
                z2 = true;
            } else {
                try {
                    if (this.mLogDir.mkdirs()) {
                        z2 = true;
                    } else {
                        exceptionMessage.mErrorMessage += "create " + Qs().mLogDir.getPath() + " failed!\n";
                        z2 = false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    z2 = true;
                }
            }
            if (file != null && andIncrement == 0) {
                if (file2 == null) {
                    file2 = new File(this.mLogDir, FILE_NAME_BASE + x.A + andIncrement + ".log");
                    if (file3 == null) {
                        file3 = new File(this.mLogDir, FILE_NAME_BASE + x.A + andIncrement + ".jtrace");
                        if (file4 != null) {
                            file4 = new File(this.mLogDir, FILE_NAME_BASE + x.A + andIncrement + ".minfo");
                            g.b(th, exceptionMessage, context);
                            g.a(exceptionMessage, getCrashType());
                            if (this.mExceptionListener != null) {
                                this.mExceptionListener.a(getCrashType(), exceptionMessage);
                            }
                            string = exceptionMessage.toJson().toString();
                            if (z2) {
                                g.a(file, string);
                                g.H(file3);
                                g.F(file2);
                                if (com.kwad.sdk.crash.e.Qd().isDebug()) {
                                    backupLogFiles(this.mLogDir);
                                }
                                if (uploader != null) {
                                    new StringBuilder("------  Java Crash Happened Begin ------\n").append(exceptionMessage);
                                    if (z) {
                                        CountDownLatch countDownLatch2 = new CountDownLatch(1);
                                        reportException(new File[]{file}, countDownLatch2);
                                        countDownLatch2.await(5L, TimeUnit.SECONDS);
                                    } else {
                                        uploadRemainingExceptions();
                                    }
                                }
                                g.I(file4);
                            } else if (uploader != null) {
                                com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "uploader.uploadEvent(message);");
                                if (z) {
                                    countDownLatch = new CountDownLatch(1);
                                } else {
                                    countDownLatch = null;
                                }
                                uploader.a(exceptionMessage, countDownLatch);
                                new StringBuilder("------  Java Crash Happened Begin ------\n").append(exceptionMessage);
                                if (countDownLatch != null) {
                                    countDownLatch.await(5L, TimeUnit.SECONDS);
                                }
                            }
                            com.kwad.sdk.m.b.TD().hx(exceptionMessage.mCrashDetail);
                            return;
                        }
                        file4 = new File(this.mLogDir, FILE_NAME_BASE + x.A + andIncrement + ".minfo");
                        g.b(th, exceptionMessage, context);
                        g.a(exceptionMessage, getCrashType());
                        if (this.mExceptionListener != null) {
                            this.mExceptionListener.a(getCrashType(), exceptionMessage);
                        }
                        string = exceptionMessage.toJson().toString();
                        if (z2) {
                            g.a(file, string);
                            g.H(file3);
                            g.F(file2);
                            if (com.kwad.sdk.crash.e.Qd().isDebug()) {
                                backupLogFiles(this.mLogDir);
                            }
                            if (uploader != null) {
                                new StringBuilder("------  Java Crash Happened Begin ------\n").append(exceptionMessage);
                                if (z) {
                                    CountDownLatch countDownLatch3 = new CountDownLatch(1);
                                    reportException(new File[]{file}, countDownLatch3);
                                    countDownLatch3.await(5L, TimeUnit.SECONDS);
                                } else {
                                    uploadRemainingExceptions();
                                }
                            }
                            g.I(file4);
                        } else if (uploader != null) {
                            com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "uploader.uploadEvent(message);");
                            if (z) {
                                countDownLatch = new CountDownLatch(1);
                            } else {
                                countDownLatch = null;
                            }
                            uploader.a(exceptionMessage, countDownLatch);
                            new StringBuilder("------  Java Crash Happened Begin ------\n").append(exceptionMessage);
                            if (countDownLatch != null) {
                                countDownLatch.await(5L, TimeUnit.SECONDS);
                            }
                        }
                        com.kwad.sdk.m.b.TD().hx(exceptionMessage.mCrashDetail);
                        return;
                    }
                    file3 = new File(this.mLogDir, FILE_NAME_BASE + x.A + andIncrement + ".jtrace");
                    if (file4 != null) {
                        file4 = new File(this.mLogDir, FILE_NAME_BASE + x.A + andIncrement + ".minfo");
                        g.b(th, exceptionMessage, context);
                        g.a(exceptionMessage, getCrashType());
                        if (this.mExceptionListener != null) {
                            this.mExceptionListener.a(getCrashType(), exceptionMessage);
                        }
                        string = exceptionMessage.toJson().toString();
                        if (z2) {
                            g.a(file, string);
                            g.H(file3);
                            g.F(file2);
                            if (com.kwad.sdk.crash.e.Qd().isDebug()) {
                                backupLogFiles(this.mLogDir);
                            }
                            if (uploader != null) {
                                new StringBuilder("------  Java Crash Happened Begin ------\n").append(exceptionMessage);
                                if (z) {
                                    CountDownLatch countDownLatch4 = new CountDownLatch(1);
                                    reportException(new File[]{file}, countDownLatch4);
                                    countDownLatch4.await(5L, TimeUnit.SECONDS);
                                } else {
                                    uploadRemainingExceptions();
                                }
                            }
                            g.I(file4);
                        } else if (uploader != null) {
                            com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "uploader.uploadEvent(message);");
                            if (z) {
                                countDownLatch = new CountDownLatch(1);
                            } else {
                                countDownLatch = null;
                            }
                            uploader.a(exceptionMessage, countDownLatch);
                            new StringBuilder("------  Java Crash Happened Begin ------\n").append(exceptionMessage);
                            if (countDownLatch != null) {
                                countDownLatch.await(5L, TimeUnit.SECONDS);
                            }
                        }
                        com.kwad.sdk.m.b.TD().hx(exceptionMessage.mCrashDetail);
                        return;
                    }
                    file4 = new File(this.mLogDir, FILE_NAME_BASE + x.A + andIncrement + ".minfo");
                    g.b(th, exceptionMessage, context);
                    g.a(exceptionMessage, getCrashType());
                    if (this.mExceptionListener != null) {
                        this.mExceptionListener.a(getCrashType(), exceptionMessage);
                    }
                    string = exceptionMessage.toJson().toString();
                    if (z2) {
                        g.a(file, string);
                        g.H(file3);
                        g.F(file2);
                        if (com.kwad.sdk.crash.e.Qd().isDebug()) {
                            backupLogFiles(this.mLogDir);
                        }
                        if (uploader != null) {
                            new StringBuilder("------  Java Crash Happened Begin ------\n").append(exceptionMessage);
                            if (z) {
                                CountDownLatch countDownLatch5 = new CountDownLatch(1);
                                reportException(new File[]{file}, countDownLatch5);
                                countDownLatch5.await(5L, TimeUnit.SECONDS);
                            } else {
                                uploadRemainingExceptions();
                            }
                        }
                        g.I(file4);
                    } else if (uploader != null) {
                        com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "uploader.uploadEvent(message);");
                        if (z) {
                            countDownLatch = new CountDownLatch(1);
                        } else {
                            countDownLatch = null;
                        }
                        uploader.a(exceptionMessage, countDownLatch);
                        new StringBuilder("------  Java Crash Happened Begin ------\n").append(exceptionMessage);
                        if (countDownLatch != null) {
                            countDownLatch.await(5L, TimeUnit.SECONDS);
                        }
                    }
                    com.kwad.sdk.m.b.TD().hx(exceptionMessage.mCrashDetail);
                    return;
                }
                file2 = new File(this.mLogDir, FILE_NAME_BASE + x.A + andIncrement + ".log");
                if (file3 == null) {
                    file3 = new File(this.mLogDir, FILE_NAME_BASE + x.A + andIncrement + ".jtrace");
                    if (file4 != null) {
                        file4 = new File(this.mLogDir, FILE_NAME_BASE + x.A + andIncrement + ".minfo");
                        g.b(th, exceptionMessage, context);
                        g.a(exceptionMessage, getCrashType());
                        if (this.mExceptionListener != null) {
                            this.mExceptionListener.a(getCrashType(), exceptionMessage);
                        }
                        string = exceptionMessage.toJson().toString();
                        if (z2) {
                            g.a(file, string);
                            g.H(file3);
                            g.F(file2);
                            if (com.kwad.sdk.crash.e.Qd().isDebug()) {
                                backupLogFiles(this.mLogDir);
                            }
                            if (uploader != null) {
                                new StringBuilder("------  Java Crash Happened Begin ------\n").append(exceptionMessage);
                                if (z) {
                                    CountDownLatch countDownLatch6 = new CountDownLatch(1);
                                    reportException(new File[]{file}, countDownLatch6);
                                    countDownLatch6.await(5L, TimeUnit.SECONDS);
                                } else {
                                    uploadRemainingExceptions();
                                }
                            }
                            g.I(file4);
                        } else if (uploader != null) {
                            com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "uploader.uploadEvent(message);");
                            if (z) {
                                countDownLatch = new CountDownLatch(1);
                            } else {
                                countDownLatch = null;
                            }
                            uploader.a(exceptionMessage, countDownLatch);
                            new StringBuilder("------  Java Crash Happened Begin ------\n").append(exceptionMessage);
                            if (countDownLatch != null) {
                                countDownLatch.await(5L, TimeUnit.SECONDS);
                            }
                        }
                        com.kwad.sdk.m.b.TD().hx(exceptionMessage.mCrashDetail);
                        return;
                    }
                    file4 = new File(this.mLogDir, FILE_NAME_BASE + x.A + andIncrement + ".minfo");
                    g.b(th, exceptionMessage, context);
                    g.a(exceptionMessage, getCrashType());
                    if (this.mExceptionListener != null) {
                        this.mExceptionListener.a(getCrashType(), exceptionMessage);
                    }
                    string = exceptionMessage.toJson().toString();
                    if (z2) {
                        g.a(file, string);
                        g.H(file3);
                        g.F(file2);
                        if (com.kwad.sdk.crash.e.Qd().isDebug()) {
                            backupLogFiles(this.mLogDir);
                        }
                        if (uploader != null) {
                            new StringBuilder("------  Java Crash Happened Begin ------\n").append(exceptionMessage);
                            if (z) {
                                CountDownLatch countDownLatch7 = new CountDownLatch(1);
                                reportException(new File[]{file}, countDownLatch7);
                                countDownLatch7.await(5L, TimeUnit.SECONDS);
                            } else {
                                uploadRemainingExceptions();
                            }
                        }
                        g.I(file4);
                    } else if (uploader != null) {
                        com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "uploader.uploadEvent(message);");
                        if (z) {
                            countDownLatch = new CountDownLatch(1);
                        } else {
                            countDownLatch = null;
                        }
                        uploader.a(exceptionMessage, countDownLatch);
                        new StringBuilder("------  Java Crash Happened Begin ------\n").append(exceptionMessage);
                        if (countDownLatch != null) {
                            countDownLatch.await(5L, TimeUnit.SECONDS);
                        }
                    }
                    com.kwad.sdk.m.b.TD().hx(exceptionMessage.mCrashDetail);
                    return;
                }
                file3 = new File(this.mLogDir, FILE_NAME_BASE + x.A + andIncrement + ".jtrace");
                if (file4 != null) {
                    file4 = new File(this.mLogDir, FILE_NAME_BASE + x.A + andIncrement + ".minfo");
                    g.b(th, exceptionMessage, context);
                    g.a(exceptionMessage, getCrashType());
                    if (this.mExceptionListener != null) {
                        this.mExceptionListener.a(getCrashType(), exceptionMessage);
                    }
                    string = exceptionMessage.toJson().toString();
                    if (z2) {
                        g.a(file, string);
                        g.H(file3);
                        g.F(file2);
                        if (com.kwad.sdk.crash.e.Qd().isDebug()) {
                            backupLogFiles(this.mLogDir);
                        }
                        if (uploader != null) {
                            new StringBuilder("------  Java Crash Happened Begin ------\n").append(exceptionMessage);
                            if (z) {
                                CountDownLatch countDownLatch8 = new CountDownLatch(1);
                                reportException(new File[]{file}, countDownLatch8);
                                countDownLatch8.await(5L, TimeUnit.SECONDS);
                            } else {
                                uploadRemainingExceptions();
                            }
                        }
                        g.I(file4);
                    } else if (uploader != null) {
                        com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "uploader.uploadEvent(message);");
                        if (z) {
                            countDownLatch = new CountDownLatch(1);
                        } else {
                            countDownLatch = null;
                        }
                        uploader.a(exceptionMessage, countDownLatch);
                        new StringBuilder("------  Java Crash Happened Begin ------\n").append(exceptionMessage);
                        if (countDownLatch != null) {
                            countDownLatch.await(5L, TimeUnit.SECONDS);
                        }
                    }
                    com.kwad.sdk.m.b.TD().hx(exceptionMessage.mCrashDetail);
                    return;
                }
                file4 = new File(this.mLogDir, FILE_NAME_BASE + x.A + andIncrement + ".minfo");
                g.b(th, exceptionMessage, context);
                g.a(exceptionMessage, getCrashType());
                if (this.mExceptionListener != null) {
                    this.mExceptionListener.a(getCrashType(), exceptionMessage);
                }
                string = exceptionMessage.toJson().toString();
                if (z2) {
                    g.a(file, string);
                    g.H(file3);
                    g.F(file2);
                    if (com.kwad.sdk.crash.e.Qd().isDebug()) {
                        backupLogFiles(this.mLogDir);
                    }
                    if (uploader != null) {
                        new StringBuilder("------  Java Crash Happened Begin ------\n").append(exceptionMessage);
                        if (z) {
                            CountDownLatch countDownLatch9 = new CountDownLatch(1);
                            reportException(new File[]{file}, countDownLatch9);
                            countDownLatch9.await(5L, TimeUnit.SECONDS);
                        } else {
                            uploadRemainingExceptions();
                        }
                    }
                    g.I(file4);
                } else if (uploader != null) {
                    com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "uploader.uploadEvent(message);");
                    if (z) {
                        countDownLatch = new CountDownLatch(1);
                    } else {
                        countDownLatch = null;
                    }
                    uploader.a(exceptionMessage, countDownLatch);
                    new StringBuilder("------  Java Crash Happened Begin ------\n").append(exceptionMessage);
                    if (countDownLatch != null) {
                        countDownLatch.await(5L, TimeUnit.SECONDS);
                    }
                }
                com.kwad.sdk.m.b.TD().hx(exceptionMessage.mCrashDetail);
                return;
            }
            try {
                try {
                    file = new File(this.mLogDir, FILE_NAME_BASE + x.A + andIncrement + ".dump");
                    if (file2 == null && andIncrement == 0) {
                        if (file3 == null) {
                            file3 = new File(this.mLogDir, FILE_NAME_BASE + x.A + andIncrement + ".jtrace");
                            if (file4 != null) {
                                file4 = new File(this.mLogDir, FILE_NAME_BASE + x.A + andIncrement + ".minfo");
                                g.b(th, exceptionMessage, context);
                                g.a(exceptionMessage, getCrashType());
                                if (this.mExceptionListener != null) {
                                    this.mExceptionListener.a(getCrashType(), exceptionMessage);
                                }
                                string = exceptionMessage.toJson().toString();
                                if (z2) {
                                    g.a(file, string);
                                    g.H(file3);
                                    g.F(file2);
                                    if (com.kwad.sdk.crash.e.Qd().isDebug()) {
                                        backupLogFiles(this.mLogDir);
                                    }
                                    if (uploader != null) {
                                        new StringBuilder("------  Java Crash Happened Begin ------\n").append(exceptionMessage);
                                        if (z) {
                                            CountDownLatch countDownLatch10 = new CountDownLatch(1);
                                            reportException(new File[]{file}, countDownLatch10);
                                            countDownLatch10.await(5L, TimeUnit.SECONDS);
                                        } else {
                                            uploadRemainingExceptions();
                                        }
                                    }
                                    g.I(file4);
                                } else if (uploader != null) {
                                    com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "uploader.uploadEvent(message);");
                                    if (z) {
                                        countDownLatch = new CountDownLatch(1);
                                    } else {
                                        countDownLatch = null;
                                    }
                                    uploader.a(exceptionMessage, countDownLatch);
                                    new StringBuilder("------  Java Crash Happened Begin ------\n").append(exceptionMessage);
                                    if (countDownLatch != null) {
                                        countDownLatch.await(5L, TimeUnit.SECONDS);
                                    }
                                }
                                com.kwad.sdk.m.b.TD().hx(exceptionMessage.mCrashDetail);
                                return;
                            }
                            file4 = new File(this.mLogDir, FILE_NAME_BASE + x.A + andIncrement + ".minfo");
                            g.b(th, exceptionMessage, context);
                            g.a(exceptionMessage, getCrashType());
                            if (this.mExceptionListener != null) {
                                this.mExceptionListener.a(getCrashType(), exceptionMessage);
                            }
                            string = exceptionMessage.toJson().toString();
                            if (z2) {
                                g.a(file, string);
                                g.H(file3);
                                g.F(file2);
                                if (com.kwad.sdk.crash.e.Qd().isDebug()) {
                                    backupLogFiles(this.mLogDir);
                                }
                                if (uploader != null) {
                                    new StringBuilder("------  Java Crash Happened Begin ------\n").append(exceptionMessage);
                                    if (z) {
                                        CountDownLatch countDownLatch11 = new CountDownLatch(1);
                                        reportException(new File[]{file}, countDownLatch11);
                                        countDownLatch11.await(5L, TimeUnit.SECONDS);
                                    } else {
                                        uploadRemainingExceptions();
                                    }
                                }
                                g.I(file4);
                            } else if (uploader != null) {
                                com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "uploader.uploadEvent(message);");
                                if (z) {
                                    countDownLatch = new CountDownLatch(1);
                                } else {
                                    countDownLatch = null;
                                }
                                uploader.a(exceptionMessage, countDownLatch);
                                new StringBuilder("------  Java Crash Happened Begin ------\n").append(exceptionMessage);
                                if (countDownLatch != null) {
                                    countDownLatch.await(5L, TimeUnit.SECONDS);
                                }
                            }
                            com.kwad.sdk.m.b.TD().hx(exceptionMessage.mCrashDetail);
                            return;
                        }
                        file3 = new File(this.mLogDir, FILE_NAME_BASE + x.A + andIncrement + ".jtrace");
                        if (file4 != null) {
                            file4 = new File(this.mLogDir, FILE_NAME_BASE + x.A + andIncrement + ".minfo");
                            g.b(th, exceptionMessage, context);
                            g.a(exceptionMessage, getCrashType());
                            if (this.mExceptionListener != null) {
                                this.mExceptionListener.a(getCrashType(), exceptionMessage);
                            }
                            string = exceptionMessage.toJson().toString();
                            if (z2) {
                                g.a(file, string);
                                g.H(file3);
                                g.F(file2);
                                if (com.kwad.sdk.crash.e.Qd().isDebug()) {
                                    backupLogFiles(this.mLogDir);
                                }
                                if (uploader != null) {
                                    new StringBuilder("------  Java Crash Happened Begin ------\n").append(exceptionMessage);
                                    if (z) {
                                        CountDownLatch countDownLatch12 = new CountDownLatch(1);
                                        reportException(new File[]{file}, countDownLatch12);
                                        countDownLatch12.await(5L, TimeUnit.SECONDS);
                                    } else {
                                        uploadRemainingExceptions();
                                    }
                                }
                                g.I(file4);
                            } else if (uploader != null) {
                                com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "uploader.uploadEvent(message);");
                                if (z) {
                                    countDownLatch = new CountDownLatch(1);
                                } else {
                                    countDownLatch = null;
                                }
                                uploader.a(exceptionMessage, countDownLatch);
                                new StringBuilder("------  Java Crash Happened Begin ------\n").append(exceptionMessage);
                                if (countDownLatch != null) {
                                    countDownLatch.await(5L, TimeUnit.SECONDS);
                                }
                            }
                            com.kwad.sdk.m.b.TD().hx(exceptionMessage.mCrashDetail);
                            return;
                        }
                        file4 = new File(this.mLogDir, FILE_NAME_BASE + x.A + andIncrement + ".minfo");
                        g.b(th, exceptionMessage, context);
                        g.a(exceptionMessage, getCrashType());
                        if (this.mExceptionListener != null) {
                            this.mExceptionListener.a(getCrashType(), exceptionMessage);
                        }
                        string = exceptionMessage.toJson().toString();
                        if (z2) {
                            g.a(file, string);
                            g.H(file3);
                            g.F(file2);
                            if (com.kwad.sdk.crash.e.Qd().isDebug()) {
                                backupLogFiles(this.mLogDir);
                            }
                            if (uploader != null) {
                                new StringBuilder("------  Java Crash Happened Begin ------\n").append(exceptionMessage);
                                if (z) {
                                    CountDownLatch countDownLatch13 = new CountDownLatch(1);
                                    reportException(new File[]{file}, countDownLatch13);
                                    countDownLatch13.await(5L, TimeUnit.SECONDS);
                                } else {
                                    uploadRemainingExceptions();
                                }
                            }
                            g.I(file4);
                        } else if (uploader != null) {
                            com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "uploader.uploadEvent(message);");
                            if (z) {
                                countDownLatch = new CountDownLatch(1);
                            } else {
                                countDownLatch = null;
                            }
                            uploader.a(exceptionMessage, countDownLatch);
                            new StringBuilder("------  Java Crash Happened Begin ------\n").append(exceptionMessage);
                            if (countDownLatch != null) {
                                countDownLatch.await(5L, TimeUnit.SECONDS);
                            }
                        }
                        com.kwad.sdk.m.b.TD().hx(exceptionMessage.mCrashDetail);
                        return;
                    }
                    try {
                        try {
                            file2 = new File(this.mLogDir, FILE_NAME_BASE + x.A + andIncrement + ".log");
                            if (file3 == null && andIncrement == 0) {
                                if (file4 != null) {
                                    file4 = new File(this.mLogDir, FILE_NAME_BASE + x.A + andIncrement + ".minfo");
                                    g.b(th, exceptionMessage, context);
                                    g.a(exceptionMessage, getCrashType());
                                    if (this.mExceptionListener != null) {
                                        this.mExceptionListener.a(getCrashType(), exceptionMessage);
                                    }
                                    string = exceptionMessage.toJson().toString();
                                    if (z2) {
                                        g.a(file, string);
                                        g.H(file3);
                                        g.F(file2);
                                        if (com.kwad.sdk.crash.e.Qd().isDebug()) {
                                            backupLogFiles(this.mLogDir);
                                        }
                                        if (uploader != null) {
                                            new StringBuilder("------  Java Crash Happened Begin ------\n").append(exceptionMessage);
                                            if (z) {
                                                CountDownLatch countDownLatch14 = new CountDownLatch(1);
                                                reportException(new File[]{file}, countDownLatch14);
                                                countDownLatch14.await(5L, TimeUnit.SECONDS);
                                            } else {
                                                uploadRemainingExceptions();
                                            }
                                        }
                                        g.I(file4);
                                    } else if (uploader != null) {
                                        com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "uploader.uploadEvent(message);");
                                        if (z) {
                                            countDownLatch = new CountDownLatch(1);
                                        } else {
                                            countDownLatch = null;
                                        }
                                        uploader.a(exceptionMessage, countDownLatch);
                                        new StringBuilder("------  Java Crash Happened Begin ------\n").append(exceptionMessage);
                                        if (countDownLatch != null) {
                                            countDownLatch.await(5L, TimeUnit.SECONDS);
                                        }
                                    }
                                    com.kwad.sdk.m.b.TD().hx(exceptionMessage.mCrashDetail);
                                    return;
                                }
                                file4 = new File(this.mLogDir, FILE_NAME_BASE + x.A + andIncrement + ".minfo");
                                g.b(th, exceptionMessage, context);
                                g.a(exceptionMessage, getCrashType());
                                if (this.mExceptionListener != null) {
                                    this.mExceptionListener.a(getCrashType(), exceptionMessage);
                                }
                                string = exceptionMessage.toJson().toString();
                                if (z2) {
                                    g.a(file, string);
                                    g.H(file3);
                                    g.F(file2);
                                    if (com.kwad.sdk.crash.e.Qd().isDebug()) {
                                        backupLogFiles(this.mLogDir);
                                    }
                                    if (uploader != null) {
                                        new StringBuilder("------  Java Crash Happened Begin ------\n").append(exceptionMessage);
                                        if (z) {
                                            CountDownLatch countDownLatch15 = new CountDownLatch(1);
                                            reportException(new File[]{file}, countDownLatch15);
                                            countDownLatch15.await(5L, TimeUnit.SECONDS);
                                        } else {
                                            uploadRemainingExceptions();
                                        }
                                    }
                                    g.I(file4);
                                } else if (uploader != null) {
                                    com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "uploader.uploadEvent(message);");
                                    if (z) {
                                        countDownLatch = new CountDownLatch(1);
                                    } else {
                                        countDownLatch = null;
                                    }
                                    uploader.a(exceptionMessage, countDownLatch);
                                    new StringBuilder("------  Java Crash Happened Begin ------\n").append(exceptionMessage);
                                    if (countDownLatch != null) {
                                        countDownLatch.await(5L, TimeUnit.SECONDS);
                                    }
                                }
                                com.kwad.sdk.m.b.TD().hx(exceptionMessage.mCrashDetail);
                                return;
                            }
                            try {
                                try {
                                    file3 = new File(this.mLogDir, FILE_NAME_BASE + x.A + andIncrement + ".jtrace");
                                    if (file4 != null || andIncrement != 0) {
                                        try {
                                            try {
                                                file4 = new File(this.mLogDir, FILE_NAME_BASE + x.A + andIncrement + ".minfo");
                                            } catch (Throwable th3) {
                                                th = th3;
                                                file4 = file4;
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                        }
                                    }
                                    try {
                                        g.b(th, exceptionMessage, context);
                                        g.a(exceptionMessage, getCrashType());
                                        if (this.mExceptionListener != null) {
                                            this.mExceptionListener.a(getCrashType(), exceptionMessage);
                                        }
                                        try {
                                            string = exceptionMessage.toJson().toString();
                                            if (z2) {
                                                g.a(file, string);
                                                g.H(file3);
                                                g.F(file2);
                                                if (com.kwad.sdk.crash.e.Qd().isDebug()) {
                                                    backupLogFiles(this.mLogDir);
                                                }
                                                if (uploader != null) {
                                                    new StringBuilder("------  Java Crash Happened Begin ------\n").append(exceptionMessage);
                                                    if (z) {
                                                        CountDownLatch countDownLatch16 = new CountDownLatch(1);
                                                        reportException(new File[]{file}, countDownLatch16);
                                                        try {
                                                            countDownLatch16.await(5L, TimeUnit.SECONDS);
                                                        } catch (InterruptedException unused) {
                                                        }
                                                    } else {
                                                        uploadRemainingExceptions();
                                                    }
                                                }
                                                g.I(file4);
                                            } else if (uploader != null) {
                                                com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "uploader.uploadEvent(message);");
                                                if (z) {
                                                    countDownLatch = new CountDownLatch(1);
                                                } else {
                                                    countDownLatch = null;
                                                }
                                                uploader.a(exceptionMessage, countDownLatch);
                                                new StringBuilder("------  Java Crash Happened Begin ------\n").append(exceptionMessage);
                                                if (countDownLatch != null) {
                                                    try {
                                                        countDownLatch.await(5L, TimeUnit.SECONDS);
                                                    } catch (InterruptedException unused2) {
                                                    }
                                                }
                                            }
                                            com.kwad.sdk.m.b.TD().hx(exceptionMessage.mCrashDetail);
                                            return;
                                        } catch (Throwable th5) {
                                            if (uploader != null) {
                                                try {
                                                    g.x(th5);
                                                    return;
                                                } catch (Exception unused3) {
                                                    return;
                                                }
                                            }
                                            return;
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                    }
                                } catch (Throwable th7) {
                                    th = th7;
                                    file3 = file3;
                                }
                            } catch (Throwable th8) {
                                th = th8;
                                exceptionMessage.mErrorMessage += th;
                                try {
                                    if (z2) {
                                        if (uploader != null) {
                                            if (z) {
                                                reportException(new File[]{file}, new CountDownLatch(1));
                                            }
                                        }
                                    }
                                } catch (Throwable th9) {
                                    if (uploader != null) {
                                        try {
                                            return;
                                        } catch (Exception unused4) {
                                            return;
                                        }
                                    }
                                    return;
                                }
                            }
                        } catch (Throwable th10) {
                            th = th10;
                            file2 = file2;
                        }
                    } catch (Throwable th11) {
                        th = th11;
                        exceptionMessage.mErrorMessage += th;
                        if (z2) {
                            if (uploader != null) {
                                if (z) {
                                    reportException(new File[]{file}, new CountDownLatch(1));
                                }
                            }
                        }
                    }
                } catch (Throwable th12) {
                    th = th12;
                    file = file;
                }
            } catch (Throwable th13) {
                th = th13;
                exceptionMessage.mErrorMessage += th;
                if (z2) {
                    if (uploader != null) {
                        if (z) {
                            reportException(new File[]{file}, new CountDownLatch(1));
                        }
                    }
                }
            }
        } catch (Throwable th14) {
            th = th14;
        }
        try {
            exceptionMessage.mErrorMessage += th;
            if (z2) {
                if (uploader != null) {
                    if (z) {
                        reportException(new File[]{file}, new CountDownLatch(1));
                    }
                }
            }
        } finally {
            try {
                String string2 = exceptionMessage.toJson().toString();
                if (z2) {
                    g.a(file, string2);
                    g.H(file3);
                    g.F(file2);
                    if (com.kwad.sdk.crash.e.Qd().isDebug()) {
                        backupLogFiles(this.mLogDir);
                    }
                    if (uploader != null) {
                        new StringBuilder("------  Java Crash Happened Begin ------\n").append(exceptionMessage);
                        if (z) {
                            CountDownLatch countDownLatch17 = new CountDownLatch(1);
                            reportException(new File[]{file}, countDownLatch17);
                            try {
                                countDownLatch17.await(5L, TimeUnit.SECONDS);
                            } catch (InterruptedException unused5) {
                            }
                        } else {
                            uploadRemainingExceptions();
                        }
                    }
                    g.I(file4);
                } else if (uploader != null) {
                    com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "uploader.uploadEvent(message);");
                    CountDownLatch countDownLatch18 = z ? new CountDownLatch(1) : null;
                    uploader.a(exceptionMessage, countDownLatch18);
                    new StringBuilder("------  Java Crash Happened Begin ------\n").append(exceptionMessage);
                    if (countDownLatch18 != null) {
                        try {
                            countDownLatch18.await(5L, TimeUnit.SECONDS);
                        } catch (InterruptedException unused6) {
                        }
                    }
                }
                com.kwad.sdk.m.b.TD().hx(exceptionMessage.mCrashDetail);
            } catch (Throwable th15) {
                if (uploader != null) {
                    try {
                        g.x(th15);
                    } catch (Exception unused7) {
                    }
                }
            }
        }
    }

    @Override // com.kwad.sdk.crash.handler.b
    protected final void reportException(File[] fileArr, CountDownLatch countDownLatch) {
        com.kwad.sdk.crash.report.f fVar = new com.kwad.sdk.crash.report.f();
        fVar.a(getUploader());
        for (File file : fileArr) {
            fVar.a(file, countDownLatch);
        }
    }
}
