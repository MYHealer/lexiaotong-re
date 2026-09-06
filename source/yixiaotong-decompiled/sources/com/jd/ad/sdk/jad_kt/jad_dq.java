package com.jd.ad.sdk.jad_kt;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_dq implements jad_fs {
    public final ThreadLocal<String> jad_an = new ThreadLocal<>();
    public final CopyOnWriteArrayList<jad_bo> jad_bo = new CopyOnWriteArrayList<>();

    @Override // com.jd.ad.sdk.jad_kt.jad_fs
    public jad_fs jad_an(String str) {
        if (str != null) {
            this.jad_an.set(str);
        }
        return this;
    }

    @Override // com.jd.ad.sdk.jad_kt.jad_fs
    public void jad_an() {
        this.jad_bo.clear();
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002e  */
    /* JADX WARN: Code duplicated, block: B:15:0x003c A[Catch: all -> 0x0050, TryCatch #0 {, blocks: (B:5:0x0005, B:8:0x0024, B:9:0x0028, B:12:0x0030, B:13:0x0036, B:15:0x003c, B:17:0x0044, B:19:0x004a), top: B:26:0x0005 }] */
    @Override // com.jd.ad.sdk.jad_kt.jad_fs
    public synchronized void jad_an(int i, String str, String str2, Throwable th) {
        if (th == null || str2 == null) {
            if (th != null && str2 == null) {
                str2 = jad_jt.jad_an(th);
            }
            if (jad_jt.jad_an((CharSequence) str2)) {
                str2 = "Empty/NULL log message";
            }
            for (jad_bo jad_boVar : this.jad_bo) {
                if (jad_boVar == null && jad_boVar.isLoggable(i, str)) {
                    jad_boVar.log(i, str, str2);
                }
            }
        } else {
            str2 = str2 + " : " + jad_jt.jad_an(th);
            if (th != null) {
                str2 = jad_jt.jad_an(th);
            }
            if (jad_jt.jad_an((CharSequence) str2)) {
                str2 = "Empty/NULL log message";
            }
            while (r6.hasNext()) {
                if (jad_boVar == null) {
                }
            }
        }
        throw th;
    }

    @Override // com.jd.ad.sdk.jad_kt.jad_fs
    public void jad_an(jad_bo jad_boVar) {
        this.jad_bo.add(jad_boVar);
    }

    @Override // com.jd.ad.sdk.jad_kt.jad_fs
    public void jad_an(String str, Object... objArr) {
        jad_an(7, (Throwable) null, str, objArr);
    }

    @Override // com.jd.ad.sdk.jad_kt.jad_fs
    public void jad_an(Throwable th, String str, Object... objArr) {
        jad_an(6, th, str, objArr);
    }

    @Override // com.jd.ad.sdk.jad_kt.jad_fs
    public void jad_bo(String str) {
        if (jad_jt.jad_an((CharSequence) str)) {
            jad_an("Empty/Null json content");
            return;
        }
        try {
            String strTrim = str.trim();
            if (strTrim.startsWith("{")) {
                jad_an((Object) new JSONObject(strTrim).toString(2));
            } else if (strTrim.startsWith("[")) {
                jad_an((Object) new JSONArray(strTrim).toString(2));
            } else {
                jad_an(6, (Throwable) null, "Invalid Json", new Object[0]);
            }
        } catch (JSONException unused) {
            jad_an(6, (Throwable) null, "Invalid Json", new Object[0]);
        }
    }

    @Override // com.jd.ad.sdk.jad_kt.jad_fs
    public void jad_bo(String str, Object... objArr) {
        jad_an(4, (Throwable) null, str, objArr);
    }

    @Override // com.jd.ad.sdk.jad_kt.jad_fs
    public void jad_cp(String str) {
        if (jad_jt.jad_an((CharSequence) str)) {
            jad_an("Empty/Null xml content");
            return;
        }
        try {
            StreamSource streamSource = new StreamSource(new StringReader(str));
            StreamResult streamResult = new StreamResult(new StringWriter());
            Transformer transformerNewTransformer = TransformerFactory.newInstance().newTransformer();
            transformerNewTransformer.setOutputProperty("indent", "yes");
            transformerNewTransformer.transform(streamSource, streamResult);
            jad_an((Object) streamResult.getWriter().toString().replaceFirst(SimpleComparison.GREATER_THAN_OPERATION, ">\n"));
        } catch (TransformerException unused) {
            jad_an(6, (Throwable) null, "Invalid xml", new Object[0]);
        }
    }

    @Override // com.jd.ad.sdk.jad_kt.jad_fs
    public void jad_cp(String str, Object... objArr) {
        jad_an(2, (Throwable) null, str, objArr);
    }

    @Override // com.jd.ad.sdk.jad_kt.jad_fs
    public void jad_dq(String str, Object... objArr) {
        jad_an(5, (Throwable) null, str, objArr);
    }

    @Override // com.jd.ad.sdk.jad_kt.jad_fs
    public void jad_er(String str, Object... objArr) {
        jad_an(3, (Throwable) null, str, objArr);
    }

    @Override // com.jd.ad.sdk.jad_kt.jad_fs
    public void jad_an(Object obj) {
        String strDeepToString;
        if (obj == null) {
            strDeepToString = "null";
        } else if (!obj.getClass().isArray()) {
            strDeepToString = obj.toString();
        } else if (obj instanceof boolean[]) {
            strDeepToString = Arrays.toString((boolean[]) obj);
        } else if (obj instanceof byte[]) {
            strDeepToString = Arrays.toString((byte[]) obj);
        } else if (obj instanceof char[]) {
            strDeepToString = Arrays.toString((char[]) obj);
        } else if (obj instanceof short[]) {
            strDeepToString = Arrays.toString((short[]) obj);
        } else if (obj instanceof int[]) {
            strDeepToString = Arrays.toString((int[]) obj);
        } else if (obj instanceof long[]) {
            strDeepToString = Arrays.toString((long[]) obj);
        } else if (obj instanceof float[]) {
            strDeepToString = Arrays.toString((float[]) obj);
        } else if (obj instanceof double[]) {
            strDeepToString = Arrays.toString((double[]) obj);
        } else {
            strDeepToString = obj instanceof Object[] ? Arrays.deepToString((Object[]) obj) : "Couldn't find a correct type for the object";
        }
        jad_an(3, (Throwable) null, strDeepToString, new Object[0]);
    }

    public final synchronized void jad_an(int i, Throwable th, String str, Object... objArr) {
        str.getClass();
        String str2 = this.jad_an.get();
        if (str2 != null) {
            this.jad_an.remove();
        } else {
            str2 = null;
        }
        if (objArr != null && objArr.length != 0) {
            str = String.format(str, objArr);
        }
        jad_an(i, str2, str, th);
    }
}
