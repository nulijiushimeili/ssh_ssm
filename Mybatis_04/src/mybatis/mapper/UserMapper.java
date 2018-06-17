package mybatis.mapper;

import mybatis.moduel.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    public void add(User user);
    public void update(User user);
    public void delete(int id);
//    @Select("select * from t_user where id = #{id}")
    public User load(int id);
}
