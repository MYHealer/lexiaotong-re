package com.unionpay.b;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.unionpay.UPSEInfoResp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class c implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f9310a;

    c(b bVar) {
        this.f9310a = bVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        String str;
        int iIntValue;
        int i = message.what;
        if (i != 1) {
            if (i != 4) {
                switch (i) {
                    case 4000:
                        this.f9310a.j.removeMessages(4);
                        b.a(this.f9310a, (Bundle) message.obj);
                        break;
                    case 4001:
                        this.f9310a.j.removeMessages(4003);
                        if (message.obj instanceof Bundle) {
                            b.b(this.f9310a, (Bundle) message.obj);
                        }
                        break;
                    case 4002:
                        this.f9310a.j.removeMessages(4003);
                        if (message.obj instanceof Bundle) {
                            b.c(this.f9310a, (Bundle) message.obj);
                        }
                        break;
                    case 4003:
                        str = "queryHwPayStatus timeout";
                        break;
                    case 4004:
                        this.f9310a.j.removeMessages(4005);
                        try {
                            iIntValue = ((Integer) message.obj).intValue();
                        } catch (Exception unused) {
                            iIntValue = 0;
                        }
                        if (!this.f9310a.g) {
                            if (iIntValue != 1) {
                                this.f9310a.c();
                            } else {
                                b.e(this.f9310a);
                            }
                        }
                        break;
                    case 4005:
                        com.unionpay.utils.j.c("uppay", "QUERY_VENDOR_CAPACITY_TIMEOUT");
                        b.g(this.f9310a);
                        this.f9310a.c();
                        break;
                }
            } else {
                str = "timeout";
            }
            com.unionpay.utils.j.c("uppay", str);
            b bVar = this.f9310a;
            bVar.a(bVar.d, bVar.e, UPSEInfoResp.ERROR_TIMEOUT, "timeout");
            b.c(this.f9310a);
        } else {
            this.f9310a.j.removeMessages(4);
            com.unionpay.utils.j.c("uppay", "msg error");
            b.a(this.f9310a, message.arg1, (String) message.obj);
        }
        return false;
    }
}
