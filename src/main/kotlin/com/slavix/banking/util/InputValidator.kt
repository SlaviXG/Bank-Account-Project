package com.slavix.banking.util
import kotlin.Throwable

object InputValidator {
    fun validInteger(input: String): Boolean{
        try {
            input.toInt()
        }
        catch (e: Throwable){
            return false
        }
        return true
    }
}