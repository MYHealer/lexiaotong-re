package com.jd.ad.sdk.jad_f_an;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import java.util.List;

/* JADX INFO: compiled from: JADFeedRender.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_f_jt implements View.OnAttachStateChangeListener {
    public final /* synthetic */ com.jd.ad.sdk.feed.jad_f_bo jad_f_an;

    public jad_f_jt(com.jd.ad.sdk.feed.jad_f_bo jad_f_boVar) {
        this.jad_f_an = jad_f_boVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        com.jd.ad.sdk.feed.jad_f_bo jad_f_boVar = this.jad_f_an;
        if (jad_f_boVar.jad_f_iv == null) {
            return;
        }
        if (!jad_f_boVar.jad_f_dq()) {
            String strJad_f_cp = jad_f_boVar.jad_f_cp();
            if (TextUtils.isEmpty(strJad_f_cp)) {
                return;
            }
            JADMediator.getInstance().getFoundationService().loadImage(jad_f_boVar.jad_f_bo(), strJad_f_cp, new jad_f_iv(jad_f_boVar, jad_f_boVar.jad_f_an("jad_feed_image")));
            return;
        }
        List<String> list = jad_f_boVar.jad_f_cp;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            JADMediator.getInstance().getFoundationService().loadImage(jad_f_boVar.jad_f_bo(), list.get(i), new jad_f_hu(jad_f_boVar, jad_f_boVar.jad_f_an("jad_feed_image" + i)));
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        com.jd.ad.sdk.feed.jad_f_bo jad_f_boVar = this.jad_f_an;
        if (jad_f_boVar.jad_f_iv == null) {
            return;
        }
        if (!jad_f_boVar.jad_f_dq()) {
            ImageView imageViewJad_f_an = jad_f_boVar.jad_f_an("jad_feed_image");
            if (imageViewJad_f_an != null) {
                imageViewJad_f_an.setImageBitmap(null);
                return;
            }
            return;
        }
        List<String> list = jad_f_boVar.jad_f_cp;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            ImageView imageViewJad_f_an2 = jad_f_boVar.jad_f_an("jad_feed_image" + i);
            if (imageViewJad_f_an2 != null) {
                imageViewJad_f_an2.setImageBitmap(null);
            }
        }
    }
}
