package com.byazt.zg;

import com.huawei.openalliance.ad.constant.x;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public enum ve implements n {
    QUESTION("?", 0),
    COLON(x.bQ, 0),
    DOUBLE_AMP("&&", 1),
    DOUBLE_BAR("||", 1),
    EQ("==", 2),
    GT(SimpleComparison.GREATER_THAN_OPERATION, 2),
    LT(SimpleComparison.LESS_THAN_OPERATION, 2),
    LT_EQ(SimpleComparison.LESS_THAN_EQUAL_TO_OPERATION, 2),
    GT_EQ(SimpleComparison.GREATER_THAN_EQUAL_TO_OPERATION, 2),
    NOT_EQ("!=", 2),
    PLUS("+", 3),
    MINUS(x.A, 3),
    MULTI("*", 4),
    DIVISION("/", 4),
    MOD("%", 4);

    public final int my;
    public final String rh;
    public static final Map<String, ve> m = new HashMap(128);
    public static final Set<ve> nu = new HashSet();

    public String c() {
        return this.rh;
    }

    public int tt() {
        return this.my;
    }

    static {
        for (ve veVar : values()) {
            m.put(veVar.c(), veVar);
            nu.add(veVar);
        }
    }

    ve(String str, int i) {
        this.rh = str;
        this.my = i;
    }

    public static ve c(String str) {
        return m.get(str);
    }

    public static boolean c(n nVar) {
        return nVar instanceof ve;
    }
}
