package com.opos.mobad.e;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e implements com.opos.mobad.h {
    /* JADX WARN: Code duplicated, block: B:21:0x003d  */
    @Override // com.opos.mobad.h
    public String a(String str) {
        byte b;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            int iHashCode = str.hashCode();
            if (iHashCode != 1197500943) {
                if (iHashCode != 1688676165) {
                    if (iHashCode == 1904942735 && str.equals("landingPageLinkCount")) {
                        b = 2;
                    } else {
                        b = -1;
                    }
                } else if (str.equals("landingPageLinkInterval")) {
                    b = 1;
                } else {
                    b = -1;
                }
            } else if (str.equals("reward_video_fallback_pos_id")) {
                b = 0;
            } else {
                b = -1;
            }
            if (b == 0) {
                return com.opos.mobad.c.b.a().m().b();
            }
            if (b != 1) {
                return b != 2 ? "" : String.valueOf(com.opos.mobad.c.b.a().v());
            }
            return String.valueOf(com.opos.mobad.c.b.a().w());
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("MobConfigModel", "getConfigByKey", e);
            return "";
        }
    }

    @Override // com.opos.mobad.h
    public void a() {
        com.opos.mobad.c.b.a().a();
    }

    @Override // com.opos.mobad.h
    public int b() {
        return com.opos.mobad.c.b.a().d();
    }

    @Override // com.opos.mobad.h
    public boolean c() {
        return com.opos.mobad.c.b.a().e();
    }

    @Override // com.opos.mobad.h
    public long d() {
        return com.opos.mobad.c.b.a().g();
    }

    @Override // com.opos.mobad.h
    public boolean e() {
        return com.opos.mobad.c.b.a().f();
    }

    @Override // com.opos.mobad.h
    public int f() {
        return com.opos.mobad.c.b.a().j();
    }

    @Override // com.opos.mobad.h
    public int g() {
        return com.opos.mobad.c.b.a().o();
    }

    @Override // com.opos.mobad.h
    public int h() {
        return com.opos.mobad.c.b.a().l();
    }

    @Override // com.opos.mobad.h
    public int i() {
        return com.opos.mobad.c.b.a().r();
    }

    @Override // com.opos.mobad.h
    public int j() {
        return com.opos.mobad.c.b.a().t();
    }

    @Override // com.opos.mobad.h
    public int k() {
        return com.opos.mobad.c.b.a().q();
    }

    @Override // com.opos.mobad.h
    public boolean l() {
        return com.opos.mobad.c.b.a().A();
    }

    @Override // com.opos.mobad.h
    public boolean m() {
        return com.opos.mobad.c.b.a().D();
    }

    @Override // com.opos.mobad.h
    public String n() {
        return com.opos.mobad.c.b.a().E();
    }
}
