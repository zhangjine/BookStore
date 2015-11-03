package cn.imust.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import cn.imust.dao.CategoryDao;
import cn.imust.domain.Category;
import cn.imust.utils.C3P0Util;

public class CategoryDaoImpl implements CategoryDao {
	//用于执行CURD命令的
	private QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
	
	public void save(Category category) {
		//PreparedStatement 预处理 sql语句中有?作为占位符
		try {
			qr.update("insert into category values(?,?，?)", category.getId(),category.getName(),category.getDescription());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public void update(Category category) {
		try {
			qr.update("update category set name=?,description=? where id=?", category.getId(),category.getName(),category.getDescription());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public void delete(Serializable id) {
		try {
			qr.update("delete from category where id=?", id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public Category findOne(Serializable id) {
		return null;
	}

	public List<Category> findAll() {
		return null;
	}

}
