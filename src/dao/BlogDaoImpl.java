package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.sun.corba.se.pept.transport.Connection;

import model.Blog;

import utility.ConnectionManager;

public class BlogDaoImpl implements BlogDaoInterface{

	@Override
	public void insertBlog(Blog blog) {
		// TODO Auto-generated method stub
		ConnectionManager con = new ConnectionManager();
		int id = blog.getBlogId();
		String blogtitile = blog.getBlogTitle();
		String blogDescription = blog.getBlogDescription();
		LocalDate date = blog.getPostedOn();
		String sql ="insert into blog(BLOGID,BLOGTITLE,blogDescription,postedOn)VALUES(?,?,?,?)";
		try {
			PreparedStatement st = ConnectionManager.getConnection().prepareStatement(sql);
			st.setInt(1, id);
			st.setString(2,blogtitile );
			st.setString(3, blogDescription);
			st.setDate(4, date);
			st.executeUpdate(sql);
			ConnectionManager.getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Blog> selectAllBlogs() {
		// TODO Auto-generated method stub
		List<Blog> blogs = new ArrayList<Blog>();
		ConnectionManager con = new ConnectionManager();
		
		try {
			Statement st = ConnectionManager.getConnection().createStatement();
			String sql = "select * from FROM WHERE BLOG";
			ResultSet res = st.executeQuery(sql);
			while(res.next()) {
				int blogId =res.getInt("blogId");
				String blogTitle = res.getString("blogTitle");
				String blogDescription = res.getString("blogDescription");
				 LocalDate postedOn= res.getDate("postedOn");
				Blog b = new Blog(blogId, blogTitle, blogDescription, postedOn);
				blogs.add(b);
				return blogs;
			}
			
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}