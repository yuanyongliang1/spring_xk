package com.zys.service;

import com.zys.pojo.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @USER 张英帅
 * @date 2021/5/18 - 16:41
 */
@Repository
public interface AdminService {

    Admin adminLogin(Admin admin);

    int updateAdmPass(Admin admin);

    List<Admin> getAdmin(Admin admin);

    List<Admin> getAdminAllButOwn(String admAccount);

    int deleteAdmin(String admAccount);

    int addAdmin(Admin admin);
}
