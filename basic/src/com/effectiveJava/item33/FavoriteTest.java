package com.effectiveJava.item33;

public class FavoriteTest {
    public static void main(String[] args) {
        Favorite f = new Favorite();

        f.putFavorite(String.class, "Mho");
        f.putFavorite(Integer.class, 0xcafebabe);
        f.putFavorite(Class.class, Favorite.class);

        String name = f.getFavorite(String.class);
        int number = f.getFavorite(Integer.class);
        Class<?> clazz = f.getFavorite(Class.class);

        System.out.printf("%s %x %s%n", name, number, clazz.getName());
    }
}
