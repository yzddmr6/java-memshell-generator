package jmg.antsword.util;

import jmg.antsword.memshell.AntSwordFilter;
import jmg.antsword.memshell.AntSwordListener;
import jmg.core.config.Constants;

import java.util.HashMap;
import java.util.Map;

public class ShellUtil {

    private static final Map<String, String> SHELL_CLASSNAME_MAP = new HashMap();
    private static final Map<String, Map<String, String>> toolMap = new HashMap();

    public ShellUtil() {
    }

    public static String getShellName(String toolType, String shellType) {
        Map<String, String> shellMap = toolMap.get(toolType);
        return shellMap == null ? "" : shellMap.getOrDefault(shellType, "");
    }

    public static String getShellClassName(String shellName) throws Exception {
        if (SHELL_CLASSNAME_MAP.get(shellName) == null) {
            throw new Exception("Invalid shell type '" + shellName + "'");
        } else {
            return SHELL_CLASSNAME_MAP.getOrDefault(shellName, "");
        }
    }

    static {
        SHELL_CLASSNAME_MAP.put(AntSwordListener.class.getSimpleName(), AntSwordListener.class.getName());
        SHELL_CLASSNAME_MAP.put(AntSwordFilter.class.getSimpleName(), AntSwordFilter.class.getName());
        Map<String, String> antSwordMap = new HashMap();
        antSwordMap.put(Constants.SHELL_FILTER,AntSwordFilter.class.getSimpleName());
        antSwordMap.put(Constants.SHELL_LISTENER, AntSwordListener.class.getSimpleName());
        toolMap.put(Constants.TOOL_ANTSWORD, antSwordMap);
    }


}
