package com.jarvis.androidassistant.accessibility

import android.accessibilityservice.AccessibilityService
import android.util.Log
import android.view.accessibility.AccessibilityEvent

class JarvisAccessibilityService : AccessibilityService() {

    companion object{
        var instance: JarvisAccessibilityService? = null;
    }

    override fun onServiceConnected() {
        super.onServiceConnected()
        instance = this
        Log.d("JARVIS", "Accessibility Service Connected")
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
//        Not needed yet
    }

    override fun onInterrupt() {
        Log.d("JARVIS", "Accessibility Interrupted")
    }

    fun tap(x: Int, y:Int) {
        val path = android.graphics.Path()
        path.moveTo(x.toFloat(), y.toFloat())

        val gesture = android.accessibilityservice.GestureDescription.Builder()
            .addStroke(
                android.accessibilityservice.GestureDescription.StrokeDescription(
                    path,
                    0,
                    100
                )
            )
            .build()

        dispatchGesture(gesture, null, null)
    }

    fun clickByText(text: String) {
        val root = rootInActiveWindow ?: return

        val nodes = root.findAccessibilityNodeInfosByText(text)

        for (node in nodes) {
            node.performAction(android.view.accessibility.AccessibilityNodeInfo.ACTION_CLICK)
            return
        }
    }

//    fun typeText(text: String) {
//
//        val root = rootInActiveWindow ?: return
//
//        val editTexts = root.findAccessibilityNodeInfosByClassName("android.widget.EditText")
//
//        if (editTexts.isNotEmpty()) {
//
//            val bundle = android.os.Bundle()
//            bundle.putCharSequence(
//                android.view.accessibility.AccessibilityNodeInfo.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE,
//                text
//            )
//
//            editTexts[0].performAction(
//                android.view.accessibility.AccessibilityNodeInfo.ACTION_SET_TEXT,
//                bundle
//            )
//        }
//    }
}