package util

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import models.RoomModel
import java.nio.file.Files
import java.nio.file.Paths

class JsonReader {

    //представим, что это коннект к базе
    fun objectifyJson(roomName: String): List<RoomModel> {
        // Чтение содержимого файла JSON в строку
        val json = String(Files.readAllBytes(Paths.get("src/main/resources/$roomName")))
        // Парсинг строки JSON в объект Action
        return ObjectMapper()
            .registerKotlinModule()
            .registerModule(JavaTimeModule())
            .readValue(json, object : TypeReference<List<RoomModel>>() {})
    }
}

fun main() {
    val obj = JsonReader().objectifyJson("booking_roomList.json")
    println(obj[1].uniqueName)
}