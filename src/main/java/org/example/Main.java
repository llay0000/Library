package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Book book;
        ListBook listBook = new ListBook();
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        do {
            Interface.menu();
            try {
                number = scanner.nextInt();
                switch (number) {
                    case 1:
                        scanner.nextLine();
                        System.out.println("Введите данные о книге: ");
                        System.out.println("Введите автора книги: ");
                        String author = scanner.nextLine();
                        System.out.println("Введите название книги: ");
                        String name = scanner.nextLine();
                        System.out.println("Введите издательство книги: ");
                        String publishingHouse = scanner.nextLine();
                        System.out.println("Введите год выпуска книги: ");
                        String year = scanner.nextLine();
                        System.out.println("Введите раздел библиотеки: ");
                        String librarySection = scanner.nextLine();
                        System.out.println("Введите происхождение книги: ");
                        String originOfTheBook = scanner.nextLine();
                        book = new Book(author,name,publishingHouse,year,librarySection,originOfTheBook);
                        listBook.ad(book.toString());
                        break;
                    case 2:
                        System.out.println("Список книг: ");
                        listBook.input();
                        break;
                    case 3:
                        listBook.search();
                        System.out.println("Введите данные для поиска книги:  ");
                        break;
                    case 4:
                        String remove = scanner.nextLine();
                        listBook.remove(remove);
                        System.out.println("Удалить книгу: ");
                        break;
                    case 5:
                        break;
                }
            } catch (Exception e) {
                System.out.println("Вы ввели не число\n" +
                        "Повторите ввод\n");
            }
            scanner.nextLine();
        } while (number != 5);
    }
}