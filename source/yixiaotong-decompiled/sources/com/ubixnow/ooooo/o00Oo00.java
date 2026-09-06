package com.ubixnow.ooooo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.ubixnow.core.common.ui.UMNFrameLayout;
import com.ubixnow.core.common.ui.UMNRelativeLayout;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o00Oo00 implements o00OOOOo {
    private WeakReference<ViewGroup> OooO00o;
    private WeakReference<ViewGroup> OooO0O0;
    private WeakReference<View> OooO0OO;
    private boolean OooO0Oo = false;
    private boolean OooO0o0 = false;

    @Override // com.ubixnow.ooooo.o00OOOOo
    public View OooO00o() {
        WeakReference<View> weakReference = this.OooO0OO;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.OooO0OO.get();
    }

    @Override // com.ubixnow.ooooo.o00OOOOo
    public ViewGroup OooO00o(Context context) {
        return new UMNFrameLayout(context);
    }

    @Override // com.ubixnow.ooooo.o00OOOOo
    public void OooO00o(ViewGroup viewGroup, View view) {
        try {
            if (this.OooO0Oo) {
                return;
            }
            ViewGroup viewGroupOooO0OO = OooO0OO();
            if (viewGroupOooO0OO != null) {
                viewGroupOooO0OO.removeAllViews();
            }
            ViewGroup viewGroupOooO0O0 = OooO0O0(viewGroup.getContext());
            viewGroupOooO0O0.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            viewGroup.addView(viewGroupOooO0O0);
            this.OooO00o = new WeakReference<>(viewGroupOooO0O0);
            if (view != null && OooO00o() == null) {
                this.OooO0OO = new WeakReference<>(view);
            }
            this.OooO0Oo = true;
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    @Override // com.ubixnow.ooooo.o00OOOOo
    public ViewGroup OooO0O0() {
        WeakReference<ViewGroup> weakReference = this.OooO0O0;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.OooO0O0.get();
    }

    @Override // com.ubixnow.ooooo.o00OOOOo
    public ViewGroup OooO0O0(Context context) {
        return new UMNRelativeLayout(context);
    }

    @Override // com.ubixnow.ooooo.o00OOOOo
    public ViewGroup OooO0OO() {
        WeakReference<ViewGroup> weakReference = this.OooO00o;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.OooO00o.get();
    }

    @Override // com.ubixnow.ooooo.o00OOOOo
    public void OooO0OO(Context context) {
        try {
            if (this.OooO0o0 || context == null || OooO0OO() == null) {
                return;
            }
            ViewGroup viewGroupOooO00o = OooO00o(context);
            viewGroupOooO00o.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.OooO0O0 = new WeakReference<>(viewGroupOooO00o);
            OooO0OO().addView(viewGroupOooO00o);
            this.OooO0o0 = true;
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }
}
