package com.kwad.sdk.crash.handler;

import android.app.ActivityManager;
import android.os.Build;
import android.os.FileObserver;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.Process;
import android.util.Log;
import android.util.Printer;
import com.byazt.hv.TTDownloadField;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.openalliance.ad.constant.x;
import com.kwad.sdk.crash.f;
import com.kwad.sdk.crash.model.message.AnrExceptionMessage;
import com.kwad.sdk.crash.model.message.AnrReason;
import com.kwad.sdk.crash.report.e;
import com.kwad.sdk.crash.utils.g;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.i;
import com.kwad.sdk.utils.y;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Pattern;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class AnrHandler extends b {
    private static final String ANR_HAPPENED_BEGIN = "------ ANR Happened Begin ------\n";
    private static final String DEFAULT_TRACE_ROOT = "/data/anr/";
    private static final long GET_REASON_INTERVAL = 500;
    private static final long PARSE_TRACE_INTERVAL = 10000;
    private static final String TAG = "AnrHandler";
    private static final long TRY_TIMES = 20;
    private static long sLastTime;
    private FileObserver mTraceFileObserver;
    private static final int MY_PID = Process.myPid();
    private static final Pattern PID_PATTERN = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
    private static final boolean DUMP_FROM_SIG_QUIT = SystemUtil.ge(21);

    static class a {
        private static final AnrHandler bet = new AnrHandler();
    }

    public static native boolean getStackTraceCrashOccured();

    public static native void install(String str, int i);

    public static native void notifyJavaDumpDone();

    public static void onCallFromNative(int i) {
    }

    @Override // com.kwad.sdk.crash.handler.b
    protected final int getCrashType() {
        return 3;
    }

    private AnrHandler() {
    }

    public static AnrHandler getInstance() {
        return a.bet;
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final void init(File file, f fVar, e eVar) {
        super.init(file, fVar, eVar);
        if (com.kwad.sdk.crash.b.PO()) {
            com.kwad.sdk.core.d.c.d(TAG, "ANR init ");
            this.mLogDir = file;
            if (!this.mLogDir.exists()) {
                this.mLogDir.mkdirs();
            }
            this.mDumpDir = new File(this.mLogDir, FILE_NAME_BASE + "-anr");
            new File(this.mLogDir, FILE_NAME_BASE);
            if (!DUMP_FROM_SIG_QUIT) {
                watchTraceFile();
                return;
            }
            try {
                Looper.getMainLooper().getQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.kwad.sdk.crash.handler.AnrHandler.1
                    @Override // android.os.MessageQueue.IdleHandler
                    public final boolean queueIdle() {
                        com.kwad.sdk.core.d.c.e(AnrHandler.TAG, "install in Idle");
                        AnrHandler.install(AnrHandler.this.mDumpDir.getPath(), Build.VERSION.SDK_INT);
                        return false;
                    }
                });
            } catch (Throwable unused) {
                getUploader();
            }
        }
    }

    /* JADX INFO: renamed from: com.kwad.sdk.crash.handler.AnrHandler$2, reason: invalid class name */
    final class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.d.c.e(AnrHandler.TAG, "install in main:");
            AnrHandler.install(AnrHandler.this.mDumpDir.getPath(), Build.VERSION.SDK_INT);
        }
    }

    private void watchTraceFile() {
        com.kwad.sdk.core.d.c.d(TAG, "ANR watchTraceFile");
        FileObserver fileObserver = new FileObserver(DEFAULT_TRACE_ROOT, 8) { // from class: com.kwad.sdk.crash.handler.AnrHandler.3
            @Override // android.os.FileObserver
            public final void onEvent(int i, String str) {
                if (str != null) {
                    AnrHandler.this.onTraceFileWritten(AnrHandler.DEFAULT_TRACE_ROOT + str);
                }
            }
        };
        this.mTraceFileObserver = fileObserver;
        try {
            fileObserver.startWatching();
        } catch (Throwable unused) {
            getInstance().getUploader();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTraceFileWritten(String str) {
        com.kwad.sdk.core.d.c.d(TAG, "ANR onTraceFileWritten");
        if (parseTraceFile(str)) {
            i.execute(new Runnable() { // from class: com.kwad.sdk.crash.handler.AnrHandler.4
                @Override // java.lang.Runnable
                public final void run() {
                    AnrHandler.getInstance().dumpAnr(null, AnrHandler.this.mIndex.getAndIncrement());
                }
            });
        }
    }

    private boolean parseTraceFile(String str) throws Throwable {
        int i;
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(str));
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            i = -1;
                            break;
                        }
                        if (PID_PATTERN.matcher(line).matches()) {
                            i = Integer.parseInt(line.split("\\s")[2]);
                            break;
                        }
                    } catch (FileNotFoundException unused) {
                        bufferedReader = bufferedReader2;
                        getUploader();
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return false;
                    } catch (IOException unused2) {
                        bufferedReader = bufferedReader2;
                        getUploader();
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        throw th;
                    }
                }
                boolean z = i == MY_PID;
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                return z;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException unused3) {
        } catch (IOException unused4) {
        }
    }

    public static synchronized String getMainThreadStackTrace() {
        StringBuilder sb;
        try {
            sb = new StringBuilder();
            for (StackTraceElement stackTraceElement : Looper.getMainLooper().getThread().getStackTrace()) {
                sb.append("  at ").append(stackTraceElement).append(IOUtils.LINE_SEPARATOR_UNIX);
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.e(TAG, Log.getStackTraceString(th));
            return "";
        }
        return sb.append(IOUtils.LINE_SEPARATOR_UNIX).toString();
    }

    public static boolean isRealNotResponding(final int i) {
        com.kwad.sdk.core.d.c.d(TAG, "judge isRealNotResponding");
        try {
            isExceptionHappened.set(true);
            sCrashingPid = String.valueOf(Process.myPid());
            i.execute(new Runnable() { // from class: com.kwad.sdk.crash.handler.AnrHandler.5
                @Override // java.lang.Runnable
                public final void run() {
                    AnrHandler.getInstance().dumpAnr(null, i);
                }
            });
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    private static boolean checkErrorState() {
        try {
            com.kwad.sdk.core.d.c.i(TAG, "[checkErrorState] start");
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = ((ActivityManager) com.kwad.sdk.core.c.b.LW().getApplication().getSystemService(TTDownloadField.TT_ACTIVITY)).getProcessesInErrorState();
            if (processesInErrorState == null) {
                com.kwad.sdk.core.d.c.i(TAG, "[checkErrorState] procs == null");
                return false;
            }
            for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                if (processErrorStateInfo.uid != Process.myUid() && processErrorStateInfo.condition == 2) {
                    com.kwad.sdk.core.d.c.i(TAG, "maybe received other apps ANR signal");
                    return false;
                }
                if (processErrorStateInfo.pid == Process.myPid() && processErrorStateInfo.condition == 2) {
                    com.kwad.sdk.core.d.c.i(TAG, "error sate longMsg = " + processErrorStateInfo.longMsg);
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.e(TAG, "[checkErrorState] error : " + th.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void dumpAnr(String str, int i) {
        boolean z;
        com.kwad.sdk.core.d.c.d(TAG, "ANR dumpAnr tracePath=" + str + " index=" + i);
        AnrExceptionMessage anrExceptionMessage = new AnrExceptionMessage();
        File file = new File(this.mDumpDir.toString() + x.A + i);
        File file2 = getInstance().mLogDir;
        try {
            if (file2.exists() || file2.mkdirs()) {
                z = true;
            } else {
                com.kwad.sdk.core.d.c.d(TAG, "ANR dumpAnr create dir failed.");
                anrExceptionMessage.mErrorMessage += "create " + file2.getPath() + " failed!\n";
                z = false;
            }
            if (!file.exists() && !file.mkdirs()) {
                com.kwad.sdk.core.d.c.d(TAG, "ANR dumpAnr create dir failed.");
                anrExceptionMessage.mErrorMessage += "create " + this.mDumpDir.getPath() + " failed!\n";
                z = false;
            }
            g.b(null, anrExceptionMessage, com.kwad.sdk.crash.e.Qd().getContext());
            g.a(anrExceptionMessage, 3);
            File file3 = new File(file, "dump");
            if (str != null && z) {
                y.h(new File(str), file3);
            }
            g.F(new File(file, "logcat"));
            try {
                final StringBuilder sb = new StringBuilder();
                Looper.getMainLooper().dump(new Printer() { // from class: com.kwad.sdk.crash.handler.AnrHandler.6
                    @Override // android.util.Printer
                    public final void println(String str2) {
                        sb.append(str2).append(IOUtils.LINE_SEPARATOR_UNIX);
                    }
                }, "");
                anrExceptionMessage.mMessageQueueDetail = sb.substring(0, sb.length() - 1);
            } catch (Exception e) {
                anrExceptionMessage.mErrorMessage += Log.getStackTraceString(e) + IOUtils.LINE_SEPARATOR_UNIX;
            }
            try {
                anrExceptionMessage.mLogUUID = g.gI(file3.getName());
                g.a(new File(file, CrashHianalyticsData.MESSAGE), anrExceptionMessage.toJson().toString());
                getInstance().backupLogFiles(file2);
                e uploader = getInstance().getUploader();
                if (uploader != null) {
                    new StringBuilder(ANR_HAPPENED_BEGIN).append(anrExceptionMessage);
                }
                g.a(uploader, TAG, file3);
                g.I(new File(file, "meminfo"));
            } catch (Throwable unused) {
            }
            if (getInstance().mExceptionListener != null) {
                getInstance().mExceptionListener.a(getInstance().getCrashType(), anrExceptionMessage);
            }
            getInstance().uploadRemainingExceptions();
            notifyJavaDumpDone();
            getAnrReason(str, file);
        } catch (Throwable th) {
            anrExceptionMessage.mErrorMessage += th;
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    private static void getAnrReason(String str, File file) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        com.kwad.sdk.core.d.c.d(TAG, "ANR getAnrReasonInner");
        e uploader = getInstance().getUploader();
        if (str != null) {
            try {
                long jLastModified = new File(str).lastModified();
                if (Math.abs(jLastModified - sLastTime) < 10000) {
                    return;
                } else {
                    sLastTime = jLastModified;
                }
            } catch (Throwable unused) {
                return;
            }
        }
        ActivityManager activityManager = (ActivityManager) com.kwad.sdk.crash.e.Qd().getContext().getSystemService(TTDownloadField.TT_ACTIVITY);
        if (activityManager == null) {
            return;
        }
        ActivityManager.ProcessErrorStateInfo processErrorStateInfo = null;
        boolean z = false;
        for (int i = 0; i < 20; i++) {
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
            if (processesInErrorState != null) {
                for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo2 : processesInErrorState) {
                    if (processErrorStateInfo2.condition == 2) {
                        processErrorStateInfo = processErrorStateInfo2;
                        break;
                    }
                }
            }
            if (Build.VERSION.SDK_INT > 33 && !z && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                do {
                    if (!it.hasNext()) {
                        com.kwad.sdk.core.d.c.i(TAG, "anr did happen on android14");
                        g.a(new File(file, "anr_happened"), (CharSequence) "anr did happen", false);
                        z = true;
                        break;
                    }
                } while (it.next().pid != Process.myPid());
            }
            if (processErrorStateInfo != null) {
                break;
            }
            Thread.sleep(500L);
        }
        if (processErrorStateInfo == null) {
            return;
        }
        if (processErrorStateInfo.pid != MY_PID) {
            if (uploader != null) {
                String str2 = processErrorStateInfo.shortMsg;
                return;
            }
            return;
        }
        AnrReason anrReason = new AnrReason();
        anrReason.mTag = processErrorStateInfo.tag;
        anrReason.mShortMsg = processErrorStateInfo.shortMsg;
        anrReason.mLongMsg = processErrorStateInfo.longMsg;
        File file2 = new File(file, "anr_reason");
        com.kwad.sdk.core.d.c.i(TAG, "anr reason: " + anrReason.toJson().toString());
        g.a(file2, anrReason.toJson().toString());
    }

    @Override // com.kwad.sdk.crash.handler.b
    protected final void reportException(File[] fileArr, CountDownLatch countDownLatch) {
        com.kwad.sdk.crash.report.b bVar = new com.kwad.sdk.crash.report.b();
        bVar.a(getUploader());
        for (File file : fileArr) {
            bVar.a(file, countDownLatch);
        }
    }
}
