/* by sln:
 * this folder structure /src/main/java is Maven's convention
 * if you follow that convention you don't need to configure anything and Maven will compile any class in that folder
 * /src/test/java is for Unit testing
 * 
 * Goals:
 * go to HelloWorld folder (because you need to run mvn.exe from where the pom.xml file is) 
 * mvn clean 	- deletes target folder and any generated resources
 * mvn compile	- everything is compiled into target/ folder 
 * mvn package	- runs compile first, runs any test, packages the app based off of its packaging type
 * mvn install 	- runs package command and then installs it in your local repo (like C:\Documents and Settings\Administrator\.m2\repository\com\sln\HelloWorld)
 * mvn deploy	- runs the install command and then deploys it to a corporate depo (don't confuse with deploying to web server)
 * you can chain it like: mvn clean package ...
 * 
 * How to override defaults:
 * if you place this into pom.xml and run "mvn clean package" it will produce foo.jar (instead of HelloWorld-1.0-SNAPSHOT.jar)
 * <build>
 * 	<finalName>foo</finalName>
 * </build>  
 * 
 * When you name your version ending with -SNAPSHOT in pom.xml and upload it to repo, Maven will watch for any
 * changes in that version and will re-download it. It has to be in CAPITAL LETTERS: SNAPSHOT
 * So never deploy to production with a SNAPSHOT. It's usually used when you're developing and testing.
 * All other namings of version are arbitrary (only SNAPSHOT has special meaning for Maven).
 * 		Check video "3.Maven Dependencies\3.Versions.wmv" for conventions (like RELEASE, Final, RC1, ...)
 * 
 * 6 scopes available for dependencies in pom.xml (see video "3.Maven Dependencies\3.Scopes.wmv"):
 * compile - default, artifact will be available everywhere
 * provided - like compile, means artifact will be provided where it is deployed.
 * 				It will available everywhere but not included in final artifact (.jar/.war/...)
 * runtime - means artifact is not needed for compilation, but needed for execution (like dynamicly loaded JDBC driver)
 * 				Not included in final artifact 
 * test - only available for test compilation and execution phase (for example, can be used for junit dependency)
 * 				Not included in final artifact 
 * system - you specify hard coded path on your file system. Do not use this, defeats the purpose of Maven
 * import - advanced topic
 * 
 * Repositories:
 * Everything Maven downloads it stores in local repo: 
 * 		On Win7: C:\Users\<yourname>\.m2\repository
 * 		On XP: C:\Documents and Settings\<yourname>\.m2\repository
 * 		so if you have many project which require same .jar files, this way you don't have to copy em into every project
 * By default Maven looks for artifacts in http://repo.maven.apache.org/maven2
 * If you want to add your own repository you do that with <repositories>...</repositories> in pom.xml
 * 		<snapshots><enabled>false</enabled></snapshots> - means "don't pull snapshots from this repository"
 * 		See "4. Maven Repositories" module
 * 
 * Plugins: see <plugins> section in this project's pom.xml
 * Goals are really just configured plugins
 * Everything is configured in Super pom.xml, it is added to your pom.xml where you can add or override
 * 
 * Eclipse/STS integration:
 * - you download STS from http://www.springsource.org/downloads/sts-ggts
 * - To import existing Maven project into IDE you right-click in Project Explorer -> Import -> Maven -> Existing Maven Projects
 * 		all source files and dependencies will be added to classpath by IDE
 * - You can convert any your regular java project into Maven project
 * 		create pom.xml file
 * 		right-click on your project -> Configure -> Convert to Maven Project
 * 			(small letter M in project's icon indicates it's a Maven project now)  
 */

public class HelloWorld {
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}
}
