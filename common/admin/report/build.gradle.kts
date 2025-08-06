/*
 * Report generation module for administrative tasks
 */

plugins {
    id("buildlogic.java-library-conventions")
}

dependencies {
    implementation(project(":utilities"))
    implementation(project(":common:admin"))
}