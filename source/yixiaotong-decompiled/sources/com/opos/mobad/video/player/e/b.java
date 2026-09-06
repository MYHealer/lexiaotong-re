package com.opos.mobad.video.player.e;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.opos.mobad.template.a f8385a;
    public final com.opos.mobad.video.player.b b;
    public final com.opos.mobad.ui.feedback.a c;
    public final com.opos.mobad.template.a d;
    public final com.opos.mobad.template.a e;
    public final boolean f;
    public final boolean g;
    public final com.opos.mobad.video.player.c.a h;
    public final com.opos.mobad.video.player.c.a.a<com.opos.mobad.video.player.c.a.b> i;

    /* JADX INFO: renamed from: com.opos.mobad.video.player.e.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.opos.mobad.video.player.c.a.a<com.opos.mobad.video.player.c.a.b> f8386a;
        private com.opos.mobad.template.a b;
        private com.opos.mobad.video.player.b c;
        private com.opos.mobad.ui.feedback.a d;
        private com.opos.mobad.template.a e = null;
        private com.opos.mobad.template.a f = null;
        private com.opos.mobad.template.a g = null;
        private com.opos.mobad.video.player.c.a h = null;
        private boolean i = false;
        private boolean j = true;

        public a(com.opos.mobad.template.a aVar, com.opos.mobad.video.player.b bVar, com.opos.mobad.ui.feedback.a aVar2) {
            this.b = aVar;
            this.c = bVar;
            this.d = aVar2;
        }

        public a a(com.opos.mobad.template.a aVar) {
            this.e = aVar;
            return this;
        }

        public a a(com.opos.mobad.video.player.c.a.a<com.opos.mobad.video.player.c.a.b> aVar) {
            this.f8386a = aVar;
            return this;
        }

        public a a(com.opos.mobad.video.player.c.a aVar) {
            this.h = aVar;
            return this;
        }

        public a a(boolean z) {
            this.i = z;
            return this;
        }

        public b a() {
            return new b(this, null);
        }

        public a b(com.opos.mobad.template.a aVar) {
            this.f = aVar;
            return this;
        }

        public a b(boolean z) {
            this.j = z;
            return this;
        }
    }

    private b(a aVar) {
        this.f8385a = aVar.b;
        this.b = aVar.c;
        this.c = aVar.d;
        this.d = aVar.e;
        this.e = aVar.f;
        this.f = aVar.i;
        this.g = aVar.j;
        this.h = aVar.h;
        this.i = aVar.f8386a;
    }

    /* synthetic */ b(a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    public void a() {
        com.opos.mobad.ui.feedback.a aVar = this.c;
        if (aVar != null) {
            aVar.a();
        }
        com.opos.mobad.template.a aVar2 = this.f8385a;
        if (aVar2 != null) {
            aVar2.d();
        }
        com.opos.mobad.video.player.b bVar = this.b;
        if (bVar != null) {
            bVar.c();
        }
        com.opos.mobad.template.a aVar3 = this.d;
        if (aVar3 != null) {
            aVar3.d();
        }
        com.opos.mobad.template.a aVar4 = this.e;
        if (aVar4 != null) {
            aVar4.d();
        }
        com.opos.mobad.video.player.c.a aVar5 = this.h;
        if (aVar5 != null) {
            aVar5.d();
        }
    }
}
