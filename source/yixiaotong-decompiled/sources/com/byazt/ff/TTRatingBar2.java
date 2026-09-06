package com.byazt.ff;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import com.byazt.nr.z;
import com.byazt.zqa.c;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO, 1011})
public class TTRatingBar2 extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2225a;
    public LinearLayout c;
    public int i;
    public double n;
    public int sp;
    public LinearLayout tt;
    public int uj;
    public int ve;
    public int x;

    public void c(int i, int i2) {
        this.ve = i2;
        this.uj = i;
    }

    public void c(int i, int i2, int i3, int i4) {
        this.f2225a = i;
        this.sp = i2;
        this.x = i3;
        this.i = i4;
    }

    public void setRating(double d) {
        this.n = d;
    }

    public TTRatingBar2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new LinearLayout(getContext());
        this.tt = new LinearLayout(getContext());
        this.c.setOrientation(0);
        this.c.setGravity(GravityCompat.START);
        this.tt.setOrientation(0);
        this.tt.setGravity(GravityCompat.START);
    }

    public void c() {
        removeAllViews();
        z.c(getContext(), "tt_ratingbar_full_star2", new com.byazt.qr.c<Bitmap>() { // from class: com.byazt.ff.TTRatingBar2.1
            @Override // com.byazt.qr.c
            public void c(Bitmap bitmap) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(TTRatingBar2.this.getContext().getResources(), bitmap);
                for (int i = 0; i < 5; i++) {
                    ImageView starImageView = TTRatingBar2.this.getStarImageView();
                    starImageView.setImageDrawable(bitmapDrawable);
                    TTRatingBar2.this.tt.addView(starImageView);
                }
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        z.c(getContext(), "tt_ratingbar_empty_star2", new com.byazt.qr.c<Bitmap>() { // from class: com.byazt.ff.TTRatingBar2.2
            @Override // com.byazt.qr.c
            public void c(Bitmap bitmap) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(TTRatingBar2.this.getContext().getResources(), bitmap);
                for (int i = 0; i < 5; i++) {
                    ImageView starImageView = TTRatingBar2.this.getStarImageView();
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
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ve, this.uj);
        layoutParams.leftMargin = this.f2225a;
        layoutParams.topMargin = this.sp;
        layoutParams.rightMargin = this.x;
        layoutParams.bottomMargin = this.i;
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.c.measure(i, i2);
        double dFloor = Math.floor(this.n);
        int i3 = this.f2225a;
        int i4 = this.x + i3;
        int i5 = this.ve;
        this.tt.measure(View.MeasureSpec.makeMeasureSpec((int) ((((double) (i4 + i5)) * dFloor) + ((double) i3) + ((this.n - dFloor) * ((double) i5))), 1073741824), View.MeasureSpec.makeMeasureSpec(this.c.getMeasuredHeight(), 1073741824));
    }
}
