package com.opos.mobad.f.a;

import android.content.Intent;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface c {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f6888a;
        public final String b;
        public final int c;
        public final int d;
        public final Intent e;
        public final Intent f;
        public final Intent g;

        public a(String str, String str2, int i, int i2, Intent intent, Intent intent2, Intent intent3) {
            this.f6888a = str;
            this.b = str2;
            this.c = i;
            this.d = i2;
            this.e = intent;
            this.f = intent2;
            this.g = intent3;
        }
    }

    void a();

    void a(int i);

    void a(int i, a aVar);
}
