package ua.com.javatraining.genericswildcards;

import java.util.HashMap;
import java.util.Map;

public class TypesafeHeterogeneousContainerPattern {

    public static void main(String[] args) {

        Favorites favorites = new Favorites();
        favorites.putFavorite(String.class, "Java");
//        favorites.putFavorite(Integer.class, 33);
        favorites.putFavorite(Integer.class, 0xcafebabe);
        favorites.putFavorite(Class.class, ThreadLocal.class);

        String favoriteString = favorites.getFavorite(String.class);
        int favoriteInteger = favorites.getFavorite(Integer.class);
        Class<?> favoriteClass = favorites.getFavorite(Class.class);

//        System.out.println("printf(%s %x %s%n)", );
        System.out.printf("%s %n %s%n", favoriteString, favoriteInteger, favoriteClass);

    }

    static class Favorites {
        private Map<Class<?>, Object> favorites = new HashMap<Class<?>, Object>();

        public <T> void putFavorite(Class<T> type, T instance) {
            if (type == null) {
                throw new NullPointerException("type is null");
            }
            favorites.put(type, instance);
        }

        public <T> T getFavorite(Class<T> type) {
            return type.cast(favorites.get(type));
        }
    }

}
