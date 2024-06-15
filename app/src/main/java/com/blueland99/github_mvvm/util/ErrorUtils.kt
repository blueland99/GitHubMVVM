package com.blueland99.github_mvvm.util

import com.google.gson.Gson
import com.google.gson.JsonObject
import retrofit2.Response

fun extractErrorMessage(response: Response<*>): String {
    return try {
        val errorBody = response.errorBody()?.string()
        if (!errorBody.isNullOrEmpty()) {
            val jsonObject = Gson().fromJson(errorBody, JsonObject::class.java)
            jsonObject["message"]?.asString ?: "Unknown error"
        } else {
            "Unknown error"
        }
    } catch (e: Exception) {
        "Unknown error"
    }
}
