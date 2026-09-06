package com.opos.mobad.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.widget.Toast;
import com.heytap.msp.mobad.api.R;
import com.huawei.openalliance.ad.constant.x;
import com.opos.mobad.f.h;
import com.stub.StubApp;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class DownloadService extends Service {
    private static AtomicInteger c;
    private static boolean f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f7317a;
    private com.opos.mobad.f.a.c b;
    private ConcurrentHashMap<String, com.opos.mobad.f.a.b> d = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, List<Messenger>> e = new ConcurrentHashMap<>();
    private AtomicBoolean g = new AtomicBoolean(false);
    private Messenger h = new Messenger(new Handler(Looper.getMainLooper()) { // from class: com.opos.mobad.service.DownloadService.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null || message.getData() == null) {
                return;
            }
            Bundle data = message.getData();
            String string = data.getString("key_url");
            String string2 = data.getString("key_pkg_name");
            com.opos.cmn.an.f.a.b(com.ubix.ssp.open.comm.DownloadService.TAG, "get message actionType:" + message.what + ",url:" + string + ",pkgName:" + string2);
            int i = message.what;
            if (i == 1) {
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                Messenger messenger = message.replyTo;
                String string3 = data.getString("key_apk_md5");
                String string4 = data.getString("key_app_name");
                DownloadService.this.a(messenger, string);
                DownloadService.this.a(string, string2, string3, string4);
                return;
            }
            if (i == 2) {
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                DownloadService.this.g(string);
                return;
            }
            if (i == 3) {
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                DownloadService.this.h(string);
            } else if (i == 4) {
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                DownloadService.this.i(string);
            } else if (i == 5) {
                DownloadService.this.f(string2);
            } else {
                if (i != 7) {
                    return;
                }
                DownloadService.this.a(message.replyTo);
            }
        }
    });
    private com.opos.mobad.f.a.InterfaceC0959a i = new com.opos.mobad.f.a.InterfaceC0959a() { // from class: com.opos.mobad.service.DownloadService.2
        private int a(long j, long j2) {
            if (j2 <= 0 || j <= 0) {
                return 0;
            }
            long j3 = (j * 100) / j2;
            if (j3 > 100) {
                return 100;
            }
            if (j3 < 0) {
                return 0;
            }
            return (int) j3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(com.opos.mobad.f.a.b bVar, String str) {
            DownloadService.this.b.a(bVar.c, new com.opos.mobad.f.a.c.a(bVar.f6887a, "", 106, 0, DownloadService.this.a(str), DownloadService.this.b(str), DownloadService.this.c(str)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(com.opos.mobad.f.a.b bVar, String str, long j, long j2, int i) {
            a(str, i);
            DownloadService.this.b.a(bVar.c, new com.opos.mobad.f.a.c.a(bVar.f6887a, ((((j * 100) / 1024) / 1024) / 100.0f) + "MB/" + ((((j2 * 100) / 1024) / 1024) / 100.0f) + "MB", 103, i, DownloadService.this.a(str), DownloadService.this.b(str), DownloadService.this.c(str)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(com.opos.mobad.f.a.b bVar, String str, String str2) {
            DownloadService.this.b.a(bVar.c, new com.opos.mobad.f.a.c.a(bVar.f6887a, "", 105, 0, DownloadService.this.d(str2), DownloadService.this.b(str), DownloadService.this.c(str)));
        }

        private void a(String str, int i) {
            com.opos.mobad.f.a.b bVar = (com.opos.mobad.f.a.b) DownloadService.this.d.get(str);
            if (bVar != null) {
                bVar.d = i;
            }
        }

        private void b(String str, int i) {
            com.opos.mobad.f.a.b bVar = (com.opos.mobad.f.a.b) DownloadService.this.d.get(str);
            if (bVar != null) {
                bVar.e = i;
            }
        }

        @Override // com.opos.mobad.f.a.InterfaceC0959a
        public void a(final String str) {
            final com.opos.mobad.f.a.b bVar;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a(str, 0);
            Toast.makeText(DownloadService.this.f7317a, DownloadService.this.f7317a.getResources().getString(R.string.download_toast_start_txt), 1).show();
            b(str, 101);
            if (DownloadService.this.b() && (bVar = (com.opos.mobad.f.a.b) DownloadService.this.d.get(str)) != null) {
                bVar.f.a(new Runnable() { // from class: com.opos.mobad.service.DownloadService.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DownloadService.this.b.a(bVar.c, new com.opos.mobad.f.a.c.a(bVar.f6887a, "", 107, 0, DownloadService.this.a(str), DownloadService.this.b(str), DownloadService.this.c(str)));
                    }
                }, com.opos.mobad.f.a.d.a.INIT_STATUS);
            }
            DownloadService.this.a(101, 0, str);
        }

        @Override // com.opos.mobad.f.a.InterfaceC0959a
        public void a(final String str, int i, long j, long j2) {
            com.opos.cmn.an.f.a.b(com.ubix.ssp.open.comm.DownloadService.TAG, "fail exception:" + i);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int iA = a(j, j2);
            Toast.makeText(DownloadService.this.f7317a, DownloadService.this.f7317a.getResources().getString(R.string.download_toast_fail_txt), 1).show();
            b(str, 106);
            if (DownloadService.this.b()) {
                a(str, iA);
                final com.opos.mobad.f.a.b bVar = (com.opos.mobad.f.a.b) DownloadService.this.d.get(str);
                if (bVar != null) {
                    bVar.f.a(new Runnable() { // from class: com.opos.mobad.service.DownloadService.2.5
                        @Override // java.lang.Runnable
                        public void run() {
                            a(bVar, str);
                        }
                    }, com.opos.mobad.f.a.d.a.FAILED_STATUS);
                }
            }
            DownloadService.this.a(106, iA, str, i + "");
        }

        @Override // com.opos.mobad.f.a.InterfaceC0959a
        public void a(String str, long j, long j2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            b(str, 107);
            DownloadService.this.a(107, a(j, j2), str);
        }

        @Override // com.opos.mobad.f.a.InterfaceC0959a
        public void a(final String str, final String str2) {
            com.opos.cmn.an.f.a.b(com.ubix.ssp.open.comm.DownloadService.TAG, "complete ");
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            Toast.makeText(DownloadService.this.f7317a, DownloadService.this.f7317a.getResources().getString(R.string.download_toast_downloaded_txt), 1).show();
            b(str, 105);
            if (DownloadService.this.b()) {
                a(str, 100);
                final com.opos.mobad.f.a.b bVar = (com.opos.mobad.f.a.b) DownloadService.this.d.get(str);
                if (bVar != null) {
                    bVar.f.a(new Runnable() { // from class: com.opos.mobad.service.DownloadService.2.6
                        @Override // java.lang.Runnable
                        public void run() {
                            a(bVar, str, str2);
                        }
                    }, com.opos.mobad.f.a.d.a.END_STATUS);
                }
            }
            DownloadService.this.a(105, 100, str);
            com.opos.mobad.f.b.b.a(DownloadService.this.f7317a, str2);
        }

        @Override // com.opos.mobad.f.a.InterfaceC0959a
        public void b(String str) {
            com.opos.cmn.an.f.a.b(com.ubix.ssp.open.comm.DownloadService.TAG, "onMobileNetworkAvailableAndChooseRetry url =" + str);
            com.opos.mobad.f.a.a(DownloadService.this.f7317a).a(str);
            Toast.makeText(DownloadService.this.f7317a, DownloadService.this.f7317a.getResources().getString(R.string.download_toast_in_mobile_txt), 1).show();
        }

        @Override // com.opos.mobad.f.a.InterfaceC0959a
        public void b(final String str, final long j, final long j2) {
            final com.opos.mobad.f.a.b bVar;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            final int iA = a(j, j2);
            b(str, 102);
            if (DownloadService.this.b() && (bVar = (com.opos.mobad.f.a.b) DownloadService.this.d.get(str)) != null) {
                int i = iA - bVar.d;
                if (i < 0) {
                    bVar.d = 0;
                }
                if (i > 1) {
                    a(str, iA);
                    com.opos.cmn.an.f.a.b(com.ubix.ssp.open.comm.DownloadService.TAG, "changePercent:" + i + ",notificationHelper.lastPercent:" + bVar.d);
                    bVar.f.a(new Runnable() { // from class: com.opos.mobad.service.DownloadService.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (bVar != null) {
                                DownloadService.this.b.a(bVar.c, new com.opos.mobad.f.a.c.a(bVar.f6887a, ((((j * 100) / 1024) / 1024) / 100.0f) + "MB/" + ((((j2 * 100) / 1024) / 1024) / 100.0f) + "MB", 102, iA, DownloadService.this.a(str), DownloadService.this.b(str), DownloadService.this.c(str)));
                            }
                        }
                    }, com.opos.mobad.f.a.d.a.PROGRESS_STATUS);
                }
            }
            DownloadService.this.a(102, iA, str);
        }

        @Override // com.opos.mobad.f.a.InterfaceC0959a
        public void c(final String str, final long j, final long j2) {
            final com.opos.mobad.f.a.b bVar;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            final int iA = a(j, j2);
            b(str, 103);
            if (DownloadService.this.b() && (bVar = (com.opos.mobad.f.a.b) DownloadService.this.d.get(str)) != null) {
                bVar.f.a(new Runnable() { // from class: com.opos.mobad.service.DownloadService.2.3
                    @Override // java.lang.Runnable
                    public void run() {
                        a(bVar, str, j, j2, iA);
                    }
                }, com.opos.mobad.f.a.d.a.PAUSED_STATUS);
            }
            DownloadService.this.a(103, iA, str);
        }

        @Override // com.opos.mobad.f.a.InterfaceC0959a
        public void d(String str, long j, long j2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int iA = a(j, j2);
            b(str, 104);
            if (DownloadService.this.b()) {
                a(str, iA);
                final com.opos.mobad.f.a.b bVar = (com.opos.mobad.f.a.b) DownloadService.this.d.get(str);
                if (bVar != null) {
                    bVar.f.a(new Runnable() { // from class: com.opos.mobad.service.DownloadService.2.4
                        @Override // java.lang.Runnable
                        public void run() {
                            DownloadService.this.b.a(bVar.c);
                        }
                    }, com.opos.mobad.f.a.d.a.END_STATUS);
                }
            }
            DownloadService.this.a(104, iA, str);
            DownloadService.this.e(str);
        }
    };

    static {
        StubApp.interface11(49829);
        c = new AtomicInteger(10000);
        f = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Intent a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(this.f7317a, (Class<?>) DownloadService.class);
        intent.setAction("key_download_action");
        intent.putExtra("key_action_type", 1);
        intent.putExtra("savePath", str);
        return intent;
    }

    private h a() {
        return com.opos.mobad.f.a.a(this.f7317a).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, String str) {
        a(i, i2, str, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, String str, String str2) {
        List<Messenger> list;
        ConcurrentHashMap<String, List<Messenger>> concurrentHashMap = this.e;
        if (concurrentHashMap == null || concurrentHashMap.size() <= 0 || TextUtils.isEmpty(str) || (list = this.e.get(str)) == null || list.size() <= 0) {
            return;
        }
        com.opos.cmn.an.f.a.b(com.ubix.ssp.open.comm.DownloadService.TAG, "service status :" + i + ",percent:" + i2 + ",url:" + str);
        Message messageObtain = Message.obtain();
        messageObtain.what = i;
        Bundle bundle = new Bundle();
        bundle.putInt("key_percent", i2);
        bundle.putString("key_server_url", str);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString("key_error_code", str2);
        }
        messageObtain.setData(bundle);
        for (Messenger messenger : list) {
            if (messenger != null) {
                if (messenger.getBinder() == null || !messenger.getBinder().isBinderAlive()) {
                    list.remove(messenger);
                } else {
                    try {
                        messenger.send(messageObtain);
                    } catch (RemoteException e) {
                        com.opos.cmn.an.f.a.b(com.ubix.ssp.open.comm.DownloadService.TAG, "", e);
                    }
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:50:0x00ec  */
    private void a(Intent intent) {
        int i;
        StringBuilder sb;
        ConcurrentHashMap<String, com.opos.mobad.f.a.b> concurrentHashMap;
        if (intent != null) {
            com.opos.cmn.an.f.a.b(com.ubix.ssp.open.comm.DownloadService.TAG, "handleNotificationIntent intent:" + intent);
            int intExtra = intent.getIntExtra("key_action_type", -1);
            com.opos.cmn.an.f.a.b(com.ubix.ssp.open.comm.DownloadService.TAG, "handleNotificationIntent action:" + intExtra);
            h hVar = null;
            String stringExtra = null;
            String stringExtra2 = null;
            hVar = null;
            if (intExtra == 0) {
                int intExtra2 = intent.getIntExtra("key_download_tasks", 3);
                boolean booleanExtra = intent.getBooleanExtra("key_show_notification", true);
                Serializable serializableExtra = intent.getSerializableExtra("key_resource_controller");
                if (serializableExtra != null && (serializableExtra instanceof h)) {
                    hVar = (h) serializableExtra;
                }
                a(intExtra2, hVar, booleanExtra);
                return;
            }
            if (intExtra == 1) {
                try {
                    stringExtra = intent.getStringExtra("savePath");
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.b(com.ubix.ssp.open.comm.DownloadService.TAG, "get extra fail", e);
                }
                if (TextUtils.isEmpty(stringExtra) || this.d == null) {
                    return;
                }
                com.opos.cmn.an.f.a.b(com.ubix.ssp.open.comm.DownloadService.TAG, "mUrlToDownloadDataMap size:" + this.d.size());
                com.opos.mobad.f.a.b bVar = this.d.get(stringExtra);
                if (bVar == null) {
                    com.opos.cmn.an.f.a.b(com.ubix.ssp.open.comm.DownloadService.TAG, "null == notificationHelper");
                    if (this.d.size() == 0) {
                        this.b.a();
                        return;
                    }
                    return;
                }
                i = bVar.e;
                if (103 == i) {
                    com.opos.mobad.f.a.a(this.f7317a).d(stringExtra);
                } else if (102 == i) {
                    com.opos.mobad.f.a.a(this.f7317a).b(stringExtra);
                } else if (106 == i) {
                    com.opos.mobad.f.a.a(this.f7317a).d(stringExtra);
                }
                sb = new StringBuilder("get ctrl bt and status is:");
            } else {
                if (intExtra != 2 && intExtra != 3) {
                    return;
                }
                com.opos.cmn.an.f.a.b(com.ubix.ssp.open.comm.DownloadService.TAG, "get sys delete" + intExtra);
                try {
                    stringExtra2 = intent.getStringExtra("savePath");
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.b(com.ubix.ssp.open.comm.DownloadService.TAG, "get extra fail", e2);
                }
                if (TextUtils.isEmpty(stringExtra2) || (concurrentHashMap = this.d) == null) {
                    return;
                }
                com.opos.mobad.f.a.b bVar2 = concurrentHashMap.get(stringExtra2);
                if (bVar2 == null) {
                    com.opos.cmn.an.f.a.b(com.ubix.ssp.open.comm.DownloadService.TAG, "null == notificationHelper");
                    if (this.d.size() == 0) {
                        this.b.a();
                        return;
                    }
                    return;
                }
                i = bVar2.e;
                if (105 == i) {
                    l(stringExtra2);
                } else {
                    com.opos.mobad.f.a.a(this.f7317a).c(stringExtra2);
                }
                sb = new StringBuilder("get global and status is:");
            }
            com.opos.cmn.an.f.a.b(com.ubix.ssp.open.comm.DownloadService.TAG, sb.append(i).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Messenger messenger) {
        ConcurrentHashMap<String, List<Messenger>> concurrentHashMap;
        if (messenger != null && (concurrentHashMap = this.e) != null && concurrentHashMap.size() > 0) {
            for (String str : this.e.keySet()) {
                List<Messenger> list = this.e.get(str);
                if (list != null && list.contains(messenger)) {
                    list.remove(messenger);
                    if (list != null && list.size() <= 0) {
                        this.e.remove(str);
                    }
                }
            }
        }
        com.opos.cmn.an.f.a.b(com.ubix.ssp.open.comm.DownloadService.TAG, "remove mClientMessengerMap size :" + this.e.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Messenger messenger, String str) {
        List<Messenger> listJ;
        if (TextUtils.isEmpty(str) || messenger == null || (listJ = j(str)) == null || listJ.contains(messenger)) {
            return;
        }
        listJ.add(messenger);
        try {
            messenger.getBinder().linkToDeath(new IBinder.DeathRecipient() { // from class: com.opos.mobad.service.DownloadService.3
                @Override // android.os.IBinder.DeathRecipient
                public void binderDied() {
                    com.opos.cmn.an.f.a.a(com.ubix.ssp.open.comm.DownloadService.TAG, "download binderDied:" + messenger);
                    DownloadService.this.a(messenger);
                    messenger.getBinder().unlinkToDeath(this, 0);
                }
            }, 0);
        } catch (RemoteException e) {
            com.opos.cmn.an.f.a.a(com.ubix.ssp.open.comm.DownloadService.TAG, "", (Throwable) e);
        }
        this.e.put(str, listJ);
        com.opos.cmn.an.f.a.b(com.ubix.ssp.open.comm.DownloadService.TAG, "add mClientMessengerToUrlsMap size:" + this.e.size() + ",messengersByUrlList size :" + listJ.size());
    }

    public static final void a(boolean z) {
        f = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Intent b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(this.f7317a, (Class<?>) DownloadService.class);
        intent.setAction("key_delete_action");
        intent.putExtra("key_action_type", 2);
        intent.putExtra("savePath", str);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        return f && (Build.VERSION.SDK_INT < 33 || this.f7317a.checkSelfPermission(x.cK) == 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Intent c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(this.f7317a, (Class<?>) DownloadService.class);
        intent.setAction("key_sys_delete_action");
        intent.putExtra("key_action_type", 3);
        intent.putExtra("savePath", str);
        return intent;
    }

    private void c() {
        ConcurrentHashMap<String, List<Messenger>> concurrentHashMap = this.e;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Intent d(String str) {
        com.opos.cmn.an.f.a.b(com.ubix.ssp.open.comm.DownloadService.TAG, "install intent downloadPath =" + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.opos.mobad.f.b.b.b(this.f7317a, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.d.remove(str);
            k(str);
        }
        com.opos.cmn.an.f.a.b(com.ubix.ssp.open.comm.DownloadService.TAG, "remove data mUrlToDownloadDataMap size:" + this.d.size() + ",mUrlToClientMessengerMap:" + this.e.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (Map.Entry<String, com.opos.mobad.f.a.b> entry : this.d.entrySet()) {
            com.opos.mobad.f.a.b value = entry.getValue();
            if (value != null && value.a(str)) {
                String key = entry.getKey();
                if (b()) {
                    com.opos.cmn.an.f.a.b(com.ubix.ssp.open.comm.DownloadService.TAG, "cancel notificationId:" + value.c);
                    this.b.a(value.c);
                }
                e(key);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.opos.mobad.f.a.a(this.f7317a).b(str);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a(com.ubix.ssp.open.comm.DownloadService.TAG, "", (Throwable) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.opos.mobad.f.a.a(this.f7317a).d(str);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a(com.ubix.ssp.open.comm.DownloadService.TAG, "", (Throwable) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.opos.mobad.f.a.a(this.f7317a).c(str);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a(com.ubix.ssp.open.comm.DownloadService.TAG, "", (Throwable) e);
        }
    }

    private List<Messenger> j(String str) {
        List<Messenger> arrayList = (TextUtils.isEmpty(str) || !this.e.containsKey(str)) ? new ArrayList<>() : this.e.get(str);
        com.opos.cmn.an.f.a.b(com.ubix.ssp.open.comm.DownloadService.TAG, "getUrlToClientMessengerMap size=" + arrayList.size());
        return arrayList;
    }

    private void k(String str) {
        ConcurrentHashMap<String, List<Messenger>> concurrentHashMap = this.e;
        if (concurrentHashMap != null && concurrentHashMap.size() > 0 && !TextUtils.isEmpty(str)) {
            this.e.remove(str);
        }
        com.opos.cmn.an.f.a.b(com.ubix.ssp.open.comm.DownloadService.TAG, "removeClientMessengerUrlList mUrlToClientMessengerMap.size:" + this.e.size());
    }

    private void l(String str) {
        com.opos.mobad.f.a.b bVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (b() && (bVar = this.d.get(str)) != null) {
            int i = bVar.c;
            this.b.a(i);
            com.opos.cmn.an.f.a.b(com.ubix.ssp.open.comm.DownloadService.TAG, "cancelNotificationAndRemoveData:" + i);
        }
        e(str);
    }

    public void a(int i, h hVar, boolean z) {
        if (this.g.compareAndSet(false, true)) {
            a(z);
            com.opos.cmn.an.f.a.b(com.ubix.ssp.open.comm.DownloadService.TAG, "int service downloadTaskNums:" + i + ",sIsShowNotification :" + f);
            com.opos.mobad.f.a.a(this.f7317a).a(i, hVar, this.i);
        }
    }

    public void a(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        com.opos.mobad.f.a.b bVar = this.d.containsKey(str) ? this.d.get(str) : null;
        com.opos.cmn.an.f.a.b(com.ubix.ssp.open.comm.DownloadService.TAG, "add downloadreq pkgName:" + str2 + ",appName :" + str4 + ",url:" + str + ",downloadReq:" + bVar);
        if (bVar == null) {
            com.opos.mobad.f.a.a(this.f7317a).a(str, str3);
            if (TextUtils.isEmpty(str4)) {
                str4 = a().a(str);
            }
            this.d.put(str, new com.opos.mobad.f.a.b(str4, str2, c.getAndIncrement(), new com.opos.mobad.f.a.d()));
            com.opos.cmn.an.f.a.b(com.ubix.ssp.open.comm.DownloadService.TAG, "add downloadreq mUrlToDownloadDataMap size:" + this.d.size());
            return;
        }
        if (102 != bVar.e && 107 != bVar.e) {
            com.opos.mobad.f.a.a(this.f7317a).a(str, str3);
        } else {
            Context context = this.f7317a;
            Toast.makeText(context, context.getResources().getString(R.string.download_toast_downloading_txt), 1).show();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        com.opos.cmn.an.f.a.b(com.ubix.ssp.open.comm.DownloadService.TAG, "on bind");
        a(intent);
        return this.h.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f7317a = StubApp.getOrigApplicationContext(getApplicationContext());
        com.opos.cmn.an.f.a.b(com.ubix.ssp.open.comm.DownloadService.TAG, "onCreate startForeground");
        com.opos.mobad.f.a.e eVarA = new com.opos.mobad.f.a.e.a().a("mob_downloader").b(3).b("download_manager").a(false).a(com.opos.mobad.f.b.c.a(this.f7317a, "opos_mob_drawable_download_icon", "drawable")).a();
        this.b = Build.VERSION.SDK_INT > 30 ? new com.opos.mobad.f.a.g(this.f7317a, eVarA) : new com.opos.mobad.f.a.a(this.f7317a, eVarA);
    }

    @Override // android.app.Service
    public void onDestroy() {
        com.opos.cmn.an.f.a.b(com.ubix.ssp.open.comm.DownloadService.TAG, "onDestroy");
        this.d.clear();
        this.b.a();
        com.opos.mobad.f.a.a(this.f7317a).b();
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        com.opos.cmn.an.f.a.b(com.ubix.ssp.open.comm.DownloadService.TAG, "on Rebind");
        a(intent);
        super.onRebind(intent);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        com.opos.cmn.an.f.a.b(com.ubix.ssp.open.comm.DownloadService.TAG, "onStartCommand");
        a(intent);
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        com.opos.cmn.an.f.a.b(com.ubix.ssp.open.comm.DownloadService.TAG, "onUnbind");
        c();
        return super.onUnbind(intent);
    }
}
