package com.meishu.sdk.core.utils;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PackConfigUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class r0 extends com.meishu.sdk.core.safe.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f4938a;

    /* JADX INFO: compiled from: PackConfigUtil.java */
    public class a implements e0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f4939a;

        public a(r0 r0Var, CountDownLatch countDownLatch) {
            this.f4939a = countDownLatch;
        }

        public void a(boolean z) {
            try {
                this.f4939a.countDown();
            } catch (Throwable unused) {
            }
        }
    }

    public r0(List list) {
        this.f4938a = list;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        int i = 0;
        while (i < this.f4938a.size()) {
            String str = (String) this.f4938a.get(i);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            e0.a(str, i == 0, new a(this, countDownLatch));
            try {
                if (countDownLatch.getCount() > 0) {
                    countDownLatch.await(10L, TimeUnit.SECONDS);
                }
            } catch (Throwable unused) {
            }
            i++;
        }
    }
}
