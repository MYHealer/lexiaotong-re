package client.android.yixiaotong.exception;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class ClientException extends Exception {
    public static final int APPUPDATECODE = -53;
    public static final int EXITAPP = 1001;
    public static final int EXITAPP1 = -44;
    public static final int LocalException = -1001;
    public static final int TIPCODE = -45;
    public static final int TIPCODE1 = -12005;
    private int mCode;
    private String mDetail;
    private Throwable mException;
    private Object mObject;
    private String mSerial;

    public int getCode() {
        return this.mCode;
    }

    public String getDetail() {
        return this.mDetail;
    }

    public Throwable getException() {
        return this.mException;
    }

    public int getLocalCode() {
        return -1000;
    }

    public Object getObject() {
        return this.mObject;
    }

    public String getSerial() {
        return this.mSerial;
    }

    public boolean isNeedExitApp(int i) {
        return i == 1001 || i == -44;
    }

    public boolean isNeedExitAppV4(int i) {
        return i == 403;
    }

    public boolean isNeedTip(int i) {
        return i == -45 || i == -12005;
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

    public void setObject(Object obj) {
        this.mObject = obj;
    }

    public void setSerial(String str) {
        this.mSerial = str;
    }

    public ClientException() {
    }

    public ClientException(int i, String str) {
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
        setDetail(str);
    }

    public static ClientException getImageUploadFailException() {
        ClientException clientException = new ClientException(-1000);
        clientException.setDetail("图片上传失败");
        return clientException;
    }

    public static boolean isImageUploadFailException(ClientException clientException) {
        return clientException.getCode() == -1000;
    }
}
