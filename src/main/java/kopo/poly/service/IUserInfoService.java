package kopo.poly.service;

import kopo.poly.dto.UserInfoDTO;

import java.beans.ExceptionListener;

public interface IUserInfoService {


    UserInfoDTO getUserIdExists(UserInfoDTO pDTO) throws Exception;

    int insertUserInfo(UserInfoDTO pDTO) throws Exception;

    int getUserLoginCheck(UserInfoDTO pDTO) throws Exception;
}
