package com.byazt.yy;

import android.content.Context;
import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import com.byazt.dna.nu;
import com.byazt.iy.n;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 122, 15})
public class uj {

    @com.byazt.zqa.c(c = {0, 1, 122, AppTypeIdUtil.NewDevice4GBathOTA})
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile int f2905a;
        public volatile Context c;
        public volatile boolean n;
        public volatile String tt;
        public volatile boolean uj;
        public volatile int ve;

        public c c(int i) {
            this.ve = i;
            return this;
        }

        public c c(String str) {
            this.tt = str;
            return this;
        }

        public c c(boolean z) {
            this.uj = z;
            return this;
        }

        public c tt(int i) {
            this.f2905a = i;
            return this;
        }

        public c c(Context context) {
            if (context == null) {
                return this;
            }
            this.c = StubApp.getOrigApplicationContext(context.getApplicationContext());
            ve.c(this.c);
            return this;
        }

        public n c() {
            if (this.ve == 2) {
                return ve();
            }
            return tt();
        }

        private n tt() {
            if (this.uj) {
                return com.byazt.ti.c.c(this.tt);
            }
            return ((nu) com.byazt.ut.uj.getService("kv_store_factory")).get(this.tt);
        }

        private n ve() {
            n nVarC = com.byazt.fu.c.c(this.c, this.tt, this.uj, this.f2905a);
            this.n = true;
            if (nVarC != null) {
                return nVarC;
            }
            this.n = false;
            return tt();
        }
    }
}
