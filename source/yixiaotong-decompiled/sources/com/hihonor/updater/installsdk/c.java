package com.hihonor.updater.installsdk;

import android.content.Context;
import android.text.TextUtils;
import com.hihonor.updater.installsdk.api.AppStatusCallback;
import com.hihonor.updater.installsdk.api.AppStatusInfo;
import com.hihonor.updater.installsdk.api.DIInfo;
import com.hihonor.updater.installsdk.api.DownloadInstallListener;
import com.hihonor.updater.installsdk.api.ResultCallback;
import com.hihonor.updater.installsdk.api.TraceUrlData;
import com.hihonor.updater.installsdk.exception.GetSettingValueException;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c implements com.hihonor.updater.installsdk.b {
    private static final String c = "CallAPIImpl";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f3731a;
    private final List<DownloadInstallListener> b;

    class a extends com.hihonor.updater.installsdk.d {
        a() {
        }

        @Override // com.hihonor.updater.installsdk.d, com.hihonor.updater.installsdk.api.DownloadInstallListener
        public void onServiceConnected() {
            synchronized (c.this) {
                c cVar = c.this;
                cVar.a((List<? extends DownloadInstallListener>) cVar.b);
            }
        }

        @Override // com.hihonor.updater.installsdk.d, com.hihonor.updater.installsdk.api.DownloadInstallListener
        public void onServiceShutdown() {
            synchronized (c.this) {
                c cVar = c.this;
                cVar.b((List<? extends DownloadInstallListener>) cVar.b);
            }
        }
    }

    class b extends f {
        final /* synthetic */ ResultCallback d;

        b(ResultCallback resultCallback) {
            this.d = resultCallback;
        }

        @Override // com.hihonor.updater.installsdk.f
        public void b(int i, String str) {
            c cVar = c.this;
            cVar.a(this.d, i, cVar.a(str));
            g.a().a(g.s);
        }
    }

    /* JADX INFO: renamed from: com.hihonor.updater.installsdk.c$c, reason: collision with other inner class name */
    class BinderC0481c extends f {
        final /* synthetic */ ResultCallback d;

        BinderC0481c(ResultCallback resultCallback) {
            this.d = resultCallback;
        }

        @Override // com.hihonor.updater.installsdk.f
        public void b(int i, String str) {
            ResultCallback resultCallback = this.d;
            if (resultCallback != null) {
                c cVar = c.this;
                cVar.a(resultCallback, i, cVar.a(str));
            }
            g.a().a(g.t);
        }
    }

    class d extends f {
        final /* synthetic */ AppStatusCallback d;

        d(AppStatusCallback appStatusCallback) {
            this.d = appStatusCallback;
        }

        @Override // com.hihonor.updater.installsdk.f
        public void b(int i, String str) {
            List<AppStatusInfo> listB = c.this.b(str);
            long j = g.s;
            if (!listB.isEmpty()) {
                for (AppStatusInfo appStatusInfo : listB) {
                    long j2 = g.t;
                    if (j2 != j && !com.hihonor.updater.installsdk.a.a(appStatusInfo)) {
                        j = j2;
                    }
                    com.hihonor.updater.installsdk.a.b(appStatusInfo);
                }
            }
            g.a().a(j);
            AppStatusCallback appStatusCallback = this.d;
            if (appStatusCallback != null) {
                appStatusCallback.onStatusLoaded(i, listB);
            }
        }
    }

    private static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final com.hihonor.updater.installsdk.b f3733a = new c(null);

        private e() {
        }
    }

    private c() {
        this.b = new ArrayList();
    }

    /* synthetic */ c(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        com.hihonor.updater.installsdk.b.e eVar = new com.hihonor.updater.installsdk.b.e();
        eVar.readFromJSON(str);
        return eVar.c();
    }

    private String a(List<String> list, boolean z) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                jSONArray.put(new DIInfo.Builder(str).setShowAgreement(z).build().writeToJSON());
            }
        }
        return jSONArray.toString();
    }

    private void a(Context context, DIInfo dIInfo, int i, ResultCallback resultCallback) {
        if (!e(context)) {
            a(resultCallback, 3003);
            return;
        }
        if (a(dIInfo, resultCallback)) {
            if (!com.hihonor.updater.installsdk.c.c.e(this.f3731a)) {
                String traceUrl = dIInfo.getTraceUrl();
                String traceUrlData = dIInfo.getTraceUrlData();
                if (TextUtils.isEmpty(traceUrl) && !TextUtils.isEmpty(traceUrlData)) {
                    TraceUrlData traceUrlData2 = new TraceUrlData();
                    traceUrlData2.readFromJSON(traceUrlData);
                    JSONObject jSONObjectWriteToJSONOld = traceUrlData2.writeToJSONOld();
                    if (jSONObjectWriteToJSONOld != null) {
                        dIInfo.setTraceUrl(jSONObjectWriteToJSONOld.toString());
                        dIInfo.setTraceUrlData(null);
                    }
                }
            }
            g.a().a(this.f3731a, i, dIInfo.writeToJSON().toString(), new BinderC0481c(resultCallback));
        }
    }

    private void a(DIInfo dIInfo, AppStatusInfo appStatusInfo, List<? extends DownloadInstallListener> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<? extends DownloadInstallListener> it = list.iterator();
        while (it.hasNext()) {
            try {
                it.next().onAppUninstalled(dIInfo, appStatusInfo);
            } catch (Exception e2) {
                com.hihonor.updater.installsdk.c.a.c(c, "error " + e2);
            }
        }
    }

    private void a(ResultCallback resultCallback, int i) {
        a(resultCallback, i, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ResultCallback resultCallback, int i, String str) {
        if (TextUtils.isEmpty(str)) {
            str = com.hihonor.updater.installsdk.c.c.a(i);
        }
        com.hihonor.updater.installsdk.c.a.c(c, "on result =" + i + PPSLabelView.Code + str);
        if (resultCallback != null) {
            resultCallback.onCall(i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<? extends DownloadInstallListener> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        com.hihonor.updater.installsdk.c.a.c(c, "serviceConnected listenerList=" + list.size());
        Iterator<? extends DownloadInstallListener> it = list.iterator();
        while (it.hasNext()) {
            try {
                it.next().onServiceConnected();
            } catch (Throwable th) {
                com.hihonor.updater.installsdk.c.a.c(c, "onServiceConnected error " + th);
            }
        }
    }

    private boolean a(DIInfo dIInfo, ResultCallback resultCallback) {
        int i;
        if (!com.hihonor.updater.installsdk.c.c.a(this.f3731a)) {
            i = 3001;
        } else if (com.hihonor.updater.installsdk.c.c.a()) {
            i = 3002;
        } else {
            if (!TextUtils.isEmpty(dIInfo.getPackageName())) {
                return true;
            }
            i = 3003;
        }
        a(resultCallback, i);
        return false;
    }

    public static com.hihonor.updater.installsdk.b b() {
        return e.f3733a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<AppStatusInfo> b(String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            com.hihonor.updater.installsdk.b.e eVar = new com.hihonor.updater.installsdk.b.e();
            eVar.readFromJSON(str);
            JSONArray jSONArray = new JSONArray(eVar.b());
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                AppStatusInfo appStatusInfo = new AppStatusInfo();
                appStatusInfo.readFromJSON(jSONObject.toString());
                arrayList.add(appStatusInfo);
            }
        } catch (Throwable th) {
            com.hihonor.updater.installsdk.c.a.b(c, "parseStatusData error " + th.getMessage());
        }
        return arrayList;
    }

    private void b(DIInfo dIInfo, AppStatusInfo appStatusInfo, List<? extends DownloadInstallListener> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        switch (appStatusInfo.getStatus()) {
            case 2003:
                Iterator<? extends DownloadInstallListener> it = list.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().onDownloadStart(dIInfo, appStatusInfo);
                    } catch (Exception e2) {
                        com.hihonor.updater.installsdk.c.a.c(c, "error " + e2);
                    }
                }
                break;
            case 2004:
                Iterator<? extends DownloadInstallListener> it2 = list.iterator();
                while (it2.hasNext()) {
                    try {
                        it2.next().onDownloadProgress(dIInfo, appStatusInfo);
                    } catch (Exception e3) {
                        com.hihonor.updater.installsdk.c.a.c(c, "error " + e3);
                    }
                }
                break;
            case 2005:
                Iterator<? extends DownloadInstallListener> it3 = list.iterator();
                while (it3.hasNext()) {
                    try {
                        it3.next().onDownloadSuccess(dIInfo, appStatusInfo);
                    } catch (Exception e4) {
                        com.hihonor.updater.installsdk.c.a.c(c, "error " + e4);
                    }
                }
                break;
            case 2006:
                Iterator<? extends DownloadInstallListener> it4 = list.iterator();
                while (it4.hasNext()) {
                    try {
                        it4.next().onDownloadFail(dIInfo, appStatusInfo);
                    } catch (Exception e5) {
                        com.hihonor.updater.installsdk.c.a.c(c, "error " + e5);
                    }
                }
                break;
            case 2007:
                Iterator<? extends DownloadInstallListener> it5 = list.iterator();
                while (it5.hasNext()) {
                    try {
                        it5.next().onDownloadPause(dIInfo, appStatusInfo);
                    } catch (Exception e6) {
                        com.hihonor.updater.installsdk.c.a.c(c, "error " + e6);
                    }
                }
                break;
            case 2008:
                Iterator<? extends DownloadInstallListener> it6 = list.iterator();
                while (it6.hasNext()) {
                    try {
                        it6.next().onDownloadInstallCancel(dIInfo, appStatusInfo);
                    } catch (Exception e7) {
                        com.hihonor.updater.installsdk.c.a.c(c, "error " + e7);
                    }
                }
                break;
            case 2009:
                Iterator<? extends DownloadInstallListener> it7 = list.iterator();
                while (it7.hasNext()) {
                    try {
                        it7.next().onDownloadWaiting(dIInfo, appStatusInfo);
                    } catch (Exception e8) {
                        com.hihonor.updater.installsdk.c.a.c(c, "error " + e8);
                    }
                }
                break;
            case 2011:
                Iterator<? extends DownloadInstallListener> it8 = list.iterator();
                while (it8.hasNext()) {
                    try {
                        it8.next().onInstallStart(dIInfo, appStatusInfo);
                    } catch (Exception e9) {
                        com.hihonor.updater.installsdk.c.a.c(c, "error " + e9);
                    }
                }
                break;
            case 2012:
                Iterator<? extends DownloadInstallListener> it9 = list.iterator();
                while (it9.hasNext()) {
                    try {
                        it9.next().onInstallSuccess(dIInfo, appStatusInfo);
                    } catch (Exception e10) {
                        com.hihonor.updater.installsdk.c.a.c(c, "error " + e10);
                    }
                }
                break;
            case 2013:
                Iterator<? extends DownloadInstallListener> it10 = list.iterator();
                while (it10.hasNext()) {
                    try {
                        it10.next().onInstallFail(dIInfo, appStatusInfo);
                    } catch (Exception e11) {
                        com.hihonor.updater.installsdk.c.a.c(c, "error " + e11);
                    }
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<? extends DownloadInstallListener> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        com.hihonor.updater.installsdk.c.a.c(c, "serviceShutdown listenerList=" + list.size());
        Iterator<? extends DownloadInstallListener> it = list.iterator();
        while (it.hasNext()) {
            try {
                it.next().onServiceShutdown();
            } catch (Throwable th) {
                com.hihonor.updater.installsdk.c.a.c(c, "onServiceShutdown error " + th);
            }
        }
    }

    private boolean e(Context context) {
        if (this.f3731a != null) {
            return true;
        }
        if (context == null || StubApp.getOrigApplicationContext(context.getApplicationContext()) == null) {
            com.hihonor.updater.installsdk.c.a.d(c, "context is invalid");
            return false;
        }
        this.f3731a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        com.hihonor.updater.installsdk.c.a.c(c, "version " + BuildConfig.versionCode);
        g.a().a(new a());
        return true;
    }

    @Override // com.hihonor.updater.installsdk.b
    public void a(Context context, DIInfo dIInfo, ResultCallback resultCallback) {
        a(context, dIInfo, 6004, resultCallback);
    }

    @Override // com.hihonor.updater.installsdk.b
    public void a(Context context, boolean z, ResultCallback resultCallback) {
        com.hihonor.updater.installsdk.c.a.c(c, "checkCallSupport");
        if (!e(context)) {
            a(resultCallback, 3003);
            return;
        }
        if (!com.hihonor.updater.installsdk.c.c.a(this.f3731a)) {
            a(resultCallback, 3001);
            return;
        }
        b bVar = new b(resultCallback);
        com.hihonor.updater.installsdk.b.d dVar = new com.hihonor.updater.installsdk.b.d();
        dVar.a(z);
        g.a().a(this.f3731a, com.hihonor.updater.installsdk.b.a.e, dVar.writeToJSON().toString(), bVar);
    }

    @Override // com.hihonor.updater.installsdk.b
    public void a(Context context, boolean z, List<String> list, AppStatusCallback appStatusCallback) {
        if (!e(context)) {
            if (appStatusCallback != null) {
                appStatusCallback.onStatusLoaded(3003, new ArrayList());
            }
        } else {
            if (!com.hihonor.updater.installsdk.c.c.a(this.f3731a)) {
                if (appStatusCallback != null) {
                    appStatusCallback.onStatusLoaded(3001, new ArrayList());
                    return;
                }
                return;
            }
            String strA = a(list, z);
            if (!TextUtils.isEmpty(strA)) {
                g.a().a(this.f3731a, 6008, strA, new d(appStatusCallback));
            } else if (appStatusCallback != null) {
                appStatusCallback.onStatusLoaded(3003, new ArrayList());
            }
        }
    }

    @Override // com.hihonor.updater.installsdk.b
    public void a(DIInfo dIInfo, AppStatusInfo appStatusInfo) {
        synchronized (this) {
            if (appStatusInfo != null) {
                if (!TextUtils.isEmpty(appStatusInfo.getPackageName())) {
                    b(dIInfo, appStatusInfo, this.b);
                }
            }
        }
    }

    @Override // com.hihonor.updater.installsdk.b
    public void a(DownloadInstallListener downloadInstallListener) {
        if (downloadInstallListener == null) {
            return;
        }
        synchronized (this) {
            this.b.remove(downloadInstallListener);
        }
        if (this.b.isEmpty()) {
            com.hihonor.updater.installsdk.c.a.c(c, "unbindService");
            g.a().k();
        }
        com.hihonor.updater.installsdk.c.a.c(c, "unRegisterListener " + this.b.size());
    }

    @Override // com.hihonor.updater.installsdk.b
    public boolean a() {
        return !this.b.isEmpty();
    }

    @Override // com.hihonor.updater.installsdk.b
    public boolean a(Context context) throws GetSettingValueException {
        if (d(context)) {
            return c(context);
        }
        return true;
    }

    @Override // com.hihonor.updater.installsdk.b
    public void b(Context context, DIInfo dIInfo, ResultCallback resultCallback) {
        a(context, dIInfo, 6002, resultCallback);
    }

    @Override // com.hihonor.updater.installsdk.b
    public void b(DownloadInstallListener downloadInstallListener) {
        if (downloadInstallListener == null) {
            return;
        }
        synchronized (this) {
            if (!this.b.contains(downloadInstallListener)) {
                this.b.add(downloadInstallListener);
            }
        }
        if (com.hihonor.updater.installsdk.a.b()) {
            g.a().m();
        }
        com.hihonor.updater.installsdk.c.a.c(c, "registerListener " + this.b.size());
    }

    @Override // com.hihonor.updater.installsdk.b
    public boolean b(Context context) {
        boolean zA = com.hihonor.updater.installsdk.c.c.a(context);
        com.hihonor.updater.installsdk.c.a.c(c, "checkVersionSupport result=" + zA);
        return zA;
    }

    @Override // com.hihonor.updater.installsdk.b
    public void c(Context context, DIInfo dIInfo, ResultCallback resultCallback) {
        a(context, dIInfo, 6001, resultCallback);
    }

    @Override // com.hihonor.updater.installsdk.b
    public boolean c(Context context) throws GetSettingValueException {
        return com.hihonor.updater.installsdk.c.c.d(context);
    }

    @Override // com.hihonor.updater.installsdk.b
    public boolean d(Context context) {
        boolean zC = com.hihonor.updater.installsdk.c.c.c(context);
        com.hihonor.updater.installsdk.c.a.c(c, "isSwitchLimitVersion result=" + zC);
        return zC;
    }

    @Override // com.hihonor.updater.installsdk.b
    public void onAppUninstalled(DIInfo dIInfo, AppStatusInfo appStatusInfo) {
        synchronized (this) {
            if (appStatusInfo != null) {
                if (!TextUtils.isEmpty(appStatusInfo.getPackageName())) {
                    a(dIInfo, appStatusInfo, this.b);
                }
            }
        }
    }
}
