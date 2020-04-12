plugins {
    id("org.openjfx.javafxplugin") version "0.0.8"
}

javafx {
    version = "11"
    modules = listOf("javafx.base", "javafx.controls", "javafx.fxml")
}

dependencies {
    api(project(":common"))
    api(project(":gui:gui-api"))
    api(project(":core:core-api"))

    implementation(Library.tornadofx)
}