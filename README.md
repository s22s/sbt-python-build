# sbt-python-build Plugin

This is an [sbt](https://www.scala-sbt.org/) plugin providing tasks for running Python [setuptools](https://pypi.org/project/setuptools/) `setup.py` file. 

## Usage

Until this plugin is released, include the following in your `project/plugins.sbt` file:

    lazy val root = (project in file(".")).dependsOn(PythonBuildPlugin)
    lazy val PythonBuildPlugin = ProjectRef(uri("https://github.com/s22s/sbt-python-build.git"), "root")

Enable the plugin in your `build.sbt` file with `enablePlugins(PythonBuildPlugin)`.

## Project Layout

By default, the plugin assumes your python project resides in `src/main/python` and includes a `setup.py` file in that directory. If this isn't to your liking, you can define a new source location with the `Python / sourceDirectory` setting.

## sbt Config and Keys

It defines the following configuration elements:

* `Python` settings config instance
* `pySetup` input task for forking a `python setup.py <args>` subprocess
* `pyWhl` builds a pip `.whl` (forks  `python pySetup build bdist_wheel`) and registers it as an artifact. 
* `pythonCommand` setting for path to python interpreter. Defaults to "python".

The plugin also provides a Python `unittest` output parser to propagate Python test results to sbt for overall `test` task success/failure determination.




