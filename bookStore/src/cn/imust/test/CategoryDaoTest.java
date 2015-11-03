package cn.imust.test;

import org.junit.Test;

import cn.imust.dao.CategoryDao;
import cn.imust.dao.impl.CategoryDaoImpl;
import cn.imust.domain.Category;

/**
 * ������
 * 
 * @author yang
 *
 */
public class CategoryDaoTest {
	@Test//ע�� Junit��Ԫ���Ե�ע��
	public void testAdd(){
		CategoryDao dao = new CategoryDaoImpl();
		Category c = new Category("123456","ˮ䰴�","���ݺܺã��ʺ�С���ӿ�");
		dao.save(c);
	}
	@Test//ע�� Junit��Ԫ���Ե�ע��
	public void testUpdate(){
		CategoryDao dao = new CategoryDaoImpl();
		Category c = new Category("123456","���μ�","���ߺ�ţ��");
		dao.update(c);
	}
	@Test//ע�� Junit��Ԫ���Ե�ע��
	public void testDelete(){
		CategoryDao dao = new CategoryDaoImpl();
		dao.delete("123456");
	}
}
