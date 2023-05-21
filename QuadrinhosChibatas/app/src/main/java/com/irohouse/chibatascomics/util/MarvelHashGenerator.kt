package com.irohouse.chibatascomics.util

import com.irohouse.chibatascomics.util.Constants.MarvelApi.PRIVATE_KEY
import com.irohouse.chibatascomics.util.Constants.MarvelApi.PUBLIC_KEY
import com.irohouse.chibatascomics.util.extension.md5

class MarvelHashGenerator {
    companion object{
        fun get(timestamp: String): String{
            val message = "$timestamp$PRIVATE_KEY$PUBLIC_KEY"
            return message.md5()
        }
    }
}