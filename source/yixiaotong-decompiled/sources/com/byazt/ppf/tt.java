package com.byazt.ppf;

import com.byazt.aas.nb;
import com.byazt.ete.ic;
import com.byazt.ete.my;
import com.byazt.xs.da;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_EXPECT_BITRATE, 13})
public class tt {
    public static Class<?> c(boolean z, ic icVar, boolean z2, Map<String, Object> map) {
        if (my.n(icVar)) {
            return TTSevenScreenWebPageActivity.class;
        }
        if (my.a(icVar) && !icVar.or()) {
            return TTVideoWebPageActivity.class;
        }
        if (ic.ve(icVar) && !z && nb.sp(icVar)) {
            if (da.a(icVar)) {
                return TTNativePageActivity.class;
            }
            if (icVar.or()) {
                return TTWebPageActivity.class;
            }
            return c(TTVideoWebPageActivity.class, z2, icVar, map);
        }
        if (da.a(icVar)) {
            return TTNativePageActivity.class;
        }
        return TTWebPageActivity.class;
    }

    private static Class c(Class cls, boolean z, ic icVar, Map<String, Object> map) {
        if (!TTVideoWebPageActivity.class.equals(cls) || !z) {
            return cls;
        }
        if (map != null) {
            try {
                com.byazt.ua.c cVar = new com.byazt.ua.c();
                cVar.sp = 100L;
                cVar.c = true;
                cVar.uj = nb.gr(icVar);
                map.put("multi_process_data", cVar.c().toString());
            } catch (Throwable unused) {
                return cls;
            }
        }
        if (icVar.ri() == 0) {
            return TTVideoScrollWebPageActivity.class;
        }
        return (icVar.ri() <= 0 || 100 <= icVar.ri() || !nb.gr(icVar)) ? cls : TTVideoScrollWebPageActivity.class;
    }
}
