package kopo.poly.service.impl;

import kopo.poly.dto.UserInfoDTO;
import kopo.poly.repository.UserInfoRepository;
import kopo.poly.repository.entity.UserInfoEntity;
import kopo.poly.service.IUserInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.ehcache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserInfoService implements IUserInfoService {

    private final UserInfoRepository userInfoRepository;

    @Override
    public UserInfoDTO getUserIdExists(UserInfoDTO pDTO) throws Exception {

        log.info("service id 유무 가져오기");

        UserInfoDTO rDTO = new UserInfoDTO();
        String userId = pDTO.getUserId();

        log.info("userId : " + userId);

        Optional<UserInfoEntity> rEntity = userInfoRepository.findByUserId(userId);

        if (rEntity.isPresent()) {
            rDTO.setExistsYn("Y");
        } else {
            rDTO.setExistsYn("N");
        }

        return rDTO;
    }

    @Override
    public int insertUserInfo(UserInfoDTO pDTO) throws Exception {

        log.info("service 회원가입 실행");

        int res = 0;

        String userId = pDTO.getUserId();
        String userName = pDTO.getUserName();
        String password = pDTO.getPassword();
        String email = pDTO.getEmail();
        String addr1 = pDTO.getAddr1();
        String addr2 = pDTO.getAddr2();

        log.info("userId : " + userId);
        log.info("userName : " + userName);
        log.info("password : " + password);
        log.info("email : " + email);
        log.info("addr1 : " + addr1);
        log.info("addr2 : " + addr2);

        Optional<UserInfoEntity> rEntity = userInfoRepository.findByUserId(userId);

        if (rEntity.isPresent()) {
            res = 2;
        } else {

            UserInfoEntity pEntity = UserInfoEntity.builder()
                    .userId(userId)
                    .userName(userName)
                    .password(password)
                    .email(email)
                    .addr1(addr1)
                    .addr2(addr2)
                    .build();

            userInfoRepository.save(pEntity);
        }



        return 0;
    }

    @Override
    public int getUserLoginCheck(UserInfoDTO pDTO) throws Exception {
        return 0;
    }
}
