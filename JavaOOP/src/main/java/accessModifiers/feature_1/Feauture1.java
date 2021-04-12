package accessModifiers.feature_1;

public class Feauture1 {

//    Вопрос: скомпилируется ли он? Иначе говоря – разрешен ли в методе testAccess доступ к private-методам и полям
//    другого экземпляра того же класса?
//    Да, разрешен. И к методам, и к полям. Класс скомпилируется.
//    Так что "моё и только моё", как я это формулировал выше, не ограничивает доступ экземпляром класса,
//    а распространяется и на другие экземпляры того же класса.
//    О чем знают не все.
//    Более того, это распространяется и на статические методы – т.е. если в статический метод класса A
//    передать экземпляр класса A, то внутри этого метода разрешен доступ ко всем private-членам переданного экземпляра.

    private int privateField = 0;

    private int getPrivateField() {
        return privateField;
    }

    public void testAccess(Feauture1 anotherObject) {
        anotherObject.privateField = 1;
        System.out.println("anotherObject.getPrivateField()=" + anotherObject.getPrivateField());
        System.out.println("anotherObject.privateField=" + anotherObject.privateField);
    }

}


