package plugin
import org.gradle.api.GradleException
import org.gradle.api.Project
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.dependencies
import java.io.Serializable

class ConstantsBuilder(val pkg: String, val className: String) : Serializable {
    var fields: Map<String, Any> = mapOf()
        private set

    fun field(name: String) = ConstantField(name)

    infix fun ConstantField.value(value: String) {
        fields += this.name to value
    }

    infix fun ConstantField.value(value: Int) {
        fields += this.name to value
    }
}

data class ConstantField (
    val name: String
)

open class GryphonExtension(private val project: Project) {
    lateinit var name: String
    lateinit var projectName: String
    var version: String = "1.0.0"
    var description: String = ""
    var mavenMods: List<String> = listOf()
    var fileMods: List<String> = listOf()

    val MC_DEFAULT = "1.14 Pre-Release 2"
    val YARN_DEFAULT = "+"
    val LOADER_DEFAULT = "0.4.1+build.123"
    fun fabric(minecraft: String = MC_DEFAULT, yarn: String = YARN_DEFAULT, loader: String = LOADER_DEFAULT) {
        project.dependencies {
            add("minecraft", create(group = "com.mojang", name = "minecraft", version = minecraft))
            add("mappings", create(group = "net.fabricmc", name = "yarn", version = "$minecraft+build.$yarn"))
            add("modCompile", create(group = "net.fabricmc", name = "fabric-loader", version = loader))
        }
    }
}