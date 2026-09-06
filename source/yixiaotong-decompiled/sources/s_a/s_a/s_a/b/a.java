package s_a.s_a.s_a.b;

import android.app.OplusNotificationManager;
import android.os.Build;
import android.util.Log;
import com.android.id.impl.IdProviderImpl;
import s_a.s_a.s_a.c.h;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IdProviderImpl f9746a;
    public OplusNotificationManager b = null;

    /* JADX INFO: renamed from: s_a.s_a.s_a.b.a$a, reason: collision with other inner class name */
    public static class C1190a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f9747a = new a();
    }

    public a() {
        this.f9746a = null;
        int i = Build.VERSION.SDK_INT;
        if (i != 31 && i != 32) {
            try {
                this.f9746a = new IdProviderImpl();
                return;
            } catch (Error | Exception e) {
                h.b("1084: " + (e.getMessage() != null ? e.getMessage() : e.getLocalizedMessage()));
            }
        }
        a();
    }

    public final void a() {
        try {
            this.b = new OplusNotificationManager();
        } catch (Error | Exception e) {
            Log.e("IDHelper", "1085: " + (e.getMessage() != null ? e.getMessage() : e.getLocalizedMessage()));
        }
    }
}
