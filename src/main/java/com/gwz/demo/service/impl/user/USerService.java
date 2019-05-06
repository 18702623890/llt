package com.gwz.demo.service.impl.user;

import com.gwz.demo.model.UpFile;
import com.gwz.demo.model.Users;
import com.gwz.demo.util.IdGenertor;

import java.util.List;

public class USerService {
    /**
     * 用户登录注册界面的业务层
     */
    public Boolean saveUsers(Users users) {
        if (users == null) {
            throw new RuntimeException("the users is null");
        }
       if(Users.userdao.findFirst("select * from users where username=?",users.get("username"))!=null)
        {
            throw new RuntimeException("the users is exists");
        }
        users.set("id", IdGenertor.genGUID());
        return users.save();
    }
    /**
     * 登录界面的业务
     */
    public Users LoginUsers(String name,String password){

        return Users.userdao.findFirst("select * from users where username='"+name+"' and password='"+password+"'");
    }
    public boolean findUserByName(String name){
        if(Users.userdao.findFirst("select * from users where username=?",name)!=null)
            return  true;
        else
            return false;

    }
    /**
     * 修改用户信息
     */
    public  boolean updateUsers(Users users){
        return users.update();
    }
    /**
     * 删除用户信息
     */
    public boolean deleteById(String id){
        return Users.userdao.deleteById(id);
    }
    /**
     * 查询所有用户信息
     */
    public List<Users> findAllUsers(){
        List<Users> objectlist=Users.userdao.find("select * from users");
        return  objectlist;
    }
    /**
     * 查询单个用户
     * @param id
     * @return
     */
    public Users findUser(String id){
        return Users.userdao.findFirst("select * from users where id=?",id);
    }

    /**
     * 保存单个文件
     * @param file
     * @return
     */
    public Boolean saveFile(UpFile file){
       return file.save();
    }

}
