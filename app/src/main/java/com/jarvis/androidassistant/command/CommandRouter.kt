package com.jarvis.androidassistant.command

import android.accessibilityservice.AccessibilityService
import com.jarvis.androidassistant.accessibility.JarvisAccessibilityService

object CommandRouter {

    fun goHome() {
        JarvisAccessibilityService.instance?.performGlobalAction(
            AccessibilityService.GLOBAL_ACTION_HOME
        )
    }

    fun goBack() {
        JarvisAccessibilityService.instance?.performGlobalAction(
            AccessibilityService.GLOBAL_ACTION_BACK
        )
    }

    fun openRecents() {
        JarvisAccessibilityService.instance?.performGlobalAction(
            AccessibilityService.GLOBAL_ACTION_RECENTS
        )
    }

    fun tap(x: Int, y: Int) {
        JarvisAccessibilityService.instance?.tap(x, y)
    }

    fun clickText(text: String) {
        JarvisAccessibilityService.instance?.clickByText(text)
    }
}