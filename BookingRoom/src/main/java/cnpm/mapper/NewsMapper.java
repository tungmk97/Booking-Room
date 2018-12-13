package cnpm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cnpm.domain.Post;

public class NewsMapper implements RowMapper<Post>{
	public Post mapRow(ResultSet rs, int rowNum) throws SQLException{
		Post post = new Post();
		post.setId_post(rs.getInt(""));
		post.setTitle(rs.getString(""));
		post.setAcreage(rs.getInt(""));
		post.setAddress(rs.getString(""));
		post.setPrice(rs.getInt(""));
		post.setDescription(rs.getString(""));
		return post;
	}
}
