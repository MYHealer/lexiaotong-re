package com.opos.cmn.an.g.a.a;

import android.content.Context;
import com.opos.cmn.an.g.f;
import com.opos.cmn.an.g.g;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b extends a {
    private OutputStream d;
    private InputStream e;

    public b(Context context, f fVar) {
        super(context, fVar);
        this.d = null;
        this.e = null;
    }

    private Map<String, String> c() {
        Map<String, List<String>> headerFields = this.c.getHeaderFields();
        HashMap map = null;
        if (headerFields != null && headerFields.size() > 0) {
            for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
                if (entry != null) {
                    String key = entry.getKey();
                    List<String> value = entry.getValue();
                    if (value != null && value.size() > 0) {
                        if (map == null) {
                            map = new HashMap();
                        }
                        map.put(key, value.get(0));
                    }
                }
            }
        }
        return map;
    }

    public g a() {
        if (this.c != null) {
            try {
                this.c.connect();
                if ("POST".equals(this.b.b) && this.b.g != null && this.b.g.length > 0) {
                    OutputStream outputStream = this.c.getOutputStream();
                    this.d = outputStream;
                    outputStream.write(this.b.g);
                    this.d.flush();
                }
                int responseCode = this.c.getResponseCode();
                String responseMessage = this.c.getResponseMessage();
                try {
                    this.e = this.c.getInputStream();
                } catch (IOException unused) {
                }
                String headerField = this.c.getHeaderField("Content-Length");
                return new g.a().a(responseCode).a(responseMessage).a(!com.opos.cmn.an.d.a.a(headerField) ? Long.parseLong(headerField) : -1L).a(c()).a(this.e).a();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("HttpURLSyncTask", "", e);
            }
        }
        return null;
    }

    public void b() {
        try {
            OutputStream outputStream = this.d;
            if (outputStream != null) {
                outputStream.close();
            }
            InputStream inputStream = this.e;
            if (inputStream != null) {
                inputStream.close();
            }
            if (this.c != null) {
                this.c.disconnect();
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("HttpURLSyncTask", "", e);
        }
    }
}
