package file;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributeView;
import java.util.Date;

public class FileAttributeTest {
	public static void main(String[] args) throws Exception {
		Path path = Paths.get("D:/test/test.txt");
		BasicFileAttributeView basicview = Files.getFileAttributeView(path,
				BasicFileAttributeView.class);
		BasicFileAttributes basicfile = basicview.readAttributes();
		System.out.println("创建时间:"
				+ new Date(basicfile.creationTime().toMillis()));
		System.out.println("文件大小:" + basicfile.size());
		DosFileAttributeView dosview = Files.getFileAttributeView(path,
				DosFileAttributeView.class);
		dosview.setHidden(true);
		dosview.setReadOnly(true);
		System.out.println("读写属性:"+dosview.readAttributes().isReadOnly());
	}

}
