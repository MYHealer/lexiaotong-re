package com.fancy.adsdk.lib.utils.ot;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Process;
import com.fancy._ie;
import com.fancy.adsdk.lib.utils._d;
import com.huawei.openalliance.ad.constant.x;
import com.kuaishou.weapon.p0.t;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class LruDiskUtils {
    public static final String CACHE_CONFIG_KEY = "fancy_sdk_config_for_policy";
    private static final int MAX_COUNT = Integer.MAX_VALUE;
    private static final int MAX_SIZE = 50000000;
    public static final int TIME_DAY = 86400;
    public static final int TIME_HOUR = 3600;
    private static final String TMP_FILE = ".tmp";
    private static final Map<String, LruDiskUtils> mInstanceMap = new HashMap();
    private _a mCache;
    private final Map<String, _b> transactionMap = new ConcurrentHashMap();

    public class _a {
        public final AtomicLong _a;
        public final AtomicInteger _b;
        public final long _c;
        public final int _d;
        public final Map<File, Long> _e;
        public File _f;
        public AtomicBoolean _g;

        /* JADX INFO: renamed from: com.fancy.adsdk.lib.utils.ot.LruDiskUtils$_a$_a, reason: collision with other inner class name */
        public class RunnableC0376_a implements Runnable {
            public RunnableC0376_a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                File[] fileArrListFiles = _a.this._f.listFiles();
                if (fileArrListFiles != null) {
                    int length = 0;
                    int i = 0;
                    for (File file : fileArrListFiles) {
                        if (file.getName().endsWith(".tmp")) {
                            file.delete();
                        } else {
                            _a.this.getClass();
                            length = (int) (file.length() + ((long) length));
                            i++;
                            _a.this._e.put(file, Long.valueOf(file.lastModified()));
                        }
                    }
                    _a.this._a.set(length);
                    _a.this._b.set(i);
                }
                try {
                    _a.this._g.set(true);
                } catch (Exception unused) {
                }
            }
        }

        public _a(File file, long j, int i) {
            this._e = Collections.synchronizedMap(new HashMap());
            this._g = new AtomicBoolean();
            this._f = file;
            this._c = j;
            this._d = i;
            this._a = new AtomicLong();
            this._b = new AtomicInteger();
            _a();
        }

        public /* synthetic */ _a(File file, long j, int i, int i2) {
            this(file, j, i);
        }

        public static void _a(_a _aVar, File file) {
            int iAddAndGet = _aVar._b.get();
            while (iAddAndGet + 1 > _aVar._d) {
                _aVar._a.addAndGet(-_aVar._b());
                iAddAndGet = _aVar._b.addAndGet(-1);
            }
            _aVar._b.addAndGet(1);
            long length = file.length();
            long jAddAndGet = _aVar._a.get();
            while (jAddAndGet + length > _aVar._c) {
                jAddAndGet = _aVar._a.addAndGet(-_aVar._b());
            }
            _aVar._a.addAndGet(length);
            Long lValueOf = Long.valueOf(System.currentTimeMillis());
            file.setLastModified(lValueOf.longValue());
            _aVar._e.put(file, lValueOf);
        }

        public final void _a() {
            _d._b(new RunnableC0376_a());
        }

        public final long _b() {
            File key;
            if (this._e.isEmpty()) {
                return 0L;
            }
            Set<Map.Entry<File, Long>> setEntrySet = this._e.entrySet();
            synchronized (this._e) {
                key = null;
                Long value = null;
                for (Map.Entry<File, Long> entry : setEntrySet) {
                    if (key == null) {
                        key = entry.getKey();
                        value = entry.getValue();
                    } else {
                        Long value2 = entry.getValue();
                        if (value2.longValue() < value.longValue()) {
                            key = entry.getKey();
                            value = value2;
                        }
                    }
                }
            }
            long length = key.length();
            if (key.delete()) {
                this._e.remove(key);
            }
            return length;
        }
    }

    public class _b {
        public File _a;
        public File _b;
        public boolean _c;
        public boolean _d = false;

        public _b(String str) {
            this._c = false;
            File file = new File(LruDiskUtils.this.mCache._f, str + ".tmp");
            this._a = file;
            if (file.exists()) {
                this._c = true;
            }
            this._b = new File(LruDiskUtils.this.mCache._f, str);
        }

        public final File _a() {
            synchronized (LruDiskUtils.this.transactionMap) {
                if (this._d || this._c || this._b.exists() || !this._a.renameTo(this._b) || !this._b.exists()) {
                    LruDiskUtils.this.transactionMap.remove(this._b.getAbsolutePath());
                    return null;
                }
                this._d = true;
                _a._a(LruDiskUtils.this.mCache, this._b);
                return this._b;
            }
        }

        public final void _b() {
            synchronized (LruDiskUtils.this.transactionMap) {
                if (!this._c) {
                    this._a.deleteOnExit();
                    if (!this._d) {
                        this._b.deleteOnExit();
                    }
                }
                LruDiskUtils.this.transactionMap.remove(this._b.getAbsolutePath());
            }
        }
    }

    public static class _c {
        public static boolean _a(byte[] bArr) {
            String[] strArr;
            if (bArr != null && bArr.length > 15 && bArr[13] == 45) {
                int i = 0;
                while (true) {
                    if (i < bArr.length) {
                        if (bArr[i] != 32) {
                            i++;
                        } else if (i > 14) {
                            String str = new String(_a(bArr, 0, 13));
                            int i2 = 0;
                            while (true) {
                                if (i2 >= bArr.length) {
                                    i2 = -1;
                                    break;
                                }
                                if (bArr[i2] == 32) {
                                    break;
                                }
                                i2++;
                            }
                            strArr = new String[]{str, new String(_a(bArr, 14, i2))};
                            break;
                        }
                    }
                    strArr = null;
                    break;
                }
            }
            strArr = null;
            break;
            if (strArr != null && strArr.length == 2) {
                String strSubstring = strArr[0];
                while (strSubstring.startsWith("0")) {
                    strSubstring = strSubstring.substring(1, strSubstring.length());
                }
                if (System.currentTimeMillis() > (Long.valueOf(strArr[1]).longValue() * 1000) + Long.valueOf(strSubstring).longValue()) {
                    return true;
                }
            }
            return false;
        }

        public static byte[] _a(byte[] bArr, int i, int i2) {
            int i3 = i2 - i;
            if (i3 < 0) {
                throw new IllegalArgumentException(i + " > " + i2);
            }
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, i, bArr2, 0, Math.min(bArr.length - i, i3));
            return bArr2;
        }
    }

    private LruDiskUtils(File file, long j, int i) {
        ensureDirWritable(file);
        this.mCache = new _a(file, j, i, 0);
    }

    private static File buildSafeCacheDir(Context context, String str) {
        File cacheDir = context != null ? context.getCacheDir() : null;
        File filesDir = context != null ? context.getFilesDir() : null;
        File file = cacheDir != null ? new File(cacheDir, str) : null;
        if (ensureDirWritable(file)) {
            return file;
        }
        File file2 = filesDir != null ? new File(filesDir, str) : null;
        if (ensureDirWritable(file2)) {
            return file2;
        }
        if (file != null) {
            return file;
        }
        return file2 != null ? file2 : new File(str);
    }

    private static boolean ensureDirWritable(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            if (file.isDirectory()) {
                return file.canWrite();
            }
            if (!file.delete()) {
                return false;
            }
        }
        return file.mkdirs() || (file.exists() && file.isDirectory() && file.canWrite());
    }

    public static LruDiskUtils get(Context context) {
        return get(context, "fancy_ad_cache");
    }

    public static LruDiskUtils get(Context context, long j, int i) {
        return get(buildSafeCacheDir(context, "fancy_ad_cache"), j, i);
    }

    public static LruDiskUtils get(Context context, String str) {
        return get(buildSafeCacheDir(context, str), 50000000L, Integer.MAX_VALUE);
    }

    public static LruDiskUtils get(File file) {
        return get(file, 50000000L, Integer.MAX_VALUE);
    }

    public static LruDiskUtils get(File file, long j, int i) {
        Map<String, LruDiskUtils> map = mInstanceMap;
        LruDiskUtils lruDiskUtils = map.get(file.getAbsoluteFile() + myPid());
        if (lruDiskUtils != null && file.exists()) {
            return lruDiskUtils;
        }
        LruDiskUtils lruDiskUtils2 = new LruDiskUtils(file, j, i);
        map.put(file.getAbsolutePath() + myPid(), lruDiskUtils2);
        return lruDiskUtils2;
    }

    private static String myPid() {
        return _ie._a("_").append(Process.myPid()).toString();
    }

    public Set<String> allKey() {
        _a _aVar = this.mCache;
        while (!_aVar._g.get()) {
            try {
                Thread.sleep(100L);
            } catch (Exception unused) {
            }
        }
        HashSet hashSet = new HashSet();
        synchronized (_aVar._e) {
            hashSet.addAll(_aVar._e.keySet());
        }
        HashSet hashSet2 = new HashSet();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            hashSet2.add(((File) it.next()).getName());
        }
        return hashSet2;
    }

    public void clear() {
        _a _aVar = this.mCache;
        _aVar._e.clear();
        _aVar._a.set(0L);
        File[] fileArrListFiles = _aVar._f.listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                file.delete();
            }
        }
    }

    public File commit(File file) {
        synchronized (this.transactionMap) {
            String absolutePath = file.getAbsolutePath();
            String string = absolutePath.endsWith(".tmp") ? absolutePath.subSequence(0, absolutePath.indexOf(".tmp")).toString() : null;
            if (this.transactionMap.containsKey(string)) {
                return this.transactionMap.get(string)._a();
            }
            return null;
        }
    }

    public void fail(File file) {
        synchronized (this.transactionMap) {
            String absolutePath = file.getAbsolutePath();
            String string = absolutePath.endsWith(".tmp") ? absolutePath.subSequence(0, absolutePath.indexOf(".tmp")).toString() : null;
            if (this.transactionMap.containsKey(string)) {
                this.transactionMap.get(string)._b();
            }
        }
    }

    public File file(String str) {
        _a _aVar = this.mCache;
        _aVar.getClass();
        File file = new File(_aVar._f, str);
        if (file.exists()) {
            return file;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:63:0x009d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0083: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:39:0x0083 */
    public byte[] getAsBinary(String str) throws Throwable {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        RandomAccessFile randomAccessFile3 = null;
        try {
            try {
                _a _aVar = this.mCache;
                _aVar.getClass();
                File file = new File(_aVar._f, str);
                Long lValueOf = Long.valueOf(System.currentTimeMillis());
                file.setLastModified(lValueOf.longValue());
                _aVar._e.put(file, lValueOf);
                if (!file.exists()) {
                    return null;
                }
                randomAccessFile = new RandomAccessFile(file, t.k);
                try {
                    int length = (int) randomAccessFile.length();
                    byte[] bArr_a = new byte[length];
                    randomAccessFile.read(bArr_a);
                    if (_c._a(bArr_a)) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        remove(str);
                        return null;
                    }
                    if (length > 15 && bArr_a[13] == 45) {
                        int i = 0;
                        for (int i2 = 0; i2 < length; i2++) {
                            if (bArr_a[i2] == 32) {
                                if (i2 <= 14) {
                                    break;
                                }
                                while (true) {
                                    if (i >= length) {
                                        i = -1;
                                        break;
                                    }
                                    if (bArr_a[i] == 32) {
                                        break;
                                    }
                                    i++;
                                }
                                bArr_a = _c._a(bArr_a, i + 1, length);
                                break;
                            }
                        }
                    }
                    try {
                        randomAccessFile.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return bArr_a;
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Throwable th) {
                th = th;
                randomAccessFile3 = randomAccessFile2;
                if (randomAccessFile3 != null) {
                    try {
                        randomAccessFile3.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            randomAccessFile = null;
        } catch (Throwable th2) {
            th = th2;
            if (randomAccessFile3 != null) {
                randomAccessFile3.close();
            }
            throw th;
        }
        e.printStackTrace();
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (IOException e6) {
                e6.printStackTrace();
            }
        }
        return null;
    }

    public Bitmap getAsBitmap(String str) throws Throwable {
        byte[] asBinary = getAsBinary(str);
        if (asBinary == null || asBinary.length == 0) {
            return null;
        }
        return BitmapFactory.decodeByteArray(asBinary, 0, asBinary.length);
    }

    public JSONArray getAsJSONArray(String str) {
        try {
            return new JSONArray(getAsString(str));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONObject getAsJSONObject(String str) {
        try {
            return new JSONObject(getAsString(str));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:56:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x005e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:? A[SYNTHETIC] */
    public Object getAsObject(String str) throws Throwable {
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        ObjectInputStream objectInputStream;
        Throwable th2;
        byte[] asBinary = getAsBinary(str);
        ObjectInputStream objectInputStream2 = null;
        if (asBinary == null) {
            return null;
        }
        try {
            byteArrayInputStream = new ByteArrayInputStream(asBinary);
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
                try {
                    try {
                        Object object = objectInputStream.readObject();
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            objectInputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        return object;
                    } catch (Exception e3) {
                        e = e3;
                        e.printStackTrace();
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        return null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    Throwable th4 = th;
                    objectInputStream2 = objectInputStream;
                    th2 = th4;
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    if (objectInputStream2 == null) {
                        throw th2;
                    }
                    try {
                        objectInputStream2.close();
                        throw th2;
                    } catch (IOException e7) {
                        e7.printStackTrace();
                        throw th2;
                    }
                }
            } catch (Exception e8) {
                e = e8;
                objectInputStream = null;
            } catch (Throwable th5) {
                th2 = th5;
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                if (objectInputStream2 == null) {
                    throw th2;
                }
                objectInputStream2.close();
                throw th2;
            }
        } catch (Exception e9) {
            e = e9;
            objectInputStream = null;
            byteArrayInputStream = null;
        } catch (Throwable th6) {
            byteArrayInputStream = null;
            th = th6;
            objectInputStream = null;
            Throwable th7 = th;
            objectInputStream2 = objectInputStream;
            th2 = th7;
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
            if (objectInputStream2 == null) {
                throw th2;
            }
            objectInputStream2.close();
            throw th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:69:0x00b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public String getAsString(String str) throws Throwable {
        BufferedReader bufferedReader;
        _a _aVar = this.mCache;
        _aVar.getClass();
        File file = new File(_aVar._f, str);
        Long lValueOf = Long.valueOf(System.currentTimeMillis());
        file.setLastModified(lValueOf.longValue());
        _aVar._e.put(file, lValueOf);
        BufferedReader bufferedReader2 = null;
        if (!file.exists()) {
            return null;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String strSubstring = "";
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    strSubstring = strSubstring + line;
                } catch (IOException e) {
                    e = e;
                    try {
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader2 = bufferedReader;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            }
            if (_c._a(strSubstring.getBytes())) {
                try {
                    bufferedReader.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                remove(str);
                return null;
            }
            byte[] bytes = strSubstring.getBytes();
            if (bytes != null && bytes.length > 15 && bytes[13] == 45) {
                for (int i = 0; i < bytes.length; i++) {
                    if (bytes[i] == 32) {
                        if (i <= 14) {
                            break;
                        }
                        strSubstring = strSubstring.substring(strSubstring.indexOf(32) + 1, strSubstring.length());
                        break;
                    }
                }
            }
            try {
                bufferedReader.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            return strSubstring;
        } catch (IOException e6) {
            e = e6;
            bufferedReader = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = bufferedReader2;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th;
        }
    }

    public void put(String str, Bitmap bitmap) {
        byte[] byteArray;
        if (bitmap == null) {
            byteArray = null;
        } else {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        put(str, byteArray);
    }

    public void put(String str, Serializable serializable) throws Throwable {
        put(str, serializable, -1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.ObjectOutputStream] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.ObjectOutputStream] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.ObjectOutputStream] */
    public void put(String str, Serializable serializable, int i) throws Throwable {
        ?? objectOutputStream;
        ?? r0 = 0;
        ?? r1 = 0;
        try {
            try {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                    try {
                        objectOutputStream.writeObject(serializable);
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        r0 = -1;
                        if (i != -1) {
                            put(str, byteArray, i);
                        } else {
                            put(str, byteArray);
                        }
                        objectOutputStream.close();
                    } catch (Exception e) {
                        e = e;
                        r1 = objectOutputStream;
                        e.printStackTrace();
                        r1.close();
                        r0 = r1;
                    } catch (Throwable th) {
                        th = th;
                        try {
                            objectOutputStream.close();
                        } catch (IOException unused) {
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    objectOutputStream = r0;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (IOException unused2) {
        }
    }

    public void put(String str, JSONArray jSONArray) {
        put(str, jSONArray.toString());
    }

    public void put(String str, JSONArray jSONArray, int i) {
        put(str, jSONArray.toString(), i);
    }

    public void put(String str, JSONObject jSONObject) {
        put(str, jSONObject.toString());
    }

    public void put(String str, JSONObject jSONObject, int i) {
        put(str, jSONObject.toString(), i);
    }

    public boolean remove(String str) {
        _a _aVar = this.mCache;
        _aVar.getClass();
        File file = new File(_aVar._f, str);
        Long lValueOf = Long.valueOf(System.currentTimeMillis());
        file.setLastModified(lValueOf.longValue());
        _aVar._e.put(file, lValueOf);
        return file.delete();
    }

    public _b transaction(String str) {
        _b _bVar;
        synchronized (this.transactionMap) {
            _bVar = new _b(str);
            String absolutePath = _bVar._b.getAbsolutePath();
            if (this.transactionMap.get(absolutePath) == null) {
                this.transactionMap.put(absolutePath, _bVar);
            }
        }
        return _bVar;
    }

    public void put(String str, Bitmap bitmap, int i) {
        byte[] byteArray;
        if (bitmap == null) {
            byteArray = null;
        } else {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        put(str, byteArray, i);
    }

    public void put(String str, Drawable drawable) {
        Bitmap bitmap;
        if (drawable == null) {
            bitmap = null;
        } else {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.draw(canvas);
            bitmap = bitmapCreateBitmap;
        }
        put(str, bitmap);
    }

    public void put(String str, Drawable drawable, int i) {
        Bitmap bitmap;
        if (drawable == null) {
            bitmap = null;
        } else {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.draw(canvas);
            bitmap = bitmapCreateBitmap;
        }
        put(str, bitmap, i);
    }

    public void put(String str, String str2) {
        _a _aVar = this.mCache;
        _aVar.getClass();
        File file = new File(_aVar._f, str);
        try {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file), 1024);
                try {
                    bufferedWriter.write(str2);
                    bufferedWriter.flush();
                    try {
                        bufferedWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    _a._a(this.mCache, file);
                } catch (Throwable th) {
                    try {
                        bufferedWriter.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        } catch (Throwable th2) {
            _a._a(this.mCache, file);
            throw th2;
        }
    }

    public void put(String str, String str2, int i) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbAppend = new StringBuilder().append(System.currentTimeMillis()).append("");
        while (true) {
            String string = sbAppend.toString();
            if (string.length() >= 13) {
                put(str, sb.append(string + x.A + i + ' ').append(str2).toString());
                return;
            }
            sbAppend = new StringBuilder("0").append(string);
        }
    }

    public void put(String str, byte[] bArr) {
        _a _aVar = this.mCache;
        _aVar.getClass();
        File file = new File(_aVar._f, str);
        try {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    fileOutputStream.write(bArr);
                    fileOutputStream.flush();
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (Throwable th) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    throw th;
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            _a._a(this.mCache, file);
        } catch (Throwable th2) {
            _a._a(this.mCache, file);
            throw th2;
        }
    }

    public void put(String str, byte[] bArr, int i) {
        StringBuilder sbAppend = new StringBuilder().append(System.currentTimeMillis()).append("");
        while (true) {
            String string = sbAppend.toString();
            if (string.length() >= 13) {
                byte[] bytes = (string + x.A + i + ' ').getBytes();
                byte[] bArr2 = new byte[bytes.length + bArr.length];
                System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
                System.arraycopy(bArr, 0, bArr2, bytes.length, bArr.length);
                put(str, bArr2);
                return;
            }
            sbAppend = new StringBuilder("0").append(string);
        }
    }
}
