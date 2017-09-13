import java.util.Date;
import java.util.*;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		return students;
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here

    this.students=students;
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
		if(index < 0||index>=this.students.length)
          throw new IllegalArgumentException();
                return students[index];
		//return null;
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
if(index < 0||index>=this.students.length)
          throw new IllegalArgumentException();
         this.getStudents()[index] = student;
	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
if(student==null)
 throw new IllegalArgumentException();

         Student[] temp = new Student[this.students.length+1];
		 temp[0] = student;
		 for(int i = 1; i < temp.length; i++)
			 temp[i] = this.students[i-1];
		 this.students = temp;
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
 Student[] temp = new Student[this.getStudents().length+1];
		 for(int i = 0; i < this.students.length; i++)
			 temp[i] = this.students[i];
		 temp[temp.length - 1] = student;
		 this.students = temp;
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
if((student==null)||index < 0||index>=this.students.length)
          throw new IllegalArgumentException();
Student[] temp = new Student[this.students.length+1];
		 for(int i = 0; i < index; i++)
			 temp[i] = this.students[i];
		 temp[index] = student;
		 for(int i = index; i < this.students.length; i++)
			 temp[i+1] = this.students[i];
		 this.students = temp;
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
if(index < 0 || index >= students.length)
			throw new IllegalArgumentException();
  Student[] temp = new Student[this.students.length-1]; 
		 int c = 0;
		 for(int i = 0; i < this.students.length; i++)
			 if(i != index) temp[c++] = this.students[i];
		 this.students = temp;
	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
LinkedList<Student> llstudent = new LinkedList<Student>(Arrays.asList(this.students));
		int firstIndex = llstudent.indexOf(student);
		if(firstIndex == -1)
			throw new IllegalArgumentException("Student not exist");
		else if(student == null)
			throw new IllegalArgumentException();
		else{
			llstudent.remove(firstIndex);
			students = llstudent.toArray(new Student[llstudent.size()]);
		}
	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
if(index < 0 || index >= students.length)
			throw new IllegalArgumentException();
		else{
			LinkedList<Student> llstudent = new LinkedList<Student>(Arrays.asList(this.students));
			for(int i=index;i<llstudent.size();i++)
			{	
				llstudent.remove(i);
				
			}
			//for(int i=0;i<llstudent.size();i++)
				//System.out.println("llstudent:"+llstudent.get(i).getFullName());
			students = llstudent.toArray(new Student[llstudent.size()]);
		}
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
if(student == null)
			throw new IllegalArgumentException();
		else{
			LinkedList<Student> llstudent = new LinkedList<Student>(Arrays.asList(this.students));
			int firstIndex = llstudent.indexOf(student);
			for(int i=firstIndex+1;i<llstudent.size();i++)
				llstudent.remove(i);
			this.students = llstudent.toArray(new Student[llstudent.size()]);
		}
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
              
		return null;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
LinkedList<Student> llstudent=new LinkedList<Student>();
		double avg=0;
		for(int i=0;i<this.students.length;i++){
			double av=this.students[i].getAvgMark();
			if(av > avg)
				avg=av;
		}
		for(int i=0;i<this.students.length;i++){
			double av=this.students[i].getAvgMark();
			if(av==avg)
				llstudent.add(this.students[i]);
		}
		if(llstudent.size() > 0)
			return llstudent.toArray(new Student[llstudent.size()]);
		return null;
	
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
if(student == null)
			throw new IllegalArgumentException();
		else{
			LinkedList<Student> llstudent = new LinkedList<Student>(Arrays.asList(this.students));
			int firstIndex = llstudent.indexOf(student);
			return llstudent.get(firstIndex+1);
		}
		//return null;
	}
}
