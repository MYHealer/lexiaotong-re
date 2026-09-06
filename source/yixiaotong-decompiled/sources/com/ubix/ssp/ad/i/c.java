package com.ubix.ssp.ad.i;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import client.android.yixiaotong.sdk.qrcode.decode.DecodeThread;
import com.huawei.hms.ads.ez;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.stub.StubApp;
import com.ubix.ssp.ad.e.a0.s;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.ad.e.a0.v;
import com.ubix.ssp.ad.e.a0.x;
import com.ubix.ssp.open.AdError;
import com.ubix.ssp.open.ParamsReview;
import com.ubix.ssp.open.nativee.NativeAd;
import com.ubix.ssp.open.nativee.UBiXImage;
import com.ubix.ssp.open.nativee.UBiXNativeInteractionListener;
import com.ubix.ssp.open.nativee.UBiXNativeVideoListener;
import com.ubix.ssp.open.nativee.express.UBiXNativeExpressInteractionListener;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c extends com.ubix.ssp.ad.a {
    static ConcurrentHashMap<String, Integer> C = new ConcurrentHashMap<>();
    static ConcurrentHashMap<Integer, List<View.OnAttachStateChangeListener>> D = new ConcurrentHashMap<>();
    private SoftReference<Context> E;
    private com.ubix.ssp.ad.g.g F;
    private ConcurrentHashMap<Integer, HashMap<String, Object>> G;
    private boolean H;

    class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f8979a;
        final /* synthetic */ com.ubix.ssp.ad.d.a b;
        final /* synthetic */ float c;
        final /* synthetic */ UBiXNativeInteractionListener d;

        a(ViewGroup viewGroup, com.ubix.ssp.ad.d.a aVar, float f, UBiXNativeInteractionListener uBiXNativeInteractionListener) {
            this.f8979a = viewGroup;
            this.b = aVar;
            this.c = f;
            this.d = uBiXNativeInteractionListener;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            try {
                this.f8979a.removeOnAttachStateChangeListener(this);
                c.this.a(this.b, this.f8979a, this.c, this.d);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    class b implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.ubix.ssp.ad.d.a f8980a;

        b(com.ubix.ssp.ad.d.a aVar) {
            this.f8980a = aVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            HashMap map = new HashMap();
            HashMap map2 = (HashMap) c.this.G.get(Integer.valueOf(this.f8980a.hashCode()));
            if (map2 == null) {
                c.this.G.put(Integer.valueOf(this.f8980a.hashCode()), new HashMap());
            } else if (map2.get("native_click_map_key") != null && (map = (HashMap) map2.get("native_click_map_key")) != null) {
                map.put("__CLICK_AREA__", "1");
                map.put("__CLICK_TRIGGER__", "1");
            }
            c.this.a((HashMap<String, String>) map, view, motionEvent);
            c.this.a(this.f8980a.hashCode(), "native_click_map_key", map);
            if (motionEvent.getAction() == 1) {
                view.performClick();
            }
            return true;
        }
    }

    /* JADX INFO: renamed from: com.ubix.ssp.ad.i.c$c, reason: collision with other inner class name */
    class ViewOnClickListenerC1119c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.ubix.ssp.ad.d.a f8981a;
        final /* synthetic */ UBiXNativeInteractionListener b;

        ViewOnClickListenerC1119c(com.ubix.ssp.ad.d.a aVar, UBiXNativeInteractionListener uBiXNativeInteractionListener) {
            this.f8981a = aVar;
            this.b = uBiXNativeInteractionListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                HashMap map = new HashMap();
                HashMap map2 = (HashMap) c.this.G.get(Integer.valueOf(this.f8981a.hashCode()));
                if (map2 != null) {
                    if (map2.get("native_click_map_key") != null && (map = (HashMap) map2.get("native_click_map_key")) != null) {
                        map.put("__CLICK_AREA__", "1");
                        map.put("__CLICK_TRIGGER__", "1");
                    }
                    HashMap map3 = map;
                    u.a("shouldClick");
                    Object obj = ((HashMap) c.this.G.get(Integer.valueOf(this.f8981a.hashCode()))).get("native_custom_confirm_window_listener_key");
                    c.this.a(this.f8981a, view, (HashMap<String, String>) map3, this.b, obj == null ? null : (com.ubix.ssp.ad.g.c) obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ UBiXNativeInteractionListener f8982a;

        d(UBiXNativeInteractionListener uBiXNativeInteractionListener) {
            this.f8982a = uBiXNativeInteractionListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            u.e("onAdClicked in");
            UBiXNativeInteractionListener uBiXNativeInteractionListener = this.f8982a;
            if (uBiXNativeInteractionListener != null) {
                uBiXNativeInteractionListener.onAdClosed();
            }
            u.e("onAdClicked out");
        }
    }

    class e implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f8983a;
        final /* synthetic */ com.ubix.ssp.ad.d.a b;
        final /* synthetic */ UBiXNativeInteractionListener c;

        e(ViewGroup viewGroup, com.ubix.ssp.ad.d.a aVar, UBiXNativeInteractionListener uBiXNativeInteractionListener) {
            this.f8983a = viewGroup;
            this.b = aVar;
            this.c = uBiXNativeInteractionListener;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            try {
                this.f8983a.removeOnAttachStateChangeListener(this);
                c.this.a(this.f8983a, this.b, this.c, (UBiXNativeExpressInteractionListener) null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    class f implements com.ubix.ssp.ad.a.y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8984a;
        final /* synthetic */ View b;
        final /* synthetic */ com.ubix.ssp.ad.d.a c;

        f(int i, View view, com.ubix.ssp.ad.d.a aVar) {
            this.f8984a = i;
            this.b = view;
            this.c = aVar;
        }

        @Override // com.ubix.ssp.ad.a.y
        public void a() {
        }

        @Override // com.ubix.ssp.ad.a.y
        public boolean a(boolean z) {
            if (!z) {
                return true;
            }
            int i = this.f8984a;
            if (i == 44) {
                com.ubix.ssp.ad.e.s.b.c().a(this.b.getContext(), this.c.o);
                return false;
            }
            if (i != 45) {
                return true;
            }
            com.ubix.ssp.ad.e.s.b.c().b(this.b.getContext(), this.c.o);
            return false;
        }
    }

    class g extends BroadcastReceiver {
        g() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            c.this.H = false;
            com.ubix.ssp.ad.e.a0.m.a(((com.ubix.ssp.ad.a) c.this).c).a(this);
            u.e("install result onReceived " + intent);
            try {
                for (com.ubix.ssp.ad.d.a aVar : ((com.ubix.ssp.ad.a) c.this).e) {
                    if (aVar.o == intent.getIntExtra("service_intent_notify_id", -1)) {
                        aVar.u = intent.getStringExtra("service_intent_pkg_extra");
                        UBiXNativeInteractionListener uBiXNativeInteractionListener = (UBiXNativeInteractionListener) ((HashMap) c.this.G.get(Integer.valueOf(aVar.hashCode()))).get("interaction_listener_key");
                        if (uBiXNativeInteractionListener != null) {
                            uBiXNativeInteractionListener.onAdStatusChanged();
                            return;
                        }
                        return;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    class h extends com.ubix.ssp.ad.g.k.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f8986a = 0;
        final /* synthetic */ com.ubix.ssp.ad.d.a b;

        h(com.ubix.ssp.ad.d.a aVar) {
            this.b = aVar;
        }

        @Override // com.ubix.ssp.ad.g.k.g
        public void a(int i, long j, long j2) {
            c cVar;
            com.ubix.ssp.ad.d.a aVar;
            int i2;
            if (j2 > 0) {
                int i3 = (int) ((100 * j) / (j2 == 0 ? 1L : j2));
                int i4 = this.f8986a;
                if (i3 >= i4 * 25) {
                    if (i4 == 0) {
                        cVar = c.this;
                        aVar = this.b;
                        i2 = 5000;
                    } else if (i4 == 1) {
                        cVar = c.this;
                        aVar = this.b;
                        i2 = 5025;
                    } else if (i4 == 2) {
                        cVar = c.this;
                        aVar = this.b;
                        i2 = 5050;
                    } else {
                        if (i4 == 3) {
                            cVar = c.this;
                            aVar = this.b;
                            i2 = 5075;
                        }
                        this.f8986a++;
                    }
                    cVar.a(aVar, i2);
                    this.f8986a++;
                }
            }
            UBiXNativeVideoListener uBiXNativeVideoListener = (UBiXNativeVideoListener) ((HashMap) c.this.G.get(Integer.valueOf(this.b.hashCode()))).get("video_listener_key");
            if (uBiXNativeVideoListener != null) {
                uBiXNativeVideoListener.onVideoProgressUpdate(j, j2);
            }
        }

        @Override // com.ubix.ssp.ad.g.k.g
        public void a(int i, AdError adError) {
            UBiXNativeVideoListener uBiXNativeVideoListener = (UBiXNativeVideoListener) ((HashMap) c.this.G.get(Integer.valueOf(this.b.hashCode()))).get("video_listener_key");
            c.this.a(this.b, 5200);
            if (uBiXNativeVideoListener != null) {
                uBiXNativeVideoListener.onVideoError(adError);
            }
        }

        @Override // com.ubix.ssp.ad.g.k.g, com.ubix.ssp.ad.g.k.b
        public void b(int i, View view, HashMap<String, String> map) {
            UBiXNativeInteractionListener uBiXNativeInteractionListener = (UBiXNativeInteractionListener) ((HashMap) c.this.G.get(Integer.valueOf(this.b.hashCode()))).get("interaction_listener_key");
            if (map != null) {
                map.put("__CLICK_AREA__", "1");
                map.put("__CLICK_TRIGGER__", "1");
            }
            Object obj = ((HashMap) c.this.G.get(Integer.valueOf(this.b.hashCode()))).get("native_custom_confirm_window_listener_key");
            c.this.a(this.b, view, map, uBiXNativeInteractionListener, obj == null ? null : (com.ubix.ssp.ad.g.c) obj);
        }

        @Override // com.ubix.ssp.ad.g.k.g
        public void c(int i) {
            c.this.a(this.b, 5100);
            c.this.a(this.b, 5200);
            UBiXNativeVideoListener uBiXNativeVideoListener = (UBiXNativeVideoListener) ((HashMap) c.this.G.get(Integer.valueOf(this.b.hashCode()))).get("video_listener_key");
            if (uBiXNativeVideoListener != null) {
                uBiXNativeVideoListener.onVideoComplete();
            }
        }

        @Override // com.ubix.ssp.ad.g.k.g
        public void g(int i) {
            try {
                HashMap map = (HashMap) c.this.G.get(Integer.valueOf(this.b.hashCode()));
                Boolean bool = Boolean.FALSE;
                map.put("lst_str", bool);
                ((HashMap) c.this.G.get(Integer.valueOf(this.b.hashCode()))).put("lst_res", bool);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            UBiXNativeVideoListener uBiXNativeVideoListener = (UBiXNativeVideoListener) ((HashMap) c.this.G.get(Integer.valueOf(this.b.hashCode()))).get("video_listener_key");
            if (uBiXNativeVideoListener != null) {
                uBiXNativeVideoListener.onVideoPause();
            }
        }

        @Override // com.ubix.ssp.ad.g.k.g
        public void h(int i) {
            try {
                Object obj = ((HashMap) c.this.G.get(Integer.valueOf(this.b.hashCode()))).get("lst_str");
                if (obj != null && Boolean.parseBoolean(obj + "")) {
                    return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            ((HashMap) c.this.G.get(Integer.valueOf(this.b.hashCode()))).put("lst_str", Boolean.TRUE);
            UBiXNativeVideoListener uBiXNativeVideoListener = (UBiXNativeVideoListener) ((HashMap) c.this.G.get(Integer.valueOf(this.b.hashCode()))).get("video_listener_key");
            if (uBiXNativeVideoListener != null) {
                uBiXNativeVideoListener.onVideoStart();
            }
        }

        @Override // com.ubix.ssp.ad.g.k.g
        public void j(int i) {
            try {
                Object obj = ((HashMap) c.this.G.get(Integer.valueOf(this.b.hashCode()))).get("lst_res");
                if (obj != null && Boolean.parseBoolean(obj + "")) {
                    return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            ((HashMap) c.this.G.get(Integer.valueOf(this.b.hashCode()))).put("lst_res", Boolean.TRUE);
            UBiXNativeVideoListener uBiXNativeVideoListener = (UBiXNativeVideoListener) ((HashMap) c.this.G.get(Integer.valueOf(this.b.hashCode()))).get("video_listener_key");
            if (uBiXNativeVideoListener != null) {
                uBiXNativeVideoListener.onVideoResume();
            }
        }
    }

    class i implements com.ubix.ssp.ad.g.k.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ UBiXNativeExpressInteractionListener f8987a;

        i(UBiXNativeExpressInteractionListener uBiXNativeExpressInteractionListener) {
            this.f8987a = uBiXNativeExpressInteractionListener;
        }

        @Override // com.ubix.ssp.ad.g.k.c
        public void a() {
        }

        @Override // com.ubix.ssp.ad.g.k.c
        public void a(String str) {
            u.e("onAdClosed in");
            UBiXNativeExpressInteractionListener uBiXNativeExpressInteractionListener = this.f8987a;
            if (uBiXNativeExpressInteractionListener != null) {
                uBiXNativeExpressInteractionListener.onAdClosed();
            }
            u.e("onAdClosed out");
        }
    }

    class j implements s.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f8988a;
        final /* synthetic */ com.ubix.ssp.ad.d.a b;

        j(Object obj, com.ubix.ssp.ad.d.a aVar) {
            this.f8988a = obj;
            this.b = aVar;
        }

        @Override // com.ubix.ssp.ad.e.a0.s.e
        public void a(float f, float f2) {
            try {
                if (((ViewGroup) this.f8988a).isShown()) {
                    if (com.ubix.ssp.ad.e.a0.y.c.a((View) this.f8988a, 0.75f, false, (List<Integer>) null) || com.ubix.ssp.ad.e.a0.y.c.a((ViewGroup) this.f8988a)) {
                        return;
                    }
                    HashMap map = new HashMap();
                    HashMap map2 = (HashMap) c.this.G.get(Integer.valueOf(this.b.hashCode()));
                    if (map2 != null && map2.get("native_click_map_key") != null) {
                        map = (HashMap) map2.get("native_click_map_key");
                    }
                    HashMap map3 = map;
                    map3.put("__TRI_VAL__", Base64.encodeToString((f + "").getBytes(), 10));
                    map3.put("__CLICK_AREA__", "3");
                    map3.put("__CLICK_TRIGGER__", "3");
                    Object obj = ((HashMap) c.this.G.get(Integer.valueOf(this.b.hashCode()))).get("native_custom_confirm_window_listener_key");
                    c.this.a(this.b, (ViewGroup) this.f8988a, (HashMap<String, String>) map3, (UBiXNativeInteractionListener) map2.get("interaction_listener_key"), obj != null ? (com.ubix.ssp.ad.g.c) obj : null);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // com.ubix.ssp.ad.e.a0.s.e
        public void a(Bundle bundle) {
            try {
                if (!((ViewGroup) this.f8988a).isShown() || com.ubix.ssp.ad.e.a0.y.c.a((View) this.f8988a, 0.75f, false, (List<Integer>) null) || com.ubix.ssp.ad.e.a0.y.c.a((ViewGroup) this.f8988a)) {
                    return;
                }
                HashMap map = new HashMap();
                HashMap map2 = (HashMap) c.this.G.get(Integer.valueOf(this.b.hashCode()));
                if (map2 != null && map2.get("native_click_map_key") != null) {
                    map = (HashMap) map2.get("native_click_map_key");
                }
                if (bundle.getInt("__SENSOR_INFO_TYPE__") == 1) {
                    map.put("__X_MAX_ACC__", String.format("%.2f", Float.valueOf(bundle.getFloat("__X_MAX_ACC__"))));
                    map.put("__Y_MAX_ACC__", String.format("%.2f", Float.valueOf(bundle.getFloat("__Y_MAX_ACC__"))));
                    map.put("__Z_MAX_ACC__", String.format("%.2f", Float.valueOf(bundle.getFloat("__Z_MAX_ACC__"))));
                    map.put("__TURN_X__", String.format("%.2f", Float.valueOf(bundle.getFloat("__TURN_X__"))));
                    map.put("__TURN_Y__", String.format("%.2f", Float.valueOf(bundle.getFloat("__TURN_Y__"))));
                    map.put("__TURN_Z__", String.format("%.2f", Float.valueOf(bundle.getFloat("__TURN_Z__"))));
                    map.put("__UBIX_TURN_TARGET__", bundle.getInt("__UBIX_TURN_TARGET__") + "");
                    map.put("__TURN_TIME__", bundle.getLong("__TURN_TIME__") + "");
                }
                c.this.a(bundle);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    class k implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f8989a;
        final /* synthetic */ Object b;
        final /* synthetic */ com.ubix.ssp.ad.d.a c;

        class a implements s.e {
            a() {
            }

            @Override // com.ubix.ssp.ad.e.a0.s.e
            public void a(float f, float f2) {
                try {
                    if (((ViewGroup) k.this.b).isShown()) {
                        if (com.ubix.ssp.ad.e.a0.y.c.a((View) k.this.b, 0.75f, false, (List<Integer>) null) || com.ubix.ssp.ad.e.a0.y.c.a((ViewGroup) k.this.b)) {
                            return;
                        }
                        HashMap map = new HashMap();
                        HashMap map2 = (HashMap) c.this.G.get(Integer.valueOf(k.this.c.hashCode()));
                        if (map2 != null && map2.get("native_click_map_key") != null) {
                            map = (HashMap) map2.get("native_click_map_key");
                        }
                        HashMap map3 = map;
                        map3.put("__TRI_VAL__", Base64.encodeToString((f + "").getBytes(), 10));
                        map3.put("__CLICK_AREA__", "3");
                        map3.put("__CLICK_TRIGGER__", "3");
                        Object obj = ((HashMap) c.this.G.get(Integer.valueOf(k.this.c.hashCode()))).get("native_custom_confirm_window_listener_key");
                        k kVar = k.this;
                        c.this.a(kVar.c, (ViewGroup) kVar.b, (HashMap<String, String>) map3, (UBiXNativeInteractionListener) map2.get("interaction_listener_key"), obj != null ? (com.ubix.ssp.ad.g.c) obj : null);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.ubix.ssp.ad.e.a0.s.e
            public void a(Bundle bundle) {
                try {
                    if (!((ViewGroup) k.this.b).isShown() || com.ubix.ssp.ad.e.a0.y.c.a((View) k.this.b, 0.75f, false, (List<Integer>) null) || com.ubix.ssp.ad.e.a0.y.c.a((ViewGroup) k.this.b)) {
                        return;
                    }
                    HashMap map = new HashMap();
                    HashMap map2 = (HashMap) c.this.G.get(Integer.valueOf(k.this.c.hashCode()));
                    if (map2 != null && map2.get("native_click_map_key") != null) {
                        map = (HashMap) map2.get("native_click_map_key");
                    }
                    if (bundle.getInt("__SENSOR_INFO_TYPE__") == 1) {
                        map.put("__X_MAX_ACC__", String.format("%.2f", Float.valueOf(bundle.getFloat("__X_MAX_ACC__"))));
                        map.put("__Y_MAX_ACC__", String.format("%.2f", Float.valueOf(bundle.getFloat("__Y_MAX_ACC__"))));
                        map.put("__Z_MAX_ACC__", String.format("%.2f", Float.valueOf(bundle.getFloat("__Z_MAX_ACC__"))));
                        map.put("__TURN_X__", String.format("%.2f", Float.valueOf(bundle.getFloat("__TURN_X__"))));
                        map.put("__TURN_Y__", String.format("%.2f", Float.valueOf(bundle.getFloat("__TURN_Y__"))));
                        map.put("__TURN_Z__", String.format("%.2f", Float.valueOf(bundle.getFloat("__TURN_Z__"))));
                        map.put("__UBIX_TURN_TARGET__", bundle.getInt("__UBIX_TURN_TARGET__") + "");
                        map.put("__TURN_TIME__", bundle.getLong("__TURN_TIME__") + "");
                    }
                    c.this.a(bundle);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        k(Object obj, Object obj2, com.ubix.ssp.ad.d.a aVar) {
            this.f8989a = obj;
            this.b = obj2;
            this.c = aVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Object obj = this.f8989a;
            if (obj != null) {
                ((s) obj).a(new a());
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ((ViewGroup) this.b).removeOnAttachStateChangeListener(this);
            ((s) this.f8989a).f();
            ((s) this.f8989a).a();
        }
    }

    class l extends FrameLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f8991a;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                int height = (l.this.f8991a.getMeasuredHeight() - l.this.f8991a.getPaddingTop()) - l.this.f8991a.getPaddingTop() <= 0 ? l.this.f8991a.getHeight() : (l.this.f8991a.getMeasuredHeight() - l.this.f8991a.getPaddingTop()) - l.this.f8991a.getPaddingTop();
                l.this.getLayoutParams().width = (l.this.f8991a.getMeasuredWidth() - l.this.f8991a.getPaddingLeft()) - l.this.f8991a.getPaddingRight();
                l.this.getLayoutParams().height = height;
                l.this.setVisibility(0);
                u.e("11111onConfigurationChanged in" + l.this.getVisibility());
            }
        }

        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                int height = (l.this.f8991a.getMeasuredHeight() - l.this.f8991a.getPaddingTop()) - l.this.f8991a.getPaddingTop() <= 0 ? l.this.f8991a.getHeight() : (l.this.f8991a.getMeasuredHeight() - l.this.f8991a.getPaddingTop()) - l.this.f8991a.getPaddingTop();
                l.this.getLayoutParams().width = (l.this.f8991a.getMeasuredWidth() - l.this.f8991a.getPaddingLeft()) - l.this.f8991a.getPaddingRight();
                l.this.getLayoutParams().height = height;
                u.e("111111onAttachedToWindow in" + l.this.getVisibility());
            }
        }

        /* JADX INFO: renamed from: com.ubix.ssp.ad.i.c$l$c, reason: collision with other inner class name */
        class RunnableC1120c implements Runnable {
            RunnableC1120c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (l.this.getLayoutParams() != null) {
                    l.this.getLayoutParams().width = 0;
                    l.this.getLayoutParams().height = 0;
                    u.e("111111onDetachedFromWindow in" + l.this.getVisibility());
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(Context context, ViewGroup viewGroup) {
            super(context);
            this.f8991a = viewGroup;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            setVisibility(0);
            u.e("111111onAttachedToWindow out" + getVisibility() + this);
            post(new b());
        }

        @Override // android.view.View
        protected void onConfigurationChanged(Configuration configuration) {
            super.onConfigurationChanged(configuration);
            setVisibility(8);
            u.e("11111onConfigurationChanged out" + getVisibility() + this);
            post(new a());
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            setVisibility(8);
            u.e("111111onDetachedFromWindow out" + getVisibility() + this);
            post(new RunnableC1120c());
        }
    }

    class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.ubix.ssp.ad.d.l f8995a;
        final /* synthetic */ List b;
        final /* synthetic */ ViewGroup c;
        final /* synthetic */ com.ubix.ssp.ad.d.a d;
        final /* synthetic */ View e;
        final /* synthetic */ UBiXNativeInteractionListener f;

        m(com.ubix.ssp.ad.d.l lVar, List list, ViewGroup viewGroup, com.ubix.ssp.ad.d.a aVar, View view, UBiXNativeInteractionListener uBiXNativeInteractionListener) {
            this.f8995a = lVar;
            this.b = list;
            this.c = viewGroup;
            this.d = aVar;
            this.e = view;
            this.f = uBiXNativeInteractionListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList arrayList;
            c cVar;
            com.ubix.ssp.ad.d.a aVar;
            View view;
            UBiXNativeInteractionListener uBiXNativeInteractionListener;
            int i;
            try {
                if (this.f8995a.s0()) {
                    arrayList = this.b != null ? new ArrayList(this.b) : new ArrayList();
                    arrayList.add(this.c);
                    cVar = c.this;
                    aVar = this.d;
                    view = this.e;
                    uBiXNativeInteractionListener = this.f;
                    i = DecodeThread.ALL_MODE;
                } else {
                    if (com.ubix.ssp.ad.d.b.E == 1 && this.d.t) {
                        return;
                    }
                    arrayList = new ArrayList();
                    arrayList.add(c.this.a(this.c));
                    cVar = c.this;
                    aVar = this.d;
                    view = this.e;
                    uBiXNativeInteractionListener = this.f;
                    i = 256;
                }
                cVar.a(aVar, arrayList, view, i, uBiXNativeInteractionListener);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    class n implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f8996a;
        final /* synthetic */ com.ubix.ssp.ad.e.a0.o b;
        final /* synthetic */ com.ubix.ssp.ad.d.l c;

        n(ViewGroup viewGroup, com.ubix.ssp.ad.e.a0.o oVar, com.ubix.ssp.ad.d.l lVar) {
            this.f8996a = viewGroup;
            this.b = oVar;
            this.c = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ubix.ssp.ad.e.a0.o oVar;
            ViewGroup viewGroup = this.f8996a;
            if (viewGroup == null || (oVar = this.b) == null || this.c == null) {
                return;
            }
            viewGroup.addView(oVar, new ViewGroup.LayoutParams(-1, -1));
            this.b.a(this.c.Z(), this.c.W(), this.c.Z() == 1 ? this.c.F() : new int[]{this.c.T()}, this.c.X(), this.c.U(), this.c.L0(), this.c.C0(), this.c.D0());
        }
    }

    class o implements com.ubix.ssp.ad.e.a0.o.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.ubix.ssp.ad.d.a f8997a;
        final /* synthetic */ ViewGroup b;
        final /* synthetic */ UBiXNativeInteractionListener c;
        final /* synthetic */ com.ubix.ssp.ad.e.a0.o d;

        o(com.ubix.ssp.ad.d.a aVar, ViewGroup viewGroup, UBiXNativeInteractionListener uBiXNativeInteractionListener, com.ubix.ssp.ad.e.a0.o oVar) {
            this.f8997a = aVar;
            this.b = viewGroup;
            this.c = uBiXNativeInteractionListener;
            this.d = oVar;
        }

        @Override // com.ubix.ssp.ad.e.a0.o.f
        public void a(float f, float f2) {
            try {
                HashMap map = new HashMap();
                HashMap map2 = (HashMap) c.this.G.get(Integer.valueOf(this.f8997a.hashCode()));
                if (map2 != null && map2.get("native_click_map_key") != null) {
                    map = (HashMap) map2.get("native_click_map_key");
                }
                map.put("__TRI_VAL__", Base64.encodeToString((f + "").getBytes(), 10));
                map.put("__CLICK_AREA__", "3");
                map.put("__CLICK_TRIGGER__", "3");
                Integer num = c.C.get(this.f8997a.g);
                c.C.put(this.f8997a.g, Integer.valueOf(num.intValue() + 1));
                int i = (Calendar.getInstance().get(1) * 1000) + (Calendar.getInstance().get(2) * 100) + Calendar.getInstance().get(5);
                if (i != v.b(StubApp.getOrigApplicationContext(this.b.getContext().getApplicationContext()), "ubix_sp_native_max_volume", this.f8997a.g + "_date")) {
                    c.C.put(this.f8997a.g, 1);
                    v.b(StubApp.getOrigApplicationContext(this.b.getContext().getApplicationContext()), "ubix_sp_native_max_volume", this.f8997a.g + "_date", i);
                }
                v.b(StubApp.getOrigApplicationContext(this.b.getContext().getApplicationContext()), "ubix_sp_native_max_volume", this.f8997a.g + "_cur", num.intValue());
                Object obj = ((HashMap) c.this.G.get(Integer.valueOf(this.f8997a.hashCode()))).get("native_custom_confirm_window_listener_key");
                c.this.a(this.f8997a, this.b, (HashMap<String, String>) map, this.c, obj == null ? null : (com.ubix.ssp.ad.g.c) obj);
                this.d.a();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // com.ubix.ssp.ad.e.a0.o.f
        public void a(Bundle bundle) {
            HashMap map = new HashMap();
            HashMap map2 = (HashMap) c.this.G.get(Integer.valueOf(this.f8997a.hashCode()));
            if (map2 != null && map2.get("native_click_map_key") != null) {
                map = (HashMap) map2.get("native_click_map_key");
            }
            if (bundle.getInt("__SENSOR_INFO_TYPE__") == 1) {
                map.put("__X_MAX_ACC__", String.format("%.2f", Float.valueOf(bundle.getFloat("__X_MAX_ACC__"))));
                map.put("__Y_MAX_ACC__", String.format("%.2f", Float.valueOf(bundle.getFloat("__Y_MAX_ACC__"))));
                map.put("__Z_MAX_ACC__", String.format("%.2f", Float.valueOf(bundle.getFloat("__Z_MAX_ACC__"))));
                map.put("__TURN_X__", String.format("%.2f", Float.valueOf(bundle.getFloat("__TURN_X__"))));
                map.put("__TURN_Y__", String.format("%.2f", Float.valueOf(bundle.getFloat("__TURN_Y__"))));
                map.put("__TURN_Z__", String.format("%.2f", Float.valueOf(bundle.getFloat("__TURN_Z__"))));
                map.put("__UBIX_TURN_TARGET__", bundle.getInt("__UBIX_TURN_TARGET__") + "");
                map.put("__TURN_TIME__", bundle.getLong("__TURN_TIME__") + "");
            }
            c.this.a(bundle);
        }

        @Override // com.ubix.ssp.ad.e.a0.o.f
        public boolean a() {
            HashMap map = new HashMap();
            HashMap map2 = (HashMap) c.this.G.get(Integer.valueOf(this.f8997a.hashCode()));
            if (map2 != null && map2.get("native_click_map_key") != null) {
                map = (HashMap) map2.get("native_click_map_key");
            }
            return !TextUtils.isEmpty((CharSequence) map.get("__MULTI_CLICK_KEY__"));
        }
    }

    class p implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.ubix.ssp.ad.d.a f8998a;
        final /* synthetic */ View b;
        final /* synthetic */ int c;
        final /* synthetic */ UBiXNativeInteractionListener d;
        final /* synthetic */ View e;

        p(com.ubix.ssp.ad.d.a aVar, View view, int i, UBiXNativeInteractionListener uBiXNativeInteractionListener, View view2) {
            this.f8998a = aVar;
            this.b = view;
            this.c = i;
            this.d = uBiXNativeInteractionListener;
            this.e = view2;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                if (motionEvent.getAction() == 0) {
                    try {
                        if (this.e != null) {
                            Rect rect = new Rect();
                            this.e.getGlobalVisibleRect(rect);
                            if (rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                                return false;
                            }
                        }
                        View viewFindViewById = ((ViewGroup) this.b.getParent()).findViewById(200019);
                        if (viewFindViewById != null) {
                            Rect rect2 = new Rect();
                            viewFindViewById.getGlobalVisibleRect(rect2);
                            if (rect2.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                                return false;
                            }
                        }
                        HashMap map = new HashMap();
                        HashMap map2 = (HashMap) c.this.G.get(Integer.valueOf(this.f8998a.hashCode()));
                        if (map2 == null) {
                            c.this.G.put(Integer.valueOf(this.f8998a.hashCode()), new HashMap());
                        } else if (map2.get("native_click_map_key") != null) {
                            map = (HashMap) map2.get("native_click_map_key");
                        }
                        c.this.a((HashMap<String, String>) map, this.b, motionEvent);
                        c.this.a(this.f8998a.hashCode(), "native_click_map_key", map);
                    } catch (Throwable th) {
                        th.printStackTrace();
                        return false;
                    }
                }
                return true;
            }
            try {
                HashMap map3 = new HashMap();
                HashMap map4 = (HashMap) c.this.G.get(Integer.valueOf(this.f8998a.hashCode()));
                if (map4 != null) {
                    if (ez.Code.equals(map4.get("easy_slide_trigger") + "") && com.ubix.ssp.ad.d.b.E == 1) {
                        this.b.setOnTouchListener(null);
                        return false;
                    }
                    if (map4.get("native_click_map_key") != null && (map3 = (HashMap) map4.get("native_click_map_key")) != null) {
                        String str = (String) map3.get(com.hihonor.adsdk.base.g.j.e.c.hnadsc);
                        String str2 = (String) map3.get(com.hihonor.adsdk.base.g.j.e.c.hnadsd);
                        float f = !TextUtils.isEmpty(str) ? Float.parseFloat(str) : 0.0f;
                        float f2 = TextUtils.isEmpty(str2) ? 0.0f : Float.parseFloat(str2);
                        if (Math.abs(f - motionEvent.getX()) >= 5.0f || Math.abs(f2 - motionEvent.getY()) >= 5.0f) {
                            map3.put("__CLICK_AREA__", "12");
                            map3.put("__CLICK_TRIGGER__", "12");
                            this.f8998a.t = true;
                            if (this.c == 256 && com.ubix.ssp.ad.d.b.E == 1) {
                                this.b.setOnTouchListener(null);
                            }
                            c.this.a(this.f8998a.hashCode(), "easy_slide_trigger", ez.Code);
                        } else {
                            map3.put("__CLICK_AREA__", "1");
                            map3.put("__CLICK_TRIGGER__", "1");
                        }
                    }
                    HashMap map5 = map3;
                    u.a("shouldClick");
                    Object obj = ((HashMap) c.this.G.get(Integer.valueOf(this.f8998a.hashCode()))).get("native_custom_confirm_window_listener_key");
                    c.this.a(this.f8998a, view, (HashMap<String, String>) map5, this.d, obj != null ? (com.ubix.ssp.ad.g.c) obj : null);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    class q implements com.ubix.ssp.ad.e.a0.y.e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SoftReference<ViewGroup> f8999a;
        private final SoftReference<UBiXNativeInteractionListener> b;
        private final com.ubix.ssp.ad.d.a c;

        public q(com.ubix.ssp.ad.d.a aVar, ViewGroup viewGroup, UBiXNativeInteractionListener uBiXNativeInteractionListener) {
            this.f8999a = new SoftReference<>(viewGroup);
            this.b = new SoftReference<>(uBiXNativeInteractionListener);
            this.c = aVar;
        }

        @Override // com.ubix.ssp.ad.e.a0.y.e.a
        public void a(int i) {
            try {
                SoftReference<ViewGroup> softReference = this.f8999a;
                if (softReference == null || softReference.get() == null) {
                    return;
                }
                c.this.a(this.f8999a.get(), this.c, this.b.get(), (UBiXNativeExpressInteractionListener) null);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // com.ubix.ssp.ad.e.a0.y.e.a
        public void b(int i) {
        }
    }

    public c(Context context, String str, int i2, com.ubix.ssp.ad.g.g gVar) {
        super(context, str);
        this.G = new ConcurrentHashMap<>();
        this.H = false;
        this.E = new SoftReference<>(context);
        this.F = gVar;
        this.u = 2;
        q(i2);
        int iA = v.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), "ubix_sp_native_max_volume", str + "_cur", 0);
        if (C.containsKey(str)) {
            return;
        }
        C.put(str, Integer.valueOf(iA));
    }

    public c(Context context, String str, com.ubix.ssp.ad.g.g gVar) {
        super(context, str);
        this.G = new ConcurrentHashMap<>();
        this.H = false;
        this.E = new SoftReference<>(context);
        this.F = gVar;
        q(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized FrameLayout a(ViewGroup viewGroup) {
        l lVar;
        int iIndexOfChild;
        synchronized (viewGroup) {
            if (viewGroup.findViewById(910200) != null) {
                viewGroup.removeViewAt(viewGroup.indexOfChild(viewGroup.findViewById(910200)));
            }
            if (viewGroup.findViewById(910100) != null && (iIndexOfChild = viewGroup.indexOfChild(viewGroup.findViewById(910100))) >= 0) {
                viewGroup.removeViewAt(iIndexOfChild);
            }
            lVar = new l(viewGroup.getContext(), viewGroup);
            lVar.setId(910200);
            viewGroup.addView(lVar, new ViewGroup.LayoutParams((viewGroup.getMeasuredWidth() - viewGroup.getPaddingLeft()) - viewGroup.getPaddingRight(), (viewGroup.getMeasuredHeight() - viewGroup.getPaddingTop()) - viewGroup.getPaddingTop() <= 0 ? viewGroup.getHeight() : (viewGroup.getMeasuredHeight() - viewGroup.getPaddingTop()) - viewGroup.getPaddingTop()));
        }
        return lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str, Object obj) {
        HashMap<String, Object> map = this.G.get(Integer.valueOf(i2));
        if (map != null) {
            map.put(str, obj);
            return;
        }
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put(str, obj);
        this.G.put(Integer.valueOf(i2), map2);
    }

    private void a(View view, com.ubix.ssp.ad.d.a aVar, UBiXNativeInteractionListener uBiXNativeInteractionListener) {
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, Object> map2 = this.G.get(Integer.valueOf(aVar.hashCode()));
        if (map2 != null) {
            if (map2.get("native_click_map_key") != null && (map = (HashMap) map2.get("native_click_map_key")) != null && map.get("__CUSTOM_CHECK__") == null) {
                map.put("__CLICK_AREA__", "1");
                map.put("__CLICK_TRIGGER__", "1");
            }
            HashMap<String, String> map3 = map;
            u.a("shouldClick");
            Object obj = this.G.get(Integer.valueOf(aVar.hashCode())).get("native_custom_confirm_window_listener_key");
            a(aVar, view, map3, uBiXNativeInteractionListener, obj == null ? null : (com.ubix.ssp.ad.g.c) obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.ubix.ssp.ad.d.a aVar, UBiXNativeInteractionListener uBiXNativeInteractionListener, UBiXNativeExpressInteractionListener uBiXNativeExpressInteractionListener) {
        com.ubix.ssp.ad.e.y.a.a.b bVar;
        String str;
        HashMap map;
        try {
            HashMap map2 = new HashMap();
            if (view != null) {
                HashMap<String, Object> map3 = this.G.get(Integer.valueOf(aVar.hashCode()));
                if (map3 != null && map3.get("native_click_map_key") != null && (map = (HashMap) map3.get("native_click_map_key")) != null) {
                    map2 = map;
                }
                map2.put(com.hihonor.adsdk.base.g.j.e.c.hnadsb, view.getWidth() + "");
                map2.put(com.hihonor.adsdk.base.g.j.e.c.hnadsa, view.getHeight() + "");
                map2.put("__IMP_AREA__", view.getLeft() + "_" + view.getTop() + "_" + view.getRight() + "_" + view.getBottom());
                a(aVar.hashCode(), "native_click_map_key", map2);
            }
            if (q(aVar)) {
                a(aVar.hashCode(), "native_exposed_key", Boolean.TRUE);
                super.x();
                if (!s(aVar)) {
                    AdError adErrorD = com.ubix.ssp.ad.e.a0.a0.a.d(4, "文件已经过期");
                    super.d(adErrorD);
                    u.e("onAdExposeFailed in");
                    if (uBiXNativeInteractionListener != null) {
                        uBiXNativeInteractionListener.onAdExposeFailed(adErrorD);
                    }
                    if (uBiXNativeExpressInteractionListener != null) {
                        uBiXNativeExpressInteractionListener.onAdExposeFailed(adErrorD);
                    }
                    u.e("onAdExposeFailed out");
                    return;
                }
                d(aVar);
                super.y();
                u.e("onAdExposed in");
                if (uBiXNativeInteractionListener != null) {
                    uBiXNativeInteractionListener.onAdExposed();
                }
                if (uBiXNativeExpressInteractionListener != null) {
                    uBiXNativeExpressInteractionListener.onAdExposed();
                }
                u.e("onAdExposed out");
                com.ubix.ssp.ad.e.y.a.a aVar2 = aVar.f8604a;
                if (aVar2 == null || (bVar = aVar2.d) == null || (str = bVar.i) == null) {
                    return;
                }
                f(str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(ViewGroup viewGroup, com.ubix.ssp.ad.d.a aVar, List<View> list, View view, UBiXNativeInteractionListener uBiXNativeInteractionListener) {
        if (list != null && list.size() > 0) {
            for (View view2 : list) {
                if (view2 != null) {
                    view2.setOnTouchListener(new b(aVar));
                    view2.setOnClickListener(new ViewOnClickListenerC1119c(aVar, uBiXNativeInteractionListener));
                }
            }
        }
        if (view != null) {
            view.setOnClickListener(new d(uBiXNativeInteractionListener));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.ubix.ssp.ad.d.a aVar, View view, HashMap<String, String> map, UBiXNativeInteractionListener uBiXNativeInteractionListener, com.ubix.ssp.ad.g.c cVar) {
        int i2 = aVar.o;
        int iB = com.ubix.ssp.ad.e.s.b.c().b(i2);
        if (iB == 46) {
            try {
                com.ubix.ssp.ad.e.s.g.b bVarB = com.ubix.ssp.ad.e.s.b.c().c(i2).b();
                File file = new File(com.ubix.ssp.ad.e.s.b.c().c(i2).b().e());
                if (file.exists() && file.length() == bVarB.g()) {
                    if (!map.containsKey("__NO_CLICK_CONFIRM_KEY__")) {
                        map.put("__NO_CLICK_CONFIRM_KEY__", "TRUE");
                    }
                } else if (map.containsKey("__NO_CLICK_CONFIRM_KEY__")) {
                    map.put("__NO_CLICK_CONFIRM_KEY__", "FALSE");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        a(aVar, new f(iB, view, aVar));
        if (a(aVar, view, map, uBiXNativeInteractionListener, (UBiXNativeExpressInteractionListener) null, cVar)) {
            Object obj = this.G.get(Integer.valueOf(aVar.hashCode())).get("native_core_view");
            if (obj instanceof com.ubix.ssp.ad.d.f) {
                ((com.ubix.ssp.ad.d.f) obj).b();
            }
            map.put("__MULTI_CLICK_KEY__", "TRUE");
            a(aVar.hashCode(), "native_click_map_key", map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.ubix.ssp.ad.d.a aVar, ViewGroup viewGroup, float f2, UBiXNativeInteractionListener uBiXNativeInteractionListener) {
        com.ubix.ssp.ad.e.a0.y.e.c.a().a(f2).a(aVar.o, viewGroup, new q(aVar, viewGroup, uBiXNativeInteractionListener));
    }

    private void a(com.ubix.ssp.ad.d.a aVar, ViewGroup viewGroup, com.ubix.ssp.ad.d.l lVar, UBiXNativeInteractionListener uBiXNativeInteractionListener) {
        HashMap<String, Object> map = this.G.get(Integer.valueOf(aVar.hashCode()));
        a(aVar.hashCode(), "custom_native_container", viewGroup);
        Object obj = map.get("custom_shake_sensor");
        if (obj != null) {
            s sVar = (s) obj;
            sVar.f();
            sVar.a();
        }
        a(aVar.hashCode(), "custom_shake_sensor", lVar.Z() == 1 ? new s(viewGroup.getContext(), lVar.W(), lVar.F(), lVar.U(), lVar.L0(), lVar.C0(), lVar.D0()) : new s(viewGroup.getContext(), lVar.W(), lVar.T(), lVar.L0()));
    }

    private void a(com.ubix.ssp.ad.d.a aVar, ViewGroup viewGroup, List<View> list, View view, float f2, UBiXNativeInteractionListener uBiXNativeInteractionListener) {
        a(aVar.hashCode(), "native_notify_id_key", Integer.valueOf(aVar.o));
        a(aVar.hashCode(), "interaction_listener_key", uBiXNativeInteractionListener);
        if (viewGroup != null && q(aVar)) {
            if (viewGroup.isAttachedToWindow()) {
                a(aVar, viewGroup, f2, uBiXNativeInteractionListener);
            } else {
                viewGroup.addOnAttachStateChangeListener(new a(viewGroup, aVar, f2, uBiXNativeInteractionListener));
            }
        }
        a(viewGroup, aVar, list, view, uBiXNativeInteractionListener);
    }

    private void a(com.ubix.ssp.ad.d.a aVar, ViewGroup viewGroup, List<View> list, View view, UBiXNativeInteractionListener uBiXNativeInteractionListener) {
        a(aVar.hashCode(), "native_notify_id_key", Integer.valueOf(aVar.o));
        a(aVar.hashCode(), "interaction_listener_key", uBiXNativeInteractionListener);
        if (viewGroup != null && viewGroup.isAttachedToWindow()) {
            a(viewGroup, aVar, uBiXNativeInteractionListener, (UBiXNativeExpressInteractionListener) null);
        } else if (viewGroup != null) {
            viewGroup.addOnAttachStateChangeListener(new e(viewGroup, aVar, uBiXNativeInteractionListener));
        }
        a(viewGroup, aVar, list, view, uBiXNativeInteractionListener);
    }

    private void a(com.ubix.ssp.ad.d.a aVar, com.ubix.ssp.ad.d.l lVar, ViewGroup viewGroup, View view, List<View> list, List<View> list2, UBiXNativeInteractionListener uBiXNativeInteractionListener) {
        int iIndexOfChild;
        int I = lVar.I();
        if (I != 2) {
            if (I == 256) {
                viewGroup.post(new m(lVar, list, viewGroup, aVar, view, uBiXNativeInteractionListener));
                return;
            } else if (I == 514) {
                a(aVar, viewGroup, lVar, uBiXNativeInteractionListener);
                return;
            } else {
                if (I != 768) {
                    return;
                }
                a(aVar, list2, view, DecodeThread.ALL_MODE, uBiXNativeInteractionListener);
                return;
            }
        }
        try {
            Integer num = C.get(aVar.g);
            if (num == null) {
                return;
            }
            if (lVar.J() < 0 || num.intValue() < lVar.J()) {
                if (viewGroup.findViewById(910100) != null) {
                    viewGroup.removeView(viewGroup.findViewById(910100));
                }
                if (viewGroup.findViewById(910100) != null && (iIndexOfChild = viewGroup.indexOfChild(viewGroup.findViewById(910100))) >= 0) {
                    viewGroup.removeViewAt(iIndexOfChild);
                }
                com.ubix.ssp.ad.e.a0.o oVar = new com.ubix.ssp.ad.e.a0.o(viewGroup.getContext(), lVar.u0() ? lVar.B() : null, lVar.t0() ? lVar.A() : null, lVar.i(), lVar.j(), lVar.h(), lVar.p0());
                viewGroup.post(new n(viewGroup, oVar, lVar));
                oVar.setCallback(new o(aVar, viewGroup, uBiXNativeInteractionListener, oVar));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.ubix.ssp.ad.d.a aVar, List<View> list, View view, int i2, UBiXNativeInteractionListener uBiXNativeInteractionListener) {
        for (View view2 : list) {
            if (view2 != null) {
                view2.setOnTouchListener(new p(aVar, view2, i2, uBiXNativeInteractionListener, view));
            }
        }
    }

    private void a(ArrayList<NativeAd> arrayList) {
        if (this.i != 3) {
            super.u();
        }
        com.ubix.ssp.ad.g.g gVar = this.F;
        if (gVar != null) {
            gVar.a(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HashMap<String, String> map, View view, MotionEvent motionEvent) {
        String str;
        String str2;
        try {
            u.b("--------touchXY", "action: " + motionEvent.getAction() + " getX:" + motionEvent.getX());
            if (motionEvent.getAction() == 0) {
                map.put(com.hihonor.adsdk.base.g.j.e.c.hnadsc, motionEvent.getX() + "");
                map.put(com.hihonor.adsdk.base.g.j.e.c.hnadsd, motionEvent.getY() + "");
                map.put("__RAW_DOWN_X__", motionEvent.getRawX() + "");
                str = motionEvent.getRawY() + "";
                str2 = "__RAW_DOWN_Y__";
            } else {
                if (motionEvent.getAction() != 1) {
                    return;
                }
                map.put(com.hihonor.adsdk.base.g.j.e.c.hnadse, motionEvent.getX() + "");
                map.put(com.hihonor.adsdk.base.g.j.e.c.hnadsf, motionEvent.getY() + "");
                map.put(com.hihonor.adsdk.base.g.j.e.c.hnadsb, view.getWidth() + "");
                map.put(com.hihonor.adsdk.base.g.j.e.c.hnadsa, view.getHeight() + "");
                map.put("__RAW_UP_X__", motionEvent.getRawX() + "");
                map.put("__RAW_UP_Y__", motionEvent.getRawY() + "");
                str = motionEvent.getX() + "_" + motionEvent.getY();
                str2 = "__CLICK_XY__";
            }
            map.put(str2, str);
        } catch (Exception unused) {
        }
    }

    private int o(int i2) {
        if (i2 == 1002 || i2 == 1005) {
            return 3;
        }
        if (i2 == 2005) {
            return 2;
        }
        if (i2 == 4004 || i2 == 6012 || i2 == 6013 || i2 == 9001 || i2 == 9002) {
            return 3;
        }
        switch (i2) {
            case 2011:
            case 2012:
            case 2013:
            case 2014:
                return 3;
            default:
                return 1;
        }
    }

    private String p(com.ubix.ssp.ad.d.a aVar) {
        try {
            com.ubix.ssp.ad.e.y.a.a.b.m mVar = aVar.f8604a.d.u;
            if (mVar != null && !TextUtils.isEmpty(mVar.c) && !TextUtils.isEmpty(mVar.b) && x.c()) {
                return "3";
            }
            String str = aVar.f8604a.d.o;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str.trim()) && str.trim().contains("://") && com.ubix.ssp.ad.e.a0.c.a(com.ubix.ssp.ad.e.a0.c.f8631a, com.ubix.ssp.ad.e.a0.c.c(str))) {
                return "3";
            }
            if (TextUtils.isEmpty(aVar.f8604a.d.n)) {
                return !TextUtils.isEmpty(aVar.f8604a.d.m) ? "3" : "0";
            }
            return a(aVar.f8604a).H() == 0 ? "2" : "1";
        } catch (Throwable th) {
            th.printStackTrace();
            return "0";
        }
    }

    private boolean q(com.ubix.ssp.ad.d.a aVar) {
        HashMap<String, Object> map = this.G.get(Integer.valueOf(aVar.hashCode()));
        return (map == null || map.containsKey("native_exposed_key")) ? false : true;
    }

    private boolean r(com.ubix.ssp.ad.d.a aVar) {
        com.ubix.ssp.ad.d.l lVarP;
        return aVar != null && (lVarP = p(this.e.indexOf(aVar))) != null && lVarP.l0() && System.currentTimeMillis() / 1000 > aVar.j;
    }

    @Override // com.ubix.ssp.ad.a
    protected void A() {
        super.A();
        if (this.H) {
            return;
        }
        this.H = true;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ACTION_INSTALLED");
        com.ubix.ssp.ad.e.a0.m.a(this.c).a(new g(), intentFilter);
    }

    public String B() {
        return l(this.i);
    }

    public void C() {
        m(1);
    }

    public void D() {
        super.u();
    }

    public void a(int i2, com.ubix.ssp.ad.b bVar) {
        b(bVar, a(this.e.get(i2).f8604a));
    }

    @Override // com.ubix.ssp.ad.a
    protected void a(int i2, com.ubix.ssp.ad.d.a aVar) {
        super.a(i2, aVar);
        try {
            a(this.c, aVar, (HashMap<String, String>) this.G.get(Integer.valueOf(aVar.hashCode())).get("native_click_map_key"));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ubix.ssp.ad.a
    protected void a(int i2, Object... objArr) {
        u.e("onAdClicked in");
        boolean z = false;
        try {
            com.ubix.ssp.ad.d.a aVar = (com.ubix.ssp.ad.d.a) objArr[0];
            com.ubix.ssp.ad.d.l lVarA = a(aVar.f8604a);
            if (lVarA.n0() && i2 != 0) {
                super.a(i2, objArr);
            }
            View view = (View) this.G.get(Integer.valueOf(aVar.hashCode())).get("native_parent_view_key");
            Object obj = this.G.get(Integer.valueOf(aVar.hashCode())).get("interaction_listener_key");
            StringBuilder sbAppend = new StringBuilder("runClickCallback ").append(i2).append(";canRun=");
            if ((!lVarA.n0() && i2 == 0) || (lVarA.n0() && i2 != 0)) {
                z = true;
            }
            u.e(sbAppend.append(z).toString());
            if (((!lVarA.n0() && i2 == 0) || (lVarA.n0() && i2 != 0)) && obj != null && !lVarA.m0()) {
                if (obj instanceof UBiXNativeInteractionListener) {
                    ((UBiXNativeInteractionListener) obj).onAdClicked(view);
                } else if (obj instanceof UBiXNativeExpressInteractionListener) {
                    ((UBiXNativeExpressInteractionListener) obj).onAdClicked(view);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        u.e("onAdClicked out");
    }

    @Override // com.ubix.ssp.ad.a
    protected void a(Message message) {
        int i2 = message.what;
        if (i2 != 5) {
            if (i2 != 6) {
                if (i2 != 10) {
                    if (i2 != 11) {
                        return;
                    }
                }
            }
            super.b((AdError) message.obj);
            e((AdError) message.obj);
            return;
        }
        ArrayList<NativeAd> arrayList = new ArrayList<>();
        for (com.ubix.ssp.ad.d.a aVar : this.e) {
            com.ubix.ssp.ad.e.y.a.a aVar2 = aVar.f8604a;
            aVar.o = aVar.d.hashCode();
            com.ubix.ssp.ad.d.l lVarA = a(aVar.f8604a);
            com.ubix.ssp.ad.d.h hVar = new com.ubix.ssp.ad.d.h();
            hVar.b(g(aVar));
            com.ubix.ssp.ad.e.y.a.a.b bVar = aVar2.d;
            hVar.e(bVar.b);
            hVar.a(aVar);
            hVar.a(this);
            hVar.b(lVarA.I());
            hVar.g(bVar.f);
            hVar.m(bVar.e);
            hVar.b(bVar.t);
            hVar.c(bVar.h);
            hVar.a(o(aVar.p));
            hVar.b(b(aVar2));
            if (lVarA.x0()) {
                hVar.f(bVar.o);
                hVar.h(bVar.n);
                hVar.l(bVar.m);
            }
            ArrayList<UBiXImage> arrayList2 = new ArrayList<>();
            com.ubix.ssp.ad.e.y.a.a.b.C1109b[] c1109bArr = bVar.j;
            if (c1109bArr != null && c1109bArr.length != 0) {
                com.ubix.ssp.ad.e.y.a.a.b.C1109b c1109b = c1109bArr[0];
                if (c1109b != null && !TextUtils.isEmpty(c1109b.c)) {
                    hVar.j(bVar.j[0].c);
                }
                for (com.ubix.ssp.ad.e.y.a.a.b.C1109b c1109b2 : bVar.j) {
                    UBiXImage uBiXImage = new UBiXImage();
                    if (c1109b2 != null && !TextUtils.isEmpty(c1109b2.c)) {
                        uBiXImage.setUrl(c1109b2.c);
                        uBiXImage.setWidth(c1109b2.d);
                        uBiXImage.setHeight(c1109b2.e);
                        uBiXImage.setMaterialId(c1109b2.f);
                        arrayList2.add(uBiXImage);
                    }
                }
            }
            if (!TextUtils.isEmpty(bVar.k.b)) {
                hVar.o(bVar.k.b);
                hVar.d(bVar.k.f);
                hVar.c(bVar.k.g);
                hVar.d(bVar.k.c);
                hVar.d(bVar.k.f);
                hVar.c(bVar.k.g);
                hVar.c(((long) bVar.k.d) * 1000);
                hVar.n(bVar.k.k);
                Bundle bundle = new Bundle();
                bundle.putInt("AUTO_PLAY", lVarA.c());
                bundle.putBoolean("AUTO_MUTE", lVarA.K0());
                bundle.putString("BUTTON_TEXT", aVar.f8604a.d.E);
                bundle.putInt("VIDEO_RENDER_TYPE", lVarA.k0());
                com.ubix.ssp.ad.d.f fVar = new com.ubix.ssp.ad.d.f(this.E.get(), bundle);
                fVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                hVar.a(fVar);
                a(aVar.hashCode(), "native_core_view", fVar);
            }
            hVar.a(arrayList2);
            hVar.a(bVar.E);
            hVar.a(com.ubix.ssp.ad.e.a0.c.a(bVar));
            hVar.r(bVar.g);
            hVar.w(bVar.A);
            hVar.s(bVar.C);
            hVar.t(bVar.B);
            hVar.u(bVar.z);
            hVar.q(bVar.F);
            hVar.a(bVar.G);
            hVar.p(bVar.H);
            hVar.v(bVar.I);
            boolean zG0 = lVarA.G0();
            aVar.v = zG0;
            hVar.a(com.ubix.ssp.ad.e.q.a("ubix/ic_logo.png", zG0));
            hVar.i(bVar.i);
            hVar.c(lVarA.z0());
            hVar.k(aVar2.m);
            hVar.getExtraInfo().put(ServerSideVerificationOptions.ACTION, p(aVar));
            arrayList.add(hVar);
        }
        a(arrayList);
    }

    public void a(com.ubix.ssp.ad.d.a aVar, int i2) {
        try {
            u.b("traceEvent " + i2 + this);
            if (i2 == 5000 || i2 == 5025 || i2 == 5050 || i2 == 5075 || i2 == 5100 || i2 == 5200) {
                a(aVar.f8604a, i2);
            } else {
                u.b("unsupport eventid " + i2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(com.ubix.ssp.ad.d.a aVar, long j2) {
        com.ubix.ssp.ad.e.y.a.a aVar2;
        if (aVar == null || (aVar2 = aVar.f8604a) == null) {
            return;
        }
        super.a(aVar2, j2);
    }

    public void a(com.ubix.ssp.ad.d.a aVar, ViewGroup viewGroup, List<View> list, List<View> list2, View view, UBiXNativeInteractionListener uBiXNativeInteractionListener) {
        try {
            com.ubix.ssp.ad.d.l lVarA = a(aVar.f8604a);
            if (lVarA.r0()) {
                a(aVar, viewGroup, list, view, lVarA.s(), uBiXNativeInteractionListener);
            } else {
                a(aVar, viewGroup, list, view, uBiXNativeInteractionListener);
            }
            if (this.u == 2 && this.i == 2) {
                a(aVar, lVarA, viewGroup, view, list, list2, uBiXNativeInteractionListener);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(com.ubix.ssp.ad.d.a aVar, com.ubix.ssp.ad.a.y yVar) {
        a(aVar.hashCode(), "native_confirm_window_listener_key", yVar);
    }

    public void a(com.ubix.ssp.ad.d.a aVar, com.ubix.ssp.ad.e.s.e eVar) {
        Object obj;
        try {
            a(aVar.hashCode(), "native_outer_download_listener_key", eVar);
            u.e("setDeveloperDownloadListener=" + eVar);
            try {
                ConcurrentHashMap<Integer, HashMap<String, Object>> concurrentHashMap = this.G;
                if (concurrentHashMap != null && (obj = concurrentHashMap.get(Integer.valueOf(aVar.hashCode())).get("native_inner_download_listener_key")) != null) {
                    ((com.ubix.ssp.ad.a.z) obj).a(eVar);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void a(com.ubix.ssp.ad.d.a aVar, com.ubix.ssp.ad.g.c cVar) {
        a(aVar.hashCode(), "native_custom_confirm_window_listener_key", cVar);
    }

    public void a(com.ubix.ssp.ad.d.a aVar, UBiXNativeVideoListener uBiXNativeVideoListener) {
        a(aVar.hashCode(), "video_listener_key", uBiXNativeVideoListener);
    }

    public void a(com.ubix.ssp.ad.d.a aVar, UBiXNativeExpressInteractionListener uBiXNativeExpressInteractionListener) {
        a(aVar, a(aVar.f8604a), new i(uBiXNativeExpressInteractionListener));
    }

    @Override // com.ubix.ssp.ad.a
    protected void a(com.ubix.ssp.ad.d.a aVar, HashMap<String, String> map) {
        try {
            com.ubix.ssp.ad.a.y yVar = (com.ubix.ssp.ad.a.y) this.G.get(Integer.valueOf(aVar.hashCode())).get("native_confirm_window_listener_key");
            if (yVar != null) {
                yVar.a(false);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        super.a(aVar, map);
    }

    public void a(com.ubix.ssp.ad.d.a aVar, boolean z) {
        List<View.OnAttachStateChangeListener> list;
        HashMap<String, Object> map = this.G.get(Integer.valueOf(aVar.hashCode()));
        Object obj = map.get("custom_shake_sensor");
        Object obj2 = map.get("custom_native_container");
        if (obj != null) {
            if (!z) {
                s sVar = (s) obj;
                sVar.f();
                sVar.a();
                return;
            }
            try {
                ((s) obj).f();
                ((s) obj).a();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (obj2 != null) {
                ConcurrentHashMap<Integer, List<View.OnAttachStateChangeListener>> concurrentHashMap = D;
                if (concurrentHashMap != null && !concurrentHashMap.isEmpty() && (list = D.get(Integer.valueOf(obj2.hashCode()))) != null && !list.isEmpty()) {
                    for (View.OnAttachStateChangeListener onAttachStateChangeListener : list) {
                        if (onAttachStateChangeListener != null) {
                            ((ViewGroup) obj2).removeOnAttachStateChangeListener(onAttachStateChangeListener);
                        }
                    }
                }
                ViewGroup viewGroup = (ViewGroup) obj2;
                if (viewGroup.isAttachedToWindow()) {
                    ((s) obj).a(new j(obj2, aVar));
                }
                List<View.OnAttachStateChangeListener> arrayList = D.get(Integer.valueOf(obj2.hashCode()));
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    D.put(Integer.valueOf(obj2.hashCode()), arrayList);
                }
                k kVar = new k(obj, obj2, aVar);
                arrayList.add(kVar);
                viewGroup.addOnAttachStateChangeListener(kVar);
            }
        }
    }

    public void a(String str, View view, com.ubix.ssp.ad.d.a aVar, HashMap<String, String> map) {
        View view2;
        Throwable th;
        UBiXNativeInteractionListener uBiXNativeInteractionListener;
        c cVar = this;
        if (aVar == null) {
            return;
        }
        if (view == null) {
            try {
                view2 = new View(com.ubix.ssp.ad.e.a0.c.e());
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                return;
            }
        } else {
            view2 = view;
        }
        com.ubix.ssp.ad.d.l lVarA = cVar.a(aVar.f8604a);
        if (lVarA != null && lVarA.z0()) {
            HashMap<String, Object> map2 = cVar.G.get(Integer.valueOf(aVar.hashCode()));
            if (map2 != null) {
                HashMap map3 = map2.get("native_click_map_key") != null ? (HashMap) map2.get("native_click_map_key") : null;
                if (map3 == null) {
                    map3 = new HashMap();
                }
                map3.put("__CUSTOM_CHECK__", "1");
                try {
                    if (TextUtils.isEmpty(str)) {
                        map3.put("__CLICK_AREA__", "1");
                        map3.put("__CLICK_TRIGGER__", "1");
                    } else {
                        map3.put("__CLICK_AREA__", str);
                        map3.put("__CLICK_TRIGGER__", str);
                    }
                    if (map != null) {
                        if (map.containsKey(NativeAd.ExtraConstant.CUSTOM_CLICK_DOWN_X)) {
                            map3.put(com.hihonor.adsdk.base.g.j.e.c.hnadsc, map.get(NativeAd.ExtraConstant.CUSTOM_CLICK_DOWN_X));
                        } else {
                            map3.put(com.hihonor.adsdk.base.g.j.e.c.hnadsc, "-999");
                        }
                        if (map.containsKey(NativeAd.ExtraConstant.CUSTOM_CLICK_DOWN_Y)) {
                            map3.put(com.hihonor.adsdk.base.g.j.e.c.hnadsd, map.get(NativeAd.ExtraConstant.CUSTOM_CLICK_DOWN_Y));
                        } else {
                            map3.put(com.hihonor.adsdk.base.g.j.e.c.hnadsd, "-999");
                        }
                        if (map.containsKey(NativeAd.ExtraConstant.CUSTOM_CLICK_RAW_DOWN_X)) {
                            map3.put("__RAW_DOWN_X__", map.get(NativeAd.ExtraConstant.CUSTOM_CLICK_RAW_DOWN_X));
                        } else {
                            map3.put("__RAW_DOWN_X__", "-999");
                        }
                        if (map.containsKey(NativeAd.ExtraConstant.CUSTOM_CLICK_RAW_DOWN_Y)) {
                            map3.put("__RAW_DOWN_Y__", map.get(NativeAd.ExtraConstant.CUSTOM_CLICK_RAW_DOWN_Y));
                        } else {
                            map3.put("__RAW_DOWN_Y__", "-999");
                        }
                        if (map.containsKey(NativeAd.ExtraConstant.CUSTOM_CLICK_UP_X)) {
                            map3.put(com.hihonor.adsdk.base.g.j.e.c.hnadse, map.get(NativeAd.ExtraConstant.CUSTOM_CLICK_UP_X));
                        } else {
                            map3.put(com.hihonor.adsdk.base.g.j.e.c.hnadse, "-999");
                        }
                        if (map.containsKey(NativeAd.ExtraConstant.CUSTOM_CLICK_UP_Y)) {
                            map3.put(com.hihonor.adsdk.base.g.j.e.c.hnadsf, map.get(NativeAd.ExtraConstant.CUSTOM_CLICK_UP_Y));
                        } else {
                            map3.put(com.hihonor.adsdk.base.g.j.e.c.hnadsf, "-999");
                        }
                        if (map.containsKey(NativeAd.ExtraConstant.CUSTOM_CLICK_RAW_UP_X)) {
                            map3.put("__RAW_UP_X__", map.get(NativeAd.ExtraConstant.CUSTOM_CLICK_RAW_UP_X));
                        } else {
                            map3.put("__RAW_UP_X__", "-999");
                        }
                        if (map.containsKey(NativeAd.ExtraConstant.CUSTOM_CLICK_RAW_UP_Y)) {
                            map3.put("__RAW_UP_Y__", map.get(NativeAd.ExtraConstant.CUSTOM_CLICK_RAW_UP_Y));
                        } else {
                            map3.put("__RAW_UP_Y__", "-999");
                        }
                    }
                    cVar = this;
                    cVar.a(aVar.hashCode(), "native_click_map_key", map3);
                } catch (Throwable th3) {
                    th = th3;
                    th.printStackTrace();
                    return;
                }
            }
            try {
                uBiXNativeInteractionListener = (UBiXNativeInteractionListener) cVar.G.get(Integer.valueOf(aVar.hashCode())).get("interaction_listener_key");
            } catch (Exception e2) {
                e2.printStackTrace();
                uBiXNativeInteractionListener = null;
            }
            cVar.a(view2, aVar, uBiXNativeInteractionListener);
        }
    }

    @Override // com.ubix.ssp.ad.a
    public void a(String str, Object obj) {
        super.a(str, obj);
    }

    public boolean a(com.ubix.ssp.ad.d.a aVar, View view, HashMap<String, String> map, UBiXNativeInteractionListener uBiXNativeInteractionListener, UBiXNativeExpressInteractionListener uBiXNativeExpressInteractionListener, com.ubix.ssp.ad.g.c cVar) {
        if (i()) {
            return false;
        }
        d(aVar, map);
        a(view, aVar, uBiXNativeInteractionListener, uBiXNativeExpressInteractionListener);
        if (view != null) {
            map.put("__BUTTON_AREA__", view.getLeft() + "_" + view.getTop() + "_" + view.getRight() + "_" + view.getBottom());
            map.put(com.hihonor.adsdk.base.g.j.e.c.hnadsb, view.getWidth() + "");
            map.put(com.hihonor.adsdk.base.g.j.e.c.hnadsa, view.getHeight() + "");
        }
        int iA = a(aVar, this.i, map, aVar.o, a(aVar.f8604a).o() == 1, cVar);
        if (iA == 6) {
            try {
                com.ubix.ssp.ad.a.y yVar = (com.ubix.ssp.ad.a.y) this.G.get(Integer.valueOf(aVar.hashCode())).get("native_confirm_window_listener_key");
                if (yVar != null) {
                    yVar.a();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            a(4, aVar);
        } else if (iA == 4) {
            try {
                com.ubix.ssp.ad.a.y yVar2 = (com.ubix.ssp.ad.a.y) this.G.get(Integer.valueOf(aVar.hashCode())).get("native_confirm_window_listener_key");
                if (yVar2 != null) {
                    yVar2.a(true);
                }
                A();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            a(4, aVar);
        } else if (iA == 22) {
            if (view != null) {
                b(view.getContext(), aVar, map, a(aVar.f8604a).q());
            }
        } else if (iA == 23) {
            if (view != null) {
                a(view.getContext(), aVar, map, a(aVar.f8604a).q());
            }
        } else if (iA == 2 || iA == 5 || iA == 31) {
            if (iA == 31) {
                g((String) null);
            }
            if (view != null) {
                a(view.getContext(), aVar, map);
            }
        } else if (iA == 3) {
            b(this.c);
        } else if (iA == 33) {
            a(33, aVar);
        } else {
            a(1, new Object[0]);
        }
        a(0, aVar);
        return true;
    }

    @Override // com.ubix.ssp.ad.a
    protected boolean a(com.ubix.ssp.ad.d.a aVar, boolean z, HashMap<String, String> map) {
        try {
            int iB = com.ubix.ssp.ad.e.s.b.c().b(aVar.o);
            b(aVar);
            if (!z && iB == 44) {
                com.ubix.ssp.ad.e.s.b.c().a(this.c, aVar.o);
                SoftReference<com.ubix.ssp.ad.e.z.h> softReference = this.s;
                if (softReference != null && softReference.get() != null) {
                    ((com.ubix.ssp.ad.e.z.e) this.s.get()).setText("下载继续");
                }
                return false;
            }
            if (iB == 45) {
                Object obj = this.G.get(Integer.valueOf(aVar.hashCode())).get("native_inner_download_listener_key");
                if (!com.ubix.ssp.ad.e.s.c.a().b((com.ubix.ssp.ad.e.s.e) obj)) {
                    com.ubix.ssp.ad.e.s.c.a().a((com.ubix.ssp.ad.e.s.e) obj);
                }
                com.ubix.ssp.ad.e.s.b.c().b(this.c, aVar.o);
                return false;
            }
            Object objA = this.G.get(Integer.valueOf(aVar.hashCode())).get("native_inner_download_listener_key");
            UBiXNativeInteractionListener uBiXNativeInteractionListener = (UBiXNativeInteractionListener) this.G.get(Integer.valueOf(aVar.hashCode())).get("interaction_listener_key");
            u.e("setDeveloperDownloadListener triggerGlobalDownloadWindow " + objA);
            if (objA == null) {
                objA = a(map, this.e.indexOf(aVar), (com.ubix.ssp.ad.e.s.e) this.G.get(Integer.valueOf(aVar.hashCode())).get("native_outer_download_listener_key"), uBiXNativeInteractionListener);
                a(aVar.hashCode(), "native_inner_download_listener_key", objA);
            }
            if (com.ubix.ssp.ad.e.s.c.a().b((com.ubix.ssp.ad.e.s.e) objA)) {
                return true;
            }
            com.ubix.ssp.ad.e.s.c.a().a((com.ubix.ssp.ad.e.s.e) objA);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }

    @Override // com.ubix.ssp.ad.a
    protected void b(int i2, com.ubix.ssp.ad.d.a aVar) {
        super.b(i2, aVar);
        if (i2 == 3) {
            a(2, aVar);
        }
    }

    public void b(com.ubix.ssp.ad.d.a aVar, ViewGroup viewGroup, List<View> list, View view, UBiXNativeInteractionListener uBiXNativeInteractionListener) {
        a(aVar, viewGroup, list, (List<View>) null, view, uBiXNativeInteractionListener);
    }

    @Override // com.ubix.ssp.ad.a
    protected boolean b(com.ubix.ssp.ad.d.a aVar, HashMap<String, String> map) {
        try {
            com.ubix.ssp.ad.a.y yVar = (com.ubix.ssp.ad.a.y) this.G.get(Integer.valueOf(aVar.hashCode())).get("native_confirm_window_listener_key");
            if (yVar != null) {
                return yVar.a(true);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return true;
    }

    @Override // com.ubix.ssp.ad.a
    protected void c(Context context, Intent intent, long j2, BroadcastReceiver broadcastReceiver) {
        super.c(context, intent, j2, broadcastReceiver);
        a(3, this.e.get(0));
    }

    public void c(com.ubix.ssp.ad.d.a aVar, HashMap<String, String> map) {
        com.ubix.ssp.ad.e.y.a.a aVar2;
        if (aVar == null || (aVar2 = aVar.f8604a) == null) {
            return;
        }
        super.a(aVar2, map);
    }

    @Override // com.ubix.ssp.ad.a
    public void c(AdError adError) {
        super.c(adError);
    }

    public void d(com.ubix.ssp.ad.d.a aVar, HashMap<String, String> map) {
        super.b(aVar, map);
    }

    @Override // com.ubix.ssp.ad.a
    public int e(com.ubix.ssp.ad.d.a aVar) {
        int iE = super.e(aVar);
        u.e("getDownloadAppProgress=" + iE);
        return iE;
    }

    public void e(AdError adError) {
        super.a(adError);
        com.ubix.ssp.ad.g.g gVar = this.F;
        if (gVar != null) {
            gVar.onAdLoadFailed(adError);
        }
    }

    public void h(String str) {
        if (TextUtils.isEmpty(str)) {
            b(com.ubix.ssp.ad.e.a0.a0.a.j(10, "竞价广告体为空或解析异常，请检查传入的参数是否正确"));
        } else {
            e(str);
        }
    }

    /* JADX WARN: Code duplicated, block: B:118:0x0150  */
    /* JADX WARN: Code duplicated, block: B:130:0x0174  */
    /* JADX WARN: Code duplicated, block: B:131:0x0179  */
    /* JADX WARN: Code duplicated, block: B:92:0x0103  */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x014c, code lost:
    
        if (android.text.TextUtils.isEmpty(r6.c) == false) goto L117;
     */
    @Override // com.ubix.ssp.ad.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected AdError j(com.ubix.ssp.ad.d.a aVar) {
        com.ubix.ssp.ad.e.y.a.a.b.C1109b[] c1109bArr;
        com.ubix.ssp.ad.e.y.a.a.b.C1109b c1109b;
        int i2;
        String str;
        com.ubix.ssp.ad.e.y.a.a.b.l lVar;
        com.ubix.ssp.ad.e.y.a.a.b.C1109b c1109b2;
        com.ubix.ssp.ad.e.y.a.a.b.C1109b c1109b3;
        com.ubix.ssp.ad.e.y.a.a.b.C1109b c1109b4;
        com.ubix.ssp.ad.e.y.a.a.b bVar = aVar.f8604a.d;
        int i3 = bVar.s;
        if (i3 == 1001) {
            c1109bArr = bVar.j;
            if (c1109bArr != null && c1109bArr.length != 0 && (c1109b = c1109bArr[0]) != null && !TextUtils.isEmpty(c1109b.c)) {
                return null;
            }
            i2 = 10;
            str = "图片资源链接异常";
        } else if (i3 == 1002) {
            lVar = bVar.k;
            if (lVar != null || TextUtils.isEmpty(lVar.c)) {
                i2 = 13;
                str = "封面图资源链接异常";
            } else {
                com.ubix.ssp.ad.e.y.a.a.b.l lVar2 = aVar.f8604a.d.k;
                if (lVar2 != null && !TextUtils.isEmpty(lVar2.b)) {
                    return null;
                }
                i2 = 12;
                str = "视频资源链接异常";
            }
        } else {
            if (i3 == 1004) {
                c1109bArr = bVar.j;
                if (c1109bArr != null) {
                    return null;
                }
            } else {
                if (i3 != 1005) {
                    if (i3 != 3001) {
                        if (i3 == 4003) {
                            com.ubix.ssp.ad.e.y.a.a.b.C1109b[] c1109bArr2 = bVar.j;
                            if (c1109bArr2 != null) {
                                if (c1109bArr2.length != 0) {
                                    com.ubix.ssp.ad.e.y.a.a.b.C1109b c1109b5 = c1109bArr2[0];
                                    if (c1109b5 != null) {
                                    }
                                }
                            }
                        } else if (i3 != 4004) {
                            switch (i3) {
                                case 2001:
                                case 2002:
                                case 2003:
                                case 2004:
                                case 2005:
                                case 2006:
                                case 2007:
                                    com.ubix.ssp.ad.e.y.a.a.b.C1109b[] c1109bArr3 = bVar.j;
                                    if (c1109bArr3 != null && c1109bArr3.length != 0 && (c1109b2 = c1109bArr3[0]) != null && !TextUtils.isEmpty(c1109b2.c)) {
                                        return null;
                                    }
                                    break;
                                default:
                                    switch (i3) {
                                        case 2011:
                                        case 2012:
                                        case 2013:
                                        case 2014:
                                            com.ubix.ssp.ad.e.y.a.a.b.l lVar3 = bVar.k;
                                            if (lVar3 == null || TextUtils.isEmpty(lVar3.c)) {
                                                i2 = 13;
                                                str = "封面图资源链接异常";
                                            } else {
                                                com.ubix.ssp.ad.e.y.a.a.b.l lVar4 = aVar.f8604a.d.k;
                                                if (lVar4 != null && !TextUtils.isEmpty(lVar4.b)) {
                                                    return null;
                                                }
                                                i2 = 12;
                                                str = "视频资源链接异常";
                                            }
                                            break;
                                        default:
                                            switch (i3) {
                                                case 6001:
                                                case 6002:
                                                case 6003:
                                                case 6004:
                                                    com.ubix.ssp.ad.e.y.a.a.b.C1109b[] c1109bArr4 = bVar.j;
                                                    if (c1109bArr4 != null && c1109bArr4.length != 0 && (c1109b3 = c1109bArr4[0]) != null && !TextUtils.isEmpty(c1109b3.c)) {
                                                        return null;
                                                    }
                                                    break;
                                                default:
                                                    switch (i3) {
                                                        case 6012:
                                                        case 6013:
                                                        case 6014:
                                                            com.ubix.ssp.ad.e.y.a.a.b.l lVar5 = bVar.k;
                                                            if (lVar5 == null || TextUtils.isEmpty(lVar5.c)) {
                                                                i2 = 13;
                                                                str = "封面图资源链接异常";
                                                            } else {
                                                                com.ubix.ssp.ad.e.y.a.a.b.l lVar6 = aVar.f8604a.d.k;
                                                                if (lVar6 != null && !TextUtils.isEmpty(lVar6.b)) {
                                                                    return null;
                                                                }
                                                                i2 = 12;
                                                                str = "视频资源链接异常";
                                                            }
                                                            break;
                                                        default:
                                                            switch (i3) {
                                                                case 9001:
                                                                case 9002:
                                                                    com.ubix.ssp.ad.e.y.a.a.b.l lVar7 = bVar.k;
                                                                    if (lVar7 == null || TextUtils.isEmpty(lVar7.c)) {
                                                                        i2 = 13;
                                                                        str = "封面图资源链接异常";
                                                                    } else {
                                                                        com.ubix.ssp.ad.e.y.a.a.b.l lVar8 = aVar.f8604a.d.k;
                                                                        if (lVar8 == null || TextUtils.isEmpty(lVar8.b)) {
                                                                            i2 = 12;
                                                                            str = "视频资源链接异常";
                                                                        } else if (!TextUtils.isEmpty(aVar.f8604a.d.i)) {
                                                                            if (!TextUtils.isEmpty(aVar.f8604a.d.e)) {
                                                                                return null;
                                                                            }
                                                                            i2 = 15;
                                                                            str = "标题内容异常";
                                                                        } else {
                                                                            i2 = 14;
                                                                            str = "ICON资源链接异常";
                                                                        }
                                                                    }
                                                                    break;
                                                                case 9003:
                                                                case 9004:
                                                                    com.ubix.ssp.ad.e.y.a.a.b.C1109b[] c1109bArr5 = bVar.j;
                                                                    if (c1109bArr5 != null && c1109bArr5.length != 0 && (c1109b4 = c1109bArr5[0]) != null && !TextUtils.isEmpty(c1109b4.c)) {
                                                                        if (!TextUtils.isEmpty(aVar.f8604a.d.i)) {
                                                                            if (!TextUtils.isEmpty(aVar.f8604a.d.e)) {
                                                                                return null;
                                                                            }
                                                                            i2 = 15;
                                                                            str = "标题内容异常";
                                                                        } else {
                                                                            i2 = 14;
                                                                            str = "ICON资源链接异常";
                                                                        }
                                                                        break;
                                                                    }
                                                                    break;
                                                                default:
                                                                    i2 = 16;
                                                                    str = "广告模板Id异常,或资源与模板不匹配";
                                                                    break;
                                                            }
                                                            break;
                                                    }
                                                    break;
                                            }
                                            break;
                                    }
                                    break;
                            }
                        } else {
                            com.ubix.ssp.ad.e.y.a.a.b.l lVar9 = bVar.k;
                            if (lVar9 == null || TextUtils.isEmpty(lVar9.c)) {
                                i2 = 13;
                                str = "封面图资源链接异常";
                            } else {
                                com.ubix.ssp.ad.e.y.a.a.b.l lVar10 = aVar.f8604a.d.k;
                                if (lVar10 != null && !TextUtils.isEmpty(lVar10.b)) {
                                    return null;
                                }
                                i2 = 12;
                                str = "视频资源链接异常";
                            }
                        }
                    }
                    return null;
                }
                lVar = bVar.k;
                if (lVar != null) {
                }
                i2 = 13;
                str = "封面图资源链接异常";
            }
            i2 = 10;
            str = "图片资源链接异常";
        }
        return com.ubix.ssp.ad.e.a0.a0.a.k(i2, str);
    }

    @Override // com.ubix.ssp.ad.a
    public void m(int i2) {
        this.h = i2;
        super.m(this.i);
    }

    public void m(com.ubix.ssp.ad.d.a aVar) {
        ViewGroup viewGroup;
        super.h();
        try {
            if (this.G.get(Integer.valueOf(aVar.hashCode())).get("native_core_view") != null && (viewGroup = (ViewGroup) this.G.get(Integer.valueOf(aVar.hashCode())).get("native_core_view")) != null) {
                viewGroup.removeAllViews();
            }
            if (this.G.get(Integer.valueOf(aVar.hashCode())) != null) {
                this.G.get(Integer.valueOf(aVar.hashCode())).clear();
            }
            com.ubix.ssp.ad.e.a0.y.e.c.a().c(aVar.o);
        } catch (Exception unused) {
        }
    }

    public int n(com.ubix.ssp.ad.d.a aVar) {
        int iF = f(aVar);
        u.e("getDownloadAppStatus=" + iF);
        return iF;
    }

    public com.ubix.ssp.ad.d.a n(int i2) {
        List<com.ubix.ssp.ad.d.a> list = this.e;
        if (list == null || list.size() <= i2) {
            return null;
        }
        return this.e.get(i2);
    }

    public ParamsReview o(com.ubix.ssp.ad.d.a aVar) {
        com.ubix.ssp.ad.d.l lVarA = a(aVar.f8604a);
        return super.a(aVar.f8604a, lVarA.x0(), lVarA.H0());
    }

    public com.ubix.ssp.ad.d.l p(int i2) {
        return a(this.e.get(i2).f8604a);
    }

    public void q(int i2) {
        this.i = i2;
    }

    public boolean s(com.ubix.ssp.ad.d.a aVar) {
        return !r(aVar);
    }

    public void t(com.ubix.ssp.ad.d.a aVar) {
        com.ubix.ssp.ad.d.f fVar;
        if (j(aVar) != null || !b(aVar.f8604a) || this.G.get(Integer.valueOf(aVar.hashCode())).get("native_core_view") == null || (fVar = (com.ubix.ssp.ad.d.f) this.G.get(Integer.valueOf(aVar.hashCode())).get("native_core_view")) == null) {
            return;
        }
        com.ubix.ssp.ad.e.v.e.b().a(aVar.f8604a.d.k.c, fVar.getCoverImage(), -1, null);
        fVar.a(aVar.f8604a.d.k.b, new h(aVar));
    }

    @Override // com.ubix.ssp.ad.a
    public void v() {
        super.v();
    }

    @Override // com.ubix.ssp.ad.a
    public void w() {
        super.w();
    }
}
