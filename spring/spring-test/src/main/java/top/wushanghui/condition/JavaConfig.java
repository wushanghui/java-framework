package top.wushanghui.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author wsh
 * @date 2020-07-28 22:30
 */
@Configuration
public class JavaConfig {

    @Bean("showCmd")
    @Conditional(WindowsCondition.class)
    public ShowCmd windowsCmd() {
        return new WindowsCmd();
    }

    @Bean("showCmd")
    @Conditional(LinuxCondition.class)
    public ShowCmd linuxCmd() {
        return new LinuxCmd();
    }

    @Bean("showCmd")
    @Conditional(MacCondition.class)
    public ShowCmd macCmd() {
        return new MacCmd();
    }
}
