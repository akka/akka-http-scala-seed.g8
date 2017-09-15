lazy val akkaHttpVersion = "$akka_http_version$"
lazy val akkaVersion    = "$akka_version$"

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization    := "$organization$",
      scalaVersion    := "$scala_version$"
    )),
    name := "$name$",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http"            % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-http-xml"        % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-stream"          % akkaVersion,

      "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % Test,
      "org.scalatest"     %% "scalatest"         % "3.0.1"         % Test
    )
  )

mainClass in Compile := Some("example.QuickstartServer")

dockerBaseImage := "openjdk:8-jre-alpine"

enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)
enablePlugins(AshScriptPlugin)