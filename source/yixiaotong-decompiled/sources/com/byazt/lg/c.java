package com.byazt.lg;

import android.text.TextUtils;
import com.byazt.ll.tt;
import com.byazt.ng.a;
import com.byazt.vx.qy;
import com.byazt.yl.ve;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.openalliance.ad.constant.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1488, 20})
public abstract class c {
    public tt c;

    public static String c(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return str2;
        }
        return (TextUtils.equals(str, MediationConstant.ADN_GDT) || TextUtils.equals(str, MediationConstant.ADN_PANGLE)) ? str2 + "_" + str3 : str2;
    }

    public static String c(String str, String str2) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        if (TextUtils.equals(str, MediationConstant.ADN_PANGLE)) {
            String[] strArrSplit2 = str2.split("message:");
            if (strArrSplit2 != null && strArrSplit2.length > 0) {
                String str3 = strArrSplit2[0];
                if (!TextUtils.isEmpty(str3) && (strArrSplit = str3.trim().split(x.bQ)) != null && strArrSplit.length >= 2) {
                    String str4 = strArrSplit[1];
                    if (!TextUtils.isEmpty(str4)) {
                        return str4.trim();
                    }
                }
            }
            return "";
        }
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        char[] charArray = str2.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c >= '0' && c <= '9') {
                sb.append(c);
                if (i == charArray.length - 1) {
                    arrayList.add(sb.toString());
                    break;
                }
            } else if (sb.length() > 0) {
                arrayList.add(sb.toString());
                sb.delete(0, sb.length());
            }
            if (arrayList.size() > 0) {
                return (String) arrayList.get(0);
            }
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb2.append((String) it.next());
            sb2.append("_");
        }
        if (sb2.length() > 0) {
            sb2.delete(sb2.length() - 1, sb2.length());
        }
        return sb2.toString();
    }

    public static boolean c() {
        boolean zVe = qy.ve(com.byazt.bp.tt.getContext());
        boolean zTt = qy.tt(com.byazt.bp.tt.getContext());
        if (com.byazt.bp.tt.tt().m()) {
            return zVe || zTt;
        }
        return false;
    }

    public final void c(ve veVar, String str, Map<String, Object> map) {
        if (veVar == null || veVar.getAdType() != 5) {
            return;
        }
        a.c(veVar, this.c, str);
    }
}
