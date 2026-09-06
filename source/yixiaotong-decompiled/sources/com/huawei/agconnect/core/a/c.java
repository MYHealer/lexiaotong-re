package com.huawei.agconnect.core.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.huawei.agconnect.core.Service;
import com.huawei.agconnect.core.ServiceDiscovery;
import com.huawei.agconnect.core.ServiceRegistrar;
import com.huawei.openalliance.ad.constant.x;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f3761a;

    /* JADX INFO: renamed from: com.huawei.agconnect.core.a.c$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class a implements Serializable, Comparator<Map.Entry<String, Integer>> {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
            return entry.getValue().intValue() - entry2.getValue().intValue();
        }
    }

    c(Context context) {
        this.f3761a = context;
    }

    private <T extends ServiceRegistrar> T a(String str) {
        StringBuilder sb;
        String localizedMessage;
        StringBuilder sbAppend;
        try {
            Class<?> cls = Class.forName(str);
            if (ServiceRegistrar.class.isAssignableFrom(cls)) {
                return (T) Class.forName(str).newInstance();
            }
            Log.e("ServiceRegistrarParser", cls + " must extends from ServiceRegistrar.");
            return null;
        } catch (ClassNotFoundException e) {
            sbAppend = new StringBuilder("Can not found service class, ").append(e.getMessage());
            Log.e("ServiceRegistrarParser", sbAppend.toString());
            return null;
        } catch (IllegalAccessException e2) {
            sb = new StringBuilder("instantiate service class exception ");
            localizedMessage = e2.getLocalizedMessage();
            sbAppend = sb.append(localizedMessage);
            Log.e("ServiceRegistrarParser", sbAppend.toString());
            return null;
        } catch (InstantiationException e3) {
            sb = new StringBuilder("instantiate service class exception ");
            localizedMessage = e3.getLocalizedMessage();
            sbAppend = sb.append(localizedMessage);
            Log.e("ServiceRegistrarParser", sbAppend.toString());
            return null;
        }
    }

    private List<String> b() {
        StringBuilder sb;
        ArrayList arrayList = new ArrayList();
        Bundle bundleC = c();
        if (bundleC == null) {
            return arrayList;
        }
        HashMap map = new HashMap(10);
        for (String message : bundleC.keySet()) {
            if ("com.huawei.agconnect.core.ServiceRegistrar".equals(bundleC.getString(message))) {
                String[] strArrSplit = message.split(x.bQ);
                if (strArrSplit.length == 2) {
                    try {
                        map.put(strArrSplit[0], Integer.valueOf(strArrSplit[1]));
                    } catch (NumberFormatException e) {
                        sb = new StringBuilder("registrar configuration format error:");
                        message = e.getMessage();
                        Log.e("ServiceRegistrarParser", sb.append(message).toString());
                    }
                } else if (strArrSplit.length == 1) {
                    map.put(strArrSplit[0], 1000);
                } else {
                    sb = new StringBuilder("registrar configuration error, ");
                    Log.e("ServiceRegistrarParser", sb.append(message).toString());
                }
            }
        }
        ArrayList arrayList2 = new ArrayList(map.entrySet());
        Collections.sort(arrayList2, new a(null));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList.add(((Map.Entry) it.next()).getKey());
        }
        return arrayList;
    }

    private Bundle c() {
        PackageManager packageManager = this.f3761a.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        try {
            ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(this.f3761a, (Class<?>) ServiceDiscovery.class), 128);
            if (serviceInfo != null) {
                return serviceInfo.metaData;
            }
            Log.e("ServiceRegistrarParser", "Can not found ServiceDiscovery service.");
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("ServiceRegistrarParser", "get ServiceDiscovery exception." + e.getLocalizedMessage());
        }
    }

    public List<Service> a() {
        Log.i("ServiceRegistrarParser", "getServices");
        List<String> listB = b();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = listB.iterator();
        while (it.hasNext()) {
            ServiceRegistrar serviceRegistrarA = a(it.next());
            if (serviceRegistrarA != null) {
                serviceRegistrarA.initialize(this.f3761a);
                List<Service> services = serviceRegistrarA.getServices(this.f3761a);
                if (services != null) {
                    arrayList.addAll(services);
                }
            }
        }
        Log.i("ServiceRegistrarParser", "services:" + Integer.valueOf(arrayList.size()));
        return arrayList;
    }
}
