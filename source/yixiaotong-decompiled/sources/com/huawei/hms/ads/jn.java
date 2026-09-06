package com.huawei.hms.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.huawei.openalliance.ad.beans.metadata.ImageInfo;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.ad.inter.data.VideoInfo;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jn {
    private static final String Code = "TemplateActionProcessor";
    private static jn I;
    private static final byte[] V = new byte[0];
    private String B = null;
    private String C = null;
    private WeakReference<Context> S;
    private Context Z;

    private jn(Context context) {
        this.Z = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    public static jn Code(Context context) {
        return V(context);
    }

    private void Code(Context context, AdContentData adContentData, String str) {
        ji.a aVar = new ji.a();
        aVar.Code((Long) null).Code((Integer) null).V((Integer) 14).I(com.huawei.openalliance.ad.utils.b.Code(context)).Code(str).B(String.format("%s,%s", 0, 0));
        jk.Code(this.Z, adContentData, aVar.Code());
    }

    private boolean Code(Context context, AdContentData adContentData, Bundle bundle, String str, String str2) {
        try {
            int i = bundle.getInt(com.huawei.openalliance.ad.constant.br.f.e);
            int i2 = bundle.getInt(com.huawei.openalliance.ad.constant.br.f.f);
            int i3 = bundle.getInt(com.huawei.openalliance.ad.constant.br.f.k);
            MaterialClickInfo materialClickInfo = (MaterialClickInfo) com.huawei.openalliance.ad.utils.ad.V(bundle.getString("click_info"), MaterialClickInfo.class, new Class[0]);
            kr krVarCode = ks.Code(context, adContentData, new HashMap(0));
            if (materialClickInfo != null) {
                materialClickInfo.V(str2);
            }
            if (krVarCode.Code()) {
                if (str2.equals(com.huawei.openalliance.ad.constant.s.B)) {
                    Code(context, adContentData, (materialClickInfo == null || !com.huawei.openalliance.ad.utils.bc.L(materialClickInfo.I())) ? null : materialClickInfo.I());
                }
                jk.Code(this.Z, adContentData, i, i2, krVarCode.Z(), i3, materialClickInfo, str, (int[]) null);
                if (HiAd.getInstance(this.Z).getExtensionActionListener() == null) {
                    return true;
                }
                HiAd.getInstance(this.Z).getExtensionActionListener().Z(adContentData.aa());
                return true;
            }
        } catch (Throwable th) {
            fh.I(Code, "deal with click err: %s", th.getClass().getSimpleName());
        }
        return false;
    }

    private static jn V(Context context) {
        jn jnVar;
        synchronized (V) {
            if (I == null) {
                I = new jn(context);
            }
            if (context instanceof Activity) {
                I.S = new WeakReference<>(context);
            }
            jnVar = I;
        }
        return jnVar;
    }

    public void Code(AdContentData adContentData) {
        fh.V(Code, "onPrepare");
        if (HiAd.getInstance(this.Z).getExtensionActionListener() == null || adContentData == null) {
            return;
        }
        HiAd.getInstance(this.Z).getExtensionActionListener().Code(adContentData.aa());
    }

    public void Code(AdContentData adContentData, int i) {
        if (HiAd.getInstance(this.Z).getExtensionActionListener() == null || adContentData == null) {
            return;
        }
        String str = this.C;
        if (str == null || !str.equals(adContentData.aa())) {
            fh.V(Code, "onFail");
            this.C = adContentData.aa();
            HiAd.getInstance(this.Z).getExtensionActionListener().Code(adContentData.aa(), i);
        }
    }

    public void Code(AdContentData adContentData, Bundle bundle) {
        Context context;
        try {
            fh.V(Code, "onEnd");
            Long lValueOf = Long.valueOf(bundle.getLong("startTime"));
            Long lValueOf2 = Long.valueOf(bundle.getLong(com.huawei.openalliance.ad.constant.br.f.h));
            Integer numValueOf = Integer.valueOf(bundle.getInt(com.huawei.openalliance.ad.constant.br.f.i));
            Integer numValueOf2 = Integer.valueOf(bundle.getInt(com.huawei.openalliance.ad.constant.br.f.j));
            if (bundle.getBoolean(com.huawei.openalliance.ad.constant.br.f.x, false)) {
                HashMap map = new HashMap();
                map.put(com.huawei.openalliance.ad.constant.bf.r, bundle.getString(com.huawei.openalliance.ad.constant.bf.r));
                map.put(com.huawei.openalliance.ad.constant.bf.q, String.valueOf(bundle.getInt(com.huawei.openalliance.ad.constant.bf.q)));
                map.put(com.huawei.openalliance.ad.constant.bf.p, String.valueOf(10));
                map.put(com.huawei.openalliance.ad.constant.bf.aP, bundle.getString(com.huawei.openalliance.ad.constant.bf.aP));
                map.put(com.huawei.openalliance.ad.constant.bf.m, bundle.getString(com.huawei.openalliance.ad.constant.bf.m));
                map.put(com.huawei.openalliance.ad.constant.bf.s, bundle.getString(com.huawei.openalliance.ad.constant.bf.s));
                map.put(com.huawei.openalliance.ad.constant.bf.aO, bundle.getString(com.huawei.openalliance.ad.constant.bf.aO));
                VideoInfo videoInfo = (VideoInfo) com.huawei.openalliance.ad.utils.ad.V(bundle.getString(com.huawei.openalliance.ad.constant.bf.aO), VideoInfo.class, new Class[0]);
                if (videoInfo != null) {
                    videoInfo.I(Boolean.TRUE.toString());
                    videoInfo.Code(bundle.getInt(com.huawei.openalliance.ad.constant.bf.q));
                    videoInfo.Code(bundle.getString(com.huawei.openalliance.ad.constant.bf.r));
                }
                ImageInfo imageInfo = (ImageInfo) com.huawei.openalliance.ad.utils.ad.V(bundle.getString(com.huawei.openalliance.ad.constant.bf.aP), ImageInfo.class, new Class[0]);
                if (imageInfo != null) {
                    com.huawei.openalliance.ad.inter.data.ImageInfo imageInfo2 = new com.huawei.openalliance.ad.inter.data.ImageInfo(imageInfo);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(imageInfo2);
                    map.put(com.huawei.openalliance.ad.constant.bf.aP, com.huawei.openalliance.ad.utils.ad.Code(arrayList));
                }
                map.put(com.huawei.openalliance.ad.constant.bf.aO, com.huawei.openalliance.ad.utils.ad.Code(videoInfo));
                map.put(com.huawei.openalliance.ad.constant.bf.aQ, bundle.getString(com.huawei.openalliance.ad.constant.bf.aQ));
                Context context2 = this.Z;
                WeakReference<Context> weakReference = this.S;
                if (weakReference != null && (context = weakReference.get()) != null) {
                    context2 = context;
                }
                ks.Code(context2, adContentData, map).Code();
            }
            jk.Code(this.Z, adContentData, com.huawei.openalliance.ad.constant.aj.L, lValueOf, lValueOf2, numValueOf, numValueOf2);
            V(adContentData);
        } catch (Throwable th) {
            fh.I(Code, "onEnd err: %s", th.getClass().getSimpleName());
        }
    }

    public void Code(AdContentData adContentData, String str) {
        fh.V(Code, "onShow");
        ji.a aVar = new ji.a();
        aVar.I(str);
        aVar.B(com.huawei.openalliance.ad.constant.x.dD);
        jk.Code(this.Z, adContentData, aVar.Code(), com.huawei.openalliance.ad.constant.aj.b);
        if (HiAd.getInstance(this.Z).getExtensionActionListener() == null || adContentData == null) {
            return;
        }
        HiAd.getInstance(this.Z).getExtensionActionListener().I(adContentData.aa());
    }

    public boolean Code(Context context, AdContentData adContentData, Bundle bundle, String str) {
        fh.V(Code, "onClick");
        return Code(context, adContentData, bundle, str, com.huawei.openalliance.ad.constant.s.B);
    }

    public void I(AdContentData adContentData, Bundle bundle) {
        int i = -1;
        try {
            i = bundle.getInt(com.huawei.openalliance.ad.constant.br.f.m);
            if (!bundle.getBoolean(com.huawei.openalliance.ad.constant.br.f.w, true)) {
                ks.Code(this.Z, adContentData, new HashMap(0)).Code();
            }
        } catch (Throwable th) {
            fh.V(Code, "get errCode err: %s", th.getClass().getSimpleName());
        }
        Code(adContentData, i);
    }

    public void V(AdContentData adContentData) {
        if (HiAd.getInstance(this.Z).getExtensionActionListener() == null || adContentData == null) {
            if (adContentData != null || HiAd.getInstance(this.Z).getExtensionActionListener() == null) {
                return;
            }
            HiAd.getInstance(this.Z).getExtensionActionListener().V(null);
            return;
        }
        String str = this.B;
        if (str == null || !str.equals(adContentData.aa())) {
            fh.V(Code, "onDismiss");
            this.B = adContentData.aa();
            HiAd.getInstance(this.Z).getExtensionActionListener().V(adContentData.aa());
        }
    }

    public void V(AdContentData adContentData, Bundle bundle) {
        try {
            fh.V(Code, "onClose");
            jk.Code(this.Z, adContentData, bundle.getInt(com.huawei.openalliance.ad.constant.br.f.e), bundle.getInt(com.huawei.openalliance.ad.constant.br.f.f), com.huawei.openalliance.ad.constant.aj.f4435a);
            V(adContentData);
        } catch (Throwable th) {
            fh.I(Code, "onClose err: %s", th.getClass().getSimpleName());
        }
    }

    public boolean V(Context context, AdContentData adContentData, Bundle bundle, String str) {
        fh.V(Code, "onEasterEggClick");
        return Code(context, adContentData, bundle, str, com.huawei.openalliance.ad.constant.s.c);
    }
}
