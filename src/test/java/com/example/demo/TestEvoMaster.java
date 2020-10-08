package com.example.demo;

import java.sql.Connection;
import java.util.List;

import org.evomaster.client.java.controller.EmbeddedSutController;
import org.evomaster.client.java.controller.InstrumentedSutStarter;
import org.evomaster.client.java.controller.api.dto.AuthenticationDto;
import org.evomaster.client.java.controller.api.dto.SutInfoDto.OutputFormat;
import org.evomaster.client.java.controller.internal.SutController;
import org.evomaster.client.java.controller.problem.ProblemInfo;
import org.evomaster.client.java.controller.problem.RestProblem;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class TestEvoMaster extends EmbeddedSutController {

	public static void main(String[] args) {

        SutController controller = new TestEvoMaster();
        InstrumentedSutStarter starter = new InstrumentedSutStarter(controller);

        starter.start();
    }

    private ConfigurableApplicationContext ctx;
    private Connection connection;
	
	@Override
	public String startSut() {
		// ctx = SpringApplication.run(DemoApplication.class, new String[] { "--server.port=0" });
		ctx = SpringApplication.run(DemoApplication.class, new String[] { });
		return "http://localhost:8080";
	}

	@Override
	public void stopSut() {
		ctx.stop();
	}

	@Override
	public void resetStateOfSUT() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isSutRunning() {
		return ctx != null && ctx.isRunning();
	}

	@Override
	public String getPackagePrefixesToCover() {
		return "com.example.demo";
	}

	@Override
	public List<AuthenticationDto> getInfoForAuthentication() {
		return null;
	}

	@Override
	public Connection getConnection() {
		return null;
	}

	@Override
	public String getDatabaseDriverName() {
		return null;
	}

	@Override
	public ProblemInfo getProblemInfo() {
		return new RestProblem("http://localhost:8080/v3/api-docs", null);
	}

	@Override
	public OutputFormat getPreferredOutputFormat() {
		return OutputFormat.JAVA_JUNIT_5;
	}

}
