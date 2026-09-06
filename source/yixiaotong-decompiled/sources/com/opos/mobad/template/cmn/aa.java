package com.opos.mobad.template.cmn;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class aa extends com.opos.mobad.template.cmn.baseview.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f7471a;
    private float b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f7472a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final float f;

        public a(int i, int i2, float f) {
            this(i, i2, i, f);
        }

        public a(int i, int i2, int i3, float f) {
            f = f <= 0.0f ? 6.315f : f;
            this.f = f;
            int i4 = i > 0 ? i : MediaPlayer.MEDIA_PLAYER_OPTION_BIT_RATE;
            this.b = i4;
            this.f7472a = (int) (i4 / f);
            if (i2 <= i4 && i2 > 0) {
                i = i2;
            }
            this.d = i;
            this.c = (int) (i / f);
            this.e = a(i3);
        }

        public int a(int i) {
            int i2 = this.d;
            if (i <= i2) {
                return i2;
            }
            int i3 = this.b;
            return i >= i3 ? i3 : i;
        }

        public int b(int i) {
            int i2 = this.c;
            if (i <= i2) {
                return i2;
            }
            int i3 = this.f7472a;
            return i >= i3 ? i3 : i;
        }

        public String toString() {
            return "maxH = " + this.f7472a + ",maxW = " + this.b + ",minH = " + this.c + ",minW = " + this.d;
        }
    }

    public aa(Context context, AttributeSet attributeSet, int i, a aVar) {
        super(context, attributeSet, i);
        this.b = 1.0f;
        this.f7471a = aVar;
    }

    public aa(Context context, AttributeSet attributeSet, a aVar) {
        this(context, attributeSet, 0, aVar);
    }

    public aa(Context context, a aVar) {
        this(context, null, aVar);
    }

    private void a(View view, float f) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams.width != -2 && layoutParams.width != -1) {
            layoutParams.width = (int) (layoutParams.width * f);
        }
        if (layoutParams.height != -2 && layoutParams.height != -1) {
            layoutParams.height = (int) (layoutParams.height * f);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams.bottomMargin != 0) {
                marginLayoutParams.bottomMargin = (int) (marginLayoutParams.bottomMargin * f);
            }
            if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = (int) (marginLayoutParams.topMargin * f);
            }
            if (marginLayoutParams.leftMargin != 0) {
                marginLayoutParams.leftMargin = (int) (marginLayoutParams.leftMargin * f);
            }
            if (marginLayoutParams.rightMargin != 0) {
                marginLayoutParams.rightMargin = (int) (marginLayoutParams.rightMargin * f);
            }
        }
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            textView.setTextSize(0, textView.getTextSize() * f);
            float lineSpacingExtra = textView.getLineSpacingExtra();
            if (0.0f != lineSpacingExtra) {
                lineSpacingExtra *= f;
            }
            textView.setLineSpacing(lineSpacingExtra, textView.getLineSpacingMultiplier());
            textView.setPadding((int) (textView.getPaddingLeft() * f), (int) (textView.getPaddingTop() * f), (int) (textView.getPaddingRight() * f), (int) (textView.getPaddingBottom() * f));
            if (textView.getMaxWidth() > 0) {
                textView.setMaxWidth((int) (textView.getMaxWidth() * f));
            }
        }
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        if (viewGroup != null) {
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(viewGroup.getChildAt(i), f);
            }
        }
    }

    private void a(ViewGroup viewGroup) {
        if (viewGroup != null) {
            float width = viewGroup.getWidth() / this.f7471a.e;
            float f = this.b;
            if (f == width) {
                return;
            }
            this.b = width;
            com.opos.cmn.an.f.a.b("ScaleViewGroup", "scale view = " + viewGroup + ",scale = " + width);
            float f2 = width / f;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(viewGroup.getChildAt(i), f2);
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        a(this);
    }

    /* JADX WARN: Code duplicated, block: B:4:0x003d  */
    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int iMakeMeasureSpec;
        int iMakeMeasureSpec2;
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i);
        int iB = this.f7471a.b(size);
        int iA = this.f7471a.a(size2);
        a aVar = this.f7471a;
        int iA2 = aVar.a(aVar.e);
        int i3 = (int) (iA2 / this.f7471a.f);
        int i4 = (int) (iA / this.f7471a.f);
        int i5 = (int) (iB * this.f7471a.f);
        if (mode2 == 1073741824) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iA, 1073741824);
            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        } else if (mode == 1073741824) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iB, 1073741824);
        } else if (mode2 == Integer.MIN_VALUE && mode == Integer.MIN_VALUE) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iA2, 1073741824);
            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iA, 1073741824);
            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        }
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec2);
    }
}
