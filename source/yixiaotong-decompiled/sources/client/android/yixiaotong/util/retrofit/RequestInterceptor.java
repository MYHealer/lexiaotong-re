package client.android.yixiaotong.util.retrofit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public interface RequestInterceptor {
    public static final RequestInterceptor NONE = new RequestInterceptor() { // from class: client.android.yixiaotong.util.retrofit.RequestInterceptor.1
        @Override // client.android.yixiaotong.util.retrofit.RequestInterceptor
        public void intercept(RequestFacade requestFacade) {
        }
    };

    public interface RequestFacade {
        void addEncodedPathParam(String str, String str2);

        void addEncodedQueryParam(String str, String str2);

        void addHeader(String str, String str2);

        void addPathParam(String str, String str2);

        void addQueryParam(String str, String str2);
    }

    void intercept(RequestFacade requestFacade);
}
