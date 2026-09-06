package com.huawei.hms.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.msgnotify.NotifyCallback;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class dn {
    private static dn V;
    private static final byte[] Z = new byte[0];
    private BroadcastReceiver B;
    private Context I;

    /* JADX INFO: renamed from: com.huawei.hms.ads.dn$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IntentFilter intentFilter = new IntentFilter("com.huawei.hms.pps.action.PPS_REWARD_STATUS_CHANGED");
            dn.this.B = new a(null);
            if (com.huawei.openalliance.ad.utils.z.B(dn.this.I)) {
                com.huawei.openalliance.ad.utils.z.Code(dn.this.I, dn.this.B, intentFilter, "com.huawei.permission.app.DOWNLOAD", null);
            } else {
                com.huawei.openalliance.ad.msgnotify.b.Code(dn.this.I, com.huawei.openalliance.ad.constant.bq.Code, new NotifyCallback() { // from class: com.huawei.hms.ads.dn.1.1
                    @Override // com.huawei.openalliance.ad.msgnotify.NotifyCallback
                    public void onMessageNotify(String str, final Intent intent) {
                        com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.dn.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (dn.this.B != null) {
                                    dn.this.B.onReceive(dn.this.I, intent);
                                }
                            }
                        });
                    }
                });
            }
            fh.V("RewardAdStatusHandler", "registerPPSReceiver");
        }
    }

    private static class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        private boolean Code(int i, com.huawei.openalliance.ad.inter.listeners.h hVar) {
            if (hVar == null) {
                return false;
            }
            if (8 == i) {
                hVar.S();
                return true;
            }
            if (9 != i) {
                return false;
            }
            hVar.C();
            return true;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            StringBuilder sb;
            fh.V("RewardAdStatusHandler", "onReceive:" + intent.getAction());
            if ("com.huawei.hms.pps.action.PPS_REWARD_STATUS_CHANGED".equals(intent.getAction())) {
                try {
                    com.huawei.openalliance.ad.inter.data.i iVarCode = dl.Code();
                    if (iVarCode != null && (iVarCode instanceof com.huawei.openalliance.ad.inter.data.q)) {
                        com.huawei.openalliance.ad.inter.data.q qVar = (com.huawei.openalliance.ad.inter.data.q) iVarCode;
                        com.huawei.openalliance.ad.inter.listeners.g gVarZ = qVar.Z();
                        com.huawei.openalliance.ad.inter.listeners.h hVarI = qVar.I();
                        int intExtra = intent.getIntExtra("reward_ad_status", -1);
                        String stringExtra = intent.getStringExtra("show_id");
                        fh.V("RewardAdStatusHandler", "status:" + intExtra);
                        if (Code(intExtra, hVarI)) {
                            return;
                        }
                        if (gVarZ == null) {
                            fh.I("RewardAdStatusHandler", "there is no status listener");
                            return;
                        }
                        switch (intExtra) {
                            case 1:
                                gVarZ.Code();
                                qVar.Z(true);
                                break;
                            case 2:
                                gVarZ.V();
                                break;
                            case 3:
                                gVarZ.I();
                                break;
                            case 4:
                                gVarZ.Z();
                                break;
                            case 5:
                                if (!qVar.F()) {
                                    gVarZ.B();
                                    qVar.I(true);
                                    AdContentData adContentDataQ = qVar.q();
                                    adContentDataQ.I(stringExtra);
                                    jk.Code(context, adContentDataQ, qVar.N(), qVar.O(), "");
                                }
                                break;
                            case 6:
                                gVarZ.Code(intent.getIntExtra("reward_ad_error", -1), intent.getIntExtra("reward_ad_extra", -1));
                                break;
                            case 7:
                                if (dn.V != null) {
                                    dn.V.V();
                                }
                                break;
                            default:
                                break;
                        }
                    }
                    fh.I("RewardAdStatusHandler", "can not get reward");
                } catch (Exception e) {
                    e = e;
                    sb = new StringBuilder("handler reward status changed error,");
                    fh.Z("RewardAdStatusHandler", sb.append(e.getClass().getSimpleName()).toString());
                } catch (Throwable th) {
                    e = th;
                    sb = new StringBuilder("handler reward status changed error,");
                    fh.Z("RewardAdStatusHandler", sb.append(e.getClass().getSimpleName()).toString());
                }
            }
        }
    }

    private dn(Context context) {
        this.I = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    public static dn Code(Context context) {
        return V(context);
    }

    private static dn V(Context context) {
        dn dnVar;
        synchronized (Z) {
            if (V == null) {
                V = new dn(context);
            }
            dnVar = V;
        }
        return dnVar;
    }

    public void Code() {
        if (this.B != null) {
            V();
        }
        com.huawei.openalliance.ad.utils.bj.Code(new AnonymousClass1());
    }

    public void V() {
        if (this.B != null) {
            com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.dn.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        fh.V("RewardAdStatusHandler", "unregisterPPSReceiver");
                        dn.this.I.unregisterReceiver(dn.this.B);
                    } catch (Throwable th) {
                        try {
                            fh.V("RewardAdStatusHandler", "unregister error," + th.getClass().getSimpleName());
                        } finally {
                            dn.this.B = null;
                        }
                    }
                }
            });
        }
        com.huawei.openalliance.ad.msgnotify.b.Code(this.I, com.huawei.openalliance.ad.constant.bq.Code);
    }
}
