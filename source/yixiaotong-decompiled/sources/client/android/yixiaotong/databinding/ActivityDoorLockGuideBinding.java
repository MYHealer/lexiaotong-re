package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.HighLightLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityDoorLockGuideBinding implements ViewBinding {
    public final HighLightLayout highLightLayout;
    private final HighLightLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public HighLightLayout getRoot() {
        return this.rootView;
    }

    private ActivityDoorLockGuideBinding(HighLightLayout highLightLayout, HighLightLayout highLightLayout2) {
        this.rootView = highLightLayout;
        this.highLightLayout = highLightLayout2;
    }

    public static ActivityDoorLockGuideBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityDoorLockGuideBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_door_lock_guide, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityDoorLockGuideBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        HighLightLayout highLightLayout = (HighLightLayout) view;
        return new ActivityDoorLockGuideBinding(highLightLayout, highLightLayout);
    }
}
