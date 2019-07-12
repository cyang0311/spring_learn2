public class PeopleFactory {
    public static People getInstance(){
        System.out.println("实例people对象");
        return new People();
    }
}
