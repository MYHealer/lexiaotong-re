package com.adprof.sdk.api;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.adprof.sdk.p1;
import com.adprof.sdk.pk;
import com.adprof.sdk.q1;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.cdo.oaps.ad.Launcher;
import com.huawei.hms.actions.SearchIntents;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.io.IOUtils;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AFFileProvider extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PathStrategy f35a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String[] f34a = {"_display_name", "_size"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final File f1039a = new File("/");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final HashMap f33a = new HashMap();

    public interface PathStrategy {
        File getFileForUri(Uri uri);

        Uri getUriForFile(File file);
    }

    public static class SimplePathStrategy implements PathStrategy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f1040a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final HashMap f36a = new HashMap();

        public SimplePathStrategy(String str) {
            this.f1040a = str;
        }

        @Override // com.adprof.sdk.api.AFFileProvider.PathStrategy
        public File getFileForUri(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int iIndexOf = encodedPath.indexOf(47, 1);
            String strDecode = Uri.decode(encodedPath.substring(1, iIndexOf));
            String strDecode2 = Uri.decode(encodedPath.substring(iIndexOf + 1));
            File file = (File) this.f36a.get(strDecode);
            if (file == null) {
                throw new IllegalArgumentException("Unable to find configured root for " + uri);
            }
            File file2 = new File(file, strDecode2);
            try {
                File canonicalFile = file2.getCanonicalFile();
                if (canonicalFile.getPath().startsWith(file.getPath())) {
                    return canonicalFile;
                }
                throw new SecurityException("Resolved path jumped beyond configured root");
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file2);
            }
        }

        @Override // com.adprof.sdk.api.AFFileProvider.PathStrategy
        public Uri getUriForFile(File file) {
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry entry = null;
                for (Map.Entry entry2 : this.f36a.entrySet()) {
                    String path = ((File) entry2.getValue()).getPath();
                    if (canonicalPath.startsWith(path) && (entry == null || path.length() > ((File) entry.getValue()).getPath().length())) {
                        entry = entry2;
                    }
                }
                if (entry == null) {
                    throw new IllegalArgumentException("Failed to find configured root that contains " + canonicalPath);
                }
                String path2 = ((File) entry.getValue()).getPath();
                boolean zEndsWith = path2.endsWith("/");
                int length = path2.length();
                if (!zEndsWith) {
                    length++;
                }
                return new Uri.Builder().scheme("content").authority(this.f1040a).encodedPath(Uri.encode((String) entry.getKey()) + IOUtils.DIR_SEPARATOR_UNIX + Uri.encode(canonicalPath.substring(length), "/")).build();
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
            }
        }
    }

    public static PathStrategy a(Context context, String str) {
        PathStrategy pathStrategyB;
        try {
            HashMap map = f33a;
            synchronized (map) {
                pathStrategyB = (PathStrategy) map.get(str);
                if (pathStrategyB == null) {
                    pathStrategyB = b(context, str);
                    map.put(str, pathStrategyB);
                }
            }
            return pathStrategyB;
        } catch (Throwable th) {
            pk.b("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", th);
            return null;
        }
    }

    public static PathStrategy b(Context context, String str) throws XmlPullParserException, IOException {
        SimplePathStrategy simplePathStrategy = new SimplePathStrategy(str);
        ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider(str, 128);
        if (providerInfoResolveContentProvider == null) {
            throw new IllegalArgumentException("Couldn't find meta-data for provider with authority " + str);
        }
        XmlResourceParser xmlResourceParserLoadXmlMetaData = providerInfoResolveContentProvider.loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
        if (xmlResourceParserLoadXmlMetaData == null) {
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }
        while (true) {
            int next = xmlResourceParserLoadXmlMetaData.next();
            if (next == 1) {
                return simplePathStrategy;
            }
            if (next == 2) {
                String name = xmlResourceParserLoadXmlMetaData.getName();
                File externalStorageDirectory = null;
                String attributeValue = xmlResourceParserLoadXmlMetaData.getAttributeValue(null, "name");
                String attributeValue2 = xmlResourceParserLoadXmlMetaData.getAttributeValue(null, "path");
                if ("root-path".equals(name)) {
                    externalStorageDirectory = f1039a;
                } else if ("files-path".equals(name)) {
                    externalStorageDirectory = context.getFilesDir();
                } else if ("cache-path".equals(name)) {
                    externalStorageDirectory = context.getCacheDir();
                } else if ("external-path".equals(name)) {
                    externalStorageDirectory = Environment.getExternalStorageDirectory();
                } else if ("external-files-path".equals(name)) {
                    File[] externalFilesDirs = getExternalFilesDirs(context, null);
                    if (externalFilesDirs.length > 0) {
                        externalStorageDirectory = externalFilesDirs[0];
                    }
                } else if ("external-cache-path".equals(name)) {
                    File[] externalCacheDirs = getExternalCacheDirs(context);
                    if (externalCacheDirs.length > 0) {
                        externalStorageDirectory = externalCacheDirs[0];
                    }
                } else if ("external-media-path".equals(name)) {
                    File[] externalMediaDirs = context.getExternalMediaDirs();
                    if (externalMediaDirs.length > 0) {
                        externalStorageDirectory = externalMediaDirs[0];
                    }
                }
                if (externalStorageDirectory == null) {
                    continue;
                } else {
                    String str2 = new String[]{attributeValue2}[0];
                    if (str2 != null) {
                        externalStorageDirectory = new File(externalStorageDirectory, str2);
                    }
                    if (TextUtils.isEmpty(attributeValue)) {
                        throw new IllegalArgumentException("Name must not be empty");
                    }
                    try {
                        simplePathStrategy.f36a.put(attributeValue, externalStorageDirectory.getCanonicalFile());
                    } catch (IOException e) {
                        throw new IllegalArgumentException("Failed to resolve canonical path for " + externalStorageDirectory, e);
                    }
                }
            }
        }
    }

    public static File[] getExternalCacheDirs(Context context) {
        return context.getExternalCacheDirs();
    }

    public static File[] getExternalFilesDirs(Context context, String str) {
        return context.getExternalFilesDirs(str);
    }

    public static Uri getUriForFile(Context context, String str, File file) {
        return a(context, str).getUriForFile(file);
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        String str;
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            str = "Provider must not be exported";
        } else {
            if (providerInfo.grantUriPermissions) {
                this.f35a = a(context, providerInfo.authority);
                return;
            }
            str = "Provider must grant uri permissions";
        }
        pk.b(str);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        try {
            PathStrategy pathStrategy = this.f35a;
            if (pathStrategy != null) {
                return pathStrategy.getFileForUri(uri).delete() ? 1 : 0;
            }
            return 0;
        } catch (Throwable th) {
            pk.b(Launcher.Method.DELETE_CALLBACK, th);
            return 0;
        }
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        try {
            File fileForUri = this.f35a.getFileForUri(uri);
            int iLastIndexOf = fileForUri.getName().lastIndexOf(46);
            if (iLastIndexOf < 0) {
                return "application/octet-stream";
            }
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileForUri.getName().substring(iLastIndexOf + 1));
            return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
        } catch (Throwable th) {
            pk.b("getType", th);
            return "application/octet-stream";
        }
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        if (getContext() instanceof Application) {
            pk.d("AFFileProvider registerActivityLifecycle ");
            q1 q1VarM710a = q1.m710a();
            Application application = (Application) getContext();
            q1VarM710a.getClass();
            try {
                if (!q1VarM710a.f650a) {
                    if (application == null) {
                        pk.b("activityCallBack error, application is null");
                    } else {
                        application.registerActivityLifecycleCallbacks(new p1(q1VarM710a));
                    }
                    q1VarM710a.f650a = true;
                }
            } catch (Throwable th) {
                pk.b("lifecycle mgr init error: ", th);
            }
        }
        return true;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        int i;
        File fileForUri = this.f35a.getFileForUri(uri);
        if (t.k.equals(str)) {
            i = 268435456;
        } else if (IAdInterListener.AdReqParam.WIDTH.equals(str) || "wt".equals(str)) {
            i = 738197504;
        } else if ("wa".equals(str)) {
            i = 704643072;
        } else if ("rw".equals(str)) {
            i = 939524096;
        } else {
            if (!"rwt".equals(str)) {
                pk.b("Invalid mode: " + str);
            }
            i = 1006632960;
        }
        return ParcelFileDescriptor.open(fileForUri, i);
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i;
        try {
            File fileForUri = this.f35a.getFileForUri(uri);
            if (strArr == null) {
                strArr = f34a;
            }
            String[] strArr3 = new String[strArr.length];
            Object[] objArr = new Object[strArr.length];
            int i2 = 0;
            for (String str3 : strArr) {
                if ("_display_name".equals(str3)) {
                    strArr3[i2] = "_display_name";
                    i = i2 + 1;
                    objArr[i2] = fileForUri.getName();
                } else {
                    if ("_size".equals(str3)) {
                        strArr3[i2] = "_size";
                        i = i2 + 1;
                        objArr[i2] = Long.valueOf(fileForUri.length());
                    }
                }
                i2 = i;
            }
            String[] strArr4 = new String[i2];
            System.arraycopy(strArr3, 0, strArr4, 0, i2);
            Object[] objArr2 = new Object[i2];
            System.arraycopy(objArr, 0, objArr2, 0, i2);
            MatrixCursor matrixCursor = new MatrixCursor(strArr4, 1);
            matrixCursor.addRow(objArr2);
            return matrixCursor;
        } catch (Throwable th) {
            pk.b(SearchIntents.EXTRA_QUERY, th);
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }
}
