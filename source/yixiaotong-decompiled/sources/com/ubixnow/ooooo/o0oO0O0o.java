package com.ubixnow.ooooo;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o0oO0O0o {
    private static boolean OooO = false;
    private static String OooO00o = "------UMNWindow";
    private static View OooO0O0 = null;
    private static int OooO0OO = 0;
    private static int OooO0Oo = 0;
    private static int OooO0o = 1;
    private static int OooO0o0 = 1;
    private static int OooO0oO;
    private static int OooO0oo;

    public class OooO00o implements Runnable {
        public final /* synthetic */ ViewGroup OooO00o;
        public final /* synthetic */ String OooO0O0;
        public final /* synthetic */ oo00o OooO0OO;
        public final /* synthetic */ Activity OooO0Oo;

        public OooO00o(ViewGroup viewGroup, String str, oo00o oo00oVar, Activity activity) {
            this.OooO00o = viewGroup;
            this.OooO0O0 = str;
            this.OooO0OO = oo00oVar;
            this.OooO0Oo = activity;
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
                o0OO0O0 o0oo0o0 = new o0OO0O0();
                o0oo0.OooOO0o = oooO;
                o0oo0o0.OooO00o(o0oo0, this.OooO0Oo);
            } catch (Exception e) {
                ooooO000.OooO00o(e);
            }
        }
    }

    public class OooO0O0 implements View.OnTouchListener {
        public final /* synthetic */ View OooO00o;

        public OooO0O0(View view) {
            this.OooO00o = view;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            o0oO0O0o.OooO0OO(this.OooO00o);
            ooooO000.OooO0O0("-------onTouch", o0oO0O0o.OooO0o0 + " ---isClick: " + o0oO0O0o.OooO + this.OooO00o.getClass().getSimpleName() + " pl:" + ((View) this.OooO00o.getParent()).getLeft() + " rawy" + motionEvent.getRawY() + " pt:" + (o0oO0O0o.OooO0oO + this.OooO00o.getTop() + this.OooO00o.getMeasuredHeight()) + "rawx: " + motionEvent.getRawX() + " left:" + (o0oO0O0o.OooO0oo + this.OooO00o.getLeft() + this.OooO00o.getMeasuredWidth()));
            return !o0oO0O0o.OooO;
        }
    }

    public class OooO0OO implements View.OnTouchListener {
        public final /* synthetic */ HashMap OooO00o;
        public final /* synthetic */ int OooO0O0;
        public final /* synthetic */ int OooO0OO;

        public class OooO00o implements Runnable {
            public OooO00o() {
            }

            @Override // java.lang.Runnable
            public void run() {
                View view = o0oO0O0o.OooO0O0;
                OooO0OO oooO0OO = OooO0OO.this;
                o0oO0O0o.OooO0O0(view, oooO0OO.OooO0O0, oooO0OO.OooO0OO, oooO0OO.OooO00o);
            }
        }

        public OooO0OO(HashMap map, int i, int i2) {
            this.OooO00o = map;
            this.OooO0O0 = i;
            this.OooO0OO = i2;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            ooooO000.OooO0O0("-------onTouch", "-----isClick: " + o0oO0O0o.OooO + o0oO0O0o.OooO0O0.getClass());
            if (motionEvent.getAction() != 1) {
                return !o0oO0O0o.OooO;
            }
            if (o0oO0O0o.OooO) {
                return false;
            }
            this.OooO00o.put(o0OO000o.o00O00, motionEvent.getRawX() + "_" + motionEvent.getRawY());
            new Handler(Looper.getMainLooper()).postDelayed(new OooO00o(), 300L);
            boolean unused = o0oO0O0o.OooO = true;
            return true;
        }
    }

    public class OooO0o implements Runnable {
        public final /* synthetic */ long[] OooO00o;
        public final /* synthetic */ int OooO0O0;
        public final /* synthetic */ int[] OooO0OO;
        public final /* synthetic */ int[] OooO0Oo;
        public final /* synthetic */ View OooO0o0;

        public OooO0o(long[] jArr, int i, int[] iArr, int[] iArr2, View view) {
            this.OooO00o = jArr;
            this.OooO0O0 = i;
            this.OooO0OO = iArr;
            this.OooO0Oo = iArr2;
            this.OooO0o0 = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            long[] jArr = this.OooO00o;
            jArr[0] = jArr[0] + 5 + ((long) this.OooO0O0);
            int[] iArr = this.OooO0OO;
            iArr[0] = iArr[0] + new Random().nextInt(20);
            int[] iArr2 = this.OooO0Oo;
            iArr2[0] = iArr2[0] + new Random().nextInt(20);
            long j = this.OooO00o[0];
            MotionEvent motionEventObtain = MotionEvent.obtain(j, j, 1, this.OooO0OO[0], this.OooO0Oo[0], 0);
            this.OooO0o0.dispatchTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
        }
    }

    public static Object OooO() {
        try {
            return OooOO0().getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e) {
            ooooO000.OooO0O0(OooO00o, "----getWindowManager e " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static List<View> OooO00o(int i, int i2, int i3, int i4, HashMap<String, String> map) {
        Object obj;
        OooO0OO = i4;
        OooO0Oo = i;
        OooO();
        ArrayList arrayList = new ArrayList();
        try {
            List list = (List) OooO0oo().get(OooO());
            arrayList.addAll(list);
            for (int i5 = 0; i5 < list.size(); i5++) {
                if (i5 == list.size() - 1) {
                    OooO = false;
                    int i6 = OooO0OO;
                    if (i6 == 0) {
                        if (OooO0Oo != 4) {
                            OooO0O0((View) list.get(i5), i2, i3, map);
                        } else {
                            obj = list.get(i5);
                            OooO00o((View) obj, 0, i2, i3, map);
                        }
                    } else if (i6 == 1) {
                        OooO0O0 = (View) list.get(i5);
                        obj = list.get(i5);
                        OooO00o((View) obj, 0, i2, i3, map);
                    }
                }
            }
        } catch (Exception e) {
            ooooO000.OooO0O0(OooO00o, "-------getViews e " + e.getMessage());
            e.printStackTrace();
        }
        return arrayList;
    }

    public static void OooO00o(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        decorView.getWindowToken();
        ooooO000.OooO0O0("------decorView", "-----decorView " + decorView.getClass());
    }

    /* JADX WARN: Code duplicated, block: B:57:0x0194 A[Catch: Exception -> 0x01a1, TryCatch #0 {Exception -> 0x01a1, blocks: (B:2:0x0000, B:4:0x0018, B:6:0x001e, B:8:0x0024, B:10:0x002f, B:12:0x003b, B:14:0x0047, B:16:0x0053, B:19:0x0061, B:21:0x006d, B:23:0x0079, B:38:0x010a, B:40:0x0115, B:42:0x0121, B:44:0x0139, B:47:0x0152, B:49:0x0169, B:50:0x016e, B:54:0x018e, B:57:0x0194, B:51:0x0173, B:53:0x0188, B:25:0x0084, B:27:0x0090, B:29:0x00a8, B:31:0x00c0, B:33:0x00d8, B:35:0x00f0, B:58:0x019d), top: B:63:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:67:? A[RETURN, SYNTHETIC] */
    public static void OooO00o(Activity activity, oo00o oo00oVar) {
        ViewGroup viewGroup;
        int size;
        try {
            List list = (List) OooO0oo().get(OooO());
            String str = oo00oVar.getBaseAdConfig().OooOOO0.Oooo0oO;
            if (list == null || TextUtils.isEmpty(str) || list.size() <= 0) {
                return;
            }
            if (oo00oVar.getBaseAdConfig().OooO00o.OooO0OO != 6 && oo00oVar.getBaseAdConfig().OooO00o.OooO0OO != 28 && oo00oVar.getBaseAdConfig().OooO00o.OooO0OO != 29 && oo00oVar.getBaseAdConfig().OooO00o.OooO0OO != 35 && oo00oVar.getBaseAdConfig().OooO00o.OooO0OO != 24 && (((oo00oVar.getBaseAdConfig().OooO00o.OooO0OO != 1 && oo00oVar.getBaseAdConfig().OooO00o.OooO0OO != 17 && oo00oVar.getBaseAdConfig().OooO00o.OooO0OO != 3) || o0O0O0O.OooO00o.OooO00o().size() <= 0 || (!o0O0O0O.OooO00o.OooO00o().get(0).getLocalClassName().contains("Stub_Standard_Portrait_Activity") && !o0O0O0O.OooO00o.OooO00o().get(0).getLocalClassName().contains("Stub_Standard_Landscape_Activity") && !o0O0O0O.OooO00o.OooO00o().get(0).getLocalClassName().contains("TTFullScreenVideoActivity") && !o0O0O0O.OooO00o.OooO00o().get(0).getLocalClassName().contains("TTFullScreenVideoLandscapeActivity") && !o0O0O0O.OooO00o.OooO00o().get(0).getLocalClassName().contains("app.FeedDownloadActivity"))) && (oo00oVar.getBaseAdConfig().OooO00o.OooO0OO != 2 || o0O0O0O.OooO00o.OooO00o().isEmpty() || (!o0O0O0O.OooO00o.OooO00o().get(0).getLocalClassName().contains("PortraitADActivity") && !o0O0O0O.OooO00o.OooO00o().get(0).getLocalClassName().contains("LandscapeADActivity"))))) {
                if (((WindowManager.LayoutParams) ((View) list.get(list.size() - 1)).getLayoutParams()).type == 2005) {
                    if (((WindowManager.LayoutParams) ((View) list.get(list.size() - 2)).getLayoutParams()).type != 2005) {
                        size = list.size() - 2;
                    } else {
                        viewGroup = null;
                    }
                    if (viewGroup != null) {
                        viewGroup.post(new OooO00o(viewGroup, str, oo00oVar, activity));
                        return;
                    }
                    return;
                }
                size = list.size() - 1;
                viewGroup = (ViewGroup) list.get(size);
                if (viewGroup != null) {
                    viewGroup.post(new OooO00o(viewGroup, str, oo00oVar, activity));
                    return;
                }
                return;
            }
            o0O0O0O.OooO00o(oo00oVar);
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    public static void OooO00o(View view, int i, int i2, int i3, HashMap<String, String> map) {
        if (!(view instanceof ViewGroup)) {
            if (view.getWidth() > 200 && OooO0Oo == 4) {
                if (OooO0OO == 0) {
                    OooO0O0(view, i2, i3, map);
                } else {
                    OooO0O0 = view;
                    ooooO000.OooO0O0("-------onTouch", "----JD--img-getWidth: " + view.getWidth() + OooO0O0.getClass());
                }
            }
            if (view.getHeight() >= 120 || OooO0OO != 1) {
                return;
            }
            view.setOnTouchListener(new OooO0OO(map, i2, i3));
            return;
        }
        int i4 = i + 1;
        int i5 = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i5 >= viewGroup.getChildCount()) {
                return;
            }
            OooO00o(viewGroup.getChildAt(i5), i4, i2, i3, map);
            i5++;
        }
    }

    public static void OooO0O0(Activity activity) {
        try {
            List list = (List) OooO0oo().get(OooO());
            ooooO000.OooO0O0("-------windowViews ", "size: " + list.size());
            if (list.size() <= 0 || list.get(list.size() - 1) == activity.getWindow().getDecorView()) {
                return;
            }
            activity.getWindowManager().removeView((View) list.get(list.size() - 1));
        } catch (Exception unused) {
        }
    }

    public static void OooO0O0(View view) {
        if (!(view instanceof ViewGroup)) {
            if (view.getHeight() < 120) {
                view.setOnTouchListener(new OooO0O0(view));
            }
        } else {
            OooO0o0++;
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i >= viewGroup.getChildCount()) {
                    return;
                }
                OooO0O0(viewGroup.getChildAt(i));
                i++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void OooO0O0(View view, int i, int i2, HashMap<String, String> map) {
        long[] jArr = {SystemClock.uptimeMillis()};
        int[] iArr = {i};
        int[] iArr2 = {i2};
        map.put(o0OO000o.o00O00Oo, "1");
        ooooO000.OooO0O0(OooO00o, "-------getViews dispatchTE x " + iArr[0] + " Y:" + iArr2[0]);
        long j = jArr[0];
        MotionEvent motionEventObtain = MotionEvent.obtain(j, j, 0, iArr[0], iArr2[0], 0);
        view.dispatchTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
        int iNextInt = new Random().nextInt(25) + 5;
        ooooO000.OooO0O0(OooO00o, "------timeRandom: " + iNextInt);
        new Handler(Looper.getMainLooper()).postDelayed(new OooO0o(jArr, iNextInt, iArr, iArr2, view), iNextInt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int OooO0OO(View view) {
        if (view.getParent() != null && (view.getParent() instanceof View)) {
            OooO0o++;
            OooO0OO((View) view.getParent());
            OooO0oO += ((View) view.getParent()).getTop();
            OooO0oo += ((View) view.getParent()).getTop();
        }
        return OooO0o;
    }

    private void OooO0o() {
        try {
            ArrayList arrayList = (ArrayList) OooO0oO().get(OooO());
            for (int i = 0; i < arrayList.size(); i++) {
                ooooO000.OooO0O0(OooO00o, "---paramsArrayList token: " + ((WindowManager.LayoutParams) arrayList.get(i)).token.toString());
            }
            ooooO000.OooO0O0(OooO00o, "---paramsArrayList " + arrayList.size());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static Field OooO0oO() {
        try {
            Field declaredField = OooOO0().getDeclaredField("mParams");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Field OooO0oo() {
        try {
            Field declaredField = OooOO0().getDeclaredField("mViews");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Class OooOO0() {
        try {
            return Class.forName("android.view.WindowManagerGlobal");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
