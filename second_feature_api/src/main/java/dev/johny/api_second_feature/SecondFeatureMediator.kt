package dev.johny.api_second_feature

import android.content.Context
import android.content.Intent

interface SecondFeatureMediator {
    fun getSecondFeatureIntent(context: Context): Intent
}