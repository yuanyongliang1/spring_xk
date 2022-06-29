package com.zys.service.Impl;

import com.zys.mapper.AdminMapper;
import com.zys.pojo.Admin;
import com.zys.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @USER 张英帅
 * @date 2021/5/18 - 16:44
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    /**
     * 数据库中查找admin是否存在
     * @param admin 前台账号输入的管理员账号信息
     * @return
     */
    @Override
    public Admin adminLogin(Admin admin) {
        Admin getAdmin = adminMapper.adminLogin(admin);

        return getAdmin;
    }


    /**
     * 修改管理员个人信息（修改管理员密码，姓名）
     * @param admin 传入对象参数
     * @return
     */
    @Override
    public int updateAdmPass(Admin admin) {
        System.out.println(admin);
        int i = adminMapper.updateAdmPass(admin);
        return i;
    }

    /**
     * 查询所有--条件查询
     * @param admin 对象参数，可传可不传
     * @return
     */
    @Override
    public List<Admin> getAdmin(Admin admin) {
        return adminMapper.getAdmin(admin);
    }

    /**
     * 查询所有，但排除登陆的管理员数据
     * @param admAccount 登录的管理员账号
     * @return
     */
    @Override
    public List<Admin> getAdminAllButOwn(String admAccount) {
        return adminMapper.getAdminAllButOwn(admAccount);
    }

    /**
     * 删除管理员
     * @param admAccount 传入管理员账号参数
     * @return
     */
    @Override
    public int deleteAdmin(String admAccount) {
        return adminMapper.deleteAdmin(admAccount);
    }

    /**
     * 通过授权老师添加管理员
     * @param admin 参数
     * @return
     */
    @Override
    public int addAdmin(Admin admin) {
        return adminMapper.addAdmin(admin);
    }
}
