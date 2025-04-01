import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val archiveList = mutableMapOf<Int, Archive>()

    while (true) {
        println("Выберите номер Меню:")

        println("1 Выбрать архив")
        println("2 Создать архив")
        println("3 Выход")

        when (scanner.nextLine().toIntOrNull()) {
            1 -> chooseArchive(scanner, archiveList)
            2 -> createArchive(scanner, archiveList)
            3 -> {
                println("Программа закрыта.")
                return
            }
            else -> println("Некорректный ввод, попробуйте снова.")
        }
    }
}











