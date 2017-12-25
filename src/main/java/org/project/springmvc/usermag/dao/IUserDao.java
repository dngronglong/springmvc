package org.project.springmvc.usermag.dao;

import org.project.springmvc.beans.UserBean;

public interface IUserDao {
    UserBean Login(UserBean user);
}
