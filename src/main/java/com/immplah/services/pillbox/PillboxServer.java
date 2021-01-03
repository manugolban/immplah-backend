package com.immplah.services.pillbox;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImplExporter;
import com.googlecode.jsonrpc4j.spring.JsonServiceExporter;
import com.immplah.services.MedicationPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.remoting.support.RemoteExporter;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
public class PillboxServer {

    @Bean(name = "/pillbox")
    public static AutoJsonRpcServiceImplExporter autoJsonRpcServiceImplExporter() {
        AutoJsonRpcServiceImplExporter exporter = new AutoJsonRpcServiceImplExporter();
        return exporter;
    }

}
