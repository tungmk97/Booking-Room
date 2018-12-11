//package cnpm.mapper;
// 
//import java.sql.ResultSet;
//import java.sql.SQLException;
// 
//import org.o7planning.sbsecurity.model.AppUser;
//import org.springframework.jdbc.core.RowMapper;
//
//import cnpm.domain.Account;
// 
//public class AppUserMapper implements RowMapper<Account> {
// 
//    public static final String BASE_SQL //
//            = "Select u.user_id, u.username, u.password From tbl_accounts u ";
// 
//    @Override
//    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
// 
//        Long userId = rs.getLong("user_id");
//        String userName = rs.getString("username");
//        String encrytedPassword = rs.getString("password");
// 
//        return new Account(userId, userName, encrytedPassword);
//    }
// 
//}