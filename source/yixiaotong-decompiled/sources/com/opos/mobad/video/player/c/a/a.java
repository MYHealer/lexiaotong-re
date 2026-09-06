package com.opos.mobad.video.player.c.a;

import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface a<T> {

    /* JADX INFO: renamed from: com.opos.mobad.video.player.c.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC1034a {
        void a();

        void a(int i, int[] iArr);

        void b();
    }

    public interface b {
        boolean c();
    }

    public interface c {

        /* JADX INFO: renamed from: com.opos.mobad.video.player.c.a.a$c$a, reason: collision with other inner class name */
        public interface InterfaceC1035a {
            void a(long j, long j2);

            void b(long j, long j2);

            void c();

            void c(long j, long j2);
        }

        void a(InterfaceC1035a interfaceC1035a);

        void d();

        void e();
    }

    public interface d {

        /* JADX INFO: renamed from: com.opos.mobad.video.player.c.a.a$d$a, reason: collision with other inner class name */
        public interface InterfaceC1036a {
            void d();

            void e();
        }

        void a(InterfaceC1036a interfaceC1036a);

        void a(Object obj, String str);

        void a(String str);

        void b(String str);

        View f();

        void g();
    }

    FrameLayout a();

    void a(InterfaceC1034a interfaceC1034a);

    void a(b bVar);

    void a(c cVar);

    void a(d dVar);

    void a(T t);

    void b();
}
