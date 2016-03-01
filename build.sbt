lazy val soap = ( project in file( "." ) )
    .settings( Settings.common ++ Settings.noPublish: _* )
    .aggregate( core )

lazy val core = project
    .settings( androidBuildAar ++ Settings.common ++ Settings.android: _* )
    .settings(
        fork in Test := true,
        libraryDependencies ++=
            "org.typelevel" %% "cats-core" % "0.4.1" ::
            "org.typelevel" %% "cats-macros" % "0.4.1" ::
            "com.chuusai" %% "shapeless" % "2.3.0" ::
            "org.julienrf" %% "enum" % "2.2" ::
            "com.geteit" %% "robotest" % "0.12" % "test" ::
            "org.scalatest" %% "scalatest" % "2.2.6" % "test" ::
            Nil,
        name := "Soap",
        minSdkVersion := "4",
        testOptions in Test += Tests.Argument( "-oDF" )
)