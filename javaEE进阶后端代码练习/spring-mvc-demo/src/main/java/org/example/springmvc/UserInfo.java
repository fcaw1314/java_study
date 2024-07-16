package org.example.springmvc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/13 9:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    private String userName;
    private String password;
    private int age;

//    public UserInfo(String userName, String password, int age) {
//        this.userName = userName;
//        this.password = password;
//        this.age = age;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    @Override
//    public String toString() {
//        return "UserInfo{" +
//                "userName='" + userName + '\'' +
//                ", password='" + password + '\'' +
//                ", age=" + age +
//                '}';
//    }
}
