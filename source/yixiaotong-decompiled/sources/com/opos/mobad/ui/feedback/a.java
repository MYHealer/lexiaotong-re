package com.opos.mobad.ui.feedback;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.Toast;
import com.opos.mobad.ui.feedback.b.c;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f8320a;
    private b b;
    private com.opos.mobad.ui.feedback.b.a c;
    private com.opos.mobad.ui.feedback.b.b d;
    private String f;
    private final String e = "以后将减少此类推荐";
    private c g = new c() { // from class: com.opos.mobad.ui.feedback.a.2
        @Override // com.opos.mobad.ui.feedback.b.c
        public void a() {
            if (a.this.c != null) {
                a.this.c.dismiss();
            }
        }

        @Override // com.opos.mobad.ui.feedback.b.c
        public void a(int i) {
            if (a.this.b != null) {
                a.this.b.a(i);
            }
            if (i != com.opos.mobad.ui.feedback.a.a.TAG_BLOCK_CONTENT.a()) {
                if (a.this.c != null) {
                    a.this.c.dismiss();
                }
                if (i != com.opos.mobad.ui.feedback.a.a.TAG_CONTENT_COMPLAINT.a()) {
                    Toast.makeText(a.this.f8320a, "以后将减少此类推荐", 1).show();
                } else if (a.this.b != null) {
                    a.this.b.b(false);
                }
            }
        }

        @Override // com.opos.mobad.ui.feedback.b.c
        public void b() {
            if (a.this.b != null) {
                a.this.b.b(true);
            }
        }
    };

    public a(Context context, b bVar) {
        this.f8320a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.b = bVar;
        com.opos.mobad.ui.feedback.b.a aVar = new com.opos.mobad.ui.feedback.b.a(context);
        this.c = aVar;
        aVar.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.opos.mobad.ui.feedback.a.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (a.this.b != null) {
                    a.this.b.a(false);
                }
            }
        });
    }

    public void a() {
        com.opos.cmn.an.f.a.b("FeedBackPresenter", "destroy mFeedBackPopWindow =" + this.c);
        com.opos.mobad.ui.feedback.b.a aVar = this.c;
        if (aVar != null) {
            aVar.dismiss();
            this.c.setOnDismissListener(null);
        }
        com.opos.mobad.ui.feedback.b.b bVar = this.d;
        if (bVar != null) {
            bVar.b();
        }
    }

    public void a(View view) {
        if (view != null) {
            try {
                if (b(view.getRootView())) {
                    com.opos.mobad.ui.feedback.b.b bVar = this.d;
                    if (bVar != null) {
                        bVar.b();
                    }
                    com.opos.mobad.ui.feedback.b.b bVar2 = new com.opos.mobad.ui.feedback.b.b(this.f8320a, this.g, this.f);
                    this.d = bVar2;
                    this.c.a(bVar2.a(), -1, -1, view);
                    return;
                }
            } catch (Exception unused) {
            }
        }
        b bVar3 = this.b;
        if (bVar3 != null) {
            bVar3.a(true);
        }
    }

    public void a(b bVar) {
        this.b = bVar;
    }

    public void a(String str) {
        this.f = str;
    }

    public boolean b(View view) {
        if (view != null) {
            Rect rect = new Rect();
            view.getLocalVisibleRect(rect);
            com.opos.cmn.an.f.a.b("FeedBackPresenter", "isMeetSize viewArea =" + rect.toString());
            if (rect.width() >= com.opos.cmn.an.h.f.a.a(view.getContext(), 320.0f) && rect.height() >= com.opos.cmn.an.h.f.a.a(view.getContext(), 320.0f)) {
                return true;
            }
        }
        com.opos.cmn.an.f.a.b("FeedBackPresenter", "decorView is not meet Size with FeedBackContent");
        return false;
    }
}
