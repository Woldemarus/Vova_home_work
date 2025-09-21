dependencies {
    implementation ("ch.qos.logback:logback-classic")
    
    // JUnit 5 BOM для управления версиями
    testImplementation(platform("org.junit:junit-bom:5.11.4"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}


