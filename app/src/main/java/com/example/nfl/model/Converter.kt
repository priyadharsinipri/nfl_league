package com.example.nfl.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.Serializable
import java.lang.reflect.Type


public class Converter : Serializable {

    @TypeConverter
    fun fromLogosValuesList(optionValues: List<Logos?>?): String? {
        if (optionValues == null) {
            return (null)
        }
        val gson = Gson()
        val type: Type = object : TypeToken<List<Logos?>?>() {
        }.getType()
        val json: String = gson.toJson(optionValues, type)
        return json
    }

    @TypeConverter // note this annotation
    fun toOptionValuesList(optionValuesString: String?): List<Logos>? {
        if (optionValuesString == null) {
            return (null)
        }
        val gson = Gson()
        val type = object : TypeToken<List<Logos?>?>() {
        }.type
        val productCategoriesList: List<Logos> =
            gson.fromJson<List<Logos>>(optionValuesString, type)
        return productCategoriesList
    }
}