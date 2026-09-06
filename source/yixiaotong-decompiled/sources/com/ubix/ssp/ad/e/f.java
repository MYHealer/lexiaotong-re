package com.ubix.ssp.ad.e;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8818a = 1;
    private String b;

    public interface a {
        void a();

        void b();

        void c();

        void d();
    }

    class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.ubix.ssp.ad.g.k.b f8819a;
        private com.ubix.ssp.ad.e.z.h.b b;

        public b() {
        }

        public b(com.ubix.ssp.ad.e.z.h.b bVar) {
            this.b = bVar;
        }

        public b(com.ubix.ssp.ad.g.k.b bVar) {
            this.f8819a = bVar;
        }

        @Override // com.ubix.ssp.ad.e.f.a
        public void a() {
            com.ubix.ssp.ad.g.k.b bVar = this.f8819a;
            if (bVar != null) {
                bVar.i(0);
            }
            com.ubix.ssp.ad.e.z.h.b bVar2 = this.b;
            if (bVar2 != null) {
                bVar2.a();
            }
        }

        @Override // com.ubix.ssp.ad.e.f.a
        public void b() {
            com.ubix.ssp.ad.g.k.b bVar = this.f8819a;
            if (bVar != null) {
                bVar.b(0);
            }
            com.ubix.ssp.ad.e.z.h.b bVar2 = this.b;
            if (bVar2 != null) {
                bVar2.b();
            }
        }

        @Override // com.ubix.ssp.ad.e.f.a
        public void c() {
            com.ubix.ssp.ad.g.k.b bVar = this.f8819a;
            if (bVar != null) {
                bVar.f(0);
            }
            com.ubix.ssp.ad.e.z.h.b bVar2 = this.b;
            if (bVar2 != null) {
                bVar2.c();
            }
        }

        @Override // com.ubix.ssp.ad.e.f.a
        public void d() {
            com.ubix.ssp.ad.g.k.b bVar = this.f8819a;
            if (bVar != null) {
                bVar.b(0, null, null);
            }
        }
    }

    public static class c extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f8820a;
        private com.ubix.ssp.ad.g.k.b b;
        private a c;
        private com.ubix.ssp.ad.e.z.h.c d;

        public c(int i) {
            this.f8820a = i;
        }

        public c(int i, a aVar) {
            this.f8820a = i;
            this.c = aVar;
        }

        public c(int i, com.ubix.ssp.ad.e.z.h.c cVar) {
            this.f8820a = i;
            this.d = cVar;
        }

        public c(int i, com.ubix.ssp.ad.g.k.b bVar) {
            this.f8820a = i;
            this.b = bVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            a aVar;
            int i = this.f8820a;
            if (i == 1) {
                a aVar2 = this.c;
                if (aVar2 != null) {
                    aVar2.c();
                    return;
                }
                return;
            }
            if (i == 2) {
                a aVar3 = this.c;
                if (aVar3 != null) {
                    aVar3.a();
                    return;
                }
                return;
            }
            if (i == 3) {
                a aVar4 = this.c;
                if (aVar4 != null) {
                    aVar4.b();
                    return;
                }
                return;
            }
            if (i != 0 || (aVar = this.c) == null) {
                return;
            }
            aVar.d();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(false);
        }
    }

    public f(String str) {
        this.b = str;
    }

    private SpannableStringBuilder a(b bVar) {
        SpannableStringBuilder spannableStringBuilderValueOf = SpannableStringBuilder.valueOf(this.b);
        int iIndexOf = this.b.indexOf("权限丨");
        int iIndexOf2 = this.b.indexOf("丨隐私丨");
        int iIndexOf3 = this.b.indexOf("丨功能介绍");
        spannableStringBuilderValueOf.setSpan(new c(1, bVar), iIndexOf, iIndexOf + 1, 33);
        spannableStringBuilderValueOf.setSpan(new c(2, bVar), iIndexOf2 + 1, iIndexOf2 + 3, 33);
        spannableStringBuilderValueOf.setSpan(new c(3, bVar), iIndexOf3 + 1, iIndexOf3 + 4, 33);
        int iIndexOf4 = 0;
        spannableStringBuilderValueOf.setSpan(new c(0, bVar), 0, iIndexOf, 33);
        int i = 10;
        while (true) {
            if (iIndexOf4 == -1 && i >= 0) {
                return spannableStringBuilderValueOf;
            }
            i--;
            iIndexOf4 = this.b.indexOf("丨", iIndexOf4 + 1);
            if (iIndexOf4 != -1) {
                spannableStringBuilderValueOf.setSpan(new StyleSpan(1), iIndexOf4, iIndexOf4 + 1, 18);
            }
        }
    }

    public static TextView a(Context context) {
        return a(context, 0);
    }

    public static TextView a(Context context, int i) {
        int iG = com.ubix.ssp.ad.e.a0.r.a().g(context);
        double dA = com.ubix.ssp.ad.e.a0.r.a().a(context);
        float f = StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getConfiguration().fontScale;
        if (f < 1.0f) {
            f = 1.0f;
        }
        int iMin = (int) Math.min(((((double) iG) / Math.sqrt(Math.exp(dA))) / ((double) f)) / 28.0d, 12.0f / f);
        if (i > 0) {
            iMin -= i;
        }
        TextView textView = new TextView(context);
        textView.setId(920101);
        textView.setGravity(80);
        textView.setTextSize(iMin);
        textView.setTextColor(-1);
        textView.setMaxLines(6);
        textView.setShadowLayer(4.0f, 0.0f, 1.0f, 1711276032);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(0);
        if (i == 0) {
            textView.setLetterSpacing(0.1f);
            textView.setLineSpacing(2.0f, 1.2f);
        }
        return textView;
    }

    private SpannableStringBuilder b() {
        SpannableStringBuilder spannableStringBuilderValueOf = SpannableStringBuilder.valueOf(this.b);
        int iIndexOf = 0;
        int i = 10;
        while (true) {
            if (iIndexOf == -1 && i >= 0) {
                return spannableStringBuilderValueOf;
            }
            i--;
            iIndexOf = this.b.indexOf("丨", iIndexOf + 1);
            if (iIndexOf != -1) {
                spannableStringBuilderValueOf.setSpan(new StyleSpan(1), iIndexOf, iIndexOf + 1, 18);
            }
        }
    }

    public SpannableStringBuilder a() {
        new b();
        return b();
    }

    public SpannableStringBuilder a(com.ubix.ssp.ad.e.z.h.b bVar) {
        return a(new b(bVar));
    }

    public SpannableStringBuilder a(com.ubix.ssp.ad.g.k.b bVar) {
        return a(new b(bVar));
    }
}
