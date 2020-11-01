package com.sxt.domain.dao;

import com.sxt.domain.entity.User;
import com.sxt.domain.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDaoImpl implements UserDao{

   @Override
    public void add(User user) {
        SqlSession session=null;
        try {
           session = MybatisUtil.createSqlSession();
            session.insert(UserDao.class.getName()+".add",user);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }finally {
            MybatisUtil.closeSqlSession(session);
        }
        System.out.println("添加成功");
    }

    @Override
    public void update(User user) {
        SqlSession session=null;
        try {
            session = MybatisUtil.createSqlSession();
            session.update(UserDao.class.getName()+".update",user);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }finally {
            MybatisUtil.closeSqlSession(session);
        }
        System.out.println("修改成功");
    }

    @Override
    public void delete(Integer id) {
        SqlSession session=null;
        try {
            session = MybatisUtil.createSqlSession();
            session.delete(UserDao.class.getName()+".delete",id);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }finally {
            MybatisUtil.closeSqlSession(session);
        }
        System.out.println("修改成功");
    }

    @Override
    public User queryById(Integer id) {
        SqlSession session=null;
        User user = null;
        try {
            session = MybatisUtil.createSqlSession();
            user = session.selectOne(UserDao.class.getName()+".queryById",id);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSqlSession(session);
        }
        return user;
    }

    @Override
    public List<User> queryAll() {
        SqlSession session=null;
        List<User> list = null;
        try {
            session = MybatisUtil.createSqlSession();
            list = session.selectList(UserDao.class.getName()+".queryALL");
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSqlSession(session);
        }
        return list;
    }
}
