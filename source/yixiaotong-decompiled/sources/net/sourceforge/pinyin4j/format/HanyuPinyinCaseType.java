package net.sourceforge.pinyin4j.format;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class HanyuPinyinCaseType {
    protected String name;
    public static final HanyuPinyinCaseType UPPERCASE = new HanyuPinyinCaseType("UPPERCASE");
    public static final HanyuPinyinCaseType LOWERCASE = new HanyuPinyinCaseType("LOWERCASE");

    protected HanyuPinyinCaseType(String str) {
        setName(str);
    }

    public String getName() {
        return this.name;
    }

    protected void setName(String str) {
        this.name = str;
    }
}
