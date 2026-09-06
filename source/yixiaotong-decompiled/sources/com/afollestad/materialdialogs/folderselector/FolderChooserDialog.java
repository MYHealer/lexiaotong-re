package com.afollestad.materialdialogs.folderselector;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.commons.R;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class FolderChooserDialog extends DialogFragment implements MaterialDialog.ListCallback {
    private static final String DEFAULT_TAG = "[MD_FOLDER_SELECTOR]";
    private boolean canGoUp = true;
    private FolderCallback mCallback;
    private File[] parentContents;
    private File parentFolder;

    public interface FolderCallback {
        void onFolderSelection(FolderChooserDialog folderChooserDialog, File file);
    }

    String[] getContentsArray() {
        File[] fileArr = this.parentContents;
        int i = 0;
        if (fileArr == null) {
            return this.canGoUp ? new String[]{getBuilder().mGoUpLabel} : new String[0];
        }
        int length = fileArr.length;
        boolean z = this.canGoUp;
        String[] strArr = new String[length + (z ? 1 : 0)];
        if (z) {
            strArr[0] = "...";
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

    File[] listFiles() {
        File[] fileArrListFiles = this.parentFolder.listFiles();
        ArrayList arrayList = new ArrayList();
        if (fileArrListFiles == null) {
            return null;
        }
        for (File file : fileArrListFiles) {
            if (file.isDirectory()) {
                arrayList.add(file);
            }
        }
        Collections.sort(arrayList, new FolderSorter());
        return (File[]) arrayList.toArray(new File[arrayList.size()]);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(getActivity(), "android.permission.READ_EXTERNAL_STORAGE") != 0) {
            return new MaterialDialog.Builder(getActivity()).title(R.string.md_error_label).content(R.string.md_storage_perm_error).positiveText(android.R.string.ok).build();
        }
        if (getArguments() == null || !getArguments().containsKey("builder")) {
            throw new IllegalStateException("You must create a FolderChooserDialog using the Builder.");
        }
        if (!getArguments().containsKey("current_path")) {
            getArguments().putString("current_path", getBuilder().mInitialPath);
        }
        this.parentFolder = new File(getArguments().getString("current_path"));
        this.parentContents = listFiles();
        MaterialDialog.Builder builderNegativeText = new MaterialDialog.Builder(getActivity()).title(this.parentFolder.getAbsolutePath()).items(getContentsArray()).itemsCallback(this).onPositive(new MaterialDialog.SingleButtonCallback() { // from class: com.afollestad.materialdialogs.folderselector.FolderChooserDialog.2
            @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
            public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                materialDialog.dismiss();
                FolderCallback folderCallback = FolderChooserDialog.this.mCallback;
                FolderChooserDialog folderChooserDialog = FolderChooserDialog.this;
                folderCallback.onFolderSelection(folderChooserDialog, folderChooserDialog.parentFolder);
            }
        }).onNegative(new MaterialDialog.SingleButtonCallback() { // from class: com.afollestad.materialdialogs.folderselector.FolderChooserDialog.1
            @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
            public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                materialDialog.dismiss();
            }
        }).autoDismiss(false).positiveText(getBuilder().mChooseButton).negativeText(getBuilder().mCancelButton);
        if (getBuilder().mAllowNewFolder) {
            builderNegativeText.neutralText(getBuilder().mNewFolderButton);
            builderNegativeText.onNeutral(new MaterialDialog.SingleButtonCallback() { // from class: com.afollestad.materialdialogs.folderselector.FolderChooserDialog.3
                @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
                public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                    FolderChooserDialog.this.createNewFolder();
                }
            });
        }
        return builderNegativeText.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createNewFolder() {
        new MaterialDialog.Builder(getActivity()).title(getBuilder().mNewFolderButton).input(0, 0, false, new MaterialDialog.InputCallback() { // from class: com.afollestad.materialdialogs.folderselector.FolderChooserDialog.4
            @Override // com.afollestad.materialdialogs.MaterialDialog.InputCallback
            public void onInput(MaterialDialog materialDialog, CharSequence charSequence) {
                File file = new File(FolderChooserDialog.this.parentFolder, charSequence.toString());
                if (file.mkdir()) {
                    FolderChooserDialog.this.reload();
                } else {
                    Toast.makeText(FolderChooserDialog.this.getActivity(), "Unable to create folder " + file.getAbsolutePath() + ", make sure you have the WRITE_EXTERNAL_STORAGE permission.", 0).show();
                }
            }
        }).show();
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
        reload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reload() {
        this.parentContents = listFiles();
        MaterialDialog materialDialog = (MaterialDialog) getDialog();
        materialDialog.setTitle(this.parentFolder.getAbsolutePath());
        getArguments().putString("current_path", this.parentFolder.getAbsolutePath());
        materialDialog.setItems(getContentsArray());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mCallback = (FolderCallback) activity;
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
        protected boolean mAllowNewFolder;
        protected final transient AppCompatActivity mContext;
        protected int mNewFolderButton;
        protected String mTag;
        protected int mChooseButton = R.string.md_choose_label;
        protected int mCancelButton = android.R.string.cancel;
        protected String mGoUpLabel = "...";
        protected String mInitialPath = Environment.getExternalStorageDirectory().getAbsolutePath();

        public Builder cancelButton(int i) {
            this.mCancelButton = i;
            return this;
        }

        public Builder chooseButton(int i) {
            this.mChooseButton = i;
            return this;
        }

        public Builder goUpLabel(String str) {
            this.mGoUpLabel = str;
            return this;
        }

        public Builder tag(String str) {
            if (str == null) {
                str = FolderChooserDialog.DEFAULT_TAG;
            }
            this.mTag = str;
            return this;
        }

        public <ActivityType extends AppCompatActivity & FolderCallback> Builder(ActivityType activitytype) {
            this.mContext = activitytype;
        }

        public Builder allowNewFolder(boolean z, int i) {
            this.mAllowNewFolder = z;
            if (i == 0) {
                i = R.string.new_folder;
            }
            this.mNewFolderButton = i;
            return this;
        }

        public Builder initialPath(String str) {
            if (str == null) {
                str = File.separator;
            }
            this.mInitialPath = str;
            return this;
        }

        public FolderChooserDialog build() {
            FolderChooserDialog folderChooserDialog = new FolderChooserDialog();
            Bundle bundle = new Bundle();
            bundle.putSerializable("builder", this);
            folderChooserDialog.setArguments(bundle);
            return folderChooserDialog;
        }

        public FolderChooserDialog show() {
            FolderChooserDialog folderChooserDialogBuild = build();
            folderChooserDialogBuild.show(this.mContext);
            return folderChooserDialogBuild;
        }
    }

    private Builder getBuilder() {
        return (Builder) getArguments().getSerializable("builder");
    }

    private static class FolderSorter implements Comparator<File> {
        private FolderSorter() {
        }

        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            return file.getName().compareTo(file2.getName());
        }
    }
}
