package com.ubixnow.ooooo;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.ubixnow.utils.BaseUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o0O0OO0 {
    private oo00o OooO00o;
    private HashMap<String, String> OooO0O0 = new HashMap<>();
    private o00O000 OooO0OO;
    private final View OooO0Oo;
    private final ViewGroup OooO0o;
    private View OooO0o0;

    public class OooO00o implements Runnable {
        public final /* synthetic */ oOO00O OooO00o;

        public OooO00o(oOO00O ooo00o) {
            this.OooO00o = ooo00o;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                o0O0OO0.this.OooO00o(this.OooO00o);
            } catch (Throwable th) {
                ooooO000.OooO00o(th);
            }
        }
    }

    public class OooO0O0 implements View.OnTouchListener {
        public final /* synthetic */ FrameLayout OooO00o;

        public class OooO00o implements Runnable {
            public OooO00o() {
            }

            @Override // java.lang.Runnable
            public void run() {
                OooO0O0 oooO0O0 = OooO0O0.this;
                o0O0OO0.this.OooO00o(oooO0O0.OooO00o);
                o0O0OO0.this.OooO0o0();
            }
        }

        public OooO0O0(FrameLayout frameLayout) {
            this.OooO00o = frameLayout;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            try {
                if (motionEvent.getAction() != 1) {
                    return false;
                }
                this.OooO00o.postDelayed(new OooO00o(), 200L);
                this.OooO00o.setOnTouchListener(null);
            } catch (Throwable th) {
                ooooO000.OooO00o(th);
            }
            return false;
        }
    }

    public o0O0OO0(o00O000 o00o000, oo00o oo00oVar, ViewGroup viewGroup, View view) {
        this.OooO0OO = o00o000;
        this.OooO00o = oo00oVar;
        this.OooO0o = viewGroup;
        this.OooO0Oo = view;
        OooO0Oo();
    }

    private void OooO00o() {
        try {
            FrameLayout frameLayout = new FrameLayout(BaseUtils.getContext());
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.OooO0o.addView(frameLayout);
            frameLayout.setOnTouchListener(new OooO0O0(frameLayout));
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO00o(View view) {
        if (view != null) {
            try {
                if (view.getParent() instanceof ViewGroup) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
            } catch (Throwable th) {
                ooooO000.OooO00o(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO00o(oOO00O ooo00o) {
        ViewParent parent = this.OooO0Oo.getParent();
        if ((parent instanceof ViewGroup) && this.OooO0o0.getParent() == null) {
            ViewGroup viewGroup = (ViewGroup) parent;
            int iIndexOfChild = viewGroup.indexOfChild(this.OooO0Oo);
            if (ooo00o.OooOOo == 2) {
                iIndexOfChild++;
            }
            this.OooO0o0.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            viewGroup.addView(this.OooO0o0, iIndexOfChild);
            OooO00o();
        }
    }

    private void OooO0O0(oOO00O ooo00o) {
        String str;
        String str2;
        if (ooo00o.OooOoO0 || ooo00o.OooOoO) {
            str = ooooO000.OooO0OO;
            str2 = "j3";
        } else {
            str = ooooO000.OooO0OO;
            str2 = "j4";
        }
        ooooO000.OooO0OO(str, ooooO000.OooO0OO(str2));
    }

    private void OooO0OO(oOO00O ooo00o) {
        this.OooO0o0 = new FrameLayout(this.OooO0Oo.getContext());
        this.OooO0Oo.post(new OooO00o(ooo00o));
    }

    private void OooO0Oo() {
        oo00o oo00oVar = this.OooO00o;
        if (oo00oVar != null) {
            if (oo00oVar.extraInfo == null) {
                oo00oVar.extraInfo = new HashMap<>();
            }
            this.OooO00o.extraInfo.put(oo00o.trackingExtraInfo, this.OooO0O0);
        }
    }

    public View OooO0O0() {
        return this.OooO0o0;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0015  */
    public void OooO0OO() {
        boolean z;
        try {
            o00O000 o00o000 = this.OooO0OO;
            oOO00O ooo00o = o00o000.OooOOO0;
            if (o0O0OOOo.OooO00o(o00o000.OooO00o, ooo00o)) {
                int i = ooo00o.OooOOo;
                z = true;
                if (i != 2 && i != 1) {
                    z = false;
                }
            } else {
                z = false;
            }
            OooO0O0(ooo00o);
            this.OooO00o.extraInfo.put(o0OO000o.o00O00Oo, "2");
            if (!z) {
                ooooO000.OooO0O0(ooooO000.OooO0OO, ooooO000.OooO0OO("j2"));
                return;
            }
            ooooO000.OooO0O0(ooooO000.OooO0OO, ooooO000.OooO0OO("j1"));
            this.OooO00o.extraInfo.put(o0OO000o.o00O00Oo, "1");
            OooO0OO(ooo00o);
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    public void OooO0o0() {
        try {
            this.OooO0OO.OooOOO0.OooOoO0 = false;
            OooO00o(this.OooO0o0);
            this.OooO0o0 = null;
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }
}
