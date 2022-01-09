package com.codeify.springboot01.typeparameter.user;

import com.codeify.springboot01.typeparameter.BaseService;
import com.codeify.springboot01.typeparameter.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author codeify
 * @since 2021/08/25 22:47
 */
@Service("s1")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

}
