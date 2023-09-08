package org.tasks.week5.Java8.LamdaTask;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class LambdaExample {

    public static void main(final String[] args) {

        final UsersRepository repository = new UsersRepository();

        banner("Listing all users");
        repository.select(null, null);

        banner("Listing users with age > 5 sorted by name");

        repository.select(user -> user.age > 5, (user1, user2) -> user1.name.compareTo(user2.name));

        repository.select(new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.age > 5;
            }
        }, new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                return user1.name.compareTo(user2.name);
            }
        });

        banner("Listing users with age < 10 sorted by age");

        repository.select(user -> user.age < 10, Comparator.comparingInt(user -> user.age));

        repository.select(new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.age < 10;
            }
        }, new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                return user1.age - user2.age;
            }
        });

        banner("Listing active users sorted by name");

        repository.select(user -> user.active, (user1, user2) -> user1.name.compareTo(user2.name));

        repository.select(new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.active;
            }
        }, new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                return user1.name.compareTo(user2.name);
            }
        });

        banner("Listing active users with age > 8 sorted by name");

        repository.select(user -> user.active && user.age > 8, (user1, user2) -> user1.name.compareTo(user2.name));

        repository.select(new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.active && user.age > 8;
            }
        }, new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                return user1.name.compareTo(user2.name);
            }
        });
    }

    private static void banner(final String m) {
        System.out.println("#### " + m + " ####");
    }

}
