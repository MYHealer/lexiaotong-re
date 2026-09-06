package com.ubixnow.ooooo;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.ubixnow.adtype.interstital.custom.UMNCustomInterstitalAdapter;
import com.ubixnow.adtype.nativead.api.UMNNativeTemplateAdView;
import com.ubixnow.utils.BaseUtils;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o0OoOo0 extends Dialog {
    private final o00O0O OooO00o;
    public List<View> OooO0O0;
    public View OooO0OO;
    public ViewGroup OooO0Oo;
    public oo00o<UMNCustomInterstitalAdapter> OooO0o;
    public o0O0O0Oo OooO0o0;
    public int OooO0oO;
    public int OooO0oo;

    public o0OoOo0(Activity activity, String str, ViewGroup viewGroup, oo000o<o000oOoO> oo000oVar, oo00o<UMNCustomInterstitalAdapter> oo00oVar, View view, UMNNativeTemplateAdView uMNNativeTemplateAdView, Bitmap bitmap, View view2, int i, int i2) {
        super(activity);
        setOwnerActivity(activity);
        this.OooO0o = oo00oVar;
        o00O0O o00o0o = new o00O0O(activity, str, viewGroup, oo000oVar, view, uMNNativeTemplateAdView, bitmap, view2, i, i2);
        this.OooO00o = o00o0o;
        this.OooO0O0 = o00o0o.OooOo0O;
        this.OooO0OO = o00o0o.OooO0oo;
        this.OooO0oO = i;
        this.OooO0oo = i2;
        OooO0O0();
        this.OooO0Oo = o00o0o.OooO;
        OooO0OO();
    }

    public static Drawable OooO00o(int i, int i2) {
        float f = i2;
        float[] fArr = {f, f, f, f, f, f, f, f};
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadii(fArr);
        return gradientDrawable;
    }

    private void OooO0O0() {
        o0O0O0Oo o0o0o0oo = new o0O0O0Oo(this.OooO0o.getBaseAdConfig(), this.OooO0o, this.OooO00o.OooO0oO, this.OooO0OO, this.OooO0oO, this.OooO0oo);
        this.OooO0o0 = o0o0o0oo;
        o0o0o0oo.OooO0OO();
        View viewOooO0O0 = this.OooO0o0.OooO0O0();
        if (viewOooO0O0 != null) {
            this.OooO0O0.add(viewOooO0O0);
        }
    }

    public void OooO00o() {
        o0O0O0Oo o0o0o0oo = this.OooO0o0;
        if (o0o0o0oo != null) {
            o0o0o0oo.OooO0o0();
        }
    }

    public final void OooO0OO() {
        try {
            Window window = getWindow();
            if (window != null) {
                window.getDecorView().setPadding(0, 0, 0, 0);
                window.setBackgroundDrawable(OooO00o(0, 14));
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = -2;
                attributes.height = -2;
                attributes.gravity = 17;
                attributes.y += (int) (((double) (-oOO00000.OooO0o0(BaseUtils.getContext()))) * 0.05d);
                window.setAttributes(attributes);
            }
            setCanceledOnTouchOutside(false);
            setCancelable(false);
            setContentView(this.OooO00o.OooO0oO, new FrameLayout.LayoutParams(-2, -2));
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            super.dismiss();
            this.OooO00o.OooO0OO();
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
            this.OooO00o.OooO0o0();
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }
}
