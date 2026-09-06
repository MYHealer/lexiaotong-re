package com.ubixnow.network.gdt;

import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oo0O;
import com.ubixnow.ooooo.ooooO000;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class GdtBiddingUtils {
    public static HashMap<String, Object> getFailInfo(o00OO0OO o00oo0oo) {
        String str;
        HashMap<String, Object> map = new HashMap<>();
        try {
            if (!o00oo0oo.OooO00o) {
                map.put("winPrice", Integer.valueOf((int) o00oo0oo.OooO0Oo.OooO00o));
                map.put("lossReason", 1);
                int i = o00oo0oo.OooO0Oo.OooO0O0;
                if (i != 5) {
                    if (i == 2) {
                        str = "1";
                    }
                    ooooO000.OooO00o(oo0O.OooO00o, "优量汇失败上报信息：" + map.toString());
                    return map;
                }
                str = "3";
                map.put("adnId", str);
                ooooO000.OooO00o(oo0O.OooO00o, "优量汇失败上报信息：" + map.toString());
                return map;
            }
            map.put("winPrice", Integer.valueOf((int) o00oo0oo.OooO0O0));
            map.put("lossReason", 1);
            map.put("adnId", "2");
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
        ooooO000.OooO00o(oo0O.OooO00o, "优量汇失败上报信息：" + map.toString());
        return map;
    }

    public static HashMap<String, Object> getSuccMap(o00OO0OO o00oo0oo) {
        HashMap<String, Object> map = new HashMap<>();
        if (o00oo0oo != null) {
            try {
                long j = o00oo0oo.OooO0o0.OooO00o;
                map.put("highestLossPrice", Integer.valueOf(j > 0 ? (int) j : (int) o00oo0oo.OooO0Oo.OooO00o));
                map.put("expectCostPrice", Integer.valueOf((int) o00oo0oo.OooO0Oo.OooO00o));
            } catch (Exception e) {
                ooooO000.OooO00o(e);
            }
        }
        ooooO000.OooO00o(oo0O.OooO00o, "优量汇成功价格回传价格：" + map.toString());
        return map;
    }
}
