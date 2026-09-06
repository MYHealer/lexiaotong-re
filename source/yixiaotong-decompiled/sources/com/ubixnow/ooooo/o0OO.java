package com.ubixnow.ooooo;

import android.widget.TextView;
import android.widget.Toast;
import com.ubixnow.core.R;
import com.ubixnow.utils.BaseUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o0OO {
    private static Toast OooO00o;

    public static void OooO00o(int i) {
        Toast toastMakeText = OooO00o;
        if (toastMakeText == null) {
            toastMakeText = Toast.makeText(BaseUtils.getContext(), (CharSequence) null, 0);
            OooO00o = toastMakeText;
        }
        toastMakeText.setText(i);
        OooO00o.show();
    }

    public static void OooO00o(String str) {
        try {
            Toast toast = new Toast(BaseUtils.getContext());
            TextView textView = new TextView(BaseUtils.getContext());
            textView.setText(str);
            textView.setTextColor(-1);
            textView.setBackgroundResource(R.drawable.ubix_feedback_toast_bg);
            textView.setPadding(oOO00000.OooO00o(16.0f), oOO00000.OooO00o(8.0f), oOO00000.OooO00o(16.0f), oOO00000.OooO00o(8.0f));
            toast.setView(textView);
            toast.show();
        } catch (Throwable unused) {
        }
    }

    public static void OooO0O0(int i) {
        Toast toastMakeText = OooO00o;
        if (toastMakeText == null) {
            toastMakeText = Toast.makeText(BaseUtils.getContext(), (CharSequence) null, 0);
            OooO00o = toastMakeText;
        }
        toastMakeText.setText(i);
        OooO00o.show();
    }

    public static void OooO0O0(String str) {
        Toast toastMakeText = OooO00o;
        if (toastMakeText == null) {
            toastMakeText = Toast.makeText(BaseUtils.getContext(), (CharSequence) null, 0);
            OooO00o = toastMakeText;
        }
        toastMakeText.setText(str);
        OooO00o.show();
    }

    public static void OooO0OO(int i) {
        Toast toastMakeText = OooO00o;
        if (toastMakeText == null) {
            toastMakeText = Toast.makeText(BaseUtils.getContext(), (CharSequence) null, 0);
            OooO00o = toastMakeText;
        }
        toastMakeText.setText(i);
        ((TextView) OooO00o.getView().findViewById(android.R.id.message)).setGravity(17);
        OooO00o.show();
    }

    public static void OooO0OO(String str) {
        Toast toastMakeText = OooO00o;
        if (toastMakeText == null) {
            toastMakeText = Toast.makeText(BaseUtils.getContext(), (CharSequence) null, 0);
            OooO00o = toastMakeText;
        }
        toastMakeText.setText(str);
        ((TextView) OooO00o.getView().findViewById(android.R.id.message)).setGravity(17);
        OooO00o.show();
    }

    public static void OooO0Oo(String str) {
        Toast toastMakeText = OooO00o;
        if (toastMakeText == null) {
            toastMakeText = Toast.makeText(BaseUtils.getContext(), (CharSequence) null, 1);
            OooO00o = toastMakeText;
        }
        toastMakeText.setText(str);
        OooO00o.show();
    }
}
