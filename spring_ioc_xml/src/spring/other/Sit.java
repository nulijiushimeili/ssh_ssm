package spring.other;

public class Sit {
    private Sit(){}

    private static Sit sit;

    public static Sit getInstance(){
        if(sit == null){
            sit = new Sit();
        }
        return sit;
    }

    public void sit(String name){
        System.out.println(name + "坐在椅子上");
    }
}
