name := "captifytesttask"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "4.5.1" % "test")

scalacOptions in Test ++= Seq("-Yrangepos")