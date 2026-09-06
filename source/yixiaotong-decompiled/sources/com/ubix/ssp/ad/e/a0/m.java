package com.ubix.ssp.ad.e.a0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.bytedance.pangle.LocalBroadcastManager;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f8710a = new Object();
    private static m b;
    private final Context c;
    private final Handler g;
    private final HashMap<BroadcastReceiver, ArrayList<c>> d = new HashMap<>();
    private final HashMap<String, ArrayList<c>> e = new HashMap<>();
    private final ArrayList<b> f = new ArrayList<>();
    private boolean h = false;

    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                super.handleMessage(message);
            } else {
                m.this.a();
            }
        }
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Intent f8712a;
        final ArrayList<c> b;

        b(Intent intent, ArrayList<c> arrayList) {
            this.f8712a = intent;
            this.b = arrayList;
        }
    }

    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final IntentFilter f8713a;
        final BroadcastReceiver b;
        boolean c;
        boolean d;

        c(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f8713a = intentFilter;
            this.b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.b);
            sb.append(" filter=");
            sb.append(this.f8713a);
            if (this.d) {
                sb.append(" DEAD");
            }
            sb.append(com.alipay.sdk.util.i.d);
            return sb.toString();
        }
    }

    private m(Context context) {
        this.c = context;
        this.g = new a(context.getMainLooper());
    }

    public static m a(Context context) {
        m mVar;
        synchronized (f8710a) {
            if (b == null) {
                b = new m(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            }
            mVar = b;
        }
        return mVar;
    }

    void a() {
        int size;
        b[] bVarArr;
        while (true) {
            synchronized (this.d) {
                size = this.f.size();
                if (size <= 0) {
                    return;
                }
                bVarArr = new b[size];
                this.f.toArray(bVarArr);
                this.f.clear();
            }
            for (int i = 0; i < size; i++) {
                b bVar = bVarArr[i];
                int size2 = bVar.b.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    c cVar = bVar.b.get(i2);
                    if (!cVar.d) {
                        cVar.b.onReceive(this.c, bVar.f8712a);
                    }
                }
            }
        }
    }

    public void a(BroadcastReceiver broadcastReceiver) {
        synchronized (this.d) {
            this.h = false;
            ArrayList<c> arrayListRemove = this.d.remove(broadcastReceiver);
            if (arrayListRemove != null) {
                for (int size = arrayListRemove.size() - 1; size >= 0; size--) {
                    c cVar = arrayListRemove.get(size);
                    cVar.d = true;
                    for (int i = 0; i < cVar.f8713a.countActions(); i++) {
                        String action = cVar.f8713a.getAction(i);
                        ArrayList<c> arrayList = this.e.get(action);
                        if (arrayList != null) {
                            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                                c cVar2 = arrayList.get(size2);
                                if (cVar2.b == broadcastReceiver) {
                                    cVar2.d = true;
                                    arrayList.remove(size2);
                                }
                            }
                            if (arrayList.size() <= 0) {
                                this.e.remove(action);
                            }
                        }
                    }
                }
            }
        }
    }

    public void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.d) {
            this.h = true;
            c cVar = new c(intentFilter, broadcastReceiver);
            ArrayList<c> arrayList = this.d.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.d.put(broadcastReceiver, arrayList);
            }
            arrayList.add(cVar);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList<c> arrayList2 = this.e.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.e.put(action, arrayList2);
                }
                arrayList2.add(cVar);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean a(Intent intent) {
        boolean z;
        ArrayList<c> arrayList;
        int i;
        String str;
        boolean z2;
        String str2;
        synchronized (this.d) {
            String action = intent.getAction();
            String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.c.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z3 = true;
            Object[] objArr = (intent.getFlags() & 8) != 0;
            if (objArr != false) {
                Log.v(LocalBroadcastManager.TAG, "Resolving type " + strResolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<c> arrayList2 = this.e.get(intent.getAction());
            if (arrayList2 != null) {
                if (objArr != false) {
                    Log.v(LocalBroadcastManager.TAG, "Action list: " + arrayList2);
                }
                ArrayList arrayList3 = null;
                int i2 = 0;
                while (i2 < arrayList2.size()) {
                    c cVar = arrayList2.get(i2);
                    if (objArr != false) {
                        Log.v(LocalBroadcastManager.TAG, "Matching against filter " + cVar.f8713a);
                    }
                    if (cVar.c) {
                        if (objArr != false) {
                            Log.v(LocalBroadcastManager.TAG, "  Filter's target already added");
                        }
                        arrayList = arrayList2;
                        i = i2;
                        str = action;
                        z2 = z3;
                    } else {
                        String str3 = action;
                        arrayList = arrayList2;
                        i = i2;
                        str = action;
                        z2 = z3;
                        int iMatch = cVar.f8713a.match(str3, strResolveTypeIfNeeded, scheme, data, categories, LocalBroadcastManager.TAG);
                        if (iMatch >= 0) {
                            if (objArr != false) {
                                Log.v(LocalBroadcastManager.TAG, "  Filter matched!  match=0x" + Integer.toHexString(iMatch));
                            }
                            if (arrayList3 == null) {
                                arrayList3 = new ArrayList();
                            }
                            arrayList3.add(cVar);
                            cVar.c = z2;
                        } else if (objArr != false) {
                            if (iMatch == -4) {
                                str2 = com.huawei.openalliance.ad.constant.x.cy;
                            } else if (iMatch == -3) {
                                str2 = "action";
                            } else if (iMatch != -2) {
                                str2 = iMatch != -1 ? "unknown reason" : "type";
                            } else {
                                str2 = "data";
                            }
                            Log.v(LocalBroadcastManager.TAG, "  Filter did not match: " + str2);
                        }
                    }
                    i2 = i + 1;
                    z3 = z2;
                    arrayList2 = arrayList;
                    action = str;
                }
                boolean z4 = z3;
                if (arrayList3 != null) {
                    for (int i3 = 0; i3 < arrayList3.size(); i3++) {
                        ((c) arrayList3.get(i3)).c = false;
                    }
                    this.f.add(new b(intent, arrayList3));
                    if (!this.g.hasMessages(z4 ? 1 : 0)) {
                        this.g.sendEmptyMessage(z4 ? 1 : 0);
                    }
                    return z4;
                }
                z = false;
            } else {
                z = false;
            }
            return z;
        }
    }

    public void b(Intent intent) {
        if (a(intent)) {
            a();
        }
    }
}
