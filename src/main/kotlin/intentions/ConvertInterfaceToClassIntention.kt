package intentions

import com.intellij.openapi.editor.Editor
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiKeyword
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.PsiUtil
import org.jetbrains.kotlin.idea.intentions.SelfTargetingRangeIntention
import org.jetbrains.kotlin.idea.util.liftToExpected
import org.jetbrains.kotlin.lexer.KtModifierKeywordToken
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.KtClass
import org.jetbrains.kotlin.psi.psiUtil.endOffset
import org.jetbrains.kotlin.psi.psiUtil.startOffset

class ConvertInterfaceToClassIntention : SelfTargetingRangeIntention<KtClass>(
    KtClass::class.java,
    "Convert to 'class'",
    "Convert Interface to abstract class"
) {

    override fun applicabilityRange(element: KtClass): TextRange? {
        if (!element.isInterface()) return null
        return TextRange(element.startOffset, element.body?.lBrace?.startOffset ?: element.endOffset)
    }

    override fun applyTo(element: KtClass, editor: Editor?) {
        val liftToExpected = element.liftToExpected()
        val interfaceElement = element.node.findChildByType(KtTokens.INTERFACE_KEYWORD)?.psi ?: return
        val psiKeyword = interfaceElement.originalElement as? PsiKeyword
        element.addModifier(KtTokens.ABSTRACT_KEYWORD)
        println(psiKeyword)
    }
}

abstract interface ISample {
    fun what()
    fun why()
}
