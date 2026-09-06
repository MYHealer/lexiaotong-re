package com.jd.ad.sdk.jad_fo;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.jd.ad.sdk.jad_gr.jad_jw;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_cp<Z> extends com.jd.ad.sdk.jad_fo.jad_an<Z> {
    public static final Handler jad_er = new Handler(Looper.getMainLooper(), new jad_an());
    public final jad_jw jad_dq;

    public class jad_an implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            jad_cp jad_cpVar = (jad_cp) message.obj;
            jad_cpVar.jad_dq.jad_an(jad_cpVar);
            return true;
        }
    }

    public jad_cp(jad_jw jad_jwVar, int i, int i2) {
        super(i, i2);
        this.jad_dq = jad_jwVar;
    }

    @Override // com.jd.ad.sdk.jad_fo.jad_er
    public void jad_an(Drawable drawable) {
    }

    @Override // com.jd.ad.sdk.jad_fo.jad_er
    public void jad_an(Z z, com.jd.ad.sdk.jad_gp.jad_bo<? super Z> jad_boVar) {
        com.jd.ad.sdk.jad_en.jad_dq jad_dqVar = this.jad_cp;
        if (jad_dqVar == null || !jad_dqVar.jad_cp()) {
            return;
        }
        jad_er.obtainMessage(1, this).sendToTarget();
    }
}
