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
			System.out.println("姓名：" + s.getName() + "，年龄：" + s.getAge());
		}
		for(Student ss : list)
		{
			System.out.println("姓名：" + ss.getName() + "，年龄：" + ss.getAge());
		}
	}
}