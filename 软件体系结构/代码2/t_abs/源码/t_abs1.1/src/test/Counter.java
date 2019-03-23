package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Counter {
	static int lines = 0;
	static int blanks = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		String root = "src";
		File dir = new File(root);
		countDir(dir);
		System.out.println("总行数:" + lines);
		System.out.println("空行数:" + blanks);
		System.out.println("非空行数:" + (lines - blanks));
		PrintWriter out = new PrintWriter(new FileOutputStream("counter.txt",
				true));
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		out.println(fmt.format(new Date()));
		out.println("总行数:" + lines);
		out.println("空行数:" + blanks);
		out.println("非空行数:" + (lines - blanks));
		out.close();
	}

	private static void countDir(File dir) {
		File[] files = dir.listFiles(new FileFilter() {
			@Override
			public boolean accept(File file) {
				return file.isDirectory() || file.getName().endsWith(".java");
			}
		});
		for (File file : files) {
			if (file.isFile()) {
				countFile(file);
			} else {
				countDir(file);
			}
		}
	}

	private static void countFile(File file) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			String str;
			while ((str = in.readLine()) != null) {
				if (str.trim().equals("")) {
					blanks++;
				}
				lines++;
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

}
