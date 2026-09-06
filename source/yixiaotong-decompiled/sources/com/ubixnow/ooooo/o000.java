package com.ubixnow.ooooo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.ubixnow.core.R;
import com.ubixnow.core.common.ui.UMNRelativeLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o000 {
    public float OooO;
    public final float OooO00o;
    public final float OooO0O0;
    public final float OooO0OO;
    public final float OooO0Oo;
    public TextView OooO0o;
    public final int OooO0o0;
    public OooO0OO OooO0oO;
    public final UMNRelativeLayout OooO0oo;
    public int OooOO0;
    public int OooOO0O;

    public class OooO00o implements View.OnTouchListener {
        public OooO00o() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public class OooO0O0 implements View.OnClickListener {
        public OooO0O0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            OooO0OO oooO0OO = o000.this.OooO0oO;
            if (oooO0OO != null) {
                oooO0OO.OooO00o();
            }
        }
    }

    public interface OooO0OO {
        void OooO00o();
    }

    public o000(Context context, Bitmap bitmap) {
        float f;
        UMNRelativeLayout uMNRelativeLayout = new UMNRelativeLayout(context);
        this.OooO0oo = uMNRelativeLayout;
        this.OooOO0 = oOO00000.OooO0Oo(uMNRelativeLayout.getContext());
        this.OooOO0O = oOO00000.OooO0OO(uMNRelativeLayout.getContext());
        this.OooO = Resources.getSystem().getDisplayMetrics().density;
        int i = uMNRelativeLayout.getContext().getResources().getConfiguration().orientation;
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
        float f3 = this.OooO;
        this.OooO0OO = f2 / f3;
        this.OooO0Oo = this.OooO0O0 / f3;
        OooO00o(bitmap);
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

    private void OooO00o(Bitmap bitmap) {
        int iOooO0OO;
        int i;
        ViewGroup viewGroup = (ViewGroup) ((LayoutInflater) this.OooO0oo.getContext().getSystemService("layout_inflater")).inflate(R.layout.umn_custom_reward_c_d_pop, this.OooO0oo);
        RelativeLayout relativeLayout = (RelativeLayout) viewGroup.findViewById(R.id.rl_content);
        relativeLayout.setOnTouchListener(new OooO00o());
        relativeLayout.setBackground(OooO00o(this.OooO0oo.getContext(), -8421505, OooO0O0(3), 1.0f, -7958372));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
        layoutParams.addRule(11);
        layoutParams.addRule(12);
        layoutParams.width = OooO0OO(MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS);
        layoutParams.height = OooO0OO(57);
        if (this.OooO0o0 == 1) {
            iOooO0OO = OooO0OO(157);
            i = 52;
        } else {
            iOooO0OO = OooO0OO(157);
            i = 25;
        }
        layoutParams.bottomMargin = iOooO0OO + OooO00o(i);
        layoutParams.rightMargin = this.OooO0o0 == 1 ? OooO00o(7) : OooO00o(37);
        ImageView imageView = (ImageView) viewGroup.findViewById(R.id.civ_icon);
        if (bitmap != null) {
            imageView.setImageDrawable(new oO000(this.OooO0oo.getContext(), bitmap, OooO0OO(9)));
        } else {
            imageView.setImageResource(R.drawable.umn_custom_rewad_default_icon);
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams2.width = OooO0OO(39);
        layoutParams2.height = OooO0OO(39);
        layoutParams2.leftMargin = OooO0OO(12);
        ((RelativeLayout.LayoutParams) ((LinearLayout) viewGroup.findViewById(R.id.ll_btn)).getLayoutParams()).leftMargin = OooO0OO(12);
        TextView textView = (TextView) viewGroup.findViewById(R.id.btn_subtitle_text);
        this.OooO0o = textView;
        textView.setTextSize(2, OooO0O0(12));
        TextView textView2 = (TextView) viewGroup.findViewById(R.id.btn_title_text);
        textView2.setTextSize(2, OooO0O0(11));
        ((LinearLayout.LayoutParams) textView2.getLayoutParams()).topMargin = OooO0OO(7);
        TextView textView3 = (TextView) viewGroup.findViewById(R.id.btn_title_text_2);
        textView3.getPaint().setFakeBoldText(true);
        textView3.setTextSize(2, OooO0O0(12));
        textView3.setBackground(OooO00o(this.OooO0oo.getContext(), 0, OooO0O0(17), 1.0f, -1));
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) textView3.getLayoutParams();
        layoutParams3.width = OooO0OO(59);
        layoutParams3.height = OooO0OO(23);
        layoutParams3.topMargin = OooO0OO(6);
        layoutParams3.rightMargin = OooO0OO(14);
        textView3.setOnClickListener(new OooO0O0());
    }

    public int OooO00o(int i) {
        double d;
        float f;
        float f2 = i;
        if (this.OooOO0O > this.OooOO0) {
            d = this.OooO * f2;
            f = this.OooO00o;
        } else {
            d = this.OooO * f2;
            f = this.OooO0O0;
        }
        return (int) Math.min(d, ((double) (f2 * f)) + 0.5d);
    }

    public void OooO00o(String str) {
        TextView textView = this.OooO0o;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public int OooO0O0(int i) {
        return (int) (((double) (i * (this.OooOO0O > this.OooOO0 ? this.OooO0OO : this.OooO0Oo))) + 0.5d);
    }

    public int OooO0OO(int i) {
        return (int) (((double) (i * (this.OooOO0O > this.OooOO0 ? this.OooO00o : this.OooO0O0))) + 0.5d);
    }
}
