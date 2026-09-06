package com.opos.cmn.module.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.cmn.module.ui.b.a.c;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class WebViewActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f6182a;

    /* JADX INFO: renamed from: com.opos.cmn.module.ui.WebViewActivity$1, reason: invalid class name */
    class AnonymousClass1 implements b {
        AnonymousClass1() {
        }

        @Override // com.opos.cmn.module.ui.WebViewActivity.b
        public void a() {
            WebViewActivity.this.finish();
        }
    }

    public static final class a extends RelativeLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private LinearLayout f6184a;
        private TextView b;
        private Context c;
        private b d;
        private com.opos.cmn.module.ui.b.a.a e;

        public a(Context context) {
            super(context);
            this.c = com.opos.mobad.service.a.a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            b();
        }

        private void a(int i, b bVar) {
            com.opos.cmn.module.ui.b.a.a aVar = this.e;
            if (aVar != null) {
                if (i == aVar.a()) {
                    com.opos.cmn.an.f.a.b("CustomPrivacyTextView", "Same type use last view");
                    return;
                } else {
                    com.opos.cmn.an.f.a.b("CustomPrivacyTextView", "differ type use new one");
                    removeView(this.e.b());
                    this.e.c();
                }
            }
            c cVar = new c(this.c, bVar);
            this.e = cVar;
            View viewB = cVar.b();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, this.f6184a.getId());
            addView(viewB, layoutParams);
        }

        private void b() {
            setBackgroundColor(-1);
            LinearLayout linearLayout = new LinearLayout(this.c);
            this.f6184a = linearLayout;
            linearLayout.setId(View.generateViewId());
            this.f6184a.setOrientation(0);
            TextView textView = new TextView(this.c);
            this.b = new TextView(this.c);
            textView.setBackground(com.opos.cmn.an.e.a.a.c(this.c, "opos_module_biz_ui_cmn_privacy_web_close_bn.png"));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.opos.cmn.module.ui.WebViewActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.d != null) {
                        a.this.d.a();
                    }
                }
            });
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.c, 16.58f), com.opos.cmn.an.h.f.a.a(this.c, 12.73f));
            layoutParams.gravity = 16;
            layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.c, 23.71f);
            layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.c, 18.71f);
            this.f6184a.addView(textView, layoutParams);
            this.b.setGravity(8388627);
            this.b.setTextSize(1, 16.0f);
            this.b.setTextColor(-16777216);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 16;
            this.f6184a.addView(this.b, layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.c, 50.0f));
            layoutParams3.addRule(10);
            addView(this.f6184a, layoutParams3);
        }

        public void a() {
            removeAllViews();
            com.opos.cmn.module.ui.b.a.a aVar = this.e;
            if (aVar != null) {
                aVar.c();
            }
        }

        public void a(b bVar) {
            this.d = bVar;
        }

        public void a(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.opos.cmn.an.f.a.b("CustomPrivacyTextView", "show url = " + str);
            a(0, this.d);
            this.e.a(str);
            this.b.setText(str2);
        }
    }

    public interface b {
        void a();
    }

    static {
        StubApp.interface11(47944);
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        a aVar = this.f6182a;
        if (aVar != null) {
            aVar.a();
        }
        com.opos.cmn.an.f.a.b("WebViewActivity", "onDestroy");
    }
}
