package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public interface FragmentResultOwner {
    void clearFragmentResult(String str);

    void clearFragmentResultListener(String str);

    void setFragmentResult(String str, Bundle bundle);

    void setFragmentResultListener(String str, LifecycleOwner lifecycleOwner, FragmentResultListener fragmentResultListener);
}
