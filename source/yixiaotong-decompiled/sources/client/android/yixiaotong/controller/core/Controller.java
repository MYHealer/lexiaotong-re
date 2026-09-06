package client.android.yixiaotong.controller.core;

import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.util.http.HttpProtocolFactory;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class Controller {
    private boolean isCancel;
    private Account mAccount;
    private volatile Listener<?> mListener;
    private Object[] mParams;
    private final String mTag = String.valueOf(System.nanoTime());

    private void clearListener() {
        if (this.mListener != null) {
            this.mListener = null;
        }
    }

    public Account getAccount() {
        return this.mAccount;
    }

    public Listener<?> getListener() {
        if (this.mListener != null) {
            return this.mListener;
        }
        return null;
    }

    public Object[] getParams() {
        return this.mParams;
    }

    public String getTag() {
        return this.mTag;
    }

    public boolean isCancel() {
        return this.isCancel;
    }

    public Controller(Account account, Listener<?> listener, Object... objArr) {
        this.mAccount = account;
        this.mListener = listener;
        this.mParams = objArr;
    }

    public void cancelController() {
        this.isCancel = true;
        clearListener();
        HttpProtocolFactory.getInstance().cancelRequest(this.mTag);
    }
}
