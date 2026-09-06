package com.hihonor.hianalytics.util;

import android.text.TextUtils;
import android.util.Pair;
import com.hihonor.hianalytics.HaEventConstants;
import com.hihonor.hianalytics.hnha.i0;
import com.hihonor.hianalytics.hnha.j2;
import com.hihonor.hianalytics.hnha.n0;
import com.huawei.openalliance.ad.constant.x;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class g {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a(i0 i0Var, i0 i0Var2) {
        if (i0Var == null && i0Var2 == null) {
            return 0;
        }
        if (i0Var == null || i0Var2 == null) {
            return -1;
        }
        long jA = i0Var.a() - i0Var2.a();
        if (jA == 0) {
            return 0;
        }
        return jA > 0 ? 1 : -1;
    }

    public static a a() {
        return a.c(b("backup_event"));
    }

    public static String a(int i) {
        if (i == 1) {
            return "maint";
        }
        if (i == 2) {
            return "preins";
        }
        return i == 3 ? "diffprivacy" : "oper";
    }

    public static String a(int i, String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (i == 1) {
            str2 = "{url}/common/himaintqrt";
        } else if (i == 2) {
            str2 = "{url}/common/hioperbatch";
        } else {
            str2 = i == 3 ? "{url}/common/common2" : "{url}/common/hioperqrt";
        }
        return str2.replace("{url}", str);
    }

    private static String a(String str) {
        return "hianalytics_" + str + "_sp_" + SystemUtils.getContext().getPackageName();
    }

    public static String a(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return str2;
        }
        String[] strArrSplit = str.split(x.A);
        if (strArrSplit.length < 1) {
            return str2;
        }
        return "_default_config_tag".equals(str) ? "_default_config_tag" : strArrSplit[strArrSplit.length - 1];
    }

    public static String a(List<n0> list) {
        StringBuilder sbAppend;
        int size = list == null ? 0 : list.size();
        if (size == 0) {
            return "";
        }
        if (size == 1) {
            sbAppend = new StringBuilder("(").append(list.get(0).a()).append(")");
        } else {
            List<Pair<String, String>> listB = b(new LinkedList(list));
            StringBuilder sb = new StringBuilder("(");
            for (Pair<String, String> pair : listB) {
                (Objects.equals(pair.first, pair.second) ? sb.append((String) pair.first) : sb.append((String) pair.first).append(x.A).append((String) pair.second)).append(",");
            }
            sbAppend = sb.append(")");
        }
        return sbAppend.toString();
    }

    public static a b() {
        return a.a(a("multi_prefer_sign_v2_1"), 4);
    }

    private static String b(String str) {
        StringBuilder sb = new StringBuilder("hianalytics_");
        sb.append(str).append("_sp_");
        String processName = SystemUtils.getProcessName();
        sb.append(processName.trim().length() > 0 ? processName.replace(x.bQ, "_") : SystemUtils.getContext().getPackageName());
        return sb.toString();
    }

    public static List<Pair<String, String>> b(List<i0> list) {
        int i = 0;
        int size = list == null ? 0 : list.size();
        LinkedList linkedList = new LinkedList();
        if (size == 0) {
            return linkedList;
        }
        try {
            if (size == 1) {
                String strValueOf = String.valueOf(list.get(0).a());
                linkedList.add(Pair.create(strValueOf, strValueOf));
                return linkedList;
            }
            Collections.sort(list, new Comparator() { // from class: com.hihonor.hianalytics.util.g$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return g.a((i0) obj, (i0) obj2);
                }
            });
            while (i < size) {
                long jA = list.get(i).a();
                i++;
                long j = jA;
                while (i < size) {
                    long jA2 = list.get(i).a();
                    if (jA2 - j != 1) {
                        break;
                    }
                    i++;
                    j = jA2;
                }
                linkedList.add(Pair.create(String.valueOf(jA), String.valueOf(j)));
            }
            return linkedList;
        } catch (Throwable th) {
            j2.g("HaAssistUtils", "sortAndGetEventIdRegion failMsg=" + SystemUtils.getDesensitizedException(th));
        }
    }

    public static int c(String str) {
        if ("oper".equals(str)) {
            return 0;
        }
        if ("maint".equals(str)) {
            return 1;
        }
        if ("preins".equals(str)) {
            return 2;
        }
        return "diffprivacy".equals(str) ? 3 : 0;
    }

    public static a c() {
        return a.c(b("prefer_sign_v2_1"));
    }

    public static a d() {
        return a.c(b("Privacy_MY"));
    }

    public static boolean d(String str) {
        return HaEventConstants.EVENT_ID_APP_START.equals(str) || HaEventConstants.EVENT_ID_APP_END.equals(str) || HaEventConstants.EVENT_ID_VIEW_EXPOSE.equals(str) || HaEventConstants.EVENT_ID_VIEW_SHOW.equals(str) || HaEventConstants.EVENT_ID_WIDGET_EXPOSE.equals(str) || HaEventConstants.EVENT_ID_WIDGET_CLICK.equals(str) || HaEventConstants.EVENT_ID_AUTO_SESSION_KEEP.equals(str);
    }
}
