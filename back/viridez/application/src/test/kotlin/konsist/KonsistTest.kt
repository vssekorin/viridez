package konsist

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.annotations
import com.lemonappdev.konsist.api.ext.list.classes
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldHaveSize
import org.junit.jupiter.api.Test

class KonsistTest {

    @Test
    fun `application module does not contain logic`() {
        val sourceFiles = Konsist
            .scopeFromModule("application")
            .files
            .filterNot { it.hasNameEndingWith("Test") }

        with (sourceFiles) {
            shouldHaveSize(1)
            classes() shouldHaveSize 1
            classes().annotations.map { it.name } shouldContain "SpringBootApplication"
        }
    }
}
