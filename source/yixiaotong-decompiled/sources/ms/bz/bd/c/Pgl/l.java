package ms.bz.bd.c.Pgl;

import android.telephony.TelephonyManager;
import com.google.common.base.Ascii;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
final class l extends pblz.pgla {
    l() {
    }

    @Override // ms.bz.bd.c.Pgl.pblz.pgla
    public final Object c(long j, String str, Object obj) throws Throwable {
        Boolean bool = Boolean.FALSE;
        TelephonyManager telephonyManager = (TelephonyManager) StubApp.getOrigApplicationContext(pblw.c().tt().getApplicationContext()).getSystemService((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "86bdca", new byte[]{57, 60, Ascii.RS, Ascii.RS, 89}));
        return (telephonyManager == null || telephonyManager.getSimState() != 5) ? bool : Boolean.TRUE;
    }
}
