package com.huawei.openalliance.ad.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.huawei.hms.ads.AdFeedbackListener;
import com.huawei.hms.ads.dd;
import com.huawei.hms.ads.dm;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.jk;
import com.huawei.hms.ads.nativead.R;
import com.huawei.openalliance.ad.constant.bf;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.feedback.FeedbackView;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.FeedbackInfo;
import com.huawei.openalliance.ad.inter.data.l;
import com.huawei.openalliance.ad.utils.SafeIntent;
import com.huawei.openalliance.ad.utils.ag;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.t;
import com.huawei.openalliance.ad.utils.z;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class FeedbackActivity extends com.huawei.openalliance.ad.activity.a implements com.huawei.openalliance.ad.compliance.a {
    private static Map<Integer, AdFeedbackListener> n;
    private static Map<Integer, AdFeedbackListener> o;
    private static WeakReference<Context> p;
    private static SecureRandom q;
    private static a r;
    private int s;

    private static class a extends BroadcastReceiver {
        private String Code;
        private WeakReference<FeedbackActivity> V;

        public a(String str, FeedbackActivity feedbackActivity) {
            this.Code = str;
            this.V = new WeakReference<>(feedbackActivity);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String str;
            FeedbackActivity feedbackActivity = this.V.get();
            if (feedbackActivity == null) {
                str = "activity is null";
            } else {
                String action = new SafeIntent(intent).getAction();
                if (!bc.Code(action)) {
                    if (action.equals(x.dH + this.Code)) {
                        feedbackActivity.L();
                        context.unregisterReceiver(FeedbackActivity.r);
                        return;
                    } else {
                        if (action.equals(x.dI + this.Code)) {
                            context.unregisterReceiver(FeedbackActivity.r);
                            feedbackActivity.finish();
                            return;
                        }
                        return;
                    }
                }
                str = "action is null";
            }
            fh.I("FeedbackActivity", str);
        }
    }

    static {
        StubApp.interface11(35584);
        n = new HashMap();
        o = new HashMap();
        q = new SecureRandom();
    }

    private a Code(Context context, String str) {
        a aVar = new a(str, this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(x.dH + str);
        intentFilter.addAction(x.dI + str);
        z.Code(context, aVar, intentFilter, z.i(StubApp.getOrigApplicationContext(getApplicationContext())), null);
        return aVar;
    }

    private static void Code(int i) {
        n.remove(Integer.valueOf(i));
        o.remove(Integer.valueOf(i));
    }

    private void Code(int i, List<FeedbackInfo> list) {
        Toast.makeText(StubApp.getOrigApplicationContext(getApplicationContext()), R.string.hiad_feedback_reduce_such_content, 0).show();
        jk.Code(this, this.b, list, 1);
        dd.Code(this, this.b, 1 == i ? "2" : "4");
        AdFeedbackListener adFeedbackListener = n.get(Integer.valueOf(this.s));
        AdFeedbackListener adFeedbackListener2 = o.get(Integer.valueOf(this.s));
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(adFeedbackListener != null);
        objArr[1] = Boolean.valueOf(adFeedbackListener2 != null);
        fh.V("FeedbackActivity", "neg, innerListener: %s, listener: %s", objArr);
        if (adFeedbackListener != null) {
            adFeedbackListener.onAdDisliked();
        }
        if (adFeedbackListener2 != null) {
            adFeedbackListener2.onAdDisliked();
        }
    }

    public static void Code(Context context, com.huawei.openalliance.ad.feedback.a aVar) {
        if (aVar == null) {
            return;
        }
        if (t.Code()) {
            fh.V("FeedbackActivity", "fast click");
            return;
        }
        l lVarCode = dm.Code();
        if (lVarCode == null) {
            fh.V("FeedbackActivity", "nativeAd is null");
            return;
        }
        AdFeedbackListener adFeedbackListenerV = aVar.V();
        AdFeedbackListener adFeedbackListenerI = aVar.I();
        AdContentData adContentDataQ = lVarCode.q();
        if (adContentDataQ == null || aVar.Code() == null || !t.Code(adContentDataQ.aC()) || adFeedbackListenerV == null) {
            fh.Z("FeedbackActivity", "startFeedbackActivity fail: invalid parameter.");
            Code(adFeedbackListenerI);
            return;
        }
        int iNextInt = q.nextInt(Integer.MAX_VALUE);
        n.put(Integer.valueOf(iNextInt), adFeedbackListenerV);
        o.put(Integer.valueOf(iNextInt), adFeedbackListenerI);
        try {
            View viewCode = aVar.Code();
            int[] iArr = new int[2];
            p = new WeakReference<>(viewCode.getContext());
            viewCode.getLocationInWindow(iArr);
            fh.V("FeedbackActivity", "startFeedbackActivity, anchorView.getLocationInWindow [x,y]= %d, %d", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
            int[] iArr2 = new int[2];
            viewCode.getLocationOnScreen(iArr2);
            int[] iArr3 = {viewCode.getMeasuredWidth(), viewCode.getMeasuredHeight()};
            viewCode.getViewTreeObserver().addOnGlobalLayoutListener(new com.huawei.openalliance.ad.activity.a.ViewTreeObserverOnGlobalLayoutListenerC0530a(viewCode, context, iArr2));
            Intent intent = new Intent(context, (Class<?>) FeedbackActivity.class);
            intent.putExtra(bf.av, iArr);
            intent.putExtra(bf.ay, iArr3);
            intent.setFlags(65536);
            intent.putExtra(bf.aU, lVarCode.q());
            intent.putExtra(bf.aJ, iNextInt);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.setClipData(x.cU);
            context.startActivity(intent);
        } catch (Throwable th) {
            fh.I("FeedbackActivity", "startFeedbackActivity error: %s", th.getClass().getSimpleName());
            Code(adFeedbackListenerI);
            Code(iNextInt);
        }
    }

    private static void Code(AdFeedbackListener adFeedbackListener) {
        if (adFeedbackListener != null) {
            adFeedbackListener.onAdFeedbackShowFailed();
        }
    }

    private void Code(List<FeedbackInfo> list) {
        Toast.makeText(StubApp.getOrigApplicationContext(getApplicationContext()), R.string.hiad_feedback_had_feedback, 0).show();
        jk.Code(this, this.b, list, 2);
        dd.Code(this, this.b, "1");
        AdFeedbackListener adFeedbackListener = n.get(Integer.valueOf(this.s));
        AdFeedbackListener adFeedbackListener2 = o.get(Integer.valueOf(this.s));
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(adFeedbackListener != null);
        objArr[1] = Boolean.valueOf(adFeedbackListener2 != null);
        fh.V("FeedbackActivity", "pos, innerListener: %s, listener: %s", objArr);
        if (adFeedbackListener != null) {
            adFeedbackListener.onAdLiked();
        }
        if (adFeedbackListener2 != null) {
            adFeedbackListener2.onAdLiked();
        }
    }

    private void D() {
        this.i.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.activity.FeedbackActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    FeedbackActivity feedbackActivity = FeedbackActivity.this;
                    dd.Code(feedbackActivity, feedbackActivity.b, "3");
                } catch (Throwable th) {
                    fh.I("FeedbackActivity", "onClick error: %s", th.getClass().getSimpleName());
                }
                FeedbackActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        FeedbackInfo next;
        List<FeedbackInfo> listAC = this.b.aC();
        if (!ag.Code(listAC)) {
            Iterator<FeedbackInfo> it = listAC.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (3 != next.V());
        } else {
            next = null;
            break;
        }
        if (next != null) {
            Code(3, next);
        }
    }

    @Override // com.huawei.openalliance.ad.activity.a
    protected boolean B() {
        SafeIntent safeIntent = new SafeIntent(getIntent());
        this.b = (AdContentData) safeIntent.getSerializableExtra(bf.aU);
        this.s = safeIntent.getIntExtra(bf.aJ, 0);
        if (this.b == null) {
            return false;
        }
        return super.B();
    }

    @Override // com.huawei.openalliance.ad.activity.a
    protected void Code() {
        this.i = (RelativeLayout) findViewById(R.id.feedback_activity_root);
        this.j = findViewById(R.id.margin_view);
        this.k = findViewById(R.id.feedback_anchor_view);
        this.c = (FeedbackView) findViewById(R.id.top_feedback_view);
        this.f = (ImageView) findViewById(R.id.top_feedback_iv);
        this.d = (FeedbackView) findViewById(R.id.bottom_feedback_view);
        this.g = (ImageView) findViewById(R.id.bottom_feedback_iv);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002a A[Catch: all -> 0x002e, TRY_LEAVE, TryCatch #0 {all -> 0x002e, blocks: (B:3:0x000f, B:9:0x0020, B:10:0x0026, B:11:0x002a), top: B:18:0x000f }] */
    @Override // com.huawei.openalliance.ad.compliance.a
    public void Code(int i, FeedbackInfo feedbackInfo) {
        fh.V("FeedbackActivity", "action type: %s", Integer.valueOf(i));
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(feedbackInfo);
            if (i == 1) {
                Code(i, arrayList);
            } else if (i == 2) {
                Code(arrayList);
            } else if (i != 3) {
                fh.Code("FeedbackActivity", "invalid feedback type");
            } else {
                Code(i, arrayList);
            }
        } catch (Throwable th) {
            fh.I("FeedbackActivity", "itemClickAction error: %s", th.getClass().getSimpleName());
        }
        finish();
    }

    @Override // com.huawei.openalliance.ad.activity.a
    protected void I() {
        C();
        this.e.Code(this.L, this.f4431a);
        this.e.setAdContentData(this.b);
        this.e.setFeedbackListener(this);
    }

    @Override // com.huawei.openalliance.ad.activity.a
    protected int V() {
        return R.layout.hiad_activity_feedback;
    }

    @Override // com.huawei.openalliance.ad.activity.a
    protected void Z() {
        Code(o.get(Integer.valueOf(this.s)));
    }

    @Override // com.huawei.openalliance.ad.activity.a, com.huawei.openalliance.ad.activity.d, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // com.huawei.openalliance.ad.activity.a, com.huawei.openalliance.ad.activity.d, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        dm.Code(null);
        fh.V("FeedbackActivity", "onDestroy %s, instance: %s", Integer.valueOf(hashCode()), Integer.valueOf(this.s));
        Code(this.s);
    }
}
