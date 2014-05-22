name := "couchbase-java-starter"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  cache,
  "org.reactivecouchbase" %% "reactivecouchbase-play" % "0.2"
)

resolvers += "ReactiveCouchbase" at "https://raw.github.com/ReactiveCouchbase/repository/master/snapshots"

play.Project.playJavaSettings
