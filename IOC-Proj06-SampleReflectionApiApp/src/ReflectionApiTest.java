import java.lang.reflect.Constructor;

public class ReflectionApiTest {
	public static void main(String[] args) throws Exception {
		Class c=Class.forName(args[0]);
		Constructor cons[]=c.getDeclaredConstructors();
		cons[0].setAccessible(true);
		cons[2].setAccessible(true);
		Object obj=cons[0].newInstance();
		System.out.println(obj);
		/*Object obj1=cons[1].newInstance();
		System.out.println(obj1);*/		//Class ReflectionApiTest can not access a member of class Demo with modifiers "private"
		Object obj2=cons[2].newInstance(10,20);
		System.out.println(obj2);
	}
}
