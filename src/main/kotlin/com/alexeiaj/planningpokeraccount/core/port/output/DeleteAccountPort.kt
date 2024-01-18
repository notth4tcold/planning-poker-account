package com.alexeiaj.planningpokeraccount.core.port.output

interface DeleteAccountPort {
    fun delete(id: Long)
}