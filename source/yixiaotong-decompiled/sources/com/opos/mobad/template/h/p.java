package com.opos.mobad.template.h;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class p extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f8108a;
    private a b;

    public interface a {
        void a(View view, int[] iArr);

        void b(View view, int[] iArr);
    }

    public p(Context context) {
        super(context);
        a();
    }

    public static p a(Context context) {
        return new p(context);
    }

    private void a() {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setBackgroundColor(0);
        RelativeLayout relativeLayout2 = new RelativeLayout(getContext());
        RelativeLayout relativeLayout3 = new RelativeLayout(getContext());
        FrameLayout frameLayout = new FrameLayout(getContext());
        relativeLayout2.setBackgroundResource(R.drawable.opos_mobad_drawable_reward_dialog_bg);
        relativeLayout.setBackgroundColor(Color.parseColor("#B3000000"));
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setId(View.generateViewId());
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        int iA = com.opos.cmn.an.h.f.a.a(getContext(), 20.0f);
        TextView textView = new TextView(getContext());
        textView.setTextColor(Color.parseColor("#2D40E9"));
        textView.setGravity(1);
        textView.setTextSize(1, 14.0f);
        textView.setText("关闭视频");
        TextPaint paint = textView.getPaint();
        paint.setStrokeWidth(1.0f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, iA);
        layoutParams.weight = 1.0f;
        linearLayout.addView(textView, layoutParams);
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.p.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (p.this.b != null) {
                    p.this.b.a(view, iArr);
                }
            }
        };
        textView.setOnClickListener(pVar);
        textView.setOnTouchListener(pVar);
        TextView textView2 = new TextView(getContext());
        textView2.setBackgroundColor(Color.parseColor("#33000000"));
        linearLayout.addView(textView2, new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 1.0f), iA));
        TextView textView3 = new TextView(getContext());
        textView3.setTextColor(Color.parseColor("#2D40E9"));
        textView3.setTextSize(1, 14.0f);
        textView3.setGravity(1);
        textView3.setText("继续观看");
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, iA);
        layoutParams2.weight = 1.0f;
        TextPaint paint2 = textView3.getPaint();
        paint2.setStrokeWidth(1.0f);
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        linearLayout.addView(textView3, layoutParams2);
        com.opos.mobad.template.cmn.p pVar2 = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.p.2
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (p.this.b != null) {
                    p.this.b.b(view, iArr);
                }
            }
        };
        textView3.setOnClickListener(pVar2);
        textView3.setOnTouchListener(pVar2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(getContext(), 60.0f));
        layoutParams3.addRule(14);
        layoutParams3.addRule(12);
        relativeLayout3.addView(linearLayout, layoutParams3);
        TextView textView4 = new TextView(getContext());
        this.f8108a = textView4;
        textView4.setId(View.generateViewId());
        this.f8108a.setTextColor(Color.parseColor("#D9000000"));
        this.f8108a.setTextSize(1, 16.0f);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 17;
        TextPaint paint3 = this.f8108a.getPaint();
        paint3.setStrokeWidth(1.0f);
        paint3.setStyle(Paint.Style.FILL_AND_STROKE);
        int iA2 = com.opos.cmn.an.h.f.a.a(getContext(), 24.0f);
        frameLayout.setPadding(iA2, iA2, iA2, 0);
        frameLayout.addView(this.f8108a, layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams5.addRule(14);
        layoutParams5.addRule(2, linearLayout.getId());
        relativeLayout3.addView(frameLayout, layoutParams5);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 328.0f), -2);
        layoutParams6.addRule(15);
        relativeLayout2.addView(relativeLayout3, layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 328.0f), com.opos.cmn.an.h.f.a.a(getContext(), 143.0f));
        layoutParams7.addRule(13);
        relativeLayout.addView(relativeLayout2, layoutParams7);
        addView(relativeLayout, new RelativeLayout.LayoutParams(-1, -1));
    }

    public void a(a aVar) {
        this.b = aVar;
    }

    public void a(CharSequence charSequence) {
        if (charSequence == null || TextUtils.isEmpty(charSequence)) {
            return;
        }
        this.f8108a.setText(charSequence);
    }
}
