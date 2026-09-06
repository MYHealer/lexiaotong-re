package cz.msebera.android.httpclient.client;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class HttpResponseException extends ClientProtocolException {
    private static final long serialVersionUID = -7186627969477257933L;
    private final int statusCode;

    public int getStatusCode() {
        return this.statusCode;
    }

    public HttpResponseException(int i, String str) {
        super(str);
        this.statusCode = i;
    }
}
