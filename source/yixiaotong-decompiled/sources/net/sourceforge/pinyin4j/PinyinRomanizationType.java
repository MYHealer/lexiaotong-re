package net.sourceforge.pinyin4j;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
class PinyinRomanizationType {
    protected String tagName;
    static final PinyinRomanizationType HANYU_PINYIN = new PinyinRomanizationType("Hanyu");
    static final PinyinRomanizationType WADEGILES_PINYIN = new PinyinRomanizationType("Wade");
    static final PinyinRomanizationType MPS2_PINYIN = new PinyinRomanizationType("MPSII");
    static final PinyinRomanizationType YALE_PINYIN = new PinyinRomanizationType("Yale");
    static final PinyinRomanizationType TONGYONG_PINYIN = new PinyinRomanizationType("Tongyong");
    static final PinyinRomanizationType GWOYEU_ROMATZYH = new PinyinRomanizationType("Gwoyeu");

    protected PinyinRomanizationType(String str) {
        setTagName(str);
    }

    String getTagName() {
        return this.tagName;
    }

    protected void setTagName(String str) {
        this.tagName = str;
    }
}
