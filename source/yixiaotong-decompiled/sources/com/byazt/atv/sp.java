package com.byazt.atv;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.byazt.aas.nb;
import com.byazt.aas.or;
import com.byazt.ete.gr;
import com.byazt.ete.ic;
import com.byazt.ete.ma;
import com.byazt.ete.pu;
import com.byazt.ouz.sl;
import com.byazt.sz.gt;
import com.byazt.sz.rh;
import com.byazt.sz.yp;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.openalliance.ad.constant.x;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 134, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public class sp extends n implements c {
    public com.byazt.kdw.tt gu;
    public sl qy;

    public void c(com.byazt.kdw.tt ttVar) {
        this.gu = ttVar;
    }

    @Override // com.byazt.atv.c
    public void c(sl slVar) {
        this.qy = slVar;
    }

    @Override // com.byazt.atv.n, com.byazt.kn.uj
    public void c(CharSequence charSequence, int i, int i2, boolean z) {
    }

    public sp(Context context, ic icVar, tt ttVar, ViewGroup viewGroup) {
        super(context, icVar, ttVar, viewGroup);
        if (ttVar != null) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            uj.c(this.f1982a, this.c, ttVar.qp(), atomicBoolean);
            uj.tt(this.f1982a, this.c, ttVar.qp(), atomicBoolean);
        }
    }

    @Override // com.byazt.atv.n
    public JSONObject c() {
        return this.sp.n().optJSONObject("xTemplate");
    }

    @Override // com.byazt.atv.n
    public void tt(com.byazt.xl.sp spVar) {
        rh();
        this.c.c((rh) this);
        this.c.c((gt) this);
        ma maVarSp = pu.sp(this.f1982a);
        try {
            if (maVarSp != null) {
                this.ve = this.c.c(this.uj, this.n, maVarSp.n());
            } else {
                this.ve = this.c.c(this.uj, this.n, (JSONObject) null);
            }
            if (this.c.c()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("component_not_exist", new JSONArray((Collection) this.c.tt()));
                this.sp.or().c(jSONObject);
                spVar.c(138, "ugen unknown component");
                return;
            }
            if (this.c.ve()) {
                spVar.c(MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO, "ugen root disable");
                return;
            }
            if (this.ve != null) {
                if (this.rl == null) {
                    this.rl = new com.byazt.qmz.c(this.sp.n());
                }
                this.rl.c(this.c, this.ve);
            }
            this.sp.or().tt();
            this.sp.or().ve();
        } catch (NoClassDefFoundError unused) {
            if (spVar != null) {
                spVar.c(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID, "ugen no class def found error");
            }
        } catch (UnsatisfiedLinkError unused2) {
            if (spVar != null) {
                spVar.c(MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_DEVICE, "ugen yoga so load fail");
            }
        } catch (Throwable unused3) {
            if (spVar != null) {
                spVar.c(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID, "ugen other fail");
            }
        }
    }

    private void rh() {
        yp ypVar = new yp();
        HashMap map = new HashMap();
        if (this.f1982a != null) {
            map.put("shake_value", Integer.valueOf(this.f1982a.ge()));
            map.put("calculation_method", Integer.valueOf(this.f1982a.e()));
            map.put("rotation_angle", Integer.valueOf(this.f1982a.br()));
            map.put("calculation_method_twist", Integer.valueOf(this.f1982a.pe()));
            map.put("twist_config", this.f1982a.lv());
            map.put("image_info", com.byazt.jlk.tt.n(this.f1982a));
            map.put("cache_dir", com.byazt.bzd.sl.n());
            map.put("shake_interact_conf", this.f1982a.cy());
            map.put("twist_interact_conf", this.f1982a.yx());
        }
        ypVar.c(map);
        ypVar.c(this.tt);
        ypVar.c(this.uj);
        ypVar.tt(this.n);
        this.c.c("ad", ypVar);
    }

    @Override // com.byazt.atv.n
    public com.byazt.xj.ve a() {
        if (this.ve == null) {
            return null;
        }
        return this.ve.n("VideoV3");
    }

    @Override // com.byazt.atv.n
    public JSONObject sl() {
        return this.sp.n();
    }

    @Override // com.byazt.atv.n, com.byazt.sz.rh
    public void c(final com.byazt.xj.ve veVar, final String str, final com.byazt.pm.a.c cVar) {
        if (cVar == null) {
            return;
        }
        if (TextUtils.equals(str, "shake") || TextUtils.equals(str, x.cB)) {
            if (this.z == null || this.z.get() == null) {
                return;
            }
            or.c(this.z, new com.byazt.hkv.ve() { // from class: com.byazt.atv.sp.1
                @Override // com.byazt.hkv.ve
                public void c() {
                    if (sp.this.z == null || sp.this.z.get() == null || !or.c(sp.this.z.get())) {
                        return;
                    }
                    sp.this.tt(veVar, str, cVar);
                }
            });
            return;
        }
        tt(veVar, str, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(com.byazt.xj.ve veVar, String str, com.byazt.pm.a.c cVar) {
        CharSequence text;
        String strTt = cVar.tt();
        Map<String, Object> mapVe = cVar.ve();
        if (tt()) {
            HashMap map = new HashMap();
            map.put("ugen_click_event_params", this.yp);
            map.put("convert_action_type", Integer.valueOf(ve(str)));
            map.put("v3_trigger_name", str);
            if (com.byazt.qdk.c.c().c(cVar, this.f1982a, this.tt, veVar, sl(), this.u, map)) {
                return;
            }
        }
        if (com.byazt.kdw.c.c.contains(strTt)) {
            com.byazt.kdw.c.c(this.qy, this.gu, this.f1982a, this.tt, strTt, cVar, this.rh, veVar);
            return;
        }
        if ("uchain".equals(strTt)) {
            HashMap map2 = new HashMap();
            map2.put("material_meta", this.f1982a);
            map2.put("context", this.tt);
            map2.put("event_tag", nb.tt(this.f1982a));
            com.byazt.ppf.ve.c(this.f1982a, (HashMap<String, Object>) map2, cVar);
            return;
        }
        strTt.hashCode();
        int i = 3;
        switch (strTt) {
            case "openAppPermission":
                i = 10;
                break;
            case "openCommonUrl":
                i = 13;
                break;
            case "renderScene":
                if (mapVe != null) {
                    c(Objects.toString(mapVe.get(com.hihonor.adsdk.base.g.j.e.a.InterfaceC0437a.hnadsd), ""), Objects.toString(mapVe.get("ugen_id"), ""), Objects.toString(mapVe.get("ugen_md5"), ""), Objects.toString(mapVe.get("ugen_url"), ""), Objects.toString(mapVe.get("displayAreaAndroid"), ""), Objects.toString(mapVe.get("render_sequence"), ""));
                    return;
                }
                return;
            case "openPrivacy":
                i = 7;
                break;
            case "resumeVideo":
                sl slVar = this.qy;
                if (slVar != null) {
                    slVar.c(3);
                    return;
                }
                return;
            case "pauseVideo":
                sl slVar2 = this.qy;
                if (slVar2 != null) {
                    slVar2.c(2);
                    return;
                }
                return;
            case "skip":
                i = 6;
                break;
            case "close":
                i = 8;
                break;
            case "openAppFunction":
                i = 12;
                break;
            case "dismissScene":
                if (mapVe != null) {
                    c(Objects.toString(mapVe.get(com.hihonor.adsdk.base.g.j.e.a.InterfaceC0437a.hnadsd), ""));
                    return;
                }
                return;
            case "videoControl":
                i = 4;
                break;
            case "convert":
                i = 2;
                break;
            case "muteVideo":
                i = 5;
                break;
            case "openAppPolicy":
                i = 9;
                break;
            case "dislike":
                break;
            default:
                i = 0;
                break;
        }
        gr.c cVarC = new gr.c().uj(this.yp.nu()).ve(this.yp.rh()).tt(this.yp.my()).c(this.yp.gt()).c(veVar.eo()).tt(this.yp.z()).c(this.yp.m()).c(tt(str));
        JSONObject jSONObject = new JSONObject();
        int iVe = ve(str);
        if (iVe > 0) {
            try {
                jSONObject.put("convertActionType", iVe);
            } catch (Throwable unused) {
            }
        }
        try {
            Object obj = mapVe.get("webUrl");
            Object obj2 = mapVe.get("webTitle");
            String strC = com.byazt.wj.tt.c(Objects.toString(obj, ""), sl());
            String strC2 = com.byazt.wj.tt.c(Objects.toString(obj2, ""), sl());
            jSONObject.put("openCommonWebUrl", strC);
            jSONObject.put("openCommonWebTitle", strC2);
        } catch (JSONException unused2) {
        }
        View viewI = veVar.i();
        try {
            if ((viewI instanceof TextView) && (text = ((TextView) viewI).getText()) != null && text.toString().contains(com.hihonor.adsdk.base.c.g1.hnadsa)) {
                jSONObject.put("is_compliant_download", true);
            }
        } catch (JSONException unused3) {
        }
        cVarC.c(jSONObject);
        gr grVarC = cVarC.c();
        if (this.i != null) {
            this.i.c(viewI, i, grVarC, -1);
        }
    }

    public static byte tt(String str) {
        if (TextUtils.isEmpty(str)) {
            return (byte) 0;
        }
        str.hashCode();
        switch (str) {
            case "tap":
                return (byte) 1;
            case "shake":
                return (byte) 3;
            case "slide":
                return (byte) 2;
            case "twist":
                return (byte) 4;
            case "longTap":
                return (byte) 5;
            default:
                return (byte) 0;
        }
    }

    private int ve(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        str.hashCode();
        if (str.equals("shake")) {
            return 1;
        }
        return !str.equals(x.cB) ? 0 : 2;
    }

    public void c(String str, Map<String, String> map) {
        if (this.ve == null) {
            return;
        }
        com.byazt.pm.a.c cVar = new com.byazt.pm.a.c();
        cVar.c(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM);
        cVar.tt("emit");
        HashMap map2 = new HashMap();
        if (map != null) {
            map2.putAll(map);
        }
        map2.put("name", str);
        cVar.c(map2);
        com.byazt.vd.c.C0303c.c(this.ve, "jsb", cVar).c();
    }
}
