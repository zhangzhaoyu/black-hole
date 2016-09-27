package org.zzy.spring4.application.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 16-9-20
 * @sine 1.0
 */
public class Spitter {

    private Long id;

    @NotNull
    @Size(min = 5, max = 16)
    private String userName;
    private String password;
    private String firstName;
    private String lastName;

    public Spitter() {
    }

    public Spitter(Long id, String userName, String password, String firstName, String lastName) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
