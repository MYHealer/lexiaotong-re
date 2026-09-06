package com.byazt.yf;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, TypedValues.PositionType.TYPE_CURVE_FIT, 34})
public class a {
    public Map<String, String> x;
    public final String c = "TTMediationSDK";
    public String tt = "";
    public String ve = "";
    public String uj = "";
    public int n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2882a = "";
    public String sp = "";

    public String a() {
        return this.f2882a;
    }

    public Map<String, String> c() {
        return this.x;
    }

    public void c(int i) {
        this.n = i;
    }

    public int n() {
        return this.n;
    }

    public String sp() {
        return this.sp;
    }

    public String tt() {
        return this.tt;
    }

    public String uj() {
        return this.uj;
    }

    public String ve() {
        return this.ve;
    }

    public void c(Map<String, String> map) {
        this.x = new HashMap();
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                if (!a(entry.getKey())) {
                    com.byazt.nr.m.uj("TTMediationSDK", "流量分组" + entry.getKey() + "字段存在不合法输入");
                } else if (!a(entry.getValue())) {
                    com.byazt.nr.m.uj("TTMediationSDK", "流量分组" + entry.getKey() + "字段的值" + entry.getValue() + "存在不合法输入");
                } else {
                    this.x.put(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public void c(String str) {
        if (a(str)) {
            this.tt = str;
        } else {
            com.byazt.nr.m.uj("TTMediationSDK", "流量分组user_id字段存在不合法输入");
        }
    }

    public void tt(String str) {
        if (a(str)) {
            this.ve = str;
        } else {
            com.byazt.nr.m.uj("TTMediationSDK", "流量分组channer字段存在不合法输入");
        }
    }

    public void ve(String str) {
        if (a(str)) {
            this.uj = str;
        } else {
            com.byazt.nr.m.uj("TTMediationSDK", "流量分组sub_channer字段存在不合法输入");
        }
    }

    public void uj(String str) {
        if (a(str)) {
            this.f2882a = str;
        } else {
            com.byazt.nr.m.uj("TTMediationSDK", "流量分组gender字段存在不合法输入");
        }
    }

    public void n(String str) {
        if (a(str)) {
            this.sp = str;
        } else {
            com.byazt.nr.m.uj("TTMediationSDK", "流量分组user_value_group字段存在不合法输入");
        }
    }

    public boolean equals(Object obj) {
        boolean z;
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            a aVar = (a) obj;
            boolean z2 = n() == aVar.n() && TextUtils.equals(sp(), aVar.sp()) && TextUtils.equals(tt(), aVar.tt()) && TextUtils.equals(ve(), aVar.ve()) && TextUtils.equals(uj(), aVar.uj()) && TextUtils.equals(a(), aVar.a());
            Map<String, String> mapC = aVar.c();
            Map<String, String> map = this.x;
            if (map == null || mapC == null) {
                z = map == null && mapC == null;
            } else {
                if (map.size() == mapC.size()) {
                    Iterator<String> it = this.x.keySet().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            String next = it.next();
                            if (TextUtils.isEmpty(next) || TextUtils.equals(this.x.get(next), mapC.get(next))) {
                            }
                        }
                    }
                }
            }
            if (z2 && z) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("[A-Za-z0-9-_]{1,100}");
    }
}
