package com.fancy.mpsdk.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.fancy._p5;
import com.fancy.adsdk.lib.R;
import com.fancy.mpsdk.component.videoplayer.NiceVideoPlayer;
import com.fancy.mpsdk.component.widgets.PlaceholderImageView;
import com.fancy.mpsdk.widget.PtgRoundLinearLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public abstract class PtgBaseVideoActivity extends Activity {
    public TextView _A;
    public TextView _B;
    public TextView _C;
    public TextView _D;
    public TextView _E;
    public TextView _F;
    public LinearLayout _G;
    public FrameLayout _a;
    public NiceVideoPlayer _b;
    public ProgressBar _c;
    public FrameLayout _d;
    public ImageView _e;
    public PtgRoundLinearLayout _f;
    public ImageView _g;
    public TextView _h;
    public ImageView _i;
    public LinearLayout _j;
    public PlaceholderImageView _k;
    public TextView _l;
    public TextView _m;
    public LinearLayout _n;
    public TextView _o;
    public TextView _p;
    public TextView _q;
    public TextView _r;
    public TextView _s;
    public TextView _t;
    public LinearLayout _u;
    public LinearLayout _v;
    public PlaceholderImageView _w;
    public TextView _x;
    public TextView _y;
    public LinearLayout _z;

    public void _a() {
    }

    public final void _b() {
        this._a = (FrameLayout) findViewById(R.id.ptg_reward_root);
        this._c = (ProgressBar) findViewById(R.id.ptg_reward_playable_loading);
        this._e = (ImageView) findViewById(R.id.ptg_cover);
        this._d = (FrameLayout) findViewById(R.id.ptg_video_reward_container);
        this._f = (PtgRoundLinearLayout) findViewById(R.id.ptg_close_layout);
        this._g = (ImageView) findViewById(R.id.ptg_reward_icon);
        this._h = (TextView) findViewById(R.id.ptg_top_countdown);
        this._i = (ImageView) findViewById(R.id.ptg_top_mute);
        this._b = (NiceVideoPlayer) findViewById(R.id.ptgVideoNiceVideoPlayer);
        this._j = (LinearLayout) findViewById(R.id.ptg_bottom_bar);
        this._k = (PlaceholderImageView) findViewById(R.id.ptg_bottom_bar_icon);
        this._l = (TextView) findViewById(R.id.ptg_bottom_bar_title);
        this._m = (TextView) findViewById(R.id.ptg_bottom_bar_subtitle);
        this._n = (LinearLayout) findViewById(R.id.ptg_app_layout);
        this._o = (TextView) findViewById(R.id.ptg_app_company_tv);
        this._p = (TextView) findViewById(R.id.ptg_app_version_tv);
        this._q = (TextView) findViewById(R.id.ptg_app_function_tv);
        this._r = (TextView) findViewById(R.id.ptg_app_authority_tv);
        this._s = (TextView) findViewById(R.id.ptg_app_privacy_tv);
        this._t = (TextView) findViewById(R.id.ptg_reward_ad_download);
        this._u = (LinearLayout) findViewById(R.id.ptg_shake_layout);
        this._v = (LinearLayout) findViewById(R.id.ptg_finished_layout);
        this._w = (PlaceholderImageView) findViewById(R.id.ptg_finished_ad_icon);
        this._x = (TextView) findViewById(R.id.ptg_finished_title);
        this._y = (TextView) findViewById(R.id.ptg_finished_subtitle);
        this._z = (LinearLayout) findViewById(R.id.ptg_finished_app_layout);
        this._A = (TextView) findViewById(R.id.ptg_finished_app_company_tv);
        this._B = (TextView) findViewById(R.id.ptg_finished_app_version_tv);
        this._C = (TextView) findViewById(R.id.ptg_finished_app_function_tv);
        this._D = (TextView) findViewById(R.id.ptg_finished_app_authority_tv);
        this._E = (TextView) findViewById(R.id.ptg_finished_app_privacy_tv);
        this._F = (TextView) findViewById(R.id.ptg_finished_download);
        this._F = (TextView) findViewById(R.id.ptg_finished_download);
        this._G = (LinearLayout) findViewById(R.id.ptg_finished_shake_layout);
        try {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.bar_logo_layout);
            LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.end_logo_layout);
            ImageView imageView = (ImageView) linearLayout.findViewById(R.id.ptg_sdk_ad_logo_iv);
            ImageView imageView2 = (ImageView) linearLayout2.findViewById(R.id.ptg_sdk_ad_logo_iv);
            _p5._a(imageView);
            _p5._a(imageView2);
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            requestWindowFeature(1);
            getWindow().addFlags(1024);
            getWindow().addFlags(16777216);
        } catch (Throwable unused) {
        }
    }
}
