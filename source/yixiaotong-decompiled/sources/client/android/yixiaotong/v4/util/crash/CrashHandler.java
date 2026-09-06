package client.android.yixiaotong.v4.util.crash;

import android.content.Context;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import android.widget.Toast;
import client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil;
import com.google.android.exoplayer2.C;
import com.huawei.openalliance.ad.constant.x;
import com.stub.StubApp;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class CrashHandler implements Thread.UncaughtExceptionHandler {
    private static CrashHandler INSTANCE = new CrashHandler();
    private static final String TAG = "CrashHandler";
    private String crashLogPath;
    private Context mContext;
    private OnCrashListener mCrashListener;
    private Thread.UncaughtExceptionHandler mDefaultHandler;
    private final Map<String, String> infos = new HashMap();
    private final DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.getDefault());
    private boolean showToast = false;

    public interface OnCrashListener {
        void onCrash(String str);
    }

    public static CrashHandler getInstance() {
        return INSTANCE;
    }

    public void setOnCrashListener(OnCrashListener onCrashListener) {
        this.mCrashListener = onCrashListener;
    }

    public void setShowToast(boolean z) {
        this.showToast = z;
    }

    public void init(Context context) {
        this.mContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.crashLogPath = getLogFilePath();
        createLogDir();
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (!handleException(th) && this.mDefaultHandler != null) {
            Log.e("CrashHandler", "uncaughtException:1111");
            this.mDefaultHandler.uncaughtException(thread, th);
            return;
        }
        Log.e("CrashHandler", "uncaughtException:22222");
        try {
            Thread.sleep(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
        } catch (InterruptedException e) {
            Log.e("CrashHandler", "Error : ", e);
        }
        Process.killProcess(Process.myPid());
        System.exit(1);
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [client.android.yixiaotong.v4.util.crash.CrashHandler$1] */
    private boolean handleException(Throwable th) {
        if (th == null) {
            return false;
        }
        String fullStackTrace = getFullStackTrace(th);
        Log.e("CrashHandler", "handleException: 完整堆栈信息: \n" + fullStackTrace);
        V4ErrorControlUtil.getInstance().postCrashErrorLog(fullStackTrace);
        if (!this.showToast) {
            return true;
        }
        new Thread() { // from class: client.android.yixiaotong.v4.util.crash.CrashHandler.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Looper.prepare();
                Toast.makeText(CrashHandler.this.mContext, "程序出现异常，即将退出", 1).show();
                Looper.loop();
            }
        }.start();
        return true;
    }

    private String getFullStackTrace(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
            printWriter.println("\nCaused by:");
            cause.printStackTrace(printWriter);
        }
        printWriter.close();
        return stringWriter.toString();
    }

    private String saveCrashInfoToFile(Throwable th) {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : this.infos.entrySet()) {
                sb.append(entry.getKey()).append("=").append(entry.getValue()).append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                cause.printStackTrace(printWriter);
            }
            printWriter.close();
            sb.append(IOUtils.LINE_SEPARATOR_UNIX).append(stringWriter.toString());
            File file = new File(this.crashLogPath, "crash-" + this.formatter.format(new Date()) + x.A + System.currentTimeMillis() + ".log");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(sb.toString());
            bufferedWriter.close();
            fileWriter.close();
            Log.e("CrashHandler", "崩溃日志保存成功: " + file.getAbsolutePath());
            return sb.toString();
        } catch (Exception e) {
            Log.e("CrashHandler", "保存崩溃日志失败", e);
            return sb.toString();
        }
    }

    private String getLogFilePath() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return this.mContext.getExternalFilesDir("crash").getAbsolutePath();
        }
        return this.mContext.getFilesDir().getAbsolutePath() + File.separator + "crash";
    }

    private void createLogDir() {
        File file = new File(this.crashLogPath);
        if (file.exists()) {
            return;
        }
        Log.d("CrashHandler", "创建日志目录: " + file.mkdirs());
    }

    public File[] getCrashLogFiles() {
        File file = new File(this.crashLogPath);
        return (file.exists() && file.isDirectory()) ? file.listFiles() : new File[0];
    }

    public void clearCrashLogs() {
        File[] fileArrListFiles;
        File file = new File(this.crashLogPath);
        if (file.exists() && file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                file2.delete();
            }
        }
    }
}
