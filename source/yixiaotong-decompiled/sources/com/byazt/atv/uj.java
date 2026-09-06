package com.byazt.atv;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import com.byazt.cd.i;
import com.byazt.cd.x;
import com.byazt.ete.ic;
import com.byazt.ete.pu;
import com.byazt.omf.gt;
import com.byazt.pm.sl;
import com.byazt.pm.u;
import com.byazt.pm.yp;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.openalliance.ad.constant.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 134, 15})
public class uj {

    /* JADX INFO: renamed from: com.byazt.atv.uj$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 134, z.k})
    static /* synthetic */ class AnonymousClass1 {
    }

    public static void c(ic icVar, com.byazt.sz.z zVar, int i, AtomicBoolean atomicBoolean) {
        if (icVar == null || zVar == null || i != 1) {
            return;
        }
        JSONObject jSONObjectU = pu.u(icVar);
        int iOptInt = 0;
        if (jSONObjectU != null) {
            try {
                iOptInt = jSONObjectU.optInt("tap_min_duration_threshold", 0);
            } catch (Exception unused) {
            }
        }
        if (iOptInt <= 0) {
            return;
        }
        zVar.c(new tt(iOptInt, atomicBoolean));
    }

    @com.byazt.zqa.c(c = {0, 1, 134, 153})
    public static class tt implements i.c, yp {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.byazt.ji.tt f1989a;
        public float c;
        public final Handler i = new i(Looper.getMainLooper(), this);
        public com.byazt.xj.ve n;
        public sl sp;
        public float tt;
        public final int uj;
        public boolean ve;
        public final AtomicBoolean x;

        public tt(int i, AtomicBoolean atomicBoolean) {
            this.uj = i;
            this.x = atomicBoolean;
        }

        @Override // com.byazt.pm.yp
        public boolean c(com.byazt.xj.ve veVar, MotionEvent motionEvent, sl slVar, com.byazt.ji.tt ttVar) {
            boolean z;
            com.byazt.pm.a aVarDa = ttVar.da();
            if (aVarDa == null || aVarDa.tt().isEmpty()) {
                z = false;
            } else {
                Iterator<com.byazt.pm.a.c> it = aVarDa.tt().iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next().tt(), "convert")) {
                        z = true;
                    }
                }
                z = false;
            }
            return c(veVar, motionEvent, ttVar, slVar, z);
        }

        /* JADX WARN: Code duplicated, block: B:21:0x0057  */
        /* JADX WARN: Code duplicated, block: B:23:0x0066  */
        /* JADX WARN: Code duplicated, block: B:25:0x006d  */
        public boolean c(com.byazt.xj.ve veVar, MotionEvent motionEvent, com.byazt.ji.tt ttVar, sl slVar, boolean z) {
            int i;
            float rawX;
            int action = motionEvent.getAction();
            if (action == 0) {
                this.x.set(false);
                this.c = motionEvent.getRawX();
                this.tt = motionEvent.getRawY();
                this.n = veVar;
                this.f1989a = ttVar;
                this.sp = slVar;
                if (z && (i = this.uj) > 0) {
                    this.i.sendEmptyMessageDelayed(1, i);
                }
            } else if (action == 1) {
                this.i.removeMessages(1);
                this.n = null;
                this.f1989a = null;
                this.sp = null;
                if (this.ve) {
                    this.ve = false;
                    this.c = 0.0f;
                    this.tt = 0.0f;
                    return false;
                }
                rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (Math.abs(rawX - this.c) < 15.0f || Math.abs(rawY - this.tt) >= 15.0f) {
                    this.ve = false;
                    return false;
                }
                if (!this.x.get()) {
                    this.x.set(true);
                    if (slVar != null) {
                        slVar.c(veVar, ttVar.sp(), ttVar.da().tt(), this.f1989a.da());
                        this.c = 0.0f;
                        this.tt = 0.0f;
                        return true;
                    }
                }
            } else if (action == 2) {
                float rawX2 = motionEvent.getRawX();
                float rawY2 = motionEvent.getRawY();
                if (Math.abs(rawX2 - this.c) >= 15.0f || Math.abs(rawY2 - this.tt) >= 15.0f) {
                    this.ve = true;
                }
            } else if (action == 3) {
                this.ve = false;
                float rawX3 = motionEvent.getRawX();
                if (motionEvent.getRawY() == 0.0f && rawX3 == 0.0f) {
                    this.i.removeMessages(1);
                    this.n = null;
                    this.f1989a = null;
                    this.sp = null;
                } else {
                    this.i.removeMessages(1);
                    this.n = null;
                    this.f1989a = null;
                    this.sp = null;
                    if (this.ve) {
                        this.ve = false;
                        this.c = 0.0f;
                        this.tt = 0.0f;
                        return false;
                    }
                    rawX = motionEvent.getRawX();
                    float rawY3 = motionEvent.getRawY();
                    if (Math.abs(rawX - this.c) < 15.0f) {
                    }
                    this.ve = false;
                    return false;
                }
            }
            return true;
        }

        @Override // com.byazt.cd.i.c
        public void c(Message message) {
            if (this.sp == null || this.n == null || this.f1989a == null || this.ve) {
                return;
            }
            if (!this.x.get()) {
                this.x.set(true);
                this.sp.c(this.n, this.f1989a.sp(), this.f1989a.da().tt(), this.f1989a.da());
            }
            this.n = null;
            this.f1989a = null;
            this.sp = null;
        }
    }

    public static void tt(ic icVar, com.byazt.sz.z zVar, int i, AtomicBoolean atomicBoolean) {
        int iOptInt;
        boolean zTw;
        if (icVar == null || zVar == null) {
            return;
        }
        JSONObject jSONObjectU = pu.u(icVar);
        int i2 = -1;
        if (jSONObjectU == null || i != 1) {
            iOptInt = -1;
        } else {
            try {
                int iOptInt2 = jSONObjectU.optInt("slide_ignore_up", -1);
                try {
                    iOptInt = jSONObjectU.optInt("slide_min_threshold", -1);
                    i2 = iOptInt2;
                } catch (Exception unused) {
                    iOptInt = -1;
                    i2 = iOptInt2;
                    zTw = false;
                    zVar.c(new c(i2, iOptInt, zTw, atomicBoolean));
                }
            } catch (Exception unused2) {
                iOptInt = -1;
            }
        }
        try {
            zTw = gt.tt().tw();
        } catch (Exception unused3) {
            zTw = false;
        }
        zVar.c(new c(i2, iOptInt, zTw, atomicBoolean));
    }

    @com.byazt.zqa.c(c = {0, 1, 134, AppTypeIdUtil.NewDevice4GBathOTA})
    public static class c implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1987a;
        public float c;
        public int n;
        public boolean sp;
        public float tt;
        public final AtomicBoolean ve;
        public final Map<String, ve> uj = new HashMap();
        public boolean x = true;

        private void c() {
            this.c = 0.0f;
            this.tt = 0.0f;
        }

        /* JADX INFO: renamed from: com.byazt.atv.uj$c$c, reason: collision with other inner class name */
        @com.byazt.zqa.c(c = {0, 1, 134, MediaPlayer.MEDIA_PLAYER_OPTION_AE_TAR_LUFS})
        private static class C0095c {
            public final int c;
            public final boolean n;
            public final AtomicInteger tt;
            public final String uj;
            public final int ve;

            /* JADX INFO: Access modifiers changed from: private */
            public int c() {
                return this.c;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean n() {
                return this.n;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public AtomicInteger tt() {
                return this.tt;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public String uj() {
                return this.uj;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public int ve() {
                return this.ve;
            }

            public C0095c(String str, int i, AtomicInteger atomicInteger, int i2, boolean z) {
                this.uj = str;
                this.c = i;
                this.tt = atomicInteger;
                this.ve = i2;
                this.n = z;
            }
        }

        @com.byazt.zqa.c(c = {0, 1, 134, MediaPlayer.MEDIA_PLAYER_OPTION_ROTATION})
        private static class ve {
            public float c;
            public float tt;
            public boolean ve;

            /* JADX INFO: Access modifiers changed from: private */
            public float c() {
                return this.c;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void c(float f, float f2) {
                this.c = f;
                this.tt = f2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public float tt() {
                return this.tt;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void uj() {
                this.ve = true;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean ve() {
                return this.ve;
            }

            private ve() {
            }

            public /* synthetic */ ve(AnonymousClass1 anonymousClass1) {
                this();
            }
        }

        @com.byazt.zqa.c(c = {0, 1, 134, 570})
        private static class tt {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final C0095c f1988a;
            public final com.byazt.xj.ve c;
            public final boolean n;
            public final MotionEvent tt;
            public final sl uj;
            public final com.byazt.ji.tt ve;

            /* JADX INFO: Access modifiers changed from: private */
            public C0095c a() {
                return this.f1988a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public com.byazt.xj.ve c() {
                return this.c;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean n() {
                return this.n;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean sp() {
                return this.uj != null;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public MotionEvent tt() {
                return this.tt;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public sl uj() {
                return this.uj;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public com.byazt.ji.tt ve() {
                return this.ve;
            }

            public tt(com.byazt.xj.ve veVar, MotionEvent motionEvent, com.byazt.ji.tt ttVar, sl slVar, boolean z, C0095c c0095c) {
                this.c = veVar;
                this.tt = motionEvent;
                this.ve = ttVar;
                this.uj = slVar;
                this.n = z;
                this.f1988a = c0095c;
            }
        }

        public c(int i, int i2, boolean z, AtomicBoolean atomicBoolean) {
            this.n = i;
            this.f1987a = i2;
            this.sp = z;
            this.ve = atomicBoolean;
        }

        @Override // com.byazt.pm.u
        public void c(String str, Object obj) {
            try {
                if (str.hashCode() == 2001723438 && str.equals("lastEventInView")) {
                    this.x = ((Boolean) obj).booleanValue();
                }
            } catch (Exception unused) {
            }
        }

        @Override // com.byazt.pm.u
        public boolean c(com.byazt.xj.ve veVar, MotionEvent motionEvent, sl slVar, com.byazt.ji.tt ttVar, String str, int i, AtomicInteger atomicInteger, int i2, boolean z) {
            boolean z2;
            C0095c c0095c = new C0095c(str, i, atomicInteger, i2, z);
            com.byazt.pm.a aVarDa = ttVar.da();
            if (aVarDa != null && !aVarDa.tt().isEmpty()) {
                Iterator<com.byazt.pm.a.c> it = aVarDa.tt().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z2 = false;
                        break;
                    }
                    if (TextUtils.equals(it.next().tt(), "convert")) {
                        z2 = true;
                        break;
                    }
                }
            } else {
                z2 = false;
                break;
            }
            return c(new tt(veVar, motionEvent, ttVar, slVar, z2 && this.n == 1, c0095c));
        }

        private String c(int i, com.byazt.ji.tt ttVar) {
            return i + "_" + System.identityHashCode(ttVar);
        }

        private boolean tt(tt ttVar) {
            MotionEvent motionEventTt = ttVar.tt();
            int actionMasked = motionEventTt.getActionMasked();
            int actionIndex = motionEventTt.getActionIndex();
            int pointerId = motionEventTt.getPointerId(actionIndex);
            String strC = c(pointerId, ttVar.ve());
            motionEventTt.getPointerCount();
            if (actionMasked == 0) {
                this.ve.set(false);
            } else {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        return ve(ttVar);
                    }
                    if (actionMasked == 3) {
                        this.uj.clear();
                        return true;
                    }
                    if (actionMasked != 5) {
                        if (actionMasked != 6) {
                            return true;
                        }
                    }
                }
                return c(ttVar, actionIndex, pointerId, strC);
            }
            c(motionEventTt, actionIndex, strC);
            return true;
        }

        private void c(MotionEvent motionEvent, int i, String str) {
            ve veVar = new ve(null);
            veVar.c(motionEvent.getX(i), motionEvent.getY(i));
            this.uj.put(str, veVar);
        }

        private boolean ve(tt ttVar) {
            MotionEvent motionEventTt = ttVar.tt();
            for (int i = 0; i < motionEventTt.getPointerCount(); i++) {
                int pointerId = motionEventTt.getPointerId(i);
                ve veVar = this.uj.get(c(pointerId, ttVar.ve()));
                if (c(ttVar, veVar) && c(ttVar, veVar, pointerId, i)) {
                    return true;
                }
            }
            return true;
        }

        private boolean c(tt ttVar, ve veVar) {
            return (!ttVar.n() || veVar == null || veVar.ve() || this.ve.get()) ? false : true;
        }

        private boolean c(tt ttVar, ve veVar, int i, int i2) {
            MotionEvent motionEventTt = ttVar.tt();
            float x = motionEventTt.getX(i2);
            float y = motionEventTt.getY(i2);
            if (!c(x, y, veVar.c(), veVar.tt(), ttVar.a())) {
                return false;
            }
            veVar.uj();
            return ttVar.sp() && c(ttVar, x, y);
        }

        private boolean c(tt ttVar, int i, int i2, String str) {
            MotionEvent motionEventTt = ttVar.tt();
            ve veVar = this.uj.get(str);
            if (veVar != null) {
                try {
                    if (!veVar.ve() && !this.ve.get()) {
                        float x = motionEventTt.getX(i);
                        float y = motionEventTt.getY(i);
                        if (ttVar.a().c() != 0 || !c(ttVar, veVar, x, y, "Slide event for pointer " + i2 + ", check limit threshold 0")) {
                            if (c(x, y, veVar.c(), veVar.tt(), ttVar.a())) {
                                c(ttVar, veVar, x, y, (String) null);
                            }
                        }
                    }
                    return true;
                } finally {
                    this.uj.remove(str);
                }
            }
            return false;
        }

        private boolean c(tt ttVar, ve veVar, float f, float f2, String str) {
            if (!ttVar.sp() || veVar.ve() || this.ve.get()) {
                return false;
            }
            TextUtils.isEmpty(str);
            veVar.uj();
            return c(ttVar, f, f2);
        }

        private boolean uj(tt ttVar) {
            MotionEvent motionEventTt = ttVar.tt();
            int action = motionEventTt.getAction();
            if (action == 0) {
                return c(motionEventTt);
            }
            if (action != 1) {
                if (action == 2) {
                    return n(ttVar);
                }
                if (action != 3 || tt(motionEventTt)) {
                    return true;
                }
            }
            return a(ttVar);
        }

        private boolean c(MotionEvent motionEvent) {
            this.ve.set(false);
            this.c = motionEvent.getX();
            this.tt = motionEvent.getY();
            return true;
        }

        private boolean n(tt ttVar) {
            if (ttVar.n() && !this.ve.get()) {
                MotionEvent motionEventTt = ttVar.tt();
                float x = motionEventTt.getX();
                float y = motionEventTt.getY();
                if (c(x, y, this.c, this.tt, ttVar.a()) && ttVar.sp()) {
                    c();
                    return c(ttVar, x, y);
                }
            }
            return true;
        }

        private boolean tt(MotionEvent motionEvent) {
            return motionEvent.getRawY() == 0.0f && motionEvent.getRawX() == 0.0f;
        }

        private boolean a(tt ttVar) {
            if (this.ve.get()) {
                return true;
            }
            MotionEvent motionEventTt = ttVar.tt();
            float x = motionEventTt.getX();
            float y = motionEventTt.getY();
            if (ttVar.a().c() == 0 && c(ttVar, x, y, "Slide event, check limit threshold 0")) {
                return true;
            }
            if (!c(x, y, this.c, this.tt, ttVar.a())) {
                return false;
            }
            c(ttVar, x, y, (String) null);
            return true;
        }

        private boolean c(tt ttVar, float f, float f2, String str) {
            if (!ttVar.sp() || this.ve.get()) {
                return false;
            }
            TextUtils.isEmpty(str);
            c();
            return c(ttVar, f, f2);
        }

        public boolean c(tt ttVar) {
            if (this.sp) {
                return tt(ttVar);
            }
            return uj(ttVar);
        }

        private boolean c(View view, float f, float f2) {
            return f >= 0.0f && f < ((float) view.getWidth()) && f2 >= 0.0f && f2 < ((float) view.getHeight());
        }

        private boolean c(tt ttVar, float f, float f2) {
            C0095c c0095cA = ttVar.a();
            AtomicInteger atomicIntegerTt = c0095cA.tt();
            if ((atomicIntegerTt != null && atomicIntegerTt.get() <= 0) || !c0095cA.n()) {
                return false;
            }
            if (c0095cA.ve() == 1 && (!c(ttVar.c().i(), f, f2) || !this.x)) {
                return false;
            }
            this.ve.set(true);
            ttVar.uj().c(ttVar.c(), ttVar.ve().sp(), ttVar.ve().da().tt(), ttVar.ve().da());
            if (atomicIntegerTt != null && atomicIntegerTt.get() != Integer.MAX_VALUE) {
                atomicIntegerTt.decrementAndGet();
            }
            return true;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:20:0x0054  */
        private boolean c(float f, float f2, float f3, float f4, C0095c c0095c) {
            byte b;
            int iTt = x.tt(gt.getContext(), f - f3);
            int iTt2 = x.tt(gt.getContext(), f2 - f4);
            switch (c0095c.uj()) {
                case "up":
                    b = 0;
                    break;
                case "all":
                    b = 4;
                    break;
                case "down":
                    b = 1;
                    break;
                case "left":
                    b = 2;
                    break;
                case "right":
                    b = 3;
                    break;
                default:
                    b = -1;
                    break;
            }
            if (b == 0) {
                iTt = -iTt2;
            } else if (b == 1) {
                iTt = iTt2;
            } else if (b == 2) {
                iTt = -iTt;
            } else if (b != 3) {
                iTt = (int) Math.abs(Math.sqrt(Math.pow(iTt, 2.0d) + Math.pow(iTt2, 2.0d)));
            }
            int i = this.f1987a;
            if (i >= 0) {
                return iTt >= i;
            }
            return iTt >= c0095c.c();
        }
    }
}
