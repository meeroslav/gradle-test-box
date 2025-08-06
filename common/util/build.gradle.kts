/*
 * Utility module for common functionality
 */

plugins {
    id("buildlogic.java-library-conventions")
}

dependencies {
    // Use api instead of implementation to expose these dependencies to consuming modules
    api(project(":list"))
    api(project(":utilities"))
}