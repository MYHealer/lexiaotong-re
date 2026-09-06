package net.sourceforge.pinyin4j;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
class TextHelper {
    TextHelper() {
    }

    static String extractPinyinString(String str) {
        return str.substring(0, str.length() - 1);
    }

    static String extractToneNumber(String str) {
        return str.substring(str.length() - 1);
    }
}
