package client.android.yixiaotong.util.retrofit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public interface ErrorHandler {
    public static final ErrorHandler DEFAULT = new ErrorHandler() { // from class: client.android.yixiaotong.util.retrofit.ErrorHandler.1
        @Override // client.android.yixiaotong.util.retrofit.ErrorHandler
        public Throwable handleError(RetrofitError retrofitError) {
            return retrofitError;
        }
    };

    Throwable handleError(RetrofitError retrofitError);
}
