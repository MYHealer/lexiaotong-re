package com.jd.ad.sdk.jad_zk;

import android.content.Context;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.alipay.sdk.util.i;
import com.jd.ad.sdk.logger.Logger;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_uh extends Fragment {
    public final com.jd.ad.sdk.jad_zk.jad_an jad_an;
    public final jad_qd jad_bo;
    public final Set<jad_uh> jad_cp;
    public jad_uh jad_dq;
    public com.jd.ad.sdk.jad_gr.jad_jw jad_er;
    public Fragment jad_fs;

    public class jad_an implements jad_qd {
        public jad_an() {
        }

        public String toString() {
            return super.toString() + "{fragment=" + jad_uh.this + i.d;
        }
    }

    public jad_uh() {
        this(new com.jd.ad.sdk.jad_zk.jad_an());
    }

    public jad_uh(com.jd.ad.sdk.jad_zk.jad_an jad_anVar) {
        this.jad_bo = new jad_an();
        this.jad_cp = new HashSet();
        this.jad_an = jad_anVar;
    }

    public final Fragment jad_an() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.jad_fs;
    }

    public final void jad_an(Context context, FragmentManager fragmentManager) {
        jad_bo();
        jad_uh jad_uhVarJad_an = com.jd.ad.sdk.jad_gr.jad_cp.jad_an(context).jad_fs.jad_an(fragmentManager, (Fragment) null);
        this.jad_dq = jad_uhVarJad_an;
        if (equals(jad_uhVarJad_an)) {
            return;
        }
        this.jad_dq.jad_cp.add(this);
    }

    public final void jad_bo() {
        jad_uh jad_uhVar = this.jad_dq;
        if (jad_uhVar != null) {
            jad_uhVar.jad_cp.remove(this);
            this.jad_dq = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        Fragment parentFragment = this;
        while (parentFragment.getParentFragment() != null) {
            parentFragment = parentFragment.getParentFragment();
        }
        FragmentManager fragmentManager = parentFragment.getFragmentManager();
        if (fragmentManager == null) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Logger.w("SupportRMFragment", "Unable to register fragment with root, ancestor detached");
            }
        } else {
            try {
                jad_an(getContext(), fragmentManager);
            } catch (IllegalStateException e) {
                if (Log.isLoggable("SupportRMFragment", 5)) {
                    Logger.w("SupportRMFragment", "Unable to register fragment with root", e);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.jad_an.jad_an();
        jad_bo();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.jad_fs = null;
        jad_bo();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.jad_an.jad_bo();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.jad_an.jad_cp();
    }

    @Override // androidx.fragment.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + jad_an() + i.d;
    }
}
