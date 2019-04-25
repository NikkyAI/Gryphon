plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
    idea
}

repositories {
    jcenter()
    mavenCentral()
    maven(url="https://maven.fabricmc.net") {
        name = "Fabric"
    }
}

dependencies {
    compile( group = "net.fabricmc", name = "fabric-loom", version = "0.2.1-SNAPSHOT")
}

configure<GradlePluginDevelopmentExtension> {
    plugins {
        create("gryphon") {
            id = "gryphon"
            implementationClass = "plugin.GryphonPlugin"
        }
    }
}