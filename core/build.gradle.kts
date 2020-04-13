dependencies {
    api(project(":common"))
    api(project(":gui:gui-api"))
    api(project(":core:core-api"))

    asm()
    implementation(Library.procyon)
}