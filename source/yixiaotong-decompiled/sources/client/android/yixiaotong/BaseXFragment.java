package client.android.yixiaotong;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.account.AccountManager;
import client.android.yixiaotong.exception.HttpException;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class BaseXFragment extends Fragment implements BaseInterface {
    public Handler mHandler;

    @Override // client.android.yixiaotong.BaseInterface
    public void onWaitEnd() {
    }

    @Override // client.android.yixiaotong.BaseInterface
    public void onWaitStart(String str) {
    }

    @Override // androidx.fragment.app.Fragment
    public Context getContext() {
        return getActivity();
    }

    public Context getApplicationContext() {
        return StubApp.getOrigApplicationContext(getActivity().getApplicationContext());
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
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
