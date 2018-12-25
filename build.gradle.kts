import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.10"
    id("org.spongepowered.plugin") version "0.8.1"
}

group = "com.m4kvn"
version = "1.0.0"

repositories {
    mavenCentral()
    jcenter()
}

val embed by configurations.creating {
    extendsFrom(configurations["implementation"])
}

dependencies {
    embed(kotlin("stdlib-jdk8"))
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.spongepowered:spongeapi:7.0.0")
    implementation("io.reactivex.rxjava2:rxkotlin:2.2.0")
    implementation("io.reactivex.rxjava2:rxjava:2.2.4")
    implementation("org.koin:koin-core:1.0.2")
}

val jar: Jar by tasks
jar.apply {
    from(configurations["embed"].map {
        if (it.isDirectory) it as Any else zipTree(it)
    })
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}