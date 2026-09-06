package com.miui.zeus.mimo.sdk.ad.binder;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.miui.zeus.mimo.msa.IBinderViewCallBack;
import com.miui.zeus.mimo.msa.IRemoteAdViewService;
import ijiami_1011.NCall;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class RemoteAdViewProxy {
    public Context b;
    public IRemoteAdViewService c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f5295a = new Object();
    public final ServiceConnection d = new a();

    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            NCall.IV(new Object[]{9, this, componentName, iBinder});
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            NCall.IV(new Object[]{10, this, componentName});
        }
    }

    public RemoteAdViewProxy(Context context) {
        this.b = context;
    }

    public final boolean a() {
        return NCall.IZ(new Object[]{11, this});
    }

    public final boolean a(Context context) {
        return NCall.IZ(new Object[]{12, this, context});
    }

    public boolean a(IBinderViewCallBack iBinderViewCallBack) {
        return NCall.IZ(new Object[]{13, this, iBinderViewCallBack});
    }

    public final boolean b() {
        return NCall.IZ(new Object[]{14, this});
    }
}
