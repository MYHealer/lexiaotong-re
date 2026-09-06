package com.hihonor.hianalytics.hnha;

import android.text.TextUtils;
import com.hihonor.hianalytics.util.SystemUtils;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static o0 f3648a;
    private static final List<o0> b = new LinkedList();
    private static final List<p0> c = new LinkedList();
    private static final List<j0> d = new LinkedList();

    public static synchronized j0 a(p0 p0Var, JSONObject jSONObject, JSONObject jSONObject2) {
        j0 j0Var = new j0(p0Var, jSONObject, jSONObject2);
        for (j0 j0Var2 : d) {
            if (j0Var.a(j0Var2)) {
                return j0Var2;
            }
        }
        int length = 0;
        StringBuilder sbAppend = new StringBuilder().append("getIdAttrs enterCreate tagTypeInfo=").append(p0Var).append(",headerLen=").append(jSONObject == null ? 0 : jSONObject.length()).append(",commonLen=");
        if (jSONObject2 != null) {
            length = jSONObject2.length();
        }
        j2.c("DataCache", sbAppend.append(length).toString());
        d.add(j0Var);
        return j0Var;
    }

    public static synchronized o0 a(String str) {
        o0 o0Var;
        o0Var = new o0(0L, System.currentTimeMillis(), str);
        List<o0> list = b;
        int iIndexOf = list.indexOf(o0Var);
        if (iIndexOf < 0) {
            list.add(o0Var);
        } else {
            o0Var = list.get(iIndexOf);
        }
        return o0Var;
    }

    public static synchronized p0 a(String str, int i) {
        p0 p0Var = new p0(str, i);
        if (TextUtils.isEmpty(str)) {
            return p0Var;
        }
        List<p0> list = c;
        int iIndexOf = list.indexOf(p0Var);
        if (iIndexOf < 0) {
            list.add(p0Var);
        } else {
            p0Var = list.get(iIndexOf);
        }
        return p0Var;
    }

    public static List<o0> a() {
        return Collections.unmodifiableList(b);
    }

    public static synchronized void a(List<String> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                for (int size = d.size() - 1; size >= 0; size--) {
                    List<j0> list2 = d;
                    if (list.contains(String.valueOf(list2.get(size).a()))) {
                        list2.remove(size);
                    }
                }
            }
        }
    }

    public static o0 b() {
        o0 o0Var = f3648a;
        if (o0Var != null) {
            return o0Var;
        }
        o0 o0VarA = a(SystemUtils.getProcessName());
        if (!o0VarA.d()) {
            f3648a = o0VarA;
        }
        return o0VarA;
    }

    public static synchronized void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (int size = d.size() - 1; size >= 0; size--) {
            List<j0> list = d;
            if (str.equals(list.get(size).o().b)) {
                list.remove(size);
            }
        }
    }

    public static synchronized void b(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (int size = d.size() - 1; size >= 0; size--) {
            List<j0> list = d;
            p0 p0VarO = list.get(size).o();
            if (str.equals(p0VarO.b) && i == p0VarO.c) {
                list.remove(size);
            }
        }
    }

    public static synchronized void b(List<p0> list) {
        for (p0 p0Var : list) {
            if (p0Var != null) {
                List<p0> list2 = c;
                int iIndexOf = list2.indexOf(p0Var);
                if (iIndexOf < 0) {
                    list2.add(p0Var);
                } else {
                    list2.get(iIndexOf).a(p0Var.a());
                }
                List<o0> list3 = b;
                int iIndexOf2 = list3.indexOf(p0Var.e);
                if (iIndexOf2 < 0) {
                    list3.add(p0Var.e);
                } else {
                    list3.get(iIndexOf2).a(p0Var.e.a());
                }
            }
        }
    }

    public static synchronized List<String> c() {
        LinkedList linkedList;
        linkedList = new LinkedList();
        for (p0 p0Var : c) {
            if (p0Var.e.c()) {
                String strValueOf = String.valueOf(p0Var.a());
                if (linkedList.contains(strValueOf)) {
                    continue;
                } else {
                    linkedList.add(strValueOf);
                }
            }
        }
        return linkedList;
    }
}
