package com.ubix.ssp.ad.e.v;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.br;
import com.ubix.ssp.ad.e.a0.k;
import com.ubix.ssp.open.AdError;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ExecutorService f8874a;
    public static c b;
    public static HandlerC1098c c;
    private static ConcurrentHashMap<Integer, CopyOnWriteArrayList<com.ubix.ssp.ad.e.v.b>> d = new ConcurrentHashMap<>();
    public static ConcurrentMap<Integer, d> e = new ConcurrentHashMap();

    class a implements ThreadFactory {
        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Ubix.ResourceDownloadThread");
        }
    }

    class b implements com.ubix.ssp.ad.e.v.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        com.ubix.ssp.ad.e.v.b f8876a;

        public b(com.ubix.ssp.ad.e.v.b bVar) {
            this.f8876a = bVar;
        }

        @Override // com.ubix.ssp.ad.e.v.b
        public void a(String str, AdError adError, String str2) {
            Message message = new Message();
            message.what = 200;
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            bundle.putSerializable(br.f.s, this.f8876a);
            bundle.putSerializable("error", adError);
            bundle.putSerializable("filePath", str2);
            message.setData(bundle);
            c.c.sendMessage(message);
        }

        @Override // com.ubix.ssp.ad.e.v.b
        public void a(String str, String str2) {
            Message message = new Message();
            message.what = 100;
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            bundle.putSerializable(br.f.s, this.f8876a);
            bundle.putSerializable("filePath", str2);
            message.setData(bundle);
            c.c.sendMessage(message);
        }
    }

    /* JADX INFO: renamed from: com.ubix.ssp.ad.e.v.c$c, reason: collision with other inner class name */
    public static class HandlerC1098c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        SoftReference<c> f8877a;

        public HandlerC1098c(c cVar) {
            super(Looper.getMainLooper());
            this.f8877a = new SoftReference<>(cVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bundle data;
            super.handleMessage(message);
            try {
                SoftReference<c> softReference = this.f8877a;
                if (softReference == null || softReference.get() == null || (data = message.getData()) == null) {
                    return;
                }
                com.ubix.ssp.ad.e.v.b bVar = (com.ubix.ssp.ad.e.v.b) data.getSerializable(br.f.s);
                String string = data.getString("url");
                String string2 = data.getString("filePath");
                int i = message.what;
                if (i == 100) {
                    c.e.remove(Integer.valueOf(string.hashCode()));
                    if (bVar != null) {
                        bVar.a(string, string2);
                    }
                    this.f8877a.get().a(string, string2);
                    return;
                }
                if (i != 200) {
                    return;
                }
                AdError adError = (AdError) data.getSerializable("error");
                c.e.remove(Integer.valueOf(string.hashCode()));
                if (bVar != null) {
                    bVar.a(string, adError, string2);
                }
                this.f8877a.get().a(string, adError, string2);
            } catch (Exception unused) {
            }
        }
    }

    c() {
        a();
        c = new HandlerC1098c(this);
    }

    private void a() {
        ExecutorService executorService = f8874a;
        if (executorService == null || executorService.isTerminated() || f8874a.isShutdown()) {
            f8874a = new ThreadPoolExecutor(3, 5, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, AdError adError, String str2) {
        int iHashCode = str.hashCode();
        try {
            synchronized (this) {
                try {
                    if (d.get(Integer.valueOf(iHashCode)) != null) {
                        CopyOnWriteArrayList<com.ubix.ssp.ad.e.v.b> copyOnWriteArrayList = d.get(Integer.valueOf(iHashCode));
                        if (copyOnWriteArrayList != null) {
                            for (com.ubix.ssp.ad.e.v.b bVar : copyOnWriteArrayList) {
                                if (bVar != null) {
                                    bVar.a(str, adError, str2);
                                }
                            }
                        }
                        d.remove(Integer.valueOf(iHashCode));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(String str, File file, com.ubix.ssp.ad.e.v.b bVar) {
        d dVar;
        d dVar2;
        try {
            int iHashCode = str.hashCode();
            ConcurrentMap<Integer, d> concurrentMap = e;
            if (concurrentMap == null || (dVar2 = concurrentMap.get(Integer.valueOf(iHashCode))) == null) {
                dVar = new d(str, new File(file.getPath() + ".download"), new b(bVar));
                e.put(Integer.valueOf(iHashCode), dVar);
            } else if (dVar2.a() == 2) {
                if (bVar != null) {
                    bVar.a(str, file.getPath());
                    return;
                }
                return;
            } else {
                if (dVar2.a() == 1) {
                    if (d.get(Integer.valueOf(iHashCode)) == null) {
                        CopyOnWriteArrayList<com.ubix.ssp.ad.e.v.b> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                        copyOnWriteArrayList.add(bVar);
                        d.put(Integer.valueOf(iHashCode), copyOnWriteArrayList);
                        return;
                    } else {
                        CopyOnWriteArrayList<com.ubix.ssp.ad.e.v.b> copyOnWriteArrayList2 = d.get(Integer.valueOf(iHashCode));
                        if (copyOnWriteArrayList2 != null) {
                            copyOnWriteArrayList2.add(bVar);
                            return;
                        }
                        return;
                    }
                }
                dVar = new d(str, new File(file.getPath() + ".download"), new b(bVar));
                e.put(Integer.valueOf(iHashCode), dVar);
            }
            f8874a.execute(dVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        int iHashCode = str.hashCode();
        try {
            synchronized (this) {
                try {
                    if (d.get(Integer.valueOf(iHashCode)) != null) {
                        CopyOnWriteArrayList<com.ubix.ssp.ad.e.v.b> copyOnWriteArrayList = d.get(Integer.valueOf(iHashCode));
                        if (copyOnWriteArrayList != null) {
                            for (com.ubix.ssp.ad.e.v.b bVar : copyOnWriteArrayList) {
                                if (bVar != null) {
                                    bVar.a(str, str2);
                                }
                            }
                        }
                        d.remove(Integer.valueOf(iHashCode));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static c b() {
        c cVar = b;
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        b = cVar2;
        return cVar2;
    }

    public void a(Context context, String str, int i, com.ubix.ssp.ad.e.v.b bVar) {
        File fileE;
        if (TextUtils.isEmpty(str)) {
            if (bVar != null) {
                bVar.a(str, com.ubix.ssp.ad.e.a0.a0.a.h(5, "图片资源链接异常"), null);
                return;
            }
            return;
        }
        if (i == 1) {
            fileE = k.e(context);
        } else {
            if (i != 2) {
                if (bVar != null) {
                    bVar.a(str, com.ubix.ssp.ad.e.a0.a0.a.h(5, "资源下载错误"), null);
                    return;
                }
                return;
            }
            fileE = k.f(context);
        }
        a(str, new File(fileE, str.hashCode() + ""), bVar);
    }
}
