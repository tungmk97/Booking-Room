package cnpm.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
@Transactional
public class RoleRepository extends JdbcDaoSupport {
 
    @Autowired
    public RoleRepository(DataSource dataSource) {
        this.setDataSource(dataSource);
    }
 
    public List<String> getRoleNames(int user_id) {
        String sql = "Select r.name " //
                + " from user_role ur, tbl_role r " //
                + " where ur.role_id = r.id and ur.user_id = ? ";
 
        Object[] params = new Object[] { user_id };
 
        List<String> roles = this.getJdbcTemplate().queryForList(sql, params, String.class);
 
        return roles;
    }
     
}