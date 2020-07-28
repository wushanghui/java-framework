package top.wushanghui.condition;

/**
 * @author wsh
 * @date 2020-07-28 22:27
 */
public class WindowsCmd implements ShowCmd {

    public String showCmd() {
        return "dir";
    }
}
