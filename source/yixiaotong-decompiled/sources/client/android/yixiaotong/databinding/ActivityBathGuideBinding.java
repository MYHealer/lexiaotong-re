package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import client.android.yixiaotong.R;
import client.android.yixiaotong.v3.ui.weight.HighLightLayoutV3;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityBathGuideBinding implements ViewBinding {
    public final HighLightLayoutV3 highLightLayout;
    private final HighLightLayoutV3 rootView;

    @Override // androidx.viewbinding.ViewBinding
    public HighLightLayoutV3 getRoot() {
        return this.rootView;
    }

    private ActivityBathGuideBinding(HighLightLayoutV3 highLightLayoutV3, HighLightLayoutV3 highLightLayoutV4) {
        this.rootView = highLightLayoutV3;
        this.highLightLayout = highLightLayoutV4;
    }

    public static ActivityBathGuideBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityBathGuideBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_bath_guide, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityBathGuideBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        HighLightLayoutV3 highLightLayoutV3 = (HighLightLayoutV3) view;
        return new ActivityBathGuideBinding(highLightLayoutV3, highLightLayoutV3);
    }
}
