package s_a.s_a.s_a.c;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.fancy.adsdk.lib.constants.BiddingConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f9753a;
    public static boolean b;
    public static boolean c;
    public static Context d;

    public static HashMap<String, String> a(int i) {
        int iA = a.a(i);
        if (iA != 10000) {
            throw new RuntimeException(iA + "");
        }
        List<String> listB = a.b(i);
        if (a()) {
            return b.C1191b.f9750a.a(d, listB);
        }
        HashMap<String, String> map = new HashMap<>();
        for (String str : (ArrayList) listB) {
            map.put(str, str == "OUID_STATUS" ? "FALSE" : "");
        }
        return map;
    }

    public static boolean a() {
        String str;
        if (!f9753a) {
            str = "1001";
        } else if (!b && !c) {
            str = BiddingConst.BIDDING_LOSS.WITH_LOW_PRICE_IN_HB;
        } else {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                return true;
            }
            str = BiddingConst.BIDDING_LOSS.WITH_BIDDING_TIMEOUT;
        }
        Log.e("IDHelper", str);
        return false;
    }
}
