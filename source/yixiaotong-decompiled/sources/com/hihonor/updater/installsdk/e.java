package com.hihonor.updater.installsdk;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.hihonor.updater.installsdk.api.AppStatusInfo;
import com.hihonor.updater.installsdk.api.DIInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HandlerThread f3739a;
    private a b;

    private static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f3740a = 1;
        public static final int b = 2;

        public a(Looper looper) {
            super(looper);
        }

        private DIInfo a(AppStatusInfo appStatusInfo) {
            if (TextUtils.isEmpty(appStatusInfo.getExtra())) {
                return null;
            }
            DIInfo dIInfoBuild = new DIInfo.Builder(null).build();
            dIInfoBuild.readFromJSON(appStatusInfo.getExtra());
            return dIInfoBuild;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null) {
                return;
            }
            int i = message.what;
            if (i != 1) {
                if (i == 2) {
                    AppStatusInfo appStatusInfo = (AppStatusInfo) message.obj;
                    c.b().onAppUninstalled(a(appStatusInfo), appStatusInfo);
                    return;
                }
                return;
            }
            Object obj = message.obj;
            if (obj == null) {
                return;
            }
            AppStatusInfo appStatusInfo2 = (AppStatusInfo) obj;
            c.b().a(a(appStatusInfo2), appStatusInfo2);
        }
    }

    public e() {
        b();
    }

    public synchronized void a() {
        a aVar = this.b;
        if (aVar != null) {
            aVar.removeCallbacksAndMessages(null);
            this.b = null;
        }
        HandlerThread handlerThread = this.f3739a;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f3739a = null;
        }
    }

    public void a(AppStatusInfo appStatusInfo) {
        if (this.b == null) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.obj = appStatusInfo;
        messageObtain.what = 2;
        this.b.sendMessage(messageObtain);
    }

    public synchronized void b() {
        if (this.f3739a == null) {
            this.f3739a = new HandlerThread("progress msg hander thread");
        }
        if (!this.f3739a.isAlive()) {
            this.f3739a.start();
        }
        if (this.b == null && this.f3739a.getLooper() != null) {
            this.b = new a(this.f3739a.getLooper());
        }
    }

    public void b(AppStatusInfo appStatusInfo) {
        if (this.b == null) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.obj = appStatusInfo;
        messageObtain.what = 1;
        this.b.sendMessage(messageObtain);
    }
}
