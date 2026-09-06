package com.byazt.ymw;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.byazt.omf.sl;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 462, 20})
public class c extends sl.c {
    public Handler c = new Handler(Looper.getMainLooper());
    public com.byazt.aas.n.c tt;

    public c(com.byazt.aas.n.c cVar) {
        this.tt = cVar;
    }

    @Override // com.byazt.omf.sl
    public void c() throws RemoteException {
        c(new Runnable() { // from class: com.byazt.ymw.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.tt != null) {
                    c.this.tt.c();
                }
            }
        });
    }

    @Override // com.byazt.omf.sl
    public void tt() throws RemoteException {
        c(new Runnable() { // from class: com.byazt.ymw.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.tt != null) {
                    c.this.tt.tt();
                }
            }
        });
    }

    @Override // com.byazt.omf.sl
    public void ve() throws RemoteException {
        c(new Runnable() { // from class: com.byazt.ymw.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.tt != null) {
                    c.this.tt.ve();
                }
            }
        });
    }

    private void c(Runnable runnable) {
        this.c.post(runnable);
    }
}
