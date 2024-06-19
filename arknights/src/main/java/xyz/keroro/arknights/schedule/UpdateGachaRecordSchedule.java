package xyz.keroro.arknights.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import xyz.keroro.arknights.dao.po.ArkAccount;
import xyz.keroro.arknights.service.ArkAccountService;
import xyz.keroro.arknights.service.ArkGachaService;

import java.util.List;

/**
 * 定时刷新每个账号的抽卡记录
 * @author wangpeng
 * @since 2024年01月03日 20:26
 */
@Component
public class UpdateGachaRecordSchedule {

    Logger logger = LoggerFactory.getLogger(UpdateGachaRecordSchedule.class);

    private final ArkAccountService arkAccountService;

    private final ArkGachaService arkGachaService;

    public UpdateGachaRecordSchedule(ArkAccountService arkAccountService, ArkGachaService arkGachaService) {
        this.arkAccountService = arkAccountService;
        this.arkGachaService = arkGachaService;
    }

    /**
     * 定时刷新每个账号的抽卡记录，每天执行一次
     */
    @Scheduled(cron = "0 0 0 * * ? ")
    public void updateAllAccountGachaRecord() {
        logger.info("开始任务：刷新抽卡记录");

        List<ArkAccount> accountList = arkAccountService.arkAccountList();
        logger.info("查询到" + accountList.size() + "个账号");

        for (ArkAccount arkAccount: accountList) {
            String accountStr = arkAccount.getArkAccount();
            if (accountStr != null) {
                int count = arkGachaService.updateGacha(accountStr, 1);
                logger.info("账号：" + accountStr + "更新成功，新增了" + count + "条记录");
            }
        }
        logger.info("结束任务：刷新抽卡记录");
    }
}
