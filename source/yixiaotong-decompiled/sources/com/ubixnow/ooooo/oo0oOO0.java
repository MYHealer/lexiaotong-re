package com.ubixnow.ooooo;

import com.ubixnow.core.api.UMNInitCallBack;
import com.ubixnow.utils.BaseUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class oo0oOO0 {
    public UMNInitCallBack OooO00o;

    public class OooO00o implements Runnable {
        public OooO00o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            oo0oOO0.this.OooO00o.onSucc();
        }
    }

    public class OooO0O0 implements Runnable {
        public final /* synthetic */ int OooO00o;
        public final /* synthetic */ String OooO0O0;

        public OooO0O0(int i, String str) {
            this.OooO00o = i;
            this.OooO0O0 = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            oo0oOO0.this.OooO00o.onFail(this.OooO00o, this.OooO0O0);
        }
    }

    public oo0oOO0(UMNInitCallBack uMNInitCallBack) {
        this.OooO00o = uMNInitCallBack;
    }

    public synchronized void OooO00o() {
        if (this.OooO00o != null) {
            BaseUtils.runInMainThread(new OooO00o());
        }
    }

    public synchronized void OooO00o(int i, String str) {
        if (this.OooO00o != null) {
            BaseUtils.runInMainThread(new OooO0O0(i, str));
        }
    }
}
