package ms.bz.bd.c.Pgl;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.util.HashMap;
import java.util.regex.Pattern;
import kotlin.io.encoding.Base64;
import okio.Utf8;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class pblh {
    private static final String c = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "5c2f99", new byte[]{Ascii.DC4, 115, 78, 17, 3, Base64.padSymbol, 37, 77, 113});
    private static final String tt = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "5da33d", new byte[]{12, 103, 0, 67, Ascii.ESC, 114, 36, SignedBytes.MAX_POWER_OF_TWO});
    private static final String ve = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "210bd9", new byte[]{5, 54, 66, 2, 78, 60, 52, 3});
    private static final String uj = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "5b688c", new byte[]{52, 99});
    private static final String n = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "a52d56", new byte[]{120, 32});

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9702a = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "d8bb5d", new byte[]{115, 46});
    private static final String sp = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "f58dd1", new byte[]{122, 54, 83});
    private static final String x = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "462f1a", new byte[]{40, Base64.padSymbol, 79});
    private static final String i = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "5905b0", new byte[]{39, 52, 81, 68});
    private static final FileFilter da = new pgla();

    final class pgla implements FileFilter {
        pgla() {
        }

        @Override // java.io.FileFilter
        public final boolean accept(File file) {
            return Pattern.matches((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f1d2ff", new byte[]{116, 35, 2, 125, 9, 60, 60, 45}), file.getName());
        }
    }

    public static String c() {
        String str;
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            HashMap<String, String> mapTt = tt();
            jSONObject.put(i, ve());
            String str3 = null;
            try {
                str = mapTt.get(c);
            } catch (Throwable unused) {
                str = null;
            }
            jSONObject.put(uj, str == null ? "" : str.trim());
            try {
                str2 = mapTt.get(tt);
            } catch (Throwable unused2) {
                str2 = null;
            }
            jSONObject.put(n, str2 == null ? "" : str2.trim());
            jSONObject.put(sp, c((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "bec69e", new byte[]{60, 116, 9, 81, 73, 118, 100, 82, 59, 101, 118, 116, 95, 81, Ascii.US, 97, 117, 65, Utf8.REPLACEMENT_BYTE, 41, 112, 119, 5, 13, 5, 98, 116, Ascii.DC4, 125, 101, 99, 114, Ascii.SYN, 80, 3, 99, 46, 71, 34, 115, 122, 105, Ascii.SYN, 77, 57, 127, 96, 92, 13, 96, 97, 98, 1})));
            jSONObject.put(x, c((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "fe3d9d", new byte[]{56, 116, 89, 3, 73, 119, 96, 82, 107, 55, 114, 116, 15, 3, Ascii.US, 96, 113, 65, 111, 123, 116, 119, 85, 95, 5, 99, 112, Ascii.DC4, 45, 55, 103, 114, 70, 2, 3, 98, 42, 71, 114, 33, 126, 105, 70, Ascii.US, 57, 126, 108, 74, 93, 50, 101, 98, 81})));
            try {
                str3 = mapTt.get(ve);
            } catch (Throwable unused3) {
            }
            jSONObject.put(f9702a, str3 != null ? str3.trim() : "");
        } catch (Throwable unused4) {
        }
        String string = jSONObject.toString();
        return TextUtils.isEmpty(string) ? (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "06979c", new byte[]{58, 41}) : string.trim();
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0046  */
    /* JADX WARN: Code duplicated, block: B:22:0x005b  */
    private static String c(String str) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        String line = null;
        try {
            File file = new File(str);
            if (!file.exists()) {
                return (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "aa1e0a", new byte[]{32});
            }
            fileReader = new FileReader(file);
            try {
                try {
                    bufferedReader = new BufferedReader(fileReader);
                    try {
                        line = bufferedReader.readLine();
                        try {
                            bufferedReader.close();
                        } catch (Throwable unused) {
                        }
                    } catch (Throwable unused2) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable unused3) {
                            }
                        }
                        if (fileReader != null) {
                        }
                        return line == null ? (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d36e6e", new byte[]{37}) : line.trim();
                    }
                } catch (Throwable unused4) {
                    bufferedReader = null;
                }
                fileReader.close();
            } catch (Throwable unused5) {
            }
            if (line == null) {
            }
        } catch (Throwable unused6) {
            fileReader = null;
            bufferedReader = null;
        }
    }

    private static HashMap<String, String> tt() {
        FileReader fileReader;
        HashMap<String, String> map = new HashMap<>();
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b59ea2", new byte[]{60, 39, 88, Ascii.RS, 93, 106, 98, 4, 125, 60, 125, 49, 69}));
            try {
                BufferedReader bufferedReader2 = new BufferedReader(fileReader);
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            try {
                                break;
                            } catch (Throwable unused) {
                            }
                        } else {
                            String[] strArrSplit = line.split((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "8eddc5", new byte[]{115}), 2);
                            if (strArrSplit.length >= 2) {
                                String strTrim = strArrSplit[0].trim();
                                String strTrim2 = strArrSplit[1].trim();
                                if (map.get(strTrim) == null) {
                                    map.put(strTrim, strTrim2);
                                } else {
                                    continue;
                                }
                            }
                        }
                    } catch (Throwable unused2) {
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable unused3) {
                            }
                        }
                        if (fileReader != null) {
                        }
                        return map;
                    }
                }
                bufferedReader2.close();
            } catch (Throwable unused4) {
            }
        } catch (Throwable unused5) {
            fileReader = null;
        }
        try {
            fileReader.close();
        } catch (Throwable unused6) {
        }
        return map;
    }

    private static int ve() {
        try {
            return new File((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "5e9c25", new byte[]{107, 116, 83, 4, 66, 38, 51, 82, 97, 48, 33, 116, 5, 4, Ascii.DC4, 49, 34, 65, 101, 124, 39, 119, 95, 88})).listFiles(da).length;
        } catch (Throwable unused) {
            return -1;
        }
    }
}
