package uk.co.hunziker.am.shell.custom;

import org.springframework.shell.plugin.PromptProvider;
import org.springframework.stereotype.Component;

@Component
public class CustomPromptProvider implements PromptProvider {

	@Override
	public String name() {
		return "custom prompt provider";
	}

	@Override
	public String getPrompt() {
		return "$ ";
	}

}
