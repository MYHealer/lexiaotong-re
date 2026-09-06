package com.bytedance.pangle.fragment;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import com.byazt.bog.a;
import com.byazt.jna.c;
import com.byazt.jna.tt;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.MethodUtils;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class ZeusDialogFragmentV4 extends DialogFragment {
    public Application.ActivityLifecycleCallbacks callbacks = new tt(this);

    public ZeusDialogFragmentV4() {
        c.c(getClass());
    }

    @Override // androidx.fragment.app.Fragment
    public Context getContext() {
        try {
            return ZeusTransformUtils.wrapperContext(super.getContext(), (String) MethodUtils.invokeStaticMethod(getClass(), "_GET_PLUGIN_PKG", new Object[0]));
        } catch (IllegalAccessException e) {
            a.c(e);
            return super.getContext();
        } catch (NoSuchMethodException e2) {
            a.c(e2);
            return super.getContext();
        } catch (InvocationTargetException e3) {
            a.c(e3);
            return super.getContext();
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        try {
            return new Dialog(ZeusTransformUtils.wrapperContext(getContext(), (String) MethodUtils.invokeStaticMethod(getClass(), "_GET_PLUGIN_PKG", new Object[0])), getTheme());
        } catch (IllegalAccessException e) {
            a.c(e);
            return null;
        } catch (NoSuchMethodException e2) {
            a.c(e2);
            return null;
        } catch (InvocationTargetException e3) {
            a.c(e3);
            return null;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        Zeus.getAppApplication().registerActivityLifecycleCallbacks(this.callbacks);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        Zeus.getAppApplication().unregisterActivityLifecycleCallbacks(this.callbacks);
        super.onDetach();
    }
}
