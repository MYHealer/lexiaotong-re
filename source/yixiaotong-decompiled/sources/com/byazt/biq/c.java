package com.byazt.biq;

import android.text.TextUtils;
import com.byazt.ete.sp;
import com.byazt.nr.m;
import com.byazt.omf.x;
import java.util.Iterator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 12, 20})
public class c {
    public static String c(String str) {
        if (!m.ve() || TextUtils.isEmpty(str)) {
            return str;
        }
        sp spVar = new sp(x.m().p());
        StringBuilder sb = new StringBuilder(str);
        Iterator<String> it = spVar.tt().iterator();
        while (it.hasNext()) {
            if (sb.toString().contains(it.next())) {
                if (sb.toString().contains("?")) {
                    sb.append("&").append(spVar.c());
                } else {
                    sb.append("?").append(spVar.c());
                }
            }
        }
        return sb.toString();
    }
}
