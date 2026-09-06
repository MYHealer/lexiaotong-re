package com.ubix.ssp.ad.i;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.kwad.library.solder.lib.ext.PluginError;
import com.meishu.sdk.core.utils.MsAdPatternType;
import com.ubix.ssp.ad.d.i;
import com.ubix.ssp.ad.d.l;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.ad.g.f;
import com.ubix.ssp.ad.g.g;
import com.ubix.ssp.open.AdError;
import com.ubix.ssp.open.AdSize;
import com.ubix.ssp.open.ParamsReview;
import com.ubix.ssp.open.nativee.NativeAd;
import com.ubix.ssp.open.nativee.express.UBiXNativeExpressInteractionListener;
import com.ubix.ssp.open.nativee.express.UBiXNativeExpressVideoListener;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private f f9000a;
    private c b;
    private AdSize c;
    private SoftReference<Context> d;
    private ConcurrentHashMap<Integer, HashMap<String, Object>> e;

    public d(Context context, String str, f fVar) {
        this(context, str, new AdSize(-1, -2), fVar);
    }

    public d(Context context, String str, AdSize adSize, f fVar) {
        this.e = new ConcurrentHashMap<>();
        this.d = new SoftReference<>(context);
        this.f9000a = fVar;
        this.c = adSize == null ? new AdSize(-1, -2) : adSize;
        this.b = new c(context, str, this);
    }

    private int a(int i) {
        HashMap<String, Object> map = this.e.get(Integer.valueOf(i));
        if (map != null && map.get("native_ad_index_key") != null) {
            try {
                return Integer.parseInt(map.get("native_ad_index_key") + "");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    private AdError a(com.ubix.ssp.ad.d.a aVar) {
        int i;
        String str;
        com.ubix.ssp.ad.e.y.a.a.b.C1109b c1109b;
        if (aVar == null) {
            return com.ubix.ssp.ad.e.a0.a0.a.k(16, "广告模板Id异常,或资源与模板不匹配");
        }
        switch (aVar.p) {
            case 2001:
            case 2002:
            case 2003:
            case 2004:
            case 2005:
            case 2006:
            case 2007:
                com.ubix.ssp.ad.e.y.a.a.b.C1109b[] c1109bArr = aVar.f8604a.d.j;
                if (c1109bArr != null && c1109bArr.length != 0 && (c1109b = c1109bArr[0]) != null && !TextUtils.isEmpty(c1109b.c)) {
                    return null;
                }
                i = 10;
                str = "图片资源链接异常";
                break;
                break;
            case 2008:
            case 2009:
            case PluginError.ERROR_UPD_PLUGIN_CONNECTION /* 2010 */:
            default:
                return com.ubix.ssp.ad.e.a0.a0.a.k(16, "广告模板Id异常,或资源与模板不匹配");
            case 2011:
            case 2012:
            case 2013:
            case 2014:
                com.ubix.ssp.ad.e.y.a.a.b.l lVar = aVar.f8604a.d.k;
                if (lVar == null || TextUtils.isEmpty(lVar.c)) {
                    i = 13;
                    str = "封面图资源链接异常";
                } else {
                    com.ubix.ssp.ad.e.y.a.a.b.l lVar2 = aVar.f8604a.d.k;
                    if (lVar2 != null && !TextUtils.isEmpty(lVar2.b)) {
                        return null;
                    }
                    i = 12;
                    str = "视频资源链接异常";
                }
                break;
        }
        return com.ubix.ssp.ad.e.a0.a0.a.k(i, str);
    }

    private void a(int i, String str, Object obj) {
        HashMap<String, Object> map = this.e.get(Integer.valueOf(i));
        if (map != null) {
            map.put(str, obj);
            return;
        }
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put(str, obj);
        this.e.put(Integer.valueOf(i), map2);
    }

    public String a() {
        c cVar = this.b;
        if (cVar != null) {
            return cVar.B();
        }
        return null;
    }

    public void a(NativeAd nativeAd) {
        if (nativeAd == null) {
            return;
        }
        try {
            HashMap<String, Object> map = this.e.get(Integer.valueOf(nativeAd.hashCode()));
            if (map != null) {
                a aVar = (a) map.get("native_core_view");
                ViewGroup viewGroup = (ViewGroup) map.get("native_parent_view_key");
                if (viewGroup != null) {
                    viewGroup.removeAllViews();
                }
                if (aVar != null) {
                    aVar.j();
                }
                map.clear();
            }
            nativeAd.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(NativeAd nativeAd, long j) {
        this.b.a(this.b.n(a(nativeAd.hashCode())), j);
    }

    public void a(NativeAd nativeAd, UBiXNativeExpressInteractionListener uBiXNativeExpressInteractionListener) {
        a aVar;
        RelativeLayout relativeLayout;
        com.ubix.ssp.ad.e.y.a.a.b bVar;
        com.ubix.ssp.ad.e.y.a.a.b.C1108a c1108a;
        com.ubix.ssp.ad.e.y.a.a.b.e eVar;
        c cVar = this.b;
        if (cVar == null) {
            AdError adErrorG = com.ubix.ssp.ad.e.a0.a0.a.g(12, "参数异常");
            u.e("onAdRenderFailed in");
            if (uBiXNativeExpressInteractionListener != null) {
                uBiXNativeExpressInteractionListener.onAdRenderFailed(adErrorG);
            }
            u.e("onAdRenderFailed out");
            return;
        }
        cVar.v();
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        Bundle bundle = new Bundle();
        int iA = a(nativeAd.hashCode());
        try {
            l lVarP = this.b.p(iA);
            if (lVarP == null || iA < 0) {
                AdError adErrorG2 = com.ubix.ssp.ad.e.a0.a0.a.g(12, "参数异常");
                u.e("onAdRenderFailed in");
                if (uBiXNativeExpressInteractionListener != null) {
                    uBiXNativeExpressInteractionListener.onAdRenderFailed(adErrorG2);
                }
                u.e("onAdRenderFailed out");
                return;
            }
            if (!d(nativeAd)) {
                AdError adErrorG3 = com.ubix.ssp.ad.e.a0.a0.a.g(4, "文件已经过期");
                u.e("onAdRenderFailed in");
                if (uBiXNativeExpressInteractionListener != null) {
                    uBiXNativeExpressInteractionListener.onAdRenderFailed(adErrorG3);
                }
                u.e("onAdRenderFailed out");
                return;
            }
            com.ubix.ssp.ad.d.a aVarN = this.b.n(iA);
            bundle.putInt("AD_WIDTH", this.c.getWidth());
            bundle.putInt("AD_HEIGHT", this.c.getHeight());
            bundle.putString("TITLE", nativeAd.getDesc());
            bundle.putInt("TEMPLATE_ID", aVarN.p);
            if (lVarP.b()) {
                bundle.putString("AD_SOURCE", nativeAd.getAdSource());
            }
            bundle.putString("BUTTON_TEXT", nativeAd.getActionButtonText());
            bundle.putBoolean("AUTO_MUTE", lVarP.K0());
            bundle.putInt("AUTO_PLAY", lVarP.c());
            bundle.putBoolean("DO_NOT_RESTRICT_SIZE", true);
            bundle.putBoolean("IS_DOWNLOAD", nativeAd.isDownloadAd());
            bundle.putInt("VIDEO_RENDER_TYPE", lVarP.k0());
            bundle.putBoolean("isSlided", aVarN.t);
            bundle.putBoolean("IS_UNNAMED", lVarP.G0());
            com.ubix.ssp.ad.e.y.a.a aVar2 = aVarN.f8604a;
            if (aVar2 != null && (bVar = aVar2.d) != null && (c1108a = bVar.O) != null && (eVar = c1108a.b) != null) {
                bundle.putFloat("AD_MARGIN_LEFT", eVar.b);
                bundle.putFloat("AD_MARGIN_TOP", aVarN.f8604a.d.O.b.c);
                bundle.putFloat("AD_MARGIN_RIGHT", aVarN.f8604a.d.O.b.d);
                bundle.putFloat("AD_MARGIN_BOTTOM", aVarN.f8604a.d.O.b.e);
            }
            HashMap<String, Object> map = this.e.get(Integer.valueOf(nativeAd.hashCode()));
            Object obj = map.get("native_core_view");
            if (obj == null) {
                aVar = (a) com.ubix.ssp.ad.b.a(this.d.get(), bundle, 2, true);
                if (aVar == null) {
                    if (uBiXNativeExpressInteractionListener != null) {
                        uBiXNativeExpressInteractionListener.onAdRenderFailed(com.ubix.ssp.ad.e.a0.a0.a.g(6, "创建ViewClass失败，请勿重试"));
                        return;
                    }
                    return;
                }
            } else {
                aVar = (a) obj;
            }
            b bVar2 = new b(this.b, nativeAd, aVar, lVarP, this.e);
            bVar2.b(uBiXNativeExpressInteractionListener);
            bVar2.a(aVarN, uBiXNativeExpressInteractionListener, arrayList, arrayList2);
            if (aVar.getParent() == null && this.e != null && map.get("native_parent_view_key") != null && (relativeLayout = (RelativeLayout) map.get("native_parent_view_key")) != null) {
                relativeLayout.addView(aVar);
            }
            a(nativeAd.hashCode(), "native_core_view", aVar);
            a(nativeAd.hashCode(), "native_notify_id_key", Integer.valueOf(aVarN.o));
            a(nativeAd.hashCode(), "interaction_listener_key", uBiXNativeExpressInteractionListener);
            a(nativeAd.hashCode(), "native_images_array_key", arrayList);
            a(nativeAd.hashCode(), "native_videos_array_key", arrayList2);
            a(nativeAd.hashCode(), "native_single_render", bVar2);
        } catch (Throwable unused) {
            AdError adErrorG4 = com.ubix.ssp.ad.e.a0.a0.a.g(12, "参数异常");
            u.e("onAdRenderFailed in");
            if (uBiXNativeExpressInteractionListener != null) {
                uBiXNativeExpressInteractionListener.onAdRenderFailed(adErrorG4);
            }
            u.e("onAdRenderFailed out");
        }
    }

    public void a(NativeAd nativeAd, UBiXNativeExpressVideoListener uBiXNativeExpressVideoListener) {
        a(nativeAd.hashCode(), "video_listener_key", uBiXNativeExpressVideoListener);
    }

    public void a(NativeAd nativeAd, HashMap<String, String> map) {
        this.b.c(this.b.n(a(nativeAd.hashCode())), map);
    }

    public void a(String str) {
        this.b.h(str);
    }

    @Override // com.ubix.ssp.ad.g.g
    public void a(ArrayList<NativeAd> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            NativeAd nativeAd = arrayList.get(i);
            AdError adErrorA = a(this.b.n(i));
            if (adErrorA != null) {
                f fVar = this.f9000a;
                if (fVar != null) {
                    fVar.onAdLoadFailed(adErrorA);
                    return;
                }
                return;
            }
            i iVar = new i();
            iVar.a(nativeAd);
            iVar.a(this);
            iVar.a(nativeAd.isVideoAd());
            iVar.b(nativeAd.getVideoDuration());
            iVar.a(nativeAd.getCreativeType());
            iVar.a(nativeAd.getPrice());
            arrayList2.add(iVar);
            RelativeLayout relativeLayout = new RelativeLayout(this.d.get());
            relativeLayout.setId(MsAdPatternType.MIX_RENDER);
            String strG = this.b.p(i).G();
            if (!TextUtils.isEmpty(strG) && strG.startsWith("#")) {
                relativeLayout.setBackgroundColor(Color.parseColor(strG));
            }
            a(nativeAd.hashCode(), "native_ad_bean_key", nativeAd);
            a(nativeAd.hashCode(), "native_parent_view_key", relativeLayout);
            a(nativeAd.hashCode(), "native_ad_index_key", Integer.valueOf(i));
        }
        f fVar2 = this.f9000a;
        if (fVar2 != null) {
            fVar2.onAdLoadSucceed(arrayList2);
        }
    }

    public void a(HashMap<String, String> map) {
        c cVar = this.b;
        if (cVar != null) {
            cVar.a(map);
        }
    }

    public RelativeLayout b(NativeAd nativeAd) {
        try {
            HashMap<String, Object> map = this.e.get(Integer.valueOf(nativeAd.hashCode()));
            if (map != null) {
                return (RelativeLayout) map.get("native_parent_view_key");
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void b() {
        b(1);
    }

    public void b(int i) {
        this.b.m(i);
    }

    public ParamsReview c(NativeAd nativeAd) {
        try {
            return this.b.o(this.b.n(a(nativeAd.hashCode())));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean d(NativeAd nativeAd) {
        try {
            c cVar = this.b;
            if (cVar != null) {
                return cVar.s(cVar.n(a(nativeAd.hashCode())));
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.ubix.ssp.ad.g.g
    public void onAdLoadFailed(AdError adError) {
        f fVar = this.f9000a;
        if (fVar != null) {
            fVar.onAdLoadFailed(adError);
        }
    }
}
