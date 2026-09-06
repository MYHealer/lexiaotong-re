package client.android.yixiaotong.v4.ui.debug;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4LogEntry {
    public final String content;
    public final int id;
    public final Level level;
    public final long timestamp;

    public enum Level {
        V,
        D,
        I,
        W,
        E
    }

    public V4LogEntry(int i, long j, Level level, String str) {
        this.id = i;
        this.timestamp = j;
        this.level = level;
        this.content = str;
    }

    public static Level parseLevel(String str) {
        if (str == null || str.isEmpty()) {
            return Level.V;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.contains("error") || lowerCase.contains("exception") || lowerCase.contains("fail") || lowerCase.contains("crash") || lowerCase.contains("fatal")) {
            return Level.E;
        }
        if (lowerCase.contains("warn") || lowerCase.contains("warning")) {
            return Level.W;
        }
        if (lowerCase.contains("debug")) {
            return Level.D;
        }
        if (lowerCase.contains("info")) {
            return Level.I;
        }
        return Level.V;
    }
}
