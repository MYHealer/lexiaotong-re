package com.meishu.sdk.core.event;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.meishu.sdk.core.safe.l;
import com.meishu.sdk.core.utils.LogUtil;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: LiveDataBus.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a {
    public static final a d = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f4791a = new Object();
    public final HashMap<String, ArrayList<BroadcastReceiver>> b = new HashMap<>();
    public final Handler c = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: com.meishu.sdk.core.event.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: LiveDataBus.java */
    public class C0794a extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f4792a;
        public final /* synthetic */ Intent b;
        public final /* synthetic */ ArrayList c;

        public C0794a(Context context, Intent intent, ArrayList arrayList) {
            this.f4792a = context;
            this.b = intent;
            this.c = arrayList;
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            a aVar = a.this;
            Context context = this.f4792a;
            Intent intent = this.b;
            ArrayList arrayList = this.c;
            aVar.getClass();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                try {
                    ((BroadcastReceiver) it.next()).onReceive(context, intent);
                } catch (Throwable th) {
                    LogUtil.e("LiveDataBus", "onReceive error", th);
                }
            }
        }
    }

    public void a(BroadcastReceiver broadcastReceiver, String[] strArr) {
        try {
            LogUtil.dev("LiveDataBus", "registerReceiver");
            synchronized (this.f4791a) {
                try {
                    for (String str : strArr) {
                        if (str != null) {
                            ArrayList<BroadcastReceiver> arrayList = this.b.get(str);
                            if (arrayList == null) {
                                arrayList = new ArrayList<>();
                                this.b.put(str, arrayList);
                            }
                            if (!arrayList.contains(broadcastReceiver)) {
                                arrayList.add(broadcastReceiver);
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            LogUtil.e("LiveDataBus", "registerReceiver error", th2);
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0038 */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0040, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(BroadcastReceiver broadcastReceiver) {
        LogUtil.dev("LiveDataBus", "unregisterReceiver");
        synchronized (this.f4791a) {
            try {
                Iterator<Map.Entry<String, ArrayList<BroadcastReceiver>>> it = this.b.entrySet().iterator();
                while (it.hasNext()) {
                    ArrayList<BroadcastReceiver> value = it.next().getValue();
                    value.remove(broadcastReceiver);
                    if (value.isEmpty()) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(Context context, Intent intent) {
        try {
            LogUtil.dev("LiveDataBus", "sendBroadcast");
            String action = intent.getAction();
            if (action == null) {
                return;
            }
            synchronized (this.f4791a) {
                ArrayList<BroadcastReceiver> arrayList = this.b.get(action);
                if (arrayList != null && !arrayList.isEmpty()) {
                    ArrayList arrayList2 = new ArrayList(arrayList);
                    this.c.post(new C0794a(StubApp.getOrigApplicationContext(context.getApplicationContext()), new Intent(intent), arrayList2));
                }
            }
        } catch (Throwable th) {
            LogUtil.e("LiveDataBus", "sendBroadcast error", th);
        }
    }
}
