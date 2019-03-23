package com.tarena.tts.abs.biz;

import java.sql.SQLException;
import com.tarena.tts.abs.entity.Information;

/**
 * @ file_name InformationBiz.java
 * @ author baiyx (baiyx@tarena.com.cn)
 * @ date May 28, 201210:54:32 AM
 * @ description
 * @ reviewed_by 
 */
public interface InfoBiz {
	
	/**
	 * 通过id查找Information对象
	 * @ Information findInfoById(InfoBiz)
	 * @ author baiyx (baiyx@tarena.com.cn)
	 * @ date May 28, 201211:07:09 AM
	 * @ description 
	 * @ reviewed_by
	 */
	public Information findInfoById(int id) throws SQLException;
	
}
