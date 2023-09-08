package org.tasks.week5.Java8.StreamsTask;

import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class StreamsExample {

        public static void main(final String[] args) {

                List<Author> authors = Library.getAuthors();

                banner("Authors information");
                Consumer<Author> printer = System.out::println;
                authors.stream()
                        .forEach(printer);

                authors.stream()
                        .forEach(System.out::println);

                banner("Active authors");

                Predicate<Author> activeFilter = author -> author.active;
                Consumer<Author> activePrinter = System.out::println;
                authors.stream().filter(activeFilter).forEach(activePrinter);

                authors.stream()
                        .filter(author -> author.active)
                        .forEach(System.out::println);

                banner("Active books for all authors");

                Consumer<Book> activeBookPrinter = System.out::println;
                Predicate<Book> activeBookFilter = book -> book.published;

                authors.stream()
                        .flatMap(author -> author.books.stream())
                        .filter(activeBookFilter)
                        .forEach(activeBookPrinter);

                authors.stream()
                        .flatMap(author -> author.books.stream()).filter(book -> book.published)
                        .forEach(System.out::println);

                banner("Average price for all books in the library");

                Consumer<Double> averagePricePrinter = System.out::println;
                Double averagePrice = authors.stream()
                        .flatMap(author -> author.books.stream())
                        .mapToDouble(book -> book.price)
                        .average().getAsDouble();
                averagePricePrinter.accept(averagePrice);

                System.out.println(
                        authors.stream()
                                .flatMap(author -> author.books.stream())
                                .mapToDouble(book -> book.price)
                                .average().getAsDouble());

                banner("Active authors that have at least one published book");

                Predicate<Author> activePublishedAuthorFilter = author -> author.active &&
                        author.books.stream().anyMatch(Book -> Book.published);

                Consumer<Author> activePublishedAuthorPrinter = System.out::println;
                authors.stream().filter(activePublishedAuthorFilter).forEach(activePublishedAuthorPrinter);

                authors.stream()
                        .filter(author -> author.active &&
                                author.books.stream().anyMatch(Book -> Book.published))
                        .forEach(System.out::println);
        }

        private static void banner(final String m) {
                System.out.println("#### " + m + " ####");
                int x = 5;
        }

}
