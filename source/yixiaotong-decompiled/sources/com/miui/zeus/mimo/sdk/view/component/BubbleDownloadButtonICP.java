package com.miui.zeus.mimo.sdk.view.component;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.common.base.Ascii;
import com.miui.zeus.mimo.sdk.a0;
import com.miui.zeus.mimo.sdk.a8;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.y8;
import com.miui.zeus.mimo.sdk.z7;
import ijiami_1011.s.s.s;
import java.util.Locale;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class BubbleDownloadButtonICP extends z7 {
    public BubbleDownloadButtonView k;
    public ImageView l;
    public TextView m;
    public TextView n;
    public ImageView o;
    public TextView p;
    public int q;
    public AnimatorSet r;
    public AnimatorSet s;
    public Region t;
    public RectF u;

    public class a extends CustomTarget<Drawable> {
        public a() {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(Drawable drawable) {
            BubbleDownloadButtonView bubbleDownloadButtonView = BubbleDownloadButtonICP.this.k;
            if (bubbleDownloadButtonView != null) {
                bubbleDownloadButtonView.setBubbleDrawable(null);
            }
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onResourceReady(Object obj, Transition transition) {
            Drawable drawable = (Drawable) obj;
            BubbleDownloadButtonView bubbleDownloadButtonView = BubbleDownloadButtonICP.this.k;
            if (bubbleDownloadButtonView == null || drawable == null) {
                return;
            }
            bubbleDownloadButtonView.setBubbleDrawable(drawable);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BubbleDownloadButtonICP.this.setEnabled(true);
            BubbleDownloadButtonICP.this.l.setVisibility(4);
            BubbleDownloadButtonICP.this.m.setVisibility(8);
            BubbleDownloadButtonICP.this.n.setVisibility(8);
            BubbleDownloadButtonICP.this.o.setVisibility(0);
            BubbleDownloadButtonICP.this.p.setVisibility(0);
            BubbleDownloadButtonICP.this.k.setProgress(0);
            BubbleDownloadButtonICP.this.p.setText(s.d(new byte[]{2, Ascii.GS}, "2878f2"));
            BubbleDownloadButtonICP.this.i();
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f5693a;

        public c(int i) {
            this.f5693a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            BubbleDownloadButtonICP.this.setEnabled(true);
            BubbleDownloadButtonICP.this.l.setVisibility(4);
            BubbleDownloadButtonICP.this.m.setVisibility(8);
            BubbleDownloadButtonICP.this.n.setVisibility(8);
            BubbleDownloadButtonICP.this.o.setVisibility(0);
            BubbleDownloadButtonICP.this.p.setVisibility(0);
            BubbleDownloadButtonICP.this.k.setProgress(this.f5693a);
            BubbleDownloadButtonICP.this.p.setText(String.format(Locale.US, s.d(new byte[]{Ascii.NAK, 6, Ascii.NAK, 68}, "0b0a13"), Integer.valueOf(this.f5693a)));
            BubbleDownloadButtonView bubbleDownloadButtonView = BubbleDownloadButtonICP.this.k;
            bubbleDownloadButtonView.s = false;
            ValueAnimator valueAnimator = bubbleDownloadButtonView.m;
            if (valueAnimator != null && valueAnimator.isPaused()) {
                bubbleDownloadButtonView.m.resume();
            }
            ValueAnimator valueAnimator2 = bubbleDownloadButtonView.n;
            if (valueAnimator2 != null && valueAnimator2.isPaused()) {
                bubbleDownloadButtonView.n.resume();
            }
            int i = bubbleDownloadButtonView.j;
            if (i <= 0 || i >= 100) {
                return;
            }
            ValueAnimator valueAnimator3 = bubbleDownloadButtonView.m;
            if (valueAnimator3 == null || !valueAnimator3.isRunning()) {
                bubbleDownloadButtonView.b();
            }
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BubbleDownloadButtonICP.this.setEnabled(true);
            BubbleDownloadButtonICP.this.l.setVisibility(0);
            BubbleDownloadButtonICP.this.o.setVisibility(8);
            BubbleDownloadButtonICP.this.p.setVisibility(8);
            BubbleDownloadButtonICP.this.m.setVisibility(0);
            BubbleDownloadButtonICP.this.n.setVisibility(0);
            BubbleDownloadButtonICP.this.m.setText(s.d(new byte[]{-34, -114, -108, -33, -118, -101, -123, -36, -19, -118, -116, -40}, "953816"));
            BubbleDownloadButtonView bubbleDownloadButtonView = BubbleDownloadButtonICP.this.k;
            bubbleDownloadButtonView.s = true;
            ValueAnimator valueAnimator = bubbleDownloadButtonView.m;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                bubbleDownloadButtonView.m.pause();
            }
            ValueAnimator valueAnimator2 = bubbleDownloadButtonView.n;
            if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
                return;
            }
            bubbleDownloadButtonView.n.pause();
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BubbleDownloadButtonICP.this.setEnabled(false);
            BubbleDownloadButtonICP.this.l.setVisibility(4);
            BubbleDownloadButtonICP.this.o.setVisibility(0);
            BubbleDownloadButtonICP.this.p.setVisibility(8);
            BubbleDownloadButtonICP.this.m.setVisibility(0);
            BubbleDownloadButtonICP.this.n.setVisibility(8);
            BubbleDownloadButtonICP.this.m.setText(s.d(new byte[]{-44, -55, -108, -47, -88, -51, -124, -54, -17, -118, -110, -32}, "2d744e"));
            BubbleDownloadButtonICP.this.i();
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f5696a;

        public f(boolean z) {
            this.f5696a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            BubbleDownloadButtonICP bubbleDownloadButtonICP = BubbleDownloadButtonICP.this;
            MimoAdInfo mimoAdInfo = bubbleDownloadButtonICP.f5761a;
            if (mimoAdInfo != null) {
                mimoAdInfo.S = false;
                bubbleDownloadButtonICP.setEnabled(true);
                BubbleDownloadButtonICP bubbleDownloadButtonICP2 = BubbleDownloadButtonICP.this;
                bubbleDownloadButtonICP2.setText(bubbleDownloadButtonICP2.f5761a.g());
                BubbleDownloadButtonICP.this.l.setVisibility(0);
                BubbleDownloadButtonICP.this.l.setImageResource(a0.C4);
                BubbleDownloadButtonICP.this.m.setVisibility(0);
                BubbleDownloadButtonICP.this.n.setVisibility(8);
                BubbleDownloadButtonICP.this.o.setVisibility(8);
                BubbleDownloadButtonICP.this.p.setVisibility(8);
                if (this.f5696a) {
                    BubbleDownloadButtonView bubbleDownloadButtonView = BubbleDownloadButtonICP.this.k;
                    bubbleDownloadButtonView.c();
                    ValueAnimator valueAnimator = bubbleDownloadButtonView.n;
                    if (valueAnimator != null && valueAnimator.isRunning()) {
                        bubbleDownloadButtonView.n.cancel();
                    }
                    bubbleDownloadButtonView.j = 0;
                    bubbleDownloadButtonView.k = 0.0f;
                    bubbleDownloadButtonView.l = 0.0f;
                    bubbleDownloadButtonView.i = 0.0f;
                    bubbleDownloadButtonView.s = false;
                    Path path = bubbleDownloadButtonView.f;
                    if (path != null) {
                        path.reset();
                    }
                    Path path2 = bubbleDownloadButtonView.r;
                    if (path2 != null) {
                        path2.reset();
                    }
                    bubbleDownloadButtonView.invalidate();
                } else {
                    BubbleDownloadButtonICP.this.k.setProgress(100);
                }
                BubbleDownloadButtonICP.this.h();
            }
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AnimatorSet animatorSet;
            BubbleDownloadButtonICP bubbleDownloadButtonICP = BubbleDownloadButtonICP.this;
            ImageView imageView = bubbleDownloadButtonICP.l;
            if (imageView == null || bubbleDownloadButtonICP.k == null) {
                return;
            }
            imageView.setPivotX(imageView.getWidth() / 2.0f);
            ImageView imageView2 = BubbleDownloadButtonICP.this.l;
            imageView2.setPivotY(imageView2.getHeight() / 2.0f);
            BubbleDownloadButtonView bubbleDownloadButtonView = BubbleDownloadButtonICP.this.k;
            bubbleDownloadButtonView.setPivotX(bubbleDownloadButtonView.getWidth() / 2.0f);
            BubbleDownloadButtonView bubbleDownloadButtonView2 = BubbleDownloadButtonICP.this.k;
            bubbleDownloadButtonView2.setPivotY(bubbleDownloadButtonView2.getHeight());
            BubbleDownloadButtonICP bubbleDownloadButtonICP2 = BubbleDownloadButtonICP.this;
            AnimatorSet animatorSet2 = null;
            if (bubbleDownloadButtonICP2.l == null) {
                animatorSet = null;
            } else {
                animatorSet = new AnimatorSet();
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(bubbleDownloadButtonICP2.l, s.d(new byte[]{66, 85, 86, 94, 80, 107}, "167253"), 1.0f, 1.2f, 0.9f, 1.2f, 0.9f, 1.0f);
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(bubbleDownloadButtonICP2.l, s.d(new byte[]{74, 86, 7, 14, 6, 56}, "95fbca"), 1.0f, 1.2f, 0.9f, 1.2f, 0.9f, 1.0f);
                objectAnimatorOfFloat.setDuration(1200L);
                objectAnimatorOfFloat2.setDuration(1200L);
                objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
                objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
                objectAnimatorOfFloat.setRepeatCount(-1);
                objectAnimatorOfFloat.setRepeatMode(1);
                objectAnimatorOfFloat2.setRepeatCount(-1);
                objectAnimatorOfFloat2.setRepeatMode(1);
                animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
            }
            bubbleDownloadButtonICP2.r = animatorSet;
            BubbleDownloadButtonICP bubbleDownloadButtonICP3 = BubbleDownloadButtonICP.this;
            if (bubbleDownloadButtonICP3.k != null) {
                animatorSet2 = new AnimatorSet();
                ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(bubbleDownloadButtonICP3.k, s.d(new byte[]{65, 86, 85, 85, 86, Base64.padSymbol}, "25493e"), 1.0f, 1.0f, 0.9f, 0.95f, 0.9f, 1.0f);
                ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(bubbleDownloadButtonICP3.k, s.d(new byte[]{Ascii.DC2, 81, 89, 88, 6, 56}, "a284ca"), 1.0f, 1.0f, 0.9f, 0.95f, 0.9f, 1.0f);
                objectAnimatorOfFloat3.setDuration(1200L);
                objectAnimatorOfFloat4.setDuration(1200L);
                objectAnimatorOfFloat3.setInterpolator(new LinearInterpolator());
                objectAnimatorOfFloat4.setInterpolator(new LinearInterpolator());
                objectAnimatorOfFloat3.setRepeatCount(-1);
                objectAnimatorOfFloat3.setRepeatMode(1);
                objectAnimatorOfFloat4.setRepeatCount(-1);
                objectAnimatorOfFloat4.setRepeatMode(1);
                animatorSet2.playTogether(objectAnimatorOfFloat3, objectAnimatorOfFloat4);
            }
            bubbleDownloadButtonICP3.s = animatorSet2;
            AnimatorSet animatorSet3 = BubbleDownloadButtonICP.this.r;
            if (animatorSet3 != null) {
                animatorSet3.start();
            }
            AnimatorSet animatorSet4 = BubbleDownloadButtonICP.this.s;
            if (animatorSet4 != null) {
                animatorSet4.setStartDelay(32L);
                BubbleDownloadButtonICP.this.s.start();
            }
        }
    }

    public BubbleDownloadButtonICP(Context context) {
        this(context, null);
    }

    public BubbleDownloadButtonICP(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BubbleDownloadButtonICP(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.q = -1;
        j();
    }

    @Override // com.miui.zeus.mimo.sdk.z7
    public void a(int i) {
        a(true);
    }

    @Override // com.miui.zeus.mimo.sdk.z7
    public boolean a() {
        String string = this.m.getText().toString();
        if (com.miui.zeus.mimo.sdk.b.g(string) || this.f5761a == null) {
            return false;
        }
        if (string.startsWith(s.d(new byte[]{-45, -69, -33, -48, -28, -114, -121, -41, -57, -124, -126, -60, 62}, "49f5c5"))) {
            string = string.substring(5);
        }
        return string.equals(this.f5761a.g()) || string.equals(this.f5761a.l()) || string.equals(this.f5761a.i()) || string.equals(this.f5761a.m()) || string.equals(this.f5761a.q()) || string.equals(s.d(new byte[]{-46, -98, -107, -128, -2, -51, -124, -54, -17, -118, -110, -32}, "436ebe")) || string.equals(s.d(new byte[]{-33, -34, -98, -42, -126, -98, -123, -36, -19, -118, -116, -40}, "8e9193"));
    }

    @Override // com.miui.zeus.mimo.sdk.z7
    public void b() {
        super.b();
        i();
        this.l = null;
        this.k = null;
        this.r = null;
        this.s = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
    }

    @Override // com.miui.zeus.mimo.sdk.z7
    public void b(int i) {
        a(true);
    }

    @Override // com.miui.zeus.mimo.sdk.z7
    public void c() {
        this.l.setVisibility(0);
        this.m.setVisibility(0);
        this.n.setVisibility(8);
        this.o.setVisibility(8);
        this.p.setVisibility(8);
        if (com.miui.zeus.mimo.sdk.b.h(this.f5761a.F1)) {
            Glide.with(getContext()).load(this.f5761a.F1).into(new a());
        }
        if (this.f5761a != null) {
            setText(getBtnInitText());
            this.m.setTextColor(this.q);
            setEnabled(true);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.z7
    public void d() {
        a(true);
    }

    @Override // com.miui.zeus.mimo.sdk.z7
    public void e() {
        y8.b.post(new e());
    }

    @Override // com.miui.zeus.mimo.sdk.z7
    public void f() {
        a(false);
    }

    @Override // com.miui.zeus.mimo.sdk.z7
    public void g() {
        y8.b.post(new d());
    }

    @Override // com.miui.zeus.mimo.sdk.z7
    public String getBtnText() {
        TextView textView = this.m;
        return textView != null ? textView.getText().toString() : "";
    }

    @Override // com.miui.zeus.mimo.sdk.z7
    public ClickAreaType getClickAreaType() {
        return this.h;
    }

    @Override // com.miui.zeus.mimo.sdk.z7
    public void h() {
        if (this.l == null || this.k == null) {
            return;
        }
        i();
        this.k.post(new g());
    }

    @Override // com.miui.zeus.mimo.sdk.z7
    public void i() {
        AnimatorSet animatorSet = this.r;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.r = null;
        }
        AnimatorSet animatorSet2 = this.s;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
            this.s = null;
        }
    }

    public void j() {
        LayoutInflater.from(getContext()).inflate(a0.g5, (ViewGroup) this, true);
        this.k = (BubbleDownloadButtonView) findViewById(a0.a0);
        this.l = (ImageView) findViewById(a0.w1);
        this.m = (TextView) findViewById(a0.B);
        this.n = (TextView) findViewById(a0.l2);
        this.o = (ImageView) findViewById(a0.f);
        this.p = (TextView) findViewById(a0.q2);
        TextView textView = this.m;
        if (textView != null) {
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            this.m.setTextColor(this.q);
        }
        TextView textView2 = this.n;
        if (textView2 != null) {
            textView2.setTextColor(-1711276033);
            this.n.setText(s.d(new byte[]{-44, -70, -95, -46, -44, -21, -123, -36, -19, -118, -116, -40}, "1574bc"));
            TextView textView3 = this.n;
            textView3.setPaintFlags(textView3.getPaintFlags() | 8);
        }
        TextView textView4 = this.n;
        if (textView4 != null) {
            textView4.setOnClickListener(new a8(this));
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || this.k == null) {
            return super.onTouchEvent(motionEvent);
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int[] iArr = new int[2];
        this.k.getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        getLocationInWindow(iArr2);
        float f2 = x - (iArr[0] - iArr2[0]);
        float f3 = y - (iArr[1] - iArr2[1]);
        this.t = new Region();
        RectF rectF = new RectF();
        this.u = rectF;
        this.k.g.computeBounds(rectF, true);
        Region region = this.t;
        Path path = this.k.g;
        RectF rectF2 = this.u;
        region.setPath(path, new Region((int) rectF2.left, (int) rectF2.top, (int) rectF2.right, (int) rectF2.bottom));
        if (this.t.contains((int) f2, (int) f3)) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setBtnStyle(int i) {
        BubbleDownloadButtonView bubbleDownloadButtonView = this.k;
        if (bubbleDownloadButtonView != null) {
            bubbleDownloadButtonView.setDesignType(i);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.z7
    public void setText(CharSequence charSequence) {
        TextView textView = this.m;
        if (textView != null) {
            textView.setText(String.format(s.d(new byte[]{19, 74, 70, 70}, "69c5e2"), s.d(new byte[]{-33, -77, -35, -41, -28, -125, -121, -41, -57, -124, -126, -60, 50}, "81d2c8"), charSequence));
        }
    }

    @Override // com.miui.zeus.mimo.sdk.z7
    public void setTextColor(int i) {
        TextView textView = this.m;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public final void a(boolean z) {
        if (this.f5761a != null) {
            com.miui.zeus.mimo.sdk.s sVarA = com.miui.zeus.mimo.sdk.s.a();
            sVarA.b.remove(this.f5761a.C);
        }
        y8.b.post(new f(z));
    }

    @Override // com.miui.zeus.mimo.sdk.z7
    public void d(int i) {
        y8.b.post(new c(i));
    }

    @Override // com.miui.zeus.mimo.sdk.z7
    public void c(int i) {
        y8.b.post(new b());
    }
}
