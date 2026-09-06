package com.opos.mobad.template.cmn.cardslideview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.C;
import com.opos.mobad.template.cmn.ac;
import com.opos.mobad.template.cmn.p;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a<T> extends RelativeLayout implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    GradientDrawable f7500a;
    GradientDrawable b;
    LinearLayout c;
    boolean d;
    private CardSlideView<T> e;
    private long f;
    private boolean g;
    private boolean h;
    private g i;
    private ac j;
    private Runnable k;

    public a(Context context, int i) {
        super(context);
        this.g = true;
        this.h = false;
        this.k = new Runnable() { // from class: com.opos.mobad.template.cmn.cardslideview.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.e.a(a.this.e.d() + 1, true);
                com.opos.mobad.d.c.c.a(this, a.this.f);
            }
        };
        a(context, i);
    }

    private void a(Context context) {
        com.opos.mobad.d.e.a aVar = new com.opos.mobad.d.e.a(context);
        aVar.a(new com.opos.mobad.d.e.a.InterfaceC0958a() { // from class: com.opos.mobad.template.cmn.cardslideview.a.1
            @Override // com.opos.mobad.d.e.a.InterfaceC0958a
            public void a(boolean z) {
                a.this.h = z;
                if (!z) {
                    a.this.b();
                    return;
                }
                a.this.a();
                if (!a.this.j.a() || a.this.j.b().getVisibility() == 0) {
                    return;
                }
                a.this.j.b().setVisibility(0);
            }
        });
        addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0130  */
    /* JADX WARN: Code duplicated, block: B:17:0x0157  */
    private void a(Context context, int i) {
        int iA;
        CardSlideView<T> cardSlideView;
        ac acVar;
        RelativeLayout.LayoutParams layoutParams;
        this.f = C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        if (i != 0) {
            if (i == 1) {
                cardSlideView = new CardSlideView<>(context, -0.945f, 0.108f, 0.56f, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL, 0, 1);
            } else {
                this.e = i == 2 ? new CardSlideView<>(context, -0.82f, 0.36f, 1.78f, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME, 0, 1) : new CardSlideView<>(context, -0.945f, 0.108f, 0.56f, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FLV_ABR, 0, 1);
                iA = com.opos.cmn.an.h.f.a.a(context, 12.0f);
                this.d = false;
            }
            this.e.setId(View.generateViewId());
            this.e.a((g) this);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(13);
            addView(this.e, layoutParams2);
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.topMargin = iA;
            layoutParams3.addRule(3, this.e.getId());
            layoutParams3.addRule(14);
            addView(relativeLayout, layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.c = linearLayout;
            linearLayout.setOrientation(0);
            layoutParams4.addRule(14);
            relativeLayout.addView(this.c, layoutParams4);
            this.c.setVisibility(8);
            GradientDrawable gradientDrawable = new GradientDrawable();
            this.b = gradientDrawable;
            gradientDrawable.setShape(1);
            this.b.setColor(-1);
            this.b.setSize(com.opos.cmn.an.h.f.a.a(context, 6.0f), com.opos.cmn.an.h.f.a.a(context, 6.0f));
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            this.f7500a = gradientDrawable2;
            gradientDrawable2.setShape(1);
            this.f7500a.setColor(Color.argb(102, 255, 255, 255));
            this.f7500a.setSize(com.opos.cmn.an.h.f.a.a(context, 6.0f), com.opos.cmn.an.h.f.a.a(context, 6.0f));
            acVar = new ac(context, 1, this.d);
            this.j = acVar;
            if (acVar.a()) {
                layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(context, 46.0f));
                layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(context, 11.0f);
                layoutParams.addRule(8, this.e.getId());
                layoutParams.addRule(14);
                if (this.j.b() != null) {
                    addView(this.j.b(), layoutParams);
                }
            }
            a(context);
        }
        cardSlideView = new CardSlideView<>(context, -0.82f, 0.36f, 1.78f, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_AUDIO_PTS, 0, 1);
        this.e = cardSlideView;
        iA = com.opos.cmn.an.h.f.a.a(context, 16.0f);
        this.d = true;
        this.e.setId(View.generateViewId());
        this.e.a((g) this);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(13);
        addView(this.e, layoutParams5);
        RelativeLayout relativeLayout2 = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.topMargin = iA;
        layoutParams6.addRule(3, this.e.getId());
        layoutParams6.addRule(14);
        addView(relativeLayout2, layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        this.c = linearLayout2;
        linearLayout2.setOrientation(0);
        layoutParams7.addRule(14);
        relativeLayout2.addView(this.c, layoutParams7);
        this.c.setVisibility(8);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        this.b = gradientDrawable3;
        gradientDrawable3.setShape(1);
        this.b.setColor(-1);
        this.b.setSize(com.opos.cmn.an.h.f.a.a(context, 6.0f), com.opos.cmn.an.h.f.a.a(context, 6.0f));
        GradientDrawable gradientDrawable4 = new GradientDrawable();
        this.f7500a = gradientDrawable4;
        gradientDrawable4.setShape(1);
        this.f7500a.setColor(Color.argb(102, 255, 255, 255));
        this.f7500a.setSize(com.opos.cmn.an.h.f.a.a(context, 6.0f), com.opos.cmn.an.h.f.a.a(context, 6.0f));
        acVar = new ac(context, 1, this.d);
        this.j = acVar;
        if (acVar.a()) {
            layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(context, 46.0f));
            layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(context, 11.0f);
            layoutParams.addRule(8, this.e.getId());
            layoutParams.addRule(14);
            if (this.j.b() != null) {
                addView(this.j.b(), layoutParams);
            }
        }
        a(context);
    }

    private void switchToPoint(int i) {
        if (this.c != null) {
            int i2 = 0;
            while (i2 < this.c.getChildCount()) {
                this.c.getChildAt(i2).setBackground(i2 == i ? this.b : this.f7500a);
                this.c.getChildAt(i2).requestLayout();
                i2++;
            }
        }
    }

    private void transformSelf(View view, float f, int i) {
        g gVar = this.i;
        if (gVar != null) {
            gVar.transformPage(view, f, i);
        }
    }

    public void a() {
        List<T> listB = this.e.b();
        if (listB != null && listB.size() > 1) {
            if (this.g) {
                b();
            }
            this.g = true;
            com.opos.mobad.d.c.c.a(this.k, this.f);
            if (this.j.a()) {
                this.j.e();
            }
        }
    }

    public void a(com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a, int i, int i2, String str) {
        if (this.j.a()) {
            this.j.a(interfaceC1003a);
            this.j.a(i, i2, str);
        }
    }

    public void a(g gVar) {
        this.i = gVar;
    }

    public void a(p pVar) {
        this.e.a(pVar);
    }

    public void a(List<T> list, b<T> bVar, boolean z) {
        int size = list == null ? 0 : list.size();
        if (size <= 1) {
            if (this.e.a() == 0) {
                this.e.b(false);
            } else {
                this.e.c(false);
            }
            this.e.a(false);
        }
        this.e.a(list, bVar, z);
        LinearLayout linearLayout = this.c;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            if (size > 1) {
                this.c.setVisibility(0);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 6.0f), com.opos.cmn.an.h.f.a.a(getContext(), 6.0f));
                layoutParams.gravity = 16;
                layoutParams.setMargins(com.opos.cmn.an.h.f.a.a(getContext(), 3.0f), com.opos.cmn.an.h.f.a.a(getContext(), 3.0f), com.opos.cmn.an.h.f.a.a(getContext(), 3.0f), com.opos.cmn.an.h.f.a.a(getContext(), 3.0f));
                for (int i = 0; i < size; i++) {
                    View view = new View(getContext());
                    view.setLayoutParams(layoutParams);
                    GradientDrawable gradientDrawable = this.f7500a;
                    if (gradientDrawable != null && this.b != null) {
                        view.setBackground(gradientDrawable);
                    }
                    this.c.addView(view);
                }
            }
        }
        if (this.g && this.h) {
            a();
        }
    }

    public void b() {
        this.g = false;
        com.opos.mobad.d.c.c.b(this.k);
        if (this.j.a()) {
            this.j.d();
        }
    }

    public void c() {
        Runnable runnable = this.k;
        if (runnable != null) {
            com.opos.mobad.d.c.c.b(runnable);
        }
        if (this.j.a()) {
            this.j.f();
        }
        removeAllViews();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        long downTime;
        long eventTime;
        int action;
        float x;
        float y;
        int action2 = motionEvent.getAction();
        if (action2 == 1 || action2 == 3 || action2 == 4) {
            a();
        } else if (action2 == 0) {
            b();
        }
        if (motionEvent.getPointerCount() > 1) {
            return false;
        }
        if (motionEvent.getY() < this.e.getY()) {
            downTime = motionEvent.getDownTime();
            eventTime = motionEvent.getEventTime();
            action = motionEvent.getAction();
            x = motionEvent.getX();
            y = this.e.getY() + motionEvent.getY();
        } else if (motionEvent.getY() > this.e.getY() + this.e.getHeight()) {
            downTime = motionEvent.getDownTime();
            eventTime = motionEvent.getEventTime();
            action = motionEvent.getAction();
            x = motionEvent.getX();
            y = motionEvent.getY() - this.e.getY();
        } else {
            if (motionEvent.getX() < this.e.getX()) {
                downTime = motionEvent.getDownTime();
                eventTime = motionEvent.getEventTime();
                action = motionEvent.getAction();
                x = this.e.getX() + motionEvent.getX();
            } else {
                if (motionEvent.getX() <= this.e.getX() + this.e.getWidth()) {
                    return super.dispatchTouchEvent(motionEvent);
                }
                downTime = motionEvent.getDownTime();
                eventTime = motionEvent.getEventTime();
                action = motionEvent.getAction();
                x = motionEvent.getX() - this.e.getX();
            }
            y = motionEvent.getY();
        }
        return super.dispatchTouchEvent(MotionEvent.obtain(downTime, eventTime, action, x, y, motionEvent.getMetaState()));
    }

    @Override // com.opos.mobad.template.cmn.cardslideview.g
    public void transformPage(View view, float f, int i) {
        transformSelf(view, f, i);
        int iA = this.e.a(view);
        if (this.e.e() == view) {
            switchToPoint(iA);
        }
    }
}
