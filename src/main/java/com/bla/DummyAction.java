package com.bla;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.DataKey;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

/**
 * @author Eleftherios Chrysochoidis
 * Date: 10/11/2024
 */
public class DummyAction extends AnAction {

   @Override
   public void actionPerformed(@NotNull AnActionEvent event) {
      //TODO:
      Project project = event.getProject();
      Editor editor = event.getData(CommonDataKeys.EDITOR);
      if (editor == null) {
         Messages.showMessageDialog(project,
               "No editor found!",
               "Foscomm Bla bla", Messages.getErrorIcon());
         return;
      }
      String selectedText = editor.getSelectionModel().getSelectedText();
      if (StringUtils.isNotEmpty(selectedText)) {
         Messages.showMessageDialog(project,
               "Selected Text: " + selectedText,
               "Foscomm Bla bla", Messages.getInformationIcon());
      } else {
         Messages.showMessageDialog(project,
               "Nothing is selected: ",
               "Foscomm Bla bla", Messages.getWarningIcon());
      }
   }
}