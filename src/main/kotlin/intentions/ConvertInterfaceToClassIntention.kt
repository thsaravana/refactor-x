package intentions

import com.intellij.codeInsight.intention.BaseElementAtCaretIntentionAction
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement

class ConvertInterfaceToClassIntention : BaseElementAtCaretIntentionAction() {

    override fun getText() = "Convert to 'abstract class'"

    override fun getFamilyName() = "Convert Interface to abstract class"

    override fun isAvailable(project: Project, editor: Editor?, element: PsiElement): Boolean {
        return true
    }

    override fun invoke(project: Project, editor: Editor?, element: PsiElement) {

    }
}