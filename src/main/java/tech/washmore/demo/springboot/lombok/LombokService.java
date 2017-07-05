package tech.washmore.demo.springboot.lombok;

import tech.washmore.demo.springboot.lombok.model.LombokUser;

/**
 * @author Washmore
 * @version V1.0
 * @summary 奇淫巧技
 * @Copyright (c) 2017, Lianjia Group All Rights Reserved.
 * @since 2017/7/5
 */
public class LombokService {
    public int getAge() {
        return new LombokUser().getAge();
    }
}
