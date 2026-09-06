package com.miui.zeus.mimo.sdk.server.cache;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import com.miui.systemAdSolution.cache.IMsaDiskLruCacheListener;
import com.miui.systemAdSolution.cache.IMsaDiskLruCacheService;
import ijiami_1011.NCall;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MsaDiskLruCacheProxyService {
    public final Context b;
    public IMsaDiskLruCacheService c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f5600a = new Object();
    public final ServiceConnection d = new a();

    /* JADX INFO: renamed from: com.miui.zeus.mimo.sdk.server.cache.MsaDiskLruCacheProxyService$2, reason: invalid class name */
    public class AnonymousClass2 extends IMsaDiskLruCacheListener.Stub {
        public final /* synthetic */ String val$fileName;

        public AnonymousClass2(String str) {
            this.val$fileName = str;
        }

        @Override // com.miui.systemAdSolution.cache.IMsaDiskLruCacheListener
        public int onCopyInput(ParcelFileDescriptor parcelFileDescriptor) {
            return NCall.II(new Object[]{409, this, parcelFileDescriptor});
        }
    }

    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            NCall.IV(new Object[]{415, this, componentName, iBinder});
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            NCall.IV(new Object[]{416, this, componentName});
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ File f5602a;
        public final /* synthetic */ ParcelFileDescriptor.AutoCloseOutputStream b;

        public b(MsaDiskLruCacheProxyService msaDiskLruCacheProxyService, File file, ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream) {
            this.f5602a = file;
            this.b = autoCloseOutputStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            NCall.IV(new Object[]{417, this});
        }
    }

    public MsaDiskLruCacheProxyService(Context context) {
        this.b = context;
    }

    public int a(String str) {
        return NCall.II(new Object[]{410, this, str});
    }

    public final boolean a() {
        return NCall.IZ(new Object[]{411, this});
    }

    public final boolean a(Context context) {
        return NCall.IZ(new Object[]{412, this, context});
    }

    public int b(String str) {
        return NCall.II(new Object[]{413, this, str});
    }

    public final boolean b() {
        return NCall.IZ(new Object[]{414, this});
    }
}
