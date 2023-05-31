package com.multi.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.multi.domain.MemoVO;
import com.multi.mapper.MemoMapper;


@Service("memoService")
public class MemoServiceImpl implements MemoService {

	@Inject
	private MemoMapper mMapper;
	
	@Override
	public int insertMemo(MemoVO memo) {
		// 글번호 관련 로직 처리
		return mMapper.insertMemo(memo);
	}

	@Override
	public List<MemoVO> listMemo() {
		// TODO Auto-generated method stub
		return mMapper.listMemo();
	}

	@Override
	public int deleteMemo(String id) {
		// TODO Auto-generated method stub
		return this.mMapper.deleteMemo(id);
	}

	@Override
	public int updateMemo(MemoVO memo) {
		// TODO Auto-generated method stub
		return this.mMapper.updateMemo(memo);
	}

	@Override
	public MemoVO getMemo(String id) {
		// TODO Auto-generated method stub
		return this.mMapper.getMemo(id);
	}

}
