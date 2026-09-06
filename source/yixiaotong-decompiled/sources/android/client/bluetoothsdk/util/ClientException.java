package android.client.bluetoothsdk.util;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class ClientException extends RuntimeException {
    private int mCode;
    private String mDetail;
    private Throwable mException;

    public int getCode() {
        return this.mCode;
    }

    public String getDetail() {
        return this.mDetail;
    }

    public Throwable getException() {
        return this.mException;
    }

    public void setCode(int i) {
        this.mCode = i;
    }

    public void setDetail(String str) {
        this.mDetail = str;
    }

    public void setException(Throwable th) {
        this.mException = th;
    }

    public ClientException() {
    }

    public ClientException(int i, String str) {
        super(str);
        setCode(i);
        setDetail(str);
    }

    public ClientException(int i) {
        setCode(i);
    }

    public ClientException(Throwable th) {
        setException(th);
    }

    public ClientException(String str) {
        super(str);
        setDetail(str);
    }
}
