package com.yfanads.android.custom.view;

import android.content.DialogInterface;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class DialogInterfaceProxy {

    public static class ProxyOnCancelListener implements DialogInterface.OnCancelListener {
        private WeakReference<DialogInterface.OnCancelListener> mProxyRef;

        public ProxyOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.mProxyRef = new WeakReference<>(onCancelListener);
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            DialogInterface.OnCancelListener onCancelListener = this.mProxyRef.get();
            if (onCancelListener != null) {
                onCancelListener.onCancel(dialogInterface);
            }
        }
    }

    public static class ProxyOnDismissListener implements DialogInterface.OnDismissListener {
        private WeakReference<DialogInterface.OnDismissListener> mProxyRef;

        public ProxyOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.mProxyRef = new WeakReference<>(onDismissListener);
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            DialogInterface.OnDismissListener onDismissListener = this.mProxyRef.get();
            if (onDismissListener != null) {
                onDismissListener.onDismiss(dialogInterface);
            }
        }
    }

    public static class ProxyOnShowListener implements DialogInterface.OnShowListener {
        private WeakReference<DialogInterface.OnShowListener> mProxyRef;

        public ProxyOnShowListener(DialogInterface.OnShowListener onShowListener) {
            this.mProxyRef = new WeakReference<>(onShowListener);
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            DialogInterface.OnShowListener onShowListener = this.mProxyRef.get();
            if (onShowListener != null) {
                onShowListener.onShow(dialogInterface);
            }
        }
    }

    private DialogInterfaceProxy() {
    }

    public static DialogInterface.OnCancelListener proxy(DialogInterface.OnCancelListener onCancelListener) {
        return new ProxyOnCancelListener(onCancelListener);
    }

    public static DialogInterface.OnDismissListener proxy(DialogInterface.OnDismissListener onDismissListener) {
        return new ProxyOnDismissListener(onDismissListener);
    }

    public static DialogInterface.OnShowListener proxy(DialogInterface.OnShowListener onShowListener) {
        return new ProxyOnShowListener(onShowListener);
    }
}
