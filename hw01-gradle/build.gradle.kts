import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id ("com.github.johnrengelman.shadow")
}

dependencies {
    implementation ("com.google.guava:guava:33.4.0-jre")
}

tasks {
    named<ShadowJar>("shadowJar") {
        archiveBaseName.set("FatJar")
        archiveVersion.set("0.1")
        archiveClassifier.set("")
        manifest {
            attributes(mapOf("Main-Class" to "org.example.HelloOtus"))
        }
    }

    build {
        dependsOn(shadowJar)
    }
}
