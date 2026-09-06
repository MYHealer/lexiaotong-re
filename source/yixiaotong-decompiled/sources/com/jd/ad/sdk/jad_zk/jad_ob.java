package com.jd.ad.sdk.jad_zk;

import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import com.alipay.sdk.util.i;
import com.jd.ad.sdk.logger.Logger;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
@Deprecated
public class jad_ob extends Fragment {
    public final com.jd.ad.sdk.jad_zk.jad_an jad_an;
    public final jad_qd jad_bo;
    public final Set<jad_ob> jad_cp;
    public com.jd.ad.sdk.jad_gr.jad_jw jad_dq;
    public jad_ob jad_er;
    public Fragment jad_fs;

    public class jad_an implements jad_qd {
        public jad_an() {
        }

        public String toString() {
            return super.toString() + "{fragment=" + jad_ob.this + i.d;
        }
    }

    public jad_ob() {
        this(new com.jd.ad.sdk.jad_zk.jad_an());
    }

    public jad_ob(com.jd.ad.sdk.jad_zk.jad_an jad_anVar) {
        this.jad_bo = new jad_an();
        this.jad_cp = new HashSet();
        this.jad_an = jad_anVar;
    }

    public final void jad_an(Activity activity) {
        jad_an();
        jad_pc jad_pcVar = com.jd.ad.sdk.jad_gr.jad_cp.jad_an(activity).jad_fs;
        jad_pcVar.getClass();
        jad_ob jad_obVarJad_an = jad_pcVar.jad_an(activity.getFragmentManager(), (Fragment) null);
        this.jad_er = jad_obVarJad_an;
        if (equals(jad_obVarJad_an)) {
            return;
        }
        this.jad_er.jad_cp.add(this);
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            jad_an(activity);
        } catch (IllegalStateException e) {
            if (Log.isLoggable("RMFragment", 5)) {
                Logger.w("RMFragment", "Unable to register fragment with root", e);
            }
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.jad_an.jad_an();
        jad_an();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        jad_an();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.jad_an.jad_bo();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.jad_an.jad_cp();
    }

    @Override // android.app.Fragment
    public String toString() {
        StringBuilder sbAppend = new StringBuilder().append(super.toString()).append("{parent=");
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null) {
            parentFragment = this.jad_fs;
        }
        return sbAppend.append(parentFragment).append(i.d).toString();
    }

    public final void jad_an() {
        jad_ob jad_obVar = this.jad_er;
        if (jad_obVar != null) {
            jad_obVar.jad_cp.remove(this);
            this.jad_er = null;
        }
    }
}
