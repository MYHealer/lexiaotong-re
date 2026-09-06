package com.hihonor.adsdk.common.f;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b0 {
    private static final String hnadsa = "ToastUtil";
    private static final int hnadsb = 1000;
    private static long hnadsc = -1;

    class a implements Runnable {
        final /* synthetic */ Context hnadsd;
        final /* synthetic */ CharSequence hnadse;
        final /* synthetic */ int hnadsf;

        a(Context context, CharSequence charSequence, int i) {
            this.hnadsd = context;
            this.hnadse = charSequence;
            this.hnadsf = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast.makeText(this.hnadsd, this.hnadse, this.hnadsf).show();
        }
    }

    public static void hnadsa(String str) {
        hnadsa(str, 1);
    }

    public static void hnadsb(String str) {
        hnadsa(str, 0);
    }

    public static void hnadsc(int i) {
        hnadsa(i, 0);
    }

    public static void hnadsa(int i) {
        hnadsa(i, 1);
    }

    public static void hnadsb(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - hnadsc > 1000) {
            hnadsc = jCurrentTimeMillis;
            hnadsa(i, 0);
        }
    }

    private static void hnadsa(int i, int i2) {
        Context contextHnadsb = com.hihonor.adsdk.common.a.hnadsa().hnadsb();
        if (contextHnadsb == null) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "realShowToast, context is null, can not be displayed messageId", new Object[0]);
        } else {
            hnadsa(contextHnadsb.getResources().getText(i), i2);
        }
    }

    private static void hnadsa(CharSequence charSequence, int i) {
        Context contextHnadsb = com.hihonor.adsdk.common.a.hnadsa().hnadsb();
        if (contextHnadsb == null) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "realShowToast, context is null, can not be displayed text", new Object[0]);
            return;
        }
        if (TextUtils.isEmpty(charSequence)) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "realShowToast, text is isEmpty, can not be displayed text", new Object[0]);
        } else if (a0.hnadsd()) {
            Toast.makeText(contextHnadsb, charSequence, i).show();
        } else {
            a0.hnadsc(new a(contextHnadsb, charSequence, i));
        }
    }
}
