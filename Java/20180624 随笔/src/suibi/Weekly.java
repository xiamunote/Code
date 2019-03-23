package suibi;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.Serializable;

public class Weekly implements Serializable
{
	private Attachment attachment;
	private String name = "c";
	int m = 1;
	public void setAttachment(Attachment attachment)
	{
		this.attachment = attachment;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setM(int m)
	{
		this.m = m;
	}
	public Attachment getAttachment()
	{
		return this.attachment;
	}
	public String getName()
	{
		return this.name;
	}
	public int getM()
	{
		return this.m;
	}
	//使用序列化技术实现深克隆
	public Weekly deepClone() throws IOException, ClassNotFoundException, OptionalDataException {
		//将对象写入流中
		ByteArrayOutputStream bao=new ByteArrayOutputStream();
		ObjectOutputStream oos=new ObjectOutputStream(bao);
		oos.writeObject(this);
		
		//将对象从流中取出
		ByteArrayInputStream bis=new ByteArrayInputStream(bao.toByteArray());
		ObjectInputStream ois=new ObjectInputStream(bis);
		return (Weekly)ois.readObject();
	}
}
