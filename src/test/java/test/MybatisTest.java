package test;

import com.sxt.domain.dao.UserDao;
import com.sxt.domain.dao.UserDaoImpl;
import com.sxt.domain.entity.User;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class MybatisTest {

    @Test
    public void testadd(){
        UserDao dao = new UserDaoImpl();
        User user = new User("景甜","香港",new Date());
        dao.add(user);
    }

    @Test
    public void testupdate(){
        UserDao dao = new UserDaoImpl();
//        User user = new User();
//        user.setId(1);
//        user.setName("景甜");
//        user.setAddress("香港");
//        user.setBirthday(new Date());
        User user = new User(3,"高圆圆","北京",new Date());
        dao.update(user);
    }

    @Test
    public void testdelete(){
        UserDao dao = new UserDaoImpl();
        dao.delete(1);
    }

    @Test
    public void testqueryById(){
        UserDao dao = new UserDaoImpl();
        User u = dao.queryById(3);
        System.out.println(u);
    }

    @Test
    public void testqueryALL(){
        UserDao dao = new UserDaoImpl();
        List<User> list=dao.queryAll();
//        for(int i= 0;i<list.size();i++){
//            System.out.println(list.get(i));
//        }
        for(User u :list){
            System.out.println(u);
        }
    }
}
