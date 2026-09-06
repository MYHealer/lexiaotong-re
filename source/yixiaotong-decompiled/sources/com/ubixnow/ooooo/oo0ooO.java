package com.ubixnow.ooooo;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import com.ubixnow.core.R;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class oo0ooO extends Dialog {
    public int OooO00o;
    private HashMap<String, String> OooO0O0;
    private Context OooO0OO;

    public class OooO00o implements o0OO0O0.OooOO0 {
        public OooO00o() {
        }

        @Override // com.ubixnow.ooooo.o0OO0O0.OooOO0
        public void OooO00o(Activity activity) {
            if (oo0ooO.this.OooO0OO != null && (oo0ooO.this.OooO0OO instanceof Activity) && ((Activity) oo0ooO.this.OooO0OO).equals(activity)) {
                ooooO000.OooO0O0("------FeedBackDialogEdtView", "----- onDestroy dialogType " + oo0ooO.this.OooO00o);
                oo0ooO.super.dismiss();
            }
        }
    }

    public static class OooO0O0 {
        private Context OooO00o;

        public class OooO00o implements o0OO0o {
            public final /* synthetic */ oo0ooO OooO00o;

            public OooO00o(oo0ooO oo0ooo) {
                this.OooO00o = oo0ooo;
            }

            @Override // com.ubixnow.ooooo.o0OO0o
            public void OooO00o() {
                oo0ooO oo0ooo = this.OooO00o;
                if (oo0ooo != null) {
                    oo0ooo.dismiss();
                }
            }

            @Override // com.ubixnow.ooooo.o0OO0o
            public void OooO00o(int i, String str) {
            }
        }

        /* JADX INFO: renamed from: com.ubixnow.ooooo.oo0ooO$OooO0O0$OooO0O0, reason: collision with other inner class name */
        public class ViewOnClickListenerC1142OooO0O0 implements View.OnClickListener {
            public final /* synthetic */ oo0ooO OooO00o;

            public ViewOnClickListenerC1142OooO0O0(oo0ooO oo0ooo) {
                this.OooO00o = oo0ooo;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (this.OooO00o != null) {
                    if (view.getId() == R.id.dialog_submit) {
                        this.OooO00o.OooO00o(1);
                    }
                    this.OooO00o.dismiss();
                }
            }
        }

        public OooO0O0(Context context) {
            this.OooO00o = context;
        }

        public oo0ooO OooO00o(int i, HashMap<String, String> map) {
            View view;
            o0OOooO0 o0ooooo0;
            o0OO0o00 o0oo0o00;
            try {
                oo0ooO oo0ooo = new oo0ooO(this.OooO00o, R.style.Ubix_DialogTheme);
                if (i == 1) {
                    o0oo0o00 = new o0OO0o00(this.OooO00o);
                    oo0ooo.OooO00o(i, map);
                    o0oo0o00.setTrackingInfo(map);
                    o0oo0o00.setDislikeCallback(new OooO00o(oo0ooo));
                } else if (i == 2) {
                    o0ooooo0 = new o0OOooO0(this.OooO00o);
                    o0ooooo0.setTrackingInfo(map);
                    oo0ooo.OooO00o(i, map);
                    o0ooooo0.setClickListener(new ViewOnClickListenerC1142OooO0O0(oo0ooo));
                } else {
                    view = null;
                }
                if (view != null) {
                    view = o0ooooo0;
                    view = o0oo0o00;
                    oo0ooo.setContentView(view);
                }
                view = o0ooooo0;
                view = o0oo0o00;
                return oo0ooo;
            } catch (Throwable th) {
                ooooO000.OooO0O0("------Throwable", "----e " + th.getMessage());
                th.printStackTrace();
                return null;
            }
        }
    }

    public oo0ooO(Context context) {
        super(context);
        this.OooO00o = 1;
    }

    public oo0ooO(Context context, int i) {
        super(context, i);
        this.OooO00o = 1;
        this.OooO0OO = context;
    }

    public void OooO00o(int i) {
        this.OooO00o = i;
    }

    public void OooO00o(int i, HashMap<String, String> map) {
        this.OooO00o = i;
        this.OooO0O0 = map;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            ooooO000.OooO0O0("------FeedBackDialogEdtView", "----- dismiss dialogType " + this.OooO00o);
            if (this.OooO00o == 2) {
                oo0ooO oo0oooOooO00o = new OooO0O0(this.OooO0OO).OooO00o(1, this.OooO0O0);
                ooooO000.OooO0O0("------FeedBackDialogEdtView", "----- trackMap" + this.OooO0O0.size());
                oo0oooOooO00o.show();
            }
        } catch (Exception unused) {
        }
        super.dismiss();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        o0O00o00 o0o00o00 = o0O0O0O.OooO00o;
        if (o0o00o00 != null) {
            o0o00o00.OooO00o(new OooO00o());
        }
    }
}
