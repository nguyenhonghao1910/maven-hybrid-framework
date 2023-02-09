package environmentConfig;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"classpath:${env}.properties"})
public interface Environment extends Config {
	String url();
	
	@Key("db.url")
	String getDBHostname();
	
	@Key("db.username")
	String getDBUsername();
	
	@Key("db.password")
	String getDBPassword();
	

}
