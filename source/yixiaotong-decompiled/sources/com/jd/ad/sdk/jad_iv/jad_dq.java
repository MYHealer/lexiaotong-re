package com.jd.ad.sdk.jad_iv;

import android.graphics.Rect;
import android.os.Message;
import android.view.View;
import com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener;
import com.jd.ad.sdk.dl.baseinfo.JADScreenInfoUtils;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.jad_jt.jad_iv;
import com.jd.ad.sdk.jad_yl.jad_fs;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ExposureManager.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_dq implements jad_er.jad_an {
    public WeakReference<View> jad_an;
    public jad_er jad_bo;
    public volatile JADExposureListener jad_cp;
    public int jad_dq;
    public final com.jd.ad.sdk.jad_yl.jad_bo jad_er = new com.jd.ad.sdk.jad_yl.jad_bo();
    public WeakReference<String> jad_fs;

    @Override // com.jd.ad.sdk.jad_iv.jad_er.jad_an
    public void jad_an(Message message) {
        com.jd.ad.sdk.jad_yl.jad_bo jad_boVar;
        int i;
        int iJad_an;
        com.jd.ad.sdk.jad_yl.jad_bo jad_boVar2;
        int iJad_an2;
        int i2;
        int i3 = message.what;
        int i4 = 0;
        if (i3 == 1) {
            View viewJad_bo = jad_bo();
            if (viewJad_bo == null) {
                jad_er jad_erVar = this.jad_bo;
                if (jad_erVar != null) {
                    jad_erVar.removeCallbacksAndMessages(null);
                    return;
                }
                return;
            }
            if (viewJad_bo.getVisibility() != 0) {
                jad_er jad_erVar2 = this.jad_bo;
                if (jad_erVar2 != null) {
                    jad_erVar2.sendEmptyMessageDelayed(1, 1000L);
                    return;
                }
                return;
            }
            if (this.jad_cp != null && (jad_boVar = this.jad_er) != null && !jad_boVar.jad_an) {
                Rect rect = new Rect();
                if (viewJad_bo.getGlobalVisibleRect(rect)) {
                    int iWidth = rect.width();
                    int iHeight = rect.height();
                    i = iWidth;
                    i4 = iHeight;
                } else {
                    i = 0;
                }
                int i5 = this.jad_dq;
                int width = viewJad_bo.getWidth();
                int height = viewJad_bo.getHeight();
                if (i5 == 1) {
                    int screenWidth = JADScreenInfoUtils.getScreenWidth(com.jd.ad.sdk.jad_fq.jad_cp.jad_an());
                    int screenHeight = JADScreenInfoUtils.getScreenHeight(com.jd.ad.sdk.jad_fq.jad_cp.jad_an());
                    iJad_an = jad_iv.jad_an(height * width, screenWidth * screenHeight);
                    i4 = height;
                    height = screenHeight;
                    i = width;
                    width = screenWidth;
                } else {
                    iJad_an = jad_iv.jad_an(i4 * i, width * height);
                }
                JADExposureListener jADExposureListener = this.jad_cp;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("visible_area", iJad_an);
                    jSONObject.put("width", width);
                    jSONObject.put("height", height);
                    jSONObject.put("visible_width", i);
                    jSONObject.put("visible_height", i4);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                jADExposureListener.onPreExposure(jSONObject.toString());
                this.jad_er.jad_an = true;
            }
            jad_er jad_erVar3 = this.jad_bo;
            if (jad_erVar3 != null) {
                jad_erVar3.sendEmptyMessage(2);
                return;
            }
            return;
        }
        if (i3 != 2) {
            if (i3 == 3) {
                View viewJad_bo2 = jad_bo();
                if (viewJad_bo2 == null) {
                    jad_er jad_erVar4 = this.jad_bo;
                    if (jad_erVar4 != null) {
                        jad_erVar4.removeCallbacksAndMessages(null);
                        return;
                    }
                    return;
                }
                if (viewJad_bo2.getVisibility() != 0) {
                    jad_er jad_erVar5 = this.jad_bo;
                    if (jad_erVar5 != null) {
                        jad_erVar5.sendEmptyMessage(1);
                        return;
                    }
                    return;
                }
                if (jad_an()) {
                    jad_er jad_erVar6 = this.jad_bo;
                    if (jad_erVar6 != null) {
                        jad_erVar6.sendEmptyMessageDelayed(4, 1000L);
                        return;
                    }
                    return;
                }
                jad_er jad_erVar7 = this.jad_bo;
                if (jad_erVar7 != null) {
                    jad_erVar7.sendEmptyMessageDelayed(3, 1000L);
                    return;
                }
                return;
            }
            if (i3 != 4) {
                return;
            }
            View viewJad_bo3 = jad_bo();
            if (viewJad_bo3 == null) {
                jad_er jad_erVar8 = this.jad_bo;
                if (jad_erVar8 != null) {
                    jad_erVar8.removeCallbacksAndMessages(null);
                    return;
                }
                return;
            }
            if (viewJad_bo3.getVisibility() != 0) {
                jad_er jad_erVar9 = this.jad_bo;
                if (jad_erVar9 != null) {
                    jad_erVar9.sendEmptyMessage(1);
                    return;
                }
                return;
            }
            if (!jad_an()) {
                jad_er jad_erVar10 = this.jad_bo;
                if (jad_erVar10 != null) {
                    jad_erVar10.sendEmptyMessageDelayed(3, 1000L);
                    return;
                }
                return;
            }
            com.jd.ad.sdk.jad_yl.jad_bo jad_boVar3 = this.jad_er;
            if (jad_boVar3 != null && !jad_boVar3.jad_cp) {
                jad_an(false, CommonConstants.ExposureType.EXPOSURE_VALID.getIndex());
            }
            jad_er jad_erVar11 = this.jad_bo;
            if (jad_erVar11 != null) {
                jad_erVar11.removeCallbacksAndMessages(null);
                return;
            }
            return;
        }
        View viewJad_bo4 = jad_bo();
        if (viewJad_bo4 == null) {
            jad_er jad_erVar12 = this.jad_bo;
            if (jad_erVar12 != null) {
                jad_erVar12.removeCallbacksAndMessages(null);
                return;
            }
            return;
        }
        if (viewJad_bo4.getVisibility() != 0) {
            jad_er jad_erVar13 = this.jad_bo;
            if (jad_erVar13 != null) {
                jad_erVar13.sendEmptyMessage(1);
                return;
            }
            return;
        }
        if (!jad_dq()) {
            jad_er jad_erVar14 = this.jad_bo;
            if (jad_erVar14 != null) {
                jad_erVar14.sendEmptyMessageDelayed(2, 1000L);
                return;
            }
            return;
        }
        if (this.jad_cp != null && (jad_boVar2 = this.jad_er) != null && !jad_boVar2.jad_bo) {
            Rect rect2 = new Rect();
            viewJad_bo4.getGlobalVisibleRect(rect2);
            int i6 = this.jad_dq;
            int iWidth2 = rect2.width();
            int iHeight2 = rect2.height();
            int width2 = viewJad_bo4.getWidth();
            int height2 = viewJad_bo4.getHeight();
            if (i6 == 1) {
                int screenWidth2 = JADScreenInfoUtils.getScreenWidth(com.jd.ad.sdk.jad_fq.jad_cp.jad_an());
                int screenHeight2 = JADScreenInfoUtils.getScreenHeight(com.jd.ad.sdk.jad_fq.jad_cp.jad_an());
                iJad_an2 = jad_iv.jad_an(height2 * width2, screenWidth2 * screenHeight2);
                iHeight2 = height2;
                height2 = screenHeight2;
                i2 = screenWidth2;
            } else {
                iJad_an2 = jad_iv.jad_an(iHeight2 * iWidth2, width2 * height2);
                i2 = width2;
                width2 = iWidth2;
            }
            JADExposureListener jADExposureListener2 = this.jad_cp;
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("visible_area", iJad_an2);
                jSONObject2.put("width", i2);
                jSONObject2.put("height", height2);
                jSONObject2.put("visible_width", width2);
                jSONObject2.put("visible_height", iHeight2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            jADExposureListener2.onExposure(jSONObject2.toString());
            this.jad_er.jad_bo = true;
        }
        jad_er jad_erVar15 = this.jad_bo;
        if (jad_erVar15 != null) {
            jad_erVar15.sendEmptyMessage(3);
        }
    }

    public final boolean jad_cp() {
        int iJad_an;
        View viewJad_bo = jad_bo();
        if (viewJad_bo == null) {
            return false;
        }
        Rect rect = new Rect();
        if (!viewJad_bo.getGlobalVisibleRect(rect)) {
            return false;
        }
        int i = this.jad_dq;
        int iWidth = rect.width();
        int iHeight = rect.height();
        int width = viewJad_bo.getWidth();
        int height = viewJad_bo.getHeight();
        if (i == 1) {
            iJad_an = jad_iv.jad_an(height * width, JADScreenInfoUtils.getScreenWidth(com.jd.ad.sdk.jad_fq.jad_cp.jad_an()) * JADScreenInfoUtils.getScreenHeight(com.jd.ad.sdk.jad_fq.jad_cp.jad_an()));
            iWidth = width;
        } else {
            iJad_an = jad_iv.jad_an(iHeight * iWidth, width * height);
            height = iHeight;
        }
        if (i == 1) {
            if (iWidth < 1 || height < 1) {
                return false;
            }
        } else if (iJad_an < 50) {
            return false;
        }
        return true;
    }

    public final boolean jad_dq() {
        View viewJad_bo = jad_bo();
        if (viewJad_bo == null) {
            return false;
        }
        Rect rect = new Rect();
        return viewJad_bo.getGlobalVisibleRect(rect) && rect.width() >= 1 && rect.height() >= 1;
    }

    public final View jad_bo() {
        WeakReference<View> weakReference = this.jad_an;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final void jad_an(boolean z, int i) {
        int iJad_an;
        List<String> list;
        View viewJad_bo = jad_bo();
        if (this.jad_cp == null || viewJad_bo == null) {
            return;
        }
        if (jad_an() || z) {
            com.jd.ad.sdk.jad_yl.jad_bo jad_boVar = this.jad_er;
            if (jad_boVar != null) {
                jad_boVar.jad_cp = true;
            }
            JADExposureListener jADExposureListener = this.jad_cp;
            Rect rect = new Rect();
            viewJad_bo.getGlobalVisibleRect(rect);
            int i2 = this.jad_dq;
            int iWidth = rect.width();
            int iHeight = rect.height();
            int width = viewJad_bo.getWidth();
            int height = viewJad_bo.getHeight();
            if (i2 == 1) {
                int screenWidth = JADScreenInfoUtils.getScreenWidth(com.jd.ad.sdk.jad_fq.jad_cp.jad_an());
                int screenHeight = JADScreenInfoUtils.getScreenHeight(com.jd.ad.sdk.jad_fq.jad_cp.jad_an());
                iJad_an = jad_iv.jad_an(height * width, screenWidth * screenHeight);
                iWidth = width;
                width = screenWidth;
                iHeight = height;
                height = screenHeight;
            } else {
                iJad_an = jad_iv.jad_an(iHeight * iWidth, width * height);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("visible_area", iJad_an);
                jSONObject.put("width", width);
                jSONObject.put("height", height);
                jSONObject.put("visible_width", iWidth);
                jSONObject.put("visible_height", iHeight);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            jADExposureListener.onDelayExposure(1000L, jSONObject.toString(), i);
            WeakReference<String> weakReference = this.jad_fs;
            if (weakReference != null && weakReference.get() != null) {
                jad_fs jad_fsVarJad_dq = com.jd.ad.sdk.jad_na.jad_bo.jad_an.jad_an.jad_dq(com.jd.ad.sdk.jad_na.jad_cp.jad_an.jad_an.jad_an(this.jad_fs.get()));
                com.jd.ad.sdk.jad_xk.jad_iv.jad_cp.jad_an.jad_an((jad_fsVarJad_dq == null || (list = jad_fsVarJad_dq.jad_jw) == null) ? new String[0] : (String[]) list.toArray(new String[0]));
            } else {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.EXPOSURE_SERVER_REPORT_ERROR;
                com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(new String[0]));
            }
            this.jad_cp = null;
            jad_er jad_erVar = this.jad_bo;
            if (jad_erVar != null) {
                jad_erVar.removeCallbacksAndMessages(null);
                this.jad_bo = null;
            }
        }
    }

    public final boolean jad_an() {
        if (this.jad_dq == 1) {
            return jad_dq();
        }
        return jad_cp();
    }
}
