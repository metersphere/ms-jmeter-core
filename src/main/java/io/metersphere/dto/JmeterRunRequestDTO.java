package io.metersphere.dto;

import io.metersphere.constants.RunModeConstants;
import io.metersphere.vo.BooleanPool;
import lombok.Data;
import org.apache.jorphan.collections.HashTree;

import java.util.Map;

@Data
public class JmeterRunRequestDTO {

    private String runMode;

    // RunModeConstants.SET_REPORT : RunModeConstants.INDEPENDENCE
    private String reportType;

    private String reportId;

    private String testPlanReportId;

    // 资源id：/场景id/用例id/接口id/测试计划场景id/测试计划用例id
    private String testId;

    // 是否发送node节点执行
    private BooleanPool pool;

    private RunModeConfigDTO config;

    private HashTree hashTree;

    private boolean isDebug;

    // 只用在node节点中会用到
    private Map<String, Object> kafkaConfig;
    // 只用在node节点中会用到
    private String platformUrl;

    public JmeterRunRequestDTO() {
    }
    public JmeterRunRequestDTO(String testId, String reportId, String runMode, HashTree hashTree) {
        this.testId = testId;
        this.reportId = reportId;
        this.runMode = runMode;
        this.hashTree = hashTree;
        this.reportType = RunModeConstants.INDEPENDENCE.name();
        this.pool = new BooleanPool();
    }
}