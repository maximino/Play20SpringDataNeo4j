import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "playtest"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    javaCore,
    javaJdbc,
    javaEbean,
    "asm"    %    "asm"    %    "3.3.1",
    "org.springframework" % "spring-context" % "3.2.1.RELEASE",
    "org.neo4j" % "neo4j" % "1.9.M04",  
	"org.springframework.data"    %    "spring-data-neo4j"      %    "2.3.0.BUILD-SNAPSHOT"
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
  	  resolvers += "Spring releases" at "http://maven.springframework.org/release",
      resolvers += "Spring Data snapshot" at "http://repo.springsource.org/snapshot/",
	  resolvers += "Neo4j" at "http://m2.neo4j.org/content/repositories/releases/" 
  )

}
