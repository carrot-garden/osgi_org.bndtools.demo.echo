Bndtools Echo OSGi Demo
=======================

The project contains a simple OSGi bndtools demo project. 
To show the basic features of bndtools in a running example.

Demo Projects
--------------

The demo contains following projects:

1. cnf - configuration project contains two local OSGi bundle repositories and the parent ant config.
2. org.bndtools.demo.echo - The project contains the source for three bundles a echo API, swing and client bundle.
3. org.bndtools.demo.echo.test - Project contains a bnd based OSGi integrated test for the echo service.

GIT Branches
------------

The project contains two branches

1. Master - Contains the demo code with plain OSGi service handling.
2. OSGiDeclarativeServices - Contains the same demo with DS service handling.