# www-4clojure

Solutions for the problems listed in [4clojure](http://www.4clojure.com/).

[![Build Status](https://travis-ci.org/carvil/www-4clojure.png)](https://travis-ci.org/carvil/www-4clojure)

## Usage

In order to try the different functions, load the repl:

    lein repl

And then use the namespace:

    user=> (use 'www-4clojure.core)
    nil

You can now use the functions defined in `www-4clojure.core` namespace.

## Test

In order to test, run:

    lein midje

Or:

    lein midje --lazytest

In development mode to run the tests after saving the files.

## License

Copyright © 2012 FIXME

Distributed under the Eclipse Public License, the same as Clojure.
