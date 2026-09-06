package com.afollestad.materialdialogs.folderselector;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.webkit.MimeTypeMap;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.commons.R;
import com.masget.base.AppConfig;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class FileChooserDialog extends DialogFragment implements MaterialDialog.ListCallback {
    private static final String DEFAULT_TAG = "[MD_FILE_SELECTOR]";
    private boolean canGoUp = true;
    private FileCallback mCallback;
    private File[] parentContents;
    private File parentFolder;

    public interface FileCallback {
        void onFileSelection(FileChooserDialog fileChooserDialog, File file);
    }

    CharSequence[] getContentsArray() {
        File[] fileArr = this.parentContents;
        int i = 0;
        if (fileArr == null) {
            return this.canGoUp ? new String[]{getBuilder().mGoUpLabel} : new String[0];
        }
        int length = fileArr.length;
        boolean z = this.canGoUp;
        String[] strArr = new String[length + (z ? 1 : 0)];
        if (z) {
            strArr[0] = getBuilder().mGoUpLabel;
        }
        while (true) {
            File[] fileArr2 = this.parentContents;
            if (i >= fileArr2.length) {
                return strArr;
            }
            strArr[this.canGoUp ? i + 1 : i] = fileArr2[i].getName();
            i++;
        }
    }

    File[] listFiles(String str, String[] strArr) {
        File[] fileArrListFiles = this.parentFolder.listFiles();
        ArrayList arrayList = new ArrayList();
        if (fileArrListFiles == null) {
            return null;
        }
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        for (File file : fileArrListFiles) {
            if (file.isDirectory()) {
                arrayList.add(file);
            } else if (strArr != null) {
                for (String str2 : strArr) {
                    if (file.getName().toLowerCase().contains(str2.toLowerCase())) {
                        arrayList.add(file);
                        break;
                    }
                }
            } else if (str != null && fileIsMimeType(file, str, singleton)) {
                arrayList.add(file);
            }
        }
        Collections.sort(arrayList, new FileSorter());
        return (File[]) arrayList.toArray(new File[arrayList.size()]);
    }

    boolean fileIsMimeType(File file, String str, MimeTypeMap mimeTypeMap) {
        int iLastIndexOf;
        if (str == null || str.equals("*/*")) {
            return true;
        }
        String string = file.toURI().toString();
        int iLastIndexOf2 = string.lastIndexOf(46);
        if (iLastIndexOf2 == -1) {
            return false;
        }
        String strSubstring = string.substring(iLastIndexOf2 + 1);
        if (strSubstring.endsWith(AppConfig.FORMAT)) {
            return str.startsWith("application/json");
        }
        String mimeTypeFromExtension = mimeTypeMap.getMimeTypeFromExtension(strSubstring);
        if (mimeTypeFromExtension == null) {
            return false;
        }
        if (mimeTypeFromExtension.equals(str)) {
            return true;
        }
        int iLastIndexOf3 = str.lastIndexOf(47);
        if (iLastIndexOf3 == -1) {
            return false;
        }
        return str.substring(iLastIndexOf3 + 1).equals("*") && (iLastIndexOf = mimeTypeFromExtension.lastIndexOf(47)) != -1 && mimeTypeFromExtension.substring(0, iLastIndexOf).equals(str.substring(0, iLastIndexOf3));
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(getActivity(), "android.permission.READ_EXTERNAL_STORAGE") != 0) {
            return new MaterialDialog.Builder(getActivity()).title(R.string.md_error_label).content(R.string.md_storage_perm_error).positiveText(android.R.string.ok).build();
        }
        if (getArguments() == null || !getArguments().containsKey("builder")) {
            throw new IllegalStateException("You must create a FileChooserDialog using the Builder.");
        }
        if (!getArguments().containsKey("current_path")) {
            getArguments().putString("current_path", getBuilder().mInitialPath);
        }
        this.parentFolder = new File(getArguments().getString("current_path"));
        this.parentContents = listFiles(getBuilder().mMimeType, getBuilder().mExtensions);
        return new MaterialDialog.Builder(getActivity()).title(this.parentFolder.getAbsolutePath()).items(getContentsArray()).itemsCallback(this).onNegative(new MaterialDialog.SingleButtonCallback() { // from class: com.afollestad.materialdialogs.folderselector.FileChooserDialog.1
            @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
            public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                materialDialog.dismiss();
            }
        }).autoDismiss(false).negativeText(getBuilder().mCancelButton).build();
    }

    @Override // com.afollestad.materialdialogs.MaterialDialog.ListCallback
    public void onSelection(MaterialDialog materialDialog, View view, int i, CharSequence charSequence) {
        boolean z = this.canGoUp;
        if (z && i == 0) {
            File parentFile = this.parentFolder.getParentFile();
            this.parentFolder = parentFile;
            if (parentFile.getAbsolutePath().equals("/storage/emulated")) {
                this.parentFolder = this.parentFolder.getParentFile();
            }
            this.canGoUp = this.parentFolder.getParent() != null;
        } else {
            File[] fileArr = this.parentContents;
            if (z) {
                i--;
            }
            File file = fileArr[i];
            this.parentFolder = file;
            this.canGoUp = true;
            if (file.getAbsolutePath().equals("/storage/emulated")) {
                this.parentFolder = Environment.getExternalStorageDirectory();
            }
        }
        if (this.parentFolder.isFile()) {
            this.mCallback.onFileSelection(this, this.parentFolder);
            dismiss();
            return;
        }
        this.parentContents = listFiles(getBuilder().mMimeType, getBuilder().mExtensions);
        MaterialDialog materialDialog2 = (MaterialDialog) getDialog();
        materialDialog2.setTitle(this.parentFolder.getAbsolutePath());
        getArguments().putString("current_path", this.parentFolder.getAbsolutePath());
        materialDialog2.setItems(getContentsArray());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mCallback = (FileCallback) activity;
    }

    public void show(FragmentActivity fragmentActivity) {
        String str = getBuilder().mTag;
        Fragment fragmentFindFragmentByTag = fragmentActivity.getSupportFragmentManager().findFragmentByTag(str);
        if (fragmentFindFragmentByTag != null) {
            ((DialogFragment) fragmentFindFragmentByTag).dismiss();
            fragmentActivity.getSupportFragmentManager().beginTransaction().remove(fragmentFindFragmentByTag).commit();
        }
        show(fragmentActivity.getSupportFragmentManager(), str);
    }

    public static class Builder implements Serializable {
        protected final transient AppCompatActivity mContext;
        protected String[] mExtensions;
        protected String mTag;
        protected int mCancelButton = android.R.string.cancel;
        protected String mInitialPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        protected String mMimeType = null;
        protected String mGoUpLabel = "...";

        public Builder cancelButton(int i) {
            this.mCancelButton = i;
            return this;
        }

        public Builder extensionsFilter(String... strArr) {
            this.mExtensions = strArr;
            return this;
        }

        public Builder goUpLabel(String str) {
            this.mGoUpLabel = str;
            return this;
        }

        public Builder mimeType(String str) {
            this.mMimeType = str;
            return this;
        }

        public Builder tag(String str) {
            if (str == null) {
                str = FileChooserDialog.DEFAULT_TAG;
            }
            this.mTag = str;
            return this;
        }

        public <ActivityType extends AppCompatActivity & FileCallback> Builder(ActivityType activitytype) {
            this.mContext = activitytype;
        }

        public Builder initialPath(String str) {
            if (str == null) {
                str = File.separator;
            }
            this.mInitialPath = str;
            return this;
        }

        public FileChooserDialog build() {
            FileChooserDialog fileChooserDialog = new FileChooserDialog();
            Bundle bundle = new Bundle();
            bundle.putSerializable("builder", this);
            fileChooserDialog.setArguments(bundle);
            return fileChooserDialog;
        }

        public FileChooserDialog show() {
            FileChooserDialog fileChooserDialogBuild = build();
            fileChooserDialogBuild.show(this.mContext);
            return fileChooserDialogBuild;
        }
    }

    public String getInitialPath() {
        return getBuilder().mInitialPath;
    }

    private Builder getBuilder() {
        return (Builder) getArguments().getSerializable("builder");
    }

    private static class FileSorter implements Comparator<File> {
        private FileSorter() {
        }

        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            if (file.isDirectory() && !file2.isDirectory()) {
                return -1;
            }
            if (file.isDirectory() || !file2.isDirectory()) {
                return file.getName().compareTo(file2.getName());
            }
            return 1;
        }
    }
}
