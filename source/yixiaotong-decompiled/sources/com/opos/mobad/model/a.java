package com.opos.mobad.model;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.hihonor.adsdk.base.c;
import com.opos.cmn.d.d;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.AdxAdExtInfoData;
import com.opos.mobad.model.data.AppPrivacyData;
import com.opos.mobad.model.data.FloatLayerData;
import com.opos.mobad.model.data.InteractionSensorData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import com.opos.mobad.model.utils.AdHelper;
import com.opos.mobad.template.d.f;
import java.text.DecimalFormat;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {
    private static com.opos.mobad.template.d.a a(AppPrivacyData appPrivacyData) {
        if (appPrivacyData == null) {
            return null;
        }
        return new com.opos.mobad.template.d.a(appPrivacyData.d, appPrivacyData.c);
    }

    public static final f a(Context context, com.opos.mobad.b bVar, AdItemData adItemData, MaterialData materialData, boolean z, int i) {
        return a(context, bVar, adItemData, materialData, z, materialData.W(), i);
    }

    public static final f a(Context context, com.opos.mobad.b bVar, AdItemData adItemData, MaterialData materialData, boolean z, boolean z2, int i) {
        return a(context, bVar, adItemData, materialData, z, materialData.W(), i, true);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:38:0x0131  */
    /* JADX WARN: Code duplicated, block: B:39:0x0139  */
    /* JADX WARN: Code duplicated, block: B:42:0x019f  */
    /* JADX WARN: Code duplicated, block: B:43:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:46:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:49:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:52:0x0231  */
    /* JADX WARN: Code duplicated, block: B:55:0x0242  */
    /* JADX WARN: Code duplicated, block: B:58:0x0253  */
    /* JADX WARN: Code duplicated, block: B:61:0x0264  */
    /* JADX WARN: Code duplicated, block: B:66:0x0274 A[LOOP:0: B:64:0x026e->B:66:0x0274, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:69:0x028c  */
    /* JADX WARN: Code duplicated, block: B:72:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:75:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:84:0x02f1  */
    public static final f a(Context context, com.opos.mobad.b bVar, AdItemData adItemData, MaterialData materialData, boolean z, boolean z2, int i, boolean z3) {
        int i2;
        int i3;
        double dOptDouble;
        int iOptInt;
        double dOptDouble2;
        f fVar;
        long jS;
        int i4;
        com.opos.mobad.template.e.a aVarA;
        MaterialFileData materialFileDataL;
        MaterialFileData materialFileDataM;
        MaterialFileData materialFileDataN;
        List<MaterialFileData> listE;
        List<MaterialFileData> listH;
        int i5;
        List<MaterialFileData> listD;
        Context context2;
        com.opos.cmn.an.f.a.b("AdShowDataWrapper", "transformData");
        InteractionSensorData interactionSensorDataAj = adItemData.aj();
        int iA = interactionSensorDataAj.a();
        int iB = interactionSensorDataAj.b();
        int i6 = adItemData.F() == 2 ? 1 : 0;
        List<AdxAdExtInfoData> listAh = materialData.ah();
        if (listAh == null || listAh.isEmpty()) {
            i2 = iA;
            i3 = iB;
            dOptDouble = 0.0d;
            iOptInt = 0;
            dOptDouble2 = 0.0d;
        } else {
            AdxAdExtInfoData adxAdExtInfoData = listAh.get(0);
            if (adxAdExtInfoData.b == null || adxAdExtInfoData.b.isEmpty()) {
                i2 = iA;
                i3 = iB;
                dOptDouble = 0.0d;
                iOptInt = 0;
                dOptDouble2 = 0.0d;
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(adxAdExtInfoData.b.get(0));
                    i2 = iA;
                    i3 = iB;
                    try {
                        dOptDouble2 = jSONObject.optDouble("qponValue", -1.0d);
                        try {
                            dOptDouble = jSONObject.optDouble("qponThreshold", -1.0d);
                            try {
                                iOptInt = jSONObject.optInt("qponType", -1);
                                try {
                                    com.opos.cmn.an.f.a.b("AdShowDataWrapper", "contentType：" + i6 + "QponType: " + iOptInt + " QponValue: " + dOptDouble2 + " QponThreshold: " + dOptDouble);
                                    dOptDouble2 = dOptDouble2;
                                } catch (Exception e) {
                                    e = e;
                                    dOptDouble2 = dOptDouble2;
                                    com.opos.cmn.an.f.a.d("AdShowDataWrapper", "QPON JSON fail exception : " + e.getMessage());
                                }
                            } catch (Exception e2) {
                                e = e2;
                                iOptInt = 0;
                                com.opos.cmn.an.f.a.d("AdShowDataWrapper", "QPON JSON fail exception : " + e.getMessage());
                                com.opos.cmn.an.f.a.b("AdShowDataWrapper", "InteractionSensorData:" + interactionSensorDataAj);
                                fVar = new f();
                                f fVarG = fVar.a(materialData.g()).b(materialData.f()).a(adItemData.j()).c(adItemData.E()).d(a(context, adItemData, materialData, z)).f(adItemData.k()).g(materialData.g);
                                if (adItemData.P() > 0) {
                                    jS = adItemData.P();
                                } else {
                                    jS = materialData.s();
                                }
                                f fVarB = fVarG.a(jS, materialData.t() * 1000).e(adItemData.b()).h(adItemData.X()).a(a(adItemData.T())).i(a(materialData.Y())).h(b(materialData.j())).e(adItemData.Y()).b(z2).a(i2).b(i3);
                                if (materialData.Q() != 1) {
                                    i4 = 1;
                                } else {
                                    i4 = 0;
                                }
                                fVarB.i(i4);
                                if (materialData == null) {
                                    aVarA = com.opos.mobad.template.e.a.UNKNOWN;
                                } else {
                                    aVarA = com.opos.mobad.template.e.a.UNKNOWN;
                                }
                                fVar.a(aVarA);
                                fVar.i("EXT_PARAM_KEY_FORWARD_DEGREE", String.valueOf(interactionSensorDataAj.f()));
                                fVar.i("EXT_PARAM_KEY_FORWARD_TIME", String.valueOf(interactionSensorDataAj.g()));
                                fVar.i("EXT_PARAM_KEY_TILT_DEGREE", String.valueOf(interactionSensorDataAj.c()));
                                fVar.i("EXT_PARAM_KEY_TILT_TIME", String.valueOf(interactionSensorDataAj.d()));
                                fVar.i("EXT_PARAM_KEY_TILT_TWOWAY", String.valueOf(interactionSensorDataAj.e()));
                                fVar.i("EXT_PARAM_KEY_AUTO_PLAY", String.valueOf(z3));
                                fVar.i("EXT_PARAM_KEY_TYPE_DOWNLOAD", String.valueOf(i6));
                                fVar.i("EXT_PARAM_KEY_QPON_TYPE", String.valueOf(iOptInt));
                                fVar.i("EXT_PARAM_KEY_QPON_VALUE", String.valueOf(dOptDouble2));
                                fVar.i("EXT_PARAM_KEY_QPON_THRESHOLD", String.valueOf(dOptDouble));
                                materialFileDataL = adItemData.l();
                                if (materialFileDataL != null) {
                                    fVar.c(materialFileDataL.a(), materialFileDataL.b());
                                }
                                materialFileDataM = adItemData.m();
                                if (materialFileDataM != null) {
                                    fVar.e(materialFileDataM.a(), materialFileDataM.b());
                                }
                                materialFileDataN = adItemData.n();
                                if (materialFileDataN != null) {
                                    fVar.d(materialFileDataN.a(), materialFileDataN.b());
                                }
                                listE = materialData.e();
                                if (listE != null) {
                                    for (MaterialFileData materialFileData : listE) {
                                        fVar.a(materialFileData.a(), materialFileData.b());
                                    }
                                }
                                listH = materialData.h();
                                if (listH != null) {
                                    i5 = 0;
                                } else {
                                    i5 = 0;
                                }
                                listD = materialData.D();
                                if (listD != null) {
                                    context2 = context;
                                } else {
                                    context2 = context;
                                }
                                fVar.d(!adItemData.I() ? 1 : 0);
                                a(context2, fVar, adItemData, materialData, z);
                                a(fVar, adItemData, materialData);
                                com.opos.cmn.an.f.a.a("AdShowDataWrapper", fVar);
                                return fVar;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            dOptDouble = 0.0d;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        dOptDouble = 0.0d;
                        iOptInt = 0;
                        dOptDouble2 = 0.0d;
                        com.opos.cmn.an.f.a.d("AdShowDataWrapper", "QPON JSON fail exception : " + e.getMessage());
                        com.opos.cmn.an.f.a.b("AdShowDataWrapper", "InteractionSensorData:" + interactionSensorDataAj);
                        fVar = new f();
                        f fVarG2 = fVar.a(materialData.g()).b(materialData.f()).a(adItemData.j()).c(adItemData.E()).d(a(context, adItemData, materialData, z)).f(adItemData.k()).g(materialData.g);
                        if (adItemData.P() > 0) {
                            jS = adItemData.P();
                        } else {
                            jS = materialData.s();
                        }
                        f fVarB2 = fVarG2.a(jS, materialData.t() * 1000).e(adItemData.b()).h(adItemData.X()).a(a(adItemData.T())).i(a(materialData.Y())).h(b(materialData.j())).e(adItemData.Y()).b(z2).a(i2).b(i3);
                        if (materialData.Q() != 1) {
                            i4 = 1;
                        } else {
                            i4 = 0;
                        }
                        fVarB2.i(i4);
                        if (materialData == null) {
                            aVarA = com.opos.mobad.template.e.a.UNKNOWN;
                        } else {
                            aVarA = com.opos.mobad.template.e.a.UNKNOWN;
                        }
                        fVar.a(aVarA);
                        fVar.i("EXT_PARAM_KEY_FORWARD_DEGREE", String.valueOf(interactionSensorDataAj.f()));
                        fVar.i("EXT_PARAM_KEY_FORWARD_TIME", String.valueOf(interactionSensorDataAj.g()));
                        fVar.i("EXT_PARAM_KEY_TILT_DEGREE", String.valueOf(interactionSensorDataAj.c()));
                        fVar.i("EXT_PARAM_KEY_TILT_TIME", String.valueOf(interactionSensorDataAj.d()));
                        fVar.i("EXT_PARAM_KEY_TILT_TWOWAY", String.valueOf(interactionSensorDataAj.e()));
                        fVar.i("EXT_PARAM_KEY_AUTO_PLAY", String.valueOf(z3));
                        fVar.i("EXT_PARAM_KEY_TYPE_DOWNLOAD", String.valueOf(i6));
                        fVar.i("EXT_PARAM_KEY_QPON_TYPE", String.valueOf(iOptInt));
                        fVar.i("EXT_PARAM_KEY_QPON_VALUE", String.valueOf(dOptDouble2));
                        fVar.i("EXT_PARAM_KEY_QPON_THRESHOLD", String.valueOf(dOptDouble));
                        materialFileDataL = adItemData.l();
                        if (materialFileDataL != null) {
                            fVar.c(materialFileDataL.a(), materialFileDataL.b());
                        }
                        materialFileDataM = adItemData.m();
                        if (materialFileDataM != null) {
                            fVar.e(materialFileDataM.a(), materialFileDataM.b());
                        }
                        materialFileDataN = adItemData.n();
                        if (materialFileDataN != null) {
                            fVar.d(materialFileDataN.a(), materialFileDataN.b());
                        }
                        listE = materialData.e();
                        if (listE != null) {
                            while (r1.hasNext()) {
                                fVar.a(materialFileData.a(), materialFileData.b());
                            }
                        }
                        listH = materialData.h();
                        if (listH != null) {
                            i5 = 0;
                        } else {
                            i5 = 0;
                        }
                        listD = materialData.D();
                        if (listD != null) {
                            context2 = context;
                        } else {
                            context2 = context;
                        }
                        fVar.d(!adItemData.I() ? 1 : 0);
                        a(context2, fVar, adItemData, materialData, z);
                        a(fVar, adItemData, materialData);
                        com.opos.cmn.an.f.a.a("AdShowDataWrapper", fVar);
                        return fVar;
                    }
                } catch (Exception e5) {
                    e = e5;
                    i2 = iA;
                    i3 = iB;
                }
            }
        }
        com.opos.cmn.an.f.a.b("AdShowDataWrapper", "InteractionSensorData:" + interactionSensorDataAj);
        fVar = new f();
        f fVarG3 = fVar.a(materialData.g()).b(materialData.f()).a(adItemData.j()).c(adItemData.E()).d(a(context, adItemData, materialData, z)).f(adItemData.k()).g(materialData.g);
        if (adItemData.P() > 0) {
            jS = adItemData.P();
        } else {
            jS = materialData.s();
        }
        f fVarB3 = fVarG3.a(jS, materialData.t() * 1000).e(adItemData.b()).h(adItemData.X()).a(a(adItemData.T())).i(a(materialData.Y())).h(b(materialData.j())).e(adItemData.Y()).b(z2).a(i2).b(i3);
        if (materialData.Q() != 1) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        fVarB3.i(i4);
        if (materialData == null && materialData.b() == i) {
            aVarA = com.opos.mobad.template.e.a.a(materialData.af());
        } else {
            aVarA = com.opos.mobad.template.e.a.UNKNOWN;
        }
        fVar.a(aVarA);
        fVar.i("EXT_PARAM_KEY_FORWARD_DEGREE", String.valueOf(interactionSensorDataAj.f()));
        fVar.i("EXT_PARAM_KEY_FORWARD_TIME", String.valueOf(interactionSensorDataAj.g()));
        fVar.i("EXT_PARAM_KEY_TILT_DEGREE", String.valueOf(interactionSensorDataAj.c()));
        fVar.i("EXT_PARAM_KEY_TILT_TIME", String.valueOf(interactionSensorDataAj.d()));
        fVar.i("EXT_PARAM_KEY_TILT_TWOWAY", String.valueOf(interactionSensorDataAj.e()));
        fVar.i("EXT_PARAM_KEY_AUTO_PLAY", String.valueOf(z3));
        fVar.i("EXT_PARAM_KEY_TYPE_DOWNLOAD", String.valueOf(i6));
        fVar.i("EXT_PARAM_KEY_QPON_TYPE", String.valueOf(iOptInt));
        fVar.i("EXT_PARAM_KEY_QPON_VALUE", String.valueOf(dOptDouble2));
        fVar.i("EXT_PARAM_KEY_QPON_THRESHOLD", String.valueOf(dOptDouble));
        materialFileDataL = adItemData.l();
        if (materialFileDataL != null) {
            fVar.c(materialFileDataL.a(), materialFileDataL.b());
        }
        materialFileDataM = adItemData.m();
        if (materialFileDataM != null) {
            fVar.e(materialFileDataM.a(), materialFileDataM.b());
        }
        materialFileDataN = adItemData.n();
        if (materialFileDataN != null) {
            fVar.d(materialFileDataN.a(), materialFileDataN.b());
        }
        listE = materialData.e();
        if (listE != null && listE.size() > 0) {
            while (r1.hasNext()) {
                fVar.a(materialFileData.a(), materialFileData.b());
            }
        }
        listH = materialData.h();
        if (listH != null || listH.size() <= 0) {
            i5 = 0;
        } else {
            i5 = 0;
            fVar.f(listH.get(0).a(), listH.get(0).b());
        }
        listD = materialData.D();
        if (listD != null || listD.size() <= 0) {
            context2 = context;
        } else {
            MaterialFileData materialFileData2 = listD.get(i5);
            String strA = materialFileData2.a();
            if (adItemData.t() == 1) {
                context2 = context;
                strA = d.a(context2, materialFileData2.a());
            } else {
                context2 = context;
                if (adItemData.t() == 2) {
                    strA = com.opos.mobad.j.a.d.a(context2, materialFileData2.a(), adItemData.V());
                }
            }
            fVar.g(strA, materialFileData2.b());
        }
        fVar.d(!adItemData.I() ? 1 : 0);
        a(context2, fVar, adItemData, materialData, z);
        a(fVar, adItemData, materialData);
        com.opos.cmn.an.f.a.a("AdShowDataWrapper", fVar);
        return fVar;
    }

    public static final f a(Context context, com.opos.mobad.b bVar, AdHelper.a aVar, boolean z, boolean z2, int i) {
        return a(context, bVar, aVar.c, aVar.d, z, z2, i);
    }

    private static String a(long j) {
        StringBuilder sbAppend;
        if (j <= 0) {
            return null;
        }
        try {
            DecimalFormat decimalFormat = new DecimalFormat("0");
            if (j >= 100000000) {
                sbAppend = new StringBuilder().append(decimalFormat.format(j / 1.0E8f)).append("亿次");
            } else {
                if (j < ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                    return null;
                }
                sbAppend = new StringBuilder().append(decimalFormat.format(j / 10000.0f)).append("万次");
            }
            return sbAppend.toString();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("", "", (Throwable) e);
            return null;
        }
    }

    private static String a(Context context, AdItemData adItemData, int i, boolean z, boolean z2) {
        String str;
        String str2 = "立即打开";
        String str3 = "";
        if (i != 2102) {
            if (i != 2115) {
                return "";
            }
            if (adItemData.C()) {
                str3 = z2 ? "查看详情" : "查看详情领取奖励";
            }
            if (!adItemData.y() && !adItemData.z()) {
                return str3;
            }
            if (!z) {
                str2 = z2 ? "立即下载" : "立即安装领取奖励";
            } else if (!z2) {
                str2 = "打开应用领取激励";
            }
            return str2;
        }
        if (adItemData.C()) {
            return z2 ? "查看详情" : "查看详情立即获得奖励";
        }
        str2 = z ? "立即打开" : "立即下载";
        String str4 = z ? "打开应用立即获得奖励" : "安装应用立即获得奖励";
        String str5 = z ? "打开应用立即获得奖励" : "下载打开应用立即获得奖励";
        if (!adItemData.y() && !adItemData.z()) {
            return "";
        }
        if (z2) {
            str = str2;
        } else {
            str = adItemData.z() ? str5 : str4;
        }
        com.opos.cmn.an.f.a.b("AdShowDataWrapper", "getClickBnTextWithTemplateId: ".concat(str));
        if (z2) {
            return str2;
        }
        return adItemData.z() ? str5 : str4;
    }

    public static String a(Context context, AdItemData adItemData, MaterialData materialData, boolean z) {
        return a(context, adItemData, materialData, z, false, false);
    }

    public static String a(Context context, AdItemData adItemData, MaterialData materialData, boolean z, boolean z2, boolean z3) {
        String strA = "";
        if (materialData == null) {
            return "";
        }
        if (!z2) {
            strA = a(context, adItemData, materialData.b(), z, z3);
            if (!TextUtils.isEmpty(strA)) {
                return strA;
            }
        }
        if (z) {
            return "立刻打开";
        }
        if (!TextUtils.isEmpty(materialData.V())) {
            return materialData.V();
        }
        switch (materialData.d()) {
            case 1:
                return "点击查看";
            case 2:
                return (com.opos.cmn.an.d.a.a(materialData.i()) || !com.opos.cmn.an.h.d.a.d(context, materialData.i())) ? "点击安装" : "立刻打开";
            case 3:
                return (com.opos.cmn.an.d.a.a(materialData.i()) || !com.opos.cmn.an.h.d.a.d(context, materialData.i())) ? "立即下载" : "立刻打开";
            case 4:
                return "立刻打开";
            case 5:
                return "查看详情";
            case 6:
                return "秒开";
            case 7:
                return "打开";
            default:
                return strA;
        }
    }

    private static void a(Context context, f fVar, AdItemData adItemData, MaterialData materialData, boolean z) {
        FloatLayerData floatLayerDataR = materialData.R();
        if (floatLayerDataR == null) {
            return;
        }
        fVar.l(floatLayerDataR.b());
        fVar.k(floatLayerDataR.c());
        fVar.j(a(context, adItemData, materialData, z, true, false));
        List<MaterialFileData> listD = floatLayerDataR.d();
        if (listD != null && listD.size() > 0) {
            for (MaterialFileData materialFileData : listD) {
                fVar.b(materialFileData.a(), materialFileData.b());
            }
        }
        MaterialFileData materialFileDataA = floatLayerDataR.a();
        if (materialFileDataA != null) {
            fVar.h(materialFileDataA.a(), materialFileDataA.b());
        }
    }

    private static void a(f fVar, AdItemData adItemData, MaterialData materialData) {
        if (materialData == null) {
            return;
        }
        String strP = materialData.p();
        boolean zEquals = false;
        if (!TextUtils.isEmpty(strP)) {
            try {
                String strOptString = new JSONObject(strP).optString("adCat");
                if (!TextUtils.isEmpty(strOptString)) {
                    zEquals = "2".equals(strOptString);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if ((adItemData == null || adItemData.F() != 2) && !zEquals) {
            return;
        }
        String strA = a(materialData.Y());
        if (!TextUtils.isEmpty(strA)) {
            fVar.j(c.g1.hnadsa, strA);
        }
        String strB = b(materialData.j());
        if (!TextUtils.isEmpty(strB)) {
            fVar.j("大小", strB);
        }
        String strAe = materialData.ae();
        if (TextUtils.isEmpty(strAe)) {
            return;
        }
        try {
            strAe = new DecimalFormat("#.#").format(Float.parseFloat(strAe));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        fVar.j("评分", strAe);
    }

    private static String b(long j) {
        StringBuilder sbAppend;
        if (j <= 0) {
            return null;
        }
        try {
            DecimalFormat decimalFormat = new DecimalFormat("0");
            if (j >= FileUtils.ONE_GB) {
                sbAppend = new StringBuilder().append(decimalFormat.format(j / 1.07374182E9f)).append("GB");
            } else {
                if (j < 1048576) {
                    return null;
                }
                sbAppend = new StringBuilder().append(decimalFormat.format(j / 1048576.0f)).append("MB");
            }
            return sbAppend.toString();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("", "", (Throwable) e);
            return null;
        }
    }
}
