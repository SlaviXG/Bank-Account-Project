package com.slavix.banking.util

import java.util.*

object Console {
    private val scanner = Scanner(System.`in`)

    fun readLine(): String {
        return scanner.nextLine()
    }

    fun print(message: Any?){
        kotlin.io.print(message)
    }

    fun println(message: Any?){
        kotlin.io.println(message)
    }
}