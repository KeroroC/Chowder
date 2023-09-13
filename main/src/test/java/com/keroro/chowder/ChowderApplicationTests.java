package com.keroro.chowder;

import com.drools.core.KieTemplate;
import com.keroro.chowder.dao.mapper.GachaRecordMapper;
import com.keroro.chowder.dao.po.GachaRecordPO;
import com.keroro.chowder.domain.entity.vo.StudentVO;
import org.drools.core.base.RuleNameEqualsAgendaFilter;
import org.junit.jupiter.api.Test;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ChowderApplicationTests {

	@Autowired
	private GachaRecordMapper gachaRecordMapper;

	@Autowired
	private KieTemplate kieTemplate;

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

//	@Test
//	public void droolsStudent() {
//
//		String drools = """
//                com.keroro.chowder.domain.entity.vo.StudentVO
//
//                rule "rule1"
//                    when
//                       student:StudentVO(age>18 || weight < 180)
//                    then
//                       System.out.println("学生的年龄是：" + student.getAge());
//                       System.out.println("学生的体重是是：" + student.getWeight());
//                end""";
//		try {
//			KnowledgeBuilder kb = KnowledgeBuilderFactory.newKnowledgeBuilder();
//			kb.add(ResourceFactory.newByteArrayResource(drools.getBytes(StandardCharsets.UTF_8)), ResourceType.DRL);
//			//如果是drools文件，这里需要使用ResourceType.DRL
//
//			if (kb.hasErrors()) {
//				String errorMessage = kb.getErrors().toString();
//				System.out.println("规则语法异常---\n" + errorMessage);
//				return;
//			}
//			InternalKnowledgeBase kBase = KnowledgeBaseFactory.newKnowledgeBase();
//			kBase.addPackages(kb.getKnowledgePackages());
//
//			StudentVO student = new StudentVO();
//			student.setAge(20);
//			student.setWeight(200);
//			//加载指定知识库对应的可执行session实例
//			StatelessKieSession kieSession = kBase.newStatelessKieSession();
//			//加载入参
//			kieSession.execute(student);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}

	@Test
	public void testKie() {
		StudentVO student = new StudentVO();
		student.setScore(44F);
		System.out.println(matchRule("global.drl", student));
	}

	private <T> T matchRule(String ruleFile, T object) {
		KieSession kieSession = kieTemplate.getKieSession(ruleFile);
		List<String> list = new ArrayList<>();
		kieSession.setGlobal("list", list);
		kieSession.insert(object);
		kieSession.fireAllRules();
		kieSession.dispose();
		return object;
	}
}
