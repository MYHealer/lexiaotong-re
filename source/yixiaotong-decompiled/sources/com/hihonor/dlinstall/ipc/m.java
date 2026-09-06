package com.hihonor.dlinstall.ipc;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.hv.TTDownloadField;
import com.google.android.exoplayer2.C;
import com.hihonor.dlinstall.DownloadInstallClient;
import com.hihonor.dlinstall.DownloadInstallTask;
import com.hihonor.dlinstall.ability.syncapp.AdAppReport;
import com.hihonor.dlinstall.data.PackageInfoResult;
import com.hihonor.dlinstall.report.DlInstallReportConfig;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class m implements ServiceConnection, IBinder.DeathRecipient {
    public static volatile m g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile String f3604a;
    public Context b;
    public final d c;
    public o d;
    public long e = 0;
    public final List<b> f = new ArrayList();

    public interface a<T> {
        void onErrorAction(T t, int i, String str);

        void onSuccessAction(o oVar, T t);

        void onTimeoutAction(T t);
    }

    public static class b<T> {
        public a<T> action;
        public String command;
        public T params;
        public long timeoutMs;

        public b(a<T> aVar, T t, long j, String str) {
            this.action = aVar;
            this.params = t;
            this.timeoutMs = j;
            this.command = str;
        }

        public b(T t, long j) {
            this.params = t;
            this.timeoutMs = j;
        }
    }

    public static class c<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public R f3605a;
        public final FutureTask<R> b = new FutureTask<>(new Callable() { // from class: com.hihonor.dlinstall.ipc.m$c$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return m.c.a();
            }
        });

        public static /* synthetic */ Object a() throws Exception {
            return null;
        }

        public R a(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
            this.b.get(j, timeUnit);
            return this.f3605a;
        }

        public void a(R r) {
            this.f3605a = null;
            this.b.run();
        }
    }

    public class d extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            int i = message.what;
            if (i == 1) {
                Object obj = message.obj;
                if (!(obj instanceof Context)) {
                    m.this.a();
                    return;
                }
                m mVar = m.this;
                Context origApplicationContext = (Context) obj;
                mVar.getClass();
                if (StubApp.getOrigApplicationContext(origApplicationContext.getApplicationContext()) != null) {
                    origApplicationContext = StubApp.getOrigApplicationContext(origApplicationContext.getApplicationContext());
                }
                mVar.b = origApplicationContext;
                mVar.a();
                return;
            }
            if (i == 2) {
                Object obj2 = message.obj;
                if (obj2 instanceof b) {
                    m mVar2 = m.this;
                    b bVar = (b) obj2;
                    o oVar = mVar2.d;
                    if (oVar != null) {
                        mVar2.a(oVar, bVar);
                        return;
                    }
                    com.hihonor.dlinstall.page.a.c("DownloadInstallService", "doExecuteCommand service is null");
                    mVar2.f.add(bVar);
                    mVar2.c.sendMessageDelayed(mVar2.c.obtainMessage(4, bVar), bVar.timeoutMs);
                    return;
                }
                return;
            }
            if (i == 3) {
                m mVar3 = m.this;
                mVar3.getClass();
                com.hihonor.dlinstall.page.a.c("DownloadInstallService", "doExecutePendingCommandList");
                o oVar2 = mVar3.d;
                if (oVar2 != null) {
                    Iterator<b> it = mVar3.f.iterator();
                    while (it.hasNext()) {
                        mVar3.a(oVar2, it.next());
                    }
                } else {
                    com.hihonor.dlinstall.page.a.c("DownloadInstallService", "doExecutePendingCommandList service is null");
                }
                mVar3.f.clear();
                mVar3.c.removeMessages(4);
                return;
            }
            if (i == 4) {
                Object obj3 = message.obj;
                if (obj3 instanceof b) {
                    b bVar2 = (b) obj3;
                    m.this.getClass();
                    bVar2.action.onTimeoutAction(bVar2.params);
                    return;
                }
                return;
            }
            if (i != 5) {
                return;
            }
            m mVar4 = m.this;
            mVar4.getClass();
            com.hihonor.dlinstall.page.a.c("DownloadInstallService", "doExecuteUnbindService: enter");
            Context context = mVar4.b;
            if (context == null) {
                str = "doExecuteUnbindService: mContext is null";
            } else {
                if (mVar4.d != null) {
                    try {
                        context.unbindService(mVar4);
                    } catch (Exception e) {
                        com.hihonor.dlinstall.page.a.b("DownloadInstallService", "doUnbindService: e is " + e.getMessage());
                    }
                    mVar4.d = null;
                    mVar4.e = 0L;
                    com.hihonor.dlinstall.ipc.b.a().onServiceShutdown();
                    return;
                }
                str = "doUnbindService: remoteService is null";
            }
            com.hihonor.dlinstall.page.a.d("DownloadInstallService", str);
        }
    }

    public m() {
        HandlerThread handlerThread = new HandlerThread("DownloadInstallService");
        handlerThread.start();
        this.c = new d(handlerThread.getLooper());
    }

    public static Bundle a(m mVar, DownloadInstallTask downloadInstallTask, String str) {
        mVar.getClass();
        Bundle bundle = new Bundle();
        AdAppReport adAppReport = downloadInstallTask.getAdAppReport();
        boolean zA = com.hihonor.dlinstall.util.a.a(adAppReport);
        String callerApkVer = downloadInstallTask.getCallerApkVer();
        PackageInfoResult packageInfoResultA = com.hihonor.dlinstall.util.a.a(downloadInstallTask.getContext());
        String str2 = "";
        if (packageInfoResultA != null) {
            String callerAppName = packageInfoResultA.getCallerAppName();
            if (TextUtils.isEmpty(callerApkVer)) {
                callerApkVer = packageInfoResultA.getCallerAppVer() + "";
            }
            str2 = callerAppName;
        }
        mVar.a(bundle, downloadInstallTask.getContext().getPackageName(), str);
        bundle.putString("key_caller_app_name", str2);
        bundle.putString("callerApkVer", callerApkVer);
        bundle.putString("key_request_id", downloadInstallTask.getRequestId());
        bundle.putInt("key_channel", downloadInstallTask.getChannel());
        bundle.putString("key_sub_channel", downloadInstallTask.getSubChannel());
        bundle.putString("isAd", String.valueOf(zA));
        bundle.putString("sceneType", downloadInstallTask.getSceneType());
        bundle.putString("callerApkVer", downloadInstallTask.getCallerApkVer());
        if (adAppReport != null) {
            bundle.putString("adId", adAppReport.getAdId());
            bundle.putString("adType", adAppReport.getAdType());
            bundle.putString("mediaId", adAppReport.getMediaId());
            bundle.putString("adUnitId", adAppReport.getAdUnitId());
            bundle.putString("mediaRequestId", adAppReport.getMediaRequestId());
            bundle.putString("adRequestId", adAppReport.getAdRequestId());
            bundle.putString("channelInfo", adAppReport.getChannelInfo());
            bundle.putString("extraJson", adAppReport.getExtraJson());
        }
        bundle.putString("key_package_name", downloadInstallTask.getPkgName());
        bundle.putBoolean("key_wifi_required", downloadInstallTask.isWifiRequired());
        bundle.putInt("key_launcher_install_type", downloadInstallTask.getLauncherInstallType());
        if (!TextUtils.isEmpty(downloadInstallTask.getExtraData())) {
            bundle.putString("key_extra_data", downloadInstallTask.getExtraData());
        }
        bundle.putString("key_apk_sign", downloadInstallTask.getApkSign());
        bundle.putBoolean("key_use_dialog_tip", downloadInstallTask.isUseDialogTip());
        DlInstallReportConfig reportConfig = downloadInstallTask.getReportConfig();
        if (reportConfig != null) {
            bundle.putStringArrayList("key_download_start_report_url", new ArrayList<>(reportConfig.getDownloadStartReportUrlList()));
            bundle.putStringArrayList("key_download_success_report_url", new ArrayList<>(reportConfig.getDownloadSuccessReportUrlList()));
            bundle.putStringArrayList("key_download_fail_report_url", new ArrayList<>(reportConfig.getDownloadFailReportUrlList()));
            bundle.putStringArrayList("key_install_start_report_url", new ArrayList<>(reportConfig.getInstallStartReportUrlList()));
            bundle.putStringArrayList("key_install_success_report_url", new ArrayList<>(reportConfig.getInstallSuccessReportUrlList()));
            bundle.putStringArrayList("key_install_fail_report_url", new ArrayList<>(reportConfig.getInstallFailReportUrlList()));
            bundle.putStringArrayList("key_commons_report_url", new ArrayList<>(reportConfig.getCommonsReportUrlList()));
            bundle.putStringArrayList("key_click_report_url", new ArrayList<>(reportConfig.getClickReportUrlList()));
        }
        if (!TextUtils.isEmpty(downloadInstallTask.getPartner())) {
            bundle.putString("key_dispatch_partner", downloadInstallTask.getPartner());
        }
        if (!TextUtils.isEmpty(downloadInstallTask.getAuthSign())) {
            bundle.putString("key_dispatch_auth_sign", downloadInstallTask.getAuthSign());
        }
        if (!TextUtils.isEmpty(downloadInstallTask.getReferrer())) {
            bundle.putString("key_dispatch_referrer", downloadInstallTask.getReferrer());
        }
        if (!TextUtils.isEmpty(downloadInstallTask.getTs())) {
            bundle.putString("key_dispatch_ts", downloadInstallTask.getTs());
        }
        if (!TextUtils.isEmpty(downloadInstallTask.getVersion())) {
            bundle.putString("key_dispatch_version", downloadInstallTask.getVersion());
        }
        if (downloadInstallTask.getClickTime() > 0) {
            bundle.putLong("key_wise_package_clicktime", downloadInstallTask.getClickTime());
        }
        return bundle;
    }

    public static m c() {
        if (g == null) {
            synchronized (m.class) {
                if (g == null) {
                    g = new m();
                }
            }
        }
        return g;
    }

    public final void a() {
        String str;
        if (this.b == null) {
            str = "doBindService: mContext is null";
        } else {
            if (this.d == null) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                com.hihonor.dlinstall.page.a.c("DownloadInstallService", "doBindService: enter nowTimestamp is " + jElapsedRealtime + ",lastBindServiceTimestamp is " + this.e);
                if (jElapsedRealtime - this.e < C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS) {
                    b();
                    return;
                }
                this.e = jElapsedRealtime;
                try {
                    Intent intent = new Intent();
                    intent.setPackage("com.hihonor.appmarket");
                    intent.addCategory("android.intent.category.DEFAULT");
                    intent.setAction("com.hihonor.appmarket.intent.action.DownloadInstallService");
                    com.hihonor.dlinstall.page.a.c("DownloadInstallService", "doBindService: result is " + this.b.bindService(intent, this, 1));
                    b();
                    return;
                } catch (Exception e) {
                    com.hihonor.dlinstall.page.a.b("DownloadInstallService", "doBindService: bindService is error: " + e.getMessage());
                    return;
                }
            }
            str = "doBindService: remoteService isn't null";
        }
        com.hihonor.dlinstall.page.a.d("DownloadInstallService", str);
    }

    public void a(Context context) {
        com.hihonor.dlinstall.page.a.c("DownloadInstallService", "bindService: enter");
        if (this.d != null) {
            com.hihonor.dlinstall.page.a.c("DownloadInstallService", "bindService: enter, remoteService is not null");
            return;
        }
        if (StubApp.getOrigApplicationContext(context.getApplicationContext()) != null) {
            context = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (this.c.hasMessages(1)) {
            return;
        }
        this.c.obtainMessage(1, context).sendToTarget();
    }

    public final void a(Bundle bundle, String str, String str2) {
        bundle.putLong("key_sdk_version", 14L);
        bundle.putString("key_caller_package_name", str);
        bundle.putString("caller_process_name", a(this.b, str2));
    }

    public final void a(String str) {
        com.hihonor.dlinstall.page.a.c("DownloadInstallService", "executeUnbindService: from is " + str);
        this.c.removeMessages(5);
        this.c.obtainMessage(5).sendToTarget();
    }

    public final void b() {
        if (this.c.hasMessages(1)) {
            return;
        }
        this.c.sendMessageDelayed(this.c.obtainMessage(1), C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
    }

    public void b(String str) {
        com.hihonor.dlinstall.page.a.c("DownloadInstallService", "unbindServiceDelay: from is " + str);
        this.c.removeMessages(5);
        this.c.sendMessageDelayed(this.c.obtainMessage(5), 300000L);
    }

    public boolean b(Context context) {
        long serviceVersion = DownloadInstallClient.getServiceVersion(context);
        com.hihonor.dlinstall.page.a.c("DownloadInstallService", "getAppMarketPermission serviceVersion is " + serviceVersion + ",minimumVersion is 4");
        return ((long) 4) > serviceVersion;
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        a("binderDied");
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        o c0476a;
        com.hihonor.dlinstall.page.a.c("DownloadInstallService", "onServiceConnected: enter");
        if (this.b == null) {
            com.hihonor.dlinstall.page.a.d("DownloadInstallService", "onServiceConnected: mContext is null");
            return;
        }
        try {
            this.c.removeMessages(1);
            int i = o.a.f3607a;
            if (iBinder == null) {
                c0476a = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.hihonor.dlinstall.ipc.IDownloadInstallService");
                c0476a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof o)) ? new o.a.C0476a(iBinder) : (o) iInterfaceQueryLocalInterface;
            }
            this.d = c0476a;
            Executors.newCachedThreadPool().submit(new FutureTask(new Callable() { // from class: com.hihonor.dlinstall.ipc.m$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f$0.a(iBinder);
                }
            }));
        } catch (Exception e) {
            com.hihonor.dlinstall.page.a.b("DownloadInstallService", "onServiceConnected: e is " + e.getMessage());
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        a("onServiceDisconnected");
    }

    public String a(Context context, String str) {
        String packageName;
        if (this.f3604a == null || this.f3604a.isEmpty()) {
            String str2 = com.hihonor.dlinstall.util.b.f3612a;
            if (context == null) {
                com.hihonor.dlinstall.page.a.d(str2, "getProcessName: mContext is null");
                packageName = null;
            } else {
                try {
                    int iMyPid = Process.myPid();
                    Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            packageName = context.getPackageName();
                            com.hihonor.dlinstall.page.a.c(com.hihonor.dlinstall.util.b.f3612a, "getProcessName is null,get package name: " + packageName);
                            break;
                        }
                        ActivityManager.RunningAppProcessInfo next = it.next();
                        if (next.pid == iMyPid) {
                            packageName = next.processName;
                            break;
                        }
                        packageName = context.getPackageName();
                        com.hihonor.dlinstall.page.a.c(com.hihonor.dlinstall.util.b.f3612a, "getProcessName is null,get package name: " + packageName);
                        break;
                    }
                } catch (Exception e) {
                    com.hihonor.dlinstall.page.a.b(com.hihonor.dlinstall.util.b.f3612a, "getProcessName is error:  " + e.getMessage());
                }
            }
            this.f3604a = packageName;
            com.hihonor.dlinstall.page.a.c("DownloadInstallService", "checkPkgProcessName:" + str + " again get mProcessName :" + this.f3604a);
        }
        return this.f3604a;
    }

    public final <T> void a(o oVar, b<T> bVar) {
        a<T> aVar;
        com.hihonor.dlinstall.page.a.c("DownloadInstallService", "doExecuteCommand(IDownloadInstallService service, Command command)");
        if (bVar != null && (aVar = bVar.action) != null) {
            try {
                aVar.onSuccessAction(oVar, bVar.params);
                return;
            } catch (Exception e) {
                com.hihonor.dlinstall.page.a.b("DownloadInstallService", "doExecuteCommand e is " + e.getMessage());
                try {
                    bVar.action.onErrorAction(bVar.params, 10001, "remote exception");
                    return;
                } catch (Exception e2) {
                    com.hihonor.dlinstall.page.a.b("DownloadInstallService", "doExecuteErrorCommand e is " + e2.getMessage());
                    return;
                }
            }
        }
        com.hihonor.dlinstall.page.a.d("DownloadInstallService", "doExecuteCommand command or command.action is null");
    }

    public final <T> void a(Context context, b<T> bVar) {
        String str = bVar.command;
        long serviceVersion = DownloadInstallClient.getServiceVersion(context);
        if (!TextUtils.equals(str, String.valueOf(8)) ? !(!TextUtils.equals(str, String.valueOf(9)) ? !(!TextUtils.equals(str, String.valueOf(10)) || serviceVersion >= 8) : serviceVersion < 7) : serviceVersion < 6) {
            this.c.obtainMessage(2, bVar).sendToTarget();
            b("executeCommand " + bVar.command);
        } else {
            bVar.action.onErrorAction(bVar.params, 10006, "no support");
            com.hihonor.dlinstall.page.a.d("DownloadInstallService", "executeCommand: cmd is " + bVar.command + " no support");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object a(IBinder iBinder) throws Exception {
        if (this.d != null) {
            com.hihonor.dlinstall.ipc.a aVar = new com.hihonor.dlinstall.ipc.a(this, com.hihonor.dlinstall.ipc.b.a());
            String strA = a(this.b, "onServiceConnected");
            this.d.a(strA, aVar);
            com.hihonor.dlinstall.page.a.c("DownloadInstallService", "registerListener success callerPkgName : " + strA);
        } else {
            com.hihonor.dlinstall.page.a.d("DownloadInstallService", "onServiceConnected: remoteService is null");
        }
        this.c.obtainMessage(3).sendToTarget();
        iBinder.linkToDeath(this, 0);
        return null;
    }
}
