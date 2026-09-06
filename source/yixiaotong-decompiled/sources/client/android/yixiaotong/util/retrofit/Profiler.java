package client.android.yixiaotong.util.retrofit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public interface Profiler<T> {
    void afterCall(RequestInformation requestInformation, long j, int i, T t);

    T beforeCall();

    public static final class RequestInformation {
        private final String baseUrl;
        private final long contentLength;
        private final String contentType;
        private final String method;
        private final String relativePath;

        public String getBaseUrl() {
            return this.baseUrl;
        }

        public long getContentLength() {
            return this.contentLength;
        }

        public String getContentType() {
            return this.contentType;
        }

        public String getMethod() {
            return this.method;
        }

        public String getRelativePath() {
            return this.relativePath;
        }

        public RequestInformation(String str, String str2, String str3, long j, String str4) {
            this.method = str;
            this.baseUrl = str2;
            this.relativePath = str3;
            this.contentLength = j;
            this.contentType = str4;
        }
    }
}
