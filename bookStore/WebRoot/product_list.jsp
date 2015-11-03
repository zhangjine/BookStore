<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>bookStore列表</title>
<%--导入css --%>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css" type="text/css" />
</head>

<body class="main">

	<jsp:include page="head.jsp" />
	<jsp:include page="menu_search.jsp" />

	<div id="divpagecontent">
		<table width="100%" border="0" cellspacing="0">
			<tr>

				<td>
					<div style="text-align:right; margin:5px 10px 5px 0px">
						<a href="index.jsp">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;计算机&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;图书列表
					</div>

					<table cellspacing="0" class="listcontent">
						<tr>
							<td>
								<h1>商品目录</h1>
								<hr />
								<h1>计算机</h1>&nbsp;&nbsp;&nbsp;&nbsp;共100种商品
								<hr />
								<div style="margin-top:20px; margin-bottom:5px">
									<img src="${pageContext.request.contextPath }/images/productlist.gif" width="100%" height="38" />
								</div>
								<table cellspacing="0" class="booklist">
								<!-- varStatus 代表遍历元素时所产生的一系列变量  内部包含index属性代表遍历元素的索引   count属性代表遍历元素的个数   -->
						         <c:forEach items="${page.recordes }" var="book" varStatus="st">
						           <c:if test="${st.index%4==0 }">
									    <tr>
									</c:if>
										<td>

											<div class="divbookpic">
												<p>
													<a href="product_info.jsp"><img src="${pageContext.request.contextPath }/bookcover/${book.imageName}" width="115"
														height="129" border="0" /> </a>
												</p>
											</div>

											<div class="divlisttitle">
												<a href="${pageContext.request.contextPath }/product_info.jsp">${book.name }<br />售价:${book.price } </a>
											</div></td>
										<td>
								 <c:if test="${st.count%4==0 }">
							        </tr>
							     </c:if>
						   </c:forEach>
			</table>















								<%@include file="commons/page.jsp" %>
							</td>
						</tr>
					</table></td>
			</tr>
		</table>
	</div>



	<jsp:include page="foot.jsp" />


</body>
</html>
