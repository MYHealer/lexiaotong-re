package com.hihonor.id.router;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.text.TextUtils;
import android.util.Log;
import com.yfanads.android.adx.core.TransparentActivity;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class Router {
    public static boolean bindService(Context context, Intent intent, int i, Executor executor, ServiceConnection serviceConnection) {
        if (context == null) {
            Log.e(TransparentActivity.TAG, "Invalid Context for binding service. ");
            return false;
        }
        if (intent == null) {
            Log.e(TransparentActivity.TAG, "Invalid Intent for binding service. ");
            return false;
        }
        if (serviceConnection == null) {
            Log.e(TransparentActivity.TAG, "Invalid ServiceConnection for binding service. ");
            return false;
        }
        ComponentName component = intent.getComponent();
        if (component == null) {
            Log.e(TransparentActivity.TAG, "Invalid componentName in Intent. ");
            return false;
        }
        String packageName = component.getPackageName();
        String className = component.getClassName();
        if (TextUtils.isEmpty(packageName)) {
            Log.e(TransparentActivity.TAG, "Unable to determine plugin from Intent. ");
            return false;
        }
        if (TextUtils.isEmpty(className)) {
            Log.e(TransparentActivity.TAG, "Unable to determine service from Intent. ");
            return false;
        }
        Bundle bundleA = c.a(intent, serviceConnection, i, executor);
        Uri uriBuild = new Uri.Builder().scheme("content").authority("com.hihonor.id.router.routercontentprovider").build();
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            Log.e(TransparentActivity.TAG, "Unable to get valid ContentResolver. ");
            return false;
        }
        try {
            Bundle bundleCall = contentResolver.call(uriBuild, "routeBindService", (String) null, bundleA);
            if (bundleCall == null) {
                return false;
            }
            return bundleCall.getBoolean("routeResult", false);
        } catch (IllegalArgumentException unused) {
            Log.e(TransparentActivity.TAG, "Unable to find RouterContentProvider. ");
            return false;
        } catch (Exception unused2) {
            Log.e(TransparentActivity.TAG, "Unexpected error occurred when binding service. ");
            return false;
        }
    }

    public static int delete(Context context, Uri uri, Bundle bundle) {
        if (Build.VERSION.SDK_INT < 30) {
            Log.w(TransparentActivity.TAG, "Sdk version lower than R. Unable to invoke this delete. ");
            return 0;
        }
        if (context == null) {
            Log.e(TransparentActivity.TAG, "Invalid context for deleting. ");
            return 0;
        }
        if (uri == null) {
            Log.e(TransparentActivity.TAG, "Invalid uri for deleting. ");
            return 0;
        }
        Uri uriA = c.a(uri);
        if (uriA == null) {
            Log.e(TransparentActivity.TAG, "Unable to build valid uri for deleting. ");
            return 0;
        }
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            Log.e(TransparentActivity.TAG, "Unable to get valid ContentResolver. ");
            return 0;
        }
        try {
            return contentResolver.delete(uriA, bundle);
        } catch (IllegalArgumentException unused) {
            Log.e(TransparentActivity.TAG, "Unable to find RouterContentProvider. ");
            return 0;
        } catch (Exception unused2) {
            Log.e(TransparentActivity.TAG, "Unexpected error occurred when deleting. ");
            return 0;
        }
    }

    public static Uri insert(Context context, Uri uri, ContentValues contentValues) {
        String str;
        if (context == null) {
            str = "Invalid context for inserting. ";
        } else if (uri == null) {
            str = "Invalid uri for inserting. ";
        } else {
            Uri uriA = c.a(uri);
            if (uriA == null) {
                str = "Unable to build valid uri for inserting. ";
            } else {
                ContentResolver contentResolver = context.getContentResolver();
                if (contentResolver == null) {
                    str = "Unable to get valid ContentResolver. ";
                } else {
                    try {
                        return contentResolver.insert(uriA, contentValues);
                    } catch (IllegalArgumentException unused) {
                        str = "Unable to find RouterContentProvider. ";
                    } catch (Exception unused2) {
                        str = "Unexpected error occurred when inserting. ";
                    }
                }
            }
        }
        Log.e(TransparentActivity.TAG, str);
        return null;
    }

    public static boolean isNeedUpdate(Context context, String str) {
        if (context == null) {
            Log.e(TransparentActivity.TAG, "Invalid Context for isNeedUpdate. ");
            return false;
        }
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            Log.e(TransparentActivity.TAG, "Unable to get valid ContentResolver. ");
            return false;
        }
        int i = c.c;
        try {
            Bundle bundleCall = contentResolver.call(new Uri.Builder().scheme("content").authority("com.hihonor.id.router.routercontentprovider").build(), "queryUpdate", str, (Bundle) null);
            if (bundleCall == null) {
                return false;
            }
            return bundleCall.getBoolean("routeResult", false);
        } catch (IllegalArgumentException unused) {
            Log.e(TransparentActivity.TAG, "Unable to find RouterContentProvider. ");
            return false;
        } catch (Exception unused2) {
            Log.e(TransparentActivity.TAG, "Unexpected error occurred when binding service. ");
            return false;
        }
    }

    public static Cursor query(Context context, Uri uri, String[] strArr, Bundle bundle, CancellationSignal cancellationSignal) {
        String str;
        if (context == null) {
            str = "Invalid context for querying. ";
        } else if (uri == null) {
            str = "Invalid uri for querying. ";
        } else {
            Uri uriA = c.a(uri);
            if (uriA == null) {
                str = "Unable to build valid uri for querying. ";
            } else {
                ContentResolver contentResolver = context.getContentResolver();
                if (contentResolver == null) {
                    str = "Unable to get valid ContentResolver. ";
                } else {
                    try {
                        return contentResolver.query(uriA, strArr, bundle, cancellationSignal);
                    } catch (IllegalArgumentException unused) {
                        str = "Unable to find RouterContentProvider. ";
                    } catch (Exception unused2) {
                        str = "Unexpected error occurred when querying. ";
                    }
                }
            }
        }
        Log.e(TransparentActivity.TAG, str);
        return null;
    }

    public static Bundle queryPluginVersion(Context context, String str) {
        if (context == null) {
            Log.e(TransparentActivity.TAG, "Invalid Context for calling RouterContentProvider. ");
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            Log.e(TransparentActivity.TAG, "Invalid pluginName for querying version. ");
            return null;
        }
        int i = c.c;
        Uri uriBuild = new Uri.Builder().scheme("content").authority("com.hihonor.id.router.routercontentprovider").build();
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            Log.e(TransparentActivity.TAG, "Unable to get valid ContentResolver. ");
            return null;
        }
        try {
            return contentResolver.call(uriBuild, "queryPluginVersion", str, (Bundle) null);
        } catch (IllegalArgumentException unused) {
            Log.e(TransparentActivity.TAG, "Unable to find RouterContentProvider. ");
            return null;
        } catch (Exception unused2) {
            Log.e(TransparentActivity.TAG, "Unexpected error occurred when querying plugin version. ");
            return null;
        }
    }

    public static int silentUpdate(Context context, String str) {
        String str2;
        String str3;
        if (context == null) {
            str3 = "Invalid Context for isNeedUpdate. ";
        } else {
            ContentResolver contentResolver = context.getContentResolver();
            if (contentResolver != null) {
                int i = c.c;
                Bundle bundleCall = null;
                try {
                    bundleCall = contentResolver.call(new Uri.Builder().scheme("content").authority("com.hihonor.id.router.routercontentprovider").build(), "silentUpdate", str, (Bundle) null);
                } catch (IllegalArgumentException unused) {
                    str2 = "Unable to find RouterContentProvider. ";
                    Log.e(TransparentActivity.TAG, str2);
                } catch (Exception unused2) {
                    str2 = "Unexpected error occurred when binding service. ";
                    Log.e(TransparentActivity.TAG, str2);
                }
                if (bundleCall == null) {
                    return -1;
                }
                return bundleCall.getInt("routeResult", -1);
            }
            str3 = "Unable to get valid ContentResolver. ";
        }
        Log.e(TransparentActivity.TAG, str3);
        return -1;
    }

    public static int startActivity(Activity activity, Intent intent, Bundle bundle) {
        String str;
        if (activity == null) {
            str = "Empty activity in startActivity. ";
        } else if (intent == null) {
            str = "Empty intent in startActivity. ";
        } else {
            Intent intentA = c.a(intent);
            if (intentA != null) {
                try {
                    activity.startActivity(intentA, bundle);
                    return -1;
                } catch (ActivityNotFoundException unused) {
                    Log.e(TransparentActivity.TAG, "Unable to find RouterActivity. ");
                    return 1001;
                } catch (Exception unused2) {
                    Log.e(TransparentActivity.TAG, "Unexpected error occurred in startActivity. ");
                    return 1002;
                }
            }
            str = "Unable to build valid intent for startActivity from Activity. ";
        }
        Log.e(TransparentActivity.TAG, str);
        return 1000;
    }

    public static int startActivityForResult(Activity activity, Intent intent, int i) {
        return startActivityForResult(activity, intent, i, null);
    }

    public static int startInstallGuideActivityForResult(Activity activity, String str, int i) {
        if (activity == null) {
            Log.i(TransparentActivity.TAG, "startInstallGuideActivityForResult : activity is null.");
            return 1000;
        }
        Intent intent = new Intent("com.hihonor.id.MMS_INSTALL_GUIDE");
        intent.setPackage("com.hihonor.id");
        intent.putExtra("pluginName", str);
        try {
            activity.startActivityForResult(intent, i);
            return -1;
        } catch (ActivityNotFoundException unused) {
            Log.e(TransparentActivity.TAG, "Unable to find RouterActivity. ");
            return 1001;
        } catch (Exception unused2) {
            Log.e(TransparentActivity.TAG, "Unexpected error occurred in startActivityForResult. ");
            return 1002;
        }
    }

    public static void unbindService(Context context, ServiceConnection serviceConnection) {
        String str;
        String str2;
        if (context == null) {
            str2 = "Invalid Context for unbinding service. ";
        } else if (serviceConnection == null) {
            str2 = "Invalid ServiceConnection for unbinding service. ";
        } else {
            Bundle bundleA = c.a(serviceConnection);
            if (bundleA != null) {
                Uri uriBuild = new Uri.Builder().scheme("content").authority("com.hihonor.id.router.routercontentprovider").build();
                ContentResolver contentResolver = context.getContentResolver();
                if (contentResolver == null) {
                    return;
                }
                try {
                    Log.i(TransparentActivity.TAG, "Route for unbind service result: " + contentResolver.call(uriBuild, "routeUnbindService", (String) null, bundleA).getBoolean("routeResult", false));
                    return;
                } catch (IllegalArgumentException unused) {
                    str = "Unable to find RouterContentProvider. ";
                    Log.e(TransparentActivity.TAG, str);
                    return;
                } catch (Exception unused2) {
                    str = "Unexpected error occurred when unbinding service. ";
                    Log.e(TransparentActivity.TAG, str);
                    return;
                }
            }
            str2 = "Unable to build valid bundle for unbinding service. ";
        }
        Log.e(TransparentActivity.TAG, str2);
    }

    public static int update(Context context, Uri uri, ContentValues contentValues, Bundle bundle) {
        if (Build.VERSION.SDK_INT < 30) {
            Log.w(TransparentActivity.TAG, "Sdk version lower than R. Unable to invoke this update. ");
            return 0;
        }
        if (context == null) {
            Log.e(TransparentActivity.TAG, "Invalid context for updating. ");
            return 0;
        }
        if (uri == null) {
            Log.e(TransparentActivity.TAG, "Invalid uri for updating. ");
            return 0;
        }
        Uri uriA = c.a(uri);
        if (uriA == null) {
            Log.e(TransparentActivity.TAG, "Unable to build valid uri for updating. ");
            return 0;
        }
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            Log.e(TransparentActivity.TAG, "Unable to get valid ContentResolver. ");
            return 0;
        }
        try {
            return contentResolver.update(uriA, contentValues, bundle);
        } catch (IllegalArgumentException unused) {
            Log.e(TransparentActivity.TAG, "Unable to find RouterContentProvider. ");
            return 0;
        } catch (Exception unused2) {
            Log.e(TransparentActivity.TAG, "Unexpected error occurred when updating. ");
            return 0;
        }
    }

    public static int delete(Context context, Uri uri, String str, String[] strArr) {
        String str2;
        if (context == null) {
            str2 = "Invalid context for deleting. ";
        } else if (uri == null) {
            str2 = "Invalid uri for deleting. ";
        } else {
            Uri uriA = c.a(uri);
            if (uriA == null) {
                str2 = "Unable to build valid uri for deleting. ";
            } else {
                ContentResolver contentResolver = context.getContentResolver();
                if (contentResolver == null) {
                    str2 = "Unable to get valid ContentResolver. ";
                } else {
                    try {
                        return contentResolver.delete(uriA, str, strArr);
                    } catch (IllegalArgumentException unused) {
                        str2 = "Unable to find RouterContentProvider. ";
                    } catch (Exception unused2) {
                        str2 = "Unexpected error occurred when deleting. ";
                    }
                }
            }
        }
        Log.e(TransparentActivity.TAG, str2);
        return 0;
    }

    public static Uri insert(Context context, Uri uri, ContentValues contentValues, Bundle bundle) {
        if (Build.VERSION.SDK_INT < 30) {
            Log.w(TransparentActivity.TAG, "Sdk version lower than R. Unable to invoke this insert. ");
            return null;
        }
        if (context == null) {
            Log.e(TransparentActivity.TAG, "Invalid context for inserting. ");
            return null;
        }
        if (uri == null) {
            Log.e(TransparentActivity.TAG, "Invalid uri for inserting. ");
            return null;
        }
        Uri uriA = c.a(uri);
        if (uriA == null) {
            Log.e(TransparentActivity.TAG, "Unable to build valid uri for inserting. ");
            return null;
        }
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            Log.e(TransparentActivity.TAG, "Unable to get valid ContentResolver. ");
            return null;
        }
        try {
            return contentResolver.insert(uriA, contentValues, bundle);
        } catch (IllegalArgumentException unused) {
            Log.e(TransparentActivity.TAG, "Unable to find RouterContentProvider. ");
            return null;
        } catch (Exception unused2) {
            Log.e(TransparentActivity.TAG, "Unexpected error occurred when inserting. ");
            return null;
        }
    }

    public static Cursor query(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return query(context, uri, strArr, str, strArr2, str2, null);
    }

    public static int startActivity(Context context, Intent intent) {
        return startActivity(context, intent, (Bundle) null);
    }

    public static int startActivityForResult(Activity activity, Intent intent, int i, Bundle bundle) {
        String str;
        if (activity == null) {
            str = "Invalid activity for startActivityForResult. ";
        } else if (intent == null) {
            str = "Invalid intent for startActivityForResult. ";
        } else {
            Intent intentA = c.a(intent);
            if (intentA != null) {
                intentA.putExtra("routeForResult", true);
                try {
                    activity.startActivityForResult(intentA, i, bundle);
                    return -1;
                } catch (ActivityNotFoundException unused) {
                    Log.e(TransparentActivity.TAG, "Unable to find RouterActivity. ");
                    return 1001;
                } catch (Exception unused2) {
                    Log.e(TransparentActivity.TAG, "Unexpected error occurred in startActivityForResult. ");
                    return 1002;
                }
            }
            str = "Unable to build valid intent for startActivityForResult. ";
        }
        Log.e(TransparentActivity.TAG, str);
        return 1000;
    }

    public static int update(Context context, Uri uri, ContentValues contentValues, String str, String[] strArr) {
        String str2;
        if (context == null) {
            str2 = "Invalid context for updating. ";
        } else if (uri == null) {
            str2 = "Invalid uri for updating. ";
        } else {
            Uri uriA = c.a(uri);
            if (uriA == null) {
                str2 = "Unable to build valid uri for updating. ";
            } else {
                ContentResolver contentResolver = context.getContentResolver();
                if (contentResolver == null) {
                    str2 = "Unable to get valid ContentResolver. ";
                } else {
                    try {
                        return contentResolver.update(uriA, contentValues, str, strArr);
                    } catch (IllegalArgumentException unused) {
                        str2 = "Unable to find RouterContentProvider. ";
                    } catch (Exception unused2) {
                        str2 = "Unexpected error occurred when updating. ";
                    }
                }
            }
        }
        Log.e(TransparentActivity.TAG, str2);
        return 0;
    }

    public static boolean bindService(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return bindService(context, intent, i, null, serviceConnection);
    }

    public static Cursor query(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        String str3;
        if (context == null) {
            str3 = "Invalid context for querying. ";
        } else if (uri == null) {
            str3 = "Invalid uri for querying. ";
        } else {
            Uri uriA = c.a(uri);
            if (uriA == null) {
                str3 = "Unable to build valid uri for querying. ";
            } else {
                ContentResolver contentResolver = context.getContentResolver();
                if (contentResolver == null) {
                    str3 = "Unable to get valid ContentResolver. ";
                } else {
                    try {
                        return contentResolver.query(uriA, strArr, str, strArr2, str2, cancellationSignal);
                    } catch (IllegalArgumentException unused) {
                        str3 = "Unable to find RouterContentProvider. ";
                    } catch (Exception unused2) {
                        str3 = "Unexpected error occurred when querying. ";
                    }
                }
            }
        }
        Log.e(TransparentActivity.TAG, str3);
        return null;
    }

    public static int startActivity(Context context, Intent intent, Bundle bundle) {
        String str;
        if (context == null) {
            str = "Invalid context for startActivity. ";
        } else if (intent == null) {
            str = "Invalid intent for startActivity. ";
        } else {
            Intent intentA = c.a(intent);
            if (intentA != null) {
                intentA.addFlags(268435456);
                try {
                    context.startActivity(intentA, bundle);
                    return -1;
                } catch (ActivityNotFoundException unused) {
                    Log.e(TransparentActivity.TAG, "Unable to find RouterActivity. ");
                    return 1001;
                } catch (Exception unused2) {
                    Log.e(TransparentActivity.TAG, "Unexpected error occurred in startActivity. ");
                    return 1002;
                }
            }
            str = "Unable to build valid intent for startActivity from Context. ";
        }
        Log.e(TransparentActivity.TAG, str);
        return 1000;
    }
}
