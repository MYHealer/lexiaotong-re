package com.fancy.adsdk.lib.utils;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class Logger {
    private static final int MAX_LOG_LENGTH = 4000;
    private static final LogDispatcher dispatcher;
    private static boolean isDebug;

    public interface DispatchCallback {
        void onDispatch();
    }

    public interface ILogger {
        public static final String TAG = "PTG_AD_LOG";

        void d(LogMessage logMessage);

        void e(LogMessage logMessage);

        boolean enable();

        void i(LogMessage logMessage);

        void setLoggerOutput(Class cls);

        void w(LogMessage logMessage);
    }

    public static class LogDispatcher {
        private static DispatchCallback dispatchCallback;
        private static final Set<ILogger> allReceivers = new HashSet();
        private static final Executor dispatcher = Executors.newSingleThreadExecutor();

        public static void addLogReceiver(ILogger iLogger) {
            if (iLogger != null) {
                Set<ILogger> set = allReceivers;
                synchronized (set) {
                    set.add(iLogger);
                }
            }
        }

        public static void setDispatchCallback(DispatchCallback dispatchCallback2) {
            dispatchCallback = dispatchCallback2;
        }

        public void dispatch(final LoggerExecutor loggerExecutor) {
            dispatcher.execute(new Runnable() { // from class: com.fancy.adsdk.lib.utils.Logger.LogDispatcher.1
                @Override // java.lang.Runnable
                public void run() {
                    if (LogDispatcher.dispatchCallback != null) {
                        LogDispatcher.dispatchCallback.onDispatch();
                    }
                    ArrayList arrayList = new ArrayList();
                    synchronized (LogDispatcher.allReceivers) {
                        arrayList.addAll(LogDispatcher.allReceivers);
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        try {
                            loggerExecutor.onExecute((ILogger) it.next());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public static class LogMessage {
        public Object context;
        public Object[] ext;
        public String message;
        public String tag;
        public Throwable throwable;

        public LogMessage setExt(Object... objArr) {
            this.ext = objArr;
            return this;
        }

        public LogMessage setMessage(String str) {
            this.message = str;
            return this;
        }

        public LogMessage setTag(String str) {
            this.tag = str;
            return this;
        }

        public LogMessage setThrowable(Throwable th) {
            this.throwable = th;
            return this;
        }

        public LogMessage with(Object obj) {
            this.context = obj;
            return this;
        }
    }

    public interface LoggerExecutor {
        void onExecute(ILogger iLogger);
    }

    public static class PlainLogger implements ILogger {
        private String defaultTag;

        public PlainLogger(String str) {
            this.defaultTag = str;
        }

        private String buildExt(Object... objArr) {
            String str;
            StringBuilder sb = new StringBuilder();
            if (objArr != null) {
                for (Object obj : objArr) {
                    if (sb.length() == 0) {
                        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
                        str = "EXT = [ ";
                    } else {
                        str = " , ";
                    }
                    sb.append(str);
                    sb.append(obj);
                }
                if (sb.length() > 0) {
                    sb.append(" ]\n");
                }
            }
            return sb.toString();
        }

        private String buildThrowable(Throwable th) {
            StringBuilder sb = new StringBuilder();
            if (th != null) {
                sb.append(IOUtils.LINE_SEPARATOR_UNIX);
                sb.append(th.getMessage());
                sb.append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            return sb.toString();
        }

        private String getTag(String str) {
            return TextUtils.isEmpty(str) ? this.defaultTag : str;
        }

        @Override // com.fancy.adsdk.lib.utils.Logger.ILogger
        public void d(LogMessage logMessage) {
            try {
                Log.d(getTag(logMessage.tag), logMessage.message + buildExt(logMessage.ext) + buildThrowable(logMessage.throwable));
            } catch (Exception unused) {
            }
        }

        @Override // com.fancy.adsdk.lib.utils.Logger.ILogger
        public void e(LogMessage logMessage) {
            try {
                Log.e(getTag(logMessage.tag), logMessage.message + buildExt(logMessage.ext) + buildThrowable(logMessage.throwable));
            } catch (Exception unused) {
            }
        }

        @Override // com.fancy.adsdk.lib.utils.Logger.ILogger
        public boolean enable() {
            return true;
        }

        @Override // com.fancy.adsdk.lib.utils.Logger.ILogger
        public void i(LogMessage logMessage) {
            try {
                Log.i(getTag(logMessage.tag), logMessage.message + buildExt(logMessage.ext) + buildThrowable(logMessage.throwable));
            } catch (Exception unused) {
            }
        }

        @Override // com.fancy.adsdk.lib.utils.Logger.ILogger
        public void setLoggerOutput(Class cls) {
        }

        @Override // com.fancy.adsdk.lib.utils.Logger.ILogger
        public void w(LogMessage logMessage) {
            try {
                Log.w(getTag(logMessage.tag), logMessage.message + buildExt(logMessage.ext) + buildThrowable(logMessage.throwable));
            } catch (Exception unused) {
            }
        }
    }

    static {
        LogDispatcher logDispatcher = new LogDispatcher();
        dispatcher = logDispatcher;
        logDispatcher.dispatch(new LoggerExecutor() { // from class: com.fancy.adsdk.lib.utils.Logger.1
            @Override // com.fancy.adsdk.lib.utils.Logger.LoggerExecutor
            public void onExecute(ILogger iLogger) {
                iLogger.setLoggerOutput(Logger.class);
            }
        });
    }

    private static LogMessage createDefault() {
        return new LogMessage();
    }

    public static LogMessage d(String str) {
        return d(null, str);
    }

    public static LogMessage d(String str, String str2) {
        return d(str, str2, new Object[0]);
    }

    public static LogMessage d(String str, String str2, Object... objArr) {
        if (!isDebug) {
            return createDefault();
        }
        final LogMessage ext = new LogMessage().setTag(getTag(str)).setMessage(str2).setExt(objArr);
        dispatcher.dispatch(new LoggerExecutor() { // from class: com.fancy.adsdk.lib.utils.Logger.3
            @Override // com.fancy.adsdk.lib.utils.Logger.LoggerExecutor
            public void onExecute(ILogger iLogger) {
                iLogger.d(ext);
            }
        });
        return ext;
    }

    public static LogMessage e(String str) {
        return e((String) null, str);
    }

    public static LogMessage e(String str, String str2) {
        return e(str, str2, null);
    }

    public static LogMessage e(String str, String str2, Throwable th) {
        if (!isDebug) {
            return createDefault();
        }
        final LogMessage throwable = new LogMessage().setTag(getTag(str)).setMessage(str2).setThrowable(th);
        dispatcher.dispatch(new LoggerExecutor() { // from class: com.fancy.adsdk.lib.utils.Logger.4
            @Override // com.fancy.adsdk.lib.utils.Logger.LoggerExecutor
            public void onExecute(ILogger iLogger) {
                iLogger.e(throwable);
            }
        });
        return throwable;
    }

    public static LogMessage e(String str, Throwable th) {
        return e(null, str, th);
    }

    private static String getTag() {
        return getTag(null);
    }

    private static String getTag(String str) {
        return TextUtils.isEmpty(str) ? ILogger.TAG : str;
    }

    public static LogMessage i(String str) {
        return i(null, str);
    }

    public static LogMessage i(String str, String str2) {
        if (!isDebug) {
            return createDefault();
        }
        final LogMessage message = new LogMessage().setTag(getTag(str)).setMessage(str2);
        dispatcher.dispatch(new LoggerExecutor() { // from class: com.fancy.adsdk.lib.utils.Logger.2
            @Override // com.fancy.adsdk.lib.utils.Logger.LoggerExecutor
            public void onExecute(ILogger iLogger) {
                iLogger.i(message);
            }
        });
        return message;
    }

    public static boolean isDebug() {
        return isDebug;
    }

    public static void logLongMessage(String str, String str2) {
        if (str2.length() <= 4000) {
            Log.d(str, str2);
            return;
        }
        int length = str2.length() / 4000;
        int i = 0;
        while (i <= length) {
            int i2 = i * 4000;
            i++;
            int iMin = Math.min(i * 4000, str2.length());
            if (i2 < iMin) {
                Log.d(str, "[" + i + "/" + (length + 1) + "] " + str2.substring(i2, iMin));
            }
        }
    }

    public static void openDebug() {
        isDebug = true;
    }
}
