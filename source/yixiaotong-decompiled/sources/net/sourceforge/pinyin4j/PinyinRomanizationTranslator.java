package net.sourceforge.pinyin4j;

import com.hp.hpl.sparta.Element;
import com.hp.hpl.sparta.ParseException;
import com.yfanads.android.libs.net.UrlConst;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
class PinyinRomanizationTranslator {
    PinyinRomanizationTranslator() {
    }

    static String convertRomanizationSystem(String str, PinyinRomanizationType pinyinRomanizationType, PinyinRomanizationType pinyinRomanizationType2) {
        String strExtractPinyinString = TextHelper.extractPinyinString(str);
        String strExtractToneNumber = TextHelper.extractToneNumber(str);
        try {
            Element elementXpathSelectElement = PinyinRomanizationResource.getInstance().getPinyinMappingDoc().xpathSelectElement(new StringBuffer(UrlConst.PRD_KEY).append(pinyinRomanizationType.getTagName()).append("[text()='").append(strExtractPinyinString).append("']").toString());
            if (elementXpathSelectElement == null) {
                return null;
            }
            return new StringBuffer().append(elementXpathSelectElement.xpathSelectString(new StringBuffer("../").append(pinyinRomanizationType2.getTagName()).append("/text()").toString())).append(strExtractToneNumber).toString();
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
