package client.android.yixiaotong.v3.util;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class LogReceivedUtil {
    private static final long MAXLENGTH = 50000;
    private static final String TAG = "LogReceivedUtil";
    private StringBuilder mStringBuilderAll;

    /* JADX INFO: renamed from: client.android.yixiaotong.v3.util.LogReceivedUtil$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public void clearData() {
        if (this.mStringBuilderAll != null) {
            this.mStringBuilderAll = null;
        }
    }

    public void saveData(String str) {
    }

    /* synthetic */ LogReceivedUtil(AnonymousClass1 anonymousClass1) {
        this();
    }

    private LogReceivedUtil() {
    }

    private static final class SingleHolder {
        private static final LogReceivedUtil INSTANCE = new LogReceivedUtil(null);

        private SingleHolder() {
        }
    }

    public static LogReceivedUtil getInstance() {
        return SingleHolder.INSTANCE;
    }

    public String getAllData() {
        StringBuilder sb = this.mStringBuilderAll;
        return sb != null ? sb.toString() : "暂无日志";
    }
}
