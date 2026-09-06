package com.opos.exoplayer.core.h;

import android.text.TextUtils;
import com.google.android.exoplayer2.util.MimeTypes;
import com.opos.exoplayer.core.i.y;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface q extends com.opos.exoplayer.core.h.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.opos.exoplayer.core.i.r<String> f6491a = new g();

    public static abstract class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final f f6492a = new f();

        @Override // com.opos.exoplayer.core.h.g.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final q a() {
            return b(this.f6492a);
        }

        protected abstract q b(f fVar);
    }

    public interface b extends com.opos.exoplayer.core.h.g.a {
    }

    public static class c extends com.opos.exoplayer.core.i.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6493a;
        public final i b;

        public c(IOException iOException, i iVar, int i) {
            super(iOException);
            this.b = iVar;
            this.f6493a = i;
        }

        public c(String str, i iVar, int i) {
            super(str);
            this.b = iVar;
            this.f6493a = i;
        }

        public c(String str, IOException iOException, i iVar, int i) {
            super(str, iOException);
            this.b = iVar;
            this.f6493a = i;
        }

        @Override // com.opos.exoplayer.core.i.c
        public String a() {
            return "HttpDataSourceException";
        }
    }

    public static final class d extends c {
        public final String c;

        public d(String str, i iVar) {
            super("Invalid content type: " + str, iVar, 1);
            this.c = str;
        }

        @Override // com.opos.exoplayer.core.h.q.c, com.opos.exoplayer.core.i.c
        public String a() {
            return "InvalidContentTypeException";
        }
    }

    public static final class e extends c {
        public final int c;
        public final Map<String, List<String>> d;

        public e(int i, Map<String, List<String>> map, i iVar) {
            super("Response code: " + i, iVar, 1);
            this.c = i;
            this.d = map;
        }

        @Override // com.opos.exoplayer.core.h.q.c, com.opos.exoplayer.core.i.c
        public String a() {
            return "InvalidResponseCodeException";
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<String, String> f6494a = new HashMap();
        private Map<String, String> b;

        public synchronized Map<String, String> a() {
            if (this.b == null) {
                this.b = Collections.unmodifiableMap(new HashMap(this.f6494a));
            }
            return this.b;
        }
    }

    static class g implements com.opos.exoplayer.core.i.r<String> {
        g() {
        }

        @Override // com.opos.exoplayer.core.i.r
        public boolean a(String str) {
            String strD = y.d(str);
            return (TextUtils.isEmpty(strD) || (strD.contains("text") && !strD.contains(MimeTypes.TEXT_VTT)) || strD.contains(com.baidu.mobads.sdk.internal.a.f) || strD.contains("xml")) ? false : true;
        }
    }
}
