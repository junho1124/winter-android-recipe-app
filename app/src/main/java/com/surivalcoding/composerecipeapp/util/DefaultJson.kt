package com.surivalcoding.composerecipeapp.util

import kotlinx.serialization.json.Json

object DefaultJson {
    val json = Json {
        ignoreUnknownKeys = true
        encodeDefaults = true
        allowTrailingComma = true
    }
}