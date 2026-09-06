package com.kwad.sdk.crash.handler;

import android.os.Build;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.Process;
import android.util.Log;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.NativeExceptionMessage;
import com.kwad.sdk.crash.report.e;
import com.kwad.sdk.crash.utils.g;
import java.io.File;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class NativeCrashHandler extends b {
    private static final String NATIVE_CRASH_HAPPENED_BEGIN = "------ Native Crash Happened Begin ------\n";
    private static final String TAG = "NativeCrashHandler";
    private static ExceptionMessage mMessage = new NativeExceptionMessage();
    private File mMessageFile;

    static class a {
        private static final NativeCrashHandler bey = new NativeCrashHandler();
    }

    public static native void doCrash();

    public static native void doFakeCrash();

    public static native void doMemoryCorruption();

    public static native void doNativeFdOverLimitCrash();

    public static native void install(String str, String str2, int i);

    @Override // com.kwad.sdk.crash.handler.b
    protected final int getCrashType() {
        return 4;
    }

    public static NativeCrashHandler getInstance() {
        return a.bey;
    }

    private NativeCrashHandler() {
    }

    public final void init(File file, boolean z, final String str, com.kwad.sdk.crash.report.c cVar) {
        super.init(file, null, cVar);
        if (com.kwad.sdk.crash.b.PO()) {
            this.mLogDir = file;
            if (!this.mLogDir.exists()) {
                this.mLogDir.mkdirs();
            }
            this.mDumpDir = new File(file, FILE_NAME_BASE + "-native-0");
            this.mLogcatFile = new File(this.mDumpDir, "logcat");
            this.mMessageFile = new File(this.mDumpDir, CrashHianalyticsData.MESSAGE);
            this.mJavaTraceFile = new File(this.mDumpDir, "all_java_backtrace");
            this.mMemoryInfoFile = new File(this.mDumpDir, "meminfo");
            try {
                Looper.getMainLooper().getQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.kwad.sdk.crash.handler.NativeCrashHandler.1
                    @Override // android.os.MessageQueue.IdleHandler
                    public final boolean queueIdle() {
                        com.kwad.sdk.core.d.c.d(NativeCrashHandler.TAG, "native install in idle" + NativeCrashHandler.this.mDumpDir.getPath());
                        NativeCrashHandler.install(NativeCrashHandler.this.mDumpDir.getPath(), str, Build.VERSION.SDK_INT);
                        return false;
                    }
                });
            } catch (Throwable unused) {
                getUploader();
            }
        }
    }

    /* JADX INFO: renamed from: com.kwad.sdk.crash.handler.NativeCrashHandler$2, reason: invalid class name */
    final class AnonymousClass2 implements Runnable {
        final /* synthetic */ String bew;

        AnonymousClass2(String str) {
            this.bew = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.d.c.e(NativeCrashHandler.TAG, "native install in main:" + NativeCrashHandler.this.mDumpDir.getPath());
            NativeCrashHandler.install(NativeCrashHandler.this.mDumpDir.getPath(), this.bew, Build.VERSION.SDK_INT);
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x018a A[Catch: all -> 0x019f, TRY_LEAVE, TryCatch #5 {all -> 0x019f, blocks: (B:29:0x0135, B:30:0x0160, B:32:0x018a), top: B:80:0x0135, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x0222 A[Catch: all -> 0x0237, TRY_LEAVE, TryCatch #1 {all -> 0x0237, blocks: (B:44:0x01cd, B:45:0x01f8, B:47:0x0222), top: B:73:0x01cd, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:83:? A[RETURN, SYNTHETIC] */
    public static synchronized void onCallFromNative(long j) {
        com.kwad.sdk.core.d.c.e(TAG, "onCallFromNative");
        isExceptionHappened.set(true);
        sCrashingPid = String.valueOf(Process.myPid());
        File file = getInstance().mLogDir;
        File file2 = getInstance().mLogcatFile;
        File file3 = getInstance().mMessageFile;
        File file4 = getInstance().mJavaTraceFile;
        File file5 = getInstance().mMemoryInfoFile;
        e uploader = getInstance().getUploader();
        try {
            if (!file.exists() && !file.mkdirs()) {
                StringBuilder sb = new StringBuilder();
                ExceptionMessage exceptionMessage = mMessage;
                exceptionMessage.mErrorMessage = sb.append(exceptionMessage.mErrorMessage).append("create ").append(file.getPath()).append(" failed!\n").toString();
                if (uploader != null) {
                    mMessage.toJson();
                }
            }
            if (!getInstance().mDumpDir.exists() && !getInstance().mDumpDir.mkdirs()) {
                StringBuilder sb2 = new StringBuilder();
                ExceptionMessage exceptionMessage2 = mMessage;
                exceptionMessage2.mErrorMessage = sb2.append(exceptionMessage2.mErrorMessage).append("create ").append(getInstance().mDumpDir.getPath()).append(" failed!\n").toString();
                if (uploader != null) {
                    mMessage.toJson();
                }
            }
            if (file2 == null) {
                file2 = new File(getInstance().mDumpDir, "logcat");
            }
            if (file3 == null) {
                file3 = new File(getInstance().mDumpDir, CrashHianalyticsData.MESSAGE);
            }
            if (file4 == null) {
                file4 = new File(getInstance().mDumpDir, "all_java_backtrace");
            }
            if (file5 == null) {
                file5 = new File(getInstance().mDumpDir, "meminfo");
            }
            g.b(null, mMessage, com.kwad.sdk.crash.e.Qd().getContext());
            g.a(mMessage, getInstance().getCrashType());
            mMessage.mLogUUID = g.gI(getInstance().mDumpDir.getName());
            if (file3 != null) {
                try {
                    com.kwad.sdk.core.d.c.e(TAG, "onCallFromNative write message " + mMessage.toJson().toString());
                    g.a(file3, mMessage.toJson().toString());
                    g.H(file4);
                    getInstance().backupLogFiles(file);
                    g.a(uploader, TAG, getInstance().mDumpDir);
                    getInstance().uploadRemainingExceptions();
                    g.I(file5);
                    g.F(file2);
                    if (getInstance().mExceptionListener != null) {
                        getInstance().mExceptionListener.a(getInstance().getCrashType(), mMessage);
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                    if (uploader != null) {
                        g.x(th);
                        return;
                    }
                    return;
                }
            } else {
                g.H(file4);
                getInstance().backupLogFiles(file);
                g.a(uploader, TAG, getInstance().mDumpDir);
                getInstance().uploadRemainingExceptions();
                g.I(file5);
                g.F(file2);
                if (getInstance().mExceptionListener != null) {
                    getInstance().mExceptionListener.a(getInstance().getCrashType(), mMessage);
                }
            }
        } catch (Throwable th2) {
            try {
                StringBuilder sb3 = new StringBuilder();
                ExceptionMessage exceptionMessage3 = mMessage;
                exceptionMessage3.mErrorMessage = sb3.append(exceptionMessage3.mErrorMessage).append(th2).toString();
                com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", Log.getStackTraceString(th2));
                if (file3 != null) {
                    try {
                        com.kwad.sdk.core.d.c.e(TAG, "onCallFromNative write message " + mMessage.toJson().toString());
                        g.a(file3, mMessage.toJson().toString());
                        g.H(file4);
                        getInstance().backupLogFiles(file);
                        g.a(uploader, TAG, getInstance().mDumpDir);
                        getInstance().uploadRemainingExceptions();
                        g.I(file5);
                        g.F(file2);
                        if (getInstance().mExceptionListener != null) {
                            getInstance().mExceptionListener.a(getInstance().getCrashType(), mMessage);
                            return;
                        }
                        return;
                    } catch (Throwable th3) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(th3);
                        if (uploader != null) {
                            g.x(th3);
                            return;
                        }
                        return;
                    }
                }
                g.H(file4);
                getInstance().backupLogFiles(file);
                g.a(uploader, TAG, getInstance().mDumpDir);
                getInstance().uploadRemainingExceptions();
                g.I(file5);
                g.F(file2);
                if (getInstance().mExceptionListener != null) {
                    getInstance().mExceptionListener.a(getInstance().getCrashType(), mMessage);
                    return;
                }
                return;
            } catch (Throwable th4) {
                if (file3 != null) {
                    try {
                        com.kwad.sdk.core.d.c.e(TAG, "onCallFromNative write message " + mMessage.toJson().toString());
                        g.a(file3, mMessage.toJson().toString());
                    } catch (Throwable th5) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(th5);
                        if (uploader != null) {
                            g.x(th5);
                        }
                        throw th4;
                    }
                }
                g.H(file4);
                getInstance().backupLogFiles(file);
                g.a(uploader, TAG, getInstance().mDumpDir);
                getInstance().uploadRemainingExceptions();
                g.I(file5);
                g.F(file2);
                if (getInstance().mExceptionListener != null) {
                    getInstance().mExceptionListener.a(getInstance().getCrashType(), mMessage);
                }
                throw th4;
            }
        }
        throw th;
    }

    @Override // com.kwad.sdk.crash.handler.b
    protected final void reportException(File[] fileArr, CountDownLatch countDownLatch) {
        com.kwad.sdk.crash.report.g gVar = new com.kwad.sdk.crash.report.g();
        gVar.a(getUploader());
        for (File file : fileArr) {
            gVar.a(file, countDownLatch);
        }
    }
}
