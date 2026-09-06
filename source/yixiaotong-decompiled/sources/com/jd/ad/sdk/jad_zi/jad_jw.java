package com.jd.ad.sdk.jad_zi;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.jd.ad.sdk.bl.adinteraction.deeplink.OnOpenAppCallback;
import com.jd.ad.sdk.bl.adinteraction.deeplink.OnUserCancelJdJumpCallback;
import com.jd.ad.sdk.mdt.service.JADTouchService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: JADTouchServiceImplementor.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_jw implements JADTouchService {

    /* JADX INFO: compiled from: JADTouchServiceImplementor.java */
    public class jad_an implements OnOpenAppCallback {
        public final /* synthetic */ Context jad_an;
        public final /* synthetic */ String jad_bo;

        public jad_an(Context context, String str) {
            this.jad_an = context;
            this.jad_bo = str;
        }

        @Override // com.jd.ad.sdk.bl.adinteraction.deeplink.OnOpenAppCallback
        public void callback(boolean z) {
            if (z) {
                return;
            }
            jad_jw jad_jwVar = jad_jw.this;
            Context context = this.jad_an;
            String str = this.jad_bo;
            jad_jwVar.getClass();
            com.jd.ad.sdk.jad_fs.jad_bo jad_boVar = com.jd.ad.sdk.jad_fs.jad_cp.jad_an.jad_an.jad_an.get(str);
            if (jad_boVar == null) {
                return;
            }
            String str2 = com.jd.ad.sdk.jad_na.jad_cp.jad_an.jad_an.jad_an.get(str);
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            com.jd.ad.sdk.jad_na.jad_bo jad_boVar2 = com.jd.ad.sdk.jad_na.jad_bo.jad_an.jad_an;
            String strJad_bo = jad_boVar2.jad_bo(str2);
            if (!"1".equals(jad_boVar2.jad_fs(str2)) || TextUtils.isEmpty(strJad_bo)) {
                return;
            }
            String strJad_an = jad_boVar.jad_an(strJad_bo);
            if (!TextUtils.isEmpty(strJad_an) && com.jd.ad.sdk.jad_er.jad_an.jad_an(context, strJad_an)) {
                com.jd.ad.sdk.jad_xk.jad_iv.jad_cp.jad_an.jad_an(jad_jwVar.jad_an(jad_boVar, str2));
            }
        }
    }

    public final String[] jad_an(com.jd.ad.sdk.jad_fs.jad_bo jad_boVar, String str) {
        com.jd.ad.sdk.jad_yl.jad_fs jad_fsVarJad_dq = com.jd.ad.sdk.jad_na.jad_bo.jad_an.jad_an.jad_dq(str);
        List<String> listEmptyList = jad_fsVarJad_dq != null ? jad_fsVarJad_dq.jad_kx : Collections.emptyList();
        if (listEmptyList == null) {
            return new String[0];
        }
        String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
        if (strArr == null || strArr.length == 0) {
            return strArr;
        }
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr2[i] = jad_boVar.jad_an(strArr[i]);
        }
        return strArr2;
    }

    @Override // com.jd.ad.sdk.mdt.service.JADTouchService
    public int onUserCancelJdJump(Context context, String str) {
        com.jd.ad.sdk.jad_fs.jad_bo jad_boVar = com.jd.ad.sdk.jad_fs.jad_cp.jad_an.jad_an.jad_an.get(str);
        if (jad_boVar == null) {
            return -2;
        }
        String str2 = com.jd.ad.sdk.jad_na.jad_cp.jad_an.jad_an.jad_an.get(str);
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        if (TextUtils.isEmpty(str2)) {
            return -2;
        }
        com.jd.ad.sdk.jad_na.jad_bo jad_boVar2 = com.jd.ad.sdk.jad_na.jad_bo.jad_an.jad_an;
        String strJad_bo = jad_boVar2.jad_bo(str2);
        if (!"1".equals(jad_boVar2.jad_fs(str2)) || TextUtils.isEmpty(strJad_bo)) {
            return 2;
        }
        String strJad_an = jad_boVar.jad_an(strJad_bo);
        if (TextUtils.isEmpty(strJad_an)) {
            return 2;
        }
        if (!com.jd.ad.sdk.jad_er.jad_an.jad_an(context, strJad_an)) {
            return 3;
        }
        com.jd.ad.sdk.jad_xk.jad_iv.jad_cp.jad_an.jad_an(jad_an(jad_boVar, str2));
        return 4;
    }

    @Override // com.jd.ad.sdk.mdt.service.JADTouchService
    public int onViewClicked(Context context, View view, String str, OnUserCancelJdJumpCallback onUserCancelJdJumpCallback) {
        com.jd.ad.sdk.jad_fs.jad_bo jad_boVar = com.jd.ad.sdk.jad_fs.jad_cp.jad_an.jad_an.jad_an.get(str);
        if (jad_boVar == null) {
            return -2;
        }
        String str2 = com.jd.ad.sdk.jad_na.jad_cp.jad_an.jad_an.jad_an.get(str);
        String str3 = "";
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        if (TextUtils.isEmpty(str2)) {
            return -2;
        }
        com.jd.ad.sdk.jad_na.jad_bo jad_boVar2 = com.jd.ad.sdk.jad_na.jad_bo.jad_an.jad_an;
        com.jd.ad.sdk.jad_yl.jad_fs jad_fsVarJad_dq = jad_boVar2.jad_dq(str2);
        if (jad_fsVarJad_dq != null && !TextUtils.isEmpty(jad_fsVarJad_dq.jad_dq)) {
            str3 = jad_fsVarJad_dq.jad_dq;
        }
        String strJad_bo = jad_boVar2.jad_bo(str2);
        String strJad_fs = jad_boVar2.jad_fs(str2);
        if ("1".equals(strJad_fs) && !TextUtils.isEmpty(str3) && com.jd.ad.sdk.jad_er.jad_an.jad_an(context, jad_boVar.jad_an(str3), str, onUserCancelJdJumpCallback, new jad_an(context, str))) {
            com.jd.ad.sdk.jad_xk.jad_iv.jad_cp.jad_an.jad_an(jad_an(jad_boVar, str2));
            return 1;
        }
        if (!"1".equals(strJad_fs) || TextUtils.isEmpty(strJad_bo)) {
            return 2;
        }
        String strJad_an = jad_boVar.jad_an(strJad_bo);
        if (TextUtils.isEmpty(strJad_an)) {
            return 2;
        }
        if (!com.jd.ad.sdk.jad_er.jad_an.jad_an(context, strJad_an)) {
            return 3;
        }
        com.jd.ad.sdk.jad_xk.jad_iv.jad_cp.jad_an.jad_an(jad_an(jad_boVar, str2));
        return 0;
    }

    @Override // com.jd.ad.sdk.mdt.service.JADTouchService
    public void onViewTouch(View view, MotionEvent motionEvent, String str) {
        com.jd.ad.sdk.jad_fs.jad_an jad_anVar;
        com.jd.ad.sdk.jad_fs.jad_bo jad_boVar = com.jd.ad.sdk.jad_fs.jad_cp.jad_an.jad_an.jad_an.get(str);
        if (jad_boVar == null || (jad_anVar = jad_boVar.jad_an) == null || motionEvent == null) {
            return;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            jad_anVar.jad_an.clear();
            jad_anVar.jad_bo = new com.jd.ad.sdk.jad_fs.jad_dq(Math.round(motionEvent.getX()), Math.round(motionEvent.getY()), System.currentTimeMillis());
            return;
        }
        if (action != 1) {
            if (action == 2) {
                if (jad_anVar.jad_an.size() > 999) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(jad_anVar.jad_an.get(0));
                    List<com.jd.ad.sdk.jad_fs.jad_dq> list = jad_anVar.jad_an;
                    arrayList.addAll(list.subList(list.size() - 399, jad_anVar.jad_an.size()));
                    jad_anVar.jad_an.clear();
                    jad_anVar.jad_an.addAll(arrayList);
                    arrayList.clear();
                }
                jad_anVar.jad_an.add(new com.jd.ad.sdk.jad_fs.jad_dq(new Double(motionEvent.getX()).intValue(), new Double(motionEvent.getY()).intValue(), System.currentTimeMillis()));
                return;
            }
            if (action != 3) {
                return;
            }
        }
        jad_anVar.jad_cp = new com.jd.ad.sdk.jad_fs.jad_dq(new Double(motionEvent.getX()).intValue(), new Double(motionEvent.getY()).intValue(), System.currentTimeMillis());
    }

    @Override // com.jd.ad.sdk.mdt.service.JADTouchService
    public void registerTouchView(String str) {
        com.jd.ad.sdk.jad_fs.jad_cp jad_cpVar = com.jd.ad.sdk.jad_fs.jad_cp.jad_an.jad_an;
        if (jad_cpVar.jad_an.get(str) == null) {
            jad_cpVar.jad_an.put(str, new com.jd.ad.sdk.jad_fs.jad_bo());
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADTouchService
    public void unregisterTouchView(String str) {
        com.jd.ad.sdk.jad_fs.jad_cp jad_cpVar = com.jd.ad.sdk.jad_fs.jad_cp.jad_an.jad_an;
        if (jad_cpVar.jad_an.get(str) != null) {
            jad_cpVar.jad_an.remove(str);
        }
    }
}
