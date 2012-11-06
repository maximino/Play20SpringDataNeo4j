import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "Play20SpringDataNeo4j"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(     
	   "asm"    %    "asm"    %    "3.3.1",  
	   "org.springframework.data"    %    "spring-data-neo4j"      %    "2.1.0.RC4"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
      resolvers += "Spring Data" at "http://repo.springsource.org/libs-milestone/",
	  resolvers += "Neo4j" at "http://m2.neo4j.org/content/repositories/releases/" 
    )

}
