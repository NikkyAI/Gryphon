package plugin

import net.fabricmc.loom.LoomGradleExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.BasePluginConvention
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByName
import org.gradle.kotlin.dsl.getPlugin
import org.gradle.kotlin.dsl.maven
import org.gradle.kotlin.dsl.repositories
import org.gradle.language.jvm.tasks.ProcessResources

open class GryphonPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val extension = with(project) {

            // apply required plugins

            pluginManager.apply("org.gradle.base")
            pluginManager.apply("org.gradle.java-library")
            pluginManager.apply("org.gradle.idea")
            pluginManager.apply("org.gradle.eclipse")
            pluginManager.apply("fabric-loom")

            dependencies {
                add("annotationProcessor", "net.fabricmc:fabric-loom:0.2.1-SNAPSHOT")
            }

            extensions.configure<JavaPluginExtension> {
                sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
            }

            repositories {
                mavenCentral()
                maven(url = "http://server.bbkr.space:8081/artifactory/libs-snapshot")
                maven(url = "https://minecraft.curseforge.com/api/maven") {
                    name = "curseforge"
                }
                flatDir { dirs("libs") }
            }


            // configure configurations
            configurations.getByName("modCompile").extendsFrom(configurations.getByName("include"))

            extensions.create("gryphon", GryphonExtension::class.java, this)
        }

        project.afterEvaluate {
            version = extension.version

            convention.getPlugin<BasePluginConvention>().apply {
                archivesBaseName = extension.projectName
            }
            extensions.configure<LoomGradleExtension> {
                refmapName = "mixins.gryphon.refmap.json"
            }

            tasks.getByName<ProcessResources>("processResources") {
                filesMatching("fabric.mod.json") {
                    expand(
                        mutableMapOf(
                            "name" to extension.name,
                            "version" to project.version,
                            "description" to extension.description
                        // TODO: add custom properties here
                        )
                    )
                }
            }
        }
    }
}

