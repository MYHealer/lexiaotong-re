package com.ubixnow.ooooo;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd;
import com.ubixnow.core.common.ui.UMNFrameLayout;
import com.ubixnow.core.common.ui.UMNRelativeLayout;
import com.ubixnow.core.utils.img.CustomImageView;
import com.ubixnow.utils.BaseUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class o000OO {
    public static final String OooO00o = "秒领奖励";
    public static final String OooO0O0 = "秒或点击广告领奖励";
    public CustomImageView OooO;
    public final UMNRelativeLayout OooO0OO;
    public ViewGroup OooO0Oo;
    public ViewGroup OooO0o0;
    public View OooO0oO;
    public TextView OooO0oo;
    public UMNFrameLayout OooOO0;
    public float OooOO0O;
    public float OooOO0o;
    public float OooOOO;
    public float OooOOO0;
    public ViewGroup OooOOOO;
    public float OooOOOo;
    public final String OooOOo0;
    public final Activity OooOOoo;
    public final View OooOo;
    public final UMNCustomNativeAd OooOo0;
    public final String OooOo00;
    public final ViewGroup OooOo0O;
    public final oo000o<o0000Ooo> OooOo0o;
    public final Bitmap OooOoO;
    public final Bitmap OooOoO0;
    public final o00O000 OooOoOO;
    public final int OooOoo;
    public final int OooOoo0;
    public final int OooOooO;
    public final int OooOooo;
    public final List<View> OooO0o = new ArrayList();
    public final String OooOOo = "已领取奖励";

    public static class OooO00o {
        public UMNCustomNativeAd OooO00o;
        public o0000Ooo OooO0O0;
        public oo000o<o0000Ooo> OooO0OO;
        public Bitmap OooO0Oo;
        public o00O000 OooO0o;
        public Bitmap OooO0o0;
        public int OooO0oO;
        public int OooO0oo;
    }

    public o000OO(Activity activity, OooO00o oooO00o) {
        int videoHeight;
        this.OooOOoo = activity;
        if (activity != null) {
            this.OooO0OO = new UMNRelativeLayout(activity);
        } else {
            this.OooO0OO = new UMNRelativeLayout(BaseUtils.getContext());
        }
        UMNCustomNativeAd uMNCustomNativeAd = oooO00o.OooO00o;
        if (uMNCustomNativeAd != null) {
            this.OooOo0O = uMNCustomNativeAd.getCustomAdContainer();
            this.OooOo = oooO00o.OooO00o.getAdMediaView(new Object[0]);
            this.OooOooO = oooO00o.OooO00o.getVideoWidth();
            videoHeight = oooO00o.OooO00o.getVideoHeight();
        } else {
            this.OooOo0O = null;
            this.OooOo = null;
            videoHeight = -1;
            this.OooOooO = -1;
        }
        this.OooOooo = videoHeight;
        o0000Ooo o0000ooo = oooO00o.OooO0O0;
        this.OooOo00 = o0000ooo != null ? o0000ooo.getLogoText() : "";
        this.OooOo0 = oooO00o.OooO00o;
        oo000o<o0000Ooo> oo000oVar = oooO00o.OooO0OO;
        this.OooOo0o = oo000oVar;
        this.OooOoO0 = oooO00o.OooO0Oo;
        this.OooOoO = oooO00o.OooO0o0;
        this.OooOoOO = oo000oVar.getBaseAdConfig();
        this.OooOoo0 = oooO00o.OooO0oO;
        this.OooOoo = oooO00o.OooO0oo;
        this.OooOOo0 = OooO0oo();
        float f = Resources.getSystem().getDisplayMetrics().density;
        this.OooOOOo = f;
        this.OooOOOo = f <= 0.0f ? 3.0f : f;
        OooO0O0();
        OooOOO0();
    }

    private void OooO00o(ViewGroup viewGroup) {
        Bitmap bitmap = this.OooOoO0;
        if (bitmap == null || bitmap.isRecycled()) {
            this.OooOO0.setBackgroundColor(-16777216);
            return;
        }
        this.OooOO0.setBackground(new BitmapDrawable(viewGroup.getResources(), ooOOO00O.OooO00o(this.OooOoO0)));
        if (this.OooOo == null) {
            this.OooO.setImageBitmap(this.OooOoO0);
        }
    }

    private void OooO00o(FrameLayout.LayoutParams layoutParams, float f) {
        float f2 = layoutParams.width;
        float f3 = layoutParams.height * f;
        if (f2 > f3) {
            layoutParams.width = (int) f3;
        } else {
            layoutParams.height = (int) (f2 / f);
        }
    }

    private String OooO0oO() {
        int i = this.OooOoOO.OooOOO0.OooOOo;
        return (i == 21 || i == 22 || i == 24) ? OooO0O0 : OooO00o;
    }

    private String OooO0oo() {
        try {
            o00O000 o00o000 = this.OooOoOO;
            if (o0O0OOOo.OooO00o(o00o000.OooO00o, o00o000.OooOOO0)) {
                ooooO000.OooO0O0(ooooO000.OooO0OO, ooooO000.OooO0OO("j1"));
                return OooO0oO();
            }
            ooooO000.OooO0O0(ooooO000.OooO0OO, ooooO000.OooO0OO("j2"));
            return OooO00o;
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
            return OooO00o;
        }
    }

    private void OooOO0O() {
        float fOooO0Oo;
        int i;
        if (this.OooOo != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.OooOO0.getLayoutParams().width, this.OooOO0.getLayoutParams().height);
            layoutParams.gravity = 17;
            int i2 = this.OooOooO;
            if (i2 < 1 || (i = this.OooOooo) < 1) {
                int i3 = this.OooOoOO.OooO00o.OooO0OO;
                if (i3 == 17 || i3 == 1) {
                    fOooO0Oo = OooO0Oo();
                }
                this.OooOO0.addView(this.OooOo, layoutParams);
            }
            fOooO0Oo = (i2 * 1.0f) / i;
            OooO00o(layoutParams, fOooO0Oo);
            this.OooOO0.addView(this.OooOo, layoutParams);
        }
    }

    private void OooOO0o() {
        OooOO0O();
        OooO00o(this.OooOOOO);
    }

    private void OooOOO0() {
        UMNRelativeLayout uMNRelativeLayout;
        ViewGroup viewGroup;
        Context context = this.OooOOoo;
        if (context == null) {
            context = BaseUtils.getContext();
        }
        ViewGroup viewGroup2 = (ViewGroup) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(OooO0o0(), (ViewGroup) null);
        this.OooOOOO = viewGroup2;
        viewGroup2.setTag("Root ViewGroup");
        ViewGroup viewGroup3 = this.OooOo0O;
        if (viewGroup3 != null) {
            if (viewGroup3.getParent() != null) {
                ((ViewGroup) this.OooOo0O.getParent()).removeAllViews();
            }
            this.OooOo0O.addView(this.OooOOOO);
            uMNRelativeLayout = this.OooO0OO;
            viewGroup = this.OooOo0O;
        } else {
            uMNRelativeLayout = this.OooO0OO;
            viewGroup = this.OooOOOO;
        }
        uMNRelativeLayout.addView(viewGroup);
        OooO();
        ViewGroup.LayoutParams layoutParams = this.OooOO0.getLayoutParams();
        layoutParams.height = this.OooOoo;
        layoutParams.width = this.OooOoo0;
        this.OooOO0.setFlag(true);
        this.OooO.getLayoutParams().width = this.OooOoo0;
        this.OooO.getLayoutParams().height = this.OooOoo;
        ViewGroup.LayoutParams layoutParams2 = this.OooO0Oo.getLayoutParams();
        layoutParams2.height = this.OooOoo;
        layoutParams2.width = this.OooOoo0;
        OooOO0o();
        this.OooO0o0 = this.OooO0OO;
        OooO00o();
        OooOOO();
    }

    public abstract void OooO();

    public int OooO00o(int i) {
        double d;
        float f;
        float f2;
        if (this.OooOoo > this.OooOoo0) {
            d = i;
            f = i;
            f2 = this.OooOOO0;
        } else {
            d = i;
            f = i;
            f2 = this.OooOOO;
        }
        return (int) Math.min(d, ((double) (f * f2)) + 0.5d);
    }

    public GradientDrawable OooO00o(Context context, int i, float f, float f2, int i2) {
        return OooO00o(context, i, new float[]{f, f, f, f, f, f, f, f}, f2, i2);
    }

    public GradientDrawable OooO00o(Context context, int i, float[] fArr, float f, int i2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (i != 0) {
            gradientDrawable.setColor(i);
        }
        if (fArr != null && fArr.length == 8) {
            float[] fArr2 = new float[8];
            for (int i3 = 0; i3 < 8; i3++) {
                fArr2[i3] = TypedValue.applyDimension(1, fArr[i3], context.getResources().getDisplayMetrics());
            }
            gradientDrawable.setCornerRadii(fArr2);
        }
        if (f > 0.0f) {
            gradientDrawable.setStroke((int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics()), i2);
        }
        return gradientDrawable;
    }

    public void OooO00o() {
        this.OooO0o.add(OooO0o());
    }

    public abstract void OooO00o(long j);

    public int OooO0O0(int i) {
        double d;
        float f;
        float f2 = i;
        if (this.OooOoo > this.OooOoo0) {
            d = this.OooOOOo * f2;
            f = this.OooOO0O;
        } else {
            d = this.OooOOOo * f2;
            f = this.OooOO0o;
        }
        return (int) Math.min(d, ((double) (f2 * f)) + 0.5d);
    }

    public abstract void OooO0O0();

    public int OooO0OO(int i) {
        return (int) (((double) (i * (this.OooOoo > this.OooOoo0 ? this.OooOOO0 : this.OooOOO))) + 0.5d);
    }

    public void OooO0OO() {
        try {
            CustomImageView customImageView = this.OooO;
            if (customImageView != null) {
                customImageView.setImageBitmap(null);
            }
            UMNRelativeLayout uMNRelativeLayout = this.OooO0OO;
            if (uMNRelativeLayout == null || !(uMNRelativeLayout.getParent() instanceof ViewGroup)) {
                return;
            }
            ((ViewGroup) this.OooO0OO.getParent()).removeView(this.OooO0OO);
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    public abstract float OooO0Oo();

    public int OooO0Oo(int i) {
        return (int) (((double) (i * (this.OooOoo > this.OooOoo0 ? this.OooOO0O : this.OooOO0o))) + 0.5d);
    }

    public abstract View OooO0o();

    public abstract int OooO0o0();

    public abstract void OooOO0();

    public abstract void OooOOO();
}
