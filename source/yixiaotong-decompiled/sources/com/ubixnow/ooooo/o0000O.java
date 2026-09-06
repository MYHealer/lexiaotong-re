package com.ubixnow.ooooo;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd;
import com.ubixnow.core.R;
import com.ubixnow.core.common.ui.UMNFrameLayout;
import com.ubixnow.core.utils.img.CustomImageView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o0000O extends o000OO {
    public TextView Oooo0;
    private ViewGroup Oooo000;
    public TextView Oooo00O;
    public TextView Oooo00o;
    public ImageView Oooo0O0;

    public o0000O(Activity activity, o000OO.OooO00o oooO00o) {
        super(activity, oooO00o);
    }

    @Override // com.ubixnow.ooooo.o000OO
    public void OooO() {
        String descriptionText;
        this.OooO0oO = this.OooOOOO.findViewById(R.id.iv_close);
        this.OooO = (CustomImageView) this.OooOOOO.findViewById(R.id.civ_img);
        this.OooOO0 = (UMNFrameLayout) this.OooOOOO.findViewById(R.id.fl_media_container);
        this.OooO0Oo = (ViewGroup) this.OooOOOO.findViewById(R.id.fl_other_container);
        this.OooO0oo = (TextView) this.OooOOOO.findViewById(R.id.c_d_text_3);
        this.Oooo000 = (ViewGroup) this.OooOOOO.findViewById(R.id.ubix_iv_click_btn);
        this.Oooo00O = (TextView) this.OooOOOO.findViewById(R.id.btn_subtitle_text);
        this.Oooo00o = (TextView) this.OooOOOO.findViewById(R.id.btn_title_text);
        TextView textView = (TextView) this.OooOOOO.findViewById(R.id.tv_logo);
        this.Oooo0 = textView;
        textView.setText(this.OooOo00);
        this.Oooo0O0 = (ImageView) this.OooOOOO.findViewById(R.id.civ_icon);
        UMNCustomNativeAd uMNCustomNativeAd = this.OooOo0;
        String descriptionText2 = "";
        if (uMNCustomNativeAd != null) {
            descriptionText = uMNCustomNativeAd.getDescriptionText();
            if (!TextUtils.isEmpty(this.OooOo0.getTitle())) {
                descriptionText2 = this.OooOo0.getTitle();
            } else if (!TextUtils.isEmpty(this.OooOo0.getDescriptionText())) {
                descriptionText2 = this.OooOo0.getDescriptionText();
                descriptionText = "";
            }
        } else {
            descriptionText = "";
        }
        if (TextUtils.isEmpty(descriptionText2)) {
            descriptionText2 = "查看详情";
        }
        this.Oooo00O.setText(descriptionText2);
        this.Oooo00o.setText(descriptionText);
    }

    @Override // com.ubixnow.ooooo.o000OO
    public void OooO00o(long j) {
        TextView textView = this.OooO0oo;
        if (textView != null) {
            textView.setText(j + this.OooOOo0);
        }
    }

    @Override // com.ubixnow.ooooo.o000OO
    public void OooO0O0() {
        float f = this.OooOoo0 / 800.0f;
        this.OooOO0O = f;
        float f2 = this.OooOoo / 360.0f;
        this.OooOO0o = f2;
        float f3 = this.OooOOOo;
        this.OooOOO0 = f / f3;
        this.OooOOO = f2 / f3;
    }

    @Override // com.ubixnow.ooooo.o000OO
    public void OooO0OO() {
        super.OooO0OO();
        ImageView imageView = this.Oooo0O0;
        if (imageView != null) {
            imageView.setImageBitmap(null);
        }
    }

    @Override // com.ubixnow.ooooo.o000OO
    public float OooO0Oo() {
        return 1.7777778f;
    }

    @Override // com.ubixnow.ooooo.o000OO
    public View OooO0o() {
        return this.Oooo000;
    }

    @Override // com.ubixnow.ooooo.o000OO
    public int OooO0o0() {
        return R.layout.umn_custom_reward_landscape;
    }

    @Override // com.ubixnow.ooooo.o000OO
    public void OooOO0() {
        TextView textView = this.OooO0oo;
        if (textView != null) {
            textView.setText("已领取奖励");
        }
    }

    @Override // com.ubixnow.ooooo.o000OO
    public void OooOOO() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.OooO0oO.getLayoutParams();
        layoutParams.rightMargin = OooO0O0(37);
        layoutParams.topMargin = OooO0O0(10);
        int iOooO0O0 = OooO0O0(24);
        layoutParams.height = iOooO0O0;
        layoutParams.width = iOooO0O0;
        this.OooO0oo.setBackground(OooO00o(this.OooO0OO.getContext(), Integer.MIN_VALUE, OooO00o(3), 1.0f, -1));
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.OooO0oo.getLayoutParams();
        layoutParams2.rightMargin = OooO0O0(17);
        layoutParams2.width = OooO0O0(102);
        layoutParams2.height = OooO0O0(22);
        this.OooO0oo.setTextSize(2, OooO00o(8));
        if (this.OooOoO != null) {
            this.Oooo0O0.setImageDrawable(new oO000(this.OooO0OO.getContext(), this.OooOoO, OooO0Oo(9)));
        } else {
            this.Oooo0O0.setImageResource(R.drawable.umn_custom_rewad_default_icon);
        }
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.Oooo0O0.getLayoutParams();
        layoutParams3.topMargin = OooO0Oo(8);
        int iOooO0Oo = OooO0Oo(39);
        layoutParams3.height = iOooO0Oo;
        layoutParams3.width = iOooO0Oo;
        this.Oooo00O.setTextSize(2, OooO0OO(13));
        ((LinearLayout.LayoutParams) this.Oooo00O.getLayoutParams()).topMargin = OooO0Oo(6);
        this.Oooo00o.setTextSize(2, OooO0OO(11));
        ((LinearLayout.LayoutParams) this.Oooo00o.getLayoutParams()).topMargin = OooO0Oo(8);
        TextView textView = (TextView) this.OooOOOO.findViewById(R.id.btn_title_text_2);
        textView.getPaint().setFakeBoldText(true);
        textView.setTextSize(2, OooO0OO(16));
        ((LinearLayout.LayoutParams) textView.getLayoutParams()).topMargin = OooO0Oo(14);
        TextView textView2 = (TextView) this.OooOOOO.findViewById(R.id.btn_title_text_3);
        textView2.setTextSize(2, OooO0OO(11));
        ((LinearLayout.LayoutParams) textView2.getLayoutParams()).topMargin = OooO0Oo(10);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.Oooo000.getLayoutParams();
        this.Oooo000.setBackground(OooO00o(this.OooO0OO.getContext(), -1, OooO0OO(8), 0.0f, -1));
        this.Oooo000.setPadding(OooO0Oo(10), 0, OooO0Oo(10), 0);
        this.Oooo000.setZ(100.0f);
        this.Oooo0.setZ(100.0f);
        this.OooO0Oo.setZ(101.0f);
        this.OooO0oo.setZ(102.0f);
        this.OooO0oO.setZ(102.0f);
        layoutParams4.rightMargin = OooO0O0(37);
        layoutParams4.width = OooO0Oo(MediaPlayer.MEDIA_PLAYER_OPTION_AV_NO_SYNC_THRESHOLD);
        layoutParams4.height = OooO0Oo(157);
        layoutParams4.bottomMargin = OooO0O0(16);
        this.Oooo0.setTextSize(2, OooO0OO(8));
        this.Oooo0.setPadding(OooO0Oo(5), OooO0Oo(3), OooO0Oo(5), OooO0Oo(3));
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.Oooo0.getLayoutParams();
        layoutParams5.rightMargin = OooO0Oo(1);
        layoutParams5.bottomMargin = OooO0Oo(8);
    }
}
