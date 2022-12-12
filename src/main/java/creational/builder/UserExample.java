package creational.builder;

import creational.builder.example.User;

public class UserExample {
    public static void main(String[] args) {
        User user1 = new User.UserBuilder("Fagundes", "Vini")
                .age(35)
                .phone("1234567")
                .address("Fake address 1234")
                .build();
        System.out.println(user1);

        User user2 = new User.UserBuilder("Peixoto", "Vinicius")
                .age(40)
                .phone("5655")
                //no address
                .build();
        System.out.println(user2);

        User user3 = new User.UserBuilder("Super", "User")
                //No age
                //No phone
                //no address
                .build();
        System.out.println(user3);
    }
}