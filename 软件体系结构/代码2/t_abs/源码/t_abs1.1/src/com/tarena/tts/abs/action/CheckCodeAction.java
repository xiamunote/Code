package com.tarena.tts.abs.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Random;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * @ file_name CheckCodeAction.java
 * @ author baiyx (baiyx@tarena.com.cn)
 * @ date May 15, 201210:27:15 AM
 * @ description
 * @ reviewed_by 
 */
public class CheckCodeAction extends BaseAction {
	
	private InputStream input;
	private static int WIDTH = 60;
	private static int HEIGHT = 30;
	private static int NUM = 4;
	private static char[] seq = 
	{ 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
	'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
	'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8',
	'9' };
	
	@Override
	public String execute() throws Exception {
		
		byte[] image = randomImage();
		input = new ByteArrayInputStream(image);
		return SUCCESS;
	}
	
	/**
	 * 
	 * @return
	 */
	private byte[] randomImage() {
		Random r = new Random();

		// 图片的内存映像
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
				BufferedImage.TYPE_INT_RGB);

		// 获得画笔对象
		Graphics g = image.getGraphics();
		g.setColor(randomColor(r));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(new Color(0, 0, 0));

		// 用于存储随机生成的验证码
		StringBuffer number = new StringBuffer();

		// 绘制验证码
		for (int i = 0; i < NUM; i++) {
			g.setColor(randomColor(r));
			int h = (int) (HEIGHT * 60 / 100);
			g.setFont(new Font(null, Font.BOLD, h));
			String ch = String.valueOf(seq[r.nextInt(seq.length)]);
			number.append(ch);
			g.drawString(ch, i * WIDTH / NUM * 90 / 100, h);
		}
		
		//将生成的验证码存入session
		session.put("number", number);

		// 绘制干扰线
		for (int i = 0; i <= 4; i++) {
			g.setColor(randomColor(r));
			g.drawLine(r.nextInt(WIDTH), r.nextInt(HEIGHT), 
					r.nextInt(WIDTH), r.nextInt(HEIGHT));
		}

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);

		// 把BufferedImage对象中的图像信息编码后
		// 向创建该对象(encoder)时指定的输出流输出
		try {
			encoder.encode(image);
			return os.toByteArray();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private Color randomColor(Random r) {
		return new Color(r.nextInt(255), 
				r.nextInt(255), r.nextInt(255));
	}

	public InputStream getInput() {return input;}
	public void setInput(InputStream input) {this.input = input;}
}
