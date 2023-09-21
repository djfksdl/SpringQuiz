package com.quiz.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson02.domain.Store;
import com.quiz.lesson02.mapper.StoreMapper;

@Service
public class StoreBo {
	@Autowired
	private StoreMapper storeMapper;
	//input : X(파라미터 안받음)
	//output : List<Store>
	public List<Store> getStoreList(){ //카타리나 노, 내가만든걸로 임포트
		return storeMapper.selectStoreList();
		
	}
}
