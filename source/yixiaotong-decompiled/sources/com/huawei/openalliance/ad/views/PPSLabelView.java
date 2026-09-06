package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.gc;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.beans.metadata.AdSource;
import com.huawei.openalliance.ad.constant.bf;
import com.huawei.openalliance.ad.constant.cf;
import com.huawei.openalliance.ad.constant.s;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.ac;
import com.huawei.openalliance.ad.utils.aq;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.bg;
import com.huawei.openalliance.ad.utils.bj;
import com.huawei.openalliance.ad.utils.z;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class PPSLabelView extends TextView {
    public static final String Code = " ";
    private static final String F = "PPSLabelView";
    public static final int V = 4;
    protected boolean B;
    protected boolean C;
    private boolean D;
    protected WeakReference<gc> I;
    private AdContentData L;
    protected a S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f4491a;
    private Drawable b;
    private View.OnClickListener c;

    public interface a {
        void Code(gc gcVar, int[] iArr, int[] iArr2);
    }

    private static class b implements aq {
        private final WeakReference<PPSLabelView> Code;
        private String V;

        b(PPSLabelView pPSLabelView, String str) {
            this.Code = new WeakReference<>(pPSLabelView);
            this.V = str;
        }

        @Override // com.huawei.openalliance.ad.utils.aq
        public void Code() {
            fh.V(PPSLabelView.F, "start - dspLogo load failed");
            bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLabelView.b.2
                @Override // java.lang.Runnable
                public void run() {
                    PPSLabelView pPSLabelView = (PPSLabelView) b.this.Code.get();
                    if (pPSLabelView != null) {
                        pPSLabelView.setTextWhenImgLoadFail(b.this.V);
                    }
                }
            });
        }

        @Override // com.huawei.openalliance.ad.utils.aq
        public void Code(String str, final Drawable drawable) {
            fh.V(PPSLabelView.F, "start - dspLogo load onSuccess");
            if (drawable != null) {
                bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLabelView.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PPSLabelView pPSLabelView = (PPSLabelView) b.this.Code.get();
                        if (pPSLabelView != null) {
                            pPSLabelView.Code(b.this.V, drawable);
                        }
                    }
                });
            }
        }
    }

    private static class c implements RemoteCallResultCallback<String> {
        private final WeakReference<PPSLabelView> Code;
        private String V;

        c(PPSLabelView pPSLabelView, String str) {
            this.Code = new WeakReference<>(pPSLabelView);
            this.V = str;
        }

        @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
        public void onRemoteCallResult(String str, CallResult<String> callResult) {
            String data = callResult.getData();
            PPSLabelView pPSLabelView = this.Code.get();
            if (pPSLabelView != null) {
                if (TextUtils.isEmpty(data) || !data.startsWith(cf.CONTENT.toString())) {
                    bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLabelView.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PPSLabelView pPSLabelView2 = (PPSLabelView) c.this.Code.get();
                            if (pPSLabelView2 != null) {
                                pPSLabelView2.setTextWhenImgLoadFail(c.this.V);
                            }
                        }
                    });
                    return;
                }
                SourceParam sourceParam = new SourceParam();
                sourceParam.V(false);
                sourceParam.I(true);
                sourceParam.I(data);
                ac.Code(pPSLabelView.getContext(), sourceParam, new b(pPSLabelView, this.V));
            }
        }
    }

    public interface d {
        void Code(View view);
    }

    public PPSLabelView(Context context) {
        super(context);
        this.D = true;
        this.B = false;
        this.C = false;
        this.f4491a = true;
        this.c = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSLabelView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PPSLabelView.this.I != null) {
                    final gc gcVar = PPSLabelView.this.I.get();
                    if (gcVar == null) {
                        fh.I(PPSLabelView.F, "adView is null");
                        return;
                    }
                    final int[] iArrZ = bg.Z(view);
                    final int[] iArrB = bg.B(view);
                    if (z.Code(iArrZ, 2) && z.Code(iArrB, 2) && PPSLabelView.this.S != null) {
                        fh.V(PPSLabelView.F, "adLabelClickListener %s", PPSLabelView.this.S);
                        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLabelView.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PPSLabelView.this.S.Code(gcVar, iArrZ, iArrB);
                            }
                        });
                    }
                }
            }
        };
        Code(context);
    }

    public PPSLabelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.D = true;
        this.B = false;
        this.C = false;
        this.f4491a = true;
        this.c = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSLabelView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PPSLabelView.this.I != null) {
                    final gc gcVar = PPSLabelView.this.I.get();
                    if (gcVar == null) {
                        fh.I(PPSLabelView.F, "adView is null");
                        return;
                    }
                    final int[] iArrZ = bg.Z(view);
                    final int[] iArrB = bg.B(view);
                    if (z.Code(iArrZ, 2) && z.Code(iArrB, 2) && PPSLabelView.this.S != null) {
                        fh.V(PPSLabelView.F, "adLabelClickListener %s", PPSLabelView.this.S);
                        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLabelView.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PPSLabelView.this.S.Code(gcVar, iArrZ, iArrB);
                            }
                        });
                    }
                }
            }
        };
        Code(context);
    }

    public PPSLabelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.D = true;
        this.B = false;
        this.C = false;
        this.f4491a = true;
        this.c = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSLabelView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PPSLabelView.this.I != null) {
                    final gc gcVar = PPSLabelView.this.I.get();
                    if (gcVar == null) {
                        fh.I(PPSLabelView.F, "adView is null");
                        return;
                    }
                    final int[] iArrZ = bg.Z(view);
                    final int[] iArrB = bg.B(view);
                    if (z.Code(iArrZ, 2) && z.Code(iArrB, 2) && PPSLabelView.this.S != null) {
                        fh.V(PPSLabelView.F, "adLabelClickListener %s", PPSLabelView.this.S);
                        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLabelView.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PPSLabelView.this.S.Code(gcVar, iArrZ, iArrB);
                            }
                        });
                    }
                }
            }
        };
        Code(context);
    }

    private SpannableStringBuilder Code(SpannableString spannableString) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannableString);
        ImageSpan clickImageSpanRight = getClickImageSpanRight();
        if (clickImageSpanRight != null) {
            spannableStringBuilder.setSpan(clickImageSpanRight, spannableString.length() - 1, spannableString.length(), 33);
        }
        return spannableStringBuilder;
    }

    private void Code(Context context) {
        try {
            this.b = context.getResources().getDrawable(R.drawable.hiad_default_dsp_logo);
        } catch (Throwable unused) {
            fh.I(F, "init error");
        }
    }

    private ImageSpan getClickImageSpanRight() {
        try {
            Drawable drawable = getResources().getDrawable(R.drawable.hiad_chevron_right);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            if (!bg.I()) {
                return new com.huawei.openalliance.ad.views.b(drawable, 2, z.V(getContext(), 4.0f), 0);
            }
            return new com.huawei.openalliance.ad.views.b(getContext(), ac.V(drawable), 2, z.V(getContext(), 4.0f), 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    private String getDefaultAdSign() {
        return this.f4491a ? getResources().getString(R.string.hiad_ad_label_new) : "";
    }

    protected ImageSpan Code(Drawable drawable, boolean z) {
        Bitmap bitmapCode = ac.Code(drawable);
        if (bitmapCode == null) {
            fh.V(F, "originImage bitmap is null");
            return null;
        }
        float textSize = getTextSize();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmapCode, Math.round(textSize), Math.round(textSize), false));
        bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        return new com.huawei.openalliance.ad.views.b(bitmapDrawable, 2, 0, z ? z.V(getContext(), 4.0f) : 0);
    }

    protected void Code(AdSource adSource, String str) {
        if (adSource == null) {
            return;
        }
        String strV = bc.V(adSource.Code()) == null ? "" : bc.V(adSource.Code());
        if (str == null) {
            str = "";
        }
        String str2 = strV + str;
        String strV2 = adSource.V();
        if (TextUtils.isEmpty(strV) && TextUtils.isEmpty(strV2)) {
            fh.V(F, "displayTextWithDspInfo, use default adSign");
        } else if (TextUtils.isEmpty(strV) || !TextUtils.isEmpty(strV2)) {
            Code(str2, strV2);
        } else {
            fh.V(F, "displayTextWithDspInfo, use dspNameWithAdSign");
            setText(str2);
        }
    }

    public void Code(a aVar, gc gcVar, AdContentData adContentData, boolean z) {
        this.S = aVar;
        this.L = adContentData;
        this.C = z;
        this.I = new WeakReference<>(gcVar);
    }

    protected void Code(String str, Drawable drawable) {
        try {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(Code);
            String defaultAdSign = getDefaultAdSign();
            if (TextUtils.isEmpty(str)) {
                str = defaultAdSign;
            }
            boolean z = !TextUtils.isEmpty(str);
            spannableStringBuilder.append((CharSequence) str);
            ImageSpan imageSpanCode = Code(drawable, z);
            if (imageSpanCode != null) {
                spannableStringBuilder.setSpan(imageSpanCode, 0, 1, 33);
            }
            setClick(spannableStringBuilder);
        } catch (Throwable unused) {
            fh.I(F, "setTextWhenImgLoaded error");
        }
    }

    protected void Code(String str, String str2) {
        fh.V(F, "loadAndSetDspInfo, start");
        Code(str, this.b);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(bf.E, str2);
            com.huawei.openalliance.ad.ipc.g.V(getContext()).Code(s.i, jSONObject.toString(), new c(this, str), String.class);
        } catch (Throwable unused) {
            fh.I(F, "loadAndSetDspInfo error");
        }
    }

    public void Code(String str, String str2, String str3) {
        SpannableStringBuilder spannableStringBuilder;
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.isEmpty(str3)) {
            fh.V(F, "dspInfo all empty or logo2Text is empty");
            fh.V(F, "setTextWithDspInfo, use default adSign");
            spannableStringBuilder = new SpannableStringBuilder(getText());
        } else {
            if (str == null) {
                str = "";
            }
            if (str3 == null) {
                str3 = "";
            }
            String str4 = str + str3;
            if (TextUtils.isEmpty(str4) && TextUtils.isEmpty(str2)) {
                fh.V(F, "setTextWithDspInfo, use default adSign");
                spannableStringBuilder = new SpannableStringBuilder(getText());
            } else if (TextUtils.isEmpty(str4) || !TextUtils.isEmpty(str2)) {
                Code(str4, str2);
                return;
            } else {
                fh.V(F, "setTextWithDspInfo, use dspNameWithAdSign");
                setText(str4);
                spannableStringBuilder = new SpannableStringBuilder(getText());
            }
        }
        setClick(spannableStringBuilder);
    }

    public boolean Code() {
        return this.D;
    }

    public void V(AdSource adSource, String str) {
        if (adSource != null && !TextUtils.isEmpty(str)) {
            Code(adSource, str);
        } else {
            fh.V(F, "setTextWithDspInfo, use default adSign");
            setClick(new SpannableStringBuilder(getText()));
        }
    }

    public void setAdLabelClickListener(a aVar) {
        fh.V(F, "setAdLabelClickListener %s", aVar);
        this.S = aVar;
    }

    protected void setClick(SpannableStringBuilder spannableStringBuilder) {
        if (!this.C && !this.B) {
            setText(spannableStringBuilder);
            return;
        }
        spannableStringBuilder.append(Code);
        setText(Code(new SpannableString(spannableStringBuilder)));
        setOnClickListener(this.c);
    }

    public void setDataAndRefreshUi(AdContentData adContentData) {
        if (adContentData == null) {
            return;
        }
        this.L = adContentData;
        if (adContentData.S() != null) {
            this.D = "2".equalsIgnoreCase(adContentData.S().g());
        }
        if (this.D) {
            return;
        }
        setVisibility(8);
    }

    public void setTextForAppDetailView(AdSource adSource) {
        if (adSource == null) {
            fh.V(F, "setTextWithDspInfo, use default adSign");
        } else {
            this.f4491a = false;
            Code(adSource, "");
        }
    }

    protected void setTextWhenImgLoadFail(String str) {
        String defaultAdSign = getDefaultAdSign();
        if (TextUtils.isEmpty(str)) {
            str = defaultAdSign;
        }
        if (TextUtils.isEmpty(str) && !this.f4491a) {
            setVisibility(8);
        }
        setText(str);
        setClick(new SpannableStringBuilder(getText()));
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (!this.D) {
            i = 8;
        }
        super.setVisibility(i);
    }
}
