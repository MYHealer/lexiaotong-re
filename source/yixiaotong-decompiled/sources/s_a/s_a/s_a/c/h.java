package s_a.s_a.s_a.c;

import android.util.Log;
import com.huawei.openalliance.ad.constant.x;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f9756a;

    public static void a(String str) {
        if (f9756a) {
            Log.d("IDHelper", str);
        }
    }

    public static void a(String str, Exception exc) {
        Log.e("IDHelper", str + x.bQ + (exc.getMessage() != null ? exc.getMessage() : exc.getLocalizedMessage()));
    }

    public static void b(String str) {
        Log.e("IDHelper", str);
    }
}
