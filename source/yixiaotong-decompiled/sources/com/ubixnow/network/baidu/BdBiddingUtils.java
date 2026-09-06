package com.ubixnow.network.baidu;

import com.baidu.mobads.sdk.api.SplashAd;
import com.ubixnow.ooooo.o;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oO0000O;
import com.ubixnow.ooooo.oo0O;
import com.ubixnow.ooooo.ooooO000;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class BdBiddingUtils extends o {
    /* JADX WARN: Code duplicated, block: B:19:0x005d A[Catch: Exception -> 0x009d, TryCatch #0 {Exception -> 0x009d, blocks: (B:3:0x0007, B:6:0x001e, B:8:0x0024, B:9:0x002e, B:32:0x0099, B:10:0x0034, B:17:0x004f, B:18:0x0056, B:19:0x005d, B:20:0x0062, B:21:0x0067, B:22:0x006c, B:24:0x0071, B:25:0x007c, B:31:0x0095), top: B:38:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0062 A[Catch: Exception -> 0x009d, TryCatch #0 {Exception -> 0x009d, blocks: (B:3:0x0007, B:6:0x001e, B:8:0x0024, B:9:0x002e, B:32:0x0099, B:10:0x0034, B:17:0x004f, B:18:0x0056, B:19:0x005d, B:20:0x0062, B:21:0x0067, B:22:0x006c, B:24:0x0071, B:25:0x007c, B:31:0x0095), top: B:38:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x0067 A[Catch: Exception -> 0x009d, TryCatch #0 {Exception -> 0x009d, blocks: (B:3:0x0007, B:6:0x001e, B:8:0x0024, B:9:0x002e, B:32:0x0099, B:10:0x0034, B:17:0x004f, B:18:0x0056, B:19:0x005d, B:20:0x0062, B:21:0x0067, B:22:0x006c, B:24:0x0071, B:25:0x007c, B:31:0x0095), top: B:38:0x0007 }] */
    public static LinkedHashMap<String, Object> getFailInfo(o00OO0OO o00oo0oo) {
        int i;
        int iValueOf;
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        try {
            if (oO0000O.OooO00o(BdInitManager.getInstance().getVersion(), "9.34") >= 0) {
                i = 10;
                if (o00oo0oo.OooO00o) {
                    linkedHashMap.put("ecpm", Integer.valueOf((int) o00oo0oo.OooO0O0));
                } else {
                    linkedHashMap.put("ecpm", Integer.valueOf((int) o00oo0oo.OooO0Oo.OooO00o));
                    int i2 = o00oo0oo.OooO0Oo.OooO0O0;
                    if (i2 == 1) {
                        iValueOf = 1;
                    } else if (i2 == 2) {
                        iValueOf = 2;
                    } else if (i2 == 3) {
                        iValueOf = 3;
                    } else if (i2 == 4) {
                        iValueOf = 8;
                    } else if (i2 == 6) {
                        iValueOf = 9;
                    }
                }
                iValueOf = Integer.valueOf(i);
            } else {
                i = 5;
                if (o00oo0oo.OooO00o) {
                    linkedHashMap.put("ecpm", Integer.valueOf((int) o00oo0oo.OooO0O0));
                } else {
                    linkedHashMap.put("ecpm", Integer.valueOf((int) o00oo0oo.OooO0Oo.OooO00o));
                    int i3 = o00oo0oo.OooO0Oo.OooO0O0;
                    if (i3 == 1) {
                        iValueOf = 1;
                    } else if (i3 == 2) {
                        iValueOf = 3;
                    } else if (i3 == 3) {
                        iValueOf = 4;
                    } else if (i3 == 6) {
                        iValueOf = 2;
                    }
                }
                iValueOf = Integer.valueOf(i);
            }
            linkedHashMap.put(SplashAd.KEY_BIDFAIL_ADN, iValueOf);
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
        ooooO000.OooO00o(oo0O.OooO00o, "百度失败上报信息：" + linkedHashMap.toString());
        return linkedHashMap;
    }

    public static long getSecondPrice(o00OO0OO o00oo0oo) {
        if (o00oo0oo != null) {
            long j = o00oo0oo.OooO0o0.OooO00o;
            if (j > 0) {
                ooooO000.OooO00o(oo0O.OooO00o, "百度成功价格回传价格：" + j);
                return j;
            }
        }
        long j2 = o00oo0oo != null ? o00oo0oo.OooO0Oo.OooO00o : 0L;
        ooooO000.OooO00o(oo0O.OooO00o, "百度成功价格回传价格：" + j2);
        return j2;
    }
}
