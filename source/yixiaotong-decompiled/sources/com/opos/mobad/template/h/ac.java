package com.opos.mobad.template.h;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.cmn.baseview.BaseImageView;
import com.opos.mobad.template.cmn.baseview.BaseTextView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f8040a;
    private ViewGroup b;
    private BaseTextView c;
    private View d;
    private TextView e;
    private BaseImageView f;
    private a g;

    public interface a {
    }

    public void a(int i, boolean z, String str) {
        BaseTextView baseTextView;
        String str2;
        int i2 = 8;
        if ((i == 0 && !z) || (i == 0 && TextUtils.isEmpty(str))) {
            this.b.setVisibility(8);
            return;
        }
        this.b.setVisibility(0);
        this.e.setVisibility(z ? 0 : 8);
        this.e.setText(str);
        boolean z2 = true;
        if (i != 1) {
            if (i == 2) {
                baseTextView = this.c;
                str2 = "VIP免广告";
            } else {
                this.c.setVisibility(8);
                z2 = false;
            }
            View view = this.d;
            if (z && z2) {
                i2 = 0;
            }
            view.setVisibility(i2);
        }
        baseTextView = this.c;
        str2 = "跳过广告";
        baseTextView.setText(str2);
        this.c.setVisibility(0);
        View view2 = this.d;
        if (z) {
            i2 = 0;
        }
        view2.setVisibility(i2);
    }

    public void a(a aVar) {
        this.g = aVar;
    }

    public void a(boolean z) {
        BaseImageView baseImageView;
        Resources resources;
        int i;
        if (z) {
            baseImageView = this.f;
            resources = this.f8040a.getResources();
            i = R.drawable.opos_mobad_drawable_sound_on;
        } else {
            baseImageView = this.f;
            resources = this.f8040a.getResources();
            i = R.drawable.opos_mobad_drawable_sound_off;
        }
        baseImageView.setImageDrawable(resources.getDrawable(i));
    }
}
