package otcyan.java.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;

import otcyan.java.bean.User;
import otcyan.java.tools.Tookit;

public class CheckInfo {

	private DataHandle dataHandle ;
	public CheckInfo(){
		dataHandle = new DataHandle() ;
	}
	/**
	 * ���ע����Ϣ
	 * @param user
	 * @return
	 */
	public boolean checkRegistInfo(User user){
	
		if(this.check(user)){
			//��ʽ��ȷ
			boolean b = checkisExist("select u_id from users where 1=?", new String[]{"1"}, user.getU_id()) ;
			if(b){
				JOptionPane.showMessageDialog(null, user.getU_id()+"�Ѿ����ڣ���");
				return false;
			}
		}else {
			return false ;
		}
		//���UserId�ǲ��Ǵ���
		
		return true;
	}
	
	public boolean check(User user){
		
//		boolean b = false ;
		String userId = user.getU_id() ; 
		String userPwd=user.getU_password(); //
		String userName=user.getU_name();
		String userTel=user.getU_telephone();//11Ϊ
		String userAddr=user.getU_address();
		String userEmail=user.getU_email();
		String userIdcard=user.getU_idcard();
		System.out.println(user);
		//�ж��û����Ƿ񳬳�
		if(userId.length()>20){
			JOptionPane.showMessageDialog(null, "�û������Ȳ��ܳ���20!");
			return false ;
		}
		//�ж��Ƿ����
		
		//�ж������Ƿ񳬳�
		if(userName.length()>20){
			JOptionPane.showMessageDialog(null, "�������Ȳ��ܳ���20!");
			return false;
		}
		//�жϵ�ַ�Ƿ񳬳�
		if(userAddr.length()>100){
			JOptionPane.showMessageDialog(null, "��ַ���Ȳ��ܳ���100!");
			return false;
		}
		//�жϵ绰�����Ƿ���ȷ"^(0\\d{2,3}-)?(\\d{7,8})|(0?1\\d{10})$"
		if(!userTel.matches("^(0\\d{2,3}-)?(\\d{7,8})|(0?1\\d{10})$")){
			JOptionPane.showMessageDialog(null, "�绰�����ʽ����!");
			return false;
		}
	    //�жϵ��������Ƿ���ȷ
		if(!userEmail.matches("^\\w{1,}@[0-9a-zA-Z]{1,10}.(com|cn)$")){
			JOptionPane.showMessageDialog(null, "���������ʽ����ȷ!");
		}
		//�ж����֤�����Ƿ���ȷ
		if(!userIdcard.matches("^\\d{17}[0-9a-zA-Z]$")){
			JOptionPane.showMessageDialog(null, "���֤��ʽ����ȷ!");
			return false;
		}
		return true ;
	}
	/**
	 * �жϺ����ǲ��Ǵ���
	 * @param sql
	 * @param paras
	 * @param txtNum
	 * @return
	 */
	public boolean checkisExist(String sql,String[] paras,String num){
	
		boolean b = false ;
			Vector<String> v = dataHandle.queryStringVector(sql, paras) ;
			if(v.contains(num)){
				//��ʾ�Ѿ�����
				b=true ;
			}
		return b ;
	}
	
	public  boolean isTrue(String date){
		//date��ʽ�ǲ�����ȷ 
		if(!date.matches("\\d{4}-\\d{2}-\\d{2}")){
			JOptionPane.showMessageDialog(null, "��ʽ����!!���磺2012-01-01") ;
			return false ;
		}
		//�ж�  ����С�� ��ǰ���� 
		DateFormat sdf = Tookit.getDateFormat("yyyy-MM-dd") ;
		String currentTime = sdf.format(new Date()) ;//2012-12-13
		System.out.println(currentTime);
		String str[] = currentTime.split("-") ;//currentTime  ��ʾ ��ǰ��    2013-03-02
		String strs[] = date.split("-") ;//date   1991  �������                                 1991-10-11
		if(!strs[1].matches("0[1-9]|1[0-2]")){
			//��<0 >12 
			JOptionPane.showMessageDialog(null, "�·ݲ���С��0���Ҵ���12") ;
		}
		
		//str[0]  strs[0]  ��ʾ ��
		//str[1]  ��ʾ��
		//str[2]   ��ʾ�� 
		if(str[0].compareTo(strs[0])<0){//��ǰ  ʱ��  year  >  date ʱ�� year  ����
			//��ʾ ��ǰ��ҪС��ͬ
			JOptionPane.showMessageDialog(null, "�������"+strs[0]+"������") ;
			return false ;
		}
		
		if(str[0].compareTo(strs[0])==0){
			//��ʾ ���
			if(str[1].compareTo(strs[1])<0){
				//��ǰ��С 
				if(!isDay(strs[1],strs[2])){
					return false ;
				}
			}
			if(str[1].compareTo(strs[1])==0){
				//�����
				if(!isDay(strs[1],strs[2])){
					return false ;
				}
			}
			if(str[1].compareTo(strs[1])>0){
				//��ǰ��Ҫ����
				return false ;
			}
		}
		
		if(str[0].compareTo(strs[0])>0){
			//��ʾ��ǰ��Ҫ��
			JOptionPane.showMessageDialog(null, "�������"+strs[0]+"������") ;
			return false;
		}
		
		
		//��ʽ�� ��ȷ 
		
		//�ж� ����ʱ�� 
		try {
			long currentTimeSecond = sdf.parse(currentTime).getTime() ;
			long dateTimeSecond = sdf.parse(date).getTime() ;

			if(dateTimeSecond-currentTimeSecond>10*24*3600*1000){
				//����10����
				JOptionPane.showMessageDialog(null, "ֻ������10�����ڵ�����") ;
				return false ;
			}
			if(dateTimeSecond-currentTimeSecond<0){
				//����10����
				JOptionPane.showMessageDialog(null, "ֻ������"+currentTime+"�Ժ������") ;
				return false ;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//��ʽ  �ǲ�����ȷ ��
		return true ;
	}
	
	public static boolean isDay(String month,String day){
		
		if(month.matches("0[1]|0[3]|0[5]|0[7]|0[8]|0[10]|0[12]|")){
			//day��30��
			if(day.compareTo("00")<0 || day.compareTo("31")>0){
				return false ;
			}
		}
		if(month.matches("0[2]")){
			//day��30��
			if(day.compareTo("00")<0 || day.compareTo("29")>0){
				return false ;
			}
		}
		if(month.matches("0[4]|0[6]|0[9]|0[11]")){
			//day��30��
			if(day.compareTo("00")<0 || day.compareTo("30")>0){
				return false ;
			}
		}
		
		return true ;
	}
}
