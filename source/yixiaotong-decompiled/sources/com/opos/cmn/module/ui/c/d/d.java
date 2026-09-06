package com.opos.cmn.module.ui.c.d;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.opos.cmn.module.ui.c.c.e;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d extends a implements c {
    private com.opos.cmn.module.ui.c.c.d c;
    private com.opos.cmn.module.ui.c.a.a d;
    private View e;
    private String f;
    private boolean g;
    private Queue<com.opos.cmn.module.ui.c.b.b> h;
    private final Handler i;

    public d(Context context, e eVar) {
        super(context, eVar);
        this.g = false;
        this.h = new ConcurrentLinkedQueue();
        this.i = new Handler(Looper.getMainLooper()) { // from class: com.opos.cmn.module.ui.c.d.d.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message != null) {
                    try {
                        int i = message.what;
                        if (i == 1 || i == 2) {
                            d dVar = d.this;
                            dVar.b(null, null, dVar.f, new Object[0]);
                        }
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.a("ReminderToastWidget", "", (Throwable) e);
                    }
                }
            }
        };
        c();
    }

    private void a(com.opos.cmn.module.ui.c.b.b bVar) {
        com.opos.cmn.an.f.a.b("ReminderToastWidget", "show toastParams=" + (bVar != null ? bVar.toString() : "null"));
        if (bVar != null) {
            this.d.a(bVar.a(), bVar.b(), bVar.c());
            if (k()) {
                g();
            } else {
                if (this.e == null) {
                    this.e = this.d.a();
                    d();
                }
                h();
            }
            String strA = bVar.a();
            this.f = strA;
            a((View) null, strA, new Object[0]);
            this.g = true;
        }
    }

    private void c() {
        com.opos.cmn.module.ui.c.a.b bVar = new com.opos.cmn.module.ui.c.a.b(this.f6219a, this);
        this.d = bVar;
        this.e = bVar.a();
        if (k()) {
            e();
        } else {
            d();
        }
    }

    private void d() {
        try {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.type = 2002;
            layoutParams.flags = MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH;
            layoutParams.width = com.opos.cmn.an.h.f.a.b(this.f6219a);
            layoutParams.height = com.opos.cmn.an.h.f.a.a(this.f6219a, 90.0f);
            layoutParams.gravity = 49;
            layoutParams.format = 1;
            View view = this.e;
            if (view != null) {
                view.setVisibility(8);
                com.opos.cmn.an.h.f.a.a(this.f6219a, this.e, layoutParams);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ReminderToastWidget", "", (Throwable) e);
        }
    }

    private void e() {
        try {
            com.opos.cmn.module.ui.c.c.c cVar = new com.opos.cmn.module.ui.c.c.c(this.f6219a, null);
            this.c = cVar;
            View view = this.e;
            if (view != null) {
                cVar.a(view);
            }
            WindowManager.LayoutParams layoutParamsA = this.c.a();
            if (layoutParamsA != null) {
                layoutParamsA.flags = MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH;
                layoutParamsA.width = com.opos.cmn.an.h.f.a.b(this.f6219a);
                layoutParamsA.height = com.opos.cmn.an.h.f.a.a(this.f6219a, 90.0f);
            }
            this.c.a(49, 0, 0);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ReminderToastWidget", "", (Throwable) e);
        }
    }

    private void f() {
        com.opos.cmn.an.f.a.b("ReminderToastWidget", "showNext mIsShowing=" + this.g);
        try {
            if (this.g) {
                return;
            }
            a(this.h.poll());
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ReminderToastWidget", "", (Throwable) e);
        }
    }

    private void g() {
        com.opos.cmn.an.f.a.b("ReminderToastWidget", "showCustomToast");
        try {
            this.c.a(1);
            if (this.i.hasMessages(2)) {
                this.i.removeMessages(2);
            }
            this.c.b();
            this.i.sendEmptyMessageDelayed(2, 4000L);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ReminderToastWidget", "", (Throwable) e);
        }
    }

    private void h() {
        com.opos.cmn.an.f.a.b("ReminderToastWidget", "showFloatWindow ");
        try {
            if (this.i.hasMessages(1)) {
                this.i.removeMessages(1);
            }
            this.e.setVisibility(0);
            this.e.invalidate();
            this.i.sendEmptyMessageDelayed(1, 3500L);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ReminderToastWidget", "", (Throwable) e);
        }
    }

    private void i() {
        if (this.i.hasMessages(2)) {
            this.i.removeMessages(2);
        }
    }

    private void j() {
        if (this.i.hasMessages(1)) {
            this.i.removeMessages(1);
        }
        this.e.setVisibility(8);
        this.e.invalidate();
    }

    private boolean k() {
        boolean z = false;
        try {
            if (com.opos.cmn.an.c.c.b() >= 19) {
                z = true;
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ReminderToastWidget", "", (Throwable) e);
        }
        com.opos.cmn.an.f.a.b("ReminderToastWidget", "isToastSupportClick=" + z);
        return z;
    }

    @Override // com.opos.cmn.module.ui.c.d.c
    public void a() {
        com.opos.cmn.an.f.a.b("ReminderToastWidget", "cancelNotification");
        try {
            if (k()) {
                i();
            } else {
                j();
            }
            this.g = false;
            f();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ReminderToastWidget", "", (Throwable) e);
        }
    }

    public void a(View view, String str, Object... objArr) {
        com.opos.cmn.an.f.a.b("ReminderToastWidget", "onShow view=" + (view != null ? view : "null") + ",pkgName=" + (str != null ? str : "null") + ",objects=" + (objArr != null ? objArr : "null"));
        this.b.a(view, str, objArr);
    }

    @Override // com.opos.cmn.module.ui.c.d.c
    public void a(View view, int[] iArr, String str, Object... objArr) {
        com.opos.cmn.an.f.a.b("ReminderToastWidget", "onClick view=" + (view != null ? view : "null") + ",pkgName=" + (str != null ? str : "null") + ",objects=" + (objArr != null ? objArr : "null"));
        this.b.a(view, iArr, str, objArr);
    }

    @Override // com.opos.cmn.module.ui.c.d.c
    public void a(String str, boolean z, Object... objArr) {
        try {
            if (com.opos.cmn.an.d.a.a(str)) {
                return;
            }
            com.opos.cmn.an.f.a.b("ReminderToastWidget", "show pkgName=" + str + ",gbClick=" + z + ",objects=" + (objArr != null ? objArr : "null"));
            this.h.offer(new com.opos.cmn.module.ui.c.b.b(str, z, objArr));
            f();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ReminderToastWidget", "", (Throwable) e);
        }
    }

    @Override // com.opos.cmn.module.ui.c.d.c
    public void b() {
        com.opos.cmn.an.f.a.b("ReminderToastWidget", "destroyContext");
        try {
            if (k()) {
                com.opos.cmn.module.ui.c.c.d dVar = this.c;
                if (dVar != null) {
                    dVar.c();
                }
            } else if (this.e != null) {
                com.opos.cmn.an.h.f.a.a(this.f6219a, this.e);
                this.e = null;
            }
            this.g = false;
            this.h.clear();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ReminderToastWidget", "", (Throwable) e);
        }
    }

    @Override // com.opos.cmn.module.ui.c.d.c
    public void b(View view, int[] iArr, String str, Object... objArr) {
        com.opos.cmn.an.f.a.b("ReminderToastWidget", "onClose view=" + (view != null ? view : "null") + ",pkgName=" + (str != null ? str : "null") + ",objects=" + (objArr != null ? objArr : "null"));
        this.b.b(view, iArr, str, objArr);
    }
}
