package util

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import pojo.BookingModel
import java.nio.file.Files
import java.nio.file.Paths

class JsonReader {

    fun objectifyJson(roomName: String): BookingModel {
        // Чтение содержимого файла JSON в строку
        val json = String(Files.readAllBytes(Paths.get("src/main/resources/$roomName")))
        // Парсинг строки JSON в объект Action
        return ObjectMapper()
            .registerKotlinModule()
            .registerModule(JavaTimeModule())
            .readValue(json, BookingModel::class.java)
    }

}