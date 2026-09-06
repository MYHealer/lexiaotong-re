package com.byazt.tm;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.byazt.aq.x;
import com.byazt.du.i;
import com.byazt.nr.m;
import com.byazt.nr.z;
import com.byazt.nwh.AnimationImageView;
import com.byazt.oq.DynamicLottieView;
import com.byazt.oq.GifView;
import com.byazt.oq.TTRoundRectImageView;
import com.byazt.or.a;
import com.byazt.or.da;
import com.byazt.ui.UpieImageView;
import com.byazt.xl.u;
import com.byazt.yj.gr;
import com.byazt.yj.qy;
import com.byazt.yj.yp;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.yfanads.android.libs.net.UrlConst;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 48, 1274})
public class DynamicImageView extends DynamicBaseWidgetImp {
    public String c;

    public DynamicImageView(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        if (!TextUtils.isEmpty(this.t.s()) && xVar.my()) {
            DynamicLottieView dynamicLottieView = new DynamicLottieView(context);
            dynamicLottieView.setAnimationsLoop(this.t.y());
            dynamicLottieView.setImageLottieTosPath(this.t.s());
            dynamicLottieView.setLottieAppNameMaxLength(this.t.dz());
            dynamicLottieView.setLottieAdTitleMaxLength(this.t.j());
            dynamicLottieView.setLottieAdDescMaxLength(this.t.iu());
            dynamicLottieView.setData(xVar.gt());
            this.z = dynamicLottieView;
        } else if (this.t.z() > 0.0f) {
            this.z = new TTRoundRectImageView(context);
            ((TTRoundRectImageView) this.z).setXRound((int) com.byazt.or.x.c(context, this.t.z()));
            ((TTRoundRectImageView) this.z).setYRound((int) com.byazt.or.x.c(context, this.t.z()));
        } else if (!sp() && "arrowButton".equals(xVar.da().getType())) {
            AnimationImageView animationImageView = new AnimationImageView(context);
            animationImageView.setBrickNativeValue(this.t);
            this.z = animationImageView;
        } else if (da.tt(this.t.sl())) {
            this.z = new GifView(context);
        } else {
            String strSl = this.t.sl();
            u renderRequest = dynamicRootView.getRenderRequest();
            if (renderRequest != null && renderRequest.tt() != null && TextUtils.equals(strSl, renderRequest.c())) {
                this.z = renderRequest.tt();
            } else {
                this.z = new ImageView(context);
            }
        }
        this.c = tt(this.t.sl());
        this.z.setTag(Integer.valueOf(getClickArea()));
        if ("arrowButton".equals(xVar.da().getType())) {
            if (this.t.tt() > 0 || this.t.c() > 0) {
                this.sp = Math.min(this.sp, this.x);
                this.x = Math.min(this.sp, this.x);
                this.i = (int) (this.i + com.byazt.or.x.c(context, this.t.tt() + (this.t.c() / 2) + 0.5f));
            } else {
                this.sp = Math.max(this.sp, this.x);
                this.x = Math.max(this.sp, this.x);
            }
            this.t.c(this.sp / 2);
        }
        addView(this.z, new FrameLayout.LayoutParams(this.sp, this.x));
    }

    @Override // com.byazt.tm.DynamicBaseWidgetImp, com.byazt.tm.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.z instanceof ImageView) {
            Drawable drawable = ((ImageView) this.z).getDrawable();
            if (Build.VERSION.SDK_INT < 28 || !(drawable instanceof AnimatedImageDrawable)) {
                return;
            }
            ((AnimatedImageDrawable) drawable).start();
        }
    }

    @Override // com.byazt.tm.DynamicBaseWidgetImp, com.byazt.tm.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.z instanceof ImageView) {
            Drawable drawable = ((ImageView) this.z).getDrawable();
            if (Build.VERSION.SDK_INT < 28 || !(drawable instanceof AnimatedImageDrawable)) {
                return;
            }
            ((AnimatedImageDrawable) drawable).stop();
        }
    }

    @Override // com.byazt.tm.DynamicBaseWidgetImp, com.byazt.tm.uj
    public boolean x() {
        super.x();
        try {
            if (this.z instanceof UpieImageView) {
                this.z.setBackgroundColor(this.t.md());
                if (i()) {
                    ((UpieImageView) this.z).setScaleType(ImageView.ScaleType.FIT_CENTER);
                } else {
                    ((UpieImageView) this.z).setScaleType(ImageView.ScaleType.FIT_XY);
                }
                if ("cover".equals(getImageObjectFit())) {
                    ((UpieImageView) this.z).setScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                return true;
            }
        } catch (Throwable th) {
            m.c(th);
        }
        if (!TextUtils.isEmpty(this.t.s())) {
            ((ImageView) this.z).setScaleType(ImageView.ScaleType.CENTER_CROP);
            return true;
        }
        if ("arrowButton".equals(this.u.da().getType())) {
            z.c(this.sl, "tt_white_righterbackicon_titlebar", new com.byazt.qr.c<Bitmap>() { // from class: com.byazt.tm.DynamicImageView.1
                @Override // com.byazt.qr.c
                public void c(Bitmap bitmap) {
                    ((ImageView) DynamicImageView.this.z).setImageDrawable(new BitmapDrawable(DynamicImageView.this.sl.getResources(), bitmap));
                    if (((ImageView) DynamicImageView.this.z).getDrawable() != null) {
                        ((ImageView) DynamicImageView.this.z).getDrawable().setAutoMirrored(true);
                    }
                }
            }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            this.z.setPadding(0, 0, 0, 0);
            ((ImageView) this.z).setScaleType(ImageView.ScaleType.FIT_XY);
            return true;
        }
        this.z.setBackgroundColor(this.t.md());
        String strTt = this.u.da().tt();
        if ("user".equals(strTt)) {
            ((ImageView) this.z).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ((ImageView) this.z).setColorFilter(this.t.sp());
            z.c(getContext(), "tt_user", (ImageView) this.z, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            ((ImageView) this.z).setPadding(this.sp / 10, this.x / 5, this.sp / 10, 0);
        } else if (strTt != null && strTt.startsWith("@")) {
            try {
                ((ImageView) this.z).setImageResource(Integer.parseInt(strTt.substring(1)));
            } catch (Exception e) {
                m.c(e);
            }
        }
        qy qyVarN = com.byazt.mf.c.c().n();
        String strSl = this.t.sl();
        if (!TextUtils.isEmpty(strSl) && !strSl.startsWith(UrlConst.HTTP) && !strSl.startsWith(UrlConst.HTTPS)) {
            strSl = i.tt(strSl, (this.yp == null || this.yp.getRenderRequest() == null) ? null : this.yp.getRenderRequest().yv());
        }
        yp ypVarKey = qyVarN.from(strSl).key(this.c);
        String strM = this.yp.getRenderRequest().m();
        if (!TextUtils.isEmpty(strM)) {
            ypVarKey.cacheDir(strM);
        }
        if (i()) {
            ((ImageView) this.z).setScaleType(ImageView.ScaleType.FIT_CENTER);
            ypVarKey.config(Bitmap.Config.ARGB_4444).type(2).converter(new c(this.sl)).to(new tt(this.z, getResources()));
        } else {
            if (com.byazt.sr.uj.c()) {
                ypVarKey.to((ImageView) this.z);
            }
            ((ImageView) this.z).setScaleType(ImageView.ScaleType.FIT_XY);
        }
        if ((this.z instanceof ImageView) && "cover".equals(getImageObjectFit())) {
            ((ImageView) this.z).setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        if (!com.byazt.sr.uj.c()) {
            c(ypVarKey);
        }
        return true;
    }

    @com.byazt.zqa.c(c = {0, 1, 48, 73})
    private static class c implements com.byazt.yj.da {
        public final WeakReference<Context> c;

        public c(Context context) {
            this.c = new WeakReference<>(context);
        }

        @Override // com.byazt.yj.da
        public Bitmap coverterTo(Bitmap bitmap) {
            Context context = this.c.get();
            if (context != null) {
                return com.byazt.or.tt.c(context, bitmap, 25);
            }
            return null;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 48, 1016})
    private static class tt implements gr<Bitmap> {
        public WeakReference<View> c;
        public Resources tt;

        @Override // com.byazt.yj.gr
        public void onFailed(int i, String str, Throwable th) {
        }

        public tt(View view, Resources resources) {
            this.c = new WeakReference<>(view);
            this.tt = resources;
        }

        @Override // com.byazt.yj.gr
        public void onSuccess(com.byazt.yj.m<Bitmap> mVar) {
            Bitmap result;
            View view = this.c.get();
            if (view == null || (result = mVar.getResult()) == null || mVar.getOriginResult() == null) {
                return;
            }
            view.setBackground(new BitmapDrawable(this.tt, result));
        }
    }

    private boolean i() {
        String strT = this.t.t();
        if (this.t.gt()) {
            return true;
        }
        if (TextUtils.isEmpty(strT)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(strT);
            return Math.abs((((float) this.sp) / (((float) this.x) * 1.0f)) - (((float) jSONObject.optInt("width")) / (((float) jSONObject.optInt("height")) * 1.0f))) > 0.01f;
        } catch (JSONException e) {
            m.c(e);
            return false;
        }
    }

    public String tt(String str) {
        Map<String, String> mapU = this.yp.getRenderRequest().u();
        if (mapU == null || mapU.size() <= 0) {
            return null;
        }
        return mapU.get(str);
    }

    private void c(yp ypVar) {
        ypVar.type(3).to(new gr() { // from class: com.byazt.tm.DynamicImageView.2
            @Override // com.byazt.yj.gr
            public void onFailed(int i, String str, Throwable th) {
            }

            @Override // com.byazt.yj.gr
            public void onSuccess(com.byazt.yj.m mVar) {
                Object result = mVar.getResult();
                if ((result instanceof byte[]) && (DynamicImageView.this.z instanceof ImageView)) {
                    a.tt((ImageView) DynamicImageView.this.z, (byte[]) result, DynamicImageView.this.sp, DynamicImageView.this.x);
                }
            }
        }, 4);
    }
}
