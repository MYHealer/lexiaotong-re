package com.opos.mobad.f;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.opos.mobad.service.DownloadService;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile c f6897a = null;
    private static final byte[] b = new byte[0];
    private static int g = 3;
    private static boolean h = true;
    private Messenger c;
    private Context d;
    private h k;
    private ConcurrentHashMap<String, com.opos.mobad.f.b.a> e = new ConcurrentHashMap<>();
    private List<com.opos.mobad.f.b.a> f = new CopyOnWriteArrayList();
    private boolean i = false;
    private int j = 0;
    private Messenger l = new Messenger(new Handler(Looper.getMainLooper()) { // from class: com.opos.mobad.f.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null || message.getData() == null) {
                return;
            }
            Bundle data = message.getData();
            int i = message.what;
            int i2 = data.getInt("key_percent");
            String string = data.getString("key_server_url");
            switch (i) {
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                case 107:
                    c.this.a(i, i2, string);
                    break;
                case 106:
                    c.this.a(i, i2, string, data.getString("key_error_code"));
                    break;
            }
        }
    });
    private ServiceConnection m = new ServiceConnection() { // from class: com.opos.mobad.f.c.2
        private void a() {
            for (com.opos.mobad.f.b.a aVar : new ArrayList(c.this.e.values())) {
                if (aVar.f == 102 || aVar.f == 107) {
                    c.this.a(aVar);
                }
            }
        }

        private void b() {
            com.opos.cmn.an.f.a.b("DownloaderMgr", "addDownloaderDelay mDelayDownloadTaskList size:" + c.this.f.size());
            try {
                if (c.this.f == null || c.this.f.size() <= 0) {
                    return;
                }
                com.opos.mobad.f.b.a[] aVarArr = (com.opos.mobad.f.b.a[]) c.this.f.toArray(new com.opos.mobad.f.b.a[c.this.f.size()]);
                c.this.f.removeAll(Arrays.asList(aVarArr));
                for (com.opos.mobad.f.b.a aVar : aVarArr) {
                    c.this.a(aVar);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("DownloaderMgr", "addDownloaderDelay error", e);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.opos.cmn.an.f.a.b("DownloaderMgr", "onServiceConnected");
            c.this.c = new Messenger(iBinder);
            b();
            a();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            com.opos.cmn.an.f.a.b("DownloaderMgr", "onServiceDisconnected");
            c.this.c = null;
            if (c.a(c.this) < 3) {
                c.this.d();
            }
        }
    };

    private c(Context context) {
        this.d = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    static /* synthetic */ int a(c cVar) {
        int i = cVar.j;
        cVar.j = i + 1;
        return i;
    }

    public static c a(Context context) {
        c cVar = f6897a;
        if (cVar == null) {
            synchronized (b) {
                cVar = f6897a;
                if (cVar == null) {
                    cVar = new c(context);
                    f6897a = cVar;
                }
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, String str) {
        a(i, i2, str, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, String str, String str2) {
        ConcurrentHashMap<String, com.opos.mobad.f.b.a> concurrentHashMap;
        com.opos.mobad.f.b.a aVar;
        com.opos.cmn.an.f.a.b("DownloaderMgr", "client status:" + i + ",percent:" + i2 + ",url:" + str);
        if (TextUtils.isEmpty(str) || (concurrentHashMap = this.e) == null || (aVar = concurrentHashMap.get(str)) == null) {
            return;
        }
        switch (i) {
            case 101:
                aVar.f = 101;
                aVar.g = i2;
                if (aVar.e == null || aVar.e.size() <= 0) {
                    return;
                }
                for (f fVar : aVar.e) {
                    if (fVar != null) {
                        fVar.a(i, i2, str, aVar.b);
                    }
                }
                return;
            case 102:
                aVar.f = 102;
                aVar.g = i2;
                if (aVar.e == null || aVar.e.size() <= 0) {
                    return;
                }
                for (f fVar2 : aVar.e) {
                    if (fVar2 != null) {
                        fVar2.b(i, i2, str, aVar.b);
                    }
                }
                return;
            case 103:
                aVar.f = 103;
                aVar.g = i2;
                if (aVar.e == null || aVar.e.size() <= 0) {
                    return;
                }
                for (f fVar3 : aVar.e) {
                    if (fVar3 != null) {
                        fVar3.d(i, i2, str, aVar.b);
                    }
                }
                return;
            case 104:
                aVar.f = 104;
                aVar.g = i2;
                if (aVar.e != null && aVar.e.size() > 0) {
                    for (f fVar4 : aVar.e) {
                        if (fVar4 != null) {
                            fVar4.e(i, i2, str, aVar.b);
                        }
                    }
                    aVar.e.clear();
                }
                break;
            case 105:
                aVar.f = 105;
                aVar.g = i2;
                if (aVar.e != null && aVar.e.size() > 0) {
                    for (f fVar5 : aVar.e) {
                        if (fVar5 != null) {
                            fVar5.f(i, i2, str, aVar.b);
                        }
                    }
                }
                break;
            case 106:
                aVar.f = 106;
                aVar.g = i2;
                if (aVar.e == null || aVar.e.size() <= 0) {
                    return;
                }
                for (f fVar6 : aVar.e) {
                    if (fVar6 != null) {
                        fVar6.a(i, i2, str, aVar.b, str2);
                    }
                }
                return;
            case 107:
                aVar.f = 107;
                aVar.g = i2;
                if (aVar.e == null || aVar.e.size() <= 0) {
                    return;
                }
                for (f fVar7 : aVar.e) {
                    if (fVar7 != null) {
                        fVar7.c(i, i2, str, aVar.b);
                    }
                }
                return;
            default:
                return;
        }
        this.e.remove(str);
    }

    private static final void a(int i, boolean z) {
        g = i;
        h = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.opos.mobad.f.b.a aVar) {
        boolean zA = (aVar == null || com.opos.cmn.an.d.a.a(aVar.d) || com.opos.cmn.an.d.a.a(aVar.b)) ? false : a(aVar.d, aVar.b, aVar.c, aVar.f6896a);
        com.opos.cmn.an.f.a.b("DownloaderMgr", "addDownloader result:" + zA + ", downloadData:" + aVar);
        return zA;
    }

    private boolean a(String str, String str2, String str3, String str4) {
        boolean z;
        com.opos.cmn.an.f.a.b("DownloaderMgr", "addDownloader pkgName:" + str2 + ",url:" + str + ",md5:" + str3 + ",appName:" + str4);
        if (com.opos.cmn.an.d.a.a(str) || com.opos.cmn.an.d.a.a(str2) || this.c == null) {
            z = false;
        } else {
            try {
                Message messageObtain = Message.obtain();
                z = true;
                messageObtain.what = 1;
                Bundle bundle = new Bundle();
                bundle.putString("key_url", str);
                bundle.putString("key_pkg_name", str2);
                if (!TextUtils.isEmpty(str3)) {
                    bundle.putString("key_apk_md5", str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    bundle.putString("key_app_name", str4);
                }
                messageObtain.setData(bundle);
                messageObtain.replyTo = this.l;
                this.c.send(messageObtain);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("DownloaderMgr", "", (Throwable) e);
                z = false;
            }
        }
        com.opos.cmn.an.f.a.b("DownloaderMgr", "addDownloader mUrlToDownloadDataMap:" + this.e.size());
        return z;
    }

    private void b() {
        boolean z;
        Iterator it = new ArrayList(this.e.values()).iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            }
            com.opos.mobad.f.b.a aVar = (com.opos.mobad.f.b.a) it.next();
            if (aVar.f == 102 || aVar.f == 107 || aVar.f == 101 || aVar.f == 106 || aVar.f == 103) {
                z = false;
                break;
            }
        }
        if (z) {
            c();
        }
        com.opos.cmn.an.f.a.b("DownloaderMgr", "unBindServiceIfNeed canUnbind:" + z);
    }

    private void c() {
        ServiceConnection serviceConnection;
        if (this.c != null) {
            try {
                Message messageObtain = Message.obtain();
                messageObtain.what = 7;
                messageObtain.replyTo = this.l;
                try {
                    this.c.send(messageObtain);
                } catch (RemoteException e) {
                    com.opos.cmn.an.f.a.b("DownloaderMgr", "", e);
                }
                Context context = this.d;
                if (context != null && (serviceConnection = this.m) != null) {
                    context.unbindService(serviceConnection);
                }
                this.c = null;
                com.opos.cmn.an.f.a.b("DownloaderMgr", "task download mgr ,unBindService");
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("DownloaderMgr", "", (Throwable) e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Intent intent = new Intent(this.d, (Class<?>) DownloadService.class);
        intent.putExtra("key_action_type", 0);
        intent.putExtra("key_download_tasks", g);
        intent.putExtra("key_show_notification", h);
        intent.putExtra("key_resource_controller", this.k);
        this.d.startService(intent);
        this.d.bindService(intent, this.m, 1);
    }

    public void a() {
        try {
            if (this.d == null || this.m == null) {
                return;
            }
            c();
            ConcurrentHashMap<String, com.opos.mobad.f.b.a> concurrentHashMap = this.e;
            if (concurrentHashMap != null) {
                concurrentHashMap.clear();
            }
            List<com.opos.mobad.f.b.a> list = this.f;
            if (list != null) {
                list.clear();
            }
        } catch (Exception unused) {
        }
    }

    public void a(int i, boolean z, h hVar) {
        if (this.i) {
            return;
        }
        com.opos.cmn.an.f.a.b("DownloaderMgr", "set nums =" + i + ", show notification =" + z);
        a(i, z);
        this.k = hVar;
        this.i = true;
    }

    public void a(f fVar) {
        if (fVar != null) {
            for (com.opos.mobad.f.b.a aVar : this.e.values()) {
                if (aVar != null) {
                    aVar.b(fVar);
                    com.opos.cmn.an.f.a.b("DownloaderMgr", "removeDownloadListener");
                    return;
                }
            }
        }
    }

    public void a(String str) {
        com.opos.cmn.an.f.a.b("DownloaderMgr", "pauseDownloader url:" + str);
        if (com.opos.cmn.an.d.a.a(str) || this.c == null) {
            return;
        }
        try {
            Message messageObtain = Message.obtain();
            messageObtain.what = 2;
            Bundle bundle = new Bundle();
            bundle.putString("key_url", str);
            messageObtain.setData(bundle);
            this.c.send(messageObtain);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("DownloaderMgr", "", (Throwable) e);
        }
    }

    public void a(String str, String str2, String str3, String str4, f fVar) {
        com.opos.mobad.f.b.a aVar;
        if (com.opos.cmn.an.d.a.a(str) || com.opos.cmn.an.d.a.a(str2)) {
            return;
        }
        if (this.e.containsKey(str)) {
            aVar = this.e.get(str);
            if (aVar != null) {
                aVar.a(fVar);
            }
        } else {
            com.opos.mobad.f.b.a aVar2 = new com.opos.mobad.f.b.a(str, str4, str2, str3);
            aVar2.a(fVar);
            this.e.put(str, aVar2);
            aVar = aVar2;
        }
        if (this.c == null) {
            d();
            this.f.add(aVar);
        } else {
            a(aVar);
        }
        this.j = 0;
    }

    public int[] a(String str, String str2) {
        com.opos.mobad.f.b.a aVar;
        int[] iArr = new int[2];
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (aVar = this.e.get(str)) != null) {
            iArr[0] = aVar.f;
            iArr[1] = aVar.g;
        }
        com.opos.cmn.an.f.a.b("DownloaderMgr", "queryDownload status:" + iArr[0] + ",percent:" + iArr[1]);
        return iArr;
    }

    public void b(String str) {
        com.opos.cmn.an.f.a.b("DownloaderMgr", "cancelDownloader url:" + str);
        if (com.opos.cmn.an.d.a.a(str) || this.c == null) {
            return;
        }
        try {
            Message messageObtain = Message.obtain();
            messageObtain.what = 4;
            Bundle bundle = new Bundle();
            bundle.putString("key_url", str);
            messageObtain.setData(bundle);
            this.c.send(messageObtain);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("DownloaderMgr", "", (Throwable) e);
        }
    }

    public void c(String str) {
        com.opos.cmn.an.f.a.b("DownloaderMgr", "notifyInstallEvent pkgName:" + str);
        if (com.opos.cmn.an.d.a.a(str) || this.c == null) {
            return;
        }
        try {
            Message messageObtain = Message.obtain();
            messageObtain.what = 5;
            Bundle bundle = new Bundle();
            bundle.putString("key_pkg_name", str);
            messageObtain.setData(bundle);
            this.c.send(messageObtain);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("DownloaderMgr", "", (Throwable) e);
        }
        b();
    }
}
