package com.opos.acs.st.entity;

import com.opos.acs.st.utils.f;
import com.opos.cmn.biz.requeststatistic.StatisticEvent;
import com.ubixnow.ooooo.o0OO000o;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a {
    public static StatisticEvent a(Map map) {
        if (map != null) {
            long jLongValue = -1;
            try {
                try {
                    if (map.get("ret") != null && !"".equals((String) map.get("ret"))) {
                        jLongValue = Long.valueOf((String) map.get("ret")).longValue();
                    }
                } catch (Exception e) {
                    f.b("ErrorTag", "", e);
                }
                StatisticEvent.Builder currentTime = new StatisticEvent.Builder((String) map.get("evtId"), (String) map.get("url"), jLongValue, map.get("rt") == null ? 0L : ((Long) map.get("rt")).longValue(), map.get("mt") == null ? 0L : ((Long) map.get("mt")).longValue(), (String) map.get("chn")).setCurrentTime(map.get("ct") == null ? System.currentTimeMillis() : ((Long) map.get("ct")).longValue());
                String str = (String) map.get(o0OO000o.o00O0O0O);
                return currentTime.setExt(str).setNet((String) map.get("net")).setSdkVersion("3013000").build();
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
