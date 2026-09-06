package com.huawei.hms.feature.dynamic;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.common.util.Logger;
import com.stub.StubApp;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class DynamicModule {
    public static final int MODULE_INTER_ERROR = 3;
    public static final int MODULE_NEED_UPDATE = 2;
    public static final int MODULE_NORMAL = 0;
    public static final int MODULE_NOT_EXIST = 1;
    public static final int MODULE_NOT_PRESET_HSF = 5;
    public static final int MODULE_NOT_READY = 4;
    public static final int c = 256;
    public static final int d = -100;
    public static int i = 0;
    public static final int j = 1;
    public static final int k = 2;
    public static int l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f4007a;
    public static final VersionPolicy PREFER_REMOTE = new com.huawei.hms.feature.dynamic.e.e();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new com.huawei.hms.feature.dynamic.e.c();
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new com.huawei.hms.feature.dynamic.e.d();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new com.huawei.hms.feature.dynamic.e.e();
    public static final String b = "DynamicModule";
    public static final ThreadLocal<HashMap<String, Boolean>> e = new ThreadLocal<>();
    public static final ThreadLocal<HashMap<String, String>> f = new ThreadLocal<>();
    public static final ThreadLocal<HashMap<String, IDynamicLoader>> g = new ThreadLocal<>();
    public static final ThreadLocal<HashMap<String, ClassLoader>> h = new ThreadLocal<>();
    public static HashMap<String, Boolean> m = new HashMap<>();
    public static HashMap<String, Boolean> n = new HashMap<>();

    public static class DynamicLoaderClassLoader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static HashMap<String, ClassLoader> f4008a = new HashMap<>();

        public static ClassLoader getsClassLoader(String str) {
            return f4008a.get(str);
        }

        public static void setsClassLoader(String str, ClassLoader classLoader) {
            f4008a.put(str, classLoader);
        }
    }

    public static class LoadingException extends Exception {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Bundle f4009a;

        public LoadingException(String str) {
            super(str);
        }

        public LoadingException(String str, Bundle bundle) {
            super(str);
            this.f4009a = bundle;
        }

        public Bundle getBundle() {
            return this.f4009a;
        }
    }

    public interface VersionPolicy {
        Bundle getModuleInfo(Context context, String str) throws LoadingException;
    }

    public static class a extends HashMap<String, ClassLoader> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f4010a;
        public final /* synthetic */ ClassLoader b;

        public a(String str, ClassLoader classLoader) {
            this.f4010a = str;
            this.b = classLoader;
            put(str, classLoader);
        }
    }

    public static class b extends HashMap<String, ClassLoader> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f4011a;
        public final /* synthetic */ ClassLoader b;

        public b(String str, ClassLoader classLoader) {
            this.f4011a = str;
            this.b = classLoader;
            put(str, classLoader);
        }
    }

    public static class c implements Callable<Bundle> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f4012a;
        public final /* synthetic */ Bundle b;

        public c(Context context, Bundle bundle) {
            this.f4012a = context;
            this.b = bundle;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Bundle call() {
            try {
                return DynamicModule.queryHMSModuleBundle(this.f4012a, com.huawei.hms.feature.dynamic.b.e, this.b);
            } catch (Exception e) {
                Logger.w(DynamicModule.b, "Query provider error.", e);
                return new Bundle();
            }
        }
    }

    public static class d extends HashMap<String, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f4013a;

        public d(String str) {
            this.f4013a = str;
            put(str, true);
        }
    }

    public static class e extends HashMap<String, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f4014a;
        public final /* synthetic */ String b;

        public e(String str, String str2) {
            this.f4014a = str;
            this.b = str2;
            put(str, str2);
        }
    }

    public static class f extends HashMap<String, IDynamicLoader> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f4015a;
        public final /* synthetic */ IBinder b;

        public f(String str, IBinder iBinder) {
            this.f4015a = str;
            this.b = iBinder;
            put(str, IDynamicLoader.Stub.asInterface(iBinder));
        }
    }

    public static class g extends Exception {
        public g(String str) {
            super(str);
        }

        public /* synthetic */ g(String str, a aVar) {
            this(str);
        }
    }

    public DynamicModule(Context context) {
        this.f4007a = context;
    }

    public static int a(Context context, String str, Bundle bundle) throws Throwable {
        int i2;
        boolean zA;
        Bundle bundle2 = new Bundle();
        LoadingException loadingException = null;
        try {
            bundle2 = queryHMSModuleBundle(context, com.huawei.hms.feature.dynamic.b.e, bundle);
            i2 = bundle2.getInt("module_version");
            try {
                zA = a(str, bundle2.getInt(com.huawei.hms.feature.dynamic.b.z));
            } catch (LoadingException e2) {
                e = e2;
                Logger.w(b, "Get loader in HMS failed:" + e.getMessage());
                loadingException = e.getBundle() != null ? new LoadingException(e.getMessage(), e.getBundle()) : new LoadingException(e.getMessage());
                zA = false;
            } catch (Exception e3) {
                e = e3;
                Logger.w(b, "Get hms loader info failed:" + e.getMessage());
                zA = false;
            }
        } catch (LoadingException e4) {
            e = e4;
            i2 = 0;
        } catch (Exception e5) {
            e = e5;
            i2 = 0;
        }
        Bundle assetModuleInfo = AssetLoadManager.getAssetModuleInfo(context, com.huawei.hms.feature.dynamic.b.e);
        int i3 = assetModuleInfo.getInt(com.huawei.hms.feature.dynamic.b.m);
        String string = assetModuleInfo.getString("module_path");
        if (i2 == 0 && i3 == 0) {
            Logger.w(b, "No available dynamic loader in HMS and asset.");
            if (loadingException == null) {
                return 0;
            }
            throw loadingException;
        }
        String str2 = b;
        Logger.i(str2, "HMS loader version:" + i2 + ", asset loader version:" + i3);
        if (i2 <= i3) {
            Logger.i(str2, "Choose dynamicLoader in asset.");
            bundle.putString("loader_path", string);
            bundle.putInt("loader_version", i3);
            return i3;
        }
        Logger.i(str2, "Choose dynamicLoader in HMS.");
        if (zA) {
            Logger.i(str2, "Need to copy HMS dynamicLoader to local dir.");
            ModuleCopy.copyModule(context, bundle2);
        }
        String string2 = bundle2.getString("module_path");
        if (TextUtils.isEmpty(string2) || !new File(string2).exists()) {
            Logger.i(str2, "HMS dynamicloader is not available, choose assets loader as default.");
            bundle.putString("loader_path", string);
            bundle.putInt("loader_version", i3);
        } else {
            bundle.putString("loader_path", string2);
            bundle.putInt("loader_version", i2);
        }
        return i2;
    }

    public static int a(VersionPolicy versionPolicy) {
        if (versionPolicy instanceof com.huawei.hms.feature.dynamic.e.e) {
            return 1;
        }
        if (versionPolicy instanceof com.huawei.hms.feature.dynamic.e.d) {
            return 2;
        }
        return versionPolicy instanceof com.huawei.hms.feature.dynamic.e.c ? 3 : 0;
    }

    public static Context a(Context context, String str, Bundle bundle, IDynamicLoader iDynamicLoader) throws LoadingException {
        try {
            IObjectWrapper iObjectWrapperLoad = iDynamicLoader.load(ObjectWrapper.wrap(context), str, bundle.getInt("module_version"), ObjectWrapper.wrap(bundle));
            Object objUnwrap = ObjectWrapper.unwrap(iObjectWrapperLoad);
            if (objUnwrap == null) {
                Logger.w(b, "Get remote context is null, module:" + str);
                return null;
            }
            if (objUnwrap instanceof Context) {
                Logger.i(b, "Get context for module:" + str + " success.");
                return (Context) objUnwrap;
            }
            if (objUnwrap instanceof Bundle) {
                Logger.i(b, "Get module info bundle for " + str);
                return a(context, str, bundle, iDynamicLoader, (Bundle) objUnwrap);
            }
            if (!objUnwrap.getClass().getName().equals(LoadingException.class.getName())) {
                Logger.w(b, "Get remote context is null, module:" + str);
                return null;
            }
            Bundle bundle2 = (Bundle) ObjectWrapper.unwrap(iObjectWrapperLoad).getClass().getDeclaredMethod("getBundle", new Class[0]).invoke(ObjectWrapper.unwrap(iObjectWrapperLoad), new Object[0]);
            Logger.w(b, "Successfully get the bundle in exception.");
            throw new LoadingException("Failed to load, please check the bundle in exception.", bundle2);
        } catch (LoadingException e2) {
            throw e2;
        } catch (Exception e3) {
            Logger.w(b, "Failed to get module context for:" + str, e3);
            return null;
        }
    }

    public static Context a(Context context, String str, Bundle bundle, IDynamicLoader iDynamicLoader, Bundle bundle2) throws LoadingException {
        Object objUnwrap;
        bundle.putInt("version_strategy_type", 4);
        if (AssetLoadManager.getAssetModuleInfo(context, str).getInt(com.huawei.hms.feature.dynamic.b.m, 0) <= 0) {
            Logger.i(b, "No fallback module in assets.");
            throw new LoadingException("Load exception, please check the bundle in exception.", bundle2);
        }
        try {
            objUnwrap = ObjectWrapper.unwrap(iDynamicLoader.load(ObjectWrapper.wrap(context), str, bundle.getInt("module_version"), ObjectWrapper.wrap(bundle)));
        } catch (RemoteException e2) {
            Logger.w(b, "tryWithAssetsModule RemoteException.", e2);
            objUnwrap = null;
        }
        if (objUnwrap instanceof Context) {
            Logger.i(b, "get dynamic module context for:" + str + " from assets fallback success.");
            return (Context) objUnwrap;
        }
        Logger.w(b, "tryWithAssetsModule get dynamicContext failed: null or wrong type.");
        throw new LoadingException("Load exception, please check the bundle in exception.", bundle2);
    }

    public static Bundle a(Context context, Bundle bundle) throws g {
        a aVar = null;
        try {
            ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
            FutureTask futureTask = new FutureTask(new c(context, bundle));
            executorServiceNewSingleThreadExecutor.execute(futureTask);
            Bundle bundle2 = (Bundle) futureTask.get(l, TimeUnit.MILLISECONDS);
            String string = bundle2.getString("loader_path");
            if (TextUtils.isEmpty(string) || !new File(string).exists()) {
                Logger.w(b, "The loader_path:" + string + " is not available.");
                throw new g("The loader_path in queryBundle is empty or not exist.", aVar);
            }
            Logger.i(b, "Query HMS module:huawei_module_dynamicloader info success.");
            return bundle2;
        } catch (TimeoutException unused) {
            Logger.w(b, "Query hms provider timeout: over " + l + " ms, choose the local loader fallback.");
            return new Bundle();
        } catch (Exception e2) {
            Logger.w(b, "FutureTask: query provider exception.", e2);
            throw new g("failed to get :huawei_module_dynamicloader info.", aVar);
        }
    }

    public static Bundle a(Context context, String str) throws LoadingException {
        boolean z = false;
        try {
            try {
                Class<?> clsA = a(context);
                Method declaredMethod = clsA.getDeclaredMethod("getsClassLoader", String.class);
                Method declaredMethod2 = clsA.getDeclaredMethod("setsClassLoader", String.class, ClassLoader.class);
                ClassLoader classLoader = (ClassLoader) declaredMethod.invoke(null, str);
                if (classLoader == null) {
                    try {
                        Logger.i(b, "No available cached loader, query remote.");
                        Bundle bundleB = b(context, str);
                        synchronized (DynamicModule.class) {
                            String str2 = (String) ((HashMap) Objects.requireNonNull(f.get())).get(str);
                            if (TextUtils.isEmpty(str2)) {
                                return bundleB;
                            }
                            com.huawei.hms.feature.dynamic.e.a aVar = new com.huawei.hms.feature.dynamic.e.a(str2, ClassLoader.getSystemClassLoader());
                            a(str, aVar);
                            declaredMethod2.invoke(null, str, aVar);
                            e.set(new d(str));
                            return bundleB;
                        }
                    } catch (g unused) {
                    }
                } else if (classLoader != ClassLoader.getSystemClassLoader()) {
                    Logger.i(b, "Cached loader is available, ready to use it.");
                    try {
                        a(str, classLoader);
                    } catch (LoadingException e2) {
                        Logger.w(b, "Get loader interface failed.", e2);
                    }
                    z = true;
                }
            } catch (LoadingException e3) {
                throw e3;
            }
        } catch (Exception e4) {
            Logger.w(b, "failed to load.", e4);
        }
        HashMap<String, Boolean> map = new HashMap<>();
        map.put(str, Boolean.valueOf(z));
        e.set(map);
        return new Bundle();
    }

    public static DynamicModule a(Context context, String str, VersionPolicy versionPolicy) throws LoadingException {
        Bundle moduleInfo = versionPolicy.getModuleInfo(context, str);
        if (moduleInfo.getInt("module_version") <= 0) {
            if (moduleInfo.getInt("local_module_version") <= 0) {
                throw new LoadingException("Query remote version and local version failed.");
            }
            Logger.i(b, "Remote version is invalid, use local context.");
            return new DynamicModule(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        }
        try {
            return c(context, str, moduleInfo);
        } catch (LoadingException e2) {
            Logger.w(b, "Failed to load remote module.", e2);
            if (getLocalVersion(context, str) <= 0) {
                throw e2;
            }
            Logger.d(b, "Local module version is valid, use local fallback.");
            return new DynamicModule(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        }
    }

    public static DynamicModule a(Context context, String str, VersionPolicy versionPolicy, Bundle bundle) throws LoadingException {
        int iA = a(versionPolicy);
        String string = bundle.getString("loader_path");
        Logger.i(b, "The loader path for module:" + str + " is:" + string + ", and versionType is:" + iA);
        if (TextUtils.isEmpty(string)) {
            throw new LoadingException("Cannot find a valid dynamic loader in HMS or local.");
        }
        Boolean bool = n.get(str);
        Boolean bool2 = m.get(str);
        bundle.putString("module_name", str);
        bundle.putInt("version_strategy_type", iA);
        bundle.putBoolean(com.huawei.hms.feature.dynamic.b.x, bool != null ? bool.booleanValue() : false);
        bundle.putBoolean(com.huawei.hms.feature.dynamic.b.y, bool2 != null ? bool2.booleanValue() : false);
        try {
            return b(context, str, bundle);
        } catch (LoadingException e2) {
            throw e2;
        } catch (Exception e3) {
            Logger.e(b, "Other exception,", e3);
            if (StubApp.getOrigApplicationContext(context.getApplicationContext()) != null) {
                context = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            return new DynamicModule(context);
        }
    }

    public static IDynamicInstall a(String str) throws LoadingException {
        if (str != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return IDynamicInstall.Stub.asInterface((IBinder) new com.huawei.hms.feature.dynamic.e.a(str, ClassLoader.getSystemClassLoader()).loadClass(com.huawei.hms.feature.dynamic.b.g).getConstructor(new Class[0]).newInstance(new Object[0]));
                }
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
                throw new LoadingException("getHMSDynamicInstaller: failed to instantiate dynamic loader:" + e2.getMessage());
            }
        }
        throw new LoadingException("Failed to get dynamicLoader path.");
    }

    public static IDynamicLoader a(Context context, String str, String str2, ClassLoader classLoader) {
        if (classLoader == null) {
            try {
                classLoader = new com.huawei.hms.feature.dynamic.e.a(str2, ClassLoader.getSystemClassLoader());
                h.set(new b(str, classLoader));
            } catch (Exception e2) {
                Logger.w(b, "Get iDynamicLoader failed.", e2);
                return null;
            }
        }
        return IDynamicLoader.Stub.asInterface((IBinder) classLoader.loadClass(com.huawei.hms.feature.dynamic.b.f).getConstructor(new Class[0]).newInstance(new Object[0]));
    }

    public static Class<?> a(Context context) throws LoadingException {
        Class<?> clsLoadClass;
        try {
            if (StubApp.getOrigApplicationContext(context.getApplicationContext()) != null) {
                context = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            clsLoadClass = context.getClassLoader().loadClass(DynamicLoaderClassLoader.class.getName());
        } catch (ClassNotFoundException unused) {
            Logger.w(b, "ClassLoader class not found when use client context.");
            clsLoadClass = null;
        }
        if (clsLoadClass == null) {
            try {
                clsLoadClass = ((ClassLoader) Objects.requireNonNull(DynamicModule.class.getClassLoader())).loadClass(DynamicLoaderClassLoader.class.getName());
                if (clsLoadClass == null) {
                    throw new LoadingException("ClassLoader class is null.");
                }
            } catch (ClassNotFoundException unused2) {
                throw new LoadingException("ClassLoader class not found when use DynamicModule's classLoader.");
            }
        }
        return clsLoadClass;
    }

    public static void a(Context context, VersionPolicy versionPolicy, String str, Bundle bundle) throws LoadingException {
        if (context == null || versionPolicy == null || str == null || str.length() == 0 || str.length() > 256 || bundle == null) {
            throw new LoadingException("Null param, please check it.");
        }
    }

    public static void a(String str, ClassLoader classLoader) throws LoadingException {
        try {
            g.set(new f(str, (IBinder) classLoader.loadClass(com.huawei.hms.feature.dynamic.b.f).getConstructor(new Class[0]).newInstance(new Object[0])));
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            throw new LoadingException("Failed to get loader interface:" + e2.getMessage());
        }
    }

    public static boolean a(String str, int i2) {
        if (i2 == 1) {
            Boolean bool = n.get(str);
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        }
        if (i2 != 2) {
            return i2 == 3 || i2 == 4;
        }
        Boolean bool2 = m.get(str);
        if (bool2 != null) {
            return bool2.booleanValue();
        }
        return false;
    }

    public static Bundle b(Context context, String str) throws g, LoadingException {
        try {
            Bundle bundleQueryHMSModuleBundle = queryHMSModuleBundle(context, str);
            String string = bundleQueryHMSModuleBundle.getString("loader_path");
            if (!TextUtils.isEmpty(string) && new File(string).exists()) {
                f.set(new e(str, string));
                Logger.i(b, "Query remote version by module name:" + str + " success.");
                return bundleQueryHMSModuleBundle;
            }
            Logger.w(b, "The loader_path:" + string + " in query bundle is not available,change the module version to:-100");
            bundleQueryHMSModuleBundle.putInt("module_version", -100);
            return bundleQueryHMSModuleBundle;
        } catch (LoadingException e2) {
            throw e2;
        } catch (Exception unused) {
            throw new g("failed to Query remote version.", null);
        }
    }

    public static DynamicModule b(Context context, VersionPolicy versionPolicy, String str, Bundle bundle) throws Throwable {
        a(context, versionPolicy, str, bundle);
        try {
            int iA = a(context, str, bundle);
            if (iA >= 10015300) {
                Logger.i(b, "Load start in new-version-policy.");
                return a(context, str, versionPolicy, bundle);
            }
            if (iA <= 0) {
                throw new LoadingException("Cannot find a valid dynamicLoader in HMS and local.");
            }
            Logger.i(b, "Load start in old-version-policy.");
            return a(context, str, versionPolicy);
        } catch (LoadingException e2) {
            throw e2;
        } catch (Exception e3) {
            Logger.e(b, "Other exception:" + e3);
            throw new LoadingException("Load failed.");
        }
    }

    public static DynamicModule b(Context context, String str, Bundle bundle) throws LoadingException {
        ClassLoader classLoader;
        synchronized (DynamicModule.class) {
            ThreadLocal<HashMap<String, ClassLoader>> threadLocal = h;
            if (threadLocal.get() == null || threadLocal.get().get(str) == null) {
                Logger.i(b, "No available cached loader for module:" + str);
                classLoader = null;
            } else {
                Logger.i(b, "Cached loader for module is available, ready to use it.");
                classLoader = threadLocal.get().get(str);
            }
        }
        IDynamicLoader iDynamicLoaderA = a(context, str, bundle.getString("loader_path"), classLoader);
        if (iDynamicLoaderA == null) {
            throw new LoadingException("Failed to get iDynamicLoader: null.");
        }
        if (StubApp.getOrigApplicationContext(context.getApplicationContext()) != null) {
            context = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        Context contextA = a(context, str, bundle, iDynamicLoaderA);
        if (contextA != null) {
            return new DynamicModule(contextA);
        }
        throw new LoadingException("New version policy: Failed to get module context: null.");
    }

    public static IDynamicInstall b(Context context) throws LoadingException {
        int i2;
        String string = null;
        int localVersion = 0;
        try {
            Bundle bundleA = a(context, (Bundle) null);
            string = bundleA.getString("loader_path");
            i2 = bundleA.getInt("loader_version");
        } catch (Exception e2) {
            Logger.w(b, "Cannot get remote HMS dynamicLoader.", e2);
            i2 = 0;
        }
        try {
            localVersion = getLocalVersion(context, com.huawei.hms.feature.dynamic.b.e);
        } catch (Exception e3) {
            Logger.w(b, "Cannot find local dynamicLoader fallback.", e3);
        }
        String str = b;
        Logger.i(str, "DynamicLoader remoteHMSVersion:" + i2 + ", hmsLoaderPath:" + string + ", localLoaderVersion:" + localVersion);
        int i3 = i2 > localVersion ? i2 : localVersion;
        if (i3 <= 10009300) {
            Logger.w(str, "The current version:" + i3 + " is too low.");
            throw new LoadingException("The loader version:" + i3 + " is too low to support HFF.");
        }
        if (i2 > localVersion) {
            Logger.i(str, "Choose hms dynamicLoader: " + string);
            i = 1;
            return a(string);
        }
        Logger.i(str, "Choose local dynamicLoader fallback: ");
        i = 2;
        return c(context);
    }

    public static DynamicModule c(Context context, String str, Bundle bundle) throws LoadingException {
        Boolean bool;
        IDynamicLoader iDynamicLoader;
        try {
            synchronized (DynamicModule.class) {
                bool = (Boolean) ((HashMap) Objects.requireNonNull(e.get())).get(str);
                iDynamicLoader = (IDynamicLoader) ((HashMap) Objects.requireNonNull(g.get())).get(str);
            }
            if (bool == null || iDynamicLoader == null) {
                throw new LoadingException("The loader for " + str + " was not prepared.");
            }
            if (StubApp.getOrigApplicationContext(context.getApplicationContext()) != null) {
                context = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            Context contextA = a(context, str, bundle, iDynamicLoader);
            if (contextA != null) {
                return new DynamicModule(contextA);
            }
            throw new LoadingException("Failed to get remote module context: null");
        } catch (LoadingException e2) {
            throw e2;
        } catch (Exception unused) {
            throw new LoadingException("Load Module Error.");
        }
    }

    public static IDynamicInstall c(Context context) throws LoadingException {
        try {
            return (IDynamicInstall) context.getClassLoader().loadClass(com.huawei.hms.feature.dynamic.b.g).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e2) {
            throw new LoadingException("getLocalLoaderFallback: failed to instantiate dynamic loader: " + e2.getMessage());
        }
    }

    public static void enable3rdPhone(String str, boolean z) {
        m.put(str, Boolean.valueOf(z));
    }

    public static void enableLowEMUI(String str, boolean z) {
        n.put(str, Boolean.valueOf(z));
    }

    public static Set<String> getInstalledModuleInfo() {
        return com.huawei.hms.feature.dynamic.d.a().f4029a;
    }

    public static Bundle getLocalModuleInfo(Context context, String str) {
        int localVersion = getLocalVersion(context, str);
        Bundle bundle = new Bundle();
        bundle.putString("module_name", str);
        bundle.putInt("local_module_version", localVersion);
        return bundle;
    }

    public static int getLocalVersion(Context context, String str) {
        if (context == null || str.length() == 0 || str.length() > 256) {
            Logger.e(b, "Invalid context or moduleName.");
            return 0;
        }
        try {
            String str2 = AssetLoadManager.d + str + ".ModuleDescriptor";
            if (StubApp.getOrigApplicationContext(context.getApplicationContext()) != null) {
                context = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            return context.getClassLoader().loadClass(str2).getDeclaredField("MODULE_VERSION").getInt(null);
        } catch (ClassNotFoundException unused) {
            Logger.w(b, "Cannot find the class of module descriptor for " + str);
            return 0;
        } catch (Exception e2) {
            Logger.w(b, "Get local module info failed.", e2);
            return 0;
        }
    }

    public static Bundle getRemoteModuleInfo(Context context, String str) throws LoadingException {
        try {
            synchronized (DynamicModule.class) {
                ThreadLocal<HashMap<String, Boolean>> threadLocal = e;
                if (threadLocal.get() == null || threadLocal.get().get(str) == null || !threadLocal.get().get(str).booleanValue()) {
                    Bundle bundleA = a(context, str);
                    if (bundleA.getInt("module_version") > 0) {
                        return bundleA;
                    }
                }
                if (threadLocal.get().get(str).booleanValue()) {
                    try {
                        return b(context, str);
                    } catch (g e2) {
                        Logger.w(b, "Query remote module info in HMS failed.", e2);
                    }
                }
                return new Bundle();
            }
        } catch (LoadingException e3) {
            throw e3;
        } catch (Exception e4) {
            Logger.w(b, "Get remote module info for " + str + " failed.", e4);
        }
    }

    public static int getRemoteVersion(Context context, String str) throws LoadingException {
        try {
            Bundle bundleB = b(context, str);
            if (bundleB != null && !bundleB.isEmpty()) {
                return bundleB.getInt("module_version");
            }
            Logger.w(b, "Query remote module:" + str + " info failed.");
            throw new LoadingException("Query remote module info failed: null or empty.");
        } catch (g e2) {
            Logger.w(b, "Query remote module:" + str + " exception:" + e2);
            return 0;
        }
    }

    public static void install(Context context, int i2) {
        if (context == null) {
            Logger.e(b, "The input context is null.");
            return;
        }
        try {
            l = i2;
            String str = b;
            Logger.i(str, "Query HMS provider timeOut is set to:" + l + " ms.");
            IDynamicInstall iDynamicInstallB = b(context);
            if (iDynamicInstallB == null) {
                throw new LoadingException("Get dynamicInstaller failed.");
            }
            Bundle bundleInstall = iDynamicInstallB.install(ObjectWrapper.wrap(context), new Bundle());
            if (bundleInstall == null) {
                throw new LoadingException("Get install info failed: moduleBundle is null.");
            }
            com.huawei.hms.feature.dynamic.d.a().a(bundleInstall);
            Logger.i(str, "Install module success.");
        } catch (RemoteException | LoadingException | NullPointerException e2) {
            if (i == 2 || getLocalVersion(context, com.huawei.hms.feature.dynamic.b.e) <= 0) {
                Logger.w(b, "Install module failed.", e2);
                return;
            }
            String str2 = b;
            Logger.i(str2, "Ready to use local loader-fallback to retry:");
            try {
                Bundle bundleInstall2 = c(context).install(ObjectWrapper.wrap(context), new Bundle());
                if (bundleInstall2 == null) {
                    throw new LoadingException("Retry: get install info failed: moduleBundle is null.");
                }
                com.huawei.hms.feature.dynamic.d.a().a(bundleInstall2);
                Logger.i(str2, "Retry install module with local loader-fallback success.");
            } catch (RemoteException | LoadingException | NullPointerException e3) {
                Logger.w(b, "Retry failed with local loader-fallback.", e3);
            }
        }
    }

    public static DynamicModule load(Context context, VersionPolicy versionPolicy, String str) throws LoadingException {
        return b(context, versionPolicy, str, new Bundle());
    }

    public static DynamicModule loadV2(Context context, VersionPolicy versionPolicy, String str) throws LoadingException {
        Bundle bundle = new Bundle();
        bundle.putString("loader_version_type", "v2");
        return b(context, versionPolicy, str, bundle);
    }

    public static DynamicModule loadV3(Context context, VersionPolicy versionPolicy, String str) throws LoadingException {
        return loadV3(context, versionPolicy, str, new Bundle());
    }

    public static DynamicModule loadV3(Context context, VersionPolicy versionPolicy, String str, Bundle bundle) throws LoadingException {
        bundle.putString("loader_version_type", com.huawei.hms.feature.dynamic.b.u);
        return b(context, versionPolicy, str, bundle);
    }

    public static Bundle queryHMSModuleBundle(Context context, String str) throws g, LoadingException {
        return queryHMSModuleBundle(context, str, null);
    }

    public static Bundle queryHMSModuleBundle(Context context, String str, Bundle bundle) throws g, LoadingException {
        a aVar = null;
        try {
            ContentResolver contentResolver = context.getContentResolver();
            if (contentResolver == null) {
                throw new g("Query remote version failed: null contentResolver.", aVar);
            }
            Bundle bundleCall = contentResolver.call(Uri.parse("content://com.huawei.hms"), str, (String) null, bundle);
            if (bundleCall == null) {
                Logger.w(b, "Failed to get bundle info:null.");
                throw new g("Query remote version failed: null bundle info.", aVar);
            }
            int i2 = bundleCall.getInt("errcode");
            String string = bundleCall.getString("loader_path");
            String str2 = b;
            Logger.i(str2, "bundle info: errorCode:" + i2 + ", moduleVersion:" + bundleCall.getInt("module_version") + ", modulePath:" + bundleCall.getString("module_path") + ", loader_version:" + bundleCall.getInt("loader_version") + ", loaderPath:" + string + ", armeabiType:" + bundleCall.getInt("armeabiType"));
            if (i2 == 0) {
                return bundleCall;
            }
            Logger.w(str2, "Failed to get " + str + " bundle info, errcode:" + i2);
            throw new LoadingException("Query " + str + " unavailable, errorCode:" + i2, bundleCall);
        } catch (LoadingException e2) {
            throw e2;
        } catch (Exception unused) {
            throw new g("failed to get :" + str + " info.", aVar);
        }
    }

    public final Context getModuleContext() {
        return this.f4007a;
    }
}
