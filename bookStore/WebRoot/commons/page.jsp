<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="pagination">
	<ul>

        当前${page.pageNo }页/共${page.totalPage }页
        <li class="nextpage"><a href="${page.url }&pageNo=1">首页 &lt;&lt;</a></li>
		<li class="nextpage"><a href="${page.url }&pageNo=${page.prep}">上一页 &lt;&lt;</a></li>
		<!-- <li class="currentpage">1</li>
		<li><a href="product_info.jsp">2</a>
		</li>
		<li><a href="product_info.jsp">3</a>
		</li>
		<li><a href="product_info.jsp">4</a>
		</li> -->


		<li class="nextpage"><a href="${page.url }&pageNo=${page.nextp}">下一页&gt;&gt;</a>
		<li class="nextpage"><a href="${page.url }&pageNo=${page.totalPage}">尾页 &lt;&lt;</a></li>
		</li>

	</ul>
</div>