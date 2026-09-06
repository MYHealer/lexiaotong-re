package com.adprof.sdk;

import android.os.Message;
import android.util.Log;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class kn implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v9 f1271a;

    public kn(nn nnVar, v9 v9Var) {
        this.f1271a = v9Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        v9 v9Var = this.f1271a;
        fn.a aVar = v9Var != null ? (fn.a) v9Var.f1475a : null;
        if (aVar == null || aVar.isCancelled()) {
            return;
        }
        try {
            aVar.execute();
        } catch (Exception e) {
            aVar.mError = e;
            Log.w("TaskHelper", e.toString(), e);
        } catch (Throwable th) {
            aVar.mError = new RuntimeException(th);
            Log.e("TaskHelper", th.toString());
        }
        if (aVar.isCancelled()) {
            return;
        }
        Message messageObtainMessage = nn.f1329a.obtainMessage(1, this.f1271a);
        if (aVar.needDoneAtOnce()) {
            nn.f1329a.sendMessageAtFrontOfQueue(messageObtainMessage);
        } else {
            nn.f1329a.sendMessage(messageObtainMessage);
        }
    }
}
