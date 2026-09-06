package com.byazt.oq;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import com.byazt.du.sl;
import com.byazt.nr.z;
import com.byazt.or.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 269, 1011})
public class TTRatingBar2 extends FrameLayout {
    public static final int sp = (sl.tt("", 0.0f, true)[1] / 2) + 1;
    public static final int x = (sl.tt("", 0.0f, true)[1] / 2) + 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f2594a;
    public LinearLayout c;
    public double n;
    public LinearLayout tt;
    public float uj;
    public float ve;

    public TTRatingBar2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new LinearLayout(getContext());
        this.tt = new LinearLayout(getContext());
        this.c.setOrientation(0);
        this.c.setGravity(GravityCompat.START);
        this.tt.setOrientation(0);
        this.tt.setGravity(GravityCompat.START);
    }

    public void c(double d, final int i, int i2, int i3) {
        float f = i2;
        this.ve = (int) x.ve(getContext(), f);
        this.uj = (int) x.ve(getContext(), f);
        this.n = d;
        this.f2594a = i3;
        removeAllViews();
        z.c(getContext(), "tt_star", new com.byazt.qr.c<Bitmap>() { // from class: com.byazt.oq.TTRatingBar2.1
            @Override // com.byazt.qr.c
            public void c(Bitmap bitmap) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(TTRatingBar2.this.getContext().getResources(), bitmap);
                for (int i4 = 0; i4 < 5; i4++) {
                    ImageView starImageView = TTRatingBar2.this.getStarImageView();
                    starImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    starImageView.setColorFilter(i, PorterDuff.Mode.SRC_IN);
                    starImageView.setImageDrawable(bitmapDrawable);
                    TTRatingBar2.this.tt.addView(starImageView);
                }
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        z.c(getContext(), "tt_star_thick", new com.byazt.qr.c<Bitmap>() { // from class: com.byazt.oq.TTRatingBar2.2
            @Override // com.byazt.qr.c
            public void c(Bitmap bitmap) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(TTRatingBar2.this.getContext().getResources(), bitmap);
                for (int i4 = 0; i4 < 5; i4++) {
                    ImageView starImageView = TTRatingBar2.this.getStarImageView();
                    starImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    starImageView.setImageDrawable(bitmapDrawable);
                    TTRatingBar2.this.c.addView(starImageView);
                }
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        addView(this.c);
        addView(this.tt);
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams((int) this.ve, (int) this.uj));
        imageView.setPadding(1, sp, 1, x);
        return imageView;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.c.measure(i, i2);
        double d = this.n;
        float f = this.ve;
        this.tt.measure(View.MeasureSpec.makeMeasureSpec((int) (((double) ((((int) d) * f) + 1.0f)) + (((double) (f - 2.0f)) * (d - ((double) ((int) d))))), 1073741824), View.MeasureSpec.makeMeasureSpec(this.c.getMeasuredHeight(), 1073741824));
        if (this.f2594a > 0.0f) {
            LinearLayout linearLayout = this.c;
            linearLayout.setPadding(0, ((int) (linearLayout.getMeasuredHeight() - this.f2594a)) / 2, 0, 0);
            this.tt.setPadding(0, ((int) (this.c.getMeasuredHeight() - this.f2594a)) / 2, 0, 0);
        }
    }
}
