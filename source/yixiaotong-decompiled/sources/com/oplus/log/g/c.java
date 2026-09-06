package com.oplus.log.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.usertrace.cdo.usertrace.domain.dto.UserTraceConfigDto;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.oplus.log.g.a f5832a;
    private com.oplus.log.c b;
    private com.oplus.log.a c = new com.oplus.log.f.a();
    private int d = 0;
    private f e;
    private g f;
    private b g;
    private String h;
    private com.oplus.log.a.a i;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f5836a;
        String b;
        long c;
        long d;
        boolean e;
        String f;
        String g;
        String h;
        String i;
    }

    public interface b {
        void a(com.oplus.log.g.b bVar);

        void a(String str, a aVar);
    }

    /* JADX INFO: renamed from: com.oplus.log.g.c$c, reason: collision with other inner class name */
    public static class C0865c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f5837a;
        String b;
        long c;
        long d;
        boolean e;
        String f;

        public C0865c(String str, long j, long j2, boolean z, String str2, String str3) {
            this.f5837a = str;
            this.c = j;
            this.d = j2;
            this.e = z;
            this.f = str2;
            this.b = str3;
        }
    }

    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f5838a;
        String b;
        e c;

        d(String str, String str2) {
            this.b = str;
            this.f5838a = str2;
        }

        void a(e eVar) {
            this.c = eVar;
        }
    }

    public interface e {
        void a(UserTraceConfigDto userTraceConfigDto);

        void a(String str);
    }

    public class f extends Handler {
        f(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.obj instanceof C0865c) {
                c.this.a((C0865c) message.obj);
            } else if (message.obj instanceof a) {
                c.this.a((a) message.obj);
            } else if (message.obj instanceof d) {
                d dVar = (d) message.obj;
                c.this.b(dVar.b, dVar.f5838a, dVar.c);
            }
        }
    }

    public interface g {
        void a();

        void a(String str);
    }

    public c(com.oplus.log.c cVar) {
        this.h = null;
        this.b = cVar == null ? new com.oplus.log.c() : cVar;
        this.h = this.b.f() + File.separator + ".zip";
        if (this.b.k() != null) {
            this.f5832a = this.b.k();
        }
        a();
    }

    private void a() {
        HandlerThread handlerThread = new HandlerThread(getClass().getName());
        handlerThread.start();
        this.e = new f(handlerThread.getLooper());
    }

    private void a(com.oplus.log.g.b bVar) {
        this.d = 0;
        com.oplus.log.g.d.a(this.h);
        b bVar2 = this.g;
        if (bVar2 != null) {
            bVar2.a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a aVar) {
        if (aVar.e && !com.oplus.log.d.c.b()) {
            this.c.b("report_log_info", "upload task need wifi connect");
            a(aVar, -121, "upload task need wifi connect");
            b bVar = this.g;
            if (bVar != null) {
                bVar.a("upload task need wifi connect", aVar);
                return;
            }
            return;
        }
        try {
            com.oplus.log.a.a aVar2 = this.i;
            if (aVar2 != null) {
                aVar2.a(new com.oplus.log.core.e.b() { // from class: com.oplus.log.g.c.2
                    @Override // com.oplus.log.core.e.b
                    public final void a() {
                        com.oplus.log.g.d.a(aVar.c, aVar.d, c.this.b, c.this.h, aVar.f, new com.oplus.log.g.d.a() { // from class: com.oplus.log.g.c.2.1
                            @Override // com.oplus.log.g.d.a
                            public final void a(int i, File file) {
                                c.this.a(aVar, i, file);
                            }

                            @Override // com.oplus.log.g.d.a
                            public final void a(int i, String str) {
                                c.this.b(aVar, i, str);
                            }
                        });
                    }
                });
            }
        } catch (Exception e2) {
            b(aVar, -1, e2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, int i, File file) {
        a aVar2;
        String str;
        String str2;
        String str3 = this.f5832a == null ? "report upload fail : HttpDelegate is null" : "";
        if (aVar == null) {
            str3 = "report upload fail : reportBody is null";
        }
        if (file == null) {
            str3 = "report upload fail : file is null";
        }
        if (!TextUtils.isEmpty(str3)) {
            this.c.c("report_log_info", str3);
            b bVar = this.g;
            if (bVar != null) {
                bVar.a(str3, aVar);
                return;
            }
            return;
        }
        try {
            try {
                try {
                    str2 = "report_log_info";
                    try {
                        try {
                            String strA = com.oplus.log.g.a(aVar.f5836a, aVar.f, file.getName(), i, "", aVar.b, this.b.a(), this.b.b(), TextUtils.isEmpty(this.b.c()) ? com.oplus.log.d.b.b(com.oplus.log.d.b.a()) : this.b.c(), aVar.g, aVar.h, aVar.d, this.h, aVar.i, this.c);
                            this.c.a("NearX-HLog", "doReportUpload Code: ".concat(String.valueOf(strA)));
                            com.oplus.log.g.b bVarA = this.f5832a.a(strA, file);
                            if (bVarA != null && bVarA.a() == 200) {
                                a(bVarA);
                                return;
                            }
                            aVar2 = aVar;
                            try {
                                b(aVar2, -110, bVarA == null ? "report upload error:response is null" : "report upload error:response code is " + bVarA.a() + ", msg is " + bVarA.b());
                            } catch (IOException e2) {
                                e = e2;
                                str = str2;
                                b(aVar2, -111, e.toString());
                                this.c.c(str, "report upload network io exception:" + e.toString());
                                if (com.oplus.log.b.c()) {
                                    e.printStackTrace();
                                }
                            } catch (Exception e3) {
                                e = e3;
                                b(aVar2, -111, e.toString());
                                this.c.c(str2, "report upload network exception:" + e.toString());
                                if (com.oplus.log.b.c()) {
                                    e.printStackTrace();
                                }
                            }
                        } catch (IOException e4) {
                            e = e4;
                            aVar2 = aVar;
                        } catch (Exception e5) {
                            e = e5;
                            aVar2 = aVar;
                        }
                    } catch (IOException e6) {
                        e = e6;
                        aVar2 = aVar;
                    } catch (Exception e7) {
                        e = e7;
                        aVar2 = aVar;
                    }
                } catch (IOException e8) {
                    e = e8;
                    aVar2 = aVar;
                    str2 = "report_log_info";
                }
            } catch (Exception e9) {
                e = e9;
                aVar2 = aVar;
                str2 = "report_log_info";
            }
        } catch (IOException e10) {
            e = e10;
            aVar2 = aVar;
            str = "report_log_info";
        }
    }

    private void a(a aVar, int i, String str) {
        if (this.f5832a == null) {
            this.c.c("report_log_info", "upload code error : HttpDelegate is null");
            return;
        }
        if (aVar == null) {
            this.c.c("report_log_info", "upload code error : UploadBody is null");
            return;
        }
        try {
            String strA = com.oplus.log.g.a(aVar.f5836a, aVar.f, "", i, str, aVar.b, this.b.a(), this.b.b(), TextUtils.isEmpty(this.b.c()) ? com.oplus.log.d.b.b(com.oplus.log.d.b.a()) : this.b.c(), aVar.g, aVar.h, aVar.d, this.h, aVar.i, this.c);
            this.c.a("NearX-HLog", "reportUpload Error Code: ".concat(String.valueOf(strA)));
            this.f5832a.a(strA);
        } catch (Exception e2) {
            this.c.c("report_log_info", "upload code error:" + e2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final C0865c c0865c) {
        if (c0865c.e && !com.oplus.log.d.c.b()) {
            this.c.b("upload_log_info", "upload task need wifi connect");
            a(c0865c, -121, "upload task need wifi connect");
            g gVar = this.f;
            if (gVar != null) {
                gVar.a("upload task need wifi connect");
                return;
            }
            return;
        }
        try {
            com.oplus.log.a.a aVar = this.i;
            if (aVar != null) {
                aVar.a();
            }
            com.oplus.log.g.d.a(c0865c.c, c0865c.d, this.b, this.h, c0865c.f, new com.oplus.log.g.d.a() { // from class: com.oplus.log.g.c.1
                @Override // com.oplus.log.g.d.a
                public final void a(int i, File file) {
                    c.this.a(c0865c, i, file);
                }

                @Override // com.oplus.log.g.d.a
                public final void a(int i, String str) {
                    c.this.b(c0865c, i, str);
                }
            });
        } catch (Exception e2) {
            b(c0865c, -1, e2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(C0865c c0865c, int i, File file) {
        String str = this.f5832a == null ? "upload fail : HttpDelegate is null" : "";
        if (c0865c == null) {
            str = "upload fail : uploadBody is null";
        }
        if (file == null) {
            str = "upload fail : file is null";
        }
        if (!TextUtils.isEmpty(str)) {
            this.c.c("upload_log_info", str);
            g gVar = this.f;
            if (gVar != null) {
                gVar.a(str);
                return;
            }
            return;
        }
        try {
            String strA = com.oplus.log.g.a(c0865c.f5837a, c0865c.f, file.getName(), i, "", c0865c.b, this.b.a(), this.b.b(), TextUtils.isEmpty(this.b.c()) ? com.oplus.log.d.b.b(com.oplus.log.d.b.a()) : this.b.c());
            this.c.a("NearX-HLog", "doUpload Code: ".concat(String.valueOf(strA)));
            com.oplus.log.g.b bVarA = this.f5832a.a(strA, file);
            if (bVarA == null || bVarA.a() != 200) {
                b(c0865c, -110, bVarA == null ? "upload error:response is null" : "upload error:response code is " + bVarA.a() + ", msg is " + bVarA.b());
            } else {
                b();
            }
        } catch (IOException e2) {
            b(c0865c, -111, e2.toString());
            this.c.c("upload_log_info", "upload network io exception:" + e2.toString());
            if (com.oplus.log.b.c()) {
                e2.printStackTrace();
            }
        } catch (Exception e3) {
            b(c0865c, -111, e3.toString());
            this.c.c("upload_log_info", "upload network exception:" + e3.toString());
            if (com.oplus.log.b.c()) {
                e3.printStackTrace();
            }
        }
    }

    private void a(C0865c c0865c, int i, String str) {
        com.oplus.log.a aVar;
        String str2;
        if (this.f5832a == null) {
            aVar = this.c;
            str2 = "upload code error : HttpDelegate is null";
        } else {
            if (c0865c != null) {
                try {
                    String strA = com.oplus.log.g.a(c0865c.f5837a, c0865c.f, "", i, str, c0865c.b, this.b.a(), this.b.b(), TextUtils.isEmpty(this.b.c()) ? com.oplus.log.d.b.b(com.oplus.log.d.b.a()) : this.b.c());
                    this.c.a("NearX-HLog", "upload Error Code: ".concat(String.valueOf(strA)));
                    this.f5832a.a(strA);
                    return;
                } catch (Exception e2) {
                    this.c.c("upload_log_info", "upload code error:" + e2.toString());
                    if (com.oplus.log.b.c()) {
                        e2.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            aVar = this.c;
            str2 = "upload code error : UploadBody is null";
        }
        aVar.c("upload_log_info", str2);
    }

    private void b() {
        this.d = 0;
        com.oplus.log.g.d.a(this.h);
        g gVar = this.f;
        if (gVar != null) {
            gVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar, int i, String str) {
        com.oplus.log.g.d.a(this.h);
        int i2 = this.d;
        if (i2 < 3) {
            int i3 = i2 + 1;
            this.d = i3;
            a(aVar, i3 * 2000);
        } else {
            this.c.b("report_log_info", "report upload failed");
            this.d = 0;
            b bVar = this.g;
            if (bVar != null) {
                bVar.a("run out of retry:".concat(String.valueOf(str)), aVar);
            }
            a(aVar, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(C0865c c0865c, int i, String str) {
        com.oplus.log.g.d.a(this.h);
        int i2 = this.d;
        if (i2 < 3) {
            int i3 = i2 + 1;
            this.d = i3;
            a(c0865c, i3 * 2000);
        } else {
            this.c.b("upload_log_info", "upload failed");
            this.d = 0;
            g gVar = this.f;
            if (gVar != null) {
                gVar.a("run out of retry:".concat(String.valueOf(str)));
            }
            a(c0865c, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2, e eVar) {
        if (this.f5832a == null) {
            this.c.c("upload_log_info", "check upload failed : HttpDelegate is null");
            return;
        }
        try {
            String strA = com.oplus.log.g.a(str, str2, this.b.a(), this.b.b(), TextUtils.isEmpty(this.b.c()) ? com.oplus.log.d.b.b(com.oplus.log.d.b.a()) : this.b.c());
            this.c.a("NearX-HLog", "doUploadChecker: ".concat(String.valueOf(strA)));
            UserTraceConfigDto userTraceConfigDtoB = this.f5832a.b(strA);
            if (userTraceConfigDtoB == null || (TextUtils.isEmpty(userTraceConfigDtoB.getImei()) && TextUtils.isEmpty(userTraceConfigDtoB.getOpenId()))) {
                if (eVar != null) {
                    eVar.a("userTraceConfigDto or device id is empty");
                }
            } else if (eVar != null) {
                this.c.b("upload_log_info", "need upload log");
                eVar.a(userTraceConfigDtoB);
            }
        } catch (Exception e2) {
            if (eVar != null) {
                eVar.a(e2.toString());
            }
        }
    }

    public void a(com.oplus.log.a.a aVar) {
        if (aVar != null) {
            this.i = aVar;
        }
    }

    public void a(a aVar, int i) {
        Message messageObtain = Message.obtain();
        messageObtain.obj = aVar;
        this.e.sendMessageDelayed(messageObtain, i);
    }

    public void a(C0865c c0865c, int i) {
        Message messageObtain = Message.obtain();
        messageObtain.obj = c0865c;
        this.e.sendMessageDelayed(messageObtain, i);
    }

    public void a(g gVar) {
        this.f = gVar;
    }

    public void a(String str, String str2, e eVar) {
        d dVar = new d(str, str2);
        dVar.a(eVar);
        Message messageObtain = Message.obtain();
        messageObtain.obj = dVar;
        this.e.sendMessage(messageObtain);
    }
}
