package ua.com.javatraining;

public class TypeErasure implements Comparable<TypeErasure> {
    private final String value;

    public TypeErasure(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TypeErasure{" + "value='" + value + '\'' + '}';
    }

    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //compareTo(Object) in 'ua.com.javatraining.TypeErasure' clashes with compareTo(T) in 'java.lang.Comparable':
    // both methods have same erasure yet neither overrides the other
    /*public int compareTo(Object odj) {//
        return value.compareTo(((TypeErasure) odj).value);
    }*/
    //В Java два разных метода не могут иметь одну и ту же сигнатуру.
    // В процессе Type Erasure компилятор добавит bridge-метод public int compareTo(Object o).
    // Но в классе уже содержится метод с такой сигнатурой, что и вызовет ошибку во время компиляции.

    @Override
    public int compareTo(TypeErasure obj) {
        return value.compareTo(((TypeErasure) obj).value);
    }

}
