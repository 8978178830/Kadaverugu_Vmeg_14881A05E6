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
if(students==null)
			throw new IllegalArgumentException();

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
if(index < 0 || index >= students.length)
			throw new IllegalArgumentException();
		else{
			LinkedList<Student> llstudent = new LinkedList<Student>(Arrays.asList(this.students));
			for(int i=0;i<index-1;i++)
				llstudent.remove(i);
			this.students = llstudent.toArray(new Student[llstudent.size()]);
		}
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
if(student == null)
			throw new IllegalArgumentException();
		else{
			LinkedList<Student> llstudent = new LinkedList<Student>(Arrays.asList(this.students));
			int firstIndex = llstudent.indexOf(student);
			for(int i=0;i<firstIndex+1;i++)
				llstudent.remove(i);
			this.students = llstudent.toArray(new Student[llstudent.size()]);
		}
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
for(int i=0;i<this.students.length;i++){
			for(int j=0;j<this.students.length-i-1;j++){
				int id1=this.students[j].getId();
				int id2=this.students[j+1].getId();
				//System.out.print("id1 :"+id1+"  id2 :"+id2+"  length:"+this.students.length);
				if(id1 > id2){
					Student temp = new Student(0,"null",null,0);
					temp = this.students[j];
					this.students[j] = this.students[j+1];
					this.students[j+1] = temp;
				}
			}
		}
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
LinkedList<Student> llstudent=new LinkedList<Student>();
		if(date == null)
			throw new IllegalArgumentException();
		else{
			for(int i=0;i<this.students.length;i++){
				Date date1=this.students[i].getBirthDate();
				int comparison = date.compareTo(date1);
				if(comparison == 0)
					llstudent.add(students[i]);
			}
		}
		if(llstudent.size()>0)
			return llstudent.toArray(new Student[llstudent.size()]);
		return null;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
LinkedList<Student> llstudent=new LinkedList<Student>();
		if(firstDate == null || lastDate == null)
			throw new IllegalArgumentException();
		else{
			for(int i=0;i<this.students.length;i++){
				Date date1=this.students[i].getBirthDate();
				int c1 = firstDate.compareTo(date1);
				int c2 = lastDate.compareTo(date1);
				if((c1 == -1 && c2 == 1) || c1==0 || c2==0)
					llstudent.add(students[i]);
			}
		}
		if(llstudent.size()>0)
			return llstudent.toArray(new Student[llstudent.size()]);
              
		return null;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
LinkedList<Student> llstudent=new LinkedList<Student>();
		if(date == null)
			throw new IllegalArgumentException();
		else{
			Date d1 = new Date();
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.DATE,days);
			d1 = c.getTime();
			//d1 = d1+days;
			for(int i=0;i<this.students.length;i++){
				Date date1=this.students[i].getBirthDate();
				int c1 = date.compareTo(date1);
				int c2 = date.compareTo(d1);
				if((c2 == -1 && c1 <= -1) || c1==0 || c2==0)
					llstudent.add(students[i]);
			}
		}
		if(llstudent.size()>0)
			return llstudent.toArray(new Student[llstudent.size()]);
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
              int age;
		if(indexOfStudent == 0)
			throw new IllegalArgumentException();
		else{
			Date d1=new Date(98,1,25);
			Date d2=this.students[indexOfStudent].getBirthDate();
			Calendar a = Calendar.getInstance();
			a.setTime(d1);
			Calendar b = Calendar.getInstance();
			b.setTime(d2);
			
			age = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
			if (a.get(Calendar.MONTH) > b.get(Calendar.MONTH) || (a.get(Calendar.MONTH) == b.get(Calendar.MONTH) && a.get(Calendar.DATE) > b.get(Calendar.DATE)))
        		age--;
		}
		if(age > 0)
			return age;

		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
 int a1;
		LinkedList<Student> llstudent=new LinkedList<Student>();
		for(int i=0;i<this.students.length;i++){
			Date d1=new Date(98,1,25);
			Date d2=this.students[i].getBirthDate();
			Calendar a = Calendar.getInstance();
			a.setTime(d1);
			Calendar b = Calendar.getInstance();
			b.setTime(d2);
			a1 = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
			
			if (a.get(Calendar.MONTH) > b.get(Calendar.MONTH) || (a.get(Calendar.MONTH) == b.get(Calendar.MONTH) && a.get(Calendar.DATE) > b.get(Calendar.DATE)))
        		a1--;
			//System.out.println("Years:  "+b.get(Calendar.YEAR)+"   "+a.get(Calendar.YEAR)+"   "+age1);
			if(a1 == age)
				llstudent.add(this.students[i]);
		}
		if(llstudent.size() > 0)
			return llstudent.toArray(new Student[llstudent.size()]);
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
