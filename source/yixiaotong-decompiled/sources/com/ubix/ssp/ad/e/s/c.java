package com.ubix.ssp.ad.e.s;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.stub.StubApp;
import com.ubix.ssp.ad.e.a0.m;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.open.AdError;
import com.yfanads.android.adx.thirdpart.filedownload.model.FileDownloadModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f8852a;
    private ConcurrentHashMap<Integer, e> b = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Integer, ArrayList<Integer>> c = new ConcurrentHashMap<>();
    private a d = new a(this);

    private static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ConcurrentHashMap<Integer, ArrayList<Integer>> f8853a;
        ConcurrentHashMap<Integer, e> b;

        public a(c cVar) {
            super(Looper.getMainLooper());
            this.b = cVar.b;
            this.f8853a = cVar.c;
        }

        private void a(Context context, int i, com.ubix.ssp.ad.e.s.g.a aVar) {
            if (aVar == null || aVar.c() == null || aVar.c().b == null) {
                return;
            }
            f.a(context, i, aVar);
        }

        private void a(com.ubix.ssp.ad.e.s.g.a aVar) {
            try {
                if (aVar.c() == null || aVar.c().b == null) {
                    return;
                }
                f.a(aVar.c().b, aVar.d());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void a(com.ubix.ssp.ad.e.s.g.a aVar, String str) {
            try {
                if (aVar.c() == null || aVar.c().b == null) {
                    return;
                }
                f.a(aVar.c().b, str, aVar.d());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void a(String str, int i, int i2) {
            a(str, i, i2, null);
        }

        /* JADX WARN: Code duplicated, block: B:29:0x0093  */
        private void a(String str, int i, int i2, int i3, AdError adError, String str2) {
            e eVar = this.b.get(Integer.valueOf(i));
            u.e("action=" + str + ";" + i + ";" + i2 + ";" + eVar);
            if (str.equals("ACTION_LOADING")) {
                if (eVar != null) {
                    eVar.c(i, i3);
                }
            } else if (str.equals("ACTION_COMPLETE")) {
                if (eVar != null) {
                    eVar.a(i, str2);
                }
            } else if (str.equals("ACTION_PREPARE")) {
                if (eVar != null) {
                    eVar.a(i);
                }
            } else if (str.equals("ACTION_FAIL")) {
                if (eVar != null) {
                    eVar.a(i, adError, str2);
                }
            } else if (str.equals("ACTION_PAUSE")) {
                if (eVar != null) {
                    eVar.a(i, i3);
                }
            } else if (str.equals("ACTION_RESUME")) {
                if (eVar != null) {
                    eVar.b(i, i3);
                }
            } else if (str.equals("ACTION_DUPLICATE") && eVar != null) {
                eVar.a(i);
            }
            if (this.f8853a.get(Integer.valueOf(i2)) != null) {
                for (Integer num : this.f8853a.get(Integer.valueOf(i2))) {
                    if (num != null) {
                        a(str, num.intValue(), 0, i3, adError, str2);
                    }
                }
            }
        }

        private void a(String str, int i, int i2, int i3, String str2) {
            a(str, i, i2, i3, null, str2);
        }

        private void a(String str, int i, int i2, AdError adError) {
            a(str, i, i2, 0, adError, null);
        }

        private int b(com.ubix.ssp.ad.e.s.g.a aVar) {
            com.ubix.ssp.ad.e.s.g.b bVarB;
            if (aVar == null || (bVarB = aVar.b()) == null || bVarB.g() == 0) {
                return 0;
            }
            aVar.a((int) ((bVarB.a() * 100) / bVarB.g()));
            return aVar.e();
        }

        private void c(com.ubix.ssp.ad.e.s.g.a aVar) {
            try {
                aVar.b().b(45);
                if (aVar.c() == null || aVar.c().b == null) {
                    return;
                }
                f.b(aVar.c().b, aVar.d());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void d(com.ubix.ssp.ad.e.s.g.a aVar) {
            if (aVar != null) {
                try {
                    if (aVar.c() == null || aVar.c().b == null) {
                        return;
                    }
                    f.a(aVar);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        private void e(com.ubix.ssp.ad.e.s.g.a aVar) {
            if (aVar != null) {
                try {
                    if (aVar.c() == null || aVar.c().b == null) {
                        return;
                    }
                    f.a(aVar.c().b, aVar.d(), b(aVar));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int iB;
            String action;
            super.handleMessage(message);
            Context context = (Context) message.obj;
            Intent intent = (Intent) message.getData().getParcelable(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
            if (intent == null) {
                return;
            }
            int intExtra = intent.getIntExtra("service_intent_notify_id", -1);
            int intExtra2 = intent.getIntExtra("service_intent_unique_id", -1);
            u.b("intent=" + intent.getAction() + ";" + intExtra);
            com.ubix.ssp.ad.e.s.g.a aVarC = b.c().c(intExtra);
            if (!intent.getAction().equals("ACTION_PREPARE")) {
                if (!intent.getAction().equals("ACTION_LOADING")) {
                    if (intent.getAction().equals("ACTION_PAUSE")) {
                        c(aVarC);
                    } else {
                        if (intent.getAction().equals("ACTION_WAIT")) {
                            return;
                        }
                        if (intent.getAction().equals("ACTION_COMPLETE")) {
                            if (aVarC != null) {
                                a("ACTION_LOADING", intExtra, intExtra2, 100, null);
                                a(intent.getAction(), intExtra, intExtra2, b(aVarC), aVarC.a().getPath());
                                e(aVarC);
                                a(context, intExtra, aVarC);
                                b.c().a(context, aVarC.b(), aVarC.d(), intExtra);
                                return;
                            }
                            return;
                        }
                        if (intent.getAction().equals("ACTION_FAIL")) {
                            if (aVarC != null) {
                                a(intent.getAction(), intExtra, intExtra2, 0, (AdError) intent.getSerializableExtra("error"), aVarC.b().e());
                            }
                            a(aVarC);
                            d(aVarC);
                            return;
                        }
                        if (intent.getAction().equals("ACTION_USER_OPERATION")) {
                            if (aVarC != null) {
                                if (aVarC.b().b() == 46) {
                                    b.c().a(context, aVarC.b(), aVarC.d(), intExtra);
                                    f.a(aVarC.d());
                                    return;
                                } else if (aVarC.b().b() != 45) {
                                    b.c().a(context, intExtra);
                                    return;
                                } else {
                                    b.c().b(context, intExtra);
                                    return;
                                }
                            }
                            return;
                        }
                        if (intent.getAction().equals("ACTION_RESUME")) {
                            iB = b(aVarC);
                            action = "ACTION_RESUME";
                        } else {
                            if (intent.getAction().equals("ACTION_BIND")) {
                                if (aVarC != null) {
                                    int intExtra3 = intent.getIntExtra("service_intent_notify_id", -1);
                                    int intExtra4 = intent.getIntExtra("service_intent_fellow_notify_ids", -1);
                                    if (intExtra4 != -1 && intExtra4 == intExtra2 && aVarC.d() != intExtra3) {
                                        e eVar = this.b.get(Integer.valueOf(intExtra));
                                        if (eVar != null) {
                                            eVar.a(intExtra);
                                        }
                                        if (this.f8853a.get(Integer.valueOf(intExtra4)) == null) {
                                            ArrayList<Integer> arrayList = new ArrayList<>();
                                            arrayList.add(Integer.valueOf(intExtra));
                                            this.f8853a.put(Integer.valueOf(intExtra2), arrayList);
                                        } else {
                                            this.f8853a.get(Integer.valueOf(intExtra4)).add(Integer.valueOf(intExtra));
                                        }
                                    }
                                }
                                f.a(intExtra);
                                return;
                            }
                            if (!intent.getAction().equals("ACTION_DUPLICATE")) {
                                if (intent.getAction().equals("ACTION_NEW_NAME")) {
                                    a(aVarC, intent.getStringExtra(FileDownloadModel.FILENAME));
                                    return;
                                }
                                return;
                            }
                        }
                    }
                    a(action, intExtra, intExtra2, iB, null);
                    return;
                }
                e(aVarC);
                action = intent.getAction();
                iB = b(aVarC);
                a(action, intExtra, intExtra2, iB, null);
                return;
            }
            a(intent.getAction(), intExtra, intExtra2);
        }
    }

    private c() {
    }

    public static c a() {
        if (f8852a == null) {
            f8852a = new c();
        }
        return f8852a;
    }

    public void a(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ACTION_FAIL");
        intentFilter.addAction("ACTION_LOADING");
        intentFilter.addAction("ACTION_PAUSE");
        intentFilter.addAction("ACTION_RESUME");
        intentFilter.addAction("ACTION_WAIT");
        intentFilter.addAction("ACTION_PREPARE");
        intentFilter.addAction("ACTION_COMPLETE");
        intentFilter.addAction("ACTION_USER_OPERATION");
        intentFilter.addAction("ACTION_BIND");
        intentFilter.addAction("ACTION_DUPLICATE");
        intentFilter.addAction("ACTION_NEW_NAME");
        m.a(StubApp.getOrigApplicationContext(context.getApplicationContext())).a(this, intentFilter);
    }

    public void a(e eVar) {
        u.e("DownloadStatusListener addListener " + eVar);
        if (eVar == null || this.b.get(Integer.valueOf(eVar.a())) != null) {
            return;
        }
        this.b.put(Integer.valueOf(eVar.a()), eVar);
    }

    public void a(e eVar, String str) {
        try {
            u.e("DownloadStatusListener removeListener " + eVar);
            if (this.c.size() > 0 && this.c.get(Integer.valueOf(eVar.a())) != null) {
                Iterator<Integer> it = this.c.get(Integer.valueOf(eVar.a())).iterator();
                while (it.hasNext()) {
                    int iIntValue = it.next().intValue();
                    if (this.b.get(Integer.valueOf(iIntValue)) != null) {
                        this.b.get(Integer.valueOf(iIntValue)).a(iIntValue, str);
                    }
                }
                this.c.remove(Integer.valueOf(eVar.a()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (eVar != null) {
            this.b.remove(Integer.valueOf(eVar.a()));
        }
    }

    public boolean b(e eVar) {
        if (eVar != null) {
            return this.b.containsValue(eVar);
        }
        return false;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Message message = new Message();
        message.obj = context;
        Bundle bundle = new Bundle();
        bundle.putParcelable(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, intent);
        message.setData(bundle);
        this.d.sendMessage(message);
    }
}
