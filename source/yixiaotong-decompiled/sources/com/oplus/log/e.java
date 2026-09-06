package com.oplus.log;

import android.text.TextUtils;
import android.util.Log;
import com.oplus.log.core.i;
import com.oplus.log.core.m;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.oplus.log.core.b f5825a = null;

    @Override // com.oplus.log.d
    public final void a() {
        try {
            com.oplus.log.core.b bVar = this.f5825a;
            if (bVar.f5801a == null) {
                throw new RuntimeException("Please initialize Logan first");
            }
            com.oplus.log.core.d dVar = bVar.f5801a;
            if (TextUtils.isEmpty(dVar.b) || dVar.d == null) {
                return;
            }
            dVar.d.b();
        } catch (Exception e) {
            if (b.c()) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.oplus.log.d
    public final void a(com.oplus.log.core.c cVar) {
        try {
            com.oplus.log.core.b bVar = new com.oplus.log.core.b();
            this.f5825a = bVar;
            bVar.a(cVar);
            if (b.c()) {
                this.f5825a.a(new i() { // from class: com.oplus.log.e.1
                    @Override // com.oplus.log.core.i
                    public final void a(String str, int i) {
                        Log.i("NLogWriter", "loganProtocolStatus: " + str + "," + i);
                    }
                });
            }
        } catch (Throwable th) {
            if (b.c()) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.oplus.log.d
    public final void a(com.oplus.log.core.e.b bVar) {
        try {
            this.f5825a.a(bVar);
        } catch (Exception e) {
            if (b.c()) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.oplus.log.d
    public final void a(String str, String str2, byte b, int i) {
        try {
            com.oplus.log.core.b bVar = this.f5825a;
            if (bVar.f5801a == null) {
                throw new RuntimeException("Please initialize Logan first");
            }
            com.oplus.log.core.d dVar = bVar.f5801a;
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            com.oplus.log.core.e eVar = new com.oplus.log.core.e();
            eVar.f5805a = com.oplus.log.core.e.a.f5806a;
            m mVar = new m();
            String name = Thread.currentThread().getName();
            long id = Thread.currentThread().getId();
            mVar.f5815a = str;
            mVar.c = str2;
            mVar.b = b;
            mVar.f = System.currentTimeMillis();
            mVar.g = i;
            mVar.d = id;
            mVar.e = name;
            eVar.c = mVar;
            if (dVar.f5804a.size() < dVar.c) {
                dVar.f5804a.add(eVar);
                if (dVar.d != null) {
                    dVar.d.a();
                }
            }
        } catch (Exception e) {
            if (b.c()) {
                e.printStackTrace();
            }
        }
    }
}
