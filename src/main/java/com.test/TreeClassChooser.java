package com.test;

import com.intellij.ide.util.AbstractTreeClassChooserDialog;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.search.GlobalSearchScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.List;

public class TreeClassChooser extends AbstractTreeClassChooserDialog {
    public TreeClassChooser(@NlsContexts.DialogTitle String title, Project project, Class elementClass) {
        super(title, project, elementClass);
    }

    public TreeClassChooser(@NlsContexts.DialogTitle String title, Project project, Class elementClass, @Nullable PsiNamedElement initialClass) {
        super(title, project, elementClass, initialClass);
    }

    public TreeClassChooser(@NlsContexts.DialogTitle String title, @NotNull Project project, GlobalSearchScope scope, @NotNull Class elementClass, @Nullable Filter classFilter, @Nullable PsiNamedElement initialClass) {
        super(title, project, scope, elementClass, classFilter, initialClass);
    }

    public TreeClassChooser(@NlsContexts.DialogTitle String title, @NotNull Project project, GlobalSearchScope scope, @NotNull Class elementClass, @Nullable Filter classFilter, @Nullable PsiNamedElement baseClass, @Nullable PsiNamedElement initialClass, boolean isShowMembers, boolean isShowLibraryContents) {
        super(title, project, scope, elementClass, classFilter, baseClass, initialClass, isShowMembers, isShowLibraryContents);
    }

    @Override
    protected PsiNamedElement getSelectedFromTreeUserObject(DefaultMutableTreeNode node) {
        return null;
    }

    @Override
    protected @NotNull List getClassesByName(String name, boolean checkBoxState, String pattern, GlobalSearchScope searchScope) {
        return null;
    }

    @Override
    public void select(Object aClass) {

    }
}
