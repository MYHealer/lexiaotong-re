package com.ubixnow.ooooo;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.ubixnow.core.common.ui.UMNRelativeLayout;
import com.ubixnow.utils.BaseUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Random;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class o00OO00O extends o00O {
    private oo00o absUbixInfo;
    private oOO00O confi;
    private o00OOOOo container;
    private WeakReference<Context> contextWeakReference;
    private boolean isJdShakeValid;
    private int[] result;
    private int screenX;
    private int screenY;
    private HashMap<String, String> trackingExtraInfo = new HashMap<>();

    public class OooO00o implements oOO0000.OooO00o {
        public final /* synthetic */ oOO0000 OooO00o;

        public OooO00o(oOO0000 ooo0000) {
            this.OooO00o = ooo0000;
        }

        @Override // com.ubixnow.ooooo.oOO0000.OooO00o
        public void OooO00o() {
            try {
                if (o00OO00O.this.contextWeakReference != null && o00OO00O.this.contextWeakReference.get() != null && (o00OO00O.this.contextWeakReference.get() instanceof Activity) && !((Activity) o00OO00O.this.contextWeakReference.get()).isFinishing()) {
                    o00OO00O.this.performClick();
                }
                this.OooO00o.OooO0O0();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class OooO0O0 implements UMNRelativeLayout.OooO00o {
        public final /* synthetic */ oOO0000 OooO00o;

        public OooO0O0(oOO0000 ooo0000) {
            this.OooO00o = ooo0000;
        }

        @Override // com.ubixnow.core.common.ui.UMNRelativeLayout.OooO00o
        public void visibleChange(boolean z) {
            if (z) {
                return;
            }
            this.OooO00o.OooO0O0();
        }
    }

    public class OooO0OO implements Runnable {
        public final /* synthetic */ oOO0000 OooO00o;

        public OooO0OO(oOO0000 ooo0000) {
            this.OooO00o = ooo0000;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.OooO00o.OooO0O0();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class OooO0o implements o00O0OO {
        public final /* synthetic */ oOO00O OooO00o;
        public final /* synthetic */ o00OOOOo OooO0O0;

        public OooO0o(oOO00O ooo00o, o00OOOOo o00ooooo) {
            this.OooO00o = ooo00o;
            this.OooO0O0 = o00ooooo;
        }

        @Override // com.ubixnow.ooooo.o00O0OO
        public boolean OooO00o(MotionEvent motionEvent, View view) {
            o00OO00O o00oo00o;
            oOO00O ooo00o;
            o00OOOOo o00ooooo;
            float f;
            int i;
            oOO00O ooo00o2 = this.OooO00o;
            if (!ooo00o2.OooOoO0) {
                o00OO00O.this.absUbixInfo.extraInfo.put(o0OO000o.o00O00Oo, "2");
                return false;
            }
            if (ooo00o2.OooOOo == 1 && o00OO00O.this.isInSkipRegion(ooo00o2, motionEvent.getRawX(), motionEvent.getRawY())) {
                return false;
            }
            if (o00OO00O.this.result != null) {
                o00oo00o = o00OO00O.this;
                ooo00o = this.OooO00o;
                o00ooooo = this.OooO0O0;
                f = o00oo00o.result[0];
                i = o00OO00O.this.result[1];
            } else {
                o00OO00O o00oo00o2 = o00OO00O.this;
                o00oo00o2.result = o00oo00o2.calculateRegion(this.OooO00o.OooOo0o.get(0).intValue(), this.OooO00o.OooOo0o.get(1).intValue(), this.OooO00o.OooOo0o.get(2).intValue(), this.OooO00o.OooOo0o.get(3).intValue());
                if (o00OO00O.this.result == null || o00OO00O.this.result[0] <= 0 || o00OO00O.this.result[1] <= 0) {
                    return false;
                }
                o00oo00o = o00OO00O.this;
                ooo00o = this.OooO00o;
                o00ooooo = this.OooO0O0;
                f = o00oo00o.result[0];
                i = o00OO00O.this.result[1];
            }
            return o00oo00o.setClickRegion(ooo00o, o00ooooo, motionEvent, f, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] calculateRegion(int i, int i2, int i3, int i4) {
        try {
            if (i >= i2 || i < 0 || i2 > 360) {
                showLog(ooooO000.OooO0OO, ooooO000.OooO0OO("j7"));
                return null;
            }
            if (i3 >= i4 || i3 < 0 || i4 > 640) {
                showLog(ooooO000.OooO0OO, ooooO000.OooO0OO("j8"));
                return null;
            }
            int i5 = this.screenX;
            float f = (i * i5) / 360.0f;
            float f2 = (i5 * i2) / 360.0f;
            int i6 = this.screenY;
            float f3 = (i3 * i6) / 640.0f;
            float f4 = (i6 * i4) / 640.0f;
            float f5 = f4 - f3;
            int iNextInt = new Random().nextInt((int) (f2 - f)) + ((int) f);
            int iNextInt2 = new Random().nextInt((int) f5) + ((int) f3);
            ooooO000.OooO0O0(ooooO000.OooO0OO, " yStart " + f3 + " yend " + f4 + " yresult " + iNextInt2 + " yscope " + f5 + " y " + this.screenY);
            return new int[]{iNextInt, iNextInt2};
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void handleCtrTracking() {
        oo00o oo00oVar = this.absUbixInfo;
        if (oo00oVar != null) {
            oo00oVar.adType = "1";
            oo00oVar.extraInfo = new HashMap<>();
            this.absUbixInfo.extraInfo.put(oo00o.trackingExtraInfo, this.trackingExtraInfo);
        }
    }

    private void handleTrackingCtrInfo(oOO00O ooo00o) {
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

    private void handleViewGroup(o00OOOOo o00ooooo, oOO00O ooo00o) {
        try {
            if (o00ooooo.OooO0O0() != null) {
                ((UMNRelativeLayout) o00ooooo.OooO0OO()).setDispatchListener(new OooO0o(ooo00o, o00ooooo));
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInSkipRegion(oOO00O ooo00o, float f, float f2) {
        float fIntValue = (this.screenX * ooo00o.OooOo.get(0).intValue()) / 360.0f;
        float fIntValue2 = (this.screenX * ooo00o.OooOo.get(1).intValue()) / 360.0f;
        float fIntValue3 = (this.screenY * ooo00o.OooOo.get(2).intValue()) / 640.0f;
        float fIntValue4 = (this.screenY * ooo00o.OooOo.get(3).intValue()) / 640.0f;
        if (f <= fIntValue || f >= fIntValue2 || f2 <= fIntValue3 || f2 >= fIntValue4) {
            return false;
        }
        ooooO000.OooO0O0(ooooO000.OooO0OO, ooooO000.OooO0OO("j6") + fIntValue + ", " + fIntValue2 + ", " + fIntValue3 + ", " + fIntValue4);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:16:0x0061 A[Catch: Exception -> 0x00ae, TryCatch #1 {Exception -> 0x00ae, blocks: (B:7:0x0013, B:10:0x001f, B:15:0x0048, B:16:0x0061, B:18:0x006f, B:22:0x0078, B:23:0x009c), top: B:34:0x0013 }] */
    public boolean setClickRegion(oOO00O ooo00o, o00OOOOo o00ooooo, MotionEvent motionEvent, float f, float f2) {
        if (o00ooooo != null) {
            try {
                ViewGroup viewGroupOooO0O0 = o00ooooo.OooO0O0();
                long jUptimeMillis = SystemClock.uptimeMillis();
                if (viewGroupOooO0O0 != null) {
                    try {
                        if (this.mBaseAdConfig.OooO00o.OooO0OO != 2) {
                            int action = motionEvent.getAction();
                            if (action == 0) {
                                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, f, f2, 0);
                                viewGroupOooO0O0.dispatchTouchEvent(motionEventObtain);
                                motionEventObtain.recycle();
                            } else if (action == 1) {
                                long j = jUptimeMillis + 500;
                                MotionEvent motionEventObtain2 = MotionEvent.obtain(j, j, 1, f, f2, 0);
                                viewGroupOooO0O0.dispatchTouchEvent(motionEventObtain2);
                                motionEventObtain2.recycle();
                                ooo00o.OooOoO0 = false;
                                ooooO000.OooO0OO(ooooO000.OooO0OO, ooooO000.OooO0OO("j9"));
                            }
                            return true;
                        }
                        float fNextInt = (f + new Random().nextInt(10)) - 5.0f;
                        float fNextInt2 = (f2 + new Random().nextInt(10)) - 5.0f;
                        int action2 = motionEvent.getAction();
                        if (action2 == 0) {
                            motionEvent.setLocation(fNextInt, fNextInt2);
                            MotionEvent motionEventObtain3 = MotionEvent.obtain(motionEvent);
                            viewGroupOooO0O0.dispatchTouchEvent(motionEventObtain3);
                            motionEventObtain3.recycle();
                        } else if (action2 == 1) {
                            motionEvent.setLocation(fNextInt, fNextInt2);
                            MotionEvent motionEventObtain4 = MotionEvent.obtain(motionEvent);
                            viewGroupOooO0O0.dispatchTouchEvent(motionEventObtain4);
                            motionEventObtain4.recycle();
                            ooo00o.OooOoO0 = false;
                            ooooO000.OooO0OO(ooooO000.OooO0OO, ooooO000.OooO0OO("j9"));
                        } else if (action2 == 2) {
                            motionEvent.setLocation(fNextInt, fNextInt2);
                            MotionEvent motionEventObtain5 = MotionEvent.obtain(motionEvent);
                            viewGroupOooO0O0.dispatchTouchEvent(motionEventObtain5);
                            motionEventObtain5.recycle();
                        }
                        return true;
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        return false;
                    }
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
        return false;
    }

    @Override // com.ubixnow.ooooo.o00O
    public abstract void destory();

    public void handle(o00OOOOo o00ooooo) {
        o00O000 o00o000 = this.mBaseAdConfig;
        oOO00O ooo00o = o00o000.OooOOO0;
        boolean zOooO00o = o0O0OOOo.OooO00o(o00o000.OooO00o, ooo00o);
        this.isJdShakeValid = o0O0OOOo.OooO0O0(this.mBaseAdConfig.OooO00o, ooo00o);
        handleTrackingCtrInfo(ooo00o);
        this.absUbixInfo.extraInfo.put(o0OO000o.o00O00Oo, "2");
        if (zOooO00o) {
            showLog(ooooO000.OooO0OO, ooooO000.OooO0OO("j1"));
            this.absUbixInfo.extraInfo.put(o0OO000o.o00O00Oo, "1");
            handleViewGroup(o00ooooo, ooo00o);
        } else if (!this.isJdShakeValid) {
            showLog(ooooO000.OooO0OO, ooooO000.OooO0OO("j2"));
        } else {
            this.confi = ooo00o;
            this.container = o00ooooo;
        }
    }

    public void handleJdShake() {
        if (this.isJdShakeValid) {
            showLog(ooooO000.OooO0OO, ooooO000.OooO0OO("j5"));
            this.absUbixInfo.extraInfo.put(o0OO000o.o00O00Oo, "1");
            oOO0000 ooo0000 = new oOO0000(BaseUtils.getContext(), this.confi.OooOoo);
            ooo0000.OooO00o(new OooO00o(ooo0000));
            UMNRelativeLayout uMNRelativeLayout = (UMNRelativeLayout) this.container.OooO0OO();
            if (uMNRelativeLayout != null) {
                uMNRelativeLayout.setVisibleChangeListener(new OooO0O0(ooo0000));
            }
            BaseUtils.postDelayed(new OooO0OO(ooo0000), 4000L);
        }
    }

    @Override // com.ubixnow.ooooo.o00O
    public void innerLoad(Context context, o00O000 o00o000, Object... objArr) {
        super.innerLoad(context, o00o000, objArr);
        this.absUbixInfo = getUbixInfo();
        this.screenX = oOO00000.OooO0o(context);
        this.screenY = oOO00000.OooO0OO(context);
        this.contextWeakReference = new WeakReference<>(context);
        loadSplashAd(context, o00o000);
        handleCtrTracking();
    }

    @Override // com.ubixnow.ooooo.o00O
    public void loadCustomAd(Context context, o00O000 o00o000, Object... objArr) {
    }

    public abstract void loadSplashAd(Context context, o00O000 o00o000);

    public void performClick() {
    }

    public abstract void show(ViewGroup viewGroup);
}
