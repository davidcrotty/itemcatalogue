package net.davidcrotty.itemcatalogue.helpers

import okreplay.Request
import java.lang.NullPointerException

class RequestRecorder {

    private var request: Request? = null

    fun record(request: Request)  {
        this.request = request
    }

    fun replay(): Request {
        return request ?: throw NullPointerException("Request was not recorded, have you recorded your response?")
    }
}