package com.adprof.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import com.bytedance.pangle.LocalBroadcastManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static m f1295a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f452a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HashMap f454a = new HashMap();
    public final HashMap b = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList f453a = new ArrayList();

    public m(Context context) {
        this.f452a = context;
    }

    public static m a() {
        if (f1295a == null) {
            synchronized (AdprofSdk.class) {
                if (f1295a == null) {
                    Context context = AdprofSdk.getInstance().getContext();
                    if (context != null) {
                        f1295a = new m(context);
                    } else {
                        pk.b(LocalBroadcastManager.TAG, "getInstance error: GTAdSdk.getInstance().getContext() returned null");
                    }
                }
            }
        }
        return f1295a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m680a() {
        synchronized (this.f454a) {
            int size = this.f453a.size();
            if (size <= 0) {
                return;
            }
            i6[] i6VarArr = new i6[size];
            this.f453a.toArray(i6VarArr);
            this.f453a.clear();
            for (int i = 0; i < size; i++) {
                i6 i6Var = i6VarArr[i];
                int size2 = i6Var.f376a.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    hi hiVar = (hi) i6Var.f376a.get(i2);
                    if (!hiVar.b) {
                        Context context = this.f452a;
                        if (context != null) {
                            hiVar.f1213a.onReceive(context, i6Var.f1224a);
                        } else {
                            pk.b(LocalBroadcastManager.TAG, "executePendingBroadcasts error: mAppContext is null");
                        }
                    }
                }
            }
        }
    }

    public void a(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f454a) {
            pk.a(LocalBroadcastManager.TAG, "\n unregisterReceiver  receiver = " + broadcastReceiver);
            ArrayList arrayList = (ArrayList) this.f454a.remove(broadcastReceiver);
            if (arrayList == null) {
                return;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                hi hiVar = (hi) arrayList.get(size);
                hiVar.b = true;
                for (int i = 0; i < hiVar.f361a.countActions(); i++) {
                    String action = hiVar.f361a.getAction(i);
                    ArrayList arrayList2 = (ArrayList) this.b.get(action);
                    if (arrayList2 != null) {
                        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                            hi hiVar2 = (hi) arrayList2.get(size2);
                            if (hiVar2.f1213a == broadcastReceiver) {
                                hiVar2.b = true;
                                arrayList2.remove(size2);
                            }
                        }
                        if (arrayList2.size() <= 0) {
                            this.b.remove(action);
                        }
                    }
                }
            }
        }
    }

    public void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f454a) {
            pk.a(LocalBroadcastManager.TAG, "\n registerReceiver  receiver = " + broadcastReceiver + "   filter = " + intentFilter);
            hi hiVar = new hi(intentFilter, broadcastReceiver);
            ArrayList arrayList = (ArrayList) this.f454a.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.f454a.put(broadcastReceiver, arrayList);
            }
            arrayList.add(hiVar);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList arrayList2 = (ArrayList) this.b.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList(1);
                    this.b.put(action, arrayList2);
                }
                arrayList2.add(hiVar);
            }
        }
    }

    public boolean a(Intent intent) {
        String str;
        int i;
        ArrayList arrayList;
        ArrayList arrayList2;
        synchronized (this.f454a) {
            String action = intent.getAction();
            Context context = this.f452a;
            if (context == null) {
                pk.b(LocalBroadcastManager.TAG, "sendBroadcast error: mAppContext is null");
                return false;
            }
            String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(context.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            ArrayList arrayList3 = (ArrayList) this.b.get(intent.getAction());
            if (arrayList3 != null) {
                ArrayList arrayList4 = null;
                int i2 = 0;
                while (i2 < arrayList3.size()) {
                    hi hiVar = (hi) arrayList3.get(i2);
                    if (hiVar.f362a) {
                        pk.a(LocalBroadcastManager.TAG, "\n sendBroadcast  Filter target already added .....");
                        i = i2;
                        arrayList2 = arrayList3;
                        str = action;
                        arrayList = arrayList4;
                    } else {
                        String str2 = action;
                        str = action;
                        i = i2;
                        arrayList = arrayList4;
                        arrayList2 = arrayList3;
                        if (hiVar.f361a.match(str2, strResolveTypeIfNeeded, scheme, data, categories, LocalBroadcastManager.TAG) >= 0) {
                            arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList4.add(hiVar);
                            hiVar.f362a = true;
                        }
                        i2 = i + 1;
                        action = str;
                        arrayList3 = arrayList2;
                    }
                    arrayList4 = arrayList;
                    i2 = i + 1;
                    action = str;
                    arrayList3 = arrayList2;
                }
                ArrayList arrayList5 = arrayList4;
                if (arrayList5 != null) {
                    for (int i3 = 0; i3 < arrayList5.size(); i3++) {
                        ((hi) arrayList5.get(i3)).f362a = false;
                    }
                    this.f453a.add(new i6(intent, arrayList5));
                    m680a();
                    return true;
                }
            }
            return false;
        }
    }
}
