dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Easy Notes"
include(":app")
include(":core")
include(":feature_note")
include(":feature_settings")
