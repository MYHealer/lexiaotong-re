package com.kwad.components.ad.widget.tailframe.appbar;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class TailFrameBarAppPortraitHorizontal extends a {
    public TailFrameBarAppPortraitHorizontal(Context context) {
        this(context, null);
    }

    public TailFrameBarAppPortraitHorizontal(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameBarAppPortraitHorizontal(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.kwad.components.ad.widget.tailframe.appbar.a
    public int getLayoutId() {
        return R.layout.ksad_video_tf_bar_app_portrait_horizontal;
    }

    @Override // com.kwad.components.ad.widget.tailframe.appbar.a
    public final void n(AdTemplate adTemplate) {
        if (e.S(adTemplate)) {
            this.Ia.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.ksad_translucent));
            this.nV.setTextColor(Color.parseColor("#FFFFFF"));
            this.Ox.setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            this.Ia.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
        super.n(adTemplate);
    }
}
