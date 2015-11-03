package cn.imust.test;

import org.junit.Test;

import cn.imust.dao.CategoryDao;
import cn.imust.dao.impl.CategoryDaoImpl;
import cn.imust.domain.Category;

/**
 * 测试类
 * 
 * @author yang
 *
 */
public class CategoryDaoTest {
	@Test//注解 Junit单元测试的注解
	public void testAdd(){
		CategoryDao dao = new CategoryDaoImpl();
		Category c = new Category("123456","水浒传","内容很好，适合小孩子看");
		dao.save(c);
	}
	@Test//注解 Junit单元测试的注解
	public void testUpdate(){
		CategoryDao dao = new CategoryDaoImpl();
		Category c = new Category("123456","西游记","作者很牛掰");
		dao.update(c);
	}
	@Test//注解 Junit单元测试的注解
	public void testDelete(){
		CategoryDao dao = new CategoryDaoImpl();
		dao.delete("123456");
	}
}
