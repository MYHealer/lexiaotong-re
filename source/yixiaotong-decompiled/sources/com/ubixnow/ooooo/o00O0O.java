package com.ubixnow.ooooo;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ubixnow.adtype.nativead.api.UMNNativeShakeView;
import com.ubixnow.adtype.nativead.api.UMNNativeTemplateAdView;
import com.ubixnow.core.R;
import com.ubixnow.core.common.ui.UMNFrameLayout;
import com.ubixnow.core.common.ui.UMNRelativeLayout;
import com.ubixnow.core.utils.img.CustomImageView;
import com.ubixnow.utils.BaseUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o00O0O {
    public ViewGroup OooO;
    private CustomImageView OooO00o;
    private final View OooO0O0;
    private ViewGroup OooO0OO;
    private UMNFrameLayout OooO0Oo;
    private ViewGroup OooO0o;
    private final Bitmap OooO0o0;
    public final UMNRelativeLayout OooO0oO;
    public View OooO0oo;
    public String OooOO0;
    public ViewGroup OooOO0O;
    private final oo000o<o000oOoO> OooOO0o;
    public UMNNativeTemplateAdView OooOOO;
    public View OooOOO0;
    public TextView OooOOOO;
    public TextView OooOOOo;
    public int OooOOo;
    public o00O000 OooOOo0;
    public int OooOOoo;
    public float OooOo0;
    public float OooOo00;
    public final List<View> OooOo0O = new ArrayList();

    public o00O0O(Activity activity, String str, ViewGroup viewGroup, oo000o<o000oOoO> oo000oVar, View view, UMNNativeTemplateAdView uMNNativeTemplateAdView, Bitmap bitmap, View view2, int i, int i2) {
        this.OooO0oO = new UMNRelativeLayout(activity);
        this.OooOO0 = str;
        this.OooOO0O = viewGroup;
        this.OooOO0o = oo000oVar;
        this.OooOOO0 = view;
        this.OooOOO = uMNNativeTemplateAdView;
        this.OooO0O0 = view2;
        this.OooO0o0 = bitmap;
        this.OooOOo0 = oo000oVar.getBaseAdConfig();
        this.OooOOo = i;
        this.OooOOoo = i2;
        OooO0O0();
        OooO0Oo();
    }

    private void OooO00o() {
        this.OooOo0O.add(this.OooO0o);
    }

    private void OooO00o(ViewGroup viewGroup) {
        Bitmap bitmap = this.OooO0o0;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.OooO0Oo.setBackground(new BitmapDrawable(viewGroup.getResources(), ooOOO00O.OooO00o(this.OooO0o0)));
        if (this.OooO0O0 == null) {
            if (this.OooO0o0.getHeight() > 0 && this.OooO0o0.getWidth() > 0) {
                this.OooO00o.getLayoutParams().height = (int) (this.OooOOo / (this.OooO0o0.getWidth() / this.OooO0o0.getHeight()));
            }
            this.OooO00o.setImageBitmap(this.OooO0o0);
        }
    }

    private void OooO0O0() {
        this.OooOo00 = this.OooOOo / 360.0f;
        float f = Resources.getSystem().getDisplayMetrics().density;
        if (f <= 0.0f) {
            f = 3.0f;
        }
        this.OooOo0 = this.OooOo00 / f;
    }

    private void OooO0O0(ViewGroup viewGroup) {
        TextView textView;
        String str;
        this.OooOOO.renderTemplateView(viewGroup);
        if (this.OooOOO.isCanAddShakeView(this.OooOO0o.getBaseAdConfig(), this.OooOOO0)) {
            if (!(this.OooOOO0 instanceof UMNNativeShakeView)) {
                this.OooO0o.setVisibility(4);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            int i = (int) (this.OooOo00 * 88.0f);
            layoutParams.width = i;
            layoutParams.height = i;
            layoutParams.addRule(2, this.OooO0o.getId());
            layoutParams.addRule(14);
            layoutParams.bottomMargin = (int) (this.OooOo00 * 52.0f);
            this.OooOOO.showShakeView(this.OooO0OO, this.OooOO0o.getBaseAdConfig(), this.OooOOO0, layoutParams, layoutParams.height);
            textView = this.OooOOOO;
            str = "摇动或点击";
        } else {
            textView = this.OooOOOO;
            str = "点击此处";
        }
        textView.setText(str);
    }

    private void OooO0Oo() {
        UMNRelativeLayout uMNRelativeLayout;
        View view;
        ViewGroup viewGroup = (ViewGroup) ((LayoutInflater) BaseUtils.getContext().getSystemService("layout_inflater")).inflate(R.layout.umn_custom_interstitial, (ViewGroup) null);
        this.OooO0OO = viewGroup;
        viewGroup.setTag("Root ViewGroup");
        this.OooO00o = (CustomImageView) this.OooO0OO.findViewById(R.id.civ_img);
        this.OooO0oo = this.OooO0OO.findViewById(R.id.iv_close);
        this.OooO0o = (ViewGroup) this.OooO0OO.findViewById(R.id.ubix_iv_click_btn);
        this.OooOOOO = (TextView) this.OooO0OO.findViewById(R.id.btn_subtitle_text);
        this.OooOOOo = (TextView) this.OooO0OO.findViewById(R.id.tv_logo);
        UMNFrameLayout uMNFrameLayout = (UMNFrameLayout) this.OooO0OO.findViewById(R.id.fl_media_container);
        this.OooO0Oo = uMNFrameLayout;
        uMNFrameLayout.setFlag(true);
        this.OooO = this.OooO0oO;
        OooO00o();
        OooO0o();
        if (this.OooOO0O != null) {
            if (this.OooOOO.getParent() != null) {
                ((ViewGroup) this.OooOOO.getParent()).removeView(this.OooOOO);
            }
            this.OooOO0O.addView(this.OooOOO);
            if (this.OooOO0O.getParent() != null) {
                ((ViewGroup) this.OooOO0O.getParent()).removeAllViews();
            }
            uMNRelativeLayout = this.OooO0oO;
            view = this.OooOO0O;
        } else {
            uMNRelativeLayout = this.OooO0oO;
            view = this.OooOOO;
        }
        uMNRelativeLayout.addView(view);
    }

    private void OooO0o() {
        boolean z = this.OooO0Oo.getResources().getConfiguration().orientation == 2;
        ViewGroup.LayoutParams layoutParams = this.OooO0Oo.getLayoutParams();
        layoutParams.height = this.OooOOoo;
        layoutParams.width = this.OooOOo;
        this.OooO00o.getLayoutParams().width = this.OooOOo;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.OooO0oo.getLayoutParams();
        int i = (int) (this.OooOo00 * 18.0f);
        layoutParams2.rightMargin = i;
        layoutParams2.topMargin = i;
        int iOooO00o = oOO00000.OooO00o(z ? 14.0f : 24.0f);
        layoutParams2.width = iOooO00o;
        layoutParams2.height = iOooO00o;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) ((ImageView) this.OooO0OO.findViewById(R.id.right_arrow)).getLayoutParams();
        float f = this.OooOo00;
        layoutParams3.rightMargin = (int) (f * 18.0f);
        int i2 = (int) (f * 20.0f);
        layoutParams3.width = i2;
        layoutParams3.height = i2;
        TextView textView = (TextView) this.OooO0OO.findViewById(R.id.btn_title_text);
        this.OooOOOO.setTextSize(2, this.OooOo0 * 18.0f);
        textView.setTextSize(2, this.OooOo0 * 12.0f);
        ((LinearLayout.LayoutParams) textView.getLayoutParams()).topMargin = (int) (this.OooOo00 * 6.0f);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.OooO0o.getLayoutParams();
        float f2 = this.OooOo00;
        int i3 = (int) (22.0f * f2);
        layoutParams4.leftMargin = i3;
        layoutParams4.rightMargin = i3;
        layoutParams4.width = layoutParams.width - (i3 * 2);
        layoutParams4.height = (int) (66.0f * f2);
        layoutParams4.bottomMargin = (int) (f2 * 25.0f);
        this.OooOOOo.setTextSize(2, this.OooOo0 * 11.0f);
        TextView textView2 = this.OooOOOo;
        float f3 = this.OooOo00;
        int i4 = (int) (5.0f * f3);
        int i5 = (int) (f3 * 3.0f);
        textView2.setPadding(i4, i5, i4, i5);
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.OooOOOo.getLayoutParams();
        float f4 = this.OooOo00;
        layoutParams5.leftMargin = (int) (18.0f * f4);
        layoutParams5.bottomMargin = (int) (f4 * 65.0f);
    }

    public void OooO0OO() {
        try {
            this.OooO00o.setImageBitmap(null);
            if (this.OooO0oO.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.OooO0oO.getParent()).removeView(this.OooO0oO);
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    public void OooO0o0() {
        this.OooOOOo.setText(this.OooOO0);
        if (this.OooO0O0 != null) {
            this.OooO00o.setVisibility(4);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.OooO0Oo.addView(this.OooO0O0, layoutParams);
        }
        OooO0O0(this.OooO0OO);
        OooO00o(this.OooO0OO);
    }
}
