package com.fynd.nitrozen.components.notification.toast

data class NotificationAction(
    val actionText : String,
    val action : ()->Unit
)
