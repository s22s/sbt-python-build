lazy val root = (project in file("."))
  .enablePlugins(SbtPlugin)
  .settings(
      name := "sbt-python-build",
      organization := "io.astraea",
        scriptedLaunchOpts := {
           scriptedLaunchOpts.value ++
             Seq("-Xmx1024M", "-Dplugin.version=" + version.value)
        },
    scriptedBufferLog := false,
    publishMavenStyle := true,
    publishArtifact in Test := false,
    addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.10")
  )