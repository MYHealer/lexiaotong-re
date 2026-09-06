package com.ubixnow.ooooo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ubixnow.core.R;
import com.ubixnow.utils.BaseUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o000O000 {
    public TextView OooO;
    public final float OooO00o;
    public final float OooO0O0;
    public final float OooO0OO;
    public final float OooO0Oo;
    public TextView OooO0o;
    public final int OooO0o0;
    public Context OooO0oO;
    public FrameLayout OooO0oo;
    public int OooOO0;
    public int OooOO0O;
    public float OooOO0o;

    public class OooO00o implements View.OnTouchListener {
        public OooO00o() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public o000O000() {
        float f;
        Context context = BaseUtils.getContext();
        this.OooO0oO = context;
        this.OooOO0 = oOO00000.OooO0Oo(context);
        this.OooOO0O = oOO00000.OooO0OO(this.OooO0oO);
        this.OooOO0o = Resources.getSystem().getDisplayMetrics().density;
        int i = this.OooO0oO.getResources().getConfiguration().orientation;
        this.OooO0o0 = i;
        if (i == 1) {
            this.OooO00o = this.OooOO0 / 360.0f;
            f = this.OooOO0O / 800.0f;
        } else {
            this.OooO00o = this.OooOO0 / 800.0f;
            f = this.OooOO0O / 360.0f;
        }
        this.OooO0O0 = f;
        float f2 = this.OooO00o;
        float f3 = this.OooOO0o;
        this.OooO0OO = f2 / f3;
        this.OooO0Oo = this.OooO0O0 / f3;
        OooO00o(OooO0O0(269), OooO0O0(209));
    }

    private GradientDrawable OooO00o(Context context, int i, float f, float f2, int i2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (i != 0) {
            gradientDrawable.setColor(i);
        }
        gradientDrawable.setCornerRadius(TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics()));
        if (f2 > 0.0f) {
            gradientDrawable.setStroke((int) TypedValue.applyDimension(1, f2, context.getResources().getDisplayMetrics()), i2);
        }
        return gradientDrawable;
    }

    private void OooO00o(int i, int i2) {
        ViewGroup viewGroup = (ViewGroup) ((LayoutInflater) this.OooO0oO.getSystemService("layout_inflater")).inflate(R.layout.umn_custom_reward_5s_pop, (ViewGroup) null);
        FrameLayout frameLayout = new FrameLayout(this.OooO0oO);
        this.OooO0oo = frameLayout;
        frameLayout.addView(viewGroup, new ViewGroup.LayoutParams(oOO00000.OooO0Oo(this.OooO0oO), oOO00000.OooO0OO(this.OooO0oO)));
        this.OooO0oo.setOnTouchListener(new OooO00o());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ((ImageView) viewGroup.findViewById(R.id.civ_icon)).getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        ((RelativeLayout.LayoutParams) ((LinearLayout) viewGroup.findViewById(R.id.ll_btn)).getLayoutParams()).bottomMargin = OooO0O0(32);
        TextView textView = (TextView) viewGroup.findViewById(R.id.btn_subtitle_text);
        this.OooO = textView;
        textView.setBackground(OooO00o(this.OooO0oO, -1, OooO00o(37), 0.0f, -1));
        this.OooO.getPaint().setFakeBoldText(true);
        this.OooO.setTextSize(2, OooO00o(16));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.OooO.getLayoutParams();
        layoutParams2.width = OooO0O0(182);
        layoutParams2.height = OooO0O0(33);
        TextView textView2 = (TextView) viewGroup.findViewById(R.id.btn_title_text);
        this.OooO0o = textView2;
        textView2.setTextSize(2, OooO00o(10));
        ((LinearLayout.LayoutParams) this.OooO0o.getLayoutParams()).topMargin = OooO0O0(6);
    }

    public int OooO00o(int i) {
        double d;
        float f;
        float f2;
        if (this.OooOO0O > this.OooOO0) {
            d = i;
            f = i;
            f2 = this.OooO0OO;
        } else {
            d = i;
            f = i;
            f2 = this.OooO0Oo;
        }
        return (int) Math.min(d, ((double) (f * f2)) + 0.5d);
    }

    public View OooO00o() {
        return this.OooO;
    }

    public void OooO00o(String str) {
        TextView textView = this.OooO0o;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public int OooO0O0(int i) {
        double d;
        float f;
        float f2 = i;
        if (this.OooOO0O > this.OooOO0) {
            d = this.OooOO0o * f2;
            f = this.OooO00o;
        } else {
            d = this.OooOO0o * f2;
            f = this.OooO0O0;
        }
        return (int) Math.min(d, ((double) (f2 * f)) + 0.5d);
    }

    public int OooO0OO(int i) {
        return (int) (((double) (i * (this.OooOO0O > this.OooOO0 ? this.OooO00o : this.OooO0O0))) + 0.5d);
    }
}
