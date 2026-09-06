package com.kwad.components.ad.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class AppScoreView extends LinearLayout {
    private ImageView NY;
    private ImageView NZ;

    public AppScoreView(Context context) {
        this(context, null);
    }

    public AppScoreView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppScoreView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        inflate(getContext(), R.layout.ksad_app_score, this);
        this.NY = (ImageView) findViewById(R.id.ksad_score_fourth);
        this.NZ = (ImageView) findViewById(R.id.ksad_score_fifth);
    }

    public void setScore(float f) {
        double d = f;
        if (d > 4.5d) {
            this.NY.setImageResource(R.drawable.ksad_star_checked);
            this.NZ.setImageResource(R.drawable.ksad_star_checked);
            return;
        }
        if (d > 4.0d) {
            this.NY.setImageResource(R.drawable.ksad_star_checked);
            this.NZ.setImageResource(R.drawable.ksad_star_half);
            return;
        }
        if (d > 3.5d) {
            this.NY.setImageResource(R.drawable.ksad_star_checked);
            this.NZ.setImageResource(R.drawable.ksad_star_unchecked);
        } else if (d > 3.0d) {
            this.NY.setImageResource(R.drawable.ksad_star_half);
            this.NZ.setImageResource(R.drawable.ksad_star_unchecked);
        } else if (d == 3.0d) {
            this.NY.setImageResource(R.drawable.ksad_star_unchecked);
            this.NZ.setImageResource(R.drawable.ksad_star_unchecked);
        }
    }
}
