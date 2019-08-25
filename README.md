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

## Build Tasks

The standard `test` and `package` sbt tasks are used to run the unit tests and create the build distribution, respectively. Additionally, for the purposes of build debugging and other build hackery, you can run the `pySetup` input task with arguments that are passed on to `setup.py`. For example, to run the `test` command with specific arguments:

```
sbt> pySetup test --addopts "-k test_foobar"
```

## Internals.

Before a build is initiated, the Python sources are copied to `target/python`. This ensures the version controlled source directories are not polluted by `setuptools` residuals, better ensuring repeatable builds. **Do not edit files in `target/python`**, as they will get overwritten. To simplify the process of working with `setup.py` in this context, the `pySetup` is made available, as described above.