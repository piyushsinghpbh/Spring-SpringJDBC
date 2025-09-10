package com.learning.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.learning.model.Alien;

@Repository
public class AlienRepo {
	
	JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public void save(Alien alien) {
		
		String query = "insert into alien (id,name,tech) values (?,?,?)";
		
		int row= template.update(query, alien.getId(),alien.getName(),alien.getTech());
		
		System.out.println("Number of row affected"+ row);
	}
	
	public List<Alien> returnAll() {
		String fetchQuery = "Select * from alien";
		
		RowMapper<Alien> mapper = new RowMapper<Alien>() {
			
			@Override
			public Alien mapRow(ResultSet rs, int rowNum) throws SQLException {
				Alien alien = new Alien();
				alien.setId(rs.getInt(1));
				alien.setName(rs.getString(2));
				alien.setTech(rs.getString(3));			
				return alien;
			}
		};
				
		template.query(fetchQuery,mapper);
		return template.query(fetchQuery,mapper);	
		
	
	}
	

}
