 package com.fynd.nitrozen.utils.extensions

interface MultipleEventsCutter {
fun processEvent(event: () -> Unit)

    companion object
}
fun MultipleEventsCutter.Companion.get(): MultipleEventsCutter =
    MultipleEventsCutterImpl

private object MultipleEventsCutterImpl : MultipleEventsCutter {

    private var lastEventTimeMs: Long = 0

    @Synchronized
    override fun processEvent(event: () -> Unit) {
        val now = System.currentTimeMillis()
        if ( lastEventTimeMs  == 0L || now - lastEventTimeMs >= 300L) {
            event.invoke()
            lastEventTimeMs = now
        }
    }
}