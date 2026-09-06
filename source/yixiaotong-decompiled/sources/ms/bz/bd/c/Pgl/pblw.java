package ms.bz.bd.c.Pgl;

import android.content.Context;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class pblw {
    private static final pblw c = new pblw();
    private Context tt;

    public static pblw c() {
        return c;
    }

    public final void c(Context context) {
        this.tt = context != null ? StubApp.getOrigApplicationContext(context.getApplicationContext()) : null;
    }

    public final Context tt() {
        return this.tt;
    }
}
