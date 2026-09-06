package com.adprof.sdk;

import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class r2 extends Lambda implements Function4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s2 f1395a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r2(s2 s2Var) {
        super(4);
        this.f1395a = s2Var;
    }

    @Override // kotlin.jvm.functions.Function4
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        int iIntValue = ((Number) obj).intValue();
        int iIntValue2 = ((Number) obj2).intValue();
        int iIntValue3 = ((Number) obj3).intValue();
        long jLongValue = ((Number) obj4).longValue();
        Function4<Integer, Integer, Integer, Long, Unit> callback = this.f1395a.getCallback();
        if (callback != null) {
            callback.invoke(Integer.valueOf(iIntValue), Integer.valueOf(iIntValue2), Integer.valueOf(iIntValue3), Long.valueOf(jLongValue));
        }
        return Unit.INSTANCE;
    }
}
