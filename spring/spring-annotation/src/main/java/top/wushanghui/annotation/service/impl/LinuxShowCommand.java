package top.wushanghui.annotation.service.impl;

import top.wushanghui.annotation.service.ShowCommand;

/**
 * @author jue
 * @date 2021/4/10 17:30
 * @describe
 */
public class LinuxShowCommand implements ShowCommand {

    @Override
    public String showCommandInfo() {
        return "ls";
    }
}
