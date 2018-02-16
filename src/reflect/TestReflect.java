package reflect;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestReflect {

	private Person person = new Person();

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * test get someone class package name
	 * <p>
	 * use Class.getClass().getName();
	 * <p>
	 * all classes is Class instance
	 **/
	@Test
	public void testGetClassPackageName() {
		System.out.println(person.getClass().getName());
		System.out.println(Class.class.getName());
	}

	/**
	 * test instance class
	 **/
	@Test
	public void testInstanceClass() throws Exception {
		Class<?> person2 = null;
		Class<?> person3 = null;
		Class<?> person4 = null;
		person2 = Class.forName("reflect.Person");
		person3 = new Person().getClass();
		person4 = Person.class;
		System.out.println(person2.getName());
		System.out.println(person3.getName());
		System.out.println(person4.getName());
	}

	/**
	 * accroding by reflect instance class by default constructor
	 * <p>
	 * use Class newInstance() method and use Class forName(String className) to
	 * find class
	 * <p>
	 **/
	@Test
	public void testInstanceClassByDefaultConstructor() throws Exception {
		Class<?> clazz = Class.forName("reflect.Person");
		Person person1 = (Person) clazz.newInstance();// accroding by default
														// constructor
		person1.setAge(10);
		person1.setName("li");
		System.out.println(person1);
	}

	/**
	 * test invoke other Class constructors
	 * <p>
	 * no argument constructor
	 * <p>
	 * has arguments constructors
	 * <p>
	 * use Class.getDeclaredConstructors() to get Class itself constructors,
	 * contains Class itself all constructos.But Class.getConstructors() to get
	 * Class itself constructors with public
	 * <p>
	 * use Constructor<?>.newInstance(...)
	 **/
	@Test
	public void testInvokeOtherClassDeclaredConstructors() throws Exception {
		Class<?> clazz = Class.forName(Person.class.getName());
		Person person = null;// invoke no argument constrcutor
		Person person2 = null;// invoke has argument constructor
		// get other class itself constrcutors
		Constructor<?>[] constructors = clazz.getDeclaredConstructors();
		int length = constructors.length;// get Person Class constrcutor size
		System.out.println(length);
		for (int i = 0; i < length; i++) {
			System.out.println(constructors[i]);
		}
		person = (Person) constructors[0].newInstance();
		person2 = (Person) constructors[1].newInstance("Jetty", 20);
		System.out.println(person + "\n" + person2);
	}

	/**
	 * test invoke other class constructors;
	 * <p>
	 * test Class.getDeclaredConstructors() and Class.getConstructors()
	 * <p>
	 **/
	@Test
	public void testInvokeOtherClassConstructors() throws Exception {
		Class<?> clazz = Class.forName(Student.class.getName());
		Student student = null;
		Student student2 = null;
		Student student3 = null;
		Constructor<?>[] constructors = clazz.getConstructors();
		int length = constructors.length;
		System.out.println(length);
		for (int i = 0; i < length; i++) {
			System.out.println(constructors[i]);
		}
		student = (Student) constructors[2].newInstance();
		student2 = (Student) constructors[1].newInstance("Jetty", 20);
		student3 = (Student) constructors[0].newInstance("1530200053", "Jetty", 21);
		System.out.println(student);
		System.out.println(student2);
		System.out.println(student3);
		constructors = clazz.getDeclaredConstructors();
		int length1 = constructors.length;
		System.out.println(length1);
		for (int i = 0; i < length1; i++) {
			System.out.println(constructors[i]);
		}
	}

	/**
	 * test get class implements interfaces
	 **/
	@Test
	public void testGetClassImplementsInterfaces() throws Exception {
		Class<?> clazz = Class.forName(MyArrayList.class.getName());
		Class<?>[] interfaces = clazz.getInterfaces();
		int length = interfaces.length;
		System.out.println(length);
		for (int i = 0; i < length; i++) {
			System.out.println(interfaces[i].getName());
		}
	}

	/**
	 * get other class super class
	 **/
	@Test
	public void testGetOtherClassSuperClass() throws Exception {
		Class<?> clazz = Class.forName(Student.class.getName());
		Class<?> superClass = clazz.getSuperclass();
		System.out.print(superClass.getName());
	}

	/**
	 * get other class constructors modifiers
	 **/
	@Test
	public void testGetOtherClassConstructorsModifiers() throws Exception {
		Class<?> clazz = Class.forName(Person.class.getName());
		// get other class itself constrcutors
		Constructor<?>[] constructors = clazz.getDeclaredConstructors();
		int length = constructors.length;// get Person Class constrcutor size
		System.out.println(length);
		// get other class constructors modifiers
		for (int i = 0; i < length; i++) {
			int modifier = constructors[i].getModifiers();
			Class<?>[] argsClass = constructors[i].getParameterTypes();
			System.out.println(Modifier.toString(modifier));
			System.out.println("Constructor[" + i + "]:" + constructors[i]);
			for (int j = 0; j < argsClass.length; j++) {
				System.out.println("Constructor[" + i + "]:" + "args[" + j + "]:" + argsClass[j]);
			}
		}
	}

	/**
	 * test get class methods
	 * <p>
	 * Class.getDeclaredMethods() can get Class itself all methods;But
	 * Class.getMethods can get Class itself public methods
	 **/
	@Test
	public void testGetClassMethods() throws Exception {
		Class<?> clazz = Class.forName(Person.class.getName());
		Method[] methods = clazz.getDeclaredMethods();
		int length = methods.length;
		System.out.println(length);
		for (int i = 0; i < length; i++) {
			System.out.println(methods[i] + ":" + methods[i].getParameterCount());
		}
	}
	
	
	

	/**
	 * test get other class all properties
	 **/
	@Test
	public void testGetOtherClassAllProperties() throws Exception {
		Class<?> clazz = Class.forName(Student.class.getName());
		Field[] fields = clazz.getFields();
		System.out.println("声明为public属性,包含在父类中定义的:");
		for (int i = 0; i < fields.length; i++) {
			System.out.println(fields[i]);
		}
		System.out.println("类定义的所有属性,不包含父类: ");
		Field[] fields2 = clazz.getDeclaredFields();
		for (int i = 0; i < fields2.length; i++) {
			System.out.println(fields2[i]);
		}
	}

	/**
	 * test invoke other method
	 **/
	@Test
	public void testInvokeOtherMethod() throws Exception {
		Class<?> clazz = Class.forName(Person.class.getName());
		Person person = (Person) clazz.newInstance();
		Method method = clazz.getMethod("setName", String.class);
		method.invoke(person, "Jetty");
		System.out.println(person);
	}

	/**
	 * test invoke other class getter and setter methods
	 **/
	@Test
	public void testInvokeOtherClassGetterAndSetter() throws Exception {
		Class<?> clazz = Class.forName(Person.class.getName());
		Person person = (Person) clazz.newInstance();
		setter(person, "Name", "jetty", String.class);
		getter(person, "Name");
	}

	private static void getter(Object object, String attr) throws Exception {
		Method method = object.getClass().getMethod("get" + attr);
		System.out.println("method name:" + method.getName() + "-->" + method.invoke(object));
	}

	private static void setter(Object object, String attr, Object value, Class<?> parameterType) throws Exception {
		Method method = object.getClass().getMethod("set" + attr, parameterType);
		method.invoke(object, value);
	}

	/**
	 * test operate other class perperties
	 * <p>
	 * Field field=clazz.getDeclaredField("name");
	 * <p>
	 * field.setAccessible(true);
	 * <p>
	 * field.set(person, "jetty");
	 **/
	@Test
	public void testOperateOtherClassProperties() throws Exception {
		Class<?> clazz = Class.forName(Person.class.getName());
		Person person = (Person) clazz.newInstance();
		Field field = clazz.getDeclaredField("name");
		field.setAccessible(true);
		field.set(person, "jetty");
		System.out.print(person);
	}

	/**
	 * test operate array information
	 **/
	@Test
	public void testOperateArrayInformation() {
		int[] temp = { 1, 2, 3, 4, 5 };
		// the Class representing the component type of this class if this class
		// is an array
		Class<?> clazz = temp.getClass().getComponentType();// get array
															// information
		System.out.println("数组类型:" + clazz.getName());
		System.out.println("数组长度" + Array.getLength(temp));
		System.out.println("数组第一个元素: " + Array.get(temp, 0));
		Array.set(temp, 0, 100);// 修改元素
		System.out.println("修改之后数组的第一个元素: " + Array.get(temp, 0));
		System.out.println(Arrays.toString(temp));
	}

	/**
	 * test operate array length
	 **/
	@Test
	public void testOperateArrayLength() {
		int[] temp = { 1, 2, 3, 4, 5 };
		int[] newTemp = (int[]) getNewArrayInstance(temp, 10);
		System.out.println(Arrays.toString(newTemp));
	}

	private static Object getNewArrayInstance(Object array, int length) {
		Class<?> clazz = array.getClass().getComponentType();
		Object newArray = Array.newInstance(clazz, length);
		int copyIndex = Array.getLength(array);
		System.arraycopy(array, 0, newArray, 0, copyIndex);
		return newArray;
	}

	/**
	 * test get class loader
	 **/
	@Test
	public void testGetClassLoader() {
		Person person = new Person();
		System.out.println(person.getClass().getClassLoader().getClass().getName());
		ArrayList<String> intList=new ArrayList<>();
		System.out.println(intList.getClass().getClassLoader());
		System.out.println(intList.getClass().getClassLoader());
		System.out.println(person.getClass().getClassLoader().getParent().getClass().getName());
		//System.out.println(person.getClass().getClassLoader().getParent().getClass().getName());
	}
	
	

}
