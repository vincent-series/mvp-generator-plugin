package com.test;

import com.intellij.ide.util.AbstractTreeClassChooserDialog;
import com.intellij.ide.util.TreeFileChooserFactory;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataKey;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.keymap.impl.ui.ChooseActionsDialog;
import com.intellij.openapi.ui.Messages;
import com.intellij.pom.Navigatable;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.search.GlobalSearchScope;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public class TestAction extends AnAction {
    @Override
    public void update(@NotNull AnActionEvent event) {
        super.update(event);
        Navigatable navigatable = event.getData(PlatformDataKeys.NAVIGATABLE);
        event.getPresentation().setVisible(navigatable instanceof PsiDirectory);
    }

    @Override
    public void actionPerformed(AnActionEvent event) {
        // TODO: insert action logic here
        new Thread() {
            @Override
            public void run() {
                super.run();
                PsiDirectory psiDirectory = (PsiDirectory) event.getData(PlatformDataKeys.NAVIGATABLE);
                File contractDir = new File(psiDirectory.getVirtualFile().getCanonicalPath(), "login/contract".replace(".", File.separator));
                contractDir.mkdirs();
                try {
                    FileWriter fileWriter = new FileWriter(new File(contractDir, "LoginContract.java"));
                    fileWriter.write("package " + contractDir.getCanonicalPath().split("java")[1].replaceFirst("\\\\", "").replaceAll("\\\\", ".") + ";");
                    fileWriter.write("\n");
                    fileWriter.write("public interface LoginContract {}");

                    fileWriter.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                File presenterDir = new File(psiDirectory.getVirtualFile().getCanonicalPath(), "login/presenter".replace(".", File.separator));
                presenterDir.mkdirs();
                File viewDir = new File(psiDirectory.getVirtualFile().getCanonicalPath(), "login/view".replace(".", File.separator));
                viewDir.mkdirs();
                File modelDir = new File(psiDirectory.getVirtualFile().getCanonicalPath(), "login/model".replace(".", File.separator));
                modelDir.mkdirs();


            }
        }.start();
        TreeFileChooserFactory.getInstance(event.getProject()).createFileChooser("name",null,null,null,false);

    }
}
