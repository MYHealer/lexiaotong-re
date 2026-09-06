package com.opos.cmn.an.f.b.a;

import android.text.TextUtils;
import com.opos.cmn.an.f.c.f;
import com.usertrace.cdo.usertrace.domain.dto.UserTraceConfigDto;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class d implements com.opos.cmn.an.f.b.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.cmn.an.f.a.b f5894a;
    private com.oplus.log.b b;

    class a implements com.oplus.log.c.b {
        a() {
        }

        @Override // com.oplus.log.c.b
        public String a() {
            return "";
        }

        @Override // com.oplus.log.c.b
        public String b() {
            return d.this.f5894a.i.a();
        }

        @Override // com.oplus.log.c.b
        public String c() {
            return "";
        }
    }

    class b implements com.oplus.log.c.a {
        b() {
        }

        @Override // com.oplus.log.c.a
        public String a() {
            return d.this.f5894a.h.a();
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.opos.cmn.an.f.a.c f5897a;
        final /* synthetic */ com.opos.cmn.an.f.a.a b;

        class a implements com.oplus.log.g.c.e {

            /* JADX INFO: renamed from: com.opos.cmn.an.f.b.a.d$c$a$a, reason: collision with other inner class name */
            class C0867a implements com.oplus.log.g.c.g {
                C0867a() {
                }

                @Override // com.oplus.log.g.c.g
                public void a() {
                    com.opos.cmn.an.f.a.a aVar = c.this.b;
                    if (aVar != null) {
                        aVar.onUploaderSuccess();
                    }
                }

                @Override // com.oplus.log.g.c.g
                public void a(String str) {
                    com.opos.cmn.an.f.a.a aVar = c.this.b;
                    if (aVar != null) {
                        aVar.onUploaderFailed(str);
                    }
                }
            }

            a() {
            }

            @Override // com.oplus.log.g.c.e
            public void a(UserTraceConfigDto userTraceConfigDto) {
                try {
                    if (userTraceConfigDto == null) {
                        if (c.this.b != null) {
                            c.this.b.onDontNeedUpload("userTraceConfigDto is null");
                            return;
                        }
                        return;
                    }
                    d.this.b.a(new C0867a());
                    boolean z = true;
                    if (userTraceConfigDto.getForce() != 1) {
                        z = false;
                    }
                    boolean z2 = z;
                    d.this.b.a("advertise_sdk", String.valueOf(userTraceConfigDto.getTraceId()), userTraceConfigDto.getBeginTime(), userTraceConfigDto.getEndTime(), z2, c.this.f5897a.f5890a);
                } catch (Throwable unused) {
                }
            }

            @Override // com.oplus.log.g.c.e
            public void a(String str) {
                com.opos.cmn.an.f.a.a aVar = c.this.b;
                if (aVar != null) {
                    aVar.onDontNeedUpload(str);
                }
            }
        }

        c(com.opos.cmn.an.f.a.c cVar, com.opos.cmn.an.f.a.a aVar) {
            this.f5897a = cVar;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.this.b.a("advertise_sdk", this.f5897a.f5890a, new a());
            } catch (Throwable unused) {
                com.opos.cmn.an.f.a.a aVar = this.b;
                if (aVar != null) {
                    aVar.onUploaderFailed("unkown error");
                }
            }
        }
    }

    private void a(int i, String str, String str2) {
        try {
            com.oplus.log.b bVar = this.b;
            if (bVar != null && bVar.a() != null) {
                if (i == 1) {
                    this.b.a().b(str, str2, com.opos.cmn.an.f.b.c.b());
                } else if (i == 2) {
                    this.b.a().a(str, str2, com.opos.cmn.an.f.b.c.b());
                } else if (i == 3) {
                    this.b.a().c(str, str2, com.opos.cmn.an.f.b.c.b());
                } else if (i == 4) {
                    this.b.a().d(str, str2, com.opos.cmn.an.f.b.c.b());
                } else if (i == 5) {
                    this.b.a().e(str, str2, com.opos.cmn.an.f.b.c.b());
                }
            }
        } catch (Throwable unused) {
        }
    }

    private String b() {
        try {
            if (f.e()) {
                return this.f5894a.g.getExternalFilesDir(null) + File.separator + ".opos_ad_log";
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    private String c() {
        try {
            if (f.e()) {
                return this.f5894a.g.getExternalFilesDir(null) + File.separator + ".opos_ad_mmap_cache_log";
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    @Override // com.opos.cmn.an.f.b.a.b
    public void a() {
        com.oplus.log.b bVar = this.b;
        if (bVar == null) {
            return;
        }
        try {
            bVar.b();
        } catch (Throwable unused) {
        }
    }

    @Override // com.opos.cmn.an.f.b.a.b
    public void a(int i) {
        if (this.b != null) {
            if (f.b()) {
                i = 1;
            }
            try {
                this.b.b(i);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.opos.cmn.an.f.b.a.b
    public void a(com.opos.cmn.an.f.a.b bVar) {
        int i;
        this.f5894a = bVar;
        try {
            f.a();
            if (f.b()) {
                com.opos.cmn.an.f.b.c.a();
                f.c();
                i = 1;
            } else {
                i = this.f5894a.c;
            }
            com.oplus.log.b.a aVarA = com.oplus.log.b.e().a(new com.opos.cmn.an.f.b.a.c()).d("ad").c(b()).b(c()).c(this.f5894a.d).a(this.f5894a.b).b(i).a(this.f5894a.f).a(new b()).a(new a());
            String strF = f.f();
            if (!TextUtils.isEmpty(strF)) {
                aVarA.e(strF);
            }
            this.b = aVarA.a(this.f5894a.g);
            com.oplus.log.b.b(false);
        } catch (Throwable unused) {
        }
    }

    @Override // com.opos.cmn.an.f.b.a.b
    public void a(com.opos.cmn.an.f.a.c cVar, com.opos.cmn.an.f.a.a aVar) {
        if (cVar == null) {
            if (aVar != null) {
                aVar.onUploaderFailed("uploadParams is null");
                return;
            }
            return;
        }
        if (com.opos.cmn.an.d.a.a(cVar.f5890a)) {
            if (aVar != null) {
                aVar.onUploaderFailed("businessType is null");
            }
        } else {
            if (this.b == null) {
                if (aVar != null) {
                    aVar.onUploaderFailed("mLogger is null");
                    return;
                }
                return;
            }
            com.opos.cmn.an.f.a.b bVar = this.f5894a;
            if (bVar == null || com.opos.cmn.an.f.b.a.a(bVar.g)) {
                new Thread(new c(cVar, aVar)).start();
            } else if (aVar != null) {
                aVar.onUploaderFailed("log buried point switch is closed, cannot upload log");
            }
        }
    }

    @Override // com.opos.cmn.an.f.b.a.b
    public void a(com.opos.cmn.an.f.b.b.d dVar) {
        com.oplus.log.b bVar;
        if (dVar != null) {
            try {
                if (dVar.b != null && dVar.f5903a != null && (bVar = this.b) != null && bVar.a() != null) {
                    int i = dVar.d;
                    String strA = f.a(dVar);
                    if (strA.length() > 3072 && com.opos.cmn.an.f.b.c.b()) {
                        int length = strA.length();
                        int i2 = 0;
                        while (length > i2) {
                            int i3 = i2 + 3072;
                            if (length <= i3) {
                                i3 = length;
                            }
                            a(i, this.f5894a.f5886a, strA.substring(i2, i3));
                            i2 = i3;
                        }
                        return;
                    }
                    a(i, this.f5894a.f5886a, strA);
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.opos.cmn.an.f.b.a.b
    public void a(boolean z) {
        com.oplus.log.b bVar = this.b;
        if (bVar == null) {
            return;
        }
        try {
            bVar.a(z);
        } catch (Throwable unused) {
        }
    }

    @Override // com.opos.cmn.an.f.b.a.b
    public void b(int i) {
        com.oplus.log.b bVar = this.b;
        if (bVar != null) {
            try {
                bVar.a(i);
            } catch (Throwable unused) {
            }
        }
    }
}
