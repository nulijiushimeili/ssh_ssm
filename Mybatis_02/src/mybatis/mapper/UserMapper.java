package mybatis.mapper;

import mybatis.moduel.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {
    @Insert("insert into t_user(name,password) values(#{name},#{password})")
    public void add(User user);
    @Update("update t_user set name = #{name},password = #{password} where id = #{id}")
    public void update(User user);
    @Delete("delete from t_user where id = #{id}")
    public void delete(int id);
    @Select("select * from t_user where id = #{id}")
    public User load(int id);
}
