package com.hihonor.id.router;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Handler f3721a = new Handler(Looper.getMainLooper());
    private static final ConcurrentHashMap b = new ConcurrentHashMap();
    public static final /* synthetic */ int c = 0;

    static Bundle a(Intent intent, ServiceConnection serviceConnection, int i, Executor executor) {
        Bundle bundle = new Bundle();
        bundle.putInt("routeFlags", i);
        bundle.putParcelable("routeServiceIntent", intent);
        ConcurrentHashMap concurrentHashMap = b;
        IBinder aVar = (IBinder) concurrentHashMap.get(serviceConnection);
        if (aVar == null) {
            aVar = executor == null ? new a(serviceConnection) : new b(executor, serviceConnection);
        }
        bundle.putBinder("routeServiceConnection", aVar);
        concurrentHashMap.put(serviceConnection, aVar);
        return bundle;
    }

    static Bundle a(ServiceConnection serviceConnection) {
        ConcurrentHashMap concurrentHashMap = b;
        IBinder iBinder = (IBinder) concurrentHashMap.get(serviceConnection);
        if (iBinder == null) {
            Log.e("Decorator", "Trying to unbind non-existent ServiceConnection. ");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putBinder("routeServiceConnection", iBinder);
        concurrentHashMap.remove(serviceConnection);
        return bundle;
    }

    static Intent a(Intent intent) {
        ComponentName component = intent.getComponent();
        if (component == null) {
            Log.e("Decorator", "Invalid componentName in intent. ");
            return null;
        }
        Intent intent2 = new Intent(intent);
        intent2.putExtra("routePlugin", component.getPackageName());
        intent2.putExtra("routeActivity", component.getClassName());
        intent2.setComponent(new ComponentName("com.hihonor.id", "com.hihonor.id.router.RouterActivity"));
        return intent2;
    }

    static Uri a(Uri uri) {
        String authority = uri.getAuthority();
        if (authority == null) {
            return null;
        }
        return uri.buildUpon().authority("com.hihonor.id.router.routercontentprovider").appendQueryParameter("routeAuthority", authority).build();
    }
}
