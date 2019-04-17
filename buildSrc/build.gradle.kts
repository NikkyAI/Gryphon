plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
    idea
}

repositories {
    jcenter()
    mavenCentral()
    maven(url="http://maven.modmuss50.me/") {
        name = "Fabric"
    }
}

dependencies {
    compile( group = "net.fabricmc", name = "fabric-loom", version = "0.2.1-SNAPSHOT")
//    compile(group = "com.squareup", name = "kotlinpoet", version = "1.0.0-RC1")
}

configure<GradlePluginDevelopmentExtension> {
    plugins {
        create("gryphon") {
            id = "gryphon"
            implementationClass = "plugin.GryphonPlugin"
        }
    }
}