package com.opos.mobad.ad.f;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f6655a;
    public final String b;
    public final String c;
    public final boolean d;
    public final d e;
    public final boolean f;
    public final e g;
    public final boolean h;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f6656a;
        private String b;
        private String c;
        private boolean d;
        private d e;
        private boolean f;
        private Context g;
        private boolean h;
        private boolean i;
        private e j;

        private a() {
            this.f6656a = 5000L;
            this.d = true;
            this.e = null;
            this.f = false;
            this.g = null;
            this.h = true;
            this.i = true;
        }

        public a(Context context) {
            this.f6656a = 5000L;
            this.d = true;
            this.e = null;
            this.f = false;
            this.g = null;
            this.h = true;
            this.i = true;
            if (context != null) {
                this.g = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
        }

        public a a(long j) {
            if (j >= C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS && j <= 5000) {
                this.f6656a = j;
            }
            return this;
        }

        public a a(d dVar) {
            if (dVar != null) {
                this.e = dVar;
            }
            return this;
        }

        public a a(e eVar) {
            this.j = eVar;
            return this;
        }

        public a a(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.b = str;
            }
            return this;
        }

        public a a(boolean z) {
            this.d = z;
            return this;
        }

        public f a() throws NullPointerException {
            this.g.getClass();
            return new f(this);
        }

        public a b(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.c = str;
            }
            return this;
        }

        public a b(boolean z) {
            this.f = z;
            return this;
        }

        public a c(boolean z) {
            this.h = z;
            return this;
        }

        public a d(boolean z) {
            this.i = z;
            return this;
        }
    }

    public f(a aVar) {
        this.f6655a = aVar.f6656a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.h = aVar.h;
        this.g = aVar.j;
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder("SplashAdParams{fetchTimeout=").append(this.f6655a).append(", title='").append(this.b).append("', desc='").append(this.c).append("', showPreLoadPage=").append(this.d).append(", bottomArea=");
        Object obj = this.e;
        if (obj == null) {
            obj = "null";
        }
        return sbAppend.append(obj).append(", isUseSurfaceView='").append(this.f).append("', isVertical=").append(this.h).append('}').toString();
    }
}
