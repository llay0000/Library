package org.example;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
   private String author;
   private String name;
   private String publishingHouse;
   private String year;
   private String librarySection;
   private String originOfTheBook;

   @Override
   public String toString() {
      return "Book{" +
              "author='" + author + '\'' +
              ", name='" + name + '\'' +
              ", publishingHouse='" + publishingHouse + '\'' +
              ", year='" + year + '\'' +
              ", librarySection='" + librarySection + '\'' +
              ", originOfTheBook='" + originOfTheBook + '\'' +
              '}';
   }
}
