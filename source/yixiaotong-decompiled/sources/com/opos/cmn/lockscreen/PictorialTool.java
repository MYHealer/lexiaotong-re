package com.opos.cmn.lockscreen;

import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.google.android.exoplayer2.ExoPlayer;
import com.heytap.pictorial.sdk.PictorialSDK;
import com.stub.StubApp;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class PictorialTool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PictorialSDK f6177a = new PictorialSDK();
    private Context b;

    private static class ResultReceiverWrapper extends ResultReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a f6181a;

        public ResultReceiverWrapper(a aVar) {
            super(null);
            this.f6181a = aVar;
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i, Bundle bundle) {
            a aVar;
            com.opos.cmn.an.f.a.b("PictorialTool", "onReceiveResult:" + i);
            boolean z = true;
            if (i == 1) {
                aVar = this.f6181a;
                if (aVar == null) {
                    return;
                }
            } else {
                aVar = this.f6181a;
                if (aVar == null) {
                    return;
                } else {
                    z = false;
                }
            }
            aVar.a(z);
        }
    }

    public interface a {
        void a(boolean z);
    }

    public interface b {
        void a(boolean z);
    }

    public PictorialTool(Context context) {
        this.b = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    private void a(final b bVar) {
        if (a(this.b)) {
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.cmn.lockscreen.PictorialTool.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean zBooleanValue;
                    FutureTask futureTask = new FutureTask(new Callable<Boolean>() { // from class: com.opos.cmn.lockscreen.PictorialTool.1.1
                        @Override // java.util.concurrent.Callable
                        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                        public Boolean call() throws Exception {
                            return Boolean.valueOf(PictorialTool.this.a());
                        }
                    });
                    com.opos.cmn.an.j.b.c(futureTask);
                    try {
                        zBooleanValue = ((Boolean) futureTask.get(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, TimeUnit.MILLISECONDS)).booleanValue();
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.b("PictorialTool", "", e);
                        zBooleanValue = false;
                    }
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.a(zBooleanValue);
                    }
                }
            });
            return;
        }
        com.opos.cmn.an.f.a.b("PictorialTool", "not support queryVerifyAsync");
        if (bVar != null) {
            bVar.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a() {
        if (!a(this.b)) {
            com.opos.cmn.an.f.a.b("PictorialTool", "not support queryVerifySync");
            return false;
        }
        try {
            boolean zA = this.f6177a.a(this.b);
            com.opos.cmn.an.f.a.b("PictorialTool", "query verify result:" + zA);
            return zA;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("PictorialTool", "need verify", e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a aVar) {
        if (!a(this.b)) {
            com.opos.cmn.an.f.a.b("PictorialTool", "not support verifyLockScreen");
            if (aVar != null) {
                aVar.a(false);
                return;
            }
            return;
        }
        try {
            com.opos.cmn.an.f.a.b("PictorialTool", "verifyLockScreen");
            this.f6177a.a(this.b, "", new ResultReceiverWrapper(aVar));
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("PictorialTool", "verify", e);
            if (aVar != null) {
                aVar.a(false);
            }
        }
    }

    public void a(a aVar) {
        if (!a(this.b)) {
            com.opos.cmn.an.f.a.b("PictorialTool", "not support unlockScreen");
            if (aVar != null) {
                aVar.a(false);
                return;
            }
            return;
        }
        try {
            com.opos.cmn.an.f.a.b("PictorialTool", "unlockScreen");
            this.f6177a.a(this.b, new ResultReceiverWrapper(aVar));
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("PictorialTool", "verify", e);
            if (aVar != null) {
                aVar.a(false);
            }
        }
    }

    public boolean a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return PictorialSDK.f3491a.a(context);
        } catch (Exception unused) {
            com.opos.cmn.an.f.a.b("PictorialTool", "checkVerifySupport ");
            return false;
        }
    }

    public void b(final a aVar) {
        if (a(this.b)) {
            a(new b() { // from class: com.opos.cmn.lockscreen.PictorialTool.2
                @Override // com.opos.cmn.lockscreen.PictorialTool.b
                public void a(boolean z) {
                    if (!z) {
                        PictorialTool.this.c(aVar);
                        return;
                    }
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a(true);
                    }
                }
            });
        } else if (aVar != null) {
            aVar.a(false);
        }
    }
}
