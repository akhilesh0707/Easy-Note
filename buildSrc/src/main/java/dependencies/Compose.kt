package dependencies

object Compose {
    const val composeVersion = "1.0.3"

    const val compiler = "androidx.compose.compiler:compiler:$composeVersion"
    const val ui = "androidx.compose.ui:ui:$composeVersion"
    const val material = "androidx.compose.material:material:$composeVersion"
    const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:$composeVersion"
    const val materialIconExtended =
        "androidx.compose.material:material-icons-extended:$composeVersion"

    private const val activityComposeVersion = "1.3.1"
    const val activityCompose = "androidx.activity:activity-compose:$activityComposeVersion"

    private const val navigationComposeVersion = "2.4.0-alpha09"
    const val navigationCompose = "androidx.navigation:navigation-compose:$navigationComposeVersion"

    private const val viewModelComposeVersion = "2.4.0-beta01"
    const val viewModelCompose =
        "androidx.lifecycle:lifecycle-viewmodel-compose:$viewModelComposeVersion"

    private const val hiltNavigationComposeVersion = "1.0.0-alpha03"
    const val hiltNavigationCompose =
        "androidx.hilt:hilt-navigation-compose:$hiltNavigationComposeVersion"
}