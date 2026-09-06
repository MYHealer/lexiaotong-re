package com.unionpay;

import android.os.Message;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class b implements Runnable {
    b() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            UPPayAssistEx.W.sendEmptyMessageDelayed(1001, 800L);
            com.unionpay.a.c cVar = new com.unionpay.a.c(UPPayAssistEx.V, com.unionpay.utils.b.a(UPPayAssistEx.q()));
            cVar.a();
            String strB = cVar.b();
            if (UPPayAssistEx.W != null) {
                Message messageObtainMessage = UPPayAssistEx.W.obtainMessage();
                messageObtainMessage.what = 1002;
                messageObtainMessage.obj = strB;
                UPPayAssistEx.W.removeMessages(1001);
                UPPayAssistEx.W.sendMessage(messageObtainMessage);
            }
        } catch (Exception unused) {
        }
    }
}
