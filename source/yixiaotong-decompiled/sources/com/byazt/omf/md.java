package com.byazt.omf;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import com.byazt.aas.nb;
import com.byazt.apd.EcBackUpWebView;
import com.byazt.nys.PluginConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.google.android.exoplayer2.C;
import com.huawei.openalliance.ad.constant.br;
import com.ubixnow.ooooo.oOOOoo00;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 31, MediaPlayer.MEDIA_PLAYER_OPTION_IS_TOO_LARGE_AV_DIFF})
public class md implements Function<SparseArray<Object>, Object> {
    public final PluginValueSet c = com.byazt.rl.c.c().c(11, com.byazt.lq.uj.c(new Supplier<Integer>() { // from class: com.byazt.omf.md.1
        @Override // java.util.function.Supplier
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Integer get() {
            return Integer.valueOf(x.m().pu());
        }
    })).c(12, "7.6.1.1").tt();

    public void register(Object obj) {
        if (x.m().lr()) {
            tt(obj);
        }
        if (obj instanceof Bundle) {
            Bundle bundle = (Bundle) obj;
            if (bundle.containsKey(PluginConstants.KEY_PL_CONFIG_INFO)) {
                x.m().c(bundle.getBundle(PluginConstants.KEY_PL_CONFIG_INFO));
                if (x.m().cu().length() == 0 || com.byazt.aas.u.tt()) {
                    return;
                }
                com.byazt.zj.tt.tt().ve();
                return;
            }
            return;
        }
        if (obj instanceof Function) {
            Function<SparseArray<Object>, Object> function = (Function) obj;
            Object objApply = function.apply(com.byazt.yxi.uj.c().c(C.RATE_UNSET_INT).c(String.class).tt());
            if ((objApply instanceof String) && "TTAdInteractionListener".equals(objApply)) {
                c(new com.byazt.ocd.tt(function));
                return;
            } else if (!com.byazt.sq.ve.tt(obj)) {
                c(function);
                return;
            }
        }
        if ((p.x() || nb.x().equals("com.pangolin_demo.toutiao")) && obj != null) {
            com.byazt.sq.ve.c(obj);
        }
        if (p.uj >= 7400 || !(obj instanceof TTAdInteractionListener)) {
            return;
        }
        c(new com.byazt.ocd.tt(new com.byazt.wrq.n((TTAdInteractionListener) obj)));
    }

    private void c(Object obj) {
        x.m().nb().apply(com.byazt.yxi.uj.c().c(162).c(0, new com.byazt.aas.zb().c(br.f.s, obj)).c(Void.class).tt());
    }

    @DungeonFlag
    private void tt(Object obj) {
        if (obj instanceof Function) {
            Function function = (Function) obj;
            if (c(function, "qa_common_tool")) {
                com.byazt.lj.ve.setQATool(function);
                com.byazt.yxi.uj ujVarC = com.byazt.yxi.uj.c();
                ujVarC.c(10002).c(Void.class);
                ujVarC.c(20002, com.byazt.lj.ve.getInstance());
                function.apply(ujVarC.tt());
            }
        }
    }

    private boolean c(Function function, String str) {
        com.byazt.yxi.uj ujVarC = com.byazt.yxi.uj.c();
        ujVarC.c(10004).c(String.class);
        return str.equals(function.apply(ujVarC.tt()));
    }

    public h createLoader(Context context) {
        return new h(context);
    }

    public SparseArray<Object> values() {
        return this.c.sparseArray();
    }

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray != null) {
            PluginValueSet pluginValueSetTt = com.byazt.rl.c.c(sparseArray).tt();
            int iIntValue = pluginValueSetTt.intValue(-99999987);
            if (iIntValue == -99999986) {
                PluginValueSet pluginValueSet = this.c;
                if (pluginValueSet != null) {
                    return pluginValueSet.sparseArray();
                }
            } else {
                if (iIntValue == -999800) {
                    return new h((Context) pluginValueSetTt.objectValue(-998000, Context.class));
                }
                if (iIntValue == 16) {
                    x.m().c(pluginValueSetTt.booleanValue(17, false), (SparseArray<Object>) pluginValueSetTt.objectValue(21, SparseArray.class));
                    return null;
                }
                if (iIntValue == 19) {
                    Bundle bundle = (Bundle) pluginValueSetTt.objectValue(20, Bundle.class);
                    if (bundle != null) {
                        int i = bundle.getInt(com.hihonor.adsdk.base.g.j.e.a.v, -1);
                        int i2 = bundle.getInt("event_type", -1);
                        String string = bundle.getString("package_name");
                        String strVe = com.byazt.nr.c.ve(bundle.getString("event_token"));
                        com.byazt.qt.c cVar = new com.byazt.qt.c();
                        try {
                            JSONObject jSONObject = new JSONObject(strVe);
                            cVar.a(jSONObject.optString("tag"));
                            cVar.sp(jSONObject.optString(oOOOoo00.OooOo0o));
                            cVar.uj(jSONObject.optString("log_extra"));
                            cVar.i(jSONObject.optString("download_url"));
                            cVar.x(jSONObject.optString("save_path"));
                        } catch (JSONException unused) {
                        }
                        cVar.c(i);
                        cVar.ve(string);
                        return com.byazt.dk.z.c(cVar, i2);
                    }
                    return new Bundle();
                }
                if (iIntValue == 999801) {
                    return this;
                }
                switch (iIntValue) {
                    case 1:
                        setThemeStatus(pluginValueSetTt != null ? pluginValueSetTt.intValue(11) : -1);
                        break;
                    case 2:
                        return getBiddingToken(com.byazt.rl.c.c(pluginValueSetTt).tt(), pluginValueSetTt.booleanValue(13), pluginValueSetTt.intValue(14));
                    case 3:
                        requestPermissionIfNecessary((Context) pluginValueSetTt.objectValue(7, Context.class));
                        break;
                    case 4:
                        register(pluginValueSetTt.objectValue(8, Object.class));
                        break;
                    case 5:
                        unregister(pluginValueSetTt.objectValue(8, Function.class));
                        break;
                    case 6:
                        return getExtra((Class) pluginValueSetTt.objectValue(9, Class.class), (Bundle) pluginValueSetTt.objectValue(10, Bundle.class));
                    default:
                        return null;
                }
            }
        }
        return null;
    }

    private void c(Function<SparseArray<Object>, Object> function) {
        if (function != null && com.byazt.rl.c.c(com.byazt.yxi.ve.c(function)).tt().intValue(10000) == 1 && p.x()) {
            com.byazt.apd.tt.c().c(function);
        }
    }

    public void unregister(Object obj) {
        if ((p.x() || nb.x().equals("com.pangolin_demo.toutiao")) && obj != null) {
            com.byazt.sq.ve.ve(obj);
        }
    }

    /* JADX WARN: Type inference failed for: r6v13, types: [T, java.util.HashMap, java.util.Map] */
    public <T> T getExtra(Class<T> cls, Bundle bundle) {
        if (bundle != null) {
            bundle.getInt("type");
        }
        if (com.byazt.sq.uj.c(cls, bundle)) {
            return (T) com.byazt.sq.uj.c(com.byazt.ue.a.c(gt.getContext()), cls, bundle);
        }
        boolean z = false;
        if (cls == SparseArray.class || (cls != null && "com.bytedance.sdk.openadsdk.AdConfig".equals(cls.getName()))) {
            if (bundle != null && !bundle.keySet().isEmpty()) {
                if (bundle.containsKey("is_paid")) {
                    x.m().n(bundle.getBoolean("is_paid"));
                }
                if (bundle.containsKey("extra_data")) {
                    x.m().sp(bundle.getString("extra_data"));
                }
                if (bundle.containsKey(com.hihonor.adsdk.base.c.y.hnadsa)) {
                    x.m().x(bundle.getString(com.hihonor.adsdk.base.c.y.hnadsa));
                }
                if (bundle.containsKey("quit_work")) {
                    x.m().c(bundle.getBoolean("quit_work", false), (SparseArray<Object>) null);
                }
            }
        } else if (cls == Bundle.class) {
            if (bundle == null) {
                return null;
            }
            int i = bundle.getInt("action", 0);
            if (i == 0) {
                x.m().c(bundle.getString("plugin_pkg_name"), bundle.getString(PluginConstants.KEY_PLUGIN_VERSION));
            } else if (i == 1) {
                com.byazt.ukr.yp.c().tt(bundle.getString("event_name"), bundle.getString("event_extra"));
            } else if (i == 2) {
                clearFullRewardCache();
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(MediationConstant.RIT_TYPE_SPLASH, 0);
                    jSONObject.put("reward", 0);
                    jSONObject.put("brand", 0);
                    jSONObject.put("other", 0);
                    com.byazt.ri.c.c(jSONObject);
                    com.byazt.bzd.sl.c(0).clearCache();
                    com.byazt.ri.c.c(gt.tt().st());
                } catch (Throwable th) {
                    com.byazt.nr.m.ve(th.getMessage());
                }
            }
        } else {
            if (cls == View.class) {
                return (T) new EcBackUpWebView(gt.getContext());
            }
            if (cls == Map.class) {
                ?? r6 = (T) new HashMap();
                if (bundle != null && bundle.getString("extra_name").equals("use_mediation_map")) {
                    if (com.byazt.nta.c.isSdkInitSuccess() && gt.tt().cx() && com.byazt.nta.c.hasDispatchAdSdkInitializer()) {
                        z = true;
                    }
                    r6.put("use_mediation_map", Boolean.valueOf(z));
                }
                return r6;
            }
            if (cls == Function.class && bundle != null && bundle.getInt("action", 0) == 4) {
                return (T) com.byazt.zlb.uj.create();
            }
        }
        return null;
    }

    public void requestPermissionIfNecessary(Context context) {
        if (context == null) {
            return;
        }
        com.byazt.dj.uj ujVarMy = x.m().my();
        if (ujVarMy != null) {
            boolean zIsCanUseLocation = ujVarMy.isCanUseLocation();
            boolean zIsCanUsePhoneState = ujVarMy.isCanUsePhoneState();
            boolean zIsCanUseWriteExternal = ujVarMy.isCanUseWriteExternal();
            if (!zIsCanUseLocation && !zIsCanUsePhoneState && !zIsCanUseWriteExternal) {
                return;
            }
        }
        Intent intent = new Intent(context, (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 2);
        if (context != null) {
            com.byazt.nr.tt.c(context, intent, null);
        }
    }

    public String getBiddingToken(PluginValueSet pluginValueSet, boolean z, int i) {
        if (pluginValueSet == null || gt.c() == null) {
            return null;
        }
        return gt.c().c(new com.byazt.dj.tt(pluginValueSet.sparseArray(), com.byazt.vxy.c.tt()), z, i);
    }

    public void setThemeStatus(int i) {
        if (i != x.m().pu()) {
            x.m().n(i);
            Intent intent = new Intent();
            intent.setAction("com.bytedance.openadsdk.themeTypeChangeReceiver");
            intent.putExtra("theme_status_change", i);
            gt.getContext().sendBroadcast(intent, nb.p());
        }
    }

    public int getThemeStatus() {
        return x.m().pu();
    }

    public void clearFullRewardCache() {
        com.byazt.aas.eo.c("open_ad_sdk_union_meta_cache_kv").clear();
        com.byazt.aas.eo.c("tt_materialMeta").clear();
        com.byazt.aas.eo.c("tt_splash").clear();
    }
}
