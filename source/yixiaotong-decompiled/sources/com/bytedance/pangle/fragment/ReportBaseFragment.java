package com.bytedance.pangle.fragment;

import android.app.Application;
import android.app.Fragment;
import android.content.Context;
import com.byazt.jna.ve;
import com.bytedance.pangle.Zeus;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class ReportBaseFragment extends Fragment {
    public Application.ActivityLifecycleCallbacks callbacks = new ve(this);

    @Override // android.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        Zeus.getAppApplication().registerActivityLifecycleCallbacks(this.callbacks);
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        Zeus.getAppApplication().unregisterActivityLifecycleCallbacks(this.callbacks);
    }
}
