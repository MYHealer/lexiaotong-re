package com.miui.zeus.mimo.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class p extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n f5557a;
    public final String b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Intent f5558a;
        public final /* synthetic */ String b;

        public a(Intent intent, String str) {
            this.f5558a = intent;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            n nVar;
            String str2;
            n nVar2;
            int intExtra = this.f5558a.getIntExtra(ijiami_1011.s.s.s.d(new byte[]{6, 16, 16, 87, 69, 33, 14, 0, 3}, "cbb87b"), Integer.MIN_VALUE);
            int intExtra2 = this.f5558a.getIntExtra(ijiami_1011.s.s.s.d(new byte[]{19, 19, 10, 86, 19, 0, Ascii.DC2, Ascii.ETB}, "cae1ae"), Integer.MIN_VALUE);
            int intExtra3 = this.f5558a.getIntExtra(ijiami_1011.s.s.s.d(new byte[]{74, 70, 84, Ascii.DC2, 67, Ascii.SYN}, "925f6e"), Integer.MIN_VALUE);
            m.a(ijiami_1011.s.s.s.d(new byte[]{127, 81, 69, 95, 92, Ascii.NAK, 37, 11, 17, 12, 93, 10, 83, 84, 117, 70, 86, 0, 5, 7, 7, 17, 69, 55, 87, 83, 82, 93, 79, 4, 19}, "20749a"), ijiami_1011.s.s.s.d(new byte[]{6, 91, 92, 7, 15}, "e48b2f") + intExtra + ijiami_1011.s.s.s.d(new byte[]{79, 19, 71, 10, 95, 69, 4, Ascii.ETB, Ascii.NAK, 95}, "cc5e87") + intExtra2 + ijiami_1011.s.s.s.d(new byte[]{Ascii.ESC, Ascii.ETB, 68, 0, 68, SignedBytes.MAX_POWER_OF_TWO, Ascii.DC2, 89}, "7d0a05") + intExtra3);
            if (intExtra != -8) {
                if (intExtra == -4) {
                    p pVar = p.this;
                    str2 = this.b;
                    pVar.getClass();
                    m.a(ijiami_1011.s.s.s.d(new byte[]{120, 7, 19, 90, 7, 67, 37, 11, 17, 12, 93, 10, 84, 2, 35, 67, 13, 86, 5, 7, 7, 17, 69, 55, 80, 5, 4, 88, Ascii.DC4, 82, 19}, "5fa1b7"), ijiami_1011.s.s.s.d(new byte[]{86, 89, 125, 90, 65, 10, 13, 11, 7, 6, 119, 4, 80, 91}, "97956d"));
                    nVar2 = pVar.f5557a;
                    if (nVar2 == null) {
                        return;
                    }
                } else {
                    if (intExtra == -3) {
                        p pVar2 = p.this;
                        String str3 = this.b;
                        pVar2.getClass();
                        m.a(ijiami_1011.s.s.s.d(new byte[]{126, 5, 74, 8, 87, 69, 37, 11, 17, 12, 93, 10, 82, 0, 122, 17, 93, 80, 5, 7, 7, 17, 69, 55, 86, 7, 93, 10, 68, 84, 19}, "3d8c21"), ijiami_1011.s.s.s.d(new byte[]{14, 90, 121, 88, 16, Ascii.SYN, 0, 8, 10, 36, 80, 12, 13}, "a406cb"));
                        n nVar3 = pVar2.f5557a;
                        if (nVar3 != null) {
                            nVar3.onInstallFailed(str3, intExtra3);
                            return;
                        }
                        return;
                    }
                    if (intExtra != -2) {
                        if (intExtra == -1) {
                            p pVar3 = p.this;
                            String str4 = this.b;
                            n nVar4 = pVar3.f5557a;
                            if (nVar4 != null) {
                                nVar4.onExistDownload(str4);
                                return;
                            }
                            return;
                        }
                        if (intExtra == 1) {
                            p pVar4 = p.this;
                            String str5 = this.b;
                            pVar4.getClass();
                            m.a(ijiami_1011.s.s.s.d(new byte[]{125, 89, 17, 15, 87, 68, 37, 11, 17, 12, 93, 10, 81, 92, 33, Ascii.SYN, 93, 81, 5, 7, 7, 17, 69, 55, 85, 91, 6, 13, 68, 85, 19}, "08cd20"), ijiami_1011.s.s.s.d(new byte[]{87, 15, 117, 86, 66, 12, 13, 11, 7, 6, 98, 17, 89, 19, 69}, "8a195b"));
                            n nVar5 = pVar4.f5557a;
                            if (nVar5 != null) {
                                nVar5.onDownloadStarted(str5);
                                return;
                            }
                            return;
                        }
                        if (intExtra == 2) {
                            p pVar5 = p.this;
                            String str6 = this.b;
                            pVar5.getClass();
                            m.a(ijiami_1011.s.s.s.d(new byte[]{120, 85, 16, 89, 80, 71, 37, 11, 17, 12, 93, 10, 84, 80, 32, SignedBytes.MAX_POWER_OF_TWO, 90, 82, 5, 7, 7, 17, 69, 55, 80, 87, 7, 91, 67, 86, 19}, "54b253"), ijiami_1011.s.s.s.d(new byte[]{92, 10, 118, 88, 70, 87, 13, 11, 7, 6, 98, 16, 80, 7, 87, 68, 66}, "3d2719"));
                            n nVar6 = pVar5.f5557a;
                            if (nVar6 != null) {
                                nVar6.onDownloadFinished(str6);
                                return;
                            }
                            return;
                        }
                        if (intExtra == 3) {
                            p pVar6 = p.this;
                            String str7 = this.b;
                            pVar6.getClass();
                            m.a(ijiami_1011.s.s.s.d(new byte[]{125, 82, Ascii.ETB, 91, 92, 16, 37, 11, 17, 12, 93, 10, 81, 87, 39, 66, 86, 5, 5, 7, 7, 17, 69, 55, 85, 80, 0, 89, 79, 1, 19}, "03e09d"), ijiami_1011.s.s.s.d(new byte[]{11, 95, 120, 94, 67, Ascii.NAK, 0, 8, 10, 49, 69, 4, Ascii.SYN, 69}, "d1100a"));
                            n nVar7 = pVar6.f5557a;
                            if (nVar7 != null) {
                                nVar7.onInstallStart(str7);
                                return;
                            }
                            return;
                        }
                        if (intExtra == 4) {
                            p pVar7 = p.this;
                            String str8 = this.b;
                            pVar7.getClass();
                            m.a(ijiami_1011.s.s.s.d(new byte[]{126, 82, 71, 8, 84, 71, 37, 11, 17, 12, 93, 10, 82, 87, 119, 17, 94, 82, 5, 7, 7, 17, 69, 55, 86, 80, 80, 10, 71, 86, 19}, "335c13"), ijiami_1011.s.s.s.d(new byte[]{93, 94, 43, 93, 16, 17, 0, 8, 10, 49, 68, 6, 81, 85, 17, SignedBytes.MAX_POWER_OF_TWO}, "20b3ce"));
                            n nVar8 = pVar7.f5557a;
                            if (nVar8 != null) {
                                nVar8.onInstallSuccess(str8);
                                return;
                            }
                            return;
                        }
                        if (intExtra != 5) {
                            return;
                        }
                        if (intExtra3 == -3) {
                            p pVar8 = p.this;
                            String str9 = this.b;
                            pVar8.getClass();
                            m.a(ijiami_1011.s.s.s.d(new byte[]{122, 80, Ascii.SYN, 94, 82, 70, 37, 11, 17, 12, 93, 10, 86, 85, 38, 71, 88, 83, 5, 7, 7, 17, 69, 55, 82, 82, 1, 92, 65, 87, 19}, "71d572"), ijiami_1011.s.s.s.d(new byte[]{11, 13, 39, 93, 71, 15, 13, 11, 7, 6, 97, 4, 17, 16, 6}, "dcc20a"));
                            n nVar9 = pVar8.f5557a;
                            if (nVar9 != null) {
                                nVar9.onDownloadPaused(str9);
                                return;
                            }
                            return;
                        }
                        if (intExtra3 != -2) {
                            return;
                        }
                        p pVar9 = p.this;
                        String str10 = this.b;
                        pVar9.getClass();
                        m.a(ijiami_1011.s.s.s.d(new byte[]{46, 0, 69, 14, 87, 71, 37, 11, 17, 12, 93, 10, 2, 5, 117, Ascii.ETB, 93, 82, 5, 7, 7, 17, 69, 55, 6, 2, 82, 12, 68, 86, 19}, "ca7e23"), ijiami_1011.s.s.s.d(new byte[]{92, 86, 39, 9, 69, 8, 13, 11, 7, 6, 88, 11, 84, 104, 17, 9, 85, Ascii.DC4, 4, Ascii.ETB, Ascii.NAK}, "38cf2f"));
                        n nVar10 = pVar9.f5557a;
                        if (nVar10 != null) {
                            nVar10.onDownloadProgressUpdated(str10, intExtra2);
                            return;
                        }
                        return;
                    }
                    if (s.d) {
                        p pVar10 = p.this;
                        str = this.b;
                        pVar10.getClass();
                        m.a(ijiami_1011.s.s.s.d(new byte[]{122, 88, 69, 9, 80, 71, 37, 11, 17, 12, 93, 10, 86, 93, 117, 16, 90, 82, 5, 7, 7, 17, 69, 55, 82, 90, 82, 11, 67, 86, 19}, "797b53"), ijiami_1011.s.s.s.d(new byte[]{11, 11, 114, 82, 11, 81, 4, 8, 34, 13, 70, 11, 8, 10, 80, 87}, "de13e2"));
                        nVar = pVar10.f5557a;
                        if (nVar == null) {
                            return;
                        }
                    } else {
                        p pVar11 = p.this;
                        str2 = this.b;
                        pVar11.getClass();
                        m.a(ijiami_1011.s.s.s.d(new byte[]{123, 2, 71, 82, 80, 16, 37, 11, 17, 12, 93, 10, 87, 7, 119, 75, 90, 5, 5, 7, 7, 17, 69, 55, 83, 0, 80, 80, 67, 1, 19}, "6c595d"), ijiami_1011.s.s.s.d(new byte[]{94, 87, 124, 95, 65, 10, 13, 11, 7, 6, 119, 4, 88, 85}, "19806d"));
                        nVar2 = pVar11.f5557a;
                        if (nVar2 == null) {
                            return;
                        }
                    }
                }
                nVar2.onDownloadFailed(str2, intExtra);
                return;
            }
            p pVar12 = p.this;
            str = this.b;
            pVar12.getClass();
            m.a(ijiami_1011.s.s.s.d(new byte[]{120, 89, SignedBytes.MAX_POWER_OF_TWO, 89, 93, SignedBytes.MAX_POWER_OF_TWO, 37, 11, 17, 12, 93, 10, 84, 92, 112, SignedBytes.MAX_POWER_OF_TWO, 87, 85, 5, 7, 7, 17, 69, 55, 80, 91, 87, 91, 78, 81, 19}, "582284"), ijiami_1011.s.s.s.d(new byte[]{13, 94, 117, 86, 8, 2, 4, 8, 34, 13, 70, 11, 14, 95, 87, 83}, "b067fa"));
            nVar = pVar12.f5557a;
            if (nVar == null) {
                return;
            }
            nVar.onCancelDownload(str);
        }
    }

    public p(String str) {
        this.b = str;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || TextUtils.isEmpty(intent.getAction())) {
            return;
        }
        String action = intent.getAction();
        m.a(ijiami_1011.s.s.s.d(new byte[]{124, 4, 70, 10, 6, 71, 37, 11, 17, 12, 93, 10, 80, 1, 118, 19, 12, 82, 5, 7, 7, 17, 69, 55, 84, 6, 81, 8, Ascii.NAK, 86, 19}, "1e4ac3"), ijiami_1011.s.s.s.d(new byte[]{81, 85, 67, 94, 13, 12, 92}, "0677bb") + action);
        if (ijiami_1011.s.s.s.d(new byte[]{2, 93, 88, 75, 65, 95, 0, 11, 11, 11, Ascii.US, 8, 0, SignedBytes.MAX_POWER_OF_TWO, 94, 0, 77, Ascii.CAN, 37, 43, 49, 44, 125, 42, 32, 118, 106, 44, 119, 101, 53, 37, 42, 46, 110, 55, 36, 97, 96, 41, 109}, "a25e96").equals(action)) {
            String stringExtra = intent.getStringExtra(ijiami_1011.s.s.s.d(new byte[]{Ascii.DC2, 82, 2, 94, 5, 80, 4, 42, 7, 15, 84}, "b3a5d7"));
            m.a(ijiami_1011.s.s.s.d(new byte[]{121, 7, 65, 9, 81, 16, 37, 11, 17, 12, 93, 10, 85, 2, 113, 16, 91, 5, 5, 7, 7, 17, 69, 55, 81, 5, 86, 11, 66, 1, 19}, "4f3b4d"), ijiami_1011.s.s.s.d(new byte[]{71, 5, 85, 92, 0, 85, 4, 42, 7, 15, 84, 88}, "7d67a2") + stringExtra + ijiami_1011.s.s.s.d(new byte[]{Ascii.SYN, 26, Ascii.CAN, 95, 103, 85, 2, 15, 7, 5, 84, 43, 87, 91, 93, Ascii.DC2, 10, Ascii.DC4}, "668274") + this.b);
            if (TextUtils.isEmpty(this.b) || TextUtils.equals(this.b, stringExtra)) {
                x8.i.execute(new a(intent, stringExtra));
            }
        }
    }
}
