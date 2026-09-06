package com.adprof.sdk;

import com.adprof.sdk.base.activity.AdxActivity;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class f3 extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AdxActivity f1163a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f3(AdxActivity adxActivity) {
        super(1);
        this.f1163a = adxActivity;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return Boolean.valueOf(AdxActivity.a(this.f1163a, (String) obj));
    }
}
