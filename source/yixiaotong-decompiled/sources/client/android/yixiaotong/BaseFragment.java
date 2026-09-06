package client.android.yixiaotong;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.account.AccountManager;
import client.android.yixiaotong.exception.HttpException;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class BaseFragment extends Fragment implements BaseInterface {
    private ProgressDialog dialog;
    public ProgressDialog mDialog;
    public Handler mHandler;
    private int dialogOpenTimes = 0;
    private Object dialogLock = new Object();

    static /* synthetic */ int access$106(BaseFragment baseFragment) {
        int i = baseFragment.dialogOpenTimes - 1;
        baseFragment.dialogOpenTimes = i;
        return i;
    }

    static /* synthetic */ int access$108(BaseFragment baseFragment) {
        int i = baseFragment.dialogOpenTimes;
        baseFragment.dialogOpenTimes = i + 1;
        return i;
    }

    @Override // android.app.Fragment
    public Context getContext() {
        return getActivity();
    }

    public Context getApplicationContext() {
        return StubApp.getOrigApplicationContext(getActivity().getApplicationContext());
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
    }

    protected void runOnUiThread(Runnable runnable) {
        try {
            getActivity().runOnUiThread(runnable);
        } catch (Exception unused) {
        }
    }

    protected void runOnUiThread(Runnable runnable, long j) {
        if (runnable != null) {
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            try {
                this.mHandler.postDelayed(runnable, j);
            } catch (Exception unused) {
            }
        }
    }

    public Account getLoginAccount() {
        return AccountManager.getInstance().getLoginAccount();
    }

    public void showProgressDialog(String str) {
        this.mDialog = ProgressDialog.show(getActivity(), null, str);
    }

    public void dismissProgressDialog() {
        ProgressDialog progressDialog = this.mDialog;
        if (progressDialog == null) {
            return;
        }
        progressDialog.dismiss();
    }

    @Override // client.android.yixiaotong.BaseInterface
    public void onWaitStart(final String str) {
        runOnUiThread(new Runnable() { // from class: client.android.yixiaotong.BaseFragment.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (BaseFragment.this.dialogLock) {
                    if (BaseFragment.access$108(BaseFragment.this) == 0) {
                        try {
                            BaseFragment baseFragment = BaseFragment.this;
                            baseFragment.dialog = ProgressDialog.show(baseFragment.getActivity(), null, str);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    @Override // client.android.yixiaotong.BaseInterface
    public void onWaitEnd() {
        runOnUiThread(new Runnable() { // from class: client.android.yixiaotong.BaseFragment.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (BaseFragment.this.dialogLock) {
                    if (BaseFragment.access$106(BaseFragment.this) <= 0) {
                        if (BaseFragment.this.dialog != null && BaseFragment.this.dialog.isShowing()) {
                            try {
                                BaseFragment.this.dialog.dismiss();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            BaseFragment.this.dialog = null;
                        }
                        BaseFragment.this.dialogOpenTimes = 0;
                    }
                }
            }
        });
    }

    @Override // client.android.yixiaotong.BaseInterface
    public void toast(String str) {
        Toast.makeText(BaseApplication.app, str, 0).show();
    }

    @Override // client.android.yixiaotong.BaseInterface
    public void handlerException(Exception exc) {
        if (exc instanceof HttpException) {
            toast(((HttpException) exc).getDetail());
        }
    }
}
