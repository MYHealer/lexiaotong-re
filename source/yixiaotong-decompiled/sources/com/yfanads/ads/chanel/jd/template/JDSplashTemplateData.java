package com.yfanads.ads.chanel.jd.template;

import android.content.Context;
import com.yfanads.android.model.template.SplashTemplateData;
import com.yfanads.android.utils.ScreenUtil;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class JDSplashTemplateData extends SplashTemplateData {
    public static final Map<Integer, Integer> VALUES;

    static {
        HashMap map = new HashMap();
        VALUES = map;
        map.put(1, 8);
        map.put(2, 10);
        map.put(3, 12);
        map.put(4, 15);
        map.put(5, 18);
    }

    public JDSplashTemplateData(String str, boolean z) {
        super(str, z);
    }

    public int[] getJmupSize(Context context) {
        if (this.conf == null) {
            return getJmupSize(context, 12);
        }
        Integer num = VALUES.get(Integer.valueOf(this.conf.cbs));
        return getJmupSize(context, num != null ? num.intValue() : 12);
    }

    private int[] getJmupSize(Context context, int i) {
        if (i == 0) {
            i = 12;
        }
        int iDip2px = ScreenUtil.dip2px(context, i);
        float f = iDip2px / 3;
        return new int[]{(int) (1.6f * f), (int) (f * 0.9f), iDip2px};
    }

    public int getJumpLoc() {
        if (this.conf == null) {
            return 2;
        }
        return this.conf.cbp;
    }

    public boolean isClickClose() {
        return this.conf != null && this.conf.jc == 1;
    }
}
