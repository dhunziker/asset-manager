package uk.co.hunziker.am.shell.custom;

import org.springframework.shell.plugin.HistoryFileNameProvider;
import org.springframework.stereotype.Component;

@Component
public class CustomHistoryFileNameProvider implements HistoryFileNameProvider {

	@Override
	public String name() {
		return "custom history provider";
	}

	@Override
	public String getHistoryFileName() {
		return "am-shell.log";
	}

}
