package com.jd.ad.sdk.jad_zk;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.fragment.app.FragmentActivity;
import com.jd.ad.sdk.logger.Logger;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_pc implements Handler.Callback {
    public static final jad_bo jad_jt = new jad_an();
    public volatile com.jd.ad.sdk.jad_gr.jad_jw jad_an;
    public final Map<FragmentManager, jad_ob> jad_bo = new HashMap();
    public final Map<androidx.fragment.app.FragmentManager, jad_uh> jad_cp = new HashMap();
    public final Handler jad_dq;
    public final jad_bo jad_er;
    public final jad_kx jad_fs;

    public class jad_an implements jad_bo {
        public com.jd.ad.sdk.jad_gr.jad_jw jad_an(com.jd.ad.sdk.jad_gr.jad_cp jad_cpVar, jad_ly jad_lyVar, jad_qd jad_qdVar, Context context) {
            return new com.jd.ad.sdk.jad_gr.jad_jw(jad_cpVar, jad_lyVar, jad_qdVar, new jad_re(), jad_cpVar.jad_bo(), context);
        }
    }

    public interface jad_bo {
    }

    public jad_pc(jad_bo jad_boVar, com.jd.ad.sdk.jad_gr.jad_fs jad_fsVar) {
        new ArrayMap();
        new ArrayMap();
        new Bundle();
        this.jad_er = jad_boVar == null ? jad_jt : jad_boVar;
        this.jad_dq = new Handler(Looper.getMainLooper(), this);
        this.jad_fs = jad_an(jad_fsVar);
    }

    public static Activity jad_an(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return jad_an(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static jad_kx jad_an(com.jd.ad.sdk.jad_gr.jad_fs jad_fsVar) {
        if (com.jd.ad.sdk.jad_te.jad_na.jad_hu && com.jd.ad.sdk.jad_te.jad_na.jad_jt) {
            return jad_fsVar.jad_an.containsKey(com.jd.ad.sdk.jad_gr.jad_dq.jad_er.class) ? new jad_iv() : new jad_jw();
        }
        return new jad_jt();
    }

    public static void jad_an(Activity activity) {
        if (activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        ComponentCallbacks componentCallbacksRemove;
        Object obj;
        Object obj2;
        boolean z = true;
        boolean z2 = false;
        boolean z3 = message.arg1 == 1;
        int i = message.what;
        if (i == 1) {
            FragmentManager fragmentManager = (FragmentManager) message.obj;
            jad_ob jad_obVar = this.jad_bo.get(fragmentManager);
            jad_ob jad_obVar2 = (jad_ob) fragmentManager.findFragmentByTag("com.jd.ad.sdk.glide.manager");
            if (jad_obVar2 != jad_obVar) {
                if (jad_obVar2 != null && jad_obVar2.jad_dq != null) {
                    throw new IllegalStateException("We've added two fragments with requests! Old: " + jad_obVar2 + " New: " + jad_obVar);
                }
                if (z3 || fragmentManager.isDestroyed()) {
                    if (Log.isLoggable("RMRetriever", 5)) {
                        if (fragmentManager.isDestroyed()) {
                            Logger.w("RMRetriever", "Parent was destroyed before our Fragment could be added");
                        } else {
                            Logger.w("RMRetriever", "Tried adding Fragment twice and failed twice, giving up!");
                        }
                    }
                    jad_obVar.jad_an.jad_an();
                } else {
                    FragmentTransaction fragmentTransactionAdd = fragmentManager.beginTransaction().add(jad_obVar, "com.jd.ad.sdk.glide.manager");
                    if (jad_obVar2 != null) {
                        fragmentTransactionAdd.remove(jad_obVar2);
                    }
                    fragmentTransactionAdd.commitAllowingStateLoss();
                    this.jad_dq.obtainMessage(1, 1, 0, fragmentManager).sendToTarget();
                    if (Log.isLoggable("RMRetriever", 3)) {
                        Logger.d("RMRetriever", "We failed to add our Fragment the first time around, trying again...");
                    }
                    obj2 = null;
                    componentCallbacksRemove = null;
                    z2 = true;
                    z = false;
                }
            }
            componentCallbacksRemove = this.jad_bo.remove(fragmentManager);
            obj = fragmentManager;
            z2 = true;
            obj2 = obj;
        } else if (i != 2) {
            z = false;
            obj2 = null;
            componentCallbacksRemove = null;
        } else {
            androidx.fragment.app.FragmentManager fragmentManager2 = (androidx.fragment.app.FragmentManager) message.obj;
            jad_uh jad_uhVar = this.jad_cp.get(fragmentManager2);
            jad_uh jad_uhVar2 = (jad_uh) fragmentManager2.findFragmentByTag("com.jd.ad.sdk.glide.manager");
            if (jad_uhVar2 != jad_uhVar) {
                if (jad_uhVar2 != null && jad_uhVar2.jad_er != null) {
                    throw new IllegalStateException("We've added two fragments with requests! Old: " + jad_uhVar2 + " New: " + jad_uhVar);
                }
                if (z3 || fragmentManager2.isDestroyed()) {
                    if (fragmentManager2.isDestroyed()) {
                        if (Log.isLoggable("RMRetriever", 5)) {
                            Logger.w("RMRetriever", "Parent was destroyed before our Fragment could be added, all requests for the destroyed parent are cancelled");
                        }
                    } else if (Log.isLoggable("RMRetriever", 6)) {
                        Logger.e("RMRetriever", "ERROR: Tried adding Fragment twice and failed twice, giving up and cancelling all associated requests! This probably means you're starting loads in a unit test with an Activity that you haven't created and never create. If you're using Robolectric, create the Activity as part of your test setup");
                    }
                    jad_uhVar.jad_an.jad_an();
                } else {
                    androidx.fragment.app.FragmentTransaction fragmentTransactionAdd2 = fragmentManager2.beginTransaction().add(jad_uhVar, "com.jd.ad.sdk.glide.manager");
                    if (jad_uhVar2 != null) {
                        fragmentTransactionAdd2.remove(jad_uhVar2);
                    }
                    fragmentTransactionAdd2.commitNowAllowingStateLoss();
                    this.jad_dq.obtainMessage(2, 1, 0, fragmentManager2).sendToTarget();
                    if (Log.isLoggable("RMRetriever", 3)) {
                        Logger.d("RMRetriever", "We failed to add our Fragment the first time around, trying again...");
                    }
                    obj2 = null;
                    componentCallbacksRemove = null;
                    z2 = true;
                    z = false;
                }
            }
            componentCallbacksRemove = this.jad_cp.remove(fragmentManager2);
            obj = fragmentManager2;
            z2 = true;
            obj2 = obj;
        }
        if (Log.isLoggable("RMRetriever", 5) && z && componentCallbacksRemove == null) {
            Logger.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
        }
        return z2;
    }

    public com.jd.ad.sdk.jad_gr.jad_jw jad_bo(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (com.jd.ad.sdk.jad_ir.jad_ly.jad_dq() && !(context instanceof Application)) {
            if (context instanceof FragmentActivity) {
                return jad_an((FragmentActivity) context);
            }
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (com.jd.ad.sdk.jad_ir.jad_ly.jad_cp()) {
                    return jad_bo(StubApp.getOrigApplicationContext(activity.getApplicationContext()));
                }
                if (activity instanceof FragmentActivity) {
                    return jad_an((FragmentActivity) activity);
                }
                jad_an(activity);
                this.jad_fs.jad_an(activity);
                FragmentManager fragmentManager = activity.getFragmentManager();
                Activity activityJad_an = jad_an((Context) activity);
                boolean z = activityJad_an == null || !activityJad_an.isFinishing();
                jad_ob jad_obVarJad_an = jad_an(fragmentManager, (Fragment) null);
                com.jd.ad.sdk.jad_gr.jad_jw jad_jwVar = jad_obVarJad_an.jad_dq;
                if (jad_jwVar != null) {
                    return jad_jwVar;
                }
                com.jd.ad.sdk.jad_gr.jad_jw jad_jwVarJad_an = ((jad_an) this.jad_er).jad_an(com.jd.ad.sdk.jad_gr.jad_cp.jad_an(activity), jad_obVarJad_an.jad_an, jad_obVarJad_an.jad_bo, activity);
                if (z) {
                    jad_jwVarJad_an.jad_cp();
                }
                jad_obVarJad_an.jad_dq = jad_jwVarJad_an;
                return jad_jwVarJad_an;
            }
            if (context instanceof ContextWrapper) {
                ContextWrapper contextWrapper = (ContextWrapper) context;
                if (StubApp.getOrigApplicationContext(contextWrapper.getBaseContext().getApplicationContext()) != null) {
                    return jad_bo(contextWrapper.getBaseContext());
                }
            }
        }
        if (this.jad_an == null) {
            synchronized (this) {
                if (this.jad_an == null) {
                    this.jad_an = ((jad_an) this.jad_er).jad_an(com.jd.ad.sdk.jad_gr.jad_cp.jad_an(StubApp.getOrigApplicationContext(context.getApplicationContext())), new com.jd.ad.sdk.jad_zk.jad_bo(), new jad_hu(), StubApp.getOrigApplicationContext(context.getApplicationContext()));
                }
            }
        }
        return this.jad_an;
    }

    public com.jd.ad.sdk.jad_gr.jad_jw jad_an(FragmentActivity fragmentActivity) {
        if (com.jd.ad.sdk.jad_ir.jad_ly.jad_cp()) {
            return jad_bo(StubApp.getOrigApplicationContext(fragmentActivity.getApplicationContext()));
        }
        jad_an((Activity) fragmentActivity);
        this.jad_fs.jad_an(fragmentActivity);
        androidx.fragment.app.FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Activity activityJad_an = jad_an((Context) fragmentActivity);
        boolean z = activityJad_an == null || !activityJad_an.isFinishing();
        jad_uh jad_uhVarJad_an = jad_an(supportFragmentManager, (androidx.fragment.app.Fragment) null);
        com.jd.ad.sdk.jad_gr.jad_jw jad_jwVarJad_an = jad_uhVarJad_an.jad_er;
        if (jad_jwVarJad_an == null) {
            jad_jwVarJad_an = ((jad_an) this.jad_er).jad_an(com.jd.ad.sdk.jad_gr.jad_cp.jad_an(fragmentActivity), jad_uhVarJad_an.jad_an, jad_uhVarJad_an.jad_bo, fragmentActivity);
            if (z) {
                jad_jwVarJad_an.jad_cp();
            }
            jad_uhVarJad_an.jad_er = jad_jwVarJad_an;
        }
        return jad_jwVarJad_an;
    }

    public final jad_ob jad_an(FragmentManager fragmentManager, Fragment fragment) {
        jad_ob jad_obVar = this.jad_bo.get(fragmentManager);
        if (jad_obVar != null) {
            return jad_obVar;
        }
        jad_ob jad_obVar2 = (jad_ob) fragmentManager.findFragmentByTag("com.jd.ad.sdk.glide.manager");
        if (jad_obVar2 == null) {
            jad_obVar2 = new jad_ob(new com.jd.ad.sdk.jad_zk.jad_an());
            jad_obVar2.jad_fs = fragment;
            if (fragment != null && fragment.getActivity() != null) {
                jad_obVar2.jad_an(fragment.getActivity());
            }
            this.jad_bo.put(fragmentManager, jad_obVar2);
            fragmentManager.beginTransaction().add(jad_obVar2, "com.jd.ad.sdk.glide.manager").commitAllowingStateLoss();
            this.jad_dq.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return jad_obVar2;
    }

    public final jad_uh jad_an(androidx.fragment.app.FragmentManager fragmentManager, androidx.fragment.app.Fragment fragment) {
        jad_uh jad_uhVar = this.jad_cp.get(fragmentManager);
        if (jad_uhVar != null) {
            return jad_uhVar;
        }
        jad_uh jad_uhVar2 = (jad_uh) fragmentManager.findFragmentByTag("com.jd.ad.sdk.glide.manager");
        if (jad_uhVar2 == null) {
            jad_uhVar2 = new jad_uh(new com.jd.ad.sdk.jad_zk.jad_an());
            jad_uhVar2.jad_fs = fragment;
            if (fragment != null && fragment.getContext() != null) {
                androidx.fragment.app.Fragment parentFragment = fragment;
                while (parentFragment.getParentFragment() != null) {
                    parentFragment = parentFragment.getParentFragment();
                }
                androidx.fragment.app.FragmentManager fragmentManager2 = parentFragment.getFragmentManager();
                if (fragmentManager2 != null) {
                    jad_uhVar2.jad_an(fragment.getContext(), fragmentManager2);
                }
            }
            this.jad_cp.put(fragmentManager, jad_uhVar2);
            fragmentManager.beginTransaction().add(jad_uhVar2, "com.jd.ad.sdk.glide.manager").commitAllowingStateLoss();
            this.jad_dq.obtainMessage(2, fragmentManager).sendToTarget();
        }
        return jad_uhVar2;
    }
}
