package uk.co.hunziker.am.shell.custom;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.springframework.shell.plugin.BannerProvider;
import org.springframework.shell.support.util.FileUtils;
import org.springframework.shell.support.util.OsUtils;
import org.springframework.stereotype.Component;

@Component
public class CustomBannerProvider implements BannerProvider {

	@Override
	public String name() {
		return "Asset Manager";
	}

	@Override
	public String getBanner() {
		StringBuilder sb = new StringBuilder();
		InputStream is = getClass().getResourceAsStream("/banner.txt");
		Reader reader = new InputStreamReader(is);
		sb.append(FileUtils.readBanner(reader));
		sb.append(getVersion()).append(OsUtils.LINE_SEPARATOR);
		sb.append(OsUtils.LINE_SEPARATOR);
		return sb.toString();
	}

	@Override
	public String getVersion() {
		Package pkg = getClass().getPackage();
		String version = null;
		if (pkg != null) {
			version = pkg.getImplementationVersion();
		}
		return (version != null ? version : "Unknown Version");
	}

	@Override
	public String getWelcomeMessage() {
		return String.format("Welcome to %s. For assistance type \"help\" then hit ENTER.", name());
	}

}
