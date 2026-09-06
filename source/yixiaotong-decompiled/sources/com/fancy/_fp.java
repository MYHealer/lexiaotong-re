package com.fancy;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.utils.Logger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _fp implements _hw {
    public File _a = _a();

    public class _a implements Runnable {
        public final /* synthetic */ _hx _a;

        public _a(_hx _hxVar) {
            this._a = _hxVar;
        }

        /* JADX WARN: Code duplicated, block: B:126:0x0188  */
        /* JADX WARN: Code duplicated, block: B:129:0x018f  */
        /* JADX WARN: Code duplicated, block: B:131:0x0198  */
        /* JADX WARN: Code duplicated, block: B:133:0x019c  */
        /* JADX WARN: Code duplicated, block: B:135:0x01ae  */
        /* JADX WARN: Code duplicated, block: B:137:0x01c7  */
        /* JADX WARN: Code duplicated, block: B:139:0x01cd  */
        /* JADX WARN: Code duplicated, block: B:141:0x01e6  */
        /* JADX WARN: Code duplicated, block: B:168:0x00bc A[EXC_TOP_SPLITTER, PHI: r0 r5
  0x00bc: PHI (r0v42 java.io.InputStream) = (r0v41 java.io.InputStream), (r0v49 java.io.InputStream) binds: [B:54:0x00ba, B:44:0x00aa] A[DONT_GENERATE, DONT_INLINE]
  0x00bc: PHI (r5v17 byte[]) = (r5v16 byte[]), (r5v21 byte[]) binds: [B:54:0x00ba, B:44:0x00aa] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:174:0x017d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:180:0x0178 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:182:0x00df A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:201:0x0149 A[EDGE_INSN: B:201:0x0149->B:95:0x0149 BREAK  A[LOOP:1: B:197:0x013f->B:94:0x0145], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:204:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:206:? A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:208:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:41:0x0092  */
        /* JADX WARN: Code duplicated, block: B:62:0x00c9  */
        /* JADX WARN: Code duplicated, block: B:70:0x00e8  */
        /* JADX WARN: Code duplicated, block: B:73:0x00f7  */
        /* JADX WARN: Code duplicated, block: B:75:0x0100  */
        /* JADX WARN: Code duplicated, block: B:77:0x0104  */
        /* JADX WARN: Code duplicated, block: B:94:0x0145 A[Catch: all -> 0x015a, Exception -> 0x0165, LOOP:1: B:197:0x013f->B:94:0x0145, LOOP_END, TryCatch #24 {Exception -> 0x0165, all -> 0x015a, blocks: (B:92:0x013f, B:94:0x0145, B:95:0x0149, B:97:0x014f), top: B:197:0x013f }] */
        /* JADX WARN: Code duplicated, block: B:97:0x014f A[Catch: all -> 0x015a, Exception -> 0x0165, TRY_LEAVE, TryCatch #24 {Exception -> 0x0165, all -> 0x015a, blocks: (B:92:0x013f, B:94:0x0145, B:95:0x0149, B:97:0x014f), top: B:197:0x013f }] */
        @Override // java.lang.Runnable
        public final void run() throws Throwable {
            String string;
            byte[] byteArray;
            String localPolicyEncode;
            File file;
            _cg _cgVar;
            _ck _ckVar;
            _hx _hxVar;
            BufferedReader bufferedReader;
            FileReader fileReader;
            StringBuilder sb;
            String line;
            _hx _hxVar2;
            Throwable th;
            InputStream inputStreamOpenInputStream;
            Uri uri_a;
            InputStream localPolicyFileInputStream = PtgAdSdk.getConfig().getLocalPolicyFileInputStream();
            File localPolicyFile = PtgAdSdk.getConfig().getLocalPolicyFile();
            String str_d = _kr._d(PtgAdSdk.getContext(), "local_config");
            if (localPolicyFileInputStream == null && localPolicyFile == null && _fp.this._a == null && TextUtils.isEmpty(str_d)) {
                Logger.d("LocalConfigPolicyLoader: not find local Policy");
                _hx _hxVar3 = this._a;
                if (_hxVar3 != null) {
                    _hxVar3._c("not find local Policy");
                    return;
                }
                return;
            }
            String string2 = "";
            if (localPolicyFileInputStream != null) {
                StringBuilder sb2 = new StringBuilder();
                InputStreamReader inputStreamReader = new InputStreamReader(localPolicyFileInputStream);
                BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                try {
                    try {
                        try {
                            while (true) {
                                try {
                                    try {
                                        String line2 = bufferedReader2.readLine();
                                        if (line2 == null) {
                                            break;
                                        } else {
                                            sb2.append(line2);
                                        }
                                    } catch (IOException unused) {
                                        string = "";
                                    }
                                } catch (Exception unused2) {
                                    localPolicyFileInputStream.close();
                                    string = "";
                                    inputStreamReader.close();
                                    bufferedReader2.close();
                                    if (localPolicyFile != null) {
                                        string2 = uri_a.toString();
                                    }
                                    FileReader fileReader2 = null;
                                    BufferedReader bufferedReader3 = null;
                                    if (TextUtils.isEmpty(string2)) {
                                        byteArray = null;
                                    } else {
                                        try {
                                            inputStreamOpenInputStream = PtgAdSdk.getContext().getContentResolver().openInputStream(Uri.parse(string2));
                                            try {
                                                try {
                                                    byteArray = _oy._a(inputStreamOpenInputStream).toByteArray();
                                                    if (inputStreamOpenInputStream != null) {
                                                        try {
                                                            inputStreamOpenInputStream.close();
                                                        } catch (IOException e) {
                                                            e.printStackTrace();
                                                        }
                                                    }
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    e.printStackTrace();
                                                    byteArray = null;
                                                    if (inputStreamOpenInputStream != null) {
                                                        inputStreamOpenInputStream.close();
                                                    }
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                if (inputStreamOpenInputStream != null) {
                                                    try {
                                                        inputStreamOpenInputStream.close();
                                                    } catch (IOException e3) {
                                                        e3.printStackTrace();
                                                    }
                                                }
                                                throw th;
                                            }
                                        } catch (Exception e4) {
                                            e = e4;
                                            inputStreamOpenInputStream = null;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            inputStreamOpenInputStream = null;
                                            if (inputStreamOpenInputStream != null) {
                                                inputStreamOpenInputStream.close();
                                            }
                                            throw th;
                                        }
                                        if (byteArray != null) {
                                            Logger.e("find local policy file fail ，uri = " + string2);
                                        } else {
                                            Logger.e("find local policy file fail ，uri = " + string2);
                                        }
                                    }
                                    localPolicyEncode = PtgAdSdk.getConfig().getLocalPolicyEncode();
                                    if (TextUtils.isEmpty(localPolicyEncode)) {
                                        Logger.e("local policy encode unset");
                                        _hxVar2 = this._a;
                                        if (_hxVar2 != null) {
                                            _hxVar2._c("local policy encode unset");
                                            return;
                                        }
                                        return;
                                    }
                                    if (byteArray != null) {
                                        try {
                                            string = new String(byteArray, Charset.forName(localPolicyEncode));
                                        } catch (Exception unused3) {
                                            Logger.e("local policy decode fail");
                                            _hx _hxVar4 = this._a;
                                            if (_hxVar4 != null) {
                                                _hxVar4._c("local policy decode fail");
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    file = _fp.this._a;
                                    if (file != null) {
                                        try {
                                            sb = new StringBuilder();
                                            fileReader = new FileReader(_fp.this._a);
                                            try {
                                                bufferedReader = new BufferedReader(fileReader);
                                                while (true) {
                                                    try {
                                                        line = bufferedReader.readLine();
                                                        if (line != null) {
                                                            break;
                                                        } else {
                                                            sb.append(line);
                                                        }
                                                    } catch (Exception unused4) {
                                                        try {
                                                            Logger.e("global local policy read fail");
                                                            if (fileReader != null) {
                                                                try {
                                                                    fileReader.close();
                                                                } catch (Exception unused5) {
                                                                }
                                                            }
                                                            if (bufferedReader != null) {
                                                            }
                                                            if (!TextUtils.isEmpty(string)) {
                                                                str_d = string;
                                                            }
                                                            if (TextUtils.isEmpty(str_d)) {
                                                                Logger.e("all local policy decode fail");
                                                                _hxVar = this._a;
                                                                if (_hxVar != null) {
                                                                    _hxVar._c("all local policy decode fail");
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            _cgVar = new _cg();
                                                            _ckVar = new _ck();
                                                            if (!_ckVar._c(str_d)) {
                                                                _fp.this.getClass();
                                                                Logger.e(new AdErrorImpl(10019, "local policy config parse fail", (Object) null).getMessage());
                                                                this._a._c("local policy config parse fail");
                                                            } else if (_cgVar._a(str_d, _ckVar)) {
                                                                this._a._a(_cgVar, _ckVar);
                                                                this._a._b(str_d);
                                                                this._a._a(str_d);
                                                            } else {
                                                                _fp.this.getClass();
                                                                Logger.e(new AdErrorImpl(10019, "local policy data parse fail", (Object) null).getMessage());
                                                                this._a._c("local policy data parse fail");
                                                            }
                                                        } catch (Throwable th4) {
                                                            th = th4;
                                                            fileReader2 = fileReader;
                                                            fileReader = fileReader2;
                                                            bufferedReader3 = bufferedReader;
                                                            if (fileReader != null) {
                                                                try {
                                                                    fileReader.close();
                                                                } catch (Exception unused6) {
                                                                }
                                                            }
                                                            if (bufferedReader3 != null) {
                                                                throw th;
                                                            }
                                                            try {
                                                                bufferedReader3.close();
                                                                throw th;
                                                            } catch (Exception unused7) {
                                                                throw th;
                                                            }
                                                        }
                                                    } catch (Throwable th5) {
                                                        th = th5;
                                                        bufferedReader3 = bufferedReader;
                                                        if (fileReader != null) {
                                                            fileReader.close();
                                                        }
                                                        if (bufferedReader3 != null) {
                                                            throw th;
                                                        }
                                                        bufferedReader3.close();
                                                        throw th;
                                                    }
                                                }
                                                if (sb.length() > 0) {
                                                    string = sb.toString();
                                                }
                                                try {
                                                    fileReader.close();
                                                } catch (Exception unused8) {
                                                }
                                            } catch (Exception unused9) {
                                                bufferedReader = null;
                                            } catch (Throwable th6) {
                                                th = th6;
                                                if (fileReader != null) {
                                                    fileReader.close();
                                                }
                                                if (bufferedReader3 != null) {
                                                    throw th;
                                                }
                                                bufferedReader3.close();
                                                throw th;
                                            }
                                        } catch (Exception unused10) {
                                            fileReader = null;
                                            bufferedReader = null;
                                        } catch (Throwable th7) {
                                            th = th7;
                                            bufferedReader = null;
                                            fileReader = fileReader2;
                                            bufferedReader3 = bufferedReader;
                                            if (fileReader != null) {
                                                fileReader.close();
                                            }
                                            if (bufferedReader3 != null) {
                                                throw th;
                                            }
                                            bufferedReader3.close();
                                            throw th;
                                        }
                                        try {
                                            bufferedReader.close();
                                        } catch (Exception unused11) {
                                        }
                                    }
                                    if (!TextUtils.isEmpty(string)) {
                                        str_d = string;
                                    }
                                    if (TextUtils.isEmpty(str_d)) {
                                        Logger.e("all local policy decode fail");
                                        _hxVar = this._a;
                                        if (_hxVar != null) {
                                            _hxVar._c("all local policy decode fail");
                                            return;
                                        }
                                        return;
                                    }
                                    _cgVar = new _cg();
                                    _ckVar = new _ck();
                                    if (!_ckVar._c(str_d)) {
                                        _fp.this.getClass();
                                        Logger.e(new AdErrorImpl(10019, "local policy config parse fail", (Object) null).getMessage());
                                        this._a._c("local policy config parse fail");
                                    } else if (_cgVar._a(str_d, _ckVar)) {
                                        _fp.this.getClass();
                                        Logger.e(new AdErrorImpl(10019, "local policy data parse fail", (Object) null).getMessage());
                                        this._a._c("local policy data parse fail");
                                    } else {
                                        this._a._a(_cgVar, _ckVar);
                                        this._a._b(str_d);
                                        this._a._a(str_d);
                                    }
                                } catch (Throwable th8) {
                                    try {
                                        localPolicyFileInputStream.close();
                                    } catch (IOException unused12) {
                                    }
                                    try {
                                        inputStreamReader.close();
                                    } catch (IOException unused13) {
                                    }
                                    try {
                                        bufferedReader2.close();
                                        throw th8;
                                    } catch (IOException unused14) {
                                        throw th8;
                                    }
                                }
                                string = "";
                                inputStreamReader.close();
                                bufferedReader2.close();
                            }
                            localPolicyFileInputStream.close();
                        } catch (IOException unused15) {
                        }
                        inputStreamReader.close();
                    } catch (IOException unused16) {
                    }
                    bufferedReader2.close();
                } catch (IOException unused17) {
                }
                string = sb2.toString();
            } else {
                string = "";
            }
            if (localPolicyFile != null && localPolicyFile.exists() && (uri_a = _oy._a(PtgAdSdk.getContext(), localPolicyFile)) != null) {
                string2 = uri_a.toString();
            }
            FileReader fileReader3 = null;
            BufferedReader bufferedReader4 = null;
            if (TextUtils.isEmpty(string2)) {
                inputStreamOpenInputStream = PtgAdSdk.getContext().getContentResolver().openInputStream(Uri.parse(string2));
                byteArray = _oy._a(inputStreamOpenInputStream).toByteArray();
                if (inputStreamOpenInputStream != null) {
                    inputStreamOpenInputStream.close();
                }
                if (byteArray != null || byteArray.length == 0) {
                    Logger.e("find local policy file fail ，uri = " + string2);
                }
            } else {
                byteArray = null;
            }
            localPolicyEncode = PtgAdSdk.getConfig().getLocalPolicyEncode();
            if (TextUtils.isEmpty(localPolicyEncode)) {
                Logger.e("local policy encode unset");
                _hxVar2 = this._a;
                if (_hxVar2 != null) {
                    _hxVar2._c("local policy encode unset");
                    return;
                }
                return;
            }
            if (byteArray != null && byteArray.length > 0) {
                string = new String(byteArray, Charset.forName(localPolicyEncode));
            }
            file = _fp.this._a;
            if (file != null && file.exists()) {
                sb = new StringBuilder();
                fileReader = new FileReader(_fp.this._a);
                bufferedReader = new BufferedReader(fileReader);
                while (true) {
                    line = bufferedReader.readLine();
                    if (line != null) {
                        break;
                        break;
                    }
                    sb.append(line);
                }
                if (sb.length() > 0) {
                    string = sb.toString();
                }
                fileReader.close();
                bufferedReader.close();
            }
            if (!TextUtils.isEmpty(string)) {
                str_d = string;
            }
            if (TextUtils.isEmpty(str_d)) {
                Logger.e("all local policy decode fail");
                _hxVar = this._a;
                if (_hxVar != null) {
                    _hxVar._c("all local policy decode fail");
                    return;
                }
                return;
            }
            _cgVar = new _cg();
            _ckVar = new _ck();
            if (!_ckVar._c(str_d)) {
                _fp.this.getClass();
                Logger.e(new AdErrorImpl(10019, "local policy config parse fail", (Object) null).getMessage());
                this._a._c("local policy config parse fail");
            } else if (_cgVar._a(str_d, _ckVar)) {
                _fp.this.getClass();
                Logger.e(new AdErrorImpl(10019, "local policy data parse fail", (Object) null).getMessage());
                this._a._c("local policy data parse fail");
            } else {
                this._a._a(_cgVar, _ckVar);
                this._a._b(str_d);
                this._a._a(str_d);
            }
        }
    }

    public static File _a() {
        Context context = PtgAdSdk.getContext();
        if (context != null && !TextUtils.isEmpty(PtgAdSdk.getConfig().getKeyToken())) {
            try {
                File file = new File(context.getExternalFilesDir(null), PtgAdSdk.getConfig().getKeyToken());
                if (file.exists() && file.canRead()) {
                    return file;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    @Override // com.fancy._hw
    public final void _a(_hx _hxVar) {
        _b(_hxVar);
    }

    @Override // com.fancy._hw
    public final void _b(_hx _hxVar) {
        com.fancy.adsdk.lib.utils._d._b(new _a(_hxVar));
    }
}
