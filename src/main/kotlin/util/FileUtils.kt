package util

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import java.io.File
import java.nio.file.Paths
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import com.fasterxml.jackson.module.kotlin.registerKotlinModule

class FileUtils {

    fun saveObjectAsJson(obj: Any, uniquePrefix: String) {
        // Создаем экземпляр ObjectMapper и регистрируем модуль для работы с java.time.* классами
        val objectMapper = ObjectMapper().registerModule(JavaTimeModule())
        // Регистрируем модуль Kotlin для работы с data class
        objectMapper.registerKotlinModule()
        // Формируем уникальное имя файла
        val fileName = "booking_$uniquePrefix.json"
        // Формируем полный путь к файлу
        val filePath = Paths.get("src/main/resources/", fileName).toString()
        // Проверяем, существует ли файл с таким же именем и путем
        val file = File(filePath)
        if (!file.exists()) {
            // Сериализуем объект в JSON и сохраняем в файл с pretty print
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, obj)
            println("JSON сохранен в: $filePath")
        } else throw IllegalStateException("По данному пути уже существует такой же файл")
    }

}