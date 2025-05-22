import com.google.protobuf.gradle.generateProtoTasks
import com.google.protobuf.gradle.ofSourceSet
import com.google.protobuf.gradle.id
import com.google.protobuf.gradle.plugins
import com.google.protobuf.gradle.protobuf
import com.google.protobuf.gradle.protoc

plugins {
    id("idea")
    id("com.google.protobuf")
}

val errorProneAnnotations: String by project
val tomcatAnnotationsApi: String by project

dependencies {
    implementation("io.grpc:grpc-netty")
    implementation("io.grpc:grpc-protobuf")
    implementation("io.grpc:grpc-stub")
    implementation("com.google.protobuf:protobuf-java")
    implementation("com.google.errorprone:error_prone_annotations:$errorProneAnnotations")

    implementation("org.apache.tomcat:annotations-api:$tomcatAnnotationsApi")

    implementation("org.slf4j:slf4j-api:2.0.12")  // SLF4J API
    implementation("ch.qos.logback:logback-classic:1.5.3")  // Реализация Logback
    implementation("ch.qos.logback:logback-core:1.5.3")     // Ядро Logback
    implementation("org.codehaus.janino:janino:3.1.10")     // Для условных выражений в Logback
}

val protoSrcDir = "$projectDir/build/generated"

idea {
    module {
        sourceDirs = sourceDirs.plus(file(protoSrcDir))
    }
}

sourceSets {
    main {
        proto {
            srcDir(protoSrcDir)
        }
    }
}

protobuf {
    generatedFilesBaseDir = protoSrcDir

    protoc {
        artifact = "com.google.protobuf:protoc:3.19.4"
    }

    generateProtoTasks {
        ofSourceSet("main")
    }
}

afterEvaluate {
    tasks {
        getByName("generateProto").dependsOn(processResources)
    }
}

protobuf {
    generatedFilesBaseDir = protoSrcDir

    protoc {
        artifact = "com.google.protobuf:protoc:3.19.4"
    }
    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:1.56.1"
        }
    }

    generateProtoTasks {
        ofSourceSet("main").forEach {
            it.plugins {
                id("grpc")
            }
        }
    }
}

afterEvaluate {
    tasks {
        getByName("generateProto").dependsOn(processResources)
    }
}