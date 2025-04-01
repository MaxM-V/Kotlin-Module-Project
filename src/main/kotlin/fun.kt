import java.util.Scanner

fun viewNotes(scanner: Scanner, archive: Archive) {
    if (archive.notes.isEmpty()) {
        println("Архиве пустой.")
        return
    }

    println("Заметки:")
    println("Выберите номер меню")
    archive.notes.forEach {
        (key, note) -> println("$key. ${note.title}")
    }
    println("${archive.notes.size}. Назад")

    val choice = scanner.nextLine().toIntOrNull()
    if (choice == archive.notes.size)
    {
        return
    }
    if (choice !in archive.notes.keys) {
        println("Некорректный выбор, введите заново.")
        return
    }

    println("Заметка: ${archive.notes[choice]?.title}")
    println("Содержание: ${archive.notes[choice]?.content}")
}


fun createNote(scanner: Scanner, archive: Archive) {
    println("Укажите название заметки:")
    val title = scanner.nextLine().trim()
    if (title.isEmpty()) {
        println("Название не может быть пустым.")
        return
    }

    println("Введите содержание заметки:")
    val content = scanner.nextLine().trim()
    if (content.isEmpty()) {
        println("Содержание не может быть пустым.")
        return
    }

    archive.notes[archive.notes.size] = Note(title, content)
    println("Заметка \"$title\" добавлена.")
}


fun chooseNote(scanner: Scanner, archive: Archive) {
    while (true) {
        println("Архив: ${archive.name}")
        println("Выберите номер пункта меню")
        println("1 Добавить заметку")
        println("2 Открыть заметку")
        println("3 Назад")

        when (scanner.nextLine().toIntOrNull()) {
            1 -> createNote(scanner, archive)
            2 -> viewNotes(scanner, archive)
            3 -> return
            else -> println("Некорректный ввод, попробуйте снова.")
        }
    }
}

fun createArchive(scanner: Scanner, archiveList: MutableMap<Int, Archive>) {
    println("Введите название архива:")
    val name = scanner.nextLine().trim()
    if (name.isEmpty()) {
        println("Название архива не может быть пустым.")
        return
    }
    archiveList[archiveList.size] = Archive(name)
    println("Архив \"$name\" создан.")
}


fun chooseArchive(scanner: Scanner, archiveList: MutableMap<Int, Archive>) {
    if (archiveList.isEmpty()) {
        println("Архив пуст. Сначала создайте архив.")
        return
    }

    println("Выберите номер архивова:")
    archiveList.forEach { (key, archive) -> println("$key. ${archive.name}") }
    println("${archiveList.size}. Назад")

    val choice = scanner.nextLine().toIntOrNull()
    if (choice == archiveList.size)
    {
        return
    }
    if (choice !in archiveList.keys) {
        println("Некорректный выбор, попробуйте снова.")
        return
    }

    chooseNote(scanner, archiveList[choice]!!)
}
