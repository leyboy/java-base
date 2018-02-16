package reflect;

import java.io.Serializable;


/**
 * this class is use to test reflect
 **/
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static int DEFAULT_AGE = 0;
	@SuppressWarnings("unused")
	private final static String DEFAULT_NAME = "none";
	private String name;
	private int age;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@SuppressWarnings("unused")
	private int getDefaultAge(){
		return 10;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}
