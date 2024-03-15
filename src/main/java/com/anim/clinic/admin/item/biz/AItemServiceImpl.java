package com.anim.clinic.admin.item.biz;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AItemServiceImpl implements AItemService {
	@Autowired
	AItemDao	aItemDao;
	
	@Override
	public String create(Map<String, Object> map) {
	    int affectRowCount = this.aItemDao.insert(map);
	    if (affectRowCount ==  1) {
	        return map.get("item_code").toString();
	    }
	    return null;

	}

}
