/*
 * Utility module for common functionality
 */

plugins {
    id("buildlogic.java-library-conventions")
}

dependencies {
    implementation(project(":list"))
    implementation(project(":utilities"))
}