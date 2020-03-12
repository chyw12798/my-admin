package com.myproject.admin.service;

import com.myproject.admin.model.MasAdmin;
import org.springframework.stereotype.Component;

public interface MasUserService {


    MasAdmin getConcurrentAdmin();

}
