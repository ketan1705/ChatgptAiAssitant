package com.ken.chatgptaiassitant.navigation

import android.os.Build
import android.os.Bundle
import androidx.navigation.NavType
import com.ken.chatgptaiassitant.components.onboard.OnboardingItem
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

sealed class Routes() {
    @Serializable
    object Splash : Routes()

    @Serializable
    data class OnBoarding(val onboardingItems: List<OnboardingItem>) : Routes()

    @Serializable
    object Home : Routes()

    @Serializable
    object ChatScreen : Routes()
}

val onBoardingType = object : NavType<List<OnboardingItem>>(false) {
    override fun get(
        bundle: Bundle,
        key: String,
    ): List<OnboardingItem>? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            bundle.getParcelableArray(key, OnboardingItem::class.java)?.toList()
        } else {
            bundle.getParcelableArray(key)?.toList() as? List<OnboardingItem>
        }
    }

    override fun parseValue(value: String): List<OnboardingItem> {
        return Json.decodeFromString(value)
    }

    override fun put(
        bundle: Bundle,
        key: String,
        value: List<OnboardingItem>,
    ) {
        bundle.putParcelableArray(key, value.toTypedArray())
    }

    override fun serializeAsValue(value: List<OnboardingItem>): String {
        return Json.encodeToString(value)
    }
}