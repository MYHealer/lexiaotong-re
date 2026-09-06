package com.jd.ad.sdk.lottie;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.PathMeasure;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import com.jd.ad.sdk.jad_lu.jad_fs;
import com.jd.ad.sdk.jad_lu.jad_iv;
import com.jd.ad.sdk.jad_lu.jad_jt;
import com.jd.ad.sdk.jad_lu.jad_jw;
import com.jd.ad.sdk.jad_lu.jad_kx;
import com.jd.ad.sdk.jad_lu.jad_ly;
import com.jd.ad.sdk.jad_lu.jad_mz;
import com.jd.ad.sdk.jad_lu.jad_ob;
import com.jd.ad.sdk.jad_lu.jad_qd;
import com.jd.ad.sdk.jad_lu.jad_re;
import com.jd.ad.sdk.jad_lu.jad_uh;
import com.jd.ad.sdk.jad_lu.jad_vi;
import com.jd.ad.sdk.jad_lu.jad_wj;
import com.jd.ad.sdk.jad_lu.jad_xk;
import com.jd.ad.sdk.jad_lu.jad_yl;
import com.jd.ad.sdk.jad_xg.jad_hu;
import com.jd.ad.sdk.multi.R;
import com.stub.StubApp;
import java.io.ByteArrayInputStream;
import java.io.InterruptedIOException;
import java.lang.ref.WeakReference;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class LottieAnimationView extends AppCompatImageView {
    public static final jad_ob<Throwable> jad_tg = new jad_an();
    public final jad_ob<jad_jt> jad_an;
    public final jad_ob<Throwable> jad_bo;
    public jad_ob<Throwable> jad_cp;
    public int jad_dq;
    public final jad_mz jad_er;
    public boolean jad_fs;
    public int jad_hu;
    public boolean jad_iv;
    public String jad_jt;
    public boolean jad_jw;
    public boolean jad_kx;
    public boolean jad_ly;
    public boolean jad_mz;
    public boolean jad_na;
    public jad_wj jad_ob;
    public final Set<jad_qd> jad_pc;
    public int jad_qd;
    public jad_uh<jad_jt> jad_re;
    public jad_jt jad_sf;

    public class jad_an implements jad_ob<Throwable> {
        @Override // com.jd.ad.sdk.jad_lu.jad_ob
        public void jad_an(Throwable th) {
            Throwable th2 = th;
            ThreadLocal<PathMeasure> threadLocal = jad_hu.jad_an;
            if (!(th2 instanceof SocketException) && !(th2 instanceof ClosedChannelException) && !(th2 instanceof InterruptedIOException) && !(th2 instanceof ProtocolException) && !(th2 instanceof SSLException) && !(th2 instanceof UnknownHostException) && !(th2 instanceof UnknownServiceException)) {
                throw new IllegalStateException("Unable to parse composition", th2);
            }
            com.jd.ad.sdk.jad_xg.jad_dq.jad_an("Unable to load composition.", th2);
        }
    }

    public class jad_bo implements jad_ob<jad_jt> {
        public jad_bo() {
        }

        @Override // com.jd.ad.sdk.jad_lu.jad_ob
        public void jad_an(jad_jt jad_jtVar) {
            LottieAnimationView.this.setComposition(jad_jtVar);
        }
    }

    public class jad_cp implements jad_ob<Throwable> {
        public jad_cp() {
        }

        @Override // com.jd.ad.sdk.jad_lu.jad_ob
        public void jad_an(Throwable th) {
            Throwable th2 = th;
            LottieAnimationView lottieAnimationView = LottieAnimationView.this;
            int i = lottieAnimationView.jad_dq;
            if (i != 0) {
                lottieAnimationView.setImageResource(i);
            }
            jad_ob<Throwable> jad_obVar = LottieAnimationView.this.jad_cp;
            if (jad_obVar == null) {
                jad_obVar = LottieAnimationView.jad_tg;
            }
            jad_obVar.jad_an(th2);
        }
    }

    public static /* synthetic */ class jad_dq {
        public static final /* synthetic */ int[] jad_an;

        static {
            int[] iArr = new int[jad_wj.values().length];
            jad_an = iArr;
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                jad_an[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                jad_an[0] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class jad_er extends View.BaseSavedState {
        public static final Parcelable.Creator<jad_er> CREATOR = new jad_an();
        public String jad_an;
        public int jad_bo;
        public float jad_cp;
        public boolean jad_dq;
        public String jad_er;
        public int jad_fs;
        public int jad_jt;

        public class jad_an implements Parcelable.Creator<jad_er> {
            @Override // android.os.Parcelable.Creator
            public jad_er createFromParcel(Parcel parcel) {
                return new jad_er(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public jad_er[] newArray(int i) {
                return new jad_er[i];
            }
        }

        public jad_er(Parcel parcel) {
            super(parcel);
            this.jad_an = parcel.readString();
            this.jad_cp = parcel.readFloat();
            this.jad_dq = parcel.readInt() == 1;
            this.jad_er = parcel.readString();
            this.jad_fs = parcel.readInt();
            this.jad_jt = parcel.readInt();
        }

        public jad_er(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.jad_an);
            parcel.writeFloat(this.jad_cp);
            parcel.writeInt(this.jad_dq ? 1 : 0);
            parcel.writeString(this.jad_er);
            parcel.writeInt(this.jad_fs);
            parcel.writeInt(this.jad_jt);
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.jad_an = new jad_bo();
        this.jad_bo = new jad_cp();
        this.jad_dq = 0;
        this.jad_er = new jad_mz();
        this.jad_iv = false;
        this.jad_jw = false;
        this.jad_kx = false;
        this.jad_ly = false;
        this.jad_mz = false;
        this.jad_na = true;
        this.jad_ob = jad_wj.AUTOMATIC;
        this.jad_pc = new HashSet();
        this.jad_qd = 0;
        jad_an(null, R.attr.lottieAnimationViewStyle);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jad_an = new jad_bo();
        this.jad_bo = new jad_cp();
        this.jad_dq = 0;
        this.jad_er = new jad_mz();
        this.jad_iv = false;
        this.jad_jw = false;
        this.jad_kx = false;
        this.jad_ly = false;
        this.jad_mz = false;
        this.jad_na = true;
        this.jad_ob = jad_wj.AUTOMATIC;
        this.jad_pc = new HashSet();
        this.jad_qd = 0;
        jad_an(attributeSet, R.attr.lottieAnimationViewStyle);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jad_an = new jad_bo();
        this.jad_bo = new jad_cp();
        this.jad_dq = 0;
        this.jad_er = new jad_mz();
        this.jad_iv = false;
        this.jad_jw = false;
        this.jad_kx = false;
        this.jad_ly = false;
        this.jad_mz = false;
        this.jad_na = true;
        this.jad_ob = jad_wj.AUTOMATIC;
        this.jad_pc = new HashSet();
        this.jad_qd = 0;
        jad_an(attributeSet, i);
    }

    private void setCompositionTask(jad_uh<jad_jt> jad_uhVar) {
        this.jad_sf = null;
        this.jad_er.jad_cp();
        jad_an();
        this.jad_re = jad_uhVar.jad_bo(this.jad_an).jad_an(this.jad_bo);
    }

    @Override // android.view.View
    public void buildDrawingCache(boolean z) {
        this.jad_qd++;
        super.buildDrawingCache(z);
        if (this.jad_qd == 1 && getWidth() > 0 && getHeight() > 0 && getLayerType() == 1 && getDrawingCache(z) == null) {
            setRenderMode(jad_wj.HARDWARE);
        }
        this.jad_qd--;
        com.jd.ad.sdk.jad_lu.jad_dq.jad_an("buildDrawingCache");
    }

    public jad_jt getComposition() {
        return this.jad_sf;
    }

    public long getDuration() {
        jad_jt jad_jtVar = this.jad_sf;
        if (jad_jtVar != null) {
            return (long) jad_jtVar.jad_an();
        }
        return 0L;
    }

    public int getFrame() {
        return (int) this.jad_er.jad_cp.jad_fs;
    }

    public String getImageAssetsFolder() {
        return this.jad_er.jad_jw;
    }

    public float getMaxFrame() {
        return this.jad_er.jad_cp.jad_dq();
    }

    public float getMinFrame() {
        return this.jad_er.jad_cp.jad_er();
    }

    public jad_vi getPerformanceTracker() {
        jad_jt jad_jtVar = this.jad_er.jad_bo;
        if (jad_jtVar != null) {
            return jad_jtVar.jad_an;
        }
        return null;
    }

    public float getProgress() {
        return this.jad_er.jad_cp.jad_cp();
    }

    public int getRepeatCount() {
        return this.jad_er.jad_cp.getRepeatCount();
    }

    public int getRepeatMode() {
        return this.jad_er.jad_cp.getRepeatMode();
    }

    public float getScale() {
        return this.jad_er.jad_dq;
    }

    public float getSpeed() {
        return this.jad_er.jad_cp.jad_cp;
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        jad_mz jad_mzVar = this.jad_er;
        if (drawable2 == jad_mzVar) {
            super.invalidateDrawable(jad_mzVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public final void jad_an() {
        jad_uh<jad_jt> jad_uhVar = this.jad_re;
        if (jad_uhVar != null) {
            jad_ob<jad_jt> jad_obVar = this.jad_an;
            synchronized (jad_uhVar) {
                jad_uhVar.jad_an.remove(jad_obVar);
            }
            jad_uh<jad_jt> jad_uhVar2 = this.jad_re;
            jad_ob<Throwable> jad_obVar2 = this.jad_bo;
            synchronized (jad_uhVar2) {
                jad_uhVar2.jad_bo.remove(jad_obVar2);
            }
        }
    }

    public final void jad_bo() {
        jad_jt jad_jtVar;
        int i = jad_dq.jad_an[this.jad_ob.ordinal()];
        int i2 = 2;
        if (i != 1 && (i == 2 || i != 3 || (((jad_jtVar = this.jad_sf) != null && jad_jtVar.jad_na && Build.VERSION.SDK_INT < 28) || (jad_jtVar != null && jad_jtVar.jad_ob > 4)))) {
            i2 = 1;
        }
        if (i2 != getLayerType()) {
            setLayerType(i2, null);
        }
    }

    public void jad_cp() {
        this.jad_mz = false;
        this.jad_kx = false;
        this.jad_jw = false;
        this.jad_iv = false;
        jad_mz jad_mzVar = this.jad_er;
        jad_mzVar.jad_hu.clear();
        jad_mzVar.jad_cp.jad_hu();
        jad_bo();
    }

    public void jad_dq() {
        if (!isShown()) {
            this.jad_iv = true;
        } else {
            this.jad_er.jad_fs();
            jad_bo();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode()) {
            return;
        }
        if (this.jad_mz || this.jad_kx) {
            jad_dq();
            this.jad_mz = false;
            this.jad_kx = false;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        if (this.jad_er.jad_er()) {
            this.jad_kx = false;
            this.jad_jw = false;
            this.jad_iv = false;
            jad_mz jad_mzVar = this.jad_er;
            jad_mzVar.jad_hu.clear();
            jad_mzVar.jad_cp.cancel();
            jad_bo();
            this.jad_kx = true;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof jad_er)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        jad_er jad_erVar = (jad_er) parcelable;
        super.onRestoreInstanceState(jad_erVar.getSuperState());
        String str = jad_erVar.jad_an;
        this.jad_jt = str;
        if (!TextUtils.isEmpty(str)) {
            setAnimation(this.jad_jt);
        }
        int i = jad_erVar.jad_bo;
        this.jad_hu = i;
        if (i != 0) {
            setAnimation(i);
        }
        setProgress(jad_erVar.jad_cp);
        if (jad_erVar.jad_dq) {
            jad_dq();
        }
        this.jad_er.jad_jw = jad_erVar.jad_er;
        setRepeatMode(jad_erVar.jad_fs);
        setRepeatCount(jad_erVar.jad_jt);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        jad_er jad_erVar = new jad_er(super.onSaveInstanceState());
        jad_erVar.jad_an = this.jad_jt;
        jad_erVar.jad_bo = this.jad_hu;
        jad_erVar.jad_cp = this.jad_er.jad_cp.jad_cp();
        jad_erVar.jad_dq = this.jad_er.jad_er() || (!ViewCompat.isAttachedToWindow(this) && this.jad_kx);
        jad_mz jad_mzVar = this.jad_er;
        jad_erVar.jad_er = jad_mzVar.jad_jw;
        jad_erVar.jad_fs = jad_mzVar.jad_cp.getRepeatMode();
        jad_erVar.jad_jt = this.jad_er.jad_cp.getRepeatCount();
        return jad_erVar;
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        if (this.jad_fs) {
            if (!isShown()) {
                if (this.jad_er.jad_er()) {
                    jad_cp();
                    this.jad_jw = true;
                    return;
                }
                return;
            }
            if (this.jad_jw) {
                if (isShown()) {
                    this.jad_er.jad_jt();
                    jad_bo();
                } else {
                    this.jad_iv = false;
                    this.jad_jw = true;
                }
            } else if (this.jad_iv) {
                jad_dq();
            }
            this.jad_jw = false;
            this.jad_iv = false;
        }
    }

    public void setAnimation(int i) {
        jad_uh<jad_jt> jad_uhVarJad_an;
        this.jad_hu = i;
        this.jad_jt = null;
        if (isInEditMode()) {
            jad_uhVarJad_an = new jad_uh<>(new com.jd.ad.sdk.jad_lu.jad_er(this, i), true);
        } else if (this.jad_na) {
            Context context = getContext();
            String strJad_an = com.jd.ad.sdk.jad_lu.jad_hu.jad_an(context, i);
            jad_uhVarJad_an = com.jd.ad.sdk.jad_lu.jad_hu.jad_an(strJad_an, new jad_kx(new WeakReference(context), StubApp.getOrigApplicationContext(context.getApplicationContext()), i, strJad_an));
        } else {
            Context context2 = getContext();
            Map<String, jad_uh<jad_jt>> map = com.jd.ad.sdk.jad_lu.jad_hu.jad_an;
            jad_uhVarJad_an = com.jd.ad.sdk.jad_lu.jad_hu.jad_an((String) null, new jad_kx(new WeakReference(context2), StubApp.getOrigApplicationContext(context2.getApplicationContext()), i, null));
        }
        setCompositionTask(jad_uhVarJad_an);
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        Map<String, jad_uh<jad_jt>> map = com.jd.ad.sdk.jad_lu.jad_hu.jad_an;
        setCompositionTask(com.jd.ad.sdk.jad_lu.jad_hu.jad_an((String) null, new jad_ly(byteArrayInputStream, null)));
    }

    public void setAnimationFromUrl(String str) {
        jad_uh<jad_jt> jad_uhVarJad_an;
        if (this.jad_na) {
            Context context = getContext();
            Map<String, jad_uh<jad_jt>> map = com.jd.ad.sdk.jad_lu.jad_hu.jad_an;
            String str2 = "url_" + str;
            jad_uhVarJad_an = com.jd.ad.sdk.jad_lu.jad_hu.jad_an(str2, new jad_iv(context, str, str2));
        } else {
            Context context2 = getContext();
            Map<String, jad_uh<jad_jt>> map2 = com.jd.ad.sdk.jad_lu.jad_hu.jad_an;
            jad_uhVarJad_an = com.jd.ad.sdk.jad_lu.jad_hu.jad_an((String) null, new jad_iv(context2, str, null));
        }
        setCompositionTask(jad_uhVarJad_an);
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.jad_er.jad_sf = z;
    }

    public void setCacheComposition(boolean z) {
        this.jad_na = z;
    }

    public void setComposition(jad_jt jad_jtVar) {
        this.jad_er.setCallback(this);
        this.jad_sf = jad_jtVar;
        boolean z = true;
        this.jad_ly = true;
        jad_mz jad_mzVar = this.jad_er;
        if (jad_mzVar.jad_bo == jad_jtVar) {
            z = false;
        } else {
            jad_mzVar.jad_uh = false;
            jad_mzVar.jad_cp();
            jad_mzVar.jad_bo = jad_jtVar;
            jad_mzVar.jad_bo();
            com.jd.ad.sdk.jad_xg.jad_er jad_erVar = jad_mzVar.jad_cp;
            boolean z2 = jad_erVar.jad_jw == null;
            jad_erVar.jad_jw = jad_jtVar;
            if (z2) {
                jad_erVar.jad_an((int) Math.max(jad_erVar.jad_hu, jad_jtVar.jad_kx), (int) Math.min(jad_erVar.jad_iv, jad_jtVar.jad_ly));
            } else {
                jad_erVar.jad_an((int) jad_jtVar.jad_kx, (int) jad_jtVar.jad_ly);
            }
            float f = jad_erVar.jad_fs;
            jad_erVar.jad_fs = 0.0f;
            jad_erVar.jad_an((int) f);
            jad_erVar.jad_an();
            jad_mzVar.jad_cp(jad_mzVar.jad_cp.getAnimatedFraction());
            jad_mzVar.jad_dq = jad_mzVar.jad_dq;
            Iterator it = new ArrayList(jad_mzVar.jad_hu).iterator();
            while (it.hasNext()) {
                jad_mz.jad_ob jad_obVar = (jad_mz.jad_ob) it.next();
                if (jad_obVar != null) {
                    jad_obVar.jad_an(jad_jtVar);
                }
                it.remove();
            }
            jad_mzVar.jad_hu.clear();
            jad_jtVar.jad_an.jad_an = jad_mzVar.jad_qd;
            Drawable.Callback callback = jad_mzVar.getCallback();
            if (callback instanceof ImageView) {
                ImageView imageView = (ImageView) callback;
                imageView.setImageDrawable(null);
                imageView.setImageDrawable(jad_mzVar);
            }
        }
        this.jad_ly = false;
        jad_bo();
        Drawable drawable = getDrawable();
        jad_mz jad_mzVar2 = this.jad_er;
        if (drawable != jad_mzVar2 || z) {
            if (!z) {
                boolean zJad_er = jad_mzVar2.jad_er();
                setImageDrawable(null);
                setImageDrawable(this.jad_er);
                if (zJad_er) {
                    this.jad_er.jad_jt();
                }
            }
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            Iterator<jad_qd> it2 = this.jad_pc.iterator();
            while (it2.hasNext()) {
                it2.next().jad_an(jad_jtVar);
            }
        }
    }

    public void setFailureListener(jad_ob<Throwable> jad_obVar) {
        this.jad_cp = jad_obVar;
    }

    public void setFallbackResource(int i) {
        this.jad_dq = i;
    }

    public void setFontAssetDelegate(com.jd.ad.sdk.jad_lu.jad_an jad_anVar) {
        jad_mz jad_mzVar = this.jad_er;
        jad_mzVar.jad_mz = jad_anVar;
        com.jd.ad.sdk.jad_py.jad_an jad_anVar2 = jad_mzVar.jad_ly;
        if (jad_anVar2 != null) {
            jad_anVar2.jad_er = jad_anVar;
        }
    }

    public void setFrame(int i) {
        this.jad_er.jad_an(i);
    }

    public void setIgnoreDisabledSystemAnimations(boolean z) {
        this.jad_er.jad_fs = z;
    }

    public void setImageAssetDelegate(com.jd.ad.sdk.jad_lu.jad_bo jad_boVar) {
        jad_mz jad_mzVar = this.jad_er;
        jad_mzVar.jad_kx = jad_boVar;
        com.jd.ad.sdk.jad_py.jad_bo jad_boVar2 = jad_mzVar.jad_iv;
        if (jad_boVar2 != null) {
            jad_boVar2.jad_cp = jad_boVar;
        }
    }

    public void setImageAssetsFolder(String str) {
        this.jad_er.jad_jw = str;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        jad_an();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        jad_an();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        jad_an();
        super.setImageResource(i);
    }

    public void setMaxFrame(int i) {
        this.jad_er.jad_bo(i);
    }

    public void setMaxFrame(String str) {
        this.jad_er.jad_an(str);
    }

    public void setMaxProgress(float f) {
        this.jad_er.jad_an(f);
    }

    public void setMinAndMaxFrame(String str) {
        this.jad_er.jad_bo(str);
    }

    public void setMinFrame(int i) {
        this.jad_er.jad_cp(i);
    }

    public void setMinFrame(String str) {
        this.jad_er.jad_cp(str);
    }

    public void setMinProgress(float f) {
        this.jad_er.jad_bo(f);
    }

    public void setOutlineMasksAndMattes(boolean z) {
        jad_mz jad_mzVar = this.jad_er;
        if (jad_mzVar.jad_re == z) {
            return;
        }
        jad_mzVar.jad_re = z;
        com.jd.ad.sdk.jad_tc.jad_bo jad_boVar = jad_mzVar.jad_ob;
        if (jad_boVar != null) {
            jad_boVar.jad_an(z);
        }
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        jad_mz jad_mzVar = this.jad_er;
        jad_mzVar.jad_qd = z;
        jad_jt jad_jtVar = jad_mzVar.jad_bo;
        if (jad_jtVar != null) {
            jad_jtVar.jad_an.jad_an = z;
        }
    }

    public void setProgress(float f) {
        this.jad_er.jad_cp(f);
    }

    public void setRenderMode(jad_wj jad_wjVar) {
        this.jad_ob = jad_wjVar;
        jad_bo();
    }

    public void setRepeatCount(int i) {
        this.jad_er.jad_cp.setRepeatCount(i);
    }

    public void setRepeatMode(int i) {
        this.jad_er.jad_cp.setRepeatMode(i);
    }

    public void setSafeMode(boolean z) {
        this.jad_er.jad_jt = z;
    }

    public void setScale(float f) {
        this.jad_er.jad_dq = f;
        Drawable drawable = getDrawable();
        jad_mz jad_mzVar = this.jad_er;
        if (drawable == jad_mzVar) {
            boolean zJad_er = jad_mzVar.jad_er();
            setImageDrawable(null);
            setImageDrawable(this.jad_er);
            if (zJad_er) {
                this.jad_er.jad_jt();
            }
        }
    }

    public void setSpeed(float f) {
        this.jad_er.jad_cp.jad_cp = f;
    }

    public void setTextDelegate(jad_yl jad_ylVar) {
        this.jad_er.getClass();
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        jad_mz jad_mzVar;
        if (!this.jad_ly && drawable == (jad_mzVar = this.jad_er) && jad_mzVar.jad_er()) {
            jad_cp();
        } else if (!this.jad_ly && (drawable instanceof jad_mz)) {
            jad_mz jad_mzVar2 = (jad_mz) drawable;
            if (jad_mzVar2.jad_er()) {
                jad_mzVar2.jad_hu.clear();
                jad_mzVar2.jad_cp.jad_hu();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    public final void jad_an(AttributeSet attributeSet, int i) {
        String string;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.LottieAnimationView, i, 0);
        this.jad_na = typedArrayObtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_cacheComposition, true);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_rawRes);
        boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_fileName);
        boolean zHasValue3 = typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_url);
        if (zHasValue && zHasValue2) {
            throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
        }
        if (zHasValue) {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.LottieAnimationView_lottie_rawRes, 0);
            if (resourceId != 0) {
                setAnimation(resourceId);
            }
        } else if (zHasValue2) {
            String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_fileName);
            if (string2 != null) {
                setAnimation(string2);
            }
        } else if (zHasValue3 && (string = typedArrayObtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_url)) != null) {
            setAnimationFromUrl(string);
        }
        setFallbackResource(typedArrayObtainStyledAttributes.getResourceId(R.styleable.LottieAnimationView_lottie_fallbackRes, 0));
        if (typedArrayObtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_autoPlay, false)) {
            this.jad_kx = true;
            this.jad_mz = true;
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_loop, false)) {
            this.jad_er.jad_cp.setRepeatCount(-1);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_repeatMode)) {
            setRepeatMode(typedArrayObtainStyledAttributes.getInt(R.styleable.LottieAnimationView_lottie_repeatMode, 1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_repeatCount)) {
            setRepeatCount(typedArrayObtainStyledAttributes.getInt(R.styleable.LottieAnimationView_lottie_repeatCount, -1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_speed)) {
            setSpeed(typedArrayObtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_speed, 1.0f));
        }
        setImageAssetsFolder(typedArrayObtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(typedArrayObtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_progress, 0.0f));
        boolean z = typedArrayObtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false);
        jad_mz jad_mzVar = this.jad_er;
        if (jad_mzVar.jad_na != z) {
            jad_mzVar.jad_na = z;
            if (jad_mzVar.jad_bo != null) {
                jad_mzVar.jad_bo();
            }
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_colorFilter)) {
            this.jad_er.jad_an(new com.jd.ad.sdk.jad_qz.jad_er("**"), jad_re.jad_mx, new com.jd.ad.sdk.jad_yh.jad_cp(new jad_xk(AppCompatResources.getColorStateList(getContext(), typedArrayObtainStyledAttributes.getResourceId(R.styleable.LottieAnimationView_lottie_colorFilter, -1)).getDefaultColor())));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_scale)) {
            this.jad_er.jad_dq = typedArrayObtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_scale, 1.0f);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_renderMode)) {
            int i2 = typedArrayObtainStyledAttributes.getInt(R.styleable.LottieAnimationView_lottie_renderMode, 0);
            if (i2 >= jad_wj.values().length) {
                i2 = 0;
            }
            setRenderMode(jad_wj.values()[i2]);
        }
        setIgnoreDisabledSystemAnimations(typedArrayObtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_ignoreDisabledSystemAnimations, false));
        typedArrayObtainStyledAttributes.recycle();
        jad_bo();
        this.jad_fs = true;
    }

    public void setAnimation(String str) {
        jad_uh<jad_jt> jad_uhVarJad_an;
        this.jad_jt = str;
        this.jad_hu = 0;
        if (isInEditMode()) {
            jad_uhVarJad_an = new jad_uh<>(new jad_fs(this, str), true);
        } else if (this.jad_na) {
            Context context = getContext();
            Map<String, jad_uh<jad_jt>> map = com.jd.ad.sdk.jad_lu.jad_hu.jad_an;
            String str2 = "asset_" + str;
            jad_uhVarJad_an = com.jd.ad.sdk.jad_lu.jad_hu.jad_an(str2, new jad_jw(StubApp.getOrigApplicationContext(context.getApplicationContext()), str, str2));
        } else {
            Context context2 = getContext();
            Map<String, jad_uh<jad_jt>> map2 = com.jd.ad.sdk.jad_lu.jad_hu.jad_an;
            jad_uhVarJad_an = com.jd.ad.sdk.jad_lu.jad_hu.jad_an((String) null, new jad_jw(StubApp.getOrigApplicationContext(context2.getApplicationContext()), str, null));
        }
        setCompositionTask(jad_uhVarJad_an);
    }
}
