package org.example;

import com.sun.tools.attach.VirtualMachine;
import org.example.pojo.DummyPojo;
import org.example.pojo.SmartPojo;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class Main {
    private static final String AGENT_PATH =
            "/home/dmitry/.m2/repository/org/aspectj/aspectjweaver/1.9.22/aspectjweaver-1.9.22.jar";

    public static void main(String[] args) throws Exception {
        loadAspectJAgent(getPid());
        new DummyPojo().dummyMethod();
        new SmartPojo().smartMethod();
    }

    private static String getPid() {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        var nameOfRunningVM = runtimeMXBean.getName();
        var pidIdx = nameOfRunningVM.indexOf('@');
        return nameOfRunningVM.substring(0, pidIdx);
    }

    public static void loadAspectJAgent(String pid)
            throws Exception {
        VirtualMachine vm = VirtualMachine.attach(pid);
        vm.loadAgent(AGENT_PATH);
        vm.detach();
    }

}