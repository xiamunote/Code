package suibi;

import java.util.*;

public class suibi
{
	public static void main(String[] args)
	{
		List<Student> list = new ArrayList<Student>();
		Student s1 = new Student("aaa", 10);
		list.add(s1);
		Student s2 = new Student("bbb", 11);
		list.add(s2);
		Iterator itr = list.iterator();
		for(;itr.hasNext();)
		{
			Student s = (Student)itr.next();
			System.out.println("������" + s.getName() + "�����䣺" + s.getAge());
		}
		for(Student ss : list)
		{
			System.out.println("������" + ss.getName() + "�����䣺" + ss.getAge());
		}
	}
}