﻿Java-программист уровня middle-senior

Требования:

- Хорошее знание Java (SE)
- Хорошее знание ООП
- Понимание принципов создания многопоточных приложений
- Английский язык на уровне чтения технической документации

Будет плюсом:

- Опыт работы с сокетами
- Опыт работы с JNI, JNA
- Опыт работы с PHP, MySQL, Git
- Базовые знания C/C++

Условия:

- Полностью удаленная работа
- Гибкий график работы
- Зарплата по результатам собеседования и выполнения тестового задания (от 2500$)
- Выполнение тестового задания

=====================================================

Задача и требования:

- Дано множество картинок
- Необходимо написать программу на Java, которая распознает, какие карты лежат на столе (только по центру картинки). Например, на этой картинке https://i.gyazo.com/65658f6ab114de07d5c08d5f81324dc7.png на столе лежат карты 4hQd7s
- Тестирование программы будет осуществляться на аналогичных картинках, которых нет в исходном множестве
- Допускаются ошибки в распознавании не более 3% от общего количества распознанных карт
- Нельзя использовать готовые библиотеки для распознавания текста. Необходимо написать свой алгоритм распознавания карт
- На распознавание одного файла не должно уходить более 1 секунды
- Исходный код решения задачи не должен быть длиннее 500 строк с нормальным форматированием

- Программу нужно предоставить в виде, готовом к запуску на Windows десктопе. Файл run.bat параметром принимает путь до папки с картинками. В консоль распечатывается результат в виде "имя файла - карты" для всех файлов папки
- Программу нужно предоставить с исходными файлами
- В исходных файлах должен быть ВЕСЬ код, который был использован для решения задачи


Рекомендации:

- У автора этой задачи решение заняло 100 строк кода. У лучшего на данный момент кандидата - 160 строк. Ничего страшного, если ваше решение занимает 500 строк. Однако, если больше и это - не комментарии, то стоит задуматься

Для решения задачи рекомендуется использовать следующие функции, встроенные в Java:

- BufferedImage img = ImageIO.read(f); - зачитка картинки из файла
- ImageIO.write(img, "png", f); - запись картинки в файл
- img.getWidth(); img.getHeight(); - рамеры картинки
- BufferedImage img1 = img.getSubimage(x, y, w, h); - взятие области в картинке
- img.getRGB(x, y); - взятие цвета точки по координате
- Color c = new Color(img.getRGB(x, y)); c.getRed(); c.getGreen(); c.getBlue(); c.equals(c1) - работа с цветом точки

Описание решения:
http://mir.arcpixel.ru/?p=839
