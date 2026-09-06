package client.android.yixiaotong.util.retrofit;

import android.os.Process;
import client.android.yixiaotong.util.retrofit.android.AndroidLog;
import client.android.yixiaotong.util.retrofit.android.MainThreadExecutor;
import client.android.yixiaotong.util.retrofit.client.Client;
import client.android.yixiaotong.util.retrofit.client.OkClient;
import client.android.yixiaotong.util.retrofit.converter.Converter;
import client.android.yixiaotong.util.retrofit.converter.GsonConverter;
import com.google.gson.Gson;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
abstract class Platform {
    private static final Platform PLATFORM = findPlatform();

    /* JADX INFO: renamed from: client.android.yixiaotong.util.retrofit.Platform$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static Platform get() {
        return PLATFORM;
    }

    abstract Executor defaultCallbackExecutor();

    abstract Client.Provider defaultClient();

    abstract Converter defaultConverter();

    abstract Executor defaultHttpExecutor();

    abstract RestAdapter.Log defaultLog();

    Platform() {
    }

    private static Platform findPlatform() {
        AnonymousClass1 anonymousClass1 = null;
        try {
            Class.forName("android.os.Build");
            return new Android(anonymousClass1);
        } catch (ClassNotFoundException unused) {
            return new Base(anonymousClass1);
        }
    }

    private static class Base extends Platform {
        private Base() {
        }

        /* synthetic */ Base(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // client.android.yixiaotong.util.retrofit.Platform
        Converter defaultConverter() {
            return new GsonConverter(new Gson());
        }

        @Override // client.android.yixiaotong.util.retrofit.Platform
        Client.Provider defaultClient() {
            final Client clientInstantiate = OkClientInstantiator.instantiate();
            return new Client.Provider() { // from class: client.android.yixiaotong.util.retrofit.Platform.Base.1
                @Override // client.android.yixiaotong.util.retrofit.client.Client.Provider
                public Client get() {
                    return clientInstantiate;
                }
            };
        }

        @Override // client.android.yixiaotong.util.retrofit.Platform
        Executor defaultHttpExecutor() {
            return Executors.newCachedThreadPool(new ThreadFactory() { // from class: client.android.yixiaotong.util.retrofit.Platform.Base.2
                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(final Runnable runnable) {
                    return new Thread(new Runnable() { // from class: client.android.yixiaotong.util.retrofit.Platform.Base.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Thread.currentThread().setPriority(1);
                            runnable.run();
                        }
                    }, "Retrofit-Idle");
                }
            });
        }

        @Override // client.android.yixiaotong.util.retrofit.Platform
        Executor defaultCallbackExecutor() {
            return new Utils.SynchronousExecutor();
        }

        @Override // client.android.yixiaotong.util.retrofit.Platform
        RestAdapter.Log defaultLog() {
            return new RestAdapter.Log() { // from class: client.android.yixiaotong.util.retrofit.Platform.Base.3
                @Override // client.android.yixiaotong.util.retrofit.RestAdapter.Log
                public void log(String str) {
                    System.out.println(str);
                }
            };
        }
    }

    private static class Android extends Platform {
        private Android() {
        }

        /* synthetic */ Android(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // client.android.yixiaotong.util.retrofit.Platform
        Converter defaultConverter() {
            return new GsonConverter(new Gson());
        }

        @Override // client.android.yixiaotong.util.retrofit.Platform
        Client.Provider defaultClient() {
            final Client clientInstantiate = OkClientInstantiator.instantiate();
            return new Client.Provider() { // from class: client.android.yixiaotong.util.retrofit.Platform.Android.1
                @Override // client.android.yixiaotong.util.retrofit.client.Client.Provider
                public Client get() {
                    return clientInstantiate;
                }
            };
        }

        @Override // client.android.yixiaotong.util.retrofit.Platform
        Executor defaultHttpExecutor() {
            return Executors.newCachedThreadPool(new ThreadFactory() { // from class: client.android.yixiaotong.util.retrofit.Platform.Android.2
                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(final Runnable runnable) {
                    return new Thread(new Runnable() { // from class: client.android.yixiaotong.util.retrofit.Platform.Android.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Process.setThreadPriority(10);
                            runnable.run();
                        }
                    }, "Retrofit-Idle");
                }
            });
        }

        @Override // client.android.yixiaotong.util.retrofit.Platform
        Executor defaultCallbackExecutor() {
            return new MainThreadExecutor();
        }

        @Override // client.android.yixiaotong.util.retrofit.Platform
        RestAdapter.Log defaultLog() {
            return new AndroidLog("Retrofit");
        }
    }

    private static class OkClientInstantiator {
        private OkClientInstantiator() {
        }

        static Client instantiate() {
            return new OkClient();
        }
    }
}
