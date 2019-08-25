# sbt-python-build Plugin

This is an [sbt](https://www.scala-sbt.org/) plugin providing tasks for running Python [setuptools](https://pypi.org/project/setuptools/) `setup.py` file. It defines the following elements:

* `Python` settings config instance
* `pySetup` input task for forking a `python setup.py <args>` subprocess
* `pyWhl` builds a pip `.whl` file via `pySetup build bdist_wheel`
* `pythonCommand` setting for path to python interpreter. Defaults to "python".

The plugin also provides a Python `unittest` output parser to propagate Python test results to sbt for success/failure determination.

