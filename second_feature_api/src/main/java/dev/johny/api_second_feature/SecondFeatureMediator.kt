package dev.johny.api_second_feature

import android.content.Context
import android.content.Intent

interface SecondFeatureMediator {
    fun getIntent(context: Context): Intent
}