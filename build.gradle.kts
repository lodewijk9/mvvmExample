// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    //dagger and hilt - plugin version 3.35
    alias(libs.plugins.dagger.hilt) apply  false
    alias(libs.plugins.kotlin.compose) apply false
}