package com.keroro.chowder;

import com.keroro.chowder.dao.mapper.GachaRecordMapper;
import com.keroro.chowder.dao.po.GachaRecordPO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ChowderApplicationTests {

	@Autowired
	private GachaRecordMapper gachaRecordMapper;

	@Test
	void contextLoads() {
	}

	/**
	 * 测试数据库连接，查询
	 */
	@Test
	public void testSelect() {
		System.out.println("----- select method test -----");
		List<GachaRecordPO> recordPOList = gachaRecordMapper.selectList(null);
		recordPOList.forEach(System.out::println);
	}

}
