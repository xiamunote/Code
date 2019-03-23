<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<s:iterator value="news">
	<DIV class="newsItem">
		<DIV class="newsContent">
			<A href="newDetail.action?info.infoId=${infoId }" 
			target="_blank">${infoTitle}</A>
		</DIV>
		<DIV class="newsDate">
			<s:date name="infoTime" format="yyyy-MM-dd" />
		</DIV>
	</DIV>
</s:iterator>