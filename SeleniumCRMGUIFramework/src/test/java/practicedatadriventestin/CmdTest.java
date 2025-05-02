package practicedatadriventestin;

import org.testng.annotations.Test;

public class CmdTest {
@Test
public void cmds() {
	String url= System.getProperty("url");
	System.out.println("Env data==>"+url);
}
}
