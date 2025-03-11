package dev.johny.api_empty_feature

import android.content.Context
import android.content.Intent

interface EmptyFeatureMediator {
    fun getEmptyFeatureIntent(context: Context): Intent
}