package reflect;

import java.io.Serializable;

public class Student extends Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String studentId;
	public static final String DEFAULT_NAME="none";

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("unused")
	private Student(String studentId){
		this.studentId=studentId;
	}

	public Student(String name, int age) {
		super(name, age);
		// TODO Auto-generated constructor stub
	}

	public Student(String studentId, String name, int age) {
		super(name, age);
		this.studentId = studentId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ",studentName=" + super.getName() + ",StudentAge=" + super.getAge()
				+ "]";
	}

}
