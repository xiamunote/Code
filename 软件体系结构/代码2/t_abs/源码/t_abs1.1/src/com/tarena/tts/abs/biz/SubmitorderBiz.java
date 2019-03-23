package com.tarena.tts.abs.biz;

import java.sql.SQLException;
import java.util.List;

import com.tarena.tts.abs.entity.Passenger;

/**
 * @ file_name SubmitorderBiz.java
 * @ author baiyx (baiyx@tarena.com.cn)
 * @ date May 30, 20129:40:52 AM
 * @ description
 * @ reviewed_by 
 */
public interface SubmitorderBiz {
	
	/**
	 * 保存页面提交的Passenger信息到数据库中
	 * @ void savePassenger(SubmitorderBiz)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date May 30, 20129:41:55 AM
	 * @ description 
	 * @ reviewed_by
	 */
	public void savePassenger(Passenger p) throws SQLException;
}
