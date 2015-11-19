# BookStore
在线书城
# 前台功能：
##1. index.jsp
	跳转到查看所有书籍的页面(listBooks.jsp)

##2. listBooks.jsp此页面要进行的功能分析:
###	1.商品分类：
		<c:forEach items="${cs}" var="c">
			<a href="${pageContext.request.contextPath}/servlet/ClientServlet?op=showCategoryPageRecords&categoryId=${c.id}">${c.name}</a>
		</c:forEach>

		点击每个分类时还要有商品分类和分页的功能

##	2.显示当前页的所有书籍

##	3.点击购买时可以将当前书籍加入到购物车，支持购物车中添加多本书籍
  		Cart:
  			private Map<String,CartItem> items = new HashMap<String,CartItem>();
  			private int totalNum;
  			private float totalPrice;
  
  			public float getTotalPrice() {
  			totalPrice=0;
  			for(Map.Entry<String, CartItem> item:items.entrySet()){
  				totalPrice+=item.getValue().getPrice();
  			}
  			return totalPrice;
  			}
  			
  			public int getTotalNum() {
  				totalNum = 0;
  				for(Map.Entry<String, CartItem> item :items.entrySet()){
  					totalNum+=item.getValue().getNum();
  				}
  				return totalNum;
  			}
  			
  			public void addBook2Cart(Book book ){
  				if(items.containsKey(book.getId())){
  					CartItem item = items.get(book.getId());
  					item.setNum(item.getNum()+1);
  				}else{
  					CartItem item = new CartItem(book, 1, book.getPrice());
  					items.put(book.getId(), item);
  				}
  			}

##3. 点击我的购物车时，可以进行当前购买书籍的查看。

#后台功能：

##1.添加分类

##2.查看分类（要加入每页的功能,可扩展出批量删除功能）
	支持删除，修改

##3.添加书籍
	1.书籍的封面应当要采用文件上传的方式保存到服务器上
	2.最好要实现客户端和服务器端的双重验证

##4.查看图书
	1.分页并显示所有图书信息
	2.支持删除，修改，看图片
