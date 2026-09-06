package com.kwad.sdk.core.e.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class b {
    private Context mContext;
    private final LinkedBlockingQueue<IBinder> mLinkedBlockingQueue = new LinkedBlockingQueue<>(1);
    private ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.kwad.sdk.core.e.a.b.1
        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", "onServiceConnected ： " + iBinder);
                b.this.mLinkedBlockingQueue.put(iBinder);
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", e);
            }
        }
    };

    public b(Context context) {
        this.mContext = context;
    }

    private c.C0743c MP() {
        Context context;
        ServiceConnection serviceConnection;
        c cVar = new c();
        cVar.mContext = this.mContext;
        try {
            Intent intent = new Intent();
            intent.setAction("com.hihonor.id.HnOaIdService");
            intent.setPackage("com.hihonor.id");
            if (c.isAdvertisingIdAvailable(this.mContext) && this.mContext.bindService(intent, this.serviceConnection, 1)) {
                try {
                    try {
                        cVar.aUF = new c.C0743c();
                        com.kwad.sdk.core.e.b.b.a aVar = new com.kwad.sdk.core.e.b.b.a(this.mLinkedBlockingQueue.take());
                        aVar.a(cVar.aUG);
                        aVar.b(cVar.aUH);
                        cVar.mCountDownLatch.await(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS, TimeUnit.MICROSECONDS);
                        context = this.mContext;
                        serviceConnection = this.serviceConnection;
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", e);
                        context = this.mContext;
                        serviceConnection = this.serviceConnection;
                    }
                    context.unbindService(serviceConnection);
                } catch (Throwable th) {
                    this.mContext.unbindService(this.serviceConnection);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", "getOAID honor service not found" + th2);
        }
        return cVar.aUF;
    }

    public final String getOAID() {
        String string;
        try {
            string = Settings.Global.getString(this.mContext.getContentResolver(), "oaid");
            try {
                if (TextUtils.isEmpty(string)) {
                    string = Settings.Secure.getString(this.mContext.getContentResolver(), "oaid");
                }
                com.kwad.sdk.core.d.c.i("HONORDeviceIDHelper", "getOAID secure: " + string);
            } catch (Throwable th) {
                th = th;
                com.kwad.sdk.core.d.c.printStackTrace(th);
            }
        } catch (Throwable th2) {
            th = th2;
            string = "";
        }
        if (string != null && !string.isEmpty()) {
            return string;
        }
        c.C0743c c0743cMP = MP();
        return c0743cMP != null ? c0743cMP.id : "";
    }
}
