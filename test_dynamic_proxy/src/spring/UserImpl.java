package spring;

public class UserImpl implements Iuser {
    @Override
    public void eat(String s) {
        System.out.println("我要吃" + s );
    }
}
