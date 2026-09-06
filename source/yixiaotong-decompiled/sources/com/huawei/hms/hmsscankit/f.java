package com.huawei.hms.hmsscankit;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.util.Log;
import com.huawei.hms.common.Preconditions;
import com.huawei.hms.feature.dynamic.DynamicModule;
import com.huawei.hms.hmsscankit.api.IRemoteCreator;
import com.huawei.hms.scankit.p.k3;
import com.huawei.hms.scankit.p.x3;
import com.stub.StubApp;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: RemoteViewInitializer.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Context f4126a;

    private static int a(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getInt("huawei_module_scankit_local", Integer.MAX_VALUE);
        } catch (PackageManager.NameNotFoundException unused) {
            x3.b("exception", "NameNotFoundException");
            return Integer.MAX_VALUE;
        }
    }

    public static void b(Context context) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        context.getClassLoader().loadClass("com.huawei.hms.feature.DynamicModuleInitializer").getDeclaredMethod("initializeModule", Context.class).invoke(null, context);
    }

    static IRemoteCreator c(Context context) {
        Preconditions.checkNotNull(context);
        try {
            Context contextE = e(context);
            if (contextE == null) {
                return null;
            }
            Object objNewInstance = contextE.getClassLoader().loadClass("com.huawei.hms.scankit.Creator").newInstance();
            if (objNewInstance instanceof IBinder) {
                return IRemoteCreator.Stub.asInterface((IBinder) objNewInstance);
            }
            return null;
        } catch (ClassNotFoundException unused) {
            x3.b("exception", "ClassNotFoundException");
            return null;
        } catch (IllegalAccessException unused2) {
            x3.b("exception", "IllegalAccessException");
            return null;
        } catch (InstantiationException unused3) {
            x3.b("exception", "InstantiationException");
            return null;
        } catch (NoSuchMethodException unused4) {
            x3.b("exception", "NoSuchMethodException");
            return null;
        } catch (InvocationTargetException unused5) {
            x3.b("exception", "InvocationTargetException");
            return null;
        }
    }

    static IRemoteCreator d(Context context) {
        Preconditions.checkNotNull(context);
        try {
            Object objNewInstance = context.getClassLoader().loadClass("com.huawei.hms.scankit.Creator").newInstance();
            if (objNewInstance instanceof IBinder) {
                return IRemoteCreator.Stub.asInterface((IBinder) objNewInstance);
            }
        } catch (ClassNotFoundException unused) {
            x3.b("exception", "ClassNotFoundException");
        } catch (IllegalAccessException unused2) {
            x3.b("exception", "IllegalAccessException");
        } catch (InstantiationException unused3) {
            x3.b("exception", "InvocationTargetException");
        }
        return null;
    }

    public static Context e(Context context) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        Log.i("ScankitSDK", "ScankitSDK Version: SCAN2.9.0.300");
        b(context);
        if (f4126a != null) {
            Log.i("ScankitSDK", "context has been inited");
            return f4126a;
        }
        try {
            k3.f4293a = false;
            int remoteVersion = DynamicModule.getRemoteVersion(StubApp.getOrigApplicationContext(context.getApplicationContext()), "huawei_module_scankit");
            int iA = a(context);
            Log.i("ScankitSDK", "local Version: " + iA + " remote Version: " + remoteVersion);
            if (iA > remoteVersion) {
                b(context);
                return context;
            }
            k3.f4293a = true;
            k3.b = String.valueOf(remoteVersion);
            Log.i("ScankitSDK", "use remote scankit " + remoteVersion);
            f4126a = DynamicModule.load(StubApp.getOrigApplicationContext(context.getApplicationContext()), DynamicModule.PREFER_REMOTE, "huawei_module_scankit").getModuleContext();
            return f4126a;
        } catch (DynamicModule.LoadingException unused) {
            b(context);
            Log.w("ScankitSDK", "Remote Load exception");
            return context;
        } catch (ClassNotFoundException unused2) {
            Log.e("ScankitSDK", "ClassNotFoundException exception");
            b(context);
            return context;
        } catch (IllegalAccessException unused3) {
            Log.e("ScankitSDK", "IllegalAccessException exception");
            b(context);
            return context;
        } catch (NoSuchMethodException unused4) {
            Log.e("ScankitSDK", "NoSuchMethodException exception");
            b(context);
            return context;
        } catch (RuntimeException unused5) {
            Log.e("ScankitSDK", "other RuntimeException exception");
            b(context);
            return context;
        } catch (InvocationTargetException unused6) {
            Log.e("ScankitSDK", "InvocationTargetException exception");
            b(context);
            return context;
        } catch (Exception unused7) {
            Log.e("ScankitSDK", "Exception exception");
            b(context);
            return context;
        } catch (Throwable unused8) {
            Log.e("ScankitSDK", "Throwable exception");
            b(context);
            return context;
        }
    }
}
