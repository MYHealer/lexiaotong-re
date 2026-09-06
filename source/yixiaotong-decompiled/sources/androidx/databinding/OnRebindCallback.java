package androidx.databinding;

import androidx.databinding.ViewDataBinding;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public abstract class OnRebindCallback<T extends ViewDataBinding> {
    public void onBound(T t) {
    }

    public void onCanceled(T t) {
    }

    public boolean onPreBind(T t) {
        return true;
    }
}
