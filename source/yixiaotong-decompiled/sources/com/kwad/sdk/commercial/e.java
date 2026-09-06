package com.kwad.sdk.commercial;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.br;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class e {
    public static int dt(int i) {
        if (i == -1) {
            return 100010;
        }
        if (i == -2) {
            return 100011;
        }
        return i;
    }

    public static BusinessType bA(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return BusinessType.OTHER;
        }
        return ds(com.kwad.sdk.core.response.helper.e.eI(adTemplate));
    }

    public static BusinessType ds(int i) {
        if (i == 3) {
            return BusinessType.AD_FULLSCREEN;
        }
        if (i == 2) {
            return BusinessType.AD_REWARD;
        }
        if (i == 4) {
            return BusinessType.AD_SPLASH;
        }
        if (i == 13 || i == 23) {
            return BusinessType.AD_INTERSTITIAL;
        }
        if (i == 1) {
            return BusinessType.AD_FEED;
        }
        if (i == 10000) {
            return BusinessType.AD_NATIVE;
        }
        return BusinessType.OTHER;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0061  */
    /* JADX WARN: Code duplicated, block: B:41:0x008e  */
    /* JADX WARN: Code duplicated, block: B:43:0x0094  */
    public static AdMatrixInfo.MatrixTemplate bB(AdTemplate adTemplate) {
        String strG;
        AdMatrixInfo.MatrixTemplate matrixTemplateT = null;
        if (adTemplate.mAdScene == null) {
            return null;
        }
        AdMatrixInfo.AdDataV2 adDataV2 = com.kwad.sdk.core.response.helper.b.cO(adTemplate).adDataV2;
        int iEI = com.kwad.sdk.core.response.helper.e.eI(adTemplate);
        if (iEI == 13) {
            strG = adDataV2.interstitialCardInfo.templateId;
        } else if (iEI == 23) {
            int iFg = com.kwad.sdk.core.response.helper.e.fg(adTemplate);
            if (iFg == 1) {
                strG = g(adTemplate, true);
            } else if (iFg == 2) {
                strG = adDataV2.interstitialCardInfo.templateId;
            } else {
                strG = "";
            }
        } else if (iEI != 10000) {
            switch (iEI) {
                case 1:
                    strG = adDataV2.feedTKCardInfo.templateId;
                    break;
                case 2:
                    strG = g(adTemplate, false);
                    break;
                case 3:
                    strG = g(adTemplate, true);
                    break;
                case 4:
                    if (adTemplate.isEndCardPage) {
                        strG = adDataV2.splashEndCardTKInfo.templateId;
                    } else {
                        strG = adDataV2.splashPlayCardTKInfo.templateId;
                    }
                    break;
                case 5:
                    strG = adDataV2.bannerTKInfo.templateId;
                    break;
                case 6:
                    strG = adDataV2.drawTKCardInfo.templateId;
                    break;
                default:
                    strG = "";
                    break;
            }
        } else {
            strG = adDataV2.nativeTKCardInfo.templateId;
        }
        if (TextUtils.isEmpty(strG)) {
            return null;
        }
        for (AdMatrixInfo.MatrixTemplate matrixTemplate : com.kwad.sdk.core.response.helper.b.cP(adTemplate)) {
            if (br.isEquals(strG, matrixTemplate.templateId)) {
                matrixTemplateT = matrixTemplate;
                if (matrixTemplateT == null) {
                    matrixTemplateT = com.kwad.sdk.core.response.helper.b.t(adTemplate, strG);
                }
                if (matrixTemplateT != null) {
                    matrixTemplateT.publishType = ((h) ServiceProvider.get(h.class)).cR(a(matrixTemplateT));
                }
                return matrixTemplateT;
            }
        }
        if (matrixTemplateT == null) {
            matrixTemplateT = com.kwad.sdk.core.response.helper.b.t(adTemplate, strG);
        }
        if (matrixTemplateT != null) {
            matrixTemplateT.publishType = ((h) ServiceProvider.get(h.class)).cR(a(matrixTemplateT));
        }
        return matrixTemplateT;
    }

    private static String g(AdTemplate adTemplate, boolean z) {
        AdMatrixInfo.AdDataV2 adDataV2 = com.kwad.sdk.core.response.helper.b.cO(adTemplate).adDataV2;
        boolean z2 = 1 == com.kwad.sdk.core.response.helper.a.bk(com.kwad.sdk.core.response.helper.e.eO(adTemplate)) && !TextUtils.isEmpty(com.kwad.sdk.core.response.helper.a.M(com.kwad.sdk.core.response.helper.e.eO(adTemplate)));
        boolean zBj = com.kwad.sdk.core.response.helper.a.bj(com.kwad.sdk.core.response.helper.e.eO(adTemplate));
        boolean zCY = com.kwad.sdk.core.response.helper.a.cY(com.kwad.sdk.core.response.helper.e.eO(adTemplate));
        if (z) {
            if (z2) {
                return adDataV2.fullScreenInfo.templateId;
            }
            if (zCY) {
                return adDataV2.videoLiveTKInfo.templateId;
            }
            if (zBj) {
                return adDataV2.videoImageTKInfo.templateId;
            }
        } else {
            if (z2) {
                return adDataV2.neoTKInfo.templateId;
            }
            if (zCY) {
                return adDataV2.videoLiveTKInfo.templateId;
            }
            if (zBj) {
                return adDataV2.videoImageTKInfo.templateId;
            }
        }
        return "";
    }

    private static String a(AdMatrixInfo.MatrixTemplate matrixTemplate) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(matrixTemplate.templateId).append("#").append(matrixTemplate.templateVersionCode);
        return stringBuffer.toString();
    }
}
